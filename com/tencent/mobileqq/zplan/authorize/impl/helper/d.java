package com.tencent.mobileqq.zplan.authorize.impl.helper;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zplan.authorize.api.CheckResult;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.api.ModChekerParams;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.JD\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002JD\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J4\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J<\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J&\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001bJ\u001e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J&\u0010 \u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001bJ\u001e\u0010!\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017J\u001e\u0010#\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0004J.\u0010$\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bJ&\u0010%\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010'\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010(\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010)\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010+\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020*J\u001e\u0010,\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/helper/d;", "", "", "modId", "", "modName", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "skipRedirect", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "result", "b", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "a", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "sceneType", "d", "Lcom/tencent/mobileqq/zplan/authorize/api/ModChekerParams;", "params", "", "j", "", QCircleWeakNetReporter.KEY_COST, h.F, "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "l", "fromSource", "p", DomainData.DOMAIN_NAME, "o", "g", "e", "f", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/zplan/authorize/api/CheckResult;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f331487a = new d();

    d() {
    }

    private final HashMap<String, String> a(ZootopiaEnterParams enterParams, ZootopiaSource source) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("k_mod_id", String.valueOf(enterParams.getMapId()));
        hashMap.put("k_scene_type", enterParams.getName());
        hashMap.put("k_source", source.getMainSource().name());
        return hashMap;
    }

    private final HashMap<String, String> b(int modId, EnterModCheckResult result, ZootopiaSource source, boolean skipRedirect) {
        String str;
        ZootopiaEnterParams enterParamsAfterCheck = result.getEnterParamsAfterCheck();
        if (enterParamsAfterCheck == null || (str = enterParamsAfterCheck.getName()) == null) {
            str = "";
        }
        HashMap<String, String> c16 = c(modId, str, source, skipRedirect);
        c16.put("k_result_code", String.valueOf(result.getResultCode()));
        return c16;
    }

    private final HashMap<String, String> c(int modId, String modName, ZootopiaSource source, boolean skipRedirect) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("k_mod_id", String.valueOf(modId));
        hashMap.put("k_mod_name", modName);
        hashMap.put("k_source", source.getMainSource().name());
        if (skipRedirect) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("k_skip_redirect", str);
        return hashMap;
    }

    private final HashMap<String, String> d(int sceneId, CheckPhoneManager.EntryType sceneType, ZootopiaSource source) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("k_scene_id", String.valueOf(sceneId));
        hashMap.put("k_scene_type", sceneType.name());
        hashMap.put("k_source", source.getMainSource().name());
        return hashMap;
    }

    public final void e(ZootopiaEnterParams enterParams, ZootopiaSource source, EnterModCheckResult result) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(result, "result");
        HashMap<String, String> a16 = a(enterParams, source);
        a16.put("k_result_code", String.valueOf(result.getResultCode()));
        a16.put("k_cloud_server_status", String.valueOf(result.getCloudServerStatus()));
        mb4.c.c(mb4.c.f416532a, "e_zplan_cloud_mod_enter_check_complete", a16, false, 4, null);
    }

    public final void f(ZootopiaEnterParams enterParams, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(source, "source");
        mb4.c.c(mb4.c.f416532a, "e_zplan_cloud_mod_enter_check_interceptor", a(enterParams, source), false, 4, null);
    }

    public final void g(ZootopiaEnterParams enterParams, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(source, "source");
        mb4.c.c(mb4.c.f416532a, "e_zplan_cloud_mod_enter_check_start", a(enterParams, source), false, 4, null);
    }

    public final void h(int modId, EnterModCheckResult result, ModChekerParams params, long cost) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(params, "params");
        HashMap<String, String> b16 = b(modId, result, params.getSource(), params.getSkipRedirect());
        b16.put("k_cost_time", String.valueOf(cost));
        b16.put("k_loading_enter_source", params.getFromSource());
        mb4.c.c(mb4.c.f416532a, "e_zplan_mod_enter_check_complete", b16, false, 4, null);
    }

    public final void i(int modId, EnterModCheckResult result, ModChekerParams params) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(params, "params");
        HashMap<String, String> b16 = b(modId, result, params.getSource(), params.getSkipRedirect());
        b16.put("k_loading_enter_source", params.getFromSource());
        mb4.c.c(mb4.c.f416532a, "e_zplan_mod_enter_check_interceptor", b16, false, 4, null);
    }

    public final void j(int modId, ModChekerParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        HashMap<String, String> c16 = c(modId, "", params.getSource(), params.getSkipRedirect());
        c16.put("k_loading_enter_source", params.getFromSource());
        mb4.c.c(mb4.c.f416532a, "e_zplan_mod_enter_check_start", c16, false, 4, null);
    }

    public final void k(int modId, EnterModCheckResult result, ModChekerParams params, long cost) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(params, "params");
        HashMap<String, String> b16 = b(modId, result, params.getSource(), params.getSkipRedirect());
        b16.put("k_cost_time", String.valueOf(cost));
        b16.put("k_loading_enter_source", params.getFromSource());
        mb4.c.c(mb4.c.f416532a, "e_zplan_mod_enter_native_check_complete", b16, false, 4, null);
    }

    public final void l(int modId, EnterModCheckResult result, ModChekerParams params) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(params, "params");
        HashMap<String, String> b16 = b(modId, result, params.getSource(), params.getSkipRedirect());
        b16.put("k_loading_enter_source", params.getFromSource());
        mb4.c.c(mb4.c.f416532a, "e_zplan_mod_enter_native_check_interceptor", b16, false, 4, null);
    }

    public final void m(int modId, ModChekerParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        HashMap<String, String> c16 = c(modId, "", params.getSource(), params.getSkipRedirect());
        c16.put("k_loading_enter_source", params.getFromSource());
        mb4.c.c(mb4.c.f416532a, "e_zplan_mod_enter_native_check_start", c16, false, 4, null);
    }

    public final void n(int modId, EnterModCheckResult result, ZootopiaSource source, String fromSource, long cost) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        HashMap<String, String> b16 = b(modId, result, source, false);
        b16.put("k_cost_time", String.valueOf(cost));
        b16.put("k_loading_enter_source", fromSource);
        mb4.c.c(mb4.c.f416532a, "e_zplan_mod_enter_server_check_complete", b16, false, 4, null);
    }

    public final void o(int modId, EnterModCheckResult result, ZootopiaSource source, String fromSource) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        HashMap<String, String> b16 = b(modId, result, source, false);
        b16.put("k_loading_enter_source", fromSource);
        mb4.c.c(mb4.c.f416532a, "e_zplan_mod_enter_server_check_interceptor", b16, false, 4, null);
    }

    public final void p(int modId, ZootopiaSource source, String fromSource) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        HashMap<String, String> c16 = c(modId, "", source, false);
        c16.put("k_loading_enter_source", fromSource);
        mb4.c.c(mb4.c.f416532a, "e_zplan_mod_enter_server_check_start", c16, false, 4, null);
    }

    public final void q(int sceneId, CheckPhoneManager.EntryType sceneType, ZootopiaSource source, CheckResult result) {
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(result, "result");
        HashMap<String, String> d16 = d(sceneId, sceneType, source);
        d16.put("k_result_code", String.valueOf(result.getResultCode()));
        mb4.c.c(mb4.c.f416532a, "e_zplan_scene_enter_check_complete", d16, false, 4, null);
    }

    public final void r(int sceneId, CheckPhoneManager.EntryType sceneType, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        Intrinsics.checkNotNullParameter(source, "source");
        mb4.c.c(mb4.c.f416532a, "e_zplan_scene_enter_check_interceptor", d(sceneId, sceneType, source), false, 4, null);
    }

    public final void s(int sceneId, CheckPhoneManager.EntryType sceneType, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        Intrinsics.checkNotNullParameter(source, "source");
        mb4.c.c(mb4.c.f416532a, "e_zplan_scene_enter_check_start", d(sceneId, sceneType, source), false, 4, null);
    }
}
