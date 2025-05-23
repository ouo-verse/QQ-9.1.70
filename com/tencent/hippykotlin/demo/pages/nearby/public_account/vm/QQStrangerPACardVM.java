package com.tencent.hippykotlin.demo.pages.nearby.public_account.vm;

import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public class QQStrangerPACardVM extends BaseComposeCardViewModel {
    public boolean isFromCache;
    public final QQStrangerPublicAccountViewModel mainVM;

    public QQStrangerPACardVM(QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel) {
        this.mainVM = qQStrangerPublicAccountViewModel;
    }

    public final void callbackIsNotVisitor(Function0<Unit> function0) {
        final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel = this.mainVM;
        if (qQStrangerPublicAccountViewModel.getAppId() == 1) {
            if (qQStrangerPublicAccountViewModel.visitor) {
                ((QQUIModule) c.f117352a.g().acquireModule("QQUIModule")).openAlertDialog("", "\u9700\u8981\u6ce8\u518c\u7ed3\u4f34\u8d26\u53f7\u624d\u80fd\u64cd\u4f5c\u54e6", "\u53bb\u6ce8\u518c", "\u53d6\u6d88", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$callbackIsNotVisitor$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Boolean bool, Boolean bool2) {
                        boolean booleanValue = bool.booleanValue();
                        bool2.booleanValue();
                        if (!booleanValue) {
                            KLog.INSTANCE.i("QQStrangerPublicAccountVM", "jieban callbackIsNotVisitor trigger login");
                            QQStrangerPublicAccountViewModel.this.showUserRegisterLoading.setValue(Boolean.TRUE);
                            QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel2 = QQStrangerPublicAccountViewModel.this;
                            qQStrangerPublicAccountViewModel2.needToSetVisitor = true;
                            qQStrangerPublicAccountViewModel2.startLogin(false);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return;
            } else {
                function0.invoke();
                return;
            }
        }
        if (qQStrangerPublicAccountViewModel.getAppId() == 2) {
            if (qQStrangerPublicAccountViewModel.visitor) {
                ((QQUIModule) c.f117352a.g().acquireModule("QQUIModule")).openAlertDialog("", "\u9700\u8981\u6ce8\u518c\u9644\u8fd1\u8d26\u53f7\u624d\u80fd\u64cd\u4f5c\u54e6", "\u53bb\u6ce8\u518c", "\u53d6\u6d88", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel$callbackIsNotVisitor$2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Boolean bool, Boolean bool2) {
                        boolean booleanValue = bool.booleanValue();
                        bool2.booleanValue();
                        if (!booleanValue) {
                            KLog.INSTANCE.i("QQStrangerPublicAccountVM", "nearbypro callbackIsNotVisitor trigger login");
                            QQStrangerPublicAccountViewModel.this.showUserRegisterLoading.setValue(Boolean.TRUE);
                            QQStrangerPublicAccountViewModel.this.startLogin(false);
                        }
                        return Unit.INSTANCE;
                    }
                });
            } else {
                function0.invoke();
            }
        }
    }
}
