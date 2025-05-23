package com.tencent.qqnt.qbasealbum.album.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.album.viewmodel.TimelineController;
import com.tencent.qqnt.qbasealbum.view.MediaRecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/model/a;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/tencent/qqnt/qbasealbum/select/model/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PickerMediaListPart$initTimelineView$2 extends Lambda implements Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ PickerMediaListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerMediaListPart$initTimelineView$2(PickerMediaListPart pickerMediaListPart) {
        super(1);
        this.this$0 = pickerMediaListPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pickerMediaListPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PickerMediaListPart this$0) {
        TimelineController timelineController;
        MediaRecyclerView mediaRecyclerView;
        MediaRecyclerView mediaRecyclerView2;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        timelineController = this$0.timelineController;
        if (timelineController != null) {
            mediaRecyclerView = this$0.mediaRecyclerView;
            MediaRecyclerView mediaRecyclerView3 = null;
            if (mediaRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView = null;
            }
            int height = mediaRecyclerView.getHeight();
            mediaRecyclerView2 = this$0.mediaRecyclerView;
            if (mediaRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            } else {
                mediaRecyclerView3 = mediaRecyclerView2;
            }
            int top = height - mediaRecyclerView3.getTop();
            i3 = this$0.timeBubbleOffset;
            timelineController.A(top - i3);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
        invoke2(aVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
        MediaRecyclerView mediaRecyclerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        mediaRecyclerView = this.this$0.mediaRecyclerView;
        if (mediaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView = null;
        }
        final PickerMediaListPart pickerMediaListPart = this.this$0;
        mediaRecyclerView.post(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.album.view.p
            @Override // java.lang.Runnable
            public final void run() {
                PickerMediaListPart$initTimelineView$2.b(PickerMediaListPart.this);
            }
        });
    }
}
