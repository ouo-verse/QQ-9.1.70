package com.tencent.state.square.friendsetting;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.holder.TroopViewHolder;
import com.tencent.state.view.TextBubblePopupWindow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SettingTipsController$showTroopOperateBubbleForHolder$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PopupWindow.OnDismissListener $dismissListener;
    final /* synthetic */ SquareFragment $squareFragment;
    final /* synthetic */ TroopViewHolder $vh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTipsController$showTroopOperateBubbleForHolder$1(Context context, SquareFragment squareFragment, TroopViewHolder troopViewHolder, PopupWindow.OnDismissListener onDismissListener) {
        super(0);
        this.$context = context;
        this.$squareFragment = squareFragment;
        this.$vh = troopViewHolder;
        this.$dismissListener = onDismissListener;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context context = this.$context;
        String string = context.getResources().getString(R.string.xf9);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026quare_has_add_troop_tips)");
        final TextBubblePopupWindow textBubblePopupWindow = new TextBubblePopupWindow(context, string);
        SquareView mapView = this.$squareFragment.getMapView();
        if (mapView != null) {
            float currentZoomRatio = mapView.getCurrentZoomRatio();
            Intrinsics.checkNotNullExpressionValue(this.$vh.itemView, "vh.itemView");
            float width = (((r3.getWidth() * currentZoomRatio) - textBubblePopupWindow.getTextViewWidth()) / 2) - ViewExtensionsKt.dip(this.$context, 10);
            View view = this.$vh.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "vh.itemView");
            int height = view.getHeight();
            Intrinsics.checkNotNullExpressionValue(this.$vh.getBinding().troopTent, "vh.binding.troopTent");
            float height2 = ((height - r7.getHeight()) - ViewExtensionsKt.dip(this.$context, 20)) * currentZoomRatio;
            View view2 = this.$vh.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "vh.itemView");
            RectF viewLocation$default = BaseMapView.getViewLocation$default(mapView, view2, null, 2, null);
            textBubblePopupWindow.updateBubbleBg(true);
            Object parent = mapView.getParent();
            if (parent != null) {
                textBubblePopupWindow.showAtLocation((View) parent, 0, ((int) viewLocation$default.left) + ((int) width), ((int) viewLocation$default.top) + ((int) height2));
                Square.INSTANCE.getConfig().getThreadManager().postOnUiDelayed(4000L, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.SettingTipsController$showTroopOperateBubbleForHolder$1$$special$$inlined$apply$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TextBubblePopupWindow.this.dismiss();
                    }
                });
                textBubblePopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.state.square.friendsetting.SettingTipsController$showTroopOperateBubbleForHolder$1$$special$$inlined$apply$lambda$2
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        this.$vh.setBubbleVisible(0);
                        PopupWindow.OnDismissListener onDismissListener = this.$dismissListener;
                        if (onDismissListener != null) {
                            onDismissListener.onDismiss();
                        }
                    }
                });
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
    }
}
