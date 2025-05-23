package com.tencent.mobileqq.wxmini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;

/* compiled from: P */
/* loaded from: classes35.dex */
public abstract class b {
    public byte[] a(Intent intent, int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
            stQWebReq.Seq.set(i3);
            stQWebReq.qua.set(QUA.getQUA3());
            stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
            stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(b()));
            if (!TextUtils.isEmpty(str)) {
                stQWebReq.traceid.set(str);
            }
            if (intent != null) {
                intent.putExtra("traceid", str);
            }
            return stQWebReq.toByteArray();
        }
        throw new RuntimeException("req traceId is null!");
    }

    public abstract byte[] b();
}
