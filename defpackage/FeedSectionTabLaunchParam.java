package defpackage;

import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0000\u0010\u000bR\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0000\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lb;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "guildId", "channelId", "c", "d", "sectionName", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class FeedSectionTabLaunchParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sectionName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final JumpGuildParam.JoinInfoParam joinInfoParam;

    public FeedSectionTabLaunchParam(@NotNull String guildId, @NotNull String channelId, @NotNull String sectionName, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        this.guildId = guildId;
        this.channelId = channelId;
        this.sectionName = sectionName;
        this.joinInfoParam = joinInfoParam;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final JumpGuildParam.JoinInfoParam getJoinInfoParam() {
        return this.joinInfoParam;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSectionName() {
        return this.sectionName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedSectionTabLaunchParam)) {
            return false;
        }
        FeedSectionTabLaunchParam feedSectionTabLaunchParam = (FeedSectionTabLaunchParam) other;
        if (Intrinsics.areEqual(this.guildId, feedSectionTabLaunchParam.guildId) && Intrinsics.areEqual(this.channelId, feedSectionTabLaunchParam.channelId) && Intrinsics.areEqual(this.sectionName, feedSectionTabLaunchParam.sectionName) && Intrinsics.areEqual(this.joinInfoParam, feedSectionTabLaunchParam.joinInfoParam)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.sectionName.hashCode()) * 31;
        JumpGuildParam.JoinInfoParam joinInfoParam = this.joinInfoParam;
        if (joinInfoParam == null) {
            hashCode = 0;
        } else {
            hashCode = joinInfoParam.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "FeedSectionTabLaunchParam(guildId=" + this.guildId + ", channelId=" + this.channelId + ", sectionName=" + this.sectionName + ", joinInfoParam=" + this.joinInfoParam + ')';
    }
}
