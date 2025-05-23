package com.qzone.preview.photodanmaku.core;

import android.content.Context;
import android.graphics.Canvas;
import com.qzone.preview.photodanmaku.config.PhotoDanmakuConfig;
import com.qzone.preview.photodanmaku.entity.AbsDanmaku;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f49959a;

    /* renamed from: b, reason: collision with root package name */
    protected int f49960b;

    /* renamed from: c, reason: collision with root package name */
    protected final TreeSet<AbsDanmaku> f49961c;

    /* renamed from: d, reason: collision with root package name */
    protected final List<AbsDanmaku> f49962d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    protected final PhotoDanmakuDrawer f49963e;

    /* renamed from: f, reason: collision with root package name */
    protected final PhotoDanmakuConfig f49964f;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, n8.a aVar, n8.c cVar, PhotoDanmakuConfig photoDanmakuConfig, Comparator<AbsDanmaku> comparator) {
        this.f49964f = photoDanmakuConfig;
        this.f49963e = new PhotoDanmakuDrawer(context, aVar, cVar);
        this.f49961c = new TreeSet<>(comparator);
        j();
    }

    public void a(AbsDanmaku absDanmaku) {
        this.f49961c.add(absDanmaku);
    }

    public void b() {
        this.f49962d.clear();
    }

    public abstract void c();

    public abstract void d();

    public PhotoDanmakuDrawer e() {
        return this.f49963e;
    }

    public List<AbsDanmaku> f() {
        return this.f49962d;
    }

    public abstract void g();

    public abstract void i();

    public void j() {
        this.f49959a = this.f49964f.mWindowMarginTop;
    }

    public void k(Canvas canvas) {
        this.f49963e.A(canvas);
    }

    public static a h(Context context, n8.a aVar, n8.c cVar, PhotoDanmakuConfig photoDanmakuConfig, Comparator<AbsDanmaku> comparator, int i3) {
        if (i3 != 1) {
            return null;
        }
        return new c(context, aVar, cVar, photoDanmakuConfig, comparator);
    }
}
