package com.tencent.qqnt.aio.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u00c6\u0003J+\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/event/MsgFetchEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "itemMediaInfoList", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "msgRecordList", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "(Ljava/util/List;Ljava/util/List;)V", "getItemMediaInfoList", "()Ljava/util/List;", "getMsgRecordList", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final /* data */ class MsgFetchEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final List<RFWLayerItemMediaInfo> itemMediaInfoList;

    @Nullable
    private final List<MsgRecord> msgRecordList;

    /* JADX WARN: Multi-variable type inference failed */
    public MsgFetchEvent(@NotNull List<? extends RFWLayerItemMediaInfo> itemMediaInfoList, @Nullable List<MsgRecord> list) {
        Intrinsics.checkNotNullParameter(itemMediaInfoList, "itemMediaInfoList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemMediaInfoList, (Object) list);
        } else {
            this.itemMediaInfoList = itemMediaInfoList;
            this.msgRecordList = list;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MsgFetchEvent copy$default(MsgFetchEvent msgFetchEvent, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = msgFetchEvent.itemMediaInfoList;
        }
        if ((i3 & 2) != 0) {
            list2 = msgFetchEvent.msgRecordList;
        }
        return msgFetchEvent.copy(list, list2);
    }

    @NotNull
    public final List<RFWLayerItemMediaInfo> component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.itemMediaInfoList;
    }

    @Nullable
    public final List<MsgRecord> component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.msgRecordList;
    }

    @NotNull
    public final MsgFetchEvent copy(@NotNull List<? extends RFWLayerItemMediaInfo> itemMediaInfoList, @Nullable List<MsgRecord> msgRecordList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MsgFetchEvent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) itemMediaInfoList, (Object) msgRecordList);
        }
        Intrinsics.checkNotNullParameter(itemMediaInfoList, "itemMediaInfoList");
        return new MsgFetchEvent(itemMediaInfoList, msgRecordList);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgFetchEvent)) {
            return false;
        }
        MsgFetchEvent msgFetchEvent = (MsgFetchEvent) other;
        if (Intrinsics.areEqual(this.itemMediaInfoList, msgFetchEvent.itemMediaInfoList) && Intrinsics.areEqual(this.msgRecordList, msgFetchEvent.msgRecordList)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<RFWLayerItemMediaInfo> getItemMediaInfoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.itemMediaInfoList;
    }

    @Nullable
    public final List<MsgRecord> getMsgRecordList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgRecordList;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int hashCode2 = this.itemMediaInfoList.hashCode() * 31;
        List<MsgRecord> list = this.msgRecordList;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MsgFetchEvent(itemMediaInfoList=" + this.itemMediaInfoList + ", msgRecordList=" + this.msgRecordList + ")";
    }
}
