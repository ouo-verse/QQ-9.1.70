package com.qzone.canvasui.widget.danmaku;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes39.dex */
class GdtDanmakuModel {
    private String[] mContents;
    private Random mRandom = new Random();
    private int mStrIndex = 0;

    public final String getNextContentInOrder() {
        String[] strArr = this.mContents;
        if (strArr != null && strArr.length != 0) {
            int max = Math.max(this.mStrIndex % strArr.length, 0);
            String str = strArr[max];
            this.mStrIndex = max + 1;
            return str;
        }
        return "";
    }

    public final String getNextContentRandomly() {
        String[] strArr = this.mContents;
        if (strArr != null && strArr.length != 0) {
            return strArr[this.mRandom.nextInt(strArr.length)];
        }
        return "";
    }

    public boolean isEmpty() {
        String[] strArr = this.mContents;
        return strArr == null || strArr.length == 0;
    }

    public GdtDanmakuModel setContents(String[] strArr) {
        this.mContents = strArr;
        return this;
    }

    public void reset() {
        this.mStrIndex = 0;
        this.mContents = null;
    }
}
