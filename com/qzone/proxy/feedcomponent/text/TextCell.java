package com.qzone.proxy.feedcomponent.text;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TextCell implements Serializable, Cloneable {
    protected static final int DEFAULT_COLOR_NOT_SET = Integer.MIN_VALUE;
    protected static double FADE_SCALE = 200.0d;
    protected static double FADE_START_INTERVAL = 100.0d;
    public static final int FLAG_EMO = 256;
    public static final int FLAG_EMO_MASK = 1044480;
    public static final int FLAG_EMO_SEQ = 4096;
    public static final int FLAG_LINEBREAK_MASK = 267386880;
    public static final int FLAG_LINEBREAK_SEQ = 1048576;
    public static final int FLAG_TYPE_MASK = 255;
    public static final int SIGN_ADV_SUMMARY = 17;
    public static final int SIGN_COLOR = 9;
    public static final int SIGN_COMMENT = 7;
    public static final int SIGN_ELLIPSIS = 20;
    public static final int SIGN_FEED_OWNER = 6;
    public static final int SIGN_GOTO_DETAIL = 5;
    public static final int SIGN_LIKE_NICKNAME = 19;
    public static final int SIGN_LINEBREAK = 16;
    public static final int SIGN_MORE = 10;
    public static final int SIGN_NORMAL = 0;
    public static final int SIGN_PACK_OR_UNPACK = 18;
    public static final int SIGN_REPLY = 8;
    public static final int SIGN_TOPIC = 1;
    public static final int SIGN_URL = 4;
    public static final int SIGN_USER = 3;
    public static final int SIGN_WALL = 2;
    static final String ellipsis = "...";
    private static final long serialVersionUID = 5342730555874002105L;
    private boolean canCopy;
    public int cellIndex;
    public int commentSpanHeight;
    protected float fontSize;
    public boolean isDrawableLoaded;
    public boolean isPresseding;
    public MotionEvent lastClickEvent;
    public int linebreak;
    public int linebreakSeq;
    protected int linkColor;
    protected float mAscent;
    protected float mDefaultAscent;
    protected float mDefaultDescent;
    protected float mDescent;
    protected int mInnerLinkTextColor;
    protected int mInnerTextColor;
    protected int mShadowColor;
    protected int mShadowRadius;
    protected int mShadowX;
    protected int mShadowY;
    public int maxCommentHeight;
    public boolean needHighLight;
    private Pair<Integer, Integer> points;
    public String post;
    public transient Rect rect;
    public String text;

    @Deprecated
    protected int textColor;
    public int type;
    protected Long uin;
    private String url;
    public boolean useDefaultFont;
    protected boolean useHanyiColorFont;
    public boolean useLinkTextColor;
    public boolean useSuperFont;
    protected static double FADE_LENGTH = ar.e(10.0f);
    private static Paint sDebugPaint = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Intent intent;
            if (!TextCell.this.clickable() || (intent = TextCell.this.getIntent()) == null) {
                return;
            }
            view.getContext().startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    public TextCell() {
        this.needHighLight = false;
        this.useDefaultFont = false;
        this.useHanyiColorFont = true;
        this.mInnerTextColor = Integer.MIN_VALUE;
        this.mInnerLinkTextColor = Integer.MIN_VALUE;
        this.linebreakSeq = 0;
        this.cellIndex = 0;
        this.isPresseding = false;
        this.canCopy = true;
        this.isDrawableLoaded = true;
        this.linebreak = 0;
        this.mDescent = -1.0f;
        this.mAscent = -1.0f;
        this.mDefaultDescent = -1.0f;
        this.mDefaultAscent = -1.0f;
        this.useSuperFont = true;
        this.useLinkTextColor = false;
        this.lastClickEvent = null;
        this.commentSpanHeight = 0;
        this.maxCommentHeight = 0;
        this.type = 0;
    }

    private void drawFadeText(Canvas canvas, Paint paint, int i3, String str, Rect rect, int i16, Bitmap bitmap, int i17) {
        paint.setAlpha(i17);
        if (paint instanceof d) {
            ((d) paint).c(str, i3, rect.left, rect.top, canvas, bitmap);
        } else {
            canvas.drawText(str, rect.left, i16, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Paint getShellDebugPaint() {
        if (sDebugPaint == null) {
            Paint paint = new Paint();
            sDebugPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            sDebugPaint.setColor(-6737203);
        }
        return sDebugPaint;
    }

    private float getWidthSafe(Paint paint) {
        float f16 = 0.0f;
        if (TextUtils.isEmpty(this.text)) {
            return 0.0f;
        }
        Typeface initFontInfo = initFontInfo(paint);
        if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint instanceof d)) {
            paint = ((d) paint).e();
        }
        int length = this.text.length();
        int i3 = 0;
        while (i3 < length) {
            int charCount = Character.charCount(this.text.codePointAt(i3)) + i3;
            f16 += paint.measureText(this.text, i3, charCount);
            i3 = charCount;
        }
        if (initFontInfo != null) {
            paint.setTypeface(initFontInfo);
        }
        return f16;
    }

    public boolean canBreak() {
        return true;
    }

    public boolean canCopy() {
        return this.canCopy;
    }

    public boolean clickable() {
        int i3 = this.type & 255;
        return (i3 == 0 || i3 == 16 || i3 == 7 || i3 == 8) ? false : true;
    }

    public TextCell copy() {
        try {
            return (TextCell) clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void draw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap) {
        Shader shader;
        String str;
        Paint paint2 = paint;
        Typeface initFontInfo = initFontInfo(paint);
        if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint2 instanceof d)) {
            paint2 = ((d) paint2).e();
        }
        Paint paint3 = paint2;
        if ((this.type & 255) == 0) {
            int i18 = this.mInnerTextColor;
            if (i18 == Integer.MIN_VALUE) {
                i18 = i16;
            }
            paint3.setColor(i18);
        } else {
            int i19 = this.mInnerLinkTextColor;
            if (i19 == Integer.MIN_VALUE) {
                i19 = i17;
            }
            paint3.setColor(i19);
        }
        float f16 = 0.0f;
        if (this.useSuperFont) {
            shader = null;
        } else {
            Shader shader2 = paint3.getShader();
            paint3.setShader(null);
            paint3.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            f16 = paint3.getTextSize();
            paint3.setTextSize(this.fontSize);
            shader = shader2;
        }
        float f17 = f16;
        int descent = rect.top + ((int) (((i3 - getDescent(paint3)) - getAscent(paint3)) / 2.0f));
        String str2 = this.text;
        if (str2.endsWith("\r\n")) {
            str = this.text.substring(0, r6.length() - 2);
        } else if (this.text.endsWith("\n")) {
            str = this.text.substring(0, r6.length() - 1);
        } else {
            str = str2;
        }
        if (FeedGlobalEnv.g().isViewDebugMode()) {
            canvas.drawRect(rect, getShellDebugPaint());
        }
        try {
            if (paint3 instanceof d) {
                ((d) paint3).c(str, i3, rect.left, rect.top, canvas, bitmap);
            } else {
                canvas.drawText(str, rect.left, descent, paint3);
            }
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.util.j.d("TextCell", "", th5);
        }
        if (initFontInfo != null) {
            paint3.setTypeface(initFontInfo);
        }
        if (this.useSuperFont) {
            return;
        }
        paint3.setTextSize(f17);
        paint3.setShader(shader);
        paint3.setShadowLayer(this.mShadowRadius, this.mShadowX, this.mShadowY, this.mShadowColor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getAscent(Paint paint) {
        if (!this.useDefaultFont && this.useHanyiColorFont && this.useSuperFont) {
            float f16 = this.mAscent;
            return f16 <= 0.0f ? paint.ascent() : f16;
        }
        if (this.mDefaultAscent <= 0.0f) {
            this.mDefaultAscent = paint.ascent();
        }
        return this.mDefaultAscent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getDescent(Paint paint) {
        if (!this.useDefaultFont && this.useHanyiColorFont && this.useSuperFont) {
            float f16 = this.mDescent;
            return f16 <= 0.0f ? paint.descent() : f16;
        }
        if (this.mDefaultDescent <= 0.0f) {
            this.mDefaultDescent = paint.descent();
        }
        return this.mDefaultDescent;
    }

    public int getDrawTextLength() {
        if (this.text.endsWith("\r\n")) {
            return this.text.length() - 2;
        }
        if (this.text.endsWith("\n")) {
            return this.text.length() - 1;
        }
        return this.text.length();
    }

    public int getFinalLinkTextColor(int i3) {
        int i16 = this.mInnerLinkTextColor;
        return i16 != Integer.MIN_VALUE ? i16 : i3;
    }

    public int getFinalTextColor(int i3) {
        int i16 = this.mInnerTextColor;
        return i16 != Integer.MIN_VALUE ? i16 : i3;
    }

    public int getHeight(Paint paint) {
        Typeface initFontInfo = initFontInfo(paint);
        if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint instanceof d)) {
            paint = ((d) paint).e();
        }
        int descent = (int) (getDescent(paint) - getAscent(paint));
        if (initFontInfo != null) {
            paint.setTypeface(initFontInfo);
        }
        return descent;
    }

    public Intent getIntent() {
        return null;
    }

    public int getLength() {
        String str = this.text;
        if (str != null) {
            return str.length();
        }
        return 0;
    }

    public Pair<Integer, Integer> getPoint() {
        return this.points;
    }

    public String getPost() {
        if (!TextUtils.isEmpty(this.post)) {
            return this.post;
        }
        return "";
    }

    public ClickableSpan getSpan() {
        return new a();
    }

    public String getText() {
        String str = this.text;
        return str == null ? "" : str;
    }

    public int getType() {
        return this.type;
    }

    public Long getUin() {
        return this.uin;
    }

    public String getUrl() {
        return this.url;
    }

    public float getWidth(Paint paint) {
        Typeface initFontInfo = initFontInfo(paint);
        if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint instanceof d)) {
            paint = ((d) paint).e();
        }
        float measureText = paint.measureText(this.text);
        if (measureText <= 0.0f) {
            measureText = getWidthSafe(paint);
        }
        if (initFontInfo != null) {
            paint.setTypeface(initFontInfo);
        }
        return measureText;
    }

    public int getWidths(Paint paint, int i3, int i16, float[] fArr) {
        if (TextUtils.isEmpty(this.text)) {
            return 0;
        }
        int i17 = i16 + i3;
        if (i17 > this.text.length()) {
            i17 = this.text.length();
        }
        if (i3 >= i17) {
            return 0;
        }
        Typeface initFontInfo = initFontInfo(paint);
        if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint instanceof d)) {
            paint = ((d) paint).e();
        }
        int textWidths = paint.getTextWidths(this.text, i3, i17, fArr);
        if (initFontInfo != null) {
            paint.setTypeface(initFontInfo);
        }
        return textWidths;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface initFontInfo(Paint paint) {
        boolean z16;
        Typeface typeface;
        if (this.useHanyiColorFont || !(paint instanceof d)) {
            z16 = false;
            typeface = null;
        } else {
            paint = ((d) paint).e();
            typeface = paint.getTypeface();
            paint.setTypeface(null);
            z16 = true;
        }
        if (!this.useDefaultFont) {
            return typeface;
        }
        if (paint instanceof d) {
            paint = ((d) paint).e();
        }
        if (z16) {
            return typeface;
        }
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(null);
        return typeface2;
    }

    public boolean isEmo() {
        return false;
    }

    public boolean isUseCustomFont() {
        return false;
    }

    public void setCanCopy(boolean z16) {
        this.canCopy = z16;
    }

    public void setDefaultShadowLayer(int i3, int i16, int i17, int i18) {
        this.mShadowRadius = i3;
        this.mShadowX = i16;
        this.mShadowY = i17;
        this.mShadowColor = i18;
    }

    public void setFontSize(Paint paint, float f16) {
        this.fontSize = f16;
        this.mDescent = paint.descent();
        this.mAscent = paint.ascent();
        this.mDefaultDescent = -1.0f;
        this.mDefaultAscent = -1.0f;
    }

    public void setInnerLinkTextColor(int i3) {
        this.mInnerLinkTextColor = i3;
    }

    public void setInnerTextColor(int i3) {
        this.mInnerTextColor = i3;
    }

    public void setLinkColor(int i3) {
        this.linkColor = i3;
    }

    public void setPoint(int i3, int i16) {
        this.points = new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public void setPost(String str) {
        this.post = str;
    }

    public void setUin(Long l3) {
        this.uin = l3;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public boolean fadedDraw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap, int i18, long j3) {
        int i19;
        boolean z16;
        int i26;
        int i27;
        double d16;
        String str;
        String str2;
        Paint paint2 = paint;
        Typeface initFontInfo = initFontInfo(paint2);
        if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint2 instanceof d)) {
            paint2 = ((d) paint2).e();
        }
        Paint paint3 = paint2;
        if ((this.type & 255) == 0) {
            paint3.setColor(getFinalTextColor(i16));
        } else {
            paint3.setColor(getFinalLinkTextColor(i17));
        }
        int descent = rect.top + ((int) (((i3 - getDescent(paint3)) - getAscent(paint3)) / 2.0f));
        String str3 = this.text;
        if (str3.endsWith("\r\n")) {
            str3 = this.text.substring(0, r0.length() - 2);
        } else if (this.text.endsWith("\n")) {
            String str4 = this.text;
            str3 = str4.substring(0, str4.length() - 1);
        }
        String str5 = str3;
        if (FeedGlobalEnv.g().isViewDebugMode()) {
            canvas.drawRect(rect, getShellDebugPaint());
        }
        if (initFontInfo != null) {
            paint3.setTypeface(initFontInfo);
        }
        double d17 = j3;
        int floor = ((int) Math.floor(d17 / FADE_START_INTERVAL)) - i18;
        if (floor >= str5.length()) {
            i19 = str5.length();
            z16 = false;
        } else if (floor < 0) {
            z16 = true;
            i19 = 0;
        } else {
            i19 = floor;
            z16 = true;
        }
        int alpha = paint3.getAlpha();
        if (i19 > 0) {
            i26 = alpha;
            i27 = i19;
            d16 = d17;
            str = str5;
            drawFadeText(canvas, paint3, i3, str5.substring(0, i19), rect, descent, bitmap, 255);
        } else {
            i26 = alpha;
            i27 = i19;
            d16 = d17;
            str = str5;
        }
        String a16 = com.qzone.util.l.a(R.string.u2w);
        double measureText = paint3.measureText(a16 + a16) - (paint3.measureText(a16) * 2.0f);
        int i28 = i27;
        while (i28 < str.length()) {
            double d18 = d16 - ((i28 + i18) * FADE_START_INTERVAL);
            if (d18 <= 0.0d) {
                break;
            }
            double d19 = FADE_SCALE;
            double d26 = (d18 % d19) / d19;
            int i29 = (int) (255.0d * d26);
            int i36 = ((int) ((1.0d - d26) * FADE_LENGTH)) + rect.left;
            if (i28 != 0) {
                str2 = str;
                i36 = (int) (i36 + ((int) paint3.measureText(str2, 0, i28)) + measureText);
            } else {
                str2 = str;
            }
            Rect rect2 = new Rect(rect);
            rect2.left = i36;
            int i37 = i28 + 1;
            drawFadeText(canvas, paint3, i3, str2.substring(i28, i37), rect2, descent, bitmap, i29);
            i28 = i37;
            str = str2;
            measureText = measureText;
        }
        paint3.setAlpha(i26);
        return z16;
    }

    public TextCell(int i3) {
        this.needHighLight = false;
        this.useDefaultFont = false;
        this.useHanyiColorFont = true;
        this.mInnerTextColor = Integer.MIN_VALUE;
        this.mInnerLinkTextColor = Integer.MIN_VALUE;
        this.linebreakSeq = 0;
        this.cellIndex = 0;
        this.isPresseding = false;
        this.canCopy = true;
        this.isDrawableLoaded = true;
        this.linebreak = 0;
        this.mDescent = -1.0f;
        this.mAscent = -1.0f;
        this.mDefaultDescent = -1.0f;
        this.mDefaultAscent = -1.0f;
        this.useSuperFont = true;
        this.useLinkTextColor = false;
        this.lastClickEvent = null;
        this.commentSpanHeight = 0;
        this.maxCommentHeight = 0;
        this.type = i3;
    }

    public void draw(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18) {
        if (isEmo() || this.rect == null) {
            return;
        }
        int i19 = this.type & 255;
        if (i19 != 0 && i19 != 7 && i19 != 8) {
            paint.setColor(i17);
        } else {
            paint.setColor(i16);
        }
        int descent = this.rect.top + ((int) (((i3 - getDescent(paint)) - getAscent(paint)) / 2.0f));
        if (FeedGlobalEnv.g().isViewDebugMode()) {
            canvas.drawRect(this.rect, getShellDebugPaint());
        }
        if (i18 > 0) {
            if (i18 < this.rect.right) {
                String str = this.text;
                canvas.drawText(str.substring(0, paint.breakText(str, true, (i18 - r5.left) - paint.measureText("..."), null)) + "...", this.rect.left, descent, paint);
                return;
            }
        }
        canvas.drawText(this.text, this.rect.left, descent, paint);
    }

    public TextCell(int i3, String str) {
        this.needHighLight = false;
        this.useDefaultFont = false;
        this.useHanyiColorFont = true;
        this.mInnerTextColor = Integer.MIN_VALUE;
        this.mInnerLinkTextColor = Integer.MIN_VALUE;
        this.linebreakSeq = 0;
        this.cellIndex = 0;
        this.isPresseding = false;
        this.canCopy = true;
        this.isDrawableLoaded = true;
        this.linebreak = 0;
        this.mDescent = -1.0f;
        this.mAscent = -1.0f;
        this.mDefaultDescent = -1.0f;
        this.mDefaultAscent = -1.0f;
        this.useSuperFont = true;
        this.useLinkTextColor = false;
        this.lastClickEvent = null;
        this.commentSpanHeight = 0;
        this.maxCommentHeight = 0;
        this.type = i3;
        this.text = str;
    }
}
