package com.tencent.av.business.servlet;

import com.tencent.av.business.handler.MobileNetSwitchHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/av/business/servlet/e;", "Lcom/tencent/av/business/servlet/a;", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "toMsg", "", "a", "<init>", "()V", "d", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class e extends a {
    @Override // com.tencent.av.business.servlet.a
    protected void a(@Nullable FromServiceMsg response, @Nullable ToServiceMsg toMsg) {
        if (QLog.isColorLevel()) {
            QLog.i("MobileNetServlet", 2, "handleResponse");
        }
        AppRuntime appRuntime = getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) appRuntime).getBusinessHandler(MobileNetSwitchHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.av.business.handler.MobileNetSwitchHandler");
        ((MobileNetSwitchHandler) businessHandler).getMMobileNetSwitchService().b(toMsg, response);
    }
}
