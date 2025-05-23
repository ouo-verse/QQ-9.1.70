package com.qzone.proxy.feedcomponent.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ColorTextCell extends TextCell {
    private static final long serialVersionUID = -7171491901412815564L;
    protected boolean bold;
    private boolean clickable;
    protected int textColor;

    public ColorTextCell() {
        super(0);
        this.clickable = true;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public boolean clickable() {
        return this.clickable && super.clickable();
    }

    public void setClickable(boolean z16) {
        this.clickable = z16;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTextBold(boolean z16) {
        this.bold = z16;
    }

    public void setTextColor(int i3) {
        this.textColor = i3;
    }

    public ColorTextCell(int i3) {
        super(i3);
        this.clickable = true;
    }

    public ColorTextCell(int i3, String str) {
        super(i3, str);
        this.clickable = true;
    }

    public ColorTextCell(int i3, String str, int i16) {
        super(i3, str);
        this.clickable = true;
        this.textColor = i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap) {
        String str;
        String substring;
        Paint paint2 = paint;
        Typeface initFontInfo = initFontInfo(paint2);
        if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint2 instanceof d)) {
            paint2 = ((d) paint2).e();
        }
        Paint paint3 = paint2;
        int i18 = this.type;
        if ((i18 & 255) != 0 && i18 != 3 && i18 != 4 && i18 != 5 && i18 != 6 && i18 != 18 && i18 != 1 && !this.useLinkTextColor) {
            paint3.setColor(this.textColor);
        } else {
            paint3.setColor(getFinalLinkTextColor(i17));
        }
        boolean isFakeBoldText = paint3.isFakeBoldText();
        boolean z16 = this.bold;
        if (z16) {
            paint3.setFakeBoldText(z16);
        }
        Shader shader = null;
        float f16 = 0.0f;
        if (!this.useSuperFont) {
            Shader shader2 = paint3.getShader();
            paint3.setShader(null);
            paint3.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            f16 = paint3.getTextSize();
            paint3.setTextSize(this.fontSize);
            shader = shader2;
        }
        int descent = rect.top + ((int) (((i3 - getDescent(paint3)) - getAscent(paint3)) / 2.0f));
        String str2 = this.text;
        if (str2.endsWith("\r\n")) {
            substring = this.text.substring(0, r6.length() - 2);
        } else if (this.text.endsWith("\n")) {
            String str3 = this.text;
            substring = str3.substring(0, str3.length() - 1);
        } else {
            str = str2;
            if (!TextUtils.isEmpty(str)) {
                if (paint3 instanceof d) {
                    ((d) paint3).c(str, i3, rect.left, rect.top, canvas, bitmap);
                } else {
                    try {
                        canvas.drawText(str, rect.left, descent, paint3);
                    } catch (NullPointerException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            if (this.bold) {
                paint3.setFakeBoldText(isFakeBoldText);
            }
            if (initFontInfo != null) {
                paint3.setTypeface(initFontInfo);
            }
            if (this.useSuperFont) {
                paint3.setTextSize(f16);
                paint3.setShader(shader);
                paint3.setShadowLayer(this.mShadowRadius, this.mShadowX, this.mShadowY, this.mShadowColor);
                return;
            }
            return;
        }
        str = substring;
        if (!TextUtils.isEmpty(str)) {
        }
        if (this.bold) {
        }
        if (initFontInfo != null) {
        }
        if (this.useSuperFont) {
        }
    }
}
