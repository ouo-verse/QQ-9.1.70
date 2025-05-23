package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.rp;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rn implements rp.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f150103a = "rastermap/handdraw";

    /* renamed from: c, reason: collision with root package name */
    private static final int f150104c = 4;

    /* renamed from: d, reason: collision with root package name */
    private static final int f150105d = 20;

    /* renamed from: f, reason: collision with root package name */
    private tr f150108f;

    /* renamed from: g, reason: collision with root package name */
    private TileOverlayOptions f150109g;

    /* renamed from: e, reason: collision with root package name */
    private final Object f150107e = new Object();

    /* renamed from: b, reason: collision with root package name */
    public TileOverlay f150106b = null;

    public rn(tr trVar) {
        this.f150108f = trVar;
        if (trVar != null) {
            rm.a(trVar.H());
            rp rpVar = new rp(this.f150108f.H(), this);
            new rp.b(rpVar, (byte) 0).execute(rpVar.f150114a);
        }
    }

    private void d() {
        TileOverlayOptions tileOverlayOptions = this.f150109g;
        if (tileOverlayOptions != null) {
            ro roVar = (ro) tileOverlayOptions.getTileProvider();
            ro.f150110a = rm.a();
            TileOverlayOptions tileOverlayOptions2 = roVar.f150112b;
            if (tileOverlayOptions2 != null) {
                tileOverlayOptions2.versionInfo(ro.a());
            }
        }
        synchronized (this.f150107e) {
            TileOverlay tileOverlay = this.f150106b;
            if (tileOverlay != null) {
                tileOverlay.clearTileCache();
                this.f150106b.reload();
            }
        }
    }

    private boolean e() {
        if (this.f150106b != null) {
            return true;
        }
        return false;
    }

    private void f() {
        synchronized (this.f150107e) {
            TileOverlay tileOverlay = this.f150106b;
            if (tileOverlay == null) {
                return;
            }
            for (Field field : tileOverlay.getClass().getDeclaredFields()) {
                if (field.getType() == qz.class) {
                    try {
                        field.setAccessible(true);
                        ((qz) field.get(this.f150106b)).a(4, 20);
                        field.setAccessible(false);
                        return;
                    } catch (IllegalAccessException e16) {
                        LogUtil.c("SketchOverlayManager set data level with reflect", e16);
                        return;
                    }
                }
            }
        }
    }

    public final void a() {
        tr trVar;
        M m3;
        if (this.f150106b == null && (trVar = this.f150108f) != null && (m3 = trVar.e_) != 0) {
            VectorMap vectorMap = (VectorMap) m3;
            if (this.f150109g == null) {
                TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
                this.f150109g = tileOverlayOptions;
                this.f150109g.tileProvider(new ro(tileOverlayOptions)).diskCacheDir(f150103a).reuseTile(true).zIndex(2);
            }
            vectorMap.b(19);
            this.f150106b = vectorMap.addTileOverlay(this.f150109g);
            synchronized (this.f150107e) {
                TileOverlay tileOverlay = this.f150106b;
                if (tileOverlay == null) {
                    return;
                }
                for (Field field : tileOverlay.getClass().getDeclaredFields()) {
                    if (field.getType() == qz.class) {
                        try {
                            field.setAccessible(true);
                            ((qz) field.get(this.f150106b)).a(4, 20);
                            field.setAccessible(false);
                            return;
                        } catch (IllegalAccessException e16) {
                            LogUtil.c("SketchOverlayManager set data level with reflect", e16);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void b() {
        synchronized (this.f150107e) {
            TileOverlay tileOverlay = this.f150106b;
            if (tileOverlay == null) {
                return;
            }
            tileOverlay.remove();
            this.f150106b = null;
        }
    }

    @Override // com.tencent.mapsdk.internal.rp.a
    public final void c() {
        TileOverlayOptions tileOverlayOptions = this.f150109g;
        if (tileOverlayOptions != null) {
            ro roVar = (ro) tileOverlayOptions.getTileProvider();
            ro.f150110a = rm.a();
            TileOverlayOptions tileOverlayOptions2 = roVar.f150112b;
            if (tileOverlayOptions2 != null) {
                tileOverlayOptions2.versionInfo(ro.a());
            }
        }
        synchronized (this.f150107e) {
            TileOverlay tileOverlay = this.f150106b;
            if (tileOverlay != null) {
                tileOverlay.clearTileCache();
                this.f150106b.reload();
            }
        }
    }
}
