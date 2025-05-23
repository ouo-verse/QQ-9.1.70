package com.tencent.luggage.wxa.p004if;

import android.os.Build;
import com.tencent.luggage.wxa.bo.e;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.eo.c;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.tn.n0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.l0;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j extends com.tencent.luggage.wxa.xd.a {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f130206a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f130207b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130208c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.if.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6304a extends n0.b.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n0.b.C6773b[] f130210a;

            public C6304a(n0.b.C6773b[] c6773bArr) {
                this.f130210a = c6773bArr;
            }

            @Override // com.tencent.luggage.wxa.tn.n0.b.a
            public void b(n0.b.C6773b c6773b) {
                this.f130210a[0] = c6773b;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b extends n0.b.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n0.b.C6773b[] f130212a;

            public b(n0.b.C6773b[] c6773bArr) {
                this.f130212a = c6773bArr;
            }

            @Override // com.tencent.luggage.wxa.tn.n0.b.a
            public void b(n0.b.C6773b c6773b) {
                this.f130212a[0] = c6773b;
            }
        }

        public a(d dVar, String str, int i3) {
            this.f130206a = dVar;
            this.f130207b = str;
            this.f130208c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (!this.f130206a.isRunning()) {
                return;
            }
            if (l0.a()) {
                h.f146825d.d(this);
                return;
            }
            InputStream readStream = this.f130206a.getFileSystem().readStream(this.f130207b);
            OutputStream outputStream = null;
            try {
                try {
                    if (readStream == null) {
                        this.f130206a.a(this.f130208c, j.this.makeReturnJson("fail file not exists"));
                    } else {
                        String extension = FilenameUtils.getExtension(this.f130207b);
                        String c16 = e.c(extension);
                        if (!j.this.b(c16)) {
                            this.f130206a.a(this.f130208c, j.this.makeReturnJson("fail invalid file type"));
                            return;
                        }
                        String c17 = j.this.c(extension);
                        if (Build.VERSION.SDK_INT < 29 || com.tencent.luggage.wxa.tn.d.b()) {
                            boolean a16 = j.this.a(c17, readStream);
                            if (a16) {
                                j.this.d(c17);
                                com.tencent.luggage.wxa.bo.b.a(c17, this.f130206a.getContext());
                            }
                            d dVar = this.f130206a;
                            int i3 = this.f130208c;
                            j jVar = j.this;
                            if (!a16) {
                                str = "fail";
                            } else {
                                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                            }
                            dVar.a(i3, jVar.makeReturnJson(str));
                        } else {
                            n0.b.C6773b[] c6773bArr = {null};
                            if (StringUtils.contains(c16, "video")) {
                                n0.a.b(z.c(), c17, new C6304a(c6773bArr));
                            } else if (StringUtils.contains(c16, "image")) {
                                n0.a.a(z.c(), c17, new b(c6773bArr));
                            }
                            n0.b.C6773b c6773b = c6773bArr[0];
                            if (c6773b != null) {
                                outputStream = c6773b.b();
                            }
                            if (outputStream != null) {
                                j.a(readStream, outputStream);
                                outputStream.flush();
                                c6773bArr[0].c();
                                j.this.d(c17);
                                this.f130206a.a(this.f130208c, j.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                            } else {
                                throw new IOException("Open OutputStream with MediaStore fail!");
                            }
                        }
                    }
                } catch (IOException e16) {
                    this.f130206a.a(this.f130208c, j.this.makeReturnJson("fail"));
                    w.a("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", e16, "", new Object[0]);
                } catch (Exception e17) {
                    this.f130206a.a(this.f130208c, j.this.makeReturnJson("fail"));
                    w.a("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", e17, "", new Object[0]);
                }
            } finally {
                w0.a((Closeable) readStream);
                w0.a((Closeable) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b extends c {
    }

    public abstract boolean b(String str);

    public abstract String c(String str);

    public abstract void d(String str);

    @Override // com.tencent.luggage.wxa.xd.a
    public final void invoke(d dVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("filePath", "");
        if (w0.c(optString)) {
            dVar.a(i3, makeReturnJson("fail filePath invalid"));
            return;
        }
        a aVar = new a(dVar, optString, i3);
        com.tencent.luggage.wxa.k0.d.a(g.a(b.class));
        w.h("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "NULL permissionInterface with appId:%s, run directly", dVar.getAppId());
        aVar.run();
    }

    public final boolean a(String str, InputStream inputStream) {
        OutputStream outputStream = null;
        try {
            v vVar = new v(str);
            vVar.k().w();
            outputStream = x.b(vVar);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return true;
                }
            }
        } catch (Exception e16) {
            w.b("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "writeFile exp %s", e16);
            return false;
        } finally {
            w0.a((Closeable) outputStream);
            w0.a((Closeable) inputStream);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j3 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j3;
            }
            outputStream.write(bArr, 0, read);
            j3 += read;
        }
    }
}
