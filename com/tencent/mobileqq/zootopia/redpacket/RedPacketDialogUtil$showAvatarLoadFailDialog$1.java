package com.tencent.mobileqq.zootopia.redpacket;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class RedPacketDialogUtil$showAvatarLoadFailDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RedPacketDialogUtil$showAvatarLoadFailDialog$1(Context context, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$context = context;
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.FALSE);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context context = this.$context;
        final Function1<Boolean, Unit> function1 = this.$callback;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.redpacket.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RedPacketDialogUtil$showAvatarLoadFailDialog$1.c(Function1.this, dialogInterface, i3);
            }
        };
        final Function1<Boolean, Unit> function12 = this.$callback;
        DialogUtil.createCustomDialog(context, 0, (String) null, "\u545c\u545cT.T\uff5e\u5f62\u8c61\u52a0\u8f7d\u5931\u8d25", "\u5173\u95ed", "\u91cd\u65b0\u52a0\u8f7d", onClickListener, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.redpacket.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RedPacketDialogUtil$showAvatarLoadFailDialog$1.d(Function1.this, dialogInterface, i3);
            }
        }).show();
    }
}
