package com.tencent.biz.qqcircle.immersive.events;

import android.widget.ImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.data.RecentUser;
import e30.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J7\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\tH\u00c6\u0001J\t\u0010\u0010\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/events/QFSShowLongPressSharePanelEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Le30/b;", "component1", "", "Lcom/tencent/mobileqq/data/RecentUser;", "component2", "Landroid/widget/ImageView;", "component3", "", "component4", "feedBlockData", "recentUserList", "anchor", "pageId", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Le30/b;", "getFeedBlockData", "()Le30/b;", "Ljava/util/List;", "getRecentUserList", "()Ljava/util/List;", "Landroid/widget/ImageView;", "getAnchor", "()Landroid/widget/ImageView;", "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "<init>", "(Le30/b;Ljava/util/List;Landroid/widget/ImageView;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final /* data */ class QFSShowLongPressSharePanelEvent extends SimpleBaseEvent {

    @NotNull
    private final ImageView anchor;

    @NotNull
    private final b feedBlockData;

    @NotNull
    private final String pageId;

    @NotNull
    private final List<RecentUser> recentUserList;

    public QFSShowLongPressSharePanelEvent(@NotNull b feedBlockData, @NotNull List<RecentUser> recentUserList, @NotNull ImageView anchor, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(feedBlockData, "feedBlockData");
        Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.feedBlockData = feedBlockData;
        this.recentUserList = recentUserList;
        this.anchor = anchor;
        this.pageId = pageId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QFSShowLongPressSharePanelEvent copy$default(QFSShowLongPressSharePanelEvent qFSShowLongPressSharePanelEvent, b bVar, List list, ImageView imageView, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bVar = qFSShowLongPressSharePanelEvent.feedBlockData;
        }
        if ((i3 & 2) != 0) {
            list = qFSShowLongPressSharePanelEvent.recentUserList;
        }
        if ((i3 & 4) != 0) {
            imageView = qFSShowLongPressSharePanelEvent.anchor;
        }
        if ((i3 & 8) != 0) {
            str = qFSShowLongPressSharePanelEvent.pageId;
        }
        return qFSShowLongPressSharePanelEvent.copy(bVar, list, imageView, str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final b getFeedBlockData() {
        return this.feedBlockData;
    }

    @NotNull
    public final List<RecentUser> component2() {
        return this.recentUserList;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final ImageView getAnchor() {
        return this.anchor;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }

    @NotNull
    public final QFSShowLongPressSharePanelEvent copy(@NotNull b feedBlockData, @NotNull List<RecentUser> recentUserList, @NotNull ImageView anchor, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(feedBlockData, "feedBlockData");
        Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        return new QFSShowLongPressSharePanelEvent(feedBlockData, recentUserList, anchor, pageId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSShowLongPressSharePanelEvent)) {
            return false;
        }
        QFSShowLongPressSharePanelEvent qFSShowLongPressSharePanelEvent = (QFSShowLongPressSharePanelEvent) other;
        if (Intrinsics.areEqual(this.feedBlockData, qFSShowLongPressSharePanelEvent.feedBlockData) && Intrinsics.areEqual(this.recentUserList, qFSShowLongPressSharePanelEvent.recentUserList) && Intrinsics.areEqual(this.anchor, qFSShowLongPressSharePanelEvent.anchor) && Intrinsics.areEqual(this.pageId, qFSShowLongPressSharePanelEvent.pageId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ImageView getAnchor() {
        return this.anchor;
    }

    @NotNull
    public final b getFeedBlockData() {
        return this.feedBlockData;
    }

    @NotNull
    public final String getPageId() {
        return this.pageId;
    }

    @NotNull
    public final List<RecentUser> getRecentUserList() {
        return this.recentUserList;
    }

    public int hashCode() {
        return (((((this.feedBlockData.hashCode() * 31) + this.recentUserList.hashCode()) * 31) + this.anchor.hashCode()) * 31) + this.pageId.hashCode();
    }

    @NotNull
    public String toString() {
        return "QFSShowLongPressSharePanelEvent(feedBlockData=" + this.feedBlockData + ", recentUserList=" + this.recentUserList + ", anchor=" + this.anchor + ", pageId=" + this.pageId + ")";
    }
}
