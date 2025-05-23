package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TextureMapView extends MapView {
    public TextureMapView(Context context) {
        this(context, (TencentMapOptions) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public final MapViewType getViewType() {
        return MapViewType.TextureView;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            return mapViewProxy.isOpaque();
        }
        return true;
    }

    public void setOpaque(boolean z16) {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.setOpaque(z16);
        }
    }

    public TextureMapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, TencentMapOptions tencentMapOptions) {
        this(context, attributeSet, 0, tencentMapOptions);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i3, TencentMapOptions tencentMapOptions) {
        super(context, attributeSet, i3, tencentMapOptions);
    }
}
