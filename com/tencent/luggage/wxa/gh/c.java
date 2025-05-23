package com.tencent.luggage.wxa.gh;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.luggage.wxa.hd.a;
import com.tencent.luggage.wxa.p004if.s;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.x0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f126712a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC6243c f126713b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f126714c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WeakReference f126715d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f126716e;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.gh.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6242a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.nl.a f126717a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ byte[] f126718b;

            public RunnableC6242a(com.tencent.luggage.wxa.nl.a aVar, byte[] bArr) {
                this.f126717a = aVar;
                this.f126718b = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f126717a.setImageByteArray(this.f126718b);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f126720a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bitmap f126721b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.nl.a f126722c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Bitmap f126723d;

            public b(boolean z16, Bitmap bitmap, com.tencent.luggage.wxa.nl.a aVar, Bitmap bitmap2) {
                this.f126720a = z16;
                this.f126721b = bitmap;
                this.f126722c = aVar;
                this.f126723d = bitmap2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (this.f126720a && (bitmap = this.f126721b) != null) {
                    this.f126722c.setImageBitmap(bitmap);
                } else {
                    this.f126722c.setImageBitmap(this.f126723d);
                }
            }
        }

        public a(String str, InterfaceC6243c interfaceC6243c, WeakReference weakReference, WeakReference weakReference2, JSONObject jSONObject) {
            this.f126712a = str;
            this.f126713b = interfaceC6243c;
            this.f126714c = weakReference;
            this.f126715d = weakReference2;
            this.f126716e = jSONObject;
        }

        @Override // com.tencent.luggage.wxa.hd.a.c
        public void a(InputStream inputStream) {
            Bitmap bitmap = null;
            if (inputStream == null) {
                w.b("Luggage.ViewAttributeHelper", "attachImageViewAttribute, openRead failed, url=%s", this.f126712a);
                InterfaceC6243c interfaceC6243c = this.f126713b;
                if (interfaceC6243c != null) {
                    interfaceC6243c.a(null);
                    return;
                }
                return;
            }
            InputStream a16 = com.tencent.luggage.wxa.vd.a.a(inputStream);
            a16.mark(com.tencent.luggage.wxa.vd.a.a());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                c.a().a(a16, null, options);
                String str = options.outMimeType;
                InterfaceC6243c interfaceC6243c2 = this.f126713b;
                if (interfaceC6243c2 != null) {
                    interfaceC6243c2.a(options);
                }
                if (!TextUtils.isEmpty(str)) {
                    str.hashCode();
                    if (str.equals("image/GIF") || str.equals("image/gif")) {
                        try {
                            a16.reset();
                            byte[] byteArray = IOUtils.toByteArray(a16);
                            IOUtils.closeQuietly(a16);
                            com.tencent.luggage.wxa.xd.d dVar = (com.tencent.luggage.wxa.xd.d) this.f126714c.get();
                            com.tencent.luggage.wxa.nl.a aVar = (com.tencent.luggage.wxa.nl.a) this.f126715d.get();
                            if (dVar != null && aVar != null) {
                                dVar.a(new RunnableC6242a(aVar, byteArray));
                                return;
                            }
                            return;
                        } catch (Throwable unused) {
                            w.b("Luggage.ViewAttributeHelper", "attachImageViewAttribute, setImageByteArray failed, url=%s", this.f126712a);
                            return;
                        }
                    }
                }
                try {
                    a16.reset();
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                    while (true) {
                        int i3 = options.outHeight * options.outWidth;
                        int i16 = options.inSampleSize;
                        if ((i3 / i16) / i16 <= 16000000) {
                            break;
                        } else {
                            options.inSampleSize = i16 + 1;
                        }
                    }
                    options.inJustDecodeBounds = false;
                    options.inMutable = true;
                    Bitmap a17 = c.a().a(a16, null, options);
                    IOUtils.closeQuietly(a16);
                    if (a17 != null && !a17.isRecycled()) {
                        boolean optBoolean = this.f126716e.optBoolean("useBlur", false);
                        if (optBoolean) {
                            int b16 = c.b(this.f126716e.optInt("blurRadius", 0));
                            w.d("Luggage.ViewAttributeHelper", "useBlur,radius is %d", Integer.valueOf(b16));
                            bitmap = com.tencent.luggage.wxa.tn.d.a(a17, b16);
                        }
                        Bitmap bitmap2 = bitmap;
                        com.tencent.luggage.wxa.xd.d dVar2 = (com.tencent.luggage.wxa.xd.d) this.f126714c.get();
                        com.tencent.luggage.wxa.nl.a aVar2 = (com.tencent.luggage.wxa.nl.a) this.f126715d.get();
                        if (dVar2 != null && aVar2 != null) {
                            dVar2.a(new b(optBoolean, bitmap2, aVar2, a17));
                        }
                    }
                } catch (Throwable th5) {
                    w.a("Luggage.ViewAttributeHelper", th5, "attachImageViewAttribute, setImageBitmap failed, url=%ss", this.f126712a);
                }
            } catch (IllegalArgumentException e16) {
                w.a("Luggage.ViewAttributeHelper", e16, "[CAUGHT EXCEPTION]", new Object[0]);
                InterfaceC6243c interfaceC6243c3 = this.f126713b;
                if (interfaceC6243c3 != null) {
                    interfaceC6243c3.a(null);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        float getTextSize();

        void setEllipsize(TextUtils.TruncateAt truncateAt);

        void setFakeBoldText(boolean z16);

        void setFontWeight(int i3);

        void setGravity(int i3);

        void setLineHeight(int i3);

        void setSingleLine(boolean z16);

        void setText(CharSequence charSequence);

        void setTextColor(int i3);

        void setTextSize(int i3, float f16);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.gh.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6243c {
        void a(BitmapFactory.Options options);
    }

    public static /* synthetic */ s a() {
        return b();
    }

    public static s b() {
        return s.b.a();
    }

    public static int b(int i3) {
        return i3 == 0 ? (x0.b() || com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g) ? Integer.parseInt(com.tencent.luggage.wxa.so.f.f140567a.a(new com.tencent.luggage.wxa.jn.a())) : i3 : i3;
    }

    public static void a(com.tencent.luggage.wxa.xd.f fVar, int i3, com.tencent.luggage.wxa.nl.a aVar, JSONObject jSONObject, InterfaceC6243c interfaceC6243c) {
        if (aVar == null || jSONObject == null) {
            return;
        }
        try {
            String a16 = com.tencent.luggage.wxa.cg.d.a(fVar, aVar, jSONObject);
            String optString = jSONObject.optString("iconPath");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            if (optString.startsWith("data:image/") && optString.contains("base64")) {
                w.d("Luggage.ViewAttributeHelper", "it is data:image/ format file, iconPath:%s", optString);
                byte[] decode = Base64.decode(optString.substring(optString.indexOf("base64,") + 7).trim(), 0);
                if (decode != null && decode.length != 0) {
                    if (interfaceC6243c != null) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        try {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
                            try {
                                b().a(byteArrayInputStream, null, options);
                                interfaceC6243c.a(options);
                                byteArrayInputStream.close();
                            } finally {
                            }
                        } catch (Exception e16) {
                            w.b("Luggage.ViewAttributeHelper", "attachImageViewAttribute appId:%s, viewId:%d, decode gif bounds, get exception:%s", fVar.getAppId(), Integer.valueOf(i3), e16);
                            interfaceC6243c.a(null);
                        }
                    }
                    aVar.setImageByteArray(decode);
                    return;
                }
                w.d("Luggage.ViewAttributeHelper", "bytes is empty");
                if (interfaceC6243c != null) {
                    interfaceC6243c.a(null);
                    return;
                }
                return;
            }
            String c16 = ((com.tencent.luggage.wxa.hd.b) fVar.b(com.tencent.luggage.wxa.hd.b.class)).c(fVar, optString);
            ((com.tencent.luggage.wxa.hd.a) fVar.b(com.tencent.luggage.wxa.hd.a.class)).a(c16, com.tencent.luggage.wxa.cg.d.a(a16), new a(c16, interfaceC6243c, new WeakReference(fVar), new WeakReference(aVar), jSONObject));
        } catch (NullPointerException e17) {
            w.a("Luggage.ViewAttributeHelper", e17, "attachImageViewAttribute", new Object[0]);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:20:0x005a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.tencent.luggage.wxa.gh.c$b] */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.CharSequence, java.lang.String] */
    public static void a(com.tencent.luggage.wxa.gh.c.b r4, org.json.JSONObject r5) {
        /*
            if (r4 == 0) goto Le9
            if (r5 != 0) goto L6
            goto Le9
        L6:
            java.lang.String r0 = "color"
            java.lang.String r0 = r5.getString(r0)     // Catch: org.json.JSONException -> L1a
            boolean r1 = com.tencent.luggage.wxa.tn.w0.c(r0)     // Catch: org.json.JSONException -> L1a
            if (r1 != 0) goto L1a
            int r0 = com.tencent.luggage.wxa.tk.g.a(r0)     // Catch: org.json.JSONException -> L1a
            r4.setTextColor(r0)     // Catch: org.json.JSONException -> L1a
        L1a:
            r0 = 0
            java.lang.String r1 = "fontSize"
            double r1 = r5.getDouble(r1)     // Catch: org.json.JSONException -> L2a
            float r1 = (float) r1     // Catch: org.json.JSONException -> L2a
            float r1 = com.tencent.luggage.wxa.tk.g.a(r1)     // Catch: org.json.JSONException -> L2a
            r4.setTextSize(r0, r1)     // Catch: org.json.JSONException -> L2a
        L2a:
            r1 = 1
            java.lang.String r2 = "textAlign"
            java.lang.String r2 = r5.getString(r2)     // Catch: org.json.JSONException -> L5a
            java.lang.String r3 = "left"
            boolean r3 = r3.equals(r2)     // Catch: org.json.JSONException -> L5a
            if (r3 == 0) goto L40
            r2 = 3
            r4.setGravity(r2)     // Catch: org.json.JSONException -> L5a
            goto L5a
        L40:
            java.lang.String r3 = "center"
            boolean r3 = r3.equals(r2)     // Catch: org.json.JSONException -> L5a
            if (r3 == 0) goto L4d
            r4.setGravity(r1)     // Catch: org.json.JSONException -> L5a
            goto L5a
        L4d:
            java.lang.String r3 = "right"
            boolean r2 = r3.equals(r2)     // Catch: org.json.JSONException -> L5a
            if (r2 == 0) goto L5a
            r2 = 5
            r4.setGravity(r2)     // Catch: org.json.JSONException -> L5a
        L5a:
            java.lang.String r2 = "fontWeight"
            java.lang.String r2 = r5.getString(r2)     // Catch: org.json.JSONException -> L8a
            java.lang.String r3 = "bold"
            boolean r3 = r3.equals(r2)     // Catch: org.json.JSONException -> L8a
            if (r3 == 0) goto L6e
            r4.setFakeBoldText(r1)     // Catch: org.json.JSONException -> L8a
            goto L8a
        L6e:
            java.lang.String r3 = "normal"
            boolean r3 = r3.equals(r2)     // Catch: org.json.JSONException -> L8a
            if (r3 == 0) goto L7b
            r4.setFakeBoldText(r0)     // Catch: org.json.JSONException -> L8a
            goto L8a
        L7b:
            int r2 = com.tencent.luggage.wxa.tn.w0.f(r2)     // Catch: org.json.JSONException -> L8a
            r3 = 100
            if (r2 < r3) goto L8a
            r3 = 900(0x384, float:1.261E-42)
            if (r2 > r3) goto L8a
            r4.setFontWeight(r2)     // Catch: org.json.JSONException -> L8a
        L8a:
            float r2 = r4.getTextSize()
            r3 = 1067030938(0x3f99999a, float:1.2)
            float r2 = r2 * r3
            int r2 = java.lang.Math.round(r2)
            java.lang.String r3 = "lineHeight"
            int r2 = com.tencent.luggage.wxa.tk.g.a(r5, r3, r2)
            r4.setLineHeight(r2)
            java.lang.String r2 = "lineBreak"
            java.lang.String r2 = r5.getString(r2)     // Catch: org.json.JSONException -> Ldf
            java.lang.String r3 = "ellipsis"
            boolean r3 = r3.equals(r2)     // Catch: org.json.JSONException -> Ldf
            if (r3 == 0) goto Lb9
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.END     // Catch: org.json.JSONException -> Ldf
            r4.setEllipsize(r0)     // Catch: org.json.JSONException -> Ldf
            r4.setSingleLine(r1)     // Catch: org.json.JSONException -> Ldf
            goto Ldf
        Lb9:
            java.lang.String r3 = "clip"
            boolean r3 = r3.equals(r2)     // Catch: org.json.JSONException -> Ldf
            if (r3 == 0) goto Lc6
            r4.setSingleLine(r1)     // Catch: org.json.JSONException -> Ldf
            goto Ldf
        Lc6:
            java.lang.String r1 = "break-word"
            boolean r1 = r1.equals(r2)     // Catch: org.json.JSONException -> Ldf
            if (r1 == 0) goto Ld3
            r4.setSingleLine(r0)     // Catch: org.json.JSONException -> Ldf
            goto Ldf
        Ld3:
            java.lang.String r1 = "break-all"
            boolean r1 = r1.equals(r2)     // Catch: org.json.JSONException -> Ldf
            if (r1 == 0) goto Ldf
            r4.setSingleLine(r0)     // Catch: org.json.JSONException -> Ldf
        Ldf:
            java.lang.String r0 = "content"
            java.lang.String r5 = r5.getString(r0)     // Catch: org.json.JSONException -> Le9
            r4.setText(r5)     // Catch: org.json.JSONException -> Le9
        Le9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.wxa.gh.c.a(com.tencent.luggage.wxa.gh.c$b, org.json.JSONObject):void");
    }
}
