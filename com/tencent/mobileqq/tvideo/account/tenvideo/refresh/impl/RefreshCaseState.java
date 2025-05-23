package com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/a;", "", "", "a", "", "toString", "", "hashCode", "other", "equals", "Z", "isNetValid", "()Z", "c", "(Z)V", "b", "isPageValid", "d", "isForeground", "<init>", "(ZZZ)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl.a, reason: from toString */
/* loaded from: classes19.dex */
public final /* data */ class RefreshCaseState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isNetValid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isPageValid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isForeground;

    public RefreshCaseState(boolean z16, boolean z17, boolean z18) {
        this.isNetValid = z16;
        this.isPageValid = z17;
        this.isForeground = z18;
    }

    public final boolean a() {
        if (this.isNetValid && this.isPageValid && this.isForeground) {
            return true;
        }
        return false;
    }

    public final void b(boolean z16) {
        this.isForeground = z16;
    }

    public final void c(boolean z16) {
        this.isNetValid = z16;
    }

    public final void d(boolean z16) {
        this.isPageValid = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RefreshCaseState)) {
            return false;
        }
        RefreshCaseState refreshCaseState = (RefreshCaseState) other;
        if (this.isNetValid == refreshCaseState.isNetValid && this.isPageValid == refreshCaseState.isPageValid && this.isForeground == refreshCaseState.isForeground) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.isNetValid;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isPageValid;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z17 = this.isForeground;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        return "RefreshCaseState(isNetValid=" + this.isNetValid + ", isPageValid=" + this.isPageValid + ", isForeground=" + this.isForeground + ")";
    }
}
