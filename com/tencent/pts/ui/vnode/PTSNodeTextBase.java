package com.tencent.pts.ui.vnode;

import android.R;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.pts.ui.PTSNodeStyleConstant;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;
import com.tencent.pts.utils.d;
import java.io.File;

/* loaded from: classes22.dex */
public abstract class PTSNodeTextBase extends PTSNodeVirtual {
    static IPatchRedirector $redirector_ = null;
    public static final String FONT_FAMILY_PING_FANG_SC_MEDIUM = "PingFangSC-Medium";
    public static final String FONT_FAMILY_PING_FANG_SC_REGULAR = "PingFangSC-Regular";
    public static final String FONT_FAMILY_SANS_SERIF = "sans-serif";
    public static final String FONT_FAMILY_SANS_SERIF_MEDIUM = "sans-serif-medium";
    public static final String FONT_PATH = "fonts";
    public static final String STYLE_ITALIC = "italic";
    public static final String TAG = "PTSNodeTextBase";
    public static final String TEXT_ALIGN_CENTER = "center";
    public static final String TEXT_ALIGN_JUSTIFY = "justify";
    public static final String TEXT_ALIGN_LEFT = "left";
    public static final String TEXT_ALIGN_RIGHT = "right";
    public static final String TEXT_DECORATION_LINE_THROUGH = "line-through";
    public static final String TEXT_DECORATION_UNDERLINE = "underline";
    public static final String TEXT_WORD_BREAK = "justify";
    public static final String TTF_SUFFIX = ".ttf";
    public static final String WEIGHT_BOLD = "bold";
    public static final String WEIGHT_LIGHTER = "lighter";
    public static final String WEIGHT_NORMAL = "normal";
    private String content;
    private String fontFamily;
    private float fontSizePx;
    private String fontStyle;
    private String fontWeight;
    private float lineSpacing;
    private int mathRound;
    private int maxLines;
    private String textAlign;
    private int textColor;
    private String textDecoration;
    private String textWordBreak;

