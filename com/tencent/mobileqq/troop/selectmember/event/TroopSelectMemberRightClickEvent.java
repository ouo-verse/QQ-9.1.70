package com.tencent.mobileqq.troop.selectmember.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.selectmember.bean.c;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003J%\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/event/TroopSelectMemberRightClickEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "component1", "", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "component2", "launchConfig", "list", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "getLaunchConfig", "()Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "Ljava/util/List;", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "<init>", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;Ljava/util/List;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class TroopSelectMemberRightClickEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @Nullable
    private final TroopSelectMemberConfig launchConfig;

    @NotNull
    private final List<c> list;

    /* JADX WARN: Multi-variable type inference failed */
    public TroopSelectMemberRightClickEvent(@Nullable TroopSelectMemberConfig troopSelectMemberConfig, @NotNull List<? extends c> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSelectMemberConfig, (Object) list);
        } else {
            this.launchConfig = troopSelectMemberConfig;
            this.list = list;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TroopSelectMemberRightClickEvent copy$default(TroopSelectMemberRightClickEvent troopSelectMemberRightClickEvent, TroopSelectMemberConfig troopSelectMemberConfig, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            troopSelectMemberConfig = troopSelectMemberRightClickEvent.launchConfig;
        }
        if ((i3 & 2) != 0) {
            list = troopSelectMemberRightClickEvent.list;
        }
        return troopSelectMemberRightClickEvent.copy(troopSelectMemberConfig, list);
    }

    @Nullable
    public final TroopSelectMemberConfig component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopSelectMemberConfig) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.launchConfig;
    }

    @NotNull
    public final List<c> component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.list;
    }

    @NotNull
    public final TroopSelectMemberRightClickEvent copy(@Nullable TroopSelectMemberConfig launchConfig, @NotNull List<? extends c> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopSelectMemberRightClickEvent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) launchConfig, (Object) list);
        }
        Intrinsics.checkNotNullParameter(list, "list");
        return new TroopSelectMemberRightClickEvent(launchConfig, list);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopSelectMemberRightClickEvent)) {
            return false;
        }
        TroopSelectMemberRightClickEvent troopSelectMemberRightClickEvent = (TroopSelectMemberRightClickEvent) other;
        if (Intrinsics.areEqual(this.launchConfig, troopSelectMemberRightClickEvent.launchConfig) && Intrinsics.areEqual(this.list, troopSelectMemberRightClickEvent.list)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final TroopSelectMemberConfig getLaunchConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopSelectMemberConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.launchConfig;
    }

    @NotNull
    public final List<c> getList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.list;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        TroopSelectMemberConfig troopSelectMemberConfig = this.launchConfig;
        if (troopSelectMemberConfig == null) {
            hashCode = 0;
        } else {
            hashCode = troopSelectMemberConfig.hashCode();
        }
        return (hashCode * 31) + this.list.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "TroopSelectMemberRightClickEvent(launchConfig=" + this.launchConfig + ", list=" + this.list + ")";
    }
}
