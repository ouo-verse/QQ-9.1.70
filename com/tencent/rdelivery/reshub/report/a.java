package com.tencent.rdelivery.reshub.report;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\f\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/rdelivery/reshub/report/a;", "", "", "d", "", "a", "I", "()I", "e", "(I)V", "errorCode", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "extraMessage", "", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "f", "(Ljava/lang/Throwable;)V", "exception", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int errorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String extraMessage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Throwable exception;

    /* renamed from: a, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Throwable getException() {
        return this.exception;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getExtraMessage() {
        return this.extraMessage;
    }

    public final boolean d() {
        if (this.errorCode == 0) {
            return true;
        }
        return false;
    }

    public final void e(int i3) {
        this.errorCode = i3;
    }

    public final void f(@Nullable Throwable th5) {
        this.exception = th5;
    }

    public final void g(@Nullable String str) {
        this.extraMessage = str;
    }
}
