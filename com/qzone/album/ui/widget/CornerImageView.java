package com.qzone.album.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.ab;

/* compiled from: P */
@Deprecated
/* loaded from: classes39.dex */
public class CornerImageView extends AsyncImageView {

    /* renamed from: d, reason: collision with root package name */
    private float[] f44178d;

    /* renamed from: e, reason: collision with root package name */
    private Path f44179e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f44180f;

    /* renamed from: h, reason: collision with root package name */
    private ab f44181h;

    public CornerImageView(Context context) {
        super(context);
        this.f44178d = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f44180f = new RectF();
        this.f44181h = new ab(this, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f44179e == null) {
            this.f44179e = new Path();
        }
        int save = canvas.save();
        try {
            try {
                Path path = this.f44179e;
                RectF rectF = this.f44180f;
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                path.reset();
                path.addRoundRect(rectF, this.f44178d, Path.Direction.CW);
                canvas.clipPath(path);
                super.onDraw(canvas);
                ab abVar = this.f44181h;
                if (abVar != null) {
                    abVar.b(canvas);
                }
            } catch (UnsupportedOperationException unused) {
                super.onDraw(canvas);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public void setRadius(float[] fArr) {
        this.f44178d = fArr;
    }

    public CornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44178d = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f44180f = new RectF();
        this.f44181h = new ab(this, null);
    }

    public CornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f44178d = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f44180f = new RectF();
        this.f44181h = new ab(this, null);
    }
}
