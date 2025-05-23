package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppRvItemAdTextSection;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppRvItemIconRightTopMarkSection;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppRvItemIconSection;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppRvItemNameTextSection;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppRvItemRecommendSection;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppRvItemRedDotTextSection;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppRvItemReportSection;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppRvItemVersionTextSection;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.w;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J4\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e0\rH\u0016J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0014J2\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\rH\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppMineInnerRvDelegate;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "()V", "getLayoutId", "", "initSection", "", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "itemView", "Landroid/view/View;", "sections", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "isForViewType", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "items", "position", "onBindViewHolder", "holder", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "payloads", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppMineInnerRvDelegate extends AbsItemAdapterDelegate<DesktopItemInfo, DesktopItemInfo> {
    private static final String TAG = "MiniAppDesktopPart.MiniAppMineInnerRvDelegate";

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.dii;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup parent, View itemView, List<Class<? extends Section<DesktopItemInfo>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(MiniAppRvItemIconSection.class);
        sections.add(MiniAppRvItemAdTextSection.class);
        sections.add(MiniAppRvItemNameTextSection.class);
        sections.add(MiniAppRvItemRecommendSection.class);
        sections.add(MiniAppRvItemRedDotTextSection.class);
        sections.add(MiniAppRvItemVersionTextSection.class);
        sections.add(MiniAppRvItemIconRightTopMarkSection.class);
        sections.add(MiniAppRvItemReportSection.class);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    public /* bridge */ /* synthetic */ boolean isForViewType(Object obj, List list, int i3) {
        return isForViewType((DesktopItemInfo) obj, (List<DesktopItemInfo>) list, i3);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: onBindViewHolder */
    public /* bridge */ /* synthetic */ void onBindViewHolder2(Object obj, SectionViewHolder sectionViewHolder, int i3, List list) {
        onBindViewHolder((DesktopItemInfo) obj, (SectionViewHolder<?>) sectionViewHolder, i3, (List<Object>) list);
    }

    protected boolean isForViewType(DesktopItemInfo item, List<DesktopItemInfo> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item.getModuleType() == 3 || item.getModuleType() == 1;
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
        try {
            View findViewById = holder.itemView.findViewById(R.id.rgp);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) findViewById;
            float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
            if (w.a(BaseApplication.getContext())) {
                f16 *= com.tencent.mobileqq.pad.e.h();
            }
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = (int) ((f16 - ViewUtils.dip2px(21.0f)) / 4.4f);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        if (item.isTemp) {
            holder.itemView.setVisibility(4);
        } else {
            holder.itemView.setVisibility(0);
        }
        super.onBindViewHolder((MiniAppMineInnerRvDelegate) item, (SectionViewHolder) holder, position, payloads);
        holder.itemView.setTag(item);
    }
}
