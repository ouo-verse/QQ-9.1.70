package bi3;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0005\u001a \u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002\u00a8\u0006\u0005"}, d2 = {"", "progress", "curPhase", "totalPhase", "b", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(int i3, int i16, int i17) {
        if (i17 == 0) {
            QLog.e("ZPlanHotPatchProgressViewHelper:calculateTotalProgress", 1, "ZPlanHotPatchProgress totalPhase deserialize to 0 unexpectedly.");
            return 0;
        }
        return ((i16 * 100) + i3) / i17;
    }
}
