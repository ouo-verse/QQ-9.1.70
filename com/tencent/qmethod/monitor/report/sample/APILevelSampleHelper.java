package com.tencent.qmethod.monitor.report.sample;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.monitor.base.util.f;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.x;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00011B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013R+\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0016j\b\u0012\u0004\u0012\u00020\u0002`\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR+\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0016j\b\u0012\u0004\u0012\u00020\u0002`\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR+\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0016j\b\u0012\u0004\u0012\u00020\u0002`\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b \u0010\u001bR$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00020\"j\b\u0012\u0004\u0012\u00020\u0002`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010$R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00020\"j\b\u0012\u0004\u0012\u00020\u0002`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010$R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00020\"j\b\u0012\u0004\u0012\u00020\u0002`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010$R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00020\"j\b\u0012\u0004\u0012\u00020\u0002`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010$R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001b\u0010.\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b*\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/qmethod/monitor/report/sample/APILevelSampleHelper;", "", "", "apiName", "", "j", "l", DTConstants.TAG.API, "Lcom/tencent/qmethod/monitor/report/sample/APILevelSampleHelper$APIType;", "d", "scene", "module", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "i", "o", DomainData.DOMAIN_NAME, "", "c", "k", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "a", "Lkotlin/Lazy;", "e", "()Ljava/util/HashSet;", "deviceUniqueApi", "b", "f", "noSeriousApis", "g", "notSplitModuleApiList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "HighList", "MiddleList", "LowList", "TripleSampleList", "", h.F, "Ljava/util/List;", "cacheStrategy", "()Z", "tripleSampleClose", "<init>", "()V", "APIType", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class APILevelSampleHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy deviceUniqueApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy noSeriousApis;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy notSplitModuleApiList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> HighList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> MiddleList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> LowList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> TripleSampleList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final List<String> cacheStrategy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final Lazy tripleSampleClose;

    /* renamed from: j, reason: collision with root package name */
    public static final APILevelSampleHelper f343864j = new APILevelSampleHelper();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qmethod/monitor/report/sample/APILevelSampleHelper$APIType;", "", "(Ljava/lang/String;I)V", "HIGH", "MIDDLE", "LOW", "UNKNOWN", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public enum APIType {
        HIGH,
        MIDDLE,
        LOW,
        UNKNOWN
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        ArrayList<String> arrayListOf;
        ArrayList<String> arrayListOf2;
        ArrayList<String> arrayListOf3;
        ArrayList<String> arrayListOf4;
        List<String> listOf;
        Lazy lazy4;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HashSet<String>>() { // from class: com.tencent.qmethod.monitor.report.sample.APILevelSampleHelper$deviceUniqueApi$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashSet<String> invoke() {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add("TM#G_MID");
                hashSet.add("TM#G_MID#I");
                hashSet.add("TM#G_DID");
                hashSet.add("TM#G_DID#I");
                hashSet.add("SE#G_AID");
                hashSet.add("BU#SER");
                hashSet.add("TM#G_IM#I");
                hashSet.add("TM#G_IM");
                hashSet.add("TM#G_SID");
                hashSet.add("TM#G_SIM_SE_NUM");
                hashSet.add("NI#G_HW_ADDR");
                hashSet.add("WI#G_MA_ADDR");
                hashSet.add("BA#G_ADDR");
                hashSet.add("OAID#OPPO");
                hashSet.add("OAID#XIAOMI");
                hashSet.add("OAID#VIVO");
                hashSet.add("SM#G_ACTIVE_SUB_L");
                hashSet.add("TM#G_UICC_INFO");
                return hashSet;
            }
        });
        deviceUniqueApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HashSet<String>>() { // from class: com.tencent.qmethod.monitor.report.sample.APILevelSampleHelper$noSeriousApis$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashSet<String> invoke() {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add("AM#G_RN_A_PC");
                hashSet.add("PM#G_LAU_INT_FOR_PKG");
                hashSet.add("WM#G_CON_INFO");
                hashSet.add("NC#HAS_TRANS");
                hashSet.add("NI#G_NET_INT");
                hashSet.add("NI#G_TYPE");
                hashSet.add("NI#G_TY_NAME");
                hashSet.add("NI#G_SUB_TYPE");
                hashSet.add("TM#G_NET_TYPE");
                hashSet.add("TM#G_DA_NET_TYPE");
                hashSet.add("IA#GET_H_A");
                return hashSet;
            }
        });
        noSeriousApis = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HashSet<String>>() { // from class: com.tencent.qmethod.monitor.report.sample.APILevelSampleHelper$notSplitModuleApiList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashSet<String> invoke() {
                HashSet e16;
                HashSet f16;
                HashSet<String> hashSet = new HashSet<>();
                APILevelSampleHelper aPILevelSampleHelper = APILevelSampleHelper.f343864j;
                e16 = aPILevelSampleHelper.e();
                hashSet.addAll(e16);
                f16 = aPILevelSampleHelper.f();
                hashSet.addAll(f16);
                hashSet.add("BU#MODEL");
                return hashSet;
            }
        });
        notSplitModuleApiList = lazy3;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("WI#G_BSSID", "WI#G_SSID", "WM#G_CON_NET");
        HighList = arrayListOf;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf("SE#G_AID", "BU#MODEL", "WI#G_MA_ADDR", "NI#G_HW_ADDR", "TM#G_SID", "TM#G_DID");
        MiddleList = arrayListOf2;
        arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf("WM#G_CON_INFO", "PM#G_PKG_INFO_N", "AM#G_RN_A_PC", "NI#G_TYPE", "NI#G_NET_INT", "TM#G_SIM_OP", "NI#G_TY_NAME", "NI#G_SUB_TYPE", "TM#G_NET_TYPE", "TM#G_NWK_OP", "WI#G_IP_ADDR", "NC#HAS_TRANS", "PM#G_LAU_INT_FOR_PKG", "WM#G_D_INFO", "PM#QUERY_INT_ACT", "PM#QUERY_INT_SERV", "NI#G_INET_ADDR", "NI#G_IF_ADDR");
        LowList = arrayListOf3;
        arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf("PM#G_PKG_INFO_N", "TM#G_NWK_OP", "WI#G_BSSID", "WM#G_CON_INFO", "NI#G_NET_INT", "WI#G_IP_ADDR", "WI#G_SSID", "NI#G_TYPE");
        TripleSampleList = arrayListOf4;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"cache_only", QQPermissionConstants.Permission.STORAGE_GROUP, "memory"});
        cacheStrategy = listOf;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Boolean>() { // from class: com.tencent.qmethod.monitor.report.sample.APILevelSampleHelper$tripleSampleClose$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                Object valueOf;
                long b16 = f.b("tri_sample");
                if (b16 == 0) {
                    f.f("tri_sample", SampleHelper.z(SampleHelper.f343779l, 0.1d, 0, 0, 6, null) ? 1L : 2L);
                    valueOf = Unit.INSTANCE;
                } else {
                    valueOf = Long.valueOf(b16);
                }
                return Intrinsics.areEqual(valueOf, (Object) 2L);
            }
        });
        tripleSampleClose = lazy4;
    }

    APILevelSampleHelper() {
    }

    private final APIType d(String api) {
        if (HighList.contains(api)) {
            return APIType.HIGH;
        }
        if (MiddleList.contains(api)) {
            return APIType.MIDDLE;
        }
        if (LowList.contains(api)) {
            return APIType.LOW;
        }
        return APIType.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet<String> e() {
        return (HashSet) deviceUniqueApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet<String> f() {
        return (HashSet) noSeriousApis.getValue();
    }

    private final HashSet<String> g() {
        return (HashSet) notSplitModuleApiList.getValue();
    }

    private final boolean h() {
        return ((Boolean) tripleSampleClose.getValue()).booleanValue();
    }

    private final boolean i(String scene, String module, String api, String strategy) {
        if (Intrinsics.areEqual(scene, "silence") || Intrinsics.areEqual(scene, "illegal_scene") || Intrinsics.areEqual(strategy, "ban")) {
            return true;
        }
        if (Intrinsics.areEqual(scene, "back") && cacheStrategy.contains(strategy)) {
            return true;
        }
        return false;
    }

    private final boolean j(String apiName) {
        boolean contains;
        contains = CollectionsKt___CollectionsKt.contains(e(), apiName);
        return contains;
    }

    private final boolean l(String apiName) {
        boolean contains;
        contains = CollectionsKt___CollectionsKt.contains(f(), apiName);
        return !contains;
    }

    private final boolean n(String scene, String module, String api, String strategy) {
        if (Intrinsics.areEqual(scene, "before") && Intrinsics.areEqual(strategy, "normal")) {
            return false;
        }
        return true;
    }

    private final boolean o(String scene, String module, String api, String strategy) {
        if (Intrinsics.areEqual(scene, "silence") || Intrinsics.areEqual(scene, "illegal_scene") || Intrinsics.areEqual(strategy, "ban")) {
            return true;
        }
        if ((!Intrinsics.areEqual(scene, "before")) && cacheStrategy.contains(strategy)) {
            return true;
        }
        return false;
    }

    public final double c(@NotNull String scene, @NotNull String module, @NotNull String api, @NotNull String strategy) {
        boolean i3;
        double d16;
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(api, "api");
        Intrinsics.checkParameterIsNotNull(strategy, "strategy");
        int i16 = a.f343865a[d(api).ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    i3 = false;
                } else {
                    i3 = n(scene, module, api, strategy);
                }
            } else {
                i3 = o(scene, module, api, strategy);
            }
        } else {
            i3 = i(scene, module, api, strategy);
        }
        if (i3) {
            if (TripleSampleList.contains(api) && h()) {
                if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                    o.a("APILevelSampleHelper", "TripleSampleList=" + api + ",  scene=" + scene + ", strategy=" + strategy);
                    return 0.0d;
                }
                return 0.0d;
            }
            e eVar = ConfigManager.f343549h.p().g().get("secondary_sample");
            if (eVar != null) {
                d16 = eVar.getRate();
            } else {
                d16 = 0.5d;
            }
            if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                o.a("APILevelSampleHelper", "changeNormalAPIRate=" + api + ", rate=" + d16 + ", scene=" + scene + ", strategy=" + strategy);
            }
            return d16;
        }
        return 1.0d;
    }

    public final boolean k(@NotNull String api) {
        Intrinsics.checkParameterIsNotNull(api, "api");
        return g().contains(api);
    }

    public final boolean m(@NotNull u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        if (Intrinsics.areEqual(reportStrategy.f343968e, "ban")) {
            return false;
        }
        if (Intrinsics.areEqual(reportStrategy.f343968e, "normal") || reportStrategy.f343969f) {
            if (Intrinsics.areEqual(reportStrategy.f343967d, "before")) {
                return true;
            }
            if ((Intrinsics.areEqual(reportStrategy.f343967d, "back") || Intrinsics.areEqual(reportStrategy.f343967d, "high_freq") || Intrinsics.areEqual(reportStrategy.f343967d, "silence")) && l(reportStrategy.f343965b)) {
                return true;
            }
        }
        if (x.B(reportStrategy.f343968e) && !reportStrategy.f343969f) {
            if (Intrinsics.areEqual(reportStrategy.f343968e, "before") && l(reportStrategy.f343965b)) {
                return true;
            }
            if (Intrinsics.areEqual(reportStrategy.f343968e, "high_freq") && j(reportStrategy.f343965b)) {
                return true;
            }
        }
        return false;
    }
}
