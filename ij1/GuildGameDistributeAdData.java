package ij1;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lij1/i;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "", "b", "[B", "()[B", "advInfo", "<init>", "(Ljava/lang/String;[B)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ij1.i, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildGameDistributeAdData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final byte[] advInfo;

    public GuildGameDistributeAdData(@NotNull String guildId, @NotNull byte[] advInfo) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(advInfo, "advInfo");
        this.guildId = guildId;
        this.advInfo = advInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final byte[] getAdvInfo() {
        return this.advInfo;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(GuildGameDistributeAdData.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.data.GuildGameDistributeAdData");
        GuildGameDistributeAdData guildGameDistributeAdData = (GuildGameDistributeAdData) other;
        if (Arrays.equals(this.advInfo, guildGameDistributeAdData.advInfo) && this.guildId.contentEquals(guildGameDistributeAdData.guildId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.advInfo) + this.guildId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildGameDistributeAdData(guildId=" + this.guildId + ", advInfo=" + Arrays.toString(this.advInfo) + ")";
    }
}
