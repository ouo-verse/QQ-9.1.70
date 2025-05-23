package cooperation.qqcircle.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.remoteweb.ad;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.utils.web.QFSWebForegroundService;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public class QFSMainProcessWebView extends TextureView {
    private static final long DEFAULT_TIME = 3000;
    private static final String ERROR_CODE = "ERROR_CODE";
    private static final String ERROR_MESSAGE = "ERROR_MESSAGE";
    private static final float MIN_REFRESH_VAL = 60.0f;
    private static final String TAG = "QFSMainProcessWebView";
    private static Surface sCurrentAttachSurface;
    private static volatile boolean sIsStartRemoteWebViewIng;
    private static int sSurfaceCount;
    public Runnable mClearInstanceRunnable;
    private Surface mCurrentSurface;
    private boolean mIsLoadErrorStatus;
    private boolean mIsResume;
    private final IProcessStateChangeCallback mProcessChangeListener;
    private StatusListener mStatusListener;
    private Boolean mSupportMultiDisplay;
    private String mUrl;
    private final com.tencent.mobileqq.remoteweb.a mWebListener;
    private final String mWebPageId;

    /* loaded from: classes28.dex */
    public interface StatusListener {
        void loadSucceed();

        void onError(Object obj, Object obj2);

        void onWebViewDestroy();
    }

    public QFSMainProcessWebView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean disableBackgroundShowNotify() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_main_process_web_back_home_show_notify_9_0_85", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchVisibleWhenPageLoadSucceed() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_main_process_web_notify_visible_when_load_succeed", true)) {
            return;
        }
        QLog.d(TAG, 1, "[dispatchVisibleWhenPageLoadSucceed]" + this.mIsResume);
        if (this.mIsResume) {
            onRealShow();
        } else {
            onRealHide();
        }
    }

    public static boolean enableKillInstanceOnExit() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_close_main_process_web_instance_when_exit_only_display_change", true)) {
            return isScreenRefreshChange();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_close_main_process_web_instance_when_exit", false);
    }

    private boolean enableShowKeepAliveNotify() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_main_process_web_show_notify_9_0_85", true);
    }

    public static boolean enableVideoPlayWebViewStatusCheck() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_video_play_remote_webview_status_check", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getWebPageId() {
        return this.mWebPageId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initListener() {
        RemoteWebRenderIPCServer.J().w(this.mWebListener);
    }

    public static boolean isForegroundStartRemoteWebView() {
        QLog.d(TAG, 1, "[isForegroundStartRemoteWebView] sIsStartRemoteWebViewIng:" + sIsStartRemoteWebViewIng);
        return sIsStartRemoteWebViewIng;
    }

    private static boolean isScreenRefreshChange() {
        try {
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity == null) {
                return false;
            }
            int currentScreenRefreshRate = (int) ScreenUtil.getCurrentScreenRefreshRate(topActivity);
            if (ScreenUtil.getMaxRefreshRate() <= currentScreenRefreshRate || currentScreenRefreshRate != 60.0f) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.d(TAG, 2, "[isScreenRefreshChange] error:" + e16);
            return false;
        }
    }

    private boolean isSupportMultiDisplay() {
        Boolean bool = this.mSupportMultiDisplay;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_main_process_web_muti_display", true));
        this.mSupportMultiDisplay = valueOf;
        return valueOf.booleanValue();
    }

    public static long killInstanceOnExitDelayTime() {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_close_main_process_web_instance_when_exit_delay", String.valueOf(3000L)));
        } catch (Exception e16) {
            QLog.d(TAG, 2, "[killInstanceOnExitDelayTime] error:" + e16);
            return 3000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearMemory$1() {
        RemoteWebRenderIPCServer.J().C(getWebPageId(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSurface$0(boolean z16, EIPCResult eIPCResult) {
        if (eIPCResult.isSuccess()) {
            if (isSupportMultiDisplay()) {
                QLog.d(TAG, 1, "[updateSurface] multiDisplay succeed webPageId:" + getWebPageId() + ",mUrl:" + this.mUrl);
                if (z16) {
                    reloadUrl();
                }
            } else {
                QLog.d(TAG, 1, "[updateSurface] single Display succeed webPageId:" + getWebPageId() + ",mCurrentSurface:" + this.mCurrentSurface + ",sCurrentAttachSurface:" + sCurrentAttachSurface);
                if (z16 || this.mCurrentSurface != sCurrentAttachSurface) {
                    reloadUrl();
                }
            }
            sCurrentAttachSurface = this.mCurrentSurface;
            return;
        }
        QLog.e(TAG, 1, "[updateSurface] error " + eIPCResult.f396321e);
    }

    private void notifyWebForeground(final boolean z16) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_main_process_web_notify_use_sub_thread", true)) {
            RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: cooperation.qqcircle.utils.QFSMainProcessWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    RemoteWebRenderIPCServer.J().U(QFSMainProcessWebView.this.getWebPageId(), z16);
                }
            });
        } else {
            RemoteWebRenderIPCServer.J().U(getWebPageId(), z16);
        }
    }

    private void reloadUrl() {
        if (this.mCurrentSurface != null && !TextUtils.isEmpty(this.mUrl)) {
            RemoteWebRenderIPCServer.J().R(this.mUrl, this.mCurrentSurface, getWebPageId(), new Bundle(), new Function1<Boolean, Unit>() { // from class: cooperation.qqcircle.utils.QFSMainProcessWebView.8
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(Boolean bool) {
                    QLog.d(QFSMainProcessWebView.TAG, 1, "[loadUrl] aBoolean \uff1a" + bool + ", webID:" + QFSMainProcessWebView.this.mWebPageId);
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRemoteWebView() {
        if (this.mCurrentSurface != null && !TextUtils.isEmpty(this.mUrl)) {
            sIsStartRemoteWebViewIng = true;
            Bundle bundle = new Bundle();
            bundle.putInt("key_web_view_width", getMeasuredWidth());
            bundle.putInt("key_web_view_height", getMeasuredHeight());
            bundle.putBoolean("key_enable_multi_display", isSupportMultiDisplay());
            bundle.putString("key_remote_service_type", "qcircle");
            QLog.d(TAG, 1, "[startRemoteWebView] webPageId:" + getWebPageId() + ",mUrl:" + this.mUrl);
            RemoteWebRenderIPCServer.J().h0(this.mUrl, this.mCurrentSurface, getWebPageId(), getContext(), bundle);
            return;
        }
        QLog.e(TAG, 1, "[startRemoteWebView] mCurrentSurface " + this.mCurrentSurface + ",mUrl:" + this.mUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOrCreateSurface(final boolean z16) {
        RFWThreadManager.getUIHandler().removeCallbacks(this.mClearInstanceRunnable);
        if (this.mCurrentSurface == null) {
            QLog.d(TAG, 1, "[updateOrCreateSurface] mCurrentSurface is null, webID:" + getWebPageId());
            return;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            QLog.d(TAG, 1, "[updateOrCreateSurface] mUrl is null");
        } else {
            RemoteWebRenderIPCServer.J().x(getWebPageId(), new Function1<Boolean, Unit>() { // from class: cooperation.qqcircle.utils.QFSMainProcessWebView.7
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(Boolean bool) {
                    QLog.d(QFSMainProcessWebView.TAG, 1, "[updateOrCreateSurface] isAttach\uff1a" + bool);
                    if (!bool.booleanValue()) {
                        QFSMainProcessWebView.this.startRemoteWebView();
                        return null;
                    }
                    QFSMainProcessWebView.this.updateSurface(z16);
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSurface(final boolean z16) {
        QLog.d(TAG, 1, "[updateSurface] webPageId:" + getWebPageId() + ",forceRefresh:" + z16);
        RemoteWebRenderIPCServer.J().j0(getWebPageId(), this.mCurrentSurface, getMeasuredWidth(), getMeasuredHeight(), new EIPCResultCallback() { // from class: cooperation.qqcircle.utils.a
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QFSMainProcessWebView.this.lambda$updateSurface$0(z16, eIPCResult);
            }
        });
    }

    public void clearMemory() {
        if (isSupportMultiDisplay()) {
            QLog.d(TAG, 1, "[clearMemory]");
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_main_process_web_destroy_use_sub_thread", true)) {
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.utils.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSMainProcessWebView.this.lambda$clearMemory$1();
                    }
                });
            } else {
                RemoteWebRenderIPCServer.J().C(getWebPageId(), null);
            }
        }
    }

    public void doRender(boolean z16) {
        QLog.d(TAG, 1, "[doRender] webPageId:" + getWebPageId() + ",url:" + this.mUrl + ",forceRefresh:" + z16);
        if (!TextUtils.isEmpty(this.mUrl)) {
            updateOrCreateSurface(z16);
        }
    }

    public void initConfig(String str) {
        QLog.d(TAG, 1, "[initConfig] url\uff1a" + str);
        this.mUrl = str;
        if (!TextUtils.isEmpty(str)) {
            updateOrCreateSurface(true);
        }
    }

    public void onRealHide() {
        this.mIsResume = false;
        QLog.d(TAG, 1, "[onPause] webPageId:" + getWebPageId() + ",url:" + this.mUrl);
        notifyWebForeground(false);
    }

    public void onRealShow() {
        onRealShow(false);
    }

    public void postDelayDestroyRemoteView() {
        QLog.d(TAG, 1, "[postDelayDestroyRemoteView] webPageId:" + getWebPageId());
        RFWThreadManager.getUIHandler().removeCallbacks(this.mClearInstanceRunnable);
        RFWThreadManager.getUIHandler().postDelayed(this.mClearInstanceRunnable, killInstanceOnExitDelayTime());
    }

    public void setStatusListener(StatusListener statusListener) {
        this.mStatusListener = statusListener;
    }

    public void startKeepAlive() {
        if (!enableShowKeepAliveNotify()) {
            return;
        }
        Context context = getContext();
        QLog.d(TAG, 1, "[startKeepAlive] context:" + context);
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) PreloadWebService.class);
        try {
            intent.putExtra("key_remote_service_type", "qcircle");
            intent.putExtra(QFSWebForegroundService.EVENT_SHOW_NOTIFY_SERVICE, true);
            intent.putExtra("key_web_page_id", getWebPageId());
            context.startService(intent);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[startKeepAlive], error=", th5);
        }
    }

    public void stopKeepAlive() {
        Context context = getContext();
        QLog.d(TAG, 1, "[stopKeepAlive] context:" + context);
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) PreloadWebService.class);
        try {
            intent.putExtra("key_remote_service_type", "qcircle");
            intent.putExtra(QFSWebForegroundService.EVENT_KILL_NOTIFY_SERVICE, true);
            intent.putExtra("key_web_page_id", getWebPageId());
            context.startService(intent);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[stopKeepAlive], error=", th5);
        }
    }

    public QFSMainProcessWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSupportMultiDisplay = null;
        this.mProcessChangeListener = new IProcessStateChangeCallback() { // from class: cooperation.qqcircle.utils.QFSMainProcessWebView.1
            @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
            public void onProcessBackground() {
                QLog.d(QFSMainProcessWebView.TAG, 1, "[onProcessBackground]");
                com.tencent.richframework.lifecycle.a.a(this);
                if (QFSMainProcessWebView.this.disableBackgroundShowNotify()) {
                    QFSMainProcessWebView.this.stopKeepAlive();
                }
                if (QFSMainProcessWebView.enableKillInstanceOnExit()) {
                    QFSMainProcessWebView.this.postDelayDestroyRemoteView();
                }
            }

            @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
            public void onProcessForeground() {
                com.tencent.richframework.lifecycle.a.b(this);
                QLog.d(QFSMainProcessWebView.TAG, 1, "[onProcessForeground]");
                if (QFSMainProcessWebView.this.mIsResume) {
                    QFSMainProcessWebView.this.startKeepAlive();
                }
            }
        };
        this.mWebListener = new ad() { // from class: cooperation.qqcircle.utils.QFSMainProcessWebView.2
            @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
            public void onFailed(@NotNull String str, int i3, @org.jetbrains.annotations.Nullable String str2) {
                if (TextUtils.equals(str, QFSMainProcessWebView.this.mWebPageId) && QFSMainProcessWebView.this.mStatusListener != null) {
                    QFSMainProcessWebView.this.mStatusListener.onError(Integer.valueOf(i3), str2);
                }
                QLog.d(QFSMainProcessWebView.TAG, 2, "[onFailed]" + QFSMainProcessWebView.this.getWebPageId() + str2);
            }

            @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
            public void onServiceConnected() {
                QLog.d(QFSMainProcessWebView.TAG, 1, "[onServiceConnected]" + QFSMainProcessWebView.this.getWebPageId());
            }

            @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
            public void onServiceDisconnected(long j3) {
                QLog.d(QFSMainProcessWebView.TAG, 1, "[onServiceDisconnected]" + QFSMainProcessWebView.this.getWebPageId());
                QFSMainProcessWebView.sIsStartRemoteWebViewIng = false;
                if (QFSMainProcessWebView.this.mStatusListener != null) {
                    QFSMainProcessWebView.this.mStatusListener.onWebViewDestroy();
                }
            }

            @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
            public void onWebViewEvent(@NotNull String str, @NotNull RemoteWebViewEvent remoteWebViewEvent, @NonNull Bundle bundle) {
                QFSMainProcessWebView.sIsStartRemoteWebViewIng = false;
                if (TextUtils.equals(str, QFSMainProcessWebView.this.mWebPageId) && remoteWebViewEvent.status() == RemoteWebViewEvent.ON_PAGE_FINISH.status()) {
                    Object obj = bundle.get("ERROR_CODE");
                    Object obj2 = bundle.get(QFSMainProcessWebView.ERROR_MESSAGE);
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() != 0) {
                        if (QFSMainProcessWebView.this.mStatusListener != null) {
                            QFSMainProcessWebView.this.mStatusListener.onError(obj, obj2);
                        }
                        QFSMainProcessWebView.this.mIsLoadErrorStatus = true;
                    } else {
                        if (QFSMainProcessWebView.this.mStatusListener != null) {
                            QFSMainProcessWebView.this.mStatusListener.loadSucceed();
                        }
                        QFSMainProcessWebView.this.dispatchVisibleWhenPageLoadSucceed();
                        QFSMainProcessWebView.this.mIsLoadErrorStatus = false;
                    }
                    QLog.d(QFSMainProcessWebView.TAG, 2, "[onWebViewEvent] load succeed:" + QFSMainProcessWebView.this.getWebPageId() + ",code:" + obj + ",msg:" + obj2);
                }
            }

            @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
            public void onReportTimeCost(@NotNull String str, @NotNull RemoteWebTimeCost remoteWebTimeCost, long j3) {
            }
        };
        this.mClearInstanceRunnable = new Runnable() { // from class: cooperation.qqcircle.utils.QFSMainProcessWebView.5
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(QFSMainProcessWebView.TAG, 1, "[mClearInstanceRunnable] run");
                QFSMainProcessWebView.this.clearMemory();
                QFSMainProcessWebView.this.stopKeepAlive();
                if (QFSMainProcessWebView.this.mStatusListener != null) {
                    QFSMainProcessWebView.this.mStatusListener.onWebViewDestroy();
                }
            }
        };
        if (isSupportMultiDisplay()) {
            this.mWebPageId = "qfs_" + hashCode();
        } else {
            this.mWebPageId = "QFS_DEFAULT_WEB_PAGE";
        }
        setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: cooperation.qqcircle.utils.QFSMainProcessWebView.3
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
                QLog.d(QFSMainProcessWebView.TAG, 1, "[onSurfaceTextureAvailable]");
                QFSMainProcessWebView.sSurfaceCount++;
                QFSMainProcessWebView.this.initListener();
                QFSMainProcessWebView.this.mCurrentSurface = new Surface(surfaceTexture);
                QFSMainProcessWebView.this.updateOrCreateSurface(true);
                RFWLifecycleHelper.getInstance().registerProcessChangeListener(QFSMainProcessWebView.this.mProcessChangeListener);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
                QFSMainProcessWebView.sSurfaceCount--;
                QLog.d(QFSMainProcessWebView.TAG, 1, "[onSurfaceTextureDestroyed] sSurfaceCount:" + QFSMainProcessWebView.sSurfaceCount);
                if (QFSMainProcessWebView.sCurrentAttachSurface == QFSMainProcessWebView.this.mCurrentSurface) {
                    QFSMainProcessWebView.sCurrentAttachSurface = null;
                    QLog.d(QFSMainProcessWebView.TAG, 1, "set sCurrentAttachSurface = null");
                }
                QFSMainProcessWebView.this.mCurrentSurface = null;
                RFWLifecycleHelper.getInstance().unRegisterProcessChangeListener(QFSMainProcessWebView.this.mProcessChangeListener);
                QFSMainProcessWebView.this.clearMemory();
                if (QFSMainProcessWebView.sSurfaceCount <= 0) {
                    QFSMainProcessWebView.this.stopKeepAlive();
                }
                if (QFSMainProcessWebView.this.mStatusListener != null) {
                    QFSMainProcessWebView.this.mStatusListener.onWebViewDestroy();
                }
                RemoteWebRenderIPCServer.J().f0(QFSMainProcessWebView.this.mWebListener);
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: cooperation.qqcircle.utils.QFSMainProcessWebView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                RemoteWebRenderIPCServer.J().G(QFSMainProcessWebView.this.getWebPageId(), motionEvent);
                return true;
            }
        });
    }

    public void onRealShow(boolean z16) {
        QLog.d(TAG, 1, "[onRealShow] webPageId:" + getWebPageId() + ",needRefresh:" + z16);
        this.mIsResume = true;
        notifyWebForeground(true);
        if (TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        updateOrCreateSurface(z16);
        if (this.mIsLoadErrorStatus) {
            reloadUrl();
        }
    }
}
