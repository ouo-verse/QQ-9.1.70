package k34;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lk34/g;", "Lk34/a;", "", "getItemType", "", "getItemId", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "troopUin", "e", "I", "a", "()I", "categoryId", "f", "b", "categoryName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int categoryId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String categoryName;

    public g(@NotNull String troopUin, int i3, @NotNull String categoryName) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        this.troopUin = troopUin;
        this.categoryId = i3;
        this.categoryName = categoryName;
    }

    /* renamed from: a, reason: from getter */
    public final int getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    @Override // k34.a
    @NotNull
    public String getItemId() {
        return this.troopUin + "-" + this.categoryId;
    }

    @Override // k34.a
    public int getItemType() {
        return 2;
    }
}
