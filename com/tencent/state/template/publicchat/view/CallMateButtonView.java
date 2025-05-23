package com.tencent.state.template.publicchat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.publicchat.data.Scene;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareCallMateButtonViewBinding;
import com.tencent.state.square.mmkv.IMMKV;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0014J$\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/template/publicchat/view/CallMateButtonView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareCallMateButtonViewBinding;", "hide", "", NodeProps.ON_ATTACHED_TO_WINDOW, "show", "scene", "Lcom/tencent/state/publicchat/data/Scene;", "bubbleText", "", NodeProps.ON_CLICK, "Lkotlin/Function0;", "showTips", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CallMateButtonView extends FrameLayout {
    private static final long TIPS_TIMEOUT_MS = 10000;
    private final VasSquareCallMateButtonViewBinding binding;

    public /* synthetic */ CallMateButtonView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    private final void showTips(Scene scene, String bubbleText) {
        String str = "vas_public_chat_call_mate_tips_" + scene;
        if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), str, false, null, false, 12, null)) {
            return;
        }
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), str, true, null, false, 12, null);
        TextView textView = this.binding.tvCallMateBubble;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvCallMateBubble");
        textView.setText(bubbleText);
        FrameLayout frameLayout = this.binding.callMateBubble;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.callMateBubble");
        ViewExtensionsKt.setVisibility(frameLayout, true);
        postDelayed(new Runnable() { // from class: com.tencent.state.template.publicchat.view.CallMateButtonView$showTips$1
            @Override // java.lang.Runnable
            public final void run() {
                VasSquareCallMateButtonViewBinding vasSquareCallMateButtonViewBinding;
                vasSquareCallMateButtonViewBinding = CallMateButtonView.this.binding;
                FrameLayout frameLayout2 = vasSquareCallMateButtonViewBinding.callMateBubble;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.callMateBubble");
                ViewExtensionsKt.setVisibility(frameLayout2, false);
            }
        }, 10000L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SquareBaseKt.getSquareReporter().setElementInfo(this, SquareReportConst.ElementId.ELEMENT_ID_CHAT_CALL_MATE_BTN, new LinkedHashMap(), false, false);
    }

    public final void show(Scene scene, String bubbleText, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(bubbleText, "bubbleText");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        if (getVisibility() == 0) {
            return;
        }
        ViewExtensionsKt.setVisibility(this, true);
        showTips(scene, bubbleText);
        this.binding.btnCallMate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.template.publicchat.view.CallMateButtonView$show$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquareCallMateButtonViewBinding vasSquareCallMateButtonViewBinding;
                onClick.invoke();
                vasSquareCallMateButtonViewBinding = CallMateButtonView.this.binding;
                FrameLayout frameLayout = vasSquareCallMateButtonViewBinding.callMateBubble;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.callMateBubble");
                ViewExtensionsKt.setVisibility(frameLayout, false);
                SquareBaseKt.getSquareReporter().reportEvent("clck", CallMateButtonView.this, new LinkedHashMap());
            }
        });
        SquareBaseKt.getSquareReporter().reportEvent("imp", this, new LinkedHashMap());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallMateButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareCallMateButtonViewBinding inflate = VasSquareCallMateButtonViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareCallMateButtonV\u2026 this,\n        true\n    )");
        this.binding = inflate;
        ViewExtensionsKt.setVisibility(this, false);
    }

    public final void hide() {
        ViewExtensionsKt.setVisibility(this, false);
    }
}
