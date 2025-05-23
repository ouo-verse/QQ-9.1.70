package kn1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0003\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lkn1/a;", "", "Lkn1/b;", "a", "Lkn1/b;", "()Lkn1/b;", "state", "<init>", "(Lkn1/b;)V", "b", "c", "Lkn1/a$a;", "Lkn1/a$b;", "Lkn1/a$c;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FeedPublishStateV2 state;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lkn1/a$a;", "Lkn1/a;", "", "toString", "Lkn1/b;", "state", "<init>", "(Lkn1/b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kn1.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes13.dex */
    public static final class FeedPublishBegin extends a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedPublishBegin(@NotNull FeedPublishStateV2 state) {
            super(state, null);
            Intrinsics.checkNotNullParameter(state, "state");
        }

        @NotNull
        public String toString() {
            return "FeedPublishBegin(state=" + getState() + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lkn1/a$b;", "Lkn1/a;", "", "toString", "Lkn1/b;", "state", "<init>", "(Lkn1/b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kn1.a$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final class FeedPublishFinish extends a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedPublishFinish(@NotNull FeedPublishStateV2 state) {
            super(state, null);
            Intrinsics.checkNotNullParameter(state, "state");
        }

        @NotNull
        public String toString() {
            return "FeedPublishFinish(state=" + getState() + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lkn1/a$c;", "Lkn1/a;", "", "toString", "Lkn1/b;", "state", "<init>", "(Lkn1/b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kn1.a$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final class FeedPublishUpdate extends a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedPublishUpdate(@NotNull FeedPublishStateV2 state) {
            super(state, null);
            Intrinsics.checkNotNullParameter(state, "state");
        }

        @NotNull
        public String toString() {
            return "FeedPublishUpdate(state=" + getState() + ")";
        }
    }

    public /* synthetic */ a(FeedPublishStateV2 feedPublishStateV2, DefaultConstructorMarker defaultConstructorMarker) {
        this(feedPublishStateV2);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final FeedPublishStateV2 getState() {
        return this.state;
    }

    a(FeedPublishStateV2 feedPublishStateV2) {
        this.state = feedPublishStateV2;
    }
}
