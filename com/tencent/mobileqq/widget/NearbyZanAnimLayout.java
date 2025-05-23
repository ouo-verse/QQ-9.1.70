package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NearbyZanAnimLayout extends HeartLayout {
    public NearbyZanAnimLayout(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.hotchat.anim.HeartLayout
    public void d(Bitmap bitmap, float f16, float f17) {
        if (this.f236902m && this.f236900h != null && bitmap != null) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f236900h.g(imageView, f16, f17, this);
        }
    }

    @Override // com.tencent.mobileqq.hotchat.anim.HeartLayout
    public void l() {
        this.H = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 5;
        this.f236901i = new Random(System.currentTimeMillis());
        v vVar = new v(this);
        this.f236900h = vVar;
        vVar.e(this);
    }

    public NearbyZanAnimLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NearbyZanAnimLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
