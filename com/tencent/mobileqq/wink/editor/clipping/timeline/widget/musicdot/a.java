package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0014j\b\u0012\u0004\u0012\u00020\b`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/a;", "Lf63/a;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/MusicDotBarView;", "", "position", "", "r", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/b;", "list", ReportConstant.COSTREPORT_PREFIX, "f", "d", "", "b", "set", "e", "c", NodeProps.MIN_WIDTH, "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "musicDotList", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends f63.a<MusicDotBarView> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MusicDotModel> musicDotList = new ArrayList<>();

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.j
    @NotNull
    public Set<Integer> b() {
        int collectionSizeOrDefault;
        Set<Integer> set;
        ArrayList<MusicDotModel> arrayList = this.musicDotList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((MusicDotModel) obj).getNeedAttract()) {
                arrayList2.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Integer.valueOf(m().y(((MusicDotModel) it.next()).getDotTimeUs())));
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList3);
        return set;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.a
    public int c() {
        return m().d() + (getPanelViewController().getConfig().getLayoutConfig().getPanelStartOffset() << 1);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.a
    public void d(int position) {
        MusicDotBarView n3 = n();
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
        MusicDotBarView n3 = n();
        if (n3 != null) {
            n3.invalidate();
        }
    }

    public final void r(int position) {
        getPanelViewController().v(position, null);
    }

    public final void s(@NotNull List<MusicDotModel> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.musicDotList.clear();
        this.musicDotList.addAll(list);
        MusicDotBarView n3 = n();
        if (n3 != null) {
            n3.f(this.musicDotList);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.a
    public void a(int minWidth) {
    }
}
