package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable.RoundedDrawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class NativeButtonImp extends NativeTextImp {
    private static final String TAG = "NativeButtonImp";

    public NativeButtonImp(Context context) {
        super(context);
        setGravity(17);
    }

    private void updateAttrs(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof RoundedDrawable) {
            RoundedDrawable roundedDrawable = (RoundedDrawable) drawable;
            roundedDrawable.setScaleType(ImageView.ScaleType.FIT_XY).setBorderWidth(this.mBorderWidth).setBorderColor(this.mBorderColor);
            roundedDrawable.setCornerRadius(100.0f, 0.0f, 0.0f, 0.0f);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i3 = 0; i3 < numberOfLayers; i3++) {
                updateAttrs(layerDrawable.getDrawable(i3));
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        updateAttrs(drawable);
        super.setBackgroundDrawable(drawable);
    }
}
