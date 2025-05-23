package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.c;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.aa;
import com.bumptech.glide.load.resource.bitmap.ab;
import com.bumptech.glide.load.resource.bitmap.ad;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.load.resource.bitmap.t;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.bitmap.z;
import com.bumptech.glide.manager.i;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import t.a;
import t.b;
import t.d;
import t.e;
import t.f;
import t.k;
import t.s;
import t.u;
import t.v;
import t.w;
import t.x;
import u.a;
import u.b;
import u.c;
import u.d;
import u.g;
import w.a;
import z.j;

/* compiled from: P */
/* loaded from: classes.dex */
public class b implements ComponentCallbacks2 {

    @GuardedBy("Glide.class")
    private static volatile b H;
    private static volatile boolean I;
    private final i C;
    private final b0.b D;
    private final a F;

    /* renamed from: d, reason: collision with root package name */
    private final h f31451d;

    /* renamed from: e, reason: collision with root package name */
    private final r.d f31452e;

    /* renamed from: f, reason: collision with root package name */
    private final s.h f31453f;

    /* renamed from: h, reason: collision with root package name */
    private final d f31454h;

    /* renamed from: i, reason: collision with root package name */
    private final Registry f31455i;

    /* renamed from: m, reason: collision with root package name */
    private final r.b f31456m;

