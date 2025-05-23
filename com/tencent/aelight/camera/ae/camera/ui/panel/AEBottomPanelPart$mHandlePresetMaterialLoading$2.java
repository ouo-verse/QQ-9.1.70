package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/aelight/camera/ae/view/a;", "invoke", "()Lcom/tencent/aelight/camera/ae/view/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEBottomPanelPart$mHandlePresetMaterialLoading$2 extends Lambda implements Function0<com.tencent.aelight.camera.ae.view.a> {
    final /* synthetic */ AEBottomPanelPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEBottomPanelPart$mHandlePresetMaterialLoading$2(AEBottomPanelPart aEBottomPanelPart) {
        super(0);
        this.this$0 = aEBottomPanelPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.aelight.camera.ae.view.a this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.cancel();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final com.tencent.aelight.camera.ae.view.a invoke() {
        final com.tencent.aelight.camera.ae.view.a aVar = new com.tencent.aelight.camera.ae.view.a(((com.tencent.aelight.camera.ae.part.b) this.this$0).mActivity);
        aVar.O(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AEBottomPanelPart$mHandlePresetMaterialLoading$2.b(com.tencent.aelight.camera.ae.view.a.this, view);
            }
        });
        return aVar;
    }
}
