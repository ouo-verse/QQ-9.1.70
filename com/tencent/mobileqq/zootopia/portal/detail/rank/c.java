package com.tencent.mobileqq.zootopia.portal.detail.rank;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.RoundImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/rank/c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "E", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "mainContentView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "noView", "Lcom/tencent/mobileqq/widget/RoundImageView;", "G", "Lcom/tencent/mobileqq/widget/RoundImageView;", "l", "()Lcom/tencent/mobileqq/widget/RoundImageView;", "avatarView", "H", "o", "nickView", "I", "r", "scoreView", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "scoreTypeView", "view", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final View mainContentView;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView noView;

    /* renamed from: G, reason: from kotlin metadata */
    private final RoundImageView avatarView;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView nickView;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView scoreView;

    /* renamed from: J, reason: from kotlin metadata */
    private final TextView scoreTypeView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.mainContentView = view.findViewById(R.id.f163597r00);
        this.noView = (TextView) view.findViewById(R.id.f163599r02);
        this.avatarView = (RoundImageView) view.findViewById(R.id.qzy);
        this.nickView = (TextView) view.findViewById(R.id.f163598r01);
        this.scoreView = (TextView) view.findViewById(R.id.f163600r03);
        this.scoreTypeView = (TextView) view.findViewById(R.id.f163601r04);
    }

    /* renamed from: l, reason: from getter */
    public final RoundImageView getAvatarView() {
        return this.avatarView;
    }

    /* renamed from: m, reason: from getter */
    public final View getMainContentView() {
        return this.mainContentView;
    }

    /* renamed from: o, reason: from getter */
    public final TextView getNickView() {
        return this.nickView;
    }

    /* renamed from: p, reason: from getter */
    public final TextView getNoView() {
        return this.noView;
    }

    /* renamed from: q, reason: from getter */
    public final TextView getScoreTypeView() {
        return this.scoreTypeView;
    }

    /* renamed from: r, reason: from getter */
    public final TextView getScoreView() {
        return this.scoreView;
    }
}
