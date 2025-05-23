package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.BoringLayout;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import android.text.style.SuggestionSpan;
import android.text.style.UpdateAppearance;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.graphics.Insets;
import com.tencent.fastertextview.layout.c;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes.dex */
public class FasterTextView extends WrappedTextView {
    public static final int DEFAULT_TYPEFACE = -1;
    private static final int EMS = 1;
    private static final int LINES = 1;
    public static final int MONOSPACE = 3;
    private static final int PIXELS = 2;
    public static final int SANS = 1;
    public static final int SERIF = 2;
    private static final String TAG = "FasterTextView";
    private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
    private static final int VERY_WIDE = 1048576;
    private BoringLayout.Metrics mBoring;
    private int mBreakStrategy;
    private TextView.BufferType mBufferType;
    private ChangeWatcher mChangeWatcher;
    private int mCurHintTextColor;
    private int mCurTextColor;
    private Drawable mCursorDrawable;
    private int mCursorDrawableRes;
    private Drawables mDrawables;
    private TextUtils.TruncateAt mEllipsize;
    private int mGravity;
    public int mHighlightColor;
    private Paint mHighlightPaint;
    private CharSequence mHint;
    private Layout mHintLayout;
    private ColorStateList mHintTextColor;
    private boolean mHorizontallyScrolling;
    private boolean mIncludePad;
    private StaticLayout mLayout;
    private ColorStateList mLinkTextColor;
    private int mMaxMode;
    private int mMaxWidth;
    private int mMaxWidthMode;
    private int mMaximum;
    private int mMinMode;
    private int mMinWidth;
    private int mMinWidthMode;
    private int mMinimum;
    private qk0.a mMovement;
    private int mOldMaxMode;
    private int mOldMaximum;
    private BoringLayout mSavedHintLayout;
    private float mSpacingAdd;
    private float mSpacingMult;
    private CharSequence mText;
    private ColorStateList mTextColor;
    private TextDirectionHeuristic mTextDir;
    private TextPaint mTextPaint;
    private Drawable mTextSelectHandle;
    private Drawable mTextSelectHandleLeft;
    private int mTextSelectHandleLeftRes;
    private int mTextSelectHandleRes;
    private Drawable mTextSelectHandleRight;
    private int mTextSelectHandleRightRes;
    private TransformationMethod mTransformation;
    private CharSequence mTransformed;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class WantWidthResult {
        int des;
        boolean fromExisting;
        int width;

        WantWidthResult(int i3, int i16, boolean z16) {
            this.des = i3;
            this.width = i16;
            this.fromExisting = z16;
        }
    }

    public FasterTextView(Context context) {
        super(context);
        this.mHighlightColor = 1714664933;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMinWidth = 0;
        this.mMaximum = Integer.MAX_VALUE;
        this.mMinimum = 0;
        this.mMaxWidthMode = 2;
        this.mMinWidthMode = 2;
        this.mMaxMode = 1;
        this.mMinMode = 1;
        this.mOldMaxMode = 1;
        this.mOldMaximum = Integer.MAX_VALUE;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mGravity = 8388659;
        this.mText = "";
        this.mTransformed = "";
        this.mIncludePad = true;
        this.mBufferType = TextView.BufferType.NORMAL;
        init(context);
        initialize(context, null);
    }

    private void assumeLayout() {
        int right = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        if (right < 1) {
            right = 0;
        }
        if (this.mHorizontallyScrolling) {
            right = 1048576;
        }
        makeNewLayout(right, right);
    }

    private void checkForRelayout() {
        Layout layout;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((layoutParams.width != -2 || (this.mMaxWidthMode == this.mMinWidthMode && this.mMaxWidth == this.mMinWidth)) && ((this.mHint == null || this.mHintLayout != null) && ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight() > 0)) {
            int height = this.mLayout.getHeight();
            int width = this.mLayout.getWidth();
            Layout layout2 = this.mHintLayout;
            if (layout2 != null) {
                layout2.getWidth();
            }
            makeNewLayout(width, ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight());
            if (this.mEllipsize != TextUtils.TruncateAt.MARQUEE) {
                int i3 = layoutParams.height;
                if (i3 != -2 && i3 != -1) {
                    invalidate();
                    return;
                } else if (this.mLayout.getHeight() == height && ((layout = this.mHintLayout) == null || layout.getHeight() == height)) {
                    invalidate();
                    return;
                }
            }
            requestLayout();
            invalidate();
            return;
        }
        nullLayouts();
        requestLayout();
        invalidate();
    }

    private static int desired(Layout layout) {
        int lineCount = layout.getLineCount();
        CharSequence text = layout.getText();
        for (int i3 = 0; i3 < lineCount - 1; i3++) {
            if (text.charAt(layout.getLineEnd(i3) - 1) != '\n') {
                return -1;
            }
        }
        float f16 = 0.0f;
        for (int i16 = 0; i16 < lineCount; i16++) {
            f16 = Math.max(f16, layout.getLineWidth(i16));
        }
        return (int) Math.ceil(f16);
    }

    @RequiresApi(api = 26)
    private void fixFocusableAndClickableSettings() {
        setFocusable(16);
        setClickable(false);
        setLongClickable(false);
    }

    private int getBottomVerticalOffset(boolean z16) {
        int boxHeight;
        int height;
        Layout layout;
        int i3 = this.mGravity & 112;
        Layout layout2 = this.mLayout;
        if (!z16 && this.mText.length() == 0 && (layout = this.mHintLayout) != null) {
            layout2 = layout;
        }
        if (i3 != 80 && (height = layout2.getHeight()) < (boxHeight = getBoxHeight(layout2))) {
            if (i3 == 48) {
                return boxHeight - height;
            }
            return (boxHeight - height) >> 1;
        }
        return 0;
    }

    private int getBoxHeight(Layout layout) {
        Insets insets = Insets.NONE;
        return (getMeasuredHeight() - (getExtendedPaddingTop() + getExtendedPaddingBottom())) + insets.top + insets.bottom;
    }

