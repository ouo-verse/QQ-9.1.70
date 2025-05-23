package com.tencent.mm.modelappbrand.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.core.graphics.BitmapCompat;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.ic.u;
import com.tencent.luggage.wxa.p004if.s;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.a;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.io.IOUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class AppBrandSimpleImageLoader {

    /* renamed from: g, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.so.c f151696g = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: r51.a
        @Override // com.tencent.luggage.wxa.so.c.a
        public final Object a() {
            return AppBrandSimpleImageLoader.e();
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public final Map f151697a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f151698b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f151699c;

    /* renamed from: d, reason: collision with root package name */
    public final h f151700d;

    /* renamed from: e, reason: collision with root package name */
    public final n f151701e;

    /* renamed from: f, reason: collision with root package name */
    public final k f151702f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f151703a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f151704b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f151705c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f151706d;

        public a(String str, m mVar, String str2, p pVar) {
            this.f151703a = str;
            this.f151704b = mVar;
            this.f151705c = str2;
            this.f151706d = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap findCachedInMemory = AppBrandSimpleImageLoader.this.findCachedInMemory(this.f151703a);
            if (findCachedInMemory == null) {
                String f16 = this.f151706d.f();
                AppBrandSimpleImageLoader.this.f151697a.put(this.f151704b, f16);
                AppBrandSimpleImageLoader.this.f151698b.put(f16, this.f151704b);
                this.f151704b.c();
                this.f151706d.i();
                return;
            }
            this.f151704b.a(findCachedInMemory);
            w.a("Luggage.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", this.f151705c, findCachedInMemory);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public final class b implements h.a, Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f151708a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppBrandSimpleImageLoader f151709b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s f151710c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function f151711d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f151712e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Map f151713f;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f151709b.f151700d.e(b.this.f151710c.b());
                b.this.f151709b.f151700d.b(b.this.f151710c.b());
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader$b$b, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C7046b implements com.tencent.luggage.wxa.jq.g {
            public C7046b() {
            }

            @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
            public String getKey() {
                return "AppBrandSimpleImageLoaderDownloadThread";
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                p.a(bVar.f151710c, bVar.f151713f, bVar.f151709b.f151702f);
                b bVar2 = b.this;
                Function function = bVar2.f151711d;
                if (function != null) {
                    try {
                        function.apply(bVar2.f151709b.f151702f.a(b.this.f151710c.b()));
                    } catch (Throwable unused) {
                    }
                }
                b.this.c();
            }
        }

        public b(AppBrandSimpleImageLoader appBrandSimpleImageLoader, s sVar, Function function, String str, Map map) {
            this.f151709b = appBrandSimpleImageLoader;
            this.f151710c = sVar;
            this.f151711d = function;
            this.f151712e = str;
            this.f151713f = map;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h.a
        public void b() {
            InputStream a16;
            if (this.f151708a) {
                return;
            }
            try {
                if (this.f151710c.a()) {
                    a16 = this.f151710c.a((Map) null);
                } else {
                    a16 = this.f151709b.f151702f.a(this.f151710c.b());
                }
                if (a16 != null) {
                    Function function = this.f151711d;
                    if (function != null) {
                        function.apply(a16);
                    } else {
                        IOUtils.closeQuietly(a16);
                    }
                    c();
                    return;
                }
                if (this.f151710c.a()) {
                    Function function2 = this.f151711d;
                    if (function2 != null) {
                        function2.apply(null);
                    }
                    c();
                    return;
                }
                com.tencent.luggage.wxa.zp.h.f146825d.execute(new C7046b());
            } catch (Throwable th5) {
                w.b("Luggage.AppBrandSimpleImageLoader", "loadIntoDiskCache diskCache.openRead failed, url=%s, e=%s", this.f151712e, th5);
                Function function3 = this.f151711d;
                if (function3 != null) {
                    function3.apply(null);
                }
                c();
            }
        }

        public final void c() {
            this.f151709b.f151700d.a(new a());
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f151709b.f151700d.c(this.f151710c.b())) {
                this.f151709b.f151700d.a(this.f151710c.b(), this);
            } else {
                this.f151709b.f151700d.d(this.f151710c.b());
                b();
            }
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h.a
        public void a() {
            this.f151708a = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c extends o {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Drawable f151717f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ImageView imageView, AppBrandSimpleImageLoader appBrandSimpleImageLoader, String str, r rVar, Drawable drawable) {
            super(imageView, appBrandSimpleImageLoader, str, rVar, null);
            this.f151717f = drawable;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void c() {
            if (d() != null && this.f151717f != null) {
                d().setImageDrawable(this.f151717f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f151719a;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                AppBrandSimpleImageLoader.this.b(dVar.f151719a);
                d.this.getClass();
            }
        }

        public d(String str, l lVar) {
            this.f151719a = str;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a() {
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m, com.tencent.luggage.wxa.pb.a
        public String b() {
            return "BytesLoadTarget";
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a(Bitmap bitmap) {
            com.tencent.luggage.wxa.tk.l.a().d(new a());
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class f implements m {
        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a() {
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m, com.tencent.luggage.wxa.pb.a
        public String b() {
            return "DefaultLoadTarget";
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a(Bitmap bitmap) {
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class g implements n {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.y8.b f151725a = new a(a());

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a extends com.tencent.luggage.wxa.y8.d {

            /* renamed from: j, reason: collision with root package name */
            public final Map f151726j;

            public a(int i3) {
                super(i3);
                this.f151726j = new ConcurrentHashMap();
            }

            @Override // com.tencent.luggage.wxa.y8.d, com.tencent.luggage.wxa.y8.b
            public void clear() {
                w.a("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", QCircleLpReportDc05507.KEY_CLEAR);
                try {
                    super.clear();
                } catch (IllegalStateException e16) {
                    w.a("LRUMap", e16, QCircleLpReportDc05507.KEY_CLEAR, new Object[0]);
                }
                this.f151726j.clear();
            }

            @Override // com.tencent.luggage.wxa.y8.d, com.tencent.luggage.wxa.tn.x
            public void a(boolean z16, String str, Reference reference, Reference reference2) {
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(g.this.f151725a.size() / 10);
                objArr[1] = Integer.valueOf(g.this.f151725a.a() / 10);
                objArr[2] = reference == null ? "null-ref" : reference.get();
                objArr[3] = reference2 != null ? reference2.get() : "null-ref";
                w.a("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "entryRemoved, curSize %d KB, maxSize %d KB, oldBmp %s, newBmp %s", objArr);
                super.a(z16, (Object) str, (Object) reference, (Object) reference2);
                Bitmap bitmap = reference == null ? null : (Bitmap) reference.get();
                if (bitmap != (reference2 != null ? (Bitmap) reference2.get() : null)) {
                    g.this.a(bitmap);
                }
                this.f151726j.remove(reference);
            }

            @Override // com.tencent.luggage.wxa.y8.d, com.tencent.luggage.wxa.tn.x
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int b(String str, Reference reference) {
                int i3 = 0;
                if (reference == null) {
                    return 0;
                }
                Integer num = (Integer) this.f151726j.get(reference);
                if (num != null && num.intValue() >= 0) {
                    return num.intValue();
                }
                Bitmap bitmap = (Bitmap) reference.get();
                if (bitmap != null && !bitmap.isRecycled()) {
                    i3 = BitmapCompat.getAllocationByteCount(bitmap);
                }
                this.f151726j.put(reference, Integer.valueOf(i3));
                return i3;
            }
        }

        public static int a() {
            return 31457280;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.n
        public void clear() {
            w.a("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", QCircleLpReportDc05507.KEY_CLEAR);
            synchronized (this.f151725a) {
                this.f151725a.clear();
            }
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.n
        public Bitmap get(String str) {
            if (w0.c(str)) {
                return null;
            }
            synchronized (this.f151725a) {
                Reference reference = (Reference) this.f151725a.get(str);
                if (reference == null) {
                    return null;
                }
                Bitmap bitmap = (Bitmap) reference.get();
                if (bitmap != null && !bitmap.isRecycled()) {
                    return bitmap;
                }
                this.f151725a.remove(str);
                return null;
            }
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.n
        public void remove(String str) {
            synchronized (this.f151725a) {
                this.f151725a.remove(str);
            }
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.n
        public void a(String str, Bitmap bitmap) {
            if (w0.c(str) || bitmap == null) {
                return;
            }
            w.a("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", str, bitmap);
            try {
                synchronized (this.f151725a) {
                    this.f151725a.put(str, new SoftReference(bitmap));
                }
            } catch (IllegalStateException unused) {
            }
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.n
        public void a(Bitmap bitmap) {
            w.a("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", bitmap);
            if (bitmap != null) {
                bitmap.isRecycled();
            }
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.n
        public void a(String str) {
            if (w0.c(str)) {
                return;
            }
            synchronized (this.f151725a) {
                Iterator it = this.f151725a.keySet().iterator();
                while (it.hasNext()) {
                    if (((String) it.next()).contains(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final b0 f151728a;

        /* renamed from: b, reason: collision with root package name */
        public final Map f151729b;

        /* renamed from: c, reason: collision with root package name */
        public final Map f151730c;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public interface a {
            void a();

            void b();
        }

        public /* synthetic */ h(b0 b0Var, a aVar) {
            this(b0Var);
        }

        public void b(String str) {
            if (w0.c(str)) {
                return;
            }
            List list = (List) this.f151729b.remove(str);
            if (w0.a(list)) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((a) it.next()).b();
            }
        }

        public boolean c(String str) {
            if (w0.c(str)) {
                return false;
            }
            return this.f151730c.containsKey(str);
        }

        public void d(String str) {
            if (w0.c(str)) {
                return;
            }
            this.f151730c.put(str, Boolean.TRUE);
        }

        public void e(String str) {
            if (w0.c(str)) {
                return;
            }
            this.f151730c.remove(str);
        }

        public h(b0 b0Var) {
            this.f151729b = new HashMap();
            this.f151730c = new HashMap();
            this.f151728a = b0Var;
        }

        public void a(String str, a aVar) {
            if (w0.c(str) || aVar == null) {
                return;
            }
            List list = (List) this.f151729b.get(str);
            if (list == null) {
                list = new LinkedList();
                this.f151729b.put(str, list);
            }
            list.add(aVar);
        }

        public void b(String str, a aVar) {
            List list;
            if (w0.c(str) || aVar == null || (list = (List) this.f151729b.get(str)) == null) {
                return;
            }
            list.remove(aVar);
        }

        public void a(String str) {
            if (w0.c(str)) {
                return;
            }
            List list = (List) this.f151729b.remove(str);
            if (w0.a(list)) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a();
            }
            list.clear();
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            this.f151728a.a(runnable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface i extends com.tencent.luggage.wxa.pb.a {
        Bitmap a(InputStream inputStream);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface j extends com.tencent.luggage.wxa.pb.a {
        Bitmap b(Bitmap bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface k {
        InputStream a(String str);

        boolean b(String str);

        OutputStream c(String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface l {
        void a(byte[] bArr);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface m extends com.tencent.luggage.wxa.pb.a {
        void a();

        void a(Bitmap bitmap);

        @Override // com.tencent.luggage.wxa.pb.a
        String b();

        void c();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface n {
        void a(Bitmap bitmap);

        void a(String str);

        void a(String str, Bitmap bitmap);

        void clear();

        Bitmap get(String str);

        void remove(String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class o implements m {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f151731a;

        /* renamed from: b, reason: collision with root package name */
        public final AppBrandSimpleImageLoader f151732b;

        /* renamed from: c, reason: collision with root package name */
        public final String f151733c;

        /* renamed from: d, reason: collision with root package name */
        public final String f151734d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f151735e;

        public /* synthetic */ o(ImageView imageView, AppBrandSimpleImageLoader appBrandSimpleImageLoader, String str, r rVar, a aVar) {
            this(imageView, appBrandSimpleImageLoader, str, rVar);
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a(Bitmap bitmap) {
            e();
            ImageView imageView = (ImageView) this.f151731a.get();
            this.f151735e = true;
            if (imageView != null) {
                if (!c0.b()) {
                    w.e("Luggage.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
                }
                imageView.setImageDrawable(new com.tencent.luggage.wxa.pb.c(imageView.getResources(), bitmap));
                return;
            }
            w.b("Luggage.AppBrandSimpleImageLoader", "onBitmapLoaded ImageView is null, onBitmapLoaded");
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m, com.tencent.luggage.wxa.pb.a
        public String b() {
            return this.f151733c;
        }

        public ImageView d() {
            return (ImageView) this.f151731a.get();
        }

        public final void e() {
            ImageView imageView = (ImageView) this.f151731a.get();
            if (imageView != null) {
                this.f151732b.f151699c.remove(Integer.valueOf(imageView.hashCode()));
            }
        }

        public o(ImageView imageView, AppBrandSimpleImageLoader appBrandSimpleImageLoader, String str, r rVar) {
            this.f151735e = false;
            this.f151731a = new WeakReference(imageView);
            this.f151732b = appBrandSimpleImageLoader;
            this.f151733c = "ImageView";
            this.f151734d = str;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a() {
            e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class p implements h.a {

        /* renamed from: a, reason: collision with root package name */
        public final s f151736a;

        /* renamed from: b, reason: collision with root package name */
        public final Map f151737b;

        /* renamed from: c, reason: collision with root package name */
        public final j f151738c;

        /* renamed from: d, reason: collision with root package name */
        public final AppBrandSimpleImageLoader f151739d;

        /* renamed from: e, reason: collision with root package name */
        public final n f151740e;

        /* renamed from: f, reason: collision with root package name */
        public final k f151741f;

        /* renamed from: g, reason: collision with root package name */
        public final i f151742g;

        /* renamed from: h, reason: collision with root package name */
        public final String f151743h;

        /* renamed from: i, reason: collision with root package name */
        public final b0 f151744i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f151745j = true;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Bitmap f151746a;

            public a(Bitmap bitmap) {
                this.f151746a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.b(this.f151746a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.b();
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Bitmap f151749a;

            public c(Bitmap bitmap) {
                this.f151749a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.c(this.f151749a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class d implements com.tencent.luggage.wxa.jq.g {

            /* compiled from: P */
            /* loaded from: classes9.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    p.this.f151745j = false;
                    p.this.c();
                }
            }

            public d() {
            }

            @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
            public String getKey() {
                return "AppBrandSimpleImageLoaderDownloadThread";
            }

            @Override // java.lang.Runnable
            public void run() {
                p.a(p.this.f151736a, p.this.f151737b, p.this.f151741f);
                p.this.f151739d.f151700d.a(new a());
            }
        }

        public p(String str, Map map, j jVar, AppBrandSimpleImageLoader appBrandSimpleImageLoader, n nVar, k kVar, i iVar, String str2, b0 b0Var) {
            this.f151736a = new s(str, null);
            this.f151737b = map;
            this.f151738c = jVar;
            this.f151739d = appBrandSimpleImageLoader;
            this.f151740e = nVar;
            this.f151741f = kVar;
            this.f151742g = iVar;
            this.f151743h = str2;
            this.f151744i = b0Var;
        }

        public final void h() {
            m mVar = (m) this.f151739d.f151698b.remove(f());
            if (mVar != null) {
                mVar.a();
                this.f151739d.f151697a.remove(mVar);
            }
        }

        public void i() {
            this.f151739d.f151700d.a(new b());
        }

        public final void c() {
            try {
                Bitmap g16 = g();
                if (g16 == null || g16.isRecycled()) {
                    return;
                }
                this.f151739d.f151700d.e(d());
                this.f151739d.f151700d.b(d(), this);
                d(g16);
                this.f151739d.f151700d.b(d());
            } catch (com.tencent.mm.modelappbrand.image.a e16) {
                w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", e16);
                this.f151739d.f151700d.e(d());
                this.f151739d.f151700d.a(d());
                d((Bitmap) null);
                if (e16 instanceof a.C7047a) {
                    this.f151739d.f151702f.b(d());
                }
            } catch (IOException e17) {
                w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", e17, " doIOJobImpl, io exp ", new Object[0]);
                this.f151739d.f151700d.e(d());
                this.f151739d.f151700d.b(d(), this);
                this.f151739d.f151700d.b(d());
                if (e17 instanceof FileNotFoundException) {
                    d((Bitmap) null);
                }
            }
        }

        public final String d() {
            return this.f151736a.b();
        }

        public final String e() {
            return AppBrandSimpleImageLoader.b(this.f151736a.toString(), this.f151738c, this.f151742g);
        }

        public final String f() {
            return AppBrandSimpleImageLoader.b(this.f151743h, e());
        }

        public final Bitmap g() {
            InputStream a16;
            Bitmap bitmap = null;
            if (!this.f151736a.a()) {
                if (this.f151739d.d()) {
                    a16 = this.f151741f.a(d());
                    if (a16 == null) {
                        w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", Boolean.valueOf(this.f151745j));
                        if (!this.f151745j) {
                            this.f151739d.f151700d.a(d());
                            this.f151739d.f151700d.e(d());
                            throw new a.b();
                        }
                        com.tencent.luggage.wxa.zp.h.f146825d.execute(new d());
                    }
                } else {
                    w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
                    throw new a.c();
                }
            } else {
                a16 = this.f151736a.a((Map) null);
            }
            if (a16 == null) {
                return null;
            }
            try {
                bitmap = a(a16);
            } catch (Exception e16) {
                w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", e16, " decode ", new Object[0]);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", bitmap);
                throw new a.C7047a();
            }
            w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", bitmap, Integer.valueOf(BitmapCompat.getAllocationByteCount(bitmap) / 1024), this.f151736a);
            return bitmap;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h.a
        public void b() {
            Bitmap bitmap = this.f151740e.get(e());
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.f151739d.f151700d.c(d())) {
                    this.f151739d.f151700d.a(d(), this);
                    w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", d());
                    return;
                } else {
                    this.f151739d.f151700d.d(d());
                    c();
                    return;
                }
            }
            w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", e());
            a(new a(bitmap));
        }

        public final void d(Bitmap bitmap) {
            Object[] objArr = new Object[1];
            boolean z16 = false;
            objArr[0] = Boolean.valueOf((bitmap == null || bitmap.isRecycled()) ? false : true);
            w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread bitmap ok %b", objArr);
            if (this.f151738c != null && bitmap != null && !bitmap.isRecycled()) {
                Bitmap a16 = a(bitmap);
                w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", bitmap, a16);
                if (a16 != bitmap) {
                    this.f151740e.a(bitmap);
                }
                bitmap = a16;
            }
            this.f151740e.a(e(), bitmap);
            Object[] objArr2 = new Object[2];
            objArr2[0] = bitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                z16 = true;
            }
            objArr2[1] = Boolean.valueOf(z16);
            w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b", objArr2);
            a(new c(bitmap));
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h.a
        public void a() {
            m mVar = (m) this.f151739d.f151698b.remove(f());
            if (mVar != null) {
                this.f151739d.f151697a.remove(mVar);
            }
        }

        public final Bitmap a(Bitmap bitmap) {
            return this.f151738c.b(bitmap);
        }

        public final void a(Runnable runnable) {
            b0 b0Var = this.f151744i;
            if (b0Var != null) {
                b0Var.a(runnable);
            } else {
                c0.a(runnable);
            }
        }

        public final Bitmap a(InputStream inputStream) {
            try {
                i iVar = this.f151742g;
                if (iVar != null) {
                    return iVar.a(inputStream);
                }
                return AppBrandSimpleImageLoader.b().a(inputStream);
            } finally {
                w0.a((Closeable) inputStream);
            }
        }

        public final void b(Bitmap bitmap) {
            m mVar = (m) this.f151739d.f151698b.remove(f());
            if (mVar != null) {
                mVar.a(bitmap);
                this.f151739d.f151697a.remove(mVar);
            } else {
                w.b("Luggage.AppBrandSimpleImageLoader.LoadTask", "onBitmapLoaded, target null");
            }
        }

        public static void a(s sVar, Map map, k kVar) {
            try {
                InputStream a16 = sVar.a(map);
                try {
                    if (a16 != null) {
                        OutputStream c16 = kVar.c(sVar.b());
                        try {
                            if (c16 != null) {
                                IOUtils.copy(a16, c16, 16384);
                                c16.flush();
                                w.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "doNetworkDownload, imageURL: %s, downloaded", sVar);
                            } else {
                                w.b("Luggage.AppBrandSimpleImageLoader.LoadTask", "doNetworkDownload URL.openWrite, get NULL output, url=%s", sVar);
                            }
                            if (c16 != null) {
                                c16.close();
                            }
                        } finally {
                        }
                    } else {
                        w.b("Luggage.AppBrandSimpleImageLoader.LoadTask", "doNetworkDownload URL.openRead, get NULL input, url=%s", sVar);
                    }
                    if (a16 != null) {
                        a16.close();
                    }
                } finally {
                }
            } catch (IOException e16) {
                w.b("Luggage.AppBrandSimpleImageLoader.LoadTask", "doNetworkDownload URL.openRead failed, url=%s, e=%s", sVar, e16);
                kVar.b(sVar.b());
            }
        }

        public final void c(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", bitmap);
                b(bitmap);
            } else {
                w.a("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", bitmap);
                h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class q {

        /* renamed from: a, reason: collision with root package name */
        public static final AppBrandSimpleImageLoader f151753a = new AppBrandSimpleImageLoader(null);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface r {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class s {

        /* renamed from: a, reason: collision with root package name */
        public final String f151754a;

        /* renamed from: b, reason: collision with root package name */
        public final String f151755b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b extends BufferedInputStream {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.tk.i f151757a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InputStream inputStream, com.tencent.luggage.wxa.tk.i iVar) {
                super(inputStream);
                this.f151757a = iVar;
            }

            @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    super.close();
                } finally {
                    IOUtils.close((URLConnection) this.f151757a.f141499a);
                }
            }
        }

        public /* synthetic */ s(String str, a aVar) {
            this(str);
        }

        public final String b() {
            return this.f151755b;
        }

        public final void c() {
            ((u) com.tencent.luggage.wxa.eo.g.a(u.class)).a(new a());
        }

        public String toString() {
            return this.f151754a;
        }

        public s(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f151754a = str;
                this.f151755b = AppBrandSimpleImageLoader.c(str);
                return;
            }
            throw new IllegalArgumentException();
        }

        public boolean a() {
            return this.f151754a.startsWith("file://") || this.f151754a.startsWith("wcf://");
        }

        public final InputStream a(Map map) {
            w.d("Luggage.AppBrandSimpleImageLoader", "openRead, imageURL: " + this.f151754a);
            if (a()) {
                try {
                    return x.n(this.f151754a);
                } catch (FileNotFoundException e16) {
                    w.a("Luggage.AppBrandSimpleImageLoader", e16, "load from local file %s", this.f151754a);
                    throw e16;
                }
            }
            if (!((u) com.tencent.luggage.wxa.eo.g.a(u.class)).I()) {
                c();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f151754a).openConnection();
            httpURLConnection.setInstanceFollowRedirects(true);
            a(httpURLConnection, map);
            InputStream a16 = a(httpURLConnection);
            w.d("Luggage.AppBrandSimpleImageLoader", "openRead, imageURL: %s, connected", this.f151754a);
            return a16;
        }

        public static InputStream a(HttpURLConnection httpURLConnection) {
            return new b(httpURLConnection.getInputStream(), new com.tencent.luggage.wxa.tk.i(httpURLConnection));
        }

        public final void a(HttpURLConnection httpURLConnection, Map map) {
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    w.d("Luggage.AppBrandSimpleImageLoader", "setHeaders, header: %s: %s", entry.getKey(), entry.getValue());
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements u.a {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.ic.u.a
            public void onSuccess() {
            }
        }
    }

    public /* synthetic */ AppBrandSimpleImageLoader(a aVar) {
        this();
    }

    public static AppBrandSimpleImageLoader instance() {
        return q.f151753a;
    }

    @MainThread
    public String attach(@NonNull ImageView imageView, String str, int i3, j jVar) {
        if (imageView == null) {
            return null;
        }
        return attach(imageView, str, imageView.getContext().getResources().getDrawable(i3), jVar);
    }

    @MainThread
    public void cancel(ImageView imageView) {
        String str;
        if (imageView == null || (str = (String) this.f151699c.remove(Integer.valueOf(imageView.hashCode()))) == null) {
            return;
        }
        cancel((m) this.f151698b.get(str));
    }

    public void clearCache() {
        this.f151701e.clear();
    }

    public void deleteDiskCacheByUrl(String str) {
        if (w0.c(str)) {
            return;
        }
        String c16 = c(str);
        if (this.f151700d.c(c16)) {
            return;
        }
        this.f151702f.b(c16);
    }

    public void deleteMemoryCacheByUrl(String str) {
        if (w0.c(str)) {
            return;
        }
        this.f151701e.a(str);
    }

    public Bitmap findCachedInMemory(String str) {
        Bitmap bitmap = this.f151701e.get(str);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        return null;
    }

    @WorkerThread
    public Bitmap findCachedLocal(String str) {
        return findCachedLocal(str, null);
    }

    public n getMemoryCache() {
        return this.f151701e;
    }

    public String load(String str) {
        if (w0.c(str)) {
            return null;
        }
        return load(new f(), str, (j) null);
    }

    public String loadIntoDiskCache(String str, @Nullable Map<String, String> map, @Nullable Function<InputStream, Void> function) {
        a aVar = null;
        if (TextUtils.isEmpty(str)) {
            if (function != null) {
                function.apply(null);
            }
            return null;
        }
        s sVar = new s(str, aVar);
        this.f151700d.f151728a.a((Runnable) new b(this, sVar, function, str, map));
        return sVar.b();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e implements k {

        /* renamed from: a, reason: collision with root package name */
        public final String f151722a;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a extends BufferedOutputStream {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f151723a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(OutputStream outputStream, String str) {
                super(outputStream);
                this.f151723a = str;
            }

            @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public synchronized void flush() {
                super.flush();
                x.c(this.f151723a);
            }
        }

        public e() {
            this.f151722a = (String) AppBrandSimpleImageLoader.f151696g.b();
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.k
        public InputStream a(String str) {
            String str2 = this.f151722a + str;
            if (x.d(str2 + ".wlock")) {
                return null;
            }
            try {
                return x.n(str2);
            } catch (IOException e16) {
                w.a("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", str, e16);
                return null;
            }
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.k
        public boolean b(String str) {
            if (!w0.c(str)) {
                if (x.c(this.f151722a + str)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.k
        public OutputStream c(String str) {
            try {
                if (!x.m(this.f151722a) && !new v(this.f151722a).p()) {
                    x.c(this.f151722a);
                    x.m(this.f151722a);
                }
            } catch (Throwable th5) {
                w.b("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", th5);
            }
            String str2 = this.f151722a + str;
            String str3 = str2 + ".wlock";
            x.c(str3);
            x.a(str3, true);
            x.b(str3, new byte[1]);
            try {
                x.c(str2);
                x.a(str2, true);
                return new a(x.o(str2), str3);
            } catch (IOException e16) {
                w.a("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", e16, "openWrite fileName %s, parent exists[%b]", str, Boolean.valueOf(x.d(this.f151722a)));
                return null;
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public AppBrandSimpleImageLoader() {
        this.f151697a = new ConcurrentHashMap();
        this.f151698b = new ConcurrentHashMap();
        this.f151699c = new ConcurrentHashMap();
        this.f151701e = new g();
        a aVar = null;
        this.f151702f = new e(aVar);
        this.f151700d = new h(new b0("AppBrandSimpleImageLoaderDiskIOHandlerThread"), aVar);
    }

    public static /* synthetic */ com.tencent.luggage.wxa.p004if.s b() {
        return c();
    }

    public static com.tencent.luggage.wxa.p004if.s c() {
        return s.b.a();
    }

    public static String e() {
        String a16 = com.tencent.luggage.wxa.tk.c.a();
        if (!a16.endsWith("/")) {
            a16 = a16 + "/";
        }
        String str = a16 + "wxacache/";
        x.m(str);
        return str;
    }

    public String attach(@NonNull ImageView imageView, String str, @Nullable Drawable drawable, @Nullable j jVar) {
        return attach(imageView, str, drawable, jVar, null, null, null);
    }

    public final boolean d() {
        String str = (String) f151696g.b();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        x.m(str);
        return new v(str).b();
    }

    @WorkerThread
    public Bitmap findCachedLocal(String str, i iVar) {
        InputStream inputStream;
        InputStream n3;
        Bitmap a16;
        InputStream inputStream2 = null;
        byte b16 = 0;
        if (w0.c(str)) {
            return null;
        }
        String b17 = b(str, null, iVar);
        Bitmap bitmap = this.f151701e.get(b17);
        if (bitmap != null) {
            return bitmap;
        }
        try {
            if (new s(str, b16 == true ? 1 : 0).a()) {
                try {
                    n3 = x.n(str);
                } catch (FileNotFoundException unused) {
                    w.b("Luggage.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found ");
                    w0.a((Closeable) null);
                    return null;
                }
            } else {
                n3 = this.f151702f.a(c(str));
            }
            if (n3 == null) {
                w0.a((Closeable) n3);
                return null;
            }
            try {
                if (iVar != null) {
                    a16 = iVar.a(n3);
                } else {
                    a16 = c().a(n3);
                }
                if (a16 != null) {
                    this.f151701e.a(b17, a16);
                }
                w0.a((Closeable) n3);
                return a16;
            } catch (Exception e16) {
                inputStream = n3;
                e = e16;
                try {
                    w.a("Luggage.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
                    w0.a((Closeable) inputStream);
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream2 = inputStream;
                    w0.a((Closeable) inputStream2);
                    throw th;
                }
            } catch (Throwable th6) {
                inputStream2 = n3;
                th = th6;
                w0.a((Closeable) inputStream2);
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            inputStream = null;
            w.a("Luggage.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
            w0.a((Closeable) inputStream);
            return null;
        } catch (Throwable th7) {
            th = th7;
            w0.a((Closeable) inputStream2);
            throw th;
        }
    }

    public static String c(String str) {
        if (w0.c(str)) {
            return null;
        }
        return com.tencent.luggage.wxa.y8.c.a(str.getBytes());
    }

    public String attach(@NonNull ImageView imageView, String str, @Nullable Drawable drawable, @Nullable j jVar, @Nullable b0 b0Var) {
        return attach(imageView, str, drawable, jVar, null, null, b0Var);
    }

    public final byte[] b(String str) {
        a aVar = null;
        if (w0.c(str)) {
            return null;
        }
        try {
            InputStream a16 = this.f151702f.a(new s(str, aVar).b());
            if (a16 == null) {
                if (a16 != null) {
                    a16.close();
                }
                return null;
            }
            try {
                byte[] byteArray = IOUtils.toByteArray(a16);
                a16.close();
                return byteArray;
            } finally {
            }
        } catch (IOException unused) {
            w.b("Luggage.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found, url=%s", str);
            return null;
        }
    }

    @MainThread
    public void cancel(m mVar) {
        if (mVar == null) {
            return;
        }
        String str = (String) this.f151697a.remove(mVar);
        if (w0.c(str)) {
            return;
        }
        this.f151698b.remove(str);
    }

    public String load(@NonNull m mVar, String str, j jVar, i iVar) {
        return load(mVar, str, null, jVar, iVar);
    }

    @MainThread
    public String attach(@NonNull ImageView imageView, String str, @Nullable Drawable drawable, @Nullable j jVar, r rVar) {
        return attach(imageView, str, drawable, jVar, null, rVar);
    }

    public String load(@NonNull m mVar, String str, @Nullable Map<String, String> map, j jVar, i iVar) {
        return load(mVar, str, map, jVar, iVar, null);
    }

    @MainThread
    public String attach(@NonNull ImageView imageView, String str, @Nullable Drawable drawable, j jVar, i iVar) {
        return attach(imageView, str, drawable, jVar, iVar, null);
    }

    public String load(@NonNull m mVar, String str, @Nullable Map<String, String> map, j jVar, i iVar, b0 b0Var) {
        if (mVar == null) {
            return null;
        }
        if (w0.c(str)) {
            mVar.a();
            return null;
        }
        try {
            if ("null".equals(Uri.parse(str).getHost())) {
                mVar.a();
                return null;
            }
        } catch (Exception unused) {
        }
        w.a("Luggage.AppBrandSimpleImageLoader", "load before start LoadTask url %s", str);
        p pVar = new p(str, map, jVar, this, this.f151701e, this.f151702f, iVar, a(mVar), b0Var);
        String e16 = pVar.e();
        a aVar = new a(e16, mVar, str, pVar);
        if (c0.b()) {
            aVar.run();
        } else if (b0Var != null) {
            b0Var.a((Runnable) aVar);
        } else {
            c0.a(aVar);
        }
        return e16;
    }

    @MainThread
    public String attach(@NonNull ImageView imageView, String str, @Nullable Drawable drawable, j jVar, i iVar, r rVar) {
        return attach(imageView, str, drawable, jVar, iVar, rVar, null);
    }

    public final String a(m mVar) {
        return mVar.b() + "@" + mVar.hashCode();
    }

    @MainThread
    public String attach(@NonNull ImageView imageView, String str, @Nullable Drawable drawable, j jVar, i iVar, r rVar, @Nullable b0 b0Var) {
        if (imageView == null) {
            return null;
        }
        cancel(imageView);
        if (w0.c(str)) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            return null;
        }
        c cVar = new c(imageView, this, str, rVar, drawable);
        String load = load(cVar, str, null, jVar, iVar, b0Var);
        if (!cVar.f151735e) {
            this.f151699c.put(Integer.valueOf(imageView.hashCode()), b(a(cVar), load));
        }
        return load;
    }

    public static String b(String str, String str2) {
        return str + str2;
    }

    public static String b(String str, j jVar, i iVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        if (jVar != null) {
            sb5.append("|transformation:");
            sb5.append(jVar.b());
        }
        if (iVar != null) {
            sb5.append("|decoder:");
            sb5.append(iVar.b());
        }
        return sb5.toString();
    }

    @MainThread
    public String load(@NonNull m mVar, String str, j jVar) {
        return load(mVar, str, jVar, null);
    }

    public void load(@NonNull String str, l lVar) {
        load(str, (Map<String, String>) null, lVar);
    }

    public void load(@NonNull String str, @Nullable Map<String, String> map, l lVar) {
        byte[] b16 = b(str);
        if (b16 == null || b16.length == 0) {
            load(new d(str, lVar), str, map, null, null);
        } else if (lVar != null) {
            lVar.a(b16);
        }
    }
}
