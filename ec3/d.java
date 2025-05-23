package ec3;

import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaGameParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J.\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u001a\u0010\u0013\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lec3/d;", "Lec3/b;", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "params", "", "source", "", "e", "fromSource", "", "g", "", "errorCode", "errorMsg", "f", "c", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tag", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String tag = "ZplanModStartReport";

    @Override // ec3.b
    /* renamed from: b, reason: from getter */
    public String getTag() {
        return this.tag;
    }

    public final void f(ZootopiaEnterParams params, String source, int errorCode, String errorMsg, String fromSource) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        Map<String, String> e16 = e(params, source);
        e16.put(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, "0");
        e16.put("k_error_code", String.valueOf(errorCode));
        e16.put("k_error_message", errorMsg);
        e16.put("k_loading_enter_source", fromSource);
        c("e_zplan_mod_loading_result", errorCode, errorMsg, e16);
    }

    public final void g(ZootopiaEnterParams params, String source, String fromSource) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        Map<String, String> e16 = e(params, source);
        e16.put(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, "1");
        e16.put("k_loading_enter_source", fromSource);
        c("e_zplan_mod_loading_result", 0, "", e16);
    }

    private final Map<String, String> e(ZootopiaEnterParams params, String source) {
        String str;
        Map<String, String> mutableMapOf;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = new Pair("k_map_id", String.valueOf(params.getMapId()));
        pairArr[1] = new Pair("k_map_name", params.getName());
        pairArr[2] = new Pair("k_pak_path", params.getPakPath());
        pairArr[3] = new Pair("k_map_version", params.getVersion());
        pairArr[4] = new Pair("k_scene_type", String.valueOf(params.getScreenType()));
        Map<String, Object> ueParams = params.getUeParams();
        if (ueParams == null || (str = ueParams.toString()) == null) {
            str = "";
        }
        pairArr[5] = new Pair("k_ue_params", str);
        pairArr[6] = new Pair("k_external_entrance", source);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (params instanceof ZootopiaGameParams) {
            ZootopiaGameParams zootopiaGameParams = (ZootopiaGameParams) params;
            mutableMapOf.put("k_script_type", zootopiaGameParams.getScriptType());
            mutableMapOf.put("k_run_script", zootopiaGameParams.getRunScript());
            mutableMapOf.put("k_game_team_params", zootopiaGameParams.getGameTeamParams());
        }
        return mutableMapOf;
    }
}
