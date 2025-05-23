package com.tencent.mobileqq.wink.picker.core.part;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.core.view.MediaRecyclerView;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Le93/a;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Le93/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaListPart$initTimelineView$2 extends Lambda implements Function1<e93.a, Unit> {
    final /* synthetic */ WinkMediaListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMediaListPart$initTimelineView$2(WinkMediaListPart winkMediaListPart) {
        super(1);
        this.this$0 = winkMediaListPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkMediaListPart this$0) {
        WinkSelectedMediaViewModel winkSelectedMediaViewModel;
        int ga5;
        int ga6;
        List<LocalMediaInfo> selectedMedia;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        winkSelectedMediaViewModel = this$0.selectedMediaViewModel;
        boolean z16 = false;
        if (winkSelectedMediaViewModel != null && (selectedMedia = winkSelectedMediaViewModel.getSelectedMedia()) != null && (!selectedMedia.isEmpty())) {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.wink.picker.core.view.d dVar = this$0.timelineController;
            if (dVar != null) {
                ga6 = this$0.ga();
                dVar.r(ga6);
                return;
            }
            return;
        }
        com.tencent.mobileqq.wink.picker.core.view.d dVar2 = this$0.timelineController;
        if (dVar2 != null) {
            ga5 = this$0.ga();
            dVar2.r(ga5);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e93.a aVar) {
        invoke2(aVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e93.a aVar) {
        MediaRecyclerView mediaRecyclerView;
        mediaRecyclerView = this.this$0.mediaRecyclerView;
        if (mediaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView = null;
        }
        final WinkMediaListPart winkMediaListPart = this.this$0;
        mediaRecyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.part.s
            @Override // java.lang.Runnable
            public final void run() {
                WinkMediaListPart$initTimelineView$2.b(WinkMediaListPart.this);
            }
        });
    }
}
