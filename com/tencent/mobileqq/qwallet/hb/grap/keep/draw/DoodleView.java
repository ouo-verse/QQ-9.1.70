package com.tencent.mobileqq.qwallet.hb.grap.keep.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qwallet.hb.grap.keep.draw.LineLayer;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DoodleView extends View {

    /* renamed from: d, reason: collision with root package name */
    private LineLayer f277431d;

    /* renamed from: e, reason: collision with root package name */
    private b f277432e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements LineLayer.a {
        a() {
        }

        @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.LineLayer.a
        public void a() {
            if (DoodleView.this.f277432e != null) {
                DoodleView.this.f277432e.a();
            }
        }

        @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.LineLayer.a
        public void b(int i3, int i16) {
            if (DoodleView.this.f277432e != null) {
                DoodleView.this.f277432e.b(i3, i16);
            }
        }

        @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.LineLayer.a
        public void c() {
            if (DoodleView.this.f277432e != null) {
                DoodleView.this.f277432e.c();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    interface b {
        void a();

        void b(int i3, int i16);

        void c();
    }

    public DoodleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d() {
        LineLayer lineLayer = new LineLayer(this);
        this.f277431d = lineLayer;
        lineLayer.e();
        this.f277431d.y(new a());
        this.f277431d.w(LineLayer.f277434x);
        super.requestLayout();
    }

    public void b(boolean z16) {
        LineLayer lineLayer = this.f277431d;
        if (lineLayer != null) {
            lineLayer.m(z16);
        }
        super.invalidate();
    }

    public void c(b bVar) {
        this.f277432e = bVar;
        d();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        LineLayer lineLayer = this.f277431d;
        if (lineLayer != null) {
            lineLayer.d(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        LineLayer lineLayer;
        if (i3 > 0 && i16 > 0 && (lineLayer = this.f277431d) != null) {
            lineLayer.j(i3, i16);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        LineLayer lineLayer = this.f277431d;
        if (lineLayer != null) {
            return lineLayer.c(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (isShown()) {
            super.invalidate();
        }
        if (i3 != 0) {
            LineLayer lineLayer = this.f277431d;
            if (lineLayer != null && lineLayer.q() == 0) {
                this.f277431d.m(true);
                return;
            }
            return;
        }
        LineLayer lineLayer2 = this.f277431d;
        if (lineLayer2 != null) {
            lineLayer2.l();
        }
    }

    public void setLineColor(int i3) {
        LineLayer lineLayer = this.f277431d;
        if (lineLayer != null) {
            lineLayer.w(i3);
        }
    }

    public void setLineTexture(int i3) {
        LineLayer lineLayer = this.f277431d;
        if (lineLayer != null) {
            lineLayer.x(i3);
        }
    }
}
