package com.tencent.ntcompose.material.base;

import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ntcompose/material/base/c;", "Lcom/tencent/ntcompose/material/base/b;", "Lcom/tencent/ntcompose/core/i;", "modifier", "", "a", "Lcom/tencent/ntcompose/core/i;", "getLazyModifier", "()Lcom/tencent/ntcompose/core/i;", "setLazyModifier", "(Lcom/tencent/ntcompose/core/i;)V", "lazyModifier", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "value", "b", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "getComposeView", "()Lcom/tencent/ntcompose/core/ComposeRenderView;", "(Lcom/tencent/ntcompose/core/ComposeRenderView;)V", "composeView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private i lazyModifier;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ComposeRenderView composeView;

    @Override // com.tencent.ntcompose.material.base.b
    public void a(i modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposeRenderView composeRenderView = this.composeView;
        if (composeRenderView != null) {
            Intrinsics.checkNotNull(composeRenderView);
            composeRenderView.o(i.INSTANCE, modifier);
        } else {
            this.lazyModifier = modifier;
        }
    }

    public final void b(ComposeRenderView composeRenderView) {
        i iVar;
        if (composeRenderView != null && (iVar = this.lazyModifier) != null) {
            i.Companion companion = i.INSTANCE;
            Intrinsics.checkNotNull(iVar);
            composeRenderView.o(companion, iVar);
            this.lazyModifier = null;
        }
        this.composeView = composeRenderView;
    }
}
