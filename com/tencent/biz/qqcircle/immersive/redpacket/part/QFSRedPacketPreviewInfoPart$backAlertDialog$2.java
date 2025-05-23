package com.tencent.biz.qqcircle.immersive.redpacket.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qqcircle/widgets/QCircleCustomDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
final class QFSRedPacketPreviewInfoPart$backAlertDialog$2 extends Lambda implements Function0<QCircleCustomDialog> {
    final /* synthetic */ QFSRedPacketPreviewInfoPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSRedPacketPreviewInfoPart$backAlertDialog$2(QFSRedPacketPreviewInfoPart qFSRedPacketPreviewInfoPart) {
        super(0);
        this.this$0 = qFSRedPacketPreviewInfoPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QFSRedPacketPreviewInfoPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QCircleCustomDialog invoke() {
        Context context = this.this$0.getContext();
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f194634cf);
        String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f19156455);
        String a18 = com.tencent.biz.qqcircle.utils.h.a(R.string.f194644cg);
        final QFSRedPacketPreviewInfoPart qFSRedPacketPreviewInfoPart = this.this$0;
        QCircleCustomDialog U = QCircleCustomDialog.U(context, null, a16, a17, a18, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.aj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QFSRedPacketPreviewInfoPart$backAlertDialog$2.c(QFSRedPacketPreviewInfoPart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.ak
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QFSRedPacketPreviewInfoPart$backAlertDialog$2.d(dialogInterface, i3);
            }
        });
        U.setCancelable(false);
        return U;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i3) {
    }
}
