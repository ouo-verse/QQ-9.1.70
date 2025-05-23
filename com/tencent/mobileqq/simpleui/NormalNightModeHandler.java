package com.tencent.mobileqq.simpleui;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class NormalNightModeHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected BaseQQAppInterface f288499d;

    /* renamed from: e, reason: collision with root package name */
    private String f288500e;

    protected NormalNightModeHandler(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        } else {
            this.f288499d = baseQQAppInterface;
        }
    }

    public String D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f288500e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.d("NormalNightModeHandler", 1, "handleGetNormalNightModeSwitch: isSuccess is False");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        byte[] bArr = (byte[]) obj;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("NormalNightModeHandler", 1, "handleGetNormalNightModeSwitch: merge bytes data to pkg: " + e16);
        }
        if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
            sb5.append("pkg.uint32_result.get() is 0, ");
            if (oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                try {
                    oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e17) {
                    QLog.e("NormalNightModeHandler", 1, "handleGetNormalNightModeSwitch: merge pkg data to response: " + e17);
                }
                if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() <= 0) {
                    QLog.d("NormalNightModeHandler", 1, "handleGetNormalNightModeSwitch: response.rpt_msg_uin_data.size() <= 0");
                    return;
                }
                oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0);
                int i3 = oidb_0x5eb_udcuindata.uint32_normal_night_mode_flag.get();
                boolean G2 = G2(oidb_0x5eb_udcuindata);
                sb5.append(", normalNightModeFlag is: ");
                sb5.append(i3);
                sb5.append(", isSimpleOrElderMode is: ");
                sb5.append(G2);
                if (G2) {
                    QLog.d("NormalNightModeHandler", 1, "handleGetNormalNightModeSwitch: " + ((Object) sb5));
                    return;
                }
                H2(i3);
            }
        }
        QLog.d("NormalNightModeHandler", 1, "handleGetNormalNightModeSwitch: " + ((Object) sb5));
    }

    void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("NormalNightModeHandler", 1, "handleSetNormalNightModeSwitch: " + z16);
    }

    boolean G2(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        int i3 = oidb_0x5eb_udcuindata.uint32_simple_ui_switch.get();
        int i16 = oidb_0x5eb_udcuindata.uint32_elder_mode_flag.get();
        if (i3 == 1 || i16 == 1) {
            return true;
        }
        return false;
    }

    void H2(int i3) {
        boolean f16 = DarkModeManager.f();
        QLog.i("NormalNightModeHandler", 1, "followSystemModeSwitch:" + f16 + ", normalNightModeFlag:" + i3);
        if (i3 == 1) {
            if (!f16 || ThemeUtil.needRefreshWhenInit()) {
                ThemeSwitcher.startSwitch("1103", ThemeReporter.FROM_NIGHT_ROAMING, null);
                return;
            }
            return;
        }
        if (i3 == 2) {
            if (("1103".equals(D2()) || "1000".equals(D2())) && !f16) {
                ThemeSwitcher.startSwitch("1000", ThemeReporter.FROM_NIGHT_ROAMING, null);
                return;
            }
            return;
        }
        if (i3 == 0) {
            J2(ThemeUtil.isDefaultNightTheme());
        }
    }

    public void I2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        QLog.i("NormalNightModeHandler", 1, "reqGetNormalNightModeSwitch uin = " + this.f288499d.getCurrentAccountUin() + ", roamingThemeId: " + str);
        K2(str);
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(this.f288499d.getLongAccountUin()));
        oidb_0x5eb_reqbody.uint32_simple_ui_switch.set(1);
        oidb_0x5eb_reqbody.uint32_elder_mode_flag.set(1);
        oidb_0x5eb_reqbody.uint32_normal_night_mode_flag.set(1);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_normalNightGet", 1515, 22, oidb_0x5eb_reqbody.toByteArray());
        makeOIDBPkg.extraData.putString("uin", this.f288499d.getCurrentAccountUin());
        sendPbReq(makeOIDBPkg);
    }

    public void J2(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
        oidb_0x587_reqbody.rpt_uint64_uins.add(Long.valueOf(this.f288499d.getLongAccountUin()));
        PBUInt32Field pBUInt32Field = oidb_0x587_reqbody.uint32_normal_night_mode_flag;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        pBUInt32Field.set(i3);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x587_normalNightSet", 1415, 74, oidb_0x587_reqbody.toByteArray());
        if (QLog.isColorLevel()) {
            QLog.d("NormalNightModeHandler", 2, "reqSetNormalNightModeSwitch() normal night mode switch status : ", Boolean.valueOf(z16));
        }
        sendPbReq(makeOIDBPkg);
    }

    public void K2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f288500e = str;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x5eb_normalNightGet");
            this.allowCmdSet.add("OidbSvc.0x587_normalNightSet");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
        } else if (TextUtils.equals("OidbSvc.0x5eb_normalNightGet", fromServiceMsg.getServiceCmd())) {
            E2(toServiceMsg, fromServiceMsg, obj);
        } else if (TextUtils.equals("OidbSvc.0x587_normalNightSet", fromServiceMsg.getServiceCmd())) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
