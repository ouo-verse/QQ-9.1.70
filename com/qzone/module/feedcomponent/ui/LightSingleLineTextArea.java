package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.qzone.proxy.feedcomponent.text.TextCell;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LightSingleLineTextArea extends FeedTextArea {
    protected TextCell mSigleTextCell;
    protected Rect rect;

    public LightSingleLineTextArea(int i3) {
        super(i3);
        this.mSigleTextCell = new TextCell(0);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        if (this.rect == null) {
            this.rect = new Rect(0, 0, 0, 0);
        }
        this.mSigleTextCell.draw(canvas, this.paint, this.mHeight, this.textColor, com.qzone.adapter.feedcomponent.j.I(), 0);
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        this.mWidth = this.mSigleTextCell.rect.width();
    }

    public void setText(String str) {
        this.mSigleTextCell.text = str;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea
    public void setTextSize(float f16) {
        super.setTextSize(f16);
        this.mHeight = this.mSigleTextCell.getHeight(this.paint);
        this.mSigleTextCell.rect = new Rect(0, 0, 10000, this.mHeight);
    }
}
