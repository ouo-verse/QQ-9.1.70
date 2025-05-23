package com.tencent.mobileqq.search.searchdetail.content.template.model;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchDoubleColumnList;
import com.tencent.qqnt.kernel.nativeinterface.SearchListDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00011B\u0017\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eRR\u0010)\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"0 j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"`\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/l;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "getItemType", "", "toString", "", "other", "", "equals", "hashCode", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchDoubleColumnList;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchDoubleColumnList;", "getDoubleColumnList", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchDoubleColumnList;", "doubleColumnList", "H", "Ljava/lang/String;", HippyTKDListViewAdapter.X, "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "I", "y", "()I", "setTotalItemSize", "(I)V", "totalItemSize", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchListDetail;", "Lkotlin/collections/ArrayList;", "J", "Ljava/util/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/util/ArrayList;", "setTwoDimensionDetailList", "(Ljava/util/ArrayList;)V", "twoDimensionDetailList", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "searchTemplate", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "K", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.l, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchTemplateDoubleColumnListItem extends a {

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @Nullable
    private final SearchDoubleColumnList doubleColumnList;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private String title;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private int totalItemSize;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private ArrayList<ArrayList<SearchListDetail>> twoDimensionDetailList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchTemplateDoubleColumnListItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate searchTemplate) {
        super(commonInfo, searchTemplate);
        String str;
        int i3;
        ArrayList<SearchListDetail> arrayList;
        SearchText searchText;
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(searchTemplate, "searchTemplate");
        this.title = "";
        this.twoDimensionDetailList = new ArrayList<>();
        SearchDoubleColumnList searchDoubleColumnList = searchTemplate.doubleColumnList;
        this.doubleColumnList = searchDoubleColumnList;
        if (searchDoubleColumnList != null && (searchText = searchDoubleColumnList.title) != null) {
            str = searchText.text;
        } else {
            str = null;
        }
        this.title = str != null ? str : "";
        if (searchDoubleColumnList != null && (arrayList = searchDoubleColumnList.listList) != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        this.totalItemSize = i3;
        A();
    }

    private final void A() {
        if (this.doubleColumnList != null) {
            int i3 = this.totalItemSize;
            int i16 = i3 / 2;
            int i17 = i3 % 2;
            if (i17 > 0) {
                i16++;
            }
            for (int i18 = 0; i18 < i16; i18++) {
                ArrayList<SearchListDetail> arrayList = new ArrayList<>();
                if (i18 == i16 - 1 && i17 > 0) {
                    for (int i19 = 0; i19 < i17; i19++) {
                        arrayList.add(this.doubleColumnList.listList.get((i18 * 2) + i19));
                    }
                } else {
                    for (int i26 = 0; i26 < 2; i26++) {
                        arrayList.add(this.doubleColumnList.listList.get((i18 * 2) + i26));
                    }
                }
                this.twoDimensionDetailList.add(arrayList);
            }
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetSearchTemplateDoubleColumnListItem) || !super.equals(other)) {
            return false;
        }
        NetSearchTemplateDoubleColumnListItem netSearchTemplateDoubleColumnListItem = (NetSearchTemplateDoubleColumnListItem) other;
        if (Intrinsics.areEqual(this.doubleColumnList, netSearchTemplateDoubleColumnListItem.doubleColumnList) && Intrinsics.areEqual(this.title, netSearchTemplateDoubleColumnListItem.title) && this.totalItemSize == netSearchTemplateDoubleColumnListItem.totalItemSize && Intrinsics.areEqual(this.twoDimensionDetailList, netSearchTemplateDoubleColumnListItem.twoDimensionDetailList)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 9;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public int hashCode() {
        int i3;
        int hashCode = super.hashCode() * 31;
        SearchDoubleColumnList searchDoubleColumnList = this.doubleColumnList;
        if (searchDoubleColumnList != null) {
            i3 = searchDoubleColumnList.hashCode();
        } else {
            i3 = 0;
        }
        return ((((((hashCode + i3) * 31) + this.title.hashCode()) * 31) + this.totalItemSize) * 31) + this.twoDimensionDetailList.hashCode();
    }

    @NotNull
    public String toString() {
        return "NetSearchTemplateDoubleColumnListItem(commonInfo=" + getCommonInfo() + ", doubleColumnList=" + this.doubleColumnList + ", title='" + this.title + "', totalItemSize=" + this.totalItemSize + ", twoDimensionDetailList=" + this.twoDimensionDetailList + ")";
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: y, reason: from getter */
    public final int getTotalItemSize() {
        return this.totalItemSize;
    }

    @NotNull
    public final ArrayList<ArrayList<SearchListDetail>> z() {
        return this.twoDimensionDetailList;
    }
}
