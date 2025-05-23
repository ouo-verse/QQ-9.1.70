package com.tencent.luggage.wxa.c3;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.n3.p;
import com.tencent.luggage.wxa.tn.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f123254a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(float f16) {
            super(null);
            this.f123254a = f16;
        }

        @Override // com.tencent.luggage.wxa.c3.c.d
        public Bitmap a(Bitmap bitmap) {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), Math.round(bitmap.getWidth() * this.f123254a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f123255a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(float f16) {
            super(null);
            this.f123255a = f16;
        }

        @Override // com.tencent.luggage.wxa.c3.c.d
        public Bitmap a(Bitmap bitmap) {
            return Bitmap.createBitmap(bitmap, 0, 0, Math.round(bitmap.getHeight() / this.f123255a), bitmap.getHeight());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.c3.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6092c extends d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f123256a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f123257b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6092c(int i3, int i16) {
            super(null);
            this.f123256a = i3;
            this.f123257b = i16;
        }

        @Override // com.tencent.luggage.wxa.c3.c.d
        public Bitmap a(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int i3 = this.f123256a;
            if (width <= i3) {
                return bitmap;
            }
            return Bitmap.createScaledBitmap(bitmap, i3, this.f123257b, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class d {
        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        public abstract Bitmap a(Bitmap bitmap);

        public final Bitmap b(Bitmap bitmap) {
            Bitmap a16 = a(bitmap);
            if (a16 != bitmap) {
                try {
                    bitmap.recycle();
                } catch (Exception unused) {
                }
            }
            return a16;
        }
    }

    public static byte[] a(Bitmap bitmap) {
        byte[] bArr = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 70, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } finally {
            }
        } catch (IOException e16) {
            w.b("Luggage.HttpUploadImg", "convertBitmapToBytes failed", e16);
        }
        return bArr;
    }

    public static String b(Bitmap bitmap) {
        d bVar;
        if (bitmap != null && !bitmap.isRecycled()) {
            int round = Math.round(840.0f);
            int round2 = Math.round(672.0f);
            float f16 = round / round2;
            if (bitmap.getHeight() / bitmap.getWidth() >= f16) {
                bVar = new a(f16);
            } else {
                bVar = new b(f16);
            }
            byte[] a16 = a(new C6092c(round2, round).b(bVar.b(bitmap)));
            if (a16 == null) {
                w.b("Luggage.HttpUploadImg", "bytes is null, return");
                return "";
            }
            return a(a16);
        }
        w.b("Luggage.HttpUploadImg", "bitmap is null, return");
        return "";
    }

    public static String a(v vVar) {
        if (vVar != null && vVar.e()) {
            return a(RequestBody.create(p.f135237f, new File(vVar.g())));
        }
        w.b("Luggage.HttpUploadImg", "file is null, return");
        return "";
    }

    public static String a(byte[] bArr) {
        return a(RequestBody.create(p.f135237f, bArr));
    }

    public static String a(RequestBody requestBody) {
        String str;
        Response execute;
        str = "";
        try {
            execute = p.cgiClient().newCall(new Request.Builder().url("https://servicewechat.com/wxaruntime/uploadimg").post(requestBody).build()).execute();
        } catch (IOException | JSONException e16) {
            w.b("Luggage.HttpUploadImg", "uploadImgByHttpClientInner error:%s", e16);
        }
        try {
            JSONObject jSONObject = execute.body() != null ? new JSONObject(execute.body().string()) : null;
            w.d("Luggage.HttpUploadImg", "respObj:%s", jSONObject);
            str = jSONObject != null ? jSONObject.optString("url") : "";
            execute.close();
            return str;
        } catch (Throwable th5) {
            if (execute != null) {
                try {
                    execute.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }
}
