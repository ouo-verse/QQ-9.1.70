package ie4;

import com.tencent.tavcut.composition.model.component.TimeStretchMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "", "a", "lib_tavcut_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class c {
    public static final int a(@NotNull TimeStretchMode toPagTimeStretchMode) {
        Intrinsics.checkParameterIsNotNull(toPagTimeStretchMode, "$this$toPagTimeStretchMode");
        int i3 = b.f407565a[toPagTimeStretchMode.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 2) {
            return 2;
        }
        return 0;
    }
}
