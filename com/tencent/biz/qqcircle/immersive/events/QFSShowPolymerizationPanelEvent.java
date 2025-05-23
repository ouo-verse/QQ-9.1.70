package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\tH\u00c6\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\b\u001a\u00020\tH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/events/QFSShowPolymerizationPanelEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "stFeed", "Lfeedcloud/FeedCloudMeta$StFeed;", "bean", "Lcom/tencent/biz/qqcircle/beans/QCirclePolymerizationBean;", ViewStickEventHelper.IS_SHOW, "", "hashCode", "", "(Lfeedcloud/FeedCloudMeta$StFeed;Lcom/tencent/biz/qqcircle/beans/QCirclePolymerizationBean;ZI)V", "getBean", "()Lcom/tencent/biz/qqcircle/beans/QCirclePolymerizationBean;", "getHashCode", "()I", "()Z", "getStFeed", "()Lfeedcloud/FeedCloudMeta$StFeed;", "setStFeed", "(Lfeedcloud/FeedCloudMeta$StFeed;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "toString", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QFSShowPolymerizationPanelEvent extends SimpleBaseEvent {

    @NotNull
    private final QCirclePolymerizationBean bean;
    private final int hashCode;
    private final boolean isShow;

    @NotNull
    private FeedCloudMeta$StFeed stFeed;

    public QFSShowPolymerizationPanelEvent(@NotNull FeedCloudMeta$StFeed stFeed, @NotNull QCirclePolymerizationBean bean, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.stFeed = stFeed;
        this.bean = bean;
        this.isShow = z16;
        this.hashCode = i3;
        this.mHashCode = i3;
    }

    public static /* synthetic */ QFSShowPolymerizationPanelEvent copy$default(QFSShowPolymerizationPanelEvent qFSShowPolymerizationPanelEvent, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCirclePolymerizationBean qCirclePolymerizationBean, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            feedCloudMeta$StFeed = qFSShowPolymerizationPanelEvent.stFeed;
        }
        if ((i16 & 2) != 0) {
            qCirclePolymerizationBean = qFSShowPolymerizationPanelEvent.bean;
        }
        if ((i16 & 4) != 0) {
            z16 = qFSShowPolymerizationPanelEvent.isShow;
        }
        if ((i16 & 8) != 0) {
            i3 = qFSShowPolymerizationPanelEvent.hashCode;
        }
        return qFSShowPolymerizationPanelEvent.copy(feedCloudMeta$StFeed, qCirclePolymerizationBean, z16, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final FeedCloudMeta$StFeed getStFeed() {
        return this.stFeed;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final QCirclePolymerizationBean getBean() {
        return this.bean;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    @NotNull
    public final QFSShowPolymerizationPanelEvent copy(@NotNull FeedCloudMeta$StFeed stFeed, @NotNull QCirclePolymerizationBean bean, boolean isShow, int hashCode) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(bean, "bean");
        return new QFSShowPolymerizationPanelEvent(stFeed, bean, isShow, hashCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSShowPolymerizationPanelEvent)) {
            return false;
        }
        QFSShowPolymerizationPanelEvent qFSShowPolymerizationPanelEvent = (QFSShowPolymerizationPanelEvent) other;
        if (Intrinsics.areEqual(this.stFeed, qFSShowPolymerizationPanelEvent.stFeed) && Intrinsics.areEqual(this.bean, qFSShowPolymerizationPanelEvent.bean) && this.isShow == qFSShowPolymerizationPanelEvent.isShow && this.hashCode == qFSShowPolymerizationPanelEvent.hashCode) {
            return true;
        }
        return false;
    }

    @NotNull
    public final QCirclePolymerizationBean getBean() {
        return this.bean;
    }

    public final int getHashCode() {
        return this.hashCode;
    }

    @NotNull
    public final FeedCloudMeta$StFeed getStFeed() {
        return this.stFeed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.stFeed.hashCode() * 31) + this.bean.hashCode()) * 31;
        boolean z16 = this.isShow;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.hashCode;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setStFeed(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<set-?>");
        this.stFeed = feedCloudMeta$StFeed;
    }

    @NotNull
    public String toString() {
        return "QFSShowPolymerizationPanelEvent(stFeed=" + this.stFeed + ", bean=" + this.bean + ", isShow=" + this.isShow + ", hashCode=" + this.hashCode + ")";
    }
}
