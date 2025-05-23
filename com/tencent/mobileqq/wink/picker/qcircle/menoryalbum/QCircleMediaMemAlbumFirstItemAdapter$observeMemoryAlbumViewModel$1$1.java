package com.tencent.mobileqq.wink.picker.qcircle.menoryalbum;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/data/a;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$1 extends Lambda implements Function1<List<? extends WinkAlbumItemWrapper>, Unit> {
    final /* synthetic */ QCircleMediaMemAlbumFirstItemAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$1(QCircleMediaMemAlbumFirstItemAdapter qCircleMediaMemAlbumFirstItemAdapter) {
        super(1);
        this.this$0 = qCircleMediaMemAlbumFirstItemAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QCircleMediaMemAlbumFirstItemAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QCircleMediaMemAlbumFirstItemAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyDataSetChanged();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WinkAlbumItemWrapper> list) {
        invoke2((List<WinkAlbumItemWrapper>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<WinkAlbumItemWrapper> list) {
        boolean z16;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if ((list != null ? list.size() : 0) == 0) {
            this.this$0.hasNotified = false;
            recyclerView2 = this.this$0.attachedRv;
            if (recyclerView2 != null) {
                final QCircleMediaMemAlbumFirstItemAdapter qCircleMediaMemAlbumFirstItemAdapter = this.this$0;
                recyclerView2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$1.c(QCircleMediaMemAlbumFirstItemAdapter.this);
                    }
                });
                return;
            }
            return;
        }
        z16 = this.this$0.hasNotified;
        if (z16) {
            return;
        }
        this.this$0.hasNotified = true;
        recyclerView = this.this$0.attachedRv;
        if (recyclerView != null) {
            final QCircleMediaMemAlbumFirstItemAdapter qCircleMediaMemAlbumFirstItemAdapter2 = this.this$0;
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.h
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$1.d(QCircleMediaMemAlbumFirstItemAdapter.this);
                }
            });
        }
    }
}
