package ph3;

import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zx4.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lph3/a;", "Lzx4/j;", "", "libName", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements j {
    @Override // zx4.j
    public boolean a(String libName) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        QLog.i("ZPlanQQCommonProxy_", 1, "loadSoByName " + libName);
        return SoLoadUtilNew.loadSoByName(BaseApplication.context, libName);
    }
}
