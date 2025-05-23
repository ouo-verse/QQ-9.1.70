package com.tencent.tencentmap.mapsdk.maps;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ky;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes26.dex */
public final class CustomLocationProvider {
    public static final String NAME = "_CustomAutoLocationProvider";
    private static CustomLocationProvider sGlobalLocationProvider;
    private Location thisLatestLocation;
    private WeakReference<MyLocationSource> thisMyLocationSourceWeakReference;
    private final List<WeakReference<a>> thisWeakRefLocationObservers = new ArrayList();
    private Handler thisRequestHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes26.dex */
    public interface MyLocationSource {
        Location getMyLocation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public interface a {
        void a(Location location);
    }

    /* loaded from: classes26.dex */
    static class b implements a, LocationSource {

        /* renamed from: a, reason: collision with root package name */
        LocationSource.OnLocationChangedListener f375359a;

        /* renamed from: b, reason: collision with root package name */
        private final CustomLocationProvider f375360b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f375361c = new Handler(Looper.getMainLooper());

        public b(CustomLocationProvider customLocationProvider) {
            this.f375360b = customLocationProvider;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.CustomLocationProvider.a
        public final void a(final Location location) {
            final LocationSource.OnLocationChangedListener onLocationChangedListener;
            if (location != null && (onLocationChangedListener = this.f375359a) != null) {
                this.f375361c.post(new Runnable() { // from class: com.tencent.tencentmap.mapsdk.maps.CustomLocationProvider.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        location.setProvider(location.getProvider() + CustomLocationProvider.NAME);
                        onLocationChangedListener.onLocationChanged(location);
                    }
                });
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.LocationSource
        public final void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
            this.f375359a = onLocationChangedListener;
            this.f375360b.addLocationObserver(this);
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.LocationSource
        public final void deactivate() {
            this.f375360b.removeLocationObserver(this);
            this.f375359a = null;
        }
    }

    CustomLocationProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocationObserver(a aVar) {
        if (aVar == null) {
            return;
        }
        this.thisWeakRefLocationObservers.add(new WeakReference<>(aVar));
        Location location = this.thisLatestLocation;
        if (location != null) {
            aVar.a(location);
        }
    }

    public static CustomLocationProvider getInstance() {
        if (sGlobalLocationProvider == null) {
            sGlobalLocationProvider = new CustomLocationProvider();
        }
        return sGlobalLocationProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLocationObserver(a aVar) {
        if (aVar == null) {
            return;
        }
        Iterator<WeakReference<a>> it = this.thisWeakRefLocationObservers.iterator();
        while (it.hasNext()) {
            if (it.next().get() == aVar) {
                it.remove();
            }
        }
    }

    public final synchronized void clearLocation() {
        this.thisLatestLocation = null;
    }

    public final synchronized Location getLatestLocation() {
        return this.thisLatestLocation;
    }

    public final LocationSource getLocationSource() {
        return new b(this);
    }

    public final synchronized boolean hasLocation() {
        if (this.thisLatestLocation != null) {
            return true;
        }
        return false;
    }

    public final boolean hasLocationSource() {
        WeakReference<MyLocationSource> weakReference = this.thisMyLocationSourceWeakReference;
        if (weakReference != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }

    public final void requestLatestLocation() {
        if (this.thisMyLocationSourceWeakReference != null) {
            LogUtil.c(ky.f149120z, "requestLatestLocation");
            final MyLocationSource myLocationSource = this.thisMyLocationSourceWeakReference.get();
            if (myLocationSource != null) {
                this.thisRequestHandler.post(new Runnable() { // from class: com.tencent.tencentmap.mapsdk.maps.CustomLocationProvider.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CustomLocationProvider.this.thisLatestLocation = myLocationSource.getMyLocation();
                        Iterator it = CustomLocationProvider.this.thisWeakRefLocationObservers.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) ((WeakReference) it.next()).get();
                            if (aVar != null) {
                                aVar.a(CustomLocationProvider.this.thisLatestLocation);
                            }
                        }
                    }
                });
            }
        }
    }

    public final void setMyLocationSource(MyLocationSource myLocationSource) {
        setMyLocationSource(null, myLocationSource);
    }

    public final void setMyLocationSource(Handler handler, MyLocationSource myLocationSource) {
        LogUtil.c(ky.f149120z, "setMyLocationSource");
        if (handler != null) {
            this.thisRequestHandler = handler;
        }
        this.thisMyLocationSourceWeakReference = new WeakReference<>(myLocationSource);
    }
}
