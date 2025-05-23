package com.tencent.mobileqq.zootopia.ueloading.report;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.ZootopiaLoadingErrMod;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.ipc.an;
import com.tencent.mobileqq.zootopia.ipc.f;
import com.tencent.mobileqq.zootopia.l;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import id3.d;
import java.util.HashMap;
import java.util.LinkedHashMap;
import k74.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001\rB\u001b\u0012\b\u00100\u001a\u0004\u0018\u00010,\u0012\b\u00104\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b=\u0010>J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000f\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0010\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0012\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\"\u0010\u0019\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017JF\u0010 \u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011J\u001a\u0010#\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020\u0002J<\u0010)\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010(\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0002J\u0018\u0010+\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010*\u001a\u00020\u0015R\u0019\u00100\u001a\u0004\u0018\u00010,8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u0019\u00104\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010<\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010:\u001a\u0004\b6\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/report/ZPlanUEReportHelper;", "", "", "loadingId", "Lcom/tencent/mobileqq/zootopia/ueloading/report/a;", "b", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/zootopia/view/ZPlanBaseSceneLoadingView;", "view", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "params", "", "a", h.F, "g", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zootopia/l;", "progressRecord", "i", "j", "", "stepCostTime", "", "needDownloadHotPatch", "k", "isSuccess", "isHotPatchEnable", "hasRealDownloaded", "", "errCode", "errMsg", "l", "o", "fromSource", "f", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/zootopia/ZootopiaLoadingErrMod;", "mod", "reportMod", "e", "firstFrameToCurrentCost", "d", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "getEnterParams", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lid3/d;", "c", "Lid3/d;", "dtReportHelper", "Lec3/d;", "Lkotlin/Lazy;", "()Lec3/d;", "reportHelper", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUEReportHelper {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaEnterParams enterParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final d dtReportHelper = new d(null, 1, null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy reportHelper;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/report/ZPlanUEReportHelper$a;", "", "Lcom/tencent/mobileqq/zootopia/ueloading/report/a;", "data", "Ljava/util/HashMap;", "", "b", "", "c", "d", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUEReportHelper$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final HashMap<String, Object> b(ZPlanUEReportData data) {
            String str;
            HashMap<String, Object> k3 = data.k();
            try {
                if (((f) i.INSTANCE.a(f.class)).isFloat()) {
                    str = "1";
                } else {
                    str = "0";
                }
                k3.put("zplan_is_floating", str);
            } catch (Exception e16) {
                QLog.e("ZPlanUeReportHelper", 1, "getReportBaseParam exception :: ", e16);
            }
            k3.put("zplan_is_coldstart", Integer.valueOf(!(((com.tencent.mobileqq.zootopia.ipc.d) i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.d.class)).isModRunning(data.getMapId()) != null ? r6.booleanValue() : 0)));
            k3.put("zplan_is_cloud_mod", 0);
            return k3;
        }

        public final void c(ZPlanUEReportData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            new d(null, 1, null).d("ev_zplan_mod_startup_begin", b(data));
        }

        public final void d(ZPlanUEReportData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            HashMap<String, Object> b16 = b(data);
            b16.put("zplan_startup_lvtm", String.valueOf(System.currentTimeMillis() - data.getStartTime()));
            new d(null, 1, null).d("ev_zplan_mod_startup_complete", b16);
        }

        Companion() {
        }
    }

    public ZPlanUEReportHelper(ZootopiaSource zootopiaSource, ZootopiaEnterParams zootopiaEnterParams) {
        Lazy lazy;
        this.source = zootopiaSource;
        this.enterParams = zootopiaEnterParams;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ec3.d>() { // from class: com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUEReportHelper$reportHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ec3.d invoke() {
                return new ec3.d();
            }
        });
        this.reportHelper = lazy;
    }

    private final ZPlanUEReportData b(String loadingId) {
        ZPlanUEReportData zPlanUEReportData = new ZPlanUEReportData(null, 0, null, null, null, 0, null, 0L, 255, null);
        if (loadingId == null) {
            loadingId = "";
        }
        zPlanUEReportData.g(loadingId);
        ZootopiaSource zootopiaSource = this.source;
        if (zootopiaSource != null) {
            zPlanUEReportData.j(zootopiaSource);
        }
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams != null) {
            zPlanUEReportData.h(zootopiaEnterParams.getMapId());
            zPlanUEReportData.i(zootopiaEnterParams.getVersion());
            zPlanUEReportData.f(zootopiaEnterParams.getSource());
        }
        return zPlanUEReportData;
    }

    private final ec3.d c() {
        return (ec3.d) this.reportHelper.getValue();
    }

    public final void d(l progressRecord, long firstFrameToCurrentCost) {
        HashMap b16 = INSTANCE.b(b(progressRecord != null ? progressRecord.getLoadingId() : null));
        b16.put("zplan_loading_lvtm", Long.valueOf(firstFrameToCurrentCost));
        this.dtReportHelper.d("ev_zplan_mod_loading_complete", b16);
        ic3.a aVar = (ic3.a) i.INSTANCE.a(ic3.a.class);
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        aVar.modLoadFinish(zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0);
        an anVar = an.f328351a;
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        anVar.a(zootopiaEnterParams2 != null ? zootopiaEnterParams2.getMapId() : 0);
    }

    public final void e(int errorCode, String errorMsg, ZootopiaLoadingErrMod mod, l progressRecord, boolean reportMod, String fromSource) {
        ZootopiaEnterParams zootopiaEnterParams;
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(mod, "mod");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        if (reportMod && (zootopiaEnterParams = this.enterParams) != null) {
            kd3.a.f412063b.f(errorCode, errorMsg, zootopiaEnterParams);
            c().f(zootopiaEnterParams, ag.f373258a.d(this.source), errorCode, errorMsg, fromSource);
        }
        HashMap b16 = INSTANCE.b(b(progressRecord != null ? progressRecord.getLoadingId() : null));
        b16.put("zplan_errorcode", String.valueOf(errorCode));
        b16.put("zplan_errormsg", errorMsg);
        if (mod == ZootopiaLoadingErrMod.ENGINE) {
            b16.put("zplan_is_ue", 1);
            b16.put("zplan_loading_lvtm", Long.valueOf(System.currentTimeMillis() - (progressRecord != null ? progressRecord.getEnterAvatarSceneStartTime() : 0L)));
        } else {
            b16.put("zplan_is_ue", 0);
            b16.put("zplan_loading_lvtm", Long.valueOf(System.currentTimeMillis() - (progressRecord != null ? progressRecord.getLoadingStartTime() : 0L)));
        }
        this.dtReportHelper.d("ev_zplan_mod_loading_fail", b16);
        QLog.d("ZPlanUeReportHelper", 1, "reportLoadingFail param:" + b16);
    }

    public final void f(l progressRecord, String fromSource) {
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams != null) {
            c().g(zootopiaEnterParams, ag.f373258a.d(this.source), fromSource);
        }
        if (progressRecord != null && progressRecord.getLoadingSucceedTime() < 0) {
            progressRecord.l(System.currentTimeMillis());
            HashMap b16 = INSTANCE.b(b(progressRecord.getLoadingId()));
            b16.put("zplan_is_ue", 1);
            b16.put("zplan_loading_lvtm", Long.valueOf(progressRecord.getLoadingSucceedTime() - progressRecord.getEnterAvatarSceneStartTime()));
            b16.put("zplan_need_hotfix", Integer.valueOf(progressRecord.getNeedHotFix()));
            QLog.i("ZPlanUeReportHelper", 1, "reportLoadingSuccess param:" + b16);
            this.dtReportHelper.d("ev_zplan_mod_loading_success", b16);
            return;
        }
        QLog.i("ZPlanUeReportHelper", 1, "reportLoadingSuccess loadingSucceedTime already done");
    }

    public final void i(l progressRecord) {
        Intrinsics.checkNotNullParameter(progressRecord, "progressRecord");
        this.dtReportHelper.d("ev_zplan_mod_loading_begin", INSTANCE.b(b(progressRecord.getLoadingId())));
    }

    public final void j(l progressRecord) {
        HashMap b16 = INSTANCE.b(b(progressRecord != null ? progressRecord.getLoadingId() : null));
        b16.put("zplan_loading_lvtm", Long.valueOf(System.currentTimeMillis() - (progressRecord != null ? progressRecord.getLoadingStartTime() : 0L)));
        this.dtReportHelper.d("ev_zplan_xw_check_begin", b16);
    }

    public final void k(l progressRecord, long stepCostTime, boolean needDownloadHotPatch) {
        HashMap b16 = INSTANCE.b(b(progressRecord != null ? progressRecord.getLoadingId() : null));
        b16.put("zplan_need_hotfix", Integer.valueOf(needDownloadHotPatch ? 1 : 0));
        b16.put("zplan_check_lvtm", Long.valueOf(stepCostTime));
        this.dtReportHelper.d("ev_zplan_xw_check_complete", b16);
    }

    public final void l(l progressRecord, boolean isSuccess, long stepCostTime, boolean isHotPatchEnable, boolean hasRealDownloaded, int errCode, String errMsg) {
        String str;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        HashMap b16 = INSTANCE.b(b(progressRecord != null ? progressRecord.getLoadingId() : null));
        b16.put("zplan_hotfix_enable", Integer.valueOf(isHotPatchEnable ? 1 : 0));
        b16.put("zplan_hotfix_lvtm", Long.valueOf(stepCostTime));
        if (!isSuccess) {
            b16.put("zplan_errorcode", Integer.valueOf(errCode));
            b16.put("zplan_errormsg", errMsg);
        } else {
            b16.put("zplan_need_hotfix", Integer.valueOf(hasRealDownloaded ? 1 : 0));
        }
        d dVar = this.dtReportHelper;
        if (isSuccess) {
            str = "ev_zplan_xw_hotfix_complete";
        } else {
            str = "ev_zplan_xw_hotfix_fail";
        }
        dVar.d(str, b16);
    }

    public final void n(String loadingId) {
        if (this.enterParams == null) {
            QLog.i("ZPlanUeReportHelper", 1, "reportModStartUpComplete enterParams is null!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap b16 = INSTANCE.b(b(loadingId));
        b16.put("zplan_startup_lvtm", String.valueOf(currentTimeMillis - this.enterParams.getStartTime()));
        b16.put("zplan_error_code", "0");
        this.dtReportHelper.d("ev_zplan_mod_startup_complete", b16);
    }

    public final void o(l progressRecord) {
        Intrinsics.checkNotNullParameter(progressRecord, "progressRecord");
        if (progressRecord.getNativeSucceedTime() >= 0) {
            QLog.i("ZPlanUeReportHelper", 1, "reportNativeSuccess nativeSucceedTime already done");
            return;
        }
        progressRecord.m(System.currentTimeMillis());
        HashMap b16 = INSTANCE.b(b(progressRecord.getLoadingId()));
        b16.put("zplan_is_ue", 0);
        b16.put("zplan_loading_lvtm", Long.valueOf(progressRecord.getNativeSucceedTime() - progressRecord.getLoadingStartTime()));
        b16.put("zplan_need_hotfix", Integer.valueOf(progressRecord.getNeedHotFix()));
        QLog.i("ZPlanUeReportHelper", 1, "reportNativeSuccess param:" + b16);
        this.dtReportHelper.d("ev_zplan_mod_loading_success", b16);
    }

    public final void a(ViewGroup container, ZPlanBaseSceneLoadingView view, ZootopiaEnterParams params) {
        String str;
        String name;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(view, "view");
        if (params == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pg_zplan_map_loading", Integer.valueOf(params.getMapId()));
        ZootopiaSource zootopiaSource = this.source;
        String str2 = "";
        if (zootopiaSource == null || (str = ah.b(zootopiaSource)) == null) {
            str = "";
        }
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams != null && (name = zootopiaEnterParams.getName()) != null) {
            str2 = name;
        }
        hashMap.put("zplan_map_name", str2);
        this.dtReportHelper.j(this, container, "pg_zplan_map_loading", hashMap);
        d.i(this.dtReportHelper, view, "em_zplan_map_loading_avatar", new HashMap(), false, false, null, false, false, 128, null);
    }

    public final void g(ZPlanBaseSceneLoadingView view) {
        if (view == null) {
            return;
        }
        this.dtReportHelper.c("imp_end", view, new LinkedHashMap());
    }

    public final void h(ZPlanBaseSceneLoadingView view) {
        if (view == null) {
            return;
        }
        this.dtReportHelper.c("imp", view, new LinkedHashMap());
    }
}
