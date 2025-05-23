package com.tencent.biz.qqcircle.immersive.redpacket.part;

import android.content.DialogInterface;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qqcircle/widgets/dialog/QCircleLoadingDialog;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSRedPacketPreviewInfoPart$loadingDialog$2 extends Lambda implements Function0<QCircleLoadingDialog> {
    final /* synthetic */ QFSRedPacketPreviewInfoPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSRedPacketPreviewInfoPart$loadingDialog$2(QFSRedPacketPreviewInfoPart qFSRedPacketPreviewInfoPart) {
        super(0);
        this.this$0 = qFSRedPacketPreviewInfoPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QFSRedPacketPreviewInfoPart this$0, DialogInterface dialogInterface) {
        com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h Z9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Z9 = this$0.Z9();
        Z9.N1();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QCircleLoadingDialog invoke() {
        QCircleLoadingDialog qCircleLoadingDialog = new QCircleLoadingDialog(this.this$0.getContext());
        final QFSRedPacketPreviewInfoPart qFSRedPacketPreviewInfoPart = this.this$0;
        qCircleLoadingDialog.S(qCircleLoadingDialog.getContext().getString(R.string.f194734cp));
        qCircleLoadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.al
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                QFSRedPacketPreviewInfoPart$loadingDialog$2.b(QFSRedPacketPreviewInfoPart.this, dialogInterface);
            }
        });
        return qCircleLoadingDialog;
    }
}
