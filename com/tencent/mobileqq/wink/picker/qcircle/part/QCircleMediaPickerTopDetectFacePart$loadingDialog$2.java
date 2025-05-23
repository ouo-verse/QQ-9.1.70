package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.view.View;
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
public final class QCircleMediaPickerTopDetectFacePart$loadingDialog$2 extends Lambda implements Function0<QCircleCommonLoadingDialog> {
    final /* synthetic */ QCircleMediaPickerTopDetectFacePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleMediaPickerTopDetectFacePart$loadingDialog$2(QCircleMediaPickerTopDetectFacePart qCircleMediaPickerTopDetectFacePart) {
        super(0);
        this.this$0 = qCircleMediaPickerTopDetectFacePart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QCircleMediaPickerTopDetectFacePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f("QCircleMediaPickerTopDetectFacePart", "Cancel LoadingDialog...");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean e() {
        return Boolean.TRUE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QCircleCommonLoadingDialog invoke() {
        QCircleCommonLoadingDialog.c j3 = new QCircleCommonLoadingDialog.c(this.this$0.getContext()).n(false).p("\u4eba\u50cf\u7b5b\u9009\u4e2d").j("");
        final QCircleMediaPickerTopDetectFacePart qCircleMediaPickerTopDetectFacePart = this.this$0;
        return j3.h(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleMediaPickerTopDetectFacePart$loadingDialog$2.d(QCircleMediaPickerTopDetectFacePart.this, view);
            }
        }).d(new Callable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean e16;
                e16 = QCircleMediaPickerTopDetectFacePart$loadingDialog$2.e();
                return e16;
            }
        }).a();
    }
}
