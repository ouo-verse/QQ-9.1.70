package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.tencent.map.tools.Callback;
import com.tencent.mapsdk.internal.t;
import com.tencent.mapsdk.internal.tf;
import com.tencent.mapsdk.internal.u;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MapView extends BaseMapView {
    private boolean mIsResumed;
    private TencentMap mMap;
    protected BaseMapView.MapViewProxy mMapDelegate;
    private TencentMapOptions mMapOptions;

    static {
        System.loadLibrary(tf.f150434a);
    }

    public MapView(@NonNull Context context) {
        this(context, new TencentMapOptions());
    }

    private <T extends TencentMap> void getMapSync(TencentMapOptions tencentMapOptions, final Callback<T> callback) {
        tencentMapOptions.setGetMapAsync(new Callback<TencentMap>() { // from class: com.tencent.tencentmap.mapsdk.maps.MapView.2

            /* compiled from: P */
            /* renamed from: com.tencent.tencentmap.mapsdk.maps.MapView$2$1, reason: invalid class name */
            /* loaded from: classes26.dex */
            final class AnonymousClass1 implements TencentMap.OnMapLoadedCallback {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ TencentMap f375369a;

                AnonymousClass1(TencentMap tencentMap) {
                    this.f375369a = tencentMap;
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
                public final void onMapLoaded() {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.callback(this.f375369a);
                    }
                    this.f375369a.removeOnMapLoadedCallback(this);
                }
            }

            private void a(TencentMap tencentMap) {
                tencentMap.addOnMapLoadedCallback(new AnonymousClass1(tencentMap));
            }

            @Override // com.tencent.map.tools.Callback
            public final /* synthetic */ void callback(TencentMap tencentMap) {
                TencentMap tencentMap2 = tencentMap;
                tencentMap2.addOnMapLoadedCallback(new AnonymousClass1(tencentMap2));
            }
        });
        initMap(tencentMapOptions);
    }

    private void initMap(TencentMapOptions tencentMapOptions) {
        BaseMapView.MapViewProxy mapViewProxy;
        TencentMapOptions tencentMapOptions2;
        if (this.mMap != null && ((tencentMapOptions2 = this.mMapOptions) == tencentMapOptions || tencentMapOptions2.equals(tencentMapOptions))) {
            return;
        }
        if (tencentMapOptions == null) {
            tencentMapOptions = new TencentMapOptions();
        }
        if (tencentMapOptions.getMapViewType() == null) {
            tencentMapOptions.setMapViewType(getViewType());
        }
        if (tencentMapOptions.getMapKernel() == null) {
            tencentMapOptions.setMapKernel(getMapKernel());
        }
        setClickable(true);
        if (this.mMap != null && (mapViewProxy = this.mMapDelegate) != null) {
            mapViewProxy.onPause();
            this.mMapDelegate.onStop();
            this.mMapDelegate.onDestroy();
            this.mMapDelegate = null;
            this.mMap = null;
        }
        final Callback<TencentMap> mapAsyncCallback = tencentMapOptions.getMapAsyncCallback();
        if (this.mMapDelegate == null) {
            t tVar = new t(getContext().getApplicationContext());
            if (mapAsyncCallback != null) {
                new BaseThread(new u.AnonymousClass4(tVar.f150419a, tVar.a(tencentMapOptions), new Handler(Looper.getMainLooper()), new t.AnonymousClass1(this, tencentMapOptions, new Callback<BaseMapView.MapViewProxy>() { // from class: com.tencent.tencentmap.mapsdk.maps.MapView.1
                    private void a(BaseMapView.MapViewProxy mapViewProxy2) {
                        MapView.this.mMapDelegate = mapViewProxy2;
                        if (mapViewProxy2 != null) {
                            mapViewProxy2.onResume();
                            mapAsyncCallback.callback(mapViewProxy2.getMap());
                        }
                    }

                    @Override // com.tencent.map.tools.Callback
                    public final /* synthetic */ void callback(BaseMapView.MapViewProxy mapViewProxy2) {
                        BaseMapView.MapViewProxy mapViewProxy3 = mapViewProxy2;
                        MapView.this.mMapDelegate = mapViewProxy3;
                        if (mapViewProxy3 != null) {
                            mapViewProxy3.onResume();
                            mapAsyncCallback.callback(mapViewProxy3.getMap());
                        }
                    }
                })), "tms-plugin").start();
            } else {
                this.mMapDelegate = tVar.a(this, tencentMapOptions);
            }
        }
        this.mMapOptions = tencentMapOptions;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        BaseMapView.MapViewProxy mapViewProxy;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (!dispatchTouchEvent && (mapViewProxy = this.mMapDelegate) != null && mapViewProxy.isTouchable()) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.mMapOptions.isDisallowInterceptTouchEvent());
            }
            return this.mMapDelegate.onTouchEvent(motionEvent);
        }
        return dispatchTouchEvent;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public TencentMap getMap() {
        TencentMap tencentMap = this.mMap;
        return tencentMap != null ? tencentMap : getMap(this.mMapOptions);
    }

    public int[] getMapPadding() {
        return new int[]{getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()};
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onDestroy() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onDestroy();
            this.mMapDelegate = null;
        }
        this.mMapOptions = null;
        this.mMap = null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onPause() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onPause();
            this.mIsResumed = false;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onRestart() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onRestart();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onResume() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null && !this.mIsResumed) {
            mapViewProxy.onResume();
            this.mIsResumed = true;
        }
        u.a();
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onSizeChanged(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onStart() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onStart();
        }
        BaseMapView.MapViewProxy mapViewProxy2 = this.mMapDelegate;
        if (mapViewProxy2 != null && !this.mIsResumed) {
            mapViewProxy2.onResume();
            this.mIsResumed = true;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onStop() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onStop();
        }
        u.a();
    }

    public void onSurfaceChanged(Object obj, int i3, int i16) {
        BaseMapView.MapViewProxy mapViewProxy;
        if (((obj instanceof Surface) || (obj instanceof SurfaceTexture) || (obj instanceof SurfaceHolder)) && (mapViewProxy = this.mMapDelegate) != null) {
            mapViewProxy.onSurfaceChanged(obj, i3, i16);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setMapPadding(int i3, int i16, int i17, int i18) {
        setPadding(i3, i16, i17, i18);
    }

    public void setOnTop(boolean z16) {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.setOnTop(z16);
        }
    }

    public MapView(@NonNull Context context, TencentMapOptions tencentMapOptions) {
        super(context);
        this.mMap = getMap(tencentMapOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public TencentMap getMap(TencentMapOptions tencentMapOptions) {
        if (!TencentMapInitializer.getAgreePrivacy()) {
            return null;
        }
        initMap(tencentMapOptions);
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            return mapViewProxy.getMap();
        }
        return null;
    }

    public MapView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, new TencentMapOptions());
    }

    public MapView(@NonNull Context context, @Nullable AttributeSet attributeSet, TencentMapOptions tencentMapOptions) {
        this(context, attributeSet, 0, tencentMapOptions);
    }

    public MapView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, new TencentMapOptions());
    }

    public MapView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, TencentMapOptions tencentMapOptions) {
        super(context, attributeSet, i3);
        this.mMap = getMap(tencentMapOptions);
    }
}
