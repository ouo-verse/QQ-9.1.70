package com.tencent.biz.qqcircle.richframework.video.player.playinterceptor;

import android.os.Process;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWLowDeviceRenderExp;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.thread.RFWThreadManager;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g extends RFWPlayerBaseInterceptor {

    /* renamed from: d, reason: collision with root package name */
    public static int f92027d;

    /* renamed from: e, reason: collision with root package name */
    private static float f92028e;

    /* renamed from: f, reason: collision with root package name */
    private static int f92029f;

    public static long c() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_rerank_high_cpu_count_limit_threshold", "20");
        try {
            return Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            RFWLog.e("QFSPlayerPlayHighFrameDropInterceptor", RFWLog.USR, "[getHighCpuUsageCountThreshold] error: " + e16 + ",serverConfig:" + loadAsString);
            return 20L;
        }
    }

    public static long d() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_rerank_high_cpu_threshold", "50");
        try {
            return Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            RFWLog.e("QFSPlayerPlayHighFrameDropInterceptor", RFWLog.USR, "[getHighCpuUsageThreshold] error: " + e16 + ",serverConfig:" + loadAsString);
            return 50L;
        }
    }

    public static long e() {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_rerank_high_drop_frame_rate_threshold", "10"));
        } catch (Exception e16) {
            RFWLog.e("QFSPlayerPlayHighFrameDropInterceptor", RFWLog.USR, "[getHighDropFrameRateThreshold] error: " + e16);
            return 10L;
        }
    }

    public static void f() {
        f92029f++;
    }

    public static boolean g() {
        if (f92029f <= c() && f92028e <= ((float) d())) {
            return false;
        }
        return true;
    }

    public static boolean h() {
        if (f92027d > e()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(RFWPlayer rFWPlayer) {
        int avgDropFrameRate = (int) (rFWPlayer.getRealPlayer().getReportProvider().getAvgDropFrameRate() * 100.0f);
        f92027d = avgDropFrameRate;
        RFWLowDeviceRenderExp.setDropFrame(avgDropFrameRate);
        float g16 = CpuUtil.f258160a.g(Process.myPid());
        RFWLog.d(getTag(), RFWLog.USR, "sDropFrame :" + f92027d + ",cpuUsage:" + g16);
        f92028e = g16 * 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        float g16 = CpuUtil.f258160a.g(Process.myPid());
        RFWLog.d(getTag(), RFWLog.USR, "sDropFrame :" + f92027d + ",cpuUsage:" + g16);
        f92028e = g16 * 100.0f;
    }

    public static void k() {
        RFWLog.d("QFSPlayerPlayHighFrameDropInterceptor", RFWLog.USR, "resetHighCpuUsage");
        f92029f = 0;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onRelease(int i3) {
        super.onRelease(i3);
        try {
            final RFWPlayer rFWPlayer = this.mPlayer;
            if (rFWPlayer != null && rFWPlayer.getRealPlayer() != null && rFWPlayer.getRealPlayer().getReportProvider() != null) {
                if (RFWThreadManager.getUIHandler().getLooper().isCurrentThread() && rFWPlayer.isSystemPlayer() && o.T0()) {
                    RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.this.i(rFWPlayer);
                        }
                    });
                } else {
                    int avgDropFrameRate = (int) (rFWPlayer.getRealPlayer().getReportProvider().getAvgDropFrameRate() * 100.0f);
                    f92027d = avgDropFrameRate;
                    RFWLowDeviceRenderExp.setDropFrame(avgDropFrameRate);
                    RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.this.j();
                        }
                    });
                }
            }
        } catch (Exception e16) {
            RFWLog.e(getTag(), RFWLog.USR, e16);
        }
    }
}
