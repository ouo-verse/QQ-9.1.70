package com.tencent.luggage.wxa.bf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x0 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122596a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122596a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.ERR_PARENT_DIR_NOT_EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122596a[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122596a[com.tencent.luggage.wxa.rc.l.RET_ALREADY_EXISTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122596a[com.tencent.luggage.wxa.rc.l.OK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        com.tencent.luggage.wxa.rc.l mkdir = dVar.getFileSystem().mkdir(str, jSONObject.optBoolean("recursive", false));
        int i3 = a.f122596a[mkdir.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return new f("fail " + mkdir.name(), new Object[0]);
                    }
                    return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
                }
                return new f("fail file already exists \"%s\"", str);
            }
            return new f("fail permission denied, open \"%s\"", str);
        }
        return new f("fail no such file or directory \"%s\"", str);
    }
}
