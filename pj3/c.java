package pj3;

import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.mobileqq.zplan.utils.am;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lpj3/c;", "Ldl0/c;", "", "b", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements dl0.c {
    @Override // dl0.c
    public void a() {
        FilamentFileUtil.INSTANCE.deleteDirSafely(am.f335779a.a());
    }

    @Override // dl0.c
    public String b() {
        if (ZPlanFeatureSwitch.f369852a.c()) {
            return "/sdcard/Android/data/com.tencent.mobileqq/cache/zplan/filament";
        }
        return am.f335779a.a() + "/cache";
    }
}
