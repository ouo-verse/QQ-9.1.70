package com.tencent.mobileqq.troop.troopfullmember.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/event/UpdateSubTroopsInfo;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "data", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "([Lcom/tencent/mobileqq/widget/listitem/Group;)V", "getData", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "component1", "copy", "([Lcom/tencent/mobileqq/widget/listitem/Group;)Lcom/tencent/mobileqq/troop/troopfullmember/event/UpdateSubTroopsInfo;", "equals", "", "other", "", "hashCode", "", "toString", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final /* data */ class UpdateSubTroopsInfo extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final Group[] data;

    public UpdateSubTroopsInfo(@NotNull Group[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) data);
        } else {
            this.data = data;
        }
    }

    public static /* synthetic */ UpdateSubTroopsInfo copy$default(UpdateSubTroopsInfo updateSubTroopsInfo, Group[] groupArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            groupArr = updateSubTroopsInfo.data;
        }
        return updateSubTroopsInfo.copy(groupArr);
    }

    @NotNull
    public final Group[] component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Group[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.data;
    }

    @NotNull
    public final UpdateSubTroopsInfo copy(@NotNull Group[] data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (UpdateSubTroopsInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        return new UpdateSubTroopsInfo(data);
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(UpdateSubTroopsInfo.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.troop.troopfullmember.event.UpdateSubTroopsInfo");
        if (Arrays.equals(this.data, ((UpdateSubTroopsInfo) other).data)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Group[] getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.data;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return Arrays.hashCode(this.data);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "UpdateSubTroopsInfo(data=" + Arrays.toString(this.data) + ")";
    }
}
