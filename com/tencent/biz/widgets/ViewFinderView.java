package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.CellDynamicAlbum;
import com.tencent.mobileqq.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class ViewFinderView extends View {
    boolean C;
    long D;
    protected int E;
    protected int F;
    protected double G;

    /* renamed from: d, reason: collision with root package name */
    Drawable f97746d;

    /* renamed from: e, reason: collision with root package name */
    Drawable f97747e;

    /* renamed from: f, reason: collision with root package name */
    Paint f97748f;

    /* renamed from: h, reason: collision with root package name */
    Rect f97749h;

    /* renamed from: i, reason: collision with root package name */
    int f97750i;

    /* renamed from: m, reason: collision with root package name */
    int f97751m;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.widgets.ViewFinderView$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f97752d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f97753e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f97754f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f97755h;
        final /* synthetic */ ViewFinderView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.invalidate(this.f97752d, this.f97753e, this.f97754f, this.f97755h);
        }
    }

    public ViewFinderView(Context context) {
        super(context);
        this.f97750i = 0;
        this.f97751m = 0;
        this.C = false;
        this.f97746d = getResources().getDrawable(R.drawable.duv);
        Drawable drawable = getResources().getDrawable(R.drawable.dv9);
        this.f97747e = drawable;
        this.F = drawable.getIntrinsicHeight();
        Paint paint = new Paint(1);
        this.f97748f = paint;
        paint.setColor(CellDynamicAlbum.sBtnBackgroundColor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i3, int i16, int i17, int i18) {
        Rect rect = new Rect(i3, i16, i17, i18);
        this.f97746d.setBounds(rect);
        int i19 = (i18 - i16) - this.F;
        this.E = i19;
        this.G = i19 / 5000.0d;
        this.f97749h = rect;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (!this.C) {
            this.D = System.currentTimeMillis();
            this.C = true;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.C = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Rect rect = this.f97749h;
        if (rect != null && rect.width() != 0 && rect.height() != 0) {
            canvas.drawRect(0.0f, 0.0f, this.f97750i, rect.top, this.f97748f);
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.f97748f);
            canvas.drawRect(rect.right, rect.top, this.f97750i, rect.bottom, this.f97748f);
            canvas.drawRect(0.0f, rect.bottom, this.f97750i, this.f97751m, this.f97748f);
            this.f97746d.draw(canvas);
            if (this.C) {
                int currentTimeMillis = ((int) ((System.currentTimeMillis() - this.D) * this.G)) % this.E;
                Drawable drawable = this.f97747e;
                int i3 = rect.left;
                int i16 = rect.top;
                drawable.setBounds(i3, i16 + currentTimeMillis, rect.right, i16 + currentTimeMillis + this.F);
                this.f97747e.draw(canvas);
                postInvalidateDelayed(20L, rect.left, rect.top, rect.right, rect.bottom);
                return;
            }
            return;
        }
        canvas.drawRect(0.0f, 0.0f, this.f97750i, this.f97751m, this.f97748f);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.f97750i = i3;
        this.f97751m = i16;
        invalidate();
    }

    @Override // android.view.View
    public void postInvalidateDelayed(long j3, int i3, int i16, int i17, int i18) {
        super.postInvalidateDelayed(j3, i3, i16, i17, i18);
    }
}
