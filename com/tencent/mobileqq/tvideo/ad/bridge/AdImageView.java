package com.tencent.mobileqq.tvideo.ad.bridge;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import tv2.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AdImageView extends ImageView implements a {
    public AdImageView(Context context) {
        super(context);
    }

    private int b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Color.parseColor(str.trim());
            }
            return -1;
        } catch (Exception e16) {
            QLog.e("ColorError", 1, e16.getMessage());
            return -1;
        }
    }

    @Override // tv2.a
    public void a(String str, int i3) {
        c(str, ImageView.ScaleType.FIT_XY, i3);
    }

    public void c(String str, ImageView.ScaleType scaleType, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setScaleType(scaleType);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setTargetView(this));
    }

    @Override // tv2.a
    public void setImageColor(String str) {
        int b16 = b(str);
        Drawable drawable = getDrawable();
        if (b16 != -1) {
            if (drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(b16, PorterDuff.Mode.SRC_ATOP);
                return;
            }
            return;
        }
        if (drawable != null) {
            drawable.mutate();
            drawable.clearColorFilter();
        }
    }

    public AdImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setId(0);
    }

    @Override // tv2.a
    public void setCornersRadius(float f16) {
    }
}
