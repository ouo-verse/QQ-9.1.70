package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

/* compiled from: P */
/* loaded from: classes.dex */
public class NetworkImageView extends ImageView {

    @Nullable
    private Bitmap C;
    private ImageLoader D;
    private ImageLoader.e E;

    /* renamed from: d, reason: collision with root package name */
    private String f31383d;

    /* renamed from: e, reason: collision with root package name */
    private int f31384e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Drawable f31385f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private Bitmap f31386h;

    /* renamed from: i, reason: collision with root package name */
    private int f31387i;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private Drawable f31388m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.android.volley.toolbox.NetworkImageView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ImageLoader.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f31389a;

        AnonymousClass1(boolean z16) {
            this.f31389a = z16;
        }

        @Override // com.android.volley.toolbox.ImageLoader.f
        public void a(final ImageLoader.e eVar, boolean z16) {
            if (z16 && this.f31389a) {
                NetworkImageView.this.post(new Runnable() { // from class: com.android.volley.toolbox.NetworkImageView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.a(eVar, false);
                    }
                });
                return;
            }
            if (eVar.d() != null) {
                NetworkImageView.this.setImageBitmap(eVar.d());
                return;
            }
            if (NetworkImageView.this.f31384e != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f31384e);
            } else if (NetworkImageView.this.f31385f != null) {
                NetworkImageView networkImageView2 = NetworkImageView.this;
                networkImageView2.setImageDrawable(networkImageView2.f31385f);
            } else if (NetworkImageView.this.f31386h != null) {
                NetworkImageView networkImageView3 = NetworkImageView.this;
                networkImageView3.setImageBitmap(networkImageView3.f31386h);
            }
        }

        @Override // com.android.volley.h.a
        public void onErrorResponse(VolleyError volleyError) {
            if (NetworkImageView.this.f31387i != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f31387i);
            } else if (NetworkImageView.this.f31388m != null) {
                NetworkImageView networkImageView2 = NetworkImageView.this;
                networkImageView2.setImageDrawable(networkImageView2.f31388m);
            } else if (NetworkImageView.this.C != null) {
                NetworkImageView networkImageView3 = NetworkImageView.this;
                networkImageView3.setImageBitmap(networkImageView3.C);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    private void h() {
        int i3 = this.f31384e;
        if (i3 != 0) {
            setImageResource(i3);
            return;
        }
        Drawable drawable = this.f31385f;
        if (drawable != null) {
            setImageDrawable(drawable);
            return;
        }
        Bitmap bitmap = this.f31386h;
        if (bitmap != null) {
            setImageBitmap(bitmap);
        } else {
            setImageBitmap(null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    void g(boolean z16) {
        boolean z17;
        boolean z18;
        int i3;
        int width = getWidth();
        int height = getHeight();
        ImageView.ScaleType scaleType = getScaleType();
        boolean z19 = true;
        if (getLayoutParams() != null) {
            if (getLayoutParams().width == -2) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (getLayoutParams().height == -2) {
                z18 = true;
            } else {
                z18 = false;
            }
        } else {
            z17 = false;
            z18 = false;
        }
        if (!z17 || !z18) {
            z19 = false;
        }
        if (width == 0 && height == 0 && !z19) {
            return;
        }
        if (TextUtils.isEmpty(this.f31383d)) {
            ImageLoader.e eVar = this.E;
            if (eVar != null) {
                eVar.c();
                this.E = null;
            }
            h();
            return;
        }
        ImageLoader.e eVar2 = this.E;
        if (eVar2 != null && eVar2.e() != null) {
            if (this.E.e().equals(this.f31383d)) {
                return;
            }
            this.E.c();
            h();
        }
        if (z17) {
            width = 0;
        }
        if (z18) {
            i3 = 0;
        } else {
            i3 = height;
        }
        this.E = this.D.e(this.f31383d, new AnonymousClass1(z16), width, i3, scaleType);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        ImageLoader.e eVar = this.E;
        if (eVar != null) {
            eVar.c();
            setImageBitmap(null);
            this.E = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        g(true);
    }

    public void setDefaultImageBitmap(Bitmap bitmap) {
        this.f31384e = 0;
        this.f31385f = null;
        this.f31386h = bitmap;
    }

    public void setDefaultImageDrawable(@Nullable Drawable drawable) {
        this.f31384e = 0;
        this.f31386h = null;
        this.f31385f = drawable;
    }

    public void setDefaultImageResId(int i3) {
        this.f31386h = null;
        this.f31385f = null;
        this.f31384e = i3;
    }

    public void setErrorImageBitmap(Bitmap bitmap) {
        this.f31387i = 0;
        this.f31388m = null;
        this.C = bitmap;
    }

    public void setErrorImageDrawable(@Nullable Drawable drawable) {
        this.f31387i = 0;
        this.C = null;
        this.f31388m = drawable;
    }

    public void setErrorImageResId(int i3) {
        this.C = null;
        this.f31388m = null;
        this.f31387i = i3;
    }

    @MainThread
    public void setImageUrl(String str, ImageLoader imageLoader) {
        l.a();
        this.f31383d = str;
        this.D = imageLoader;
        g(false);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
