package com.tencent.ntcompose.material;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R2\u0010\u0019\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0013\u0018\u00010\u00128\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\n\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ntcompose/material/ak;", "", "", "text", "", "length", "", "b", "(Ljava/lang/String;I)V", "<set-?>", "a", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "I", "getTextLength", "()I", "textLength", "Lcom/tencent/kuikly/core/base/aa;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "c", "Lcom/tencent/kuikly/core/base/aa;", "getRef$ntcompose_release", "()Lcom/tencent/kuikly/core/base/aa;", "(Lcom/tencent/kuikly/core/base/aa;)V", "ref", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String text = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int textLength;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.aa<DeclarativeBaseView<?, ?>> ref;

    public final void a(com.tencent.kuikly.core.base.aa<DeclarativeBaseView<?, ?>> aaVar) {
        this.ref = aaVar;
    }

    public final void b(String text, int length) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.textLength = length;
    }
}
