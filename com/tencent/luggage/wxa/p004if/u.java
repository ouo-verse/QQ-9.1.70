package com.tencent.luggage.wxa.p004if;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tk.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.ym.a;
import com.tencent.luggage.wxa.ym.b;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 733;
    public static final String NAME = "compressVideo";

    /* renamed from: a, reason: collision with root package name */
    public AtomicBoolean f130238a = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.C6962a f130239a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f130240b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130241c;

        public a(a.C6962a c6962a, d dVar, int i3) {
            this.f130239a = c6962a;
            this.f130240b = dVar;
            this.f130241c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a16 = com.tencent.luggage.wxa.ym.a.a(this.f130239a.f146022a);
            if (u.this.a(this.f130240b, a16, this.f130241c)) {
                u.this.f130238a.compareAndSet(true, false);
                return;
            }
            d dVar = this.f130240b;
            if (dVar != null && dVar.getFileSystem() != null) {
                if (a16 == 2) {
                    w.b("MicroMsg.JsApiCompressVideo", "file not be compressed, cuz unnecessary");
                    i iVar = new i();
                    this.f130240b.getFileSystem().createTempFileFrom(new v(this.f130239a.f146022a), "mp4", false, iVar);
                    HashMap hashMap = new HashMap();
                    hashMap.put("tempFilePath", iVar.f141499a);
                    hashMap.put("size", Long.valueOf(Math.round((x.e(this.f130239a.f146022a) * 1.0d) / 1024.0d)));
                    this.f130240b.a(this.f130241c, u.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                    u.this.f130238a.compareAndSet(true, false);
                    return;
                }
                String a17 = com.tencent.luggage.wxa.ym.a.a(this.f130239a);
                if (!x.d(a17)) {
                    w.d("MicroMsg.JsApiCompressVideo", "compressed file not exist");
                    this.f130240b.a(this.f130241c, u.this.makeReturnJson("fail:compress failed, generate path failed"));
                    u.this.f130238a.compareAndSet(true, false);
                    return;
                }
                i iVar2 = new i();
                this.f130240b.getFileSystem().createTempFileFrom(new v(a17), null, false, iVar2);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("tempFilePath", iVar2.f141499a);
                hashMap2.put("size", Long.valueOf(Math.round((x.e(a17) * 1.0d) / 1024.0d)));
                this.f130240b.a(this.f130241c, u.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap2));
                u.this.f130238a.compareAndSet(true, false);
                return;
            }
            w.d("MicroMsg.JsApiCompressVideo", "component or file system is null");
            u.this.f130238a.compareAndSet(true, false);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        float f16;
        a.C6962a c6962a;
        if (this.f130238a.get()) {
            w.d("MicroMsg.JsApiCompressVideo", "is compressing now");
            dVar.a(i3, makeReturnJson("fail:is compressing now"));
            return;
        }
        if (dVar == null) {
            w.b("MicroMsg.JsApiCompressVideo", "fail:component is null");
            return;
        }
        if (jSONObject == null) {
            w.f("MicroMsg.JsApiCompressVideo", "fail:data is null");
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        String optString = jSONObject.optString("src");
        if (w0.c(optString)) {
            w.f("MicroMsg.JsApiCompressVideo", "fail:data src is empty");
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        if (!optString.startsWith("wxfile://")) {
            w.f("MicroMsg.JsApiCompressVideo", "fail:src path not supported");
            dVar.a(i3, makeReturnJson("fail:src path not be supported"));
            return;
        }
        r fileSystem = dVar.getFileSystem();
        if (fileSystem == null) {
            w.f("MicroMsg.JsApiCompressVideo", "fail:runtime fileSystem is null");
            dVar.a(i3, makeReturnJson("fail:internal error"));
            return;
        }
        v absoluteFile = fileSystem.getAbsoluteFile(optString);
        if (absoluteFile == null) {
            w.f("MicroMsg.JsApiCompressVideo", "fail:srcFile is null");
            dVar.a(i3, makeReturnJson("fail:file doesn't exist"));
            return;
        }
        String g16 = absoluteFile.g();
        if (!x.d(g16)) {
            w.f("MicroMsg.JsApiCompressVideo", "fail:filePath is null or without exist file");
            dVar.a(i3, makeReturnJson("fail:file doesn't exist"));
            return;
        }
        if (!jSONObject.has(CustomImageProps.QUALITY) && !jSONObject.has("bitrate") && !jSONObject.has("fps") && !jSONObject.has("resolution")) {
            w.f("MicroMsg.JsApiCompressVideo", "no quality config");
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        if (jSONObject.has(CustomImageProps.QUALITY)) {
            w.d("MicroMsg.JsApiCompressVideo", "compress with quality config");
            a(dVar, i3, g16, jSONObject.optString(CustomImageProps.QUALITY));
            return;
        }
        w.d("MicroMsg.JsApiCompressVideo", "compress with advance config");
        float optDouble = (float) jSONObject.optDouble("resolution", 1.0d);
        if (optDouble > 0.0f && optDouble <= 1.0f) {
            f16 = (Math.round(optDouble * 10.0f) * 1.0f) / 10.0f;
        } else {
            f16 = 1.0f;
        }
        a.b c16 = com.tencent.luggage.wxa.ym.a.c(g16);
        if (c16 == null) {
            w.f("MicroMsg.JsApiCompressVideo", "fail:videoInfo is null");
            dVar.a(i3, makeReturnJson("fail:can't get info from video file"));
            return;
        }
        int round = Math.round(c16.f146034f * f16);
        int round2 = Math.round(c16.f146035g * f16);
        int i16 = com.tencent.luggage.wxa.ym.a.f146021a;
        int optInt = jSONObject.optInt("bitrate", Math.round((i16 * 1.0f) / 1000.0f)) * 1000;
        if (optInt <= 0 || optInt >= c16.f146036h) {
            optInt = i16;
        }
        float optDouble2 = (float) jSONObject.optDouble("fps", b.f146041d);
        if (optDouble2 < 1.0f || optDouble2 > c16.f146037i) {
            optDouble2 = b.f146041d;
        }
        w.d("MicroMsg.JsApiCompressVideo", "ratio: %f, bitrate: %d, fps: %f", Float.valueOf(f16), Integer.valueOf(optInt), Float.valueOf(optDouble2));
        if (round != 0 && round2 != 0) {
            c6962a = new a.C6962a(g16, 0, 0, round, round2, optInt, optDouble2);
        } else {
            c6962a = new a.C6962a(g16, 720, 540, 0, 0, optInt, optDouble2);
        }
        a(dVar, i3, c6962a);
    }

    public final void a(d dVar, int i3, String str, String str2) {
        a(dVar, i3, a(str, str2));
    }

    public final void a(d dVar, int i3, a.C6962a c6962a) {
        this.f130238a.compareAndSet(false, true);
        l.a().d(new a(c6962a, dVar, i3));
    }

    public final boolean a(d dVar, int i3, int i16) {
        if (i3 == -50006) {
            return false;
        }
        if (i3 == -50002) {
            w.d("MicroMsg.JsApiCompressVideo", "fail:compress failed, video duration error");
            dVar.a(i16, makeReturnJson("fail:compress failed, video duration error"));
            return true;
        }
        if (i3 == -50001) {
            w.d("MicroMsg.JsApiCompressVideo", "fail:compress failed, file not exist");
            dVar.a(i16, makeReturnJson("fail:file doesn't exist"));
            return true;
        }
        if (i3 != 1) {
            return i3 != 2;
        }
        w.d("MicroMsg.JsApiCompressVideo", "fail:compress failed, file type not be supported");
        dVar.a(i16, makeReturnJson("fail:compress failed, video type not be supported"));
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
    
        if (r19.equals(com.tencent.hippy.qq.adapter.image.HippyImageInfo.QUALITY_LOW) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a.C6962a a(String str, String str2) {
        char c16 = 1;
        w.d("MicroMsg.JsApiCompressVideo", "quality: %s", str2);
        a.b c17 = com.tencent.luggage.wxa.ym.a.c(str);
        int i3 = c17 == null ? 720 : c17.f146034f;
        int i16 = c17 == null ? 540 : c17.f146035g;
        str2.hashCode();
        switch (str2.hashCode()) {
            case -1078030475:
                if (str2.equals("medium")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 107348:
                break;
            case 3202466:
                if (str2.equals("high")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                return new a.C6962a(str, 0, 0, Math.round(i3 * 0.5f), Math.round(i16 * 0.5f), Math.round(com.tencent.luggage.wxa.ym.a.f146021a * 1.5f), b.f146041d);
            case 1:
                return new a.C6962a(str, 0, 0, Math.round(i3 * 0.3f), Math.round(i16 * 0.3f), com.tencent.luggage.wxa.ym.a.f146021a, b.f146041d);
            case 2:
                return new a.C6962a(str, 0, 0, Math.round(i3 * 0.8f), Math.round(i16 * 0.8f), Math.round(com.tencent.luggage.wxa.ym.a.f146021a * 2.0f), b.f146041d);
            default:
                return null;
        }
    }
}
