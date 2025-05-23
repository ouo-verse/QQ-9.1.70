package com.tencent.mobileqq.search.searchdetail.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0011\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupContentRankType;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "I", "a", "()I", "c", "(I)V", "rankTypeId", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "rankTypeText", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchGroupContentRankType implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int rankTypeId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String rankTypeText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupContentRankType$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupContentRankType;", "Landroid/os/Parcel;", "parcel", "b", "", "size", "", "c", "(I)[Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupContentRankType;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupContentRankType;", "sdk", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.SearchGroupContentRankType$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion implements Parcelable.Creator<SearchGroupContentRankType> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchGroupContentRankType a(@NotNull com.tencent.qqnt.kernel.nativeinterface.SearchGroupContentRankType sdk) {
            Intrinsics.checkNotNullParameter(sdk, "sdk");
            SearchGroupContentRankType searchGroupContentRankType = new SearchGroupContentRankType();
            searchGroupContentRankType.c(sdk.rankTypeId);
            String str = sdk.rankTypeText;
            Intrinsics.checkNotNullExpressionValue(str, "sdk.rankTypeText");
            searchGroupContentRankType.e(str);
            return searchGroupContentRankType;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SearchGroupContentRankType createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SearchGroupContentRankType(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SearchGroupContentRankType[] newArray(int size) {
            return new SearchGroupContentRankType[size];
        }

        Companion() {
        }
    }

    public SearchGroupContentRankType() {
        this.rankTypeText = "";
    }

    /* renamed from: a, reason: from getter */
    public final int getRankTypeId() {
        return this.rankTypeId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRankTypeText() {
        return this.rankTypeText;
    }

    public final void c(int i3) {
        this.rankTypeId = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rankTypeText = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.rankTypeId);
        parcel.writeString(this.rankTypeText);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchGroupContentRankType(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.rankTypeId = parcel.readInt();
        String readString = parcel.readString();
        this.rankTypeText = readString == null ? "" : readString;
    }
}
