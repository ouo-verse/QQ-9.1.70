package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\u0016\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timebar/b;", "Lpj2/a;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timebar/TimeBarView;", "", "position", "", "d", "p", "c", NodeProps.MIN_WIDTH, "a", "", "b", "set", "e", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends pj2.a<TimeBarView> {
    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.l
    @NotNull
    public Set<Integer> b() {
        Set<Integer> emptySet;
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.a
    public int c() {
        return l().c() + (getPanelViewController().getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String().getLayoutConfig().getPanelStartOffset() << 1);
    }

    @Override // tj2.b
    public void d(int position) {
        TimeBarView m3 = m();
        if (m3 != null) {
            m3.scrollTo(position, m3.getScrollY());
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.l
    public void e(@NotNull Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "set");
    }

    public final void p(int position) {
        getPanelViewController().n(position, null);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.a
    public void a(int minWidth) {
    }
}
