package com.tencent.filament.zplan.avatar.exception;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/filament/zplan/avatar/exception/IllegalViewerException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class IllegalViewerException extends IllegalArgumentException {
    public IllegalViewerException() {
        super("viewer is null");
    }
}
