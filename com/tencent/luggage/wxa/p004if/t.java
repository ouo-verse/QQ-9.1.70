package com.tencent.luggage.wxa.p004if;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.luggage.wxa.af.g;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.p004if.j;
import com.tencent.luggage.wxa.p004if.s;
import com.tencent.luggage.wxa.p004if.t;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 528;
    private static final String NAME = "compressImage";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f130227a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130228b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130229c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f130230d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f130231e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ WeakReference f130232f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f130233g;

        public a(String str, com.tencent.luggage.wxa.xd.d dVar, int i3, int i16, int i17, WeakReference weakReference, int i18) {
            this.f130227a = str;
            this.f130228b = dVar;
            this.f130229c = i3;
            this.f130230d = i16;
            this.f130231e = i17;
            this.f130232f = weakReference;
            this.f130233g = i18;
        }

        @Override // java.lang.Runnable
        public void run() {
            d eVar;
            a aVar = null;
            if (!w0.c(this.f130227a) && this.f130227a.startsWith("wxfile://")) {
                eVar = new c(aVar);
            } else {
                eVar = new e(aVar);
            }
            b a16 = eVar.a(this.f130228b, this.f130227a, this.f130229c, this.f130230d, this.f130231e);
            if (this.f130232f.get() != null && ((com.tencent.luggage.wxa.xd.d) this.f130232f.get()).isRunning()) {
                com.tencent.luggage.wxa.xd.d dVar = (com.tencent.luggage.wxa.xd.d) this.f130232f.get();
                if (a16 != null && (a16.f130235a || !w0.c(a16.f130236b))) {
                    if (!a16.f130235a) {
                        w.h("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", a16.f130236b);
                        dVar.a(this.f130233g, t.this.makeReturnJson(a16.f130236b, a16.f130237c));
                        return;
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempFilePath", a16.f130236b);
                        dVar.a(this.f130233g, t.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, com.tencent.luggage.wxa.af.e.f121305a, hashMap));
                        return;
                    }
                }
                w.f("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
                dVar.a(this.f130233g, t.this.makeReturnJson("fail:compress image fail", a16.f130237c));
                return;
            }
            w.f("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f130235a;

        /* renamed from: b, reason: collision with root package name */
        public String f130236b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.af.c f130237c;

        public b(boolean z16, String str, com.tencent.luggage.wxa.af.c cVar) {
            this.f130235a = z16;
            this.f130236b = str;
            this.f130237c = cVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c implements d {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.if.t.d
        public b a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3, int i16, int i17) {
            String str2;
            Bitmap.CompressFormat compressFormat;
            r fileSystem = dVar.getFileSystem();
            if (fileSystem == null) {
                w.f("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:fileSystem is null");
                return new b(false, "fail:runtime fileSystem is null", com.tencent.luggage.wxa.af.e.f121309e);
            }
            v absoluteFile = dVar.getFileSystem().getAbsoluteFile(str);
            if (absoluteFile == null) {
                w.f("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
                return new b(false, "fail:file doesn't exist", g.f121332a);
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                Bitmap a16 = s.b.a().a(absoluteFile.g(), options);
                if (a16 != null) {
                    Bitmap b16 = t.b(a16, i16, i17);
                    if (com.tencent.luggage.wxa.g2.a.b(options)) {
                        str2 = "jpg";
                    } else {
                        str2 = "png";
                    }
                    String str3 = com.tencent.luggage.wxa.db.a.g() + "microMsg.tmp." + System.currentTimeMillis() + "." + str2;
                    if (com.tencent.luggage.wxa.g2.a.b(options)) {
                        compressFormat = Bitmap.CompressFormat.JPEG;
                    } else {
                        compressFormat = Bitmap.CompressFormat.PNG;
                    }
                    com.tencent.luggage.wxa.tn.d.a(b16, i3, compressFormat, str3, true);
                    if (com.tencent.luggage.wxa.g2.a.b(options)) {
                        com.tencent.luggage.wxa.vd.c.a(absoluteFile.g(), str3);
                    }
                    i iVar = new i();
                    if (fileSystem.createTempFileFrom(new v(str3), str2, false, iVar) != l.OK) {
                        w.f("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
                        return new b(false, "fail:create tmp file fail", g.f121334c);
                    }
                    w.d("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", str3, iVar.f141499a);
                    return new b(true, (String) iVar.f141499a, com.tencent.luggage.wxa.af.e.f121305a);
                }
                w.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
                return new b(false, "fail:decode image fail", g.f121333b);
            } catch (NullPointerException e16) {
                w.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", e16);
                return new b(false, "fail:compress image NPE", g.f121335d);
            } catch (Exception e17) {
                w.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", e17);
                x.c(null);
                return new b(false, "fail:compress image exception", g.f121335d);
            } catch (OutOfMemoryError e18) {
                w.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", e18);
                return new b(false, "fail:compress image OOM", com.tencent.luggage.wxa.af.e.f121325u);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        b a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e implements d {
        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.if.t.d
        public b a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3, int i16, int i17) {
            String str2;
            Bitmap.CompressFormat compressFormat;
            if (dVar != null && (dVar instanceof com.tencent.luggage.wxa.ic.l)) {
                r fileSystem = dVar.getFileSystem();
                if (fileSystem == null) {
                    w.f("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:runtime fileSystem is null");
                    return new b(false, "fail:runtime fileSystem is null", com.tencent.luggage.wxa.af.e.f121309e);
                }
                InputStream d16 = k0.d(((com.tencent.luggage.wxa.ic.l) dVar).getRuntime(), str);
                if (d16 == null) {
                    w.f("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
                    return new b(false, "fail:file doesn't exist", g.f121332a);
                }
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    Bitmap a16 = s.b.a().a(d16, null, options);
                    if (a16 != null) {
                        Bitmap b16 = t.b(a16, i16, i17);
                        if (com.tencent.luggage.wxa.g2.a.b(options)) {
                            str2 = "jpg";
                        } else {
                            str2 = "png";
                        }
                        String str3 = com.tencent.luggage.wxa.db.a.g() + "microMsg.tmp." + System.currentTimeMillis() + "." + str2;
                        if (com.tencent.luggage.wxa.g2.a.b(options)) {
                            compressFormat = Bitmap.CompressFormat.JPEG;
                        } else {
                            compressFormat = Bitmap.CompressFormat.PNG;
                        }
                        com.tencent.luggage.wxa.tn.d.a(b16, i3, compressFormat, str3, true);
                        if (com.tencent.luggage.wxa.g2.a.b(options)) {
                            com.tencent.luggage.wxa.vd.c.a(d16, str3);
                        }
                        i iVar = new i();
                        if (fileSystem.createTempFileFrom(new v(str3), str2, false, iVar) != l.OK) {
                            w.f("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
                            return new b(false, "fail:create tmp file fail", g.f121334c);
                        }
                        w.d("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", str3, iVar.f141499a);
                        return new b(true, (String) iVar.f141499a, com.tencent.luggage.wxa.af.e.f121305a);
                    }
                    w.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
                    return new b(false, "fail:decode image fail", g.f121333b);
                } catch (NullPointerException e16) {
                    w.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", e16);
                    return new b(false, "fail:compress image NPE", g.f121335d);
                } catch (Exception e17) {
                    w.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception:%s", e17);
                    x.c(null);
                    return new b(false, "fail:compress image exception", g.f121335d);
                } catch (OutOfMemoryError e18) {
                    w.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", e18);
                    return new b(false, "fail:compress image OOM", com.tencent.luggage.wxa.af.e.f121325u);
                }
            }
            w.f("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:not in service context");
            return new b(false, "fail:internal error invalid js component", com.tencent.luggage.wxa.af.e.f121309e);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(final com.tencent.luggage.wxa.xd.d dVar, final JSONObject jSONObject, final int i3) {
        Runnable runnable = new Runnable() { // from class: t21.c
            @Override // java.lang.Runnable
            public final void run() {
                t.this.b(dVar, jSONObject, i3);
            }
        };
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(j.b.class));
        w.h("MicroMsg.JsApiCompressImage.javayhu", "NULL permissionInterface with appId:%s, run directly", dVar.getAppId());
        runnable.run();
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null) {
            w.b("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
            return;
        }
        if (jSONObject == null) {
            w.f("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        String optString = jSONObject.optString("src");
        if (w0.c(optString)) {
            w.f("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
            dVar.a(i3, makeReturnJson("fail:data src is null", com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        if (dVar.getFileSystem() == null) {
            w.f("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
            dVar.a(i3, makeReturnJson("fail:runtime fileSystem is null", com.tencent.luggage.wxa.af.e.f121309e));
            return;
        }
        int optInt = jSONObject.optInt(CustomImageProps.QUALITY, 80);
        if (optInt >= 1 && optInt <= 100) {
            int optInt2 = jSONObject.optInt("compressedWidth", -1);
            int optInt3 = jSONObject.optInt("compressedHeight", -1);
            w.d("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", Integer.valueOf(optInt), optString);
            com.tencent.luggage.wxa.co.a.a(new a(optString, dVar, optInt, optInt2, optInt3, new WeakReference(dVar), i3), String.format(Locale.US, "AppBrandJsApiCompressImage[%s#%d]", optString, Integer.valueOf(optInt)), 10);
            return;
        }
        w.h("MicroMsg.JsApiCompressImage.javayhu", "invalid quality %d", Integer.valueOf(optInt));
        dVar.a(i3, makeReturnJson(g.f121336e));
    }

    public static Bitmap b(Bitmap bitmap, float f16, float f17) {
        float f18;
        float f19;
        if (f16 <= 0.0f && f17 <= 0.0f) {
            return bitmap;
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        w.d("MicroMsg.JsApiCompressImage.javayhu", "scaleTheBitmap srcWidth:%f srcHeight:%f targetCompressWidth:%f targetCompressHeight:%f", Float.valueOf(width), Float.valueOf(height), Float.valueOf(f16), Float.valueOf(f17));
        if (width > 0.0f && height > 0.0f) {
            if (f16 <= 0.0f || f17 <= 0.0f) {
                f18 = f16 > 0.0f ? f16 / width : f17 / height;
                f19 = f18;
            } else {
                f18 = f16 / width;
                f19 = f17 / height;
            }
            w.d("MicroMsg.JsApiCompressImage.javayhu", "scaleTheBitmap widthScale:%f heightScale:%f", Float.valueOf(f18), Float.valueOf(f19));
            try {
                Bitmap a16 = com.tencent.luggage.wxa.tn.d.a(bitmap, f18, f19);
                w.d("MicroMsg.JsApiCompressImage.javayhu", "scaleTheBitmap scaledBitmap width:%d height:%d", Integer.valueOf(a16.getWidth()), Integer.valueOf(a16.getHeight()));
                return a16;
            } catch (Exception e16) {
                w.b("MicroMsg.JsApiCompressImage.javayhu", "scaleTheBitmap %s", e16);
            }
        }
        return bitmap;
    }
}
