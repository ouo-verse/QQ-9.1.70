package fm1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Lfm1/i;", "", "b", "a", "e", "c", "", "type", "d", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {
    public static final boolean a(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        if (iVar.i() == 0 && iVar.getSubType() == com.tencent.guild.api.media.album.c.a()) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        if (iVar.i() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        if (iVar.i() == 1) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull i iVar, int i3) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        if (iVar.i() == 1 && iVar.getSubType() == i3) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        if (iVar.i() == 0 && iVar.getSubType() == com.tencent.guild.api.media.album.c.b()) {
            return true;
        }
        return false;
    }
}
