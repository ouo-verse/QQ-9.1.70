package com.tencent.mobileqq.guild;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0014R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/GuildsPinnedHeaderExpandableListView;", "Lcom/tencent/widget/SwipPinnedHeaderExpandableListView;", "", "canAction", "", "setChildViewCanAction", "", "curX", "curY", "Landroid/view/View;", "view", NodeProps.MAX_WIDTH, "scrollItemView", "d", "Z", "mCanChildAction", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildsPinnedHeaderExpandableListView extends SwipPinnedHeaderExpandableListView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mCanChildAction;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildsPinnedHeaderExpandableListView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView
    public void scrollItemView(int curX, int curY, View view, int maxWidth) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.mCanChildAction) {
            super.scrollItemView(curX, curY, view, maxWidth);
        }
    }

    public final void setChildViewCanAction(boolean canAction) {
        ExpandableListAdapter expandableListAdapter = getExpandableListAdapter();
        if (expandableListAdapter instanceof BuddyListAdapter) {
            ((BuddyListAdapter) expandableListAdapter).y(canAction);
        }
        this.mCanChildAction = canAction;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildsPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildsPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? R.attr.expandableListViewStyle : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildsPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCanChildAction = true;
    }
}
