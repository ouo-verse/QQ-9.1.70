package com.tencent.mobileqq.login.restart;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.perf.report.abtag.BuglyABManager;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bN\u0010OJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J \u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J&\u0010#\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0!H\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0004H\u0002J\n\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\u0006\u0010(\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\bR\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R \u00108\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00107R\u0016\u0010;\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010=R\u001b\u0010A\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010D\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010>\u001a\u0004\bC\u0010@R\u0018\u0010F\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010HR\u001b\u0010M\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010>\u001a\u0004\bK\u0010L\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/login/restart/LoginProcessRestartMonitor;", "", "Lcom/tencent/mobileqq/login/restart/Scene;", "scene", "", "uin", "", "restartProcess", "", "E", "Lcom/tencent/mobileqq/login/restart/Stage;", "stage", "f", "i", "t", "u", "", "costTime", BdhLogUtil.LogTag.Tag_Conn, "D", "w", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "validEnd", "H", "B", "startTime", "endTime", HippyTKDListViewAdapter.X, "", "startPss", "curPss", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "pssList", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "reason", "y", "l", "v", ReportConstant.COSTREPORT_PREFIX, "k", tl.h.F, "b", "Lcom/tencent/mobileqq/login/restart/Scene;", "curScene", "c", "Ljava/lang/String;", "d", "Z", "isRestartProcess", "e", "J", "startMonitorTime", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "stageTimeMap", "g", "I", "startMonitorPss", "", "Ljava/util/List;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "deviceEnable", "j", DomainData.DOMAIN_NAME, "reportEnable", "Ljava/lang/Integer;", "curPerfTag", "Landroid/os/Handler;", "Landroid/os/Handler;", "handle", "Lcom/tencent/mobileqq/app/bc;", "o", "()Lcom/tencent/mobileqq/app/bc;", "subQQHandler", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LoginProcessRestartMonitor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LoginProcessRestartMonitor f242582a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Scene curScene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String uin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isRestartProcess;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long startMonitorTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Stage, Long> stageTimeMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int startMonitorPss;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> pssList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy deviceEnable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy reportEnable;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Integer curPerfTag;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy subQQHandler;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23548);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f242582a = new LoginProcessRestartMonitor();
        curScene = Scene.UNKNOWN;
        uin = "";
        stageTimeMap = new ConcurrentHashMap<>();
        pssList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(LoginProcessRestartMonitor$deviceEnable$2.INSTANCE);
        deviceEnable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LoginProcessRestartMonitor$reportEnable$2.INSTANCE);
        reportEnable = lazy2;
        handle = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.login.restart.f
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean p16;
                p16 = LoginProcessRestartMonitor.p(message);
                return p16;
            }
        });
        lazy3 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) LoginProcessRestartMonitor$subQQHandler$2.INSTANCE);
        subQQHandler = lazy3;
    }

    LoginProcessRestartMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void A(Scene scene, int startPss, List<Integer> pssList2) {
        Object obj;
        Map mutableMapOf;
        if (!v()) {
            return;
        }
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("scene", scene.name());
        String str = "1";
        if (isRestartProcess) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[1] = TuplesKt.to("restartProcess", obj);
        if (!m()) {
            str = "0";
        }
        pairArr[2] = TuplesKt.to("deviceEnable", str);
        pairArr[3] = TuplesKt.to("perfLevel", String.valueOf(c.f242621a.b()));
        pairArr[4] = TuplesKt.to("startMemory", String.valueOf(startPss));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        int size = pssList2.size();
        for (int i3 = 1; i3 < size; i3++) {
            mutableMapOf.put("memory" + i3, String.valueOf(pssList2.get(i3).intValue()));
        }
        QQBeaconReport.report(l(), "switch_account_memory_monitor", mutableMapOf);
    }

    private final void B(Scene scene) {
        Object obj;
        Map mapOf;
        if (!v()) {
            return;
        }
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("scene", scene.name());
        String str = "1";
        if (isRestartProcess) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[1] = TuplesKt.to("restartProcess", obj);
        if (!m()) {
            str = "0";
        }
        pairArr[2] = TuplesKt.to("deviceEnable", str);
        pairArr[3] = TuplesKt.to("perfLevel", String.valueOf(c.f242621a.b()));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        QQBeaconReport.report(l(), "switch_account_start", mapOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void C(long costTime) {
        JSONArray jSONArray;
        int c16;
        MMKVOptionEntity from;
        IntRange until;
        IntProgression reversed;
        int i3 = 0;
        JSONArray jSONArray2 = null;
        try {
            from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
            String decodeString = from.decodeString("login_restart_monitor_cost_time_recently", null);
            if (decodeString == null) {
                decodeString = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            jSONArray = new JSONArray(decodeString);
        } catch (Exception e16) {
            e = e16;
        }
        try {
            if (jSONArray.length() >= 5) {
                until = RangesKt___RangesKt.until(0, (jSONArray.length() - 5) + 1);
                reversed = RangesKt___RangesKt.reversed(until);
                int first = reversed.getFirst();
                int last = reversed.getLast();
                int step = reversed.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        jSONArray.remove(first);
                        if (first == last) {
                            break;
                        } else {
                            first += step;
                        }
                    }
                }
            }
            jSONArray.put(costTime);
            String jSONArray3 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray3, "timeArray.toString()");
            from.encodeString("login_restart_monitor_cost_time_recently", jSONArray3);
            QLog.i("LoginProcessRestartMonitor", 1, "save recently cost time " + jSONArray3);
        } catch (Exception e17) {
            e = e17;
            jSONArray2 = jSONArray;
            QLog.e("LoginProcessRestartMonitor", 1, "saveCostTime error:", e);
            jSONArray = jSONArray2;
            b a16 = c.f242621a.a();
            int d16 = a16.d();
            c16 = a16.c();
            if (jSONArray != null) {
            }
            if (i3 < c16) {
            }
        }
        b a162 = c.f242621a.a();
        int d162 = a162.d();
        c16 = a162.c();
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i16 = 0;
            while (i3 < length) {
                if (jSONArray.optLong(i3) >= d162) {
                    i16++;
                }
                i3++;
            }
            i3 = i16;
        }
        if (i3 < c16) {
            k("recentlySlow");
        }
    }

    private final void D() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        from.encodeInt("login_restart_monitor_scene", curScene.ordinal());
        from.encodeString("login_restart_monitor_uin", uin);
        from.encodeBool("login_restart_monitor_restart_process", isRestartProcess);
        from.encodeLong("login_restart_monitor_start_time", startMonitorTime);
        for (Stage stage : Stage.values()) {
            Long l3 = stageTimeMap.get(stage);
            if (l3 == null) {
                l3 = 0L;
            }
            from.encodeLong("login_restart_monitor_stage_time_" + stage.name(), l3.longValue());
        }
        from.encodeInt("login_restart_monitor_start_pss", startMonitorPss);
    }

    @JvmStatic
    public static final void E(@NotNull final Scene scene, @Nullable final String uin2, final boolean restartProcess) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        final long currentTimeMillis = System.currentTimeMillis();
        f242582a.o().post(new Runnable() { // from class: com.tencent.mobileqq.login.restart.d
            @Override // java.lang.Runnable
            public final void run() {
                LoginProcessRestartMonitor.F(Scene.this, uin2, restartProcess, currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Scene scene, String str, boolean z16, long j3) {
        boolean z17;
        String str2;
        Intrinsics.checkNotNullParameter(scene, "$scene");
        if (startMonitorTime > 0 && curScene != Scene.UNKNOWN) {
            z17 = true;
        } else {
            z17 = false;
        }
        handle.removeMessages(1);
        curScene = scene;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        uin = str2;
        isRestartProcess = z16;
        startMonitorTime = j3;
        stageTimeMap.clear();
        startMonitorPss = MemoryUtil.m(0, 1, null).getTotalPss();
        LoginProcessRestartMonitor loginProcessRestartMonitor = f242582a;
        loginProcessRestartMonitor.D();
        if (!z17) {
            loginProcessRestartMonitor.B(scene);
        } else {
            QLog.d("LoginProcessRestartMonitor", 1, "ignore report repeat start");
        }
        QLog.i("LoginProcessRestartMonitor", 1, "start scene=" + scene + " uin=" + StringUtil.getSimpleUinForPrint(str) + " restartProcess=" + z16 + " startPss=" + startMonitorPss);
    }

    private final void G() {
        pssList.clear();
        Handler handler = handle;
        handler.removeMessages(1);
        handler.sendEmptyMessageDelayed(1, 10000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void H(boolean validEnd) {
        int i3;
        Integer num;
        boolean z16;
        boolean z17;
        if (validEnd) {
            if (isRestartProcess) {
                i3 = 1;
            } else if (m()) {
                i3 = 2;
            }
            QLog.i("LoginProcessRestartMonitor", 2, "updatePerfABTag perfTag=" + i3);
            num = curPerfTag;
            if (num != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (num == null || i3 != num.intValue()) {
                z17 = true;
            } else {
                z17 = false;
            }
            curPerfTag = Integer.valueOf(i3);
            if (i3 != 1) {
                if (i3 == 2) {
                    PerfFeature.a(PerfFeature.CustomFlag.SwitchAccountRebootContrast);
                    PerfFeature.d(PerfFeature.CustomFlag.SwitchAccountRebootExp);
                }
            } else {
                PerfFeature.a(PerfFeature.CustomFlag.SwitchAccountRebootExp);
                PerfFeature.d(PerfFeature.CustomFlag.SwitchAccountRebootContrast);
            }
            if (z17) {
                if (z16 || i3 != 3) {
                    if (1 == i3) {
                        BuglyABManager.a(BuglyABManager.ABTag.SwitchAccountRebootContrast.name(), false);
                        BuglyABManager.a(BuglyABManager.ABTag.SwitchAccountRebootExp.name(), true);
                        return;
                    } else if (2 == i3) {
                        BuglyABManager.a(BuglyABManager.ABTag.SwitchAccountRebootExp.name(), false);
                        BuglyABManager.a(BuglyABManager.ABTag.SwitchAccountRebootContrast.name(), true);
                        return;
                    } else {
                        BuglyABManager.a(BuglyABManager.ABTag.SwitchAccountRebootExp.name(), false);
                        BuglyABManager.a(BuglyABManager.ABTag.SwitchAccountRebootContrast.name(), false);
                        return;
                    }
                }
                return;
            }
            return;
        }
        i3 = 3;
        QLog.i("LoginProcessRestartMonitor", 2, "updatePerfABTag perfTag=" + i3);
        num = curPerfTag;
        if (num != null) {
        }
        if (num == null) {
            z17 = false;
            curPerfTag = Integer.valueOf(i3);
            if (i3 != 1) {
            }
            if (z17) {
            }
        }
        z17 = true;
        curPerfTag = Integer.valueOf(i3);
        if (i3 != 1) {
        }
        if (z17) {
        }
    }

    @JvmStatic
    public static final void f(@NotNull final Stage stage) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        final long currentTimeMillis = System.currentTimeMillis();
        f242582a.o().post(new Runnable() { // from class: com.tencent.mobileqq.login.restart.g
            @Override // java.lang.Runnable
            public final void run() {
                LoginProcessRestartMonitor.g(Stage.this, currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Stage stage, long j3) {
        Intrinsics.checkNotNullParameter(stage, "$stage");
        QLog.d("LoginProcessRestartMonitor", 1, "changeStage " + stage);
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        from.encodeLong("login_restart_monitor_stage_time_" + stage.name(), j3);
    }

    @JvmStatic
    public static final void i(@NotNull final Scene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        final long currentTimeMillis = System.currentTimeMillis();
        f242582a.o().post(new Runnable() { // from class: com.tencent.mobileqq.login.restart.e
            @Override // java.lang.Runnable
            public final void run() {
                LoginProcessRestartMonitor.j(Scene.this, currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Scene scene, long j3) {
        Intrinsics.checkNotNullParameter(scene, "$scene");
        LoginProcessRestartMonitor loginProcessRestartMonitor = f242582a;
        loginProcessRestartMonitor.w();
        if (!loginProcessRestartMonitor.u(scene)) {
            loginProcessRestartMonitor.h();
            loginProcessRestartMonitor.H(false);
            return;
        }
        long j16 = startMonitorTime;
        long j17 = j3 - j16;
        startMonitorTime = 0L;
        if (isRestartProcess) {
            loginProcessRestartMonitor.C(j17);
        }
        if (j17 > 60000) {
            QLog.d("LoginProcessRestartMonitor", 1, "ignore end, cost time is too long");
            return;
        }
        loginProcessRestartMonitor.x(scene, j17, j16, j3);
        QLog.i("LoginProcessRestartMonitor", 1, "end scene=" + scene + " costTime=" + j17);
        loginProcessRestartMonitor.H(true);
        QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeLong("login_restart_monitor_start_time", 0L);
        loginProcessRestartMonitor.G();
    }

    private final String l() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentAccountUin();
        }
        return null;
    }

    private final boolean m() {
        return ((Boolean) deviceEnable.getValue()).booleanValue();
    }

    private final boolean n() {
        return ((Boolean) reportEnable.getValue()).booleanValue();
    }

    private final bc o() {
        return (bc) subQQHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1) {
            f242582a.q();
        }
        return true;
    }

    private final void q() {
        o().post(new Runnable() { // from class: com.tencent.mobileqq.login.restart.h
            @Override // java.lang.Runnable
            public final void run() {
                LoginProcessRestartMonitor.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r() {
        int totalPss = MemoryUtil.m(0, 1, null).getTotalPss();
        int i3 = startMonitorPss;
        List<Integer> list = pssList;
        list.add(Integer.valueOf(totalPss));
        QLog.i("LoginProcessRestartMonitor", 1, "handleMemoryMonitor scene=" + curScene + " pss=" + totalPss);
        if (list.size() == 1) {
            QLog.i("LoginProcessRestartMonitor", 1, "instant memory monitor deltaPss=" + (totalPss - i3));
            f242582a.z(curScene, i3, totalPss);
        }
        if (list.size() >= 6) {
            LoginProcessRestartMonitor loginProcessRestartMonitor = f242582a;
            loginProcessRestartMonitor.A(curScene, i3, list);
            loginProcessRestartMonitor.h();
            QLog.i("LoginProcessRestartMonitor", 1, "end memory monitor");
            return;
        }
        handle.sendEmptyMessageDelayed(1, 60000L);
    }

    @JvmStatic
    public static final boolean t() {
        boolean z16;
        if (curScene != Scene.SWITCH_ACCOUNT) {
            return false;
        }
        if (uin.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || isRestartProcess) {
            return false;
        }
        return true;
    }

    private final boolean u(Scene scene) {
        String str;
        if (curScene == Scene.UNKNOWN || startMonitorTime == 0) {
            return false;
        }
        Scene scene2 = curScene;
        if (scene2 != scene) {
            QLog.d("LoginProcessRestartMonitor", 2, "ignore end, scene is not equal");
            return false;
        }
        if (scene2 == Scene.SWITCH_ACCOUNT) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, uin)) {
                QLog.d("LoginProcessRestartMonitor", 2, "ignore end, uin is not equal");
                return false;
            }
            return true;
        }
        return true;
    }

    private final boolean v() {
        if (isRestartProcess) {
            return true;
        }
        return n();
    }

    private final void w() {
        Object orNull;
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        Scene[] values = Scene.values();
        Scene scene = Scene.UNKNOWN;
        orNull = ArraysKt___ArraysKt.getOrNull(values, from.decodeInt("login_restart_monitor_scene", scene.ordinal()));
        Scene scene2 = (Scene) orNull;
        if (scene2 != null) {
            scene = scene2;
        }
        curScene = scene;
        String str = "";
        String decodeString = from.decodeString("login_restart_monitor_uin", "");
        if (decodeString != null) {
            str = decodeString;
        }
        uin = str;
        isRestartProcess = from.decodeBool("login_restart_monitor_restart_process", false);
        startMonitorTime = from.decodeLong("login_restart_monitor_start_time", 0L);
        for (Stage stage : Stage.values()) {
            stageTimeMap.put(stage, Long.valueOf(from.decodeLong("login_restart_monitor_stage_time_" + stage.name(), 0L)));
        }
        startMonitorPss = from.decodeInt("login_restart_monitor_start_pss", 0);
    }

    private final void x(Scene scene, long costTime, long startTime, long endTime) {
        Object obj;
        Map mutableMapOf;
        if (!v()) {
            return;
        }
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("scene", scene.name());
        String str = "1";
        if (isRestartProcess) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[1] = TuplesKt.to("restartProcess", obj);
        if (!m()) {
            str = "0";
        }
        pairArr[2] = TuplesKt.to("deviceEnable", str);
        pairArr[3] = TuplesKt.to("perfLevel", String.valueOf(c.f242621a.b()));
        pairArr[4] = TuplesKt.to("costTime", String.valueOf(costTime));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (isRestartProcess) {
            ConcurrentHashMap<Stage, Long> concurrentHashMap = stageTimeMap;
            Long l3 = concurrentHashMap.get(Stage.CAPTURE);
            if (l3 == null) {
                l3 = 0L;
            }
            long longValue = l3.longValue();
            Long l16 = concurrentHashMap.get(Stage.LOADING);
            if (l16 == null) {
                l16 = 0L;
            }
            long longValue2 = l16.longValue();
            Long l17 = concurrentHashMap.get(Stage.RESTART);
            if (l17 == null) {
                l17 = 0L;
            }
            long longValue3 = l17.longValue();
            if (longValue > 0 && longValue2 > 0 && longValue3 > 0 && startTime > 0 && endTime > 0) {
                long j3 = longValue - startTime;
                long j16 = longValue2 - longValue;
                long j17 = longValue3 - longValue2;
                long j18 = endTime - longValue3;
                mutableMapOf.put("logoutCostTime", String.valueOf(j3));
                mutableMapOf.put("captureCostTime", String.valueOf(j16));
                mutableMapOf.put("loadingCostTime", String.valueOf(j17));
                mutableMapOf.put("restartCostTime", String.valueOf(j18));
                QLog.d("LoginProcessRestartMonitor", 1, "StageCost: logoutCost=" + j3 + " captureCost=" + j16 + " loadingCost=" + j17 + " restartTotalCost=" + j18);
                if (scene == Scene.SWITCH_ACCOUNT) {
                    Long l18 = concurrentHashMap.get(Stage.COLD_START_END);
                    if (l18 == null) {
                        l18 = 0L;
                    }
                    long longValue4 = l18.longValue();
                    long j19 = longValue4 - longValue3;
                    long j26 = endTime - longValue4;
                    long j27 = longValue4 - startTime;
                    if (j19 > 0 && j26 > 0 && j27 > 0) {
                        mutableMapOf.put("coldStartCostTime", String.valueOf(j19));
                        mutableMapOf.put("registerProxyCostTime", String.valueOf(j26));
                        mutableMapOf.put("toColdStartCostTime", String.valueOf(j27));
                    }
                    QLog.d("LoginProcessRestartMonitor", 1, "StageCost: coldStartCost=" + j19 + " registerProxyCost=" + j26 + " toColdStartTotalCost=" + j27);
                }
            } else {
                QLog.w("LoginProcessRestartMonitor", 1, "StageCost invalid: startTime=" + startTime + " captureTime=" + longValue + " loadingTime=" + longValue2 + " restartTime=" + longValue3 + " endTime=" + endTime);
            }
        }
        QQBeaconReport.report(l(), "switch_account_cost_time", mutableMapOf);
    }

    private final void y(String reason) {
        Map mutableMapOf;
        if (v()) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("scene", curScene.name()), TuplesKt.to("perfLevel", String.valueOf(c.f242621a.b())), TuplesKt.to("downgradeReason", reason));
            QQBeaconReport.report(l(), "switch_account_downgrade", mutableMapOf);
        }
    }

    private final void z(Scene scene, int startPss, int curPss) {
        Object obj;
        Map mapOf;
        if (!v()) {
            return;
        }
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("scene", scene.name());
        String str = "1";
        if (isRestartProcess) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[1] = TuplesKt.to("restartProcess", obj);
        if (!m()) {
            str = "0";
        }
        pairArr[2] = TuplesKt.to("deviceEnable", str);
        pairArr[3] = TuplesKt.to("perfLevel", String.valueOf(c.f242621a.b()));
        pairArr[4] = TuplesKt.to("startMemory", String.valueOf(startPss));
        pairArr[5] = TuplesKt.to("endMemory", String.valueOf(curPss));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        QQBeaconReport.report(l(), "switch_account_instant_memory", mapOf);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        curScene = Scene.UNKNOWN;
        uin = "";
        isRestartProcess = false;
        startMonitorTime = 0L;
        stageTimeMap.clear();
        startMonitorPss = 0;
        pssList.clear();
        D();
    }

    public final void k(@NotNull String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) reason);
            return;
        }
        Intrinsics.checkNotNullParameter(reason, "reason");
        QLog.w("LoginProcessRestartMonitor", 1, "force disable process restart because " + reason);
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        from.encodeBool("login_switch_account_process_restart_disable", true);
        y(reason);
    }

    public final boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        return from.decodeBool("login_switch_account_process_restart_disable", false);
    }
}
