package com.tencent.av.video.effect.beauty;

import android.content.Context;
import com.tencent.av.video.effect.core.BeautyNative;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.utils.ColorFormat;
import com.tencent.av.video.effect.utils.Log;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Beauty20Render {
    private static final String TAG = "Beauty20Render";
    private WeakReference<Context> mContextReference;
    private float mCurrentBeautyLevel = 0.0f;

    public Beauty20Render(Context context) {
        this.mContextReference = new WeakReference<>(context);
    }

    public EffectFrame processData(EffectFrame effectFrame) {
        if (effectFrame == null) {
            Log.d(TAG, "processData inFrame = null");
            return effectFrame;
        }
        byte[] bArr = effectFrame.frameData;
        if (bArr != null && bArr.length != 0) {
            float f16 = this.mCurrentBeautyLevel;
            if (f16 == 0.0f) {
                Log.d(TAG, "processData mCurrentBeautyLevel = 0");
                return effectFrame;
            }
            int i3 = ((int) ((f16 * 100.0f) + 9.0f)) / 10;
            Log.d(TAG, "processData mCurrentBeautyLevel = " + this.mCurrentBeautyLevel + " | nativeBeautyLevel = " + i3 + " | dataLength = " + effectFrame.frameData.length + " | width=" + effectFrame.frameWidth + " | height = " + effectFrame.frameHeight + " | format =" + effectFrame.frameFormat);
            try {
                EffectFrame effectFrame2 = new EffectFrame();
                effectFrame2.frameData = BeautyNative.beautyProcess20(effectFrame.frameData, effectFrame.frameFormat.ordinal(), effectFrame.frameWidth, effectFrame.frameHeight, i3);
                effectFrame2.frameWidth = effectFrame.frameWidth;
                effectFrame2.frameHeight = effectFrame.frameHeight;
                effectFrame2.frameFormat = ColorFormat.I420;
                return effectFrame2;
            } catch (Throwable th5) {
                Log.d(TAG, "processData e = " + th5.getMessage());
                return effectFrame;
            }
        }
        Log.d(TAG, "processData frameData = null");
        return effectFrame;
    }

    public void setBeautyLevel(float f16) {
        Log.d(TAG, "setBeautyLevel beautyLevel = " + f16);
        if (f16 > 1.0f) {
            this.mCurrentBeautyLevel = 1.0f;
        } else if (f16 < 0.0f) {
            this.mCurrentBeautyLevel = 0.0f;
        } else {
            this.mCurrentBeautyLevel = f16;
        }
    }

    public void destroy() {
    }
}
