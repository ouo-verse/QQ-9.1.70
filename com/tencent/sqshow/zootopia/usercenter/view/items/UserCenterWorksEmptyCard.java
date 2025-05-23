package com.tencent.sqshow.zootopia.usercenter.view.items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import jc4.UserCenterCardData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc4.a;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/view/items/UserCenterWorksEmptyCard;", "Landroid/widget/FrameLayout;", "Lnc4/a;", "Ljc4/a;", "data", "", "position", "", "w0", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "d", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "userCenterPage", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tipsView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UserCenterWorksEmptyCard extends FrameLayout implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tipsView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCenterWorksEmptyCard(Context context, com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userCenterPage, "userCenterPage");
        this.userCenterPage = userCenterPage;
        View findViewById = LayoutInflater.from(context).inflate(R.layout.dcn, this).findViewById(R.id.r9a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.zplan_tv_tips)");
        this.tipsView = (TextView) findViewById;
    }

    @Override // nc4.a
    public void w0(UserCenterCardData data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.userCenterPage.j8()) {
            this.tipsView.setText(R.string.xwl);
        } else if (this.userCenterPage.E3()) {
            this.tipsView.setText(R.string.xwm);
        } else {
            this.tipsView.setText(R.string.xwk);
        }
    }
}
