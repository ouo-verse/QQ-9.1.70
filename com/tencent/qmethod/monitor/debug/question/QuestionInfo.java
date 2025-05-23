package com.tencent.qmethod.monitor.debug.question;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\t\u0010\u0011\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/qmethod/monitor/debug/question/a;", "", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", "", "a", h.F, "", "e", "f", "b", "c", "", "", "g", "Lorg/json/JSONObject;", "d", "toString", "hashCode", "other", "", "equals", "", "Ljava/util/List;", "reportList", "", "successReportList", "Lcom/tencent/qmethod/pandoraex/api/u;", "getReportStrategy", "()Lcom/tencent/qmethod/pandoraex/api/u;", "<init>", "(Lcom/tencent/qmethod/pandoraex/api/u;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qmethod.monitor.debug.question.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class QuestionInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<u> reportList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<Long> successReportList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final u reportStrategy;

    public QuestionInfo(@NotNull u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        this.reportStrategy = reportStrategy;
        this.reportList = new ArrayList();
        this.successReportList = new ArrayList();
        a(reportStrategy);
    }

    public final void a(@NotNull u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        this.reportList.add(reportStrategy);
    }

    public final int b() {
        String str;
        int i3 = 0;
        for (u uVar : this.reportList) {
            if (!uVar.f343969f && (str = uVar.f343968e) != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1884274053) {
                    if (hashCode != -1077756671) {
                        if (hashCode == 28936777 && str.equals("cache_only")) {
                            i3++;
                        }
                    } else if (str.equals("memory")) {
                        i3++;
                    }
                } else if (str.equals(QQPermissionConstants.Permission.STORAGE_GROUP)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public final int c() {
        Iterator<T> it = this.reportList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((u) it.next()).f343969f) {
                i3++;
            }
        }
        return i3;
    }

    @NotNull
    public final JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("module", this.reportStrategy.f343964a);
        jSONObject.put(DTConstants.TAG.API, this.reportStrategy.f343965b);
        jSONObject.put("questionCount", e());
        jSONObject.put("reportCount", f());
        jSONObject.put("callSysCount", c());
        jSONObject.put("callCacheCount", b());
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, Integer> entry : g().entrySet()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("scene", entry.getKey());
            jSONObject2.put("count", entry.getValue().intValue());
            jSONArray.mo162put(jSONObject2);
        }
        jSONObject.put("sceneCount", jSONArray);
        return jSONObject;
    }

    public final int e() {
        return this.reportList.size();
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof QuestionInfo) || !Intrinsics.areEqual(this.reportStrategy, ((QuestionInfo) other).reportStrategy)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final int f() {
        return this.successReportList.size();
    }

    @NotNull
    public final Map<String, Integer> g() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (u uVar : this.reportList) {
            String str = uVar.f343967d;
            Intrinsics.checkExpressionValueIsNotNull(str, "it.scene");
            Object obj = linkedHashMap.get(str);
            if (obj == null) {
                obj = 0;
                linkedHashMap.put(str, obj);
            }
            int intValue = ((Number) obj).intValue();
            String str2 = uVar.f343967d;
            Intrinsics.checkExpressionValueIsNotNull(str2, "it.scene");
            linkedHashMap.put(str2, Integer.valueOf(intValue + 1));
        }
        return linkedHashMap;
    }

    public final void h(@NotNull u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        this.successReportList.add(Long.valueOf(reportStrategy.f343977n));
    }

    public int hashCode() {
        u uVar = this.reportStrategy;
        if (uVar != null) {
            return uVar.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "QuestionInfo(reportStrategy=" + this.reportStrategy + ")";
    }
}
