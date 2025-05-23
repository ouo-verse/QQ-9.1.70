package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    public static final int f147683a = 0;

    /* renamed from: b, reason: collision with root package name */
    public ak f147684b;

    /* renamed from: c, reason: collision with root package name */
    public TencentMap.SnapshotReadyCallback f147685c = null;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f147686d = new Handler(Looper.getMainLooper()) { // from class: com.tencent.mapsdk.internal.ab.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message != null && message.what == 0) {
                TencentMap.SnapshotReadyCallback snapshotReadyCallback = ab.this.f147685c;
                if (snapshotReadyCallback != null) {
                    snapshotReadyCallback.onSnapshotReady((Bitmap) message.obj);
                }
                ab.this.f147685c = null;
            }
        }
    };

    public ab(ak akVar) {
        this.f147684b = null;
        this.f147684b = akVar;
    }

    private static /* synthetic */ TencentMap.SnapshotReadyCallback b(ab abVar) {
        abVar.f147685c = null;
        return null;
    }

    private void c() {
        if (this.f147684b != null) {
            this.f147684b = null;
        }
    }

    private float d() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return -1.0f;
        }
        return akVar.b();
    }

    private float e() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return -1.0f;
        }
        return akVar.c();
    }

    private void f() {
    }

    private void g() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.d();
    }

    private int h() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return 1000;
        }
        return akVar.A();
    }

    private int i() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return -1;
        }
        return akVar.f();
    }

    private boolean j() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return false;
        }
        return akVar.h();
    }

    private void l() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.j();
    }

    private void o() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.n();
    }

    private void p() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.m();
    }

    private String q() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return "";
        }
        return akVar.o();
    }

    private Language r() {
        ak akVar = this.f147684b;
        if (akVar != null) {
            return akVar.p();
        }
        return Language.zh;
    }

    private int s() {
        ak akVar = this.f147684b;
        if (akVar != null) {
            return akVar.r();
        }
        return -1;
    }

    private String[] t() {
        ak akVar = this.f147684b;
        if (akVar != null) {
            return akVar.s();
        }
        return null;
    }

    private boolean u() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return false;
        }
        return akVar.w();
    }

    private String v() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return null;
        }
        return akVar.z();
    }

    private void b(int i3) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.e(i3);
    }

    private void f(int i3) {
        ak akVar = this.f147684b;
        if (akVar != null) {
            akVar.c(i3);
        }
    }

    public final CameraPosition a() {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return null;
        }
        return akVar.a();
    }

    private void c(int i3) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.f(i3);
    }

    private void d(int i3) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(i3);
    }

    private void e(int i3) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.b(i3);
    }

    private void g(boolean z16) {
        ak akVar = this.f147684b;
        if (akVar != null) {
            akVar.h(z16);
        }
    }

    private void h(boolean z16) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.i(z16);
    }

    private void a(int i3) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.d(i3);
    }

    private void b(TencentMapGestureListener tencentMapGestureListener) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.b(tencentMapGestureListener);
    }

    private void f(boolean z16) {
        ak akVar = this.f147684b;
        if (akVar != null) {
            akVar.g(z16);
        }
    }

    private void c(boolean z16) {
        ak akVar = this.f147684b;
        if (akVar != null) {
            akVar.c(z16);
        }
    }

    private void d(boolean z16) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.e(z16);
    }

    private void e(boolean z16) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.f(z16);
    }

    private void b(boolean z16) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.b(z16);
    }

    public final int a(CameraUpdate cameraUpdate) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return Integer.MIN_VALUE;
        }
        return akVar.a(cameraUpdate);
    }

    private void b(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        ak akVar = this.f147684b;
        if (akVar != null) {
            akVar.b(onMapLoadedCallback);
        }
    }

    public final int a(CameraUpdate cameraUpdate, long j3, TencentMap.CancelableCallback cancelableCallback) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return Integer.MIN_VALUE;
        }
        return akVar.a(cameraUpdate, j3, cancelableCallback);
    }

    private float a(LatLng latLng, LatLng latLng2) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return -1.0f;
        }
        return akVar.a(latLng, latLng2);
    }

    private void b(Language language) {
        ak akVar = this.f147684b;
        if (akVar != null) {
            akVar.a(language);
        }
    }

    private void a(boolean z16) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(z16);
    }

    @Deprecated
    private String b(LatLng latLng) {
        IndoorBuilding u16;
        ak akVar = this.f147684b;
        if (akVar == null || (u16 = akVar.u()) == null) {
            return null;
        }
        if (u16.getBuildingLatLng() != null && latLng != null) {
            latLng.latitude = u16.getBuildingLatLng().latitude;
            latLng.longitude = u16.getBuildingLatLng().longitude;
        }
        return u16.getBuildingName();
    }

    private void a(TencentMap.OnMapClickListener onMapClickListener) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(onMapClickListener);
    }

    private void a(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(onMapLongClickListener);
    }

    private void a(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(onCameraChangeListener);
    }

    public final boolean b() {
        ak akVar = this.f147684b;
        if (akVar != null) {
            return akVar.x();
        }
        return false;
    }

    private void a(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(onScaleViewChangedListener);
    }

    private int b(String str) {
        if (this.f147684b == null || hs.a(str)) {
            return -1;
        }
        return this.f147684b.b(str);
    }

    private void a(Handler handler, Bitmap.Config config, int i3) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(handler, config, i3);
    }

    private void a(TencentMap.SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config, int i3) {
        ak akVar = this.f147684b;
        if (akVar == null || snapshotReadyCallback == null) {
            return;
        }
        this.f147685c = snapshotReadyCallback;
        Handler handler = this.f147686d;
        if (akVar != null) {
            akVar.a(handler, config, i3);
        }
    }

    private void k() {
    }

    private void m() {
    }

    private void n() {
    }

    private String a(LatLng latLng) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return null;
        }
        return akVar.a(latLng);
    }

    private void a(TencentMapGestureListener tencentMapGestureListener) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(tencentMapGestureListener);
    }

    private void a(int i3, int i16) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(i3, i16);
    }

    private CameraPosition a(List<fb> list, List<LatLng> list2, int i3, int i16, int i17, int i18) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return null;
        }
        return akVar.a(list, list2, i3, i16, i17, i18);
    }

    private void a(float f16, float f17, boolean z16) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(f16, f17, z16);
    }

    private void a(TencentMap.OnCompassClickedListener onCompassClickedListener) {
        ak akVar = this.f147684b;
        if (akVar != null) {
            akVar.a(onCompassClickedListener);
        }
    }

    private void a(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        ak akVar = this.f147684b;
        if (akVar != null) {
            akVar.a(onMapLoadedCallback);
        }
    }

    private void a(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(onIndoorStateChangeListener);
    }

    private void a(String str) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(str);
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f147684b.a(str, str2);
    }

    public final void a(Language language) {
        ak akVar = this.f147684b;
        if (akVar != null) {
            akVar.b(language);
        }
    }

    private TileOverlay a(TileOverlayOptions tileOverlayOptions) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return null;
        }
        return akVar.a(tileOverlayOptions);
    }

    private CustomLayer a(CustomLayerOptions customLayerOptions) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return null;
        }
        return akVar.a(customLayerOptions);
    }

    private void a(LatLngBounds latLngBounds, int i3) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(latLngBounds, i3);
    }

    private void a(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener) {
        ak akVar = this.f147684b;
        if (akVar == null) {
            return;
        }
        akVar.a(onTrafficEventClickListener);
    }
}
