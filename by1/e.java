package by1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lby1/e;", "Lby1/a;", "", "a", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setGroupName", "(Ljava/lang/String;)V", "groupName", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String groupName;

    public e(@NotNull String groupName) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        this.groupName = groupName;
    }

    @Override // by1.a
    public int a() {
        return 2;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }
}
