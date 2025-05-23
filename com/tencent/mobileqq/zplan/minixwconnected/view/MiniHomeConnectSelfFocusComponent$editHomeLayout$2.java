package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectIconLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class MiniHomeConnectSelfFocusComponent$editHomeLayout$2 extends Lambda implements Function0<MiniHomeConnectIconLayout> {
    final /* synthetic */ MiniHomeConnectSelfFocusComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectSelfFocusComponent$editHomeLayout$2(MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent) {
        super(0);
        this.this$0 = miniHomeConnectSelfFocusComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MiniHomeConnectSelfFocusComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiniHomeConnectedController miniHomeConnectedController = this$0.y().get();
        if (miniHomeConnectedController != null) {
            miniHomeConnectedController.x();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MiniHomeConnectIconLayout invoke() {
        MiniHomeConnectIconLayout miniHomeConnectIconLayout = new MiniHomeConnectIconLayout(this.this$0.getContext(), c.b(this.this$0.getContext(), R.drawable.qui_decorate, 0, 4, null), "\u88c5\u4fee\u8ff7\u4f60\u7a9d");
        final MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent = this.this$0;
        ViewGroup.LayoutParams layoutParams = miniHomeConnectIconLayout.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.addRule(14, -1);
            layoutParams2.bottomMargin = ViewUtils.dpToPx(48.0f);
        }
        miniHomeConnectIconLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniHomeConnectSelfFocusComponent$editHomeLayout$2.b(MiniHomeConnectSelfFocusComponent.this, view);
            }
        });
        return miniHomeConnectIconLayout;
    }
}
