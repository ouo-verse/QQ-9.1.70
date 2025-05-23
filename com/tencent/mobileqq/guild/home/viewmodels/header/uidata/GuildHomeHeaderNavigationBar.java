package com.tencent.mobileqq.guild.home.viewmodels.header.uidata;

import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001\u0005BE\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016JK\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u0017\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0010\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u001aR\u0017\u0010\u0011\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b)\u0010\u001aR\"\u0010,\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001c\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/f;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "other", "", "b", "a", "", "c", "isActive", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "tintColors", "", "guildId", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationInfo;", "infoList", "isExpand", "isJustChangeHigh", h.F, "toString", "", "hashCode", "equals", "e", "Z", "f", "()Z", "setActive", "(Z)V", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "g", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;)V", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "Ljava/util/List;", "k", "()Ljava/util/List;", "i", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "isNeedReportImpEvent", "<init>", "(ZLcom/tencent/mobileqq/guild/home/viewmodels/header/e;Ljava/lang/String;Ljava/util/List;ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.uidata.f, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildHomeHeaderNavigationBar extends b {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildHomeCoverColors tintColors;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<IGProNavigationInfo> infoList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isExpand;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isJustChangeHigh;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedReportImpEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/f$a;", "", "", "guildId", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "tintColors", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationInfo;", "infoList", "", "isExpand", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/f;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.uidata.f$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildHomeHeaderNavigationBar a(@NotNull String guildId, @NotNull GuildHomeCoverColors tintColors, @NotNull List<? extends IGProNavigationInfo> infoList, boolean isExpand) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tintColors, "tintColors");
            Intrinsics.checkNotNullParameter(infoList, "infoList");
            return new GuildHomeHeaderNavigationBar(!infoList.isEmpty(), tintColors, guildId, infoList, isExpand, false, 32, null);
        }

        Companion() {
        }
    }

    public /* synthetic */ GuildHomeHeaderNavigationBar(boolean z16, GuildHomeCoverColors guildHomeCoverColors, String str, List list, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, guildHomeCoverColors, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 16) != 0 ? false : z17, (i3 & 32) != 0 ? false : z18);
    }

    public static /* synthetic */ GuildHomeHeaderNavigationBar i(GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar, boolean z16, GuildHomeCoverColors guildHomeCoverColors, String str, List list, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = guildHomeHeaderNavigationBar.getIsActive();
        }
        if ((i3 & 2) != 0) {
            guildHomeCoverColors = guildHomeHeaderNavigationBar.getTintColors();
        }
        GuildHomeCoverColors guildHomeCoverColors2 = guildHomeCoverColors;
        if ((i3 & 4) != 0) {
            str = guildHomeHeaderNavigationBar.guildId;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            list = guildHomeHeaderNavigationBar.infoList;
        }
        List list2 = list;
        if ((i3 & 16) != 0) {
            z17 = guildHomeHeaderNavigationBar.isExpand;
        }
        boolean z19 = z17;
        if ((i3 & 32) != 0) {
            z18 = guildHomeHeaderNavigationBar.isJustChangeHigh;
        }
        return guildHomeHeaderNavigationBar.h(z16, guildHomeCoverColors2, str2, list2, z19, z18);
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public boolean a(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof GuildHomeHeaderNavigationBar)) {
            return false;
        }
        GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar = (GuildHomeHeaderNavigationBar) other;
        if (!Intrinsics.areEqual(guildHomeHeaderNavigationBar.guildId, this.guildId) || guildHomeHeaderNavigationBar.infoList.size() != this.infoList.size() || !Intrinsics.areEqual(other.getTintColors(), getTintColors())) {
            return false;
        }
        GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar2 = (GuildHomeHeaderNavigationBar) other;
        if (guildHomeHeaderNavigationBar2.isExpand != this.isExpand || guildHomeHeaderNavigationBar2.isNeedReportImpEvent != this.isNeedReportImpEvent) {
            return false;
        }
        int i3 = 0;
        for (Object obj : guildHomeHeaderNavigationBar2.infoList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            IGProNavigationInfo iGProNavigationInfo = (IGProNavigationInfo) obj;
            if (!Intrinsics.areEqual(this.infoList.get(i3).getTitle(), iGProNavigationInfo.getTitle()) || !Intrinsics.areEqual(this.infoList.get(i3).getIconUrl(), iGProNavigationInfo.getIconUrl()) || !Intrinsics.areEqual(this.infoList.get(i3).getJumpUrl(), iGProNavigationInfo.getJumpUrl())) {
                return false;
            }
            i3 = i16;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public boolean b(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other.getId() == getId()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    @Nullable
    public Object c(@NotNull b other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    @NotNull
    /* renamed from: e, reason: from getter */
    public GuildHomeCoverColors getTintColors() {
        return this.tintColors;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHomeHeaderNavigationBar)) {
            return false;
        }
        GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar = (GuildHomeHeaderNavigationBar) other;
        if (getIsActive() == guildHomeHeaderNavigationBar.getIsActive() && Intrinsics.areEqual(getTintColors(), guildHomeHeaderNavigationBar.getTintColors()) && Intrinsics.areEqual(this.guildId, guildHomeHeaderNavigationBar.guildId) && Intrinsics.areEqual(this.infoList, guildHomeHeaderNavigationBar.infoList) && this.isExpand == guildHomeHeaderNavigationBar.isExpand && this.isJustChangeHigh == guildHomeHeaderNavigationBar.isJustChangeHigh) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    /* renamed from: f, reason: from getter */
    public boolean getIsActive() {
        return this.isActive;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b
    public void g(@NotNull GuildHomeCoverColors guildHomeCoverColors) {
        Intrinsics.checkNotNullParameter(guildHomeCoverColors, "<set-?>");
        this.tintColors = guildHomeCoverColors;
    }

    @NotNull
    public final GuildHomeHeaderNavigationBar h(boolean isActive, @NotNull GuildHomeCoverColors tintColors, @NotNull String guildId, @NotNull List<? extends IGProNavigationInfo> infoList, boolean isExpand, boolean isJustChangeHigh) {
        Intrinsics.checkNotNullParameter(tintColors, "tintColors");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        return new GuildHomeHeaderNavigationBar(isActive, tintColors, guildId, infoList, isExpand, isJustChangeHigh);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        boolean isActive = getIsActive();
        int i3 = 1;
        int i16 = isActive;
        if (isActive) {
            i16 = 1;
        }
        int hashCode = ((((((i16 * 31) + getTintColors().hashCode()) * 31) + this.guildId.hashCode()) * 31) + this.infoList.hashCode()) * 31;
        boolean z16 = this.isExpand;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode + i17) * 31;
        boolean z17 = this.isJustChangeHigh;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i18 + i3;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final List<IGProNavigationInfo> k() {
        return this.infoList;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsExpand() {
        return this.isExpand;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsJustChangeHigh() {
        return this.isJustChangeHigh;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsNeedReportImpEvent() {
        return this.isNeedReportImpEvent;
    }

    public final void o(boolean z16) {
        this.isNeedReportImpEvent = z16;
    }

    @NotNull
    public String toString() {
        return "GuildHomeHeaderNavigationBar(isActive=" + getIsActive() + ", tintColors=" + getTintColors() + ", guildId=" + this.guildId + ", infoList=" + this.infoList + ", isExpand=" + this.isExpand + ", isJustChangeHigh=" + this.isJustChangeHigh + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildHomeHeaderNavigationBar(boolean z16, @NotNull GuildHomeCoverColors tintColors, @NotNull String guildId, @NotNull List<? extends IGProNavigationInfo> infoList, boolean z17, boolean z18) {
        super(2, false, tintColors, 2, null);
        Intrinsics.checkNotNullParameter(tintColors, "tintColors");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.isActive = z16;
        this.tintColors = tintColors;
        this.guildId = guildId;
        this.infoList = infoList;
        this.isExpand = z17;
        this.isJustChangeHigh = z18;
        this.isNeedReportImpEvent = true;
    }
}
