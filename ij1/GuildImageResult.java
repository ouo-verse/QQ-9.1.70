package ij1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lij1/j;", "Lij1/l;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "originUrl", "I", "getOriginWidth", "()I", "setOriginWidth", "(I)V", "originWidth", "c", "getOriginHeight", "setOriginHeight", "originHeight", "<init>", "(Ljava/lang/String;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ij1.j, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildImageResult extends l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String originUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int originWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int originHeight;

    public GuildImageResult() {
        this(null, 0, 0, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originUrl = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildImageResult)) {
            return false;
        }
        GuildImageResult guildImageResult = (GuildImageResult) other;
        if (Intrinsics.areEqual(this.originUrl, guildImageResult.originUrl) && this.originWidth == guildImageResult.originWidth && this.originHeight == guildImageResult.originHeight) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.originUrl.hashCode() * 31) + this.originWidth) * 31) + this.originHeight;
    }

    @NotNull
    public String toString() {
        return "GuildImageResult(originUrl=" + this.originUrl + ", originWidth=" + this.originWidth + ", originHeight=" + this.originHeight + ")";
    }

    public /* synthetic */ GuildImageResult(String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? -1 : i3, (i17 & 4) != 0 ? -1 : i16);
    }

    public GuildImageResult(@NotNull String originUrl, int i3, int i16) {
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        this.originUrl = originUrl;
        this.originWidth = i3;
        this.originHeight = i16;
    }
}
