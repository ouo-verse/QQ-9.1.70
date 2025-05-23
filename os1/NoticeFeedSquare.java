package os1;

import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\fR\u0019\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010#\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\fR\u0017\u0010%\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\fR\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u00100\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u00a8\u00061"}, d2 = {"Los1/c;", "Los1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Z", "()Z", "setActive", "(Z)V", "isActive", "c", "I", "getFeedNumber", "()I", "feedNumber", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "guildId", "e", "isVisitor", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "f", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "getFacadeArgsData", "()Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "g", "isMovePositionSection", h.F, "isTopChannelEmpty", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "i", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "getFacadeType", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "facadeType", "j", "Ljava/lang/Object;", "getExtra", "()Ljava/lang/Object;", "extra", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: os1.c, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class NoticeFeedSquare extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int feedNumber;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isVisitor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FacadeArgsData facadeArgsData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isMovePositionSection;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isTopChannelEmpty;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildFacadeType facadeType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object extra;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: b, reason: from getter */
    public boolean getIsActive() {
        return this.isActive;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoticeFeedSquare)) {
            return false;
        }
        NoticeFeedSquare noticeFeedSquare = (NoticeFeedSquare) other;
        if (getIsActive() == noticeFeedSquare.getIsActive() && this.feedNumber == noticeFeedSquare.feedNumber && Intrinsics.areEqual(this.guildId, noticeFeedSquare.guildId) && this.isVisitor == noticeFeedSquare.isVisitor && Intrinsics.areEqual(this.facadeArgsData, noticeFeedSquare.facadeArgsData) && this.isMovePositionSection == noticeFeedSquare.isMovePositionSection && this.isTopChannelEmpty == noticeFeedSquare.isTopChannelEmpty && this.facadeType == noticeFeedSquare.facadeType && Intrinsics.areEqual(this.extra, noticeFeedSquare.extra)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        int hashCode;
        boolean isActive = getIsActive();
        int i3 = 1;
        ?? r06 = isActive;
        if (isActive) {
            r06 = 1;
        }
        int hashCode2 = ((((r06 * 31) + this.feedNumber) * 31) + this.guildId.hashCode()) * 31;
        ?? r26 = this.isVisitor;
        int i16 = r26;
        if (r26 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        int i18 = 0;
        if (facadeArgsData == null) {
            hashCode = 0;
        } else {
            hashCode = facadeArgsData.hashCode();
        }
        int i19 = (i17 + hashCode) * 31;
        ?? r27 = this.isMovePositionSection;
        int i26 = r27;
        if (r27 != 0) {
            i26 = 1;
        }
        int i27 = (i19 + i26) * 31;
        boolean z16 = this.isTopChannelEmpty;
        if (!z16) {
            i3 = z16 ? 1 : 0;
        }
        int hashCode3 = (((i27 + i3) * 31) + this.facadeType.hashCode()) * 31;
        Object obj = this.extra;
        if (obj != null) {
            i18 = obj.hashCode();
        }
        return hashCode3 + i18;
    }

    @NotNull
    public String toString() {
        return "NoticeFeedSquare(isActive=" + getIsActive() + ", feedNumber=" + this.feedNumber + ", guildId=" + this.guildId + ", isVisitor=" + this.isVisitor + ", facadeArgsData=" + this.facadeArgsData + ", isMovePositionSection=" + this.isMovePositionSection + ", isTopChannelEmpty=" + this.isTopChannelEmpty + ", facadeType=" + this.facadeType + ", extra=" + this.extra + ")";
    }
}
