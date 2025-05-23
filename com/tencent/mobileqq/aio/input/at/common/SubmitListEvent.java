package com.tencent.mobileqq.aio.input.at.common;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003J\u0019\u0010\u0006\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/SubmitListEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "component1", VideoTemplateParser.ITEM_LIST, "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getItemList", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class SubmitListEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final List<com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList;

    /* JADX WARN: Multi-variable type inference failed */
    public SubmitListEvent(@NotNull List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemList);
        } else {
            this.itemList = itemList;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubmitListEvent copy$default(SubmitListEvent submitListEvent, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = submitListEvent.itemList;
        }
        return submitListEvent.copy(list);
    }

    @NotNull
    public final List<com.tencent.mobileqq.aio.input.at.common.list.data.b> component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.itemList;
    }

    @NotNull
    public final SubmitListEvent copy(@NotNull List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SubmitListEvent) iPatchRedirector.redirect((short) 4, (Object) this, (Object) itemList);
        }
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        return new SubmitListEvent(itemList);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof SubmitListEvent) && Intrinsics.areEqual(this.itemList, ((SubmitListEvent) other).itemList)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<com.tencent.mobileqq.aio.input.at.common.list.data.b> getItemList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.itemList;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.itemList.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "SubmitListEvent(itemList=" + this.itemList + ")";
    }
}
