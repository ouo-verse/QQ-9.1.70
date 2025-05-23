package com.tencent.qmethod.monitor.report;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.monitor.base.util.NetworkUtil;
import com.tencent.qmethod.monitor.base.util.ProcessForegroundHelper;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.pandoraex.api.b;
import com.tencent.qmethod.pandoraex.api.c;
import com.tencent.qmethod.pandoraex.api.s;
import com.tencent.qmethod.pandoraex.api.t;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.api.v;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;
import yr3.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\f\u0010\b\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\f\u0010\t\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\u0014\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a&\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0000\u001a\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0002\u00a8\u0006\u001b"}, d2 = {"Lorg/json/JSONObject;", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "j", "l", "a", "b", DomainData.DOMAIN_NAME, "k", "", "d", "", "sceneList", "lastActivity", "c", "moduleName", "apiName", "", "f", "e", "i", "name", "value", "g", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {
    private static final void a(@NotNull JSONObject jSONObject) {
        boolean z16;
        s[] b16 = com.tencent.qmethod.pandoraex.core.a.b();
        if (b16 != null) {
            if (b16.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                JSONArray jSONArray = new JSONArray();
                for (s sVar : b16) {
                    jSONArray.mo162put(sVar.a());
                }
                jSONObject.put("recentActivities", jSONArray);
            }
        }
    }

    private static final void b(@NotNull JSONObject jSONObject) {
        List<s> e16 = ProcessForegroundHelper.f343520g.e();
        if (!e16.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = e16.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(((s) it.next()).a());
            }
            jSONObject.put("recentProcesses", jSONArray);
        }
    }

    private static final String c(u uVar, Set<String> set, String str) {
        boolean z16;
        String[] strArr = uVar.f343982s;
        if (strArr != null) {
            if (strArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (String it : strArr) {
                    if (set.contains(it)) {
                        Intrinsics.checkExpressionValueIsNotNull(it, "it");
                        return it;
                    }
                }
                return "";
            }
        }
        if (!set.contains(str)) {
            return "";
        }
        return str;
    }

    private static final String d(u uVar) {
        boolean z16;
        s sVar;
        s[] sVarArr = uVar.f343981r;
        if (sVarArr == null) {
            return "";
        }
        if (sVarArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16) || (sVar = sVarArr[0]) == null) {
            return "";
        }
        String str = sVar.f343958a;
        Intrinsics.checkExpressionValueIsNotNull(str, "it.name");
        return str;
    }

    private static final Set<String> e(u uVar) {
        ArrayList arrayList = new ArrayList();
        try {
            for (b bVar : ConfigManager.f343549h.p().d()) {
                if (Intrinsics.areEqual("default_module", bVar.f343878a)) {
                    arrayList.add(bVar);
                } else if (Intrinsics.areEqual(bVar.f343878a, uVar.f343964a) && (TextUtils.isEmpty(bVar.f343879b) || Intrinsics.areEqual(bVar.f343879b, uVar.f343965b))) {
                    arrayList.add(bVar);
                }
            }
        } catch (Exception e16) {
            o.d("Reporter", "get config error", e16);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            v vVar = ((b) it.next()).f343880c.get("illegal_scene");
            if (vVar != null) {
                Set<String> set = vVar.f343997h;
                Intrinsics.checkExpressionValueIsNotNull(set, "it.illegalPage");
                linkedHashSet.addAll(set);
                Set<String> set2 = vVar.f343996g;
                Intrinsics.checkExpressionValueIsNotNull(set2, "it.legalPage");
                linkedHashSet.addAll(set2);
            }
        }
        linkedHashSet.remove("==");
        return linkedHashSet;
    }

    public static final boolean f(@NotNull String moduleName, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(moduleName, "moduleName");
        return !e(new u(moduleName, str)).isEmpty();
    }

    private static final JSONObject g(@NotNull JSONObject jSONObject, String str, String str2) throws InvalidParameterException {
        boolean z16;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            jSONObject.put(str, str2);
            return jSONObject;
        }
        throw new InvalidParameterException("\u95ee\u9898\u4e0a\u62a5\u7f3a\u5c11\u5fc5\u987b\u53c2\u6570\uff1a" + str);
    }

    @VisibleForTesting
    @NotNull
    public static final JSONObject h(@NotNull JSONObject putAttributesReportParams, @NotNull u reportStrategy) throws InvalidParameterException {
        int i3;
        Intrinsics.checkParameterIsNotNull(putAttributesReportParams, "$this$putAttributesReportParams");
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        g(putAttributesReportParams, "module", reportStrategy.f343964a);
        g(putAttributesReportParams, DTConstants.TAG.API, reportStrategy.f343965b);
        putAttributesReportParams.put("isFg", reportStrategy.f343970g ? 1 : 0);
        putAttributesReportParams.put("isAgreed", reportStrategy.f343971h ? 1 : 0);
        g(putAttributesReportParams, "scene", reportStrategy.f343967d);
        g(putAttributesReportParams, AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, reportStrategy.f343968e);
        g(putAttributesReportParams, "process", reportStrategy.f343979p);
        if ((Intrinsics.areEqual(reportStrategy.f343968e, "memory") || Intrinsics.areEqual(reportStrategy.f343968e, QQPermissionConstants.Permission.STORAGE_GROUP)) && !reportStrategy.f343969f) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        putAttributesReportParams.put("hitCache", i3);
        j(putAttributesReportParams, reportStrategy);
        putAttributesReportParams.put("cacheTime", reportStrategy.f343972i);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("silenceShreshold", reportStrategy.f343973j);
        jSONObject.put("silenceTime", reportStrategy.f343974k);
        putAttributesReportParams.put("silence", jSONObject);
        l(putAttributesReportParams, reportStrategy);
        n(putAttributesReportParams, reportStrategy);
        if (reportStrategy.C != null) {
            k(putAttributesReportParams, reportStrategy);
        }
        String str = reportStrategy.f343967d;
        Intrinsics.checkExpressionValueIsNotNull(str, "reportStrategy.scene");
        if ("back".contentEquals(str)) {
            putAttributesReportParams.put("backTime", reportStrategy.f343975l);
        }
        Object obj = reportStrategy.f343986w;
        if (obj == null) {
            obj = new JSONObject();
        }
        putAttributesReportParams.put("exInfo", obj);
        putAttributesReportParams.put("shiplyTag", reportStrategy.A);
        putAttributesReportParams.put(AdMetricTag.Report.TYPE, reportStrategy.f343984u);
        putAttributesReportParams.put("constitution", reportStrategy.f343985v ? 1 : 0);
        putAttributesReportParams.put("callTimes", reportStrategy.f343987x);
        putAttributesReportParams.put("nextAppStatus", reportStrategy.f343988y);
        putAttributesReportParams.put("nextIntervalTime", reportStrategy.f343989z);
        putAttributesReportParams.put("sdkInitTime", com.tencent.qmethod.monitor.base.util.h.f343541c.c());
        putAttributesReportParams.put("eventTimeMills", reportStrategy.f343977n);
        if (Intrinsics.areEqual(reportStrategy.f343967d, "back")) {
            a(putAttributesReportParams);
            b(putAttributesReportParams);
        }
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            o.a("Reporter", "attr=" + putAttributesReportParams);
        }
        return putAttributesReportParams;
    }

    private static final JSONObject i(@NotNull JSONObject jSONObject, u uVar) {
        JSONArray jSONArray = new JSONArray();
        List<t> list = uVar.f343980q;
        if (list != null) {
            for (t tVar : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("count", tVar.f343963c);
                jSONObject2.put("call_stack", tVar.f343962b);
                jSONArray.mo162put(jSONObject2);
            }
        }
        jSONObject.put("stacks", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        g(jSONObject3, "sdkVersion", uVar.f343978o);
        jSONObject.put("ext", jSONObject3);
        return jSONObject;
    }

    private static final void j(@NotNull JSONObject jSONObject, u uVar) {
        c cVar = uVar.f343976m;
        if (cVar != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("count", cVar.f343897b);
            jSONObject2.put("duration", cVar.f343898c);
            jSONObject2.put("actualDuration", cVar.f343899d);
            jSONObject.put("highFreq", jSONObject2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void k(@NotNull JSONObject jSONObject, u uVar) {
        int collectionSizeOrDefault;
        Object obj;
        String i3;
        List<String> list = uVar.D;
        if (list != null && !list.isEmpty()) {
            String str = list.get(0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, str);
            JSONObject jSONObject3 = new JSONObject();
            LinkedHashSet<yr3.c> linkedHashSet = uVar.C;
            Intrinsics.checkExpressionValueIsNotNull(linkedHashSet, "reportStrategy.splitModules");
            for (yr3.c it : linkedHashSet) {
                if (!it.k()) {
                    String str2 = it.f451069a;
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("backOpen", uVar.a() ? 1 : 0);
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    jSONObject4.put("bandingPages", it.a());
                    jSONObject4.put("permissionOpen", it.l(str) ? 1 : 0);
                    jSONObject3.put(str2, jSONObject4);
                }
            }
            jSONObject2.put("currentBusiness", jSONObject3);
            JSONObject jSONObject5 = new JSONObject();
            LinkedHashSet<yr3.c> linkedHashSet2 = uVar.C;
            Intrinsics.checkExpressionValueIsNotNull(linkedHashSet2, "reportStrategy.splitModules");
            for (yr3.c it5 : linkedHashSet2) {
                if (it5.k()) {
                    StringBuilder sb5 = new StringBuilder();
                    Intrinsics.checkExpressionValueIsNotNull(it5, "it");
                    sb5.append(it5.h());
                    sb5.append('#');
                    sb5.append(it5.f451069a);
                    String sb6 = sb5.toString();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("backOpen", uVar.a() ? 1 : 0);
                    jSONObject6.put("bandingPages", it5.a());
                    jSONObject6.put("permissionOpen", it5.l(str) ? 1 : 0);
                    jSONObject5.put(sb6, jSONObject6);
                }
            }
            jSONObject2.put("currentSubBusiness", jSONObject5);
            jSONObject.put("curModules", jSONObject2);
            ArrayList arrayList = new ArrayList();
            LinkedHashSet<yr3.c> linkedHashSet3 = uVar.C;
            Intrinsics.checkExpressionValueIsNotNull(linkedHashSet3, "reportStrategy.splitModules");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(linkedHashSet3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it6 = linkedHashSet3.iterator();
            while (it6.hasNext()) {
                arrayList2.add(((yr3.c) it6.next()).f451069a);
            }
            arrayList.addAll(arrayList2);
            if (arrayList.isEmpty()) {
                arrayList.add("Others");
            }
            jSONObject.put("sm_modules", new JSONArray((Collection) arrayList));
            jSONObject.put("sm_permission", str);
            String str3 = uVar.f343967d;
            if (str3 != null) {
                int hashCode = str3.hashCode();
                if (hashCode != -1392885889) {
                    if (hashCode == 3015911 && str3.equals("back")) {
                        obj = "background";
                    }
                } else if (str3.equals("before")) {
                    obj = "before";
                }
                jSONObject.put("sm_scene", obj);
                e c16 = e.c();
                Intrinsics.checkExpressionValueIsNotNull(c16, "SplitModuleGranter.getInstance()");
                i3 = c16.i();
                if (!TextUtils.isEmpty(i3)) {
                    jSONObject.put("sm_version", i3);
                }
                Object obj2 = "ban";
                if (!Intrinsics.areEqual(uVar.f343968e, "ban")) {
                    obj2 = "normal";
                }
                jSONObject.put("sm_control", obj2);
            }
            obj = com.tencent.mobileqq.msf.core.net.r.a.f248963o;
            jSONObject.put("sm_scene", obj);
            e c162 = e.c();
            Intrinsics.checkExpressionValueIsNotNull(c162, "SplitModuleGranter.getInstance()");
            i3 = c162.i();
            if (!TextUtils.isEmpty(i3)) {
            }
            Object obj22 = "ban";
            if (!Intrinsics.areEqual(uVar.f343968e, "ban")) {
            }
            jSONObject.put("sm_control", obj22);
        }
    }

    private static final void l(@NotNull JSONObject jSONObject, u uVar) {
        s[] sVarArr = uVar.f343981r;
        if (sVarArr != null) {
            JSONArray jSONArray = new JSONArray();
            for (s sVar : sVarArr) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", sVar.f343958a);
                jSONObject2.put("inTime", sVar.f343960c);
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("recentScenes", jSONArray);
        }
    }

    public static final void m(@NotNull JSONObject putReportParams, @Nullable u uVar) throws InvalidParameterException {
        Intrinsics.checkParameterIsNotNull(putReportParams, "$this$putReportParams");
        if (uVar != null) {
            NetworkUtil networkUtil = NetworkUtil.f343513c;
            String jSONObject = h(new JSONObject(), uVar).toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "JSONObject().putAttribut\u2026eportStrategy).toString()");
            putReportParams.put(ReportDataBuilder.KEY_ATTRIBUTES, networkUtil.a(jSONObject));
            String jSONObject2 = i(new JSONObject(), uVar).toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "JSONObject().putBodyRepo\u2026eportStrategy).toString()");
            putReportParams.put(ReportDataBuilder.KEY_BODY, networkUtil.a(jSONObject2));
            putReportParams.put(ReportDataBuilder.KEY_TRANSLATE_TYPE, KuiklyLaunchParams.SPLIT_MODE_LAUNCH_MODE_STANDARD);
            return;
        }
        throw new InvalidParameterException("\u95ee\u9898\u4e0a\u62a5\u6570\u636e\u4e3a\u7a7a");
    }

    private static final void n(@NotNull JSONObject jSONObject, u uVar) {
        boolean isBlank;
        Set<String> e16 = e(uVar);
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = e16.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put((String) it.next());
        }
        jSONObject.put("addRuleSencePages", jSONArray);
        String d16 = d(uVar);
        String[] strArr = uVar.f343982s;
        if (strArr != null) {
            JSONArray jSONArray2 = new JSONArray();
            for (String str : strArr) {
                if (str != null && !str.contentEquals(d16)) {
                    jSONArray2.mo162put(str);
                }
            }
            jSONObject.put("appEnterSencePages", jSONArray2);
        }
        String c16 = c(uVar, e16, d16);
        isBlank = StringsKt__StringsJVMKt.isBlank(c16);
        if (!isBlank) {
            jSONObject.put("hitSencePage", c16);
        }
    }
}
