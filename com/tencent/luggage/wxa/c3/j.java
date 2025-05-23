package com.tencent.luggage.wxa.c3;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import com.tencent.luggage.opensdk.OpenSDKApiContentProvider;
import com.tencent.luggage.wxa.c3.j;
import com.tencent.luggage.wxa.kj.s;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e.c {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(Void r16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public void a(Object obj) {
            if (obj instanceof Throwable) {
                w.a("Luggage.ShareWithSnapshot", (Throwable) obj, "save screenshot bitmap interrupted", new Object[0]);
            } else {
                w.b("Luggage.ShareWithSnapshot", "save screenshot bitmap interrupted %s", obj);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f123277b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f123278c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f123279d;

        public c(Uri uri, Runnable runnable, String str) {
            this.f123277b = uri;
            this.f123278c = runnable;
            this.f123279d = str;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(Bitmap bitmap) {
            int width;
            Object[] objArr = new Object[3];
            objArr[0] = this.f123277b.toString();
            int i3 = -1;
            if (bitmap == null) {
                width = -1;
            } else {
                width = bitmap.getWidth();
            }
            objArr[1] = Integer.valueOf(width);
            if (bitmap != null) {
                i3 = bitmap.getHeight();
            }
            objArr[2] = Integer.valueOf(i3);
            w.a("Luggage.ShareWithSnapshot", "get screenshot uri %s, w %d h %d", objArr);
            if (bitmap == null) {
                this.f123278c.run();
                return com.tencent.luggage.wxa.uo.b.f142835a;
            }
            try {
                try {
                    com.tencent.luggage.wxa.tn.d.a(bitmap, 100, Bitmap.CompressFormat.JPEG, this.f123279d, true);
                } catch (IOException e16) {
                    this.f123278c.run();
                    com.tencent.luggage.wxa.xo.h.a().a(e16);
                }
                try {
                    bitmap.recycle();
                } catch (Throwable unused) {
                }
                return com.tencent.luggage.wxa.uo.b.f142835a;
            } catch (Throwable th5) {
                try {
                    bitmap.recycle();
                } catch (Throwable unused2) {
                }
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f123281b;

        public d(JSONObject jSONObject) {
            this.f123281b = jSONObject;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(String str) {
            j.this.a(this.f123281b, str);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.i f123283b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f123284c;

        public e(com.tencent.luggage.wxa.xd.i iVar, JSONObject jSONObject) {
            this.f123283b = iVar;
            this.f123284c = jSONObject;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(Void r36) {
            if (com.tencent.luggage.wxa.v3.g.a()) {
                return j.this.a(this.f123283b, this.f123284c);
            }
            return j.this.a(this.f123284c, this.f123283b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements com.tencent.luggage.wxa.uo.b {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(Bitmap bitmap) {
            int width;
            Object[] objArr = new Object[2];
            int i3 = -1;
            if (bitmap == null) {
                width = -1;
            } else {
                width = bitmap.getWidth();
            }
            objArr[0] = Integer.valueOf(width);
            if (bitmap != null) {
                i3 = bitmap.getHeight();
            }
            objArr[1] = Integer.valueOf(i3);
            w.a("Luggage.ShareWithSnapshot", "get screenshot w %d h %d", objArr);
            String b16 = com.tencent.luggage.wxa.c3.c.b(bitmap);
            try {
                bitmap.recycle();
            } catch (Throwable unused) {
            }
            return b16;
        }
    }

    public com.tencent.luggage.wxa.xo.d b(com.tencent.luggage.wxa.xd.i iVar, JSONObject jSONObject) {
        return com.tencent.luggage.wxa.xo.h.c().b(new e(iVar, jSONObject)).b(new d(jSONObject));
    }

    public final String a(com.tencent.luggage.wxa.xd.i iVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("imageUrl");
        final String[] strArr = {optString};
        if (w0.c(optString)) {
            try {
                String a16 = OpenSDKApiContentProvider.a(w0.c() + "-temp.png");
                final File file = new File(a16);
                file.createNewFile();
                Uri uriForFile = FileProvider.getUriForFile(iVar.getContext(), iVar.getContext().getPackageName() + ".openapidata", file);
                iVar.getContext().grantUriPermission("com.tencent.mm", uriForFile, 1);
                Runnable runnable = new Runnable() { // from class: f21.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.a(file, strArr);
                    }
                };
                strArr[0] = uriForFile.toString();
                com.tencent.luggage.wxa.m4.b a17 = a(iVar);
                if (a17 == null) {
                    runnable.run();
                    return null;
                }
                a17.a((Bundle) null);
                a17.s1().c(new c(uriForFile, runnable, a16)).a(new b()).a(new a());
            } catch (IOException e16) {
                w.a("Luggage.ShareWithSnapshot", e16, "", new Object[0]);
            }
        } else if (!optString.startsWith("http://")) {
            optString.startsWith("https://");
        }
        return strArr[0];
    }

    public static /* synthetic */ void a(File file, String[] strArr) {
        try {
            file.delete();
        } catch (Exception unused) {
        }
        strArr[0] = null;
    }

    public final String a(JSONObject jSONObject, com.tencent.luggage.wxa.xd.i iVar) {
        String optString = jSONObject.optString("imageUrl");
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.m4.b a16 = a(iVar);
            if (a16 != null) {
                a16.a((Bundle) null);
                com.tencent.luggage.wxa.xo.h.a((com.tencent.luggage.wxa.xo.e) a(a16));
                return optString;
            }
            w.b("Luggage.ShareWithSnapshot", "curPageView is null, return");
            return optString;
        }
        if (optString.startsWith("http://") || optString.startsWith("https://")) {
            return optString;
        }
        if (optString.startsWith("wxfile://")) {
            return com.tencent.luggage.wxa.c3.c.a(iVar.getFileSystem().getAbsoluteFile(optString));
        }
        return (optString.startsWith("http://") || optString.startsWith("https://")) ? optString : com.tencent.luggage.wxa.c3.c.b(s.a(iVar.getRuntime(), optString));
    }

    public final com.tencent.luggage.wxa.xo.d a(com.tencent.luggage.wxa.m4.b bVar) {
        return bVar.s1().c(new f());
    }

    public final com.tencent.luggage.wxa.m4.b a(com.tencent.luggage.wxa.xd.i iVar) {
        if (iVar instanceof com.tencent.luggage.wxa.m4.b) {
            return (com.tencent.luggage.wxa.m4.b) iVar;
        }
        if (iVar.getRuntime() == null) {
            w.b("Luggage.ShareWithSnapshot", "getPageViewLu runtime is null, return");
            return null;
        }
        v currentPageView = iVar.getRuntime().Y().getCurrentPage().getCurrentPageView();
        if (currentPageView instanceof com.tencent.luggage.wxa.m4.b) {
            return (com.tencent.luggage.wxa.m4.b) currentPageView;
        }
        return null;
    }

    public void a(JSONObject jSONObject, String str) {
        if (w0.c(str)) {
            return;
        }
        try {
            jSONObject.remove("imageUrl");
            jSONObject.put("imageUrl", str);
        } catch (JSONException e16) {
            w.a("Luggage.ShareWithSnapshot", e16, "", new Object[0]);
        }
    }
}
