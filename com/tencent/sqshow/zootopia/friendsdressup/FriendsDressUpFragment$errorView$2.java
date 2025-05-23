package com.tencent.sqshow.zootopia.friendsdressup;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class FriendsDressUpFragment$errorView$2 extends Lambda implements Function0<QUIEmptyState> {
    final /* synthetic */ FriendsDressUpFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsDressUpFragment$errorView$2(FriendsDressUpFragment friendsDressUpFragment) {
        super(0);
        this.this$0 = friendsDressUpFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FriendsDressUpFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fj(false);
        this$0.pi();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QUIEmptyState invoke() {
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(this.this$0.getContext()).setImageType(5);
        String qqStr = HardCodeUtil.qqStr(R.string.xp8);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.zplan_friends_dress_net_error)");
        QUIEmptyState.Builder backgroundColorType = imageType.setTitle(qqStr).setBackgroundColorType(0);
        String qqStr2 = HardCodeUtil.qqStr(R.string.xp_);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.zplan_friends_dress_retry)");
        final FriendsDressUpFragment friendsDressUpFragment = this.this$0;
        QUIEmptyState build = backgroundColorType.setButton(qqStr2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendsDressUpFragment$errorView$2.b(FriendsDressUpFragment.this, view);
            }
        }).build();
        build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        build.setVisibility(0);
        return build;
    }
}
