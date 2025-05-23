package com.qzone.reborn.intimate.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateTaskDetailInitBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "spaceId", "", "albumId", "tabId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAlbumId", "()Ljava/lang/String;", "getSpaceId", "getTabId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateTaskDetailInitBean extends QZoneIntimateInitBean {
    private final String albumId;
    private final String spaceId;
    private final Integer tabId;

    public /* synthetic */ QZoneIntimateTaskDetailInitBean(String str, String str2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? 0 : num);
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final Integer getTabId() {
        return this.tabId;
    }

    public QZoneIntimateTaskDetailInitBean(String spaceId, String str, Integer num) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        this.spaceId = spaceId;
        this.albumId = str;
        this.tabId = num;
    }
}
