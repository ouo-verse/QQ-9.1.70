package com.tencent.mobileqq.profilecard.servlet;

import SummaryCard.ReqHead;
import SummaryCard.ReqSummaryCard;
import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.impl.ProfileProtocolServiceImpl;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardBusiEntry$comm;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* loaded from: classes16.dex */
public class ProfileCardServlet extends MSFServlet implements IProfileProtocolConst {
    static IPatchRedirector $redirector_ = null;
    public static final int CMD_ID_INVALID = 0;
    public static final int CMD_ID_REQ_SUMMARY_CARD = 1;
    public static final String CMD_REQ_SUMMARY_CARD = "SummaryCard.ReqSummaryCard";
    public static final String PARAM_CMD_ID = "cmdID";
    private static final String TAG = "ProfileCardServlet";

    public ProfileCardServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayList<byte[]> buildReqServicesBuffer(long j3, long j16, String str, ArrayList<BusinessReqBuffer> arrayList) {
        int i3;
        int i16;
        long j17 = j16;
        ArrayList<byte[]> arrayList2 = new ArrayList<>();
        if (j17 > 0 && arrayList != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(AppSetting.f99551k);
            sb5.append(".");
            String str2 = AppSetting.f99542b;
            sb5.append(str2);
            String sb6 = sb5.toString();
            int i17 = 0;
            ?? r75 = 1;
            try {
                i3 = Integer.parseInt(str2);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "buildReqSummaryCard fail.", e16);
                i3 = 0;
            }
            Iterator<BusinessReqBuffer> it = arrayList.iterator();
            while (it.hasNext()) {
                BusinessReqBuffer next = it.next();
                SummaryCardBusiEntry$comm summaryCardBusiEntry$comm = new SummaryCardBusiEntry$comm();
                summaryCardBusiEntry$comm.ver.set(r75);
                summaryCardBusiEntry$comm.fromuin.set(j3);
                summaryCardBusiEntry$comm.touin.set(j17);
                summaryCardBusiEntry$comm.service.set(next.getBusinessType());
                summaryCardBusiEntry$comm.platform.set(2);
                summaryCardBusiEntry$comm.qqver.set(sb6);
                summaryCardBusiEntry$comm.build.set(i3);
                int businessType = next.getBusinessType();
                if (businessType == 17 || businessType == 19 || businessType == 18 || businessType == 20 || businessType == 25 || businessType == 24) {
                    summaryCardBusiEntry$comm.msg_login_sig.setHasFlag(r75);
                    summaryCardBusiEntry$comm.msg_login_sig.uint32_type.set(8);
                    summaryCardBusiEntry$comm.msg_login_sig.uint32_appid.set(16);
                    if (!TextUtils.isEmpty(str)) {
                        if (!HexUtil.emptybytes.equals(str)) {
                            summaryCardBusiEntry$comm.msg_login_sig.bytes_sig.set(ByteStringMicro.copyFromUtf8(str));
                        }
                        byte[] byteArray = summaryCardBusiEntry$comm.toByteArray();
                        int length = byteArray.length;
                        if (next.getBuffer() == null) {
                            i16 = next.getBuffer().length;
                        } else {
                            i16 = i17;
                        }
                        byte[] bArr = new byte[length + 9 + i16 + r75];
                        bArr[i17] = 40;
                        int i18 = i3;
                        PkgTools.DWord2Byte(bArr, r75, length);
                        PkgTools.DWord2Byte(bArr, 5, i16);
                        PkgTools.copyData(bArr, 9, byteArray, length);
                        int length2 = 9 + byteArray.length;
                        if (next.getBuffer() == null) {
                            PkgTools.copyData(bArr, length2, next.getBuffer(), next.getBuffer().length);
                            length2 += next.getBuffer().length;
                        }
                        bArr[length2] = 41;
                        arrayList2.add(bArr);
                        i3 = i18;
                        i17 = 0;
                        r75 = 1;
                        j17 = j16;
                    }
                }
                byte[] byteArray2 = summaryCardBusiEntry$comm.toByteArray();
                int length3 = byteArray2.length;
                if (next.getBuffer() == null) {
                }
                byte[] bArr2 = new byte[length3 + 9 + i16 + r75];
                bArr2[i17] = 40;
                int i182 = i3;
                PkgTools.DWord2Byte(bArr2, r75, length3);
                PkgTools.DWord2Byte(bArr2, 5, i16);
                PkgTools.copyData(bArr2, 9, byteArray2, length3);
                int length22 = 9 + byteArray2.length;
                if (next.getBuffer() == null) {
                }
                bArr2[length22] = 41;
                arrayList2.add(bArr2);
                i3 = i182;
                i17 = 0;
                r75 = 1;
                j17 = j16;
            }
        }
        return arrayList2;
    }

    private ReqSummaryCard buildReqSummaryCard(Intent intent) {
        byte[] bArr;
        long longExtra = intent.getLongExtra("selfUin", 0L);
        long longExtra2 = intent.getLongExtra(IProfileProtocolConst.PARAM_TARGET_UIN, 0L);
        int intExtra = intent.getIntExtra(IProfileProtocolConst.PARAM_COME_FROM_TYPE, 0);
        long longExtra3 = intent.getLongExtra(IProfileProtocolConst.PARAM_QZONE_FEED_TIMESTAMP, 0L);
        byte byteExtra = intent.getByteExtra(IProfileProtocolConst.PARAM_IS_FRIEND, (byte) 0);
        long longExtra4 = intent.getLongExtra(IProfileProtocolConst.PARAM_TROOP_CODE, 0L);
        long longExtra5 = intent.getLongExtra("troopUin", 0L);
        byte[] byteArrayExtra = intent.getByteArrayExtra(IProfileProtocolConst.PARAM_QZONE_SEED);
        String stringExtra = intent.getStringExtra(IProfileProtocolConst.PARAM_SEARCH_NAME);
        long longExtra6 = intent.getLongExtra(IProfileProtocolConst.PARAM_GET_CONTROL, 0L);
        int intExtra2 = intent.getIntExtra("addFriendSource", 0);
        byte[] byteArrayExtra2 = intent.getByteArrayExtra(IProfileProtocolConst.PARAM_SECURE_SIG);
        byte byteExtra2 = intent.getByteExtra(IProfileProtocolConst.PARAM_REQ_MEDAL, (byte) 0);
        byte byteExtra3 = intent.getByteExtra(IProfileProtocolConst.PARAM_REQ_EXTEND, (byte) 0);
        String stringExtra2 = intent.getStringExtra(IProfileProtocolConst.PARAM_LOGIN_SIG);
        byte[] byteArrayExtra3 = intent.getByteArrayExtra(IProfileProtocolConst.PARAM_REQ_TEMPLATE);
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra(IProfileProtocolConst.PARAM_REQ_0X5EB);
        ArrayList<BusinessReqBuffer> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IProfileProtocolConst.PARAM_REQ_SERVICES);
        if (byteArrayExtra == null) {
            byteArrayExtra = new byte[]{0};
        }
        byte[] bArr2 = byteArrayExtra;
        if (byteArrayExtra2 == null) {
            bArr = new byte[]{0};
        } else {
            bArr = byteArrayExtra2;
        }
        return new ReqSummaryCard(longExtra2, intExtra, longExtra3, byteExtra, longExtra4, longExtra5, bArr2, stringExtra, longExtra6, intExtra2, bArr, null, byteArrayExtra3, null, buildReqServicesBuffer(longExtra, longExtra2, stringExtra2, parcelableArrayListExtra), 0L, 0L, null, byteExtra2, integerArrayListExtra, (byte) 1, (byte) 0, byteExtra3, null, 1L);
    }

    private void requestSummaryCard(Intent intent, Packet packet) {
        ReqHead reqHead = new ReqHead();
        reqHead.iVersion = 2;
        ReqSummaryCard buildReqSummaryCard = buildReqSummaryCard(intent);
        UniPacket uniPacket = new UniPacket();
        uniPacket.setServantName("SummaryCardServantObj");
        uniPacket.setFuncName("ReqSummaryCard");
        uniPacket.put("ReqHead", reqHead);
        uniPacket.put("ReqSummaryCard", buildReqSummaryCard);
        packet.setSSOCommand(CMD_REQ_SUMMARY_CARD);
        packet.putSendData(uniPacket.encode());
        packet.setTimeout(30000L);
    }

    private void responseSummaryCard(Intent intent, FromServiceMsg fromServiceMsg) {
        RespHead respHead;
        RespSummaryCard respSummaryCard;
        Bundle extras = intent.getExtras();
        if (fromServiceMsg.isSuccess()) {
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            respHead = (RespHead) decodePacket(wupBuffer, "RespHead", new RespHead());
            respSummaryCard = (RespSummaryCard) decodePacket(wupBuffer, "RespSummaryCard", new RespSummaryCard());
        } else {
            QLog.e(TAG, 1, String.format("responseSummaryCard fail! resultCode=%s", Integer.valueOf(fromServiceMsg.getResultCode())));
            respHead = null;
            respSummaryCard = null;
        }
        ProfileProtocolServiceImpl.getProfileProtocolService(getAppRuntime()).responseProfileCard(extras, respHead, respSummaryCard);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        int intExtra = intent.getIntExtra(PARAM_CMD_ID, 0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("onReceive cmdID=%s", Integer.valueOf(intExtra)));
        }
        if (intExtra != 1) {
            QLog.e(TAG, 1, String.format("onReceive invalid command! cmdID=%s", Integer.valueOf(intExtra)));
        } else {
            responseSummaryCard(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        int intExtra = intent.getIntExtra(PARAM_CMD_ID, 0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("onSend cmdID=%s", Integer.valueOf(intExtra)));
        }
        if (intExtra != 1) {
            QLog.e(TAG, 1, String.format("onSend invalid command! cmdID=%s", Integer.valueOf(intExtra)));
        } else {
            requestSummaryCard(intent, packet);
        }
    }
}
