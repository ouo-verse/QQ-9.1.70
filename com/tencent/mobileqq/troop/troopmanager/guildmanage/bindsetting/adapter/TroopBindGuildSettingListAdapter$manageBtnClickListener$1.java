package com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter;

import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.kernel.nativeinterface.AIOBindGuildInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "guildInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopBindGuildSettingListAdapter$manageBtnClickListener$1 extends Lambda implements Function1<AIOBindGuildInfo, Unit> {
    final /* synthetic */ TroopBindGuildSettingListAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopBindGuildSettingListAdapter$manageBtnClickListener$1(TroopBindGuildSettingListAdapter troopBindGuildSettingListAdapter) {
        super(1);
        this.this$0 = troopBindGuildSettingListAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TroopBindGuildSettingListAdapter this$0, AIOBindGuildInfo guildInfo, DialogInterface dialogInterface, int i3) {
        LifecycleOwner lifecycleOwner;
        ht2.g gVar;
        Map<String, ? extends Object> m06;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildInfo, "$guildInfo");
        lifecycleOwner = this$0.viewLifecycleOwner;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopBindGuildSettingListAdapter$manageBtnClickListener$1$1$dialog$1$1(this$0, guildInfo, null), 3, null);
        gVar = this$0.vm;
        m06 = this$0.m0(guildInfo);
        gVar.c2("em_group_channel_unbind", "dt_clck", m06);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AIOBindGuildInfo aIOBindGuildInfo) {
        invoke2(aIOBindGuildInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final AIOBindGuildInfo guildInfo) {
        Context context;
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        context = this.this$0.context;
        if (context != null) {
            final TroopBindGuildSettingListAdapter troopBindGuildSettingListAdapter = this.this$0;
            if (!NetworkUtil.isNetworkAvailable(context)) {
                QQToast.makeText(context, 1, context.getString(R.string.f171139ci4), 1).show();
                return;
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, HardCodeUtil.qqStr(R.string.f23378787), HardCodeUtil.qqStr(R.string.f2339078i), HardCodeUtil.qqStr(R.string.f2059456z), HardCodeUtil.qqStr(R.string.f2336477t), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopBindGuildSettingListAdapter$manageBtnClickListener$1.c(TroopBindGuildSettingListAdapter.this, guildInfo, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopBindGuildSettingListAdapter$manageBtnClickListener$1.d(dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(it,\n \u2026miss()\n                })");
            createCustomDialog.show();
        }
    }
}
