package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.constant.PractiveConst;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SentenceUI {
    private static final String TAG = "SentenceUI";
    public final ArrayList<LyricCharacter> mCharacters;
    public long mEndTime;
    private final int mHighLightOffsetX;
    public SentenceAttachInfo mLeftAttachInfo = null;
    private final int mNormalOffsetX;
    public long mStartTime;
    public final String mText;

    public SentenceUI(String str, int i3, int i16, ArrayList<LyricCharacter> arrayList) {
        this.mStartTime = 0L;
        this.mEndTime = 0L;
        this.mNormalOffsetX = i3;
        this.mHighLightOffsetX = i16;
        this.mText = str;
        this.mCharacters = arrayList;
        if (arrayList != null && arrayList.size() > 0) {
            this.mStartTime = arrayList.get(0).mStartTime;
            LyricCharacter lyricCharacter = arrayList.get(arrayList.size() - 1);
            this.mEndTime = lyricCharacter.mStartTime + lyricCharacter.mDuration;
        }
    }

    private void drawAttachInfo(Canvas canvas, int i3, int i16, Paint paint) {
        Bitmap bitmap;
        int i17 = i3 + this.mNormalOffsetX;
        SentenceAttachInfo sentenceAttachInfo = this.mLeftAttachInfo;
        if (sentenceAttachInfo != null && (bitmap = sentenceAttachInfo.mBitmap) != null && !bitmap.isRecycled()) {
            SentenceAttachInfo sentenceAttachInfo2 = this.mLeftAttachInfo;
            canvas.drawBitmap(this.mLeftAttachInfo.mBitmap, (Rect) null, new Rect((i17 - sentenceAttachInfo2.mPadding) - sentenceAttachInfo2.mBitmap.getWidth(), (int) ((i16 - paint.getTextSize()) + 2.0f), i17 - this.mLeftAttachInfo.mPadding, (int) (((i16 + r4.mBitmap.getHeight()) - paint.getTextSize()) + 2.0f)), (Paint) null);
        }
    }

    public void drawLyricContour(Canvas canvas, int i3, int i16, Paint paint, boolean z16) {
        int i17;
        if (z16) {
            i17 = this.mHighLightOffsetX;
        } else {
            i17 = this.mNormalOffsetX;
        }
        int i18 = i3 + i17;
        float f16 = i18 - 1;
        float f17 = i16 - 1;
        canvas.drawText(this.mText, f16, f17, paint);
        float f18 = i18;
        canvas.drawText(this.mText, f18, f17, paint);
        float f19 = i18 + 1;
        canvas.drawText(this.mText, f19, f17, paint);
        float f26 = i16;
        canvas.drawText(this.mText, f19, f26, paint);
        float f27 = i16 + 1;
        canvas.drawText(this.mText, f19, f27, paint);
        canvas.drawText(this.mText, f18, f27, paint);
        canvas.drawText(this.mText, f16, f27, paint);
        canvas.drawText(this.mText, f16, f26, paint);
    }

    public long getEndTime() {
        ArrayList<LyricCharacter> arrayList = this.mCharacters;
        if (arrayList != null && arrayList.size() > 0) {
            LyricCharacter lyricCharacter = this.mCharacters.get(r0.size() - 1);
            return lyricCharacter.mStartTime + lyricCharacter.mDuration;
        }
        return 0L;
    }

    public long getStartTime() {
        ArrayList<LyricCharacter> arrayList = this.mCharacters;
        if (arrayList != null && arrayList.size() > 0) {
            return this.mCharacters.get(0).mStartTime;
        }
        return 0L;
    }

    public void paint(Canvas canvas, int i3, int i16, Paint paint, boolean z16) {
        canvas.drawText(this.mText, i3 + (z16 ? this.mHighLightOffsetX : this.mNormalOffsetX), i16, paint);
    }

    public void paintMarkCharacter(Canvas canvas, int[] iArr, int i3, int i16, int i17, Paint paint, Paint paint2, Paint paint3, Paint paint4, boolean z16, float f16) {
        int i18;
        Paint.FontMetrics fontMetrics;
        SentenceUI sentenceUI = this;
        if (iArr == null) {
            return;
        }
        if (z16) {
            i18 = sentenceUI.mHighLightOffsetX;
        } else {
            i18 = sentenceUI.mNormalOffsetX;
        }
        Paint.FontMetrics fontMetrics2 = paint2.getFontMetrics();
        int i19 = i3;
        int i26 = i16 + i18;
        int i27 = 0;
        while (i27 < sentenceUI.mCharacters.size()) {
            LyricCharacter lyricCharacter = sentenceUI.mCharacters.get(i27);
            String substring = sentenceUI.mText.substring(lyricCharacter.mStart, lyricCharacter.mEnd);
            float measureText = paint2.measureText(substring);
            float textSize = paint2.getTextSize();
            if (iArr[i19] != PractiveConst.NO_MARK_CHARACTER) {
                float f17 = i26;
                float f18 = i17;
                float f19 = fontMetrics2.top;
                float f26 = fontMetrics2.bottom;
                fontMetrics = fontMetrics2;
                canvas.drawRect(f17, ((f18 + f19) + f26) - f16, f17 + measureText, textSize + f18 + f19 + f26 + f16, paint);
                canvas.drawText(substring, f17, f18, paint2);
            } else {
                fontMetrics = fontMetrics2;
                if (z16) {
                    canvas.drawText(substring, i26, i17, paint3);
                } else {
                    canvas.drawText(substring, i26, i17, paint4);
                    i26 = (int) (i26 + measureText);
                    i27++;
                    i19++;
                    sentenceUI = this;
                    fontMetrics2 = fontMetrics;
                }
            }
            i26 = (int) (i26 + measureText);
            i27++;
            i19++;
            sentenceUI = this;
            fontMetrics2 = fontMetrics;
        }
    }

    public void paintWithContour(Canvas canvas, int i3, int i16, Paint paint, Paint paint2, boolean z16) {
        drawAttachInfo(canvas, i3, i16, paint);
        if (z16) {
            drawLyricContour(canvas, i3, i16, paint2, false);
        }
        paint(canvas, i3, i16, paint, false);
    }

    public void setLeftAttachInfo(SentenceAttachInfo sentenceAttachInfo) {
        this.mLeftAttachInfo = sentenceAttachInfo;
    }

    public String toString() {
        return String.format("SentenceUI -> mNormalOffsetX:%d, mHighLightOffsetX:%d", Integer.valueOf(this.mNormalOffsetX), Integer.valueOf(this.mHighLightOffsetX));
    }

    public void paint(Canvas canvas, int i3, int i16, Paint paint, Paint paint2, Paint paint3, int i17, float f16, float f17, int[] iArr, float[] fArr) {
        String substring;
        int i18 = this.mHighLightOffsetX;
        int i19 = i3 + i18;
        float f18 = f17 + i18;
        float f19 = i16;
        float f26 = f18 + f16;
        paint3.setShader(new LinearGradient(f18, f19, f26, f19, iArr, fArr, Shader.TileMode.CLAMP));
        if (i17 > 0) {
            LyricCharacter lyricCharacter = this.mCharacters.get(i17 - 1);
            String str = this.mText;
            canvas.drawText(str.substring(0, Math.min(lyricCharacter.mEnd, str.length())), i19, f19, paint2);
        }
        LyricCharacter lyricCharacter2 = this.mCharacters.get(i17);
        if (i17 == this.mCharacters.size() - 1) {
            String str2 = this.mText;
            substring = str2.substring(lyricCharacter2.mStart, str2.length());
        } else {
            String str3 = this.mText;
            substring = str3.substring(lyricCharacter2.mStart, Math.min(lyricCharacter2.mEnd, str3.length()));
        }
        canvas.drawText(substring, f18, f19, paint3);
        if (i17 < this.mCharacters.size() - 1) {
            LyricCharacter lyricCharacter3 = this.mCharacters.get(i17 + 1);
            String str4 = this.mText;
            canvas.drawText(str4.substring(lyricCharacter3.mStart, str4.length()), f26, f19, paint);
        }
    }
}
