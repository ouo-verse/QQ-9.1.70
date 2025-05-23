package com.tencent.biz.richframework.network.request;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public abstract class ProtoBufRequest {
    public static final String TAG = "ProtoBufRequest";
    public static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static byte[] decode(byte[] bArr) {
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        try {
            stQWebRsp.mergeFrom(bArr);
            return stQWebRsp.busiBuff.get().toByteArray();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("ProtoBufRequest", 2, "inform QZoneGetGroupCountServlet resultcode fail.");
                return null;
            }
            return null;
        }
    }

    public static long getNewSeq() {
        return atomicInteger.getAndIncrement();
    }

    public byte[] encode(Intent intent, int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
            stQWebReq.Seq.set(i3);
            stQWebReq.qua.set(QUA.getQUA3());
            stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
            stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(getBusiBuf()));
            if (!TextUtils.isEmpty(str)) {
                stQWebReq.traceid.set(str);
            }
            if (intent != null) {
                intent.putExtra("traceid", str);
            }
            if (StudyModeManager.t()) {
                COMM.Entry entry = new COMM.Entry();
                entry.key.set("teenager");
                entry.value.set(String.valueOf(1));
                ArrayList arrayList = new ArrayList();
                arrayList.add(entry);
                stQWebReq.Extinfo.set(arrayList);
            }
            return stQWebReq.toByteArray();
        }
        throw new RuntimeException("req traceId is null!");
    }

    public abstract byte[] getBusiBuf();
}
