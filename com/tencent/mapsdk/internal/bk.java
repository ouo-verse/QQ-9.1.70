package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.kq;
import com.tencent.mapsdk.internal.qa;
import com.tencent.mapsdk.internal.sj;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class bk implements bd, qa.a, sj.c {

    /* renamed from: a, reason: collision with root package name */
    public final bf f147877a;

    /* renamed from: b, reason: collision with root package name */
    kq.a f147878b;

    /* renamed from: c, reason: collision with root package name */
    public final bj f147879c;

    /* renamed from: d, reason: collision with root package name */
    public fc f147880d;

    /* renamed from: f, reason: collision with root package name */
    int f147882f;

    /* renamed from: i, reason: collision with root package name */
    private Marker f147885i;

    /* renamed from: j, reason: collision with root package name */
    private Marker f147886j;

    /* renamed from: k, reason: collision with root package name */
    private Marker f147887k;

    /* renamed from: g, reason: collision with root package name */
    private Marker f147883g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f147884h = false;

    /* renamed from: e, reason: collision with root package name */
    public final Map<Class<? extends ni>, nh<?>> f147881e = new ConcurrentHashMap();

    public bk(bj bjVar, bf bfVar) {
        this.f147882f = -1;
        this.f147877a = bfVar;
        this.f147879c = bjVar;
        this.f147882f = ((ne) bfVar).N;
    }

    private void d(fb fbVar) {
        a(fbVar);
    }

    private void e(fb fbVar) {
        a(fbVar);
    }

    private void f(fb fbVar) {
        a(fbVar);
    }

    private void c(fb fbVar) {
        a(fbVar);
    }

    private bj d() {
        return this.f147879c;
    }

    private void e() {
        Collection<nh<?>> values = this.f147881e.values();
        if (values.isEmpty()) {
            return;
        }
        Iterator<nh<?>> it = values.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    private boolean f() {
        nh<?> nhVar = this.f147881e.get(nr.class);
        if (nhVar != null) {
            return nhVar.f();
        }
        return false;
    }

    public final void b(fb fbVar) {
        bg bgVar = this.f147879c.f147871j;
        if (fbVar != null) {
            synchronized (bgVar.f147792a) {
                bgVar.f147792a.remove(fbVar);
                bgVar.f147793b.add(fbVar);
            }
        }
    }

    public final void a(fb fbVar) {
        bj bjVar = this.f147879c;
        bg bgVar = bjVar.f147871j;
        synchronized (bgVar.f147792a) {
            if (!bgVar.f147792a.contains(fbVar)) {
                bgVar.f147792a.add(fbVar);
            }
        }
        if (fbVar instanceof ex) {
            bjVar.a((ex) fbVar);
        }
    }

    @Override // com.tencent.mapsdk.internal.sj.c
    public final void c() {
        Marker marker = this.f147886j;
        if (marker != null) {
            marker.setVisible(true);
        }
        Marker marker2 = this.f147885i;
        if (marker2 != null) {
            marker2.setVisible(true);
        }
    }

    private boolean b(float f16, float f17) {
        TappedElement a16 = this.f147877a.g().a(f16, f17);
        return a16 != null && a16.type == 6;
    }

    public final void b() {
        Collection<nh<?>> values = this.f147881e.values();
        if (!values.isEmpty()) {
            Iterator<nh<?>> it = values.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
        this.f147884h = false;
        this.f147883g = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <O extends ni, L extends ng<O>> L a(O o16) {
        bf bfVar = this.f147877a;
        if (o16 == null || bfVar == null) {
            return null;
        }
        nh<?> nhVar = this.f147881e.get(o16.getClass());
        if (nhVar == null) {
            if (o16.getClass() == oe.class) {
                nhVar = new od(bfVar.g());
            } else if (o16.getClass() == np.class) {
                nhVar = new no(bfVar.g());
            } else if (o16.getClass() == nl.class) {
                nhVar = new nm(bfVar.g());
            } else if (o16.getClass() == nv.class) {
                nhVar = new nu(bfVar.g());
            } else if (o16.getClass() == ny.class) {
                nhVar = new nx(bfVar.g());
            } else if (o16.getClass() == ob.class) {
                nhVar = new nz(bfVar.g());
            } else if (o16.getClass() == oh.class) {
                nhVar = new og(bfVar.g());
            } else if (o16.getClass() == ok.class) {
                nhVar = new oj(bfVar.g());
            } else if (o16.getClass() == nr.class) {
                nhVar = new nq(bfVar.g());
            }
            nh<?> nhVar2 = (nh) this.f147881e.put(o16.getClass(), nhVar);
            if (nhVar2 != null) {
                this.f147881e.put(o16.getClass(), nhVar2);
                nhVar = nhVar2;
            }
        }
        return (L) nhVar.b((nh<?>) o16);
    }

    @Override // com.tencent.mapsdk.internal.sj.c
    public final void b(View view, Rect rect, boolean z16) {
        Bitmap a16;
        if (view == null || (a16 = hn.a(view)) == null) {
            return;
        }
        if (this.f147886j == null) {
            MarkerOptions visible = new MarkerOptions().anchor(0.0f, 0.0f).visible(false);
            visible.tag(qa.f149734c);
            visible.fastLoad(true);
            Marker a17 = this.f147879c.a(visible);
            this.f147886j = a17;
            a17.setClickable(false);
        }
        this.f147886j.setFixingPoint(rect.left, rect.top);
        this.f147886j.setIcon(BitmapDescriptorFactory.fromBitmap(this.f147877a, a16));
        this.f147886j.setVisible(z16);
        ku.a(a16);
    }

    private <O extends ni, L extends ng<O>> void a(int i3, O o16) {
        ng<?> a16;
        nh<?> nhVar = this.f147881e.get(o16.getClass());
        if (nhVar == null || (a16 = nhVar.a(i3)) == null) {
            return;
        }
        a16.a((ng<?>) o16);
        nhVar.a(a16);
    }

    public final <O extends ni, L extends ng<O>> L a(Class<L> cls, int i3) {
        L l3;
        nh<?> nhVar = this.f147881e.get(((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0]);
        if (nhVar == null || (l3 = (L) nhVar.a(i3)) == null) {
            return null;
        }
        return l3;
    }

    private <O extends ni, L extends ng<O>> boolean a(int i3, Class<L> cls) {
        ng a16 = a(cls, i3);
        if (a16 == null) {
            return false;
        }
        a16.remove();
        return true;
    }

    @Deprecated
    private boolean a(GL10 gl10) {
        this.f147879c.f147871j.a(gl10);
        return true;
    }

    private void a(fc fcVar) {
        this.f147880d = fcVar;
    }

    private boolean a(float f16, float f17) {
        TappedElement a16 = this.f147877a.g().a(f16, f17);
        if (a16 == null || a16.type != 3) {
            return false;
        }
        fc fcVar = this.f147880d;
        if (fcVar == null) {
            return true;
        }
        fcVar.o_();
        return true;
    }

    @Override // com.tencent.mapsdk.internal.bd
    public final void a(MotionEvent motionEvent) {
        bf bfVar = this.f147877a;
        if (bfVar == null || !this.f147884h || this.f147883g == null) {
            return;
        }
        TencentMap.OnMarkerDragListener r16 = bfVar.r();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.f147883g.setPosition(ks.a(this.f147877a.d().a(new fw((int) motionEvent.getX(), (int) motionEvent.getY()))));
                if (r16 != null) {
                    r16.onMarkerDrag(this.f147883g);
                    return;
                }
                return;
            }
            if (action != 3 && action != 4) {
                return;
            }
        }
        this.f147884h = false;
        if (r16 != null) {
            r16.onMarkerDragEnd(this.f147883g);
        }
        this.f147883g = null;
    }

    @Override // com.tencent.mapsdk.internal.bd
    public final void a(String str) {
        if (str.trim().length() == 0) {
            this.f147883g = null;
            this.f147884h = false;
            return;
        }
        TencentMap.OnMarkerDragListener r16 = this.f147877a.r();
        Marker marker = (Marker) this.f147879c.a(str, ax.class);
        this.f147883g = marker;
        if (marker != null) {
            TencentMapContext tencentMapContext = this.f147877a;
            if (tencentMapContext instanceof bp) {
                if ((marker == null || marker != this.f147885i) ? false : gq.a((bp) tencentMapContext)) {
                    return;
                }
            }
            if (!this.f147883g.isDraggable()) {
                this.f147883g = null;
                this.f147884h = false;
            } else {
                this.f147884h = true;
                if (r16 != null) {
                    r16.onMarkerDragStart(this.f147883g);
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.bd
    public final void a() {
        this.f147884h = false;
        this.f147883g = null;
    }

    private boolean a(bp bpVar, Marker marker) {
        if (marker == null || marker != this.f147885i) {
            return false;
        }
        return gq.a(bpVar);
    }

    @Override // com.tencent.mapsdk.internal.sj.c
    public final void a(View view, Rect rect, boolean z16) {
        Bitmap a16;
        if (view == null || rect == null || (a16 = hn.a(view)) == null) {
            return;
        }
        if (this.f147885i == null) {
            MarkerOptions visible = new MarkerOptions().anchor(0.0f, 0.0f).visible(false);
            visible.tag(qa.f149734c);
            visible.fastLoad(true);
            Marker a17 = this.f147879c.a(visible);
            this.f147885i = a17;
            ax axVar = (ax) this.f147879c.a(a17.getId(), ax.class);
            if (axVar != null) {
                axVar.f147778b.a(new TencentMap.OnMarkerClickListener() { // from class: com.tencent.mapsdk.internal.bk.1
                    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
                    public final boolean onMarkerClick(Marker marker) {
                        bk bkVar = bk.this;
                        if (bkVar.f147878b == null) {
                            bkVar.f147878b = kq.a(bkVar.f147877a.getContext(), null, " ", 0);
                        }
                        LogUtil.a(bk.this.f147882f).a(bk.this.f147877a.getContext(), bk.this.f147878b);
                        return false;
                    }
                });
            }
        }
        this.f147885i.setFixingPoint(rect.left, rect.top);
        this.f147885i.setIcon(BitmapDescriptorFactory.fromBitmap(this.f147877a, a16));
        this.f147885i.setVisible(z16);
        ku.a(a16);
    }

    @Override // com.tencent.mapsdk.internal.sj.c
    public final void a(sj sjVar) {
        Marker marker = this.f147886j;
        if (marker != null) {
            marker.setVisible(false);
        }
        if (this.f147885i == null || sjVar.k()) {
            return;
        }
        this.f147885i.setVisible(false);
    }

    @Override // com.tencent.mapsdk.internal.qa.a
    public final void a(Bitmap bitmap, int i3, int i16) {
        Marker marker = this.f147887k;
        if (marker == null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.tag(qa.f149734c);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(this.f147877a, bitmap));
            Marker a16 = this.f147879c.a(markerOptions);
            this.f147887k = a16;
            a16.setFixingPoint(i3 / 2, i16 / 2);
            this.f147887k.setClickable(false);
        } else {
            marker.setIcon(BitmapDescriptorFactory.fromBitmap(this.f147877a, bitmap));
            this.f147887k.setFixingPoint(i3 / 2, i16 / 2);
        }
        ku.a(bitmap);
    }

    private Pair<VectorOverlay, TencentMap.IClickedObject> a(LatLng latLng, long j3, String str, String str2) {
        nh<?> nhVar = this.f147881e.get(nr.class);
        if (nhVar != null) {
            return nhVar.a(latLng, j3, str, str2);
        }
        return new Pair<>(null, null);
    }
}
