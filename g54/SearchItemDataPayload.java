package g54;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lg54/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getCallbackData", "()Ljava/lang/String;", "callbackData", "<init>", "(Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: g54.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SearchItemDataPayload {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String callbackData;

    public SearchItemDataPayload(@NotNull String callbackData) {
        Intrinsics.checkNotNullParameter(callbackData, "callbackData");
        this.callbackData = callbackData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SearchItemDataPayload) && Intrinsics.areEqual(this.callbackData, ((SearchItemDataPayload) other).callbackData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.callbackData.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchItemDataPayload(callbackData=" + this.callbackData + ")";
    }
}
