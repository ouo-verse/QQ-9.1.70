package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class ImageLoader {

    /* renamed from: a, reason: collision with root package name */
    private final RequestQueue f31363a;

    /* renamed from: c, reason: collision with root package name */
    private final d f31365c;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f31369g;

    /* renamed from: b, reason: collision with root package name */
    private int f31364b = 100;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, c> f31366d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, c> f31367e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final Handler f31368f = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements h.b<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f31370a;

        a(String str) {
            this.f31370a = str;
        }

        @Override // com.android.volley.h.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(Bitmap bitmap) {
            ImageLoader.this.i(this.f31370a, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b implements h.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f31372a;

        b(String str) {
            this.f31372a = str;
        }

        @Override // com.android.volley.h.a
        public void onErrorResponse(VolleyError volleyError) {
            ImageLoader.this.h(this.f31372a, volleyError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final Request<?> f31374a;

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f31375b;

        /* renamed from: c, reason: collision with root package name */
        private VolleyError f31376c;

        /* renamed from: d, reason: collision with root package name */
        private final List<e> f31377d;

        public c(Request<?> request, e eVar) {
            ArrayList arrayList = new ArrayList();
            this.f31377d = arrayList;
            this.f31374a = request;
            arrayList.add(eVar);
        }

        public void d(e eVar) {
            this.f31377d.add(eVar);
        }

        public VolleyError e() {
            return this.f31376c;
        }

        public boolean f(e eVar) {
            this.f31377d.remove(eVar);
            if (this.f31377d.size() == 0) {
                this.f31374a.cancel();
                return true;
            }
            return false;
        }

        public void g(VolleyError volleyError) {
            this.f31376c = volleyError;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface d {
        @Nullable
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        private Bitmap f31378a;

        /* renamed from: b, reason: collision with root package name */
        private final f f31379b;

        /* renamed from: c, reason: collision with root package name */
        private final String f31380c;

        /* renamed from: d, reason: collision with root package name */
        private final String f31381d;

        public e(Bitmap bitmap, String str, String str2, f fVar) {
            this.f31378a = bitmap;
            this.f31381d = str;
            this.f31380c = str2;
            this.f31379b = fVar;
        }

        @MainThread
        public void c() {
            l.a();
            if (this.f31379b == null) {
                return;
            }
            c cVar = (c) ImageLoader.this.f31366d.get(this.f31380c);
            if (cVar != null) {
                if (cVar.f(this)) {
                    ImageLoader.this.f31366d.remove(this.f31380c);
                    return;
                }
                return;
            }
            c cVar2 = (c) ImageLoader.this.f31367e.get(this.f31380c);
            if (cVar2 != null) {
                cVar2.f(this);
                if (cVar2.f31377d.size() == 0) {
                    ImageLoader.this.f31367e.remove(this.f31380c);
                }
            }
        }

        public Bitmap d() {
            return this.f31378a;
        }

        public String e() {
            return this.f31381d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface f extends h.a {
        void a(e eVar, boolean z16);
    }

    public ImageLoader(RequestQueue requestQueue, d dVar) {
        this.f31363a = requestQueue;
        this.f31365c = dVar;
    }

    private void d(String str, c cVar) {
        this.f31367e.put(str, cVar);
        if (this.f31369g == null) {
            Runnable runnable = new Runnable() { // from class: com.android.volley.toolbox.ImageLoader.4
                @Override // java.lang.Runnable
                public void run() {
                    for (c cVar2 : ImageLoader.this.f31367e.values()) {
                        for (e eVar : cVar2.f31377d) {
                            if (eVar.f31379b != null) {
                                if (cVar2.e() == null) {
                                    eVar.f31378a = cVar2.f31375b;
                                    eVar.f31379b.a(eVar, false);
                                } else {
                                    eVar.f31379b.onErrorResponse(cVar2.e());
                                }
                            }
                        }
                    }
                    ImageLoader.this.f31367e.clear();
                    ImageLoader.this.f31369g = null;
                }
            };
            this.f31369g = runnable;
            this.f31368f.postDelayed(runnable, this.f31364b);
        }
    }

    private static String f(String str, int i3, int i16, ImageView.ScaleType scaleType) {
        StringBuilder sb5 = new StringBuilder(str.length() + 12);
        sb5.append("#W");
        sb5.append(i3);
        sb5.append("#H");
        sb5.append(i16);
        sb5.append("#S");
        sb5.append(scaleType.ordinal());
        sb5.append(str);
        return sb5.toString();
    }

    @MainThread
    public e e(String str, f fVar, int i3, int i16, ImageView.ScaleType scaleType) {
        l.a();
        String f16 = f(str, i3, i16, scaleType);
        Bitmap bitmap = this.f31365c.getBitmap(f16);
        if (bitmap != null) {
            e eVar = new e(bitmap, str, null, null);
            fVar.a(eVar, true);
            return eVar;
        }
        e eVar2 = new e(null, str, f16, fVar);
        fVar.a(eVar2, true);
        c cVar = this.f31366d.get(f16);
        if (cVar == null) {
            cVar = this.f31367e.get(f16);
        }
        if (cVar != null) {
            cVar.d(eVar2);
            return eVar2;
        }
        Request<Bitmap> g16 = g(str, i3, i16, scaleType, f16);
        this.f31363a.a(g16);
        this.f31366d.put(f16, new c(g16, eVar2));
        return eVar2;
    }

    protected Request<Bitmap> g(String str, int i3, int i16, ImageView.ScaleType scaleType, String str2) {
        return new i(str, new a(str2), i3, i16, scaleType, Bitmap.Config.RGB_565, new b(str2));
    }

    protected void h(String str, VolleyError volleyError) {
        c remove = this.f31366d.remove(str);
        if (remove != null) {
            remove.g(volleyError);
            d(str, remove);
        }
    }

    protected void i(String str, Bitmap bitmap) {
        this.f31365c.putBitmap(str, bitmap);
        c remove = this.f31366d.remove(str);
        if (remove != null) {
            remove.f31375b = bitmap;
            d(str, remove);
        }
    }
}
