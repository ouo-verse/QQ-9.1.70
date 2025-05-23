package com.tencent.mobileqq.selectfriend.part.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.selectfriend.enter.select.SelectEnterBaseAdapter;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.selectfriend.part.adapter.SelectFriendEnterAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/SelectDefaultEnterAdapter;", "Lcom/tencent/mobileqq/selectfriend/enter/select/SelectEnterBaseAdapter;", "Lcom/tencent/mobileqq/selectfriend/part/adapter/SelectFriendEnterAdapter$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "", "onBindViewHolder", "", "isSupportShow", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "Landroid/os/Bundle;", "fsForwardData", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SelectDefaultEnterAdapter extends SelectEnterBaseAdapter<SelectFriendEnterAdapter.b> {
    public SelectDefaultEnterAdapter(Context context, FSForwardData<Bundle> fSForwardData) {
        super(context, fSForwardData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return -1;
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public boolean isSupportShow() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SelectFriendEnterAdapter.b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelectFriendEnterAdapter.b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new SelectFriendEnterAdapter.b(parent);
    }
}
