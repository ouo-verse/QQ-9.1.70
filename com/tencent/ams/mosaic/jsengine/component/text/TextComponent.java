package com.tencent.ams.mosaic.jsengine.component.text;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface TextComponent extends Component {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface DecorationType {
        public static final String STRIKETHROUGH = "strikethrough";
        public static final String UNDERLINE = "underline";
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SpanStyle {
        public static final String COLOR = "color";
        public static final String IMAGE = "image";
        public static final String TEXT_SIZE = "textSize";
        public static final String TYPEFACE = "typeface";
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SpanType {
        public static final String HTML = "html";
        public static final String NORMAL = "normal";
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface TextAlign {
        public static final String CENTER = "center";
        public static final String LEFT = "left";
        public static final String RIGHT = "right";
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface TextStyle {
        public static final String BOLD = "bold";
        public static final String BOLD_ITALIC = "bold-italic";
        public static final String ITALIC = "italic";
        public static final String NORMAL = "normal";
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface TruncateMode {
        public static final String END = "end";
        public static final String MIDDLE = "middle";
        public static final String NONE = "none";
        public static final String START = "start";
    }

    void setIncludeFontPadding(boolean z16);

    void setLetterSpacing(float f16);

    void setLineSpacingExtra(float f16);

    void setMaxLines(int i3);

    void setScrollable(boolean z16);

    void setShadow(float f16, float f17, float f18, String str);

    void setSpannableString(String str);

    void setText(String str);

    void setTextAlign(String str);

    void setTextColor(String str);

    void setTextDecoration(String str);

    void setTextDecorationColor(String str);

    void setTextDecorationPadding(float f16);

    void setTextDecorationWeight(float f16);

    void setTextSize(float f16);

    void setTextTypeface(String str, String str2);

    void setTruncateMode(String str);
}
