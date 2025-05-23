package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import android.location.Location;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.px;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.SubPoi;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tp implements fd {

    /* renamed from: a, reason: collision with root package name */
    private tr f150996a;

    public tp(tr trVar) {
        this.f150996a = trVar;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final void a() {
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean b() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean c() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean d() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean e(float f16, float f17) {
        ax d16;
        tr trVar = this.f150996a;
        if (trVar == null || !trVar.f151124av) {
            return false;
        }
        if (trVar.f151062s != null && (d16 = trVar.d(f16, f17)) != null) {
            trVar.f151062s.a(d16.getId());
            trVar.a(d16, true);
        } else if (trVar.f151064u != null && trVar.f151124av) {
            trVar.f151064u.onMapLongClick(ks.a(((VectorMap) trVar.e_).getProjection().a(new fw(f16, f17))));
        }
        TencentMapGestureListenerList tencentMapGestureListenerList = this.f150996a.f151123au;
        if (tencentMapGestureListenerList == null) {
            return false;
        }
        return tencentMapGestureListenerList.onLongPress(f16, f17);
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean f(float f16, float f17) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean g(float f16, float f17) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean h(float f16, float f17) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean i(float f16, float f17) {
        tr trVar = this.f150996a;
        if (trVar == null || !trVar.f151124av) {
            return false;
        }
        trVar.aB++;
        TencentMapGestureListenerList tencentMapGestureListenerList = trVar.f151123au;
        if (tencentMapGestureListenerList == null) {
            return false;
        }
        return tencentMapGestureListenerList.onDown(f16, f17);
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean j(float f16, float f17) {
        int i3;
        tr trVar = this.f150996a;
        if (trVar == null || !trVar.f151124av) {
            return false;
        }
        int i16 = trVar.aB;
        if (i16 > 0) {
            i3 = i16 - 1;
            trVar.aB = i3;
        } else {
            i3 = 0;
        }
        trVar.aB = i3;
        if (trVar.aA && this.f150996a.f151128az) {
            tr trVar2 = this.f150996a;
            if (trVar2.aB == 0) {
                CameraPosition a16 = trVar2.a();
                if (a16 == null) {
                    return false;
                }
                this.f150996a.aA = false;
                this.f150996a.onCameraChangeFinished(a16);
            }
        }
        TencentMapGestureListenerList tencentMapGestureListenerList = this.f150996a.f151123au;
        if (tencentMapGestureListenerList == null) {
            return false;
        }
        return tencentMapGestureListenerList.onUp(f16, f17);
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean k(float f16, float f17) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean a(float f16) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean b(float f16) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean c(float f16, float f17) {
        TencentMapGestureListenerList tencentMapGestureListenerList;
        tr trVar = this.f150996a;
        if (trVar == null || !trVar.f151124av || (tencentMapGestureListenerList = trVar.f151123au) == null) {
            return false;
        }
        return tencentMapGestureListenerList.onFling(f16, f17);
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean d(float f16, float f17) {
        TencentMapGestureListenerList tencentMapGestureListenerList;
        tr trVar = this.f150996a;
        if (trVar == null || !trVar.f151124av || (tencentMapGestureListenerList = trVar.f151123au) == null) {
            return false;
        }
        return tencentMapGestureListenerList.onScroll(f16, f17);
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean a(PointF pointF, PointF pointF2, double d16, double d17) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0133, code lost:
    
        if (r0 == false) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0139  */
    @Override // com.tencent.mapsdk.internal.fd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(float f16, float f17) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        py pyVar;
        px.d dVar;
        px.d dVar2;
        List<px.d> list;
        WeakReference<TencentMap.OnMyLocationClickListener> weakReference;
        TencentMap.OnMyLocationClickListener onMyLocationClickListener;
        tk tkVar;
        tr trVar = this.f150996a;
        if (trVar == null || !trVar.f151124av) {
            return false;
        }
        ne neVar = trVar.aC;
        fd fdVar = trVar.f151032al;
        SubPoi subPoi = null;
        boolean z26 = true;
        if (neVar.P == null) {
            nh<?> nhVar = neVar.f149400m.f147881e.get(nr.class);
            if ((nhVar != null ? nhVar.f() : false) && (tkVar = neVar.f149396i) != null) {
                tkVar.f150514d.scheduleClickOnNextRender(tkVar.f150515e, f16, f17);
                neVar.P = fdVar;
                z16 = true;
                if (!z16) {
                    return true;
                }
                tr trVar2 = this.f150996a;
                if (trVar2.f151124av) {
                    VectorMap vectorMap = (VectorMap) trVar2.e_;
                    bk bkVar = vectorMap.f151351o.f149400m;
                    TappedElement a16 = bkVar.f147877a.g().a(f16, f17);
                    if (a16 == null || a16.type != 3) {
                        z17 = false;
                    } else {
                        fc fcVar = bkVar.f147880d;
                        if (fcVar != null) {
                            fcVar.o_();
                        }
                        z17 = true;
                    }
                    if (!z17) {
                        bh bhVar = vectorMap.f151355s;
                        if (bhVar != null) {
                            TappedElement a17 = bhVar.f147806j.f149400m.f147877a.g().a(f16, f17);
                            z18 = a17 != null && a17.type == 6;
                            if (z18 && (weakReference = bhVar.f147802f) != null && (onMyLocationClickListener = weakReference.get()) != null) {
                                LatLng latLng = new LatLng();
                                Location location = bhVar.f147805i;
                                if (location != null) {
                                    latLng.setAltitude(location.getAltitude());
                                    latLng.setLongitude(bhVar.f147805i.getLongitude());
                                    latLng.setLatitude(bhVar.f147805i.getLatitude());
                                }
                                z18 = onMyLocationClickListener.onMyLocationClicked(latLng);
                            }
                        } else {
                            z18 = false;
                        }
                        if (!z18) {
                            TappedElement a18 = vectorMap.a(f16, f17);
                            if (a18 != null && (pyVar = vectorMap.f151356t) != null && pyVar.f149723c != null && a18.type == 4) {
                                long j3 = a18.itemId;
                                Iterator<pw> it = pyVar.f149721a.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    pw next = it.next();
                                    px pxVar = next.f149671b;
                                    if (pxVar != null && (dVar2 = pxVar.f149690a) != null && (list = dVar2.f149708j) != null) {
                                        Iterator<px.d> it5 = list.iterator();
                                        while (it5.hasNext()) {
                                            dVar = it5.next();
                                            if (((oc) next.f149670a.f149722b.f149400m.a(oc.class, dVar.f149699a)) != null && r10.a() == j3) {
                                                break;
                                            }
                                        }
                                    }
                                    dVar = null;
                                    if (dVar != null) {
                                        subPoi = pw.a(next.getId(), dVar);
                                        break;
                                    }
                                }
                                if (subPoi != null) {
                                    pyVar.f149723c.onClicked(subPoi);
                                    z19 = true;
                                }
                            }
                            z19 = false;
                        }
                    }
                    boolean b16 = z26 ? false : this.f150996a.b(f16, f17);
                    tr trVar3 = this.f150996a;
                    TencentMapGestureListenerList tencentMapGestureListenerList = trVar3.f151123au;
                    return (tencentMapGestureListenerList == null && trVar3.f151124av) ? tencentMapGestureListenerList.onSingleTap(f16, f17) : b16;
                }
                z26 = false;
                if (z26) {
                }
                tr trVar32 = this.f150996a;
                TencentMapGestureListenerList tencentMapGestureListenerList2 = trVar32.f151123au;
                if (tencentMapGestureListenerList2 == null) {
                }
            }
        }
        neVar.P = null;
        z16 = false;
        if (!z16) {
        }
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean a(PointF pointF, PointF pointF2, float f16) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean a(float f16, float f17) {
        boolean z16;
        TencentMapGestureListenerList tencentMapGestureListenerList;
        tr trVar = this.f150996a;
        if (trVar != null && (z16 = trVar.f151124av) && (tencentMapGestureListenerList = trVar.f151123au) != null && z16) {
            return tencentMapGestureListenerList.onDoubleTap(f16, f17);
        }
        return false;
    }
}
