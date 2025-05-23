package com.tencent.mobileqq.zplan.minihome.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeEditBuyAndSaveButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "", "price", "furnitureNum", "", TuxUIConstants.POP_BTN_TEXT, "", "u", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeEditBuyAndSaveButton extends QUIButton {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniHomeEditBuyAndSaveButton(Context context) {
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

    public final void u(final int price, final int furnitureNum, final String btnText) {
        Intrinsics.checkNotNullParameter(btnText, "btnText");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditBuyAndSaveButton$updatePrice$1
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
                int i3;
                int i16 = price;
                if (i16 > 0 && (i3 = furnitureNum) > 0) {
                    this.setText(i16 + " \u8d2d\u4e70\uff08" + i3 + "\u4ef6\u5bb6\u5177\uff09");
                    Drawable b16 = q.b(R.drawable.ilx);
                    b16.setBounds(0, 0, com.tencent.sqshow.zootopia.utils.i.b(16), com.tencent.sqshow.zootopia.utils.i.b(16));
                    this.setCompoundDrawablePadding(com.tencent.sqshow.zootopia.utils.i.b(5));
                    this.setGravity(19);
                    this.setCompoundDrawables(b16, null, null, null);
                    return;
                }
                this.setText(btnText);
                this.setGravity(17);
                this.setCompoundDrawables(null, null, null, null);
            }
        });
    }

    public /* synthetic */ MiniHomeEditBuyAndSaveButton(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeEditBuyAndSaveButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
