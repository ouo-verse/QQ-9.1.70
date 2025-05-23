package com.tencent.mobileqq.zootopia.redpacket;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class RedPacketDialogUtil$showMaintenanceDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ZPlanMaintInfo $info;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedPacketDialogUtil$showMaintenanceDialog$1(Context context, ZPlanMaintInfo zPlanMaintInfo) {
        super(0);
        this.$context = context;
        this.$info = zPlanMaintInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.$context, 230);
        createCustomDialog.setTitle(this.$info.f());
        createCustomDialog.setMessage(this.$info.g());
        createCustomDialog.setPositiveButton(R.string.xqq, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.redpacket.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RedPacketDialogUtil$showMaintenanceDialog$1.b(dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton((String) null, (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(true);
        createCustomDialog.show();
    }
}
