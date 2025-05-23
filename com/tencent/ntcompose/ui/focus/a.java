package com.tencent.ntcompose.ui.focus;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.aa;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R2\u0010\u000e\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/ui/focus/a;", "", "", "c", "", "a", "b", "Lcom/tencent/kuikly/core/base/aa;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/base/aa;", "getViewRef$ntcompose_release", "()Lcom/tencent/kuikly/core/base/aa;", "d", "(Lcom/tencent/kuikly/core/base/aa;)V", "viewRef", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private aa<DeclarativeBaseView<?, ?>> viewRef;

    public final boolean a() {
        DeclarativeBaseView<?, ?> b16;
        aa<DeclarativeBaseView<?, ?>> aaVar = this.viewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return false;
        }
        return b.b(b16);
    }

    public final boolean b() {
        DeclarativeBaseView<?, ?> b16;
        aa<DeclarativeBaseView<?, ?>> aaVar = this.viewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return false;
        }
        return b.a(b16);
    }

    public final void c() {
        a();
    }

    public final void d(aa<DeclarativeBaseView<?, ?>> aaVar) {
        this.viewRef = aaVar;
    }
}
