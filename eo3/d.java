package eo3;

import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import or4.g;
import or4.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0005"}, d2 = {"", "anchorUid", "Lor4/g;", "rsp", "a", "qq-live-linkpk-ui-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {
    public static final long a(long j3, @NotNull g rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        k[] kVarArr = rsp.f423489d;
        long j16 = 0;
        if (kVarArr != null) {
            for (k kVar : kVarArr) {
                j16 = kVar.f423504a;
            }
        }
        AegisLogger.INSTANCE.i("PK_Biz|PkDataUtils", "getOtherAnchorUid left: " + j3 + ", right: " + j16);
        return j16;
    }
}
