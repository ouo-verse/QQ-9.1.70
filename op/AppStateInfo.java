package op;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R3\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lop/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "extraInfo", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "c", "I", "()I", "state", "<init>", "(Ljava/lang/String;I)V", "fg_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: op.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AppStateInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final HashMap<String, String> extraInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int state;

    public AppStateInfo() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final HashMap<String, String> a() {
        return this.extraInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: c, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof AppStateInfo) {
                AppStateInfo appStateInfo = (AppStateInfo) other;
                if (!Intrinsics.areEqual(this.name, appStateInfo.name) || this.state != appStateInfo.state) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        String str = this.name;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return (i3 * 31) + this.state;
    }

    @NotNull
    public String toString() {
        return "AppStateInfo(name='" + this.name + "', state=" + this.state + ", extraInfo=" + this.extraInfo + ')';
    }

    public AppStateInfo(@NotNull String name, int i3) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.name = name;
        this.state = i3;
        this.extraInfo = new HashMap<>();
    }

    public /* synthetic */ AppStateInfo(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "unknown" : str, (i16 & 2) != 0 ? 0 : i3);
    }
}
