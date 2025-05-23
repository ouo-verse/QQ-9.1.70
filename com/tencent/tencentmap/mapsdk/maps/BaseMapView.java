package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MapKernel;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class BaseMapView extends FrameLayout {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface MapViewProxy {
        TencentMap getMap();

        boolean isOpaque();

        boolean isTouchable();

        void onCreated();

        void onDestroy();

        void onPause();

        void onRestart();

        void onResume();

        void onSizeChanged(int i3, int i16, int i17, int i18);

        void onStart();

        void onStop();

        void onSurfaceChanged(Object obj, int i3, int i16);

        boolean onTouchEvent(MotionEvent motionEvent);

        void onUpdateOptions(TencentMapOptions tencentMapOptions);

        void setOnTop(boolean z16);

        void setOpaque(boolean z16);
    }

    public BaseMapView(@NonNull Context context) {
        super(context);
    }

    public abstract TencentMap getMap();

    public abstract TencentMap getMap(TencentMapOptions tencentMapOptions);

    /* JADX INFO: Access modifiers changed from: protected */
    public TencentMapOptions.IMapKernel getMapKernel() {
        return MapKernel.Vector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MapViewType getViewType() {
        return MapViewType.SurfaceView;
    }

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onRestart();

    public abstract void onResume();

    public abstract void onStart();

    public abstract void onStop();

    public BaseMapView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseMapView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
