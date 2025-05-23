package com.tencent.mobileqq.guild.rolegroup.levelrole;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleUIData;", "itemData", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mTip", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView mTip;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.evv, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        View findViewById = this.itemView.findViewById(R.id.wlp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026uild_level_role_list_tip)");
        this.mTip = (TextView) findViewById;
    }

    public final void l(@NotNull LevelRoleUIData itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        this.mTip.setText(itemData.getRoleName());
    }
}
