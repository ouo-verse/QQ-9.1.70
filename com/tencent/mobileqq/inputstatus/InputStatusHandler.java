package com.tencent.mobileqq.inputstatus;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.nio.ByteBuffer;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class InputStatusHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final String f238089f;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f238090d;

    /* renamed from: e, reason: collision with root package name */
    private iv3.a f238091e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72577);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f238089f = InputStatusHandler.class.getSimpleName();
        }
    }

    public InputStatusHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f238091e = null;
            this.f238090d = qQAppInterface;
        }
    }

    private void E2(FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String str;
        StringBuilder sb5;
        boolean z17;
        boolean z18 = true;
        boolean z19 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f238089f, 2, "handleGetShowInputStatusToFriendResp success=" + z16);
        }
        if (z16) {
            try {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f238089f, 2, "handleGetShowInputStatusToFriendResp result=" + z16);
                    }
                    if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                        oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                            int i3 = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0).uint32_input_status_flag.get();
                            if (i3 != 1 && i3 != 0) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                        } else {
                            z17 = false;
                            z18 = false;
                        }
                        try {
                            if (this.f238090d != null) {
                                if (this.f238091e != null) {
                                    QLog.d(f238089f, 2, "handleGetShowInputStatusToFriendResp inputStateShowSwitchListener isOn =" + z17);
                                    this.f238091e.a(z17);
                                    this.f238091e = null;
                                }
                                this.f238090d.setVisibilityForInputStatus(z17, false);
                            }
                            z19 = z17;
                            z16 = z18;
                        } catch (Exception e16) {
                            e = e16;
                            z19 = z17;
                            z16 = z18;
                            if (QLog.isColorLevel()) {
                                QLog.d(f238089f, 2, "handleGetShowInputStatusToFriendResp ex", e);
                            }
                            if (QLog.isColorLevel()) {
                                str = f238089f;
                                sb5 = new StringBuilder();
                                sb5.append("handleGetShowInputStatusToFriendResp result=");
                                sb5.append(z16);
                                QLog.d(str, 2, sb5.toString());
                            }
                            notifyUI(2, z16, Boolean.valueOf(z19));
                        } catch (Throwable th5) {
                            th = th5;
                            z16 = z18;
                            if (QLog.isColorLevel()) {
                                QLog.d(f238089f, 2, "handleGetShowInputStatusToFriendResp result=" + z16);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        if (QLog.isColorLevel()) {
            str = f238089f;
            sb5 = new StringBuilder();
            sb5.append("handleGetShowInputStatusToFriendResp result=");
            sb5.append(z16);
            QLog.d(str, 2, sb5.toString());
        }
        notifyUI(2, z16, Boolean.valueOf(z19));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Exception exc;
        boolean z17;
        boolean z18;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z19 = true;
        boolean z26 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f238089f, 2, "handleSetShowInputStatusToFriendResp success=" + z16);
        }
        if (z16) {
            try {
                mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f238089f, 2, "handleSetShowInputStatusToFriendResp result=" + z16);
                }
            } catch (Exception e16) {
                exc = e16;
                z17 = z16;
                z18 = false;
            } catch (Throwable th5) {
                th = th5;
                z19 = z16;
            }
            if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                long P = Utils.P(ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt());
                if (this.f238090d.getCurrentAccountUin().equals(String.valueOf(P))) {
                    z18 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                    try {
                        this.f238090d.setVisibilityForInputStatus(z18, false);
                        z26 = z18;
                    } catch (Exception e17) {
                        exc = e17;
                        z17 = true;
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d(f238089f, 1, "handleSetShowInputStatusToFriendResp ex", exc);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(f238089f, 2, "handleSetShowInputStatusToFriendResp result=false;allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                            }
                            notifyUI(3, z26, Boolean.valueOf(z18));
                        } catch (Throwable th6) {
                            z19 = z17;
                            th = th6;
                            if (QLog.isColorLevel()) {
                                QLog.d(f238089f, 2, "handleSetShowInputStatusToFriendResp result=" + z19 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        if (QLog.isColorLevel()) {
                        }
                        throw th;
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(f238089f, 2, "handleSetShowInputStatusToFriendResp cur:" + this.f238090d.getCurrentAccountUin() + " dwUin:" + P);
                    }
                    z19 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f238089f, 2, "handleSetShowInputStatusToFriendResp result=" + z19 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                }
                z18 = z26;
                z26 = z19;
                notifyUI(3, z26, Boolean.valueOf(z18));
            }
        }
        z19 = z16;
        if (QLog.isColorLevel()) {
        }
        z18 = z26;
        z26 = z19;
        notifyUI(3, z26, Boolean.valueOf(z18));
    }

    public void D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        try {
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.f238090d.getCurrentAccountUin())));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        oidb_0x5eb_reqbody.uint32_input_status_flag.set(1);
        sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42261", 1515, 22, oidb_0x5eb_reqbody.toByteArray()));
    }

    public void G2(iv3.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f238091e = aVar;
        }
    }

    public void H2(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f238089f, 2, "setVisibilityForInputStatus OPEN=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f238090d.getCurrentAccountUin());
            if (z16) {
                s16 = 1;
            } else {
                s16 = 2;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort((short) -23275).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x4ff_42261");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("uint32_input_status_flag", true);
            createToServiceMsg.extraData.putBoolean("reqFromInputStatusHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f238089f, 1, "setMedalSwitch ex", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            if (TextUtils.equals("OidbSvc.0x5eb_42261", fromServiceMsg.getServiceCmd())) {
                E2(fromServiceMsg, obj);
            } else if (TextUtils.equals("OidbSvc.0x4ff_42261", fromServiceMsg.getServiceCmd())) {
                F2(toServiceMsg, fromServiceMsg, obj);
            }
        }
    }
}
