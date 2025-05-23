package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService;

/* compiled from: P */
/* loaded from: classes24.dex */
public final /* synthetic */ class av {
    public static IKernelLoginService z() {
        return IKernelLoginService.CppProxy.getLoginService();
    }

    public static void f(IKernelLoginService iKernelLoginService) {
    }

    public static void h(IKernelLoginService iKernelLoginService, ILoginTicketListCallback iLoginTicketListCallback) {
    }

    public static void v(IKernelLoginService iKernelLoginService, String str) {
    }

    public static void w(IKernelLoginService iKernelLoginService, String str) {
    }

    public static void a(IKernelLoginService iKernelLoginService, String str, IRapidLoginCallback iRapidLoginCallback) {
    }

    public static void b(IKernelLoginService iKernelLoginService, CheckGatewayCodeReq checkGatewayCodeReq, ILoginCallback iLoginCallback) {
    }

    public static void c(IKernelLoginService iKernelLoginService, CheckLimitHandleResultReq checkLimitHandleResultReq, IRegisterIdentityCallback iRegisterIdentityCallback) {
    }

    public static void d(IKernelLoginService iKernelLoginService, CheckSmsReqBody checkSmsReqBody, ILoginCallback iLoginCallback) {
    }

    public static void e(IKernelLoginService iKernelLoginService, CheckThirdCodeReq checkThirdCodeReq, ICheckThirdCodeCallback iCheckThirdCodeCallback) {
    }

    public static void g(IKernelLoginService iKernelLoginService, long j3, long j16) {
    }

    public static void j(IKernelLoginService iKernelLoginService, GetRegisterSmsCodeReq getRegisterSmsCodeReq, IRegisterIdentityCallback iRegisterIdentityCallback) {
    }

    public static void k(IKernelLoginService iKernelLoginService, GetRegisterUinReq getRegisterUinReq, IGetRegisterUinCallback iGetRegisterUinCallback) {
    }

    public static void l(IKernelLoginService iKernelLoginService, GetSmsReqBody getSmsReqBody, ILoginCallback iLoginCallback) {
    }

    public static void m(IKernelLoginService iKernelLoginService, InitLoginConfig initLoginConfig, IloginAdapter iloginAdapter) {
    }

    public static void n(IKernelLoginService iKernelLoginService, OptimusLoginInfo optimusLoginInfo, ILoginCallback iLoginCallback) {
    }

    public static void o(IKernelLoginService iKernelLoginService, PwdLoginInfo pwdLoginInfo, ILoginCallback iLoginCallback) {
    }

    public static void p(IKernelLoginService iKernelLoginService, RapidLoginReq rapidLoginReq, IRapidLoginCallback iRapidLoginCallback) {
    }

    public static void r(IKernelLoginService iKernelLoginService, AuthQrReqInfo authQrReqInfo, ICommonCallback iCommonCallback) {
    }

    public static void s(IKernelLoginService iKernelLoginService, byte[] bArr, ICommonCallback iCommonCallback) {
    }

    public static void t(IKernelLoginService iKernelLoginService, byte[] bArr, ICommonCallback iCommonCallback) {
    }

    public static void u(IKernelLoginService iKernelLoginService, ScanQrReq scanQrReq, IScanQRCodeCallback iScanQRCodeCallback) {
    }

    public static void x(IKernelLoginService iKernelLoginService, SubmitIdentityInfoReq submitIdentityInfoReq, IRegisterIdentityCallback iRegisterIdentityCallback) {
    }

    public static void y(IKernelLoginService iKernelLoginService, NewDeviceVerifyReq newDeviceVerifyReq, IVerifyNewDeviceCallback iVerifyNewDeviceCallback) {
    }

    public static void i(IKernelLoginService iKernelLoginService, long j3, long j16, ILoginTicketCallback iLoginTicketCallback) {
    }

    public static void q(IKernelLoginService iKernelLoginService, long j3, AppInfo appInfo, boolean z16, ILoginRefreshTicketCallback iLoginRefreshTicketCallback) {
    }
}
