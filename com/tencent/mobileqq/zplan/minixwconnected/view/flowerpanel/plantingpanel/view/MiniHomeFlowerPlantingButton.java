package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.filament.zplan.scene.xwconnect.data.CoinType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.i;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/view/MiniHomeFlowerPlantingButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "flowerData", "", "u", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeFlowerPlantingButton extends QUIButton {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniHomeFlowerPlantingButton(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quibutton.QUIButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        float width;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable[] compoundDrawables = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(compoundDrawables, "compoundDrawables");
        Drawable drawable = (compoundDrawables.length == 0) ^ true ? compoundDrawables[0] : null;
        if (drawable != null) {
            int width2 = drawable.getBounds().width();
            int compoundDrawablePadding = getCompoundDrawablePadding();
            CharSequence text = getText();
            if (!TextUtils.isEmpty(text)) {
                width = ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - width2) - compoundDrawablePadding) - getPaint().measureText(text.toString());
            } else {
                width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - width2;
            }
            canvas.translate(width / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    public final void u(final MiniHomeFlowerPlantingPanelViewModel.FlowerData flowerData) {
        Intrinsics.checkNotNullParameter(flowerData, "flowerData");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.view.MiniHomeFlowerPlantingButton$update$1
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
                String str;
                Drawable drawable;
                boolean a16 = i.a(MiniHomeFlowerPlantingPanelViewModel.FlowerData.this);
                if (a16) {
                    str = MiniHomeFlowerPlantingPanelViewModel.FlowerData.this.getFlowerCost() + " ";
                } else {
                    str = "";
                }
                if (a16) {
                    drawable = q.b(MiniHomeFlowerPlantingPanelViewModel.FlowerData.this.getFlowerCoinType() == CoinType.GOLD ? R.drawable.ilx : R.drawable.f159901im2);
                } else {
                    drawable = null;
                }
                if (drawable != null) {
                    drawable.setBounds(0, 0, com.tencent.sqshow.zootopia.utils.i.b(16), com.tencent.sqshow.zootopia.utils.i.b(16));
                }
                this.setCompoundDrawablePadding(a16 ? com.tencent.sqshow.zootopia.utils.i.b(5) : 0);
                this.setCompoundDrawables(drawable, null, null, null);
                MiniHomeFlowerPlantingButton miniHomeFlowerPlantingButton = this;
                miniHomeFlowerPlantingButton.setText(str + miniHomeFlowerPlantingButton.getContext().getResources().getString(R.string.xqt));
                this.setGravity(a16 ? 19 : 17);
            }
        });
    }

    public /* synthetic */ MiniHomeFlowerPlantingButton(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeFlowerPlantingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
