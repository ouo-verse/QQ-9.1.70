package com.tencent.luggage.wxa.bf;

import com.tencent.luggage.wxa.bf.e;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h1 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122544a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122544a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.ERR_PARENT_DIR_NOT_EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122544a[com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122544a[com.tencent.luggage.wxa.rc.l.RET_ALREADY_EXISTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122544a[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f122544a[com.tencent.luggage.wxa.rc.l.ERR_SYMLINK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f122544a[com.tencent.luggage.wxa.rc.l.ERR_EXCEED_DIRECTORY_MAX_SIZE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f122544a[com.tencent.luggage.wxa.rc.l.OK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        InputStream byteArrayInputStream;
        e eVar;
        boolean optBoolean = jSONObject.optBoolean("append", false);
        String optString = jSONObject.optString("encoding");
        com.tencent.luggage.wxa.uk.c0.a(dVar.getJsRuntime(), jSONObject, (c0.a) dVar.a(c0.a.class));
        Object opt = jSONObject.opt("data");
        if (opt instanceof String) {
            if (com.tencent.luggage.wxa.tn.w0.c(optString)) {
                eVar = (e) e.a.f122536a.get("utf8");
            } else {
                eVar = (e) e.a.f122536a.get(optString.toLowerCase());
                if (eVar == null) {
                    return new f("fail invalid encoding", new Object[0]);
                }
            }
            try {
                byteArrayInputStream = new com.tencent.luggage.wxa.h6.a(eVar.a((String) opt));
            } catch (Exception e16) {
                return new f("fail " + e16.getMessage(), new Object[0]);
            }
        } else if (opt instanceof ByteBuffer) {
            byteArrayInputStream = new com.tencent.luggage.wxa.h6.a((ByteBuffer) opt);
        } else if (opt == null) {
            if (optBoolean) {
                return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
            }
            byteArrayInputStream = new ByteArrayInputStream(new byte[0]);
        } else {
            return new f("fail invalid data", new Object[0]);
        }
        com.tencent.luggage.wxa.rc.l writeFile = dVar.getFileSystem().writeFile(str, byteArrayInputStream, optBoolean);
        switch (a.f122544a[writeFile.ordinal()]) {
            case 1:
                return new f("fail no such file or directory, open \"%s\"", str);
            case 2:
                return new f("fail no such file \"%s\"", str);
            case 3:
                return new f("fail illegal operation on a directory, open \"%s\"", str);
            case 4:
                return new f("fail permission denied, open \"%s\"", str);
            case 5:
                return new f("fail \"%s\" is not a regular file", str);
            case 6:
                return new f("fail the maximum size of the file storage limit is exceeded", new Object[0]);
            case 7:
                return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
            default:
                return new f("fail " + writeFile.name(), new Object[0]);
        }
    }
}
