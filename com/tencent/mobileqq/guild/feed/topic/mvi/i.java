package com.tencent.mobileqq.guild.feed.topic.mvi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/i;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/h;", "<init>", "()V", "a", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/i$a;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class i extends h {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/i$a;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/i;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "firstFeedId", "getSource", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.i$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class Refresh extends i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String firstFeedId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Refresh(@NotNull String firstFeedId, @NotNull String source) {
            super(null);
            Intrinsics.checkNotNullParameter(firstFeedId, "firstFeedId");
            Intrinsics.checkNotNullParameter(source, "source");
            this.firstFeedId = firstFeedId;
            this.source = source;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFirstFeedId() {
            return this.firstFeedId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Refresh)) {
                return false;
            }
            Refresh refresh = (Refresh) other;
            if (Intrinsics.areEqual(this.firstFeedId, refresh.firstFeedId) && Intrinsics.areEqual(this.source, refresh.source)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.firstFeedId.hashCode() * 31) + this.source.hashCode();
        }

        @NotNull
        public String toString() {
            return "Refresh(firstFeedId=" + this.firstFeedId + ", source=" + this.source + ")";
        }
    }

    public /* synthetic */ i(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    i() {
        super(null);
    }
}
