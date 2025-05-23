package com.tencent.mobileqq.troop.selectmember.event;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.selectmember.bean.c;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001f\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/event/TroopSelectMemberSingleModeItemClickEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "component1", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "component2", "launchConfig", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "getLaunchConfig", "()Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "getItem", "()Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "<init>", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;Lcom/tencent/mobileqq/troop/selectmember/bean/c;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class TroopSelectMemberSingleModeItemClickEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final c item;

    @Nullable
    private final TroopSelectMemberConfig launchConfig;

    public TroopSelectMemberSingleModeItemClickEvent(@Nullable TroopSelectMemberConfig troopSelectMemberConfig, @NotNull c item) {
        Intrinsics.checkNotNullParameter(item, "item");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSelectMemberConfig, (Object) item);
        } else {
            this.launchConfig = troopSelectMemberConfig;
            this.item = item;
        }
    }

    public static /* synthetic */ TroopSelectMemberSingleModeItemClickEvent copy$default(TroopSelectMemberSingleModeItemClickEvent troopSelectMemberSingleModeItemClickEvent, TroopSelectMemberConfig troopSelectMemberConfig, c cVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            troopSelectMemberConfig = troopSelectMemberSingleModeItemClickEvent.launchConfig;
        }
        if ((i3 & 2) != 0) {
            cVar = troopSelectMemberSingleModeItemClickEvent.item;
        }
        return troopSelectMemberSingleModeItemClickEvent.copy(troopSelectMemberConfig, cVar);
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
    public final c component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.item;
    }

    @NotNull
    public final TroopSelectMemberSingleModeItemClickEvent copy(@Nullable TroopSelectMemberConfig launchConfig, @NotNull c item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopSelectMemberSingleModeItemClickEvent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) launchConfig, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        return new TroopSelectMemberSingleModeItemClickEvent(launchConfig, item);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopSelectMemberSingleModeItemClickEvent)) {
            return false;
        }
        TroopSelectMemberSingleModeItemClickEvent troopSelectMemberSingleModeItemClickEvent = (TroopSelectMemberSingleModeItemClickEvent) other;
        if (Intrinsics.areEqual(this.launchConfig, troopSelectMemberSingleModeItemClickEvent.launchConfig) && Intrinsics.areEqual(this.item, troopSelectMemberSingleModeItemClickEvent.item)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final c getItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.item;
    }

    @Nullable
    public final TroopSelectMemberConfig getLaunchConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopSelectMemberConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.launchConfig;
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
        return (hashCode * 31) + this.item.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "TroopSelectMemberSingleModeItemClickEvent(launchConfig=" + this.launchConfig + ", item=" + this.item + ")";
    }
}
