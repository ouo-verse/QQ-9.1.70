package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelLoginService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelLoginService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        CppProxy(long j3) {
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        public static native IKernelLoginService getLoginService();

        private native void nativeDestroy(long j3);

        private native void native_cancelRapidLogin(long j3, String str, IRapidLoginCallback iRapidLoginCallback);

        private native void native_checkGatewayCode(long j3, CheckGatewayCodeReq checkGatewayCodeReq, ILoginCallback iLoginCallback);

        private native void native_checkLimitHandleResult(long j3, CheckLimitHandleResultReq checkLimitHandleResultReq, IRegisterIdentityCallback iRegisterIdentityCallback);

        private native void native_checkSms(long j3, CheckSmsReqBody checkSmsReqBody, ILoginCallback iLoginCallback);

        private native void native_checkThirdCode(long j3, CheckThirdCodeReq checkThirdCodeReq, ICheckThirdCodeCallback iCheckThirdCodeCallback);

        private native void native_deleteAllLoginTicket(long j3);

        private native void native_deleteLoginTicket(long j3, long j16, long j17);

        private native void native_getAllLoginTicket(long j3, ILoginTicketListCallback iLoginTicketListCallback);

        private native void native_getLoginTicketByUin(long j3, long j16, long j17, ILoginTicketCallback iLoginTicketCallback);

        private native void native_getRegisterSmsCode(long j3, GetRegisterSmsCodeReq getRegisterSmsCodeReq, IRegisterIdentityCallback iRegisterIdentityCallback);

        private native void native_getRegisterUin(long j3, GetRegisterUinReq getRegisterUinReq, IGetRegisterUinCallback iGetRegisterUinCallback);

        private native void native_getSms(long j3, GetSmsReqBody getSmsReqBody, ILoginCallback iLoginCallback);

        private native void native_initConfig(long j3, InitLoginConfig initLoginConfig, IloginAdapter iloginAdapter);

        private native void native_optimusLogin(long j3, OptimusLoginInfo optimusLoginInfo, ILoginCallback iLoginCallback);

        private native void native_passwordLogin(long j3, PwdLoginInfo pwdLoginInfo, ILoginCallback iLoginCallback);

        private native void native_rapidLogin(long j3, RapidLoginReq rapidLoginReq, IRapidLoginCallback iRapidLoginCallback);

        private native void native_refreshLoginTicketsByUin(long j3, long j16, AppInfo appInfo, boolean z16, ILoginRefreshTicketCallback iLoginRefreshTicketCallback);

        private native void native_sendAuthQrRequest(long j3, AuthQrReqInfo authQrReqInfo, ICommonCallback iCommonCallback);

        private native void native_sendCancleQrRequest(long j3, byte[] bArr, ICommonCallback iCommonCallback);

        private native void native_sendRejectQrRequest(long j3, byte[] bArr, ICommonCallback iCommonCallback);

        private native void native_sendScanQrRequest(long j3, ScanQrReq scanQrReq, IScanQRCodeCallback iScanQRCodeCallback);

        private native void native_setCurrentUin(long j3, String str);

        private native void native_setGuid(long j3, String str);

        private native void native_submitIdentityInfo(long j3, SubmitIdentityInfoReq submitIdentityInfoReq, IRegisterIdentityCallback iRegisterIdentityCallback);

        private native void native_verifyNewDeviceWithPwd(long j3, NewDeviceVerifyReq newDeviceVerifyReq, IVerifyNewDeviceCallback iVerifyNewDeviceCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void cancelRapidLogin(String str, IRapidLoginCallback iRapidLoginCallback) {
            native_cancelRapidLogin(this.nativeRef, str, iRapidLoginCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void checkGatewayCode(CheckGatewayCodeReq checkGatewayCodeReq, ILoginCallback iLoginCallback) {
            native_checkGatewayCode(this.nativeRef, checkGatewayCodeReq, iLoginCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void checkLimitHandleResult(CheckLimitHandleResultReq checkLimitHandleResultReq, IRegisterIdentityCallback iRegisterIdentityCallback) {
            native_checkLimitHandleResult(this.nativeRef, checkLimitHandleResultReq, iRegisterIdentityCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void checkSms(CheckSmsReqBody checkSmsReqBody, ILoginCallback iLoginCallback) {
            native_checkSms(this.nativeRef, checkSmsReqBody, iLoginCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void checkThirdCode(CheckThirdCodeReq checkThirdCodeReq, ICheckThirdCodeCallback iCheckThirdCodeCallback) {
            native_checkThirdCode(this.nativeRef, checkThirdCodeReq, iCheckThirdCodeCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void deleteAllLoginTicket() {
            native_deleteAllLoginTicket(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void deleteLoginTicket(long j3, long j16) {
            native_deleteLoginTicket(this.nativeRef, j3, j16);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void getAllLoginTicket(ILoginTicketListCallback iLoginTicketListCallback) {
            native_getAllLoginTicket(this.nativeRef, iLoginTicketListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void getLoginTicketByUin(long j3, long j16, ILoginTicketCallback iLoginTicketCallback) {
            native_getLoginTicketByUin(this.nativeRef, j3, j16, iLoginTicketCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void getRegisterSmsCode(GetRegisterSmsCodeReq getRegisterSmsCodeReq, IRegisterIdentityCallback iRegisterIdentityCallback) {
            native_getRegisterSmsCode(this.nativeRef, getRegisterSmsCodeReq, iRegisterIdentityCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void getRegisterUin(GetRegisterUinReq getRegisterUinReq, IGetRegisterUinCallback iGetRegisterUinCallback) {
            native_getRegisterUin(this.nativeRef, getRegisterUinReq, iGetRegisterUinCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void getSms(GetSmsReqBody getSmsReqBody, ILoginCallback iLoginCallback) {
            native_getSms(this.nativeRef, getSmsReqBody, iLoginCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void initConfig(InitLoginConfig initLoginConfig, IloginAdapter iloginAdapter) {
            native_initConfig(this.nativeRef, initLoginConfig, iloginAdapter);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void optimusLogin(OptimusLoginInfo optimusLoginInfo, ILoginCallback iLoginCallback) {
            native_optimusLogin(this.nativeRef, optimusLoginInfo, iLoginCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void passwordLogin(PwdLoginInfo pwdLoginInfo, ILoginCallback iLoginCallback) {
            native_passwordLogin(this.nativeRef, pwdLoginInfo, iLoginCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void rapidLogin(RapidLoginReq rapidLoginReq, IRapidLoginCallback iRapidLoginCallback) {
            native_rapidLogin(this.nativeRef, rapidLoginReq, iRapidLoginCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void refreshLoginTicketsByUin(long j3, AppInfo appInfo, boolean z16, ILoginRefreshTicketCallback iLoginRefreshTicketCallback) {
            native_refreshLoginTicketsByUin(this.nativeRef, j3, appInfo, z16, iLoginRefreshTicketCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void sendAuthQrRequest(AuthQrReqInfo authQrReqInfo, ICommonCallback iCommonCallback) {
            native_sendAuthQrRequest(this.nativeRef, authQrReqInfo, iCommonCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void sendCancleQrRequest(byte[] bArr, ICommonCallback iCommonCallback) {
            native_sendCancleQrRequest(this.nativeRef, bArr, iCommonCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void sendRejectQrRequest(byte[] bArr, ICommonCallback iCommonCallback) {
            native_sendRejectQrRequest(this.nativeRef, bArr, iCommonCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void sendScanQrRequest(ScanQrReq scanQrReq, IScanQRCodeCallback iScanQRCodeCallback) {
            native_sendScanQrRequest(this.nativeRef, scanQrReq, iScanQRCodeCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void setCurrentUin(String str) {
            native_setCurrentUin(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void setGuid(String str) {
            native_setGuid(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void submitIdentityInfo(SubmitIdentityInfoReq submitIdentityInfoReq, IRegisterIdentityCallback iRegisterIdentityCallback) {
            native_submitIdentityInfo(this.nativeRef, submitIdentityInfoReq, iRegisterIdentityCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLoginService
        public void verifyNewDeviceWithPwd(NewDeviceVerifyReq newDeviceVerifyReq, IVerifyNewDeviceCallback iVerifyNewDeviceCallback) {
            native_verifyNewDeviceWithPwd(this.nativeRef, newDeviceVerifyReq, iVerifyNewDeviceCallback);
        }
    }

    void cancelRapidLogin(String str, IRapidLoginCallback iRapidLoginCallback);

    void checkGatewayCode(CheckGatewayCodeReq checkGatewayCodeReq, ILoginCallback iLoginCallback);

    void checkLimitHandleResult(CheckLimitHandleResultReq checkLimitHandleResultReq, IRegisterIdentityCallback iRegisterIdentityCallback);

    void checkSms(CheckSmsReqBody checkSmsReqBody, ILoginCallback iLoginCallback);

    void checkThirdCode(CheckThirdCodeReq checkThirdCodeReq, ICheckThirdCodeCallback iCheckThirdCodeCallback);

    void deleteAllLoginTicket();

    void deleteLoginTicket(long j3, long j16);

    void getAllLoginTicket(ILoginTicketListCallback iLoginTicketListCallback);

    void getLoginTicketByUin(long j3, long j16, ILoginTicketCallback iLoginTicketCallback);

    void getRegisterSmsCode(GetRegisterSmsCodeReq getRegisterSmsCodeReq, IRegisterIdentityCallback iRegisterIdentityCallback);

    void getRegisterUin(GetRegisterUinReq getRegisterUinReq, IGetRegisterUinCallback iGetRegisterUinCallback);

    void getSms(GetSmsReqBody getSmsReqBody, ILoginCallback iLoginCallback);

    void initConfig(InitLoginConfig initLoginConfig, IloginAdapter iloginAdapter);

    void optimusLogin(OptimusLoginInfo optimusLoginInfo, ILoginCallback iLoginCallback);

    void passwordLogin(PwdLoginInfo pwdLoginInfo, ILoginCallback iLoginCallback);

    void rapidLogin(RapidLoginReq rapidLoginReq, IRapidLoginCallback iRapidLoginCallback);

    void refreshLoginTicketsByUin(long j3, AppInfo appInfo, boolean z16, ILoginRefreshTicketCallback iLoginRefreshTicketCallback);

    void sendAuthQrRequest(AuthQrReqInfo authQrReqInfo, ICommonCallback iCommonCallback);

    void sendCancleQrRequest(byte[] bArr, ICommonCallback iCommonCallback);

    void sendRejectQrRequest(byte[] bArr, ICommonCallback iCommonCallback);

    void sendScanQrRequest(ScanQrReq scanQrReq, IScanQRCodeCallback iScanQRCodeCallback);

    void setCurrentUin(String str);

    void setGuid(String str);

    void submitIdentityInfo(SubmitIdentityInfoReq submitIdentityInfoReq, IRegisterIdentityCallback iRegisterIdentityCallback);

    void verifyNewDeviceWithPwd(NewDeviceVerifyReq newDeviceVerifyReq, IVerifyNewDeviceCallback iVerifyNewDeviceCallback);
}
