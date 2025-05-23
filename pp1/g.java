package pp1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H&J\b\u0010\u0007\u001a\u00020\u0006H&R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lpp1/g;", "", "other", "", "c", "d", "", "b", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "channelId", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    public g(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.channelId = channelId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public abstract String b();

    public abstract boolean c(@NotNull g other);

    public abstract boolean d(@NotNull g other);
}
