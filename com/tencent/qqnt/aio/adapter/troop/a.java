package com.tencent.qqnt.aio.adapter.troop;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u001b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u0014\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u0017\u0010\u001f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\f\u0010\u000fR\u0017\u0010 \u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/troop/a;", "", "", "needColorNick", "needRemark", "", "e", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "troopUin", "b", "j", "uin", "c", "i", "uid", "d", "colorNick", "I", "()I", "colorNickId", "f", "g", AppConstants.Preferences.TROOP_NICK, "autoRemark", "friendNick", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String colorNick;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int colorNickId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopNick;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String autoRemark;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String friendNick;

    public a(@NotNull String troopUin, @NotNull String uin, @NotNull String uid, @NotNull String colorNick, int i3, @NotNull String troopNick, @NotNull String autoRemark, @NotNull String friendNick) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(colorNick, "colorNick");
        Intrinsics.checkNotNullParameter(troopNick, "troopNick");
        Intrinsics.checkNotNullParameter(autoRemark, "autoRemark");
        Intrinsics.checkNotNullParameter(friendNick, "friendNick");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, uin, uid, colorNick, Integer.valueOf(i3), troopNick, autoRemark, friendNick);
            return;
        }
        this.troopUin = troopUin;
        this.uin = uin;
        this.uid = uid;
        this.colorNick = colorNick;
        this.colorNickId = i3;
        this.troopNick = troopNick;
        this.autoRemark = autoRemark;
        this.friendNick = friendNick;
    }

    public static /* synthetic */ String f(a aVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        return aVar.e(z16, z17);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.autoRemark;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.colorNick;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.colorNickId;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.friendNick;
    }

    @NotNull
    public final String e(boolean needColorNick, boolean needRemark) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(needColorNick), Boolean.valueOf(needRemark));
        }
        return ((INtTroopMemberApi) QRoute.api(INtTroopMemberApi.class)).getShowName(this, needColorNick, needRemark);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.troopUin, aVar.troopUin) && Intrinsics.areEqual(this.uin, aVar.uin) && Intrinsics.areEqual(this.uid, aVar.uid) && Intrinsics.areEqual(this.colorNick, aVar.colorNick) && this.colorNickId == aVar.colorNickId && Intrinsics.areEqual(this.troopNick, aVar.troopNick) && Intrinsics.areEqual(this.autoRemark, aVar.autoRemark) && Intrinsics.areEqual(this.friendNick, aVar.friendNick)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.troopNick;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return (((((((((((((this.troopUin.hashCode() * 31) + this.uin.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.colorNick.hashCode()) * 31) + this.colorNickId) * 31) + this.troopNick.hashCode()) * 31) + this.autoRemark.hashCode()) * 31) + this.friendNick.hashCode();
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.uid;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uin;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "TroopMemberNickInfoWrapper(troopUin=" + this.troopUin + ", uin=" + this.uin + ", uid=" + this.uid + ", colorNick=" + this.colorNick + ", colorNickId=" + this.colorNickId + ", troopNick=" + this.troopNick + ", autoRemark=" + this.autoRemark + ", friendNick=" + this.friendNick + ")";
    }
}
