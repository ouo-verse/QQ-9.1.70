package com.tencent.luggage.wxa.hh;

import com.tencent.luggage.wxa.xd.o;
import com.tencent.mobileqq.app.face.FaceConstant;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends o.a {

    /* renamed from: d, reason: collision with root package name */
    public static final g f127194d = new g(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);

    public g(String str, Object... objArr) {
        super(str, objArr);
    }

    public boolean a() {
        return FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS.equals(this.f144873b);
    }

    public String toString() {
        return "VoiceCallResult{errMsg='" + this.f144873b + "'}";
    }
}
