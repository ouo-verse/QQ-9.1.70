package com.tencent.mobileqq.troop.troopownertask.api.impl;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u00c6\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u00c6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/api/impl/TroopOwnerTaskRefreshUIEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "component1", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/b;", "component2", "", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/a;", "component3", "troopUin", "troopOwnerTask", "troopOwnerMsg", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/b;", "getTroopOwnerTask", "()Lcom/tencent/mobileqq/troop/troopownertask/api/impl/b;", "Ljava/util/List;", "getTroopOwnerMsg", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/troop/troopownertask/api/impl/b;Ljava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class TroopOwnerTaskRefreshUIEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @Nullable
    private final List<a> troopOwnerMsg;

    @Nullable
    private final b troopOwnerTask;

    @NotNull
    private final String troopUin;

    public TroopOwnerTaskRefreshUIEvent(@NotNull String troopUin, @Nullable b bVar, @Nullable List<a> list) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, bVar, list);
            return;
        }
        this.troopUin = troopUin;
        this.troopOwnerTask = bVar;
        this.troopOwnerMsg = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TroopOwnerTaskRefreshUIEvent copy$default(TroopOwnerTaskRefreshUIEvent troopOwnerTaskRefreshUIEvent, String str, b bVar, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = troopOwnerTaskRefreshUIEvent.troopUin;
        }
        if ((i3 & 2) != 0) {
            bVar = troopOwnerTaskRefreshUIEvent.troopOwnerTask;
        }
        if ((i3 & 4) != 0) {
            list = troopOwnerTaskRefreshUIEvent.troopOwnerMsg;
        }
        return troopOwnerTaskRefreshUIEvent.copy(str, bVar, list);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.troopUin;
    }

    @Nullable
    public final b component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.troopOwnerTask;
    }

    @Nullable
    public final List<a> component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.troopOwnerMsg;
    }

    @NotNull
    public final TroopOwnerTaskRefreshUIEvent copy(@NotNull String troopUin, @Nullable b troopOwnerTask, @Nullable List<a> troopOwnerMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TroopOwnerTaskRefreshUIEvent) iPatchRedirector.redirect((short) 8, this, troopUin, troopOwnerTask, troopOwnerMsg);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return new TroopOwnerTaskRefreshUIEvent(troopUin, troopOwnerTask, troopOwnerMsg);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopOwnerTaskRefreshUIEvent)) {
            return false;
        }
        TroopOwnerTaskRefreshUIEvent troopOwnerTaskRefreshUIEvent = (TroopOwnerTaskRefreshUIEvent) other;
        if (Intrinsics.areEqual(this.troopUin, troopOwnerTaskRefreshUIEvent.troopUin) && Intrinsics.areEqual(this.troopOwnerTask, troopOwnerTaskRefreshUIEvent.troopOwnerTask) && Intrinsics.areEqual(this.troopOwnerMsg, troopOwnerTaskRefreshUIEvent.troopOwnerMsg)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<a> getTroopOwnerMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopOwnerMsg;
    }

    @Nullable
    public final b getTroopOwnerTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopOwnerTask;
    }

    @NotNull
    public final String getTroopUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        int hashCode2 = this.troopUin.hashCode() * 31;
        b bVar = this.troopOwnerTask;
        int i3 = 0;
        if (bVar == null) {
            hashCode = 0;
        } else {
            hashCode = bVar.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        List<a> list = this.troopOwnerMsg;
        if (list != null) {
            i3 = list.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "TroopOwnerTaskRefreshUIEvent(troopUin=" + this.troopUin + ", troopOwnerTask=" + this.troopOwnerTask + ", troopOwnerMsg=" + this.troopOwnerMsg + ")";
    }
}
