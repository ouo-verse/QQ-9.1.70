package com.tencent.ditto.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.google.android.exoplayer2.C;
import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoBitmapCache;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.DittoResourcesUtil;
import com.tencent.ditto.widget.text.StaticLayoutWithMaxLines;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoTextArea extends DittoArea {

    @DittoJsonElement("\u5b57\u4f53")
    public static final String FONT_FAMILY = "font_family";

    @DittoJsonElement("\u5b57\u95f4\u8ddd, \u9ed8\u8ba40, \u5355\u4f4dem")
    public static final String LETTER_SPACE = "text_letter_space";
    public static final String LineSpace = "line_space";
    public static final String LinkColor = "link_color";
    public static final String MaxLine = "max_line";

    @DittoJsonElement("\u6587\u5b57\u9634\u5f71\u989c\u8272")
    public static final String SHADOW_BG_COLOR = "shadow_bg_color";

    @DittoJsonElement("\u6587\u5b57\u9634\u5f71dx, \u5355\u4f4d\u9ed8\u8ba4px")
    public static final String SHADOW_DX = "shadow_dx";

    @DittoJsonElement("\u6587\u5b57\u9634\u5f71dy")
    public static final String SHADOW_DY = "shadow_dy";

    @DittoJsonElement("\u6587\u5b57\u9634\u5f71\u5706\u89d2")
    public static final String SHADOW_RADIUS = "shadow_radius";
    private static final String TAG = "DittoTextArea";
    public static final String Text = "text";

    @DittoJsonElement
    public static final String TextAlignment = "text_alignment";
    public static final String TextBold = "text_bold";
    public static final String TextColor = "text_color";
    public static final String TextSize = "text_size";
    private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
    private boolean isDirty;
    public float letterSpace;
    public BoringLayout.Metrics mBoring;
    private Integer mCacheKey;
    private TextCache mCacheText;
    private int mCurTextColor;
    private float mCurrTextSize;
    private TextUtils.TruncateAt mEllipsize;
    public String mFontFamily;
    private boolean mIncludeFontPadding;
    private Layout.Alignment mLayoutAlignment;
    public int mLineSpace;
    private float mLineSpacingAdd;
    private float mLineSpacingMult;
    private int mMaxLines;
    private int mOldMaxLines;
    private TextPaint mPaint;
    protected String mText;
    public boolean mTextBold;
    public Typeface mTypeface;
    public int shadowBgColor;
    public float shadowDx;
    public float shadowDy;
    public float shadowRadius;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class TextCache extends DittoBitmapCache {
        private Layout mLayout;
        private int measuredHeight;
        private int measuredWidth;

        TextCache() {
        }
    }

    public DittoTextArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mText = "";
        this.mTextBold = false;
        this.mMaxLines = Integer.MAX_VALUE;
        this.mOldMaxLines = Integer.MAX_VALUE;
        this.mLineSpace = 2;
        this.letterSpace = 0.0f;
        this.mLineSpacingMult = 1.0f;
        this.mLineSpacingAdd = 0.0f;
        this.mIncludeFontPadding = true;
        this.mLayoutAlignment = Layout.Alignment.ALIGN_NORMAL;
        this.mCacheText = null;
        this.isDirty = false;
        this.shadowDx = Float.MIN_VALUE;
        this.shadowDy = Float.MIN_VALUE;
        this.shadowRadius = Float.MIN_VALUE;
        this.shadowBgColor = 0;
        this.mTypeface = Typeface.DEFAULT;
        this.mFontFamily = "sans-serif";
        setEllipsize(TextUtils.TruncateAt.END);
    }

    private Integer generateCacheKey() {
        return Integer.valueOf((this.mText + "_" + this.mCurTextColor + "_" + this.mCurrTextSize + "_" + this.mLayoutAlignment + "_" + this.mEllipsize + "_" + this.letterSpace + "_" + this.mFontFamily).hashCode());
    }

    private int getDesiredHeight() {
        TextCache textCache = this.mCacheText;
        if (textCache != null && textCache.mLayout != null) {
            return this.mCacheText.mLayout.getLineTop(Math.min(this.mMaxLines, this.mCacheText.mLayout.getLineCount())) + getPaddingTop() + getPaddingBottom();
        }
        return 0;
    }

    private Layout makeNewLayout(int i3, BoringLayout.Metrics metrics, int i16, boolean z16) {
        int i17;
        boolean z17 = false;
        if (i3 < 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        this.mOldMaxLines = this.mMaxLines;
        TextUtils.TruncateAt truncateAt = this.mEllipsize;
        if (truncateAt != null) {
            z17 = true;
        }
        return makeSingleLayout(i17, metrics, i16, this.mLayoutAlignment, z17, truncateAt, z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        if (r1 > r14) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return android.text.BoringLayout.make(r2, r13.mPaint, r14, r17, r13.mLineSpacingMult, r13.mLineSpacingAdd, r7, r13.mIncludeFontPadding, r19, r16);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Layout makeSingleLayout(int i3, BoringLayout.Metrics metrics, int i16, Layout.Alignment alignment, boolean z16, TextUtils.TruncateAt truncateAt, boolean z17) {
        BoringLayout.Metrics metrics2;
        String str = this.mText;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        if (metrics == UNKNOWN_BORING) {
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(str2, this.mPaint, this.mBoring);
            if (isBoring != null) {
                this.mBoring = isBoring;
            }
            metrics2 = isBoring;
        } else {
            metrics2 = metrics;
        }
        if (metrics2 != null) {
            int i17 = metrics2.width;
            if (i17 <= i3 && (truncateAt == null || i17 <= i16)) {
                return BoringLayout.make(str2, this.mPaint, i3, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, metrics2, this.mIncludeFontPadding);
            }
            if (z16) {
                return StaticLayoutWithMaxLines.create(str2, 0, str2.length(), this.mPaint, i3, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, truncateAt, i16, this.mMaxLines);
            }
            return new StaticLayout(str2, this.mPaint, i3, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
        }
        if (z16) {
            return StaticLayoutWithMaxLines.create(str2, 0, str2.length(), this.mPaint, i3, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, truncateAt, i16, this.mMaxLines);
        }
        return new StaticLayout(str2, this.mPaint, i3, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
    }

    public int getMaxLines() {
        return this.mMaxLines;
    }

    public CharSequence getText() {
        return this.mText;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() != 0 && getHeight() != 0) {
            TextCache textCache = this.mCacheText;
            if (textCache != null && textCache.getBitmap() != null) {
                canvas.drawBitmap(this.mCacheText.getBitmap(), 0.0f, 0.0f, (Paint) null);
                return;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(createBitmap);
                TextCache textCache2 = this.mCacheText;
                if (textCache2 != null && textCache2.mLayout != null) {
                    this.mCacheText.mLayout.draw(canvas2);
                    this.mCacheText.setBitmap(createBitmap);
                }
                TextCache textCache3 = this.mCacheText;
                if (textCache3 != null) {
                    canvas.drawBitmap(textCache3.getBitmap(), 0.0f, 0.0f, (Paint) null);
                }
            } catch (Exception e16) {
                DittoLog.e(DittoLog.defaultTag, "create bitmap failed", e16);
            }
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onLayout(int i3, int i16, int i17, int i18) {
        super.onLayout(i3, i16, i17, i18);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        if (this.isDirty || this.mCacheKey == null) {
            this.mCacheKey = generateCacheKey();
            this.isDirty = false;
        }
        TextCache textCache = (TextCache) getAreaCache(this.mCacheKey, TextCache.class);
        this.mCacheText = textCache;
        if (textCache != null && textCache.mLayout != null && !this.mMeasureDirty) {
            setMeasuredDimension(this.mCacheText.measuredWidth, this.mCacheText.measuredHeight);
            return;
        }
        TextCache textCache2 = new TextCache();
        this.mCacheText = textCache2;
        addAreaCache(this.mCacheKey, textCache2);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == 1073741824) {
            this.mCacheText.measuredWidth = size;
        } else {
            String str = this.mText;
            if (str == null) {
                str = "";
            }
            TextPaint textPaint = this.mPaint;
            BoringLayout.Metrics metrics = UNKNOWN_BORING;
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(str, textPaint, metrics);
            this.mBoring = isBoring;
            if (isBoring != null && isBoring != metrics) {
                this.mCacheText.measuredWidth = isBoring.width;
            } else {
                this.mCacheText.measuredWidth = (int) Layout.getDesiredWidth(str, this.mPaint);
            }
            this.mCacheText.measuredWidth += this.paddingLeft + this.paddingRight;
            if (mode == Integer.MIN_VALUE) {
                TextCache textCache3 = this.mCacheText;
                textCache3.measuredWidth = Math.min(size, textCache3.measuredWidth);
            }
        }
        int i17 = (this.mCacheText.measuredWidth - this.paddingLeft) - this.paddingRight;
        this.mCacheText.mLayout = makeNewLayout(i17, this.mBoring, i17, false);
        if (mode2 == 1073741824) {
            this.mCacheText.measuredHeight = size2;
        } else {
            this.mCacheText.measuredHeight = getDesiredHeight();
            if (mode2 == Integer.MIN_VALUE) {
                TextCache textCache4 = this.mCacheText;
                textCache4.measuredHeight = Math.min(size2, textCache4.measuredHeight);
            }
        }
        setMeasuredDimension(this.mCacheText.measuredWidth, this.mCacheText.measuredHeight);
    }

    public void setDirty(boolean z16) {
        this.isDirty = z16;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.mEllipsize == truncateAt) {
            return;
        }
        this.isDirty = true;
        this.mEllipsize = truncateAt;
    }

    protected void setFontFamily(String str) {
        this.mFontFamily = str;
        if ("sans-serif".equals(str)) {
            this.mTypeface = Typeface.SANS_SERIF;
            this.mFontFamily = str;
        } else if (C.SERIF_NAME.equals(str)) {
            this.mTypeface = Typeface.SERIF;
        } else if ("monospace".equals(str)) {
            this.mTypeface = Typeface.MONOSPACE;
        } else {
            try {
                this.mTypeface = Typeface.createFromAsset(getHost().getContext().getResources().getAssets(), str);
            } catch (Throwable unused) {
                this.mTypeface = Typeface.SANS_SERIF;
                this.mFontFamily = "sans-serif";
            }
        }
        setTypeface(this.mTypeface);
    }

    public void setIncludeFontPadding(boolean z16) {
        this.mIncludeFontPadding = z16;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0119, code lost:
    
        if (r0.equals("ALIGN_NORMAL") == false) goto L47;
     */
    @Override // com.tencent.ditto.area.DittoArea
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setLayoutAttr(LayoutAttrSet layoutAttrSet) {
        String str;
        int i3;
        boolean z16;
        super.setLayoutAttr(layoutAttrSet);
        boolean z17 = true;
        if (this.mPaint == null) {
            TextPaint textPaint = new TextPaint(1);
            this.mPaint = textPaint;
            textPaint.density = getHost().getContext().getResources().getDisplayMetrics().density;
        }
        if (layoutAttrSet != null) {
            String str2 = null;
            if (layoutAttrSet.getAttr("text_color", (String) null) != null) {
                String attr = layoutAttrSet.getAttr("text_color", (String) null);
                if (!TextUtils.isEmpty(attr)) {
                    try {
                        setTextColor(DittoResourcesUtil.parseColor(attr));
                    } catch (Throwable th5) {
                        DittoLog.e(DittoLog.defaultTag, "the text " + attr + " can't be parsed as color string", th5);
                    }
                }
            }
            String attr2 = layoutAttrSet.getAttr(LinkColor, (String) null);
            if (attr2 != null) {
                try {
                    setLinkColor(DittoResourcesUtil.parseColor(attr2));
                } catch (Throwable th6) {
                    DittoLog.e(DittoLog.defaultTag, "the text " + attr2 + " can't be parsed as color string", th6);
                }
            }
            if (layoutAttrSet.hasAttr("text_size")) {
                setTextSize(layoutAttrSet.getAttr("text_size", 15));
            }
            if (layoutAttrSet.hasAttr(MaxLine)) {
                setMaxLines(layoutAttrSet.getAttr(MaxLine, Integer.MAX_VALUE));
            }
            if (layoutAttrSet.hasAttr(LineSpace)) {
                setLineSpace(layoutAttrSet.getAttr(LineSpace, 2));
            }
            if (layoutAttrSet.hasAttr(TextBold)) {
                if (layoutAttrSet.getAttr(TextBold, 0) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                setTextBold(z16);
            }
            if (layoutAttrSet.getAttr("text", (String) null) != null) {
                String attr3 = layoutAttrSet.getAttr("text", (String) null);
                if (!TextUtils.isEmpty(attr3)) {
                    setText(attr3);
                }
            }
            if (!layoutAttrSet.hasAttr(TextAlignment)) {
                str = "ALIGN_NORMAL";
            } else {
                str = layoutAttrSet.getAttr(TextAlignment, "ALIGN_NORMAL");
            }
            str.hashCode();
            switch (str.hashCode()) {
                case -1371700497:
                    if (str.equals("ALIGN_CENTER")) {
                        z17 = false;
                        break;
                    }
                    z17 = -1;
                    break;
                case -1047432319:
                    break;
                case 1015327489:
                    if (str.equals("ALIGN_OPPOSITE")) {
                        z17 = 2;
                        break;
                    }
                    z17 = -1;
                    break;
                default:
                    z17 = -1;
                    break;
            }
            switch (z17) {
                case false:
                    this.mLayoutAlignment = Layout.Alignment.ALIGN_CENTER;
                    break;
                case true:
                    this.mLayoutAlignment = Layout.Alignment.ALIGN_NORMAL;
                    break;
                case true:
                    this.mLayoutAlignment = Layout.Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    throw new RuntimeException("Text alignment\"" + str + "\" is not supported");
            }
            if (layoutAttrSet.hasAttr(SHADOW_DX)) {
                this.shadowDx = layoutAttrSet.getAttr(SHADOW_DX, 0.0f);
            }
            if (layoutAttrSet.hasAttr(SHADOW_DY)) {
                this.shadowDy = layoutAttrSet.getAttr(SHADOW_DY, 0.0f);
            }
            if (layoutAttrSet.hasAttr(SHADOW_RADIUS)) {
                this.shadowRadius = layoutAttrSet.getAttr(SHADOW_RADIUS, 0.0f);
            }
            if (layoutAttrSet.hasAttr(SHADOW_BG_COLOR)) {
                try {
                    str2 = layoutAttrSet.getAttr(SHADOW_BG_COLOR, "#00000000");
                    this.shadowBgColor = DittoResourcesUtil.parseColor(str2);
                } catch (Throwable th7) {
                    DittoLog.e(DittoLog.defaultTag, "the text " + str2 + " can't be parsed as color string", th7);
                }
            }
            if (layoutAttrSet.hasAttr(LETTER_SPACE)) {
                setLetterSpace(layoutAttrSet.getAttr(LETTER_SPACE, 0.0f));
            }
            float f16 = this.shadowDx;
            if (f16 != Float.MIN_VALUE) {
                float f17 = this.shadowDy;
                if (f17 != Float.MIN_VALUE) {
                    float f18 = this.shadowRadius;
                    if (f18 != Float.MIN_VALUE && (i3 = this.shadowBgColor) != 0) {
                        this.mPaint.setShadowLayer(f18, f16, f17, i3);
                    }
                }
            }
            if (layoutAttrSet.hasAttr(FONT_FAMILY)) {
                setFontFamily(layoutAttrSet.getAttr(FONT_FAMILY, "sans-serif"));
            }
        }
    }

    public void setLetterSpace(float f16) {
        this.letterSpace = f16;
        TextPaint textPaint = this.mPaint;
        if (textPaint != null) {
            textPaint.setLetterSpacing(f16);
            requestLayout();
        }
    }

    public void setLineSpace(int i3) {
        this.mLineSpace = i3;
    }

    public void setMaxLines(int i3) {
        this.mMaxLines = i3;
    }

    public void setText(String str) {
        this.mText = str;
        this.isDirty = true;
        requestLayout();
    }

    public void setTextAlignment(Layout.Alignment alignment) {
        if (this.mLayoutAlignment == alignment) {
            return;
        }
        this.isDirty = true;
        this.mLayoutAlignment = alignment;
        requestLayout();
    }

    public void setTextBold(boolean z16) {
        this.mTextBold = z16;
        this.mPaint.setFakeBoldText(true);
    }

    public void setTextColor(int i3) {
        if (this.mCurTextColor == i3) {
            return;
        }
        this.mCurTextColor = i3;
        this.mPaint.setColor(i3);
        this.isDirty = true;
    }

    public void setTextSize(float f16) {
        setTextSize(2, f16);
    }

    public void setTypeface(Typeface typeface, int i3) {
        Typeface create;
        TextPaint textPaint = this.mPaint;
        if (textPaint != null) {
            if (i3 > 0) {
                if (typeface == null) {
                    create = Typeface.defaultFromStyle(i3);
                } else {
                    create = Typeface.create(typeface, i3);
                }
                setTypeface(create);
                int i16 = (~(create != null ? create.getStyle() : 0)) & i3;
                this.mPaint.setFakeBoldText((i16 & 1) != 0);
                this.mPaint.setTextSkewX((i16 & 2) != 0 ? -0.25f : 0.0f);
                return;
            }
            textPaint.setFakeBoldText(false);
            this.mPaint.setTextSkewX(0.0f);
            setTypeface(typeface);
        }
    }

    public void setTextSize(int i3, float f16) {
        float applyDimension = TypedValue.applyDimension(i3, f16, getContext().getResources().getDisplayMetrics());
        if (this.mPaint.getTextSize() == applyDimension) {
            return;
        }
        this.isDirty = true;
        this.mPaint.setTextSize(applyDimension);
        this.mCurrTextSize = applyDimension;
        requestLayout();
    }

    public void setText(String str, int i3, String str2) {
        if (str == null || i3 <= 0) {
            return;
        }
        if (str.length() <= i3) {
            this.mText = str;
        } else {
            this.mText = str.substring(0, i3 - 1) + str2;
        }
        this.isDirty = true;
        requestLayout();
    }

    private void setTypeface(Typeface typeface) {
        TextPaint textPaint = this.mPaint;
        if (textPaint == null || textPaint.getTypeface() == typeface) {
            return;
        }
        this.mPaint.setTypeface(typeface);
        requestLayout();
    }

    public void setLinkColor(int i3) {
    }

    public void setLeftDrawable(Drawable drawable, int i3) {
    }
}
