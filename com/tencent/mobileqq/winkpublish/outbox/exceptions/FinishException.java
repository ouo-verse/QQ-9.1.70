package com.tencent.mobileqq.winkpublish.outbox.exceptions;

import com.tencent.mobileqq.winkpublish.report.TaskErrorCode;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/exceptions/FinishException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "errorCode", "Lcom/tencent/mobileqq/winkpublish/report/TaskErrorCode;", "(Lcom/tencent/mobileqq/winkpublish/report/TaskErrorCode;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class FinishException extends CancellationException {
    public FinishException(TaskErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
    }
}
