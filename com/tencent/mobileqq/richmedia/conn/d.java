package com.tencent.mobileqq.richmedia.conn;

import com.tencent.av.business.handler.a;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntRspBody;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.apache.http.HttpException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    public boolean a(byte[] bArr) {
        a.C0737a c0737a;
        int i3;
        int i16;
        long j3;
        if (bArr != null && bArr.length <= 60) {
            try {
                c0737a = com.tencent.av.business.handler.a.c(bArr);
            } catch (OutOfMemoryError unused) {
                QLog.e("SubTitleProtocoDataCodec", 2, "decodeS2CData OOM!!");
                c0737a = null;
            }
            if (c0737a == null) {
                return false;
            }
            byte[] bArr2 = c0737a.f73287a;
            byte[] bArr3 = c0737a.f73288b;
            try {
                AudioTransClientTransInfo$IntHead mergeFrom = new AudioTransClientTransInfo$IntHead().mergeFrom(bArr2);
                if (mergeFrom.uint32_error_no.has()) {
                    i3 = mergeFrom.uint32_error_no.get();
                } else {
                    i3 = 0;
                }
                if (mergeFrom.enum_body_type.has()) {
                    i16 = mergeFrom.enum_body_type.get();
                } else {
                    i16 = 0;
                }
                if (mergeFrom.str_session_id.has()) {
                    j3 = Long.valueOf(mergeFrom.str_session_id.get()).longValue();
                } else {
                    j3 = 0;
                }
                QLog.d("SubTitleProtocoDataCodec", 2, "onReceive result:" + i3 + " sessionid:" + j3 + " bodyType:" + i16);
                AudioTransClientTransInfo$IntRspBody mergeFrom2 = new AudioTransClientTransInfo$IntRspBody().mergeFrom(bArr3);
                if (i3 == 0) {
                    if (i16 == 10 && QLog.isColorLevel()) {
                        QLog.d("PeakAudioTransHandler", 2, "decodeS2CData INT_C2S_HEART_BEAT_RSP heartbeat !");
                    }
                } else {
                    AudioTransClientTransInfo$IntC2SFailedRsp audioTransClientTransInfo$IntC2SFailedRsp = mergeFrom2.msg_failed_rsp.get();
                    QLog.d("SubTitleProtocoDataCodec", 2, "create session rsp fail msg: " + mergeFrom.uint32_error_no.get() + " uint32_errcode = " + audioTransClientTransInfo$IntC2SFailedRsp.uint32_errcode.get() + " str_errmsg = " + audioTransClientTransInfo$IntC2SFailedRsp.str_errmsg.get());
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                QLog.e("SubTitleProtocoDataCodec", 2, "decodeS2CData exception = " + e16.getMessage(), e16);
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("PeakAudioTransHandler", 2, "decodeS2CData data error");
        }
        return false;
    }

    public void b(MsfSocketInputBuffer msfSocketInputBuffer) throws IOException, HttpException {
        int bufferlen = msfSocketInputBuffer.getBufferlen();
        byte[] bArr = new byte[bufferlen];
        System.arraycopy(msfSocketInputBuffer.getBuffer(), 0, bArr, 0, bufferlen);
        a(bArr);
    }
}
