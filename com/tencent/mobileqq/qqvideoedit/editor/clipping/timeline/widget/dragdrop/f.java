package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016J\u0016\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016J\u000f\u0010\u0010\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0011J#\u0010\u0016\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/f;", "Lpj2/a;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;", "", "position", "", "d", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "c", NodeProps.MIN_WIDTH, "a", "", "b", "set", "e", "p", "()I", "r", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/a;", "startPoint", "endPoint", "t", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/a;Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/a;)V", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/h;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "dragModelList", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/x;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/x;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/x;", "setTrackManager$qqvideoedit_impl_release", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/x;)V", "trackManager", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f extends pj2.a<DragDropScrollView> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<DragModel> dragModelList = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private x trackManager = new x(this);

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.a
    public void a(int minWidth) {
        DragDropScrollView m3 = m();
        if (m3 != null) {
            m3.g0(minWidth);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.l
    @NotNull
    public Set<Integer> b() {
        Set<Integer> emptySet;
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.a
    public int c() {
        DragDropScrollView m3 = m();
        if (m3 != null) {
            return m3.I();
        }
        return 0;
    }

    @Override // tj2.b
    public void d(int position) {
        DragDropScrollView m3 = m();
        if (m3 != null) {
            m3.l(position, m3.getScrollY());
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.l
    public void e(@NotNull Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "set");
        DragDropScrollView m3 = m();
        if (m3 != null) {
            m3.setAttractPointPosition$qqvideoedit_impl_release(set);
        }
    }

    @Override // pj2.a
    public void n() {
        DragDropScrollView m3 = m();
        if (m3 != null) {
            m3.d0();
        }
    }

    public final int p() {
        DragDropScrollView m3 = m();
        if (m3 != null) {
            return m3.getHalfScreenWidth();
        }
        return 0;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final x getTrackManager() {
        return this.trackManager;
    }

    public final int r() {
        DragDropScrollView m3 = m();
        if (m3 != null) {
            return m3.P();
        }
        return 0;
    }

    public final void s(int position) {
        getPanelViewController().n(position, this);
    }

    public final void t(@Nullable AttractPoint startPoint, @Nullable AttractPoint endPoint) {
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
        i.c(startPoint, endPoint);
    }
}
