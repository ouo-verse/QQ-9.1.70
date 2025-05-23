package ck1;

import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lck1/a;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "b", "Lck1/a$a;", "Lck1/a$b;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\tR#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lck1/a$a;", "Lck1/a;", "Lkotlin/Pair;", "", "a", "Lkotlin/Pair;", "()Lkotlin/Pair;", "posRange", "<init>", "(Lkotlin/Pair;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ck1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C0197a extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Pair<Integer, Integer> posRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0197a(@NotNull Pair<Integer, Integer> posRange) {
            super(null);
            Intrinsics.checkNotNullParameter(posRange, "posRange");
            this.posRange = posRange;
        }

        @NotNull
        public final Pair<Integer, Integer> a() {
            return this.posRange;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lck1/a$b;", "Lck1/a;", "", "a", "I", "()I", "feedSortMode", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int feedSortMode;

        public b(int i3) {
            super(null);
            this.feedSortMode = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getFeedSortMode() {
            return this.feedSortMode;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
