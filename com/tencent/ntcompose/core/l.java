package com.tencent.ntcompose.core;

import androidx.compose.runtime.AbstractApplier;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0014J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ntcompose/core/l;", "Landroidx/compose/runtime/AbstractApplier;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "", "index", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "a", "b", "from", "to", "count", "move", "onClear", "remove", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "<init>", "(Lcom/tencent/ntcompose/core/ComposeRenderView;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l extends AbstractApplier<ComposeRenderView> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ComposeRenderView view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ComposeRenderView view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // androidx.compose.runtime.Applier
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void insertBottomUp(int index, ComposeRenderView instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // androidx.compose.runtime.Applier
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void insertTopDown(int index, ComposeRenderView instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        getCurrent().d(index, instance);
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int from, int to5, int count) {
        getCurrent().e(from, to5, count);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void onClear() {
        getCurrent().f();
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int index, int count) {
        getCurrent().g(index, count);
    }
}
