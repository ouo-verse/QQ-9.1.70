package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.os.Handler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012 \u0010\u0002\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007\u0018\u00010\u00032\u001c\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007H\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "batch", "", "Lkotlin/Pair;", "Lcom/tencent/ttpic/openapi/PTFaceAttr;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/aelight/camera/ae/camera/ui/gallery/DetectPair;", "single", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class MiniPhotoListAdapter$startQuery$2 extends Lambda implements Function2<List<? extends Pair<? extends PTFaceAttr, ? extends LocalMediaInfo>>, Pair<? extends PTFaceAttr, ? extends LocalMediaInfo>, Unit> {
    final /* synthetic */ boolean $detectFace;
    final /* synthetic */ Function1<Boolean, Unit> $onEmpty;
    final /* synthetic */ MiniPhotoListAdapter this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((LocalMediaInfo) ((Pair) t17).getSecond()).addedDate), Long.valueOf(((LocalMediaInfo) ((Pair) t16).getSecond()).addedDate));
            return compareValues;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MiniPhotoListAdapter$startQuery$2(MiniPhotoListAdapter miniPhotoListAdapter, Function1<? super Boolean, Unit> function1, boolean z16) {
        super(2);
        this.this$0 = miniPhotoListAdapter;
        this.$onEmpty = function1;
        this.$detectFace = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MiniPhotoListAdapter this$0, List infos, Function1 onEmpty, boolean z16) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(infos, "$infos");
        Intrinsics.checkNotNullParameter(onEmpty, "$onEmpty");
        arrayList = this$0.data;
        arrayList.clear();
        arrayList2 = this$0.data;
        arrayList2.addAll(infos);
        MiniPhotoListAdapter.INSTANCE.a();
        arrayList3 = this$0.data;
        if (arrayList3.isEmpty()) {
            onEmpty.invoke(Boolean.valueOf(z16));
        }
        this$0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MiniPhotoListAdapter this$0, Pair pair) {
        boolean isEmpty;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        isEmpty = this$0.isEmpty();
        if (isEmpty) {
            arrayList3 = this$0.data;
            arrayList3.clear();
        }
        arrayList = this$0.data;
        arrayList.add(new PhotoInfo(false, (LocalMediaInfo) pair.getSecond(), (PTFaceAttr) pair.getFirst()));
        MiniPhotoListAdapter.INSTANCE.a();
        if (!isEmpty) {
            arrayList2 = this$0.data;
            this$0.notifyItemInserted(arrayList2.size());
        } else {
            this$0.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MiniPhotoListAdapter this$0, Function1 onEmpty, boolean z16) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onEmpty, "$onEmpty");
        arrayList = this$0.data;
        arrayList.clear();
        onEmpty.invoke(Boolean.valueOf(z16));
        this$0.notifyDataSetChanged();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Pair<? extends PTFaceAttr, ? extends LocalMediaInfo>> list, Pair<? extends PTFaceAttr, ? extends LocalMediaInfo> pair) {
        invoke2(list, pair);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends Pair<? extends PTFaceAttr, ? extends LocalMediaInfo>> list, final Pair<? extends PTFaceAttr, ? extends LocalMediaInfo> pair) {
        List sortedWith;
        int collectionSizeOrDefault;
        if (list == null) {
            if (pair != null) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final MiniPhotoListAdapter miniPhotoListAdapter = this.this$0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniPhotoListAdapter$startQuery$2.e(MiniPhotoListAdapter.this, pair);
                    }
                });
                return;
            } else {
                Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
                final MiniPhotoListAdapter miniPhotoListAdapter2 = this.this$0;
                final Function1<Boolean, Unit> function1 = this.$onEmpty;
                final boolean z16 = this.$detectFace;
                uIHandlerV22.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniPhotoListAdapter$startQuery$2.f(MiniPhotoListAdapter.this, function1, z16);
                    }
                });
                return;
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new a());
        List<Pair> list2 = sortedWith;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        final ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Pair pair2 : list2) {
            arrayList.add(new PhotoInfo(false, (LocalMediaInfo) pair2.getSecond(), (PTFaceAttr) pair2.getFirst()));
        }
        Handler uIHandlerV23 = ThreadManagerV2.getUIHandlerV2();
        final MiniPhotoListAdapter miniPhotoListAdapter3 = this.this$0;
        final Function1<Boolean, Unit> function12 = this.$onEmpty;
        final boolean z17 = this.$detectFace;
        uIHandlerV23.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.z
            @Override // java.lang.Runnable
            public final void run() {
                MiniPhotoListAdapter$startQuery$2.d(MiniPhotoListAdapter.this, arrayList, function12, z17);
            }
        });
    }
}
