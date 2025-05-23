package com.tencent.mobileqq.guild.discoveryv2.content.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\tB\u0011\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0002\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k;", "", "", "a", "Z", "()Z", "refreshing", "<init>", "(Z)V", "b", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k$a;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k$b;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean refreshing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k$a;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Z", "getImmediate", "()Z", "immediate", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.model.k$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class RefreshFinish extends k {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean immediate;

        public RefreshFinish(boolean z16) {
            super(false, null);
            this.immediate = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RefreshFinish) && this.immediate == ((RefreshFinish) other).immediate) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.immediate;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "RefreshFinish(immediate=" + this.immediate + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k$b;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/k;", "", "toString", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends k {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final b f217043b = new b();

        b() {
            super(true, null);
        }

        @NotNull
        public String toString() {
            return "Refreshing";
        }
    }

    public /* synthetic */ k(boolean z16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getRefreshing() {
        return this.refreshing;
    }

    k(boolean z16) {
        this.refreshing = z16;
    }
}
