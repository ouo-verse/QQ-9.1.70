package com.tencent.luggage.wxa.i8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.tencent.luggage.wxa.a8.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends ConstraintLayout implements i {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f129500a;

    /* renamed from: b, reason: collision with root package name */
    public final TextureView f129501b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f129502c;

    public c(Context context) {
        this(context, null);
    }

    @Override // com.tencent.luggage.wxa.a8.i
    public Bitmap getBitmap() {
        return this.f129501b.getBitmap();
    }

    @Override // com.tencent.luggage.wxa.a8.i
    @Nullable
    public SurfaceTexture getSurfaceTexture() {
        return this.f129501b.getSurfaceTexture();
    }

    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return this.f129501b.getSurfaceTextureListener();
    }

    @Override // com.tencent.luggage.wxa.a8.i
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.f129502c.setImageBitmap(bitmap);
            this.f129502c.setVisibility(0);
        } else {
            this.f129502c.setVisibility(4);
        }
    }

    @Override // com.tencent.luggage.wxa.a8.i
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.f129501b.setSurfaceTextureListener(surfaceTextureListener);
    }

    @MainThread
    public void setTextureViewHeightWeight(float f16) {
        w.d("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewHeightWeight, heightWeight: " + f16);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f129500a.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
        layoutParams.matchConstraintPercentHeight = f16;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        this.f129500a.setLayoutParams(layoutParams);
    }

    @MainThread
    public void setTextureViewWidthWeight(float f16) {
        w.d("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewWidthWeight, widthWeight: " + f16);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f129500a.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
        layoutParams.matchConstraintPercentWidth = f16;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        this.f129500a.setLayoutParams(layoutParams);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setId(R.id.f164363ss0);
        setBackgroundColor(-16777216);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f129500a = frameLayout;
        addView(frameLayout, -1, -1);
        frameLayout.setId(R.id.srz);
        TextureView textureView = new TextureView(context);
        this.f129501b = textureView;
        frameLayout.addView(textureView, -1, -1);
        ImageView imageView = new ImageView(context);
        this.f129502c = imageView;
        frameLayout.addView(imageView, -1, -1);
        imageView.setVisibility(4);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        constraintSet.connect(R.id.srz, 3, R.id.f164363ss0, 3, 0);
        constraintSet.connect(R.id.srz, 4, R.id.f164363ss0, 4, 0);
        constraintSet.connect(R.id.srz, 1, R.id.f164363ss0, 1, 0);
        constraintSet.connect(R.id.srz, 2, R.id.f164363ss0, 2, 0);
        constraintSet.applyTo(this);
    }
}
