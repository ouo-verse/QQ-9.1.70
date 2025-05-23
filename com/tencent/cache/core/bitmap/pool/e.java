package com.tencent.cache.core.bitmap.pool;

import android.graphics.Bitmap;
import com.tencent.cache.core.bitmap.base.lrucache.a;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f98689a;

    /* renamed from: b, reason: collision with root package name */
    public int f98690b;

    /* renamed from: c, reason: collision with root package name */
    public int f98691c;

    /* renamed from: d, reason: collision with root package name */
    public int f98692d;

    /* renamed from: e, reason: collision with root package name */
    public int f98693e;

    /* renamed from: f, reason: collision with root package name */
    public int f98694f;

    /* renamed from: g, reason: collision with root package name */
    public final f f98695g;

    /* renamed from: h, reason: collision with root package name */
    public Set<? extends Bitmap.Config> f98696h;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f98695g = new f();
            Set<Bitmap> set = g.f98700a;
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        com.tencent.cache.core.util.b.f98833f.j("LruBitmapPool", 1, "clearMemory");
        int i3 = this.f98690b;
        c(0L);
        return i3;
    }

    @NotNull
    public Bitmap b(int i3, int i16, @NotNull Bitmap.Config config) {
        a.C1002a c1002a;
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this) {
            f fVar = this.f98695g;
            fVar.getClass();
            Intrinsics.checkNotNullParameter(config, "config");
            int a16 = com.tencent.cache.api.util.c.f98640a.a(i3, i16, config);
            c key = fVar.f98697a.a(a16, config);
            Bitmap.Config[] b16 = b.f98684e.b(config);
            int length = b16.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length) {
                    break;
                }
                Bitmap.Config config2 = b16[i17];
                Integer ceilingKey = fVar.c(config2).ceilingKey(Integer.valueOf(a16));
                if (ceilingKey != null && ceilingKey.intValue() <= a16 * 8) {
                    if (ceilingKey.intValue() != a16 || config2 != config) {
                        d dVar = fVar.f98697a;
                        dVar.getClass();
                        Intrinsics.checkNotNullParameter(key, "key");
                        if (dVar.f98688a.size() < 20) {
                            dVar.f98688a.offer(key);
                        }
                        key = fVar.f98697a.a(ceilingKey.intValue(), config2);
                    }
                } else {
                    i17++;
                }
            }
            com.tencent.cache.core.bitmap.base.lrucache.a<c, Bitmap> aVar = fVar.f98698b;
            a.C1002a<c, Bitmap> c1002a2 = aVar.f98642b.get(key);
            if (c1002a2 == null) {
                a.C1002a<c, Bitmap> c1002a3 = new a.C1002a<>(key);
                aVar.f98642b.put(key, c1002a3);
                c1002a = c1002a3;
            } else {
                key.a();
                c1002a = c1002a2;
            }
            a.C1002a<K, V> c1002a4 = c1002a.f98646d;
            c1002a4.f98645c = c1002a.f98645c;
            c1002a.f98645c.f98646d = c1002a4;
            a.C1002a c1002a5 = aVar.f98641a;
            c1002a.f98646d = c1002a5;
            a.C1002a<K, V> c1002a6 = c1002a5.f98645c;
            c1002a.f98645c = c1002a6;
            c1002a6.f98646d = c1002a;
            c1002a.f98646d.f98645c = c1002a;
            bitmap = (Bitmap) c1002a.a();
            if (bitmap != null) {
                int i18 = key.f98686b;
                Intrinsics.checkNotNullExpressionValue(bitmap, "this");
                fVar.d(i18, bitmap);
                bitmap.reconfigure(i3, i16, config);
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Missing bitmap=");
                f fVar2 = this.f98695g;
                fVar2.getClass();
                Intrinsics.checkNotNullParameter(config, "config");
                sb5.append(fVar2.b(com.tencent.cache.api.util.c.f98640a.a(i3, i16, config), config));
                bVar.d("LruBitmapPool", 3, sb5.toString());
                this.f98692d++;
            } else {
                this.f98691c++;
                this.f98690b -= this.f98695g.a(bitmap);
                Set<Bitmap> set = g.f98700a;
                if (set.contains(bitmap)) {
                    set.remove(bitmap);
                    bitmap.setHasAlpha(true);
                    bitmap.setPremultiplied(true);
                } else {
                    throw new IllegalStateException("Cannot remove bitmap not in tracker".toString());
                }
            }
            com.tencent.cache.core.util.b bVar2 = com.tencent.cache.core.util.b.f98833f;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Get bitmap=");
            f fVar3 = this.f98695g;
            fVar3.getClass();
            Intrinsics.checkNotNullParameter(config, "config");
            sb6.append(fVar3.b(com.tencent.cache.api.util.c.f98640a.a(i3, i16, config), config));
            bVar2.d("LruBitmapPool", 3, sb6.toString());
            f();
        }
        if (bitmap != null) {
            bitmap.eraseColor(0);
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public final synchronized void c(long j3) {
        Bitmap bitmap;
        Object obj;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
            return;
        }
        while (this.f98690b > j3) {
            f fVar = this.f98695g;
            com.tencent.cache.core.bitmap.base.lrucache.a<c, Bitmap> aVar = fVar.f98698b;
            a.C1002a c1002a = aVar.f98641a.f98646d;
            while (true) {
                bitmap = null;
                if (!c1002a.equals(aVar.f98641a)) {
                    obj = c1002a.a();
                    if (obj != null) {
                        break;
                    }
                    a.C1002a<K, V> c1002a2 = c1002a.f98646d;
                    c1002a2.f98645c = c1002a.f98645c;
                    c1002a.f98645c.f98646d = c1002a2;
                    aVar.f98642b.remove(c1002a.f98643a);
                    ((com.tencent.cache.core.bitmap.base.lrucache.c) c1002a.f98643a).a();
                    c1002a = c1002a.f98646d;
                } else {
                    obj = null;
                    break;
                }
            }
            Bitmap bitmap2 = (Bitmap) obj;
            if (bitmap2 != null) {
                com.tencent.cache.api.util.c cVar = com.tencent.cache.api.util.c.f98640a;
                Intrinsics.checkNotNullExpressionValue(bitmap2, "this");
                fVar.d(cVar.b(bitmap2), bitmap2);
                bitmap = bitmap2;
            }
            if (bitmap == null) {
                com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
                if (com.tencent.cache.core.util.b.f98828a > 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    bVar.j("LruBitmapPool", 2, "Size mismatch, resetting");
                    e();
                }
                this.f98690b = 0;
                return;
            }
            Set<Bitmap> set = g.f98700a;
            if (set.contains(bitmap)) {
                set.remove(bitmap);
                this.f98690b -= this.f98695g.a(bitmap);
                this.f98694f++;
                com.tencent.cache.core.util.b bVar2 = com.tencent.cache.core.util.b.f98833f;
                StringBuilder a16 = com.tencent.cache.api.collection.c.a("Evicting bitmap=");
                a16.append(this.f98695g.e(bitmap));
                bVar2.d("LruBitmapPool", 3, a16.toString());
                f();
                bitmap.recycle();
            } else {
                throw new IllegalStateException("Cannot remove bitmap not in tracker".toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void d(@NotNull Bitmap bitmap) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
            return;
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.isRecycled()) {
            com.tencent.cache.core.util.b.f98833f.j("LruBitmapPool", 2, "Cannot pool recycled bitmap");
            return;
        }
        int a16 = this.f98695g.a(bitmap);
        if (bitmap.isMutable() && a16 <= this.f98689a) {
            Set<? extends Bitmap.Config> set = this.f98696h;
            if (set == null) {
                Intrinsics.throwUninitializedPropertyAccessException("allowedConfigs");
            }
            if (set.contains(bitmap.getConfig())) {
                f fVar = this.f98695g;
                fVar.getClass();
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                if (bitmap.getConfig() != null) {
                    int b16 = com.tencent.cache.api.util.c.f98640a.b(bitmap);
                    d dVar = fVar.f98697a;
                    Bitmap.Config config = bitmap.getConfig();
                    Intrinsics.checkNotNullExpressionValue(config, "bitmap.config");
                    c a17 = dVar.a(b16, config);
                    com.tencent.cache.core.bitmap.base.lrucache.a<c, Bitmap> aVar = fVar.f98698b;
                    a.C1002a c1002a = aVar.f98642b.get(a17);
                    if (c1002a == null) {
                        c1002a = new a.C1002a(a17);
                        a.C1002a<K, V> c1002a2 = c1002a.f98646d;
                        c1002a2.f98645c = c1002a.f98645c;
                        c1002a.f98645c.f98646d = c1002a2;
                        a.C1002a c1002a3 = aVar.f98641a;
                        c1002a.f98646d = c1002a3.f98646d;
                        c1002a.f98645c = c1002a3;
                        c1002a3.f98646d = c1002a;
                        c1002a.f98646d.f98645c = c1002a;
                        aVar.f98642b.put(a17, c1002a);
                    } else {
                        a17.a();
                    }
                    if (c1002a.f98644b == null) {
                        c1002a.f98644b = new ArrayList();
                    }
                    c1002a.f98644b.add(bitmap);
                    Bitmap.Config config2 = bitmap.getConfig();
                    Intrinsics.checkNotNullExpressionValue(config2, "bitmap.config");
                    NavigableMap<Integer, Integer> c16 = fVar.c(config2);
                    Integer valueOf = Integer.valueOf(a17.f98686b);
                    Integer num = c16.get(Integer.valueOf(a17.f98686b));
                    if (num != null) {
                        i3 = num.intValue() + 1;
                    } else {
                        i3 = 1;
                    }
                    c16.put(valueOf, Integer.valueOf(i3));
                }
                Set<Bitmap> set2 = g.f98700a;
                if (!set2.contains(bitmap)) {
                    set2.add(bitmap);
                    this.f98693e++;
                    this.f98690b += a16;
                    com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
                    StringBuilder a18 = com.tencent.cache.api.collection.c.a("Put bitmap in pool=");
                    a18.append(this.f98695g.e(bitmap));
                    bVar.d("LruBitmapPool", 3, a18.toString());
                    f();
                    c(this.f98689a);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Can't add already added bitmap: ");
                sb5.append(bitmap);
                sb5.append(" [");
                Intrinsics.checkNotNull(bitmap);
                sb5.append(bitmap.getWidth());
                sb5.append(HippyTKDListViewAdapter.X);
                sb5.append(bitmap.getHeight());
                sb5.append("]");
                throw new IllegalStateException(sb5.toString().toString());
            }
        }
        com.tencent.cache.core.util.b bVar2 = com.tencent.cache.core.util.b.f98833f;
        Object[] objArr = new Object[1];
        StringBuilder a19 = com.tencent.cache.api.collection.c.a("Reject bitmap from pool, bitmap: ");
        a19.append(this.f98695g.e(bitmap));
        a19.append(", is mutable: ");
        a19.append(bitmap.isMutable());
        a19.append(", is allowed config: ");
        Set<? extends Bitmap.Config> set3 = this.f98696h;
        if (set3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allowedConfigs");
        }
        a19.append(set3.contains(bitmap.getConfig()));
        objArr[0] = a19.toString();
        bVar2.d("LruBitmapPool", 1, objArr);
        bitmap.recycle();
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
        StringBuilder a16 = com.tencent.cache.api.collection.c.a("Hits=");
        a16.append(this.f98691c);
        a16.append(", misses=");
        a16.append(this.f98692d);
        a16.append(", puts=");
        a16.append(this.f98693e);
        a16.append(", evictions=");
        a16.append(this.f98694f);
        a16.append(", ");
        a16.append("currentSize=");
        a16.append(this.f98690b);
        a16.append(", maxSize=");
        a16.append(this.f98689a);
        a16.append("\nStrategy=");
        a16.append(this.f98695g);
        bVar.d("LruBitmapPool", 3, a16.toString());
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (com.tencent.cache.core.util.b.f98833f.f()) {
            e();
        }
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f98690b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(int i3, @NotNull Set<? extends Bitmap.Config> allowedConfigs) {
        this();
        Intrinsics.checkNotNullParameter(allowedConfigs, "allowedConfigs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) allowedConfigs);
        } else {
            this.f98689a = i3;
            this.f98696h = allowedConfigs;
        }
    }
}
