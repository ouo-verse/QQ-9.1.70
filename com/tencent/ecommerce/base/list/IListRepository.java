package com.tencent.ecommerce.base.list;

import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004:\u0001\u0016J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH&J'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\fJ/\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00120\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/base/list/IListRepository;", "REQUEST", "BEAN", "EXTRA", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "loadFromMemory", "(Ljava/lang/Object;)Lcom/tencent/ecommerce/base/list/IListRepository$a;", "", "clearMemoryCache", "loadFromDatabase", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFirstPageFromServer", "extra", "loadNextPageFromServer", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/tencent/ecommerce/base/list/e;", "getOperatorEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "operatorEvent", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface IListRepository<REQUEST, BEAN, EXTRA> {
    void clearMemoryCache();

    SharedFlow<e<BEAN>> getOperatorEvent();

    Object loadFirstPageFromServer(REQUEST request, Continuation<? super Result<BEAN, EXTRA>> continuation);

    Object loadFromDatabase(REQUEST request, Continuation<? super Result<BEAN, EXTRA>> continuation);

    Result<BEAN, EXTRA> loadFromMemory(REQUEST request);

    Object loadNextPageFromServer(REQUEST request, EXTRA extra, Continuation<? super Result<BEAN, EXTRA>> continuation);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u00022\u00020\u0003B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJL\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0004H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00d6\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0019\u0010\t\u001a\u0004\u0018\u00018\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/base/list/IListRepository$a;", "BEAN", "EXTRA", "", "", "isSucceeded", "", "list", "hasMore", "extra", "a", "(ZLjava/util/List;ZLjava/lang/Object;)Lcom/tencent/ecommerce/base/list/IListRepository$a;", "", "toString", "", "hashCode", "other", "equals", "Z", "b", "Ljava/util/List;", "d", "()Ljava/util/List;", "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "<init>", "(ZLjava/util/List;ZLjava/lang/Object;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.list.IListRepository$a, reason: from toString */
    /* loaded from: classes32.dex */
    public static final /* data */ class Result<BEAN, EXTRA> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isSucceeded;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<BEAN> list;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean hasMore;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final EXTRA extra;

        /* JADX WARN: Multi-variable type inference failed */
        public Result(boolean z16, List<? extends BEAN> list, boolean z17, EXTRA extra) {
            this.isSucceeded = z16;
            this.list = list;
            this.hasMore = z17;
            this.extra = extra;
        }

        public final Result<BEAN, EXTRA> a(boolean isSucceeded, List<? extends BEAN> list, boolean hasMore, EXTRA extra) {
            return new Result<>(isSucceeded, list, hasMore, extra);
        }

        public final EXTRA c() {
            return this.extra;
        }

        public final List<BEAN> d() {
            return this.list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z16 = this.isSucceeded;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            List<BEAN> list = this.list;
            int hashCode = (i3 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z17 = this.hasMore;
            int i16 = (hashCode + (z17 ? 1 : z17 ? 1 : 0)) * 31;
            EXTRA extra = this.extra;
            return i16 + (extra != null ? extra.hashCode() : 0);
        }

        public String toString() {
            return "Result(isSucceeded=" + this.isSucceeded + ", list=" + this.list + ", hasMore=" + this.hasMore + ", extra=" + this.extra + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return this.isSucceeded == result.isSucceeded && Intrinsics.areEqual(this.list, result.list) && this.hasMore == result.hasMore && Intrinsics.areEqual(this.extra, result.extra);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result b(Result result, boolean z16, List list, boolean z17, Object obj, int i3, Object obj2) {
            if ((i3 & 1) != 0) {
                z16 = result.isSucceeded;
            }
            if ((i3 & 2) != 0) {
                list = result.list;
            }
            if ((i3 & 4) != 0) {
                z17 = result.hasMore;
            }
            if ((i3 & 8) != 0) {
                obj = result.extra;
            }
            return result.a(z16, list, z17, obj);
        }
    }
}
