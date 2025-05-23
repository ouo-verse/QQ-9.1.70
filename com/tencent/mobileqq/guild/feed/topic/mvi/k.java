package com.tencent.mobileqq.guild.feed.topic.mvi;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00052\u00060\u0001j\u0002`\u0002:\u0003\u0005\b\tB\t\b\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u0082\u0001\u0002\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/k;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/h;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/TopicFeedsRspChanger;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/a;", "oldState", "a", "<init>", "()V", "b", "c", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/k$b;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/k$c;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class k extends h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/k$a;", "", "Lcom/tencent/mobileqq/guild/feed/topic/g;", "Lcom/tencent/mobileqq/guild/feed/topic/RefreshRsp;", "rsp", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/k;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.k$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final k a(@NotNull com.tencent.mobileqq.guild.feed.topic.g rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            if (rsp.getRspStatus().d()) {
                return new RefreshRspSuccess(new com.tencent.mobileqq.guild.feed.topic.h(rsp.a()), rsp.getIsFinish());
            }
            return new RefreshRspFail(rsp.getRspStatus());
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/k$b;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/k;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lri1/a;", "b", "Lri1/a;", "()Lri1/a;", "success", "<init>", "(Lri1/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.k$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class RefreshRspFail extends k {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ri1.a success;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefreshRspFail(@NotNull ri1.a success) {
            super(null);
            Intrinsics.checkNotNullParameter(success, "success");
            this.success = success;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final ri1.a getSuccess() {
            return this.success;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RefreshRspFail) && Intrinsics.areEqual(this.success, ((RefreshRspFail) other).success)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.success.hashCode();
        }

        @NotNull
        public String toString() {
            return "RefreshRspFail(success=" + this.success + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f\u0012\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R!\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\r\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/k$c;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/k;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/topic/h;", "Lvn1/b;", "Lcom/tencent/mobileqq/guild/feed/topic/TopicFeedList;", "b", "Lcom/tencent/mobileqq/guild/feed/topic/h;", "c", "()Lcom/tencent/mobileqq/guild/feed/topic/h;", "list", "Z", "()Z", "finish", "<init>", "(Lcom/tencent/mobileqq/guild/feed/topic/h;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.k$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class RefreshRspSuccess extends k {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.mobileqq.guild.feed.topic.h<vn1.b> list;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean finish;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefreshRspSuccess(@NotNull com.tencent.mobileqq.guild.feed.topic.h<vn1.b> list, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.finish = z16;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getFinish() {
            return this.finish;
        }

        @NotNull
        public final com.tencent.mobileqq.guild.feed.topic.h<vn1.b> c() {
            return this.list;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RefreshRspSuccess)) {
                return false;
            }
            RefreshRspSuccess refreshRspSuccess = (RefreshRspSuccess) other;
            if (Intrinsics.areEqual(this.list, refreshRspSuccess.list) && this.finish == refreshRspSuccess.finish) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.list.hashCode() * 31;
            boolean z16 = this.finish;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "RefreshRspSuccess(list=" + this.list + ", finish=" + this.finish + ")";
        }
    }

    public /* synthetic */ k(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.mvi.h
    @NotNull
    public FeedListState a(@NotNull FeedListState oldState) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        if (this instanceof RefreshRspSuccess) {
            ri1.a f16 = ri1.a.f();
            Intrinsics.checkNotNullExpressionValue(f16, "ok()");
            RefreshRspSuccess refreshRspSuccess = (RefreshRspSuccess) this;
            return FeedListState.b(oldState, f16, false, refreshRspSuccess.c(), refreshRspSuccess.getFinish(), 0, false, 50, null);
        }
        if (this instanceof RefreshRspFail) {
            return FeedListState.b(oldState, ((RefreshRspFail) this).getSuccess(), false, null, false, 0, false, 62, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    k() {
        super(null);
    }
}
