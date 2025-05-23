package com.tencent.gdtad.splash.view;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtSplashAdViewBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final int f109460d = Color.rgb(240, 240, 240);

    /* renamed from: e, reason: collision with root package name */
    private static final int f109461e = Color.argb(77, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private TextView f109462a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f109463b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f109464c;

    public GdtSplashAdViewBuilder() {
        i();
    }

    private void g() {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            QLog.e("GdtSplashAdViewBuilder", 1, "[initWifiView] context is null");
            return;
        }
        ImageView imageView = new ImageView(context);
        this.f109463b = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = a.c(57.0f, context.getResources());
        layoutParams.leftMargin = a.c(16.0f, context.getResources());
        layoutParams.height = a.c(32.0f, context.getResources());
        layoutParams.gravity = 8388659;
        this.f109463b.setLayoutParams(layoutParams);
    }

    private void h() {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            QLog.e("GdtSplashAdViewBuilder", 1, "[initWifiView] context is null");
            return;
        }
        TextView textView = new TextView(context);
        this.f109462a = textView;
        textView.setText("\u8df3\u8fc7");
        this.f109462a.setWidth(a.c(49.0f, context.getResources()));
        this.f109462a.setHeight(a.c(32.0f, context.getResources()));
        this.f109462a.setGravity(17);
        this.f109462a.setTextColor(f109460d);
        this.f109462a.setTextSize(14.0f);
        this.f109462a.setBackgroundColor(-16777216);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(a.c(6.0f, context.getResources()));
        gradientDrawable.setColor(f109461e);
        this.f109462a.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = a.c(12.0f, context.getResources());
        layoutParams.topMargin = a.c(54.0f, context.getResources());
        layoutParams.rightMargin = a.c(10.0f, context.getResources());
        layoutParams.gravity = 8388661;
        this.f109462a.setLayoutParams(layoutParams);
    }

    private void i() {
        h();
        g();
    }

    public void d() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.view.GdtSplashAdViewBuilder.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BaseApplication context = BaseApplication.getContext();
                    if (context == null) {
                        QLog.e("GdtSplashAdViewBuilder", 1, "[decodeLogoBitmapAsync] context is null");
                        return;
                    }
                    GdtSplashAdViewBuilder.this.f109464c = a.a(context, "gdt_splash_qq_logo.png", a.c(64.0f, context.getResources()), a.c(26.0f, context.getResources()));
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gdtad.splash.view.GdtSplashAdViewBuilder.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GdtSplashAdViewBuilder.this.f109463b != null && GdtSplashAdViewBuilder.this.f109464c != null) {
                                GdtSplashAdViewBuilder.this.f109463b.setImageBitmap(GdtSplashAdViewBuilder.this.f109464c);
                            }
                        }
                    });
                    QLog.i("GdtSplashAdViewBuilder", 1, "finish to set entry static image");
                } catch (Throwable th5) {
                    QLog.e("GdtSplashAdViewBuilder", 1, th5, new Object[0]);
                }
            }
        }, 64, null, true);
    }

    public ImageView e() {
        return this.f109463b;
    }

    public TextView f() {
        return this.f109462a;
    }
}
