package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.proto.KidModePassword$ClearPasswdReq;
import com.tencent.mobileqq.studymode.proto.KidModePassword$ClearPasswdRsp;
import com.tencent.mobileqq.studymode.proto.KidModePassword$QueryPasswdStateReq;
import com.tencent.mobileqq.studymode.proto.KidModePassword$QueryPasswdStateRsp;
import com.tencent.mobileqq.studymode.proto.KidModePassword$SetPasswdReq;
import com.tencent.mobileqq.studymode.proto.KidModePassword$SetPasswdRsp;
import com.tencent.mobileqq.studymode.proto.KidModePassword$VerifyPasswdReq;
import com.tencent.mobileqq.studymode.proto.KidModePassword$VerifyPasswdRsp;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.List;
import java.util.Random;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8$PhoneInfo;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8$ReqBody;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8$RspBody;
import tencent.im.oidb.cmd0xed1.oidb_0xed1$ReqBody;
import tencent.im.oidb.cmd0xed2.oidb_0xed2$ReqBody;
import tencent.im.oidb.cmd0xed2.oidb_0xed2$RspBody;
import tencent.im.oidb.oidb_0x87a$ReqBody;
import tencent.im.oidb.oidb_0x87a$RspBody;
import tencent.im.oidb.oidb_0x87c$ReqBody;
import tencent.im.oidb.oidb_0x87c$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class KidModeServlet extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    static b f290903d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class ClearPasswordHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        ClearPasswordHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static KidModeObserver.ClearPasswordResult decodeClearPassword(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                KidModePassword$ClearPasswdRsp kidModePassword$ClearPasswdRsp = new KidModePassword$ClearPasswdRsp();
                try {
                    kidModePassword$ClearPasswdRsp.mergeFrom(bArr);
                    KidModeObserver.ClearPasswordResult clearPasswordResult = new KidModeObserver.ClearPasswordResult();
                    if (kidModePassword$ClearPasswdRsp.err_code.get() != 0) {
                        QLog.i("KidModeServlet", 1, "decodeClearPassword, err=" + kidModePassword$ClearPasswdRsp.err_code.get() + ", " + kidModePassword$ClearPasswdRsp.err_msg.get());
                        clearPasswordResult.errCode = kidModePassword$ClearPasswdRsp.err_code.get();
                        clearPasswordResult.errMessage = kidModePassword$ClearPasswdRsp.err_msg.get();
                    }
                    return clearPasswordResult;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.w("KidModeServlet", 1, "decodeClearPassword, " + e16);
                }
            }
            return null;
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
                return;
            }
            KidModeObserver.ClearPasswordResult decodeClearPassword = decodeClearPassword(KidModeServlet.j(fromServiceMsg));
            bundle.putSerializable("NOTIFY_RESULT_OBJECT", decodeClearPassword);
            if (decodeClearPassword != null && decodeClearPassword.errCode == 0) {
                StudyModeManager.M(3);
            }
            kidModeServlet.notifyObserver(intent, 11, true, bundle, KidModeObserver.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class GetKidModeStatusHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        GetKidModeStatusHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z28 = false;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    oidb_sso$OIDBSSOPkg i3 = KidModeServlet.i(fromServiceMsg);
                    if (fromServiceMsg.isSuccess() && i3 != null) {
                        int i16 = i3.get().uint32_result.get();
                        if (i16 == 0) {
                            oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                            oidb_0x5eb_rspbody.mergeFrom(i3.bytes_bodybuffer.get().toByteArray());
                            if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has()) {
                                try {
                                    oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0);
                                    int i17 = oidb_0x5eb_udcuindata.uint32_flag_study_mode_switch.get();
                                    int i18 = oidb_0x5eb_udcuindata.uint32_flag_kid_mode_switch.get();
                                    int i19 = oidb_0x5eb_udcuindata.uint32_flag_kid_mode_need_phone_verify.get();
                                    int i26 = oidb_0x5eb_udcuindata.uint32_flag_kid_mode_can_search_friends.get();
                                    int i27 = oidb_0x5eb_udcuindata.uint32_flag_kid_mode_can_pull_group.get();
                                    int i28 = oidb_0x5eb_udcuindata.uint32_flag_kid_mode_can_search_by_strangers.get();
                                    int i29 = oidb_0x5eb_udcuindata.uint32_kid_mode_child_birthday.get();
                                    int i36 = oidb_0x5eb_udcuindata.uint32_kid_mode_can_net_search.get();
                                    int i37 = oidb_0x5eb_udcuindata.uint32_flag_kid_mode_can_filter_url.get();
                                    bundle.putInt("SIMPLE_MODE_SWITCH", i17);
                                    bundle.putInt("KID_MODE_SWITCH", i18);
                                    bundle.putInt("KID_MODE_NEED_VERIFY", i19);
                                    bundle.putInt("KID_MODE_PULL_GROUP", i27);
                                    bundle.putInt("KID_MODE_SEARCH_FRIENDS", i26);
                                    bundle.putInt("KID_MODE_SEARCH_BY_STRANGERS", i28);
                                    bundle.putInt("KID_MODE_NET_SEARCH", i36);
                                    bundle.putInt("KID_MODE_URL_FILTER", i37);
                                    if (i28 == 0) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    StudyModeManager.W(16, z17);
                                    if (i26 == 0) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    StudyModeManager.W(8, z18);
                                    if (i27 == 0) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    StudyModeManager.W(32, z19);
                                    if (i36 != 0) {
                                        z26 = true;
                                    } else {
                                        z26 = false;
                                    }
                                    StudyModeManager.W(128, z26);
                                    if (i37 != 1) {
                                        z27 = true;
                                    } else {
                                        z27 = false;
                                    }
                                    StudyModeManager.W(80, z27);
                                    if (i37 != 0) {
                                        z28 = true;
                                    }
                                    StudyModeManager.W(96, z28);
                                    StudyModeManager.V(i29);
                                    StudyModeManager.L(i19);
                                    z28 = true;
                                } catch (InvalidProtocolBufferMicroException e16) {
                                    e = e16;
                                    z28 = true;
                                    QLog.e("KidModeServlet", 1, "respGetKidModeStatus get a error: ", e);
                                    kidModeServlet.notifyObserver(intent, 3, z28, bundle, KidModeObserver.class);
                                    return;
                                }
                            } else {
                                QLog.d("KidModeServlet", 1, "respGetKidModeStatus fail, udc is null");
                            }
                        } else {
                            QLog.d("KidModeServlet", 1, "respGetKidModeStatus fail, result: ", Integer.valueOf(i16));
                        }
                    } else {
                        Object[] objArr = new Object[4];
                        objArr[0] = "respGetKidModeStatus fail, response isSuccess: ";
                        objArr[1] = Boolean.valueOf(fromServiceMsg.isSuccess());
                        objArr[2] = "pkg isNull: ";
                        if (i3 == null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objArr[3] = Boolean.valueOf(z16);
                        QLog.d("KidModeServlet", 1, objArr);
                    }
                } catch (InvalidProtocolBufferMicroException e17) {
                    e = e17;
                }
                kidModeServlet.notifyObserver(intent, 3, z28, bundle, KidModeObserver.class);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class GetPhoneBindStatusHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        GetPhoneBindStatusHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            Bundle bundle2;
            Bundle bundle3;
            oidb_sso$OIDBSSOPkg i3;
            Bundle bundle4;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            z16 = false;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    i3 = KidModeServlet.i(fromServiceMsg);
                } catch (Exception e16) {
                    e = e16;
                    bundle2 = bundle;
                }
                if (i3 != null && fromServiceMsg.isSuccess() && i3.uint32_result.get() == 0 && i3.bytes_bodybuffer.has()) {
                    oidb_0xeb8$RspBody oidb_0xeb8_rspbody = new oidb_0xeb8$RspBody();
                    oidb_0xeb8_rspbody.mergeFrom(i3.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0xeb8_rspbody.uint32_check_result.get() > 0) {
                        try {
                            bundle4 = new Bundle();
                        } catch (Exception e17) {
                            e = e17;
                            bundle4 = bundle;
                        }
                        try {
                            if (oidb_0xeb8_rspbody.str_mibao_change_url.has()) {
                                bundle4.putString("mibao_change_url", oidb_0xeb8_rspbody.str_mibao_change_url.get());
                            }
                            if (oidb_0xeb8_rspbody.str_mibao_set_url.has()) {
                                bundle4.putString("mibao_set_url", oidb_0xeb8_rspbody.str_mibao_set_url.get());
                            }
                            if (oidb_0xeb8_rspbody.str_mibao_verify_url.has()) {
                                bundle4.putString("mibao_verify_url", oidb_0xeb8_rspbody.str_mibao_verify_url.get());
                            }
                            if (oidb_0xeb8_rspbody.rpt_phone_info.has()) {
                                List<oidb_0xeb8$PhoneInfo> list = oidb_0xeb8_rspbody.rpt_phone_info.get();
                                Bundle[] bundleArr = new Bundle[list.size()];
                                for (int i17 = 0; i17 < list.size(); i17++) {
                                    oidb_0xeb8$PhoneInfo oidb_0xeb8_phoneinfo = list.get(i17);
                                    if (oidb_0xeb8_phoneinfo != null) {
                                        Bundle bundle5 = new Bundle();
                                        if (oidb_0xeb8_phoneinfo.uint32_phone_type.has()) {
                                            bundle5.putInt("phone_type", oidb_0xeb8_phoneinfo.uint32_phone_type.get());
                                            i16 = oidb_0xeb8_phoneinfo.uint32_phone_type.get();
                                        } else {
                                            i16 = -1;
                                        }
                                        if (oidb_0xeb8_phoneinfo.str_country_code.has()) {
                                            bundle5.putString("country_code", oidb_0xeb8_phoneinfo.str_country_code.get());
                                            if (i16 == 1) {
                                                bundle4.putString("country_code", oidb_0xeb8_phoneinfo.str_country_code.get());
                                            }
                                        }
                                        if (oidb_0xeb8_phoneinfo.str_phone.has()) {
                                            bundle5.putString("phone", oidb_0xeb8_phoneinfo.str_phone.get());
                                            if (i16 == 1) {
                                                bundle4.putString("phone", oidb_0xeb8_phoneinfo.str_phone.get());
                                            }
                                        }
                                        if (oidb_0xeb8_phoneinfo.uint32_phone_status.has()) {
                                            bundle5.putInt("status", oidb_0xeb8_phoneinfo.uint32_phone_status.get());
                                            if (i16 == 1) {
                                                bundle4.putInt("status", oidb_0xeb8_phoneinfo.uint32_phone_status.get());
                                            }
                                        }
                                        if (oidb_0xeb8_phoneinfo.bytes_vas_phone.has()) {
                                            bundle5.putByteArray("vaskey", oidb_0xeb8_phoneinfo.bytes_vas_phone.get().toByteArray());
                                        }
                                        bundleArr[i17] = bundle5;
                                    }
                                }
                                bundle4.putParcelableArray("phone_info", bundleArr);
                            }
                            z16 = true;
                            bundle3 = bundle4;
                        } catch (Exception e18) {
                            e = e18;
                            z16 = true;
                            bundle2 = bundle4;
                            bundle3 = bundle2;
                            if (QLog.isColorLevel()) {
                                QLog.d("KidModeServlet", 1, "onGetPhoneBindInfo error:" + e.getMessage());
                                bundle3 = bundle2;
                            }
                            kidModeServlet.notifyObserver(intent, 7, z16, bundle3, KidModeObserver.class);
                            return;
                        }
                        kidModeServlet.notifyObserver(intent, 7, z16, bundle3, KidModeObserver.class);
                        return;
                    }
                }
                bundle3 = bundle;
                kidModeServlet.notifyObserver(intent, 7, z16, bundle3, KidModeObserver.class);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class GetSmsCodeHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        GetSmsCodeHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    oidb_sso$OIDBSSOPkg i3 = KidModeServlet.i(fromServiceMsg);
                    if (fromServiceMsg.isSuccess() && i3 != null) {
                        int i16 = i3.uint32_result.get();
                        bundle.putInt("REQ_RESULT", i16);
                        oidb_0x87a$RspBody oidb_0x87a_rspbody = new oidb_0x87a$RspBody();
                        oidb_0x87a_rspbody.mergeFrom(i3.bytes_bodybuffer.get().toByteArray());
                        bundle.putInt("RESENT_INTERVAL_TIMEOUT", oidb_0x87a_rspbody.uint32_resend_interval.get());
                        if (i16 == 0) {
                            z17 = true;
                        } else {
                            if (i3.str_error_msg.has()) {
                                bundle.putString("REQ_RESULT_MSG", i3.str_error_msg.get());
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("KidModeServlet", 1, "respGetSmsCode fail, result: ", Integer.valueOf(i16));
                            }
                        }
                    } else {
                        Object[] objArr = new Object[4];
                        objArr[0] = "respVerifySmsCode fail, response isSuccess: ";
                        objArr[1] = Boolean.valueOf(fromServiceMsg.isSuccess());
                        objArr[2] = "pkg isNull: ";
                        if (i3 == null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objArr[3] = Boolean.valueOf(z16);
                        QLog.d("KidModeServlet", 1, objArr);
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("KidModeServlet", 1, "respGetSmsCode get a error: ", e16);
                }
                kidModeServlet.notifyObserver(intent, 4, z17, bundle, KidModeObserver.class);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class KidModeAdvancedSetChildBirthdayHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        KidModeAdvancedSetChildBirthdayHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                oidb_sso$OIDBSSOPkg i3 = KidModeServlet.i(fromServiceMsg);
                if (fromServiceMsg.isSuccess() && i3 != null) {
                    int i16 = i3.get().uint32_result.get();
                    if (i16 == 0) {
                        z17 = true;
                    } else {
                        QLog.d("KidModeServlet", 1, "KidModeAdvancedSetChildBirthdayRsp fail, result: ", Integer.valueOf(i16));
                    }
                } else {
                    Object[] objArr = new Object[4];
                    objArr[0] = "KidModeAdvancedSetChildBirthdayRsp fail, response isSuccess: ";
                    objArr[1] = Boolean.valueOf(fromServiceMsg.isSuccess());
                    objArr[2] = "pkg isNull: ";
                    if (i3 == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    objArr[3] = Boolean.valueOf(z16);
                    QLog.d("KidModeServlet", 1, objArr);
                }
                bundle.putInt("advance_setting_field", 64);
                kidModeServlet.notifyObserver(intent, 1, z17, bundle, KidModeObserver.class);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class QueryPasswordStateHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        QueryPasswordStateHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static KidModeObserver.QueryPasswordStateResult decodeQueryPasswordState(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                KidModePassword$QueryPasswdStateRsp kidModePassword$QueryPasswdStateRsp = new KidModePassword$QueryPasswdStateRsp();
                try {
                    kidModePassword$QueryPasswdStateRsp.mergeFrom(bArr);
                    KidModeObserver.QueryPasswordStateResult queryPasswordStateResult = new KidModeObserver.QueryPasswordStateResult();
                    if (kidModePassword$QueryPasswdStateRsp.err_code.get() != 0) {
                        QLog.w("KidModeServlet", 1, "decodeQueryPasswordState, server return error, err=" + kidModePassword$QueryPasswdStateRsp.err_code.get() + " ," + kidModePassword$QueryPasswdStateRsp.err_msg.get());
                        queryPasswordStateResult.errCode = kidModePassword$QueryPasswdStateRsp.err_code.get();
                        queryPasswordStateResult.errMessage = kidModePassword$QueryPasswdStateRsp.err_msg.get();
                        return queryPasswordStateResult;
                    }
                    queryPasswordStateResult.passwordState = kidModePassword$QueryPasswdStateRsp.state.get();
                    queryPasswordStateResult.salt = kidModePassword$QueryPasswdStateRsp.sha256_rounds2_params.salt.get();
                    return queryPasswordStateResult;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("KidModeServlet", 1, "decodeQueryPasswordState fail, " + e16);
                    return null;
                }
            }
            QLog.w("KidModeServlet", 1, "decodeQueryPasswordState fail, data is null");
            return null;
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
                return;
            }
            KidModeObserver.QueryPasswordStateResult decodeQueryPasswordState = decodeQueryPasswordState(KidModeServlet.j(fromServiceMsg));
            bundle.putSerializable("NOTIFY_RESULT_OBJECT", decodeQueryPasswordState);
            if (decodeQueryPasswordState != null) {
                StudyModeManager.N(decodeQueryPasswordState.passwordState, decodeQueryPasswordState.salt);
            }
            kidModeServlet.notifyObserver(intent, 8, true, bundle, KidModeObserver.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface ResponseHandler extends Serializable {
        void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class SendSmsTokenHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        SendSmsTokenHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    oidb_sso$OIDBSSOPkg i3 = KidModeServlet.i(fromServiceMsg);
                    if (fromServiceMsg.isSuccess() && i3 != null) {
                        int i16 = i3.uint32_result.get();
                        if (i16 == 0) {
                            oidb_0xed2$RspBody oidb_0xed2_rspbody = new oidb_0xed2$RspBody();
                            oidb_0xed2_rspbody.mergeFrom(i3.bytes_bodybuffer.get().toByteArray());
                            int i17 = oidb_0xed2_rspbody.uint32_result.get();
                            if (i17 == 0) {
                                z17 = true;
                            } else {
                                QLog.d("KidModeServlet", 1, "respSendSmsToken fail, uint32_result result: ", Integer.valueOf(i17));
                            }
                        } else {
                            QLog.d("KidModeServlet", 1, "respSendSmsToken fail, pkg header result: ", Integer.valueOf(i16));
                        }
                    } else {
                        Object[] objArr = new Object[4];
                        objArr[0] = "respSendSmsToken fail, response isSuccess: ";
                        objArr[1] = Boolean.valueOf(fromServiceMsg.isSuccess());
                        objArr[2] = "pkg isNull: ";
                        if (i3 == null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objArr[3] = Boolean.valueOf(z16);
                        QLog.d("KidModeServlet", 1, objArr);
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("KidModeServlet", 1, "respVerifySmsCode get a error: ", e16);
                }
                kidModeServlet.notifyObserver(intent, 2, z17, bundle, KidModeObserver.class);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class SetAdvanceSettingSwitchHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        SetAdvanceSettingSwitchHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
                return;
            }
            if (fromServiceMsg.isSuccess()) {
                oidb_sso$OIDBSSOPkg i3 = KidModeServlet.i(fromServiceMsg);
                if (i3 != null) {
                    int i16 = i3.uint32_result.get();
                    if (i16 == 0) {
                        int i17 = bundle.getInt("advance_setting_field");
                        int i18 = bundle.getInt("advance_setting_value");
                        if (i17 != 8 && i17 != 16 && i17 != 32) {
                            if (i17 == 128) {
                                if (i18 != 0) {
                                    z16 = true;
                                }
                                StudyModeManager.W(i17, z16);
                            } else if (i17 == 80) {
                                if (i18 != 1) {
                                    z16 = true;
                                }
                                StudyModeManager.W(i17, z16);
                            }
                        } else {
                            if (i18 == 0) {
                                z16 = true;
                            }
                            StudyModeManager.W(i17, z16);
                        }
                        z16 = true;
                    } else {
                        QLog.d("KidModeServlet", 1, "respSendSetKidMode, oidb result: " + i16);
                    }
                } else {
                    QLog.d("KidModeServlet", 1, "ssoPkg == null");
                }
            } else {
                QLog.d("KidModeServlet", 1, "respSendSetKidMode fail");
            }
            kidModeServlet.notifyObserver(intent, 1, z16, bundle, KidModeObserver.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class SetNewPasswordHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        SetNewPasswordHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static KidModeObserver.SetNewPasswordResult decodeSetNewPassword(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                KidModePassword$SetPasswdRsp kidModePassword$SetPasswdRsp = new KidModePassword$SetPasswdRsp();
                try {
                    kidModePassword$SetPasswdRsp.mergeFrom(bArr);
                    KidModeObserver.SetNewPasswordResult setNewPasswordResult = new KidModeObserver.SetNewPasswordResult();
                    if (kidModePassword$SetPasswdRsp.err_code.get() != 0) {
                        QLog.w("KidModeServlet", 1, "decodeSetNewPassword fail, err=" + kidModePassword$SetPasswdRsp.err_code.get() + ", " + kidModePassword$SetPasswdRsp.err_msg.get());
                        setNewPasswordResult.errCode = kidModePassword$SetPasswdRsp.err_code.get();
                        setNewPasswordResult.errMessage = kidModePassword$SetPasswdRsp.err_msg.get();
                        return setNewPasswordResult;
                    }
                    setNewPasswordResult.token = kidModePassword$SetPasswdRsp.signature.get();
                    return setNewPasswordResult;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("KidModeServlet", 1, "decodeSetNewPassword fail, " + e16);
                    return null;
                }
            }
            QLog.e("KidModeServlet", 1, "decodeSetNewPassword fail, data is empty");
            return null;
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
                return;
            }
            KidModeObserver.SetNewPasswordResult decodeSetNewPassword = decodeSetNewPassword(KidModeServlet.j(fromServiceMsg));
            bundle.putSerializable("NOTIFY_RESULT_OBJECT", decodeSetNewPassword);
            if (decodeSetNewPassword != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            kidModeServlet.notifyObserver(intent, 9, z16, bundle, KidModeObserver.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class VerifyPasswordHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        VerifyPasswordHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static KidModeObserver.VerifyPasswordResult decodeVerifyPassword(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                KidModePassword$VerifyPasswdRsp kidModePassword$VerifyPasswdRsp = new KidModePassword$VerifyPasswdRsp();
                try {
                    kidModePassword$VerifyPasswdRsp.mergeFrom(bArr);
                    KidModeObserver.VerifyPasswordResult verifyPasswordResult = new KidModeObserver.VerifyPasswordResult();
                    if (kidModePassword$VerifyPasswdRsp.err_code.get() != 0) {
                        QLog.w("KidModeServlet", 1, "decodeVerifyPassword fail, err=" + kidModePassword$VerifyPasswdRsp.err_code.get() + ", " + kidModePassword$VerifyPasswdRsp.err_msg.get());
                        verifyPasswordResult.errCode = kidModePassword$VerifyPasswdRsp.err_code.get();
                        verifyPasswordResult.errMessage = kidModePassword$VerifyPasswdRsp.err_msg.get();
                        return verifyPasswordResult;
                    }
                    verifyPasswordResult.token = kidModePassword$VerifyPasswdRsp.signature.get();
                    return verifyPasswordResult;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("KidModeServlet", 1, "decodeVerifyPassword fail, " + e16);
                    return null;
                }
            }
            QLog.w("KidModeServlet", 1, "decodeVerifyPassword fail, data is null");
            return null;
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
            } else {
                bundle.putSerializable("NOTIFY_RESULT_OBJECT", decodeVerifyPassword(KidModeServlet.j(fromServiceMsg)));
                kidModeServlet.notifyObserver(intent, 10, true, bundle, KidModeObserver.class);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class VerifySmsCodeHandler implements ResponseHandler {
        static IPatchRedirector $redirector_;

        VerifySmsCodeHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
        public void handle(KidModeServlet kidModeServlet, Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    oidb_sso$OIDBSSOPkg i3 = KidModeServlet.i(fromServiceMsg);
                    if (fromServiceMsg.isSuccess() && i3 != null) {
                        int i16 = i3.uint32_result.get();
                        if (i16 == 0) {
                            try {
                                oidb_0x87c$RspBody oidb_0x87c_rspbody = new oidb_0x87c$RspBody();
                                oidb_0x87c_rspbody.mergeFrom(i3.bytes_bodybuffer.get().toByteArray());
                                byte[] byteArray = oidb_0x87c_rspbody.bytes_key.get().toByteArray();
                                int i17 = oidb_0x87c_rspbody.uint32_key_type.get();
                                bundle.putByteArray("SMS_TOKEN", byteArray);
                                bundle.putInt("SMS_TOKEN_TYPE", i17);
                                z17 = true;
                            } catch (InvalidProtocolBufferMicroException e16) {
                                e = e16;
                                z17 = true;
                                QLog.e("KidModeServlet", 1, "respVerifySmsCode get a error: ", e);
                                kidModeServlet.notifyObserver(intent, 5, z17, bundle, KidModeObserver.class);
                                return;
                            }
                        } else {
                            QLog.d("KidModeServlet", 1, "respVerifySmsCode fail, pkg result: ", Integer.valueOf(i16));
                        }
                    } else {
                        Object[] objArr = new Object[4];
                        objArr[0] = "respVerifySmsCode fail, response isSuccess: ";
                        objArr[1] = Boolean.valueOf(fromServiceMsg.isSuccess());
                        objArr[2] = "pkg isNull: ";
                        if (i3 == null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objArr[3] = Boolean.valueOf(z16);
                        QLog.d("KidModeServlet", 1, objArr);
                    }
                } catch (InvalidProtocolBufferMicroException e17) {
                    e = e17;
                }
                kidModeServlet.notifyObserver(intent, 5, z17, bundle, KidModeObserver.class);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, kidModeServlet, intent, fromServiceMsg, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a implements b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeServlet.b
        public void a(QQAppInterface qQAppInterface, int i3, String str, int i16, byte[] bArr, Bundle bundle, ResponseHandler responseHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, qQAppInterface, Integer.valueOf(i3), str, Integer.valueOf(i16), bArr, bundle, responseHandler);
                return;
            }
            if (i3 != 0) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.uint32_command.set(i3);
                oidb_sso_oidbssopkg.uint32_service_type.set(i16);
                oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
                qQAppInterface.startServlet(KidModeServlet.f(qQAppInterface, str, oidb_sso_oidbssopkg.toByteArray(), bundle, responseHandler));
                return;
            }
            qQAppInterface.startServlet(KidModeServlet.f(qQAppInterface, str, bArr, bundle, responseHandler));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(QQAppInterface qQAppInterface, int i3, String str, int i16, byte[] bArr, Bundle bundle, ResponseHandler responseHandler);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75680);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f290903d = new a();
        }
    }

    public KidModeServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static byte[] d(byte[] bArr) {
        try {
            return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(bArr);
        } catch (Exception e16) {
            QLog.i("KidModeServlet", 1, "hash password fail, " + e16);
            return null;
        }
    }

    public static void e(QQAppInterface qQAppInterface, String str, String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            KidModePassword$ClearPasswdReq kidModePassword$ClearPasswdReq = new KidModePassword$ClearPasswdReq();
            kidModePassword$ClearPasswdReq.scene_id.set(1);
            kidModePassword$ClearPasswdReq.auth_method.set(1);
            kidModePassword$ClearPasswdReq.face_key.setHasFlag(true);
            kidModePassword$ClearPasswdReq.face_key.nonce.set(str);
            kidModePassword$ClearPasswdReq.face_key.id_key.set(str2);
            kidModePassword$ClearPasswdReq.nonce.set(h());
            kidModePassword$ClearPasswdReq.timestamp.set(k());
            r(qQAppInterface, "trpc.passwd.manager.PasswdManager.ClearPasswd", kidModePassword$ClearPasswdReq.toByteArray(), new ClearPasswordHandler());
            return;
        }
        QLog.w("KidModeServlet", 1, "clearPassword, invalid arguments");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NewIntent f(QQAppInterface qQAppInterface, String str, byte[] bArr, Bundle bundle, ResponseHandler responseHandler) {
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), KidModeServlet.class);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", bArr);
        newIntent.putExtra("extensionField", bundle);
        newIntent.putExtra("responseHandler", responseHandler);
        return newIntent;
    }

    private static oidb_sso$OIDBSSOPkg g(int i3, int i16) {
        byte[] byteArray;
        int i17 = 74;
        int i18 = 1415;
        if (i3 == 128) {
            oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
            oidb_0x587_reqbody.uint32_kid_mode_can_net_search.set(i16);
            byteArray = oidb_0x587_reqbody.toByteArray();
        } else if (i3 == 80) {
            oidb_0x587$ReqBody oidb_0x587_reqbody2 = new oidb_0x587$ReqBody();
            oidb_0x587_reqbody2.uint32_kid_mode_can_filter_url.set(i16);
            byteArray = oidb_0x587_reqbody2.toByteArray();
        } else {
            oidb_0xed1$ReqBody oidb_0xed1_reqbody = new oidb_0xed1$ReqBody();
            if (i3 != 4) {
                if (i3 != 8) {
                    if (i3 != 16) {
                        if (i3 == 32) {
                            oidb_0xed1_reqbody.uint32_can_join_group.set(i16);
                        }
                    } else {
                        oidb_0xed1_reqbody.uint32_other_can_search.set(i16);
                    }
                } else {
                    oidb_0xed1_reqbody.uint32_can_search.set(i16);
                }
            } else {
                oidb_0xed1_reqbody.uint32_need_verify.set(i16);
            }
            byteArray = oidb_0xed1_reqbody.toByteArray();
            i18 = 3793;
            i17 = 1;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i18);
        oidb_sso_oidbssopkg.uint32_service_type.set(i17);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(byteArray));
        return oidb_sso_oidbssopkg;
    }

    static long h() {
        return new Random().nextLong();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static oidb_sso$OIDBSSOPkg i(FromServiceMsg fromServiceMsg) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        byte[] bArr = new byte[r3.getInt() - 4];
        ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
        try {
            oidb_sso_oidbssopkg.mergeFrom(bArr);
            return oidb_sso_oidbssopkg;
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("KidModeServlet", 2, "respGetBirthday|oidb_sso parseFrom byte", e16);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] j(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            byte[] bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
            return bArr;
        }
        return null;
    }

    static long k() {
        return System.currentTimeMillis() / 1000;
    }

    static String l(String str, String str2) {
        byte[] d16;
        byte[] d17 = d((1 + str2 + str).getBytes());
        if (d17 == null || (d16 = d(d17)) == null) {
            return "";
        }
        return HexUtil.bytes2HexStr(d16);
    }

    public static void m(QQAppInterface qQAppInterface) {
        KidModePassword$QueryPasswdStateReq kidModePassword$QueryPasswdStateReq = new KidModePassword$QueryPasswdStateReq();
        kidModePassword$QueryPasswdStateReq.scene_id.set(1);
        r(qQAppInterface, "trpc.passwd.manager.PasswdManager.QueryPasswdState", kidModePassword$QueryPasswdStateReq.toByteArray(), new QueryPasswordStateHandler());
    }

    public static void n(QQAppInterface qQAppInterface) {
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(qQAppInterface.getCurrentAccountUin())));
        oidb_0x5eb_reqbody.uint32_flag_study_mode_switch.set(1);
        oidb_0x5eb_reqbody.uint32_flag_kid_mode_switch.set(1);
        oidb_0x5eb_reqbody.uint32_flag_kid_mode_can_pull_group.set(1);
        oidb_0x5eb_reqbody.uint32_flag_kid_mode_can_search_by_strangers.set(1);
        oidb_0x5eb_reqbody.uint32_flag_kid_mode_need_phone_verify.set(1);
        oidb_0x5eb_reqbody.uint32_flag_kid_mode_can_search_friends.set(1);
        oidb_0x5eb_reqbody.uint32_kid_mode_can_net_search.set(1);
        oidb_0x5eb_reqbody.uint32_kid_mode_child_birthday.set(1);
        oidb_0x5eb_reqbody.uint32_flag_kid_mode_can_filter_url.set(1);
        q(qQAppInterface, 1515, "OidbSvc.0x5eb_kidmode", 22, oidb_0x5eb_reqbody.toByteArray(), null, new GetKidModeStatusHandler());
    }

    public static void o(QQAppInterface qQAppInterface, int i3) {
        oidb_0xeb8$ReqBody oidb_0xeb8_reqbody = new oidb_0xeb8$ReqBody();
        oidb_0xeb8_reqbody.uint32_src.set(i3);
        q(qQAppInterface, 3768, "OidbSvc.0xeb9_bindPhone", 1, oidb_0xeb8_reqbody.toByteArray(), null, new GetPhoneBindStatusHandler());
    }

    public static void p(QQAppInterface qQAppInterface, byte[] bArr) {
        oidb_0xed2$ReqBody oidb_0xed2_reqbody = new oidb_0xed2$ReqBody();
        if (bArr != null) {
            oidb_0xed2_reqbody.bytes_signature.set(ByteStringMicro.copyFrom(bArr));
        }
        q(qQAppInterface, 3794, "OidbSvc.0xed2_1", 1, oidb_0xed2_reqbody.toByteArray(), null, new SendSmsTokenHandler());
    }

    static void q(QQAppInterface qQAppInterface, int i3, String str, int i16, byte[] bArr, Bundle bundle, ResponseHandler responseHandler) {
        if (qQAppInterface == null) {
            QLog.e("KidModeServlet", 1, "sendRequest QQAppInterface is null, command is " + str);
            return;
        }
        b bVar = f290903d;
        if (bVar == null) {
            QLog.e("KidModeServlet", 1, "sendRequest, handler is null, command is " + str);
            return;
        }
        bVar.a(qQAppInterface, i3, str, i16, bArr, bundle, responseHandler);
    }

    static void r(QQAppInterface qQAppInterface, String str, byte[] bArr, ResponseHandler responseHandler) {
        q(qQAppInterface, 0, str, 0, bArr, null, responseHandler);
    }

    public static void s(QQAppInterface qQAppInterface, int i3) {
        oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
        oidb_0x587_reqbody.uint32_kid_mode_child_birthday.set(i3);
        q(qQAppInterface, 1415, "OidbSvc.0x587_74", 74, oidb_0x587_reqbody.toByteArray(), null, new KidModeAdvancedSetChildBirthdayHandler());
    }

    public static void t(QQAppInterface qQAppInterface, Bundle bundle) {
        oidb_0x87a$ReqBody oidb_0x87a_reqbody = new oidb_0x87a$ReqBody();
        oidb_0x87a_reqbody.enum_butype.set(1);
        q(qQAppInterface, 2170, "OidbSvc.0x87a_115", 115, oidb_0x87a_reqbody.toByteArray(), bundle, new GetSmsCodeHandler());
    }

    public static void u(QQAppInterface qQAppInterface, String str, String str2, int i3, byte[] bArr) {
        oidb_0xed2$ReqBody oidb_0xed2_reqbody = new oidb_0xed2$ReqBody();
        oidb_0xed2_reqbody.str_country.set(str);
        oidb_0xed2_reqbody.str_telephone.set(str2);
        oidb_0xed2_reqbody.uint32_key_type.set(i3);
        if (bArr != null) {
            oidb_0xed2_reqbody.bytes_key.set(ByteStringMicro.copyFrom(bArr));
        }
        oidb_0xed2_reqbody.enum_reqphonetype.set(1);
        q(qQAppInterface, 3794, "OidbSvc.0xed2_1", 1, oidb_0xed2_reqbody.toByteArray(), null, new SendSmsTokenHandler());
    }

    public static void v(QQAppInterface qQAppInterface, String str) {
        oidb_0x87c$ReqBody oidb_0x87c_reqbody = new oidb_0x87c$ReqBody();
        oidb_0x87c_reqbody.str_sms_code.set(str);
        oidb_0x87c_reqbody.enum_butype.set(1);
        q(qQAppInterface, 2172, "OidbSvc.0x87c_115", 115, oidb_0x87c_reqbody.toByteArray(), null, new VerifySmsCodeHandler());
    }

    public static void w(QQAppInterface qQAppInterface, int i3, int i16) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("KidModeServlet", 2, "setAdvanceSettingSwitch mask: " + i3 + ", value: " + i16);
        }
        if (qQAppInterface == null) {
            QLog.d("KidModeServlet", 2, "sendSetKidModeRequest, app == null");
            return;
        }
        if (i3 == 128) {
            str = "OidbSvc.0x587_74";
        } else {
            str = "OidbSvc.0xed1_1";
        }
        oidb_sso$OIDBSSOPkg g16 = g(i3, i16);
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), KidModeServlet.class);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", g16.toByteArray());
        newIntent.putExtra("advance_setting_field", i3);
        newIntent.putExtra("advance_setting_value", i16);
        newIntent.putExtra("responseHandler", new SetAdvanceSettingSwitchHandler());
        qQAppInterface.startServlet(newIntent);
    }

    public static void x(QQAppInterface qQAppInterface, String str, String str2) {
        if (str != null && str.length() != 0) {
            KidModePassword$SetPasswdReq kidModePassword$SetPasswdReq = new KidModePassword$SetPasswdReq();
            kidModePassword$SetPasswdReq.scene_id.set(1);
            kidModePassword$SetPasswdReq.hash_method.set(1);
            kidModePassword$SetPasswdReq.passwd_hash.set(l(str, str2));
            kidModePassword$SetPasswdReq.nonce.set(h());
            kidModePassword$SetPasswdReq.timestamp.set(k());
            kidModePassword$SetPasswdReq.sha256_rounds2_params.setHasFlag(true);
            kidModePassword$SetPasswdReq.sha256_rounds2_params.salt.set(str2);
            r(qQAppInterface, "trpc.passwd.manager.PasswdManager.SetPasswd", kidModePassword$SetPasswdReq.toByteArray(), new SetNewPasswordHandler());
            return;
        }
        QLog.w("KidModeServlet", 1, "setNewPassword, empty password");
    }

    public static void y(QQAppInterface qQAppInterface, String str, String str2) {
        if (str != null && str.length() != 0) {
            KidModePassword$VerifyPasswdReq kidModePassword$VerifyPasswdReq = new KidModePassword$VerifyPasswdReq();
            kidModePassword$VerifyPasswdReq.scene_id.set(1);
            kidModePassword$VerifyPasswdReq.passwd_hash.set(l(str, str2));
            kidModePassword$VerifyPasswdReq.nonce.set(h());
            kidModePassword$VerifyPasswdReq.timestamp.set(k());
            r(qQAppInterface, "trpc.passwd.manager.PasswdManager.VerifyPasswd", kidModePassword$VerifyPasswdReq.toByteArray(), new VerifyPasswordHandler());
            return;
        }
        QLog.w("KidModeServlet", 1, "verifyPassword, empty password");
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("KidModeServlet", 2, "onReceive");
        }
        if (intent != null && fromServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            ResponseHandler responseHandler = (ResponseHandler) intent.getSerializableExtra("responseHandler");
            if (responseHandler != null) {
                responseHandler.handle(this, intent, fromServiceMsg, extras);
                return;
            }
            QLog.w("KidModeServlet", 1, "KidModeServlet unknown cmd: " + serviceCmd);
            return;
        }
        QLog.i("KidModeServlet", 1, "onReceive, request or response is null");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("cmd");
        long longExtra = intent.getLongExtra("timeout", 30000L);
        QLog.i("KidModeServlet", 1, "onSend, cmd is " + stringExtra);
        packet.setSSOCommand(stringExtra);
        packet.putSendData(fh.b(byteArrayExtra));
        if (longExtra > 0) {
            packet.setTimeout(longExtra);
        }
        if (QLog.isColorLevel()) {
            QLog.i("KidModeServlet", 2, "onSend exit");
        }
    }
}
