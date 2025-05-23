package com.tenpay.idverify.hint;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.idverify.IdVerifyCommonHintVC;
import com.tenpay.idverify.hint.IdVerifyHintFragment;
import com.tenpay.idverify.model.IdVerifyStateBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyUnknownProcessor;", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment$IdVerifyHintProcessor;", "fragment", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment;", "stateBean", "Lcom/tenpay/idverify/model/IdVerifyStateBean;", "(Lcom/tenpay/idverify/hint/IdVerifyHintFragment;Lcom/tenpay/idverify/model/IdVerifyStateBean;)V", "setVCData", "", "vc", "Lcom/tenpay/idverify/IdVerifyCommonHintVC;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyUnknownProcessor implements IdVerifyHintFragment.IdVerifyHintProcessor {

    @NotNull
    private final IdVerifyHintFragment fragment;

    @Nullable
    private final IdVerifyStateBean stateBean;

    public IdVerifyUnknownProcessor(@NotNull IdVerifyHintFragment fragment, @Nullable IdVerifyStateBean idVerifyStateBean) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.stateBean = idVerifyStateBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVCData$lambda$0(IdVerifyUnknownProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fragment.exitCurrentProcess();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.idverify.hint.IdVerifyHintFragment.IdVerifyHintProcessor
    public void setVCData(@NotNull IdVerifyCommonHintVC vc5) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(vc5, "vc");
        Drawable drawable = ResourcesCompat.getDrawable(vc5.resources(), R.drawable.olf, null);
        IdVerifyStateBean idVerifyStateBean = this.stateBean;
        if (idVerifyStateBean == null || (string = idVerifyStateBean.getStateTitle()) == null) {
            string = vc5.resources().getString(R.string.f21856642);
            Intrinsics.checkNotNullExpressionValue(string, "vc.resources().getString\u2026llet_real_name_error_msg)");
        }
        String str = string;
        IdVerifyStateBean idVerifyStateBean2 = this.stateBean;
        if (idVerifyStateBean2 == null || (string2 = idVerifyStateBean2.getStateTip()) == null) {
            string2 = vc5.resources().getString(R.string.f2187964o);
            Intrinsics.checkNotNullExpressionValue(string2, "vc.resources().getString\u2026l_name_result_btn_ensure)");
        }
        IdVerifyCommonHintVC.setData$default(vc5, drawable, str, null, string2, new View.OnClickListener() { // from class: com.tenpay.idverify.hint.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IdVerifyUnknownProcessor.setVCData$lambda$0(IdVerifyUnknownProcessor.this, view);
            }
        }, null, null, 100, null);
    }

    public /* synthetic */ IdVerifyUnknownProcessor(IdVerifyHintFragment idVerifyHintFragment, IdVerifyStateBean idVerifyStateBean, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(idVerifyHintFragment, (i3 & 2) != 0 ? null : idVerifyStateBean);
    }
}
