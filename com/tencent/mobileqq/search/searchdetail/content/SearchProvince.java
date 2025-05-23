package com.tencent.mobileqq.search.searchdetail.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.search.searchdetail.content.SearchCity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 #2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b \u0010!B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR6\u0010\u001a\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012`\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u0014\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchProvince;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "name", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchCity;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "setCitys", "(Ljava/util/ArrayList;)V", "citys", "I", "a", "()I", "(I)V", "cityId", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchProvince implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<SearchCity> citys;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int cityId;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchProvince$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchProvince;", "Landroid/os/Parcel;", "parcel", "b", "", "size", "", "c", "(I)[Lcom/tencent/mobileqq/search/searchdetail/content/SearchProvince;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchProvince;", "sdk", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.SearchProvince$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion implements Parcelable.Creator<SearchProvince> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchProvince a(@NotNull com.tencent.qqnt.kernel.nativeinterface.SearchProvince sdk) {
            Intrinsics.checkNotNullParameter(sdk, "sdk");
            SearchProvince searchProvince = new SearchProvince();
            searchProvince.e(sdk.cityId);
            String str = sdk.name;
            Intrinsics.checkNotNullExpressionValue(str, "sdk.name");
            searchProvince.f(str);
            ArrayList<com.tencent.qqnt.kernel.nativeinterface.SearchCity> arrayList = sdk.citys;
            Intrinsics.checkNotNullExpressionValue(arrayList, "sdk.citys");
            for (com.tencent.qqnt.kernel.nativeinterface.SearchCity it : arrayList) {
                ArrayList<SearchCity> b16 = searchProvince.b();
                SearchCity.Companion companion = SearchCity.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                b16.add(companion.a(it));
            }
            return searchProvince;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SearchProvince createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SearchProvince(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SearchProvince[] newArray(int size) {
            return new SearchProvince[size];
        }

        Companion() {
        }
    }

    public SearchProvince() {
        this.name = "";
        this.citys = new ArrayList<>();
    }

    /* renamed from: a, reason: from getter */
    public final int getCityId() {
        return this.cityId;
    }

    @NotNull
    public final ArrayList<SearchCity> b() {
        return this.citys;
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

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeList(this.citys);
        parcel.writeInt(this.cityId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchProvince(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.name = readString == null ? "" : readString;
        parcel.readList(this.citys, SearchCity.Companion.class.getClassLoader());
        this.cityId = parcel.readInt();
    }
}
