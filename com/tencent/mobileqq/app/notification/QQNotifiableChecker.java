package com.tencent.mobileqq.app.notification;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.notification.processor.common.b;
import com.tencent.mobileqq.app.notification.processor.common.c;
import com.tencent.mobileqq.guild.message.notify.api.IGuildNotify;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.pushnotice.ThirdPushManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderMsgService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.az;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.nt.adapter.session.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernel.nativeinterface.MsgStatus;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.inject.ICheckProcessor;
import com.tencent.robot.api.IRobotIdentityApi;
import com.tencent.util.j;
import com.tencent.util.notification.NotificationController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b,\u0010-J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0016J*\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00152\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010&\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010'\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010(\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010)\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010*\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010+\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/app/notification/QQNotifiableChecker;", "Lcom/tencent/qqnt/notification/inject/ICheckProcessor;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "Lcom/tencent/qqnt/notification/trace/a;", "trackerConfig", "", "a", "", "i", h.F, "g", "withPreview", "d", "b", "e", "showNotification", "c", "isAppForeground", "", "uin", "isRobotUin", HippyTKDListViewAdapter.X, "Lcom/tencent/imcore/message/Message;", "message", "w", "v", "t", "r", ReportConstant.COSTREPORT_PREFIX, "u", "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/mobileqq/app/QQAppInterface;", "l", "o", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "y", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QQNotifiableChecker implements ICheckProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<QQNotifiableChecker> f196370b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u001b\u0010\u0011\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/app/notification/QQNotifiableChecker$a;", "", "", "content", "", "f", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "d", "c", "e", "Lcom/tencent/mobileqq/app/notification/QQNotifiableChecker;", "instance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/app/notification/QQNotifiableChecker;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.notification.QQNotifiableChecker$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(String content) {
            QLog.i("Notification.Check", 1, content);
        }

        @NotNull
        public final QQNotifiableChecker b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQNotifiableChecker) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (QQNotifiableChecker) QQNotifiableChecker.f196370b.getValue();
        }

        @JvmStatic
        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null && guardManager.isApplicationForeground()) {
                return false;
            }
            return true;
        }

        @JvmStatic
        public final boolean d(@NotNull QQAppInterface app) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) app)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(app, "app");
            IRuntimeService runtimeService = app.getRuntimeService(IOnlineStatusService.class);
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026tatusService::class.java)");
            if (((IOnlineStatusService) runtimeService).getOnlineStatus() == AppRuntime.Status.dnd) {
                f("Notifiable check, online status is dnd");
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean e(@NotNull QQAppInterface app) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) app)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(app, "app");
            Object systemService = app.getApplicationContext().getSystemService("keyguard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            boolean inKeyguardRestrictedInputMode = ((KeyguardManager) systemService).inKeyguardRestrictedInputMode();
            if (Foreground.isCurrentProcessForeground() && !inKeyguardRestrictedInputMode) {
                return false;
            }
            return true;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<QQNotifiableChecker> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54325);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) QQNotifiableChecker$Companion$instance$2.INSTANCE);
        f196370b = lazy;
    }

    public QQNotifiableChecker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Message k(RecentContactInfo msgRecord) {
        Message message = new Message();
        message.istroop = c.c(msgRecord.chatType);
        message.msgtype = 0;
        message.senderuin = String.valueOf(msgRecord.senderUin);
        message.frienduin = String.valueOf(msgRecord.peerUin);
        message.uniseq = msgRecord.msgId;
        return message;
    }

    private final boolean l(QQAppInterface app, Message message, com.tencent.qqnt.notification.trace.a trackerConfig) {
        boolean z16 = true;
        if (!o(app, message) && !n(app, message)) {
            long j3 = message.uniseq;
            Companion companion = INSTANCE;
            QLog.d("Notification.Check", 1, "[currentDeviceStateNeedNotification], should not notify, msgId=" + j3 + " appBackground=" + companion.c() + " mainProcessBackground=" + companion.e(app));
            z16 = false;
            if (trackerConfig != null) {
                trackerConfig.b(new b.a(false));
            }
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        r3 = r3.get(0).topActivity;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String m(Context context) {
        ComponentName componentName;
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) systemService).getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() == 0 || componentName == null) {
            return null;
        }
        return componentName.getPackageName();
    }

    private final boolean n(QQAppInterface app, Message message) {
        if (!INSTANCE.e(app)) {
            return false;
        }
        boolean p16 = p(app, message);
        QLog.i("Notification.Check", 1, "[currentDeviceStateNeedNotification] main process is background, notify=" + p16);
        return p16;
    }

    private final boolean o(QQAppInterface app, Message message) {
        if (INSTANCE.c()) {
            return false;
        }
        boolean q16 = q(app, message);
        QLog.i("Notification.Check", 1, "[currentDeviceStateNeedNotification] app is foreground, notify=" + q16);
        return q16;
    }

    private final boolean p(QQAppInterface app, Message message) {
        boolean y16 = y(app, message);
        boolean z16 = false;
        boolean shieldNotifyMainBackground = ((IGuildNotify) app.getRuntimeService(IGuildNotify.class)).shieldNotifyMainBackground(message, false);
        if (y16 && !shieldNotifyMainBackground) {
            z16 = true;
        }
        QLog.i("Notification.Check", 1, "[isBackgroundPushEnabled] enabled=" + z16 + ", subProcFgPushEnabled=" + y16 + ", guildShieldNotifyMainBackground=" + shieldNotifyMainBackground);
        return z16;
    }

    private final boolean q(QQAppInterface app, Message message) {
        ForegroundNotifyManager b16 = ForegroundNotifyManager.b(app);
        if (b16 != null && b16.n(message)) {
            return true;
        }
        return false;
    }

    private final boolean r(Message message) {
        int i3 = message.istroop;
        if (i3 != 10014 && i3 != 10022) {
            return false;
        }
        return true;
    }

    private final boolean s(Message message) {
        if (message.istroop == 10022) {
            return true;
        }
        return false;
    }

    private final boolean t(Message message) {
        int i3 = message.msgtype;
        if (i3 != -1013 && i3 != -2030 && i3 != -1047 && i3 != -1019 && i3 != -1018) {
            return false;
        }
        return true;
    }

    private final boolean u(Message message) {
        if (Utils.G(message.frienduin)) {
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            String m3 = m(context);
            if (Intrinsics.areEqual(context.getPackageName(), m3)) {
                INSTANCE.f("Notifiable check, BabyQ package: " + m3);
                return true;
            }
            return false;
        }
        return false;
    }

    private final boolean v(RecentContactInfo msgRecord, Message message, com.tencent.qqnt.notification.trace.a trackerConfig) {
        if (t(message)) {
            QLog.i("Notification.Check", 1, "[needSoundWhenNoNotification] isNoSoundMessageType, msgId=" + msgRecord.msgId);
            if (trackerConfig != null) {
                trackerConfig.a(new c.a(message.msgtype));
            }
            return false;
        }
        if (r(message)) {
            QLog.i("Notification.Check", 1, "[needSoundWhenNoNotification] isNoNeedSoundWhenNoNotification, msgId=" + msgRecord.msgId);
            if (trackerConfig != null) {
                trackerConfig.a(c.b.f196399a);
            }
            return false;
        }
        if (!x(msgRecord)) {
            return true;
        }
        QLog.i("Notification.Check", 1, "[needSoundAndVibrate] in same aio, no need to play sound and vibrate");
        return false;
    }

    private final boolean w(RecentContactInfo msgRecord, Message message, com.tencent.qqnt.notification.trace.a trackerConfig) {
        if (!s(message)) {
            return true;
        }
        QLog.i("Notification.Check", 1, "[needSoundWhenNotificationShow] isNoNeedSoundWhenNotificationShow, msgId=" + msgRecord.msgId);
        if (trackerConfig != null) {
            trackerConfig.a(c.b.f196399a);
            return false;
        }
        return false;
    }

    private final boolean x(RecentContactInfo msgRecord) {
        if (msgRecord.chatType == 119) {
            QQNearbyModule.Companion companion = QQNearbyModule.INSTANCE;
            boolean f16 = companion.f();
            boolean isAppForeground = isAppForeground();
            if (QLog.isColorLevel()) {
                QLog.d("Notification.Check", 1, "[shouldSkipSoundAndVibrate] nearby new message: isInNearby=" + f16 + ", isAppForeground=" + isAppForeground);
            }
            if (!companion.f() && isAppForeground()) {
                return true;
            }
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_mute_msg_ring_in_same_aio_9030", true) && ForegroundNotifyManager.l(msgRecord.chatType, msgRecord.peerUid)) {
            return true;
        }
        return false;
    }

    private final boolean y(QQAppInterface app, Message message) {
        ForegroundNotifyManager b16 = ForegroundNotifyManager.b(app);
        if (b16 == null || b16.t()) {
            return true;
        }
        if (b16.C(message.istroop) && b16.B(message.frienduin)) {
            QLog.d("Notification.Check", 1, "subProcFgPushEnabled: invoked. isSubProcessBackgroundStop: false");
            return b16.D();
        }
        return false;
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public boolean a(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, @Nullable com.tencent.qqnt.notification.trace.a trackerConfig) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, app, msgRecord, trackerConfig)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        QQAppInterface qQAppInterface = (QQAppInterface) app;
        Message k3 = k(msgRecord);
        int i3 = msgRecord.chatType;
        Boolean bool = null;
        m mVar = null;
        if ((i3 == 109 || i3 == 104) && ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).isNeedForbidNotification()) {
            INSTANCE.f("Notifiable check, matchfriendnotification is hidden");
            if (trackerConfig != null) {
                if (msgRecord.chatType == 104) {
                    bool = Boolean.valueOf(((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).isNeedForbidNotification());
                }
                trackerConfig.b(new b.f(msgRecord.chatType, bool));
            }
            return false;
        }
        int i16 = msgRecord.chatType;
        if (i16 == 106 || i16 == 107 || i16 == 108) {
            INSTANCE.f("Notifiable check, nearby notification is hidden");
            if (trackerConfig != null) {
                trackerConfig.b(new b.g(msgRecord.chatType));
            }
            return false;
        }
        if (i16 == 105) {
            IRuntimeService runtimeService = app.getRuntimeService(IGameMsgBoxManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
            if (((IGameMsgBoxManager) runtimeService).shouldForbidNotification(app, msgRecord)) {
                INSTANCE.f("Notifiable check, gamenotification is hidden");
                if (trackerConfig != null) {
                    trackerConfig.b(new b.c(msgRecord.chatType));
                }
                return false;
            }
        }
        String str = k3.frienduin;
        Intrinsics.checkNotNullExpressionValue(str, "message.frienduin");
        if (com.tencent.mobileqq.app.nthiddenchat.b.h(str, k3.istroop, (AppInterface) app)) {
            INSTANCE.f("Notifiable check, isHiddenChat");
            if (trackerConfig != null) {
                trackerConfig.b(b.e.f196386a);
            }
            return false;
        }
        if (UserguideActivity.G2(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin())) {
            INSTANCE.f("Notifiable check, showUserGuide");
            if (trackerConfig != null) {
                trackerConfig.b(b.d.f196385a);
            }
            return false;
        }
        if (((INewFriendApi) QRoute.api(INewFriendApi.class)).isSuspiciousSysMsg(k3)) {
            INSTANCE.f("Notifiable check, isSuspiciousSysMsg");
            if (trackerConfig != null) {
                trackerConfig.b(b.m.f196395a);
            }
            return false;
        }
        if (u(k3)) {
            if (trackerConfig != null) {
                trackerConfig.b(b.n.f196396a);
            }
            return false;
        }
        Companion companion = INSTANCE;
        if (companion.d(qQAppInterface)) {
            if (trackerConfig != null) {
                trackerConfig.b(b.C7387b.f196383a);
            }
            return false;
        }
        IKernelService iKernelService = (IKernelService) app.getRuntimeService(IKernelService.class, "");
        if (iKernelService != null) {
            mVar = iKernelService.getBuddyService();
        }
        if (mVar != null && msgRecord.chatType == 1) {
            String str2 = msgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.peerUid");
            Boolean isBuddy = mVar.isBuddy(str2);
            if (isBuddy != null) {
                z16 = isBuddy.booleanValue();
            } else {
                z16 = false;
            }
            if (!z16) {
                companion.f("Notifiable check, isOneWayMessage");
                if (trackerConfig != null) {
                    trackerConfig.b(b.j.f196392a);
                }
                return false;
            }
        }
        ArrayList<RecentContactExtAttr> arrayList = msgRecord.extAttrs;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                MsgStatus msgStatus = ((RecentContactExtAttr) it.next()).msgStatus;
                if (msgStatus != null) {
                    Intrinsics.checkNotNullExpressionValue(msgStatus, "msgStatus");
                    if (msgStatus.getMsgPushStatus() != 0) {
                        INSTANCE.f("Notifiable check, isStreamMsg");
                        return false;
                    }
                }
            }
        }
        if (msgRecord.chatType == 113) {
            INSTANCE.f("Notifiable check, qcircle chat is hidden");
            if (trackerConfig != null) {
                trackerConfig.b(b.l.f196394a);
            }
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public void b() {
        IQQReminderMsgService iQQReminderMsgService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iQQReminderMsgService = (IQQReminderMsgService) peekAppRuntime.getRuntimeService(IQQReminderMsgService.class, ProcessConstant.MULTI)) != null) {
            iQQReminderMsgService.onSystemNotificationShow();
        }
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public boolean c(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, boolean showNotification, @Nullable com.tencent.qqnt.notification.trace.a trackerConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, app, msgRecord, Boolean.valueOf(showNotification), trackerConfig)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Message k3 = k(msgRecord);
        if (showNotification) {
            return w(msgRecord, k3, trackerConfig);
        }
        return v(msgRecord, k3, trackerConfig);
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public boolean d(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, boolean withPreview, @Nullable com.tencent.qqnt.notification.trace.a trackerConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, app, msgRecord, Boolean.valueOf(withPreview), trackerConfig)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        QQAppInterface qQAppInterface = (QQAppInterface) app;
        Message k3 = k(msgRecord);
        if (withPreview) {
            BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.util.notification.NotificationController");
            if (!((NotificationController) businessHandler).shouldNotify(k3.frienduin, k3.istroop)) {
                if (trackerConfig != null) {
                    trackerConfig.b(b.o.f196397a);
                }
                return false;
            }
        }
        AppInterface appInterface = (AppInterface) app;
        if (!az.a(qQAppInterface.getApp().getApplicationContext(), appInterface)) {
            INSTANCE.f("Notifiable check, global dnd");
            if (trackerConfig != null) {
                trackerConfig.b(b.i.f196391a);
            }
            return false;
        }
        if (!com.tencent.mobileqq.message.newmsg.a.d(qQAppInterface).l(k3)) {
            INSTANCE.f("Notifiable check, newMsgNotification disable");
            if (trackerConfig != null) {
                trackerConfig.b(b.h.f196390a);
            }
            return false;
        }
        if (az.c(qQAppInterface.getApp().getApplicationContext(), appInterface)) {
            INSTANCE.f("Notifiable check, is mute");
            if (trackerConfig != null) {
                trackerConfig.b(b.k.f196393a);
            }
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public void e(@NotNull AppRuntime app, boolean withPreview) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, app, Boolean.valueOf(withPreview));
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        if (withPreview) {
            ThirdPushManager.getInstance().clearNotificationsBackground(app.getApplicationContext());
        }
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public boolean f(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo recentContactInfo, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, appRuntime, recentContactInfo, aVar)).booleanValue();
        }
        return ICheckProcessor.DefaultImpls.c(this, appRuntime, recentContactInfo, aVar);
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public void g(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) app, (Object) msgRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Message k3 = k(msgRecord);
        j.a((QQAppInterface) app, k3.istroop, k3.msgUid);
        OpenApiManager.getInstance().onReceiveNewMsg(k3);
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public boolean h(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, @Nullable com.tencent.qqnt.notification.trace.a trackerConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, app, msgRecord, trackerConfig)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return l((QQAppInterface) app, k(msgRecord), trackerConfig);
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public void i(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) app, (Object) msgRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ((QQAppInterface) app).messageNotifiableChecker.C();
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public boolean isAppForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return !INSTANCE.c();
    }

    @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
    public boolean isRobotUin(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) uin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(uin);
    }
}
