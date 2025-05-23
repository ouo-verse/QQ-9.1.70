package com.tencent.biz.qqcircle.publicaccount;

import com.tencent.common.app.business.BaseQQAppInterface;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/common/app/business/BaseQQAppInterface;", "b", "()Lcom/tencent/common/app/business/BaseQQAppInterface;", "qqAppInterface", "qcircle-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseQQAppInterface b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            return (BaseQQAppInterface) peekAppRuntime;
        }
        return null;
    }
}
