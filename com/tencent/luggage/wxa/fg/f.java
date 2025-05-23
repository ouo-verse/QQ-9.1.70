package com.tencent.luggage.wxa.fg;

import com.tencent.luggage.wxa.uk.h0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends k0 {
    static final int CTRL_INDEX = 473;
    static final String NAME = "onDeviceOrientationChange";

    public void a(h0.a aVar) {
        String replace = aVar.name().replace("_", "");
        HashMap hashMap = new HashMap(2);
        hashMap.put("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        hashMap.put("value", replace);
        try {
            setData(hashMap).dispatch();
        } catch (NullPointerException unused) {
        }
    }
}
