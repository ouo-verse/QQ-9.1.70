package com.tencent.sqshow.zootopia.data;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\nBM\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR2\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/data/g;", "a", "Lcom/tencent/sqshow/zootopia/data/g;", "b", "()Lcom/tencent/sqshow/zootopia/data/g;", "setCurrentData", "(Lcom/tencent/sqshow/zootopia/data/g;)V", "currentData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "f", "(Ljava/util/ArrayList;)V", "cardList", "c", "Z", "()Z", "hasMore", "", "d", "[B", "()[B", "pagInfo", "e", "g", "(Z)V", "isRefresh", "<init>", "(Lcom/tencent/sqshow/zootopia/data/g;Ljava/util/ArrayList;Z[BZ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.h, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaDetailFeedsListData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaDetailFeedsCardData currentData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private ArrayList<ZootopiaDetailFeedsCardData> cardList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasMore;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final byte[] pagInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isRefresh;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"JC\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001dR\u0014\u0010\u001f\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/h$a;", "", "Lpu4/n;", "currentData", "", "Lpv4/t;", "groupList", "", "hasMore", "", "pageInfo", "", "status", "Lcom/tencent/sqshow/zootopia/data/h;", "a", "(Lpu4/n;[Lpv4/t;Z[BI)Lcom/tencent/sqshow/zootopia/data/h;", "Lpv4/r;", "sceneIndexModules", "", "e", "([Lpv4/r;)Ljava/util/List;", "data", "", "f", "Liw4/b;", "rsp", "b", "Liw4/f;", "c", "Liw4/h;", "d", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.h$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ZootopiaDetailFeedsListData a(pu4.n currentData, pv4.t[] groupList, boolean hasMore, byte[] pageInfo, int status) {
            IntRange indices;
            ZootopiaDetailFeedsListData zootopiaDetailFeedsListData = new ZootopiaDetailFeedsListData(new ZootopiaDetailFeedsCardData(0, currentData, status), null, hasMore, pageInfo, false, 18, null);
            ArrayList<ZootopiaDetailFeedsCardData> arrayList = new ArrayList<>();
            if ((groupList != null ? groupList.length : 0) < 0) {
                return zootopiaDetailFeedsListData;
            }
            if (groupList != null && (indices = ArraysKt.getIndices(groupList)) != null) {
                Iterator<Integer> it = indices.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    List<pv4.r> e16 = ZootopiaDetailFeedsListData.INSTANCE.e(groupList[nextInt].f427699d);
                    if (!e16.isEmpty()) {
                        int size = e16.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList.add(ZootopiaDetailFeedsCardData.INSTANCE.b(e16.get(i3), nextInt));
                        }
                    }
                }
            }
            zootopiaDetailFeedsListData.f(arrayList);
            return zootopiaDetailFeedsListData;
        }

        private final List<pv4.r> e(pv4.r[] sceneIndexModules) {
            ArrayList arrayList = new ArrayList();
            if (sceneIndexModules == null || sceneIndexModules.length < 0) {
                return arrayList;
            }
            for (pv4.r rVar : sceneIndexModules) {
                if (rVar.f427657a != 0) {
                    arrayList.add(rVar);
                } else {
                    QLog.e("ZootopiaDetailFeedsListData", 1, "!!!invalid card data - " + rVar);
                }
            }
            return arrayList;
        }

        public final ZootopiaDetailFeedsListData b(iw4.b rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            return a(rsp.f408873a, rsp.f408876d, rsp.f408874b, rsp.f408875c, rsp.f408879g);
        }

        public final ZootopiaDetailFeedsListData c(iw4.f rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            return a(null, rsp.f408886c, rsp.f408884a, rsp.f408885b, 0);
        }

        public final ZootopiaDetailFeedsListData d(iw4.h rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            return a(null, rsp.f408894c, rsp.f408892a, rsp.f408893b, 0);
        }

        public final String f(ZootopiaDetailFeedsListData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            StringBuilder sb5 = new StringBuilder("getListDataLogString");
            ArrayList<ZootopiaDetailFeedsCardData> a16 = data.a();
            if (a16 == null || a16.isEmpty()) {
                sb5.append("list is null or empty");
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
                return sb6;
            }
            int size = data.a().size();
            for (int i3 = 0; i3 < size; i3++) {
                sb5.append("position: " + i3 + ", id:" + data + ".cardList[i].outfitWorksInfo?.detailInfo?.id");
            }
            String sb7 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb7, "builder.toString()");
            return sb7;
        }

        Companion() {
        }
    }

    public ZootopiaDetailFeedsListData() {
        this(null, null, false, null, false, 31, null);
    }

    public final ArrayList<ZootopiaDetailFeedsCardData> a() {
        return this.cardList;
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaDetailFeedsCardData getCurrentData() {
        return this.currentData;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: d, reason: from getter */
    public final byte[] getPagInfo() {
        return this.pagInfo;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    public final void f(ArrayList<ZootopiaDetailFeedsCardData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.cardList = arrayList;
    }

    public final void g(boolean z16) {
        this.isRefresh = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = this.currentData;
        int hashCode = (((zootopiaDetailFeedsCardData == null ? 0 : zootopiaDetailFeedsCardData.hashCode()) * 31) + this.cardList.hashCode()) * 31;
        boolean z16 = this.hasMore;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        byte[] bArr = this.pagInfo;
        int hashCode2 = (i16 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        boolean z17 = this.isRefresh;
        return hashCode2 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "ZootopiaDetailFeedsListData(currentData=" + this.currentData + ", cardList=" + this.cardList + ", hasMore=" + this.hasMore + ", pagInfo=" + Arrays.toString(this.pagInfo) + ", isRefresh=" + this.isRefresh + ")";
    }

    public ZootopiaDetailFeedsListData(ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData, ArrayList<ZootopiaDetailFeedsCardData> cardList, boolean z16, byte[] bArr, boolean z17) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        this.currentData = zootopiaDetailFeedsCardData;
        this.cardList = cardList;
        this.hasMore = z16;
        this.pagInfo = bArr;
        this.isRefresh = z17;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaDetailFeedsListData)) {
            return false;
        }
        ZootopiaDetailFeedsListData zootopiaDetailFeedsListData = (ZootopiaDetailFeedsListData) other;
        return Intrinsics.areEqual(this.currentData, zootopiaDetailFeedsListData.currentData) && Intrinsics.areEqual(this.cardList, zootopiaDetailFeedsListData.cardList) && this.hasMore == zootopiaDetailFeedsListData.hasMore && Intrinsics.areEqual(this.pagInfo, zootopiaDetailFeedsListData.pagInfo) && this.isRefresh == zootopiaDetailFeedsListData.isRefresh;
    }

    public /* synthetic */ ZootopiaDetailFeedsListData(ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData, ArrayList arrayList, boolean z16, byte[] bArr, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : zootopiaDetailFeedsCardData, (i3 & 2) != 0 ? new ArrayList() : arrayList, (i3 & 4) != 0 ? false : z16, (i3 & 8) == 0 ? bArr : null, (i3 & 16) != 0 ? true : z17);
    }
}
