package com.tencent.mobileqq.zplan.manager;

import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class ZPlanProfileLikeManager$ZPlanSVipManager$showDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ZPlanProfileLikeManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanProfileLikeManager$ZPlanSVipManager$showDialog$1(ZPlanProfileLikeManager zPlanProfileLikeManager) {
        super(0);
        this.this$0 = zPlanProfileLikeManager;
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
        DialogUtil.createCustomDialog(this.this$0.getContext(), 232, (String) null, HardCodeUtil.qqStr(R.string.msk), (String) null, HardCodeUtil.qqStr(R.string.mss), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.manager.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZPlanProfileLikeManager$ZPlanSVipManager$showDialog$1.b(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }
}
