package com.tencent.mobileqq.guild.rolegroup.fragments.roledetail;

import android.view.ViewGroup;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/roledetail/a;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/widget/listitem/e;", "r0", "holder", "position", "", "p0", "<init>", "()V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends QUIListItemAdapter {
    public a() {
        super(null, false, false, 7, null);
    }

    @Override // com.tencent.mobileqq.widget.listitem.QUIListItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0 */
    public void onBindViewHolder(@NotNull com.tencent.mobileqq.widget.listitem.e holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
    }

    @Override // com.tencent.mobileqq.widget.listitem.QUIListItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: r0 */
    public com.tencent.mobileqq.widget.listitem.e onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return super.onCreateViewHolder(parent, viewType);
    }
}
