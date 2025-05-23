package com.tencent.gamecenter.wadl.sdk;

import android.os.SystemClock;
import com.tencent.gamecenter.wadl.sdk.common.d.h;
import com.tencent.gamecenter.wadl.sdk.common.d.i;
import com.tencent.gamecenter.wadl.sdk.common.e.b;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import com.tencent.gamecenter.wadl.sdk.downloader.Downloader;

/* compiled from: P */
/* loaded from: classes6.dex */
public class Agent {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f106966a = false;

    Agent() {
    }

    public static void enableLog(boolean z16) {
        b.a(z16);
    }

    public static Downloader getDownloader(InitParam initParam) {
        if (!f106966a) {
            init(initParam);
        }
        com.tencent.gamecenter.wadl.sdk.downloader.manager.a a16 = com.tencent.gamecenter.wadl.sdk.downloader.manager.a.a();
        a16.setMultiTheadDownOpen(true);
        return a16;
    }

    public static synchronized void init(InitParam initParam) {
        synchronized (Agent.class) {
            b.e("Wadl-cloud-Agent", "init INIT_FINISH:" + f106966a + ",type:http,param:" + initParam);
            if (f106966a) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (initParam != null) {
                String a16 = i.a(initParam.getContext());
                if (initParam.appid > 0) {
                    com.tencent.gamecenter.wadl.sdk.common.a.a(initParam, a16);
                    com.tencent.gamecenter.wadl.sdk.common.b.b.d();
                    b.e("Wadl-cloud-Agent", "init try startPlatform on process:" + a16);
                    h.e().a();
                    f106966a = true;
                    b.e("Wadl-cloud-Agent", "init finished on process:" + a16 + ",initFinish:" + f106966a + ",initTime:" + currentTimeMillis + ",costTime:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                    return;
                }
                throw new RuntimeException("appid illegal:" + initParam.appid + ",isTestMode=" + initParam.isTestMode);
            }
            throw new RuntimeException("initParam null");
        }
    }

    public static boolean isInit() {
        return f106966a;
    }

    public static boolean isTestMode() {
        return com.tencent.gamecenter.wadl.sdk.common.a.i();
    }

    public static void setCanGetWifiMac(boolean z16) {
        g.f107241b = z16;
    }

    public static void setCustomVersionCode(int i3) {
        com.tencent.gamecenter.wadl.sdk.common.a.f106983f = i3;
    }
}
