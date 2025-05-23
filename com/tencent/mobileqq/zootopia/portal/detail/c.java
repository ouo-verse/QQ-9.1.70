package com.tencent.mobileqq.zootopia.portal.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.view.ZootopiaUserView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.data.ZootopiaMapComment;
import com.tencent.widget.pull2refresh.BaseAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/c;", "Lcom/tencent/widget/pull2refresh/BaseAdapter;", "Lcom/tencent/sqshow/zootopia/data/l;", "Lcom/tencent/mobileqq/zootopia/portal/detail/d;", "", "position", "getCustomItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "p", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c extends BaseAdapter<ZootopiaMapComment, d> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int position) {
        return 1;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindCustomViewHolder(d holder, int position) {
        ZootopiaUserView userView;
        ZootopiaMapComment item = getItem(position);
        if (item != null) {
            TextView commentView = holder != null ? holder.getCommentView() : null;
            if (commentView != null) {
                commentView.setText(item.getComment());
            }
            if (holder == null || (userView = holder.getUserView()) == null) {
                return;
            }
            userView.a(item.getUserData());
        }
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public d onCreateCustomViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.context).inflate(R.layout.f167423d82, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new d(itemView);
    }
}