    private com.tencent.fastertextview.layout.c getBuildParam(int i3, int i16) {
        CharSequence charSequence;
        int i17;
        c.a aVar = new c.a();
        if (this.mText.length() == 0 && !TextUtils.isEmpty(this.mHint)) {
            charSequence = this.mHint;
        } else {
            charSequence = this.mText;
        }
        aVar.k(charSequence);
        aVar.n(this.mTextPaint);
        aVar.j(i3);
        aVar.d(com.tencent.fastertextview.util.a.e(getTextAlignment(), this.mGravity, getLayoutDirection()));
        aVar.m(this.mSpacingMult);
        aVar.l(this.mSpacingAdd);
        aVar.h(this.mIncludePad);
        aVar.g(this.mEllipsize);
        if (this.mMaxMode == 1) {
            i17 = this.mMaximum;
        } else {
            i17 = Integer.MAX_VALUE;
        }
        aVar.i(i17);
        aVar.f(i16);
        aVar.e(this.mBreakStrategy);
        return aVar.a();
    }

    private int getDesiredHeight() {
        return Math.max(getDesiredHeight(this.mLayout, true), getDesiredHeight(this.mHintLayout, this.mEllipsize != null));
    }

    private InputMethodManager getInputMethodManager() {
        return (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
    }

    private WantWidthResult getWantWidth(int i3, int i16) {
        BoringLayout.Metrics metrics;
        boolean z16;
        int i17;
        int min;
        int max;
        BoringLayout.Metrics metrics2 = UNKNOWN_BORING;
        int i18 = -1;
        boolean z17 = false;
        if (i16 != 1073741824) {
            StaticLayout staticLayout = this.mLayout;
            if (staticLayout != null && this.mEllipsize == null) {
                i18 = desired(staticLayout);
            }
            if (i18 < 0) {
                metrics = BoringLayout.isBoring(this.mTransformed, this.mTextPaint, this.mBoring);
                if (metrics != null) {
                    this.mBoring = metrics;
                }
                z16 = false;
            } else {
                metrics = metrics2;
                z16 = true;
            }
            if (metrics != null && metrics != metrics2) {
                i17 = metrics.width;
            } else {
                if (i18 < 0) {
                    CharSequence charSequence = this.mTransformed;
                    i18 = (int) Math.ceil(Layout.getDesiredWidth(charSequence, 0, charSequence.length(), this.mTextPaint));
                }
                i17 = i18;
            }
            Drawables drawables = this.mDrawables;
            if (drawables != null) {
                i17 = Math.max(Math.max(i17, drawables.mDrawableWidthTop), drawables.mDrawableWidthBottom);
            }
            int compoundPaddingLeft = i17 + getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.mMaxWidthMode == 1) {
                min = Math.min(compoundPaddingLeft, this.mMaxWidth * getLineHeight());
            } else {
                min = Math.min(compoundPaddingLeft, this.mMaxWidth);
            }
            if (this.mMinWidthMode == 1) {
                max = Math.max(min, this.mMinWidth * getLineHeight());
            } else {
                max = Math.max(min, this.mMinWidth);
            }
            int max2 = Math.max(max, getSuggestedMinimumWidth());
            if (i16 == Integer.MIN_VALUE) {
                i3 = Math.min(i3, max2);
            } else {
                i3 = max2;
            }
            z17 = z16;
        }
        return new WantWidthResult(i18, i3, z17);
    }

    private void init(Context context) {
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = context.getResources().getDisplayMetrics().density;
        this.mHighlightPaint = new Paint(1);
    }

