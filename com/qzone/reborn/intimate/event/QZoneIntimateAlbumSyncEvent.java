package com.qzone.reborn.intimate.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0007R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/intimate/event/QZoneIntimateAlbumSyncEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "albumIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "spaceId", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "getAlbumIds", "()Ljava/util/ArrayList;", "setAlbumIds", "(Ljava/util/ArrayList;)V", "getSpaceId", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumSyncEvent extends SimpleBaseEvent {
    private ArrayList<String> albumIds;
    private String spaceId;

    public /* synthetic */ QZoneIntimateAlbumSyncEvent(ArrayList arrayList, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, (i3 & 2) != 0 ? "" : str);
    }

    public final ArrayList<String> getAlbumIds() {
        return this.albumIds;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final void setAlbumIds(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.albumIds = arrayList;
    }

    public final void setSpaceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public QZoneIntimateAlbumSyncEvent(ArrayList<String> albumIds, String spaceId) {
        Intrinsics.checkNotNullParameter(albumIds, "albumIds");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        this.albumIds = albumIds;
        this.spaceId = spaceId;
    }
}
