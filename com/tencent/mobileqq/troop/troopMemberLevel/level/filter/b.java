package com.tencent.mobileqq.troop.troopmemberlevel.level.filter;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmemberlevel/level/filter/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "()Lmqq/app/AppRuntime;", "mAppRuntime", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "b", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "c", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "d", "Ljava/lang/String;", "getMemberUin", "()Ljava/lang/String;", "memberUin", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/data/troop/TroopInfo;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppRuntime mAppRuntime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopInfo troopInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOMsgItem msgItem;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String memberUin;

    public b(@NotNull AppRuntime mAppRuntime, @NotNull TroopInfo troopInfo, @NotNull AIOMsgItem msgItem, @NotNull String memberUin) {
        Intrinsics.checkNotNullParameter(mAppRuntime, "mAppRuntime");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mAppRuntime, troopInfo, msgItem, memberUin);
            return;
        }
        this.mAppRuntime = mAppRuntime;
        this.troopInfo = troopInfo;
        this.msgItem = msgItem;
        this.memberUin = memberUin;
    }

    @NotNull
    public final AppRuntime a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mAppRuntime;
    }

    @NotNull
    public final AIOMsgItem b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msgItem;
    }

    @NotNull
    public final TroopInfo c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopInfo;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.mAppRuntime, bVar.mAppRuntime) && Intrinsics.areEqual(this.troopInfo, bVar.troopInfo) && Intrinsics.areEqual(this.msgItem, bVar.msgItem) && Intrinsics.areEqual(this.memberUin, bVar.memberUin)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (((((this.mAppRuntime.hashCode() * 31) + this.troopInfo.hashCode()) * 31) + this.msgItem.hashCode()) * 31) + this.memberUin.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "TroopMemberLevelFilterArgs(mAppRuntime=" + this.mAppRuntime + ", troopInfo=" + this.troopInfo + ", msgItem=" + this.msgItem + ", memberUin=" + this.memberUin + ")";
    }
}
