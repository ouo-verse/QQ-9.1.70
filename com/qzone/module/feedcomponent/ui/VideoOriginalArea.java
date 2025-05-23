package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VideoOriginalArea extends FeedTextArea {
    static final int DEFAULT_SPACE;
    static final int ICON_HEIGHT;
    static final int ICON_WIDTH;
    static Drawable ROUND_DRAWABLE_BG;
    private static String originalText = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "Original", "\u539f\u521b");
    boolean mHasPhoto;
    boolean mHasVideo;
    int mTextWidth;

    static {
        try {
            ROUND_DRAWABLE_BG = com.qzone.adapter.feedcomponent.j.g(com.tencent.luggage.wxa.uf.e.CTRL_INDEX);
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d("VideoOriginalArea", "", e16);
        }
        DEFAULT_SPACE = (int) (FeedGlobalEnv.g().getDensity() * 5.0f);
        ICON_HEIGHT = (int) (FeedGlobalEnv.g().getDensity() * 16.0f);
        ICON_WIDTH = (int) (FeedGlobalEnv.g().getDensity() * 33.0f);
    }

    public VideoOriginalArea() {
        super(81);
        initText(originalText);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(DEFAULT_SPACE, 0.0f);
        super.draw(canvas, paint);
        canvas.restore();
        ROUND_DRAWABLE_BG.setBounds(0, 0, ICON_WIDTH, ICON_HEIGHT);
        ROUND_DRAWABLE_BG.draw(canvas);
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        this.mTextWidth = i3;
        if (mode == 1073741824 || (mode == 0 && size > 0)) {
            this.mTextWidth = size - DEFAULT_SPACE;
        }
        super.measure(-2, i16);
        this.mTextWidth = this.mWidth;
        this.mHeight = ICON_HEIGHT;
    }

    private void initText(String str) {
        setData(str, 0);
        setTextSize(11.0f);
        setTextColor(Color.parseColor("#999999"));
        super.measure(-2, 0);
    }

    public VideoOriginalArea(String str) {
        super(81);
        initText(str);
    }
}
