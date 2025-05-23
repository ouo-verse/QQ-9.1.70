package com.tencent.mobileqq.activity.richmedia.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
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
import com.tencent.qphone.base.util.QLog;
import java.lang.Character;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ExtendEditText extends EditText {
    private static final d L = new a();
    public static final d M = new b();
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
    private boolean f186032d;

    /* renamed from: e, reason: collision with root package name */
    private d f186033e;

    /* renamed from: f, reason: collision with root package name */
    protected int f186034f;

    /* renamed from: h, reason: collision with root package name */
    private int f186035h;

    /* renamed from: i, reason: collision with root package name */
    int f186036i;

    /* renamed from: m, reason: collision with root package name */
    protected LinearGradient f186037m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements d {
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

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements d {
        b() {
        }

        private boolean c(char c16) {
            Character.UnicodeBlock of5 = Character.UnicodeBlock.of(c16);
            if (of5 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS && of5 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS && of5 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A && of5 != Character.UnicodeBlock.GENERAL_PUNCTUATION && of5 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION && of5 != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.d
        public int a(CharSequence charSequence, int i3, int i16) {
            int i17;
            if (i3 <= i16) {
                i17 = i3;
            } else {
                i17 = i16;
            }
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

        @Override // com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.d
        public int b(CharSequence charSequence, int i3, int i16) {
            int i17;
            if (i3 <= i16) {
                i17 = i3;
            } else {
                i17 = i16;
            }
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f186038a;

        static {
            int[] iArr = new int[GradientDrawable.Orientation.values().length];
            f186038a = iArr;
            try {
                iArr[GradientDrawable.Orientation.TOP_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f186038a[GradientDrawable.Orientation.TR_BL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f186038a[GradientDrawable.Orientation.RIGHT_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f186038a[GradientDrawable.Orientation.BR_TL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f186038a[GradientDrawable.Orientation.BOTTOM_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f186038a[GradientDrawable.Orientation.BL_TR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f186038a[GradientDrawable.Orientation.LEFT_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface d {
        int a(CharSequence charSequence, int i3, int i16);

        int b(CharSequence charSequence, int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements InputFilter {

        /* renamed from: d, reason: collision with root package name */
        private int f186039d;

        public e(int i3) {
            this.f186039d = i3;
        }

        private void a() {
            ExtendEditText.b(ExtendEditText.this);
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int a16;
            int a17;
            d dVar = ExtendEditText.this.f186033e;
            if (dVar == null) {
                a16 = spanned.length() - (i18 - i17);
            } else {
                a16 = dVar.a(spanned, i18, spanned.length()) + dVar.a(spanned, 0, i17);
            }
            if (dVar == null) {
                a17 = i16 - i3;
            } else {
                a17 = dVar.a(charSequence, i3, i16);
            }
            int i19 = this.f186039d - a16;
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
    /* loaded from: classes10.dex */
    public interface f {
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public String f186041a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f186042b = 0;

        /* renamed from: c, reason: collision with root package name */
        public boolean f186043c = false;

        /* renamed from: d, reason: collision with root package name */
        public String f186044d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f186045e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f186046f = "";

        /* renamed from: g, reason: collision with root package name */
        public int f186047g = -1;

        /* renamed from: h, reason: collision with root package name */
        public long f186048h = 0;

        /* renamed from: i, reason: collision with root package name */
        public String f186049i = "";

        /* renamed from: j, reason: collision with root package name */
        public int f186050j = 0;

        /* renamed from: k, reason: collision with root package name */
        public int f186051k = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f186052l = 0;

        /* renamed from: m, reason: collision with root package name */
        public String f186053m = "";

        /* renamed from: n, reason: collision with root package name */
        public ArrayList<String> f186054n = null;

        /* renamed from: o, reason: collision with root package name */
        public ArrayList<Double> f186055o = null;

        /* renamed from: p, reason: collision with root package name */
        public int f186056p = 0;

        /* renamed from: q, reason: collision with root package name */
        public ArrayList<String> f186057q = null;

        /* renamed from: r, reason: collision with root package name */
        public int f186058r = 0;

        public static g b(String str) {
            g gVar = new g();
            gVar.a(str);
            return gVar;
        }

        public static int c(String str) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            String trim = str.trim();
            if (!trim.startsWith("#")) {
                trim = "#" + trim;
            }
            try {
                return Color.parseColor(trim);
            } catch (Exception e16) {
                e16.printStackTrace();
                return 0;
            }
        }

        public void a(String str) {
            int length;
            int length2;
            int length3;
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f186047g = jSONObject.optInt("iItemId");
                this.f186048h = jSONObject.optLong("lSparkleFlag");
                this.f186049i = jSONObject.optString("strTextColor");
                this.f186050j = jSONObject.optInt("iShadowOffsetX");
                this.f186051k = jSONObject.optInt("iShadowOffsetY");
                this.f186052l = jSONObject.optInt("iShadowBlurRadius");
                this.f186053m = jSONObject.optString("strShadowColor");
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("vecGradientColor");
                    if (optJSONArray == null) {
                        length3 = 0;
                    } else {
                        length3 = optJSONArray.length();
                    }
                    this.f186054n = new ArrayList<>();
                    for (int i3 = 0; i3 < length3; i3++) {
                        this.f186054n.add(optJSONArray.getString(i3));
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                this.f186055o = new ArrayList<>();
                try {
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("vecGradientPosition");
                    if (optJSONArray2 == null) {
                        length2 = 0;
                    } else {
                        length2 = optJSONArray2.length();
                    }
                    for (int i16 = 0; i16 < length2; i16++) {
                        this.f186055o.add(Double.valueOf(optJSONArray2.getDouble(i16)));
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                this.f186056p = jSONObject.optInt("iGradientDirection");
                this.f186057q = new ArrayList<>();
                try {
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("vecTextColorAnimation");
                    if (optJSONArray3 == null) {
                        length = 0;
                    } else {
                        length = optJSONArray3.length();
                    }
                    for (int i17 = 0; i17 < length; i17++) {
                        this.f186057q.add(optJSONArray3.getString(i17));
                    }
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                this.f186058r = jSONObject.optInt("iTextColorSpanTime");
            } catch (Exception e19) {
                e19.printStackTrace();
            }
        }
    }

    public ExtendEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f186032d = false;
        this.f186033e = null;
        this.f186034f = 0;
        this.f186035h = 4;
        this.f186036i = -1;
        this.F = 0;
        this.G = null;
        this.H = new Transformation();
        this.K = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditText);
        setClearFocusOnBack(obtainStyledAttributes.getBoolean(R.styleable.EditText_clearFocusOnBack, false));
        this.f186036i = obtainStyledAttributes.getInteger(R.styleable.EditText_maxLength, -1);
        obtainStyledAttributes.recycle();
        i();
    }

    static /* bridge */ /* synthetic */ f b(ExtendEditText extendEditText) {
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
        int i3 = this.f186036i;
        if (i3 >= 0) {
            setFilters(new InputFilter[]{new e(i3)});
        }
    }

    private void j(g gVar) {
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
            int c16 = g.c(gVar.f186049i);
            setTextColor(c16);
            setHintTextColor(c16);
        } else {
            setTextColor(this.K);
            setHintTextColor(this.K);
        }
        if ((gVar.f186048h & 2) != 0) {
            setShadowLayer(BaseAIOUtils.f(gVar.f186052l, getResources()), BaseAIOUtils.f(gVar.f186050j, getResources()), BaseAIOUtils.f(gVar.f186051k, getResources()), g.c(gVar.f186053m));
        } else {
            setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
        if ((gVar.f186048h & 8) != 0 && (arrayList3 = gVar.f186057q) != null && arrayList3.size() >= 2) {
            ArrayList<Integer> arrayList4 = new ArrayList<>(gVar.f186057q.size());
            int size = gVar.f186057q.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList4.add(Integer.valueOf(g.c(gVar.f186057q.get(i3))));
            }
            setTextColorAnimation(arrayList4, gVar.f186058r * (size - 1));
        } else {
            setTextColorAnimation(null, 0);
        }
        if ((gVar.f186048h & 4) != 0 && (arrayList = gVar.f186054n) != null && arrayList.size() >= 2 && (arrayList2 = gVar.f186055o) != null && arrayList2.size() >= 2) {
            int size2 = gVar.f186054n.size();
            int[] iArr = new int[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                iArr[i16] = g.c(gVar.f186054n.get(i16));
            }
            int size3 = gVar.f186055o.size();
            float[] fArr = new float[size3];
            for (int i17 = 0; i17 < size3; i17++) {
                fArr[i17] = gVar.f186055o.get(i17).floatValue();
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            int i18 = gVar.f186056p;
            if (i18 != 0) {
                if (i18 != 1) {
                    if (i18 != 2) {
                        if (i18 == 3) {
                            orientation = GradientDrawable.Orientation.BL_TR;
                        }
                    } else {
                        orientation = GradientDrawable.Orientation.TL_BR;
                    }
                } else {
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                }
            }
            setGradientColor(iArr, fArr, orientation);
            return;
        }
        setGradientColor(null, null, null);
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
        if (this.C != null && this.D != null) {
            int f39 = f();
            if (this.f186037m != null && f39 == this.F) {
                return;
            }
            this.F = f39;
            Rect rect = new Rect(0, 0, this.F, getMeasuredHeight());
            switch (c.f186038a[this.E.ordinal()]) {
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
            this.f186037m = new LinearGradient(f36, f38, f37, f29, this.C, this.D, Shader.TileMode.CLAMP);
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
        if (layout == null || g() - 1 < 0) {
            return;
        }
        scrollTo(getScrollX(), layout.getLineTop(g16));
    }

    protected void e() {
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        scrollTo(getScrollX(), layout.getLineBottom(g()));
    }

    @TargetApi(14)
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
            if (QLog.isColorLevel()) {
                QLog.w("ExtendEditText", 2, "", e17);
                return i3;
            }
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
        LinearGradient linearGradient = this.f186037m;
        if (linearGradient != null) {
            paint.setShader(linearGradient);
        }
        super.onDraw(canvas);
        if (this.f186037m != null) {
            paint.setShader(null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
        if (this.f186032d && i3 == 4 && keyEvent.getAction() == 1) {
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
        int i18 = this.f186034f;
        if (i18 != lineCount) {
            if (i18 < lineCount) {
                if (lineCount > this.f186035h) {
                    e();
                    return;
                }
                return;
            }
            d();
            return;
        }
        c();
    }

    @Override // android.view.View
    public void postInvalidateOnAnimation() {
        super.postInvalidateDelayed(33L);
    }

    public void setBeforeChangeLineCount(int i3) {
        this.f186034f = i3;
    }

    public void setClearFocusOnBack(boolean z16) {
        this.f186032d = z16;
    }

    public void setGradientColor(int[] iArr, float[] fArr, GradientDrawable.Orientation orientation) {
        this.f186037m = null;
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

    public void setMaxLengthConvertor(d dVar) {
        this.f186033e = dVar;
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
            j(g.b(str));
        }
    }

    public ExtendEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f186032d = false;
        this.f186033e = null;
        this.f186034f = 0;
        this.f186035h = 4;
        this.f186036i = -1;
        this.F = 0;
        this.G = null;
        this.H = new Transformation();
        this.K = null;
        i();
    }

    public void setLimitListener(f fVar) {
    }

    public ExtendEditText(Context context) {
        super(context);
        this.f186032d = false;
        this.f186033e = null;
        this.f186034f = 0;
        this.f186035h = 4;
        this.f186036i = -1;
        this.F = 0;
        this.G = null;
        this.H = new Transformation();
        this.K = null;
        i();
    }
}
