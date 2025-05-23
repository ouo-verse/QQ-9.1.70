package com.tencent.mobileqq.guild.live.fragment.audience.module.topbar;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class QQGuildTopBarLiveFragment$mExitLiveDialog$2 extends Lambda implements Function0<QQCustomDialog> {
    final /* synthetic */ QQGuildTopBarLiveFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGuildTopBarLiveFragment$mExitLiveDialog$2(QQGuildTopBarLiveFragment qQGuildTopBarLiveFragment) {
        super(0);
        this.this$0 = qQGuildTopBarLiveFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QQGuildTopBarLiveFragment this$0, DialogInterface dialogInterface, int i3) {
        HashMap hashMapOf;
        com.tencent.mobileqq.guild.live.viewmodel.h hVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("live_room_type", String.valueOf(gLiveChannelCore.s().getLiveType())));
        com.tencent.mobileqq.guild.performance.report.l.i("live_room_live_end_dialog_end", hashMapOf, 0, null, 12, null);
        hVar = this$0.mGuildLiveRoomVM;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildLiveRoomVM");
            hVar = null;
        }
        hVar.c2("anchor click end live, liveType:" + gLiveChannelCore.s().getLiveType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i3) {
        com.tencent.mobileqq.guild.performance.report.l.i("live_room_live_end_dialog_cancel", null, 0, null, 14, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QQCustomDialog invoke() {
        Context context = this.this$0.getContext();
        String h16 = cw.h(R.string.f147650xg);
        String h17 = cw.h(R.string.f147630xe);
        String h18 = cw.h(R.string.f140850f3);
        String h19 = cw.h(R.string.f147640xf);
        final QQGuildTopBarLiveFragment qQGuildTopBarLiveFragment = this.this$0;
        return DialogUtil.createCustomDialog(context, 230, h16, h17, h18, h19, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQGuildTopBarLiveFragment$mExitLiveDialog$2.c(QQGuildTopBarLiveFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQGuildTopBarLiveFragment$mExitLiveDialog$2.d(dialogInterface, i3);
            }
        });
    }
}
