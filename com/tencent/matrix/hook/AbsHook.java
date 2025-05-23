package com.tencent.matrix.hook;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class AbsHook {

    /* renamed from: a, reason: collision with root package name */
    private Status f151452a = Status.UNCOMMIT;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum Status {
        UNCOMMIT,
        COMMIT_SUCCESS,
        COMMIT_FAIL_ON_LOAD_LIB,
        COMMIT_FAIL_ON_CONFIGURE,
        COMMIT_FAIL_ON_HOOK
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public abstract String a();

    public Status b() {
        return this.f151452a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean c();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean d(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Status status) {
        this.f151452a = status;
    }
}
