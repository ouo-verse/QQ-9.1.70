package dy0;

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
/* loaded from: classes7.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public Path f395186b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f395187c;

    /* renamed from: e, reason: collision with root package name */
    public int f395189e;

    /* renamed from: f, reason: collision with root package name */
    public int f395190f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f395191g;

    /* renamed from: h, reason: collision with root package name */
    public int f395192h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f395193i;

    /* renamed from: j, reason: collision with root package name */
    public Region f395194j;

    /* renamed from: k, reason: collision with root package name */
    public RectF f395195k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f395197m;

    /* renamed from: a, reason: collision with root package name */
    public float[] f395185a = new float[8];

    /* renamed from: d, reason: collision with root package name */
    public boolean f395188d = false;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<Integer> f395196l = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
    }

    private void a(View view) {
        if (view.isEnabled()) {
            this.f395196l.add(Integer.valueOf(R.attr.state_enabled));
        }
        if (view.isFocused()) {
            this.f395196l.add(Integer.valueOf(R.attr.state_focused));
        }
        if (view.isPressed()) {
            this.f395196l.add(Integer.valueOf(R.attr.state_pressed));
        }
        if (view.isHovered()) {
            this.f395196l.add(Integer.valueOf(R.attr.state_hovered));
        }
        if (view.isSelected()) {
            this.f395196l.add(Integer.valueOf(R.attr.state_selected));
        }
        if (view.isActivated()) {
            this.f395196l.add(Integer.valueOf(R.attr.state_activated));
        }
        if (view.hasWindowFocus()) {
            this.f395196l.add(Integer.valueOf(R.attr.state_window_focused));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(View view) {
        if (!(view instanceof b)) {
            return;
        }
        this.f395196l.clear();
        if (view instanceof Checkable) {
            this.f395196l.add(Integer.valueOf(R.attr.state_checkable));
            if (((Checkable) view).isChecked()) {
                this.f395196l.add(Integer.valueOf(R.attr.state_checked));
            }
        }
        a(view);
        ColorStateList colorStateList = this.f395191g;
        if (colorStateList != null && colorStateList.isStateful()) {
            int[] iArr = new int[this.f395196l.size()];
            for (int i3 = 0; i3 < this.f395196l.size(); i3++) {
                iArr[i3] = this.f395196l.get(i3).intValue();
            }
            ((b) view).setStrokeColor(this.f395191g.getColorForState(iArr, this.f395189e));
        }
    }

    public void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d52.a.F4);
        this.f395188d = obtainStyledAttributes.getBoolean(d52.a.H4, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(d52.a.N4);
        this.f395191g = colorStateList;
        if (colorStateList != null) {
            this.f395190f = colorStateList.getDefaultColor();
            this.f395189e = this.f395191g.getDefaultColor();
        } else {
            this.f395190f = -1;
            this.f395189e = -1;
        }
        this.f395192h = obtainStyledAttributes.getDimensionPixelSize(d52.a.O4, 0);
        this.f395193i = obtainStyledAttributes.getBoolean(d52.a.G4, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d52.a.I4, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(d52.a.L4, dimensionPixelSize);
        float[] fArr = this.f395185a;
        float f16 = dimensionPixelSize2;
        fArr[0] = f16;
        fArr[1] = f16;
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(d52.a.M4, dimensionPixelSize);
        float[] fArr2 = this.f395185a;
        float f17 = dimensionPixelSize3;
        fArr2[2] = f17;
        fArr2[3] = f17;
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(d52.a.J4, dimensionPixelSize);
        float[] fArr3 = this.f395185a;
        float f18 = dimensionPixelSize4;
        fArr3[6] = f18;
        fArr3[7] = f18;
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(d52.a.K4, dimensionPixelSize);
        float[] fArr4 = this.f395185a;
        float f19 = dimensionPixelSize5;
        fArr4[4] = f19;
        fArr4[5] = f19;
        obtainStyledAttributes.recycle();
        this.f395195k = new RectF();
        this.f395186b = new Path();
        this.f395194j = new Region();
        Paint paint = new Paint();
        this.f395187c = paint;
        paint.setColor(-1);
        this.f395187c.setAntiAlias(true);
    }

    public void d(Canvas canvas) {
        if (this.f395192h > 0) {
            this.f395187c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.f395187c.setColor(-1);
            this.f395187c.setStrokeWidth(this.f395192h * 2);
            this.f395187c.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.f395186b, this.f395187c);
            this.f395187c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            this.f395187c.setColor(this.f395190f);
            this.f395187c.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.f395186b, this.f395187c);
        }
        this.f395187c.setColor(-1);
        this.f395187c.setStyle(Paint.Style.FILL);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f395187c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.f395186b, this.f395187c);
            return;
        }
        this.f395187c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path path = new Path();
        path.addRect(-1.0f, -1.0f, (int) this.f395195k.width(), (int) this.f395195k.height(), Path.Direction.CW);
        path.op(this.f395186b, Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.f395187c);
    }

    public void e(View view, int i3, int i16) {
        this.f395195k.set(0.0f, 0.0f, i3, i16);
        f(view);
    }

    public void f(View view) {
        float width;
        RectF rectF = new RectF();
        rectF.left = view.getPaddingLeft();
        rectF.top = view.getPaddingTop();
        int width2 = (int) this.f395195k.width();
        int height = (int) this.f395195k.height();
        rectF.right = width2 - view.getPaddingRight();
        rectF.bottom = height - view.getPaddingBottom();
        this.f395186b.reset();
        if (this.f395188d) {
            if (rectF.width() >= rectF.height()) {
                width = rectF.height();
            } else {
                width = rectF.width();
            }
            float f16 = width / 2.0f;
            float f17 = height / 2;
            PointF pointF = new PointF(width2 / 2, f17);
            if (Build.VERSION.SDK_INT <= 27) {
                this.f395186b.addCircle(pointF.x, pointF.y, f16, Path.Direction.CW);
                this.f395186b.moveTo(0.0f, 0.0f);
                this.f395186b.moveTo(width2, height);
            } else {
                float f18 = f17 - f16;
                this.f395186b.moveTo(rectF.left, f18);
                this.f395186b.addCircle(pointF.x, f18 + f16, f16, Path.Direction.CW);
            }
        } else {
            this.f395186b.addRoundRect(rectF, this.f395185a, Path.Direction.CW);
        }
        this.f395194j.setPath(this.f395186b, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }
}
