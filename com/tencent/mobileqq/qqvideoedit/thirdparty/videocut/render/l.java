package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.Logger;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tavcut.model.ClipSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0002\u0016\u001aB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/l;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/j;", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "newClips", "", DomainData.DOMAIN_NAME, "", "count", "position", "", "payload", "j", "fromPosition", "toPosition", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "mediaModel", "c", "Lcom/tencent/tavcut/session/a;", "a", "Lcom/tencent/tavcut/session/a;", "tavCutSession", "", "b", "Ljava/util/List;", "oldList", "<init>", "(Lcom/tencent/tavcut/session/a;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class l implements j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.a tavCutSession;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<MediaClip> oldList;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/l$b;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "getChangePayload", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "a", "Ljava/util/List;", "getOldClips", "()Ljava/util/List;", "oldClips", "b", "getNewClips", "newClips", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends DiffUtil.Callback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<MediaClip> oldClips;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<MediaClip> newClips;

        public b(@NotNull List<MediaClip> oldClips, @NotNull List<MediaClip> newClips) {
            Intrinsics.checkNotNullParameter(oldClips, "oldClips");
            Intrinsics.checkNotNullParameter(newClips, "newClips");
            this.oldClips = oldClips;
            this.newClips = newClips;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            if (Intrinsics.areEqual(this.oldClips.get(oldItemPosition).resource, this.newClips.get(newItemPosition).resource) && Intrinsics.areEqual(this.oldClips.get(oldItemPosition).matrix, this.newClips.get(newItemPosition).matrix)) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            String str;
            ResourceModel resourceModel = this.oldClips.get(oldItemPosition).resource;
            String str2 = null;
            if (resourceModel != null) {
                str = resourceModel.id;
            } else {
                str = null;
            }
            ResourceModel resourceModel2 = this.newClips.get(newItemPosition).resource;
            if (resourceModel2 != null) {
                str2 = resourceModel2.id;
            }
            return Intrinsics.areEqual(str, str2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        @Nullable
        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
            return this.newClips.get(newItemPosition);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newClips.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldClips.size();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/l$c", "Landroidx/recyclerview/widget/ListUpdateCallback;", "", "position", "count", "", "onInserted", "onRemoved", "fromPosition", "toPosition", "onMoved", "", "payload", "onChanged", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements ListUpdateCallback {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<MediaClip> f276143e;

        c(List<MediaClip> list) {
            this.f276143e = list;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int position, int count, @Nullable Object payload) {
            l.this.j(count, position, payload);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int position, int count) {
            l.this.k(count, position, this.f276143e);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int fromPosition, int toPosition) {
            l.this.l(fromPosition, toPosition);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int position, int count) {
            l.this.m(position, count);
        }
    }

    public l(@NotNull com.tencent.tavcut.session.a tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        this.tavCutSession = tavCutSession;
        this.oldList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(int count, int position, Object payload) {
        IntRange until;
        int collectionSizeOrDefault;
        ArrayList arrayList = new ArrayList();
        until = RangesKt___RangesKt.until(0, count);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((IntIterator) it).nextInt() + position));
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            int intValue = ((Number) it5.next()).intValue();
            MediaClip mediaClip = this.oldList.get(intValue);
            Intrinsics.checkNotNull(payload, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip");
            MediaClip mediaClip2 = (MediaClip) payload;
            this.oldList.set(intValue, mediaClip2);
            ClipSource c16 = gk2.d.c(mediaClip2);
            if (c16 != null) {
                arrayList.add(c16);
            }
            Logger.f275870a.b("MediaClipProcessor", "onChanged  position " + intValue + ", count " + count + " oldItem " + mediaClip + ", \nnewItem " + mediaClip2);
        }
        this.tavCutSession.getIClipSourceOperator().e(position, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int count, int position, List<MediaClip> newClips) {
        IntRange until;
        int collectionSizeOrDefault;
        ArrayList arrayList = new ArrayList();
        until = RangesKt___RangesKt.until(0, count);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((IntIterator) it).nextInt() + position));
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            int intValue = ((Number) it5.next()).intValue();
            MediaClip mediaClip = newClips.get(intValue);
            this.oldList.add(intValue, mediaClip);
            ClipSource c16 = gk2.d.c(mediaClip);
            if (c16 != null) {
                arrayList.add(c16);
            }
            Logger.f275870a.b("MediaClipProcessor", "onInserted  position " + position + ", count " + count + ", newItem " + mediaClip);
        }
        this.tavCutSession.getIClipSourceOperator().d(position, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(int fromPosition, int toPosition) {
        Logger.f275870a.b("MediaClipProcessor", "onMoved  fromPosition " + fromPosition + ", toPosition " + toPosition);
        this.oldList.add(toPosition, this.oldList.remove(fromPosition));
        this.tavCutSession.getIClipSourceOperator().a(fromPosition, toPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int position, int count) {
        for (int i3 = 0; i3 < count; i3++) {
            this.oldList.remove(position);
        }
        this.tavCutSession.getIClipSourceOperator().c(position, count + position);
    }

    private final void n(List<MediaClip> newClips) {
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new b(this.oldList, newClips));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(MediaClips\u2026lBack(oldList, newClips))");
        calculateDiff.dispatchUpdatesTo(new c(newClips));
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.j
    public void c(@NotNull MediaModel mediaModel) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        n(mediaModel.videos);
    }
}
