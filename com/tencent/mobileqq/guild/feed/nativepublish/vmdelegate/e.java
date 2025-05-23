package com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate;

import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/e;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/e$a;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class e implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u000e\u0010\u0013\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001f\u0010\u0013\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/e$a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "cacheHit", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorDraftModel;", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "draft", "<init>", "(ZLcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.e$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class QueryLastDraftResult extends e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean cacheHit;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProGuildFeedDraft draft;

        public QueryLastDraftResult(boolean z16, @Nullable GProGuildFeedDraft gProGuildFeedDraft) {
            super(null);
            this.cacheHit = z16;
            this.draft = gProGuildFeedDraft;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCacheHit() {
            return this.cacheHit;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final GProGuildFeedDraft getDraft() {
            return this.draft;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QueryLastDraftResult)) {
                return false;
            }
            QueryLastDraftResult queryLastDraftResult = (QueryLastDraftResult) other;
            if (this.cacheHit == queryLastDraftResult.cacheHit && Intrinsics.areEqual(this.draft, queryLastDraftResult.draft)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.cacheHit;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            GProGuildFeedDraft gProGuildFeedDraft = this.draft;
            if (gProGuildFeedDraft == null) {
                hashCode = 0;
            } else {
                hashCode = gProGuildFeedDraft.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "QueryLastDraftResult(cacheHit=" + this.cacheHit + ", draft=" + this.draft + ")";
        }
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    e() {
    }
}
