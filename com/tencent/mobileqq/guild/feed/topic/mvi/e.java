package com.tencent.mobileqq.guild.feed.topic.mvi;

import com.tencent.qqmini.sdk.widget.ToastView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u0082\u0001\u0002\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/e;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/h;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/a;", "oldState", "a", "<init>", "()V", "b", "c", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/e$b;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/e$c;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class e extends h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/e$a;", "", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/f;", "intent", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/a;", "state", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/e;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.e$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final e a(@NotNull TopicFeedsLordMoreIntent intent, @NotNull FeedListState state) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (state.getSuccess().f431477a == -1) {
                return new LoreMoreIgnore("notReady");
            }
            if (state.getLoadingMore()) {
                return new LoreMoreIgnore(ToastView.ICON_LOADING);
            }
            if (state.getFinish()) {
                return new LoreMoreIgnore("finish");
            }
            return new LoreMoreLoading(intent.getSource());
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/e$b;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "reason", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.e$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class LoreMoreIgnore extends e {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoreMoreIgnore(@NotNull String reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof LoreMoreIgnore) && Intrinsics.areEqual(this.reason, ((LoreMoreIgnore) other).reason)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoreMoreIgnore(reason=" + this.reason + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/e$c;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.e$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class LoreMoreLoading extends e {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoreMoreLoading(@NotNull String source) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof LoreMoreLoading) && Intrinsics.areEqual(this.source, ((LoreMoreLoading) other).source)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoreMoreLoading(source=" + this.source + ")";
        }
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.mvi.h
    @NotNull
    public FeedListState a(@NotNull FeedListState oldState) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        if (!(this instanceof LoreMoreIgnore)) {
            if (this instanceof LoreMoreLoading) {
                return FeedListState.b(oldState, null, true, null, false, 0, false, 61, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        return oldState;
    }

    e() {
        super(null);
    }
}
