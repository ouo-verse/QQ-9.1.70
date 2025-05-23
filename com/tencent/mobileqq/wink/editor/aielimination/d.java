package com.tencent.mobileqq.wink.editor.aielimination;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationTabName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/d;", "Lcom/tencent/mobileqq/wink/editor/aielimination/WinkEliminateOperatorPart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "canClicked", "M9", "", "z9", "", "A9", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationTabName;", "x9", "C9", "i", "Landroid/view/View;", "operatorView", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d extends WinkEliminateOperatorPart {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View operatorView;

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart
    @NotNull
    public String A9() {
        return "\u4e00\u952e\u53bb\u6c34\u5370";
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart
    @NotNull
    public View C9() {
        View view = this.operatorView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatorView");
            return null;
        }
        return view;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart
    public void M9(boolean canClicked) {
        E9().setAlpha(1.0f);
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.zyj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.op_watermark_layout)");
        this.operatorView = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatorView");
            findViewById = null;
        }
        super.onInitView(findViewById);
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart
    @NotNull
    public AIEliminationTabName x9() {
        return AIEliminationTabName.REMOVE_WATERMARK;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart
    public int z9() {
        return R.drawable.qui_ai_cleanup_white;
    }
}
