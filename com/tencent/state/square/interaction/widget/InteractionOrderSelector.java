package com.tencent.state.square.interaction.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.interaction.InteractionSelectOrder;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J-\u0010\u0016\u001a\u00020\u00122%\u0010\u0017\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000ej\u0002`\u0013J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR1\u0010\r\u001a%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\u0004\u0018\u0001`\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/interaction/widget/InteractionOrderSelector;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "hintImgView", "Landroid/widget/ImageView;", "nextOrder", "Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "getNextOrder", "()Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "onChangeCallbackFunc", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "order", "", "Lcom/tencent/state/square/interaction/widget/OnOrderChangeCallbackFunc;", "titleView", "Landroid/widget/TextView;", "setOnOrderChange", "cb", "updateOrder", "silence", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionOrderSelector extends LinearLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final InteractionSelectOrder[] ORDER_VALUES = InteractionSelectOrder.values();
    private final ImageView hintImgView;
    private Function1<? super InteractionSelectOrder, Unit> onChangeCallbackFunc;
    private InteractionSelectOrder order;
    private final TextView titleView;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/interaction/widget/InteractionOrderSelector$Companion;", "", "()V", "ORDER_VALUES", "", "Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "getORDER_VALUES", "()[Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "[Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final InteractionSelectOrder[] getORDER_VALUES() {
            return InteractionOrderSelector.ORDER_VALUES;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InteractionSelectOrder.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[InteractionSelectOrder.RANDOM.ordinal()] = 1;
            iArr[InteractionSelectOrder.SEQUENCE.ordinal()] = 2;
        }
    }

    public /* synthetic */ InteractionOrderSelector(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InteractionSelectOrder getNextOrder() {
        int indexOf;
        InteractionSelectOrder[] interactionSelectOrderArr = ORDER_VALUES;
        indexOf = ArraysKt___ArraysKt.indexOf(interactionSelectOrderArr, this.order);
        return interactionSelectOrderArr[(indexOf + 1) % interactionSelectOrderArr.length];
    }

    public final void setOnOrderChange(Function1<? super InteractionSelectOrder, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.onChangeCallbackFunc = cb5;
    }

    public final void updateOrder(InteractionSelectOrder order, boolean silence) {
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(order, "order");
        this.order = order;
        int i18 = WhenMappings.$EnumSwitchMapping$0[order.ordinal()];
        if (i18 == 1) {
            i3 = R.string.xfo;
            i16 = R.string.xfp;
            i17 = R.drawable.i9z;
        } else {
            if (i18 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i3 = R.string.xfq;
            i16 = R.string.xfr;
            i17 = R.drawable.i_0;
        }
        this.titleView.setText(getResources().getString(i3));
        this.hintImgView.setImageResource(i17);
        Function1<? super InteractionSelectOrder, Unit> function1 = this.onChangeCallbackFunc;
        if (function1 != null && function1 != null) {
            function1.invoke(order);
        }
        if (silence) {
            return;
        }
        ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        squareCommon.showToast(context, i16, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionOrderSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.order = ORDER_VALUES[0];
        View.inflate(context, R.layout.f167406d51, this);
        View findViewById = findViewById(R.id.qrk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.titleView)");
        this.titleView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.pzg);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.hintImgView)");
        this.hintImgView = (ImageView) findViewById2;
        updateOrder(this.order, true);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.widget.InteractionOrderSelector.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InteractionOrderSelector interactionOrderSelector = InteractionOrderSelector.this;
                interactionOrderSelector.updateOrder(interactionOrderSelector.getNextOrder(), false);
            }
        });
    }
}
