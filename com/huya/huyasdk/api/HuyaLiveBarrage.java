package com.huya.huyasdk.api;

import hynb.a.a;
import hynb.p.g;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuyaLiveBarrage {
    public static final String TAG = "HuyaLiveBarrage";

    public static void sendBarrage(HuyaLiveBarrageSendInfo huyaLiveBarrageSendInfo, SendLiveBarrageCallback sendLiveBarrageCallback) {
        g.f406799a.info(TAG, "sendBarrage info: " + huyaLiveBarrageSendInfo + ", callback: " + sendLiveBarrageCallback);
        a.f406608d.a(huyaLiveBarrageSendInfo, sendLiveBarrageCallback);
    }

    public static void setLiveBarrageCallback(LiveBarrageCallback liveBarrageCallback) {
        g.f406799a.info(TAG, "setLiveBarrageCallback callback: " + liveBarrageCallback);
        a.f406608d.a(liveBarrageCallback);
    }
}
