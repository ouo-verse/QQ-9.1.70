package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import android.content.Context;
import android.content.res.ColorStateList;
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
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import com.tencent.qphone.base.util.QLog;
import java.lang.Character;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ExtendEditText extends EditText {
    private static final ExtendEditText.d L = new a();
    public static final ExtendEditText.d M = new b();
    protected int[] C;
    protected float[] D;
    protected GradientDrawable.Orientation E;
    protected int F;
    protected com.tencent.mobileqq.activity.richmedia.view.b G;
    private Transformation H;
    private String I;
    private int J;
    private ColorStateList K;

    /* renamed from: d, reason: collision with root package name */
    private boolean f66527d;

    /* renamed from: e, reason: collision with root package name */
    private ExtendEditText.d f66528e;

    /* renamed from: f, reason: collision with root package name */
    protected int f66529f;

    /* renamed from: h, reason: collision with root package name */
    private int f66530h;

    /* renamed from: i, reason: collision with root package name */
    int f66531i;

    /* renamed from: m, reason: collision with root package name */
    protected LinearGradient f66532m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements ExtendEditText.d {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.d
        public int a(CharSequence charSequence, int i3, int i16) {
            int i17 = i16 - i3;
            if (i17 < 0) {
                return -i17;
            }
            return i17;
        }

        @Override // com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.d
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
    /* loaded from: classes32.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f66533a;

        static {
            int[] iArr = new int[GradientDrawable.Orientation.values().length];
            f66533a = iArr;
            try {
                iArr[GradientDrawable.Orientation.TOP_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66533a[GradientDrawable.Orientation.TR_BL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f66533a[GradientDrawable.Orientation.RIGHT_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f66533a[GradientDrawable.Orientation.BR_TL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f66533a[GradientDrawable.Orientation.BOTTOM_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f66533a[GradientDrawable.Orientation.BL_TR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f66533a[GradientDrawable.Orientation.LEFT_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements InputFilter {

        /* renamed from: d, reason: collision with root package name */
        private int f66534d;

        public d(int i3) {
            this.f66534d = i3;
        }

        private void a() {
            ExtendEditText.b(ExtendEditText.this);
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int a16;
            ExtendEditText.d dVar = ExtendEditText.this.f66528e;
            if (dVar == null) {
                a16 = spanned.length() - (i18 - i17);
            } else {
                a16 = dVar.a(spanned, i18, spanned.length()) + dVar.a(spanned, 0, i17);
            }
            int a17 = dVar == null ? i16 - i3 : dVar.a(charSequence, i3, i16);
            int i19 = this.f66534d - a16;
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

    public ExtendEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f66527d = false;
        this.f66528e = null;
        this.f66529f = 0;
        this.f66530h = 4;
        this.f66531i = -1;
        this.F = 0;
        this.G = null;
        this.H = new Transformation();
        this.K = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditText);
        setClearFocusOnBack(obtainStyledAttributes.getBoolean(0, false));
        this.f66531i = obtainStyledAttributes.getInteger(1, -1);
        obtainStyledAttributes.recycle();
        i();
    }

    static /* bridge */ /* synthetic */ ExtendEditText.f b(ExtendEditText extendEditText) {
        extendEditText.getClass();
        return null;
    }

    private int f() {
        Layout layout = getLayout();
        if (TextUtils.isEmpty(getText())) {
            CharSequence hint = getHint();
            if (!TextUtils.isEmpty(hint)) {
                if (!hint.equals(this.I)) {
                    this.I = hint.toString();
                    this.J = (int) getPaint().measureText(hint.toString());
                }
                return this.J;
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

    private void h() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void i() {
        int i3 = this.f66531i;
        if (i3 >= 0) {
            setFilters(new InputFilter[]{new d(i3)});
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0031. Please report as an issue. */
    private void k() {
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
        if (this.C == null || this.D == null) {
            return;
        }
        int f39 = f();
        if (this.f66532m == null || f39 != this.F) {
            this.F = f39;
            Rect rect = new Rect(0, 0, this.F, getMeasuredHeight());
            switch (c.f66533a[this.E.ordinal()]) {
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
            this.f66532m = new LinearGradient(f36, f38, f37, f29, this.C, this.D, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.widget.TextView
    public boolean bringPointIntoView(int i3) {
        return false;
    }

    protected void c() {
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        int g16 = g();
        int lineTop = layout.getLineTop(g16);
        int lineBottom = layout.getLineBottom(g16);
        int scrollY = getScrollY();
        int scrollX = getScrollX();
        if (Math.abs(scrollY - lineTop) > Math.abs(lineBottom - scrollY)) {
            lineTop = lineBottom;
        }
        scrollTo(scrollX, lineTop);
    }

    protected void d() {
        int g16;
        Layout layout = getLayout();
        if (layout != null && g() - 1 >= 0) {
            scrollTo(getScrollX(), layout.getLineTop(g16));
        }
    }

    protected void e() {
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        scrollTo(getScrollX(), layout.getLineBottom(g()));
    }

    int g() {
        int i3 = 0;
        try {
            if (getLayout() == null) {
                return 0;
            }
            try {
                i3 = getLayout().getLineForOffset(getOffsetForPosition(getX(), getY()));
                return i3;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("ExtendEditText", 2, "", e16);
                }
                return 0;
            }
        } catch (Exception e17) {
            if (!QLog.isColorLevel()) {
                return i3;
            }
            QLog.w("ExtendEditText", 2, "", e17);
            return i3;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        com.tencent.mobileqq.activity.richmedia.view.b bVar = this.G;
        if (bVar != null) {
            boolean transformation = bVar.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.H);
            int a16 = this.G.a();
            setTextColor(a16);
            setHintTextColor(a16);
            if (transformation) {
                postInvalidateOnAnimation();
            }
        }
        k();
        LinearGradient linearGradient = this.f66532m;
        if (linearGradient != null) {
            paint.setShader(linearGradient);
        }
        super.onDraw(canvas);
        if (this.f66532m != null) {
            paint.setShader(null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
        if (this.f66527d && i3 == 4 && keyEvent.getAction() == 1) {
            h();
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
        int i18 = this.f66529f;
        if (i18 == lineCount) {
            c();
        } else {
            if (i18 < lineCount) {
                if (lineCount > this.f66530h) {
                    e();
                    return;
                }
                return;
            }
            d();
        }
    }

    public void setBeforeChangeLineCount(int i3) {
        this.f66529f = i3;
    }

    public void setClearFocusOnBack(boolean z16) {
        this.f66527d = z16;
    }

    public void setMaxLengthConvertor(ExtendEditText.d dVar) {
        this.f66528e = dVar;
    }

    public void setTextColorAnimation(ArrayList<Integer> arrayList, int i3) {
        com.tencent.mobileqq.activity.richmedia.view.b bVar = this.G;
        if (bVar != null) {
            bVar.cancel();
        }
        if (arrayList != null && arrayList.size() >= 2 && i3 != 0) {
            com.tencent.mobileqq.activity.richmedia.view.b bVar2 = new com.tencent.mobileqq.activity.richmedia.view.b(arrayList);
            this.G = bVar2;
            bVar2.setFillAfter(true);
            this.G.setRepeatCount(-1);
            this.G.setRepeatMode(2);
            this.G.setInterpolator(new LinearInterpolator());
            this.G.setDuration(i3);
            this.G.setStartTime(0L);
            return;
        }
        this.G = null;
    }

    public void setTextEffect(String str) {
        if (TextUtils.isEmpty(str)) {
            j(null);
        } else {
            j(ExtendEditText.g.b(str));
        }
    }

    public void setGradientColor(int[] iArr, float[] fArr, GradientDrawable.Orientation orientation) {
        this.f66532m = null;
        this.C = iArr;
        this.D = fArr;
        this.E = orientation;
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

    private void j(ExtendEditText.g gVar) {
        ArrayList<String> arrayList;
        ArrayList<Double> arrayList2;
        ArrayList<String> arrayList3;
        if (gVar == null) {
            ColorStateList colorStateList = this.K;
            if (colorStateList != null) {
                setTextColor(colorStateList);
                setHintTextColor(this.K);
            }
            setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            setTextColorAnimation(null, 0);
            setGradientColor(null, null, null);
            return;
        }
        if (this.K == null) {
            this.K = getTextColors();
        }
        if ((gVar.f186048h & 1) != 0) {
            int c16 = ExtendEditText.g.c(gVar.f186049i);
            setTextColor(c16);
            setHintTextColor(c16);
        } else {
            setTextColor(this.K);
            setHintTextColor(this.K);
        }
        if ((gVar.f186048h & 2) != 0) {
            setShadowLayer(BaseAIOUtils.f(gVar.f186052l, getResources()), BaseAIOUtils.f(gVar.f186050j, getResources()), BaseAIOUtils.f(gVar.f186051k, getResources()), ExtendEditText.g.c(gVar.f186053m));
        } else {
            setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
        if ((gVar.f186048h & 8) != 0 && (arrayList3 = gVar.f186057q) != null && arrayList3.size() >= 2) {
            ArrayList<Integer> arrayList4 = new ArrayList<>(gVar.f186057q.size());
            int size = gVar.f186057q.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList4.add(Integer.valueOf(ExtendEditText.g.c(gVar.f186057q.get(i3))));
            }
            setTextColorAnimation(arrayList4, gVar.f186058r * (size - 1));
        } else {
            setTextColorAnimation(null, 0);
        }
        if ((gVar.f186048h & 4) != 0 && (arrayList = gVar.f186054n) != null && arrayList.size() >= 2 && (arrayList2 = gVar.f186055o) != null && arrayList2.size() >= 2) {
            int size2 = gVar.f186054n.size();
            int[] iArr = new int[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                iArr[i16] = ExtendEditText.g.c(gVar.f186054n.get(i16));
            }
            int size3 = gVar.f186055o.size();
            float[] fArr = new float[size3];
            for (int i17 = 0; i17 < size3; i17++) {
                fArr[i17] = gVar.f186055o.get(i17).floatValue();
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            int i18 = gVar.f186056p;
            if (i18 != 0) {
                if (i18 == 1) {
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                } else if (i18 == 2) {
                    orientation = GradientDrawable.Orientation.TL_BR;
                } else if (i18 == 3) {
                    orientation = GradientDrawable.Orientation.BL_TR;
                }
            }
            setGradientColor(iArr, fArr, orientation);
            return;
        }
        setGradientColor(null, null, null);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements ExtendEditText.d {
        b() {
        }

        private boolean c(char c16) {
            Character.UnicodeBlock of5 = Character.UnicodeBlock.of(c16);
            return of5 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of5 == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of5 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of5 == Character.UnicodeBlock.GENERAL_PUNCTUATION || of5 == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of5 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
        }

        @Override // com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.d
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

        @Override // com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.d
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
        this.f66527d = false;
        this.f66528e = null;
        this.f66529f = 0;
        this.f66530h = 4;
        this.f66531i = -1;
        this.F = 0;
        this.G = null;
        this.H = new Transformation();
        this.K = null;
        i();
    }

    public ExtendEditText(Context context) {
        super(context);
        this.f66527d = false;
        this.f66528e = null;
        this.f66529f = 0;
        this.f66530h = 4;
        this.f66531i = -1;
        this.F = 0;
        this.G = null;
        this.H = new Transformation();
        this.K = null;
        i();
    }

    public void setLimitListener(ExtendEditText.f fVar) {
    }
}
