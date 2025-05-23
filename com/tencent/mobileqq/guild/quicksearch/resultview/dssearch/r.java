package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r$a;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r$b;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r$c;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r$d;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class r {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r$a;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "reason", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.r$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class Error extends r {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Error) && Intrinsics.areEqual(this.reason, ((Error) other).reason)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        @NotNull
        public String toString() {
            return "Error(reason=" + this.reason + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r$b;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends r {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f231719a = new b();

        b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r$c;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends r {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f231720a = new c();

        c() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r$d;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends r {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f231721a = new d();

        d() {
            super(null);
        }
    }

    public /* synthetic */ r(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    r() {
    }
}
