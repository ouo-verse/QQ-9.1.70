package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MapRenderLayer extends MapView {
    public MapRenderLayer(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public final MapViewType getViewType() {
        return MapViewType.RenderLayer;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.MapView
    public final void onSurfaceChanged(Object obj, int i3, int i16) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture) && !(obj instanceof SurfaceHolder)) {
            return;
        }
        super.onSurfaceChanged(obj, i3, i16);
    }
}
