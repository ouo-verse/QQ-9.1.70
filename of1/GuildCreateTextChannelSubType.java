package of1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lof1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "id", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "c", "hintText", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: of1.a, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class GuildCreateTextChannelSubType {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String hintText;

    public GuildCreateTextChannelSubType(int i3, @NotNull String name, @NotNull String hintText) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hintText, "hintText");
        this.id = i3;
        this.name = name;
        this.hintText = hintText;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getHintText() {
        return this.hintText;
    }

    /* renamed from: b, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCreateTextChannelSubType)) {
            return false;
        }
        GuildCreateTextChannelSubType guildCreateTextChannelSubType = (GuildCreateTextChannelSubType) other;
        if (this.id == guildCreateTextChannelSubType.id && Intrinsics.areEqual(this.name, guildCreateTextChannelSubType.name) && Intrinsics.areEqual(this.hintText, guildCreateTextChannelSubType.hintText)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.id * 31) + this.name.hashCode()) * 31) + this.hintText.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildCreateTextChannelSubType(id=" + this.id + ", name=" + this.name + ", hintText=" + this.hintText + ")";
    }
}
