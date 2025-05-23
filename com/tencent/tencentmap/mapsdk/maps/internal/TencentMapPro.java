package com.tencent.tencentmap.mapsdk.maps.internal;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ag;
import com.tencent.mapsdk.internal.an;
import com.tencent.mapsdk.internal.bi;
import com.tencent.mapsdk.internal.bk;
import com.tencent.mapsdk.internal.bw;
import com.tencent.mapsdk.internal.cr;
import com.tencent.mapsdk.internal.dk;
import com.tencent.mapsdk.internal.dz;
import com.tencent.mapsdk.internal.fb;
import com.tencent.mapsdk.internal.ge;
import com.tencent.mapsdk.internal.hq;
import com.tencent.mapsdk.internal.kp;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.ob;
import com.tencent.mapsdk.internal.om;
import com.tencent.mapsdk.internal.sm;
import com.tencent.mapsdk.internal.th;
import com.tencent.mapsdk.internal.tr;
import com.tencent.mapsdk.internal.ud;
import com.tencent.mapsdk.internal.y;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import java.util.ArrayList;
import java.util.List;

@Keep
/* loaded from: classes26.dex */
public final class TencentMapPro {
    private tr mVectorMapDelegate;
    private boolean mapDestroyed = false;
    private bi mapManager;
    private ag viewControl;

    public TencentMapPro(bi biVar, ag agVar) {
        this.mapManager = biVar;
        this.viewControl = agVar;
        this.mVectorMapDelegate = biVar.f147819b;
    }

    @Keep
    public static final boolean isLocal(Context context, LatLng latLng) {
        kp.a(kp.a());
        sm.a().a(context);
        sm.a();
        ge[] c16 = sm.c(sm.f150328a);
        ge b16 = y.b(GeoPoint.from(latLng));
        if (b16 != null && c16 != null) {
            boolean a16 = sm.a(b16, c16);
            if (a16) {
                kp.a((kp.g) new kp.g<Boolean>() { // from class: com.tencent.tencentmap.mapsdk.maps.internal.TencentMapPro.1
                    private static Boolean a() throws Exception {
                        try {
                            dz dzVar = (dz) cr.a(dz.class);
                            if (dzVar == null) {
                                dzVar = (dz) hq.a(dz.class, new Object[0]);
                            }
                            NetResponse local = ((dk) dzVar.i()).local(1);
                            if (local != null) {
                                LogUtil.b("data with response:" + new String(local.data, local.charset));
                            }
                        } catch (Exception e16) {
                            LogUtil.d("err:" + e16.getMessage());
                        }
                        return Boolean.TRUE;
                    }

                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() throws Exception {
                        return a();
                    }
                }).a((kp.b.a) Boolean.FALSE);
            }
            return a16;
        }
        return true;
    }

    @Keep
    public final IntersectionOverlay addIntersectionEnlargeOverlay(IntersectionOverlayOptions intersectionOverlayOptions) {
        tr trVar;
        ne neVar;
        if (this.mapDestroyed || (trVar = this.mVectorMapDelegate) == null || (neVar = trVar.aC) == null || neVar.f149396i == null) {
            return null;
        }
        return (IntersectionOverlay) neVar.f149400m.a((bk) new ob(intersectionOverlayOptions));
    }

