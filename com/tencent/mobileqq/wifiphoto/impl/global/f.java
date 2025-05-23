package com.tencent.mobileqq.wifiphoto.impl.global;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.PowerManager;
import android.view.Window;
import androidx.core.app.NotificationCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wifiphoto.activity.WifiPhotoActivity;
import com.tencent.mobileqq.wifiphoto.data.WifiPhotoInfo;
import com.tencent.mobileqq.wifiphoto.fragment.PushApplyFragment;
import com.tencent.mobileqq.wifiphoto.fragment.RequestApplyFragment;
import com.tencent.mobileqq.wifiphoto.impl.global.f;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ah;
import com.tencent.qqnt.kernel.nativeinterface.AuthorizationStatus;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoPreCheckCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoAuthorizationInfo;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoConnectionType;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoRequestInfo;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoRequestType;
import com.tencent.qqnt.kernel.nativeinterface.ce;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bF\u0010GJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\tJ*\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001cJ \u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001cJ\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u0006R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010,R\u0016\u00100\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u001bR\u0016\u00106\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u001bR\u001c\u0010=\u001a\b\u0018\u000109R\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/impl/global/f;", "", "Landroid/content/Context;", "context", "", "tips", "", "O", "page", "", "source", "errorCode", "Landroid/content/Intent;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "M", "", "isOn", "H", "K", UserInfo.SEX_FEMALE, "E", BdhLogUtil.LogTag.Tag_Conn, "G", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoPreCheckCallback;", "cb", "I", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "L", "Lcom/tencent/qqnt/kernel/nativeinterface/AuthorizationStatus;", "authorizationStatus", "d", "reason", "J", "B", "Lcom/tencent/qqnt/kernel/api/ah;", "b", "Lcom/tencent/qqnt/kernel/api/ah;", "service", "c", "Ljava/lang/Integer;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Lcom/tencent/qqnt/kernel/nativeinterface/WiFiPhotoRequestInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/WiFiPhotoRequestInfo;", "requestInfo", "e", "Z", "isAccess", "f", "isRequestApplyBackground", "g", "cancelRequestType", tl.h.F, "isBackgroundDisconnect", "i", "backgroundDisconnectErrorCode", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "j", "Landroid/os/PowerManager$WakeLock;", "wakeLock", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoHostListener;", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoHostListener;", "wiFiPhotoHostListener", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "l", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "guardManagerCallback", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f317624a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ah service;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Integer requestId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WiFiPhotoRequestInfo requestInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isAccess;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isRequestApplyBackground;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static volatile int cancelRequestType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isBackgroundDisconnect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int backgroundDisconnectErrorCode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static PowerManager.WakeLock wakeLock;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IKernelWiFiPhotoHostListener wiFiPhotoHostListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IGuardInterface guardManagerCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wifiphoto/impl/global/f$a", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements IGuardInterface {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c() {
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity == null) {
                return;
            }
            if (!(topActivity instanceof WifiPhotoActivity)) {
                f.f317624a.M(topActivity, f.backgroundDisconnectErrorCode);
            } else {
                f.D(f.f317624a, topActivity, "/wifi_photo/request_apply", 0, f.backgroundDisconnectErrorCode, 4, null);
            }
            f.isBackgroundDisconnect = false;
            f.backgroundDisconnectErrorCode = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d() {
            f fVar = f.f317624a;
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            f.D(fVar, context, "/wifi_photo/request_apply", 0, f.cancelRequestType, 4, null);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QLog.i("QWifiPhotoService", 1, "wifi photo in background, isAccess: " + f.isAccess);
                if (f.isAccess) {
                    f fVar = f.f317624a;
                    BaseApplication context = BaseApplication.context;
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    fVar.O(context, "\u4f60\u7684\u7535\u8111\u6b63\u5728\u8bbf\u95ee\u624b\u673a\u76f8\u518c\uff0c\u8bf7\u4e0d\u8981\u79bb\u5f00QQ");
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QLog.i("QWifiPhotoService", 1, "wifi photo in foreground, isBackgroundDisconnect: " + f.isBackgroundDisconnect);
                if (f.isBackgroundDisconnect) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.impl.global.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.a.c();
                        }
                    });
                }
                if (f.isRequestApplyBackground) {
                    f.isRequestApplyBackground = false;
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.impl.global.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.a.d();
                        }
                    });
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, isEnabled);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0019\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wifiphoto/impl/global/f$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoHostListener;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Lcom/tencent/qqnt/kernel/nativeinterface/WiFiPhotoRequestInfo;", "requestInfo", "", "onRequestVisitAlbum", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CANCEL_TYPE, "onCanceled", "(Ljava/lang/Integer;)V", "error", "onDisconnection", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IKernelWiFiPhotoHostListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d() {
            if (GuardManager.sInstance.isApplicationForeground()) {
                Activity topActivity = Foreground.getTopActivity();
                QLog.i("QWifiPhotoService", 1, "onCanceled top: " + topActivity);
                if (topActivity instanceof WifiPhotoActivity) {
                    f.D(f.f317624a, topActivity, "/wifi_photo/request_apply", 0, f.cancelRequestType, 4, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(int i3) {
            BannerManager.l().N(com.tencent.mobileqq.banner.d.f200256i, 0, -1);
            f fVar = f.f317624a;
            fVar.H(false);
            if (!GuardManager.sInstance.isApplicationForeground()) {
                f.isBackgroundDisconnect = true;
                f.backgroundDisconnectErrorCode = i3;
                return;
            }
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity instanceof WifiPhotoActivity) {
                f.D(fVar, topActivity, "/wifi_photo/request_apply", 0, i3, 4, null);
            } else if (topActivity != null) {
                fVar.M(topActivity, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f() {
            BaseApplication context = BaseApplication.context;
            if (!GuardManager.sInstance.isApplicationForeground()) {
                f.isRequestApplyBackground = true;
                f fVar = f.f317624a;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                fVar.O(context, "\u8bf7\u5f00\u542fQQ\uff0c\u77ac\u95f4\u79fb\u52a8\u7167\u7247\u5230\u7535\u8111");
                return;
            }
            f fVar2 = f.f317624a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            f.D(fVar2, context, "/wifi_photo/request_apply", 0, 0, 12, null);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostListener
        public /* synthetic */ void onAutoReconnecting(int i3) {
            ce.a(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostListener
        public void onCanceled(@Nullable Integer cancelType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cancelType);
                return;
            }
            QLog.i("QWifiPhotoService", 1, "cancel: " + cancelType);
            if (cancelType != null && 1 == cancelType.intValue()) {
                f.cancelRequestType = AppConstants.VALUE.UIN_TYPE_OFFICE_OPEN;
            } else if (cancelType != null && cancelType.intValue() == 0) {
                f.cancelRequestType = 9999;
            }
            f.requestId = null;
            f.requestInfo = null;
            f.isAccess = false;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.impl.global.h
                @Override // java.lang.Runnable
                public final void run() {
                    f.b.d();
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostListener
        public /* synthetic */ void onConnected(WiFiPhotoConnectionType wiFiPhotoConnectionType) {
            ce.c(this, wiFiPhotoConnectionType);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostListener
        public void onDisconnection(final int error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, error);
                return;
            }
            QLog.i("QWifiPhotoService", 1, "onDisconnection...");
            f.f317624a.K();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.impl.global.i
                @Override // java.lang.Runnable
                public final void run() {
                    f.b.e(error);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostListener
        public /* synthetic */ void onRequestAlbumFullAccess() {
            ce.e(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostListener
        public void onRequestVisitAlbum(int requestId, @Nullable WiFiPhotoRequestInfo requestInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                f.cancelRequestType = -1;
                if (requestInfo == null) {
                    return;
                }
                QLog.i("QWifiPhotoService", 1, "onRequestVisitAlbum...requestId " + requestId + ", requestInfo: " + requestInfo);
                f.requestId = Integer.valueOf(requestId);
                f.requestInfo = requestInfo;
                if (requestInfo.requestType == WiFiPhotoRequestType.KLOCALREQUEST) {
                    BaseApplication baseApplication = BaseApplication.context;
                    Intent intent = new Intent();
                    intent.setAction(PushApplyFragment.ACCESS_RESULT_ACTION);
                    Integer num = f.requestId;
                    Intrinsics.checkNotNull(num);
                    int intValue = num.intValue();
                    WiFiPhotoRequestInfo wiFiPhotoRequestInfo = f.requestInfo;
                    Intrinsics.checkNotNull(wiFiPhotoRequestInfo);
                    String str = wiFiPhotoRequestInfo.clientLoginLocation;
                    Intrinsics.checkNotNullExpressionValue(str, "requestInfo!!.clientLoginLocation");
                    WiFiPhotoRequestInfo wiFiPhotoRequestInfo2 = f.requestInfo;
                    Intrinsics.checkNotNull(wiFiPhotoRequestInfo2);
                    String str2 = wiFiPhotoRequestInfo2.clientDeviceName;
                    Intrinsics.checkNotNullExpressionValue(str2, "requestInfo!!.clientDeviceName");
                    intent.putExtra(RequestApplyFragment.INFO_KEY, new WifiPhotoInfo(intValue, str, str2));
                    baseApplication.sendBroadcast(intent);
                    return;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.impl.global.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.b.f();
                    }
                });
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, requestId, (Object) requestInfo);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25642);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f317624a = new f();
        cancelRequestType = -1;
        backgroundDisconnectErrorCode = -1;
        wiFiPhotoHostListener = new b();
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static /* synthetic */ Intent A(f fVar, Context context, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i3 = 0;
        }
        if ((i17 & 8) != 0) {
            i16 = -1;
        }
        return fVar.z(context, str, i3, i16);
    }

    public static /* synthetic */ void D(f fVar, Context context, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i3 = 0;
        }
        if ((i17 & 8) != 0) {
            i16 = -1;
        }
        fVar.C(context, str, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(boolean isOn) {
        Object systemService = BaseApplication.context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager powerManager = (PowerManager) systemService;
        if (isOn) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870918, f.class.getSimpleName());
            wakeLock = newWakeLock;
            if (newWakeLock != null) {
                newWakeLock.acquire();
                return;
            }
            return;
        }
        PowerManager.WakeLock wakeLock2 = wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
        wakeLock = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        isAccess = false;
        requestId = null;
        requestInfo = null;
        isRequestApplyBackground = false;
        cancelRequestType = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(Activity activity, int errorCode) {
        int i3;
        int i16;
        QQCustomDialog qQCustomDialog = new QQCustomDialog(activity);
        Window window = qQCustomDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Window window2 = qQCustomDialog.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        if (errorCode == 20003) {
            i3 = R.string.zrt;
        } else {
            i3 = R.string.zrv;
        }
        qQCustomDialog.setTitle(i3);
        if (errorCode == 70001) {
            i16 = R.string.f172572qt;
        } else {
            i16 = R.string.zru;
        }
        qQCustomDialog.setMessage(i16);
        qQCustomDialog.setPositiveButton(R.string.f1380608j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.impl.global.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i17) {
                f.N(dialogInterface, i17);
            }
        });
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(Context context, String tips) {
        Intent A = A(this, context, "/wifi_photo/request_apply", 0, 0, 12, null);
        A.putExtra(RequestApplyFragment.NEED_REPORT_KEY, true);
        PendingIntent activity = PendingIntent.getActivity(context, 0, A, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(context, 0, \u2026tent.FLAG_UPDATE_CURRENT)");
        NotificationCompat.Builder when = new NotificationCompat.Builder(context, QQNotificationManager.CHANNEL_ID_OTHER).setContentText(tips).setSmallIcon(R.drawable.b8g).setContentIntent(activity).setAutoCancel(true).setOngoing(false).setVibrate(new long[0]).setWhen(System.currentTimeMillis());
        Intrinsics.checkNotNullExpressionValue(when, "Builder(context, Notific\u2026stem.currentTimeMillis())");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(265, when.build());
        QLog.i("QWifiPhotoService", 1, "show wifi photo notification in background..");
    }

    public static /* synthetic */ void e(f fVar, AuthorizationStatus authorizationStatus, int i3, IOperateCallback iOperateCallback, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        fVar.d(authorizationStatus, i3, iOperateCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(IOperateCallback cb5, int i3, String str) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("QWifiPhotoService", 1, "acceptRequest result: " + i3);
        if (i3 == 0) {
            isAccess = true;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.impl.global.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.g();
                }
            });
        }
        cb5.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        f317624a.H(true);
    }

    private final Intent z(Context context, String page, int source, int errorCode) {
        Intent intent = new Intent(context, (Class<?>) WifiPhotoActivity.class);
        if (isAccess) {
            page = "/wifi_photo/request_apply";
        }
        intent.putExtra("FRAGMENT_INDEX", page);
        intent.addFlags(536870912);
        intent.putExtra("SOURCE_KEY", source);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (requestId != null && requestInfo != null) {
            Integer num = requestId;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            WiFiPhotoRequestInfo wiFiPhotoRequestInfo = requestInfo;
            Intrinsics.checkNotNull(wiFiPhotoRequestInfo);
            String str = wiFiPhotoRequestInfo.clientLoginLocation;
            Intrinsics.checkNotNullExpressionValue(str, "requestInfo!!.clientLoginLocation");
            WiFiPhotoRequestInfo wiFiPhotoRequestInfo2 = requestInfo;
            Intrinsics.checkNotNull(wiFiPhotoRequestInfo2);
            String str2 = wiFiPhotoRequestInfo2.clientDeviceName;
            Intrinsics.checkNotNullExpressionValue(str2, "requestInfo!!.clientDeviceName");
            intent.putExtra(RequestApplyFragment.INFO_KEY, new WifiPhotoInfo(intValue, str, str2));
        } else {
            intent.putExtra(RequestApplyFragment.ERROR_CODE, errorCode);
            intent.putExtra(RequestApplyFragment.INFO_KEY, (Parcelable) null);
        }
        return intent;
    }

    public final void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Integer num = requestId;
        if (num != null) {
            num.intValue();
            ah ahVar = service;
            if (ahVar != null) {
                ahVar.disconnect(10003);
            }
        }
        H(false);
        K();
    }

    public final void C(@NotNull Context context, @NotNull String page, int source, int errorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, page, Integer.valueOf(source), Integer.valueOf(errorCode));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(page, "page");
        context.startActivity(z(context, page, source, errorCode));
    }

    public final int E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return cancelRequestType;
    }

    public final int F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (requestId != null && requestInfo != null) {
            if (isAccess) {
                return 2;
            }
            return 1;
        }
        return 3;
    }

    public final void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("QWifiPhotoService", 1, "init wifi photo...");
        isBackgroundDisconnect = false;
        backgroundDisconnectErrorCode = -1;
        ah wifiPhotoHostService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getWifiPhotoHostService();
        service = wifiPhotoHostService;
        if (wifiPhotoHostService != null) {
            wifiPhotoHostService.addKernelWiFiPhotoHostListener(wiFiPhotoHostListener);
        }
        ah ahVar = service;
        if (ahVar != null) {
            ahVar.setAlbumAccessDelegate(new com.tencent.mobileqq.wifiphoto.impl.album.f());
        }
        if (guardManagerCallback == null) {
            guardManagerCallback = new a();
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null) {
                guardManager.registerCallBack(guardManagerCallback);
            }
        }
    }

    public final void I(@NotNull IKernelWiFiPhotoPreCheckCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ah ahVar = service;
        if (ahVar != null) {
            ahVar.C0(cb5);
        }
    }

    public final void J(int reason, @NotNull IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, reason, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Integer num = requestId;
        if (num != null) {
            int intValue = num.intValue();
            ah ahVar = service;
            if (ahVar != null) {
                ahVar.rejectRequest(intValue, reason, cb5);
            }
        }
    }

    public final void L(@NotNull IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ah ahVar = service;
        if (ahVar != null) {
            ahVar.requestVisitLocalAlbum(cb5);
        }
    }

    public final void d(@NotNull AuthorizationStatus authorizationStatus, int source, @NotNull final IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, authorizationStatus, Integer.valueOf(source), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(authorizationStatus, "authorizationStatus");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Integer num = requestId;
        if (num != null) {
            int intValue = num.intValue();
            WiFiPhotoAuthorizationInfo wiFiPhotoAuthorizationInfo = new WiFiPhotoAuthorizationInfo();
            wiFiPhotoAuthorizationInfo.deviceName = Build.BRAND + "-" + DeviceInfoMonitor.getModel() + "\u7684\u76f8\u518c";
            wiFiPhotoAuthorizationInfo.authorizationStatus = authorizationStatus;
            if (source != 0) {
                wiFiPhotoAuthorizationInfo.userData = "{ \"source\": \"" + source + "\" }";
            }
            ah ahVar = service;
            if (ahVar != null) {
                ahVar.acceptRequest(intValue, wiFiPhotoAuthorizationInfo, new IOperateCallback() { // from class: com.tencent.mobileqq.wifiphoto.impl.global.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        f.f(IOperateCallback.this, i3, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(DialogInterface dialogInterface, int i3) {
    }
}
