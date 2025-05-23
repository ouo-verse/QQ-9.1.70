package com.tencent.mobileqq.widget.mapview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QMapView extends MapView {
    public QMapView(@NonNull Context context) {
        this(context, (TencentMapOptions) null);
    }

    private void init() {
        if (TencentMapInitializer.getAgreePrivacy()) {
            return;
        }
        TencentMapInitializer.setAgreePrivacy(true);
    }

    public QMapView(@NonNull Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        init();
    }

    public QMapView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this(context, attributeSet, 0, null);
    }

    public QMapView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null);
    }

    public QMapView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i3, TencentMapOptions tencentMapOptions) {
        super(context, attributeSet, i3, tencentMapOptions);
        init();
    }
}
