package com.tencent.qqnt.aio.robot.api.impl;

import com.tencent.qqnt.aio.interceptor.sendmsg.a;
import com.tencent.qqnt.aio.interceptor.sendmsg.c;
import com.tencent.qqnt.aio.interceptor.sendmsg.d;
import com.tencent.qqnt.aio.robot.api.IAIORobotApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/robot/api/impl/AIORobotApiNtImpl;", "Lcom/tencent/qqnt/aio/robot/api/IAIORobotApi;", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/a;", "createAIOSendMsgInterceptor", "", "isInterceptAtRobotSendMsgEnable", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/c;", "paramWrapper", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/d;", "intercept", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIORobotApiNtImpl implements IAIORobotApi, a {
    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    @NotNull
    public d intercept(@NotNull c paramWrapper) {
        Intrinsics.checkNotNullParameter(paramWrapper, "paramWrapper");
        return new d(false, true);
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    public boolean interceptResend(@NotNull com.tencent.aio.api.runtime.a aVar, @NotNull com.tencent.aio.data.msglist.a aVar2) {
        return a.C9483a.a(this, aVar, aVar2);
    }

    @Override // com.tencent.qqnt.aio.robot.api.IAIORobotApi
    public boolean isInterceptAtRobotSendMsgEnable() {
        return false;
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    public void reportAfterKernelSend(boolean z16, long j3) {
        a.C9483a.b(this, z16, j3);
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    public void reportBeforeKernelSend(boolean z16, long j3) {
        a.C9483a.c(this, z16, j3);
    }

    @Override // com.tencent.qqnt.aio.robot.api.IAIORobotApi
    @NotNull
    public a createAIOSendMsgInterceptor() {
        return this;
    }
}
