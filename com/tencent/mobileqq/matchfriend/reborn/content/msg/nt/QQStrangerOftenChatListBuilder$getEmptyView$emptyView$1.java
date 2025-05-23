package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
final class QQStrangerOftenChatListBuilder$getEmptyView$emptyView$1 extends Lambda implements Function0<QUIEmptyState> {
    public static final QQStrangerOftenChatListBuilder$getEmptyView$emptyView$1 INSTANCE = new QQStrangerOftenChatListBuilder$getEmptyView$emptyView$1();

    private static final Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#6F57FF"), Color.parseColor("#B557FF")});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.d(4.0f));
        gradientDrawable.setGradientType(0);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view) {
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterSignalSquare(view.getContext());
    }

    QQStrangerOftenChatListBuilder$getEmptyView$emptyView$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QUIEmptyState invoke() {
        QUIEmptyState build = new QUIEmptyState.Builder(QBaseActivity.sTopActivity).setImageType(8).setTitle("\u6682\u65e0\u5e38\u804a\u597d\u53cb\uff0c\u5feb\u53bb\u8ba4\u8bc6\u65b0\u670b\u53cb\u5427").setHalfScreenState(true).setButton("\u53bb\u6269\u5217", new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerOftenChatListBuilder$getEmptyView$emptyView$1.c(view);
            }
        }).setBackgroundColorType(0).build();
        build.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        build.findViewById(R.id.uum).setBackground(b());
        return build;
    }
}
