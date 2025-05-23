package com.tencent.kuikly.core.base;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000*\u0010\b\u0000\u0010\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0014\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/kuikly/core/base/aa;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "T", "", "other", "", "equals", "", "toString", "a", "Ljava/lang/String;", "getPagerId", "()Ljava/lang/String;", "pagerId", "", "b", "I", "()I", "nativeRef", "()Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "<init>", "(Ljava/lang/String;I)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class aa<T extends DeclarativeBaseView<?, ?>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String pagerId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int nativeRef;

    public aa(String pagerId, int i3) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        this.pagerId = pagerId;
        this.nativeRef = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getNativeRef() {
        return this.nativeRef;
    }

    public final T b() {
        AbstractBaseView<?, ?> viewWithNativeRef = com.tencent.kuikly.core.manager.c.f117352a.k(this.pagerId).getViewWithNativeRef(this.nativeRef);
        if (viewWithNativeRef instanceof DeclarativeBaseView) {
            return (T) viewWithNativeRef;
        }
        return null;
    }

    public String toString() {
        return "pagerId:" + this.pagerId + " nativeRef:" + this.nativeRef;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof aa)) {
            return false;
        }
        aa aaVar = (aa) other;
        return Intrinsics.areEqual(this.pagerId, aaVar.pagerId) && this.nativeRef == aaVar.nativeRef;
    }
}
