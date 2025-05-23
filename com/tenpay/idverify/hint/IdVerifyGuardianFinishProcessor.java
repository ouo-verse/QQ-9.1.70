package com.tenpay.idverify.hint;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.idverify.IdVerifyCommonHintVC;
import com.tenpay.idverify.model.IdVerifyStateBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyGuardianFinishProcessor;", "Lcom/tenpay/idverify/hint/IdVerifyStateProcessor;", "fragment", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment;", "stateBean", "Lcom/tenpay/idverify/model/IdVerifyStateBean;", "(Lcom/tenpay/idverify/hint/IdVerifyHintFragment;Lcom/tenpay/idverify/model/IdVerifyStateBean;)V", "setVCData", "", "vc", "Lcom/tenpay/idverify/IdVerifyCommonHintVC;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyGuardianFinishProcessor extends IdVerifyStateProcessor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdVerifyGuardianFinishProcessor(@NotNull IdVerifyHintFragment fragment, @NotNull IdVerifyStateBean stateBean) {
        super(fragment, stateBean);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(stateBean, "stateBean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVCData$lambda$0(IdVerifyGuardianFinishProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFragment().exitCurrentProcess();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.idverify.hint.IdVerifyStateProcessor, com.tenpay.idverify.hint.IdVerifyHintFragment.IdVerifyHintProcessor
    public void setVCData(@NotNull IdVerifyCommonHintVC vc5) {
        Intrinsics.checkNotNullParameter(vc5, "vc");
        super.setVCData(vc5);
        vc5.setConfirmButton(vc5.resources().getString(R.string.b9f), new View.OnClickListener() { // from class: com.tenpay.idverify.hint.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IdVerifyGuardianFinishProcessor.setVCData$lambda$0(IdVerifyGuardianFinishProcessor.this, view);
            }
        });
    }
}
