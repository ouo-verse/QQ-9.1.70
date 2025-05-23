package pl2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"Lpl2/k;", "", "Lpl2/g;", "a", "qqpay-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class l {
    @Nullable
    public static final g a(@NotNull k<byte[]> kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        if (kVar instanceof i) {
            return ((i) kVar).getAbility();
        }
        if (kVar instanceof g) {
            return (g) kVar;
        }
        return null;
    }
}
