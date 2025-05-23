package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerJumpHomePageEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
final class QQStrangerLiteActionListPart$emptyView$1 extends Lambda implements Function0<QUIEmptyState> {
    final /* synthetic */ QQStrangerLiteActionListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerLiteActionListPart$emptyView$1(QQStrangerLiteActionListPart qQStrangerLiteActionListPart) {
        super(0);
        this.this$0 = qQStrangerLiteActionListPart;
    }

    private static final Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#6F57FF"), Color.parseColor("#B557FF")});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.d(4.0f));
        gradientDrawable.setGradientType(0);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QQStrangerLiteActionListPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerJumpHomePageEvent());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QUIEmptyState invoke() {
        QUIEmptyState.Builder halfScreenState = new QUIEmptyState.Builder(QBaseActivity.sTopActivity).setImageType(8).setTitle("\u6682\u65f6\u6ca1\u6709\u6d88\u606f\u54e6\uff0c\u53bb\u540c\u9891\u5e7f\u573a\u770b\u770b\u5427").setHalfScreenState(true);
        final QQStrangerLiteActionListPart qQStrangerLiteActionListPart = this.this$0;
        QUIEmptyState build = halfScreenState.setButton("\u53bb\u770b\u770b", new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerLiteActionListPart$emptyView$1.c(QQStrangerLiteActionListPart.this, view);
            }
        }).setBackgroundColorType(0).build();
        build.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        build.findViewById(R.id.uum).setBackground(b());
        return build;
    }
}
