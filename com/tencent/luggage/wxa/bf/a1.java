package com.tencent.luggage.wxa.bf;

import com.tencent.luggage.wxa.bf.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a1 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122520a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122520a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122520a[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122520a[com.tencent.luggage.wxa.rc.l.ERR_SYMLINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122520a[com.tencent.luggage.wxa.rc.l.ERR_ILLEGAL_READ_POSITION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f122520a[com.tencent.luggage.wxa.rc.l.ERR_ILLEGAL_READ_LENGTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        e eVar;
        long optLong;
        long j3;
        com.tencent.luggage.wxa.rc.l readFile;
        Object a16;
        String optString = jSONObject.optString("encoding");
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", str, optString);
        if (com.tencent.luggage.wxa.tn.w0.c(optString)) {
            eVar = null;
        } else {
            eVar = (e) e.a.f122536a.get(optString.toLowerCase());
            if (eVar == null) {
                return new f("fail invalid encoding", new Object[0]);
            }
        }
        e eVar2 = eVar;
        if (!jSONObject.has("position") && !jSONObject.has("length")) {
            j3 = Long.MIN_VALUE;
            optLong = Long.MIN_VALUE;
        } else {
            long optLong2 = jSONObject.optLong("position", 0L);
            optLong = jSONObject.optLong("length", Long.MAX_VALUE);
            j3 = optLong2;
        }
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        if (j3 != Long.MIN_VALUE && optLong != Long.MIN_VALUE) {
            readFile = dVar.getFileSystem().readFile(str, j3, optLong, iVar);
        } else {
            readFile = dVar.getFileSystem().readFile(str, iVar);
        }
        if (readFile == com.tencent.luggage.wxa.rc.l.OK) {
            if (eVar2 == null) {
                a16 = iVar.f141499a;
            } else {
                a16 = eVar2.a((ByteBuffer) iVar.f141499a);
            }
            if (!(a16 instanceof ByteBuffer)) {
                com.tencent.luggage.wxa.h6.a.a((ByteBuffer) iVar.f141499a);
            }
            return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]).a("data", a16);
        }
        int i3 = a.f122520a[readFile.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return new f("fail " + readFile.name(), new Object[0]);
                        }
                        return new f("fail the value of \"length\" is out of range", new Object[0]);
                    }
                    return new f("fail the value of \"position\" is out of range", new Object[0]);
                }
                return new f("fail \"%s\" is not a regular file", str);
            }
            return new f("fail permission denied, open \"%s\"", str);
        }
        return new f("fail no such file \"%s\"", str);
    }
}
