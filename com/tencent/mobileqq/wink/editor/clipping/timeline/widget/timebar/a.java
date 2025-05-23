package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/a;", "Lf63/a;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarView;", "", "f", "", "position", "d", "r", "c", NodeProps.MIN_WIDTH, "a", "", "b", "set", "e", "", NodeProps.VISIBLE, ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends f63.a<TimeBarView> {
    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.j
    @NotNull
    public Set<Integer> b() {
        Set<Integer> emptySet;
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.a
    public int c() {
        return m().d() + (getPanelViewController().getConfig().getLayoutConfig().getPanelStartOffset() << 1);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.a
    public void d(int position) {
        TimeBarView n3 = n();
        if (n3 != null) {
            n3.scrollTo(position, n3.getScrollY());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.j
    public void e(@NotNull Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "set");
    }

    @Override // i63.a
    public void f() {
        TimeBarView n3 = n();
        if (n3 != null) {
            n3.invalidate();
        }
    }

    public final void r(int position) {
        getPanelViewController().v(position, null);
    }

    public final void s(boolean visible) {
        int i3;
        TimeBarView n3 = n();
        if (n3 != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            n3.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.a
    public void a(int minWidth) {
    }
}
