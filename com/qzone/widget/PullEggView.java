package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.util.ar;
import com.qzone.widget.util.c;
import cooperation.qzone.util.QZLog;

/* loaded from: classes37.dex */
public class PullEggView extends View {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.widget.util.c f60447d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f60448e;

    /* renamed from: f, reason: collision with root package name */
    private int f60449f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements c.d {
        a() {
        }

        @Override // com.qzone.widget.util.c.d
        public void a(int i3) {
            PullEggView.this.invalidate();
        }
    }

    /* loaded from: classes37.dex */
    public interface b {
    }

    public PullEggView(Context context) {
        super(context);
        a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f60448e == null || getHeight() != this.f60448e.bottom) {
            int width = getWidth();
            int height = getHeight();
            int i3 = this.f60449f;
            this.f60448e = new Rect((width - i3) / 2, height - i3, (width + i3) / 2, height);
            QZLog.d("PullView", 4, "onDraw: init anim dest rect " + this.f60448e.toShortString());
        }
        this.f60447d.e(canvas, this.f60448e);
    }

    public PullEggView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f60449f = ar.e(100.0f);
        QZLog.d("PullView", 4, "init: anim side length " + this.f60449f);
        com.qzone.widget.util.c cVar = new com.qzone.widget.util.c(getContext(), "https://qzonestyle.gtimg.cn/aoi/sola/20181016104539_jjJcYKy5EJ.png", 1, 7, 7, 25);
        this.f60447d = cVar;
        cVar.r(new a());
    }

    public void setVisibleHeight(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        this.f60447d.g();
        int i16 = ((i3 * 2) * 16) / (this.f60449f * 3);
        if (i16 > 48) {
            i16 = 48;
        }
        this.f60447d.w(i16);
        this.f60447d.g();
    }

    public PullEggView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }

    public void setVisibilityChangeListener(b bVar) {
    }
}
