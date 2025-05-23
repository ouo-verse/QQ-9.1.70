package com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedThirdVideoFullScreenEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "showInFullScreen", "", "webPageId", "", "url", "(ZLjava/lang/String;Ljava/lang/String;)V", "getShowInFullScreen", "()Z", "getUrl", "()Ljava/lang/String;", "getWebPageId", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class FeedThirdVideoFullScreenEvent extends SimpleBaseEvent {
    private final boolean showInFullScreen;

    @NotNull
    private final String url;

    @NotNull
    private final String webPageId;

    public FeedThirdVideoFullScreenEvent(boolean z16, @NotNull String webPageId, @NotNull String url) {
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Intrinsics.checkNotNullParameter(url, "url");
        this.showInFullScreen = z16;
        this.webPageId = webPageId;
        this.url = url;
    }

    public static /* synthetic */ FeedThirdVideoFullScreenEvent copy$default(FeedThirdVideoFullScreenEvent feedThirdVideoFullScreenEvent, boolean z16, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = feedThirdVideoFullScreenEvent.showInFullScreen;
        }
        if ((i3 & 2) != 0) {
            str = feedThirdVideoFullScreenEvent.webPageId;
        }
        if ((i3 & 4) != 0) {
            str2 = feedThirdVideoFullScreenEvent.url;
        }
        return feedThirdVideoFullScreenEvent.copy(z16, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShowInFullScreen() {
        return this.showInFullScreen;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getWebPageId() {
        return this.webPageId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final FeedThirdVideoFullScreenEvent copy(boolean showInFullScreen, @NotNull String webPageId, @NotNull String url) {
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Intrinsics.checkNotNullParameter(url, "url");
        return new FeedThirdVideoFullScreenEvent(showInFullScreen, webPageId, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedThirdVideoFullScreenEvent)) {
            return false;
        }
        FeedThirdVideoFullScreenEvent feedThirdVideoFullScreenEvent = (FeedThirdVideoFullScreenEvent) other;
        if (this.showInFullScreen == feedThirdVideoFullScreenEvent.showInFullScreen && Intrinsics.areEqual(this.webPageId, feedThirdVideoFullScreenEvent.webPageId) && Intrinsics.areEqual(this.url, feedThirdVideoFullScreenEvent.url)) {
            return true;
        }
        return false;
    }

    public final boolean getShowInFullScreen() {
        return this.showInFullScreen;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getWebPageId() {
        return this.webPageId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.showInFullScreen;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.webPageId.hashCode()) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedThirdVideoFullScreenEvent(showInFullScreen=" + this.showInFullScreen + ", webPageId=" + this.webPageId + ", url=" + this.url + ")";
    }
}
