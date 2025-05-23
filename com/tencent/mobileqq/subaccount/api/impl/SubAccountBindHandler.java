package com.tencent.mobileqq.subaccount.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.dc;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.loginregister.servlet.g;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.ISubAccountServlet;
import com.tencent.mobileqq.subaccount.h;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0$LoginSig;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0$ReqBody;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0$RspBody;
import tencent.im.oidb.cmd0x7a1.oidb_0x7a1$ReqBody;
import tencent.im.oidb.cmd0x7a1.oidb_0x7a1$RspBody;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2$ReqBody;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes18.dex */
public class SubAccountBindHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static String f291072e;

    /* renamed from: f, reason: collision with root package name */
    private static String f291073f;

    /* renamed from: h, reason: collision with root package name */
    private static String f291074h;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f291075d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.subaccount.logic.a f291076d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ISubAccountService f291077e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f291078f;

        a(com.tencent.mobileqq.subaccount.logic.a aVar, ISubAccountService iSubAccountService, boolean z16) {
            this.f291076d = aVar;
            this.f291077e = iSubAccountService;
            this.f291078f = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SubAccountBindHandler.this, aVar, iSubAccountService, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.g
        protected void a(String str, String str2, String str3) {
            boolean z16;
            boolean z17;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3);
                return;
            }
            boolean z19 = false;
            if (str3 != null && str2 != null && str != null) {
                if (SubAccountBindHandler.this.f291075d != null && str2.equalsIgnoreCase(this.f291076d.f291124d) && str.equalsIgnoreCase(SubAccountBindHandler.this.f291075d.getAccount())) {
                    this.f291077e.updateA2(str2, str3, this.f291078f);
                    h.J(SubAccountBindHandler.this.f291075d, (byte) 1, str2);
                    com.tencent.mobileqq.subaccount.logic.a aVar = this.f291076d;
                    aVar.f291131k = true;
                    SubAccountBindHandler.this.notifyUI(2, true, aVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("handlerGetBindSubAccount() onGetKeyBack error happen 1 ? =>app:");
                    if (SubAccountBindHandler.this.f291075d == null) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    sb5.append(z18);
                    sb5.append(" subUin:");
                    sb5.append(str2.equalsIgnoreCase(this.f291076d.f291124d));
                    sb5.append(" mainAccount:");
                    if (SubAccountBindHandler.this.f291075d != null && str.equalsIgnoreCase(SubAccountBindHandler.this.f291075d.getAccount())) {
                        z19 = true;
                    }
                    sb5.append(z19);
                    QLog.d("SUB_ACCOUNT", 2, sb5.toString());
                }
                SubAccountBindHandler.this.notifyUI(2, true, this.f291076d);
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("handlerGetBindSubAccount() onGetKeyBack key is null or ? happen 0 ? =>");
                if (str3 == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb6.append(z16);
                if (str2 == null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb6.append(z17);
                if (str == null) {
                    z19 = true;
                }
                sb6.append(z19);
                QLog.e("SUB_ACCOUNT", 2, sb6.toString());
            }
            SubAccountBindHandler.this.notifyUI(2, true, this.f291076d);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25682);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f291072e = "OidbSvc.0x7a0_0";
        f291073f = "OidbSvc.0x7a1_0";
        f291074h = "OidbSvc.0x7a2_0";
    }

    SubAccountBindHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f291075d = appInterface;
        }
    }

    @Nullable
    private oidb_sso$OIDBSSOPkg G2(int i3, byte[] bArr, com.tencent.mobileqq.subaccount.logic.a aVar, String str, String str2, String str3, int i16, String str4) {
        if (i3 != 1000) {
            return null;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "getPkg InvalidProtocolBufferMicroException");
            }
            e16.printStackTrace();
        }
        if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
            if (oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                return oidb_sso_oidbssopkg;
            }
            R2("12008", str4, str2, str3, false);
            aVar.f291121a = 1000;
            notifyUI(i16, false, aVar);
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "getPkg !pkg.bytes_bodybuffer.has() || pkg.bytes_bodybuffer.get() == null");
            }
            return null;
        }
        R2("12008", str, str2, str3, false);
        aVar.f291121a = 1001;
        notifyUI(i16, false, aVar);
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getPkg !pkg.uint32_result.has() || pkg.uint32_result.get() != 0");
        }
        return null;
    }

    private void H2(ToServiceMsg toServiceMsg, String str, String str2, String str3, com.tencent.mobileqq.subaccount.logic.a aVar, oidb_0x7a0$RspBody oidb_0x7a0_rspbody, int i3) {
        boolean z16;
        boolean z17 = true;
        if (i3 == 0) {
            R2("12009", "sucess_0", "bindhandle", "actSBDBindProtol", true);
            aVar.f291121a = 0;
            ISubAccountService iSubAccountService = (ISubAccountService) this.f291075d.getRuntimeService(ISubAccountService.class, "");
            String string = toServiceMsg.extraData.getString("subaccount_a2");
            if (iSubAccountService != null) {
                iSubAccountService.updateSubAccountInfo(aVar);
                iSubAccountService.setStatus(str2, 1);
                iSubAccountService.updateA2(str2, string, true);
            }
            h.J(this.f291075d, (byte) 1, str2);
            h.w(this.f291075d, false, str2);
            h.G(this.f291075d, str2, false);
            if (!((ISubAccountConfigApi) QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
                ((ISubAccountServlet) QRoute.api(ISubAccountServlet.class)).fetchOneTroopNewMsg(this.f291075d, str2);
            }
            if (((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getAccountManagerName().equals(str3)) {
                ReportController.o(this.f291075d, "CliOper", "", "", "0X8004003", "0X8004003", 0, 0, "", "", "", "");
            }
        } else {
            String str4 = "Bind_fail_rsp_" + i3;
            if (i3 != 1000 && i3 != 1001) {
                z16 = false;
            } else {
                z16 = true;
            }
            R2("12011", str4, "bindhandle", "actSBDBindProtol", z16);
            aVar.f291122b = oidb_0x7a0_rspbody.str_errmsg.get();
            if (i3 != 1000) {
                if (i3 != 1001) {
                    if (Q2(i3)) {
                        String valueOf = String.valueOf(oidb_0x7a0_rspbody.uint64_err_uin.get());
                        if (str2 != null && valueOf.equalsIgnoreCase(str2)) {
                            aVar.f291121a = 1004;
                            this.f291075d.updateSubAccountLogin(aVar.f291124d, false);
                            if (QLog.isColorLevel()) {
                                QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_SUBACCOUNT_A2_ERROR");
                            }
                        } else if (str != null && str.equalsIgnoreCase(valueOf)) {
                            aVar.f291121a = 1005;
                            if (QLog.isColorLevel()) {
                                QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_MAINACCOUNT_A2_ERROR");
                            }
                        } else {
                            aVar.f291121a = 1000;
                            if (QLog.isColorLevel()) {
                                QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_UNKNOW");
                            }
                        }
                    } else if (i3 == 1221) {
                        aVar.f291121a = 1011;
                        if (QLog.isColorLevel()) {
                            QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_EQLIP_LOCK_FAIL");
                        }
                    } else {
                        aVar.f291121a = 1000;
                        if (QLog.isColorLevel()) {
                            QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_UNKNOW");
                        }
                    }
                } else {
                    aVar.f291121a = 1003;
                    if (QLog.isColorLevel()) {
                        QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_SUB_HADBIND_ANOTHER");
                    }
                }
            } else {
                aVar.f291121a = 1002;
                if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_MAIN_HADBIND_ANOTHER");
                }
            }
            z17 = false;
        }
        notifyUI(0, z17, aVar);
    }

    private void I2(com.tencent.mobileqq.subaccount.logic.a aVar, oidb_0x7a2$RspBody oidb_0x7a2_rspbody) {
        R2("12009", "success_0", "SubBind", "actSBGetbindProtol", true);
        ISubAccountService iSubAccountService = (ISubAccountService) this.f291075d.getRuntimeService(ISubAccountService.class, "");
        ArrayList<String> allSubUin = iSubAccountService.getAllSubUin();
        aVar.f291121a = 0;
        aVar.j(oidb_0x7a2_rspbody, allSubUin);
        ArrayList<String> e16 = aVar.e();
        if (e16 != null && e16.size() > 0) {
            ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) this.f291075d.getRuntimeService(ISubAccountControlService.class, "");
            Iterator<String> it = e16.iterator();
            while (it.hasNext()) {
                iSubAccountControlService.addHintPair(it.next(), 1);
            }
        }
        if (aVar.i()) {
            P2(aVar, iSubAccountService);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount, not has subaccount");
        }
        aVar.f291121a = 1008;
        h.j(this.f291075d, ISubAccountControlService.UIN_ALL);
        notifyUI(2, true, aVar);
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2;
        String str3;
        oidb_0x7a0$RspBody oidb_0x7a0_rspbody;
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() time = " + System.currentTimeMillis());
        }
        if (toServiceMsg != null) {
            str = toServiceMsg.getUin();
            str2 = toServiceMsg.extraData.getString("subAccount");
            str3 = toServiceMsg.extraData.getString("fromWhere");
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
        try {
            if (M2(toServiceMsg, fromServiceMsg, aVar, 0, "", "")) {
                return;
            }
            int resultCode = fromServiceMsg.getResultCode();
            aVar.f291123c = str;
            aVar.f291124d = str2;
            N2(aVar, resultCode, "actSBDBindProtol", "fali_end_rs_" + resultCode, "bindhandle", 0);
            oidb_sso$OIDBSSOPkg G2 = G2(resultCode, (byte[]) obj, aVar, "uint32_not_rs", "bindhandle", "actSBDBindProtol", 0, "body_buff_not");
            if (G2 == null) {
                return;
            }
            byte[] byteArray = G2.bytes_bodybuffer.get().toByteArray();
            oidb_0x7a0$RspBody oidb_0x7a0_rspbody2 = new oidb_0x7a0$RspBody();
            try {
                oidb_0x7a0_rspbody = oidb_0x7a0_rspbody2.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() oidb_0x7a0 parseFrom byte InvalidProtocolBufferMicroException");
                }
                e16.printStackTrace();
                oidb_0x7a0_rspbody = oidb_0x7a0_rspbody2;
            }
            int i3 = oidb_0x7a0_rspbody.uint32_result.get();
            aVar.f291129i = i3;
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() rspResult = " + i3);
            }
            H2(toServiceMsg, str, str2, str3, aVar, oidb_0x7a0_rspbody, i3);
        } catch (Exception e17) {
            e17.printStackTrace();
            R2("12013", "exception", "bindhandle", "actSBDBindProtol", false);
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() last exception errormsg = " + e17.getMessage());
            }
        }
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount:");
        }
        com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
        try {
            if (M2(toServiceMsg, fromServiceMsg, aVar, 2, "actSBGetbindProtol", "SubBind")) {
                return;
            }
            int resultCode = fromServiceMsg.getResultCode();
            aVar.f291123c = toServiceMsg.getUin();
            L2(toServiceMsg, aVar, resultCode);
            oidb_sso$OIDBSSOPkg G2 = G2(resultCode, (byte[]) obj, aVar, "pkguint32_null", "SubBind", "actSBGetbindProtol", 2, "bytebody_null");
            if (G2 == null) {
                return;
            }
            byte[] byteArray = G2.bytes_bodybuffer.get().toByteArray();
            oidb_0x7a2$RspBody oidb_0x7a2_rspbody = new oidb_0x7a2$RspBody();
            try {
                oidb_0x7a2_rspbody = oidb_0x7a2_rspbody.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: parseFrom byte InvalidProtocolBufferMicroException ");
                }
                e16.printStackTrace();
            }
            int i3 = oidb_0x7a2_rspbody.uint32_result.get();
            aVar.f291129i = i3;
            aVar.f291122b = oidb_0x7a2_rspbody.str_errmsg.get();
            if (i3 == 0) {
                I2(aVar, oidb_0x7a2_rspbody);
                return;
            }
            R2("12011", "rspResult_" + i3, "SubBind", "actSBGetbindProtol", false);
            if (Q2(i3)) {
                aVar.f291121a = 1005;
                if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: get main account a2 error rspResult = " + i3);
                }
            } else {
                aVar.f291121a = 1000;
                aVar.f291131k = true;
                if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: get main account error rspResult = " + i3);
                }
            }
            notifyUI(2, false, aVar);
        } catch (Exception e17) {
            R2("12013", "exception", "SubBind", "actSBGetbindProtol", false);
            e17.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: exception happen e = " + e17.getMessage());
            }
        }
    }

    private void L2(ToServiceMsg toServiceMsg, com.tencent.mobileqq.subaccount.logic.a aVar, int i3) {
        if (i3 == 1000) {
            return;
        }
        if (i3 == 2901) {
            int i16 = toServiceMsg.extraData.getInt("fastResendCount", 0);
            byte[] byteArray = toServiceMsg.extraData.getByteArray("request_ByteArray");
            ToServiceMsg createToServiceMsg = createToServiceMsg(f291074h);
            int i17 = i16 + 1;
            if (i17 < 3) {
                createToServiceMsg.setEnableFastResend(true);
                createToServiceMsg.extraData.putInt("fastResendCount", i17);
                createToServiceMsg.extraData.putByteArray("request_ByteArray", byteArray);
            }
            createToServiceMsg.putWupBuffer(byteArray);
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount() result==2901, resend count=" + i16 + " setFastResend=" + createToServiceMsg.isFastResendEnabled());
            }
            sendPbReq(createToServiceMsg);
            return;
        }
        aVar.f291131k = true;
        N2(aVar, i3, "actSBGetbindProtol", "result_" + i3, "SubBind", 2);
    }

    private boolean M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, com.tencent.mobileqq.subaccount.logic.a aVar, int i3, String str, String str2) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            R2("12007", "req_null", str2, str, false);
        }
        aVar.f291121a = 1000;
        notifyUI(i3, false, aVar);
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerRespEmpty: req == null || resp == null");
            return true;
        }
        return true;
    }

    private void N2(com.tencent.mobileqq.subaccount.logic.a aVar, int i3, String str, String str2, String str3, int i16) {
        if (i3 == 1000) {
            return;
        }
        if (i3 != 1002 && i3 != 1013) {
            R2("12012", str2, str3, str, false);
            aVar.f291121a = 1000;
            if (QLog.isColorLevel()) {
                QLog.e("SUB_ACCOUNT", 2, "handlerRspFailed ERROR_TYPE_UNKNOWN last");
            }
        } else {
            R2("12010", "timeout", str3, str, false);
            aVar.f291121a = 1007;
            if (QLog.isColorLevel()) {
                QLog.e("SUB_ACCOUNT", 2, "handlerRspFailed ERROR_TYPE_SERVER_TIMEOUT");
            }
        }
        notifyUI(i16, false, aVar);
    }

    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2;
        oidb_0x7a1$RspBody oidb_0x7a1_rspbody;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() start");
        }
        if (toServiceMsg != null) {
            str = toServiceMsg.extraData.getString("subAccount");
            str2 = toServiceMsg.getUin();
        } else {
            str = null;
            str2 = null;
        }
        com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
        try {
            if (M2(toServiceMsg, fromServiceMsg, aVar, 1, "actSBUnbindProtol", "SubBind")) {
                return;
            }
            int resultCode = fromServiceMsg.getResultCode();
            aVar.f291123c = str2;
            aVar.f291124d = str;
            N2(aVar, resultCode, "actSBUnbindProtol", "error", "SubBind", 1);
            oidb_sso$OIDBSSOPkg G2 = G2(resultCode, (byte[]) obj, aVar, "pkg32rs_null", "SubBind", "actSBUnbindProtol", 1, "bytebody_null");
            if (G2 == null) {
                return;
            }
            byte[] byteArray = G2.bytes_bodybuffer.get().toByteArray();
            oidb_0x7a1$RspBody oidb_0x7a1_rspbody2 = new oidb_0x7a1$RspBody();
            try {
                oidb_0x7a1_rspbody = oidb_0x7a1_rspbody2.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() oidb_0x7a1 parseFrom byte InvalidProtocolBufferMicroException");
                }
                e16.printStackTrace();
                oidb_0x7a1_rspbody = oidb_0x7a1_rspbody2;
            }
            int i16 = oidb_0x7a1_rspbody.uint32_result.get();
            aVar.f291129i = i16;
            aVar.f291122b = oidb_0x7a1_rspbody.str_errmsg.get();
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount()  rspResult = " + i16);
            }
            boolean z16 = false;
            if (i16 != 0 && i16 != 1000 && i16 != 1001) {
                R2("12011", "rspResult_" + i16, "SubBind", "actSBUnbindProtol", false);
                if (Q2(i16)) {
                    String valueOf = String.valueOf(oidb_0x7a1_rspbody.uint64_err_uin.get());
                    if (str != null && valueOf.equalsIgnoreCase(str)) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: server error happen subaccount a2 error? not it is not happan");
                        }
                    } else if (str2 != null && str2.equalsIgnoreCase(valueOf)) {
                        aVar.f291121a = 1005;
                        if (QLog.isColorLevel()) {
                            QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_MAINACCOUNT_A2_ERROR");
                        }
                    } else {
                        aVar.f291121a = 1000;
                        if (QLog.isColorLevel()) {
                            QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW");
                        }
                    }
                } else {
                    aVar.f291121a = 1000;
                    if (QLog.isColorLevel()) {
                        QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW");
                    }
                }
                i3 = 1;
            } else {
                R2("12009", "rspResult_0", "SubBind", "actSBUnbindProtol", true);
                aVar.f291121a = 0;
                h.j(this.f291075d, str);
                i3 = 1;
                z16 = true;
            }
            notifyUI(i3, z16, aVar);
        } catch (Exception e17) {
            e17.printStackTrace();
            R2("12013", "exception", "SubBind", "actSBUnbindProtol", false);
            if (QLog.isColorLevel()) {
                QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount:   error e = " + e17.getMessage());
            }
        }
    }

    private void P2(com.tencent.mobileqq.subaccount.logic.a aVar, ISubAccountService iSubAccountService) {
        iSubAccountService.updateSubAccountInfo(aVar);
        ArrayList<String> d16 = aVar.d();
        Iterator<String> it = aVar.f291125e.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            String next = it.next();
            boolean contains = d16.contains(next);
            boolean booleanValue = h.d(this.f291075d, next).second.booleanValue();
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount() subUin=" + next + " isLogin = " + booleanValue);
            }
            if (booleanValue) {
                iSubAccountService.setStatus(next, 1);
                com.tencent.mobileqq.subaccount.logic.a c16 = com.tencent.mobileqq.subaccount.logic.a.c(aVar);
                c16.f291124d = next;
                ((ILoginServletService) this.f291075d.getRuntimeService(ILoginServletService.class, "all")).getSubAccountKey(this.f291075d.getAccount(), c16.f291124d, new a(c16, iSubAccountService, contains));
                z16 = false;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount, has subaccount but islogin is false");
                }
                iSubAccountService.updateA2(next, null, contains);
            }
        }
        if (z16) {
            notifyUI(2, true, aVar);
        }
    }

    private boolean Q2(int i3) {
        if (i3 != 1200 && i3 != 1214 && i3 != 1215 && i3 != 1218 && i3 != 1232 && i3 != 1233 && i3 != 1240 && i3 != 1241 && i3 != 1242) {
            return false;
        }
        return true;
    }

    private void R2(String str, String str2, String str3, String str4, boolean z16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", str);
        hashMap.put(ISubAccountControlService.FAIL_STEP, str2);
        hashMap.put(ISubAccountControlService.FAIL_LOCATION, str3);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f291075d.getCurrentAccountUin(), str4, z16, 0L, 0L, hashMap, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E2(String str, String str2, String str3) {
        byte[] hexToBytes;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "bindSubAccount() start");
        }
        oidb_0x7a0$LoginSig oidb_0x7a0_loginsig = new oidb_0x7a0$LoginSig();
        if (str2 != null) {
            try {
                hexToBytes = PkgTools.hexToBytes(str2);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (hexToBytes != null) {
                oidb_0x7a0_loginsig.bytes_sig.set(ByteStringMicro.copyFrom(hexToBytes));
            }
            oidb_0x7a0_loginsig.uint32_type.set(8);
            oidb_0x7a0_loginsig.uint32_appid.set(16);
            oidb_0x7a0$ReqBody oidb_0x7a0_reqbody = new oidb_0x7a0$ReqBody();
            oidb_0x7a0_reqbody.uint32_flag.set(1);
            oidb_0x7a0_reqbody.msg_bind_uin_sig.set(oidb_0x7a0_loginsig);
            oidb_0x7a0_reqbody.uint64_bind_uin.set(Long.parseLong(str));
            oidb_0x7a0_reqbody.uint32_clt_appid.set(this.f291075d.getAppid());
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1952);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.uint32_service_type.set(0);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x7a0_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(f291072e);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.extraData.putString("subAccount", str);
            createToServiceMsg.extraData.putString("subaccount_a2", str2);
            if (str3 != null) {
                createToServiceMsg.extraData.putString("fromWhere", str3);
            }
            sendPbReq(createToServiceMsg);
        }
        hexToBytes = null;
        if (hexToBytes != null) {
        }
        oidb_0x7a0_loginsig.uint32_type.set(8);
        oidb_0x7a0_loginsig.uint32_appid.set(16);
        oidb_0x7a0$ReqBody oidb_0x7a0_reqbody2 = new oidb_0x7a0$ReqBody();
        oidb_0x7a0_reqbody2.uint32_flag.set(1);
        oidb_0x7a0_reqbody2.msg_bind_uin_sig.set(oidb_0x7a0_loginsig);
        oidb_0x7a0_reqbody2.uint64_bind_uin.set(Long.parseLong(str));
        oidb_0x7a0_reqbody2.uint32_clt_appid.set(this.f291075d.getAppid());
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg2.uint32_command.set(1952);
        oidb_sso_oidbssopkg2.uint32_result.set(0);
        oidb_sso_oidbssopkg2.uint32_service_type.set(0);
        oidb_sso_oidbssopkg2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x7a0_reqbody2.toByteArray()));
        ToServiceMsg createToServiceMsg2 = createToServiceMsg(f291072e);
        createToServiceMsg2.putWupBuffer(oidb_sso_oidbssopkg2.toByteArray());
        createToServiceMsg2.extraData.putString("subAccount", str);
        createToServiceMsg2.extraData.putString("subaccount_a2", str2);
        if (str3 != null) {
        }
        sendPbReq(createToServiceMsg2);
    }

    public void F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getBindSubAccount: start");
        }
        oidb_0x7a2$ReqBody oidb_0x7a2_reqbody = new oidb_0x7a2$ReqBody();
        oidb_0x7a2_reqbody.uint32_flag.set(1);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1954);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x7a2_reqbody.toByteArray()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        ToServiceMsg createToServiceMsg = createToServiceMsg(f291074h);
        createToServiceMsg.setEnableFastResend(true);
        createToServiceMsg.extraData.putInt("fastResendCount", 0);
        createToServiceMsg.extraData.putByteArray("request_ByteArray", byteArray);
        createToServiceMsg.putWupBuffer(byteArray);
        sendPbReq(createToServiceMsg);
    }

    public void S2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "unBindSubAccount: start");
        }
        oidb_0x7a1$ReqBody oidb_0x7a1_reqbody = new oidb_0x7a1$ReqBody();
        oidb_0x7a1_reqbody.uint32_flag.set(1);
        oidb_0x7a1_reqbody.uint64_bind_uin.set(Long.parseLong(str));
        oidb_0x7a1_reqbody.uint32_clt_appid.set(this.f291075d.getAppid());
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1953);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x7a1_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg(f291073f);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putString("subAccount", str);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getPushCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        HashSet hashSet = new HashSet(8);
        hashSet.add(f291073f);
        hashSet.add(f291074h);
        hashSet.add(f291072e);
        return hashSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return dc.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd != null && serviceCmd.length() != 0) {
            if (f291072e.equalsIgnoreCase(serviceCmd)) {
                J2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (f291073f.equalsIgnoreCase(serviceCmd)) {
                O2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (f291074h.equalsIgnoreCase(serviceCmd)) {
                try {
                    K2(toServiceMsg, fromServiceMsg, obj);
                } catch (VerifyError e16) {
                    QLog.e("SUB_ACCOUNT", 2, "handlerGetBindSubAccount VerifyError: " + e16.getMessage());
                }
            }
        }
    }
}