    @Keep
    public final void addRouteNameSegments(List<MapRouteSectionWithName> list, List<LatLng> list2) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (MapRouteSectionWithName mapRouteSectionWithName : list) {
                if (mapRouteSectionWithName != null) {
                    MapRouteSection mapRouteSection = new MapRouteSection();
                    mapRouteSection.color = mapRouteSectionWithName.color;
                    mapRouteSection.endNum = mapRouteSectionWithName.endNum;
                    mapRouteSection.roadName = mapRouteSectionWithName.roadName;
                    mapRouteSection.startNum = mapRouteSectionWithName.startNum;
                    arrayList.add(mapRouteSection);
                }
            }
            addSegmentsWithRouteName(arrayList, list2);
        }
    }

    @Keep
    public final void addSegmentsWithRouteName(List<MapRouteSection> list, List<LatLng> list2) {
        bi biVar;
        VectorMap vectorMap;
        if (!this.mapDestroyed && (biVar = this.mapManager) != null && biVar.f147819b != null && (vectorMap = (VectorMap) biVar.f147819b.e_) != null) {
            List<GeoPoint> from = GeoPoint.from(list2);
            ne neVar = vectorMap.f151351o;
            if (neVar.C == null) {
                neVar.C = new ne.d();
            }
            ne.d dVar = neVar.C;
            dVar.f149425a = list;
            dVar.f149426b = from;
            ne.this.f149396i.a(list, from);
        }
    }

    @Keep
    public final void animateToNaviPosition(LatLng latLng, float f16, float f17) {
        bi biVar;
        if (this.mapDestroyed || (biVar = this.mapManager) == null) {
            return;
        }
        biVar.a(latLng, f16, f17, 0.0f, true);
    }

    @Keep
    public final void animateToNaviPosition2(LatLng latLng, float f16, float f17, float f18, boolean z16) {
        bi biVar;
        if (!this.mapDestroyed && (biVar = this.mapManager) != null) {
            th thVar = new th();
            thVar.b((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
            thVar.a(f18);
            thVar.c(f16);
            thVar.d(f17);
            thVar.f150457a = biVar.f147828k;
            thVar.f150487g = true;
            thVar.a(1000L);
            ((VectorMap) biVar.f147819b.e_).y();
            ((VectorMap) biVar.f147819b.e_).a(thVar);
        }
    }

    @Keep
    public final float calNaviLevel(LatLngBounds latLngBounds, float f16, int i3, boolean z16) {
        bi biVar;
        int i16;
        float f17;
        if (this.mapDestroyed || (biVar = this.mapManager) == null || latLngBounds == null) {
            return 0.0f;
        }
        if (z16) {
            i16 = biVar.f147819b.K;
        } else {
            i16 = biVar.f147819b.M;
        }
        if (!z16) {
            f17 = 0.0f;
        } else {
            f17 = f16;
        }
        if (i16 < 0) {
            i16 = biVar.f147819b.f151030aj / 2;
        }
        return biVar.a(f17, 0, 0, i3, biVar.f147819b.f151031ak - i16, latLngBounds.southwest, latLngBounds.northeast);
    }

    @Keep
    public final float calNaviLevel2(LatLng latLng, LatLng latLng2, float f16, float f17, int i3, boolean z16) {
        bi biVar;
        float f18;
        if (this.mapDestroyed || (biVar = this.mapManager) == null || latLng == null || latLng2 == null) {
            return 0.0f;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        if (!z16) {
            f18 = 0.0f;
        } else {
            f18 = f16;
        }
        return biVar.a(f18, 0, 0, i3, 0, builder.build().southwest, builder.build().northeast);
    }

    @Keep
    public final float calNaviLevel3(LatLng latLng, LatLng latLng2, float f16, int i3, int i16, int i17, int i18, boolean z16) {
        bi biVar;
        float f17;
        if (this.mapDestroyed || (biVar = this.mapManager) == null || latLng == null || latLng2 == null) {
            return 0.0f;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        if (!z16) {
            f17 = 0.0f;
        } else {
            f17 = f16;
        }
        return biVar.a(f17, i3, i16, i17, i18, builder.build().southwest, builder.build().northeast);
    }

    @Keep
    public final CameraPosition calculateZoomToSpanLevelAsync(List<IOverlay> list, List<LatLng> list2, int i3, int i16, int i17, int i18, TencentMap.AsyncOperateCallback<CameraPosition> asyncOperateCallback) {
        if (!this.mapDestroyed && this.mapManager != null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (IOverlay iOverlay : list) {
                    if (iOverlay instanceof fb) {
                        arrayList.add((fb) iOverlay);
                    }
                }
            }
            return this.mapManager.a(arrayList, list2, i3, i16, i17, i18, asyncOperateCallback);
        }
        if (asyncOperateCallback != null) {
            asyncOperateCallback.onOperateFinished(null);
        }
        return null;
    }

    @Keep
    public final void clearRouteNameSegments() {
        bi biVar;
        VectorMap vectorMap;
        if (!this.mapDestroyed && (biVar = this.mapManager) != null && biVar.f147819b != null && (vectorMap = (VectorMap) biVar.f147819b.e_) != null) {
            vectorMap.clearRouteNameSegments();
        }
    }

    @Keep
    public final boolean isNaviStateEnabled() {
        bi biVar;
        if (!this.mapDestroyed && (biVar = this.mapManager) != null) {
            return biVar.x();
        }
        return false;
    }

    @Keep
    public final void moveToNavPosition(CameraUpdate cameraUpdate, LatLng latLng) {
        bi biVar;
        if (!this.mapDestroyed && (biVar = this.mapManager) != null) {
            biVar.a(cameraUpdate);
            if (latLng != null) {
                setNavCenter((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
            }
        }
    }

    @Keep
    public final void onDestroy() {
        this.mapDestroyed = true;
    }

    @Keep
    public final void setNavCenter(int i3, int i16) {
        bw C;
        ag agVar = this.viewControl;
        if (agVar == null) {
            return;
        }
        an anVar = agVar.f147772a;
        if (anVar == null) {
            C = null;
        } else {
            C = anVar.C();
        }
        if (C instanceof ud) {
            ((ud) C).getVectorMapDelegate().b(i3, i16);
        }
    }

    @Keep
    public final void setNaviFixingProportion(float f16, float f17) {
        bi biVar;
        if (!this.mapDestroyed && (biVar = this.mapManager) != null && biVar.f147819b != null) {
            if (f16 < 0.0f) {
                f16 = 0.0f;
            } else if (f16 > 1.0f) {
                f16 = 1.0f;
            }
            if (f17 < 0.0f) {
                f17 = 0.0f;
            } else if (f17 > 1.0f) {
                f17 = 1.0f;
            }
            biVar.f147819b.c((int) (biVar.f147819b.f151030aj * f16), (int) (biVar.f147819b.f151031ak * f17));
            biVar.f147819b.N = f16;
            biVar.f147819b.O = f17;
        }
    }

    @Keep
    public final void setNaviFixingProportion2D(float f16, float f17) {
        bi biVar;
        if (!this.mapDestroyed && (biVar = this.mapManager) != null && biVar.f147819b != null) {
            if (f16 < 0.0f) {
                f16 = 0.0f;
            } else if (f16 > 1.0f) {
                f16 = 1.0f;
            }
            if (f17 < 0.0f) {
                f17 = 0.0f;
            } else if (f17 > 1.0f) {
                f17 = 1.0f;
            }
            biVar.f147819b.d((int) (biVar.f147819b.f151030aj * f16), (int) (biVar.f147819b.f151031ak * f17));
            biVar.f147819b.P = f16;
            biVar.f147819b.Q = f17;
        }
    }

    @Keep
    public final void setNaviStateEnabled(boolean z16) {
        bi biVar;
        if (!this.mapDestroyed && (biVar = this.mapManager) != null) {
            biVar.h(z16);
        }
    }

    @Keep
    public final void setOnCameraChangeListener(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        bi biVar;
        if (!this.mapDestroyed && (biVar = this.mapManager) != null && biVar.f147819b != null) {
            biVar.f147819b.F = onCameraChangeListener;
        }
    }

    public final void setOptionalResourcePath(String str) {
        tr trVar;
        ne neVar;
        om omVar;
        if (!this.mapDestroyed && (trVar = this.mVectorMapDelegate) != null && (neVar = trVar.aC) != null && (omVar = neVar.A) != null) {
            omVar.a(str);
        }
    }

    @Keep
    public final void animateToNaviPosition(LatLng latLng, float f16, float f17, float f18) {
        bi biVar;
        if (this.mapDestroyed || (biVar = this.mapManager) == null) {
            return;
        }
        biVar.a(latLng, f16, f17, f18, true);
    }

    @Keep
    public final void animateToNaviPosition(LatLng latLng, float f16, float f17, float f18, boolean z16) {
        bi biVar;
        if (this.mapDestroyed || (biVar = this.mapManager) == null) {
            return;
        }
        biVar.a(latLng, f16, f17, f18, z16);
    }
}