    /* JADX WARN: Finally extract failed */
    private void initialize(Context context, @Nullable AttributeSet attributeSet) {
        String str;
        int i3;
        int i16;
        String str2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, pk0.a.f426386a, 0, 0);
        int i17 = (int) ((context.getResources().getDisplayMetrics().density * 14.0f) + 0.5f);
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            boolean z16 = false;
            String str3 = null;
            int i29 = -1;
            int i36 = -1;
            int i37 = -1;
            Drawable drawable = null;
            Drawable drawable2 = null;
            Drawable drawable3 = null;
            Drawable drawable4 = null;
            ColorStateList colorStateList = null;
            ColorStateList colorStateList2 = null;
            ColorStateList colorStateList3 = null;
            CharSequence charSequence = null;
            int i38 = -1;
            String str4 = null;
            while (i27 < indexCount) {
                int index = obtainStyledAttributes.getIndex(i27);
                int i39 = indexCount;
                if (index == pk0.a.f426388c) {
                    i17 = obtainStyledAttributes.getDimensionPixelSize(index, i17);
                } else if (index == pk0.a.f426391f) {
                    colorStateList = obtainStyledAttributes.getColorStateList(index);
                } else {
                    if (index == pk0.a.f426409x) {
                        setSingleLineInner(obtainStyledAttributes, index);
                    } else if (index == pk0.a.f426405t) {
                        setLines(obtainStyledAttributes.getInt(index, -1));
                    } else if (index == pk0.a.f426396k) {
                        setGravity(obtainStyledAttributes.getInt(index, -1));
                    } else if (index == pk0.a.f426397l) {
                        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                    } else if (index == pk0.a.E) {
                        this.mSpacingAdd = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mSpacingAdd);
                    } else if (index == pk0.a.F) {
                        this.mSpacingMult = obtainStyledAttributes.getFloat(index, this.mSpacingMult);
                    } else if (index == pk0.a.f426399n) {
                        setMinWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                    } else if (index == pk0.a.f426400o) {
                        setMinHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                    } else if (index == pk0.a.f426398m) {
                        setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                    } else if (index == pk0.a.f426404s) {
                        setMaxLines(obtainStyledAttributes.getInt(index, -1));
                    } else if (index == pk0.a.f426407v) {
                        setMinLines(obtainStyledAttributes.getInt(index, -1));
                    } else {
                        if (index == pk0.a.f426401p) {
                            str2 = obtainStyledAttributes.getString(index);
                        } else if (index == pk0.a.f426408w) {
                            setWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                        } else if (index == pk0.a.f426406u) {
                            setHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                        } else if (index == pk0.a.f426402q) {
                            charSequence = obtainStyledAttributes.getText(index);
                        } else if (index == pk0.a.f426393h) {
                            colorStateList3 = obtainStyledAttributes.getColorStateList(index);
                        } else if (index == pk0.a.f426394i) {
                            colorStateList2 = obtainStyledAttributes.getColorStateList(index);
                        } else if (index == pk0.a.f426395j) {
                            i29 = obtainStyledAttributes.getInt(index, i29);
                        } else if (index == pk0.a.B) {
                            drawable = obtainStyledAttributes.getDrawable(index);
                        } else if (index == pk0.a.f426411z) {
                            drawable2 = obtainStyledAttributes.getDrawable(index);
                        } else if (index == pk0.a.C) {
                            drawable3 = obtainStyledAttributes.getDrawable(index);
                        } else if (index == pk0.a.A) {
                            drawable4 = obtainStyledAttributes.getDrawable(index);
                        } else if (index == pk0.a.D) {
                            i18 = obtainStyledAttributes.getDimensionPixelSize(index, i18);
                        } else if (index == pk0.a.f426410y) {
                            setIncludeFontPaddingInner(obtainStyledAttributes, index);
                        } else if (index == pk0.a.N) {
                            i38 = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                        } else if (index == pk0.a.f426387b) {
                            setEnabled(obtainStyledAttributes.getBoolean(index, isEnabled()));
                        } else if (index == pk0.a.K) {
                            this.mCursorDrawableRes = obtainStyledAttributes.getResourceId(index, 0);
                        } else if (index == pk0.a.H) {
                            this.mTextSelectHandleLeftRes = obtainStyledAttributes.getResourceId(index, 0);
                        } else if (index == pk0.a.I) {
                            this.mTextSelectHandleRightRes = obtainStyledAttributes.getResourceId(index, 0);
                        } else if (index == pk0.a.J) {
                            this.mTextSelectHandleRes = obtainStyledAttributes.getResourceId(index, 0);
                        } else {
                            i3 = i37;
                            if (index == pk0.a.f426403r) {
                                setCursorVisible(obtainStyledAttributes.getBoolean(index, true));
                                i16 = i28;
                                i28 = i16;
                                i37 = i3;
                            } else if (index == pk0.a.f426392g) {
                                i28 = obtainStyledAttributes.getColor(index, i28);
                                str2 = str3;
                                i37 = i3;
                            } else {
                                i16 = i28;
                                if (index == pk0.a.M) {
                                    this.mBreakStrategy = obtainStyledAttributes.getInt(index, 0);
                                } else if (index == pk0.a.G) {
                                    i19 = obtainStyledAttributes.getInt(index, 0);
                                } else if (index == pk0.a.L) {
                                    str4 = obtainStyledAttributes.getString(index);
                                    i28 = i16;
                                    i37 = i3;
                                    z16 = true;
                                } else if (index == pk0.a.f426390e) {
                                    i26 = obtainStyledAttributes.getInt(index, 0);
                                } else if (index == pk0.a.O) {
                                    i28 = i16;
                                    i37 = obtainStyledAttributes.getInt(index, -1);
                                } else if (index == pk0.a.f426389d) {
                                    i36 = obtainStyledAttributes.getInt(index, -1);
                                }
                                i28 = i16;
                                i37 = i3;
                            }
                        }
                        i27++;
                        str3 = str2;
                        indexCount = i39;
                    }
                    i3 = i37;
                    i16 = i28;
                    i28 = i16;
                    i37 = i3;
                }
                str2 = str3;
                i27++;
                str3 = str2;
                indexCount = i39;
            }
            int i46 = i37;
            int i47 = i28;
            obtainStyledAttributes.recycle();
            setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            setCompoundDrawablePadding(i18);
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(-16777216);
            }
            setTextColor(colorStateList);
            setTextSize(0, i17);
            setLinkTextColor(colorStateList2);
            setHintTextColor(colorStateList3);
            if (i47 != 0) {
                setHighlightColor(i47);
            }
            if (i29 != -1) {
                setEllipsize(i29);
            }
            if (!TextUtils.isEmpty(str3)) {
                setText(str3);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                setHint(charSequence);
            }
            int i48 = i38;
            if (i48 >= 0) {
                setLineHeight(i48);
            }
            if (i36 != -1 && !z16) {
                str = null;
            } else {
                str = str4;
            }
            com.tencent.fastertextview.util.a.g(this, i19, str, i36, i26, i46);
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    private boolean isLayoutChanged(int i3, int i16, int i17, int i18) {
        if (this.mLayout.getWidth() == i16 && i18 == i17 && this.mLayout.getEllipsizedWidth() == (i3 - getCompoundPaddingLeft()) - getCompoundPaddingRight()) {
            return false;
        }
        return true;
    }

    private void makeNewLayout(int i3, int i16) {
        this.mOldMaximum = this.mMaximum;
        this.mOldMaxMode = this.mMaxMode;
        com.tencent.fastertextview.layout.c buildParam = getBuildParam(i3, i16);
        com.tencent.fastertextview.layout.a aVar = com.tencent.fastertextview.layout.a.f105502a;
        StaticLayout a16 = aVar.a(buildParam);
        this.mLayout = a16;
        if (a16 == null) {
            StaticLayout a17 = com.tencent.fastertextview.layout.b.INSTANCE.a(buildParam, this.mTextPaint);
            this.mLayout = a17;
            aVar.b(buildParam, a17);
        }
    }

    private void mayCreateLayout() {
        if (getMeasuredHeight() == 0) {
            requestLayout();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.text.Spanned, android.text.Spannable] */
    /* JADX WARN: Type inference failed for: r0v7 */
    private CharSequence removeSuggestionSpans(CharSequence charSequence) {
        ?? r06;
        if (charSequence instanceof Spanned) {
            if (charSequence instanceof Spannable) {
                r06 = (Spannable) charSequence;
            } else {
                charSequence = Spannable.Factory.getInstance().newSpannable(charSequence);
                r06 = charSequence;
            }
            for (SuggestionSpan suggestionSpan : (SuggestionSpan[]) r06.getSpans(0, charSequence.length(), SuggestionSpan.class)) {
                r06.removeSpan(suggestionSpan);
            }
        }
        return charSequence;
    }

    public static int round(float f16) {
        return (int) (((f16 * 1.6777216E7f) + VasBusiness.CHAT_FONT_SWITCH) >> 24);
    }

    private void setChangeWatcherSpan(int i3, Spannable spannable) {
        for (ChangeWatcher changeWatcher : (ChangeWatcher[]) spannable.getSpans(0, spannable.length(), ChangeWatcher.class)) {
            spannable.removeSpan(changeWatcher);
        }
        if (this.mChangeWatcher == null) {
            this.mChangeWatcher = new ChangeWatcher(this);
        }
        spannable.setSpan(this.mChangeWatcher, 0, i3, 6553618);
    }

    private void setIncludeFontPaddingInner(TypedArray typedArray, int i3) {
        if (!typedArray.getBoolean(i3, true)) {
            setIncludeFontPadding(false);
        }
    }

    private void setRawTextSize(float f16, boolean z16) {
        if (f16 != this.mTextPaint.getTextSize()) {
            this.mTextPaint.setTextSize(f16);
            if (z16 && this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    private void setSingleLineInner(TypedArray typedArray, int i3) {
        if (typedArray.getBoolean(i3, false)) {
            setMaxLines(1);
        }
    }

    private void setTextPaintColor() {
        int i3 = this.mCurTextColor;
        if (this.mHint != null && this.mText.length() == 0 && this.mHintTextColor != null) {
            i3 = this.mCurHintTextColor;
        }
        this.mTextPaint.setColor(i3);
    }

    private void setTextSizeInternal(int i3, float f16, boolean z16) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i3, f16, resources.getDisplayMetrics()), z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        if (r7.mText.length() == 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateTextColors() {
        boolean z16;
        int colorForState;
        int[] drawableState = getDrawableState();
        int colorForState2 = this.mTextColor.getColorForState(drawableState, 0);
        if (colorForState2 == 0) {
            colorForState2 = this.mTextColor.getDefaultColor();
        }
        boolean z17 = true;
        if (colorForState2 != this.mCurTextColor) {
            this.mCurTextColor = colorForState2;
            z16 = true;
        } else {
            z16 = false;
        }
        ColorStateList colorStateList = this.mLinkTextColor;
        if (colorStateList != null) {
            int colorForState3 = colorStateList.getColorForState(drawableState, 0);
            if (colorForState3 == 0) {
                colorForState3 = this.mLinkTextColor.getDefaultColor();
            }
            TextPaint textPaint = this.mTextPaint;
            if (colorForState3 != textPaint.linkColor) {
                textPaint.linkColor = colorForState3;
                z16 = true;
            }
        }
        ColorStateList colorStateList2 = this.mHintTextColor;
        if (colorStateList2 != null && (colorForState = colorStateList2.getColorForState(drawableState, 0)) != this.mCurHintTextColor) {
            this.mCurHintTextColor = colorForState;
        }
        z17 = z16;
        if (z17) {
            invalidate();
        }
    }

    private void updateTransformed(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        TransformationMethod transformationMethod = this.mTransformation;
        if (transformationMethod == null) {
            this.mTransformed = charSequence;
        } else {
            this.mTransformed = transformationMethod.getTransformation(charSequence, this);
        }
        if (this.mTransformed == null) {
            this.mTransformed = "";
        }
    }

    public int getCompoundDrawablePadding() {
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            return drawables.mDrawablePadding;
        }
        return 0;
    }

    public int getCompoundPaddingBottom() {
        Drawables drawables = this.mDrawables;
        if (drawables != null && drawables.mShowing[3] != null) {
            return getPaddingBottom() + drawables.mDrawablePadding + drawables.mDrawableSizeBottom;
        }
        return getPaddingBottom();
    }

    public int getCompoundPaddingLeft() {
        Drawables drawables = this.mDrawables;
        if (drawables != null && drawables.mShowing[0] != null) {
            return getPaddingLeft() + drawables.mDrawablePadding + drawables.mDrawableSizeLeft;
        }
        return getPaddingLeft();
    }

    public int getCompoundPaddingRight() {
        Drawables drawables = this.mDrawables;
        if (drawables != null && drawables.mShowing[2] != null) {
            return getPaddingRight() + drawables.mDrawablePadding + drawables.mDrawableSizeRight;
        }
        return getPaddingRight();
    }

    public int getCompoundPaddingTop() {
        Drawables drawables = this.mDrawables;
        if (drawables != null && drawables.mShowing[1] != null) {
            return getPaddingTop() + drawables.mDrawablePadding + drawables.mDrawableSizeTop;
        }
        return getPaddingTop();
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.mEllipsize;
    }

    public int getExtendedPaddingBottom() {
        if (this.mMaxMode != 1) {
            return getCompoundPaddingBottom();
        }
        if (this.mLayout == null) {
            assumeLayout();
        }
        if (this.mLayout.getLineCount() <= this.mMaximum) {
            return getCompoundPaddingBottom();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int height = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
        int lineTop = this.mLayout.getLineTop(this.mMaximum);
        if (lineTop >= height) {
            return compoundPaddingBottom;
        }
        int i3 = this.mGravity & 112;
        if (i3 == 48) {
            return (compoundPaddingBottom + height) - lineTop;
        }
        if (i3 == 80) {
            return compoundPaddingBottom;
        }
        return compoundPaddingBottom + ((height - lineTop) / 2);
    }

    public int getExtendedPaddingTop() {
        if (this.mMaxMode != 1) {
            return getCompoundPaddingTop();
        }
        if (this.mLayout == null) {
            assumeLayout();
        }
        if (this.mLayout.getLineCount() <= this.mMaximum) {
            return getCompoundPaddingTop();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
        int lineTop = this.mLayout.getLineTop(this.mMaximum);
        if (lineTop >= height) {
            return compoundPaddingTop;
        }
        int i3 = this.mGravity & 112;
        if (i3 == 48) {
            return compoundPaddingTop;
        }
        if (i3 == 80) {
            return (compoundPaddingTop + height) - lineTop;
        }
        return compoundPaddingTop + ((height - lineTop) / 2);
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getHighlightColor() {
        return this.mHighlightColor;
    }

    public int getHorizontalOffsetForDrawables() {
        return 0;
    }

    public boolean getHorizontallyScrolling() {
        return this.mHorizontallyScrolling;
    }

    public Layout getLayout() {
        return this.mLayout;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.mLayout;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public int getLineHeight() {
        return round((this.mTextPaint.getFontMetricsInt(null) * this.mSpacingMult) + this.mSpacingAdd);
    }

    public float getLineSpacingExtra() {
        return this.mSpacingAdd;
    }

    public float getLineSpacingMultiplier() {
        return this.mSpacingMult;
    }

    public int getMaxEms() {
        if (this.mMaxWidthMode == 1) {
            return this.mMaxWidth;
        }
        return -1;
    }

    public int getMaxHeight() {
        if (this.mMaxMode == 2) {
            return this.mMaximum;
        }
        return -1;
    }

    public int getMaxLines() {
        if (this.mMaxMode == 1) {
            return this.mMaximum;
        }
        return -1;
    }

    public int getMaxWidth() {
        if (this.mMaxWidthMode == 2) {
            return this.mMaxWidth;
        }
        return -1;
    }

    public int getMinHeight() {
        if (this.mMinMode == 2) {
            return this.mMinimum;
        }
        return -1;
    }

    public int getMinLines() {
        if (this.mMinMode == 1) {
            return this.mMinimum;
        }
        return -1;
    }

    public int getMinWidth() {
        if (this.mMinWidthMode == 2) {
            return this.mMinWidth;
        }
        return -1;
    }

    public final qk0.a getMovementMethod() {
        return null;
    }

    public TextPaint getPaint() {
        return this.mTextPaint;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public ColorStateList getTextColors() {
        return this.mTextColor;
    }

    public Drawable getTextCursorDrawable() {
        if (this.mCursorDrawable == null && this.mCursorDrawableRes != 0) {
            this.mCursorDrawable = getContext().getDrawable(this.mCursorDrawableRes);
        }
        return this.mCursorDrawable;
    }

    public TextDirectionHeuristic getTextDirectionHeuristic() {
        boolean z16 = true;
        if (getLayoutDirection() != 1) {
            z16 = false;
        }
        switch (getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                if (z16) {
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                }
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    public Drawable getTextSelectHandle() {
        if (this.mTextSelectHandle == null && this.mTextSelectHandleRes != 0) {
            this.mTextSelectHandle = getContext().getDrawable(this.mTextSelectHandleRes);
        }
        return this.mTextSelectHandle;
    }

    public Drawable getTextSelectHandleLeft() {
        if (this.mTextSelectHandleLeft == null && this.mTextSelectHandleLeftRes != 0) {
            this.mTextSelectHandleLeft = getContext().getDrawable(this.mTextSelectHandleLeftRes);
        }
        return this.mTextSelectHandleLeft;
    }

    public Drawable getTextSelectHandleRight() {
        if (this.mTextSelectHandleRight == null && this.mTextSelectHandleRightRes != 0) {
            this.mTextSelectHandleRight = getContext().getDrawable(this.mTextSelectHandleRightRes);
        }
        return this.mTextSelectHandleRight;
    }

    public int getTotalPaddingBottom() {
        return getExtendedPaddingBottom() + getBottomVerticalOffset(true);
    }

    public int getTotalPaddingLeft() {
        return getCompoundPaddingLeft();
    }

    public int getTotalPaddingRight() {
        return getCompoundPaddingRight();
    }

    public int getTotalPaddingTop() {
        return getExtendedPaddingTop() + getVerticalOffset(true);
    }

    int getVerticalOffset(boolean z16) {
        int boxHeight;
        int height;
        Layout layout;
        int i3 = this.mGravity & 112;
        Layout layout2 = this.mLayout;
        if (!z16 && this.mText.length() == 0 && (layout = this.mHintLayout) != null) {
            layout2 = layout;
        }
        if (i3 != 48 && (height = layout2.getHeight()) < (boxHeight = getBoxHeight(layout2))) {
            if (i3 == 80) {
                return boxHeight - height;
            }
            return (boxHeight - height) >> 1;
        }
        return 0;
    }

    public boolean isLayoutRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public void nullLayouts() {
        Layout layout = this.mHintLayout;
        if ((layout instanceof BoringLayout) && this.mSavedHintLayout == null) {
            this.mSavedHintLayout = (BoringLayout) layout;
        }
        this.mLayout = null;
        this.mBoring = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.WrappedTextView, android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        float f16;
        int i16;
        int i17;
        if (this.mLayout == null) {
            return;
        }
        super.onDraw(canvas);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int right = getRight();
        int left = getLeft();
        int bottom = getBottom();
        int top = getTop();
        boolean isLayoutRtl = isLayoutRtl();
        int horizontalOffsetForDrawables = getHorizontalOffsetForDrawables();
        if (isLayoutRtl) {
            i3 = 0;
        } else {
            i3 = horizontalOffsetForDrawables;
        }
        if (!isLayoutRtl) {
            horizontalOffsetForDrawables = 0;
        }
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            int i18 = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
            int i19 = ((right - left) - compoundPaddingRight) - compoundPaddingLeft;
            if (drawables.mShowing[0] != null) {
                canvas.save();
                canvas.translate(getPaddingLeft() + scrollX + i3, scrollY + compoundPaddingTop + ((i18 - drawables.mDrawableHeightLeft) / 2));
                drawables.mShowing[0].draw(canvas);
                canvas.restore();
            }
            if (drawables.mShowing[2] != null) {
                canvas.save();
                canvas.translate(((((scrollX + right) - left) - getPaddingRight()) - drawables.mDrawableSizeRight) - horizontalOffsetForDrawables, scrollY + compoundPaddingTop + ((i18 - drawables.mDrawableHeightRight) / 2));
                drawables.mShowing[2].draw(canvas);
                canvas.restore();
            }
            if (drawables.mShowing[1] != null) {
                canvas.save();
                canvas.translate(scrollX + compoundPaddingLeft + ((i19 - drawables.mDrawableWidthTop) / 2), getPaddingTop() + scrollY);
                drawables.mShowing[1].draw(canvas);
                canvas.restore();
            }
            if (drawables.mShowing[3] != null) {
                canvas.save();
                canvas.translate(scrollX + compoundPaddingLeft + ((i19 - drawables.mDrawableWidthBottom) / 2), (((scrollY + bottom) - top) - getPaddingBottom()) - drawables.mDrawableSizeBottom);
                drawables.mShowing[3].draw(canvas);
                canvas.restore();
            }
        }
        setTextPaintColor();
        canvas.save();
        int extendedPaddingTop = getExtendedPaddingTop();
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int height = this.mLayout.getHeight() - (((getBottom() - getTop()) - compoundPaddingBottom) - compoundPaddingTop);
        float f17 = compoundPaddingLeft + scrollX;
        if (scrollY == 0) {
            f16 = 0.0f;
        } else {
            f16 = extendedPaddingTop + scrollY;
        }
        float compoundPaddingRight2 = ((right - left) - getCompoundPaddingRight()) + scrollX;
        int i26 = (bottom - top) + scrollY;
        if (scrollY == height) {
            extendedPaddingBottom = 0;
        }
        canvas.clipRect(f17, f16, compoundPaddingRight2, i26 - extendedPaddingBottom);
        if ((this.mGravity & 112) != 48) {
            i17 = getVerticalOffset(false);
            i16 = getVerticalOffset(true);
        } else {
            i16 = 0;
            i17 = 0;
        }
        canvas.translate(compoundPaddingLeft, extendedPaddingTop + i17);
        this.mLayout.draw(canvas, null, this.mHighlightPaint, i16 - i17);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        int width;
        boolean z16;
        boolean z17;
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        WantWidthResult wantWidth = getWantWidth(size, mode);
        int i18 = wantWidth.des;
        boolean z18 = wantWidth.fromExisting;
        int i19 = wantWidth.width;
        if (this.mTextDir == null) {
            this.mTextDir = getTextDirectionHeuristic();
        }
        int compoundPaddingLeft = (i19 - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        if (this.mHorizontallyScrolling) {
            i17 = 1048576;
        } else {
            i17 = compoundPaddingLeft;
        }
        Layout layout = this.mHintLayout;
        if (layout == null) {
            width = i17;
        } else {
            width = layout.getWidth();
        }
        if (this.mLayout == null) {
            makeNewLayout(i17, i17);
        } else {
            boolean isLayoutChanged = isLayoutChanged(i19, i17, i17, width);
            if (this.mHint == null && this.mEllipsize == null && i17 > this.mLayout.getWidth() && z18 && i18 >= 0 && i18 <= i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.mMaxMode == this.mOldMaxMode && this.mMaximum == this.mOldMaximum) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (isLayoutChanged || z17) {
                if (!z17 && z16) {
                    this.mLayout.increaseWidthTo(i17);
                } else {
                    makeNewLayout(i17, i17);
                }
            }
        }
        if (mode2 != 1073741824) {
            int desiredHeight = getDesiredHeight();
            if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(desiredHeight, size2);
            } else {
                size2 = desiredHeight;
            }
        }
        int compoundPaddingTop = (size2 - getCompoundPaddingTop()) - getCompoundPaddingBottom();
        if (this.mMaxMode == 1) {
            int lineCount = this.mLayout.getLineCount();
            int i26 = this.mMaximum;
            if (lineCount > i26) {
                compoundPaddingTop = Math.min(compoundPaddingTop, this.mLayout.getLineTop(i26));
            }
        }
        if (this.mLayout.getWidth() <= compoundPaddingLeft && this.mLayout.getHeight() <= compoundPaddingTop) {
            scrollTo(0, 0);
        }
        setMeasuredDimension(i19, size2);
    }

    protected void onSelectionChanged(int i3, int i16) {
        sendAccessibilityEvent(8192);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (onCheckIsTextEditor() && isEnabled()) {
            boolean z16 = this.mText instanceof Spannable;
        }
        return onTouchEvent;
    }

    public Pair<com.tencent.fastertextview.layout.c, Layout> preCreateLayout(int i3, int i16) {
        int compoundPaddingLeft = (getWantWidth(i3, i16).width - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        setTextPaintColor();
        com.tencent.fastertextview.layout.c buildParam = getBuildParam(compoundPaddingLeft, compoundPaddingLeft);
        StaticLayout a16 = com.tencent.fastertextview.layout.a.f105502a.a(buildParam);
        if (a16 == null) {
            a16 = com.tencent.fastertextview.layout.b.INSTANCE.a(buildParam, this.mTextPaint);
        }
        return new Pair<>(buildParam, a16);
    }

    @Override // android.widget.WrappedTextView
    public void setBreakStrategy(int i3) {
        super.setBreakStrategy(i3);
        this.mBreakStrategy = i3;
        if (this.mLayout != null) {
            nullLayouts();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.widget.WrappedTextView
    public void setCompoundDrawablePadding(int i3) {
        super.setCompoundDrawablePadding(i3);
        Drawables drawables = this.mDrawables;
        if (i3 == 0) {
            if (drawables != null) {
                drawables.mDrawablePadding = i3;
            }
        } else {
            if (drawables == null) {
                drawables = new Drawables(getContext());
                this.mDrawables = drawables;
            }
            drawables.mDrawablePadding = i3;
        }
        invalidate();
        requestLayout();
    }

    @Override // android.widget.WrappedTextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        boolean z16;
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            drawables.discardRelative();
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (drawables != null) {
                if (!drawables.hasMetadata()) {
                    this.mDrawables = null;
                } else {
                    drawables.clearByMetadata();
                }
            }
        } else {
            if (drawables == null) {
                drawables = new Drawables(getContext());
                this.mDrawables = drawables;
            }
            drawables.updateDrawables(drawable, drawable2, drawable3, drawable4, getDrawableState(), this);
        }
        if (drawables != null) {
            drawables.mDrawableLeftInitial = drawable;
            drawables.mDrawableRightInitial = drawable3;
        }
        invalidate();
        requestLayout();
    }

    @Override // android.widget.WrappedTextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, drawable4.getIntrinsicWidth(), drawable4.getIntrinsicHeight());
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setCursorVisible(boolean z16) {
        if (z16) {
        } else {
            throw new RuntimeException("cursorVisible : false not support");
        }
    }

    @Override // android.widget.WrappedTextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        super.setEllipsize(truncateAt);
        if (this.mEllipsize != truncateAt) {
            this.mEllipsize = truncateAt;
            mayCreateLayout();
        }
    }

    @Override // android.widget.WrappedTextView, android.view.View
    public void setEnabled(boolean z16) {
        InputMethodManager inputMethodManager;
        InputMethodManager inputMethodManager2;
        if (z16 == isEnabled()) {
            return;
        }
        if (!z16 && (inputMethodManager2 = getInputMethodManager()) != null && inputMethodManager2.isActive(this)) {
            inputMethodManager2.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        super.setEnabled(z16);
        if (z16 && (inputMethodManager = getInputMethodManager()) != null) {
            inputMethodManager.restartInput(this);
        }
    }

    @Override // android.widget.WrappedTextView
    public void setGravity(int i3) {
        boolean z16;
        super.setGravity(i3);
        if ((i3 & 8388615) == 0) {
            i3 |= 8388611;
        }
        if ((i3 & 112) == 0) {
            i3 |= 48;
        }
        int i16 = i3 & 8388615;
        int i17 = this.mGravity;
        if (i16 != (8388615 & i17)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 != i17) {
            invalidate();
        }
        this.mGravity = i3;
        if (this.mLayout != null && z16) {
            makeNewLayout(getMeasuredWidth(), getMeasuredWidth());
        }
    }

    @Override // android.widget.WrappedTextView
    public void setHeight(int i3) {
        super.setHeight(i3);
        this.mMinimum = i3;
        this.mMaximum = i3;
        this.mMinMode = 2;
        this.mMaxMode = 2;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.WrappedTextView
    public void setHighlightColor(@ColorInt int i3) {
        super.setHighlightColor(i3);
        if (this.mHighlightColor != i3) {
            this.mHighlightColor = i3;
            invalidate();
        }
    }

    public final void setHint(@StringRes int i3) {
        setHint(getContext().getResources().getText(i3));
    }

    @Override // android.widget.WrappedTextView
    public final void setHintTextColor(@ColorInt int i3) {
        super.setHintTextColor(i3);
        this.mHintTextColor = ColorStateList.valueOf(i3);
        updateTextColors();
    }

    @Override // android.widget.WrappedTextView
    public void setHorizontallyScrolling(boolean z16) {
        if (this.mHorizontallyScrolling != z16) {
            this.mHorizontallyScrolling = z16;
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
        super.setHorizontallyScrolling(z16);
    }

    @Override // android.widget.WrappedTextView
    public void setIncludeFontPadding(boolean z16) {
        super.setIncludeFontPadding(z16);
        if (z16 != this.mIncludePad) {
            this.mIncludePad = z16;
            mayCreateLayout();
        }
    }

    public void setLineHeight(int i3) {
        if (i3 != getPaint().getFontMetricsInt(null)) {
            setLineSpacing(i3 - r0, 1.0f);
        }
    }

    @Override // android.widget.WrappedTextView
    public void setLineSpacing(float f16, float f17) {
        if (this.mSpacingAdd != f16 || this.mSpacingMult != f17) {
            this.mSpacingAdd = f16;
            this.mSpacingMult = f17;
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
        super.setLineSpacing(f16, f17);
    }

    @Override // android.widget.WrappedTextView
    public void setLines(int i3) {
        super.setLines(i3);
        this.mMinimum = i3;
        this.mMaximum = i3;
        this.mMinMode = 1;
        this.mMaxMode = 1;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.WrappedTextView
    public final void setLinkTextColor(@ColorInt int i3) {
        super.setLinkTextColor(i3);
        this.mLinkTextColor = ColorStateList.valueOf(i3);
        updateTextColors();
    }

    @Override // android.widget.WrappedTextView
    public void setMaxHeight(int i3) {
        super.setMaxHeight(i3);
        this.mMaximum = i3;
        this.mMaxMode = 2;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.WrappedTextView
    public void setMaxLines(int i3) {
        super.setMaxLines(i3);
        this.mMaximum = i3;
        this.mMaxMode = 1;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.WrappedTextView
    public void setMaxWidth(int i3) {
        super.setMaxWidth(i3);
        this.mMaxWidth = i3;
        this.mMaxWidthMode = 2;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.WrappedTextView
    public void setMinHeight(int i3) {
        super.setMinHeight(i3);
        this.mMinimum = i3;
        this.mMinMode = 2;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.WrappedTextView
    public void setMinLines(int i3) {
        super.setMinLines(i3);
        this.mMinimum = i3;
        this.mMinMode = 1;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.WrappedTextView
    public void setMinWidth(int i3) {
        super.setMinWidth(i3);
        this.mMinWidth = i3;
        this.mMinWidthMode = 2;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.WrappedTextView
    public final void setMovementMethod(qk0.a aVar) {
        super.setMovementMethod(aVar);
        if (aVar != null) {
            if (aVar != null) {
                CharSequence charSequence = this.mText;
                if (!(charSequence instanceof Spannable)) {
                    setText(charSequence);
                }
            }
            if (Build.VERSION.SDK_INT >= 26) {
                fixFocusableAndClickableSettings();
            }
        }
    }

    @Override // android.widget.WrappedTextView
    public void setSingleLine(boolean z16) {
        throw new RuntimeException("");
    }

    public void setText(CharSequence charSequence) {
        setText(charSequence, this.mBufferType);
    }

    @Override // android.widget.WrappedTextView
    public void setTextColor(@ColorInt int i3) {
        super.setTextColor(i3);
        this.mTextColor = ColorStateList.valueOf(i3);
        updateTextColors();
    }

    @Override // android.widget.WrappedTextView
    public void setTextCursorDrawable(Drawable drawable) {
        this.mCursorDrawable = drawable;
        this.mCursorDrawableRes = 0;
        super.setTextCursorDrawable(drawable);
    }

    @Override // android.widget.WrappedTextView
    public void setTextSelectHandle(Drawable drawable) {
        this.mTextSelectHandle = drawable;
        this.mTextSelectHandleRes = 0;
        super.setTextSelectHandle(drawable);
    }

    @Override // android.widget.WrappedTextView
    public void setTextSelectHandleLeft(Drawable drawable) {
        this.mTextSelectHandleLeft = drawable;
        this.mTextSelectHandleLeftRes = 0;
        super.setTextSelectHandleLeft(drawable);
    }

    @Override // android.widget.WrappedTextView
    public void setTextSelectHandleRight(Drawable drawable) {
        this.mTextSelectHandleRight = drawable;
        this.mTextSelectHandleRightRes = 0;
        super.setTextSelectHandleRight(drawable);
    }

    @Override // android.widget.WrappedTextView
    public void setTextSize(float f16) {
        super.setTextSize(f16);
        setTextSize(2, f16);
    }

    @Override // android.widget.WrappedTextView
    public void setTypeface(Typeface typeface, int i3) {
        if (i3 > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
            setTypeface(defaultFromStyle);
            int i16 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i3;
            this.mTextPaint.setFakeBoldText((i16 & 1) != 0);
            this.mTextPaint.setTextSkewX((i16 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    @Override // android.widget.WrappedTextView
    public void setWidth(int i3) {
        super.setWidth(i3);
        this.mMinWidth = i3;
        this.mMaxWidth = i3;
        this.mMinWidthMode = 2;
        this.mMaxWidthMode = 2;
        requestLayout();
        invalidate();
    }

    void spanChange(Spanned spanned, Object obj, int i3, int i16, int i17, int i18) {
        if ((obj instanceof UpdateAppearance) || (obj instanceof ParagraphStyle) || (obj instanceof CharacterStyle)) {
            invalidate();
        }
    }

    private int getDesiredHeight(Layout layout, boolean z16) {
        int i3;
        if (layout == null) {
            return 0;
        }
        int lineCount = layout.getLineCount();
        int lineTop = layout.getLineTop(lineCount);
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            lineTop = Math.max(Math.max(lineTop, drawables.mDrawableHeightLeft), drawables.mDrawableHeightRight);
        }
        int compoundPaddingTop = getCompoundPaddingTop() + getCompoundPaddingBottom();
        int i16 = lineTop + compoundPaddingTop;
        if (this.mMaxMode != 1) {
            i16 = Math.min(i16, this.mMaximum);
        } else if (z16 && lineCount > (i3 = this.mMaximum) && ((layout instanceof DynamicLayout) || (layout instanceof BoringLayout))) {
            int lineTop2 = layout.getLineTop(i3);
            if (drawables != null) {
                lineTop2 = Math.max(Math.max(lineTop2, drawables.mDrawableHeightLeft), drawables.mDrawableHeightRight);
            }
            i16 = lineTop2 + compoundPaddingTop;
            lineCount = this.mMaximum;
        }
        if (this.mMinMode == 1) {
            if (lineCount < this.mMinimum) {
                i16 += getLineHeight() * (this.mMinimum - lineCount);
            }
        } else {
            i16 = Math.max(i16, this.mMinimum);
        }
        return Math.max(i16, getSuggestedMinimumHeight());
    }

    @Override // android.widget.WrappedTextView
    public final void setHint(CharSequence charSequence) {
        super.setHint(charSequence);
        this.mHint = TextUtils.stringOrSpannedString(charSequence);
        if (this.mLayout != null) {
            checkForRelayout();
        }
        if (this.mText.length() == 0) {
            invalidate();
        }
    }

    @Override // android.widget.WrappedTextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(charSequence, bufferType);
        this.mBufferType = bufferType;
        CharSequence removeSuggestionSpans = removeSuggestionSpans(charSequence);
        if (bufferType != TextView.BufferType.SPANNABLE) {
            if (bufferType == TextView.BufferType.NORMAL) {
                removeSuggestionSpans = TextUtils.stringOrSpannedString(removeSuggestionSpans);
            }
        } else {
            removeSuggestionSpans = Spannable.Factory.getInstance().newSpannable(removeSuggestionSpans);
        }
        this.mText = removeSuggestionSpans;
        updateTransformed(removeSuggestionSpans);
        int length = removeSuggestionSpans.length();
        if (removeSuggestionSpans instanceof Spannable) {
            Spannable spannable = (Spannable) removeSuggestionSpans;
            setChangeWatcherSpan(length, spannable);
            TransformationMethod transformationMethod = this.mTransformation;
            if (transformationMethod != null) {
                spannable.setSpan(transformationMethod, 0, length, 18);
            }
        }
        if (this.mLayout != null) {
            checkForRelayout();
        }
    }

    @Override // android.widget.WrappedTextView
    public void setTextSize(int i3, float f16) {
        super.setTextSize(i3, f16);
        setTextSizeInternal(i3, f16, true);
    }

    @Override // android.widget.WrappedTextView
    public final void setHintTextColor(ColorStateList colorStateList) {
        super.setHintTextColor(colorStateList);
        this.mHintTextColor = colorStateList;
        updateTextColors();
    }

    @Override // android.widget.WrappedTextView
    public final void setLinkTextColor(ColorStateList colorStateList) {
        super.setLinkTextColor(colorStateList);
        this.mLinkTextColor = colorStateList;
        updateTextColors();
    }

    @Override // android.widget.WrappedTextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        colorStateList.getClass();
        this.mTextColor = colorStateList;
        updateTextColors();
    }

    @Override // android.widget.WrappedTextView
    public void setTextCursorDrawable(@DrawableRes int i3) {
        setTextCursorDrawable(i3 != 0 ? getContext().getDrawable(i3) : null);
    }

    @Override // android.widget.WrappedTextView
    public void setTextSelectHandle(@DrawableRes int i3) {
        setTextSelectHandle(getContext().getDrawable(i3));
    }

    @Override // android.widget.WrappedTextView
    public void setTextSelectHandleLeft(@DrawableRes int i3) {
        setTextSelectHandleLeft(getContext().getDrawable(i3));
    }

    @Override // android.widget.WrappedTextView
    public void setTextSelectHandleRight(@DrawableRes int i3) {
        setTextSelectHandleRight(getContext().getDrawable(i3));
    }

    private void setEllipsize(int i3) {
        if (i3 == 1) {
            setEllipsize(TextUtils.TruncateAt.START);
        } else if (i3 == 2) {
            setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else {
            if (i3 != 3) {
                return;
            }
            setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Override // android.widget.WrappedTextView
    public void setTypeface(Typeface typeface) {
        if (this.mTextPaint.getTypeface() != typeface) {
            this.mTextPaint.setTypeface(typeface);
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ChangeWatcher implements TextWatcher, SpanWatcher {
        private WeakReference<FasterTextView> mWeakRef;

        public ChangeWatcher(FasterTextView fasterTextView) {
            this.mWeakRef = new WeakReference<>(fasterTextView);
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i3, int i16) {
            FasterTextView fasterTextView = this.mWeakRef.get();
            if (fasterTextView != null) {
                fasterTextView.spanChange(spannable, obj, -1, i3, -1, i16);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i3, int i16, int i17, int i18) {
            FasterTextView fasterTextView = this.mWeakRef.get();
            if (fasterTextView != null) {
                fasterTextView.spanChange(spannable, obj, i3, i17, i16, i18);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i3, int i16) {
            FasterTextView fasterTextView = this.mWeakRef.get();
            if (fasterTextView != null) {
                fasterTextView.spanChange(spannable, obj, i3, -1, i16, -1);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    public FasterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHighlightColor = 1714664933;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMinWidth = 0;
        this.mMaximum = Integer.MAX_VALUE;
        this.mMinimum = 0;
        this.mMaxWidthMode = 2;
        this.mMinWidthMode = 2;
        this.mMaxMode = 1;
        this.mMinMode = 1;
        this.mOldMaxMode = 1;
        this.mOldMaximum = Integer.MAX_VALUE;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mGravity = 8388659;
        this.mText = "";
        this.mTransformed = "";
        this.mIncludePad = true;
        this.mBufferType = TextView.BufferType.NORMAL;
        init(context);
        initialize(context, attributeSet);
    }

    public FasterTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mHighlightColor = 1714664933;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMinWidth = 0;
        this.mMaximum = Integer.MAX_VALUE;
        this.mMinimum = 0;
        this.mMaxWidthMode = 2;
        this.mMinWidthMode = 2;
        this.mMaxMode = 1;
        this.mMinMode = 1;
        this.mOldMaxMode = 1;
        this.mOldMaximum = Integer.MAX_VALUE;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mGravity = 8388659;
        this.mText = "";
        this.mTransformed = "";
        this.mIncludePad = true;
        this.mBufferType = TextView.BufferType.NORMAL;
        init(context);
        initialize(context, attributeSet);
    }
}
