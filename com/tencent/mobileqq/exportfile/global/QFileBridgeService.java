package com.tencent.mobileqq.exportfile.global;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.PowerManager;
import android.view.Window;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.exportfile.fragment.BaseExportFileFragment;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeAuthenticationType;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeClientState;
import com.tencent.qqnt.kernel.nativeinterface.PlatformType;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoConnectionType;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b5\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001k\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bn\u0010oJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0015H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015H\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0018J\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015H\u0000\u00a2\u0006\u0004\b\u001d\u0010\u0018J\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0015H\u0000\u00a2\u0006\u0004\b\u001f\u0010\u0018J\u001a\u0010\"\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040 J\u001a\u0010#\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040 J+\u0010(\u001a\u00020\u00042#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00040 J+\u0010)\u001a\u00020\u00042#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00040 J\u0006\u0010*\u001a\u00020\u0002J\b\u0010,\u001a\u0004\u0018\u00010+J\u0006\u0010-\u001a\u00020\bJ\b\u0010/\u001a\u0004\u0018\u00010.J\u0006\u00101\u001a\u000200J\u000e\u00102\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u00103\u001a\u00020\rJ\u0006\u00104\u001a\u00020\u0004J\u000f\u00105\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R(\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040 0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R(\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040 0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R(\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040 0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R(\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040 0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010<R(\u0010E\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040 0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010<R(\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040 0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010<R9\u0010I\u001a%\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00040 0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010<R\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010V\u001a\b\u0018\u00010RR\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\"\u0010`\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010d\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010[\u001a\u0004\bb\u0010]\"\u0004\bc\u0010_R\u0016\u0010f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010[R\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010!\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010m\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/exportfile/global/QFileBridgeService;", "", "", "isOn", "", "J", "Landroid/content/Context;", "context", "", "tips", "T", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "errorCode", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "G", "K", "Lcom/tencent/qqnt/kernel/api/p;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/qqnt/kernel/api/p;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/exportfile/global/p;", "t", "()Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/exportfile/global/q;", "u", "Lcom/tencent/mobileqq/exportfile/global/o;", ReportConstant.COSTREPORT_PREFIX, "w", "Lcom/tencent/mobileqq/exportfile/global/r;", "v", "Lkotlin/Function1;", "listener", "M", "W", "Lcom/tencent/qqnt/kernel/nativeinterface/WiFiPhotoConnectionType;", "Lkotlin/ParameterName;", "name", "connType", "L", "V", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeClientState;", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/nativeinterface/PlatformType;", "D", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeAuthenticationType;", "E", HippyTKDListViewAdapter.X, UserInfo.SEX_FEMALE, "N", "I", "()Ljava/lang/Boolean;", "b", "Lcom/tencent/qqnt/kernel/api/p;", "service", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onDownloadProgressListenerList", "d", "onDownloadSpeedListenerList", "e", "onDownloadFinishListenerList", "f", "onDownloadStateChangeListenerList", "g", "onDownloadThumbnailFinishListenerList", tl.h.F, "onDisconnectListener", "i", "connectListener", "Lmqq/app/IAccountCallback;", "j", "Lmqq/app/IAccountCallback;", "accountCB", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "k", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "guardManagerCallback", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "l", "Landroid/os/PowerManager$WakeLock;", "wakeLock", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeAuthenticationType;", TangramHippyConstants.LOGIN_TYPE, DomainData.DOMAIN_NAME, "Z", BdhLogUtil.LogTag.Tag_Conn, "()Z", "P", "(Z)V", "hasShowMobileNet", "o", "B", "O", "hasCheckUncompletedRecords", "p", "isBackgroundDisconnect", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/Runnable;", "timeoutDisconnectTask", "com/tencent/mobileqq/exportfile/global/QFileBridgeService$listener$1", "r", "Lcom/tencent/mobileqq/exportfile/global/QFileBridgeService$listener$1;", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QFileBridgeService {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFileBridgeService f205517a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.qqnt.kernel.api.p service;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<Function1<p, Unit>> onDownloadProgressListenerList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<Function1<q, Unit>> onDownloadSpeedListenerList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<Function1<o, Unit>> onDownloadFinishListenerList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<Function1<r, Unit>> onDownloadStateChangeListenerList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<Function1<o, Unit>> onDownloadThumbnailFinishListenerList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<Function1<Integer, Unit>> onDisconnectListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<Function1<WiFiPhotoConnectionType, Unit>> connectListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IAccountCallback accountCB;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IGuardInterface guardManagerCallback;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static PowerManager.WakeLock wakeLock;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static FileBridgeAuthenticationType loginType;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static boolean hasShowMobileNet;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static boolean hasCheckUncompletedRecords;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static boolean isBackgroundDisconnect;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable timeoutDisconnectTask;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final QFileBridgeService$listener$1 listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/exportfile/global/QFileBridgeService$a", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements IGuardInterface {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b() {
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                QFileBridgeService.f205517a.Q(topActivity, -1);
                QFileBridgeService.isBackgroundDisconnect = false;
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i("QFileBridgeService", 1, "export file in background");
            QFileBridgeService qFileBridgeService = QFileBridgeService.f205517a;
            if (qFileBridgeService.H()) {
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                qFileBridgeService.T(context, "\u4f60\u7684\u624b\u673a\u6b63\u5728\u8bbf\u95ee\u7535\u8111\uff0c\u8bf7\u4e0d\u8981\u79bb\u5f00QQ");
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QLog.i("QFileBridgeService", 1, "export file in Foreground " + QFileBridgeService.isBackgroundDisconnect);
                if (QFileBridgeService.isBackgroundDisconnect) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.global.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            QFileBridgeService.a.b();
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
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/exportfile/global/QFileBridgeService$b", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IAccountCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) newRuntime);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) newRuntime);
            } else {
                QFileBridgeService.f205517a.N();
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(@Nullable Constants.LogoutReason reason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) reason);
            } else {
                QFileBridgeService.f205517a.N();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24821);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
            return;
        }
        f205517a = new QFileBridgeService();
        onDownloadProgressListenerList = new CopyOnWriteArrayList<>();
        onDownloadSpeedListenerList = new CopyOnWriteArrayList<>();
        onDownloadFinishListenerList = new CopyOnWriteArrayList<>();
        onDownloadStateChangeListenerList = new CopyOnWriteArrayList<>();
        onDownloadThumbnailFinishListenerList = new CopyOnWriteArrayList<>();
        onDisconnectListener = new CopyOnWriteArrayList<>();
        connectListener = new CopyOnWriteArrayList<>();
        loginType = FileBridgeAuthenticationType.KNULL;
        timeoutDisconnectTask = new Runnable() { // from class: com.tencent.mobileqq.exportfile.global.b
            @Override // java.lang.Runnable
            public final void run() {
                QFileBridgeService.U();
            }
        };
        listener = new QFileBridgeService$listener$1();
    }

    QFileBridgeService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(boolean isOn) {
        Object systemService = BaseApplication.context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager powerManager = (PowerManager) systemService;
        if (isOn) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870918, QFileBridgeService.class.getSimpleName());
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
    public final void Q(Activity activity, final int errorCode) {
        int i3;
        HashMap hashMap = new HashMap();
        hashMap.put(CheckForwardServlet.KEY_ERR_CODE, Integer.valueOf(errorCode));
        hashMap.put("dt_pgid", "pg_bas_abnormal_popup");
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        VideoReport.reportEvent("pgin", hashMap);
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
        if (errorCode != 100106) {
            qQCustomDialog.setTitle(R.string.zrv);
        }
        qQCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.exportfile.global.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                QFileBridgeService.R(errorCode, dialogInterface);
            }
        });
        if (errorCode == 100106) {
            i3 = R.string.zwk;
        } else {
            i3 = R.string.zw8;
        }
        qQCustomDialog.setMessage(i3);
        qQCustomDialog.setPositiveButton(R.string.f1380608j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.global.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                QFileBridgeService.S(dialogInterface, i16);
            }
        });
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(int i3, DialogInterface dialogInterface) {
        HashMap hashMap = new HashMap();
        hashMap.put(CheckForwardServlet.KEY_ERR_CODE, Integer.valueOf(i3));
        hashMap.put("dt_pgid", "pg_bas_abnormal_popup");
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        VideoReport.reportEvent("pgout", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(DialogInterface dialogInterface, int i3) {
        SimpleEventBus.getInstance().dispatchEvent(new ExportFileExitEvent());
        BaseApplication.getContext().sendBroadcast(new Intent("SEARCH_FILE_EXIT_EVENT"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(Context context, String tips) {
        Intent intent = new Intent(context, (Class<?>) QPublicFragmentActivity.class);
        intent.putExtra("FRAGMENT_INDEX", "/export_file/browser_file");
        intent.putExtra("public_fragment_class", BaseExportFileFragment.class.getName());
        intent.addFlags(536870912);
        intent.addFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(context, 0, \u2026tent.FLAG_UPDATE_CURRENT)");
        NotificationCompat.Builder when = new NotificationCompat.Builder(context, QQNotificationManager.CHANNEL_ID_OTHER).setContentText(tips).setSmallIcon(R.drawable.b8g).setContentIntent(activity).setAutoCancel(true).setOngoing(false).setVibrate(new long[0]).setWhen(System.currentTimeMillis());
        Intrinsics.checkNotNullExpressionValue(when, "Builder(context, Notific\u2026stem.currentTimeMillis())");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(265, when.build());
        QLog.i("QFileBridgeService", 1, "show wifi photo notification in background..");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U() {
        FileBridgeClientState fileBridgeClientState;
        com.tencent.qqnt.kernel.api.p pVar;
        com.tencent.qqnt.kernel.api.p pVar2 = service;
        if (pVar2 != null) {
            fileBridgeClientState = pVar2.getCurrentStatus();
        } else {
            fileBridgeClientState = null;
        }
        if (fileBridgeClientState == FileBridgeClientState.KCONNECTED && (pVar = service) != null) {
            pVar.disconnect(100106);
        }
    }

    @Nullable
    public final com.tencent.qqnt.kernel.api.p A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.kernel.api.p) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return service;
    }

    public final boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return hasCheckUncompletedRecords;
    }

    public final boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return hasShowMobileNet;
    }

    @Nullable
    public final PlatformType D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (PlatformType) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        com.tencent.qqnt.kernel.api.p pVar = service;
        if (pVar != null) {
            return pVar.getHostSystemType();
        }
        return null;
    }

    @NotNull
    public final FileBridgeAuthenticationType E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (FileBridgeAuthenticationType) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return loginType;
    }

    public final int F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        com.tencent.qqnt.kernel.api.p pVar = service;
        if (pVar != null) {
            return pVar.getMaxAuthenticateWithoutPasswordValidDays();
        }
        return 1;
    }

    public final void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        isBackgroundDisconnect = false;
        com.tencent.qqnt.kernel.api.p fileBridgeService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService();
        service = fileBridgeService;
        if (fileBridgeService != null) {
            fileBridgeService.addKernelFileBridgeClientListener(listener);
        }
        if (guardManagerCallback == null) {
            guardManagerCallback = new a();
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null) {
                guardManager.registerCallBack(guardManagerCallback);
            }
        }
    }

    public final boolean H() {
        FileBridgeClientState fileBridgeClientState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.kernel.api.p pVar = service;
        FileBridgeClientState fileBridgeClientState2 = null;
        if (pVar != null) {
            fileBridgeClientState = pVar.getCurrentStatus();
        } else {
            fileBridgeClientState = null;
        }
        if (fileBridgeClientState != FileBridgeClientState.KCONNECTED) {
            com.tencent.qqnt.kernel.api.p pVar2 = service;
            if (pVar2 != null) {
                fileBridgeClientState2 = pVar2.getCurrentStatus();
            }
            if (fileBridgeClientState2 != FileBridgeClientState.KFILETRANSFERING) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final Boolean I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Boolean) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        com.tencent.qqnt.kernel.api.p pVar = service;
        if (pVar != null) {
            return Boolean.valueOf(pVar.getHostIsSupportSearch());
        }
        return null;
    }

    public final void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (accountCB != null) {
                return;
            }
            accountCB = new b();
            MobileQQ.sMobileQQ.registerAccountCallback(accountCB);
        }
    }

    public final void L(@NotNull Function1<? super WiFiPhotoConnectionType, Unit> listener2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) listener2);
        } else {
            Intrinsics.checkNotNullParameter(listener2, "listener");
            connectListener.add(listener2);
        }
    }

    public final void M(@NotNull Function1<? super Integer, Unit> listener2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) listener2);
        } else {
            Intrinsics.checkNotNullParameter(listener2, "listener");
            onDisconnectListener.add(listener2);
        }
    }

    public final void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        onDownloadProgressListenerList.clear();
        onDownloadSpeedListenerList.clear();
        onDownloadFinishListenerList.clear();
        onDisconnectListener.clear();
        MobileQQ.sMobileQQ.unregisterAccountCallback(accountCB);
        accountCB = null;
    }

    public final void O(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            hasCheckUncompletedRecords = z16;
        }
    }

    public final void P(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            hasShowMobileNet = z16;
        }
    }

    public final void V(@NotNull Function1<? super WiFiPhotoConnectionType, Unit> listener2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) listener2);
        } else {
            Intrinsics.checkNotNullParameter(listener2, "listener");
            connectListener.remove(listener2);
        }
    }

    public final void W(@NotNull Function1<? super Integer, Unit> listener2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) listener2);
        } else {
            Intrinsics.checkNotNullParameter(listener2, "listener");
            onDisconnectListener.remove(listener2);
        }
    }

    @NotNull
    public final Flow<o> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Flow) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return FlowKt.callbackFlow(new QFileBridgeService$createDownloadFinishFlow$1(null));
    }

    @NotNull
    public final Flow<p> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Flow) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return FlowKt.callbackFlow(new QFileBridgeService$createDownloadProgressFlow$1(null));
    }

    @NotNull
    public final Flow<q> u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Flow) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return FlowKt.callbackFlow(new QFileBridgeService$createDownloadSpeedFlow$1(null));
    }

    @NotNull
    public final Flow<r> v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Flow) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return FlowKt.callbackFlow(new QFileBridgeService$createDownloadStateFlow$1(null));
    }

    @NotNull
    public final Flow<o> w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Flow) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return FlowKt.callbackFlow(new QFileBridgeService$createThumbnailDownloadFinishFlow$1(null));
    }

    public final void x(int errorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, errorCode);
            return;
        }
        com.tencent.qqnt.kernel.api.p pVar = service;
        if (pVar != null) {
            pVar.disconnect(errorCode);
        }
    }

    @Nullable
    public final FileBridgeClientState y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (FileBridgeClientState) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        com.tencent.qqnt.kernel.api.p pVar = service;
        if (pVar != null) {
            return pVar.getCurrentStatus();
        }
        return null;
    }

    @NotNull
    public final String z() {
        String deviceName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        com.tencent.qqnt.kernel.api.p pVar = service;
        if (pVar == null || (deviceName = pVar.getDeviceName()) == null) {
            return "";
        }
        return deviceName;
    }
}
