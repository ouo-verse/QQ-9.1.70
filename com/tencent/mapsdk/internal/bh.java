package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.Handler;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.net.NetManager;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.CustomLocationProvider;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LocationCompass;
import com.tencent.tencentmap.mapsdk.maps.model.LocationNavigationGravityline;
import com.tencent.tencentmap.mapsdk.maps.model.LocationRegion;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class bh implements aj {

    /* renamed from: n, reason: collision with root package name */
    private static final int f147796n = 10;

    /* renamed from: a, reason: collision with root package name */
    final ab f147797a;

    /* renamed from: c, reason: collision with root package name */
    boolean f147799c;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<TencentMap.OnMyLocationChangeListener> f147801e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<TencentMap.OnMyLocationClickListener> f147802f;

    /* renamed from: j, reason: collision with root package name */
    public final ne f147806j;

    /* renamed from: k, reason: collision with root package name */
    LocationRegion f147807k;

    /* renamed from: p, reason: collision with root package name */
    private BitmapDescriptor f147811p;

    /* renamed from: q, reason: collision with root package name */
    private BitmapDescriptor f147812q;

    /* renamed from: r, reason: collision with root package name */
    private int f147813r;

    /* renamed from: s, reason: collision with root package name */
    private BitmapDescriptor f147814s;

    /* renamed from: o, reason: collision with root package name */
    private LocationSource f147810o = null;

    /* renamed from: b, reason: collision with root package name */
    boolean f147798b = false;

    /* renamed from: d, reason: collision with root package name */
    Circle f147800d = null;

    /* renamed from: g, reason: collision with root package name */
    final List<WeakReference<LocationRegion.LocationRegionChangedListener>> f147803g = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    MyLocationStyle f147804h = new MyLocationStyle();

    /* renamed from: i, reason: collision with root package name */
    public Location f147805i = null;

    /* renamed from: l, reason: collision with root package name */
    final AtomicInteger f147808l = new AtomicInteger(0);

    /* renamed from: t, reason: collision with root package name */
    private final LocationSource.OnLocationChangedListener f147815t = new LocationSource.OnLocationChangedListener() { // from class: com.tencent.mapsdk.internal.bh.1
        @Override // com.tencent.tencentmap.mapsdk.maps.LocationSource.OnLocationChangedListener
        public final void onLocationChanged(Location location) {
            boolean z16;
            LocationRegion.RegionName regionName;
            TencentMap.OnMyLocationChangeListener onMyLocationChangeListener;
            if (location == null) {
                return;
            }
            LogUtil.c(ky.f149120z, "new location changed : ".concat(String.valueOf(location)));
            bh bhVar = bh.this;
            Location location2 = bhVar.f147805i;
            if (location2 == null) {
                bhVar.f147805i = new Location(location);
            } else {
                try {
                    location2.set(location);
                } catch (Exception e16) {
                    LogUtil.e(ky.f149098d, "location input format exception:" + e16.fillInStackTrace());
                }
            }
            boolean contains = location.getProvider().contains(CustomLocationProvider.NAME);
            if (bh.this.f147808l.getAndIncrement() != 0 && bh.this.f147808l.get() < 10) {
                z16 = false;
            } else {
                z16 = true;
            }
            if ((contains || z16) && !bh.this.f147803g.isEmpty()) {
                LogUtil.c(ky.f149120z, "check location region change times:" + bh.this.f147808l.get() + " fromCustomAuto:" + contains);
                sm.a().a(bh.this.f147806j.getContext());
                sm.a();
                ge[] c16 = sm.c(sm.f150330c);
                ge b16 = y.b(GeoPoint.from(new LatLng(location.getLatitude(), location.getLongitude())));
                if (b16 != null && c16 != null) {
                    if (bh.this.f147808l.get() >= 10) {
                        bh.this.f147808l.set(1);
                    }
                    boolean a16 = sm.a(b16, c16);
                    LocationRegion locationRegion = new LocationRegion();
                    if (a16) {
                        regionName = LocationRegion.RegionName.INLAND_WITHOUT_SAR_OF_CHINA;
                    } else {
                        regionName = LocationRegion.RegionName.EARTH;
                    }
                    locationRegion.regionName = regionName;
                    locationRegion.target = location;
                    LocationRegion locationRegion2 = bh.this.f147807k;
                    if (locationRegion2 == null || locationRegion2.regionName != regionName) {
                        LogUtil.c(ky.f149120z, "location region changed: isInlandWithoutSAROfChina = ".concat(String.valueOf(a16)));
                        Iterator<WeakReference<LocationRegion.LocationRegionChangedListener>> it = bh.this.f147803g.iterator();
                        while (it.hasNext()) {
                            LocationRegion.LocationRegionChangedListener locationRegionChangedListener = it.next().get();
                            if (locationRegionChangedListener != null) {
                                locationRegionChangedListener.onLocationRegionChanged(bh.this.f147807k, locationRegion);
                            }
                        }
                    }
                    bh.this.f147807k = locationRegion;
                } else {
                    return;
                }
            }
            bh bhVar2 = bh.this;
            if (bhVar2.f147798b) {
                LogUtil.b(ky.f149120z, "updateMyLocation ".concat(String.valueOf(location)));
                bhVar2.a(location);
                MyLocationStyle myLocationStyle = bhVar2.f147804h;
                if (myLocationStyle != null) {
                    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    Circle circle = bhVar2.f147800d;
                    if (circle != null) {
                        circle.setCenter(latLng);
                        bhVar2.f147800d.setRadius(LocationMonitor.getAccuracy(location));
                    }
                    bhVar2.f147806j.a(GeoPoint.from(latLng), 0.0f, 0.0f, false);
                    int myLocationType = myLocationStyle.getMyLocationType();
                    if (myLocationType != 1) {
                        if (myLocationType != 2) {
                            if (myLocationType != 3) {
                                bhVar2.f147806j.a(location.getBearing());
                                ab abVar = bhVar2.f147797a;
                                if (abVar != null) {
                                    abVar.a(CameraUpdateFactory.newLatLng(latLng));
                                }
                            } else {
                                ab abVar2 = bhVar2.f147797a;
                                if (abVar2 != null) {
                                    bhVar2.f147797a.a(CameraUpdateFactory.rotateTo(location.getBearing(), abVar2.a().tilt));
                                }
                            }
                        }
                    } else {
                        bhVar2.f147806j.a(location.getBearing());
                    }
                }
                WeakReference<TencentMap.OnMyLocationChangeListener> weakReference = bhVar2.f147801e;
                if (weakReference != null && (onMyLocationChangeListener = weakReference.get()) != null) {
                    onMyLocationChangeListener.onMyLocationChange(location);
                }
            }
        }
    };

    /* renamed from: m, reason: collision with root package name */
    final Handler f147809m = new Handler(kp.a("gesture"));

    public bh(ne neVar, ab abVar) {
        this.f147806j = neVar;
        this.f147797a = abVar;
    }

    private BitmapDescriptor f() {
        if (this.f147814s == null) {
            this.f147814s = BitmapDescriptorFactory.fromAsset(this.f147806j, "navi_marker_location.png");
        }
        return this.f147814s;
    }

    private BitmapDescriptor g() {
        return this.f147811p;
    }

    @Override // com.tencent.mapsdk.internal.aj
    public final void b() {
        LogUtil.c(ky.f149120z, "enableMyLocation : " + this.f147798b);
        if (this.f147798b) {
            return;
        }
        this.f147798b = true;
        this.f147806j.e(false);
        this.f147806j.f(false);
        this.f147806j.g(false);
        Circle circle = this.f147800d;
        if (circle != null) {
            circle.setVisible(true);
        }
    }

    @Override // com.tencent.mapsdk.internal.aj
    public final void c() {
        Circle circle = this.f147800d;
        if (circle != null) {
            circle.setVisible(false);
            this.f147800d.remove();
            this.f147800d = null;
        }
        LogUtil.b(ky.f149120z, "disableMyLocation " + this.f147798b);
        if (this.f147798b) {
            this.f147798b = false;
            this.f147806j.e(true);
            this.f147806j.f(true);
            this.f147806j.g(true);
            this.f147813r = 0;
        }
    }

    @Override // com.tencent.mapsdk.internal.aj
    public final boolean d() {
        return this.f147798b;
    }

    @Override // com.tencent.mapsdk.internal.aj
    public final Location e() {
        if (this.f147805i == null) {
            return null;
        }
        return new Location(this.f147805i);
    }

    @Override // com.tencent.mapsdk.internal.aj
    public final void a() {
        this.f147799c = false;
        c();
        LocationSource locationSource = this.f147810o;
        if (locationSource != null) {
            locationSource.deactivate();
        }
        LocationRegion.LocationRegionChangedListener regionChangedListener = NetManager.getInstance().getRegionChangedListener();
        if (regionChangedListener != null) {
            Iterator<WeakReference<LocationRegion.LocationRegionChangedListener>> it = this.f147803g.iterator();
            while (it.hasNext()) {
                if (it.next().get() != regionChangedListener) {
                    it.remove();
                }
            }
        }
    }

    private void b(Location location) {
        TencentMap.OnMyLocationChangeListener onMyLocationChangeListener;
        if (!this.f147798b || location == null) {
            return;
        }
        LogUtil.b(ky.f149120z, "updateMyLocation ".concat(String.valueOf(location)));
        a(location);
        MyLocationStyle myLocationStyle = this.f147804h;
        if (myLocationStyle != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            Circle circle = this.f147800d;
            if (circle != null) {
                circle.setCenter(latLng);
                this.f147800d.setRadius(LocationMonitor.getAccuracy(location));
            }
            this.f147806j.a(GeoPoint.from(latLng), 0.0f, 0.0f, false);
            int myLocationType = myLocationStyle.getMyLocationType();
            if (myLocationType == 1) {
                this.f147806j.a(location.getBearing());
            } else if (myLocationType != 2) {
                if (myLocationType != 3) {
                    this.f147806j.a(location.getBearing());
                    ab abVar = this.f147797a;
                    if (abVar != null) {
                        abVar.a(CameraUpdateFactory.newLatLng(latLng));
                    }
                } else {
                    ab abVar2 = this.f147797a;
                    if (abVar2 != null) {
                        this.f147797a.a(CameraUpdateFactory.rotateTo(location.getBearing(), abVar2.a().tilt));
                    }
                }
            }
        }
        WeakReference<TencentMap.OnMyLocationChangeListener> weakReference = this.f147801e;
        if (weakReference == null || (onMyLocationChangeListener = weakReference.get()) == null) {
            return;
        }
        onMyLocationChangeListener.onMyLocationChange(location);
    }

    @Override // com.tencent.mapsdk.internal.aj
    public final void a(LocationSource locationSource) {
        LogUtil.b(ky.f149120z, "setLocationSource " + locationSource + " enable " + this.f147798b);
        if (locationSource == null) {
            return;
        }
        LocationSource locationSource2 = this.f147810o;
        if (locationSource2 != null) {
            locationSource2.deactivate();
        }
        this.f147810o = locationSource;
        locationSource.activate(this.f147815t);
        LocationRegion.LocationRegionChangedListener regionChangedListener = NetManager.getInstance().getRegionChangedListener();
        if (regionChangedListener != null) {
            this.f147803g.add(new WeakReference<>(regionChangedListener));
        }
        if (CustomLocationProvider.getInstance().hasLocationSource()) {
            this.f147799c = true;
            this.f147809m.postDelayed(new Runnable() { // from class: com.tencent.mapsdk.internal.bh.2
                @Override // java.lang.Runnable
                public final void run() {
                    CustomLocationProvider.getInstance().requestLatestLocation();
                    if (bh.this.f147799c) {
                        if (CustomLocationProvider.getInstance().hasLocation()) {
                            bh.this.f147809m.postDelayed(this, MiniBoxNoticeInfo.MIN_5);
                        } else {
                            bh.this.f147809m.postDelayed(this, 60000L);
                        }
                    }
                }
            }, 1000L);
        }
    }

    final void a(Location location) {
        BitmapDescriptor compassImage;
        Bitmap bitmap;
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        if (this.f147800d == null) {
            CircleOptions circleOptions = new CircleOptions();
            circleOptions.radius(LocationMonitor.getAccuracy(location)).center(latLng).fillColor(this.f147804h.getFillColor()).strokeColor(this.f147804h.getStrokeColor()).strokeWidth(this.f147804h.getStrokeWidth());
            bj bjVar = this.f147806j.M;
            this.f147800d = bjVar == null ? null : bjVar.a(circleOptions);
        }
        if (this.f147813r == 0) {
            BitmapDescriptor myLocationIcon = this.f147804h.getMyLocationIcon();
            if (myLocationIcon == null) {
                myLocationIcon = f();
            }
            Bitmap bitmap2 = myLocationIcon.getBitmap(this.f147806j.getContext());
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.f147811p = myLocationIcon;
                this.f147813r = this.f147806j.a(myLocationIcon.getFormater().getBitmapId(), this.f147804h.getAnchorU(), this.f147804h.getAnchorV());
            }
            LocationCompass locationCompass = this.f147804h.getLocationCompass();
            if (locationCompass != null && locationCompass.getCompassImage() != null && (bitmap = (compassImage = locationCompass.getCompassImage()).getBitmap(this.f147806j.getContext())) != null && !bitmap.isRecycled()) {
                this.f147812q = compassImage;
                this.f147806j.c(compassImage.getFormater().getBitmapId());
                BitmapDescriptor[] compassGroupImages = locationCompass.getCompassGroupImages();
                if (compassGroupImages != null && compassGroupImages.length == 4) {
                    String[] strArr = new String[compassGroupImages.length];
                    for (int i3 = 0; i3 < compassGroupImages.length; i3++) {
                        BitmapDescriptor bitmapDescriptor = compassGroupImages[i3];
                        if (bitmapDescriptor != null) {
                            bitmapDescriptor.getBitmap(this.f147806j.getContext());
                            strArr[i3] = compassGroupImages[i3].getFormater().getBitmapId();
                        } else {
                            strArr[i3] = "";
                        }
                    }
                    this.f147806j.a(compassImage.getFormater().getBitmapId(), strArr[0], strArr[1], strArr[2], strArr[3]);
                }
            }
            LocationNavigationGravityline locationNavigationGravityline = this.f147804h.getLocationNavigationGravityline();
            if (locationNavigationGravityline != null) {
                this.f147806j.a(locationNavigationGravityline.getWidth(), locationNavigationGravityline.getColor(), locationNavigationGravityline.getDestination());
            }
        }
    }

    private void b(LocationRegion.LocationRegionChangedListener locationRegionChangedListener) {
        if (locationRegionChangedListener != null) {
            Iterator<WeakReference<LocationRegion.LocationRegionChangedListener>> it = this.f147803g.iterator();
            while (it.hasNext()) {
                if (it.next().get() != locationRegionChangedListener) {
                    it.remove();
                }
            }
        }
    }

    private static /* synthetic */ void b(bh bhVar, Location location) {
        TencentMap.OnMyLocationChangeListener onMyLocationChangeListener;
        if (!bhVar.f147798b || location == null) {
            return;
        }
        LogUtil.b(ky.f149120z, "updateMyLocation ".concat(String.valueOf(location)));
        bhVar.a(location);
        MyLocationStyle myLocationStyle = bhVar.f147804h;
        if (myLocationStyle != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            Circle circle = bhVar.f147800d;
            if (circle != null) {
                circle.setCenter(latLng);
                bhVar.f147800d.setRadius(LocationMonitor.getAccuracy(location));
            }
            bhVar.f147806j.a(GeoPoint.from(latLng), 0.0f, 0.0f, false);
            int myLocationType = myLocationStyle.getMyLocationType();
            if (myLocationType == 1) {
                bhVar.f147806j.a(location.getBearing());
            } else if (myLocationType != 2) {
                if (myLocationType != 3) {
                    bhVar.f147806j.a(location.getBearing());
                    ab abVar = bhVar.f147797a;
                    if (abVar != null) {
                        abVar.a(CameraUpdateFactory.newLatLng(latLng));
                    }
                } else {
                    ab abVar2 = bhVar.f147797a;
                    if (abVar2 != null) {
                        bhVar.f147797a.a(CameraUpdateFactory.rotateTo(location.getBearing(), abVar2.a().tilt));
                    }
                }
            }
        }
        WeakReference<TencentMap.OnMyLocationChangeListener> weakReference = bhVar.f147801e;
        if (weakReference == null || (onMyLocationChangeListener = weakReference.get()) == null) {
            return;
        }
        onMyLocationChangeListener.onMyLocationChange(location);
    }

    private void a(MyLocationStyle myLocationStyle, Location location) {
        if (location == null || myLocationStyle == null) {
            return;
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        Circle circle = this.f147800d;
        if (circle != null) {
            circle.setCenter(latLng);
            this.f147800d.setRadius(LocationMonitor.getAccuracy(location));
        }
        this.f147806j.a(GeoPoint.from(latLng), 0.0f, 0.0f, false);
        int myLocationType = myLocationStyle.getMyLocationType();
        if (myLocationType == 1) {
            this.f147806j.a(location.getBearing());
            return;
        }
        if (myLocationType != 2) {
            if (myLocationType != 3) {
                this.f147806j.a(location.getBearing());
                ab abVar = this.f147797a;
                if (abVar != null) {
                    abVar.a(CameraUpdateFactory.newLatLng(latLng));
                    return;
                }
                return;
            }
            ab abVar2 = this.f147797a;
            if (abVar2 != null) {
                this.f147797a.a(CameraUpdateFactory.rotateTo(location.getBearing(), abVar2.a().tilt));
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.aj
    public final void a(MyLocationStyle myLocationStyle) {
        BitmapDescriptor compassImage;
        Bitmap bitmap;
        if (myLocationStyle == null) {
            return;
        }
        this.f147804h = myLocationStyle;
        Circle circle = this.f147800d;
        if (circle != null) {
            circle.setFillColor(myLocationStyle.getFillColor());
            this.f147800d.setStrokeColor(myLocationStyle.getStrokeColor());
            this.f147800d.setStrokeWidth(myLocationStyle.getStrokeWidth());
        }
        LogUtil.b(ky.f149120z, "mMyLocationId " + this.f147813r + " mIcon " + this.f147811p);
        if (this.f147813r == 0 || this.f147811p == null) {
            return;
        }
        BitmapDescriptor myLocationIcon = myLocationStyle.getMyLocationIcon();
        if (myLocationIcon == null) {
            myLocationIcon = f();
        }
        Bitmap bitmap2 = myLocationIcon.getBitmap(this.f147806j.getContext());
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            String bitmapId = myLocationIcon.getFormater().getBitmapId();
            if (!this.f147811p.getFormater().getBitmapId().equals(bitmapId)) {
                this.f147811p = myLocationStyle.getMyLocationIcon();
                this.f147813r = this.f147806j.a(bitmapId, myLocationStyle.getAnchorU(), myLocationStyle.getAnchorV());
            }
        }
        LocationCompass locationCompass = myLocationStyle.getLocationCompass();
        if (locationCompass != null && locationCompass.getCompassImage() != null && (bitmap = (compassImage = locationCompass.getCompassImage()).getBitmap(this.f147806j.getContext())) != null && !bitmap.isRecycled()) {
            String bitmapId2 = compassImage.getFormater().getBitmapId();
            BitmapDescriptor bitmapDescriptor = this.f147812q;
            if (!(bitmapDescriptor != null ? bitmapDescriptor.getFormater().getBitmapId() : "").equals(bitmapId2)) {
                this.f147812q = compassImage;
                this.f147806j.c(bitmapId2);
            }
            BitmapDescriptor[] compassGroupImages = locationCompass.getCompassGroupImages();
            if (compassGroupImages != null && compassGroupImages.length == 4) {
                String[] strArr = new String[compassGroupImages.length];
                for (int i3 = 0; i3 < compassGroupImages.length; i3++) {
                    BitmapDescriptor bitmapDescriptor2 = compassGroupImages[i3];
                    if (bitmapDescriptor2 != null) {
                        bitmapDescriptor2.getBitmap(this.f147806j.getContext());
                        strArr[i3] = compassGroupImages[i3].getFormater().getBitmapId();
                    } else {
                        strArr[i3] = "";
                    }
                }
                this.f147806j.a(bitmapId2, strArr[0], strArr[1], strArr[2], strArr[3]);
            }
        }
        LocationNavigationGravityline locationNavigationGravityline = myLocationStyle.getLocationNavigationGravityline();
        if (locationNavigationGravityline != null) {
            this.f147806j.a(locationNavigationGravityline.getWidth(), locationNavigationGravityline.getColor(), locationNavigationGravityline.getDestination());
        }
    }

    private void a(TencentMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        if (onMyLocationChangeListener == null) {
            return;
        }
        this.f147801e = new WeakReference<>(onMyLocationChangeListener);
    }

    private boolean a(float f16, float f17) {
        WeakReference<TencentMap.OnMyLocationClickListener> weakReference;
        TencentMap.OnMyLocationClickListener onMyLocationClickListener;
        TappedElement a16 = this.f147806j.f149400m.f147877a.g().a(f16, f17);
        boolean z16 = a16 != null && a16.type == 6;
        if (!z16 || (weakReference = this.f147802f) == null || (onMyLocationClickListener = weakReference.get()) == null) {
            return z16;
        }
        LatLng latLng = new LatLng();
        Location location = this.f147805i;
        if (location != null) {
            latLng.setAltitude(location.getAltitude());
            latLng.setLongitude(this.f147805i.getLongitude());
            latLng.setLatitude(this.f147805i.getLatitude());
        }
        return onMyLocationClickListener.onMyLocationClicked(latLng);
    }

    private void a(TencentMap.OnMyLocationClickListener onMyLocationClickListener) {
        if (onMyLocationClickListener == null) {
            return;
        }
        this.f147802f = new WeakReference<>(onMyLocationClickListener);
    }

    private void a(LocationRegion.LocationRegionChangedListener locationRegionChangedListener) {
        if (locationRegionChangedListener != null) {
            this.f147803g.add(new WeakReference<>(locationRegionChangedListener));
        }
    }
}
