package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/t;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class t implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        Intrinsics.checkNotNullParameter(command, "command");
        ThreadManagerV2.getUIHandlerV2().post(command);
    }
}
