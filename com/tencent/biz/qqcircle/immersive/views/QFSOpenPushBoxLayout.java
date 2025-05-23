package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class QFSOpenPushBoxLayout extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private static final int f90406f = 2131240666;

    /* renamed from: h, reason: collision with root package name */
    private static final int f90407h = 2131240667;

    /* renamed from: i, reason: collision with root package name */
    private static final int f90408i = 2131240665;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f90409d;

    /* renamed from: e, reason: collision with root package name */
    private a f90410e;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public QFSOpenPushBoxLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        ImageView imageView = new ImageView(context);
        this.f90409d = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f90409d.setImageResource(f90406f);
        this.f90409d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f90409d);
    }

    public void setOpenPushBoxResponseListener(a aVar) {
        this.f90410e = aVar;
    }

    public void setPushBoxOpened() {
        ImageView imageView = this.f90409d;
        if (imageView != null) {
            imageView.setImageResource(f90408i);
        }
    }

    public void setPushBoxUnOpened(boolean z16) {
        ImageView imageView = this.f90409d;
        if (imageView != null) {
            if (z16) {
                imageView.setImageResource(f90407h);
            } else {
                imageView.setImageResource(f90406f);
            }
        }
    }

    public QFSOpenPushBoxLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSOpenPushBoxLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }
}
