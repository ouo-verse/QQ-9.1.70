package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.luggage.wxa.ff.c;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterError;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
import com.tencent.qqmini.sdk.widget.media.danmu.Barrage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class MiniAppLivePlayer extends FrameLayout implements View.OnClickListener {
    private static final String ON_LIVE_PLAYER_EVENT = "onLivePlayerEvent";
    private static final String ON_LIVE_PLAYER_FULLSCREENCHANGE = "onLivePlayerFullScreenChange";
    private static final String ON_LIVE_PLAYER_META_DATA = "onLivePlayerMetadata";
    private static final String ON_LIVE_PLAYER_NETSTATUS = "onLivePlayerNetStatus";
    private static final String ON_LIVE_PLAYER_ON_AUDIO_VOLUME_NOTIFY = "onLivePlayerAudioVolumeNotify";
    private static final String TAG = "MiniAppLivePlayer";
    public static final String VIEW_TAG = "MiniAppLivePlayer";
    public WeakReference<Activity> atyRef;
    public List<Barrage> barrages;
    public BaseRuntime baseRuntime;
    private int componentLayoutScrollY;
    public boolean customCache;
    public String data;
    public int direction;
    public boolean enableDanmu;
    public boolean enablePlayGesture;
    public boolean enableProgressGesture;
    private final Handler handler;
    private boolean hasSetUp;
    public boolean hide;
    public int initialTime;
    boolean isBusyInChangeScreen;
    public boolean isFullScreen;
    private int lastNavBarVisibility;
    long lastSmallScreenTime;
    private int lastTabBarVisibility;
    public long livePlayerId;
    private TXLivePlayerJSAdapter livePlayerJsAdapter;
    public boolean loop;
    private Context mContext;
    public WeakReference<IMiniAppContext> miniAppContextRef;
    public boolean muted;
    public boolean needEvent;
    public int parentId;
    public String playBtnPosition;
    private ImageView playStatusImg;
    public String poster;
    public boolean showCenterPlayBtn;
    public boolean showControlProgress;
    public boolean showDanmuBtn;
    public boolean showFullScreenBtn;
    public boolean showMuteBtn;
    public boolean showPlayBtn;
    public boolean showProgress;
    private ViewGroup.LayoutParams smallLayoutParams;
    private Object tXCloudVideoView;
    public String title;
    private View vdView;
    private VideoGestureRelativeLayout videoContainer;
    private FrameLayout videoPopContainer;
    private View view;
    public int webviewId;

    public MiniAppLivePlayer(@NonNull Context context) {
        this(context, null);
        setUpView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackFullScreenChange() {
        IMiniAppContext iMiniAppContext;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("livePlayerId", this.livePlayerId);
            jSONObject.put("direction", "");
            jSONObject.put("fullScreen", this.isFullScreen);
            WeakReference<IMiniAppContext> weakReference = this.miniAppContextRef;
            if (weakReference != null) {
                iMiniAppContext = weakReference.get();
            } else {
                iMiniAppContext = null;
            }
            if (iMiniAppContext != null) {
                iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(ON_LIVE_PLAYER_FULLSCREENCHANGE, jSONObject.toString(), this.webviewId));
            }
            this.baseRuntime.getJsService().evaluateSubscribeJS(ON_LIVE_PLAYER_FULLSCREENCHANGE, jSONObject.toString(), this.webviewId);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void cancelAvoidLockScreen() {
        WeakReference<Activity> weakReference = this.atyRef;
        if (weakReference != null && weakReference.get() != null) {
            this.atyRef.get().getWindow().clearFlags(128);
            this.atyRef.get().getWindow().addFlags(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterFullScreenMode(Activity activity) {
        activity.getWindow().getDecorView().getSystemUiVisibility();
        activity.getWindow().getDecorView().setSystemUiVisibility(5894 | 2048);
    }

    private void initPlayerView() {
        Object creatSpecifiedObject = JarReflectUtil.creatSpecifiedObject(IWXLivePusherProxy.CLASS_NAME_TX_CLOUD_VIDEO_VIEW, JarReflectUtil.getParamsClass(Context.class), getContext());
        this.tXCloudVideoView = creatSpecifiedObject;
        if (creatSpecifiedObject == null) {
            QMLog.e("MiniAppLivePlayer", "tXCloudVideoView is null?! ");
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = (View) this.tXCloudVideoView;
        this.vdView = view;
        view.setLayoutParams(layoutParams);
        this.vdView.setVisibility(0);
        this.videoPopContainer.setVisibility(0);
        this.videoContainer.removeAllViews();
        this.videoContainer.addView(this.vdView);
        this.videoContainer.setBackgroundColor(-16777216);
        this.videoContainer.setEnablePageGesture(false);
        this.videoContainer.setEnablePlayGesture(false);
        this.videoContainer.setEnableProgressGesture(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayEvent(int i3, Bundle bundle, RequestEvent requestEvent) {
        IMiniAppContext iMiniAppContext = null;
        if (2028 == i3) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("livePlayerId", this.livePlayerId);
                jSONObject.put("errCode", i3);
                Object obj = bundle.get("EVT_GET_METADATA");
                if (obj instanceof HashMap) {
                    jSONObject.put("errMsg", new JSONObject((HashMap) obj));
                }
                WeakReference<IMiniAppContext> weakReference = this.miniAppContextRef;
                if (weakReference != null) {
                    iMiniAppContext = weakReference.get();
                }
                if (iMiniAppContext != null) {
                    iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(ON_LIVE_PLAYER_META_DATA, jSONObject.toString(), this.webviewId));
                }
                requestEvent.jsService.evaluateSubscribeJS(ON_LIVE_PLAYER_META_DATA, jSONObject.toString(), this.webviewId);
                QMLog.e("MiniAppLivePlayer", "operate start evaluateSubcribeJS onLivePlayerMetadata = " + jSONObject.toString());
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("livePlayerId", this.livePlayerId);
            jSONObject2.put("errCode", i3);
            jSONObject2.put("errMsg", bundle.get("EVT_MSG"));
            WeakReference<IMiniAppContext> weakReference2 = this.miniAppContextRef;
            if (weakReference2 != null) {
                iMiniAppContext = weakReference2.get();
            }
            if (iMiniAppContext != null) {
                iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(ON_LIVE_PLAYER_EVENT, jSONObject2.toString(), this.webviewId));
            }
            requestEvent.jsService.evaluateSubscribeJS(ON_LIVE_PLAYER_EVENT, jSONObject2.toString(), this.webviewId);
            QMLog.e("MiniAppLivePlayer", "operate start evaluateSubcribeJS onLivePlayerEvent = " + jSONObject2.toString());
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveJpeg(Bitmap bitmap, File file) throws IOException {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, Math.min(100, 100), bufferedOutputStream2);
                bufferedOutputStream2.flush();
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestedOrientation(Activity activity) {
        int i3 = this.direction;
        if (i3 != -90 && i3 != 270) {
            if (i3 == 0) {
                activity.setRequestedOrientation(1);
                return;
            } else if (i3 != 180 && i3 != -180) {
                activity.setRequestedOrientation(0);
                return;
            } else {
                activity.setRequestedOrientation(9);
                return;
            }
        }
        activity.setRequestedOrientation(8);
    }

    private void setUpView(Context context) {
        if (this.hasSetUp) {
            return;
        }
        this.hasSetUp = true;
        setTag("MiniAppLivePlayer");
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_player_view, (ViewGroup) null);
        this.view = inflate;
        VideoGestureRelativeLayout videoGestureRelativeLayout = (VideoGestureRelativeLayout) inflate.findViewById(R.id.layout_videolayout);
        this.videoContainer = videoGestureRelativeLayout;
        videoGestureRelativeLayout.setContentDescription("videoContainer");
        this.videoPopContainer = (FrameLayout) this.view.findViewById(R.id.video_pop_container);
        ImageView imageView = (ImageView) this.view.findViewById(R.id.play_status_img);
        this.playStatusImg = imageView;
        imageView.setVisibility(8);
        this.videoContainer.setOnClickListener(this);
        addView(this.view);
    }

    public void changeState() {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.3
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public void doSmallScreen(Activity activity, AppBrandPageContainer appBrandPageContainer) {
        AppBrandPage showingPage = appBrandPageContainer.getShowingPage();
        if (showingPage != null) {
            if (showingPage.getNavBar() != null) {
                showingPage.getNavBar().setVisibility(this.lastNavBarVisibility);
            }
            if (showingPage.getTabBar() != null) {
                showingPage.getTabBar().setVisibility(this.lastTabBarVisibility);
            }
        }
        activity.getWindow().clearFlags(1024);
        activity.setRequestedOrientation(1);
        activity.getWindow().getDecorView().setSystemUiVisibility(1024);
        if (showingPage != null) {
            try {
                int statusNavigationBarTextStyle = showingPage.getNavBar().getStatusNavigationBarTextStyle();
                if (statusNavigationBarTextStyle == -1) {
                    ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
                } else if (statusNavigationBarTextStyle == -16777216) {
                    ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
                }
            } catch (Exception e16) {
                QMLog.e("MiniAppLivePlayer", "smallScreen: ", e16);
            }
        }
        this.lastSmallScreenTime = System.currentTimeMillis();
        this.isBusyInChangeScreen = true;
        this.handler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.6
            @Override // java.lang.Runnable
            public void run() {
                ((CoverLiveView) MiniAppLivePlayer.this.getParent()).setLayoutParams(MiniAppLivePlayer.this.smallLayoutParams);
                if (MiniAppLivePlayer.this.getParent().getParent() != null) {
                    ((ViewGroup) MiniAppLivePlayer.this.getParent().getParent()).scrollTo(0, MiniAppLivePlayer.this.componentLayoutScrollY);
                }
                MiniAppLivePlayer.this.isBusyInChangeScreen = false;
            }
        }, 200L);
    }

    public boolean enterBackground() {
        TXJSAdapterError enterBackground = this.livePlayerJsAdapter.enterBackground(2);
        if (QMLog.isColorLevel()) {
            QMLog.d("MiniAppLivePlayer", "enterBackground: " + enterBackground);
        }
        if (enterBackground.errorCode == 0) {
            return true;
        }
        return false;
    }

    public boolean enterForeground() {
        TXJSAdapterError enterForeground = this.livePlayerJsAdapter.enterForeground();
        if (QMLog.isColorLevel()) {
            QMLog.d("MiniAppLivePlayer", "enterForeground: " + enterForeground);
        }
        if (enterForeground.errorCode == 0) {
            return true;
        }
        return false;
    }

    public void fullScreen() {
        this.handler.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.4
            @Override // java.lang.Runnable
            public void run() {
                WeakReference<Activity> weakReference;
                Activity activity;
                MiniAppLivePlayer miniAppLivePlayer = MiniAppLivePlayer.this;
                if (!miniAppLivePlayer.isBusyInChangeScreen && (weakReference = miniAppLivePlayer.atyRef) != null && (activity = weakReference.get()) != null && (MiniAppLivePlayer.this.getParent() instanceof CoverLiveView)) {
                    MiniAppLivePlayer miniAppLivePlayer2 = MiniAppLivePlayer.this;
                    miniAppLivePlayer2.isFullScreen = true;
                    IPage page = miniAppLivePlayer2.baseRuntime.getPage();
                    if (!(page instanceof AppBrandPageContainer)) {
                        QMLog.d("MiniAppLivePlayer", "Page is invalid");
                        return;
                    }
                    AppBrandPage showingPage = ((AppBrandPageContainer) page).getShowingPage();
                    if (showingPage != null) {
                        MiniAppLivePlayer.this.lastNavBarVisibility = showingPage.getNavBar().getVisibility();
                        showingPage.getNavBar().setVisibility(8);
                        MiniAppLivePlayer.this.lastTabBarVisibility = showingPage.getTabBar().getVisibility();
                        showingPage.getTabBar().setVisibility(8);
                    }
                    MiniAppLivePlayer miniAppLivePlayer3 = MiniAppLivePlayer.this;
                    miniAppLivePlayer3.smallLayoutParams = ((CoverLiveView) miniAppLivePlayer3.getParent()).getLayoutParams();
                    if (MiniAppLivePlayer.this.getParent().getParent() != null) {
                        MiniAppLivePlayer miniAppLivePlayer4 = MiniAppLivePlayer.this;
                        miniAppLivePlayer4.componentLayoutScrollY = ((ViewGroup) miniAppLivePlayer4.getParent().getParent()).getScrollY();
                        ((ViewGroup) MiniAppLivePlayer.this.getParent().getParent()).scrollTo(0, 0);
                    }
                    if (showingPage == null) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.getRealHeight(MiniAppLivePlayer.this.getContext()), ImmersiveUtils.getScreenWidth());
                        layoutParams.leftMargin = 0;
                        layoutParams.topMargin = 0;
                        ((CoverLiveView) MiniAppLivePlayer.this.getParent()).setLayoutParams(layoutParams);
                    } else {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DisplayUtil.getRealHeight(MiniAppLivePlayer.this.getContext()), ImmersiveUtils.getScreenWidth());
                        layoutParams2.leftMargin = 0;
                        layoutParams2.topMargin = 0;
                        ((CoverLiveView) MiniAppLivePlayer.this.getParent()).setLayoutParams(layoutParams2);
                    }
                    activity.getWindow().getDecorView().setSystemUiVisibility(2);
                    MiniAppLivePlayer.this.setRequestedOrientation(activity);
                    MiniAppLivePlayer.this.enterFullScreenMode(activity);
                    MiniAppLivePlayer.this.callBackFullScreenChange();
                }
            }
        });
    }

    public void initLivePlayerSettings(final RequestEvent requestEvent, JSONObject jSONObject) {
        if (QMLog.isColorLevel()) {
            QMLog.d("MiniAppLivePlayer", "initLivePlayerSettings isFullScreen: " + this.isFullScreen);
        }
        initPlayerView();
        TXLivePlayerJSAdapter tXLivePlayerJSAdapter = new TXLivePlayerJSAdapter(getContext());
        this.livePlayerJsAdapter = tXLivePlayerJSAdapter;
        tXLivePlayerJSAdapter.initLivePlayer(this.tXCloudVideoView, jSONObject);
        this.livePlayerJsAdapter.setPlayListener(new TXLivePlayerJSAdapter.IPlayOuterListener() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.1
            @Override // com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener
            public void onNetStatus(Bundle bundle) {
                IMiniAppContext iMiniAppContext;
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("VIDEO_BITRATE", bundle.get("VIDEO_BITRATE"));
                    jSONObject3.put("AUDIO_BITRATE", bundle.get("AUDIO_BITRATE"));
                    jSONObject3.put("VIDEO_FPS", bundle.get("VIDEO_FPS"));
                    jSONObject3.put("VIDEO_GOP", bundle.get("VIDEO_GOP"));
                    jSONObject3.put("NET_SPEED", bundle.get("NET_SPEED"));
                    jSONObject3.put("NET_JITTER", bundle.get("NET_JITTER"));
                    jSONObject3.put("VIDEO_WIDTH", bundle.get("VIDEO_WIDTH"));
                    jSONObject3.put("VIDEO_HEIGHT", bundle.get("VIDEO_HEIGHT"));
                    jSONObject2.put("livePlayerId", MiniAppLivePlayer.this.livePlayerId);
                    jSONObject2.put("info", jSONObject3);
                    WeakReference<IMiniAppContext> weakReference = MiniAppLivePlayer.this.miniAppContextRef;
                    if (weakReference != null) {
                        iMiniAppContext = weakReference.get();
                    } else {
                        iMiniAppContext = null;
                    }
                    if (iMiniAppContext != null) {
                        iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MiniAppLivePlayer.ON_LIVE_PLAYER_NETSTATUS, jSONObject2.toString(), MiniAppLivePlayer.this.webviewId));
                    }
                    requestEvent.jsService.evaluateSubscribeJS(MiniAppLivePlayer.ON_LIVE_PLAYER_NETSTATUS, jSONObject2.toString(), MiniAppLivePlayer.this.webviewId);
                    QMLog.e("MiniAppLivePlayer", "operate start evaluateSubcribeJS onLivePlayerNetStatus = " + jSONObject2.toString());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }

            @Override // com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener
            public void onPlayEvent(int i3, Bundle bundle) {
                QMLog.d("MiniAppLivePlayer", "onPlayEvent code:" + i3);
                MiniAppLivePlayer.this.onPlayEvent(i3, bundle, requestEvent);
            }
        });
        this.livePlayerJsAdapter.setItxAudioVolumeEvaluationOuterListener(new TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.2
            @Override // com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener
            public void onAudioVolumeEvaluationNotify(int i3) {
                IMiniAppContext iMiniAppContext;
                QMLog.d("MiniAppLivePlayer", "onAudioVolumeEvaluationNotify code:" + i3);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("livePlayerId", MiniAppLivePlayer.this.livePlayerId);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, i3);
                    jSONObject2.put("info", jSONObject3);
                    WeakReference<IMiniAppContext> weakReference = MiniAppLivePlayer.this.miniAppContextRef;
                    if (weakReference != null) {
                        iMiniAppContext = weakReference.get();
                    } else {
                        iMiniAppContext = null;
                    }
                    if (iMiniAppContext != null) {
                        iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MiniAppLivePlayer.ON_LIVE_PLAYER_ON_AUDIO_VOLUME_NOTIFY, jSONObject2.toString(), MiniAppLivePlayer.this.webviewId));
                    }
                    requestEvent.jsService.evaluateSubscribeJS(MiniAppLivePlayer.ON_LIVE_PLAYER_ON_AUDIO_VOLUME_NOTIFY, jSONObject2.toString(), MiniAppLivePlayer.this.webviewId);
                    if (QMLog.isColorLevel()) {
                        QMLog.e("MiniAppLivePlayer", "onAudioVolumeEvaluationNotify resultObj.toString() = " + jSONObject2.toString());
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    public boolean isFullScreen() {
        return this.isFullScreen;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFullScreenSize(int i3, int i16) {
        if (i3 == DisplayUtil.getRealHeight(getContext()) && i16 == ImmersiveUtils.getScreenWidth()) {
            return true;
        }
        return false;
    }

    public boolean isPlaying() {
        TXLivePlayerJSAdapter tXLivePlayerJSAdapter = this.livePlayerJsAdapter;
        if (tXLivePlayerJSAdapter != null && tXLivePlayerJSAdapter.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isFullScreen) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void operateLivePlayer(String str, RequestEvent requestEvent, JSONObject jSONObject) {
        boolean z16;
        String optString;
        if (this.livePlayerJsAdapter == null) {
            return;
        }
        if ("requestFullScreen".equalsIgnoreCase(str)) {
            fullScreen();
            requestEvent.ok();
            return;
        }
        if ("exitFullScreen".equalsIgnoreCase(str)) {
            smallScreen();
            requestEvent.ok();
        } else {
            if ("snapshot".equalsIgnoreCase(str)) {
                if (jSONObject != null && (optString = jSONObject.optString(CustomImageProps.QUALITY)) != null && optString.equalsIgnoreCase("compressed")) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                takePhoto(c.NAME, z16, requestEvent);
                return;
            }
            this.livePlayerJsAdapter.operateLivePlayer(str, jSONObject);
            requestEvent.ok();
        }
    }

    public void release() {
        TXLivePlayerJSAdapter tXLivePlayerJSAdapter = this.livePlayerJsAdapter;
        if (tXLivePlayerJSAdapter != null) {
            tXLivePlayerJSAdapter.uninitLivePlayer();
        }
        cancelAvoidLockScreen();
        ScreenOffOnListener.getInstance().unRegistListener();
    }

    public void setAtyRef(WeakReference<Activity> weakReference) {
        this.atyRef = weakReference;
    }

    public void smallScreen() {
        this.handler.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.5
            @Override // java.lang.Runnable
            public void run() {
                WeakReference<Activity> weakReference;
                Activity activity;
                MiniAppLivePlayer miniAppLivePlayer = MiniAppLivePlayer.this;
                if (!miniAppLivePlayer.isBusyInChangeScreen && (weakReference = miniAppLivePlayer.atyRef) != null && (activity = weakReference.get()) != null && MiniAppLivePlayer.this.livePlayerJsAdapter != null && (MiniAppLivePlayer.this.getParent() instanceof CoverLiveView)) {
                    MiniAppLivePlayer miniAppLivePlayer2 = MiniAppLivePlayer.this;
                    if (!miniAppLivePlayer2.isFullScreen) {
                        return;
                    }
                    miniAppLivePlayer2.isFullScreen = false;
                    miniAppLivePlayer2.callBackFullScreenChange();
                    IPage page = MiniAppLivePlayer.this.baseRuntime.getPage();
                    if (!(page instanceof AppBrandPageContainer)) {
                        QMLog.d("MiniAppLivePlayer", "Page is invalid");
                    } else {
                        MiniAppLivePlayer.this.doSmallScreen(activity, (AppBrandPageContainer) page);
                    }
                }
            }
        });
    }

    public void stop() {
        TXLivePlayerJSAdapter tXLivePlayerJSAdapter = this.livePlayerJsAdapter;
        if (tXLivePlayerJSAdapter != null) {
            tXLivePlayerJSAdapter.operateLivePlayer("stop", null);
        }
        cancelAvoidLockScreen();
    }

    public void takePhoto(final String str, boolean z16, final RequestEvent requestEvent) {
        if (this.livePlayerJsAdapter == null) {
            return;
        }
        QMLog.e("MiniAppLivePlayer", "takePhoto invoke");
        this.livePlayerJsAdapter.setSnapshotListener(new TXLivePlayerJSAdapter.ISnapshotOuterListener() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.7
            @Override // com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ISnapshotOuterListener
            public void onSnapshot(final Bitmap bitmap) {
                ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            File file = new File(((MiniAppFileManager) MiniAppLivePlayer.this.baseRuntime.getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
                            file.getParentFile().mkdirs();
                            MiniAppLivePlayer.saveJpeg(bitmap, file);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("tempImagePath", file.getAbsolutePath());
                            jSONObject.put("width", bitmap.getWidth());
                            jSONObject.put("height", bitmap.getHeight());
                            JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str, jSONObject);
                            RequestEvent requestEvent2 = requestEvent;
                            requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, wrapCallbackOk.toString());
                            QMLog.e("MiniAppLivePlayer", "takePhoto - evaluateCallbackJs\uff1a" + wrapCallbackOk.toString());
                        } catch (Exception unused) {
                            JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(str, new JSONObject());
                            RequestEvent requestEvent3 = requestEvent;
                            requestEvent3.jsService.evaluateCallbackJs(requestEvent3.callbackId, wrapCallbackFail.toString());
                        }
                    }
                });
            }
        });
        this.livePlayerJsAdapter.takePhoto(z16);
    }

    public void updateLivePlayerSetting(JSONObject jSONObject) {
        if (QMLog.isColorLevel()) {
            QMLog.d("MiniAppLivePlayer", "updateLivePlayerSetting isFullScreen: " + this.isFullScreen);
        }
        TXLivePlayerJSAdapter tXLivePlayerJSAdapter = this.livePlayerJsAdapter;
        if (tXLivePlayerJSAdapter == null) {
            return;
        }
        tXLivePlayerJSAdapter.updateLivePlayer(jSONObject);
    }

    public MiniAppLivePlayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler(Looper.getMainLooper());
        this.enableDanmu = false;
        this.showDanmuBtn = false;
        this.loop = false;
        this.initialTime = 0;
        this.showProgress = true;
        this.showPlayBtn = false;
        this.showCenterPlayBtn = true;
        this.showFullScreenBtn = true;
        this.enableProgressGesture = true;
        this.showMuteBtn = true;
        this.muted = false;
        this.enablePlayGesture = false;
        this.direction = -1;
        this.isBusyInChangeScreen = false;
        this.lastSmallScreenTime = -1L;
        this.lastNavBarVisibility = 8;
        this.lastTabBarVisibility = 8;
        this.componentLayoutScrollY = 0;
        this.hasSetUp = false;
        setUpView(context);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
