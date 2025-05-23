package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

/* compiled from: P */
/* loaded from: classes9.dex */
public class nv extends GroundOverlayInfo implements ni {

    /* renamed from: a, reason: collision with root package name */
    GroundOverlayOptions f149474a;

    public nv(Context context, GroundOverlayOptions groundOverlayOptions) {
        if (groundOverlayOptions == null) {
            return;
        }
        this.f149474a = groundOverlayOptions;
        BitmapDescriptor bitmap = groundOverlayOptions.getBitmap();
        if (bitmap != null) {
            Bitmap bitmap2 = bitmap.getBitmap(context);
            if (bitmap2 != null) {
                this.mBitmapWidth = bitmap2.getWidth();
                this.mBitmapHeight = bitmap2.getHeight();
            }
            this.mBitmap = bitmap2;
        }
        this.mAlpha = groundOverlayOptions.getAlpha();
        this.mVisibility = groundOverlayOptions.isVisible();
        this.mLevel = groundOverlayOptions.getLevel();
        this.mZIndex = groundOverlayOptions.getZIndex();
        if (groundOverlayOptions.getPosition() != null) {
            a();
        }
        if (groundOverlayOptions.getLatLngBounds() != null) {
            LatLngBounds latLngBounds = groundOverlayOptions.getLatLngBounds();
            Parcel obtain = Parcel.obtain();
            obtain.writeParcelable(latLngBounds, 0);
            obtain.setDataPosition(0);
            Parcelable readParcelable = obtain.readParcelable(latLngBounds.getClass().getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            this.mLatLngBounds = (LatLngBounds) readParcelable;
        }
    }

    private GroundOverlayOptions b() {
        return this.f149474a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.f149474a.getPosition() == null) {
            return;
        }
        float max = Math.max(0.0f, Math.min(1.0f, this.f149474a.getAnchorU()));
        float max2 = Math.max(0.0f, Math.min(1.0f, this.f149474a.getAnchorV()));
        double pow = Math.pow(2.0d, 20.0f - Math.max(3.0f, Math.min(22.0f, this.f149474a.getZoom())));
        gi giVar = new gi(2.68435456E8d);
        fw d16 = giVar.d(this.f149474a.getPosition());
        this.mLatLngBounds = LatLngBounds.builder().include(giVar.b(new fw(d16.f148383a - ((this.mBitmapWidth * max) * pow), d16.f148384b - ((this.mBitmapHeight * max2) * pow)))).include(giVar.b(new fw(d16.f148383a + (this.mBitmapWidth * (1.0d - max) * pow), d16.f148384b + (this.mBitmapHeight * (1.0d - max2) * pow)))).build();
    }
}
