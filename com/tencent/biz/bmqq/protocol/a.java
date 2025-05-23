package com.tencent.biz.bmqq.protocol;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends BaseProtocolCoder {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f78384d = {"hrtxformqq"};

    /* renamed from: e, reason: collision with root package name */
    public static int f78385e = 0;

    public static int a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    private Object b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        BmqqUserSimpleInfo bmqqUserSimpleInfo = new BmqqUserSimpleInfo();
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        int length = wupBuffer.length - 4;
        byte[] bArr = new byte[length];
        System.arraycopy(wupBuffer, 4, bArr, 0, length);
        byte b16 = bArr[0];
        byte b17 = bArr[length - 1];
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 1, bArr2, 0, 4);
        a(bArr2);
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, 5, bArr3, 0, 4);
        a(bArr3);
        byte[] bArr4 = new byte[4];
        System.arraycopy(bArr, 9, bArr4, 0, 4);
        int a16 = a(bArr4);
        byte[] bArr5 = new byte[4];
        System.arraycopy(bArr, 13, bArr5, 0, 4);
        int a17 = a(bArr5);
        byte[] bArr6 = new byte[a16];
        System.arraycopy(bArr, 17, bArr6, 0, a16);
        mobileqq_bmqq$CorpcardRspHead mobileqq_bmqq_corpcardrsphead = new mobileqq_bmqq$CorpcardRspHead();
        try {
            mobileqq_bmqq_corpcardrsphead.mergeFrom(bArr6);
            mobileqq_bmqq_corpcardrsphead.rspHead.get().uint64_qquin.get();
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        byte[] bArr7 = new byte[a17];
        System.arraycopy(bArr, a16 + 17, bArr7, 0, a17);
        mobileqq_bmqq$CorpcardRspBody mobileqq_bmqq_corpcardrspbody = new mobileqq_bmqq$CorpcardRspBody();
        try {
            mobileqq_bmqq_corpcardrspbody.mergeFrom(bArr7);
        } catch (InvalidProtocolBufferMicroException e17) {
            e17.printStackTrace();
        }
        long j3 = mobileqq_bmqq_corpcardrspbody.uint64_qquin.get();
        if (j3 > 0) {
            bmqqUserSimpleInfo.mBmqqUin = Long.toString(j3);
        }
        long j16 = mobileqq_bmqq_corpcardrspbody.uint64_kfuin.get();
        if (j16 >= 0) {
            bmqqUserSimpleInfo.mBmqqMasterUin = Long.toString(j16);
        }
        int i3 = mobileqq_bmqq_corpcardrspbody.retInfo.get().uint32_ret_code.get();
        String str = mobileqq_bmqq_corpcardrspbody.retInfo.get().err_info.get();
        bmqqUserSimpleInfo.mBmqqNickName = mobileqq_bmqq_corpcardrspbody.nickname.get();
        bmqqUserSimpleInfo.mBmqqRemarkName = mobileqq_bmqq_corpcardrspbody.remarkname.get();
        bmqqUserSimpleInfo.mBmqqJobTitle = mobileqq_bmqq_corpcardrspbody.jobs.get();
        bmqqUserSimpleInfo.mBmqqMobileNum = mobileqq_bmqq_corpcardrspbody.mobile.get();
        bmqqUserSimpleInfo.mBmqqTelphone = mobileqq_bmqq_corpcardrspbody.phone.get();
        bmqqUserSimpleInfo.mBmqqEmail = mobileqq_bmqq_corpcardrspbody.email.get();
        bmqqUserSimpleInfo.mBmqqCompany = mobileqq_bmqq_corpcardrspbody.corpname.get();
        bmqqUserSimpleInfo.mFlag = mobileqq_bmqq_corpcardrspbody.flag.get();
        bundle.putParcelable("info", bmqqUserSimpleInfo);
        bundle.putInt("result", i3);
        bundle.putString("errinfo", str);
        return bundle;
    }

    private byte[] c(ToServiceMsg toServiceMsg) {
        long j3;
        long longValue = ((Long) toServiceMsg.getAttributes().get("uin")).longValue();
        try {
            j3 = Long.parseLong(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
        } catch (Exception e16) {
            QLog.e("BmqqBusinessService", 1, "encodeGetUserSimpleInfo exception: ", e16);
            j3 = 0;
        }
        mobileqq_bmqq$HRTXHead mobileqq_bmqq_hrtxhead = new mobileqq_bmqq$HRTXHead();
        mobileqq_bmqq_hrtxhead.uint64_qquin.set(longValue);
        mobileqq_bmqq$CorpcardReqHead mobileqq_bmqq_corpcardreqhead = new mobileqq_bmqq$CorpcardReqHead();
        mobileqq_bmqq_corpcardreqhead.reqHead.set(mobileqq_bmqq_hrtxhead);
        mobileqq_bmqq$CorpcardReqBody mobileqq_bmqq_corpcardreqbody = new mobileqq_bmqq$CorpcardReqBody();
        mobileqq_bmqq_corpcardreqbody.uint64_qquin.set(j3);
        int length = mobileqq_bmqq_corpcardreqhead.toByteArray().length;
        int length2 = mobileqq_bmqq_corpcardreqbody.toByteArray().length;
        int i3 = length + 17;
        int i16 = i3 + length2 + 1;
        byte[] bArr = new byte[i16];
        bArr[0] = Constants.SEND_CHANNEL_LATENCY;
        System.arraycopy(d(1001), 0, bArr, 1, 4);
        int i17 = f78385e;
        f78385e = i17 + 1;
        System.arraycopy(d(i17), 0, bArr, 5, 4);
        System.arraycopy(d(length), 0, bArr, 9, 4);
        System.arraycopy(d(length2), 0, bArr, 13, 4);
        System.arraycopy(mobileqq_bmqq_corpcardreqhead.toByteArray(), 0, bArr, 17, length);
        System.arraycopy(mobileqq_bmqq_corpcardreqbody.toByteArray(), 0, bArr, i3, length2);
        bArr[i16 - 1] = 93;
        return bArr;
    }

    private byte[] d(int i3) {
        return new byte[]{(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        return f78384d;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if ("hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return b(toServiceMsg, fromServiceMsg);
        }
        return null;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean enableBinaryProtocol() {
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        return false;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public byte[] encodeReqMsg(ToServiceMsg toServiceMsg) {
        byte[] c16 = "hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(toServiceMsg.getServiceCmd()) ? c(toServiceMsg) : null;
        if (c16 == null) {
            return null;
        }
        byte[] d16 = d(c16.length + 4);
        byte[] bArr = new byte[c16.length + 4];
        System.arraycopy(d16, 0, bArr, 0, 4);
        System.arraycopy(c16, 0, bArr, 4, c16.length);
        return bArr;
    }
}
