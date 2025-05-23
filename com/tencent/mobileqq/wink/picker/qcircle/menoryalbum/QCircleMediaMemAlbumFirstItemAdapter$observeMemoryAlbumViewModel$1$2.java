package com.tencent.mobileqq.wink.picker.qcircle.menoryalbum;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ QCircleMediaMemAlbumFirstItemAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$2(QCircleMediaMemAlbumFirstItemAdapter qCircleMediaMemAlbumFirstItemAdapter) {
        super(1);
        this.this$0 = qCircleMediaMemAlbumFirstItemAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QCircleMediaMemAlbumFirstItemAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyDataSetChanged();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0020, code lost:
    
        r3 = r2.this$0.attachedRv;
     */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(Boolean bool) {
        RecyclerView recyclerView;
        w53.b.f("QCircleMediaMemAlbumItemAdapter", "allAlbumDataTypeData allAlbumDataLoadFinished:" + bool);
        if (!Intrinsics.areEqual(bool, Boolean.TRUE) || recyclerView == null) {
            return;
        }
        final QCircleMediaMemAlbumFirstItemAdapter qCircleMediaMemAlbumFirstItemAdapter = this.this$0;
        recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.i
            @Override // java.lang.Runnable
            public final void run() {
                QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$2.b(QCircleMediaMemAlbumFirstItemAdapter.this);
            }
        });
    }
}
