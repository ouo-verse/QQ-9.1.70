package com.tencent.mobileqq.studymode;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AlphabeticFontHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f290887d;

    public AlphabeticFontHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f290887d = qQAppInterface;
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0135: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) (LINE:310), block:B:66:0x0135 */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0109 A[Catch: all -> 0x0134, TRY_LEAVE, TryCatch #2 {all -> 0x0134, blocks: (B:24:0x004f, B:26:0x0055, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:34:0x00a8, B:41:0x0103, B:43:0x0109, B:52:0x00ca, B:54:0x00d0), top: B:9:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        Exception e16;
        boolean z18;
        oidb_sso$OIDBSSOPkg mergeFrom;
        int i3;
        boolean z19;
        boolean z26 = true;
        boolean z27 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AlphabeticFontHandler", 2, "handleSetAlphabeticFontStatus success=" + z16);
        }
        try {
            if (z16) {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    i3 = mergeFrom.uint32_result.get();
                    if (i3 == 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                } catch (Exception e17) {
                    e16 = e17;
                } catch (Throwable th5) {
                    z26 = z16;
                    th = th5;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("AlphabeticFontHandler", 2, "handleSetAlphabeticFontStatus result=" + z19 + ", errorCode= " + i3);
                    }
                    if (z19 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        long P = Utils.P(ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt());
                        if (this.f290887d.getCurrentAccountUin().equals(String.valueOf(P))) {
                            boolean z28 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                            try {
                                com.tencent.mobileqq.utils.p.g(BaseApplication.context, getCurrentAccountUin(), true, "key_alphabetic_font_switch_status_", Boolean.valueOf(z28));
                                z27 = z28;
                            } catch (Exception e18) {
                                z18 = z28;
                                e16 = e18;
                                if (QLog.isColorLevel()) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                                notifyUI(2, z27, Boolean.valueOf(z18));
                            } catch (Throwable th6) {
                                th = th6;
                                if (QLog.isColorLevel()) {
                                    QLog.d("AlphabeticFontHandler", 2, "handleSetAlphabeticFontStatus result=" + z26 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                                }
                                throw th;
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("AlphabeticFontHandler", 2, "handleSetAlphabeticFontStatus cur:" + this.f290887d.getCurrentAccountUin() + " dwUin:" + P);
                            }
                            z26 = false;
                        }
                    } else {
                        z26 = z19;
                    }
                } catch (Exception e19) {
                    e16 = e19;
                    z18 = false;
                    if (QLog.isColorLevel()) {
                        QLog.d("AlphabeticFontHandler", 1, "handleSetAlphabeticFontStatus ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AlphabeticFontHandler", 2, "handleSetAlphabeticFontStatus result=false;allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    notifyUI(2, z27, Boolean.valueOf(z18));
                }
            } else {
                z26 = z16;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AlphabeticFontHandler", 2, "handleSetAlphabeticFontStatus result=" + z26 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            }
            z18 = z27;
            z27 = z26;
            notifyUI(2, z27, Boolean.valueOf(z18));
        } catch (Throwable th7) {
            th = th7;
            z26 = z17;
        }
    }

    private boolean G2() {
        String str = (String) com.tencent.mobileqq.utils.p.a(BaseApplication.context, getCurrentAccountUin(), AppConstants.Preferences.KEY_TEENS_MODE_LAST_LOGIN_CHECK_ALPHABETIC_TIME, "");
        if (!TextUtils.isEmpty(str)) {
            try {
                Date parse = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE).parse(str);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(parse);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(new Date());
                if (calendar.get(0) != calendar2.get(0) || calendar.get(1) != calendar2.get(1)) {
                    return false;
                }
                if (calendar.get(6) != calendar2.get(6)) {
                    return false;
                }
                return true;
            } catch (ParseException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public boolean D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        try {
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.f290887d.getCurrentAccountUin())));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        oidb_0x5eb_reqbody.uint32_alphabetic_font_flag.set(1);
        sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42483", 1515, 22, oidb_0x5eb_reqbody.toByteArray()));
        return ((Boolean) com.tencent.mobileqq.utils.p.a(BaseApplication.context, getCurrentAccountUin(), "key_alphabetic_font_switch_status_", Boolean.FALSE)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E2(FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z17;
        boolean z18 = false;
        boolean z19 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp success=" + z16);
        }
        try {
            if (z16) {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp result=" + z16);
                    }
                } catch (Exception e16) {
                    e = e16;
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                        if (oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0).uint32_alphabetic_font_flag.get() != 0) {
                            z18 = true;
                        }
                        try {
                            com.tencent.mobileqq.utils.p.g(BaseApplication.context, getCurrentAccountUin(), true, "key_alphabetic_font_switch_status_", Boolean.valueOf(z18));
                            QLog.d("AlphabeticFontHandler", 1, "set KEY_ALPHABETIC_FONT_SWITCH_STATUS: " + z18);
                            z17 = z18;
                            z18 = true;
                        } catch (Exception e17) {
                            e = e17;
                            z16 = true;
                            if (QLog.isColorLevel()) {
                                QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp ex", e);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp result=" + z16);
                            }
                            if (!G2()) {
                            }
                            notifyUI(1, z16, Boolean.valueOf(z18));
                        } catch (Throwable th5) {
                            th = th5;
                            if (QLog.isColorLevel()) {
                                QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp result=" + z19);
                            }
                            throw th;
                        }
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp result=" + z18);
                    }
                    z16 = z18;
                    z18 = z17;
                    if (!G2()) {
                        if (z18) {
                            ReportController.o(this.f290887d, "dc00898", "", "", "0X800B3D4", "0X800B3D4", 0, 0, "", "", "", "");
                        }
                        com.tencent.mobileqq.utils.p.g(BaseApplication.context, getCurrentAccountUin(), true, AppConstants.Preferences.KEY_TEENS_MODE_LAST_LOGIN_CHECK_ALPHABETIC_TIME, new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE).format(new Date()));
                    }
                    notifyUI(1, z16, Boolean.valueOf(z18));
                }
            }
            z17 = false;
            z18 = z16;
            if (QLog.isColorLevel()) {
            }
            z16 = z18;
            z18 = z17;
            if (!G2()) {
            }
            notifyUI(1, z16, Boolean.valueOf(z18));
        } catch (Throwable th6) {
            th = th6;
            z19 = z16;
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
            QLog.d("AlphabeticFontHandler", 2, "setVisibilityForAlphabeticFontStatus OPEN=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f290887d.getCurrentAccountUin());
            if (z16) {
                s16 = 1;
            } else {
                s16 = 2;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort((short) -23053).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x4ff_42483");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("uint32_input_status_flag", true);
            createToServiceMsg.extraData.putBoolean("reqFromAlphabeticFontHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AlphabeticFontHandler", 1, "setMedalSwitch ex", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return c.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            if (TextUtils.equals("OidbSvc.0x5eb_42483", fromServiceMsg.getServiceCmd())) {
                E2(fromServiceMsg, obj);
            } else if (TextUtils.equals("OidbSvc.0x4ff_42483", fromServiceMsg.getServiceCmd())) {
                F2(toServiceMsg, fromServiceMsg, obj);
            }
        }
    }
}
