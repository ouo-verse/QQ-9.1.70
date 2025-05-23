package com.tencent.tav.core;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ExportRuntimeException extends RuntimeException {

    @NonNull
    private final ExportErrorStatus errorStatus;

    public ExportRuntimeException(int i3, Throwable th5) {
        this(new ExportErrorStatus(i3, th5));
    }

    @NonNull
    public ExportErrorStatus getErrorStatus() {
        return this.errorStatus;
    }

    public ExportRuntimeException(@NonNull ExportErrorStatus exportErrorStatus) {
        super(exportErrorStatus.throwable);
        this.errorStatus = exportErrorStatus;
    }
}
