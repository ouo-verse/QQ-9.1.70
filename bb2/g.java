package bb2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"Lbb2/f;", "", "a", "d", "b", "e", "c", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g {
    public static final boolean a(@NotNull SortCluster sortCluster) {
        Intrinsics.checkNotNullParameter(sortCluster, "<this>");
        return sortCluster.getCenterInfo() instanceof eb2.a;
    }

    public static final boolean b(@NotNull SortCluster sortCluster) {
        Intrinsics.checkNotNullParameter(sortCluster, "<this>");
        if ((sortCluster.getCenterInfo() instanceof gb2.c) && sortCluster.g().size() > 1) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull SortCluster sortCluster) {
        Intrinsics.checkNotNullParameter(sortCluster, "<this>");
        if ((sortCluster.getCenterInfo() instanceof hb2.b) && sortCluster.g().size() > 1) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull SortCluster sortCluster) {
        Intrinsics.checkNotNullParameter(sortCluster, "<this>");
        if ((sortCluster.getCenterInfo() instanceof gb2.c) && sortCluster.g().size() <= 1) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull SortCluster sortCluster) {
        Intrinsics.checkNotNullParameter(sortCluster, "<this>");
        if ((sortCluster.getCenterInfo() instanceof hb2.b) && sortCluster.g().size() <= 1) {
            return true;
        }
        return false;
    }
}
