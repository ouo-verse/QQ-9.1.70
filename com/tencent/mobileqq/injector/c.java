package com.tencent.mobileqq.injector;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.api.transfile.IGuildTransFileApi;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MSFSharedPreUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qqnt.kernel.nativeinterface.DeviceInfo;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.OnLineBusinessInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/injector/c;", "Ldx3/a;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", "wrapperSession", "", "a", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/DeviceInfo;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/OnLineBusinessInfo;", "b", "", "uin", "", "c", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c implements dx3.a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(IQQNTWrapperSession wrapperSession, String str, String str2) {
        Intrinsics.checkNotNullParameter(wrapperSession, "$wrapperSession");
        wrapperSession.setQimei36(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        ((IGuildTransFileApi) QRoute.api(IGuildTransFileApi.class)).getBigDataTicket();
    }

    @Override // dx3.a
    public void a(@NotNull AppRuntime app, @NotNull final IQQNTWrapperSession wrapperSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) app, (Object) wrapperSession);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(wrapperSession, "wrapperSession");
        com.tencent.mobileqq.statistics.o.d(new o.c() { // from class: com.tencent.mobileqq.injector.a
            @Override // com.tencent.mobileqq.statistics.o.c
            public final void a(String str, String str2) {
                c.h(IQQNTWrapperSession.this, str, str2);
            }
        });
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.injector.b
            @Override // java.lang.Runnable
            public final void run() {
                c.i();
            }
        }, 16, null, false);
    }

    @Override // dx3.a
    @NotNull
    public OnLineBusinessInfo b(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (OnLineBusinessInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) app);
        }
        Intrinsics.checkNotNullParameter(app, "app");
        int i3 = !SettingCloneUtil.readValue((Context) MobileQQ.sMobileQQ, app.getCurrentAccountUin(), AppConstants.Preferences.LOGIN_ACCOUNTS, AppConstants.QQSETTING_BOTHONLINE_KEY, true) ? 1 : 0;
        IRuntimeService runtimeService = app.getRuntimeService(ISubAccountService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IS\u2026ssConstant.MAIN\n        )");
        boolean notifySwitch = ((ISubAccountService) runtimeService).getNotifySwitch();
        boolean readValue = SettingCloneUtil.readValue((Context) MobileQQ.sMobileQQ, app.getCurrentUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
        return new OnLineBusinessInfo(i3, readValue ? 1 : 0, notifySwitch ? 1 : 0);
    }

    @Override // dx3.a
    @NotNull
    public List<String> c(@NotNull String uin, @NotNull AppRuntime app) {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) uin, (Object) app);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(app, "app");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"", "", ""});
        return listOf;
    }

    @Override // dx3.a
    public boolean d(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) app)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(app, "app");
        if (app.getCurAccLoginType() != 5) {
            return true;
        }
        return false;
    }

    @Override // dx3.a
    @NotNull
    public DeviceInfo e(@NotNull AppRuntime app) {
        String str;
        String str2 = "";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DeviceInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) app);
        }
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.i("AccountModuleInjector", 1, "ntOnline, Runtime: " + this);
        int i3 = 0;
        boolean readValue = SettingCloneUtil.readValue((Context) BaseApplication.context, app.getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_QRLOGIN_SET_MUTE, false);
        String guid = MSFSharedPreUtils.getGuid();
        if (TextUtils.isEmpty(guid)) {
            guid = HexUtil.bytes2HexStr(((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).getGUID());
        }
        String str3 = guid;
        try {
            str = ROMUtil.getRomName();
        } catch (Throwable unused) {
            str = "";
        }
        try {
            str2 = ROMUtil.getRomVersion();
        } catch (Throwable unused2) {
        }
        String str4 = str2;
        try {
            i3 = BaseApplication.getContext().getThirdPushType();
        } catch (Throwable unused3) {
        }
        return new DeviceInfo(str3, AppSetting.f99542b, AppActivity.localeId, Build.BRAND + "-" + DeviceInfoMonitor.getModel(), Build.DEVICE, str, Build.VERSION.RELEASE, str4, readValue, i3);
    }
}
