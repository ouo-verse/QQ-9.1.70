package com.tencent.mobileqq.widget.mapview;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QTextureMapView extends TextureMapView {
    public QTextureMapView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        if (TencentMapInitializer.getAgreePrivacy()) {
            return;
        }
        TencentMapInitializer.setAgreePrivacy(true);
    }

    public QTextureMapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        init();
    }

    public QTextureMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (TencentMapOptions) null);
    }

    public QTextureMapView(Context context, AttributeSet attributeSet, TencentMapOptions tencentMapOptions) {
        this(context, attributeSet, 0, tencentMapOptions);
    }

    public QTextureMapView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null);
    }

    public QTextureMapView(Context context, AttributeSet attributeSet, int i3, TencentMapOptions tencentMapOptions) {
        super(context, attributeSet, i3, tencentMapOptions);
        init();
    }
}
