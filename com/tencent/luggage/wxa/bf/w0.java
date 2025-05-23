package com.tencent.luggage.wxa.bf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w0 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122595a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122595a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122595a[com.tencent.luggage.wxa.rc.l.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122595a[com.tencent.luggage.wxa.rc.l.ERR_IS_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        com.tencent.luggage.wxa.rc.l isdir = dVar.getFileSystem().isdir(str);
        int i3 = a.f122595a[isdir.ordinal()];
        boolean z16 = false;
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                return new f("fail " + isdir.name(), new Object[0]);
            }
            f fVar = new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
            if (isdir == com.tencent.luggage.wxa.rc.l.OK) {
                z16 = true;
            }
            return fVar.a("result", Boolean.valueOf(z16));
        }
        return new f("fail no such file or directory \"%s\"", str);
    }
}
