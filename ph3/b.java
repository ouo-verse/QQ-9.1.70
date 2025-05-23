package ph3;

import com.tencent.qphone.base.util.QLog;
import k74.i;
import kotlin.Metadata;
import zx4.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lph3/b;", "Lzx4/k;", "", "appForeground", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements k {
    @Override // com.epicgames.ue4.IUEAppStatus
    public boolean appForeground() {
        boolean z16;
        try {
            z16 = ((we3.a) i.INSTANCE.a(we3.a.class)).appForeground();
        } catch (Throwable th5) {
            QLog.w("ZPlanQQStatusProxy_", 1, "appForeground error,", th5);
            z16 = false;
        }
        QLog.i("ZPlanQQStatusProxy_", 1, "appForeground:" + z16);
        return z16;
    }
}
