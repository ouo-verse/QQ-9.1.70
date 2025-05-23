package com.huya.huyasdk.api;

import android.util.Pair;
import hynb.i.a;
import hynb.p.g;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuyaStatisticLive {
    public static final String PLAY_END_LIVE = "play_end/live";
    public static final String PLAY_START_LIVE = "play_start/live";
    public static final String TAG = "HuyaStatisticLive";
    public static final Map<Long, Pair<Long, Integer>> pidPairMap = new ConcurrentHashMap();

    public static void reportLivePreviewBegin(long j3, int i3) {
        pidPairMap.put(Long.valueOf(j3), new Pair<>(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i3)));
        HashMap hashMap = new HashMap();
        hashMap.put("anchor_uid", String.valueOf(j3));
        hashMap.put("game_id", String.valueOf(i3));
        g.f406799a.a(TAG, "reportLivePreviewBegin: " + hashMap);
        a.a().a(PLAY_START_LIVE, hashMap);
    }

    public static void reportLivePreviewEnd(long j3) {
        Pair<Long, Integer> remove = pidPairMap.remove(Long.valueOf(j3));
        if (remove == null) {
            g.f406799a.a("reportLivePreviewEnd pair is null");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - ((Long) remove.first).longValue();
        HashMap hashMap = new HashMap();
        hashMap.put("anchor_uid", String.valueOf(j3));
        hashMap.put("game_id", String.valueOf(remove.second));
        hashMap.put("duration", String.valueOf(currentTimeMillis));
        g.f406799a.a(TAG, "reportLivePreviewEnd: " + hashMap);
        a.a().a(PLAY_END_LIVE, hashMap);
    }
}
