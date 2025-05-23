package e74;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\r\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Le74/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "buttonName", "b", "getType", "type", "", "Le74/c;", "c", "Ljava/util/List;", "()Ljava/util/List;", "requireData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e74.e, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RequireList {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String buttonName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<RequireData> requireData;

    public RequireList(@NotNull String buttonName, @NotNull String type, @Nullable List<RequireData> list) {
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        Intrinsics.checkNotNullParameter(type, "type");
        this.buttonName = buttonName;
        this.type = type;
        this.requireData = list;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getButtonName() {
        return this.buttonName;
    }

    @Nullable
    public final List<RequireData> b() {
        return this.requireData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequireList)) {
            return false;
        }
        RequireList requireList = (RequireList) other;
        if (Intrinsics.areEqual(this.buttonName, requireList.buttonName) && Intrinsics.areEqual(this.type, requireList.type) && Intrinsics.areEqual(this.requireData, requireList.requireData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.buttonName.hashCode() * 31) + this.type.hashCode()) * 31;
        List<RequireData> list = this.requireData;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "RequireList(buttonName=" + this.buttonName + ", type=" + this.type + ", requireData=" + this.requireData + ")";
    }
}
