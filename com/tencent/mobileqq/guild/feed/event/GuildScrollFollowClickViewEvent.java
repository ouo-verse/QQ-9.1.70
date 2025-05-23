package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildScrollFollowClickViewEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", HippyTKDListViewAdapter.X, "", "y", "(II)V", "getX", "()I", "getY", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildScrollFollowClickViewEvent extends SimpleBaseEvent {
    private final int x;
    private final int y;

    public GuildScrollFollowClickViewEvent(int i3, int i16) {
        this.x = i3;
        this.y = i16;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }
}
