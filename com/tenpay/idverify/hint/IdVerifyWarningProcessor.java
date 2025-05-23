package com.tenpay.idverify.hint;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.idverify.IdVerifyCommonHintVC;
import com.tenpay.idverify.hint.IdVerifyHintFragment;
import com.tenpay.idverify.model.IdVerifyStateBean;
import com.tenpay.sdk.util.WalletGateData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyWarningProcessor;", "Lcom/tenpay/idverify/hint/IdVerifyStateProcessor;", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment$IFragmentAbility;", "fragment", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment;", "stateBean", "Lcom/tenpay/idverify/model/IdVerifyStateBean;", "(Lcom/tenpay/idverify/hint/IdVerifyHintFragment;Lcom/tenpay/idverify/model/IdVerifyStateBean;)V", "onBackEvent", "", "setVCData", "", "vc", "Lcom/tenpay/idverify/IdVerifyCommonHintVC;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyWarningProcessor extends IdVerifyStateProcessor implements IdVerifyHintFragment.IFragmentAbility {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdVerifyWarningProcessor(@NotNull IdVerifyHintFragment fragment, @NotNull IdVerifyStateBean stateBean) {
        super(fragment, stateBean);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(stateBean, "stateBean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVCData$lambda$0(IdVerifyWarningProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFragment().exitCurrentProcess();
        WalletGateData.getInstance().clear();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.idverify.hint.IdVerifyHintFragment.IFragmentAbility
    public boolean onBackEvent() {
        getFragment().exitCurrentProcess();
        WalletGateData.getInstance().clear();
        return true;
    }

    @Override // com.tenpay.idverify.hint.IdVerifyStateProcessor, com.tenpay.idverify.hint.IdVerifyHintFragment.IdVerifyHintProcessor
    public void setVCData(@NotNull IdVerifyCommonHintVC vc5) {
        Intrinsics.checkNotNullParameter(vc5, "vc");
        super.setVCData(vc5);
        vc5.setConfirmButton(vc5.resources().getString(R.string.f2187964o), new View.OnClickListener() { // from class: com.tenpay.idverify.hint.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IdVerifyWarningProcessor.setVCData$lambda$0(IdVerifyWarningProcessor.this, view);
            }
        });
    }
}
