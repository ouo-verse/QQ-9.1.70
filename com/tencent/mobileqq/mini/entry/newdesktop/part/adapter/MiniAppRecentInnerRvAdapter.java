package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppRecentInnerRvAdapter;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "delegatesManager", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "getItemId", "", "position", "", "setItems", "", "items", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class MiniAppRecentInnerRvAdapter extends AsyncListDifferDelegationAdapter<DesktopItemInfo> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppRecentInnerRvAdapter(DiffUtil.ItemCallback<DesktopItemInfo> diffCallback, AdapterDelegatesManager<List<DesktopItemInfo>> delegatesManager) {
        super(diffCallback, delegatesManager);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter
    public void setItems(List<DesktopItemInfo> items) {
        if (items != null && items.size() > 8) {
            super.setItems(items.subList(0, 8));
        } else {
            super.setItems(items);
        }
    }
}
