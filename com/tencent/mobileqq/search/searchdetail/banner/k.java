package com.tencent.mobileqq.search.searchdetail.banner;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateBannerItem;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.SearchLayOut;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J4\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u001a\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00100\u0005H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/banner/k;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/a;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/i;", "Lcom/tencent/mobileqq/search/searchdetail/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "f", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class k extends com.tencent.mobileqq.search.searchdetail.content.base.a<NetSearchTemplateBannerItem> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/banner/k$a;", "", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/i;", "data", "", "index", "", "Lcom/tencent/mobileqq/search/searchdetail/c;", "dataList", "", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.banner.k$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull NetSearchTemplateBannerItem data, int index, @NotNull List<? extends com.tencent.mobileqq.search.searchdetail.c> dataList) {
            Float f16;
            boolean areEqual;
            boolean z16;
            boolean z17;
            boolean z18;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            com.tencent.mobileqq.search.searchdetail.c cVar = null;
            if (index == 0) {
                areEqual = false;
            } else {
                SearchLayOut layoutInfo = data.getLayoutInfo();
                if (layoutInfo != null) {
                    f16 = Float.valueOf(layoutInfo.marginTop);
                } else {
                    f16 = null;
                }
                areEqual = Intrinsics.areEqual(f16, 0.0f);
            }
            if (index < dataList.size() - 12) {
                cVar = dataList.get(index + 1);
            }
            if (cVar == null || !(cVar instanceof NetSearchTemplateBannerItem)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || ((NetSearchTemplateBannerItem) cVar).getLayoutInfo().marginTop != 0.0f) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!areEqual && !z17) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18 || !data.C().isEmpty()) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.search.searchdetail.c item, @NotNull List<com.tencent.mobileqq.search.searchdetail.c> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item.getItemType() == 5) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.fnw;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<NetSearchTemplateBannerItem>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(NetSearchBannerSection.class);
    }
}
