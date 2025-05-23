package bc3;

import ck3.ZPlanModReqInfo;
import com.tencent.mobileqq.zootopia.utils.m;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.state.report.SquareReportConst;
import ec3.b;
import id3.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ<\u0010\u000b\u001a\u00020\n2\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJF\u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bJH\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lbc3/a;", "Lec3/b;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "Lck3/b;", "modInfo", "", "isPreDownload", "", "e", "i", "isSuccess", "", "errCode", "errMsg", "", "totalCostTime", "hasRealChecked", "hasRealDownloaded", h.F, "isFinish", "f", "Lid3/d;", "c", "Lid3/d;", "bizDtReporter", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final d bizDtReporter = new d(null, 1, null);

    private final void e(HashMap<String, String> params, ZPlanModReqInfo modInfo, boolean isPreDownload) {
        params.put("k_mod_map_id", modInfo.getModId());
        params.put("k_mod_version", modInfo.getModLocalVersion());
        params.put("k_mod_pack_type", String.valueOf(modInfo.getModPackType()));
        params.put("k_is_predownload", String.valueOf(isPreDownload));
        params.put("k_net_type", m.f329564a.b());
    }

    public final void f(ZPlanModReqInfo modInfo, boolean isPreDownload, boolean isFinish, boolean isSuccess, int errCode, String errMsg, long totalCostTime) {
        Map<String, Object> mutableMapOf;
        String str;
        Intrinsics.checkNotNullParameter(modInfo, "modInfo");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        ag agVar = ag.f373258a;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, agVar.d(agVar.b())), new Pair("zplan_download_type", "3"), new Pair("zplan_map_id", modInfo.getModId()), new Pair("zplan_mod_version", modInfo.getModLocalVersion()), new Pair("zplan_is_silence", Integer.valueOf(isPreDownload ? 1 : 0)));
        if (isFinish) {
            mutableMapOf.put("zplan_error_code", Integer.valueOf(errCode));
            mutableMapOf.put("subErrCode", errMsg);
            mutableMapOf.put("zplan_download_lvtm", Long.valueOf(totalCostTime));
        }
        if (!isFinish) {
            str = "ev_zplan_mod_download_begin";
        } else if (isSuccess) {
            str = "ev_zplan_mod_download_success";
        } else {
            str = "ev_zplan_mod_download_fail";
        }
        this.bizDtReporter.d(str, mutableMapOf);
    }

    public final void i(ZPlanModReqInfo modInfo, boolean isPreDownload) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(modInfo, "modInfo");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_errcode", String.valueOf(0)));
        e(hashMapOf, modInfo, isPreDownload);
        c("e_zplan_mod_hot_patch_check_start", 0, "", hashMapOf);
    }

    public final void h(boolean isSuccess, int errCode, String errMsg, ZPlanModReqInfo modInfo, boolean isPreDownload, long totalCostTime, boolean hasRealChecked, boolean hasRealDownloaded) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(modInfo, "modInfo");
        int i3 = isSuccess ? 0 : errCode;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_errcode", String.valueOf(i3)), TuplesKt.to("k_cost_time", String.valueOf(totalCostTime)));
        e(hashMapOf, modInfo, isPreDownload);
        c("e_zplan_mod_hot_patch_check_finish", i3, errMsg, hashMapOf);
        if (hasRealDownloaded) {
            f(modInfo, isPreDownload, true, isSuccess, i3, errMsg, totalCostTime);
        }
    }
}
