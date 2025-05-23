package com.tencent.ecommerce.repo.live;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0003\u0014\u001d\u001aJ2\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J(\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J\u001e\u0010\f\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\u0005H&J$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u0005H&J$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u0005H&J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0002H&J*\u0010\u0017\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00152\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u0005H&J$\u0010\u0018\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u0005H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u000bH&J!\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/repo/live/k;", "", "", "query", "couponId", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/repo/live/k$d;", "", "callback", "g", "c", "Lcom/tencent/ecommerce/repo/live/q;", "i", "product", "Lcom/tencent/ecommerce/repo/live/k$b;", "l", "j", "mediaProductId", "liveProduct", "e", "a", "", "productList", tl.h.F, "k", "f", "d", "activityIdList", "Lcom/tencent/ecommerce/repo/live/k$a;", "b", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface k {

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\f\u001a\u00020\t\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\n\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/repo/live/k$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/repo/live/k$b;", "a", "Lcom/tencent/ecommerce/repo/live/k$b;", "result", "", "Lcom/tencent/ecommerce/repo/live/q;", "b", "Ljava/util/List;", "()Ljava/util/List;", "resultList", "c", "Lcom/tencent/ecommerce/repo/live/q;", "topProduct", "d", "I", "totalCount", "e", "Z", "isEnd", "f", "Ljava/lang/Object;", "()Ljava/lang/Object;", "extra", "<init>", "(Lcom/tencent/ecommerce/repo/live/k$b;Ljava/util/List;Lcom/tencent/ecommerce/repo/live/q;IZLjava/lang/Object;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.k$d, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class PageResponse {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final CommonResponse result;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<LiveProduct> resultList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final LiveProduct topProduct;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final int totalCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isEnd;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final Object extra;

        public PageResponse(CommonResponse commonResponse, List<LiveProduct> list, LiveProduct liveProduct, int i3, boolean z16, Object obj) {
            this.result = commonResponse;
            this.resultList = list;
            this.topProduct = liveProduct;
            this.totalCount = i3;
            this.isEnd = z16;
            this.extra = obj;
        }

        /* renamed from: a, reason: from getter */
        public final Object getExtra() {
            return this.extra;
        }

        public final List<LiveProduct> b() {
            return this.resultList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            CommonResponse commonResponse = this.result;
            int hashCode = (commonResponse != null ? commonResponse.hashCode() : 0) * 31;
            List<LiveProduct> list = this.resultList;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            LiveProduct liveProduct = this.topProduct;
            int hashCode3 = (((hashCode2 + (liveProduct != null ? liveProduct.hashCode() : 0)) * 31) + this.totalCount) * 31;
            boolean z16 = this.isEnd;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode3 + i3) * 31;
            Object obj = this.extra;
            return i16 + (obj != null ? obj.hashCode() : 0);
        }

        public String toString() {
            return "PageResponse(result=" + this.result + ", resultList=" + this.resultList + ", topProduct=" + this.topProduct + ", totalCount=" + this.totalCount + ", isEnd=" + this.isEnd + ", extra=" + this.extra + ")";
        }

        public /* synthetic */ PageResponse(CommonResponse commonResponse, List list, LiveProduct liveProduct, int i3, boolean z16, Object obj, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(commonResponse, list, liveProduct, i3, z16, (i16 & 32) != 0 ? null : obj);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageResponse)) {
                return false;
            }
            PageResponse pageResponse = (PageResponse) other;
            return Intrinsics.areEqual(this.result, pageResponse.result) && Intrinsics.areEqual(this.resultList, pageResponse.resultList) && Intrinsics.areEqual(this.topProduct, pageResponse.topProduct) && this.totalCount == pageResponse.totalCount && this.isEnd == pageResponse.isEnd && Intrinsics.areEqual(this.extra, pageResponse.extra);
        }
    }

    LiveProduct a(String mediaProductId);

    Object b(List<String> list, Continuation<? super ActivityResponse> continuation);

    void c(String couponId, Function1<? super PageResponse, Unit> callback);

    LiveProduct d();

    LiveProduct e(String mediaProductId, LiveProduct liveProduct);

    LiveProduct f();

    void g(String query, String couponId, Function1<? super PageResponse, Unit> callback);

    void h(List<LiveProduct> productList, Function1<? super CommonResponse, Unit> callback);

    void i(Function1<? super LiveProduct, Unit> callback);

    void j(LiveProduct product, Function1<? super CommonResponse, Unit> callback);

    void k(LiveProduct product, Function1<? super CommonResponse, Unit> callback);

    void l(LiveProduct product, Function1<? super CommonResponse, Unit> callback);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/repo/live/k$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isSuccess", "", "Lcom/tencent/ecommerce/repo/live/l;", "b", "Ljava/util/List;", "()Ljava/util/List;", "liveActivityList", "<init>", "(ZLjava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.k$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ActivityResponse {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<LiveActivity> liveActivityList;

        public ActivityResponse(boolean z16, List<LiveActivity> list) {
            this.isSuccess = z16;
            this.liveActivityList = list;
        }

        public final List<LiveActivity> a() {
            return this.liveActivityList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            List<LiveActivity> list = this.liveActivityList;
            return i3 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "ActivityResponse(isSuccess=" + this.isSuccess + ", liveActivityList=" + this.liveActivityList + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActivityResponse)) {
                return false;
            }
            ActivityResponse activityResponse = (ActivityResponse) other;
            return this.isSuccess == activityResponse.isSuccess && Intrinsics.areEqual(this.liveActivityList, activityResponse.liveActivityList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/repo/live/k$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isSuccess", "b", "I", "code", "c", "Ljava/lang/String;", "msg", "<init>", "(ZILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.k$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class CommonResponse {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int code;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String msg;

        public CommonResponse(boolean z16, int i3, String str) {
            this.isSuccess = z16;
            this.code = i3;
            this.msg = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = ((r06 * 31) + this.code) * 31;
            String str = this.msg;
            return i3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "CommonResponse(isSuccess=" + this.isSuccess + ", code=" + this.code + ", msg=" + this.msg + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommonResponse)) {
                return false;
            }
            CommonResponse commonResponse = (CommonResponse) other;
            return this.isSuccess == commonResponse.isSuccess && this.code == commonResponse.code && Intrinsics.areEqual(this.msg, commonResponse.msg);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c {
        public static /* synthetic */ void a(k kVar, String str, String str2, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = "";
                }
                if ((i3 & 2) != 0) {
                    str2 = "";
                }
                kVar.g(str, str2, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshAll");
        }

        public static /* synthetic */ void b(k kVar, String str, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = "";
                }
                kVar.c(str, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestNextPage");
        }
    }
}
