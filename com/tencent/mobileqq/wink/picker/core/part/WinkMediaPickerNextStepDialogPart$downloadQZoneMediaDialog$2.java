package com.tencent.mobileqq.wink.picker.core.part;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkMediaPickerNextStepDialogPart$downloadQZoneMediaDialog$2 extends Lambda implements Function0<QCircleCommonLoadingDialog> {
    final /* synthetic */ WinkMediaPickerNextStepDialogPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMediaPickerNextStepDialogPart$downloadQZoneMediaDialog$2(WinkMediaPickerNextStepDialogPart winkMediaPickerNextStepDialogPart) {
        super(0);
        this.this$0 = winkMediaPickerNextStepDialogPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(WinkMediaPickerNextStepDialogPart this$0, View view) {
        WinkMediaPickerNextStepDialogPart.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aVar = this$0.callback;
        aVar.onCancelClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean d(WinkMediaPickerNextStepDialogPart this$0) {
        WinkMediaPickerNextStepDialogPart.a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aVar = this$0.callback;
        aVar.onCancelClick();
        return Boolean.FALSE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QCircleCommonLoadingDialog invoke() {
        this.this$0.isQZoneDialogInit = true;
        QCircleCommonLoadingDialog.c p16 = new QCircleCommonLoadingDialog.c(this.this$0.getContext()).n(false).p(this.this$0.getContext().getString(R.string.f216335y1));
        final WinkMediaPickerNextStepDialogPart winkMediaPickerNextStepDialogPart = this.this$0;
        QCircleCommonLoadingDialog.c h16 = p16.h(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkMediaPickerNextStepDialogPart$downloadQZoneMediaDialog$2.c(WinkMediaPickerNextStepDialogPart.this, view);
            }
        });
        final WinkMediaPickerNextStepDialogPart winkMediaPickerNextStepDialogPart2 = this.this$0;
        return h16.d(new Callable() { // from class: com.tencent.mobileqq.wink.picker.core.part.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean d16;
                d16 = WinkMediaPickerNextStepDialogPart$downloadQZoneMediaDialog$2.d(WinkMediaPickerNextStepDialogPart.this);
                return d16;
            }
        }).a();
    }
}
