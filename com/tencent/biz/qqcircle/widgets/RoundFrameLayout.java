package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cx;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RoundFrameLayout extends QFSPressEffectFrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final RectF f93471d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f93472e;

    /* renamed from: f, reason: collision with root package name */
    private final Path f93473f;

    /* renamed from: h, reason: collision with root package name */
    private int f93474h;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(RoundFrameLayout.this.f93472e, RoundFrameLayout.this.f93474h);
        }
    }

    public RoundFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    private void c(int i3, int i16) {
        this.f93473f.reset();
        this.f93471d.set(0.0f, 0.0f, i3, i16);
        Path path = this.f93473f;
        RectF rectF = this.f93471d;
        int i17 = this.f93474h;
        path.addRoundRect(rectF, i17, i17, Path.Direction.CW);
        this.f93472e.set(0, 0, i3, i16);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!canvas.isHardwareAccelerated()) {
            setLayerType(2, null);
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        c(i3, i16);
    }

    public void setRadius(int i3) {
        this.f93474h = i3;
        c(getWidth(), getHeight());
        postInvalidate();
    }

    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93471d = new RectF();
        this.f93472e = new Rect();
        this.f93473f = new Path();
        this.f93474h = cx.a(4.0f);
        setClipToOutline(true);
        setOutlineProvider(new a());
    }
}
