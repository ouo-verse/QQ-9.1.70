package com.tencent.qqnt.kernel.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.thirdsig.api.impl.ThirdSigServiceImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.AppInfo;
import com.tencent.qqnt.kernel.nativeinterface.AuthQrReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.CheckGatewayCodeReq;
import com.tencent.qqnt.kernel.nativeinterface.CheckLimitHandleResultReq;
import com.tencent.qqnt.kernel.nativeinterface.CheckSmsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.CheckThirdCodeReq;
import com.tencent.qqnt.kernel.nativeinterface.GetRegisterSmsCodeReq;
import com.tencent.qqnt.kernel.nativeinterface.GetRegisterUinReq;
import com.tencent.qqnt.kernel.nativeinterface.GetSmsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.ICheckThirdCodeCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICommonCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetLoginRecordFromWTCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetRegisterUinCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService;
import com.tencent.qqnt.kernel.nativeinterface.ILoginCallback;
import com.tencent.qqnt.kernel.nativeinterface.ILoginRefreshTicketCallback;
import com.tencent.qqnt.kernel.nativeinterface.ILoginTicketCallback;
import com.tencent.qqnt.kernel.nativeinterface.ILoginTicketListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRapidLoginCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRegisterIdentityCallback;
import com.tencent.qqnt.kernel.nativeinterface.IScanQRCodeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IVerifyNewDeviceCallback;
import com.tencent.qqnt.kernel.nativeinterface.IloginAdapter;
import com.tencent.qqnt.kernel.nativeinterface.InitLoginConfig;
import com.tencent.qqnt.kernel.nativeinterface.LoginPlatformType;
import com.tencent.qqnt.kernel.nativeinterface.NewDeviceVerifyReq;
import com.tencent.qqnt.kernel.nativeinterface.OptimusLoginInfo;
import com.tencent.qqnt.kernel.nativeinterface.PwdLoginInfo;
import com.tencent.qqnt.kernel.nativeinterface.RapidLoginReq;
import com.tencent.qqnt.kernel.nativeinterface.ScanQrReq;
import com.tencent.qqnt.kernel.nativeinterface.SubmitIdentityInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.WTLoginRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u0001:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u001f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010!\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010 2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010#\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010'\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u0005\u001a\u0004\u0018\u00010&H\u0016J\u001c\u0010*\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010(2\b\u0010\u0005\u001a\u0004\u0018\u00010)H\u0016J\u001c\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\u0005\u001a\u0004\u0018\u00010)H\u0016J\u001c\u0010.\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\u0005\u001a\u0004\u0018\u00010)H\u0016J\u001c\u00101\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010/2\b\u0010\u0005\u001a\u0004\u0018\u000100H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\u001c\u00104\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u0001032\b\u0010\u0005\u001a\u0004\u0018\u000100H\u0016J\u001c\u00106\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u0001052\b\u0010\u0005\u001a\u0004\u0018\u000100H\u0016J\u0010\u00108\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u000207H\u0016J\u001c\u0010;\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u0001092\b\u0010\u0005\u001a\u0004\u0018\u00010:H\u0016J\u0018\u0010=\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u0012H\u0016\u00a8\u0006B"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/LoginServiceImpl;", "Lcom/tencent/qqnt/kernel/api/ILoginService;", "Lcom/tencent/qqnt/kernel/nativeinterface/PwdLoginInfo;", "loginInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/ILoginCallback;", "cb", "", "passwordLogin", "Lcom/tencent/qqnt/kernel/nativeinterface/GetSmsReqBody;", "req", "getSms", "Lcom/tencent/qqnt/kernel/nativeinterface/NewDeviceVerifyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IVerifyNewDeviceCallback;", "verifyNewDeviceWithPwd", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckSmsReqBody;", "checkSms", "Lcom/tencent/qqnt/kernel/nativeinterface/OptimusLoginInfo;", "optimusLogin", "", "uin", "Lcom/tencent/qqnt/kernel/nativeinterface/AppInfo;", "appInfo", "", "forceRefresh", "Lcom/tencent/qqnt/kernel/nativeinterface/ILoginRefreshTicketCallback;", "refreshLoginTicketsByUin", "appId", "Lcom/tencent/qqnt/kernel/nativeinterface/ILoginTicketCallback;", "getLoginTicketByUin", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckThirdCodeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckThirdCodeCallback;", "checkThirdCode", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckGatewayCodeReq;", "checkGatewayCode", "", "setCurrentUin", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanQrReq;", "reqInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IScanQRCodeCallback;", "sendScanQrRequest", "Lcom/tencent/qqnt/kernel/nativeinterface/AuthQrReqInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICommonCallback;", "sendAuthQrRequest", "", "qrSig", "sendRejectQrRequest", "sendCancleQrRequest", "Lcom/tencent/qqnt/kernel/nativeinterface/SubmitIdentityInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRegisterIdentityCallback;", "submitIdentityInfo", "deleteAllLoginTicket", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckLimitHandleResultReq;", "checkLimitHandleResult", "Lcom/tencent/qqnt/kernel/nativeinterface/GetRegisterSmsCodeReq;", "getRegisterSmsCode", "Lcom/tencent/qqnt/kernel/nativeinterface/ILoginTicketListCallback;", "getAllLoginTicket", "Lcom/tencent/qqnt/kernel/nativeinterface/GetRegisterUinReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRegisterUinCallback;", "getRegisterUin", "appid", "deleteLoginTicket", "<init>", "()V", "Companion", "b", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class LoginServiceImpl implements ILoginService {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String BEACON_EVENT = "nt_login_invalid_call";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String KEY_TRACE = "trace";

    @NotNull
    private static final String TAG = "LoginServiceImpl";

    @NotNull
    private static AtomicBoolean isGuidInit;

    @NotNull
    private static IKernelLoginService loginService;

    @Nullable
    private static com.tencent.mobileqq.inject.b sAppSetting;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_AppSetting.yml", version = 1)
    @NotNull
    private static ArrayList<Class<com.tencent.mobileqq.inject.b>> sAppSettingList;

    @Nullable
    private static dx3.d sKernelLoginInject;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_KernelLogin.yml", version = 1)
    @NotNull
    private static ArrayList<Class<dx3.d>> sKernelLoginInjectList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IloginAdapter;", "", "uin", "", "appid", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetLoginRecordFromWTCallback;", "cb", "", "getWTLoginRecord", "deleteWTLoginRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/WTLoginRecord;", "loginRecord", "addWTLoginRecordFromNT", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements IloginAdapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IloginAdapter
        public void addWTLoginRecordFromNT(@NotNull WTLoginRecord loginRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) loginRecord);
                return;
            }
            Intrinsics.checkNotNullParameter(loginRecord, "loginRecord");
            dx3.d dVar = LoginServiceImpl.sKernelLoginInject;
            Intrinsics.checkNotNull(dVar);
            dVar.addWTLoginRecordFromNT(loginRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IloginAdapter
        public void deleteWTLoginRecord(long uin, int appid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                dx3.d dVar = LoginServiceImpl.sKernelLoginInject;
                Intrinsics.checkNotNull(dVar);
                dVar.deleteWTLoginRecord(uin, appid);
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(uin), Integer.valueOf(appid));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IloginAdapter
        public void getWTLoginRecord(long uin, int appid, @NotNull IGetLoginRecordFromWTCallback cb5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(uin), Integer.valueOf(appid), cb5);
                return;
            }
            Intrinsics.checkNotNullParameter(cb5, "cb");
            dx3.d dVar = LoginServiceImpl.sKernelLoginInject;
            Intrinsics.checkNotNull(dVar);
            dVar.getWTLoginRecord(uin, appid, cb5);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/LoginServiceImpl$b;", "", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "callback", "", "b", "", "BEACON_EVENT", "Ljava/lang/String;", "KEY_TRACE", "TAG", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isGuidInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelLoginService;", "loginService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelLoginService;", "Lcom/tencent/mobileqq/inject/b;", "sAppSetting", "Lcom/tencent/mobileqq/inject/b;", "Ldx3/d;", "sKernelLoginInject", "Ldx3/d;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.LoginServiceImpl$b, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$b$a", "Lcom/tencent/mobileqq/guid/d;", "", "guid", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.kernel.api.impl.LoginServiceImpl$b$a */
        /* loaded from: classes24.dex */
        public static final class a implements com.tencent.mobileqq.guid.d {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ gz f357254a;

            a(gz gzVar) {
                this.f357254a = gzVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) gzVar);
                }
            }

            @Override // com.tencent.mobileqq.guid.d
            public void a(@NotNull byte[] guid) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) guid);
                    return;
                }
                Intrinsics.checkNotNullParameter(guid, "guid");
                QLog.d(LoginServiceImpl.TAG, 1, "checkGuidReady get guid async success!");
                LoginServiceImpl.isGuidInit.set(true);
                com.tencent.qqnt.kernel.nativeinterface.av.z().setGuid(util.buf_to_string(guid));
                gz gzVar = this.f357254a;
                if (gzVar != null) {
                    gzVar.a();
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(gz callback) {
            if (!LoginServiceImpl.isGuidInit.get()) {
                com.tencent.mobileqq.guid.c.f213821a.g(new a(callback));
            } else if (callback != null) {
                callback.a();
            }
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$c", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckGatewayCodeReq f357255a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ILoginCallback f357256b;

        c(CheckGatewayCodeReq checkGatewayCodeReq, ILoginCallback iLoginCallback) {
            this.f357255a = checkGatewayCodeReq;
            this.f357256b = iLoginCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) checkGatewayCodeReq, (Object) iLoginCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().checkGatewayCode(this.f357255a, this.f357256b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$d", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckLimitHandleResultReq f357257a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IRegisterIdentityCallback f357258b;

        d(CheckLimitHandleResultReq checkLimitHandleResultReq, IRegisterIdentityCallback iRegisterIdentityCallback) {
            this.f357257a = checkLimitHandleResultReq;
            this.f357258b = iRegisterIdentityCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) checkLimitHandleResultReq, (Object) iRegisterIdentityCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().checkLimitHandleResult(this.f357257a, this.f357258b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$e", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class e implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckSmsReqBody f357259a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ILoginCallback f357260b;

        e(CheckSmsReqBody checkSmsReqBody, ILoginCallback iLoginCallback) {
            this.f357259a = checkSmsReqBody;
            this.f357260b = iLoginCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) checkSmsReqBody, (Object) iLoginCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().checkSms(this.f357259a, this.f357260b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$f", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class f implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckThirdCodeReq f357261a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ICheckThirdCodeCallback f357262b;

        f(CheckThirdCodeReq checkThirdCodeReq, ICheckThirdCodeCallback iCheckThirdCodeCallback) {
            this.f357261a = checkThirdCodeReq;
            this.f357262b = iCheckThirdCodeCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) checkThirdCodeReq, (Object) iCheckThirdCodeCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().checkThirdCode(this.f357261a, this.f357262b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$g", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class g implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f357263a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f357264b;

        g(long j3, long j16) {
            this.f357263a = j3;
            this.f357264b = j16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().deleteLoginTicket(this.f357263a, this.f357264b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$h", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class h implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ILoginTicketListCallback f357265a;

        h(ILoginTicketListCallback iLoginTicketListCallback) {
            this.f357265a = iLoginTicketListCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iLoginTicketListCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().getAllLoginTicket(this.f357265a);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$i", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class i implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f357266a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f357267b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ILoginTicketCallback f357268c;

        i(long j3, long j16, ILoginTicketCallback iLoginTicketCallback) {
            this.f357266a = j3;
            this.f357267b = j16;
            this.f357268c = iLoginTicketCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), iLoginTicketCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().getLoginTicketByUin(this.f357266a, this.f357267b, this.f357268c);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$j", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class j implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GetRegisterSmsCodeReq f357269a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IRegisterIdentityCallback f357270b;

        j(GetRegisterSmsCodeReq getRegisterSmsCodeReq, IRegisterIdentityCallback iRegisterIdentityCallback) {
            this.f357269a = getRegisterSmsCodeReq;
            this.f357270b = iRegisterIdentityCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) getRegisterSmsCodeReq, (Object) iRegisterIdentityCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().getRegisterSmsCode(this.f357269a, this.f357270b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$k", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class k implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GetRegisterUinReq f357271a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGetRegisterUinCallback f357272b;

        k(GetRegisterUinReq getRegisterUinReq, IGetRegisterUinCallback iGetRegisterUinCallback) {
            this.f357271a = getRegisterUinReq;
            this.f357272b = iGetRegisterUinCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) getRegisterUinReq, (Object) iGetRegisterUinCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().getRegisterUin(this.f357271a, this.f357272b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$l", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class l implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GetSmsReqBody f357273a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ILoginCallback f357274b;

        l(GetSmsReqBody getSmsReqBody, ILoginCallback iLoginCallback) {
            this.f357273a = getSmsReqBody;
            this.f357274b = iLoginCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) getSmsReqBody, (Object) iLoginCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().getSms(this.f357273a, this.f357274b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$m", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class m implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OptimusLoginInfo f357275a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ILoginCallback f357276b;

        m(OptimusLoginInfo optimusLoginInfo, ILoginCallback iLoginCallback) {
            this.f357275a = optimusLoginInfo;
            this.f357276b = iLoginCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) optimusLoginInfo, (Object) iLoginCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().optimusLogin(this.f357275a, this.f357276b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$n", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class n implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PwdLoginInfo f357277a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ILoginCallback f357278b;

        n(PwdLoginInfo pwdLoginInfo, ILoginCallback iLoginCallback) {
            this.f357277a = pwdLoginInfo;
            this.f357278b = iLoginCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) pwdLoginInfo, (Object) iLoginCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().passwordLogin(this.f357277a, this.f357278b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$o", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class o implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f357279a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppInfo f357280b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f357281c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ILoginRefreshTicketCallback f357282d;

        o(long j3, AppInfo appInfo, boolean z16, ILoginRefreshTicketCallback iLoginRefreshTicketCallback) {
            this.f357279a = j3;
            this.f357280b = appInfo;
            this.f357281c = z16;
            this.f357282d = iLoginRefreshTicketCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), appInfo, Boolean.valueOf(z16), iLoginRefreshTicketCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().refreshLoginTicketsByUin(this.f357279a, this.f357280b, this.f357281c, this.f357282d);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$p", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class p implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AuthQrReqInfo f357283a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ICommonCallback f357284b;

        p(AuthQrReqInfo authQrReqInfo, ICommonCallback iCommonCallback) {
            this.f357283a = authQrReqInfo;
            this.f357284b = iCommonCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) authQrReqInfo, (Object) iCommonCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().sendAuthQrRequest(this.f357283a, this.f357284b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$q", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class q implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f357285a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ICommonCallback f357286b;

        q(byte[] bArr, ICommonCallback iCommonCallback) {
            this.f357285a = bArr;
            this.f357286b = iCommonCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr, (Object) iCommonCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().sendCancleQrRequest(this.f357285a, this.f357286b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$r", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class r implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f357287a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ICommonCallback f357288b;

        r(byte[] bArr, ICommonCallback iCommonCallback) {
            this.f357287a = bArr;
            this.f357288b = iCommonCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr, (Object) iCommonCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().sendRejectQrRequest(this.f357287a, this.f357288b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$s", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class s implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScanQrReq f357289a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IScanQRCodeCallback f357290b;

        s(ScanQrReq scanQrReq, IScanQRCodeCallback iScanQRCodeCallback) {
            this.f357289a = scanQrReq;
            this.f357290b = iScanQRCodeCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) scanQrReq, (Object) iScanQRCodeCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().sendScanQrRequest(this.f357289a, this.f357290b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$t", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class t implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f357291a;

        t(String str) {
            this.f357291a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().setCurrentUin(this.f357291a);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$u", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class u implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SubmitIdentityInfoReq f357292a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IRegisterIdentityCallback f357293b;

        u(SubmitIdentityInfoReq submitIdentityInfoReq, IRegisterIdentityCallback iRegisterIdentityCallback) {
            this.f357292a = submitIdentityInfoReq;
            this.f357293b = iRegisterIdentityCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) submitIdentityInfoReq, (Object) iRegisterIdentityCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().submitIdentityInfo(this.f357292a, this.f357293b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/LoginServiceImpl$v", "Lcom/tencent/qqnt/kernel/api/impl/gz;", "", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class v implements gz {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NewDeviceVerifyReq f357294a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IVerifyNewDeviceCallback f357295b;

        v(NewDeviceVerifyReq newDeviceVerifyReq, IVerifyNewDeviceCallback iVerifyNewDeviceCallback) {
            this.f357294a = newDeviceVerifyReq;
            this.f357295b = iVerifyNewDeviceCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) newDeviceVerifyReq, (Object) iVerifyNewDeviceCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.impl.gz
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.av.z().verifyNewDeviceWithPwd(this.f357294a, this.f357295b);
            }
        }
    }

    static {
        String str;
        String str2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49721);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        ArrayList<Class<com.tencent.mobileqq.inject.b>> arrayList = new ArrayList<>();
        sAppSettingList = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
        sAppSettingList.add(com.tencent.mobileqq.injector.d.class);
        ArrayList<Class<dx3.d>> arrayList2 = new ArrayList<>();
        sKernelLoginInjectList = arrayList2;
        arrayList2.add(com.tencent.mobileqq.injector.p.class);
        isGuidInit = new AtomicBoolean(false);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (sKernelLoginInjectList.size() > 0) {
            dx3.d newInstance = sKernelLoginInjectList.get(0).newInstance();
            sKernelLoginInject = newInstance;
            Intrinsics.checkNotNull(newInstance);
            if (!newInstance.a()) {
                Exception exc = new Exception();
                QLog.e(TAG, 1, exc, new Object[0]);
                HashMap hashMap = new HashMap();
                String stackTraceString = QLog.getStackTraceString(exc);
                Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(exception)");
                hashMap.put(KEY_TRACE, stackTraceString);
                if (peekAppRuntime != null) {
                    str2 = peekAppRuntime.getCurrentUin();
                } else {
                    str2 = null;
                }
                com.tencent.mobileqq.inject.v.c(str2, BEACON_EVENT, hashMap);
            }
        }
        if (sAppSettingList.size() > 0) {
            sAppSetting = sAppSettingList.get(0).newInstance();
        }
        IKernelLoginService z16 = com.tencent.qqnt.kernel.nativeinterface.av.z();
        Intrinsics.checkNotNullExpressionValue(z16, "getLoginService()");
        loginService = z16;
        InitLoginConfig initLoginConfig = new InitLoginConfig();
        initLoginConfig.bid = String.valueOf(BaseApplication.getContext().getAppId());
        initLoginConfig.appid = 16L;
        initLoginConfig.guid = util.buf_to_string(com.tencent.mobileqq.guid.c.f213821a.c());
        initLoginConfig.qua = BaseApplication.getContext().getQua();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar != null) {
            str = bVar.getSubVersion();
        } else {
            str = null;
        }
        initLoginConfig.clientVer = str;
        initLoginConfig.commonPath = BaseApplication.getContext().getFilesDir().getAbsolutePath() + ThirdSigServiceImpl.NT_WTLOGIN_DIR;
        initLoginConfig.deviceType = "ANDROID";
        initLoginConfig.hostName = DeviceInfoMonitor.getModel();
        initLoginConfig.platform = LoginPlatformType.PLATFORM_ANDROID;
        initLoginConfig.appName = BaseApplication.getContext().getPackageName();
        com.tencent.qqnt.kernel.nativeinterface.av.z().initConfig(initLoginConfig, new a());
        if (TextUtils.isEmpty(initLoginConfig.guid)) {
            companion.b(null);
        }
    }

    public LoginServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public /* synthetic */ void cancelRapidLogin(String str, IRapidLoginCallback iRapidLoginCallback) {
        com.tencent.qqnt.kernel.nativeinterface.av.a(this, str, iRapidLoginCallback);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void checkGatewayCode(@Nullable CheckGatewayCodeReq req, @Nullable ILoginCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            INSTANCE.b(new c(req, cb5));
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) req, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void checkLimitHandleResult(@Nullable CheckLimitHandleResultReq req, @Nullable IRegisterIdentityCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            INSTANCE.b(new d(req, cb5));
        } else {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) req, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void checkSms(@Nullable CheckSmsReqBody req, @Nullable ILoginCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            INSTANCE.b(new e(req, cb5));
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) req, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void checkThirdCode(@Nullable CheckThirdCodeReq req, @Nullable ICheckThirdCodeCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            INSTANCE.b(new f(req, cb5));
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) req, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void deleteAllLoginTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            QLog.d(TAG, 1, "deleteAllLoginTicket");
            com.tencent.qqnt.kernel.nativeinterface.av.z().deleteAllLoginTicket();
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void deleteLoginTicket(long uin, long appid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(uin), Long.valueOf(appid));
            return;
        }
        QLog.d(TAG, 1, "deleteLoginTicket uin:" + uin + " appid:" + appid);
        INSTANCE.b(new g(uin, appid));
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void getAllLoginTicket(@NotNull ILoginTicketListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(cb5, "cb");
            INSTANCE.b(new h(cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void getLoginTicketByUin(long uin, long appId, @Nullable ILoginTicketCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            INSTANCE.b(new i(uin, appId, cb5));
        } else {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(uin), Long.valueOf(appId), cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void getRegisterSmsCode(@Nullable GetRegisterSmsCodeReq req, @Nullable IRegisterIdentityCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            INSTANCE.b(new j(req, cb5));
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) req, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void getRegisterUin(@Nullable GetRegisterUinReq req, @Nullable IGetRegisterUinCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            INSTANCE.b(new k(req, cb5));
        } else {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) req, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void getSms(@Nullable GetSmsReqBody req, @Nullable ILoginCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            INSTANCE.b(new l(req, cb5));
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) req, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public /* synthetic */ void initConfig(InitLoginConfig initLoginConfig, IloginAdapter iloginAdapter) {
        com.tencent.qqnt.kernel.nativeinterface.av.m(this, initLoginConfig, iloginAdapter);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void optimusLogin(@Nullable OptimusLoginInfo loginInfo, @Nullable ILoginCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            INSTANCE.b(new m(loginInfo, cb5));
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) loginInfo, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void passwordLogin(@Nullable PwdLoginInfo loginInfo, @Nullable ILoginCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            INSTANCE.b(new n(loginInfo, cb5));
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginInfo, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public /* synthetic */ void rapidLogin(RapidLoginReq rapidLoginReq, IRapidLoginCallback iRapidLoginCallback) {
        com.tencent.qqnt.kernel.nativeinterface.av.p(this, rapidLoginReq, iRapidLoginCallback);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void refreshLoginTicketsByUin(long uin, @NotNull AppInfo appInfo, boolean forceRefresh, @Nullable ILoginRefreshTicketCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(uin), appInfo, Boolean.valueOf(forceRefresh), cb5);
        } else {
            Intrinsics.checkNotNullParameter(appInfo, "appInfo");
            INSTANCE.b(new o(uin, appInfo, forceRefresh, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void sendAuthQrRequest(@Nullable AuthQrReqInfo reqInfo, @Nullable ICommonCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            INSTANCE.b(new p(reqInfo, cb5));
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) reqInfo, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void sendCancleQrRequest(@Nullable byte[] qrSig, @Nullable ICommonCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            INSTANCE.b(new q(qrSig, cb5));
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) qrSig, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void sendRejectQrRequest(@Nullable byte[] qrSig, @Nullable ICommonCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            INSTANCE.b(new r(qrSig, cb5));
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) qrSig, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void sendScanQrRequest(@Nullable ScanQrReq reqInfo, @Nullable IScanQRCodeCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            INSTANCE.b(new s(reqInfo, cb5));
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) reqInfo, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void setCurrentUin(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            INSTANCE.b(new t(uin));
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) uin);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public /* synthetic */ void setGuid(String str) {
        com.tencent.qqnt.kernel.nativeinterface.av.w(this, str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void submitIdentityInfo(@Nullable SubmitIdentityInfoReq req, @Nullable IRegisterIdentityCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            INSTANCE.b(new u(req, cb5));
        } else {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) req, (Object) cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
    public void verifyNewDeviceWithPwd(@Nullable NewDeviceVerifyReq req, @Nullable IVerifyNewDeviceCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            INSTANCE.b(new v(req, cb5));
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) req, (Object) cb5);
        }
    }
}
