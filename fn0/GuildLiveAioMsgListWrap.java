package fn0;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lfn0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/aio/data/msglist/a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "list", "b", "Z", "getIncludeLocation", "()Z", "includeLocation", "Landroid/os/Bundle;", "c", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "extra", "<init>", "(Ljava/util/List;ZLandroid/os/Bundle;)V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fn0.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GuildLiveAioMsgListWrap {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<com.tencent.aio.data.msglist.a> list;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean includeLocation;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bundle extra;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildLiveAioMsgListWrap(@NotNull List<? extends com.tencent.aio.data.msglist.a> list, boolean z16, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.includeLocation = z16;
        this.extra = bundle;
    }

    @NotNull
    public final List<com.tencent.aio.data.msglist.a> a() {
        return this.list;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildLiveAioMsgListWrap)) {
            return false;
        }
        GuildLiveAioMsgListWrap guildLiveAioMsgListWrap = (GuildLiveAioMsgListWrap) other;
        if (Intrinsics.areEqual(this.list, guildLiveAioMsgListWrap.list) && this.includeLocation == guildLiveAioMsgListWrap.includeLocation && Intrinsics.areEqual(this.extra, guildLiveAioMsgListWrap.extra)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.list.hashCode() * 31;
        boolean z16 = this.includeLocation;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        Bundle bundle = this.extra;
        if (bundle == null) {
            hashCode = 0;
        } else {
            hashCode = bundle.hashCode();
        }
        return i16 + hashCode;
    }

    @NotNull
    public String toString() {
        return "GuildLiveAioMsgListWrap(list=" + this.list + ", includeLocation=" + this.includeLocation + ", extra=" + this.extra + ")";
    }

    public /* synthetic */ GuildLiveAioMsgListWrap(List list, boolean z16, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? null : bundle);
    }
}
