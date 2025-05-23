package com.tencent.aelight.camera.zplan.api.impl;

import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/k;", "Lcom/tencent/aelight/camera/zplan/api/impl/m;", "", "Q0", "R0", "onCreate", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Lcom/tencent/biz/qqstory/view/PressDarkImageButton;", "b0", "Lcom/tencent/biz/qqstory/view/PressDarkImageButton;", "backgroundEditButton", "Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;", "manager", "", "enableMask", "<init>", "(Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;I)V", "c0", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class k extends m {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private PressDarkImageButton backgroundEditButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(EditVideoPartManager manager, int i3) {
        super(manager, i3);
        Intrinsics.checkNotNullParameter(manager, "manager");
    }

    private final void R0() {
        if (this.mParent.y(4000)) {
            QLog.i("ZPlanEditButtonsPart", 1, "zplan pic edit: exit background selection.");
            this.mParent.t(0);
        } else {
            QLog.i("ZPlanEditButtonsPart", 1, "zplan pic edit: begin background edit!");
            this.mParent.t(4000);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        PressDarkImageButton pressDarkImageButton = this.backgroundEditButton;
        if (pressDarkImageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundEditButton");
            pressDarkImageButton = null;
        }
        if (Intrinsics.areEqual(view, pressDarkImageButton)) {
            R0();
        } else {
            super.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.zplan.api.impl.m, com.tencent.aelight.camera.aioeditor.takevideo.r, com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        Q0();
    }

    private final void Q0() {
        View findViewSure = findViewSure(R.id.rs9);
        Intrinsics.checkNotNull(findViewSure, "null cannot be cast to non-null type com.tencent.biz.qqstory.view.PressDarkImageButton");
        PressDarkImageButton pressDarkImageButton = (PressDarkImageButton) findViewSure;
        this.backgroundEditButton = pressDarkImageButton;
        if (pressDarkImageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundEditButton");
            pressDarkImageButton = null;
        }
        pressDarkImageButton.setVisibility(0);
        pressDarkImageButton.setImageResource(R.drawable.izg);
        pressDarkImageButton.setOnClickListener(this);
    }
}
