package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AnimationTextView extends PatchedTextView implements com.tencent.qqnt.selectable.e, Handler.Callback {
    private float C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private Paint H;
    private Path I;
    private final Handler J;
    private Drawable[] K;
    private Drawable[] L;
    private final int[] M;
    private final boolean N;
    private boolean P;
    Runnable Q;
    public boolean R;
    public boolean S;
    private int T;
    private boolean U;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.qqnt.selectable.i f315395f;

    /* renamed from: h, reason: collision with root package name */
    private int f315396h;

    /* renamed from: i, reason: collision with root package name */
    private int f315397i;

    /* renamed from: m, reason: collision with root package name */
    private int[] f315398m;

    public AnimationTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315398m = new int[]{0, 0};
        this.C = 1.0f;
        this.D = -5250572;
        this.E = false;
        this.F = false;
        this.G = true;
        this.J = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.M = new int[2];
        this.N = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("animation_text_view", true);
        this.P = false;
        this.Q = new Runnable() { // from class: com.tencent.mobileqq.widget.AnimationTextView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AnimationTextView.this.getTag(R.id.dbm) != null) {
                    ((Boolean) AnimationTextView.this.getTag(R.id.dbm)).booleanValue();
                }
                AnimationTextView animationTextView = AnimationTextView.this;
                if (animationTextView.R) {
                    animationTextView.getClass();
                }
                AnimationTextView.this.setTag(R.id.dbm, Boolean.FALSE);
            }
        };
        this.R = true;
        this.S = false;
    }

    private void p() {
        if (this.f315395f != null) {
        } else {
            throw new RuntimeException("Select delegate has not bound.");
        }
    }

    private void q() {
        if (this.H == null) {
            Paint paint = new Paint();
            this.H = paint;
            paint.setAntiAlias(true);
            this.H.setStyle(Paint.Style.FILL);
        }
    }

    private void r() {
        if (this.I == null) {
            this.I = new Path();
        }
    }

    private int s(int i3, int i16) {
        Layout layout = getLayout();
        if (layout != null) {
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(i16), i3);
            if (((int) layout.getPrimaryHorizontal(offsetForHorizontal)) > i3) {
                return layout.getOffsetToLeftOf(offsetForHorizontal);
            }
            return offsetForHorizontal;
        }
        return -1;
    }

    private int t(int i3, int i16) {
        int f16;
        p();
        int i17 = this.f315395f.i();
        if (i17 == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("AnimationTextView", 2, "detectIndexByOffsetSpring backport to detectIndexByOffset");
            }
            return s(i3, i16);
        }
        Layout layout = getLayout();
        if (layout == null) {
            return -1;
        }
        if (i17 == 1) {
            f16 = this.f315395f.q();
        } else {
            f16 = this.f315395f.f();
        }
        int lineForVertical = layout.getLineForVertical(i16);
        if (x(f16)) {
            int i18 = f16 - 1;
            int primaryHorizontal = (int) layout.getPrimaryHorizontal(i18);
            int lineRight = (int) layout.getLineRight(lineForVertical);
            if (i3 > lineRight - ((lineRight - primaryHorizontal) / 2)) {
                f16 = i18;
            }
        }
        int lineForOffset = layout.getLineForOffset(f16);
        int lineTop = layout.getLineTop(lineForOffset);
        int lineBottom = layout.getLineBottom(lineForOffset);
        int i19 = (lineBottom - lineTop) / 2;
        if ((lineForVertical == lineForOffset + 1 && i16 - lineBottom < i19) || (lineForVertical == lineForOffset - 1 && lineTop - i16 < i19)) {
            lineForVertical = lineForOffset;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, i3);
        if (offsetForHorizontal < contentLength() - 1) {
            int i26 = offsetForHorizontal + 1;
            if (x(i26)) {
                int primaryHorizontal2 = (int) layout.getPrimaryHorizontal(offsetForHorizontal);
                int lineRight2 = (int) layout.getLineRight(lineForVertical);
                if (i3 > lineRight2 - ((lineRight2 - primaryHorizontal2) / 2)) {
                    return i26;
                }
                return offsetForHorizontal;
            }
            return offsetForHorizontal;
        }
        return offsetForHorizontal;
    }

    private int v(int i3) {
        Layout layout = getLayout();
        if (!this.N) {
            return layout.getLineBottom(i3);
        }
        if (layout != null) {
            int lineTop = layout.getLineTop(i3);
            int lineBottom = layout.getLineBottom(i3) - lineTop;
            int lineSpacingExtra = (int) ((lineBottom - getLineSpacingExtra()) / getLineSpacingMultiplier());
            if (i3 != layout.getLineCount() - 1) {
                lineBottom = lineSpacingExtra;
            }
            return layout.getLineTop(i3) + lineBottom;
        }
        return 0;
    }

    private void w(Object obj) {
        CharSequence text = getText();
        if (text instanceof Spannable) {
            Spannable spannable = (Spannable) text;
            int spanStart = spannable.getSpanStart(obj);
            int spanEnd = spannable.getSpanEnd(obj);
            SpanWatcher[] spanWatcherArr = (SpanWatcher[]) spannable.getSpans(spanStart, spanEnd, SpanWatcher.class);
            if (spanWatcherArr != null && spanWatcherArr.length > 0) {
                for (SpanWatcher spanWatcher : spanWatcherArr) {
                    try {
                        spanWatcher.onSpanChanged(spannable, obj, spanStart, spanEnd, spanStart, spanEnd);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("AnimationTextView", 2, "Exception: " + e16.getMessage());
                        }
                    }
                }
            }
        }
    }

    private boolean x(int i3) {
        Layout layout = getLayout();
        if (layout != null) {
            if (i3 > 0 && layout.getLineForOffset(i3) == layout.getLineForOffset(i3 - 1) + 1) {
                return true;
            }
            return false;
        }
        throw new RuntimeException("Has no layout.");
    }

    @Override // com.tencent.qqnt.selectable.g
    @Nullable
    public CharSequence a() {
        CharSequence text = getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public int b(int i3, int i16) {
        getLocationInWindow(this.M);
        int paddingLeft = (i3 - this.M[0]) - getPaddingLeft();
        int paddingTop = (i16 - this.M[1]) - getPaddingTop();
        if (this.f315395f == null) {
            return s(paddingLeft, paddingTop);
        }
        return t(paddingLeft, paddingTop);
    }

    @Override // com.tencent.qqnt.selectable.g
    @Nullable
    public com.tencent.qqnt.selectable.i c() {
        return this.f315395f;
    }

    @Override // com.tencent.qqnt.selectable.g
    public int contentLength() {
        return getText().length();
    }

    @Override // com.tencent.qqnt.selectable.g
    public void g(@Nullable com.tencent.qqnt.selectable.i iVar) {
        this.f315395f = iVar;
    }

    public void h() {
        this.E = false;
        invalidate();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            CharSequence text = getText();
            if (text instanceof Spannable) {
                Spannable spannable = (Spannable) text;
                EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) spannable.getSpans(0, spannable.length(), EmoticonSpan.class);
                if (emoticonSpanArr != null && emoticonSpanArr.length > 0) {
                    this.P = true;
                    for (EmoticonSpan emoticonSpan : emoticonSpanArr) {
                        if (emoticonSpan.getDrawable() == message.obj) {
                            w(emoticonSpan);
                        }
                    }
                    this.P = false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.qqnt.selectable.g
    public boolean hasSelected() {
        return this.F;
    }

    public int highlightBackgroundColor() {
        return this.D;
    }

    public void i(int i3, @NonNull int[] iArr, boolean z16) {
        Layout layout = getLayout();
        if (layout == null) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        getLocationInWindow(iArr);
        float f16 = this.C;
        if (f16 > 0.0f) {
            int i16 = iArr[0];
            int[] iArr2 = this.f315398m;
            int i17 = i16 - iArr2[0];
            iArr[0] = i17;
            int i18 = iArr[1] - iArr2[1];
            iArr[1] = i18;
            iArr[0] = (int) (i17 / f16);
            iArr[1] = (int) (i18 / f16);
        }
        iArr[0] = iArr[0] + ((int) layout.getPrimaryHorizontal(i3)) + getPaddingLeft();
        iArr[1] = iArr[1] + v(layout.getLineForOffset(i3)) + getPaddingTop();
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        Message obtainMessage = this.J.obtainMessage(1);
        obtainMessage.obj = drawable;
        this.J.removeMessages(1);
        this.J.sendMessageDelayed(obtainMessage, 100L);
    }

    @Override // com.tencent.qqnt.selectable.g
    public void j(int i3, int i16) {
        if (i3 != -1 && i16 != -1) {
            if (i3 > i16) {
                this.f315396h = i16;
                this.f315397i = i3;
            } else {
                this.f315396h = i3;
                this.f315397i = i16;
            }
            if (this.f315397i - this.f315396h > 0) {
                this.F = true;
                return;
            }
            return;
        }
        this.f315396h = -1;
        this.f315397i = -1;
        this.F = false;
    }

    @Override // com.tencent.qqnt.selectable.g
    @Nullable
    public CharSequence k() {
        CharSequence a16 = a();
        if (a16 != null) {
            return a16.subSequence(this.f315396h, this.f315397i);
        }
        return null;
    }

    @Override // com.tencent.qqnt.selectable.g
    public void l(Object obj) {
        com.tencent.qqnt.selectable.i iVar = this.f315395f;
        if (iVar != null) {
            iVar.n(obj);
            ReportController.o(null, "dc00898", "", "", "0X800AE7A", "0X800AE7A", 1, 0, "", "", "", "");
            return;
        }
        throw new IllegalStateException("Has no bound delegate!");
    }

    public void m() {
        if (!hasSelected()) {
            h();
        }
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        q();
        r();
        this.E = true;
        this.I.reset();
        this.H.setColor(this.D);
        layout.getSelectionPath(this.f315396h, this.f315397i, this.I);
        invalidate();
    }

    @Override // com.tencent.qqnt.selectable.g
    public void n(@ColorInt int i3) {
        this.D = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.J.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.E) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
            canvas.drawPath(this.I, this.H);
            canvas.translate(-getPaddingLeft(), -getPaddingTop());
        }
        if (this.U) {
            int currentTextColor = getCurrentTextColor();
            getPaint().setStyle(Paint.Style.STROKE);
            getPaint().setStrokeWidth(3.0f);
            setTextColor(this.T);
            super.onDraw(canvas);
            getPaint().setStyle(Paint.Style.FILL);
            setTextColor(currentTextColor);
            super.onDraw(canvas);
            return;
        }
        try {
            super.onDraw(canvas);
        } catch (Exception e16) {
            QLog.e("AnimationTextView", 1, "text=", getText(), e16);
        }
    }

    @Override // com.tencent.mobileqq.widget.PatchedTextView, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void requestLayout() {
        if (!this.P) {
            super.requestLayout();
        }
    }

    @Override // com.tencent.qqnt.selectable.e
    public void setCursorOffset(int[] iArr, float f16) {
        if (f16 <= 0.0f) {
            return;
        }
        int[] iArr2 = this.f315398m;
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        this.C = f16;
    }

    public void setStrokeColor(boolean z16, int i3) {
        this.U = z16;
        this.T = i3;
    }

    @Override // com.tencent.mobileqq.widget.PatchedTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence text = getText();
        super.setText(charSequence, bufferType);
        this.K = null;
        this.L = null;
        if (text != charSequence && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) spanned.getSpans(0, spanned.length(), EmoticonSpan.class);
            Drawable[] drawableArr = new Drawable[emoticonSpanArr.length];
            for (int i3 = 0; i3 < emoticonSpanArr.length; i3++) {
                Drawable drawable = emoticonSpanArr[i3].getDrawable();
                drawableArr[i3] = drawable;
                if (drawable != null) {
                    drawable.setCallback(this);
                }
            }
            this.K = drawableArr;
            DynamicDrawableSpan[] dynamicDrawableSpanArr = (DynamicDrawableSpan[]) spanned.getSpans(0, spanned.length(), DynamicDrawableSpan.class);
            Drawable[] drawableArr2 = new Drawable[dynamicDrawableSpanArr.length];
            for (int i16 = 0; i16 < dynamicDrawableSpanArr.length; i16++) {
                Drawable drawable2 = dynamicDrawableSpanArr[i16].getDrawable();
                drawableArr2[i16] = drawable2;
                if (drawable2 != null) {
                    drawable2.setCallback(this);
                }
            }
            this.L = drawableArr2;
        }
    }

    public int u() {
        return this.f315397i;
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return true;
    }

    public int y() {
        return this.f315396h;
    }

    public AnimationTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315398m = new int[]{0, 0};
        this.C = 1.0f;
        this.D = -5250572;
        this.E = false;
        this.F = false;
        this.G = true;
        this.J = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.M = new int[2];
        this.N = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("animation_text_view", true);
        this.P = false;
        this.Q = new Runnable() { // from class: com.tencent.mobileqq.widget.AnimationTextView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AnimationTextView.this.getTag(R.id.dbm) != null) {
                    ((Boolean) AnimationTextView.this.getTag(R.id.dbm)).booleanValue();
                }
                AnimationTextView animationTextView = AnimationTextView.this;
                if (animationTextView.R) {
                    animationTextView.getClass();
                }
                AnimationTextView.this.setTag(R.id.dbm, Boolean.FALSE);
            }
        };
        this.R = true;
        this.S = false;
    }

    @Override // com.tencent.qqnt.selectable.g
    @Nullable
    public View f() {
        return this;
    }

    public AnimationTextView(Context context) {
        super(context);
        this.f315398m = new int[]{0, 0};
        this.C = 1.0f;
        this.D = -5250572;
        this.E = false;
        this.F = false;
        this.G = true;
        this.J = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.M = new int[2];
        this.N = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("animation_text_view", true);
        this.P = false;
        this.Q = new Runnable() { // from class: com.tencent.mobileqq.widget.AnimationTextView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AnimationTextView.this.getTag(R.id.dbm) != null) {
                    ((Boolean) AnimationTextView.this.getTag(R.id.dbm)).booleanValue();
                }
                AnimationTextView animationTextView = AnimationTextView.this;
                if (animationTextView.R) {
                    animationTextView.getClass();
                }
                AnimationTextView.this.setTag(R.id.dbm, Boolean.FALSE);
            }
        };
        this.R = true;
        this.S = false;
    }
}
