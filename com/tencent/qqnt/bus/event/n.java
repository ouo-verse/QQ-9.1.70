package com.tencent.qqnt.bus.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0015\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010$\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010)\u001a\u00020\u0004\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0016\u0010\u001eR\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\n\u0010\u001eR\u0017\u0010$\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010'\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R\u0017\u0010(\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b\u000f\u0010\u0014R\u0019\u0010*\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b%\u0010\r\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/bus/event/n;", "Lzv3/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "troopUin", "b", "c", "memberUin", "I", "e", "()I", "rankId", "d", tl.h.F, "realLevel", "g", "rankTitle", "", "f", "[I", "()[I", "rankColor", "levelColor", "Z", "k", "()Z", "isShowLevel", "i", "l", "isShowRank", "rankTextColor", "levelImageColor", "richLevelUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;[I[IZZIILjava/lang/String;)V", "bus_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class n implements zv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String memberUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int rankId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int realLevel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String rankTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] rankColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] levelColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowLevel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowRank;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int rankTextColor;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int levelImageColor;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String richLevelUrl;

    public n(@NotNull String troopUin, @NotNull String memberUin, int i3, int i16, @NotNull String rankTitle, @NotNull int[] rankColor, @NotNull int[] levelColor, boolean z16, boolean z17, int i17, int i18, @Nullable String str) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(rankTitle, "rankTitle");
        Intrinsics.checkNotNullParameter(rankColor, "rankColor");
        Intrinsics.checkNotNullParameter(levelColor, "levelColor");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, memberUin, Integer.valueOf(i3), Integer.valueOf(i16), rankTitle, rankColor, levelColor, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i17), Integer.valueOf(i18), str);
            return;
        }
        this.troopUin = troopUin;
        this.memberUin = memberUin;
        this.rankId = i3;
        this.realLevel = i16;
        this.rankTitle = rankTitle;
        this.rankColor = rankColor;
        this.levelColor = levelColor;
        this.isShowLevel = z16;
        this.isShowRank = z17;
        this.rankTextColor = i17;
        this.levelImageColor = i18;
        this.richLevelUrl = str;
    }

    @NotNull
    public final int[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (int[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.levelColor;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.levelImageColor;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.memberUin;
    }

    @NotNull
    public final int[] d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (int[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.rankColor;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.rankId;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof n)) {
            return false;
        }
        n nVar = (n) other;
        if (Intrinsics.areEqual(this.troopUin, nVar.troopUin) && Intrinsics.areEqual(this.memberUin, nVar.memberUin) && this.rankId == nVar.rankId && this.realLevel == nVar.realLevel && Intrinsics.areEqual(this.rankTitle, nVar.rankTitle) && Intrinsics.areEqual(this.rankColor, nVar.rankColor) && Intrinsics.areEqual(this.levelColor, nVar.levelColor) && this.isShowLevel == nVar.isShowLevel && this.isShowRank == nVar.isShowRank && this.rankTextColor == nVar.rankTextColor && this.levelImageColor == nVar.levelImageColor && Intrinsics.areEqual(this.richLevelUrl, nVar.richLevelUrl)) {
            return true;
        }
        return false;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.rankTextColor;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.rankTitle;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.realLevel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        int hashCode2 = ((((((((((((this.troopUin.hashCode() * 31) + this.memberUin.hashCode()) * 31) + this.rankId) * 31) + this.realLevel) * 31) + this.rankTitle.hashCode()) * 31) + Arrays.hashCode(this.rankColor)) * 31) + Arrays.hashCode(this.levelColor)) * 31;
        boolean z16 = this.isShowLevel;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.isShowRank;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (((((i17 + i3) * 31) + this.rankTextColor) * 31) + this.levelImageColor) * 31;
        String str = this.richLevelUrl;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return i18 + hashCode;
    }

    @Nullable
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.richLevelUrl;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.isShowLevel;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isShowRank;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return "MemberLevelUpdateEvent(troopUin=" + this.troopUin + ", memberUin=" + this.memberUin + ", rankId=" + this.rankId + ", realLevel=" + this.realLevel + ", rankTitle=" + this.rankTitle + ", rankColor=" + Arrays.toString(this.rankColor) + ", levelColor=" + Arrays.toString(this.levelColor) + ", isShowLevel=" + this.isShowLevel + ", isShowRank=" + this.isShowRank + ", rankTextColor=" + this.rankTextColor + ", levelImageColor=" + this.levelImageColor + ", richLevelUrl=" + this.richLevelUrl + ")";
    }
}
