package com.tencent.mobileqq.search.util;

import androidx.annotation.MainThread;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.contact.NtBuddySearchEngine;
import com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine;
import com.tencent.mobileqq.search.business.contact.NtTroopSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.searchlocal.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.search.searchlocal.searchengine.NTSearchFunctionEngine;
import com.tencent.mobileqq.searchlocal.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0007J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0007J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0007J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0015\u001a\u00020\bH\u0002J\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0016H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0007J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J\u0016\u0010#\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010!H\u0007R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R0\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/search/util/SearchEnginePerfReporter;", "", "", "keyword", "", "from", "", "isFirstSearch", "", "u", "o", "key", "value", "g", "name", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "k", "t", "l", "w", "Lkotlin/Function0;", "task", tl.h.F, "j", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "methodName", "msg", DomainData.DOMAIN_NAME, "Lon2/b;", EnginePathProvider.ENGINE_DIR, "p", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "otherParams", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mobileqq/search/util/ax;", "Lkotlin/collections/LinkedHashMap;", "c", "Ljava/util/LinkedHashMap;", "stepCostTime", "d", "Ljava/lang/String;", "e", "Z", "isLocalEnd", "f", "isNetEnd", "hasReported", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchEnginePerfReporter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SearchEnginePerfReporter f284945a = new SearchEnginePerfReporter();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, String> otherParams = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LinkedHashMap<String, ax> stepCostTime = new LinkedHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static volatile String keyword = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isLocalEnd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isNetEnd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasReported;

    SearchEnginePerfReporter() {
    }

    @JvmStatic
    public static final void g(@NotNull String keyword2, @NotNull final String key, @NotNull final Object value) {
        Intrinsics.checkNotNullParameter(keyword2, "keyword");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        f284945a.h(keyword2, new Function0<Unit>() { // from class: com.tencent.mobileqq.search.util.SearchEnginePerfReporter$addParams$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ConcurrentHashMap concurrentHashMap;
                String obj;
                if (key.length() > 0) {
                    concurrentHashMap = SearchEnginePerfReporter.otherParams;
                    String str = key;
                    Object obj2 = value;
                    if (obj2 instanceof String) {
                        obj = (String) obj2;
                    } else if (obj2 instanceof Boolean) {
                        obj = ((Boolean) obj2).booleanValue() ? "1" : "0";
                    } else {
                        obj = obj2.toString();
                    }
                    concurrentHashMap.put(str, obj);
                }
            }
        });
    }

    private final void h(String keyword2, Function0<Unit> task) {
        boolean z16;
        if (!hasReported) {
            if (keyword.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && Intrinsics.areEqual(keyword, keyword2)) {
                task.invoke();
            }
        }
    }

    private final synchronized Map<String, String> i() {
        LinkedHashMap linkedHashMap;
        linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(otherParams);
        for (Map.Entry<String, ax> entry : stepCostTime.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            String str = key;
            ax value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "entry.value");
            ax axVar = value;
            if (axVar.getStartTime() == 0) {
                n("doReport", str + " startTime cannot be 0");
            }
            if (axVar.getEndTime() == 0) {
                n("doReport", str + " endTime cannot be 0");
            }
            linkedHashMap.put(str, String.valueOf(axVar.a()));
        }
        return linkedHashMap;
    }

    private final synchronized void j() {
        ua0.j.f(i());
        q();
    }

    @JvmStatic
    public static final void k(@NotNull final String keyword2) {
        Intrinsics.checkNotNullParameter(keyword2, "keyword");
        f284945a.h(keyword2, new Function0<Unit>() { // from class: com.tencent.mobileqq.search.util.SearchEnginePerfReporter$endLocalSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SearchEnginePerfReporter.isLocalEnd = true;
                SearchEnginePerfReporter.m(keyword2, "localCost");
                SearchEnginePerfReporter.f284945a.w();
            }
        });
    }

    @JvmStatic
    public static final void l(@NotNull final String keyword2) {
        Intrinsics.checkNotNullParameter(keyword2, "keyword");
        f284945a.h(keyword2, new Function0<Unit>() { // from class: com.tencent.mobileqq.search.util.SearchEnginePerfReporter$endNetSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SearchEnginePerfReporter.isNetEnd = true;
                SearchEnginePerfReporter.m(keyword2, "netCost");
                SearchEnginePerfReporter.f284945a.w();
            }
        });
    }

    @JvmStatic
    public static final void m(@NotNull String keyword2, @NotNull final String name) {
        Intrinsics.checkNotNullParameter(keyword2, "keyword");
        Intrinsics.checkNotNullParameter(name, "name");
        f284945a.h(keyword2, new Function0<Unit>() { // from class: com.tencent.mobileqq.search.util.SearchEnginePerfReporter$endStep$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LinkedHashMap linkedHashMap;
                if (name.length() == 0) {
                    return;
                }
                SearchEnginePerfReporter searchEnginePerfReporter = SearchEnginePerfReporter.f284945a;
                String str = name;
                synchronized (searchEnginePerfReporter) {
                    linkedHashMap = SearchEnginePerfReporter.stepCostTime;
                    ax axVar = (ax) linkedHashMap.get(str);
                    if (axVar == null) {
                        searchEnginePerfReporter.n("endStep", "step " + str + " has never started");
                    } else {
                        axVar.d(System.currentTimeMillis());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String methodName, String msg2) {
        QLog.e("SearchEnginePerfReporter", 1, new IllegalStateException("#" + methodName + MsgSummary.STR_COLON + msg2), new Object[0]);
    }

    private final void o() {
        g(keyword, "isDebugVersion", Boolean.FALSE);
        g(keyword, "isOptSwitchOn", Boolean.valueOf(y.b()));
    }

    @JvmStatic
    @NotNull
    public static final String p(@Nullable on2.b<?> engine) {
        String str;
        if (engine instanceof ContactSearchEngine) {
            str = "ContactSearchEngine";
        } else if (engine instanceof FavoriteSearchEngine) {
            str = "FavoriteSearchEngine";
        } else if (engine instanceof FileManagerSearchEngine) {
            str = "FileManagerSearchEngine";
        } else if (engine instanceof MiniProgramSearchEngine) {
            str = "MiniProgramSearchEngine";
        } else if (engine instanceof NTSearchFunctionEngine) {
            str = "NTSearchFunctionEngine";
        } else if (engine instanceof PublicAccountSearchEngine) {
            str = "PublicAccountSearchEngine";
        } else if (engine instanceof NtTroopSearchEngine) {
            str = "NtTroopSearchEngine";
        } else if (engine instanceof NtBuddySearchEngine) {
            str = "NtBuddySearchEngine";
        } else if (engine instanceof NetSearchEngine) {
            str = "NetSearchEngine";
        } else if (engine instanceof NTFtsMessageSearchEngine) {
            str = "NTFtsMessageSearchEngine";
        } else if (engine instanceof NtGroupLocalInfoSearchEngine) {
            str = "NtGroupLocalInfoSearchEngine";
        } else {
            f284945a.n("getSearchEngineName", "unknown engine: " + engine);
            str = "unknown engine ";
        }
        return str + "Cost";
    }

    private final synchronized void q() {
        boolean z16;
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : otherParams.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        QLog.d("SearchEnginePerfReporter", 1, "#logStepTime: params = " + jSONObject);
        LinkedHashMap<String, ax> linkedHashMap = stepCostTime;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, ax> entry2 : linkedHashMap.entrySet()) {
            if (entry2.getValue().getStartTime() > 0 && entry2.getValue().getEndTime() > 0 && entry2.getValue().a() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            jSONObject2.put((String) entry3.getKey(), String.valueOf(((ax) entry3.getValue()).a()));
        }
        QLog.d("SearchEnginePerfReporter", 1, "#logStepTime: costTime = " + jSONObject2);
    }

    @JvmStatic
    public static final void r() {
        hasReported = true;
        isNetEnd = false;
        isLocalEnd = false;
        keyword = "";
        otherParams.clear();
        synchronized (f284945a) {
            stepCostTime.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void s(@NotNull final String keyword2) {
        Intrinsics.checkNotNullParameter(keyword2, "keyword");
        f284945a.h(keyword2, new Function0<Unit>() { // from class: com.tencent.mobileqq.search.util.SearchEnginePerfReporter$startLocalSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SearchEnginePerfReporter.isLocalEnd = false;
                SearchEnginePerfReporter.v(keyword2, "localCost");
            }
        });
    }

    @JvmStatic
    public static final void t(@NotNull final String keyword2) {
        Intrinsics.checkNotNullParameter(keyword2, "keyword");
        f284945a.h(keyword2, new Function0<Unit>() { // from class: com.tencent.mobileqq.search.util.SearchEnginePerfReporter$startNetSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SearchEnginePerfReporter.isNetEnd = false;
                SearchEnginePerfReporter.v(keyword2, "netCost");
            }
        });
    }

    @JvmStatic
    @MainThread
    public static final void u(@NotNull String keyword2, int from, boolean isFirstSearch) {
        Intrinsics.checkNotNullParameter(keyword2, "keyword");
        r();
        if (!isFirstSearch) {
            return;
        }
        hasReported = false;
        keyword = keyword2;
        f284945a.o();
        g(keyword2, "searchFrom", Integer.valueOf(from));
        g(keyword2, "isFirstSearch", Boolean.valueOf(isFirstSearch));
        v(keyword2, VasPerfReportUtils.WHILE_COST_TOTAL);
    }

    @JvmStatic
    public static final void v(@NotNull String keyword2, @NotNull final String name) {
        Intrinsics.checkNotNullParameter(keyword2, "keyword");
        Intrinsics.checkNotNullParameter(name, "name");
        f284945a.h(keyword2, new Function0<Unit>() { // from class: com.tencent.mobileqq.search.util.SearchEnginePerfReporter$startStep$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LinkedHashMap linkedHashMap;
                LinkedHashMap linkedHashMap2;
                if (name.length() == 0) {
                    return;
                }
                SearchEnginePerfReporter searchEnginePerfReporter = SearchEnginePerfReporter.f284945a;
                String str = name;
                synchronized (searchEnginePerfReporter) {
                    linkedHashMap = SearchEnginePerfReporter.stepCostTime;
                    if (linkedHashMap.containsKey(str)) {
                        searchEnginePerfReporter.n("startStep", "step " + str + " cannot start twice");
                    }
                    linkedHashMap2 = SearchEnginePerfReporter.stepCostTime;
                    ax axVar = new ax();
                    axVar.e(System.currentTimeMillis());
                    linkedHashMap2.put(str, axVar);
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void w() {
        if (!hasReported && isNetEnd && isLocalEnd) {
            m(keyword, VasPerfReportUtils.WHILE_COST_TOTAL);
            j();
            r();
        }
    }
}
