package com.tencent.tavmovie.sticker;

import android.support.annotation.NonNull;
import com.tencent.tavsticker.model.TAVStickerTextItem;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieStickerTextItem implements Cloneable {
    private String fontPath;
    private String text;
    private int textColor;
    private TAVStickerTextItem textItem;

    public TAVMovieStickerTextItem() {
    }

    public String getFontPath() {
        return this.fontPath;
    }

    public String getText() {
        return this.text;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public TAVStickerTextItem getTextItem() {
        return this.textItem;
    }

    public void setFontPath(String str) {
        this.fontPath = str;
        TAVStickerTextItem tAVStickerTextItem = this.textItem;
        if (tAVStickerTextItem != null) {
            tAVStickerTextItem.setFontPath(str);
        }
    }

    public void setText(String str) {
        this.text = str;
        TAVStickerTextItem tAVStickerTextItem = this.textItem;
        if (tAVStickerTextItem != null) {
            tAVStickerTextItem.setText(str);
        }
    }

    public void setTextColor(int i3) {
        this.textColor = i3;
        TAVStickerTextItem tAVStickerTextItem = this.textItem;
        if (tAVStickerTextItem != null) {
            tAVStickerTextItem.setTextColor(i3);
        }
    }

    public void setTextItem(TAVStickerTextItem tAVStickerTextItem) {
        this.textItem = tAVStickerTextItem;
    }

    public TAVMovieStickerTextItem(@NonNull TAVStickerTextItem tAVStickerTextItem) {
        this.textItem = tAVStickerTextItem;
        this.text = tAVStickerTextItem.getText();
        this.textColor = this.textItem.getTextColor();
        this.fontPath = this.textItem.getFontPath();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVMovieStickerTextItem m282clone() {
        TAVMovieStickerTextItem tAVMovieStickerTextItem = new TAVMovieStickerTextItem();
        tAVMovieStickerTextItem.setTextItem(this.textItem);
        tAVMovieStickerTextItem.setText(this.text);
        tAVMovieStickerTextItem.setTextColor(this.textColor);
        tAVMovieStickerTextItem.setFontPath(this.fontPath);
        return tAVMovieStickerTextItem;
    }
}
