package com.tencent.tav.decoder.factory;

import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.IAVResample;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.resample.TAVResample;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AVResampleFactory {
    private static final String TAG = "AVResampleFactory";
    private static AVResampleFactory instance;
    private boolean tavResampleEnable;

    public AVResampleFactory() {
        this.tavResampleEnable = false;
        try {
            int i3 = TAVResample.f374473a;
            this.tavResampleEnable = true;
        } catch (ClassNotFoundException e16) {
            Logger.w(TAG, "newAVResample: " + e16);
        }
    }

    public static synchronized AVResampleFactory getInstance() {
        AVResampleFactory aVResampleFactory;
        synchronized (AVResampleFactory.class) {
            if (instance == null) {
                instance = new AVResampleFactory();
            }
            aVResampleFactory = instance;
        }
        return aVResampleFactory;
    }

    public static synchronized void setInstance(AVResampleFactory aVResampleFactory) {
        synchronized (AVResampleFactory.class) {
            instance = aVResampleFactory;
        }
    }

    @Nullable
    public IAVResample newAVResample(int i3, int i16, int i17, int i18) {
        if (this.tavResampleEnable) {
            return new TAVResample(i3, i16, i17, i18);
        }
        return null;
    }
}
