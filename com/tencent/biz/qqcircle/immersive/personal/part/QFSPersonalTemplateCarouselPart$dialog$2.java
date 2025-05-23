package com.tencent.biz.qqcircle.immersive.personal.part;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qqcircle/widgets/dialog/QCircleLoadingDialog;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSPersonalTemplateCarouselPart$dialog$2 extends Lambda implements Function0<QCircleLoadingDialog> {
    final /* synthetic */ QFSPersonalTemplateCarouselPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalTemplateCarouselPart$dialog$2(QFSPersonalTemplateCarouselPart qFSPersonalTemplateCarouselPart) {
        super(0);
        this.this$0 = qFSPersonalTemplateCarouselPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QCircleLoadingDialog this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QFSPersonalTemplateCarouselPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSPersonalTemplateCarouselPart", 1, "dialog dismiss ");
        this$0.da();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QCircleLoadingDialog invoke() {
        final QCircleLoadingDialog qCircleLoadingDialog = new QCircleLoadingDialog(this.this$0.getContext());
        final QFSPersonalTemplateCarouselPart qFSPersonalTemplateCarouselPart = this.this$0;
        qCircleLoadingDialog.S("\u89c6\u9891\u751f\u6210\u4e2d");
        ImageView U = qCircleLoadingDialog.U();
        U.setVisibility(0);
        U.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPersonalTemplateCarouselPart$dialog$2.c(QCircleLoadingDialog.this, view);
            }
        });
        qCircleLoadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.ac
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                QFSPersonalTemplateCarouselPart$dialog$2.d(QFSPersonalTemplateCarouselPart.this, dialogInterface);
            }
        });
        return qCircleLoadingDialog;
    }
}
