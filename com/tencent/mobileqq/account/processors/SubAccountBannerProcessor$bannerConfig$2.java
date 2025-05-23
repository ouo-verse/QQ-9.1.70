package com.tencent.mobileqq.account.processors;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.account.configs.SubAccountBannerConfig;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/account/configs/SubAccountBannerConfig;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class SubAccountBannerProcessor$bannerConfig$2 extends Lambda implements Function0<SubAccountBannerConfig> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ SubAccountBannerProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubAccountBannerProcessor$bannerConfig$2(SubAccountBannerProcessor subAccountBannerProcessor) {
        super(0);
        this.this$0 = subAccountBannerProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) subAccountBannerProcessor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SubAccountBannerProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final SubAccountBannerConfig invoke() {
        com.tencent.mobileqq.account.viewmodel.c I;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SubAccountBannerConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Activity e16 = this.this$0.e();
        QBaseActivity qBaseActivity = e16 instanceof QBaseActivity ? (QBaseActivity) e16 : null;
        if (qBaseActivity == null) {
            qBaseActivity = QBaseActivity.sTopActivity;
        }
        I = this.this$0.I();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        final SubAccountBannerProcessor subAccountBannerProcessor = this.this$0;
        return new SubAccountBannerConfig(I, qBaseActivity, new View.OnClickListener() { // from class: com.tencent.mobileqq.account.processors.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubAccountBannerProcessor$bannerConfig$2.b(SubAccountBannerProcessor.this, view);
            }
        });
    }
}
