package com.qzone.reborn.groupalbum.event;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0019\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u00c6\u0003J-\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u00c6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R'\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/groupalbum/event/GroupAlbumFeedExposureEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "component1", "Ljava/util/ArrayList;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Lkotlin/collections/ArrayList;", "component2", "from", "data", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getFrom", "()I", "Ljava/util/ArrayList;", "getData", "()Ljava/util/ArrayList;", "<init>", "(ILjava/util/ArrayList;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class GroupAlbumFeedExposureEvent extends SimpleBaseEvent {
    public static final int FROM_DYNAMIC_TAB_EXPOSURE = 1;
    public static final int FROM_USER_WRITE_ACTION = 2;
    private final ArrayList<BusinessFeedData> data;
    private final int from;

    public GroupAlbumFeedExposureEvent(int i3, ArrayList<BusinessFeedData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.from = i3;
        this.data = data;
    }

    /* renamed from: component1, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    public final ArrayList<BusinessFeedData> component2() {
        return this.data;
    }

    public final GroupAlbumFeedExposureEvent copy(int from, ArrayList<BusinessFeedData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new GroupAlbumFeedExposureEvent(from, data);
    }

    public final ArrayList<BusinessFeedData> getData() {
        return this.data;
    }

    public final int getFrom() {
        return this.from;
    }

    public int hashCode() {
        return (this.from * 31) + this.data.hashCode();
    }

    public String toString() {
        return "GroupAlbumFeedExposureEvent(from=" + this.from + ", data=" + this.data + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupAlbumFeedExposureEvent copy$default(GroupAlbumFeedExposureEvent groupAlbumFeedExposureEvent, int i3, ArrayList arrayList, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = groupAlbumFeedExposureEvent.from;
        }
        if ((i16 & 2) != 0) {
            arrayList = groupAlbumFeedExposureEvent.data;
        }
        return groupAlbumFeedExposureEvent.copy(i3, arrayList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupAlbumFeedExposureEvent)) {
            return false;
        }
        GroupAlbumFeedExposureEvent groupAlbumFeedExposureEvent = (GroupAlbumFeedExposureEvent) other;
        return this.from == groupAlbumFeedExposureEvent.from && Intrinsics.areEqual(this.data, groupAlbumFeedExposureEvent.data);
    }
}
