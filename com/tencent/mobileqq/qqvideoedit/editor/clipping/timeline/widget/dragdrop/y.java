package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b \u0018\u0000 \"2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b.\u0010/J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u0011\u0010-\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/y;", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;", "dragViewModel", "", "start", "end", "", "a", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;II)Z", "", "k", "", "id", "l", "c", "", "Ljava/util/List;", "d", "()Ljava/util/List;", "blocks", "b", "I", "i", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "top", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bottom", "g", "o", "leftMargin", tl.h.F, "p", "rightMargin", "f", DomainData.DOMAIN_NAME, "index", "getTrackType", "r", "trackType", "j", "()Z", "isEmptyTrack", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<DragViewModel> blocks = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int top;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int bottom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int leftMargin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int rightMargin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int index;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int trackType;

    public static /* synthetic */ boolean b(y yVar, DragViewModel dragViewModel, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = dragViewModel.getStartPosition();
        }
        if ((i17 & 4) != 0) {
            i16 = dragViewModel.getEndPosition();
        }
        return yVar.a(dragViewModel, i3, i16);
    }

    public final boolean a(@NotNull DragViewModel dragViewModel, int start, int end) {
        int coerceAtLeast;
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(dragViewModel, "dragViewModel");
        if (j()) {
            return true;
        }
        for (DragViewModel dragViewModel2 : this.blocks) {
            if (!Intrinsics.areEqual(dragViewModel2.getId(), dragViewModel.getId())) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(start, dragViewModel2.getStartPosition());
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(end, dragViewModel2.getEndPosition());
                if (coerceAtLeast < coerceAtMost) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean c(@Nullable String id5) {
        List<DragViewModel> list = this.blocks;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(id5, ((DragViewModel) it.next()).getId())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<DragViewModel> d() {
        return this.blocks;
    }

    /* renamed from: e, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    /* renamed from: f, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: g, reason: from getter */
    public final int getLeftMargin() {
        return this.leftMargin;
    }

    /* renamed from: h, reason: from getter */
    public final int getRightMargin() {
        return this.rightMargin;
    }

    /* renamed from: i, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    public final boolean j() {
        return this.blocks.isEmpty();
    }

    public final void k(@NotNull DragViewModel dragViewModel) {
        Object obj;
        Intrinsics.checkNotNullParameter(dragViewModel, "dragViewModel");
        Iterator<T> it = this.blocks.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((DragViewModel) obj).getId(), dragViewModel.getId())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            this.blocks.add(dragViewModel);
        }
    }

    public final boolean l(@NotNull String id5) {
        Object obj;
        Intrinsics.checkNotNullParameter(id5, "id");
        Iterator<T> it = this.blocks.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((DragViewModel) obj).getId(), id5)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        DragViewModel dragViewModel = (DragViewModel) obj;
        if (dragViewModel != null) {
            this.blocks.remove(dragViewModel);
            return true;
        }
        return false;
    }

    public final void m(int i3) {
        this.bottom = i3;
    }

    public final void n(int i3) {
        this.index = i3;
    }

    public final void o(int i3) {
        this.leftMargin = i3;
    }

    public final void p(int i3) {
        this.rightMargin = i3;
    }

    public final void q(int i3) {
        this.top = i3;
    }

    public final void r(int i3) {
        this.trackType = i3;
    }
}
