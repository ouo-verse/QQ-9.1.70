package com.tencent.mobileqq.guild.widget.qqui;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qphone.base.util.QLog;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes14.dex */
public class IndexView extends View {
    private Drawable C;
    private Rect D;
    private Drawable E;
    private Rect F;
    private boolean G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private String[] f236453d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f236454e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f236455f;

    /* renamed from: h, reason: collision with root package name */
    private TextPaint f236456h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f236457i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f236458m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
    }

    public IndexView(Context context) {
        super(context);
        this.f236456h = new TextPaint();
        this.f236457i = false;
        this.G = false;
        this.H = false;
    }

    private static int a(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 : iArr) {
            i3 += i16;
        }
        return i3;
    }

    private int b(int i3) {
        int length = this.f236453d.length;
        TextPaint textPaint = this.f236456h;
        textPaint.setTextSize(i3);
        textPaint.setAntiAlias(true);
        Rect rect = new Rect();
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            String str = this.f236453d[i17];
            textPaint.getTextBounds(str, 0, str.length(), rect);
            int i18 = rect.bottom - rect.top;
            i16 = i16 + i18 + ((int) (i18 * 0.8f));
        }
        return i16;
    }

    private void c() {
        int length = this.f236453d.length;
        Rect rect = new Rect();
        for (int i3 = 0; i3 < length; i3++) {
            TextPaint textPaint = this.f236456h;
            String str = this.f236453d[i3];
            textPaint.getTextBounds(str, 0, str.length(), rect);
            this.f236455f[i3] = rect.right - rect.left;
            this.f236454e[i3] = rect.bottom - rect.top;
        }
    }

    private int d(int i3) {
        int length = this.f236453d.length;
        TextPaint textPaint = this.f236456h;
        textPaint.setTextSize(i3);
        textPaint.setAntiAlias(true);
        Rect rect = new Rect();
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            String str = this.f236453d[i17];
            textPaint.getTextBounds(str, 0, str.length(), rect);
            i16 = Math.max(i16, rect.right - rect.left);
        }
        return i16;
    }

    private int e(int i3) {
        return View.MeasureSpec.getSize(i3);
    }

    private int f(int i3, int i16) {
        int paddingTop = i16 - (getPaddingTop() + getPaddingBottom());
        int i17 = 1;
        int i18 = 100;
        int i19 = 50;
        while (i17 < i18) {
            i19 = (i17 + i18) / 2;
            if (b(i19) <= paddingTop) {
                i17 = i19 + 1;
            } else {
                i18 = i19 - 1;
            }
        }
        return d(i19) + getPaddingLeft() + getPaddingRight();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f16;
        int i3;
        int i16;
        int i17;
        int i18;
        super.onDraw(canvas);
        TextPaint textPaint = this.f236456h;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if ((getHeight() - paddingTop) - getPaddingBottom() > a(this.f236454e)) {
            f16 = ((r3 - r2) * 1.0f) / (this.f236453d.length - 1);
        } else {
            f16 = 0.0f;
        }
        float f17 = f16;
        float f18 = paddingTop;
        int length = this.f236453d.length;
        if (!this.f236457i) {
            textPaint.setColor(Color.rgb(119, 119, 119));
        } else {
            textPaint.setColor(-1);
        }
        if (this.f236458m) {
            float f19 = f18 + this.f236454e[0];
            float intrinsicWidth = (this.C.getIntrinsicWidth() * 1.0f) / this.C.getIntrinsicHeight();
            float f26 = width;
            int i19 = this.f236454e[0];
            if (intrinsicWidth >= (f26 * 1.0f) / i19) {
                i18 = (int) (f26 / intrinsicWidth);
                i17 = width;
            } else {
                i17 = (int) (intrinsicWidth * i19);
                i18 = i19;
            }
            Rect rect = this.D;
            int i26 = ((width - i17) / 2) + paddingLeft;
            rect.left = i26;
            int i27 = paddingTop + ((i19 - i18) / 2);
            rect.top = i27;
            rect.right = i26 + i17;
            rect.bottom = i27 + i18;
            this.C.setBounds(rect);
            this.C.draw(canvas);
            f18 = f19 + f17;
        }
        if (this.G) {
            int i28 = length - 1;
            if (this.H) {
                i28 = length - 2;
            }
            int i29 = i28;
            for (int i36 = this.f236458m ? 1 : 0; i36 < i29; i36++) {
                float f27 = f18 + this.f236454e[i36];
                String str = this.f236453d[i36];
                canvas.drawText(str, 0, str.length(), ((width - this.f236455f[i36]) / 2) + paddingLeft, f27, (Paint) textPaint);
                f18 = f27 + f17;
            }
            int i37 = (int) f18;
            float f28 = f18 + this.f236454e[i29];
            float intrinsicWidth2 = (this.E.getIntrinsicWidth() * 1.0f) / this.E.getIntrinsicHeight();
            float f29 = width;
            int i38 = this.f236454e[i29];
            if (intrinsicWidth2 >= (1.0f * f29) / i38) {
                i16 = (int) (f29 / intrinsicWidth2);
                i3 = width;
            } else {
                i3 = (int) (intrinsicWidth2 * i38);
                i16 = i38;
            }
            Rect rect2 = this.F;
            int i39 = ((width - i3) / 2) + paddingLeft;
            rect2.left = i39;
            int i46 = i37 + ((i38 - i16) / 2);
            rect2.top = i46;
            rect2.right = i39 + i3;
            rect2.bottom = i46 + i16;
            this.E.setBounds(rect2);
            this.E.draw(canvas);
            float f36 = f28 + f17;
            if (this.H) {
                float f37 = f36 + this.f236454e[r14];
                String str2 = this.f236453d[i29 + 1];
                canvas.drawText(str2, 0, str2.length(), ((width - this.f236455f[r14]) / 2) + paddingLeft, f37, (Paint) textPaint);
                return;
            }
            return;
        }
        for (int i47 = this.f236458m ? 1 : 0; i47 < length; i47++) {
            float f38 = f18 + this.f236454e[i47];
            String str3 = this.f236453d[i47];
            canvas.drawText(str3, 0, str3.length(), ((width - this.f236455f[i47]) / 2) + paddingLeft, f38, (Paint) textPaint);
            f18 = f38 + f17;
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        c();
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        int e16 = e(i16);
        int f16 = f(i3, e16);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            f16 = Math.min(f16, size);
        } else if (mode == 1073741824) {
            f16 = size;
        }
        setMeasuredDimension(f16, e16);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f236457i = true;
            int[] iArr = {R.attr.state_pressed};
            Drawable drawable = this.C;
            if (drawable != null) {
                drawable.setState(iArr);
                this.C.invalidateSelf();
            }
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                drawable2.setState(iArr);
                this.E.invalidateSelf();
            }
            Drawable background = getBackground();
            if (background != null) {
                background.setState(iArr);
                background.invalidateSelf();
            } else {
                QLog.e("IndexView", 1, "getBackground: failed. ");
            }
        } else if (action == 3 || action == 1) {
            this.f236457i = false;
            int[] iArr2 = new int[0];
            Drawable drawable3 = this.C;
            if (drawable3 != null) {
                drawable3.setState(iArr2);
                this.C.invalidateSelf();
            }
            Drawable drawable4 = this.E;
            if (drawable4 != null) {
                drawable4.setState(iArr2);
                this.E.invalidateSelf();
            }
            Drawable background2 = getBackground();
            if (background2 != null) {
                background2.setState(iArr2);
                background2.invalidateSelf();
            } else {
                QLog.e("IndexView", 1, "getBackground: failed. ");
            }
        }
        if (action != 0 && action != 2 && action != 1) {
            if (action != 3) {
                return false;
            }
            return true;
        }
        motionEvent.getY();
        return true;
    }

    public void setIndex(String[] strArr) {
        if ("$".equals(strArr[0])) {
            this.f236458m = true;
            this.C = getResources().getDrawable(com.tencent.mobileqq.R.drawable.f160878oa);
            this.D = new Rect();
        }
        if (this.G) {
            this.E = getResources().getDrawable(com.tencent.mobileqq.R.drawable.o_);
            this.F = new Rect();
        }
        this.f236453d = strArr;
        this.f236454e = new int[strArr.length];
        this.f236455f = new int[strArr.length];
    }

    public IndexView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236456h = new TextPaint();
        this.f236457i = false;
        this.G = false;
        this.H = false;
    }

    public IndexView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236456h = new TextPaint();
        this.f236457i = false;
        this.G = false;
        this.H = false;
    }

    public void setIndex(String[] strArr, boolean z16) {
        if (z16) {
            String[] strArr2 = new String[strArr.length + 1];
            int i3 = 0;
            strArr2[0] = "$";
            while (i3 < strArr.length) {
                int i16 = i3 + 1;
                strArr2[i16] = strArr[i3];
                i3 = i16;
            }
            strArr = strArr2;
        }
        setIndex(strArr);
    }

    public void setIndex(String[] strArr, boolean z16, boolean z17, boolean z18) {
        if (z16) {
            this.G = z17;
            this.H = z18;
            int i3 = 0;
            if (z17 && z18) {
                String[] strArr2 = new String[strArr.length + 3];
                strArr2[0] = "$";
                while (i3 < strArr.length) {
                    int i16 = i3 + 1;
                    strArr2[i16] = strArr[i3];
                    i3 = i16;
                }
                strArr2[i3 + 1] = ContainerUtils.FIELD_DELIMITER;
                strArr2[i3 + 2] = Marker.ANY_NON_NULL_MARKER;
                strArr = strArr2;
            } else if (!z17 && !z18) {
                String[] strArr3 = new String[strArr.length + 1];
                strArr3[0] = "$";
                while (i3 < strArr.length) {
                    int i17 = i3 + 1;
                    strArr3[i17] = strArr[i3];
                    i3 = i17;
                }
                strArr = strArr3;
            } else {
                String[] strArr4 = new String[strArr.length + 2];
                strArr4[0] = "$";
                while (i3 < strArr.length) {
                    int i18 = i3 + 1;
                    strArr4[i18] = strArr[i3];
                    i3 = i18;
                }
                if (z17) {
                    strArr4[i3 + 1] = ContainerUtils.FIELD_DELIMITER;
                } else {
                    strArr4[i3 + 1] = Marker.ANY_NON_NULL_MARKER;
                }
                strArr = strArr4;
            }
        }
        setIndex(strArr);
    }

    public void setOnIndexChangedListener(b bVar) {
    }

    public void setOnIndexChangedListener2(a aVar) {
    }
}
