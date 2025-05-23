package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes6.dex */
final class e extends URLImageView {

    /* renamed from: d, reason: collision with root package name */
    private Path f108533d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f108534e;

    /* renamed from: f, reason: collision with root package name */
    private int f108535f;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f108536a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f108537b;

        a(int i3, int i16) {
            this.f108536a = i3;
            this.f108537b = i16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, this.f108536a, this.f108537b, e.this.f108535f);
        }
    }

    public e(Context context) {
        super(context);
        this.f108533d = new Path();
        this.f108534e = new RectF();
    }

    public void d(int i3) {
        this.f108535f = i3;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        setClipToOutline(true);
        setOutlineProvider(new a(width, height));
        super.dispatchDraw(canvas);
    }
}
