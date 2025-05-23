package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016J#\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016J\u0016\u0010\u0016\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0019\u0010\u0018J#\u0010\u001d\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\"\u0010*\u001a\u00020$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/d;", "Lf63/a;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;", "", "f", "", "position", "d", "v", "o", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;", "T", "", "tag", "r", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;", "c", NodeProps.MIN_WIDTH, "a", "", "b", "set", "e", ReportConstant.COSTREPORT_PREFIX, "()I", "u", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/a;", "startPoint", "endPoint", "w", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/a;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/a;)V", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/f;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "dragModelList", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/x;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/x;", "t", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/x;", "setTrackManager$qq_wink_impl_release", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/x;)V", "trackManager", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d extends f63.a<DragDropScrollView> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<DragModel> dragModelList = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private x trackManager = new x(this);

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.a
    public void a(int minWidth) {
        DragDropScrollView n3 = n();
        if (n3 != null) {
            n3.j0(minWidth);
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
        DragDropScrollView n3 = n();
        if (n3 != null) {
            return n3.M();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.a
    public void d(int position) {
        DragDropScrollView n3 = n();
        if (n3 != null) {
            n3.l(position, n3.getScrollY());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.j
    public void e(@NotNull Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "set");
        DragDropScrollView n3 = n();
        if (n3 != null) {
            n3.setAttractPointPosition$qq_wink_impl_release(set);
        }
    }

    @Override // i63.a
    public void f() {
        for (DragModel dragModel : this.dragModelList) {
            m r16 = r(dragModel.getId());
            if (r16 != null) {
                r16.setDragViewModel(DragViewModel.b(r16.j(), null, getPanelViewController().getScaleCalculator().y(dragModel.getStartTime()), getPanelViewController().getScaleCalculator().y(dragModel.getEndTime()), 0L, 0, null, null, 121, null));
                this.trackManager.g(r16.j());
            }
        }
        DragDropScrollView n3 = n();
        if (n3 != null) {
            n3.g0();
        }
    }

    @Override // f63.a
    public void o() {
        DragDropScrollView n3 = n();
        if (n3 != null) {
            n3.g0();
        }
    }

    @Nullable
    public final <T extends m> T r(@Nullable Object tag) {
        T t16;
        DragDropScrollView n3 = n();
        if (n3 != null && (t16 = (T) n3.K(tag)) != null) {
            return t16;
        }
        return null;
    }

    public final int s() {
        DragDropScrollView n3 = n();
        if (n3 != null) {
            return n3.getHalfScreenWidth();
        }
        return 0;
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final x getTrackManager() {
        return this.trackManager;
    }

    public final int u() {
        DragDropScrollView n3 = n();
        if (n3 != null) {
            return n3.T();
        }
        return 0;
    }

    public final void v(int position) {
        getPanelViewController().v(position, this);
    }

    public final void w(@Nullable AttractPoint startPoint, @Nullable AttractPoint endPoint) {
        long endTime;
        Object obj;
        long endTime2;
        Object obj2 = null;
        if (startPoint != null) {
            Iterator<T> it = this.dragModelList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(startPoint.getId(), ((DragModel) obj).getId())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            DragModel dragModel = (DragModel) obj;
            if (dragModel != null) {
                if (startPoint.getIsStart()) {
                    endTime2 = dragModel.getStartTime();
                } else {
                    endTime2 = dragModel.getEndTime();
                }
                startPoint = AttractPoint.b(startPoint, endTime2, 0, null, false, 14, null);
            }
        }
        if (endPoint != null) {
            Iterator<T> it5 = this.dragModelList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (Intrinsics.areEqual(endPoint.getId(), ((DragModel) next).getId())) {
                    obj2 = next;
                    break;
                }
            }
            DragModel dragModel2 = (DragModel) obj2;
            if (dragModel2 != null) {
                if (endPoint.getIsStart()) {
                    endTime = dragModel2.getStartTime();
                } else {
                    endTime = dragModel2.getEndTime();
                }
                endPoint = AttractPoint.b(endPoint, endTime, 0, null, false, 14, null);
            }
        }
        g.c(startPoint, endPoint);
    }
}
