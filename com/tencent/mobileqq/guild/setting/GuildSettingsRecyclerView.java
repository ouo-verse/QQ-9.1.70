package com.tencent.mobileqq.guild.setting;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.m;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/GuildSettingsRecyclerView;", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onThemeChanged", "", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildSettingsRecyclerView extends QUISettingsRecyclerView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSettingsRecyclerView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView, com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        int i3;
        m mVar;
        super.onThemeChanged();
        if (GuildThemeManager.f235286a.b()) {
            i3 = 1002;
        } else {
            i3 = 1001;
        }
        int itemDecorationCount = getItemDecorationCount();
        for (int i16 = 0; i16 < itemDecorationCount; i16++) {
            RecyclerView.ItemDecoration itemDecorationAt = getItemDecorationAt(i16);
            if (itemDecorationAt instanceof m) {
                mVar = (m) itemDecorationAt;
            } else {
                mVar = null;
            }
            if (mVar != null) {
                mVar.d(i3);
            }
        }
        QUIListItemAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.u0(i3);
        }
    }

    @Override // com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView, androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        super.setAdapter(adapter);
        onThemeChanged();
    }

    public /* synthetic */ GuildSettingsRecyclerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSettingsRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
