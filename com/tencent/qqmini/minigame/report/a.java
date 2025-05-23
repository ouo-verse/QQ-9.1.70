package com.tencent.qqmini.minigame.report;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.tencent.qqmini.minigame.ui.GameUIProxy;
import com.tencent.qqmini.minigame.utils.CpuUtil;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a implements Handler.Callback {
    private int D;

    /* renamed from: e, reason: collision with root package name */
    private int f346663e;

    /* renamed from: m, reason: collision with root package name */
    private GameUIProxy f346667m;

    /* renamed from: f, reason: collision with root package name */
    private final double[] f346664f = new double[30];

    /* renamed from: h, reason: collision with root package name */
    private final double[] f346665h = new double[30];

    /* renamed from: i, reason: collision with root package name */
    private final double[] f346666i = new double[30];
    private final AtomicBoolean C = new AtomicBoolean(false);
    private long E = 0;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f346662d = new Handler(ThreadManager.getSubThreadHandler().getLooper(), this);

    a() {
    }

    private String a(double[] dArr, int i3, int i16) {
        String str;
        if (dArr != null && dArr.length != 0 && i3 >= 0 && i16 >= 0 && i3 < i16 && i3 < dArr.length && i16 <= dArr.length) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append('[');
            while (i3 < i16) {
                sb5.append(String.format("%.2f", Double.valueOf(dArr[i3])));
                if (i3 == i16 - 1) {
                    str = "]";
                } else {
                    str = ", ";
                }
                sb5.append(str);
                i3++;
            }
            return sb5.toString();
        }
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public static boolean b(int i3) {
        if (i3 < 0 || i3 > 100) {
            return false;
        }
        if (i3 != 100 && Math.random() * 100.0d > i3) {
            return false;
        }
        return true;
    }

    @Nullable
    public static a c() {
        if (b(((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getRunTimeReportRate())) {
            return new a();
        }
        return null;
    }

    private String d(double[] dArr, int i3, int i16) {
        if (dArr != null && dArr.length != 0 && i3 >= 0 && i16 >= 0 && i3 < i16 && i3 < dArr.length && i16 <= dArr.length) {
            double d16 = 0.0d;
            for (int i17 = i3; i17 < i16; i17++) {
                d16 += dArr[i17];
            }
            return String.format("%.2f", Double.valueOf(d16 / (i16 - i3)));
        }
        return "0";
    }

    private String e(double[] dArr, int i3, int i16) {
        int i17;
        double doubleValue;
        if (dArr != null && dArr.length != 0 && i3 >= 0 && i16 >= 0 && i3 < i16 && i3 < dArr.length && i16 <= dArr.length) {
            int i18 = i16 - i3;
            if (i18 == 1) {
                return String.format("%.2f", Double.valueOf(dArr[i3]));
            }
            int i19 = (i18 / 2) + 1;
            PriorityQueue priorityQueue = new PriorityQueue(i19);
            int i26 = i3;
            while (true) {
                i17 = i3 + i19;
                if (i26 >= i17) {
                    break;
                }
                priorityQueue.add(Double.valueOf(dArr[i26]));
                i26++;
            }
            while (i17 < i16) {
                if (((Double) priorityQueue.peek()).doubleValue() < dArr[i17]) {
                    priorityQueue.poll();
                    priorityQueue.add(Double.valueOf(dArr[i17]));
                }
                i17++;
            }
            if (i18 % 2 == 1) {
                doubleValue = ((Double) priorityQueue.peek()).doubleValue();
            } else {
                doubleValue = (((Double) priorityQueue.poll()).doubleValue() + ((Double) priorityQueue.peek()).doubleValue()) / 2.0d;
            }
            return String.format("%.2f", Double.valueOf(doubleValue));
        }
        return "0";
    }

    private void i() {
        int i3 = this.f346663e + 1;
        this.f346663e = i3;
        int i16 = i3 * 10000;
        if (i16 % 10000 == 0) {
            this.f346664f[(i16 / 10000) - 1] = TaskMonitorManager.g().getCurrentFps();
        }
        int i17 = i16 % 60000;
        if (i17 == 0) {
            double h16 = CpuUtil.f346831k.h(Process.myPid()) * 100.0f;
            if (h16 > 100.0d || h16 < 0.0d) {
                h16 = 0.0d;
            }
            this.f346665h[(i16 / 60000) - 1] = h16;
        }
        if (i17 == 0) {
            this.f346666i[(i16 / 60000) - 1] = TaskMonitorManager.getTotalPss(AppLoaderFactory.g().getContext()) / 1024.0d;
        }
        if (this.f346663e >= 30) {
            k();
        }
        if (this.C.get()) {
            this.f346662d.sendEmptyMessageDelayed(1, 10000L);
        }
    }

    private void k() {
        if (this.f346663e <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        int i3 = this.f346663e * 10000;
        this.E += i3;
        int i16 = i3 / 10000;
        hashMap.put("fps", a(this.f346664f, 0, i16));
        hashMap.put("averageFps", d(this.f346664f, 0, i16));
        hashMap.put("medianFps", e(this.f346664f, 0, i16));
        ou3.a jankStatistics = MiniGamePerformanceStatics.getInstance().getJankStatistics();
        hashMap.put("jankCount", String.valueOf(jankStatistics.getJankCount()));
        hashMap.put("bigJankCount", String.valueOf(jankStatistics.getBigJankCount()));
        hashMap.put("jankTimeSec", String.valueOf(jankStatistics.d()));
        hashMap.put("runDuration", String.valueOf(this.E));
        int i17 = i3 / 60000;
        hashMap.put("cpu", a(this.f346665h, 0, i17));
        hashMap.put("averageCpu", d(this.f346665h, 0, i17));
        hashMap.put("medianCpu", e(this.f346665h, 0, i17));
        hashMap.put("memory", a(this.f346666i, 0, i17));
        hashMap.put("averageMemory", d(this.f346666i, 0, i17));
        hashMap.put("medianMemory", e(this.f346666i, 0, i17));
        hashMap.put("memoryWhenLaunch", String.format("%.2f", Float.valueOf(this.D / 1024.0f)));
        GameUIProxy gameUIProxy = this.f346667m;
        if (gameUIProxy != null) {
            MiniGameMonitorReport.o(gameUIProxy, "minigame_performance_andriod", hashMap, false);
        }
        this.f346663e = 0;
        Arrays.fill(this.f346664f, 0.0d);
        Arrays.fill(this.f346665h, 0.0d);
        Arrays.fill(this.f346666i, 0.0d);
    }

    public void f(GameUIProxy gameUIProxy) {
        this.C.set(true);
        this.f346667m = gameUIProxy;
        this.f346662d.removeMessages(1);
        this.f346662d.sendEmptyMessageDelayed(1, 10000L);
    }

    public void g() {
        this.D = TaskMonitorManager.getTotalPss(AppLoaderFactory.g().getContext());
    }

    public void h() {
        this.C.set(false);
        this.f346662d.removeMessages(1);
        k();
        CpuUtil.f346831k.l();
        this.f346667m = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (1 == message.what) {
            i();
            return true;
        }
        return false;
    }

    public void j() {
        this.f346662d.removeCallbacksAndMessages(null);
        this.f346667m = null;
    }
}
