package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqnt.kernel.nativeinterface.SearchButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\u0016\u0010!R\u0019\u0010'\u001a\u0004\u0018\u00010#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u001a\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/v;", "", "", "b", "e", "a", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "getIcon", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "icon", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "getTitle", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "title", "c", "getSubTitle", QQWinkConstants.TAB_SUBTITLE, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "getButton", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "button", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "jumpLink", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", CacheTable.TABLE_NAME, "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.v, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class QSearchListItemModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SearchIcon icon;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SearchText title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SearchText subTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SearchButton button;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SearchJump jumpLink;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SearchReportInfo reportInfo;

    public QSearchListItemModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    @NotNull
    public final String a() {
        String str;
        SearchText searchText = this.subTitle;
        if (searchText != null) {
            str = searchText.text;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String b() {
        String str;
        SearchIcon searchIcon = this.icon;
        if (searchIcon != null) {
            str = searchIcon.iconLink;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final SearchJump getJumpLink() {
        return this.jumpLink;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    @NotNull
    public final String e() {
        String str;
        SearchText searchText = this.title;
        if (searchText != null) {
            str = searchText.text;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QSearchListItemModel)) {
            return false;
        }
        QSearchListItemModel qSearchListItemModel = (QSearchListItemModel) other;
        if (Intrinsics.areEqual(this.icon, qSearchListItemModel.icon) && Intrinsics.areEqual(this.title, qSearchListItemModel.title) && Intrinsics.areEqual(this.subTitle, qSearchListItemModel.subTitle) && Intrinsics.areEqual(this.button, qSearchListItemModel.button) && Intrinsics.areEqual(this.jumpLink, qSearchListItemModel.jumpLink) && Intrinsics.areEqual(this.reportInfo, qSearchListItemModel.reportInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        SearchIcon searchIcon = this.icon;
        int i3 = 0;
        if (searchIcon == null) {
            hashCode = 0;
        } else {
            hashCode = searchIcon.hashCode();
        }
        int i16 = hashCode * 31;
        SearchText searchText = this.title;
        if (searchText == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = searchText.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        SearchText searchText2 = this.subTitle;
        if (searchText2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = searchText2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        SearchButton searchButton = this.button;
        if (searchButton == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = searchButton.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        SearchJump searchJump = this.jumpLink;
        if (searchJump == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = searchJump.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        SearchReportInfo searchReportInfo = this.reportInfo;
        if (searchReportInfo != null) {
            i3 = searchReportInfo.hashCode();
        }
        return i26 + i3;
    }

    @NotNull
    public String toString() {
        return "QSearchListItemModel(icon=" + this.icon + ", title=" + this.title + ", subTitle=" + this.subTitle + ", button=" + this.button + ", jumpLink=" + this.jumpLink + ", reportInfo=" + this.reportInfo + ")";
    }

    public QSearchListItemModel(@Nullable SearchIcon searchIcon, @Nullable SearchText searchText, @Nullable SearchText searchText2, @Nullable SearchButton searchButton, @Nullable SearchJump searchJump, @Nullable SearchReportInfo searchReportInfo) {
        this.icon = searchIcon;
        this.title = searchText;
        this.subTitle = searchText2;
        this.button = searchButton;
        this.jumpLink = searchJump;
        this.reportInfo = searchReportInfo;
    }

    public /* synthetic */ QSearchListItemModel(SearchIcon searchIcon, SearchText searchText, SearchText searchText2, SearchButton searchButton, SearchJump searchJump, SearchReportInfo searchReportInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : searchIcon, (i3 & 2) != 0 ? null : searchText, (i3 & 4) != 0 ? null : searchText2, (i3 & 8) != 0 ? null : searchButton, (i3 & 16) != 0 ? null : searchJump, (i3 & 32) != 0 ? null : searchReportInfo);
    }
}
