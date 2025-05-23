package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data;

import android.graphics.Bitmap;
import android.graphics.Color;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SentenceAttachInfo {
    public Bitmap mBitmap;
    public int mPadding;
    public int mSentenceColor;

    public SentenceAttachInfo() {
        this.mSentenceColor = Color.parseColor("#FFFF0000");
    }

    public SentenceAttachInfo(SentenceAttachInfo sentenceAttachInfo) {
        this.mSentenceColor = Color.parseColor("#FFFF0000");
        this.mSentenceColor = sentenceAttachInfo.mSentenceColor;
        this.mBitmap = sentenceAttachInfo.mBitmap;
        this.mPadding = sentenceAttachInfo.mPadding;
    }
}
