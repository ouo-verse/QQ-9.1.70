package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class FeedIPCApiImpl$handlerConstructorMap$6 extends FunctionReferenceImpl implements Function0<Function2<? super AbsIpcMethod.a, ? super Object[], ? extends EIPCResult>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedIPCApiImpl$handlerConstructorMap$6(Object obj) {
        super(0, obj, FeedIPCApiImpl.class, "syncReBindReportTask", "syncReBindReportTask()Lkotlin/jvm/functions/Function2;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Function2<? super AbsIpcMethod.a, ? super Object[], ? extends EIPCResult> invoke() {
        Function2<? super AbsIpcMethod.a, ? super Object[], ? extends EIPCResult> n3;
        n3 = ((FeedIPCApiImpl) this.receiver).n();
        return n3;
    }
}
