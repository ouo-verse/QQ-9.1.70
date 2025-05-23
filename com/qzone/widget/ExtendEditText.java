package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;
import java.lang.Character;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ExtendEditText extends EditText {
    private static final d N = new a();
    public static final d P = new b();
    protected LinearGradient C;
    protected int[] D;
    protected float[] E;
    protected GradientDrawable.Orientation F;
    protected int G;
    protected z H;
    private Transformation I;
    private String J;
    private int K;
    private boolean L;
    private int M;

    /* renamed from: d, reason: collision with root package name */
    private boolean f60345d;

    /* renamed from: e, reason: collision with root package name */
    private f f60346e;

    /* renamed from: f, reason: collision with root package name */
    private d f60347f;

    /* renamed from: h, reason: collision with root package name */
    protected int f60348h;

    /* renamed from: i, reason: collision with root package name */
    private int f60349i;

    /* renamed from: m, reason: collision with root package name */
    int f60350m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements d {
        a() {
        }

        @Override // com.qzone.widget.ExtendEditText.d
        public int a(CharSequence charSequence, int i3, int i16) {
            int i17 = i16 - i3;
            if (i17 < 0) {
                return -i17;
            }
            return i17;
        }

        @Override // com.qzone.widget.ExtendEditText.d
        public int b(CharSequence charSequence, int i3, int i16) {
            int i17 = i16 - i3;
            if (i17 < 0) {
                return -i17;
            }
            return i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f60351a;

        static {
            int[] iArr = new int[GradientDrawable.Orientation.values().length];
            f60351a = iArr;
            try {
                iArr[GradientDrawable.Orientation.TOP_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f60351a[GradientDrawable.Orientation.TR_BL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f60351a[GradientDrawable.Orientation.RIGHT_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f60351a[GradientDrawable.Orientation.BR_TL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f60351a[GradientDrawable.Orientation.BOTTOM_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f60351a[GradientDrawable.Orientation.BL_TR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f60351a[GradientDrawable.Orientation.LEFT_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d {
        int a(CharSequence charSequence, int i3, int i16);

        int b(CharSequence charSequence, int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class e implements InputFilter {

        /* renamed from: d, reason: collision with root package name */
        private int f60352d;

        public e(int i3) {
            this.f60352d = i3;
        }

        private void a() {
            if (ExtendEditText.this.f60346e != null) {
                ExtendEditText.this.f60346e.a(this.f60352d);
            }
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int a16;
            d dVar = ExtendEditText.this.f60347f;
            if (dVar == null) {
                a16 = spanned.length() - (i18 - i17);
            } else {
                a16 = dVar.a(spanned, i18, spanned.length()) + dVar.a(spanned, 0, i17);
            }
            int a17 = dVar == null ? i16 - i3 : dVar.a(charSequence, i3, i16);
            int i19 = this.f60352d - a16;
            if (i19 <= 0) {
                a();
                return "";
            }
            if (i19 >= a17) {
                return null;
            }
            a();
            if (dVar != null && (i19 = dVar.b(charSequence, i3, i19 + i3)) <= 0) {
                return "";
            }
            int i26 = i19 + i3;
            if (Character.isHighSurrogate(charSequence.charAt(i26 - 1)) && i26 - 1 == i3) {
                return "";
            }
            return charSequence.subSequence(i3, i26);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface f {
        void a(int i3);
    }

    public ExtendEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60345d = false;
        this.f60347f = null;
        this.f60348h = 0;
        this.f60349i = 4;
        this.f60350m = -1;
        this.G = 0;
        this.H = null;
        this.I = new Transformation();
        this.M = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditText);
        setClearFocusOnBack(obtainStyledAttributes.getBoolean(0, false));
        this.f60350m = obtainStyledAttributes.getInteger(1, -1);
        obtainStyledAttributes.recycle();
        k();
    }

    private boolean g() {
        int scrollY = getScrollY();
        int height = getLayout().getHeight() - ((getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom());
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height - 1;
    }

    private int h() {
        Layout layout = getLayout();
        if (TextUtils.isEmpty(getText())) {
            CharSequence hint = getHint();
            if (!TextUtils.isEmpty(hint)) {
                if (!hint.equals(this.J)) {
                    this.J = hint.toString();
                    this.K = (int) getPaint().measureText(hint.toString());
                }
                return this.K;
            }
        }
        if (layout == null) {
            return 0;
        }
        int lineCount = layout.getLineCount();
        int i3 = 0;
        for (int i16 = 0; i16 < lineCount; i16++) {
            int lineRight = (int) layout.getLineRight(i16);
            if (i3 < lineRight) {
                i3 = lineRight;
            }
        }
        return i3;
    }

    private void j() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void k() {
        int i3 = this.f60350m;
        if (i3 >= 0) {
            setFilters(new InputFilter[]{new e(i3)});
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0031. Please report as an issue. */
    private void l() {
        float f16;
        float f17;
        int i3;
        float f18;
        float f19;
        float f26;
        int i16;
        float f27;
        float f28;
        int i17;
        float f29;
        float f36;
        float f37;
        float f38;
        if (this.D == null || this.E == null) {
            return;
        }
        int h16 = h();
        if (this.C == null || h16 != this.G) {
            this.G = h16;
            Rect rect = new Rect(0, 0, this.G, getMeasuredHeight());
            switch (c.f60351a[this.F.ordinal()]) {
                case 1:
                    f16 = rect.left;
                    f17 = rect.top;
                    i3 = rect.bottom;
                    f29 = i3 * 1.0f;
                    f36 = f16;
                    f37 = f36;
                    f38 = f17;
                    break;
                case 2:
                    f18 = rect.right;
                    f19 = rect.top;
                    f26 = rect.left * 1.0f;
                    i16 = rect.bottom;
                    f29 = i16 * 1.0f;
                    f36 = f18;
                    f38 = f19;
                    f37 = f26;
                    break;
                case 3:
                    f27 = rect.right;
                    f28 = rect.top;
                    i17 = rect.left;
                    f37 = i17 * 1.0f;
                    f36 = f27;
                    f38 = f28;
                    f29 = f38;
                    break;
                case 4:
                    f18 = rect.right;
                    f19 = rect.bottom;
                    f26 = rect.left * 1.0f;
                    i16 = rect.top;
                    f29 = i16 * 1.0f;
                    f36 = f18;
                    f38 = f19;
                    f37 = f26;
                    break;
                case 5:
                    f16 = rect.left;
                    f17 = rect.bottom;
                    i3 = rect.top;
                    f29 = i3 * 1.0f;
                    f36 = f16;
                    f37 = f36;
                    f38 = f17;
                    break;
                case 6:
                    f18 = rect.left;
                    f19 = rect.bottom;
                    f26 = rect.right * 1.0f;
                    i16 = rect.top;
                    f29 = i16 * 1.0f;
                    f36 = f18;
                    f38 = f19;
                    f37 = f26;
                    break;
                case 7:
                    f27 = rect.left;
                    f28 = rect.top;
                    i17 = rect.right;
                    f37 = i17 * 1.0f;
                    f36 = f27;
                    f38 = f28;
                    f29 = f38;
                    break;
                default:
                    f18 = rect.left;
                    f19 = rect.top;
                    f26 = rect.right * 1.0f;
                    i16 = rect.bottom;
                    f29 = i16 * 1.0f;
                    f36 = f18;
                    f38 = f19;
                    f37 = f26;
                    break;
            }
            this.C = new LinearGradient(f36, f38, f37, f29, this.D, this.E, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.widget.TextView
    public boolean bringPointIntoView(int i3) {
        if (f()) {
            return super.bringPointIntoView(i3);
        }
        return false;
    }

    protected void c() {
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        int i3 = i();
        int lineTop = layout.getLineTop(i3);
        int lineBottom = layout.getLineBottom(i3);
        int scrollY = getScrollY();
        int scrollX = getScrollX();
        if (Math.abs(scrollY - lineTop) > Math.abs(lineBottom - scrollY)) {
            lineTop = lineBottom;
        }
        scrollTo(scrollX, lineTop);
    }

    protected void d() {
        int i3;
        Layout layout = getLayout();
        if (layout != null && i() - 1 >= 0) {
            scrollTo(getScrollX(), layout.getLineTop(i3));
        }
    }

    protected void e() {
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        scrollTo(getScrollX(), layout.getLineBottom(i()));
    }

    public boolean f() {
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            TextPaint paint = getPaint();
            z zVar = this.H;
            if (zVar != null) {
                boolean transformation = zVar.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.I);
                int a16 = this.H.a();
                setTextColor(a16);
                setHintTextColor(a16);
                if (transformation) {
                    postInvalidateOnAnimation();
                }
            }
            l();
            LinearGradient linearGradient = this.C;
            if (linearGradient != null) {
                paint.setShader(linearGradient);
            }
            super.onDraw(canvas);
            if (this.C != null) {
                paint.setShader(null);
            }
        } catch (Throwable th5) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "onDraw error", th5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
        if (this.f60345d && i3 == 4 && keyEvent.getAction() == 1) {
            j();
            clearFocus();
            return true;
        }
        return super.onKeyPreIme(i3, keyEvent);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i3, int i16) {
        super.onSelectionChanged(i3, i16);
        c();
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        super.onTextChanged(charSequence, i3, i16, i17);
        int lineCount = getLineCount();
        int i18 = this.f60348h;
        if (i18 == lineCount) {
            c();
            return;
        }
        if (i18 < lineCount) {
            boolean z16 = this.L;
            if (!z16 && lineCount > this.f60349i) {
                e();
                return;
            } else {
                if (z16 && g()) {
                    e();
                    return;
                }
                return;
            }
        }
        d();
    }

    public void setBeforeChangeLineCount(int i3) {
        this.f60348h = i3;
    }

    public void setClearFocusOnBack(boolean z16) {
        this.f60345d = z16;
    }

    public void setEditDistanceParentHeight(int i3) {
        this.M = i3;
    }

    public void setFixedHeight(boolean z16) {
        this.L = z16;
    }

    public void setLimitListener(f fVar) {
        this.f60346e = fVar;
    }

    public void setMaxLength(int i3) {
        this.f60350m = i3;
        k();
    }

    public void setMaxLengthConvertor(d dVar) {
        this.f60347f = dVar;
    }

    public void setMaxLineToScrollAlways(int i3) {
        this.f60349i = i3;
    }

    public void setTextColorAnimation(ArrayList<Integer> arrayList, int i3) {
        z zVar = this.H;
        if (zVar != null) {
            zVar.cancel();
        }
        if (arrayList != null && arrayList.size() >= 2 && i3 != 0) {
            z zVar2 = new z(arrayList);
            this.H = zVar2;
            zVar2.setFillAfter(true);
            this.H.setRepeatCount(-1);
            this.H.setRepeatMode(2);
            this.H.setInterpolator(new LinearInterpolator());
            this.H.setDuration(i3);
            this.H.setStartTime(0L);
            return;
        }
        this.H = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        int i3 = 0;
        try {
            if (getLayout() == null) {
                return 0;
            }
            try {
                i3 = getLayout().getLineForOffset(getOffsetForPosition(getX(), getY() - this.M));
                return i3;
            } catch (Exception e16) {
                e16.printStackTrace();
                return 0;
            }
        } catch (Exception e17) {
            QZLog.w(QZLog.TO_DEVICE_TAG, "getTargetLine error", e17);
            return i3;
        }
    }

    public void setGradientColor(int[] iArr, float[] fArr, GradientDrawable.Orientation orientation) {
        this.C = null;
        this.D = iArr;
        this.E = fArr;
        this.F = orientation;
        try {
            setLayerType(0, null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        setDrawingCacheEnabled(false);
    }

    @Override // android.view.View
    public void postInvalidateOnAnimation() {
        super.postInvalidateDelayed(33L);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements d {
        b() {
        }

        private boolean c(char c16) {
            Character.UnicodeBlock of5 = Character.UnicodeBlock.of(c16);
            return of5 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of5 == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of5 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of5 == Character.UnicodeBlock.GENERAL_PUNCTUATION || of5 == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of5 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
        }

        @Override // com.qzone.widget.ExtendEditText.d
        public int b(CharSequence charSequence, int i3, int i16) {
            int i17 = i3 <= i16 ? i3 : i16;
            if (i3 <= i16) {
                i3 = i16;
            }
            int i18 = 0;
            for (int i19 = i17; i19 < charSequence.length(); i19++) {
                if (c(charSequence.charAt(i19))) {
                    i18++;
                }
                if (i19 + i18 >= i3) {
                    return i19 - i17;
                }
            }
            return 0;
        }

        @Override // com.qzone.widget.ExtendEditText.d
        public int a(CharSequence charSequence, int i3, int i16) {
            int i17 = i3 <= i16 ? i3 : i16;
            if (i3 <= i16) {
                i3 = i16;
            }
            int i18 = 0;
            for (int i19 = i17; i19 < i3 && i19 < charSequence.length(); i19++) {
                if (c(charSequence.charAt(i19))) {
                    i18++;
                }
            }
            return (i3 - i17) + i18;
        }
    }

    public ExtendEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60345d = false;
        this.f60347f = null;
        this.f60348h = 0;
        this.f60349i = 4;
        this.f60350m = -1;
        this.G = 0;
        this.H = null;
        this.I = new Transformation();
        this.M = 0;
        k();
    }

    public ExtendEditText(Context context) {
        super(context);
        this.f60345d = false;
        this.f60347f = null;
        this.f60348h = 0;
        this.f60349i = 4;
        this.f60350m = -1;
        this.G = 0;
        this.H = null;
        this.I = new Transformation();
        this.M = 0;
        k();
    }
}
