package com.tencent.mobileqq.guild.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class RoundImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private int f215534d;

    /* renamed from: e, reason: collision with root package name */
    private int f215535e;

    /* renamed from: f, reason: collision with root package name */
    private int f215536f;

    /* renamed from: h, reason: collision with root package name */
    private int f215537h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f215538i;

    /* renamed from: m, reason: collision with root package name */
    private final Path f215539m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, RoundImageView.this.getWidth(), RoundImageView.this.getHeight(), RoundImageView.this.f215534d);
        }
    }

    public RoundImageView(Context context) {
        this(context, null);
    }

    private void b(Context context, AttributeSet attributeSet, int i3) {
        boolean z16 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.G3, i3, 0);
        try {
            try {
                float dimension = (int) obtainStyledAttributes.getDimension(b.J3, 0.0f);
                this.f215534d = (int) obtainStyledAttributes.getDimension(b.K3, dimension);
                this.f215535e = (int) obtainStyledAttributes.getDimension(b.L3, dimension);
                this.f215537h = (int) obtainStyledAttributes.getDimension(b.I3, dimension);
                int dimension2 = (int) obtainStyledAttributes.getDimension(b.H3, dimension);
                this.f215536f = dimension2;
                int i16 = this.f215534d;
                if (i16 == this.f215535e && i16 == this.f215537h && i16 == dimension2) {
                    z16 = true;
                }
                this.f215538i = z16;
            } catch (Exception e16) {
                QLog.e("RoundImageView", 1, "initAttrs exception", e16);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void c() {
        this.f215539m.reset();
        if (this.f215538i) {
            setClipToOutline(true);
            setOutlineProvider(new a());
            return;
        }
        setClipToOutline(false);
        setOutlineProvider(null);
        Path path = this.f215539m;
        float width = getWidth();
        float bottom = getBottom();
        int i3 = this.f215534d;
        int i16 = this.f215535e;
        int i17 = this.f215537h;
        int i18 = this.f215536f;
        path.addRoundRect(0.0f, 0.0f, width, bottom, new float[]{i3, i3, i16, i16, i17, i17, i18, i18}, Path.Direction.CW);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            if (this.f215538i) {
                super.onDraw(canvas);
            } else {
                int save = canvas.save();
                canvas.clipPath(this.f215539m);
                super.onDraw(canvas);
                canvas.restoreToCount(save);
            }
        } catch (Exception e16) {
            QLog.e("RoundImageView", 1, "onDraw exception", e16);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        c();
    }

    public void setBottomLeftRadius(int i3) {
        setRadius(this.f215534d, this.f215535e, this.f215537h, i3);
    }

    public void setBottomRightRadius(int i3) {
        setRadius(this.f215534d, this.f215535e, i3, this.f215536f);
    }

    public void setRadius(int i3) {
        setRadius(i3, i3, i3, i3);
    }

    public void setTopLeftRadius(int i3) {
        setRadius(i3, this.f215535e, this.f215537h, this.f215536f);
    }

    public void setTopRightRadius(int i3) {
        setRadius(this.f215534d, i3, this.f215537h, this.f215536f);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setRadius(int i3, int i16, int i17, int i18) {
        this.f215534d = i3;
        this.f215535e = i16;
        this.f215537h = i17;
        this.f215536f = i18;
        this.f215538i = i3 == i16 && i3 == i17 && i3 == i18;
        c();
        invalidate();
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f215534d = 0;
        this.f215535e = 0;
        this.f215536f = 0;
        this.f215537h = 0;
        this.f215538i = false;
        this.f215539m = new Path();
        b(context, attributeSet, i3);
    }
}
