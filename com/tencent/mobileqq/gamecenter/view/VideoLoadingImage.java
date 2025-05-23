package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes12.dex */
public class VideoLoadingImage extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private int f213495d;

    public VideoLoadingImage(Context context) {
        super(context);
        this.f213495d = 1;
    }

    private void a(boolean z16, int i3) {
        FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(R.id.efi);
        if (frameLayout != null && z16) {
            frameLayout.setBackgroundColor(i3);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i3 = this.f213495d;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    setVisibility(8);
                    return;
                }
                return;
            } else {
                setImageDrawable(getResources().getDrawable(R.drawable.common_loading5));
                setScaleType(ImageView.ScaleType.CENTER);
                a(true, -16777216);
                return;
            }
        }
        setImageDrawable(new a(getResources()));
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        a(false, 0);
    }

    public void setStyle(int i3) {
        this.f213495d = i3;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        int i16 = this.f213495d;
        if (2 == i16) {
            FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(R.id.efi);
            if (frameLayout != null) {
                frameLayout.setVisibility(i3);
                return;
            }
            return;
        }
        if (3 == i16) {
            super.setVisibility(8);
        }
    }

    public VideoLoadingImage(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f213495d = 1;
    }

    public VideoLoadingImage(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f213495d = 1;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private static class a extends Drawable {

        /* renamed from: a, reason: collision with root package name */
        private Bitmap f213496a;

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f213497b;

        /* renamed from: c, reason: collision with root package name */
        private int f213498c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f213499d = 0;

        /* renamed from: e, reason: collision with root package name */
        private float f213500e = 0.0f;

        /* renamed from: f, reason: collision with root package name */
        private Rect f213501f = new Rect();

        /* renamed from: g, reason: collision with root package name */
        private Rect f213502g = new Rect();

        /* renamed from: h, reason: collision with root package name */
        private Rect f213503h = new Rect();

        /* renamed from: i, reason: collision with root package name */
        private Rect f213504i = new Rect();

        a(@NonNull Resources resources) {
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.cnh);
            this.f213496a = decodeResource;
            if (decodeResource != null) {
                this.f213501f.set(0, 0, decodeResource.getWidth(), this.f213496a.getHeight());
            }
            Bitmap decodeResource2 = BitmapFactory.decodeResource(resources, R.drawable.cni);
            this.f213497b = decodeResource2;
            if (decodeResource2 != null) {
                this.f213502g.set(0, 0, decodeResource2.getWidth(), this.f213497b.getHeight());
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (this.f213496a != null && this.f213497b != null) {
                this.f213500e += 2.5f;
                canvas.save();
                canvas.rotate(this.f213500e, this.f213499d >> 1, this.f213498c >> 1);
                canvas.drawBitmap(this.f213496a, this.f213501f, this.f213503h, (Paint) null);
                canvas.restore();
                canvas.rotate(-this.f213500e, this.f213499d >> 1, this.f213498c >> 1);
                canvas.drawBitmap(this.f213497b, this.f213502g, this.f213504i, (Paint) null);
                Drawable.Callback callback = getCallback();
                if (callback != null) {
                    callback.invalidateDrawable(this);
                }
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            this.f213499d = rect.width();
            int height = rect.height();
            this.f213498c = height;
            this.f213503h.set(0, 0, this.f213499d, height);
            Rect rect2 = this.f213504i;
            int i3 = this.f213499d;
            int i16 = this.f213498c;
            rect2.set(i3 >> 2, i16 >> 2, (i3 * 3) / 4, (i16 * 3) / 4);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@androidx.annotation.Nullable ColorFilter colorFilter) {
        }
    }
}
