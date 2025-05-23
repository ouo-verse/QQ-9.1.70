package com.tencent.qqlive.tvkplayer.vinfo.api;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKServerTimeGetter {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ITVKServerTimeCompleteListener {
        void onComplete(String str);
    }

    long calculateCurrentServerTimeSec();

    void execute();

    long getElapsedRealTimeMs();

    long getServerTimeSec();

    void setServerTimeCompleteListener(ITVKServerTimeCompleteListener iTVKServerTimeCompleteListener);
}
