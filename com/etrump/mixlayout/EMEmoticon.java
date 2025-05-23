package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EMEmoticon {
    private static final int FLAG_LOAD_EMOTICON_CONCISE = 1;
    private static final int FLAG_LOAD_EMOTICON_DEFAULT = 0;
    private static final String TAG = "HiBoomFont.EMEmoticon";
    private int mFrameDelay;
    public String mText;
    private long mNativeDescriptorHandle = 0;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mFrameNum = 0;
    private int mFrameIndex = -1;
    private ETEngine mEngine = null;
    public ETFont mFont = null;

    public static void callbackDrawText(int i3, Canvas canvas, Matrix matrix, float f16, float f17, float f18, float f19, float f26, boolean z16, int i16, boolean z17, int i17, float f27, float f28, float f29, boolean z18, int i18, float f36) {
        int i19;
        float f37;
        float f38;
        if (canvas == null) {
            return;
        }
        String valueOf = String.valueOf(Character.toChars(i3));
        Paint paint = new Paint();
        paint.reset();
        paint.setColor(i16);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setTextSize(f19);
        int i26 = (int) (255.0f * f26);
        paint.setAlpha(i26);
        if (!z16) {
            paint.setStyle(Paint.Style.STROKE);
        }
        canvas.save();
        canvas.setMatrix(matrix);
        if (z17 && z16) {
            float f39 = 0.0f == f29 ? 0.1f : f29;
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            fArr[2] = 0.0f;
            fArr[5] = 0.0f;
            Matrix matrix2 = new Matrix();
            matrix2.setValues(fArr);
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                float[] fArr2 = new float[2];
                matrix3.mapPoints(fArr2, new float[]{f27, f28});
                f37 = fArr2[0];
                f38 = fArr2[1];
                i19 = i17;
            } else {
                i19 = i17;
                f37 = f27;
                f38 = f28;
            }
            paint.setShadowLayer(f39, f37, f38, i19);
        }
        if (z18) {
            Paint paint2 = new Paint(1);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(i18);
            paint2.setStrokeWidth(f36);
            paint2.setTextSize(f19);
            paint2.setAlpha(i26);
            canvas.drawText(valueOf, 0.0f, f18 + Math.abs(paint2.getFontMetricsInt().ascent), paint2);
        }
        canvas.drawText(valueOf, f17, f18 + Math.abs(paint.getFontMetricsInt().ascent), paint);
        canvas.restore();
    }

    private static ETSegment createEmojiSegment(char c16, char c17) {
        ETSegment eTSegment = new ETSegment();
        eTSegment.type = 1;
        eTSegment.textLength = 0;
        eTSegment.textOffset = 0;
        eTSegment.codePoint = ((c16 << '\n') + c17) - 56613888;
        return eTSegment;
    }

    public static EMEmoticon createEmoticon(ETEngine eTEngine, String str, int i3, ETFont eTFont) {
        if (eTEngine == null || TextUtils.isEmpty(str)) {
            return null;
        }
        long native_emoticonCreateDescriptor = eTEngine.native_emoticonCreateDescriptor(str, createSegments(str, eTFont), i3, eTFont, 0);
        if (0 == native_emoticonCreateDescriptor) {
            return null;
        }
        EMEmoticon eMEmoticon = new EMEmoticon();
        eMEmoticon.mEngine = eTEngine;
        eMEmoticon.mNativeDescriptorHandle = native_emoticonCreateDescriptor;
        eMEmoticon.mFrameNum = eTEngine.native_emoticonGetFrameNum(native_emoticonCreateDescriptor);
        eMEmoticon.mWidth = eMEmoticon.mEngine.native_emoticonGetWidth(native_emoticonCreateDescriptor);
        eMEmoticon.mHeight = eMEmoticon.mEngine.native_emoticonGetHeight(native_emoticonCreateDescriptor);
        eMEmoticon.mText = str;
        eMEmoticon.mFont = eTFont;
        int native_emoticonGetFrameDelay = eTEngine.native_emoticonGetFrameDelay(native_emoticonCreateDescriptor, 0);
        eMEmoticon.mFrameDelay = native_emoticonGetFrameDelay;
        if (native_emoticonGetFrameDelay < 50) {
            eMEmoticon.mFrameDelay = 50;
        }
        return eMEmoticon;
    }

    private static ETSegment[] createSegments(String str, ETFont eTFont) {
        int i3;
        if (str != null && str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            int i16 = 0;
            int i17 = -1;
            int i18 = 0;
            while (i16 < length) {
                char charAt = str.charAt(i16);
                if (Character.isHighSurrogate(charAt) && (i3 = i16 + 1) < length) {
                    char charAt2 = str.charAt(i3);
                    if (Character.isLowSurrogate(charAt2)) {
                        int i19 = i16 - (i17 + 1);
                        if (i19 > 0) {
                            ETSegment createTextSegment = createTextSegment(i19, i18);
                            createTextSegment.textSize = eTFont.getSize();
                            i18 += i19;
                            arrayList.add(createTextSegment);
                        }
                        ETSegment createEmojiSegment = createEmojiSegment(charAt, charAt2);
                        createEmojiSegment.textSize = eTFont.getSize();
                        arrayList.add(createEmojiSegment);
                        i16 = i3;
                        i17 = i16;
                        i16++;
                    }
                }
                if (i16 + 1 == length) {
                    int i26 = length - (i17 + 1);
                    ETSegment createTextSegment2 = createTextSegment(i26, i18);
                    createTextSegment2.textSize = eTFont.getSize();
                    i18 += i26;
                    arrayList.add(createTextSegment2);
                    i17 = length;
                }
                i16++;
            }
            return (ETSegment[]) arrayList.toArray(new ETSegment[arrayList.size()]);
        }
        return null;
    }

    private static ETSegment createTextSegment(int i3, int i16) {
        ETSegment eTSegment = new ETSegment();
        eTSegment.type = 0;
        eTSegment.textLength = i3;
        eTSegment.textOffset = i16;
        eTSegment.codePoint = -1;
        return eTSegment;
    }

    public int currentFrameIndex() {
        int i3 = this.mFrameIndex;
        if (i3 < 0 || i3 >= this.mFrameNum) {
            return this.mFrameNum - 1;
        }
        return i3;
    }

    public void deleteDescriptor() {
        long j3 = this.mNativeDescriptorHandle;
        if (j3 != 0) {
            this.mEngine.native_emoticonDeleteDescriptor(j3);
            this.mNativeDescriptorHandle = 0L;
        }
    }

    public void drawFrame(Bitmap bitmap) {
        int currentFrameIndex = currentFrameIndex();
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null && currentFrameIndex >= 0 && currentFrameIndex < this.mFrameNum) {
            eTEngine.native_emoticonDrawFrame(this.mNativeDescriptorHandle, currentFrameIndex, this.mFont, bitmap);
        }
    }

    public int getFrameDelay() {
        return this.mFrameDelay;
    }

    public int getFrameNum() {
        return this.mFrameNum;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getHeightByIndex(int i3, ETFont eTFont) {
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null) {
            return eTEngine.native_emoticonGetHeightByIndex(i3, eTFont);
        }
        return 0;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getWidthByIndex(int i3, ETFont eTFont) {
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null) {
            return eTEngine.native_emoticonGetWidthByIndex(i3, eTFont);
        }
        return 0;
    }

    public void gotoFirstFrame() {
        this.mFrameIndex = 0;
    }

    public void gotoFrame(int i3) {
        if (i3 >= 0 && i3 < this.mFrameNum) {
            this.mFrameIndex = i3;
        }
    }

    public boolean nextFrame() {
        int i3 = this.mFrameIndex + 1;
        this.mFrameIndex = i3;
        if (i3 < this.mFrameNum) {
            return true;
        }
        this.mFrameIndex = -1;
        return false;
    }
}
