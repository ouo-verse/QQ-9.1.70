package com.tencent.qqnt.aio.nick;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\u0006\u0010%\u001a\u00020\u0007\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u000e\u0010\u001aR\u0017\u0010 \u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010#\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0017\u0010$\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b!\u0010\fR\u0017\u0010%\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0019\u0010'\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b&\u0010\u0014R\"\u0010+\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0012\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010*R\"\u0010-\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b,\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/qqnt/aio/nick/f;", "", "other", "", "a", "", "toString", "", "hashCode", "equals", "I", "f", "()I", "rankId", "b", "i", "realLevel", "c", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "rankTitle", "", "d", "[I", "e", "()[I", "rankColor", "levelColor", "Z", "l", "()Z", "isShowLevel", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isShowRank", "rankTextColor", "levelImageColor", "j", "richLevelUrl", "k", "o", "(Ljava/lang/String;)V", "senderUid", DomainData.DOMAIN_NAME, "peerUid", "<init>", "(IILjava/lang/String;[I[IZZIILjava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int rankId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int realLevel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String rankTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] rankColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] levelColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowLevel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowRank;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int rankTextColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int levelImageColor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String richLevelUrl;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String senderUid;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String peerUid;

    public f(int i3, int i16, @NotNull String rankTitle, @NotNull int[] rankColor, @NotNull int[] levelColor, boolean z16, boolean z17, int i17, int i18, @Nullable String str) {
        Intrinsics.checkNotNullParameter(rankTitle, "rankTitle");
        Intrinsics.checkNotNullParameter(rankColor, "rankColor");
        Intrinsics.checkNotNullParameter(levelColor, "levelColor");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), rankTitle, rankColor, levelColor, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i17), Integer.valueOf(i18), str);
            return;
        }
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
        this.senderUid = "";
        this.peerUid = "";
    }

    public final boolean a(@Nullable f other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) other)).booleanValue();
        }
        if (other == null || this.rankId != other.rankId || this.isShowLevel != other.isShowLevel || this.isShowRank != other.isShowRank || this.realLevel != other.realLevel || !Intrinsics.areEqual(this.rankTitle, other.rankTitle) || !Arrays.equals(this.levelColor, other.levelColor) || !Arrays.equals(this.rankColor, other.rankColor) || this.levelImageColor != other.levelImageColor || this.rankTextColor != other.rankTextColor || !TextUtils.equals(this.richLevelUrl, other.richLevelUrl)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.levelColor;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.levelImageColor;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.peerUid;
    }

    @NotNull
    public final int[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.rankColor;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (this.rankId == fVar.rankId && this.realLevel == fVar.realLevel && Intrinsics.areEqual(this.rankTitle, fVar.rankTitle) && Intrinsics.areEqual(this.rankColor, fVar.rankColor) && Intrinsics.areEqual(this.levelColor, fVar.levelColor) && this.isShowLevel == fVar.isShowLevel && this.isShowRank == fVar.isShowRank && this.rankTextColor == fVar.rankTextColor && this.levelImageColor == fVar.levelImageColor && Intrinsics.areEqual(this.richLevelUrl, fVar.richLevelUrl)) {
            return true;
        }
        return false;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.rankId;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.rankTextColor;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.rankTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        int hashCode2 = ((((((((this.rankId * 31) + this.realLevel) * 31) + this.rankTitle.hashCode()) * 31) + Arrays.hashCode(this.rankColor)) * 31) + Arrays.hashCode(this.levelColor)) * 31;
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

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.realLevel;
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.richLevelUrl;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.senderUid;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isShowLevel;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isShowRank;
    }

    public final void n(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.peerUid = str;
        }
    }

    public final void o(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.senderUid = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return "MemberLevelInfo(rankId=" + this.rankId + ", realLevel=" + this.realLevel + ", rankTitle=" + this.rankTitle + ", rankColor=" + Arrays.toString(this.rankColor) + ", levelColor=" + Arrays.toString(this.levelColor) + ", isShowLevel=" + this.isShowLevel + ", isShowRank=" + this.isShowRank + ", rankTextColor=" + this.rankTextColor + ", levelImageColor=" + this.levelImageColor + ", richLevelUrl=" + this.richLevelUrl + ")";
    }
}