    @GuardedBy("managers")
    private final List<RequestManager> E = new ArrayList();
    private MemoryCategory G = MemoryCategory.NORMAL;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a {
        @NonNull
        com.bumptech.glide.request.e build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull Context context, @NonNull h hVar, @NonNull s.h hVar2, @NonNull r.d dVar, @NonNull r.b bVar, @NonNull i iVar, @NonNull b0.b bVar2, int i3, @NonNull a aVar, @NonNull Map<Class<?>, g<?, ?>> map, @NonNull List<com.bumptech.glide.request.d<Object>> list, e eVar) {
        com.bumptech.glide.load.f gVar;
        com.bumptech.glide.load.f abVar;
        Registry registry;
        this.f31451d = hVar;
        this.f31452e = dVar;
        this.f31456m = bVar;
        this.f31453f = hVar2;
        this.C = iVar;
        this.D = bVar2;
        this.F = aVar;
        Resources resources = context.getResources();
        Registry registry2 = new Registry();
        this.f31455i = registry2;
        registry2.o(new DefaultImageHeaderParser());
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 27) {
            registry2.o(new t());
        }
        List<ImageHeaderParser> g16 = registry2.g();
        z.a aVar2 = new z.a(context, g16, dVar, bVar);
        com.bumptech.glide.load.f<ParcelFileDescriptor, Bitmap> h16 = VideoDecoder.h(dVar);
        q qVar = new q(registry2.g(), resources.getDisplayMetrics(), dVar, bVar);
        if (eVar.a(c.b.class) && i16 >= 28) {
            abVar = new x();
            gVar = new com.bumptech.glide.load.resource.bitmap.i();
        } else {
            gVar = new com.bumptech.glide.load.resource.bitmap.g(qVar);
            abVar = new ab(qVar, bVar);
        }
        x.e eVar2 = new x.e(context);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar3 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        com.bumptech.glide.load.resource.bitmap.c cVar2 = new com.bumptech.glide.load.resource.bitmap.c(bVar);
        a0.a aVar4 = new a0.a();
        a0.d dVar3 = new a0.d();
        ContentResolver contentResolver = context.getContentResolver();
        registry2.a(ByteBuffer.class, new t.c()).a(InputStream.class, new t.t(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, gVar).e("Bitmap", InputStream.class, Bitmap.class, abVar);
        if (ParcelFileDescriptorRewinder.b()) {
            registry2.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new z(qVar));
        }
        registry2.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, h16).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.c(dVar)).d(Bitmap.class, Bitmap.class, v.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new ad()).b(Bitmap.class, cVar2).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, gVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, abVar)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, h16)).b(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(dVar, cVar2)).e("Gif", InputStream.class, z.c.class, new j(g16, aVar2, bVar)).e("Gif", ByteBuffer.class, z.c.class, aVar2).b(z.c.class, new z.d()).d(GifDecoder.class, GifDecoder.class, v.a.a()).e("Bitmap", GifDecoder.class, Bitmap.class, new z.h(dVar)).c(Uri.class, Drawable.class, eVar2).c(Uri.class, Bitmap.class, new aa(eVar2, dVar)).p(new a.C11448a()).d(File.class, ByteBuffer.class, new d.b()).d(File.class, InputStream.class, new f.e()).c(File.class, File.class, new y.a()).d(File.class, ParcelFileDescriptor.class, new f.b()).d(File.class, File.class, v.a.a()).p(new k.a(bVar));
        if (ParcelFileDescriptorRewinder.b()) {
            registry = registry2;
            registry.p(new ParcelFileDescriptorRewinder.a());
        } else {
            registry = registry2;
        }
        Class cls = Integer.TYPE;
        registry.d(cls, InputStream.class, cVar).d(cls, ParcelFileDescriptor.class, bVar3).d(Integer.class, InputStream.class, cVar).d(Integer.class, ParcelFileDescriptor.class, bVar3).d(Integer.class, Uri.class, dVar2).d(cls, AssetFileDescriptor.class, aVar3).d(Integer.class, AssetFileDescriptor.class, aVar3).d(cls, Uri.class, dVar2).d(String.class, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(String.class, InputStream.class, new u.c()).d(String.class, ParcelFileDescriptor.class, new u.b()).d(String.class, AssetFileDescriptor.class, new u.a()).d(Uri.class, InputStream.class, new a.c(context.getAssets())).d(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).d(Uri.class, InputStream.class, new b.a(context)).d(Uri.class, InputStream.class, new c.a(context));
        if (i16 >= 29) {
            registry.d(Uri.class, InputStream.class, new d.c(context));
            registry.d(Uri.class, ParcelFileDescriptor.class, new d.b(context));
        }
        registry.d(Uri.class, InputStream.class, new w.d(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).d(Uri.class, InputStream.class, new x.a()).d(URL.class, InputStream.class, new g.a()).d(Uri.class, File.class, new k.a(context)).d(t.g.class, InputStream.class, new a.C11315a()).d(byte[].class, ByteBuffer.class, new b.a()).d(byte[].class, InputStream.class, new b.d()).d(Uri.class, Uri.class, v.a.a()).d(Drawable.class, Drawable.class, v.a.a()).c(Drawable.class, Drawable.class, new x.f()).q(Bitmap.class, BitmapDrawable.class, new a0.b(resources)).q(Bitmap.class, byte[].class, aVar4).q(Drawable.class, byte[].class, new a0.c(dVar, aVar4, dVar3)).q(z.c.class, byte[].class, dVar3);
        com.bumptech.glide.load.f<ByteBuffer, Bitmap> d16 = VideoDecoder.d(dVar);
        registry.c(ByteBuffer.class, Bitmap.class, d16);
        registry.c(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, d16));
        this.f31454h = new d(context, bVar, registry, new e0.f(), aVar, map, list, hVar, eVar, i3);
    }

    @GuardedBy("Glide.class")
    private static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!I) {
            I = true;
            m(context, generatedAppGlideModule);
            I = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @NonNull
    public static b c(@NonNull Context context) {
        if (H == null) {
            GeneratedAppGlideModule d16 = d(context.getApplicationContext());
            synchronized (b.class) {
                if (H == null) {
                    a(context, d16);
                }
            }
        }
        return H;
    }

    @Nullable
    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e16) {
            q(e16);
            return null;
        } catch (InstantiationException e17) {
            q(e17);
            return null;
        } catch (NoSuchMethodException e18) {
            q(e18);
            return null;
        } catch (InvocationTargetException e19) {
            q(e19);
            return null;
        }
    }

    @NonNull
    private static i l(@Nullable Context context) {
        h0.j.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    @GuardedBy("Glide.class")
    private static void m(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new c(), generatedAppGlideModule);
    }

    @GuardedBy("Glide.class")
    private static void n(@NonNull Context context, @NonNull c cVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        i.b bVar;
        Context applicationContext = context.getApplicationContext();
        List<c0.b> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new c0.d(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d16 = generatedAppGlideModule.d();
            Iterator<c0.b> it = emptyList.iterator();
            while (it.hasNext()) {
                c0.b next = it.next();
                if (d16.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<c0.b> it5 = emptyList.iterator();
            while (it5.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it5.next().getClass());
            }
        }
        if (generatedAppGlideModule != null) {
            bVar = generatedAppGlideModule.e();
        } else {
            bVar = null;
        }
        cVar.b(bVar);
        Iterator<c0.b> it6 = emptyList.iterator();
        while (it6.hasNext()) {
            it6.next().a(applicationContext, cVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, cVar);
        }
        b a16 = cVar.a(applicationContext);
        for (c0.b bVar2 : emptyList) {
            try {
                bVar2.b(applicationContext, a16, a16.f31455i);
            } catch (AbstractMethodError e16) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + bVar2.getClass().getName(), e16);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, a16, a16.f31455i);
        }
        applicationContext.registerComponentCallbacks(a16);
        H = a16;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static RequestManager t(@NonNull Context context) {
        return l(context).l(context);
    }

    @NonNull
    public static RequestManager u(@NonNull View view) {
        return l(view.getContext()).m(view);
    }

    public void b() {
        h0.k.a();
        this.f31453f.a();
        this.f31452e.a();
        this.f31456m.a();
    }

    @NonNull
    public r.b e() {
        return this.f31456m;
    }

    @NonNull
    public r.d f() {
        return this.f31452e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0.b g() {
        return this.D;
    }

    @NonNull
    public Context h() {
        return this.f31454h.getBaseContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public d i() {
        return this.f31454h;
    }

    @NonNull
    public Registry j() {
        return this.f31455i;
    }

    @NonNull
    public i k() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(RequestManager requestManager) {
        synchronized (this.E) {
            if (!this.E.contains(requestManager)) {
                this.E.add(requestManager);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        r(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p(@NonNull e0.h<?> hVar) {
        synchronized (this.E) {
            Iterator<RequestManager> it = this.E.iterator();
            while (it.hasNext()) {
                if (it.next().w(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i3) {
        h0.k.a();
        synchronized (this.E) {
            Iterator<RequestManager> it = this.E.iterator();
            while (it.hasNext()) {
                it.next().onTrimMemory(i3);
            }
        }
        this.f31453f.trimMemory(i3);
        this.f31452e.trimMemory(i3);
        this.f31456m.trimMemory(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(RequestManager requestManager) {
        synchronized (this.E) {
            if (this.E.contains(requestManager)) {
                this.E.remove(requestManager);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
