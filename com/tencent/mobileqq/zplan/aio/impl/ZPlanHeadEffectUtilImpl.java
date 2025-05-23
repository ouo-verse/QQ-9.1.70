package com.tencent.mobileqq.zplan.aio.impl;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.zplan.aio.IZPlanHeadEffectUtil;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/impl/ZPlanHeadEffectUtilImpl;", "Lcom/tencent/mobileqq/zplan/aio/IZPlanHeadEffectUtil;", "()V", "enable", "", "source", "", "saveExtInfoToMessage", "", "message", "Lcom/tencent/imcore/message/Message;", "key", "value", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanHeadEffectUtilImpl implements IZPlanHeadEffectUtil {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveExtInfoToMessage$lambda$1(Message message) {
        Intrinsics.checkNotNullParameter(message, "$message");
        AppRuntime d16 = bb.f335811a.d();
        if (d16 != null) {
            Manager manager = d16.getManager(QQManagerFactory.MGR_MSG_FACADE);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.imcore.message.QQMessageFacade");
            ((QQMessageFacade) manager).a1(message.frienduin, message.istroop, message.uniseq, AppConstants.Key.COLUMN_EXT_STR, message.extStr);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanHeadEffectUtil
    public boolean enable(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return ZPlanQQMC.INSTANCE.enableHeadEffect();
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanHeadEffectUtil
    public void saveExtInfoToMessage(final Message message, String key, String value) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        message.saveExtInfoToExtStr(key, value);
        t74.l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.s
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanHeadEffectUtilImpl.saveExtInfoToMessage$lambda$1(Message.this);
            }
        });
    }
}
