package com.tencent.superplayer.bandwidth;

import com.tencent.superplayer.api.ISPBandwidthMonitor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.report.SPBeaconReporter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements ISPBandwidthMonitor.Callback {

    /* renamed from: b, reason: collision with root package name */
    private static String f373901b = "actSPBandwidthReport";

    /* renamed from: c, reason: collision with root package name */
    public static long f373902c = 60000;

    /* renamed from: d, reason: collision with root package name */
    public static int[] f373903d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<Integer, ISPBandwidthMonitor> f373904e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private int f373905a;

    public a(int i3) {
        this.f373905a = i3;
    }

    public static boolean a(int i3) {
        int[] iArr = f373903d;
        if (iArr == null) {
            return false;
        }
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static synchronized void b(int i3) {
        synchronized (a.class) {
            if (a(i3)) {
                Map<Integer, ISPBandwidthMonitor> map = f373904e;
                if (!map.containsKey(Integer.valueOf(i3))) {
                    ISPBandwidthMonitor createBandwidthMonitor = SuperPlayerFactory.createBandwidthMonitor(i3);
                    map.put(Integer.valueOf(i3), createBandwidthMonitor);
                    createBandwidthMonitor.start(SuperPlayerSDKMgr.getContext(), new a(i3), f373902c);
                }
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthMonitor.Callback
    public void onBandwidthUpdate(Map<String, ISPBandwidthMonitor.Stat> map) {
        for (Map.Entry<String, ISPBandwidthMonitor.Stat> entry : map.entrySet()) {
            String key = entry.getKey();
            ISPBandwidthMonitor.Stat value = entry.getValue();
            long j3 = value.httpBandwidth;
            long j16 = value.pcdnBandwidth;
            long j17 = value.p2pBandwidth;
            long j18 = value.p2pUploadBandwidth;
            if (j3 > 0 || j16 > 0 || j17 > 0 || j18 > 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("param_sceneId", String.valueOf(this.f373905a));
                hashMap.put("param_host", key);
                hashMap.put("param_httpBw", String.valueOf(j3));
                hashMap.put("param_pcdnBw", String.valueOf(j16));
                hashMap.put("param_p2pBw", String.valueOf(j17));
                hashMap.put("param_p2pUploadBw", String.valueOf(j18));
                SPBeaconReporter.report(f373901b, hashMap);
            }
        }
    }
}
