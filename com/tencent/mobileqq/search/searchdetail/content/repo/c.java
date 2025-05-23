package com.tencent.mobileqq.search.searchdetail.content.repo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/repo/c;", "", "<init>", "()V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/repo/c$a;", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;", "a", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;", "b", "()Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;", "loadMoreType", "Ljava/lang/String;", "()Ljava/lang/String;", "callSource", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.repo.c$a, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class LoadMoreMessage extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final LoadMoreType loadMoreType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String callSource;

        public LoadMoreMessage(@NotNull LoadMoreType loadMoreType, @NotNull String callSource) {
            Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            this.loadMoreType = loadMoreType;
            this.callSource = callSource;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getCallSource() {
            return this.callSource;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final LoadMoreType getLoadMoreType() {
            return this.loadMoreType;
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

        public int hashCode() {
            return (this.loadMoreType.hashCode() * 31) + this.callSource.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadMoreMessage(loadMoreType=" + this.loadMoreType + ", callSource=" + this.callSource + ")";
        }
    }
}