    public PTSNodeTextBase(PTSAppInstance pTSAppInstance, String str, String str2) {
        super(pTSAppInstance, str, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, pTSAppInstance, str, str2);
            return;
        }
        this.fontSizePx = PTSDeviceUtil.dp2px(16.0f);
        this.textColor = -16777216;
        this.fontWeight = "normal";
        this.fontStyle = "";
        this.fontFamily = "";
        this.mathRound = 0;
        this.maxLines = Integer.MAX_VALUE;
        this.lineSpacing = PTSDeviceUtil.dp2px(3.2f);
        this.textAlign = "left";
        this.textDecoration = "";
        this.textWordBreak = "";
    }

    private String getAndroidFontFamily(String str) {
        String str2;
        if (TextUtils.equals(str, FONT_FAMILY_PING_FANG_SC_MEDIUM)) {
            str2 = FONT_FAMILY_SANS_SERIF_MEDIUM;
        } else if (TextUtils.equals(str, FONT_FAMILY_PING_FANG_SC_REGULAR)) {
            str2 = "sans-serif";
        } else {
            str2 = str;
        }
        PTSLog.i(TAG, "[getAndroidFontFamily] inputFontFamily = " + str + ", res = " + str2);
        return str2;
    }

    public static float getHeightOffset(float f16, int i3) {
        return PTSDeviceUtil.getTextHeightOffsetPerLine() * i3 * f16;
    }

    public static float getLineSpacing(float f16, float f17, TextPaint textPaint) {
        if (textPaint == null) {
            PTSLog.e(TAG, "[getLineSpacing] error, textPaint is null.");
            textPaint = new TextPaint();
        }
        textPaint.setTextSize(PTSDeviceUtil.dp2px(f17));
        return PTSDeviceUtil.dp2px(f16) - textPaint.getFontMetricsInt(null);
    }

    public static float getWidthOffset(float f16, int i3) {
        float f17;
        float textWidthOffsetPerLength = PTSDeviceUtil.getTextWidthOffsetPerLength() * f16;
        float f18 = i3;
        if (i3 > 0) {
            f17 = 9.0f / f18;
        } else {
            f17 = 0.0f;
        }
        return textWidthOffsetPerLength * (f18 + f17);
    }

    private void updateFontFamily(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Typeface a16 = d.a(getContext(), "fonts" + File.separator + str + ".ttf");
            if (a16 != null) {
                ((TextView) getView()).setTypeface(a16);
            }
        } catch (Exception e16) {
            PTSLog.e(TAG, "[updateFontFamily] e = " + e16);
            try {
                Typeface b16 = d.b(getAndroidFontFamily(str));
                if (b16 != null) {
                    ((TextView) getView()).setTypeface(b16);
                }
            } catch (Exception e17) {
                PTSLog.e(TAG, "[updateFontFamily] ex = " + e17);
            }
        }
    }

    private void updateMathRound(int i3) {
        if (i3 <= 0) {
            return;
        }
        this.content = String.valueOf(Math.round(PTSValueConvertUtil.getFloat(this.content) * 100.0d) / 100.0d);
        ((TextView) getView()).setText(this.content);
    }

    private void updatePtsOnPressColor() {
        Integer ptsOnPressColor = getPtsOnPressColor();
        if (ptsOnPressColor == null) {
            return;
        }
        ((TextView) getView()).setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{ptsOnPressColor.intValue(), this.textColor}));
    }

    @SuppressLint({"WrongConstant"})
    private void updateTextAlign(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = (TextView) getView();
        if (str.equalsIgnoreCase("left")) {
            textView.setGravity(19);
            return;
        }
        if (str.equalsIgnoreCase("right")) {
            textView.setGravity(21);
            return;
        }
        if (str.equalsIgnoreCase("center")) {
            textView.setGravity(17);
        } else if (str.equalsIgnoreCase("justify") && Build.VERSION.SDK_INT >= 26) {
            textView.setJustificationMode(1);
        }
    }

    private void updateTextDecoration(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SpannableString spannableString = new SpannableString(this.content);
        if (TextUtils.equals("underline", str)) {
            spannableString.setSpan(new UnderlineSpan(), 0, this.content.length(), 0);
        } else if (TextUtils.equals(TEXT_DECORATION_LINE_THROUGH, str)) {
            spannableString.setSpan(new StrikethroughSpan(), 0, this.content.length(), 0);
        }
        ((TextView) getView()).setText(spannableString);
    }

    private void updateTextWordBreak(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = (TextView) getView();
        if (str.equalsIgnoreCase("justify")) {
            textView.setBreakStrategy(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getFontSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.fontSizePx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getForegroundColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.textColor;
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onParseValueFinished();
        TextView textView = (TextView) getView();
        textView.setText(this.content);
        int i16 = 0;
        textView.setTextSize(0, this.fontSizePx);
        textView.setTextColor(this.textColor);
        textView.setMaxLines(this.maxLines);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setLineSpacing(this.lineSpacing, 1.0f);
        boolean equals = TextUtils.equals(this.fontWeight, "bold");
        boolean equals2 = TextUtils.equals(this.fontStyle, "italic");
        if (equals) {
            Typeface typeface = Typeface.DEFAULT_BOLD;
            if (equals2) {
                i3 = 3;
            } else {
                i3 = 1;
            }
            textView.setTypeface(typeface, i3);
        } else {
            Typeface typeface2 = Typeface.DEFAULT;
            if (equals2) {
                i16 = 2;
            }
            textView.setTypeface(typeface2, i16);
        }
        updateTextAlign(this.textAlign);
        updateTextDecoration(this.textDecoration);
        updateFontFamily(this.fontFamily);
        updateTextWordBreak(this.textWordBreak);
        updatePtsOnPressColor();
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void resetAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.resetAll();
        TextView textView = (TextView) getView();
        textView.setText("");
        textView.setTextSize(16.0f);
        textView.setTypeface(null, 0);
        textView.setMaxLines(Integer.MAX_VALUE);
        textView.setGravity(16);
        textView.setLineSpacing(PTSDeviceUtil.dp2px(3.2f), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, obj)).booleanValue();
        }
        boolean attribute = super.setAttribute(str, obj);
        if (attribute) {
            return true;
        }
        if (PTSNodeAttributeConstant.MATH_ROUND.equalsIgnoreCase(str)) {
            this.mathRound = PTSValueConvertUtil.getInt(obj);
            return true;
        }
        return attribute;
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    protected boolean setContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        this.content = str;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setStyle(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, obj)).booleanValue();
        }
        boolean style = super.setStyle(str, obj);
        if (style) {
            return true;
        }
        if ("font-size".equalsIgnoreCase(str)) {
            this.fontSizePx = PTSDeviceUtil.dp2px(getNodeInfo().getStyle().getFontSize());
        } else if ("color".equalsIgnoreCase(str)) {
            this.textColor = PTSValueConvertUtil.getColor(obj);
        } else if (PTSNodeStyleConstant.FONT_STYLE.equalsIgnoreCase(str)) {
            this.fontStyle = PTSValueConvertUtil.getString(obj);
        } else if ("font-weight".equalsIgnoreCase(str)) {
            this.fontWeight = PTSValueConvertUtil.getString(obj);
        } else if ("-webkit-line-clamp".equalsIgnoreCase(str)) {
            int i3 = PTSValueConvertUtil.getInt(obj);
            if (i3 <= 0) {
                i3 = 1;
            }
            this.maxLines = i3;
        } else if ("line-height".equalsIgnoreCase(str)) {
            this.lineSpacing = getNodeInfo().getStyle().getLineSpacing(((TextView) getView()).getPaint());
        } else if (PTSNodeStyleConstant.TEXT_ALIGN.equalsIgnoreCase(str)) {
            this.textAlign = PTSValueConvertUtil.getString(obj);
        } else if (PTSNodeStyleConstant.TEXT_DECORATION.equalsIgnoreCase(str)) {
            this.textDecoration = PTSValueConvertUtil.getString(obj);
        } else if (PTSNodeStyleConstant.FONT_FAMILY.equalsIgnoreCase(str)) {
            this.fontFamily = PTSValueConvertUtil.getString(obj);
        } else if (PTSNodeStyleConstant.TEXT_WORD_BREAK.equalsIgnoreCase(str)) {
            this.textWordBreak = PTSValueConvertUtil.getString(obj);
        } else {
            return style;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.content = str;
            ((TextView) getView()).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextWithSpannableString(SpannableStringBuilder spannableStringBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) spannableStringBuilder);
        } else {
            this.content = spannableStringBuilder.toString();
            ((TextView) getView()).setText(spannableStringBuilder);
        }
    }
}
