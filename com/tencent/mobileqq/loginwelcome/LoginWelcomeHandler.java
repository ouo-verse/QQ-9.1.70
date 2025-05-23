package com.tencent.mobileqq.loginwelcome;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$BindContactInfo;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_808;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_808_web;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_common;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_common_web;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$ReqBody;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoginWelcomeHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public LoginWelcomeHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        oidb_0x59f$BindContactInfo oidb_0x59f_bindcontactinfo;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean z16 = false;
        String str2 = null;
        if (fromServiceMsg.isSuccess()) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    oidb_0x59f$RspBody oidb_0x59f_rspbody = new oidb_0x59f$RspBody();
                    oidb_0x59f_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0x59f_rspbody.uint32_is_first_login.has() && oidb_0x59f_rspbody.uint32_is_first_login.get() == 1) {
                        Object[] objArr = new Object[4];
                        try {
                            if (oidb_0x59f_rspbody.str_reg_mobile.has()) {
                                str = oidb_0x59f_rspbody.str_reg_mobile.get();
                            } else {
                                str = null;
                            }
                            objArr[0] = str;
                            if (oidb_0x59f_rspbody.msg_contact_bind_info.has()) {
                                oidb_0x59f_bindcontactinfo = oidb_0x59f_rspbody.msg_contact_bind_info.get();
                            } else {
                                oidb_0x59f_bindcontactinfo = null;
                            }
                            objArr[1] = oidb_0x59f_bindcontactinfo;
                            if (oidb_0x59f_rspbody.uint32_gray_flag.has()) {
                                i3 = oidb_0x59f_rspbody.uint32_gray_flag.get();
                            } else {
                                i3 = 0;
                            }
                            objArr[2] = Integer.valueOf(i3);
                            if (oidb_0x59f_rspbody.str_guide_url.has()) {
                                str2 = oidb_0x59f_rspbody.str_guide_url.get();
                            }
                            objArr[3] = str2;
                            str2 = objArr;
                            z16 = true;
                        } catch (Throwable th5) {
                            th = th5;
                            str2 = objArr;
                            if (QLog.isColorLevel()) {
                                QLog.d("LoginWelcomeManager", 2, "handleGetIsFirstLogin failed", th);
                            }
                            if (QLog.isColorLevel()) {
                            }
                            notifyUI(PlayerResources.ViewId.CURRUNT_TIME, z16, (Object) str2, true);
                        }
                    }
                } else {
                    QLog.e("LoginWelcomeManager", 1, " sso failed: " + oidb_sso_oidbssopkg.uint32_result.get());
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "handleGetIsFirstLogin, result " + z16);
        }
        notifyUI(PlayerResources.ViewId.CURRUNT_TIME, z16, (Object) str2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x021d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_0x59f$Guidelines_808 oidb_0x59f_guidelines_808;
        oidb_0x59f$Guidelines_common oidb_0x59f_guidelines_common;
        oidb_0x59f$Guidelines_common_web oidb_0x59f_guidelines_common_web;
        boolean z17;
        oidb_0x59f$Guidelines_808_web oidb_0x59f_guidelines_808_web;
        String str;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String str2 = null;
        boolean z18 = false;
        if (fromServiceMsg.isSuccess()) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    oidb_0x59f$RspBody oidb_0x59f_rspbody = new oidb_0x59f$RspBody();
                    oidb_0x59f_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    LoginWelcomeManager.k kVar = new LoginWelcomeManager.k();
                    if (oidb_0x59f_rspbody.uint32_addrlist_entrance_flag.has() && oidb_0x59f_rspbody.uint32_addrlist_entrance_flag.get() != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    kVar.f243096b = z16;
                    if (oidb_0x59f_rspbody.msg_guidelines808.has()) {
                        oidb_0x59f_guidelines_808 = oidb_0x59f_rspbody.msg_guidelines808.get();
                    } else {
                        oidb_0x59f_guidelines_808 = null;
                    }
                    if (oidb_0x59f_guidelines_808 != null) {
                        if (oidb_0x59f_guidelines_808.uint32_welcomepage_flag.has() && oidb_0x59f_guidelines_808.uint32_welcomepage_flag.get() != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        kVar.f243095a = z17;
                        if (oidb_0x59f_guidelines_808.msg_guidelines_web.has()) {
                            oidb_0x59f_guidelines_808_web = oidb_0x59f_guidelines_808.msg_guidelines_web.get();
                        } else {
                            oidb_0x59f_guidelines_808_web = null;
                        }
                        if (oidb_0x59f_guidelines_808_web != null) {
                            if (oidb_0x59f_guidelines_808_web.str_web_url.has()) {
                                str = oidb_0x59f_guidelines_808_web.str_web_url.get();
                            } else {
                                str = "";
                            }
                            if (!TextUtils.isEmpty(str)) {
                                kVar.f243097c = str;
                            }
                            if (oidb_0x59f_guidelines_808_web.uint32_friends_recomm_flag.has()) {
                                i3 = oidb_0x59f_guidelines_808_web.uint32_friends_recomm_flag.get();
                            } else {
                                i3 = 0;
                            }
                            kVar.f243098d = i3;
                            if (oidb_0x59f_guidelines_808_web.uint32_groups_recomm_flag.has()) {
                                i16 = oidb_0x59f_guidelines_808_web.uint32_groups_recomm_flag.get();
                            } else {
                                i16 = 0;
                            }
                            kVar.f243099e = i16;
                        }
                    }
                    Object[] objArr = new Object[3];
                    try {
                        objArr[0] = kVar;
                        LoginWelcomeManager.j jVar = new LoginWelcomeManager.j();
                        if (oidb_0x59f_rspbody.msg_guidelines813.has()) {
                            oidb_0x59f_guidelines_common = oidb_0x59f_rspbody.msg_guidelines813.get();
                        } else {
                            oidb_0x59f_guidelines_common = null;
                        }
                        if (oidb_0x59f_guidelines_common != null) {
                            if (oidb_0x59f_guidelines_common.msg_guidelines_web.has()) {
                                oidb_0x59f_guidelines_common_web = oidb_0x59f_guidelines_common.msg_guidelines_web.get();
                            } else {
                                oidb_0x59f_guidelines_common_web = null;
                            }
                            if (oidb_0x59f_guidelines_common_web != null) {
                                if (oidb_0x59f_guidelines_common_web.str_web_url.has()) {
                                    str2 = oidb_0x59f_guidelines_common_web.str_web_url.get();
                                }
                                jVar.f243094b = str2;
                                if (oidb_0x59f_guidelines_common_web.uint32_groups_recomm_flag.has() && oidb_0x59f_guidelines_common_web.uint32_groups_recomm_flag.get() == 1) {
                                    jVar.f243093a = 1;
                                } else if (oidb_0x59f_guidelines_common_web.uint32_set_gender.has() && oidb_0x59f_guidelines_common_web.uint32_set_gender.get() == 1) {
                                    jVar.f243093a = 2;
                                } else if (oidb_0x59f_guidelines_common_web.uint32_set_birthday.has() && oidb_0x59f_guidelines_common_web.uint32_set_birthday.get() == 1) {
                                    jVar.f243093a = 3;
                                } else if (oidb_0x59f_guidelines_common_web.uint32_set_head.has() && oidb_0x59f_guidelines_common_web.uint32_set_head.get() == 1) {
                                    jVar.f243093a = 4;
                                } else if (oidb_0x59f_guidelines_common_web.uint32_set_school.has() && oidb_0x59f_guidelines_common_web.uint32_set_school.get() == 1) {
                                    jVar.f243093a = 5;
                                } else if (oidb_0x59f_guidelines_common_web.uint32_set_region.has() && oidb_0x59f_guidelines_common_web.uint32_set_region.get() == 1) {
                                    jVar.f243093a = 6;
                                } else if (oidb_0x59f_guidelines_common_web.uint32_set_company.has() && oidb_0x59f_guidelines_common_web.uint32_set_company.get() == 1) {
                                    jVar.f243093a = 7;
                                } else {
                                    jVar.f243093a = 0;
                                }
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("LoginWelcomeManager", 2, String.format("813 guide :type %s, url %s", Integer.valueOf(jVar.f243093a), jVar.f243094b));
                        }
                        objArr[1] = jVar;
                        if (oidb_0x59f_rspbody.uint32_need_not_req_nexttime.has() && oidb_0x59f_rspbody.uint32_need_not_req_nexttime.get() == 1) {
                            objArr[2] = Boolean.FALSE;
                        } else {
                            objArr[2] = Boolean.TRUE;
                        }
                        z18 = true;
                        str2 = objArr;
                    } catch (Throwable th5) {
                        th = th5;
                        str2 = objArr;
                        if (QLog.isColorLevel()) {
                            QLog.d("LoginWelcomeManager", 2, "handleRequestGuide failed", th);
                        }
                        if (QLog.isColorLevel()) {
                        }
                        notifyUI(PlayerResources.ViewId.ADVTISMENT_VIDEO_TIP, z18, (Object) str2, true);
                    }
                } else {
                    QLog.e("LoginWelcomeManager", 1, "handleRequestGuide sso failed: " + oidb_sso_oidbssopkg.uint32_result.get());
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "handleRequestGuide, result " + z18);
        }
        notifyUI(PlayerResources.ViewId.ADVTISMENT_VIDEO_TIP, z18, (Object) str2, true);
    }

    public void F2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x59f", 1439, 1, new oidb_0x59f$ReqBody().toByteArray());
        makeOIDBPkg.extraData.putBoolean("isFirst", z16);
        sendPbReq(makeOIDBPkg);
        if (QLog.isColorLevel()) {
            QLog.i("LoginWelcomeHandler", 2, "requestGuide [" + z16 + "]");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return LoginWelcomeManager.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else if (toServiceMsg.getServiceCmd().equals("OidbSvc.0x59f")) {
            if (toServiceMsg.extraData.getBoolean("isFirst")) {
                D2(toServiceMsg, fromServiceMsg, obj);
            }
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
