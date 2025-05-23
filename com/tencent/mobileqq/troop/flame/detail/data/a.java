package com.tencent.mobileqq.troop.flame.detail.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d\u0012\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b$\u0010\u0010\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getTroopName", "()Ljava/lang/String;", "troopName", "b", "I", "()I", "activeDays", "c", "activeMembers", "d", "e", "selfRank", "globalRank", "Lcom/tencent/mobileqq/troop/flame/detail/data/b;", "f", "Lcom/tencent/mobileqq/troop/flame/detail/data/b;", "()Lcom/tencent/mobileqq/troop/flame/detail/data/b;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "g", "Ljava/util/List;", "getMemberUinList", "()Ljava/util/List;", "memberUinList", h.F, "getMemberCount", "memberCount", "<init>", "(Ljava/lang/String;IIIILcom/tencent/mobileqq/troop/flame/detail/data/b;Ljava/util/List;I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int activeDays;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int activeMembers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int selfRank;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int globalRank;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b rule;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> memberUinList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int memberCount;

    public a(@NotNull String troopName, int i3, int i16, int i17, int i18, @NotNull b rule, @NotNull List<String> memberUinList, int i19) {
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(memberUinList, "memberUinList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopName, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), rule, memberUinList, Integer.valueOf(i19));
            return;
        }
        this.troopName = troopName;
        this.activeDays = i3;
        this.activeMembers = i16;
        this.selfRank = i17;
        this.globalRank = i18;
        this.rule = rule;
        this.memberUinList = memberUinList;
        this.memberCount = i19;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.activeDays;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.activeMembers;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.globalRank;
    }

    @NotNull
    public final b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.rule;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.selfRank;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.troopName, aVar.troopName) && this.activeDays == aVar.activeDays && this.activeMembers == aVar.activeMembers && this.selfRank == aVar.selfRank && this.globalRank == aVar.globalRank && Intrinsics.areEqual(this.rule, aVar.rule) && Intrinsics.areEqual(this.memberUinList, aVar.memberUinList) && this.memberCount == aVar.memberCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return (((((((((((((this.troopName.hashCode() * 31) + this.activeDays) * 31) + this.activeMembers) * 31) + this.selfRank) * 31) + this.globalRank) * 31) + this.rule.hashCode()) * 31) + this.memberUinList.hashCode()) * 31) + this.memberCount;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "TroopFlameDetailData(troopName=" + this.troopName + ", activeDays=" + this.activeDays + ", activeMembers=" + this.activeMembers + ", selfRank=" + this.selfRank + ", globalRank=" + this.globalRank + ", rule=" + this.rule + ", memberUinList=" + this.memberUinList + ", memberCount=" + this.memberCount + ")";
    }
}
