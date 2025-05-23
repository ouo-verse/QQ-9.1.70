package com.tencent.state.square.interaction;

import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionSettingMeList;", "", "list", "", "Lcom/tencent/state/square/interaction/InteractionSettingMeItem;", "(Ljava/util/List;)V", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionSettingMeList {
    private final List<InteractionSettingMeItem> list;

    public InteractionSettingMeList(List<InteractionSettingMeItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    public final List<InteractionSettingMeItem> component1() {
        return this.list;
    }

    public final InteractionSettingMeList copy(List<InteractionSettingMeItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new InteractionSettingMeList(list);
    }

    public final List<InteractionSettingMeItem> getList() {
        return this.list;
    }

    public int hashCode() {
        List<InteractionSettingMeItem> list = this.list;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "InteractionSettingMeList(list=" + this.list + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof InteractionSettingMeList) && Intrinsics.areEqual(this.list, ((InteractionSettingMeList) other).list);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InteractionSettingMeList copy$default(InteractionSettingMeList interactionSettingMeList, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = interactionSettingMeList.list;
        }
        return interactionSettingMeList.copy(list);
    }
}
