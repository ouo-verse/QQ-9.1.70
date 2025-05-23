package com.tencent.mobileqq.notification.msg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.gamecenter.common.util.l;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.GuardState;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.nt.adapter.session.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.notification.report.a;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J2\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/notification/msg/MsgPushNotificationReceiver;", "Landroid/content/BroadcastReceiver;", "", "b", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "uin", "", "uinType", "uinName", "a", "", "J", "lastReceiveTime", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class MsgPushNotificationReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String[] f254326c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String[] f254327d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long lastReceiveTime;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/notification/msg/MsgPushNotificationReceiver$a;", "", "", "ACTION_MSG_PUSH", "Ljava/lang/String;", "", "ALLOW_PROCESSES", "[Ljava/lang/String;", "ALLOW_TRANSPARENT_PROCESSES", "", "IGNORE_TIME_INTERVAL", "I", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.notification.msg.MsgPushNotificationReceiver$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59363);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        f254326c = new String[]{GuardState.PROCESS_NAME_MINIAPP, "com.tencent.mobileqq:mini2", "com.tencent.mobileqq:mini3", "com.tencent.mobileqq:mini4"};
        f254327d = new String[]{"com.tencent.mobileqq:p00miniboxapp", "com.tencent.mobileqq:p01miniboxapp", "com.tencent.mobileqq:p02miniboxapp"};
    }

    public MsgPushNotificationReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b() {
        ReportController.o(null, "dc00898", "", "", "0X800C397", "0X800C397", 0, 0, "", "", "", "");
    }

    public final void a(@NotNull QQAppInterface app, @NotNull Context context, @Nullable String uin, int uinType, @Nullable String uinName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, app, context, uin, Integer.valueOf(uinType), uinName);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intent aliasIntent = SplashActivity.getAliasIntent(app.getApp());
        aliasIntent.putExtra("uin", uin);
        aliasIntent.putExtra("uintype", uinType);
        aliasIntent.putExtra("uinname", uinName);
        Intent m3 = BaseAIOUtils.m(aliasIntent, new int[]{2});
        m3.setAction("com.tencent.mobileqq.action.CHAT");
        context.startActivity(m3);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        boolean z16;
        String str;
        boolean contains;
        boolean contains2;
        boolean contains3;
        boolean y16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        boolean z17 = false;
        if (mobileQQ != null && mobileQQ.peekAppRuntime() != null) {
            if (!(MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface)) {
                QLog.d("MsgPushNotificationReceiver", 1, "onReceive not qq process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastReceiveTime < 200) {
                QLog.d("MsgPushNotificationReceiver", 1, "onReceive frequency limit");
                return;
            }
            this.lastReceiveTime = currentTimeMillis;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            ForegroundNotifyManager b16 = ForegroundNotifyManager.b(qQAppInterface);
            if (qQAppInterface.isBackgroundStop && b16.t()) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("MsgPushNotificationReceiver", 1, "onReceive app.isBackgroundStop=" + qQAppInterface.isBackgroundStop + ", appBackground=" + z16);
            String stringExtra = intent.getStringExtra("uin");
            int intExtra = intent.getIntExtra("uintype", 0);
            String stringExtra2 = intent.getStringExtra("uinname");
            long longExtra = intent.getLongExtra(AppConstants.Key.MSG_UNISEQ, 0L);
            if (QFileUtils.e(qQAppInterface, stringExtra) && !h.o()) {
                QLog.d("MsgPushNotificationReceiver", 1, "onReceive: get new dataline notify. jump to liteActivity");
                Intent intent2 = new Intent(qQAppInterface.getApp(), (Class<?>) LiteActivity.class);
                intent2.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PC_UIN);
                intent2.addFlags(67108864);
                intent2.putExtras(intent);
                context.startActivity(intent2);
                return;
            }
            if (z16) {
                a(qQAppInterface, context, stringExtra, intExtra, stringExtra2);
                return;
            }
            b();
            l.p(true, new Contact(c.l(intExtra), ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra), ""), stringExtra, longExtra);
            if (ForegroundNotifyManager.b(qQAppInterface).p()) {
                QLog.d("MsgPushNotificationReceiver", 1, "onReceive already on MiniAio");
                return;
            }
            a.f359850a.b(c.l(intExtra));
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null) {
                Map<String, String> realForegroundProcessMap = guardManager.realForegroundProcessMap();
                QLog.d("MsgPushNotificationReceiver", 1, "onReceive foreground process=" + realForegroundProcessMap);
                if (realForegroundProcessMap.size() == 1) {
                    String next = realForegroundProcessMap.keySet().iterator().next();
                    contains2 = ArraysKt___ArraysKt.contains(f254326c, next);
                    if (!contains2) {
                        contains3 = ArraysKt___ArraysKt.contains(f254327d, next);
                        if (contains3) {
                            y16 = com.tencent.mobileqq.activity.miniaio.h.v().y(intent.getExtras());
                        }
                    } else {
                        y16 = com.tencent.mobileqq.activity.miniaio.h.v().y(intent.getExtras());
                    }
                    z17 = y16;
                } else if (realForegroundProcessMap.size() == 2) {
                    for (String str2 : realForegroundProcessMap.keySet()) {
                        contains = ArraysKt___ArraysKt.contains(f254327d, str2);
                        if (contains) {
                            QLog.d("MsgPushNotificationReceiver", 1, "onReceive transparent foreground process=" + str2);
                            z17 = com.tencent.mobileqq.activity.miniaio.h.v().y(intent.getExtras());
                        }
                    }
                }
            }
            if (!z17) {
                Bundle bundle = new Bundle();
                if (ForegroundNotifyManager.k()) {
                    str = "22";
                } else {
                    str = "23";
                }
                bundle.putString("key_from", str);
                bundle.putAll(intent.getExtras());
                MiniChatActivity.I2(bundle);
                return;
            }
            return;
        }
        if (MobileQQ.sMobileQQ == null) {
            z17 = true;
        }
        QLog.d("MsgPushNotificationReceiver", 1, "onReceive sMobileQQ or peekAppRuntime is null. sMobileQQ=" + z17);
    }
}
