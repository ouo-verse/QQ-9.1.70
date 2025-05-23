package com.qzone.proxy.feedcomponent.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.mobileqq.R;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class EmoCell extends TextCell {
    private static final long serialVersionUID = -3999833992135197771L;
    String emoCode;
    public Drawable emoDrawable;

    public EmoCell() {
        this.type = 0;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public boolean canBreak() {
        return false;
    }

    public EmoCell cloneEmoCell() {
        EmoCell emoCell = new EmoCell();
        emoCell.emoDrawable = this.emoDrawable;
        emoCell.emoCode = this.emoCode;
        emoCell.needHighLight = this.needHighLight;
        emoCell.useDefaultFont = this.useDefaultFont;
        emoCell.useHanyiColorFont = this.useHanyiColorFont;
        emoCell.textColor = this.textColor;
        emoCell.uin = this.uin;
        emoCell.type = this.type;
        emoCell.text = this.text;
        emoCell.cellIndex = this.cellIndex;
        emoCell.linebreakSeq = this.linebreakSeq;
        emoCell.isPresseding = this.isPresseding;
        emoCell.isDrawableLoaded = this.isDrawableLoaded;
        emoCell.linebreak = this.linebreak;
        emoCell.post = this.post;
        emoCell.mShadowRadius = this.mShadowRadius;
        emoCell.mShadowX = this.mShadowX;
        emoCell.mShadowY = this.mShadowY;
        emoCell.mShadowColor = this.mShadowColor;
        emoCell.linkColor = this.linkColor;
        emoCell.fontSize = this.fontSize;
        emoCell.useSuperFont = this.useSuperFont;
        return emoCell;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public void draw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap) {
        if (!this.useDefaultFont && (paint instanceof d)) {
            d dVar = (d) paint;
            if (dVar.i() && !dVar.f50712d) {
                return;
            }
        }
        try {
            Drawable emoDrawable = getEmoDrawable();
            if (emoDrawable != null) {
                if (FeedGlobalEnv.g().isViewDebugMode()) {
                    canvas.drawRect(rect, TextCell.getShellDebugPaint());
                }
                canvas.translate(rect.left, (rect.top - 1) + ((i3 - emoDrawable.getBounds().height()) / 2));
                emoDrawable.draw(canvas);
                canvas.translate(-r5, -r4);
            }
        } catch (Exception unused) {
        }
    }

    public Drawable getEmoDrawable() {
        return this.emoDrawable;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public int getHeight(Paint paint) {
        Drawable emoDrawable = getEmoDrawable();
        if (emoDrawable == null) {
            return 0;
        }
        return emoDrawable.getBounds().height();
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public int getLength() {
        return 1;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public String getText() {
        if (TextUtils.isEmpty(this.text)) {
            String description = QzoneEmotionUtils.getDescription(this.emoCode);
            this.text = description;
            if (description == null) {
                this.text = this.emoCode;
            }
        }
        return this.text;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public float getWidth(Paint paint) {
        if (getEmoDrawable() == null) {
            return 0.0f;
        }
        return r1.getBounds().width();
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public int getWidths(Paint paint, int i3, int i16, float[] fArr) {
        fArr[0] = getEmoDrawable() == null ? 0.0f : r1.getBounds().width();
        return 1;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public boolean isEmo() {
        return true;
    }

    public void reloadDrawable(TextLayoutBase textLayoutBase, com.qzone.proxy.feedcomponent.text.font.a aVar) {
        EmoObjectPool.f().o(this, textLayoutBase, aVar);
    }

    public EmoCell(String str, Drawable drawable) {
        super(0);
        this.emoCode = str;
        this.emoDrawable = drawable;
    }

    public EmoCell(String str) {
        this.text = str;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public boolean fadedDraw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap, int i18, long j3) {
        double d16 = j3;
        int floor = ((int) Math.floor(d16 / TextCell.FADE_START_INTERVAL)) - i18;
        int alpha = paint.getAlpha();
        if (floor > 0) {
            draw(canvas, paint, i3, rect, i16, i17, bitmap);
            return false;
        }
        String a16 = com.qzone.util.l.a(R.string.m5d);
        paint.measureText(a16 + a16);
        paint.measureText(a16);
        double d17 = d16 - (((double) (i18 + 1)) * TextCell.FADE_START_INTERVAL);
        if (d17 <= 0.0d) {
            paint.setAlpha(alpha);
            return true;
        }
        double d18 = TextCell.FADE_SCALE;
        double d19 = (d17 % d18) / d18;
        int i19 = (int) (255.0d * d19);
        int i26 = ((int) ((1.0d - d19) * TextCell.FADE_LENGTH)) + rect.left;
        Rect rect2 = new Rect(rect);
        rect2.left = i26;
        paint.setAlpha(i19);
        draw(canvas, paint, i3, rect2, i16, i17, bitmap);
        paint.setAlpha(alpha);
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public void draw(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18) {
        try {
            Drawable emoDrawable = getEmoDrawable();
            if (emoDrawable != null) {
                if (FeedGlobalEnv.g().isViewDebugMode()) {
                    canvas.drawRect(this.rect, TextCell.getShellDebugPaint());
                }
                canvas.translate(this.rect.left, (r4.top - 1) + ((i3 - emoDrawable.getBounds().height()) / 2));
                emoDrawable.draw(canvas);
                canvas.translate(-r5, -r4);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public TextCell copy() {
        return this;
    }
}
