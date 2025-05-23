package i1;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f407014i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f407015j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f407016k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f407017l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Paint f407018a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final Paint f407019b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final Paint f407020c;

    /* renamed from: d, reason: collision with root package name */
    private int f407021d;

    /* renamed from: e, reason: collision with root package name */
    private int f407022e;

    /* renamed from: f, reason: collision with root package name */
    private int f407023f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f407024g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f407025h;

    public a() {
        this(-16777216);
    }

    public void a(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i3, float f16, float f17) {
        boolean z16;
        if (f17 < 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        Path path = this.f407024g;
        if (z16) {
            int[] iArr = f407016k;
            iArr[0] = 0;
            iArr[1] = this.f407023f;
            iArr[2] = this.f407022e;
            iArr[3] = this.f407021d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f16, f17);
            path.close();
            float f18 = -i3;
            rectF.inset(f18, f18);
            int[] iArr2 = f407016k;
            iArr2[0] = 0;
            iArr2[1] = this.f407021d;
            iArr2[2] = this.f407022e;
            iArr2[3] = this.f407023f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f19 = 1.0f - (i3 / width);
        float[] fArr = f407017l;
        fArr[1] = f19;
        fArr[2] = ((1.0f - f19) / 2.0f) + f19;
        this.f407019b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f407016k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z16) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f407025h);
        }
        canvas.drawArc(rectF, f16, f17, true, this.f407019b);
        canvas.restore();
    }

    public void b(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i3) {
        rectF.bottom += i3;
        rectF.offset(0.0f, -i3);
        int[] iArr = f407014i;
        iArr[0] = this.f407023f;
        iArr[1] = this.f407022e;
        iArr[2] = this.f407021d;
        Paint paint = this.f407020c;
        float f16 = rectF.left;
        paint.setShader(new LinearGradient(f16, rectF.top, f16, rectF.bottom, iArr, f407015j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f407020c);
        canvas.restore();
    }

    @NonNull
    public Paint c() {
        return this.f407018a;
    }

    public void d(int i3) {
        this.f407021d = ColorUtils.setAlphaComponent(i3, 68);
        this.f407022e = ColorUtils.setAlphaComponent(i3, 20);
        this.f407023f = ColorUtils.setAlphaComponent(i3, 0);
        this.f407018a.setColor(this.f407021d);
    }

    public a(int i3) {
        this.f407024g = new Path();
        this.f407025h = new Paint();
        this.f407018a = new Paint();
        d(i3);
        this.f407025h.setColor(0);
        Paint paint = new Paint(4);
        this.f407019b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f407020c = new Paint(paint);
    }
}
