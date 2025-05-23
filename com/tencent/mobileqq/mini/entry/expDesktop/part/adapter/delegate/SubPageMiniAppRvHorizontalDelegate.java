package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.delegate;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section.MiniAppRvItemIconSection;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section.MiniAppRvItemNameSection;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section.MiniAppRvItemVersionTextSection;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J4\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e0\rH\u0016J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0014J2\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\rH\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/delegate/SubPageMiniAppRvHorizontalDelegate;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "()V", "getLayoutId", "", "initSection", "", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "itemView", "Landroid/view/View;", "sections", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "isForViewType", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "items", "position", "onBindViewHolder", "holder", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "payloads", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class SubPageMiniAppRvHorizontalDelegate extends AbsItemAdapterDelegate<DesktopItemInfo, DesktopItemInfo> {
    private static final String TAG = "MiniAppExpDesktopPart.SubPageMiniAppRvHorizontalDelegate";

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.f167477dj1;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup parent, View itemView, List<Class<? extends Section<DesktopItemInfo>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(MiniAppRvItemIconSection.class);
        sections.add(MiniAppRvItemNameSection.class);
        sections.add(MiniAppRvItemVersionTextSection.class);
    }

    protected boolean isForViewType(DesktopItemInfo item, List<DesktopItemInfo> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    public /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, SectionViewHolder sectionViewHolder, int i3, List list) {
        onBindViewHolder((DesktopItemInfo) obj, (SectionViewHolder<?>) sectionViewHolder, i3, (List<Object>) list);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    public /* bridge */ /* synthetic */ boolean isForViewType(Object obj, List list, int i3) {
        return isForViewType((DesktopItemInfo) obj, (List<DesktopItemInfo>) list, i3);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ void onBindViewHolder2(DesktopItemInfo desktopItemInfo, SectionViewHolder sectionViewHolder, int i3, List list) {
        onBindViewHolder(desktopItemInfo, (SectionViewHolder<?>) sectionViewHolder, i3, (List<Object>) list);
    }

    protected void onBindViewHolder(DesktopItemInfo item, SectionViewHolder<?> holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.width = -1;
        holder.itemView.setLayoutParams(layoutParams);
        if (item instanceof DesktopAppInfo) {
            holder.itemView.setVisibility(((DesktopAppInfo) item).isDrag() ? 4 : 0);
        }
        super.onBindViewHolder((SubPageMiniAppRvHorizontalDelegate) item, (SectionViewHolder) holder, position, payloads);
        holder.itemView.setTag(item);
    }
}
