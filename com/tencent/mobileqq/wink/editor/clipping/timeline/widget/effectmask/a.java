package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/a;", "Lf63/a;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer;", "", "f", "", "position", "d", "", "b", "set", "e", "c", NodeProps.MIN_WIDTH, "a", "r", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends f63.a<EffectMaskContainer> {
    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.a
    public void a(int minWidth) {
        EffectMaskContainer n3 = n();
        if (n3 != null) {
            n3.getLayoutParams().width = minWidth;
            n3.setLayoutParams(n3.getLayoutParams());
            n3.K(minWidth);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.j
    @NotNull
    public Set<Integer> b() {
        Set<Integer> emptySet;
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.a
    public int c() {
        return 0;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.a
    public void d(int position) {
        EffectMaskContainer n3 = n();
        if (n3 != null) {
            n3.scrollTo(position, 0);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.j
    public void e(@NotNull Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "set");
    }

    @Override // i63.a
    public void f() {
        EffectMaskContainer n3 = n();
        if (n3 != null) {
            n3.invalidate();
        }
    }

    public final void r(int position) {
        getPanelViewController().v(position, null);
    }
}
