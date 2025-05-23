package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\tJ*\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/RankRvSectionViewHolder;", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "itemView", "Landroid/view/View;", "sections", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "(Landroid/view/View;Ljava/util/List;)V", "mData", "mPosition", "", "bindData", "", "data", "position", "payload", "", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class RankRvSectionViewHolder extends SectionViewHolder<DesktopItemInfo> {
    private DesktopItemInfo mData;
    private int mPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankRvSectionViewHolder(View itemView, List<? extends Class<? extends Section<DesktopItemInfo>>> list) {
        super(itemView, list);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.mPosition = -1;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.SectionViewHolder
    public /* bridge */ /* synthetic */ void bindData(DesktopItemInfo desktopItemInfo, int i3, List list) {
        bindData2(desktopItemInfo, i3, (List<Object>) list);
    }

    /* renamed from: bindData, reason: avoid collision after fix types in other method */
    public void bindData2(DesktopItemInfo data, int position, List<Object> payload) {
        super.bindData((RankRvSectionViewHolder) data, position, payload);
        this.mData = data;
        this.mPosition = position;
    }
}
