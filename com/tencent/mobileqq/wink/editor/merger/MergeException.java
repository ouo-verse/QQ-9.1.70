package com.tencent.mobileqq.wink.editor.merger;

import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/merger/MergeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "winkErrorCode", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "(Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;)V", "getWinkErrorCode", "()Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class MergeException extends RuntimeException {

    @NotNull
    private final ExportErrorCode winkErrorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MergeException(@NotNull ExportErrorCode winkErrorCode) {
        super(winkErrorCode.getMessage());
        Intrinsics.checkNotNullParameter(winkErrorCode, "winkErrorCode");
        this.winkErrorCode = winkErrorCode;
    }

    @NotNull
    public final ExportErrorCode getWinkErrorCode() {
        return this.winkErrorCode;
    }
}
