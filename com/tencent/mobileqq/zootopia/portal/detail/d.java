package com.tencent.mobileqq.zootopia.portal.detail;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.view.ZootopiaUserView;
import com.tencent.sqshow.zootopia.data.ZootopiaMapComment;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/d;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lcom/tencent/sqshow/zootopia/data/l;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaUserView;", "d", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaUserView;", "c", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaUserView;", "userView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "b", "()Landroid/widget/TextView;", "commentView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends BaseViewHolder<ZootopiaMapComment> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaUserView userView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView commentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.qwg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.uv_user)");
        this.userView = (ZootopiaUserView) findViewById;
        View findViewById2 = view.findViewById(R.id.qtb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tv_comment)");
        this.commentView = (TextView) findViewById2;
    }

    /* renamed from: b, reason: from getter */
    public final TextView getCommentView() {
        return this.commentView;
    }

    /* renamed from: c, reason: from getter */
    public final ZootopiaUserView getUserView() {
        return this.userView;
    }
}
