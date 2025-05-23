package ey3;

import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.bd;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqperf.tools.f;
import com.tencent.util.AppSetting;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.util.AbstractUnifiedMonitor;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends AbstractUnifiedMonitor implements Handler.Callback {
    private static a D = null;
    public static AtomicBoolean E = null;
    private static int F = -1;
    public static String[] G = {"FAMILY_LOOPER", "FAMILY_OBSERVER", "FAMILY_IMAGE_DRAWABLE", "FAMILY_IMAGE_VIEW", "FAMILY_SUB_TASK", "FAMILY_FILE_TASK", "FAMILY_BG_TASK", "FAMILY_MSF_MSG", "FAMILY_MSF_MSG_HIGH_PRIORITY", "FAMILY_ACT_TIME", "FAMILY_SCENE_SMOOTH", "FAMILY_DROP_FRAME", "FAMILY_CPU_STATS", "FAMILY_NEW_FPS", "FAMILY_RECENT", "FAMILY_QZONE_LOOPER", "FAMILY_MSF_SENDER", "FAMILY_MSF_RECVER", "FAMILY_MSF_LIGHT_SENDER", "FAMILY_MSF_NETWORK", "FAMILY_TOOL_LOOPER", "FAMILY_SCENE_PERF", "FAMILY_LAST"};

    /* renamed from: d, reason: collision with root package name */
    private bc f397405d = null;

    /* renamed from: e, reason: collision with root package name */
    private bd f397406e = null;

    /* renamed from: f, reason: collision with root package name */
    private bc f397407f = null;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f397408h = false;

    /* renamed from: i, reason: collision with root package name */
    private C10273a[] f397409i = {new C10273a(8.0E-4f, 100, 10, 0.1f, 6, 0, 0, 0, false), new C10273a(), new C10273a(), new C10273a(), new C10273a(0.001f, 180000, 2, 1.0f, 6, 0, 0, 0, true), new C10273a(0.001f, 180000, 2, 1.0f, 6, 0, 0, 0, true), new C10273a(0.001f, 1000, 10, 0.001f, 0, 0, 0, 0, false), new C10273a(0.001f, 180000, 2, 1.0f, 6, 6, 0, 0, true), new C10273a(0.001f, 0, 10, 0.1f, 0, 0, 0, 0, false), new C10273a(0.001f, 100, 5, 0.01f, 0, 0, 0, 0, false), new C10273a(0.001f, 100, 10, 0.1f, 6, 0, 0, 0, false), new b(-0.0f, 100100005, 1, 0.01f, 0, 0, 2, 300), new C10273a(0.01f, 100, 5, 0.01f, 0, 0, 0, 0, false), new C10273a(0.001f, 180000, 10, 1.0f, 6, 0, 0, 0, true), new C10273a(0.001f, 100, 5, 0.01f, 6, 0, 0, 0, false), new C10273a(0.001f, 600000, 2, 1.0f, 6, 0, 0, 0, true), new C10273a(0.001f, 180000, 2, 1.0f, 6, 0, 0, 0, true), new C10273a(0.001f, 180000, 2, 1.0f, 6, 0, 0, 0, true), new C10273a(0.001f, 180000, 2, 1.0f, 6, 0, 0, 0, true), new C10273a(0.001f, 100, 5, 0.01f, 6, 0, 0, 0, false), new C10273a(0.01f, 100, 10, 0.01f, 0, 0, 0, 0, false), new C10273a(0.001f, 180000, 2, 1.0f, 6, 6, 0, 0, true)};

    /* renamed from: m, reason: collision with root package name */
    private Handler f397410m = null;
    private String C = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b extends C10273a {

        /* renamed from: s, reason: collision with root package name */
        boolean f397429s;

        /* renamed from: t, reason: collision with root package name */
        int f397430t;

        /* renamed from: u, reason: collision with root package name */
        int f397431u;

        /* renamed from: v, reason: collision with root package name */
        int f397432v;

        /* renamed from: w, reason: collision with root package name */
        long f397433w;

        b(float f16, int i3, int i16, float f17, int i17, int i18, int i19, int i26) {
            super(f16, i3, i16, f17, i17, i18, i19, i26, false);
            this.f397429s = false;
            this.f397430t = 80;
            this.f397431u = 70;
            this.f397432v = 5;
            this.f397433w = 0L;
            this.f397432v = i3 % 1000;
            int i27 = i3 / 1000;
            this.f397431u = i27 % 1000;
            this.f397430t = (i27 / 1000) % 1000;
        }

        void b(int[] iArr) {
            boolean z16 = false;
            this.f397430t = iArr[0];
            this.f397431u = iArr[1];
            this.f397432v = iArr[2];
            if (iArr[3] == 1) {
                z16 = true;
            }
            this.f397429s = z16;
        }
    }

    private void a() {
        if (1 != MobileQQ.sProcessId) {
            return;
        }
        MainService.setUnifiedMonitorInstance(f());
        l();
    }

    public static boolean b() {
        if (E == null) {
            E = new AtomicBoolean(new File("/proc/stat").canRead());
        }
        return E.get();
    }

    public static boolean c() {
        return new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/looper")).exists();
    }

    public static HashMap<String, String> e() {
        String topActivityName = ((IPerfApi) QRoute.api(IPerfApi.class)).getTopActivityName();
        if (topActivityName != null) {
            HashMap<String, String> hashMap = new HashMap<>(8);
            hashMap.put(EventKey.ACT, topActivityName);
            return hashMap;
        }
        return null;
    }

    public static a f() {
        a aVar;
        a aVar2 = D;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            if (D == null) {
                D = new a();
            }
            aVar = D;
        }
        return aVar;
    }

    public static String g(int i3) {
        String[] strArr = G;
        if (strArr.length > i3) {
            return strArr[i3];
        }
        return "unknown";
    }

    public static boolean h() {
        if (!AppSetting.isDebugVersion() && ((AppSetting.isGrayVersion() || !QLog.isColorLevel()) && !Utils.K())) {
            return false;
        }
        return true;
    }

    private void i() {
        C10273a[] c10273aArr;
        int i3;
        try {
            String featureValue = AppSetting.isDebugVersion() ? null : ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.unified_monitor_params.name());
            QLog.d("UnifiedMonitor", 1, "dpc string " + featureValue);
            if (featureValue != null) {
                String[] split = featureValue.split("\\|");
                if (split == null) {
                    synchronized (this) {
                        this.f397408h = true;
                    }
                    return;
                }
                for (String str : split) {
                    try {
                        String[] split2 = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split2 != null && split2.length == 2 && !TextUtils.isEmpty(split2[0]) && !TextUtils.isEmpty(split2[1])) {
                            int lastIndexOf = split2[0].lastIndexOf(95);
                            String substring = lastIndexOf != -1 ? split2[0].substring(0, lastIndexOf + 1) : null;
                            String substring2 = (lastIndexOf == -1 || lastIndexOf >= split2[0].length() - 1) ? null : split2[0].substring(lastIndexOf + 1);
                            try {
                                i3 = Integer.valueOf(substring2).intValue();
                            } catch (NumberFormatException unused) {
                                i3 = -1;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("UnifiedMonitor", 2, "reading config item from dpc string, family_no=" + i3 + ", config-prefix=" + substring + ", key=" + split2[0] + ",value=" + split2[1]);
                            }
                            if (i3 >= 1000 && i3 - 1000 < -1) {
                                i3 = -1;
                            }
                            if (substring != null && lastIndexOf != -1 && i3 != -1 && substring2 != null && i3 < 22) {
                                if ("user_ratio_".equals(substring)) {
                                    this.f397409i[i3].f397413c = Float.valueOf(split2[1]).floatValue();
                                } else if ("max_report_".equals(substring)) {
                                    this.f397409i[i3].f397412b = Integer.valueOf(split2[1]).intValue();
                                } else if ("num_thresh_".equals(substring)) {
                                    this.f397409i[i3].f397411a = Integer.valueOf(split2[1]).intValue();
                                } else if ("event_ratio_".equals(substring)) {
                                    this.f397409i[i3].f397414d = Float.valueOf(split2[1]).floatValue();
                                } else if ("max_stackdep_".equals(substring)) {
                                    this.f397409i[i3].f397415e = Integer.valueOf(split2[1]).intValue();
                                } else if ("max_stack_ts_".equals(substring)) {
                                    this.f397409i[i3].f397416f = Integer.valueOf(split2[1]).intValue();
                                } else if ("all_stack_".equals(substring)) {
                                    this.f397409i[i3].f397428r = Boolean.valueOf(split2[1]).booleanValue();
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.e("UnifiedMonitor", 2, "", th5);
                        }
                    }
                }
            }
            int i16 = 0;
            while (true) {
                c10273aArr = this.f397409i;
                if (i16 >= c10273aArr.length) {
                    break;
                }
                c10273aArr[i16].a(i16);
                i16++;
            }
            c10273aArr[10].f397422l = false;
            if ((!AppSetting.isPublicVersion() && !AppSetting.isDebugVersion() && c()) || QLog.isColorLevel()) {
                C10273a c10273a = this.f397409i[0];
                c10273a.f397422l = true;
                c10273a.f397412b = Integer.MAX_VALUE;
                c10273a.f397414d = 1.0f;
                if (QLog.isColorLevel()) {
                    this.f397409i[0].f397411a = 200;
                }
            }
            if (MobileQQ.sProcessId == 4 && AppSetting.isGrayVersion()) {
                C10273a c10273a2 = this.f397409i[15];
                double random = Math.random();
                C10273a[] c10273aArr2 = this.f397409i;
                c10273a2.f397422l = random <= ((double) c10273aArr2[15].f397413c) * 0.2d;
                C10273a c10273a3 = c10273aArr2[16];
                double random2 = Math.random();
                C10273a[] c10273aArr3 = this.f397409i;
                c10273a3.f397422l = random2 <= ((double) c10273aArr3[16].f397413c) * 0.2d;
                C10273a c10273a4 = c10273aArr3[17];
                double random3 = Math.random();
                C10273a[] c10273aArr4 = this.f397409i;
                c10273a4.f397422l = random3 <= ((double) c10273aArr4[17].f397413c) * 0.2d;
                c10273aArr4[18].f397422l = Math.random() <= ((double) this.f397409i[18].f397413c) * 0.2d;
            }
            if (MobileQQ.sProcessId == 1) {
                if (!AppSetting.isPublicVersion()) {
                    C10273a[] c10273aArr5 = this.f397409i;
                    c10273aArr5[9].f397422l = true;
                    C10273a c10273a5 = c10273aArr5[11];
                    c10273a5.f397422l = true;
                    c10273a5.f397417g = Integer.MAX_VALUE;
                    c10273a5.f397418h = Integer.MAX_VALUE;
                    ((b) c10273a5).b(d());
                } else {
                    this.f397409i[11].f397422l = false;
                }
            }
            if (Utils.K()) {
                int i17 = MobileQQ.sProcessId;
                if (i17 == 1 && this.f397409i[4].f397422l) {
                    HashMap<String, String> hashMap = new HashMap<>(2);
                    hashMap.put("cnt", String.valueOf(1));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "monitorVIPUser", true, 0L, 0L, hashMap, null);
                } else if (i17 == 4 && this.f397409i[15].f397422l) {
                    HashMap<String, String> hashMap2 = new HashMap<>(2);
                    hashMap2.put("cnt", String.valueOf(2));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "monitorVIPUser", true, 0L, 0L, hashMap2, null);
                }
            }
            QLog.d("UnifiedMonitor", 1, "Conf debug=" + AppSetting.isDebugVersion() + " gray=" + AppSetting.isGrayVersion() + " public=" + AppSetting.isPublicVersion() + " vip=" + Utils.K() + " clr=" + QLog.isColorLevel());
            int length = this.f397409i.length;
            for (int i18 = 0; i18 < length; i18++) {
                C10273a c10273a6 = this.f397409i[i18];
                QLog.d("UnifiedMonitor", 1, "Conf " + g(i18) + ", r=" + c10273a6.f397422l + ", es=" + c10273a6.f397414d + " us" + c10273a6.f397413c + " mx=" + c10273a6.f397412b + " thres=" + c10273a6.f397411a);
            }
            synchronized (this) {
                this.f397408h = true;
            }
        } catch (Throwable th6) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("UnifiedMonitor", 2, "", th6);
                }
                synchronized (this) {
                    this.f397408h = true;
                }
            } catch (Throwable th7) {
                synchronized (this) {
                    this.f397408h = true;
                    throw th7;
                }
            }
        }
    }

    private final void l() {
        if (whetherReportDuringThisStartup(11) && this.f397406e == null && b()) {
            bd newHandlerRecycleThread = ThreadManagerV2.newHandlerRecycleThread("cpu-stats", 0);
            this.f397406e = newHandlerRecycleThread;
            bc a16 = newHandlerRecycleThread.a(this);
            this.f397407f = a16;
            a16.sendEmptyMessage(4);
        }
    }

    @Override // mqq.util.AbstractUnifiedMonitor
    public void addEvent(int i3, String str, int i16, int i17, Map<String, String> map) {
        String valueOf;
        if (this.f397408h && whetherReportDuringThisStartup(i3)) {
            String str2 = this.f397409i[i3].f397424n;
            if (this.f397409i[i3].f397426p && TextUtils.isEmpty(str2)) {
                return;
            }
            if (map == null) {
                map = new HashMap<>(17);
            }
            map.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY, String.valueOf(i3));
            if (str == null) {
                str = "";
            }
            map.put("event", str);
            map.put("revision", AppSetting.getRevision());
            if (this.C == null) {
                this.C = "dbg";
                if (AppSetting.isGrayVersion()) {
                    this.C = "gray";
                } else if (AppSetting.isPublicVersion()) {
                    this.C = "pub";
                } else if (!AppSetting.isDebugVersion()) {
                    this.C = TVKNetVideoInfo.AUDIO_TRACK_DOLBY;
                }
            }
            map.put("build_type", this.C);
            if (SystemClock.uptimeMillis() - f.f363416b < 60000) {
                map.put("totalCpu", String.valueOf(f.f363417c));
                map.put("appCpu", String.valueOf(f.f363418d.f363431m));
                map.put("cpu_update_time", String.valueOf((SystemClock.uptimeMillis() - f.f363416b) / 1000));
            }
            if (i3 == 0) {
                if (MobileQQ.sProcessId == 1) {
                    map.put("param_is_logining", String.valueOf(((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isLogining()));
                    map.put("param_syncing_msg", String.valueOf(((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isSyncingMsg()));
                }
                map.put("max_heap_size", String.valueOf(Runtime.getRuntime().maxMemory()));
                map.put("currentHeapSize", String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
            }
            map.put("wal_enable", String.valueOf(F));
            if (QLog.isColorLevel()) {
                valueOf = "-1";
            } else {
                valueOf = String.valueOf(i17);
            }
            map.put("not_reported", valueOf);
            if (str2 != null) {
                if (str2.length() <= 950) {
                    map.put("stack", str2);
                } else {
                    map.put("stack", str2.substring(0, 950));
                    map.put("stack1", str2.substring(950));
                }
            }
            com.tencent.mobileqq.perf.report.a.a(map);
            bc bcVar = this.f397405d;
            if (bcVar != null) {
                bcVar.h(bcVar.obtainMessage(1, i16, 0, map));
                this.f397409i[i3].f397419i++;
            }
        }
    }

    public int[] d() {
        int[] iArr = new int[4];
        if (!AppSetting.isPublicVersion()) {
            String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("cpu_stats_switch" + account, 0);
            int i3 = sharedPreferences.getInt("cpu_stats_config", 0);
            int i16 = sharedPreferences.getInt("cpu_stats_aio", 0);
            if (i3 == 0 && !TextUtils.isEmpty(account)) {
                if (!account.equals("46221724") && !account.equals("328659992") && !account.equals("43087") && !account.equals("9948938") && !account.equals("425812207") && !account.equals("354653668") && !account.equals("306392284") && !account.equals("514807908") && !account.equals("32606670")) {
                    i3 = 101100005;
                    i16 = 0;
                } else {
                    i3 = 80040002;
                    i16 = 1;
                }
            }
            int i17 = i3 / 1000;
            iArr[0] = (i17 / 1000) % 1000;
            iArr[1] = i17 % 1000;
            iArr[2] = i3 % 1000;
            iArr[3] = i16;
        }
        return iArr;
    }

    @Override // mqq.util.AbstractUnifiedMonitor
    public int getThreshold(int i3) {
        return this.f397409i[i3].f397411a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0254, code lost:
    
        return true;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
            case 11:
            case 12:
                Object obj = message.obj;
                if (obj != null) {
                    try {
                        HashMap<String, String> hashMap = (HashMap) obj;
                        int i3 = message.arg1;
                        if (!AppSetting.isPublicVersion()) {
                            QLog.d("UnifiedMonitor", 1, "addEvent, num=" + i3 + ", extra=" + Arrays.toString(hashMap.entrySet().toArray()));
                        }
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "unifiedMonitor", true, i3, 0L, hashMap, null);
                        break;
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            th5.printStackTrace();
                            break;
                        }
                    }
                }
                break;
            case 2:
                addEvent(message.arg1, "", 3000, -1, e());
                this.f397409i[message.arg1].f397424n = null;
                break;
            case 3:
                i();
                a();
                break;
            case 4:
                this.f397409i[11].f397421k = SystemClock.uptimeMillis();
                this.f397407f.b(5, 2000L);
                break;
            case 5:
                f.l(false);
                if (!this.f397407f.c(7)) {
                    this.f397407f.b(6, 1500L);
                    break;
                }
                break;
            case 6:
                f.k(false);
                b bVar = (b) this.f397409i[11];
                if (whetherReportThisTime(11, true)) {
                    HashMap hashMap2 = new HashMap(10);
                    hashMap2.put("total_cpu", String.valueOf(f.f363417c));
                    hashMap2.put("app_cpu", String.valueOf(f.f363418d.f363431m));
                    f().addEvent(11, null, 0, 0, hashMap2);
                }
                if (f.f363417c >= bVar.f397430t || f.f363418d.f363431m >= bVar.f397431u) {
                    if (QLog.isColorLevel() && SystemClock.uptimeMillis() - bVar.f397433w > 60000) {
                        QLog.d("UnifiedMonitor", 2, "totalCpu exceed: " + f.f363417c + ", appCpu: " + f.f363418d.f363431m);
                        f.l(true);
                        try {
                            LockMethodProxy.sleep(2000L);
                        } catch (InterruptedException unused) {
                        }
                        f.k(true);
                        Iterator<String> it = f.e(bVar.f397432v, true).iterator();
                        while (it.hasNext()) {
                            QLog.d("UnifiedMonitor", 2, it.next());
                        }
                        QLog.d("UnifiedMonitor", 2, f.d(10));
                        Iterator<String> it5 = f.e(bVar.f397432v, true).iterator();
                        while (it5.hasNext()) {
                            QLog.d("UnifiedMonitor", 2, it5.next());
                        }
                        bVar.f397433w = SystemClock.uptimeMillis();
                    } else {
                        QLog.d("UnifiedMonitor", 1, "totalCpu exceed: " + f.f363417c + ", appCpu: " + f.f363418d.f363431m);
                    }
                    bVar.f397420j++;
                }
                if (bVar.f397420j < bVar.f397417g && SystemClock.uptimeMillis() - bVar.f397421k < bVar.f397418h * 1000) {
                    this.f397407f.b(5, 2000L);
                    break;
                }
                break;
            case 7:
                this.f397407f.removeCallbacksAndMessages(null);
                f.l(true);
                this.f397407f.b(8, 10000L);
                break;
            case 8:
                f.k(true);
                b bVar2 = (b) this.f397409i[11];
                if (QLog.isColorLevel()) {
                    List<String> e16 = f.e(bVar2.f397432v, true);
                    QLog.d("UnifiedMonitor", 2, "trace " + message.obj + "'s cpu end(" + f.f363417c + ", " + f.f363418d.f363431m + ")");
                    Iterator<String> it6 = e16.iterator();
                    while (it6.hasNext()) {
                        QLog.d("UnifiedMonitor", 2, it6.next());
                    }
                    break;
                }
                break;
            case 9:
                if (!AppSetting.isPublicVersion()) {
                    ((b) this.f397409i[11]).b(d());
                    break;
                }
                break;
        }
    }

    public void j() {
        bc bcVar;
        if (!AppSetting.isPublicVersion() && (bcVar = this.f397407f) != null) {
            bcVar.sendEmptyMessage(9);
        }
    }

    public synchronized void k() {
        if (!this.f397408h) {
            if (this.f397405d == null) {
                bc a16 = ThreadManagerV2.newHandlerRecycleThread("unified-monitor", 0).a(this);
                this.f397405d = a16;
                a16.sendEmptyMessage(3);
            }
        }
    }

    @Override // mqq.util.AbstractUnifiedMonitor
    public void notifyNotTimeout(int i3) {
        this.f397409i[i3].f397425o = 0L;
        this.f397409i[i3].f397424n = null;
        bc bcVar = this.f397405d;
        if (bcVar != null) {
            if (i3 == 0 || i3 == 10) {
                bcVar.removeMessages(2);
            }
        }
    }

    @Override // mqq.util.AbstractUnifiedMonitor
    public void reportStackIfTimeout(int i3) {
        this.f397409i[i3].f397425o = SystemClock.uptimeMillis();
        this.f397409i[i3].f397424n = null;
        this.f397409i[i3].f397423m = false;
    }

    @Override // mqq.util.AbstractUnifiedMonitor
    public boolean setMonitoredThread(int i3, Thread thread, AbstractUnifiedMonitor.ThreadMonitorCallback threadMonitorCallback) {
        return false;
    }

    @Override // mqq.util.AbstractUnifiedMonitor
    public boolean whetherReportDuringThisStartup(int i3) {
        if (i3 >= 22) {
            return false;
        }
        return this.f397409i[i3].f397422l;
    }

    @Override // mqq.util.AbstractUnifiedMonitor
    public boolean whetherReportThisTime(int i3) {
        if (this.f397408h) {
            C10273a c10273a = this.f397409i[i3];
            if (c10273a.f397422l) {
                if (c10273a.f397426p) {
                    return c10273a.f397423m;
                }
                return whetherReportThisTime(i3, false);
            }
        }
        return false;
    }

    @Override // mqq.util.AbstractUnifiedMonitor
    public boolean whetherStackEnabled(int i3) {
        return this.f397409i[i3].f397426p;
    }

    @Override // mqq.util.AbstractUnifiedMonitor
    public boolean whetherReportThisTime(int i3, boolean z16) {
        if (!AppSetting.isPublicVersion() && !z16) {
            return true;
        }
        C10273a c10273a = this.f397409i[i3];
        return c10273a.f397419i < c10273a.f397412b && Math.random() <= ((double) c10273a.f397414d);
    }

    /* compiled from: P */
    /* renamed from: ey3.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C10273a {

        /* renamed from: a, reason: collision with root package name */
        public int f397411a;

        /* renamed from: b, reason: collision with root package name */
        public int f397412b;

        /* renamed from: c, reason: collision with root package name */
        public float f397413c;

        /* renamed from: d, reason: collision with root package name */
        public float f397414d;

        /* renamed from: e, reason: collision with root package name */
        int f397415e;

        /* renamed from: f, reason: collision with root package name */
        int f397416f;

        /* renamed from: g, reason: collision with root package name */
        int f397417g;

        /* renamed from: h, reason: collision with root package name */
        int f397418h;

        /* renamed from: i, reason: collision with root package name */
        int f397419i;

        /* renamed from: j, reason: collision with root package name */
        int f397420j;

        /* renamed from: k, reason: collision with root package name */
        long f397421k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f397422l;

        /* renamed from: m, reason: collision with root package name */
        volatile boolean f397423m;

        /* renamed from: n, reason: collision with root package name */
        volatile String f397424n;

        /* renamed from: o, reason: collision with root package name */
        volatile long f397425o;

        /* renamed from: p, reason: collision with root package name */
        boolean f397426p;

        /* renamed from: q, reason: collision with root package name */
        int f397427q;

        /* renamed from: r, reason: collision with root package name */
        boolean f397428r;

        C10273a() {
            this.f397411a = 100;
            this.f397412b = 10;
            this.f397413c = 0.001f;
            this.f397414d = 0.1f;
            this.f397415e = 0;
            this.f397416f = 500;
            this.f397417g = 5;
            this.f397418h = 300;
            this.f397419i = 0;
            this.f397420j = 0;
            this.f397421k = 0L;
            this.f397422l = false;
            this.f397423m = false;
            this.f397424n = null;
            this.f397425o = 0L;
            this.f397426p = false;
            this.f397427q = 0;
            this.f397428r = false;
        }

        public void a(int i3) {
            boolean z16;
            if (a.h() && i3 != 9) {
                if (this.f397413c > 0.0f) {
                    this.f397413c = 1.0f;
                    this.f397414d = 1.0f;
                    this.f397412b = Integer.MAX_VALUE;
                }
            } else if (AppSetting.isGrayVersion()) {
                if (this.f397413c > 0.0f) {
                    this.f397413c = 0.1f;
                }
            } else if (!AppSetting.isPublicVersion()) {
                this.f397413c = 0.0f;
            }
            if (Math.random() <= this.f397413c) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f397422l = z16;
        }

        C10273a(float f16, int i3, int i16, float f17, int i17, int i18, int i19, int i26, boolean z16) {
            this.f397411a = 100;
            this.f397412b = 10;
            this.f397413c = 0.001f;
            this.f397414d = 0.1f;
            this.f397415e = 0;
            this.f397416f = 500;
            this.f397417g = 5;
            this.f397418h = 300;
            this.f397419i = 0;
            this.f397420j = 0;
            this.f397421k = 0L;
            this.f397422l = false;
            this.f397423m = false;
            this.f397424n = null;
            this.f397425o = 0L;
            this.f397426p = false;
            this.f397413c = f16;
            this.f397411a = i3;
            this.f397412b = i16;
            this.f397414d = f17;
            this.f397415e = i17;
            this.f397427q = i18;
            this.f397428r = z16;
        }
    }
}
