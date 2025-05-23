package com.tencent.ntcompose.core;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0006\u001a\u00020\u00032\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0002\b\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R/\u0010\u0005\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a2\u0006\u0002\b\u00048\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0007R\"\u0010\u0014\u001a\u00020\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ntcompose/core/g;", "Lcom/tencent/kuikly/core/base/k;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "i", "(Lkotlin/jvm/functions/Function2;)V", "a", "Lkotlin/jvm/functions/Function2;", tl.h.F, "()Lkotlin/jvm/functions/Function2;", "j", "", "b", "Z", "getDidSetContent$ntcompose_release", "()Z", "setDidSetContent$ntcompose_release", "(Z)V", "didSetContent", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends com.tencent.kuikly.core.base.k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function2<? super Composer, ? super Integer, Unit> content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean didSetContent;

    public final Function2<Composer, Integer, Unit> h() {
        return this.content;
    }

    public final void i(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (this.didSetContent) {
            return;
        }
        this.didSetContent = true;
        this.content = content;
    }

    public final void j(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content = function2;
    }
}
