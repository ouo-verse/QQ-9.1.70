package com.tencent.mtt.hippy.dom.node;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.BidiFormatter;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.RequiresApi;
import com.huawei.hms.hihealth.data.Value;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.flex.FlexMeasureMode;
import com.tencent.mtt.hippy.dom.flex.f;
import com.tencent.mtt.hippy.utils.I18nUtil;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.text.HippyTextView;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TextNode extends StyleNode {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
    private static final String ELLIPSIS = "\u2026";
    public static final String IMAGE_SPAN_TEXT = "[img]";
    public static final String MODE_CLIP = "clip";
    public static final String MODE_HEAD = "head";
    public static final String MODE_MIDDLE = "middle";
    public static final String MODE_TAIL = "tail";
    public static final String PROP_SHADOW_COLOR = "textShadowColor";
    public static final String PROP_SHADOW_OFFSET = "textShadowOffset";
    public static final String PROP_SHADOW_OFFSET_HEIGHT = "height";
    public static final String PROP_SHADOW_OFFSET_WIDTH = "width";
    public static final String PROP_SHADOW_RADIUS = "textShadowRadius";
    public static final String STRATEGY_BALANCED = "balanced";
    public static final String STRATEGY_HIGH_QUALITY = "high_quality";
    public static final String STRATEGY_SIMPLE = "simple";
    private static final f.a TEXT_MEASURE_FUNCTION = new f.a() { // from class: com.tencent.mtt.hippy.dom.node.TextNode.1
        @Override // com.tencent.mtt.hippy.dom.flex.f.a
        public long measure(com.tencent.mtt.hippy.dom.flex.f fVar, float f16, FlexMeasureMode flexMeasureMode, float f17, FlexMeasureMode flexMeasureMode2) {
            Layout layout;
            boolean z16;
            try {
                layout = ((TextNode) fVar).createLayout(f16, flexMeasureMode);
                z16 = false;
            } catch (Throwable th5) {
                LogUtils.e("TextNode", "text createLayout", th5);
                layout = null;
                z16 = true;
            }
            if (!z16 && layout != null) {
                LogUtils.d("TextNode", "measure: w: " + layout.getWidth() + " h: " + layout.getHeight());
                return com.tencent.mtt.hippy.dom.flex.g.a(layout.getWidth(), layout.getHeight());
            }
            return com.tencent.mtt.hippy.dom.flex.g.a(f16, f17);
        }
    };
    public static final int UNSET = -1;
    private int mBackgroundColor;
    private final boolean mIsVirtual;
    protected float mLineSpacingExtra;
    SpannableStringBuilder mSpanned;
    CharSequence mText;
    protected Layout.Alignment mTextAlign;
    private TextPaint mTextPaintForEmpty;
    final TextPaint mTextPaintInstance;
    protected int mNumberOfLines = -1;
    private String mEllipsizeMode = MODE_TAIL;
    private String mBreakStrategy = "simple";
    protected int mFontSize = (int) Math.ceil(PixelUtil.dp2px(14.0f));
    private float mLineHeight = -1.0f;
    private float mLetterSpacing = -1.0f;
    protected float mLineSpacingMultiplier = -1.0f;
    protected int mColor = -16777216;
    private final boolean mIsBackgroundColorSet = false;
    private String mFontFamily = null;
    protected final TextUtils.TruncateAt mTruncateAt = TextUtils.TruncateAt.END;
    private float mTextShadowOffsetDx = 0.0f;
    private float mTextShadowOffsetDy = 0.0f;
    private float mTextShadowRadius = 1.0f;
    private int mTextShadowColor = DEFAULT_TEXT_SHADOW_COLOR;
    private boolean mIsUnderlineTextDecorationSet = false;
    private boolean mIsLineThroughTextDecorationSet = false;
    private int mFontStyle = -1;
    private int mFontWeight = -1;
    private ArrayList<String> mGestureTypes = null;
    protected boolean mEnableScale = false;
    private WeakReference<HippyTextView> mTextViewWeakRefrence = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        protected final int f337375a;

        /* renamed from: b, reason: collision with root package name */
        protected final int f337376b;

        /* renamed from: c, reason: collision with root package name */
        protected final Object f337377c;

        a(int i3, int i16, Object obj) {
            this.f337375a = i3;
            this.f337376b = i16;
            this.f337377c = obj;
        }

        public void a(SpannableStringBuilder spannableStringBuilder) {
            int i3;
            Object obj = this.f337377c;
            if (obj instanceof ImageSpan) {
                i3 = 33;
            } else if (this.f337375a == 0) {
                i3 = 18;
            } else {
                i3 = 34;
            }
            try {
                spannableStringBuilder.setSpan(obj, this.f337375a, this.f337376b, i3);
            } catch (Exception e16) {
                LogUtils.e("TextNode", "setSpan exception msg: " + e16.getMessage());
            }
        }
    }

    public TextNode(boolean z16) {
        this.mTextAlign = Layout.Alignment.ALIGN_NORMAL;
        this.mIsVirtual = z16;
        if (!z16) {
            setMeasureFunction(TEXT_MEASURE_FUNCTION);
        }
        if (I18nUtil.isRTL()) {
            this.mTextAlign = Layout.Alignment.ALIGN_OPPOSITE;
        }
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaintInstance = textPaint;
        textPaint.setTextSize(this.mFontSize);
    }

    private StaticLayout buildStaticLayout(CharSequence charSequence, TextPaint textPaint, int i3) {
        Layout.Alignment alignment = this.mTextAlign;
        if (I18nUtil.isRTL() && BidiFormatter.getInstance().isRtl(charSequence.toString()) && alignment == Layout.Alignment.ALIGN_OPPOSITE) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        }
        return StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i3).setAlignment(alignment).setLineSpacing(this.mLineSpacingExtra, getLineSpacingMultiplier()).setIncludePad(true).setBreakStrategy(getBreakStrategy()).build();
    }

    private void createImageSpanOperation(List<a> list, SpannableStringBuilder spannableStringBuilder, ImageNode imageNode, HippyEngineContext hippyEngineContext, HippyImageLoader hippyImageLoader) {
        String str;
        String str2;
        Drawable drawable;
        Bitmap bitmap;
        HippyMap totalProps = imageNode.getTotalProps();
        Drawable drawable2 = null;
        if (totalProps != null) {
            String string = totalProps.getString("src");
            str = totalProps.getString("defaultSource");
            str2 = string;
        } else {
            str = null;
            str2 = null;
        }
        if (!TextUtils.isEmpty(str) && hippyImageLoader != null && (bitmap = hippyImageLoader.getImage(str, (Object) null).getBitmap()) != null) {
            drawable2 = new BitmapDrawable(bitmap);
        }
        if (drawable2 == null) {
            drawable = new ColorDrawable(Color.parseColor("#00000000"));
        } else {
            drawable = drawable2;
        }
        drawable.setBounds(0, 0, Math.round(imageNode.getStyleWidth()), Math.round(imageNode.getStyleHeight()));
        c cVar = new c(drawable, str2, imageNode, hippyImageLoader, hippyEngineContext);
        imageNode.setImageSpan(cVar);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(IMAGE_SPAN_TEXT);
        int i3 = length + 5;
        list.add(new a(length, i3, cVar));
        if (imageNode.getGestureTypes() != null && imageNode.getGestureTypes().size() > 0) {
            f fVar = new f(imageNode.getId(), true);
            fVar.a(imageNode.getGestureTypes());
            list.add(new a(length, i3, fVar));
        }
    }

    private SpannableStringBuilder createSpan(CharSequence charSequence, boolean z16, HippyEngineContext hippyEngineContext, HippyFontScaleAdapter hippyFontScaleAdapter, HippyImageLoader hippyImageLoader) {
        if (charSequence != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            List<a> arrayList = new ArrayList<>();
            createSpanOperations(arrayList, spannableStringBuilder, this, charSequence, z16, hippyEngineContext, hippyFontScaleAdapter, hippyImageLoader);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(spannableStringBuilder);
            }
            createCustomSpan(charSequence, spannableStringBuilder);
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder("");
    }

    private void createSpanOperations(List<a> list, SpannableStringBuilder spannableStringBuilder, TextNode textNode, CharSequence charSequence, boolean z16, HippyEngineContext hippyEngineContext, HippyFontScaleAdapter hippyFontScaleAdapter, HippyImageLoader hippyImageLoader) {
        CharSequence charSequence2;
        CharSequence emoticonText;
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        int length2 = spannableStringBuilder.length();
        if (length <= length2) {
            list.add(new a(length, length2, createForegroundColorSpan(textNode.mColor, textNode)));
            if (textNode.mLetterSpacing != -1.0f) {
                list.add(new a(length, length2, new d(textNode.mLetterSpacing)));
            }
            int i3 = textNode.mFontSize;
            if (i3 != -1) {
                if (hippyFontScaleAdapter != null && textNode.mEnableScale) {
                    i3 = (int) (i3 * hippyFontScaleAdapter.getFontScale());
                }
                list.add(new a(length, length2, new AbsoluteSizeSpan(i3)));
            }
            String str = textNode.mFontFamily;
            if (str == null && hippyFontScaleAdapter != null) {
                str = hippyFontScaleAdapter.getCustomDefaultFontFamily();
            }
            if (textNode.mFontStyle != -1 || textNode.mFontWeight != -1 || str != null) {
                list.add(new a(length, length2, new h(textNode.mFontStyle, textNode.mFontWeight, str, hippyFontScaleAdapter)));
            }
            if (textNode.mIsUnderlineTextDecorationSet) {
                list.add(new a(length, length2, new UnderlineSpan()));
            }
            if (textNode.mIsLineThroughTextDecorationSet) {
                list.add(new a(length, length2, new StrikethroughSpan()));
            }
            if (textNode.mTextShadowOffsetDx != 0.0f || textNode.mTextShadowOffsetDy != 0.0f) {
                list.add(new a(length, length2, new g(textNode.mTextShadowOffsetDx, textNode.mTextShadowOffsetDy, textNode.mTextShadowRadius, textNode.mTextShadowColor)));
            }
            float f16 = textNode.mLineHeight;
            if (f16 != -1.0f && this.mLineSpacingMultiplier == -1.0f && this.mLineSpacingExtra == 0.0f) {
                if (hippyFontScaleAdapter != null && textNode.mEnableScale) {
                    f16 *= hippyFontScaleAdapter.getFontScale();
                }
                list.add(new a(length, length2, new e(f16)));
            }
            ArrayList<String> arrayList = textNode.mGestureTypes;
            if (arrayList != null && arrayList.size() > 0) {
                f fVar = new f(textNode.getId(), isVirtual());
                fVar.a(textNode.mGestureTypes);
                list.add(new a(length, length2, fVar));
            }
        }
        if (z16) {
            for (int i16 = 0; i16 < textNode.getChildCount(); i16++) {
                b childAt = textNode.getChildAt(i16);
                if (childAt instanceof TextNode) {
                    TextNode textNode2 = (TextNode) childAt;
                    CharSequence charSequence3 = textNode2.mText;
                    if (hippyFontScaleAdapter != null && !TextUtils.isEmpty(charSequence3) && (emoticonText = hippyFontScaleAdapter.getEmoticonText(charSequence3, textNode2.mFontSize)) != null) {
                        charSequence2 = emoticonText;
                    } else {
                        charSequence2 = charSequence3;
                    }
                    createSpanOperations(list, spannableStringBuilder, textNode2, charSequence2, z16, hippyEngineContext, hippyFontScaleAdapter, hippyImageLoader);
                } else if (childAt instanceof ImageNode) {
                    createImageSpanOperation(list, spannableStringBuilder, (ImageNode) childAt, hippyEngineContext, hippyImageLoader);
                } else {
                    throw new RuntimeException(childAt.getViewClass() + "is not support in Text");
                }
                childAt.markUpdateSeen();
            }
        }
    }

    private CharSequence ellipsizeHead(CharSequence charSequence, TextPaint textPaint, int i3, int i16) {
        CharSequence charSequence2;
        int max = Math.max(i16, TextUtils.lastIndexOf(charSequence, '\n') + 1);
        if (charSequence instanceof Spanned) {
            charSequence2 = new SpannableStringBuilder().append((CharSequence) "\u2026").append(charSequence, max, charSequence.length());
        } else {
            StringBuilder sb5 = new StringBuilder((charSequence.length() + 1) - max);
            sb5.append("\u2026");
            sb5.append(charSequence, max, charSequence.length());
            charSequence2 = sb5;
        }
        CharSequence ellipsize = TextUtils.ellipsize(charSequence2, textPaint, i3, TextUtils.TruncateAt.START);
        if (ellipsize instanceof Spannable) {
            Spannable spannable = (Spannable) ellipsize;
            for (Object obj : spannable.getSpans(1, 1, Object.class)) {
                if (!(obj instanceof ImageSpan) && spannable.getSpanStart(obj) == 1) {
                    int spanFlags = spannable.getSpanFlags(obj);
                    int spanEnd = spannable.getSpanEnd(obj);
                    spannable.removeSpan(obj);
                    spannable.setSpan(obj, 0, spanEnd, spanFlags);
                }
            }
        }
        return ellipsize;
    }

    private CharSequence ellipsizeMiddle(CharSequence charSequence, TextPaint textPaint, int i3, int i16) {
        CharSequence charSequence2;
        CharSequence replace;
        int indexOf = TextUtils.indexOf(charSequence, '\n', i16);
        if (indexOf != -1) {
            int lastIndexOf = TextUtils.lastIndexOf(charSequence, '\n') + 1;
            if (charSequence instanceof Spanned) {
                charSequence2 = new SpannableStringBuilder().append(charSequence, i16, indexOf).append((CharSequence) "\u2026").append(charSequence, lastIndexOf, charSequence.length());
            } else {
                StringBuilder sb5 = new StringBuilder((((indexOf - i16) + 1) + charSequence.length()) - lastIndexOf);
                sb5.append(charSequence, i16, indexOf);
                sb5.append("\u2026");
                sb5.append(charSequence, lastIndexOf, charSequence.length());
                charSequence2 = sb5;
            }
            final int[] iArr = new int[2];
            CharSequence ellipsize = TextUtils.ellipsize(charSequence2, textPaint, i3, TextUtils.TruncateAt.MIDDLE, false, new TextUtils.EllipsizeCallback() { // from class: com.tencent.mtt.hippy.dom.node.TextNode.2
                @Override // android.text.TextUtils.EllipsizeCallback
                public void ellipsized(int i17, int i18) {
                    int[] iArr2 = iArr;
                    iArr2[0] = i17;
                    iArr2[1] = i18;
                }
            });
            if (ellipsize != charSequence2) {
                int i17 = indexOf - i16;
                int i18 = i17 + 1;
                int i19 = iArr[0];
                if (i19 > i17) {
                    if (charSequence2 instanceof SpannableStringBuilder) {
                        replace = ((SpannableStringBuilder) charSequence2).replace(i17, iArr[1], (CharSequence) "\u2026");
                    } else {
                        replace = ((StringBuilder) charSequence2).replace(i17, iArr[1], "\u2026");
                    }
                } else if (iArr[1] < i18) {
                    if (charSequence2 instanceof SpannableStringBuilder) {
                        replace = ((SpannableStringBuilder) charSequence2).replace(i19, i18, (CharSequence) "\u2026");
                    } else {
                        replace = ((StringBuilder) charSequence2).replace(i19, i18, "\u2026");
                    }
                } else {
                    return ellipsize;
                }
                return replace;
            }
            return ellipsize;
        }
        return TextUtils.ellipsize(charSequence.subSequence(i16, charSequence.length()), textPaint, i3, TextUtils.TruncateAt.MIDDLE);
    }

    private CharSequence ellipsizeTail(CharSequence charSequence, TextPaint textPaint, int i3, int i16, int i17) {
        CharSequence charSequence2;
        if (charSequence.charAt(i17 - 1) == '\n') {
            i17--;
        }
        if (charSequence instanceof Spanned) {
            charSequence2 = new SpannableStringBuilder().append(charSequence, i16, i17).append((CharSequence) "\u2026");
        } else {
            StringBuilder sb5 = new StringBuilder((i17 - i16) + 1);
            sb5.append(charSequence, i16, i17);
            sb5.append("\u2026");
            charSequence2 = sb5;
        }
        return TextUtils.ellipsize(charSequence2, textPaint, i3, TextUtils.TruncateAt.END);
    }

    @RequiresApi(api = 23)
    private int getBreakStrategy() {
        String str = this.mBreakStrategy;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1924829944:
                if (str.equals(STRATEGY_BALANCED)) {
                    c16 = 0;
                    break;
                }
                break;
            case -902286926:
                if (str.equals("simple")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1790083938:
                if (str.equals(STRATEGY_HIGH_QUALITY)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 2;
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                throw new RuntimeException("Invalid breakStrategy: " + str);
        }
    }

    private float getLineHeight(Layout layout, int i3) {
        return layout.getLineTop(i3 + 1) - layout.getLineTop(i3);
    }

    private TextPaint getTextPaint() {
        if (TextUtils.isEmpty(this.mText)) {
            if (this.mTextPaintForEmpty == null) {
                this.mTextPaintForEmpty = new TextPaint(1);
            }
            return this.mTextPaintForEmpty;
        }
        return this.mTextPaintInstance;
    }

    private static int parseArgument(String str) {
        if (str.length() == 3 && str.endsWith("00") && str.charAt(0) <= '9' && str.charAt(0) >= '1') {
            return (str.charAt(0) - '0') * 100;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private StaticLayout truncateLayoutWithNumberOfLine(Layout layout, int i3, int i16) {
        SpannableStringBuilder spannableStringBuilder;
        CharSequence ellipsizeTail;
        float textSize;
        boolean z16;
        int lineCount = layout.getLineCount();
        CharSequence text = layout.getText();
        TextPaint paint = layout.getPaint();
        if ("clip".equals(this.mEllipsizeMode)) {
            int lineEnd = layout.getLineEnd(i16 - 1);
            if (text.charAt(lineEnd - 1) == '\n') {
                lineEnd--;
            }
            ellipsizeTail = text.subSequence(0, lineEnd);
        } else {
            TextPaint textPaint = new TextPaint();
            textPaint.set(paint);
            int i17 = i16 - 1;
            int lineStart = layout.getLineStart(i17);
            if (lineStart > 0) {
                if (text.charAt(lineStart - 1) != '\n') {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (text instanceof Spanned) {
                    spannableStringBuilder = new SpannableStringBuilder().append(text, 0, lineStart);
                    if (z16) {
                        spannableStringBuilder.append('\n');
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(text, 0, lineStart);
                    if (z16) {
                        sb5.append('\n');
                    }
                    spannableStringBuilder = sb5;
                }
            } else {
                spannableStringBuilder = null;
            }
            Object obj = spannableStringBuilder;
            if ("head".equals(this.mEllipsizeMode)) {
                if (i16 >= 2) {
                    textSize = getLineHeight(layout, i16 - 2);
                } else {
                    textSize = paint.getTextSize();
                }
                textPaint.setTextSize(Math.max(textSize, Math.max(getLineHeight(layout, lineCount - 2), getLineHeight(layout, lineCount - 1))));
                ellipsizeTail = ellipsizeHead(text, textPaint, i3, lineStart);
            } else if ("middle".equals(this.mEllipsizeMode)) {
                textPaint.setTextSize(Math.max(getLineHeight(layout, i17), getLineHeight(layout, lineCount - 1)));
                ellipsizeTail = ellipsizeMiddle(text, textPaint, i3, lineStart);
            } else {
                textPaint.setTextSize(getLineHeight(layout, i17));
                ellipsizeTail = ellipsizeTail(text, textPaint, i3, lineStart, layout.getLineEnd(i17));
            }
            if (obj != null) {
                if (obj instanceof SpannableStringBuilder) {
                    ellipsizeTail = ((SpannableStringBuilder) obj).append(ellipsizeTail);
                } else {
                    StringBuilder sb6 = (StringBuilder) obj;
                    sb6.append(ellipsizeTail);
                    ellipsizeTail = sb6;
                }
            }
        }
        return buildStaticLayout(ellipsizeTail, paint, i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_CLICK)
    public void clickEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add(NodeProps.ON_CLICK);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "color")
    public void color(Integer num) {
        this.mColor = num.intValue();
        markUpdated();
    }

    protected HippyForegroundColorSpan createForegroundColorSpan(int i3, TextNode textNode) {
        return new HippyForegroundColorSpan(i3);
    }

    protected Layout createLayout(float f16, FlexMeasureMode flexMeasureMode) {
        BoringLayout.Metrics metrics;
        float f17;
        boolean z16;
        double d16;
        Layout make;
        int i3;
        double d17;
        TextPaint textPaint = getTextPaint();
        CharSequence charSequence = this.mSpanned;
        if (charSequence == null) {
            charSequence = new SpannedString("");
        }
        try {
            metrics = BoringLayout.isBoring(charSequence, textPaint);
        } catch (Throwable th5) {
            LogUtils.d("TextNode", "createLayout: " + th5.getMessage());
            metrics = null;
        }
        BoringLayout.Metrics metrics2 = metrics;
        if (metrics2 == null) {
            f17 = Layout.getDesiredWidth(charSequence, textPaint);
        } else {
            f17 = Float.NaN;
        }
        float f18 = f17;
        if (flexMeasureMode != FlexMeasureMode.UNDEFINED && f16 >= 0.0f) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (metrics2 == null && (z16 || (!com.tencent.mtt.hippy.dom.flex.c.a(f18) && f18 <= f16))) {
            d16 = f18;
        } else {
            if (metrics2 != null && (z16 || metrics2.width <= f16)) {
                make = BoringLayout.make(charSequence, textPaint, metrics2.width, this.mTextAlign, getLineSpacingMultiplier(), this.mLineSpacingExtra, metrics2, true);
                i3 = this.mNumberOfLines;
                if (i3 == -1 && i3 > 0) {
                    int lineCount = make.getLineCount();
                    int i16 = this.mNumberOfLines;
                    if (lineCount > i16 && make.getLineStart(i16 - 1) < make.getLineEnd(this.mNumberOfLines - 1)) {
                        if (z16) {
                            d17 = f18;
                        } else {
                            d17 = f16;
                        }
                        return truncateLayoutWithNumberOfLine(make, (int) Math.ceil(d17), this.mNumberOfLines);
                    }
                    return make;
                }
            }
            d16 = f16;
        }
        make = buildStaticLayout(charSequence, textPaint, (int) Math.ceil(d16));
        i3 = this.mNumberOfLines;
        return i3 == -1 ? make : make;
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "enableScale")
    public void enableScale(boolean z16) {
        this.mEnableScale = z16;
        markUpdated();
    }

    @HippyControllerProps(name = "fontFamily")
    public void fontFamily(String str) {
        this.mFontFamily = str;
        markUpdated();
    }

    @HippyControllerProps(defaultNumber = 14.0d, defaultType = "number", name = "fontSize")
    public void fontSize(float f16) {
        int ceil = (int) Math.ceil(PixelUtil.dp2px(f16));
        this.mFontSize = ceil;
        this.mTextPaintInstance.setTextSize(ceil);
        markUpdated();
    }

    @HippyControllerProps(defaultString = "normal", defaultType = HippyControllerProps.STRING, name = "fontStyle")
    public void fontStyle(String str) {
        int i3;
        if ("italic".equals(str)) {
            i3 = 2;
        } else if ("normal".equals(str)) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        if (i3 != this.mFontStyle) {
            this.mFontStyle = i3;
            markUpdated();
        }
    }

    @HippyControllerProps(name = "fontWeight")
    public void fontWeight(String str) {
        int i3;
        int i16 = -1;
        if (str != null) {
            i3 = parseArgument(str);
        } else {
            i3 = -1;
        }
        if (i3 < 500 && !"bold".equals(str)) {
            if ("normal".equals(str) || i3 != -1) {
                i16 = 0;
            }
        } else {
            i16 = 1;
        }
        if (i16 != this.mFontWeight) {
            this.mFontWeight = i16;
            markUpdated();
        }
    }

    protected float getLineSpacingMultiplier() {
        float f16 = this.mLineSpacingMultiplier;
        if (f16 <= 0.0f) {
            return 1.0f;
        }
        return f16;
    }

    public Spannable getSpan() {
        return this.mSpanned;
    }

    @Override // com.tencent.mtt.hippy.dom.node.b
    public boolean isVirtual() {
        return this.mIsVirtual;
    }

    @Override // com.tencent.mtt.hippy.dom.node.b
    public void layoutAfter(HippyEngineContext hippyEngineContext) {
        if (!isVirtual()) {
            LogUtils.d("TextNode", "measure:layoutAfter w: " + getLayoutWidth() + " h: " + getLayoutHeight());
            Layout createLayout = createLayout((getLayoutWidth() - getPadding(0)) - getPadding(2), FlexMeasureMode.EXACTLY);
            hippyEngineContext.getDomManager().a(createLayout);
            setData(createLayout);
        }
    }

    @Override // com.tencent.mtt.hippy.dom.node.b
    public void layoutBefore(HippyEngineContext hippyEngineContext) {
        CharSequence emoticonText;
        super.layoutBefore(hippyEngineContext);
        HippyFontScaleAdapter fontScaleAdapter = hippyEngineContext.getGlobalConfigs().getFontScaleAdapter();
        HippyImageLoader imageLoaderAdapter = hippyEngineContext.getGlobalConfigs().getImageLoaderAdapter();
        if (this.mIsVirtual) {
            return;
        }
        if (fontScaleAdapter != null && !TextUtils.isEmpty(this.mText) && (emoticonText = fontScaleAdapter.getEmoticonText(this.mText, this.mFontSize)) != null) {
            this.mText = emoticonText;
        }
        this.mSpanned = createSpan(this.mText, true, hippyEngineContext, fontScaleAdapter, imageLoaderAdapter);
    }

    @HippyControllerProps(defaultNumber = Value.DOUBLE_DEFAULT_VALUE_FROM_PARCLE, defaultType = "number", name = NodeProps.LETTER_SPACING)
    public void letterSpacing(float f16) {
        if (f16 != -1.0f) {
            this.mLetterSpacing = PixelUtil.dp2px(f16);
            markUpdated();
        }
    }

    @HippyControllerProps(defaultNumber = Value.DOUBLE_DEFAULT_VALUE_FROM_PARCLE, defaultType = "number", name = NodeProps.LINE_HEIGHT)
    public void lineHeight(int i3) {
        float dp2px;
        if (i3 == -1) {
            dp2px = -1.0f;
        } else {
            dp2px = PixelUtil.dp2px(i3);
        }
        this.mLineHeight = dp2px;
        markUpdated();
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.LINE_SPACING_EXTRA)
    public void lineSpacingExtra(float f16) {
        this.mLineSpacingExtra = PixelUtil.dp2px(f16);
        markUpdated();
    }

    @HippyControllerProps(defaultNumber = Value.DOUBLE_DEFAULT_VALUE_FROM_PARCLE, defaultType = "number", name = NodeProps.LINE_SPACING_MULTIPLIER)
    public void lineSpacingMultiplier(float f16) {
        this.mLineSpacingMultiplier = f16;
        markUpdated();
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_LONG_CLICK)
    public void longClickEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add(NodeProps.ON_LONG_CLICK);
        }
    }

    @Override // com.tencent.mtt.hippy.dom.node.b
    public void markUpdated() {
        super.markUpdated();
        if (!this.mIsVirtual) {
            super.dirty();
        }
    }

    public void postInvalidateDelayed(long j3) {
        WeakReference<HippyTextView> weakReference = this.mTextViewWeakRefrence;
        if (weakReference != null && weakReference.get() != null) {
            this.mTextViewWeakRefrence.get().postInvalidateDelayed(j3);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_PRESS_IN)
    public void pressInEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add(NodeProps.ON_PRESS_IN);
        }
    }

    @HippyControllerProps(name = NodeProps.ON_PRESS_OUT)
    public void pressOutEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add(NodeProps.ON_PRESS_OUT);
        }
    }

    @HippyControllerProps(defaultString = "simple", defaultType = HippyControllerProps.STRING, name = NodeProps.BREAK_STRATEGY)
    public void setBreakStrategy(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "simple";
        }
        if (!this.mBreakStrategy.equals(str)) {
            if (!"simple".equals(str) && !STRATEGY_HIGH_QUALITY.equals(str) && !STRATEGY_BALANCED.equals(str)) {
                throw new RuntimeException("Invalid breakStrategy: " + str);
            }
            this.mBreakStrategy = str;
            markUpdated();
        }
    }

    @HippyControllerProps(defaultString = MODE_TAIL, defaultType = HippyControllerProps.STRING, name = NodeProps.ELLIPSIZE_MODE)
    public void setEllipsizeMode(String str) {
        if (TextUtils.isEmpty(str)) {
            str = MODE_TAIL;
        }
        if (!this.mEllipsizeMode.equals(str)) {
            if (!MODE_TAIL.equals(str) && !"clip".equals(str) && !"middle".equals(str) && !"head".equals(str)) {
                throw new RuntimeException("Invalid ellipsizeMode: " + str);
            }
            this.mEllipsizeMode = str;
            markUpdated();
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.NUMBER_OF_LINES)
    public void setNumberOfLines(int i3) {
        if (i3 == 0) {
            i3 = -1;
        }
        this.mNumberOfLines = i3;
        markUpdated();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (com.tencent.mtt.hippy.utils.I18nUtil.isRTL() != false) goto L13;
     */
    @HippyControllerProps(defaultString = "left", defaultType = HippyControllerProps.STRING, name = "textAlign")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTextAlign(String str) {
        Layout.Alignment alignment;
        if (str != null && !"auto".equals(str) && !"justify".equals(str)) {
            if (!"left".equals(str)) {
                if (!"right".equals(str)) {
                    if ("center".equals(str)) {
                        alignment = Layout.Alignment.ALIGN_CENTER;
                    } else {
                        throw new RuntimeException("Invalid textAlign: " + str);
                    }
                }
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            }
            alignment = Layout.Alignment.ALIGN_NORMAL;
        }
        this.mTextAlign = alignment;
        markUpdated();
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = PROP_SHADOW_COLOR)
    public void setTextShadowColor(int i3) {
        if (i3 != this.mTextShadowColor) {
            this.mTextShadowColor = i3;
            markUpdated();
        }
    }

    public void setTextView(HippyTextView hippyTextView) {
        this.mTextViewWeakRefrence = new WeakReference<>(hippyTextView);
    }

    @HippyControllerProps(name = "text")
    public void text(String str) {
        this.mText = str;
        markUpdated();
    }

    @HippyControllerProps(name = NodeProps.TEXT_DECORATION_LINE)
    public void textDecorationLine(String str) {
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        if (str != null) {
            for (String str2 : str.split(" ")) {
                if ("underline".equals(str2)) {
                    this.mIsUnderlineTextDecorationSet = true;
                } else if (PTSNodeTextBase.TEXT_DECORATION_LINE_THROUGH.equals(str2)) {
                    this.mIsLineThroughTextDecorationSet = true;
                }
            }
        }
        markUpdated();
    }

    @HippyControllerProps(name = PROP_SHADOW_OFFSET)
    public void textShadowOffset(HippyMap hippyMap) {
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        if (hippyMap != null) {
            if (hippyMap.get("width") != null) {
                this.mTextShadowOffsetDx = PixelUtil.dp2px(hippyMap.getDouble("width"));
            }
            if (hippyMap.get("height") != null) {
                this.mTextShadowOffsetDy = PixelUtil.dp2px(hippyMap.getDouble("height"));
            }
        }
        markUpdated();
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = PROP_SHADOW_RADIUS)
    public void textShadowRadius(float f16) {
        if (f16 != this.mTextShadowRadius) {
            this.mTextShadowRadius = f16;
            markUpdated();
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onTouchCancel")
    public void touchCancelable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add("onTouchCancel");
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_TOUCH_DOWN)
    public void touchDownEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add(NodeProps.ON_TOUCH_DOWN);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onTouchEnd")
    public void touchEndEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add("onTouchEnd");
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onTouchMove")
    public void touchUpEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add("onTouchMove");
        }
    }

    @Override // com.tencent.mtt.hippy.dom.node.b
    public void updateProps(HippyMap hippyMap) {
        super.updateProps(hippyMap);
        HippyMap hippyMap2 = (HippyMap) hippyMap.get("style");
        if (hippyMap2 != null && hippyMap2.get("color") == null) {
            hippyMap2.pushInt("color", -16777216);
        }
    }

    public boolean enableScale() {
        return this.mEnableScale;
    }

    protected void createCustomSpan(CharSequence charSequence, Spannable spannable) {
    }
}
