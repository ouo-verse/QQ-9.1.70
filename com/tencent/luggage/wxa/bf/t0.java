package com.tencent.luggage.wxa.bf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t0 extends d {
    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        String format;
        if (dVar.getFileSystem().access(str) == com.tencent.luggage.wxa.rc.l.OK) {
            format = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
        } else {
            format = String.format("fail no such file or directory \"%s\"", str);
        }
        return new f(format, new Object[0]);
    }
}
