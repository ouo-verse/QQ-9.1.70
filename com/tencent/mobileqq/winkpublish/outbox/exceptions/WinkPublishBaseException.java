package com.tencent.mobileqq.winkpublish.outbox.exceptions;

import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/exceptions/WinkPublishBaseException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "winkErrorCode", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "(Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;)V", "getErrorCode", "", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public class WinkPublishBaseException extends RuntimeException {
    private final WinkBaseErrorCode winkErrorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkPublishBaseException(WinkBaseErrorCode winkErrorCode) {
        super(winkErrorCode.getMessage());
        Intrinsics.checkNotNullParameter(winkErrorCode, "winkErrorCode");
        this.winkErrorCode = winkErrorCode;
    }

    public final long getErrorCode() {
        return this.winkErrorCode.transformedCode();
    }
}
