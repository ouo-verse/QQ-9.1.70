package com.tencent.mobileqq.injector;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.msf.core.auth.api.UIDFileUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGetLoginRecordFromWTCallback;
import com.tencent.qqnt.kernel.nativeinterface.WTLoginRecord;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.WTLoginRecordSnapshot;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/injector/p;", "Ldx3/d;", "", "a", "", "uin", "", "appid", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetLoginRecordFromWTCallback;", "cb", "", "getWTLoginRecord", "deleteWTLoginRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/WTLoginRecord;", "loginRecord", "addWTLoginRecordFromNT", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class p implements dx3.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/injector/p$a;", "", "", "EVENT_WT_SIG_TRANSFORM", "Ljava/lang/String;", "KEY_APPID", "KEY_CHECK_STATE", "KEY_RESULT", "MMKV_KEY", "TAG", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.injector.p$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/injector/p$b", "Lcom/tencent/mobileqq/loginregister/servlet/h;", "", "userAccount", "", "ret", "Loicq/wlogin_sdk/tools/ErrMsg;", NotificationActivity.KEY_LAST_ERROR, "", "D", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WTLoginRecord f238080d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f238081e;

        b(WTLoginRecord wTLoginRecord, int i3) {
            this.f238080d = wTLoginRecord;
            this.f238081e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) wTLoginRecord, i3);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void D(@Nullable String userAccount, int ret, @Nullable ErrMsg lastError) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, userAccount, Integer.valueOf(ret), lastError);
                return;
            }
            super.D(userAccount, ret, lastError);
            QLog.d("KernelLoginInjector", 1, "addWTLoginRecordFromNT onTransformNtSig : userAccount=" + userAccount + ", ret=" + ret + ", lastError=" + lastError);
            HashMap hashMap = new HashMap();
            hashMap.put("appid", String.valueOf(this.f238080d.appid));
            hashMap.put("result", String.valueOf(ret));
            hashMap.put("check_state", String.valueOf(this.f238081e));
            com.tencent.mobileqq.inject.v.c(String.valueOf(this.f238080d.uin), "event_wt_sig_transform", hashMap);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25356);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // dx3.d
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MobileQQ.sMobileQQ.isLoginByNT();
    }

    @Override // dx3.d
    public void addWTLoginRecordFromNT(@NotNull WTLoginRecord loginRecord) {
        TicketManager ticketManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) loginRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(loginRecord, "loginRecord");
        QLog.d("KernelLoginInjector", 1, "addWTLoginRecordFromNT, uin is " + loginRecord.uin + ", appid is " + loginRecord.appid);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (ticketManager = (TicketManager) peekAppRuntime.getManager(2)) == null) {
            return;
        }
        WTLoginRecordSnapshot wTLoginRecordSnapshot = new WTLoginRecordSnapshot();
        wTLoginRecordSnapshot.uin = loginRecord.uin;
        wTLoginRecordSnapshot.appid = loginRecord.appid;
        wTLoginRecordSnapshot.a1Key = loginRecord.a1Key;
        wTLoginRecordSnapshot.f422864a1 = loginRecord.f359236a1;
        wTLoginRecordSnapshot.noPicSig = loginRecord.noPicSig;
        wTLoginRecordSnapshot.a2GenerateTime = loginRecord.a2GenerateTime;
        wTLoginRecordSnapshot.f422866d2 = loginRecord.f359238d2;
        wTLoginRecordSnapshot.d2Key = loginRecord.d2Key;
        wTLoginRecordSnapshot.account = loginRecord.account;
        wTLoginRecordSnapshot.f422865a2 = loginRecord.f359237a2;
        wTLoginRecordSnapshot.a2Key = loginRecord.a2Key;
        wTLoginRecordSnapshot.expireTime = loginRecord.expireTime;
        int addWTLoginRecordFromNT = ticketManager.addWTLoginRecordFromNT(wTLoginRecordSnapshot);
        QLog.d("KernelLoginInjector", 1, "addWTLoginRecordFromNT, uin is " + loginRecord.uin + ",appid is " + loginRecord.appid + ", result " + addWTLoginRecordFromNT + ", wtRefreshSigImmediately:true");
        if (addWTLoginRecordFromNT != 0) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ILoginServletService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IL\u2026ava, ProcessConstant.ALL)");
            Bundle bundle = new Bundle();
            bundle.putByteArray(AppConstants.Key.KEY_CONNECT_DATA, com.tencent.open.agent.util.g.u(String.valueOf(loginRecord.appid)));
            ((ILoginServletService) runtimeService).transformNTSigToWT(String.valueOf(loginRecord.uin), loginRecord.appid, bundle, new b(loginRecord, addWTLoginRecordFromNT));
        }
    }

    @Override // dx3.d
    public void deleteWTLoginRecord(long uin, int appid) {
        WtloginManager wtloginManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(uin), Integer.valueOf(appid));
            return;
        }
        QLog.d("KernelLoginInjector", 1, "deleteWTLoginRecord, uin is " + uin + ", appid is " + appid);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (wtloginManager = (WtloginManager) peekAppRuntime.getManager(1)) == null) {
            return;
        }
        wtloginManager.clearUserFastLoginData(String.valueOf(uin), appid);
    }

    @Override // dx3.d
    public void getWTLoginRecord(long uin, int appid, @NotNull IGetLoginRecordFromWTCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(uin), Integer.valueOf(appid), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            cb5.onResult(-1, "app is null", null);
            return;
        }
        TicketManager ticketManager = (TicketManager) peekAppRuntime.getManager(2);
        if (ticketManager == null) {
            cb5.onResult(-1, "ticketManager is null", null);
            return;
        }
        WTLoginRecordSnapshot wTLoginRecordSnapshot = ticketManager.getWTLoginRecordSnapshot(uin, appid);
        if (wTLoginRecordSnapshot == null) {
            QLog.d("KernelLoginInjector", 1, "getWTLoginRecord snapshot is null uin:" + uin + ", appid:" + appid);
            cb5.onResult(-1, "record is null", null);
            return;
        }
        WTLoginRecord wTLoginRecord = new WTLoginRecord();
        wTLoginRecord.uin = wTLoginRecordSnapshot.uin;
        wTLoginRecord.appid = wTLoginRecordSnapshot.appid;
        wTLoginRecord.f359237a2 = wTLoginRecordSnapshot.f422865a2;
        wTLoginRecord.a2Key = wTLoginRecordSnapshot.a2Key;
        wTLoginRecord.f359238d2 = wTLoginRecordSnapshot.f422866d2;
        wTLoginRecord.d2Key = wTLoginRecordSnapshot.d2Key;
        wTLoginRecord.f359236a1 = wTLoginRecordSnapshot.f422864a1;
        wTLoginRecord.a1Key = wTLoginRecordSnapshot.a1Key;
        wTLoginRecord.noPicSig = wTLoginRecordSnapshot.noPicSig;
        wTLoginRecord.a2GenerateTime = wTLoginRecordSnapshot.a2GenerateTime;
        wTLoginRecord.expireTime = wTLoginRecordSnapshot.expireTime;
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "msf_mmkv_file").decodeString(peekAppRuntime.getCurrentUin(), null);
        if (TextUtils.isEmpty(decodeString)) {
            decodeString = UIDFileUtil.getUIDFromFile(String.valueOf(wTLoginRecord.uin));
        }
        wTLoginRecord.uid = decodeString;
        QLog.d("KernelLoginInjector", 1, "getWTLoginRecord success, uin is " + uin + ", appid:" + appid);
        cb5.onResult(0, "", wTLoginRecord);
    }
}
