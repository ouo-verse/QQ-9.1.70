package com.tencent.superplayer.player;

import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.report.SPBeaconReporter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f373921a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f373922b = 10;

    public static void a() {
        boolean z16;
        HashMap hashMap = new HashMap(SuperPlayerSDKMgr.getPlayerPool().getAllPlayer());
        if (hashMap.size() >= f373922b) {
            synchronized (b.class) {
                if (f373921a == null) {
                    f373921a = SuperPlayerSDKMgr.getUid() + "_" + System.currentTimeMillis();
                }
                if (hashMap.size() > f373922b) {
                    f373922b = ((hashMap.size() / 10) * 10) + 10;
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                com.tencent.superplayer.report.a aVar = new com.tencent.superplayer.report.a(hashMap, f373921a);
                SPBeaconReporter.report(aVar.b(), aVar.a());
            }
        }
    }
}
