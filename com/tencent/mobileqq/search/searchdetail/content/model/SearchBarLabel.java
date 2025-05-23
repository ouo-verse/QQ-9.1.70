package com.tencent.mobileqq.search.searchdetail.content.model;

import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010 \u001a\u0004\b\n\u0010!\"\u0004\b\"\u0010#R$\u0010*\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010&\u001a\u0004\b\u0012\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/search/searchdetail/content/model/i;", "a", "Lcom/tencent/mobileqq/search/searchdetail/content/model/i;", "getTagIcon", "()Lcom/tencent/mobileqq/search/searchdetail/content/model/i;", "g", "(Lcom/tencent/mobileqq/search/searchdetail/content/model/i;)V", "tagIcon", "Lcom/tencent/mobileqq/search/searchdetail/content/model/j;", "b", "Lcom/tencent/mobileqq/search/searchdetail/content/model/j;", "c", "()Lcom/tencent/mobileqq/search/searchdetail/content/model/j;", tl.h.F, "(Lcom/tencent/mobileqq/search/searchdetail/content/model/j;)V", "tagText", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "text", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "e", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;)V", "clickJump", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "f", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;)V", CacheTable.TABLE_NAME, "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/model/i;Lcom/tencent/mobileqq/search/searchdetail/content/model/j;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.model.f, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class SearchBarLabel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private TagIcon tagIcon;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private TagText tagText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private SearchJump clickJump;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private SearchReportInfo reportInfo;

    public SearchBarLabel() {
        this(null, null, null, null, null, 31, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final SearchJump getClickJump() {
        return this.clickJump;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final TagText getTagText() {
        return this.tagText;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final void e(@Nullable SearchJump searchJump) {
        this.clickJump = searchJump;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchBarLabel)) {
            return false;
        }
        SearchBarLabel searchBarLabel = (SearchBarLabel) other;
        if (Intrinsics.areEqual(this.tagIcon, searchBarLabel.tagIcon) && Intrinsics.areEqual(this.tagText, searchBarLabel.tagText) && Intrinsics.areEqual(this.text, searchBarLabel.text) && Intrinsics.areEqual(this.clickJump, searchBarLabel.clickJump) && Intrinsics.areEqual(this.reportInfo, searchBarLabel.reportInfo)) {
            return true;
        }
        return false;
    }

    public final void f(@Nullable SearchReportInfo searchReportInfo) {
        this.reportInfo = searchReportInfo;
    }

    public final void g(@Nullable TagIcon tagIcon) {
        this.tagIcon = tagIcon;
    }

    public final void h(@Nullable TagText tagText) {
        this.tagText = tagText;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        TagIcon tagIcon = this.tagIcon;
        int i3 = 0;
        if (tagIcon == null) {
            hashCode = 0;
        } else {
            hashCode = tagIcon.hashCode();
        }
        int i16 = hashCode * 31;
        TagText tagText = this.tagText;
        if (tagText == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = tagText.hashCode();
        }
        int hashCode4 = (((i16 + hashCode2) * 31) + this.text.hashCode()) * 31;
        SearchJump searchJump = this.clickJump;
        if (searchJump == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = searchJump.hashCode();
        }
        int i17 = (hashCode4 + hashCode3) * 31;
        SearchReportInfo searchReportInfo = this.reportInfo;
        if (searchReportInfo != null) {
            i3 = searchReportInfo.hashCode();
        }
        return i17 + i3;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    @NotNull
    public String toString() {
        return "SearchBarLabel(tagIcon=" + this.tagIcon + ", tagText=" + this.tagText + ", text=" + this.text + ", clickJump=" + this.clickJump + ", reportInfo=" + this.reportInfo + ")";
    }

    public SearchBarLabel(@Nullable TagIcon tagIcon, @Nullable TagText tagText, @NotNull String text, @Nullable SearchJump searchJump, @Nullable SearchReportInfo searchReportInfo) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.tagIcon = tagIcon;
        this.tagText = tagText;
        this.text = text;
        this.clickJump = searchJump;
        this.reportInfo = searchReportInfo;
    }

    public /* synthetic */ SearchBarLabel(TagIcon tagIcon, TagText tagText, String str, SearchJump searchJump, SearchReportInfo searchReportInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : tagIcon, (i3 & 2) != 0 ? null : tagText, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? null : searchJump, (i3 & 16) != 0 ? null : searchReportInfo);
    }
}
