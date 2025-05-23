package ao4;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public Path f26600b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f26601c;

    /* renamed from: e, reason: collision with root package name */
    public int f26603e;

    /* renamed from: f, reason: collision with root package name */
    public int f26604f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f26605g;

    /* renamed from: h, reason: collision with root package name */
    public int f26606h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f26607i;

    /* renamed from: j, reason: collision with root package name */
    public Region f26608j;

    /* renamed from: k, reason: collision with root package name */
    public RectF f26609k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f26611m;

    /* renamed from: a, reason: collision with root package name */
    public float[] f26599a = new float[8];

    /* renamed from: d, reason: collision with root package name */
    public boolean f26602d = false;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<Integer> f26610l = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
    }

    private void a(View view) {
        if (view.isEnabled()) {
            this.f26610l.add(Integer.valueOf(R.attr.state_enabled));
        }
        if (view.isFocused()) {
            this.f26610l.add(Integer.valueOf(R.attr.state_focused));
        }
        if (view.isPressed()) {
            this.f26610l.add(Integer.valueOf(R.attr.state_pressed));
        }
        if (view.isHovered()) {
            this.f26610l.add(Integer.valueOf(R.attr.state_hovered));
        }
        if (view.isSelected()) {
            this.f26610l.add(Integer.valueOf(R.attr.state_selected));
        }
        if (view.isActivated()) {
            this.f26610l.add(Integer.valueOf(R.attr.state_activated));
        }
        if (view.hasWindowFocus()) {
            this.f26610l.add(Integer.valueOf(R.attr.state_window_focused));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(View view) {
        if (!(view instanceof b)) {
            return;
        }
        this.f26610l.clear();
        if (view instanceof Checkable) {
            this.f26610l.add(Integer.valueOf(R.attr.state_checkable));
            if (((Checkable) view).isChecked()) {
                this.f26610l.add(Integer.valueOf(R.attr.state_checked));
            }
        }
        a(view);
        ColorStateList colorStateList = this.f26605g;
        if (colorStateList != null && colorStateList.isStateful()) {
            int[] iArr = new int[this.f26610l.size()];
            for (int i3 = 0; i3 < this.f26610l.size(); i3++) {
                iArr[i3] = this.f26610l.get(i3).intValue();
            }
            ((b) view).setStrokeColor(this.f26605g.getColorForState(iArr, this.f26603e));
        }
    }

    public void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mr2.a.E4);
        this.f26602d = obtainStyledAttributes.getBoolean(mr2.a.G4, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(mr2.a.M4);
        this.f26605g = colorStateList;
        if (colorStateList != null) {
            this.f26604f = colorStateList.getDefaultColor();
            this.f26603e = this.f26605g.getDefaultColor();
        } else {
            this.f26604f = -1;
            this.f26603e = -1;
        }
        this.f26606h = obtainStyledAttributes.getDimensionPixelSize(mr2.a.N4, 0);
        this.f26607i = obtainStyledAttributes.getBoolean(mr2.a.F4, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(mr2.a.H4, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(mr2.a.K4, dimensionPixelSize);
        float[] fArr = this.f26599a;
        float f16 = dimensionPixelSize2;
        fArr[0] = f16;
        fArr[1] = f16;
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(mr2.a.L4, dimensionPixelSize);
        float[] fArr2 = this.f26599a;
        float f17 = dimensionPixelSize3;
        fArr2[2] = f17;
        fArr2[3] = f17;
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(mr2.a.I4, dimensionPixelSize);
        float[] fArr3 = this.f26599a;
        float f18 = dimensionPixelSize4;
        fArr3[6] = f18;
        fArr3[7] = f18;
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(mr2.a.J4, dimensionPixelSize);
        float[] fArr4 = this.f26599a;
        float f19 = dimensionPixelSize5;
        fArr4[4] = f19;
        fArr4[5] = f19;
        obtainStyledAttributes.recycle();
        this.f26609k = new RectF();
        this.f26600b = new Path();
        this.f26608j = new Region();
        Paint paint = new Paint();
        this.f26601c = paint;
        paint.setColor(-1);
        this.f26601c.setAntiAlias(true);
    }

    public void d(Canvas canvas) {
        if (this.f26606h > 0) {
            this.f26601c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.f26601c.setColor(-1);
            this.f26601c.setStrokeWidth(this.f26606h * 2);
            this.f26601c.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.f26600b, this.f26601c);
            this.f26601c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            this.f26601c.setColor(this.f26604f);
            this.f26601c.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.f26600b, this.f26601c);
        }
        this.f26601c.setColor(-1);
        this.f26601c.setStyle(Paint.Style.FILL);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f26601c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.f26600b, this.f26601c);
            return;
        }
        this.f26601c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path path = new Path();
        path.addRect(-1.0f, -1.0f, (int) this.f26609k.width(), (int) this.f26609k.height(), Path.Direction.CW);
        path.op(this.f26600b, Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.f26601c);
    }

    public void e(View view, int i3, int i16) {
        this.f26609k.set(0.0f, 0.0f, i3, i16);
        f(view);
    }

    public void f(View view) {
        float width;
        RectF rectF = new RectF();
        rectF.left = view.getPaddingLeft();
        rectF.top = view.getPaddingTop();
        int width2 = (int) this.f26609k.width();
        int height = (int) this.f26609k.height();
        rectF.right = width2 - view.getPaddingRight();
        rectF.bottom = height - view.getPaddingBottom();
        this.f26600b.reset();
        if (this.f26602d) {
            if (rectF.width() >= rectF.height()) {
                width = rectF.height();
            } else {
                width = rectF.width();
            }
            float f16 = width / 2.0f;
            float f17 = height / 2;
            PointF pointF = new PointF(width2 / 2, f17);
            if (Build.VERSION.SDK_INT <= 27) {
                this.f26600b.addCircle(pointF.x, pointF.y, f16, Path.Direction.CW);
                this.f26600b.moveTo(0.0f, 0.0f);
                this.f26600b.moveTo(width2, height);
            } else {
                float f18 = f17 - f16;
                this.f26600b.moveTo(rectF.left, f18);
                this.f26600b.addCircle(pointF.x, f18 + f16, f16, Path.Direction.CW);
            }
        } else {
            this.f26600b.addRoundRect(rectF, this.f26599a, Path.Direction.CW);
        }
        this.f26608j.setPath(this.f26600b, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }
}
