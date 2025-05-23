package com.tencent.qmethod.monitor.report;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.d;
import com.tencent.qmethod.monitor.base.util.f;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.ConstitutionSceneConfig;
import com.tencent.qmethod.monitor.config.bean.ConstitutionSceneReportType;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.report.sample.APILevelSampleHelper;
import com.tencent.qmethod.monitor.utils.DateUtilKt;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001RB\t\b\u0002\u00a2\u0006\u0004\bP\u0010QJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J&\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0017\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u000fJ\"\u0010$\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\tJ\u0006\u0010'\u001a\u00020\tR\u0014\u0010*\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010.\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00101\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u00106\u001a\u0004\b7\u00108R\"\u0010?\u001a\u00020\t8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010B\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010:\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 0C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010DR\u001b\u0010I\u001a\u00020F8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u00106\u001a\u0004\bG\u0010HR\u0017\u0010O\u001a\u00020J8\u0006\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\u00a8\u0006S"}, d2 = {"Lcom/tencent/qmethod/monitor/report/SampleHelper;", "", "", "scene", "module", DTConstants.TAG.API, AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "Lcom/tencent/qmethod/monitor/report/SampleHelper$SampleStatus;", "f", "", "t", "", "g", "", "value", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "l", HippyTKDListViewAdapter.X, "readModuleMaxKey", "r", "step", "j", "i", "e", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", "w", "(Lcom/tencent/qmethod/pandoraex/api/u;)V", "v", "", "rate", Element.ELEMENT_NAME_MIN, "max", "y", "flag", "B", "u", "a", "Ljava/lang/Object;", "TODAY_LOCK", "b", "SCENE_MAP_LOCK", "c", "MODULE_API_LOCK", "d", "I", "singleAPIMaxReport", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "moduleAPIMap", "Ljava/util/concurrent/atomic/AtomicLong;", "Lkotlin/Lazy;", h.F, "()Ljava/util/concurrent/atomic/AtomicLong;", "todayCount", "Z", "p", "()Z", "setFullSampleReportOnlySerious$qmethod_privacy_monitor_tencentBuglyRelease", "(Z)V", "isFullSampleReportOnlySerious", "o", "setFilterSameEnable", "isFilterSameEnable", "", "Ljava/util/Map;", "apiCoefficient", "Ljava/util/concurrent/atomic/AtomicBoolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isOpenReport", "Landroid/os/Handler;", "k", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler", "<init>", "()V", "SampleStatus", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class SampleHelper {

    /* renamed from: f, reason: from kotlin metadata */
    private static final Lazy todayCount;

    /* renamed from: g, reason: from kotlin metadata */
    private static boolean isFullSampleReportOnlySerious;

    /* renamed from: h */
    private static boolean isFilterSameEnable;

    /* renamed from: i, reason: from kotlin metadata */
    private static final Map<String, Double> apiCoefficient;

    /* renamed from: j, reason: from kotlin metadata */
    @NotNull
    private static final Lazy isOpenReport;

    /* renamed from: k, reason: from kotlin metadata */
    @NotNull
    private static final Handler handler;

    /* renamed from: l */
    public static final SampleHelper f343779l = new SampleHelper();

    /* renamed from: a, reason: from kotlin metadata */
    private static final Object TODAY_LOCK = new Object();

    /* renamed from: b, reason: from kotlin metadata */
    private static final Object SCENE_MAP_LOCK = new Object();

    /* renamed from: c, reason: from kotlin metadata */
    private static final Object MODULE_API_LOCK = new Object();

    /* renamed from: d, reason: from kotlin metadata */
    private static int singleAPIMaxReport = 2;

    /* renamed from: e, reason: from kotlin metadata */
    private static final ConcurrentHashMap<String, Integer> moduleAPIMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qmethod/monitor/report/SampleHelper$SampleStatus;", "", "(Ljava/lang/String;I)V", "GLOBAL_LIMIT", "GLOBAL_RATE", "SCENE_LIMIT", "SCENE_RATE", "MODULE_LIMIT", "PASS", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public enum SampleStatus {
        GLOBAL_LIMIT,
        GLOBAL_RATE,
        SCENE_LIMIT,
        SCENE_RATE,
        MODULE_LIMIT,
        PASS
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qmethod/monitor/report/SampleHelper$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        
            r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull((java.lang.String) r3.get(1));
         */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(@NotNull Message msg2) {
            List split$default;
            Long longOrNull;
            Long longOrNull2;
            Intrinsics.checkParameterIsNotNull(msg2, "msg");
            if (msg2.what == 1) {
                SampleHelper sampleHelper = SampleHelper.f343779l;
                synchronized (SampleHelper.a(sampleHelper)) {
                    String d16 = f.d("today");
                    long j3 = 0;
                    if (d16 != null) {
                        split$default = StringsKt__StringsKt.split$default((CharSequence) d16, new String[]{"-"}, false, 0, 6, (Object) null);
                        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) split$default.get(0));
                        if (longOrNull != null && DateUtilKt.c(longOrNull.longValue()) && split$default.size() == 2 && longOrNull2 != null) {
                            j3 = longOrNull2.longValue();
                        }
                    }
                    Object obj = msg2.obj;
                    if (obj != null) {
                        long longValue = j3 + ((Long) obj).longValue();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(System.currentTimeMillis());
                        sb5.append('-');
                        sb5.append(longValue);
                        f.g("today", sb5.toString());
                        if (longValue > sampleHelper.h().get()) {
                            sampleHelper.h().set(longValue);
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
                    }
                }
            }
            super.handleMessage(msg2);
        }
    }

    static {
        Lazy lazy;
        Map<String, Double> mutableMapOf;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<AtomicLong>() { // from class: com.tencent.qmethod.monitor.report.SampleHelper$todayCount$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AtomicLong invoke() {
                long g16;
                g16 = SampleHelper.f343779l.g();
                return new AtomicLong(g16);
            }
        });
        todayCount = lazy;
        isFilterSameEnable = true;
        Double valueOf = Double.valueOf(0.1d);
        Double valueOf2 = Double.valueOf(0.5d);
        Double valueOf3 = Double.valueOf(1.0d);
        Double valueOf4 = Double.valueOf(3.0d);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("WM#G_CON_INFO", valueOf), TuplesKt.to("NI#G_NET_INT", valueOf2), TuplesKt.to("TM#G_SIM_OP", valueOf2), TuplesKt.to("NC#HAS_TRANS", valueOf), TuplesKt.to("NI#G_TYPE", valueOf2), TuplesKt.to("NI#G_SUB_TYPE", valueOf2), TuplesKt.to("TM#G_NET_TYPE", valueOf2), TuplesKt.to("TM#G_DA_NET_TYPE", valueOf2), TuplesKt.to("NI#G_TY_NAME", valueOf), TuplesKt.to("CM#G_PRI_CLIP_DESC", valueOf3), TuplesKt.to("CM#HAS_PRI_CLIP", valueOf3), TuplesKt.to("CM#G_PRI_DESC", valueOf3), TuplesKt.to("BU#MODEL", Double.valueOf(0.05d)), TuplesKt.to("TM#G_IM", valueOf3), TuplesKt.to("TM#G_SID", valueOf3), TuplesKt.to("TM#G_MID", valueOf3), TuplesKt.to("SE#G_AID", valueOf2), TuplesKt.to("CAM#OPN#I", valueOf3), TuplesKt.to("AR#STRT_REC", valueOf3), TuplesKt.to("PM#G_IN_APPS", valueOf4), TuplesKt.to("PM#G_IN_PKGS", valueOf4));
        apiCoefficient = mutableMapOf;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AtomicBoolean>() { // from class: com.tencent.qmethod.monitor.report.SampleHelper$isOpenReport$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AtomicBoolean invoke() {
                boolean i3;
                LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
                i3 = SampleHelper.f343779l.i();
                AtomicBoolean atomicBoolean = new AtomicBoolean(i3);
                o.e("SampleHelper", "isOpenReport=" + atomicBoolean.get());
                for (Map.Entry<String, e> entry : ConfigManager.f343549h.p().g().entrySet()) {
                    o.e("SampleHelper", "currentSampleInfo: scene=" + entry.getKey() + ", rate=" + entry.getValue().getRate() + ", maxReport=" + entry.getValue().getMaxReport());
                }
                return atomicBoolean;
            }
        });
        isOpenReport = lazy2;
        handler = new a(ThreadManager.f343506c.a());
    }

    SampleHelper() {
    }

    private final boolean A(String str, String str2, String str3, String str4) {
        double d16;
        double d17;
        ConfigManager configManager = ConfigManager.f343549h;
        e eVar = configManager.p().g().get(str);
        if (eVar != null) {
            d16 = eVar.getRate();
        } else {
            d16 = 0.0d;
        }
        if (Intrinsics.areEqual("normal", str)) {
            ConstitutionSceneConfig a16 = configManager.q().a(str2, str3, str);
            if (a16 == null) {
                if (APILevelSampleHelper.f343864j.k(str3)) {
                    return false;
                }
            } else if (a16.getCom.tencent.ad.tangram.statistics.metric.AdMetricTag.Report.TYPE java.lang.String() == ConstitutionSceneReportType.NORMAL && com.tencent.qmethod.monitor.report.a.f(str2, str3)) {
                return false;
            }
        }
        if (!com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            Map<String, Double> map = apiCoefficient;
            if (map.containsKey(str3)) {
                Double d18 = map.get(str3);
                if (d18 != null) {
                    d17 = d18.doubleValue();
                } else {
                    d17 = 1.0d;
                }
                d16 *= d17;
            }
            d16 *= APILevelSampleHelper.f343864j.c(str, str2, str3, str4);
        }
        double d19 = d16;
        if (d19 > 1) {
            return true;
        }
        return z(this, d19, 0, 0, 6, null);
    }

    public static final /* synthetic */ Object a(SampleHelper sampleHelper) {
        return TODAY_LOCK;
    }

    private final SampleStatus f(String scene, String module, String r46, String r56) {
        if (!isFullSampleReportOnlySerious && !q().get()) {
            return SampleStatus.GLOBAL_RATE;
        }
        if (t()) {
            return SampleStatus.GLOBAL_LIMIT;
        }
        if (s(scene)) {
            return SampleStatus.SCENE_LIMIT;
        }
        if (!isFullSampleReportOnlySerious && !A(scene, module, r46, r56)) {
            return SampleStatus.SCENE_RATE;
        }
        String str = module + r46 + scene + r56;
        if (r(str)) {
            return SampleStatus.MODULE_LIMIT;
        }
        n(this, 0, 1, null);
        l(scene);
        k(this, str, 0, 2, null);
        return SampleStatus.PASS;
    }

    public final long g() {
        List split$default;
        boolean z16;
        List split$default2;
        Long longOrNull;
        List split$default3;
        Long longOrNull2;
        String d16 = f.d("today");
        if (d16 != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) d16, new String[]{"-"}, false, 0, 6, (Object) null);
            if (d16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && split$default.size() == 2) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) d16, new String[]{"-"}, false, 0, 6, (Object) null);
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) split$default2.get(0));
                split$default3 = StringsKt__StringsKt.split$default((CharSequence) d16, new String[]{"-"}, false, 0, 6, (Object) null);
                longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull((String) split$default3.get(1));
                if (longOrNull != null && DateUtilKt.c(longOrNull.longValue()) && longOrNull2 != null) {
                    return longOrNull2.longValue();
                }
            }
        }
        return 0L;
    }

    public final AtomicLong h() {
        return (AtomicLong) todayCount.getValue();
    }

    public final boolean i() {
        double d16;
        boolean z16;
        List split$default;
        Long longOrNull;
        Double doubleOrNull;
        synchronized (TODAY_LOCK) {
            String d17 = f.d("today_total_rate");
            ConfigManager configManager = ConfigManager.f343549h;
            e eVar = configManager.p().g().get(ReadInJoyMMapKvStorage.NAME_DEFAULT);
            double d18 = 0.0d;
            if (eVar != null) {
                d16 = eVar.getRate();
            } else {
                d16 = 0.0d;
            }
            z16 = false;
            double d19 = -1.0d;
            if (!TextUtils.isEmpty(d17)) {
                if (d17 == null) {
                    Intrinsics.throwNpe();
                }
                split$default = StringsKt__StringsKt.split$default((CharSequence) d17, new String[]{"#"}, false, 0, 6, (Object) null);
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) split$default.get(0));
                if (longOrNull != null && DateUtilKt.c(longOrNull.longValue()) && split$default.size() == 3) {
                    doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull((String) split$default.get(1));
                    if (doubleOrNull != null) {
                        d19 = doubleOrNull.doubleValue();
                    }
                    boolean parseBoolean = Boolean.parseBoolean((String) split$default.get(2));
                    o.e("SampleHelper", "getTodaySampleState[old]=" + parseBoolean);
                    z16 = parseBoolean;
                }
            }
            o.e("SampleHelper", "lastRate=" + d19 + ", currentRate=" + d16 + ", lastSampleStatus=" + z16);
            if (d19 != d16) {
                e eVar2 = configManager.p().g().get(ReadInJoyMMapKvStorage.NAME_DEFAULT);
                if (eVar2 != null) {
                    d18 = eVar2.getRate();
                }
                double d26 = d18;
                z16 = z(f343779l, d26, 0, 0, 6, null);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(System.currentTimeMillis());
                sb5.append('#');
                sb5.append(d26);
                sb5.append('#');
                sb5.append(z16);
                f.g("today_total_rate", sb5.toString());
                o.e("SampleHelper", "getTodaySampleState[new]=" + z16);
            }
        }
        return z16;
    }

    private final void j(String readModuleMaxKey, int step) {
        synchronized (MODULE_API_LOCK) {
            ConcurrentHashMap<String, Integer> concurrentHashMap = moduleAPIMap;
            Integer num = concurrentHashMap.get(readModuleMaxKey);
            if (num == null) {
                num = 0;
            }
            concurrentHashMap.put(readModuleMaxKey, Integer.valueOf(num.intValue() + step));
            Unit unit = Unit.INSTANCE;
        }
    }

    static /* synthetic */ void k(SampleHelper sampleHelper, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        sampleHelper.j(str, i3);
    }

    private final void l(String scene) {
        synchronized (SCENE_MAP_LOCK) {
            d.f343534a.d(3, "KEY_QUESTION_REPORT_" + scene);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void m(int i3) {
        long j3 = i3;
        h().addAndGet(j3);
        handler.obtainMessage(1, Long.valueOf(j3)).sendToTarget();
    }

    static /* synthetic */ void n(SampleHelper sampleHelper, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 1;
        }
        sampleHelper.m(i3);
    }

    private final boolean r(String readModuleMaxKey) {
        boolean z16;
        synchronized (MODULE_API_LOCK) {
            Integer num = moduleAPIMap.get(readModuleMaxKey);
            z16 = false;
            if (num == null) {
                num = 0;
            }
            if (Intrinsics.compare(num.intValue(), singleAPIMaxReport) >= 0) {
                z16 = true;
            }
        }
        return z16;
    }

    private final boolean s(String str) {
        int i3;
        boolean b16;
        synchronized (SCENE_MAP_LOCK) {
            d dVar = d.f343534a;
            String str2 = "KEY_QUESTION_REPORT_" + str;
            e eVar = ConfigManager.f343549h.p().g().get(str);
            if (eVar != null) {
                i3 = eVar.getMaxReport();
            } else {
                i3 = 0;
            }
            b16 = dVar.b(3, str2, i3);
        }
        return b16;
    }

    private final boolean t() {
        int i3;
        long j3 = h().get();
        e eVar = ConfigManager.f343549h.p().g().get(ReadInJoyMMapKvStorage.NAME_DEFAULT);
        if (eVar != null) {
            i3 = eVar.getMaxReport();
        } else {
            i3 = 0;
        }
        if (j3 < i3) {
            return false;
        }
        return true;
    }

    private final void x(String str) {
        synchronized (SCENE_MAP_LOCK) {
            d.f343534a.e(3, "KEY_QUESTION_REPORT_" + str);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ boolean z(SampleHelper sampleHelper, double d16, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 1;
        }
        return sampleHelper.y(d16, i3, i16);
    }

    public final void B(boolean flag) {
        isFullSampleReportOnlySerious = flag;
    }

    public final boolean e(@NotNull String scene, @NotNull String module, @NotNull String r102, @NotNull String r112) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(r102, "api");
        Intrinsics.checkParameterIsNotNull(r112, "strategy");
        SampleStatus f16 = f(scene, module, r102, r112);
        if (SampleStatus.PASS == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            if (!z16) {
                o.a("SampleHelper", "canReport ignore: scene=" + scene + ", module=" + module + ", api=" + r102 + ", because of " + f16);
            } else {
                o.a("SampleHelper", "canReport ok: scene=" + scene + ", module=" + module + ", api=" + r102 + ", because of " + f16);
            }
        }
        return z16;
    }

    public final boolean o() {
        return isFilterSameEnable;
    }

    public final boolean p() {
        return isFullSampleReportOnlySerious;
    }

    @NotNull
    public final AtomicBoolean q() {
        return (AtomicBoolean) isOpenReport.getValue();
    }

    public final boolean u() {
        if (!isFullSampleReportOnlySerious && !q().get()) {
            return false;
        }
        return true;
    }

    public final void v() {
        q().set(i());
        Unit unit = Unit.INSTANCE;
        o.e("SampleHelper", "onConfigUpdate, isOpenReport=" + f343779l.q().get());
        for (Map.Entry<String, e> entry : ConfigManager.f343549h.p().g().entrySet()) {
            o.e("SampleHelper", "onConfigUpdate, currentSampleInfo: scene=" + entry.getKey() + ", rate=" + entry.getValue().getRate() + ", maxReport=" + entry.getValue().getMaxReport());
        }
    }

    public final void w(@NotNull u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        m(-1);
        String str = reportStrategy.f343967d;
        Intrinsics.checkExpressionValueIsNotNull(str, "reportStrategy.scene");
        x(str);
        j(reportStrategy.f343964a + reportStrategy.f343965b + reportStrategy.f343967d + reportStrategy.f343968e, -1);
    }

    public final boolean y(double rate, int r75, int max) {
        if (rate > (Math.random() * max) + r75) {
            return true;
        }
        return false;
    }
}
