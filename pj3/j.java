package pj3;

import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.util.AppSetting;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lpj3/j;", "Ldl0/i;", "", "c", "", "a", "", "b", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j implements dl0.i {
    @Override // dl0.i
    public String a() {
        return AppSetting.getAppSubVersionName();
    }

    @Override // dl0.i
    public int b() {
        return ViewUtils.getScreenHeight();
    }

    @Override // dl0.i
    public float c() {
        return ViewUtils.mDensity;
    }

    @Override // dl0.i
    public int d() {
        return ViewUtils.getScreenWidth();
    }
}
