package com.tencent.mobileqq.zootopia.portal.detail.main;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.view.ZootopiaUserView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/main/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaUserView;", "E", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaUserView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaUserView;", "userView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "commentView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final ZootopiaUserView userView;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView commentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.userView = (ZootopiaUserView) view.findViewById(R.id.qwg);
        this.commentView = (TextView) view.findViewById(R.id.qtb);
    }

    /* renamed from: l, reason: from getter */
    public final TextView getCommentView() {
        return this.commentView;
    }

    /* renamed from: m, reason: from getter */
    public final ZootopiaUserView getUserView() {
        return this.userView;
    }
}
