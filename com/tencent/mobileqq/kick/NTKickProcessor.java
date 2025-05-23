package com.tencent.mobileqq.kick;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKickApi;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0002J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002J\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/kick/NTKickProcessor;", "Lcom/tencent/qqnt/kernel/api/IKickApi$b;", "Lcom/tencent/qqnt/kernel/nativeinterface/KickedInfo;", "kickedInfo", "", "d", "Lmqq/app/AppRuntime;", "appRuntime", "", "g", "info", "e", "Lmqq/app/Constants$LogoutReason;", "reason", "j", "Lkotlin/Function0;", "task", h.F, "a", "<init>", "()V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NTKickProcessor implements IKickApi.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/kick/NTKickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kick.NTKickProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17980);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTKickProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean d(KickedInfo kickedInfo) {
        KickedType kickedType = kickedInfo.kickedType;
        if (kickedInfo.securityKickedType == 0 && kickedType == KickedType.KKICKBYMULTIINST) {
            return false;
        }
        return true;
    }

    private final void e(final AppRuntime appRuntime, KickedInfo info) {
        QLog.d("NTKickProcessor", 1, "kicked.....onKicked:isTokenExpired start");
        final MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kick.a
            @Override // java.lang.Runnable
            public final void run() {
                NTKickProcessor.f(AppRuntime.this, mobileQQ);
            }
        }, 16, null, true);
        MsfSdkUtils.updateSimpleAccount(appRuntime.getCurrentUin(), false);
        mobileQQ.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        j(appRuntime, info, Constants.LogoutReason.kicked);
        QLog.d("NTKickProcessor", 1, "kicked.....onKicked:isTokenExpired end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AppRuntime appRuntime, MobileQQ mobileQQ) {
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        if (MobileQQ.sProcessId == 1) {
            NewIntent newIntent = new NewIntent(mobileQQ.getApplicationContext(), BuiltInServlet.class);
            newIntent.putExtra("action", 2218);
            newIntent.putExtra("uin", appRuntime.getCurrentUin());
            newIntent.putExtra(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_CMD, "onKicked");
            newIntent.putExtra(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_PARAM, appRuntime.getCurrentUin());
            appRuntime.startServlet(newIntent);
            QLog.d("mqq", 1, "kicked ... send to msf");
        }
    }

    private final void g(AppRuntime appRuntime, KickedInfo kickedInfo) {
        QLog.d("NTKickProcessor", 1, "kicked.....onKicked:kickOnly start");
        appRuntime.setAutoLogin(false);
        k(this, appRuntime, kickedInfo, null, 4, null);
        QLog.d("NTKickProcessor", 1, "kicked.....onKicked:kickOnly end");
    }

    private final void h(final Function0<Unit> task) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            task.invoke();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.kick.b
                @Override // java.lang.Runnable
                public final void run() {
                    NTKickProcessor.i(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        task.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, android.content.Intent] */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, android.content.Intent] */
    private final void j(AppRuntime appRuntime, KickedInfo kickedInfo, Constants.LogoutReason reason) {
        if (appRuntime.isLogin()) {
            appRuntime.ntTriggerLogout(Constants.LogoutReason.kicked);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? intent = new Intent(BaseApplication.getContext(), (Class<?>) NotificationActivity.class);
        objectRef.element = intent;
        intent.setAction(NewIntent.ACTION_ACCOUNT_KICKED);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("kick_to_login_page", true);
        QLog.d("NTKickProcessor", 1, "showNotification kick to login page: " + isSwitchOn);
        if (isSwitchOn) {
            ?? intent2 = new Intent();
            objectRef.element = intent2;
            intent2.setAction(NewIntent.ACTION_KICK_TO_LOGIN);
            ((Intent) objectRef.element).putExtra("login_page_action", NewIntent.ACTION_ACCOUNT_KICKED);
        }
        ((Intent) objectRef.element).setPackage(MobileQQ.sMobileQQ.getPackageName());
        ((Intent) objectRef.element).putExtra("reason", reason);
        ((Intent) objectRef.element).putExtra("title", kickedInfo.tipsTitle);
        ((Intent) objectRef.element).putExtra("msg", kickedInfo.tipsDesc);
        ((Intent) objectRef.element).putExtra("isSameDevice", kickedInfo.sameDevice);
        ((Intent) objectRef.element).addFlags(268435456);
        if (!appRuntime.isClearTaskBySystem && (!kickedInfo.sameDevice || !appRuntime.isBackgroundStop)) {
            boolean onReceiveUnhandledKickedMsg = appRuntime.onReceiveUnhandledKickedMsg(NewIntent.ACTION_ACCOUNT_KICKED, (Intent) objectRef.element);
            if (!onReceiveUnhandledKickedMsg) {
                h(new Function0<Unit>(objectRef) { // from class: com.tencent.mobileqq.kick.NTKickProcessor$showNotification$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Ref.ObjectRef<Intent> $notifyIntent;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$notifyIntent = objectRef;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            MobileQQ.sMobileQQ.startActivity(this.$notifyIntent.element);
                            QLog.d("NTKickProcessor", 1, "kicked start notification......");
                        }
                    }
                });
            }
            QLog.d("NTKickProcessor", 1, "kicked start notification...... handle: ", Boolean.valueOf(onReceiveUnhandledKickedMsg));
            return;
        }
        QLog.d("NTKickProcessor", 1, "kicked samedevice and set kickIntent");
        QLog.d("NTKickProcessor", 1, "isClearTaskBySystem=" + appRuntime.isClearTaskBySystem + " sameDevice=" + kickedInfo.sameDevice + " isBackgroundStop={appRuntime.isBackgroundStop}");
        appRuntime.setKickIntent((Intent) objectRef.element);
    }

    static /* synthetic */ void k(NTKickProcessor nTKickProcessor, AppRuntime appRuntime, KickedInfo kickedInfo, Constants.LogoutReason logoutReason, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            logoutReason = Constants.LogoutReason.forceLogout;
        }
        nTKickProcessor.j(appRuntime, kickedInfo, logoutReason);
    }

    @Override // com.tencent.qqnt.kernel.api.IKickApi.b
    public void a(@NotNull AppRuntime appRuntime, @Nullable KickedInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        QLog.d("NTKickProcessor", 1, "KickNT", ", AppRuntime: ", appRuntime);
        if (info == null) {
            QLog.d("NTKickProcessor", 1, "KickNT info is null");
        } else if (d(info)) {
            e(appRuntime, info);
        } else {
            g(appRuntime, info);
        }
    }
}
