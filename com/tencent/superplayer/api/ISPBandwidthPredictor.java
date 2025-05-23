package com.tencent.superplayer.api;

import android.content.Context;

/* loaded from: classes26.dex */
public interface ISPBandwidthPredictor {
    long getCurrentPrediction();

    long getLastBandwidth();

    void start(Context context);

    void stop(Context context);
}
