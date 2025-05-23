package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;

/* loaded from: classes39.dex */
public class PlayBarUserArea extends FeedTextArea {
    public static final int DEFAULT_WIDTH;
    public static final int TEXT_MARGIN_LEFT;
    String displayStr;
    String playingText;
    int playingTextX;
    int playingTextY;
    static final String PLAYING_TEXT = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "Playing", "\u5728\u73a9");
    static final int DEFAULT_SPACE = (int) (FeedGlobalEnv.g().getDensity() * 1.0f);
    public static final float TEXT_SIZE = AreaConst.secondTextSize;
    public static final int TEXT_COLOR = com.qzone.adapter.feedcomponent.j.o();

    static {
        int a16 = com.qzone.proxy.feedcomponent.util.g.a(10.0f);
        TEXT_MARGIN_LEFT = a16;
        DEFAULT_WIDTH = SinglePlayPicArea.DEFAULT_PIC_WIDTH - a16;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        canvas.drawText(this.playingText, this.playingTextX, this.playingTextY + ((int) (((super.getHeight() - this.paint.descent()) - this.paint.ascent()) / 2.0f)), this.paint);
        return super.draw(canvas, this.paint);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        int measureText = i3 - ((int) this.paint.measureText(this.playingText));
        int i17 = DEFAULT_SPACE;
        super.setMaxWidth(measureText - i17);
        super.measure(-2, i16);
        this.playingTextX = super.getMeasuredWidth() + i17;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea
    public void setData(String str, int i3) {
        this.displayStr = str;
        super.setData(str, i3);
    }

    public void setPostFix(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.playingText = str;
        } else {
            this.playingText = PLAYING_TEXT;
        }
    }

    public PlayBarUserArea() {
        super(33);
        this.playingText = PLAYING_TEXT;
        setTextSize(TEXT_SIZE);
        setTextColor(TEXT_COLOR);
        setMaxLine(1);
    }
}
