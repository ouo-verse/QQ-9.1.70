package com.tencent.map.lib.models;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class GroundOverlayInfo {
    protected Bitmap mBitmap;
    protected int mBitmapHeight;
    protected int mBitmapWidth;
    protected LatLngBounds mLatLngBounds;
    protected int mZIndex;
    protected float mAlpha = 1.0f;
    protected boolean mVisibility = true;
    protected int mLevel = 1;

    public boolean checkValid() {
        if (this.mBitmap != null) {
            return true;
        }
        return false;
    }

    public void setAlpha(float f16) {
        this.mAlpha = f16;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        if (bitmap != null) {
            this.mBitmapWidth = bitmap.getWidth();
            this.mBitmapHeight = bitmap.getHeight();
        }
    }

    public void setLatLngBounds(LatLngBounds latLngBounds) {
        this.mLatLngBounds = latLngBounds;
    }

    public void setLevel(int i3) {
        this.mLevel = i3;
    }

    public void setVisibility(boolean z16) {
        this.mVisibility = z16;
    }

    public void setZIndex(int i3) {
        this.mZIndex = i3;
    }
}
