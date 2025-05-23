package com.tencent.mobileqq.winkpublish.outbox.exceptions;

import com.tencent.mobileqq.winkpublish.report.TaskErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/exceptions/PreUploadException;", "Lcom/tencent/mobileqq/winkpublish/outbox/exceptions/WinkPublishBaseException;", "errorCode", "Lcom/tencent/mobileqq/winkpublish/report/TaskErrorCode;", "(Lcom/tencent/mobileqq/winkpublish/report/TaskErrorCode;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class PreUploadException extends WinkPublishBaseException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreUploadException(TaskErrorCode errorCode) {
        super(errorCode);
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
    }
}
