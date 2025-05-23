package n34;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Ln34/b;", "", "Lk34/c;", "oldItem", "newItem", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f418124a = new b();

    b() {
    }

    public final boolean a(@NotNull k34.c oldItem, @NotNull k34.c newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (Intrinsics.areEqual(oldItem.getRobotBase().robotAvatar, newItem.getRobotBase().robotAvatar) && Intrinsics.areEqual(oldItem.getRobotBase().robotName, newItem.getRobotBase().robotName) && Intrinsics.areEqual(oldItem.getRobotBase().robotDesc, newItem.getRobotBase().robotDesc) && oldItem.getRobotBase().robotUin == newItem.getRobotBase().robotUin) {
            return true;
        }
        return false;
    }
}
