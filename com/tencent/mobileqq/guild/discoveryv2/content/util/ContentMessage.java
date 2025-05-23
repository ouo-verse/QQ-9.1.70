package com.tencent.mobileqq.guild.discoveryv2.content.util;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreType;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/util/ContentMessage;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "<init>", "()V", "LoadMoreMessage", "PullToRefreshMessage", "ScrollToPositionMessage", "TriggerJumpTopAndPullToRefresh", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class ContentMessage extends SimpleBaseEvent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/util/ContentMessage$LoadMoreMessage;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/util/ContentMessage;", "loadMoreType", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;", "callSource", "", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;Ljava/lang/String;)V", "getCallSource", "()Ljava/lang/String;", "getLoadMoreType", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class LoadMoreMessage extends ContentMessage {

        @NotNull
        private final String callSource;

        @NotNull
        private final LoadMoreType loadMoreType;

        public LoadMoreMessage(@NotNull LoadMoreType loadMoreType, @NotNull String callSource) {
            Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            this.loadMoreType = loadMoreType;
            this.callSource = callSource;
        }

        public static /* synthetic */ LoadMoreMessage copy$default(LoadMoreMessage loadMoreMessage, LoadMoreType loadMoreType, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                loadMoreType = loadMoreMessage.loadMoreType;
            }
            if ((i3 & 2) != 0) {
                str = loadMoreMessage.callSource;
            }
            return loadMoreMessage.copy(loadMoreType, str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final LoadMoreType getLoadMoreType() {
            return this.loadMoreType;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getCallSource() {
            return this.callSource;
        }

        @NotNull
        public final LoadMoreMessage copy(@NotNull LoadMoreType loadMoreType, @NotNull String callSource) {
            Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            return new LoadMoreMessage(loadMoreType, callSource);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadMoreMessage)) {
                return false;
            }
            LoadMoreMessage loadMoreMessage = (LoadMoreMessage) other;
            if (this.loadMoreType == loadMoreMessage.loadMoreType && Intrinsics.areEqual(this.callSource, loadMoreMessage.callSource)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCallSource() {
            return this.callSource;
        }

        @NotNull
        public final LoadMoreType getLoadMoreType() {
            return this.loadMoreType;
        }

        public int hashCode() {
            return (this.loadMoreType.hashCode() * 31) + this.callSource.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadMoreMessage(loadMoreType=" + this.loadMoreType + ", callSource=" + this.callSource + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/util/ContentMessage$PullToRefreshMessage;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/util/ContentMessage;", "pullToRefreshType", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/PullToRefreshType;", "callSource", "", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/model/PullToRefreshType;Ljava/lang/String;)V", "getCallSource", "()Ljava/lang/String;", "getPullToRefreshType", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/model/PullToRefreshType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class PullToRefreshMessage extends ContentMessage {

        @NotNull
        private final String callSource;

        @NotNull
        private final PullToRefreshType pullToRefreshType;

        public PullToRefreshMessage(@NotNull PullToRefreshType pullToRefreshType, @NotNull String callSource) {
            Intrinsics.checkNotNullParameter(pullToRefreshType, "pullToRefreshType");
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            this.pullToRefreshType = pullToRefreshType;
            this.callSource = callSource;
        }

        public static /* synthetic */ PullToRefreshMessage copy$default(PullToRefreshMessage pullToRefreshMessage, PullToRefreshType pullToRefreshType, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                pullToRefreshType = pullToRefreshMessage.pullToRefreshType;
            }
            if ((i3 & 2) != 0) {
                str = pullToRefreshMessage.callSource;
            }
            return pullToRefreshMessage.copy(pullToRefreshType, str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final PullToRefreshType getPullToRefreshType() {
            return this.pullToRefreshType;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getCallSource() {
            return this.callSource;
        }

        @NotNull
        public final PullToRefreshMessage copy(@NotNull PullToRefreshType pullToRefreshType, @NotNull String callSource) {
            Intrinsics.checkNotNullParameter(pullToRefreshType, "pullToRefreshType");
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            return new PullToRefreshMessage(pullToRefreshType, callSource);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PullToRefreshMessage)) {
                return false;
            }
            PullToRefreshMessage pullToRefreshMessage = (PullToRefreshMessage) other;
            if (this.pullToRefreshType == pullToRefreshMessage.pullToRefreshType && Intrinsics.areEqual(this.callSource, pullToRefreshMessage.callSource)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCallSource() {
            return this.callSource;
        }

        @NotNull
        public final PullToRefreshType getPullToRefreshType() {
            return this.pullToRefreshType;
        }

        public int hashCode() {
            return (this.pullToRefreshType.hashCode() * 31) + this.callSource.hashCode();
        }

        @NotNull
        public String toString() {
            return "PullToRefreshMessage(pullToRefreshType=" + this.pullToRefreshType + ", callSource=" + this.callSource + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/util/ContentMessage$ScrollToPositionMessage;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/util/ContentMessage;", "position", "", "callSource", "", "(ILjava/lang/String;)V", "getCallSource", "()Ljava/lang/String;", "getPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class ScrollToPositionMessage extends ContentMessage {

        @NotNull
        private final String callSource;
        private final int position;

        public ScrollToPositionMessage(int i3, @NotNull String callSource) {
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            this.position = i3;
            this.callSource = callSource;
        }

        public static /* synthetic */ ScrollToPositionMessage copy$default(ScrollToPositionMessage scrollToPositionMessage, int i3, String str, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = scrollToPositionMessage.position;
            }
            if ((i16 & 2) != 0) {
                str = scrollToPositionMessage.callSource;
            }
            return scrollToPositionMessage.copy(i3, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getCallSource() {
            return this.callSource;
        }

        @NotNull
        public final ScrollToPositionMessage copy(int position, @NotNull String callSource) {
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            return new ScrollToPositionMessage(position, callSource);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScrollToPositionMessage)) {
                return false;
            }
            ScrollToPositionMessage scrollToPositionMessage = (ScrollToPositionMessage) other;
            if (this.position == scrollToPositionMessage.position && Intrinsics.areEqual(this.callSource, scrollToPositionMessage.callSource)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCallSource() {
            return this.callSource;
        }

        public final int getPosition() {
            return this.position;
        }

        public int hashCode() {
            return (this.position * 31) + this.callSource.hashCode();
        }

        @NotNull
        public String toString() {
            return "ScrollToPositionMessage(position=" + this.position + ", callSource=" + this.callSource + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/util/ContentMessage$TriggerJumpTopAndPullToRefresh;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/util/ContentMessage;", "callSource", "", "(Ljava/lang/String;)V", "getCallSource", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class TriggerJumpTopAndPullToRefresh extends ContentMessage {

        @NotNull
        private final String callSource;

        public TriggerJumpTopAndPullToRefresh(@NotNull String callSource) {
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            this.callSource = callSource;
        }

        public static /* synthetic */ TriggerJumpTopAndPullToRefresh copy$default(TriggerJumpTopAndPullToRefresh triggerJumpTopAndPullToRefresh, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = triggerJumpTopAndPullToRefresh.callSource;
            }
            return triggerJumpTopAndPullToRefresh.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getCallSource() {
            return this.callSource;
        }

        @NotNull
        public final TriggerJumpTopAndPullToRefresh copy(@NotNull String callSource) {
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            return new TriggerJumpTopAndPullToRefresh(callSource);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof TriggerJumpTopAndPullToRefresh) && Intrinsics.areEqual(this.callSource, ((TriggerJumpTopAndPullToRefresh) other).callSource)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCallSource() {
            return this.callSource;
        }

        public int hashCode() {
            return this.callSource.hashCode();
        }

        @NotNull
        public String toString() {
            return "TriggerJumpTopAndPullToRefresh(callSource=" + this.callSource + ")";
        }
    }
}
