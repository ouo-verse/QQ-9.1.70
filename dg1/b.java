package dg1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0014\u0010\u0016\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0018\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Ldg1/b;", "", "other", "", "a", "equals", "", "hashCode", "", "c", "()J", "channelId", "e", "()I", "channelType", "", "d", "()Ljava/lang/String;", "channelName", "f", "guildId", "b", "cardType", "g", "memberCount", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class b {
    public boolean a(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (c() == other.c() && b() == other.b()) {
            return true;
        }
        return false;
    }

    public abstract int b();

    public abstract long c();

    @NotNull
    public abstract String d();

    public abstract int e();

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        Class<?> cls2 = getClass();
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(cls2, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.channelcard.data.ChannelCardItemData");
        b bVar = (b) other;
        if (c() == bVar.c() && e() == bVar.e() && Intrinsics.areEqual(d(), bVar.d()) && f() == bVar.f() && b() == bVar.b() && Intrinsics.areEqual(g(), bVar.g())) {
            return true;
        }
        return false;
    }

    public abstract long f();

    @NotNull
    public abstract String g();

    public int hashCode() {
        return (((((((((androidx.fragment.app.a.a(c()) * 31) + e()) * 31) + d().hashCode()) * 31) + androidx.fragment.app.a.a(f())) * 31) + b()) * 31) + g().hashCode();
    }
}
