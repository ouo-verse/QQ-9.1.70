package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig;

import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class QQGuildNavigatorConfigFragment$getConfigInfo$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ QQGuildNavigatorConfigFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGuildNavigatorConfigFragment$getConfigInfo$1$2(QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment) {
        super(0);
        this.this$0 = qQGuildNavigatorConfigFragment;
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
        DialogUtil.createCustomDialog(this.this$0.getActivity(), 230, (String) null, QQGuildUIUtil.r(R.string.f1509916h), (String) null, QQGuildUIUtil.r(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ab
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQGuildNavigatorConfigFragment$getConfigInfo$1$2.b(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }
}
