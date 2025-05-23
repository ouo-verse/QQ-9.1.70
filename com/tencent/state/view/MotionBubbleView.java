package com.tencent.state.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.data.AnchorBubble;
import com.tencent.state.square.data.SquareAnchorEntrance;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.databinding.VasSquareEntranceMotionBubbleBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/view/MotionBubbleView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareEntranceMotionBubbleBinding;", "setBubbleInfo", "Lcom/tencent/state/square/data/SquareAnchorEntrance;", "data", "Lcom/tencent/state/square/data/SquareEntranceItem;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MotionBubbleView extends LinearLayout {
    private final VasSquareEntranceMotionBubbleBinding binding;

    public MotionBubbleView(Context context) {
        this(context, null, 0, 6, null);
    }

    public final SquareAnchorEntrance setBubbleInfo(SquareEntranceItem data) {
        List<SquareAnchorEntrance> anchorEntry;
        final AnchorBubble anchorBubble;
        String textAfter;
        View root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setVisibility(8);
        final SquareAnchorEntrance squareAnchorEntrance = null;
        if (data != null && (anchorEntry = data.getAnchorEntry()) != null) {
            anchorEntry.isEmpty();
            List<SquareAnchorEntrance> anchorEntry2 = data.getAnchorEntry();
            if (anchorEntry2 != null) {
                for (SquareAnchorEntrance squareAnchorEntrance2 : anchorEntry2) {
                    if (squareAnchorEntrance2.getAnchorBubble() != null) {
                        squareAnchorEntrance = squareAnchorEntrance2;
                    }
                }
            }
            if (squareAnchorEntrance != null && (anchorBubble = squareAnchorEntrance.getAnchorBubble()) != null) {
                if (squareAnchorEntrance.getNeedUnlock()) {
                    textAfter = anchorBubble.getTextBefore();
                } else {
                    textAfter = anchorBubble.getTextAfter();
                }
                if (textAfter.length() > 12) {
                    StringBuilder sb5 = new StringBuilder();
                    String substring = textAfter.substring(0, 11);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    sb5.append(substring);
                    sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    textAfter = sb5.toString();
                }
                TextView textView = this.binding.entranceBubbleText;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.entranceBubbleText");
                textView.setText(textAfter);
                View root2 = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
                ViewExtensionsKt.updateLayoutParams(root2, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.MotionBubbleView$setBubbleInfo$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                        invoke2(layoutParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(RelativeLayout.LayoutParams receiver) {
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        receiver.bottomMargin = AnchorBubble.this.getCoordinate().y - ViewExtensionsKt.dip((View) this, 8);
                    }
                });
                View root3 = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
                root3.setVisibility(0);
            }
        }
        return squareAnchorEntrance;
    }

    public MotionBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MotionBubbleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionBubbleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareEntranceMotionBubbleBinding inflate = VasSquareEntranceMotionBubbleBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareEntranceMotionB\u2026ater.from(context), this)");
        this.binding = inflate;
        setOrientation(1);
    }
}
