package com.qzone.proxy.feedcomponent.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.qzone.module.feedcomponent.ui.AreaConst;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NetImageCell extends NetEmoCell {
    private int customId;
    private boolean isClickable;
    private long uin;

    public NetImageCell(String str) {
        super(str);
        this.isClickable = true;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public boolean clickable() {
        return this.isClickable;
    }

    @Override // com.qzone.proxy.feedcomponent.text.NetEmoCell, com.qzone.proxy.feedcomponent.text.EmoCell, com.qzone.proxy.feedcomponent.text.TextCell
    public void draw(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18) {
        Drawable emoDrawable = getEmoDrawable();
        if ((i18 <= 0 || i18 >= this.rect.right) && emoDrawable != null) {
            emoDrawable.setBounds(0, 0, this.mWidth, this.mHeight);
            canvas.save();
            Rect rect = this.rect;
            canvas.translate(rect.left, (rect.top - 1) + ((i3 - emoDrawable.getBounds().height()) / 2));
            emoDrawable.draw(canvas);
            canvas.restore();
        }
    }

    public int getCustomId() {
        return this.customId;
    }

    public long getCustomUin() {
        return this.uin;
    }

    @Override // com.qzone.proxy.feedcomponent.text.NetEmoCell, com.qzone.proxy.feedcomponent.text.EmoCell, com.qzone.proxy.feedcomponent.text.TextCell
    public int getHeight(Paint paint) {
        Drawable drawable = this.emoDrawable;
        if (drawable != null && this.mHeight == 0) {
            return drawable.getBounds().height();
        }
        return this.mHeight + AreaConst.f48749dp4;
    }

    @Override // com.qzone.proxy.feedcomponent.text.NetEmoCell, com.qzone.proxy.feedcomponent.text.EmoCell, com.qzone.proxy.feedcomponent.text.TextCell
    public float getWidth(Paint paint) {
        int i3;
        int i16;
        Drawable drawable = this.emoDrawable;
        if (drawable != null && this.mWidth == 0) {
            i3 = drawable.getBounds().width() + this.mLeftPadding;
            i16 = this.mRightPadding;
        } else {
            i3 = this.mWidth + this.mLeftPadding;
            i16 = this.mRightPadding;
        }
        return i3 + i16;
    }

    @Override // com.qzone.proxy.feedcomponent.text.EmoCell
    public void reloadDrawable(TextLayoutBase textLayoutBase, com.qzone.proxy.feedcomponent.text.font.a aVar) {
        EmoObjectPool.f().p(this, textLayoutBase, aVar);
    }

    public void setClickable(boolean z16) {
        this.isClickable = z16;
    }

    public void setCustomId(int i3) {
        this.customId = i3;
    }

    public void setCustomUin(long j3) {
        this.uin = j3;
    }

    public NetImageCell(String str, Drawable drawable) {
        super(str, drawable);
        this.isClickable = true;
    }
}
