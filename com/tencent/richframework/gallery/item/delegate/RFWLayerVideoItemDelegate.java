package com.tencent.richframework.gallery.item.delegate;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u001c\u0010\u0003\u001a\u0018\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00050\u0011H\u0016J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0014R$\u0010\u0003\u001a\u0018\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/richframework/gallery/item/delegate/RFWLayerVideoItemDelegate;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mExtVideoSections", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "(Ljava/util/List;)V", "getLayoutId", "", "initSection", "", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "itemView", "Landroid/view/View;", "sections", "", "isForViewType", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "items", "position", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class RFWLayerVideoItemDelegate extends AbsItemAdapterDelegate<RFWLayerItemMediaInfo, RFWLayerItemMediaInfo> {
    private final List<Class<? extends Section<RFWLayerItemMediaInfo>>> mExtVideoSections;

    /* JADX WARN: Multi-variable type inference failed */
    public RFWLayerVideoItemDelegate(@Nullable List<? extends Class<? extends Section<RFWLayerItemMediaInfo>>> list) {
        this.mExtVideoSections = list;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.hn9;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<RFWLayerItemMediaInfo>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(RFWLayerVideoControlSection.class);
        if (this.mExtVideoSections != null && (!r2.isEmpty())) {
            sections.addAll(this.mExtVideoSections);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    public /* bridge */ /* synthetic */ boolean isForViewType(Object obj, List list, int i3) {
        return isForViewType((RFWLayerItemMediaInfo) obj, (List<? extends RFWLayerItemMediaInfo>) list, i3);
    }

    protected boolean isForViewType(@NotNull RFWLayerItemMediaInfo item, @NotNull List<? extends RFWLayerItemMediaInfo> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item.getLayerVideoInfo() != null;
    }
}
