package kotlin;

import kotlin.internal.InlineOnly;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0087\b\u00a8\u0006\u0003"}, d2 = {"hashCode", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class HashCodeKt {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }
}
