package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.doodle.LineLayer;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DoodleView extends View {

    /* renamed from: d, reason: collision with root package name */
    private LineLayer f178424d;

    /* renamed from: e, reason: collision with root package name */
    private b f178425e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements LineLayer.a {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.doodle.LineLayer.a
        public void a() {
            if (DoodleView.this.f178425e != null) {
                DoodleView.this.f178425e.a();
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.doodle.LineLayer.a
        public void b(int i3, int i16) {
            if (DoodleView.this.f178425e != null) {
                DoodleView.this.f178425e.b(i3, i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    interface b {
        void a();

        void b(int i3, int i16);
    }

    public DoodleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void e() {
        LineLayer lineLayer = new LineLayer(this);
        this.f178424d = lineLayer;
        lineLayer.e();
        this.f178424d.y(new a());
        this.f178424d.w(LineLayer.f178436x);
        super.requestLayout();
    }

    public void b(boolean z16) {
        LineLayer lineLayer = this.f178424d;
        if (lineLayer != null) {
            lineLayer.m(z16);
        }
        super.invalidate();
    }

    public int c(boolean z16) {
        if (!z16) {
            LineLayer lineLayer = this.f178424d;
            if (lineLayer != null) {
                return lineLayer.q();
            }
            return 0;
        }
        LineLayer lineLayer2 = this.f178424d;
        if (lineLayer2 != null) {
            return lineLayer2.t();
        }
        return 0;
    }

    public void d(b bVar) {
        this.f178425e = bVar;
        e();
    }

    public void f() {
        LineLayer lineLayer = this.f178424d;
        if (lineLayer != null) {
            lineLayer.A();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        LineLayer lineLayer = this.f178424d;
        if (lineLayer != null) {
            lineLayer.d(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        LineLayer lineLayer;
        if (i3 > 0 && i16 > 0 && (lineLayer = this.f178424d) != null) {
            lineLayer.j(i3, i16);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        LineLayer lineLayer = this.f178424d;
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
            LineLayer lineLayer = this.f178424d;
            if (lineLayer != null && lineLayer.q() == 0) {
                this.f178424d.m(true);
                return;
            }
            return;
        }
        LineLayer lineLayer2 = this.f178424d;
        if (lineLayer2 != null) {
            lineLayer2.l();
        }
    }

    public void setLineColor(int i3) {
        LineLayer lineLayer = this.f178424d;
        if (lineLayer != null) {
            lineLayer.w(i3);
        }
    }

    public void setLineTexture(int i3) {
        LineLayer lineLayer = this.f178424d;
        if (lineLayer != null) {
            lineLayer.x(i3);
        }
    }
}
