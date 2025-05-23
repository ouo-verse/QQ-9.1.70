package com.qzone.proxy.feedcomponent.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UserNameCell extends ColorTextCell {
    private static final long serialVersionUID = 90745655000732280L;

    public UserNameCell() {
        this(3);
    }

    private void a() {
        setTextColor(FeedGlobalEnv.g().getColor(3));
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public void setLinkColor(int i3) {
        super.setLinkColor(i3);
    }

    public UserNameCell(int i3) {
        this(i3, null);
    }

    public UserNameCell(int i3, String str) {
        super(i3, str);
        a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UserNameCell(int i3, String str, String str2) {
        super(i3, r0.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(str2 == null ? "" : str2);
        a();
    }

    public void etPaintDrawText(String str, int i3, Rect rect, Canvas canvas, Bitmap bitmap, Paint paint) {
        if (rect == null || canvas == null || paint == null) {
            return;
        }
        ((d) paint).c(str, i3, rect.left, rect.top, canvas, bitmap);
    }

    public void canvasDrawText(Canvas canvas, String str, Rect rect, int i3, Paint paint) {
        if (canvas == null || rect == null || paint == null || str == null) {
            return;
        }
        canvas.drawText(str, rect.left, i3, paint);
    }

    @Override // com.qzone.proxy.feedcomponent.text.ColorTextCell, com.qzone.proxy.feedcomponent.text.TextCell
    public void draw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap) {
        Shader shader;
        Paint paint2 = paint;
        if (paint2 == null || rect == null || canvas == null) {
            return;
        }
        Typeface initFontInfo = initFontInfo(paint2);
        if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint2 instanceof d)) {
            paint2 = ((d) paint2).e();
        }
        Paint paint3 = paint2;
        int i18 = this.type;
        if ((i18 & 255) != 0 && i18 != 19 && i18 != 3 && i18 != 4 && i18 != 5 && i18 != 6) {
            paint3.setColor(getFinalTextColor(i16));
        } else {
            paint3.setColor(getFinalLinkTextColor(this.linkColor));
        }
        boolean isFakeBoldText = paint3.isFakeBoldText();
        boolean z16 = this.bold;
        if (z16) {
            paint3.setFakeBoldText(z16);
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
            paint3.setColor(getFinalLinkTextColor(this.linkColor));
            shader = shader2;
        }
        float f17 = f16;
        int descent = rect.top + ((int) (((i3 - getDescent(paint3)) - getAscent(paint3)) / 2.0f));
        String str = this.text;
        if (str.endsWith("\r\n")) {
            str = this.text.substring(0, r0.length() - 2);
        } else if (this.text.endsWith("\n")) {
            str = this.text.substring(0, r0.length() - 1);
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            if (paint3 instanceof d) {
                etPaintDrawText(str2, i3, rect, canvas, bitmap, paint3);
            } else {
                canvasDrawText(canvas, str2, rect, descent, paint3);
            }
            if (FeedGlobalEnv.g().isViewDebugMode()) {
                canvas.drawRect(rect, TextCell.getShellDebugPaint());
            }
        }
        if (this.bold) {
            paint3.setFakeBoldText(isFakeBoldText);
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
}
