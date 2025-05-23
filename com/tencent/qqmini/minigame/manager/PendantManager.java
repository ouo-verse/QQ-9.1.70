package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.widget.DragImageView;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes23.dex */
public class PendantManager {
    public static final String OPERATE_TYPE_ADD = "add";
    public static final String OPERATE_TYPE_REMOVE = "remove";
    private static final String TAG = "PendantManager";
    private Activity mContext;
    private DragImageView mDragImageView;
    private ViewGroup mGameContainer;
    private IMiniAppContext mMiniAppContext;
    public static final Handler SHOW_HANDLER = new Handler(Looper.getMainLooper());
    public static final Handler REMOVE_HANDLER = new Handler(Looper.getMainLooper());
    public static final Handler AUTO_WEBVIEW_DELAY_HANDLER = new Handler(Looper.getMainLooper());
    public static final Handler STATIC_PENDANT = new Handler(Looper.getMainLooper());
    private static Drawable defaultDrawable = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public static class a implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DragImageView f346533a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PendantAdInfo f346534b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f346535c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMiniAppContext f346536d;

        a(DragImageView dragImageView, PendantAdInfo pendantAdInfo, Activity activity, IMiniAppContext iMiniAppContext) {
            this.f346533a = dragImageView;
            this.f346534b = pendantAdInfo;
            this.f346535c = activity;
            this.f346536d = iMiniAppContext;
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            QMLog.d(PendantManager.TAG, "closeWebView doOnActivityResult requestCode" + i3 + " resultCode:" + i16);
            boolean z16 = false;
            if (i3 != 11007) {
                return false;
            }
            Bundle extras = intent.getExtras();
            if (i16 == -1 && extras != null && extras.get("allCloseState") != null) {
                boolean equals = extras.get("allCloseState").toString().equals("0");
                String str = "2";
                boolean equals2 = extras.get("allCloseState").toString().equals("2");
                if (equals || equals2) {
                    z16 = true;
                }
                PendantDataManager.TIME_EXTENSION_ENABLE = equals;
                QMLog.d(PendantManager.TAG, "allCloseState=" + extras.get("allCloseState").toString() + ", shouldShowStaticPic=" + z16);
                if (z16) {
                    PendantDataManager.entranceStrategy = 1;
                    DragImageView dragImageView = this.f346533a;
                    if (dragImageView != null) {
                        PendantManager.showNewPendantIcon(this.f346534b, dragImageView, this.f346535c);
                    }
                    if (!equals) {
                        str = "4";
                    }
                    PendantDataManager.reportExposure(str);
                } else {
                    PendantDataManager.entranceStrategy = 2;
                    PendantDataManager.getSp().edit().putString("numMaxConsumption", Integer.toString(Integer.parseInt(this.f346534b.getNumMaxConsumption()) - 1)).commit();
                }
                PendantDataManager.requestAd(this.f346535c, this.f346536d, this.f346534b.getAppId(), this.f346534b.getScene());
            }
            ActivityResultManager.g().removeActivityResultListener(this);
            return true;
        }
    }

    public PendantManager(Activity activity, IMiniAppContext iMiniAppContext, ViewGroup viewGroup) {
        this.mContext = activity;
        this.mMiniAppContext = iMiniAppContext;
        this.mGameContainer = viewGroup;
        defaultDrawable = activity.getResources().getDrawable(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdView(final PendantAdInfo pendantAdInfo) {
        if (this.mDragImageView != null) {
            QMLog.e(TAG, "addAdView fail, already exist");
            return;
        }
        QMLog.d(TAG, "addAdViewing");
        this.mDragImageView = new DragImageView(this.mContext, 1);
        final MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (PendantDataManager.entranceStrategy == 1) {
            this.mDragImageView.setImageDrawable(miniAppProxy.getDrawable(this.mContext, pendantAdInfo.getPendantUrl(), 0, 0, defaultDrawable));
            STATIC_PENDANT.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantManager.2
                @Override // java.lang.Runnable
                public void run() {
                    PendantManager.this.mDragImageView.setImageDrawable(miniAppProxy.getDrawable(PendantManager.this.mContext, pendantAdInfo.getStaticPendantUrl(), 0, 0, PendantManager.defaultDrawable));
                }
            }, 2000L);
        } else {
            Drawable drawable = miniAppProxy.getDrawable(this.mContext, pendantAdInfo.getPictureUrl(), 0, 0, defaultDrawable);
            this.mDragImageView.setImageDrawable(drawable);
            setExpoResult(drawable);
            PendantDataManager.reportExposure("1");
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, 100.0f), DisplayUtil.dip2px(this.mContext, 100.0f));
        layoutParams.leftMargin = DisplayUtil.dip2px(this.mContext, 29.0f);
        layoutParams.rightMargin = DisplayUtil.dip2px(this.mContext, 87.0f);
        layoutParams.topMargin = DisplayUtil.dip2px(this.mContext, 0.0f);
        layoutParams.bottomMargin = DisplayUtil.dip2px(this.mContext, 92.5f);
        layoutParams.gravity = 8388661;
        this.mGameContainer.addView(this.mDragImageView, layoutParams);
        bookFlashingIcon(pendantAdInfo, this.mDragImageView, this.mContext);
        this.mDragImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.manager.PendantManager.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                PendantManager.this.onAdClick(pendantAdInfo, miniAppProxy);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    public static void bookFlashingIcon(final PendantAdInfo pendantAdInfo, final DragImageView dragImageView, final Activity activity) {
        ArrayList<Date> handleTianshuDateParsing = PendantDataManager.handleTianshuDateParsing(new Date(((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getServerTime()), pendantAdInfo);
        if (handleTianshuDateParsing == null) {
            return;
        }
        Date date = handleTianshuDateParsing.get(0);
        SHOW_HANDLER.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantManager.5
            @Override // java.lang.Runnable
            public void run() {
                if (PendantDataManager.entranceStrategy == 1 && PendantDataManager.TIME_EXTENSION_ENABLE) {
                    QMLog.d(PendantManager.TAG, "\u6302\u4ef6\u4e94\u5206\u949f\u5012\u8ba1\u65f6\u95ea\u70c1");
                    dragImageView.setImageDrawable(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(activity, pendantAdInfo.getPendantUrl(), 0, 0, PendantManager.defaultDrawable));
                }
            }
        }, handleTianshuDateParsing.get(3).getTime() - date.getTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClick(PendantAdInfo pendantAdInfo, MiniAppProxy miniAppProxy) {
        if (pendantAdInfo == null) {
            QMLog.e(TAG, "pendantAdInfo is null");
            return;
        }
        if (pendantAdInfo.isSchema()) {
            miniAppProxy.openSchema(this.mContext, pendantAdInfo.getJumpUrl(), 1037, null);
        } else {
            startRedPacketBrowserActivity(this.mContext, pendantAdInfo.getJumpUrl(), this.mDragImageView, pendantAdInfo, this.mMiniAppContext);
            QMLog.i(TAG, "click to start transparentBrowser");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setExpoResult(Drawable drawable) {
        if (drawable == null) {
            PendantDataManager.RESULT = 1;
        }
    }

    public static void showNewPendantIcon(final PendantAdInfo pendantAdInfo, final DragImageView dragImageView, final Activity activity) {
        final MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        Drawable drawable = miniAppProxy.getDrawable(activity, pendantAdInfo.getPendantUrl(), 0, 0, defaultDrawable);
        dragImageView.setImageDrawable(drawable);
        setExpoResult(drawable);
        STATIC_PENDANT.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantManager.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable2 = MiniAppProxy.this.getDrawable(activity, pendantAdInfo.getStaticPendantUrl(), 0, 0, PendantManager.defaultDrawable);
                dragImageView.setImageDrawable(drawable2);
                PendantManager.setExpoResult(drawable2);
            }
        }, 2000L);
    }

    public static void startRedPacketBrowserActivity(Activity activity, String str, DragImageView dragImageView, PendantAdInfo pendantAdInfo, IMiniAppContext iMiniAppContext) {
        boolean z16;
        ActivityResultManager.g().addActivityResultListener(new a(dragImageView, pendantAdInfo, activity, iMiniAppContext));
        Bundle bundle = new Bundle();
        if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        QMLog.d(TAG, "activity isLandscape= " + z16);
        bundle.putBoolean("mini_game_orientation", z16);
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy == null) {
            QMLog.e(TAG, "channelProxy null");
            return;
        }
        if (!channelProxy.startRedpacketTranslucentBrowserActivityForResult(activity, str, bundle, 11007)) {
            PendantDataManager.RESULT = 1;
        }
        int i3 = PendantDataManager.entranceStrategy;
        if (i3 == 1) {
            PendantDataManager.reportClick("2");
        } else if (i3 == 0) {
            PendantDataManager.reportClick("1");
        }
        QMLog.i(TAG, "startTransparentBrowserActivity, url=" + str);
    }

    public boolean removePendantAd() {
        ViewGroup viewGroup = this.mGameContainer;
        if (viewGroup == null) {
            return false;
        }
        viewGroup.post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantManager.7
            @Override // java.lang.Runnable
            public void run() {
                if (PendantManager.this.mDragImageView != null) {
                    PendantManager.this.mGameContainer.removeView(PendantManager.this.mDragImageView);
                }
                PendantManager.this.mDragImageView = null;
            }
        });
        return true;
    }

    public boolean showPendantAd(final PendantAdInfo pendantAdInfo) {
        ViewGroup viewGroup;
        if (this.mContext != null && (viewGroup = this.mGameContainer) != null) {
            if (this.mDragImageView != null) {
                QMLog.e(TAG, "showPendantAd fail, already exist");
                return false;
            }
            viewGroup.post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantManager.1
                @Override // java.lang.Runnable
                public void run() {
                    PendantManager.this.addAdView(pendantAdInfo);
                }
            });
            return true;
        }
        QMLog.e(TAG, "showDragAd fail");
        return false;
    }
}
