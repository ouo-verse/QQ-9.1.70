package com.tencent.mobileqq.search.searchdetail.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.search.searchdetail.content.SearchGroupContentRankType;
import com.tencent.mobileqq.search.searchdetail.content.SearchProvince;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupSearchFilterCondition;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 %2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R2\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R2\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00130\tj\b\u0012\u0004\u0012\u00020\u0013`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R2\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00170\tj\b\u0012\u0004\u0012\u00020\u0017`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\u0018\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupFilterConditionLocal;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "e", "()Ljava/util/ArrayList;", "g", "(Ljava/util/ArrayList;)V", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "Lcom/tencent/mobileqq/search/searchdetail/content/SearchProvince;", "a", "setGeoInfoList", "geoInfoList", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupContentRankType;", "f", "c", "setGroupContentRankTypeList", "groupContentRankTypeList", h.F, "I", "b", "()I", "(I)V", "geoInfoVersion", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchGroupFilterConditionLocal implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> tags;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<SearchProvince> geoInfoList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<SearchGroupContentRankType> groupContentRankTypeList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int geoInfoVersion;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupFilterConditionLocal$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupFilterConditionLocal;", "Landroid/os/Parcel;", "parcel", "b", "", "size", "", "c", "(I)[Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupFilterConditionLocal;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupSearchFilterCondition;", "condition", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.SearchGroupFilterConditionLocal$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion implements Parcelable.Creator<SearchGroupFilterConditionLocal> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchGroupFilterConditionLocal a(@NotNull SearchGroupSearchFilterCondition condition) {
            Intrinsics.checkNotNullParameter(condition, "condition");
            SearchGroupFilterConditionLocal searchGroupFilterConditionLocal = new SearchGroupFilterConditionLocal();
            ArrayList<String> arrayList = condition.tags;
            Intrinsics.checkNotNullExpressionValue(arrayList, "condition.tags");
            searchGroupFilterConditionLocal.g(arrayList);
            ArrayList<com.tencent.qqnt.kernel.nativeinterface.SearchProvince> arrayList2 = condition.geoInfoList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "condition.geoInfoList");
            for (com.tencent.qqnt.kernel.nativeinterface.SearchProvince it : arrayList2) {
                ArrayList<SearchProvince> a16 = searchGroupFilterConditionLocal.a();
                SearchProvince.Companion companion = SearchProvince.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                a16.add(companion.a(it));
            }
            ArrayList<com.tencent.qqnt.kernel.nativeinterface.SearchGroupContentRankType> arrayList3 = condition.groupContentRankTypeList;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "condition.groupContentRankTypeList");
            for (com.tencent.qqnt.kernel.nativeinterface.SearchGroupContentRankType it5 : arrayList3) {
                ArrayList<SearchGroupContentRankType> c16 = searchGroupFilterConditionLocal.c();
                SearchGroupContentRankType.Companion companion2 = SearchGroupContentRankType.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                c16.add(companion2.a(it5));
            }
            searchGroupFilterConditionLocal.f(condition.geoInfoVersion);
            return searchGroupFilterConditionLocal;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SearchGroupFilterConditionLocal createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SearchGroupFilterConditionLocal(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SearchGroupFilterConditionLocal[] newArray(int size) {
            return new SearchGroupFilterConditionLocal[size];
        }

        Companion() {
        }
    }

    public SearchGroupFilterConditionLocal() {
        this.tags = new ArrayList<>();
        this.geoInfoList = new ArrayList<>();
        this.groupContentRankTypeList = new ArrayList<>();
    }

    @NotNull
    public final ArrayList<SearchProvince> a() {
        return this.geoInfoList;
    }

    /* renamed from: b, reason: from getter */
    public final int getGeoInfoVersion() {
        return this.geoInfoVersion;
    }

    @NotNull
    public final ArrayList<SearchGroupContentRankType> c() {
        return this.groupContentRankTypeList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final ArrayList<String> e() {
        return this.tags;
    }

    public final void f(int i3) {
        this.geoInfoVersion = i3;
    }

    public final void g(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.tags = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeStringList(this.tags);
        parcel.writeList(this.geoInfoList);
        parcel.writeList(this.groupContentRankTypeList);
        parcel.writeInt(this.geoInfoVersion);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchGroupFilterConditionLocal(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.readStringList(this.tags);
        parcel.readList(this.geoInfoList, SearchProvince.Companion.class.getClassLoader());
        parcel.readList(this.groupContentRankTypeList, SearchProvince.Companion.class.getClassLoader());
        this.geoInfoVersion = parcel.readInt();
    }
}
