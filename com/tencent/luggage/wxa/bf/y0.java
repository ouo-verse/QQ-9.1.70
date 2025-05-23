package com.tencent.luggage.wxa.bf;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mm.plugin.appbrand.appstorage.BrotliJNI;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class y0 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122597a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122597a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122597a[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122597a[com.tencent.luggage.wxa.rc.l.ERR_SYMLINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        if (dVar.getFileSystem() == null) {
            return new f("fail no file system", new Object[0]);
        }
        String optString = jSONObject.optString("compressionAlgorithm");
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.UnitReadCompressedFile", "call, path %s, compressionAlgorithm %s", str, optString);
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        com.tencent.luggage.wxa.rc.l readFile = dVar.getFileSystem().readFile(str, iVar);
        if (readFile == com.tencent.luggage.wxa.rc.l.OK) {
            if (optString.equals(TtmlNode.TAG_BR)) {
                b.INST.b();
                byte[] decompress = BrotliJNI.decompress((ByteBuffer) iVar.f141499a);
                if (decompress == null) {
                    return new f("fail brotli decompress file \"%s\"", str);
                }
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(decompress.length);
                allocateDirect.put(decompress);
                return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]).a("data", allocateDirect);
            }
            return new f("fail invalid compressionAlgorithm \"%s\"", optString);
        }
        int i3 = a.f122597a[readFile.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return new f("fail " + readFile.name(), new Object[0]);
                }
                return new f("fail \"%s\" is not a regular file", str);
            }
            return new f("fail permission denied, open \"%s\"", str);
        }
        return new f("fail no such file \"%s\"", str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        INST;

        static {
            com.tencent.luggage.wxa.aa.h.b("appbrandcommon", b.class.getClassLoader());
        }

        public void b() {
        }
    }
}
