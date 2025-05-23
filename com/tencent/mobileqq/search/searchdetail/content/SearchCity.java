package com.tencent.mobileqq.search.searchdetail.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.search.searchdetail.content.SearchDistrict;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 (2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020\u0004\u00a2\u0006\u0004\b$\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR2\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R2\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0011j\b\u0012\u0004\u0012\u00020\u001a`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\u0013\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchCity;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "name", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "getDistricts", "()Ljava/util/ArrayList;", "f", "(Ljava/util/ArrayList;)V", "districts", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchDistrict;", "b", "setDistrictsNewList", "districtsNewList", h.F, "I", "a", "()I", "(I)V", "cityId", "<init>", "()V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchCity implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> districts;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<SearchDistrict> districtsNewList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int cityId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchCity$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchCity;", "Landroid/os/Parcel;", "parcel", "b", "", "size", "", "c", "(I)[Lcom/tencent/mobileqq/search/searchdetail/content/SearchCity;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchCity;", "sdk", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.SearchCity$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion implements Parcelable.Creator<SearchCity> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchCity a(@NotNull com.tencent.qqnt.kernel.nativeinterface.SearchCity sdk) {
            Intrinsics.checkNotNullParameter(sdk, "sdk");
            SearchCity searchCity = new SearchCity();
            searchCity.e(sdk.cityId);
            String str = sdk.name;
            Intrinsics.checkNotNullExpressionValue(str, "sdk.name");
            searchCity.g(str);
            ArrayList<String> arrayList = sdk.districts;
            Intrinsics.checkNotNullExpressionValue(arrayList, "sdk.districts");
            searchCity.f(arrayList);
            ArrayList<com.tencent.qqnt.kernel.nativeinterface.SearchDistrict> arrayList2 = sdk.districtsNewList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "sdk.districtsNewList");
            for (com.tencent.qqnt.kernel.nativeinterface.SearchDistrict it : arrayList2) {
                ArrayList<SearchDistrict> b16 = searchCity.b();
                SearchDistrict.Companion companion = SearchDistrict.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                b16.add(companion.a(it));
            }
            return searchCity;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SearchCity createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SearchCity[] newArray(int size) {
            return new SearchCity[size];
        }

        Companion() {
        }
    }

    public SearchCity() {
        this.name = "";
        this.districts = new ArrayList<>();
        this.districtsNewList = new ArrayList<>();
    }

    /* renamed from: a, reason: from getter */
    public final int getCityId() {
        return this.cityId;
    }

    @NotNull
    public final ArrayList<SearchDistrict> b() {
        return this.districtsNewList;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(int i3) {
        this.cityId = i3;
    }

    public final void f(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.districts = arrayList;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.name);
        dest.writeStringList(this.districts);
        dest.writeList(this.districtsNewList);
        dest.writeInt(this.cityId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchCity(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.name = readString == null ? "" : readString;
        parcel.readStringList(this.districts);
        parcel.readList(this.districtsNewList, SearchDistrict.Companion.class.getClassLoader());
        this.cityId = parcel.readInt();
    }
}
