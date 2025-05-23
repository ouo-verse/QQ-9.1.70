package com.tencent.mobileqq.aio.input.at.common;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/SelectItemEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "component1", "itemData", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "getItemData", "()Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "<init>", "(Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class SelectItemEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final com.tencent.mobileqq.aio.input.at.common.list.data.b itemData;

    public SelectItemEvent(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemData);
        } else {
            this.itemData = itemData;
        }
    }

    public static /* synthetic */ SelectItemEvent copy$default(SelectItemEvent selectItemEvent, com.tencent.mobileqq.aio.input.at.common.list.data.b bVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bVar = selectItemEvent.itemData;
        }
        return selectItemEvent.copy(bVar);
    }

    @NotNull
    public final com.tencent.mobileqq.aio.input.at.common.list.data.b component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.input.at.common.list.data.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.itemData;
    }

    @NotNull
    public final SelectItemEvent copy(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SelectItemEvent) iPatchRedirector.redirect((short) 4, (Object) this, (Object) itemData);
        }
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        return new SelectItemEvent(itemData);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof SelectItemEvent) && Intrinsics.areEqual(this.itemData, ((SelectItemEvent) other).itemData)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final com.tencent.mobileqq.aio.input.at.common.list.data.b getItemData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.at.common.list.data.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.itemData;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.itemData.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "SelectItemEvent(itemData=" + this.itemData + ")";
    }
}
