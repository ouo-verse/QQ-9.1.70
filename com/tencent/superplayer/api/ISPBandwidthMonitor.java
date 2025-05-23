package com.tencent.superplayer.api;

import android.content.Context;
import java.util.Map;

/* loaded from: classes26.dex */
public interface ISPBandwidthMonitor {
    public static final long DEFAULE_INTERVAL = 60000;
    public static final long ONE_MINUTE = 60000;
    public static final long ONE_SECOND = 1000;

    /* loaded from: classes26.dex */
    public interface Callback {
        void onBandwidthUpdate(Map<String, Stat> map);
    }

    /* loaded from: classes26.dex */
    public static class Stat {
        public long httpBandwidth;
        public long p2pBandwidth;
        public long p2pUploadBandwidth;
        public long pcdnBandwidth;

        public static Stat diff(Stat stat, Stat stat2) {
            Stat stat3 = new Stat();
            stat3.httpBandwidth = stat2.httpBandwidth - stat.httpBandwidth;
            stat3.pcdnBandwidth = stat2.pcdnBandwidth - stat.pcdnBandwidth;
            stat3.p2pBandwidth = stat2.p2pBandwidth - stat.p2pBandwidth;
            stat3.p2pUploadBandwidth = stat2.p2pUploadBandwidth - stat.p2pUploadBandwidth;
            return stat3;
        }
    }

    void start(Context context, Callback callback, long j3);

    void stop(Context context);
}
