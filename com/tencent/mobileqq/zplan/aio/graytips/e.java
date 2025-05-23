package com.tencent.mobileqq.zplan.aio.graytips;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.api.IZPlanAIOGrayTipApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/graytips/e;", "", "Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$GrayTipType;", "type", "", "isImp", "", "c", "", "", "f", "b", "g", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f331031a = new e();

    e() {
    }

    private final String b(IZPlanAIOGrayTipApi.GrayTipType type) {
        if (IZPlanAIOGrayTipApi.GrayTipType.SWITCH_SCENE == type) {
            return "ev_zplan_scene_linkage_gray";
        }
        return "ev_zplan_open_guide_gray";
    }

    private final void c(final IZPlanAIOGrayTipApi.GrayTipType type, final boolean isImp) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.graytips.d
            @Override // java.lang.Runnable
            public final void run() {
                e.d(IZPlanAIOGrayTipApi.GrayTipType.this, isImp);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(IZPlanAIOGrayTipApi.GrayTipType type, boolean z16) {
        Intrinsics.checkNotNullParameter(type, "$type");
        e eVar = f331031a;
        VideoReport.reportEvent(eVar.b(type), eVar.f(z16));
    }

    private final Map<String, String> f(boolean isImp) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        if (isImp) {
            str = "imp";
        } else {
            str = "click";
        }
        hashMap.put("zplan_action_type", str);
        return hashMap;
    }

    public final void e(IZPlanAIOGrayTipApi.GrayTipType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        c(type, false);
    }

    public final void g(IZPlanAIOGrayTipApi.GrayTipType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        c(type, true);
    }
}
