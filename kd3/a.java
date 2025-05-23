package kd3;

import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zplan.event.api.Event;
import id3.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lkd3/a;", "Lid3/b;", "", "errorCode", "", "errorMsg", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "modParams", "", "d", "e", "f", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f412063b = new a();

    a() {
    }

    public final void d(int errorCode, String errorMsg, ZootopiaEnterParams modParams) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(modParams, "modParams");
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", String.valueOf(modParams.getMapId()));
        hashMap.put("k_enter_params", modParams.toJsonString());
        b(new Event("e_zplan_base_mod_info_check_error", 0, errorCode, errorMsg, hashMap, 2, null));
    }

    public final void e(int errorCode, String errorMsg, ZootopiaEnterParams modParams) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(modParams, "modParams");
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", String.valueOf(modParams.getMapId()));
        hashMap.put("k_enter_params", modParams.toJsonString());
        b(new Event("e_zplan_mod_hot_patch_check_error", 0, errorCode, errorMsg, hashMap, 2, null));
    }

    public final void f(int errorCode, String errorMsg, ZootopiaEnterParams modParams) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(modParams, "modParams");
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", String.valueOf(modParams.getMapId()));
        hashMap.put("k_enter_params", modParams.toJsonString());
        b(new Event("e_zplan_mod_loading_error", 0, errorCode, errorMsg, hashMap, 2, null));
    }
}
