package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchPlayletDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/h;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "getItemType", "", "i", "", "toString", "", "other", "", "equals", "hashCode", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchPlayletDetail;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchPlayletDetail;", HippyTKDListViewAdapter.X, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchPlayletDetail;", "playletDetail", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.h, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchPlayletTemplateItem extends a {

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private final SearchPlayletDetail playletDetail;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchPlayletTemplateItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template) {
        super(commonInfo, template);
        String str;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        SearchPlayletDetail searchPlayletDetail = template.playletDetail;
        searchPlayletDetail = searchPlayletDetail == null ? new SearchPlayletDetail() : searchPlayletDetail;
        this.playletDetail = searchPlayletDetail;
        SearchJump jumpLink = getJumpLink();
        boolean z16 = false;
        if (jumpLink != null && (str = jumpLink.jumpLink) != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (isBlank) {
                z16 = true;
            }
        }
        if (z16) {
            w(searchPlayletDetail.moreButton.jumpLink);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof NetSearchPlayletTemplateItem) && super.equals(other) && Intrinsics.areEqual(this.playletDetail, ((NetSearchPlayletTemplateItem) other).playletDetail)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 11;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public int hashCode() {
        return (super.hashCode() * 31) + this.playletDetail.hashCode();
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public void i() {
        String picLink = this.playletDetail.mainPic.picLink;
        com.tencent.mobileqq.search.searchdetail.util.c cVar = com.tencent.mobileqq.search.searchdetail.util.c.f284739a;
        Intrinsics.checkNotNullExpressionValue(picLink, "picLink");
        com.tencent.mobileqq.search.searchdetail.util.c.b(cVar, picLink, 0, 0, 6, null);
    }

    @NotNull
    public String toString() {
        return "NetSearchPlayletTemplateItem(commonInfo=" + getCommonInfo() + ", playletDetail=" + this.playletDetail + ")";
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final SearchPlayletDetail getPlayletDetail() {
        return this.playletDetail;
    }
}
