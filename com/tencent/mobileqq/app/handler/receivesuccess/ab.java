package com.tencent.mobileqq.app.handler.receivesuccess;

import QQService.StreamData;
import QQService.StreamInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.ptt_reserve.ptt_reserve$ReserveStruct;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ab {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, FromServiceMsg fromServiceMsg, Object obj) {
        byte[] bArr;
        if ("StreamSvr.PushStreamMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) && obj != null) {
            Object[] objArr = (Object[]) obj;
            long longValue = ((Long) objArr[0]).longValue();
            StreamInfo streamInfo = (StreamInfo) objArr[1];
            StreamData streamData = (StreamData) objArr[2];
            long longValue2 = ((Long) objArr[3]).longValue();
            long longValue3 = ((Long) objArr[4]).longValue();
            long longValue4 = ((Long) objArr[5]).longValue();
            ptt_reserve$ReserveStruct ptt_reserve_reservestruct = new ptt_reserve$ReserveStruct();
            if (streamInfo != null && (bArr = streamInfo.vPbData) != null) {
                try {
                    ptt_reserve_reservestruct.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("Q.msg.MessageHandler", 1, "parse streaminfo.vPbData failed.", e16);
                }
            }
            if (streamInfo != null) {
                com.tencent.mobileqq.streamtransfile.b.w(qQAppInterface, streamInfo, streamData, longValue, longValue2, longValue3, longValue4, ptt_reserve_reservestruct);
            }
        }
    }
}
