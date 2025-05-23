package com.qzone.reborn.albumx.qzone.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/event/QZoneAlbumSwitchTabEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "tabType", "I", "getTabType", "()I", "setTabType", "(I)V", "<init>", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumSwitchTabEvent extends SimpleBaseEvent {
    public static final int TAB_ALBUM_LIST = 1;
    public static final int TAB_LOCAL_PHOTO_RECOMMEND = 4;
    public static final int TAB_RECENT_PHOTO = 3;
    public static final int TAB_VIDEO = 2;
    private int tabType;

    public QZoneAlbumSwitchTabEvent(int i3) {
        this.tabType = i3;
    }

    public final int getTabType() {
        return this.tabType;
    }

    public final void setTabType(int i3) {
        this.tabType = i3;
    }
}
