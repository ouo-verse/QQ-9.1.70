package com.tencent.mobileqq.troop.troopsetting.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.troopsetting.api.b;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopSettingHandler extends TroopBaseHandler implements com.tencent.mobileqq.troop.troopsetting.api.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f301070e;

    public TroopSettingHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f301070e = new ConcurrentHashMap<>();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        oidb_0x5eb$RspBody oidb_0x5eb_rspbody;
        boolean z17 = true;
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
                int i16 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.i("TroopSettingHandler", 2, "handleAutoAgreeInvite2GroupIn50Flag ret=" + i16);
                }
                if (i16 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    try {
                        byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                        oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                        oidb_0x5eb_rspbody.mergeFrom(byteArray);
                    } catch (InvalidProtocolBufferMicroException unused) {
                        i3 = 1;
                    }
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has()) {
                        z16 = false;
                        i3 = 1;
                        for (oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata : oidb_0x5eb_rspbody.rpt_msg_uin_data.get()) {
                            try {
                                if (oidb_0x5eb_udcuindata.uint32_req_invite2group_auto_agree_flag.has()) {
                                    i3 = oidb_0x5eb_udcuindata.uint32_req_invite2group_auto_agree_flag.get();
                                    z16 = true;
                                }
                            } catch (InvalidProtocolBufferMicroException unused2) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("TroopSettingHandler", 2, "handleAutoAgreeInvite2GroupIn50Flag ret=" + i16);
                                }
                                z16 = false;
                                int i17 = b.f301069m;
                                Object[] objArr = new Object[1];
                                if (i3 != 0) {
                                }
                                objArr[0] = Boolean.valueOf(z17);
                                notifyUI(i17, z16, objArr);
                            }
                        }
                        int i172 = b.f301069m;
                        Object[] objArr2 = new Object[1];
                        if (i3 != 0) {
                            z17 = false;
                        }
                        objArr2[0] = Boolean.valueOf(z17);
                        notifyUI(i172, z16, objArr2);
                    }
                }
            }
        }
        z16 = false;
        i3 = 1;
        int i1722 = b.f301069m;
        Object[] objArr22 = new Object[1];
        if (i3 != 0) {
        }
        objArr22[0] = Boolean.valueOf(z17);
        notifyUI(i1722, z16, objArr22);
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.i("TroopSettingHandler", 2, "handleOidb0x4ff_86Rsp ret=" + i3);
                }
                if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                    if (4 <= byteArray.length) {
                        String valueOf = String.valueOf(PkgTools.getLongData(byteArray, 0));
                        if (TextUtils.isEmpty(valueOf) || !valueOf.equals(this.appRuntime.getAccount())) {
                            if (QLog.isColorLevel()) {
                                QLog.w(LogTag.DATING, 2, "handleOidb0x4ff_86Rsp uin error");
                            }
                        }
                    }
                    z16 = true;
                    notifyUI(b.f301068i, z16, new Object[]{Boolean.valueOf(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, false))});
                }
            }
        }
        z16 = false;
        notifyUI(b.f301068i, z16, new Object[]{Boolean.valueOf(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, false))});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x4ff_86");
            this.allowCmdSet.add("OidbSvc.0x5eb_94");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopSettingHandler";
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.api.a
    public void m2(String str, int i3, String str2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2);
            return;
        }
        QLog.i("TroopSettingHandler", 1, "[notifyModifyGroupRemark] troopUin:" + str + ",result:" + i3 + ",from:" + str2);
        int i16 = b.f301065e;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        notifyUI(i16, z16, new Object[]{str, Integer.valueOf(i3)});
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.api.a
    public void n(boolean z16, String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("TroopSettingHandler", 1, "[notifyModifyGroupGroupMsgMask] success:" + z16 + ",troopUin:" + str + ",memberUid:" + str2 + ",op:" + i3 + ",type:" + i16);
        notifyUI(b.f301067h, z16, new Object[]{str, str2, Integer.valueOf(i3), Integer.valueOf(i16)});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopSettingHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopSettingHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0x4ff_86".equals(fromServiceMsg.getServiceCmd())) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0x5eb_94".equals(fromServiceMsg.getServiceCmd())) {
                    F2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopSettingHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
