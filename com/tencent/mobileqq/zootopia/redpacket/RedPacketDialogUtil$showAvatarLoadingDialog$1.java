package com.tencent.mobileqq.zootopia.redpacket;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class RedPacketDialogUtil$showAvatarLoadingDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedPacketDialogUtil$showAvatarLoadingDialog$1(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DialogUtil.createCustomDialog(this.$context, 0, (String) null, "\u6b63\u5728\u88c5\u626e\u4e2d\uff0c\u8bf7\u7a0d\u5019...", "", "\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.redpacket.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RedPacketDialogUtil$showAvatarLoadingDialog$1.b(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogInterface dialogInterface, int i3) {
    }
}
