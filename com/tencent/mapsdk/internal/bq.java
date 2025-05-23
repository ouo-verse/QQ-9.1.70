package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.bn;
import com.tencent.mapsdk.internal.bp;
import com.tencent.mapsdk.internal.gn;
import com.tencent.mapsdk.internal.gp;
import com.tencent.mapsdk.internal.kp;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class bq<C extends bp, M extends bn> implements MapDelegate<C, M, bw> {

    /* renamed from: c, reason: collision with root package name */
    public bw f147931c;

    /* renamed from: d, reason: collision with root package name */
    protected final Context f147932d;
    public C d_;

    /* renamed from: e, reason: collision with root package name */
    protected TencentMapOptions f147933e;
    public M e_;

    /* renamed from: f, reason: collision with root package name */
    public final int f147934f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<ViewGroup> f147935g;

    /* renamed from: h, reason: collision with root package name */
    private kp.c f147936h;

    /* renamed from: i, reason: collision with root package name */
    private final la f147937i;

    public bq(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        int hashCode = hashCode();
        this.f147934f = hashCode;
        this.f147932d = context;
        this.f147935g = new WeakReference<>(viewGroup);
        this.f147933e = tencentMapOptions;
        if (this.f147936h == null) {
            this.f147936h = kp.a();
        }
        kp.b();
        kp.a(this.f147936h);
        la laVar = new la(context, tencentMapOptions, hashCode);
        this.f147937i = laVar;
        LogUtil.a(hashCode, laVar);
        LogUtil.a(new kx(context, tencentMapOptions));
        lc.a(lb.f149152aa, hashCode);
        lc.a(lb.C, hashCode);
        if (tencentMapOptions != null) {
            lc.a(lb.f149152aa, "options", tencentMapOptions, hashCode);
        }
    }

    private M ae() {
        return this.e_;
    }

    private C af() {
        return this.d_;
    }

    private int ag() {
        return this.f147934f;
    }

    private void c(float f16) {
        bw bwVar = this.f147931c;
        if (bwVar != null) {
            bwVar.a(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X() {
        C c16 = this.d_;
        if (c16 != null) {
            bp.b D = c16.D();
            ho.a(c16.f147914a, D.f147925a, D.f147926b, D.f147930f);
            gp gpVar = new gp(c16);
            c16.f147917d = gpVar;
            if (gpVar.f148531a == 0) {
                gpVar.a(new gp.AnonymousClass1(new gp.AnonymousClass2()));
            }
            gpVar.f148531a++;
            long currentTimeMillis = System.currentTimeMillis();
            gp.e.a(gp.c.CREATE).f148566e = Long.valueOf(currentTimeMillis);
            c16.f147918e = new hi(currentTimeMillis);
            gp gpVar2 = c16.f147917d;
            String str = gpVar2.f148533c;
            String str2 = gpVar2.f148534d;
            String m3 = ho.m();
            String str3 = gpVar2.f148535e;
            String h16 = ho.h();
            String d16 = ho.d();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(ho.j());
            c16.f147919f = new go(new gn.b(str, str2, m3, str3, h16, d16, sb5.toString(), ho.k(), ho.n(), ho.c(), ho.g()));
            c16.A();
        }
    }

    public final M a(C c16) {
        return createMap(c16);
    }

    protected abstract C a(Context context, TencentMapOptions tencentMapOptions);

    public final MapViewType aa() {
        return this.d_.f147915b.getMapViewType();
    }

    public final ViewGroup ab() {
        WeakReference<ViewGroup> weakReference = this.f147935g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.core.MapDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract M createMap(C c16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.core.MapDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract bw createMapView(C c16, ViewGroup viewGroup);

    @Override // com.tencent.mapsdk.core.MapDelegate, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public /* bridge */ /* synthetic */ TencentMap getMap() {
        return this.e_;
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    public /* bridge */ /* synthetic */ TencentMapContext getMapContext() {
        return this.d_;
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    public bw getMapRenderView() {
        return this.f147931c;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean isOpaque() {
        bw bwVar = this.f147931c;
        if (bwVar != null) {
            return bwVar.e();
        }
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean isTouchable() {
        M m3 = this.e_;
        if (m3 != null && m3.a()) {
            return true;
        }
        return false;
    }

    public void m(boolean z16) {
        C c16 = this.d_;
        if (c16 != null) {
            c16.f147921h = z16;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onCreated() {
        lc.a(lb.O, this.f147934f);
        this.d_ = a(this.f147932d, this.f147933e);
        X();
        lc.c(lb.O, this.f147934f);
        lc.a(lb.P, this.f147934f);
        bw createMapView = createMapView(this.d_, this.f147935g.get());
        this.f147931c = createMapView;
        View view = createMapView.getView();
        view.setEnabled(true);
        view.setClickable(true);
        lc.c(lb.P, this.f147934f);
        lc.a(lb.N, this.f147934f);
        this.e_ = createMap(this.d_);
        Y();
        this.e_.b(bp.z());
        Z();
        lc.c(lb.N, this.f147934f);
        lc.c(lb.C, this.f147934f);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onDestroy() {
        WeakReference<ViewGroup> weakReference = this.f147935g;
        if (weakReference != null) {
            ViewGroup viewGroup = weakReference.get();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            this.f147935g.clear();
            this.f147935g = null;
        }
        M m3 = this.e_;
        if (m3 != null) {
            m3.n();
        }
        C c16 = this.d_;
        if (c16 != null) {
            gp gpVar = c16.f147917d;
            hi hiVar = c16.f147918e;
            hiVar.f148660b = System.currentTimeMillis() - hiVar.f148659a;
            gpVar.a(hiVar, c16.f147919f);
            Bundle bundle = new Bundle();
            if (bundle.size() > 0) {
                Parcel obtain = Parcel.obtain();
                bundle.writeToParcel(obtain, 0);
                kt.a(kt.b(kt.f149081d, "map-context.cache"), obtain.marshall());
                OaidMonitor.parcelRecycle(obtain);
            }
            c16.B();
            BitmapDescriptorFactory.detachMapContext(c16);
            ho.r();
        }
        kp.c();
        kp.d();
        lc.c(lb.J, this.f147934f);
        lc.c(lb.f149152aa, this.f147934f);
        la laVar = this.f147937i;
        if (laVar != null && !laVar.f149129d) {
            laVar.f149129d = true;
            laVar.f149128c = null;
            laVar.f149130e = null;
            Handler handler = la.f149121f;
            if (handler != null) {
                handler.sendEmptyMessage(-102);
            }
        }
        LogUtil.b(this.f147934f);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onPause() {
        C c16 = this.d_;
        if (c16 != null) {
            c16.w();
        }
        M m3 = this.e_;
        if (m3 != null) {
            m3.k();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onRestart() {
        M m3 = this.e_;
        if (m3 != null) {
            m3.l();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onResume() {
        C c16 = this.d_;
        if (c16 != null) {
            c16.x();
        }
        M m3 = this.e_;
        if (m3 != null) {
            m3.j();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        bw bwVar = this.f147931c;
        if (bwVar != null) {
            bwVar.onSizeChanged(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onStart() {
        M m3 = this.e_;
        if (m3 != null) {
            m3.i();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onStop() {
        M m3 = this.e_;
        if (m3 != null) {
            m3.m();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onSurfaceChanged(Object obj, int i3, int i16) {
        bw bwVar = this.f147931c;
        if (bwVar != null) {
            bwVar.a(obj, i3, i16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void setOnTop(boolean z16) {
        M m3 = this.e_;
        if (m3 != null) {
            m3.a(z16);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void setOpaque(boolean z16) {
        bw bwVar = this.f147931c;
        if (bwVar != null) {
            bwVar.setMapOpaque(z16);
        }
    }

    public final bw a(C c16, ViewGroup viewGroup) {
        return createMapView(c16, viewGroup);
    }

    private static void ac() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onUpdateOptions(TencentMapOptions tencentMapOptions) {
    }
}
