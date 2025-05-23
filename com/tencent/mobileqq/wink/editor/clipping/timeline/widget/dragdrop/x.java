package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0019j\b\u0012\u0004\u0012\u00020\u0002`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R!\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0019j\b\u0012\u0004\u0012\u00020\u0002`\u001a8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/x;", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/y;", "trackModel", tl.h.F, "", "trackType", "a", "(I)Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/y;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;", "dragViewModel", "", "b", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;)Z", "c", "d", com.tencent.mobileqq.msf.service.b.f250814q, "", "g", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;)V", "f", "()V", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/d;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/d;", "controller", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "tracks", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/v;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/v;", "getTrackConfig", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/v;", "setTrackConfig", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/v;)V", "trackConfig", "e", "()Ljava/util/ArrayList;", "trackModels", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/d;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d controller;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<y> tracks;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TrackConfig trackConfig;

    public x(@NotNull d controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.controller = controller;
        this.tracks = new ArrayList<>();
        this.trackConfig = new TrackConfig(0.0f, 0.0f, 0.0f, 7, null);
    }

    private final y h(y trackModel) {
        trackModel.q(trackModel.getIndex() * (c() + d()));
        trackModel.m(trackModel.getTop() + c());
        trackModel.o(this.controller.s());
        trackModel.p(this.controller.u());
        return trackModel;
    }

    @NotNull
    public final y a(int trackType) {
        ArrayList<y> arrayList = this.tracks;
        return h(w.a(arrayList, trackType, arrayList.size()));
    }

    public final boolean b(@NotNull DragViewModel dragViewModel) {
        Object obj;
        Intrinsics.checkNotNullParameter(dragViewModel, "dragViewModel");
        for (y yVar : this.tracks) {
            Iterator<T> it = yVar.d().iterator();
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
            DragViewModel dragViewModel2 = (DragViewModel) obj;
            if (dragViewModel2 != null) {
                if (yVar.getIndex() != dragViewModel2.getTrackIndex()) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int c() {
        return com.tencent.videocut.utils.e.f384236a.a(this.trackConfig.getTrackHeight());
    }

    public final int d() {
        return com.tencent.videocut.utils.e.f384236a.a(this.trackConfig.getTrackMargin());
    }

    @NotNull
    public final ArrayList<y> e() {
        return this.tracks;
    }

    public final void f() {
        int size = this.tracks.size();
        while (true) {
            size--;
            if (-1 < size && this.tracks.get(size).j()) {
                this.tracks.remove(size);
            } else {
                return;
            }
        }
    }

    public final void g(@NotNull DragViewModel newModel) {
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        for (y yVar : this.tracks) {
            int i3 = 0;
            for (Object obj : yVar.d()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((DragViewModel) obj).getId(), newModel.getId())) {
                    yVar.d().set(i3, newModel);
                    return;
                }
                i3 = i16;
            }
        }
    }
}
