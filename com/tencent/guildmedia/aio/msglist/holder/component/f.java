package com.tencent.guildmedia.aio.msglist.holder.component;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.halfpop.BaseBottomSheetDialog;
import com.tencent.guild.aio.halfpop.menu.p;
import com.tencent.guild.aio.halfpop.menu.q;
import com.tencent.guild.aio.halfpop.menu.s;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/holder/component/f;", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "j", "intent", "handleIntent", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f extends com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> {
    /* JADX WARN: Multi-variable type inference failed */
    private final void j(GuildMsgItem msgItem) {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            BaseBottomSheetDialog baseBottomSheetDialog = new BaseBottomSheetDialog();
            baseBottomSheetDialog.yh(co0.b.f31162a.a(com.tencent.guild.aio.halfpop.c.f110667a.g(), msgItem, (com.tencent.aio.api.runtime.a) getMContext(), false));
            baseBottomSheetDialog.setCancelable(true);
            baseBottomSheetDialog.vh(true);
            baseBottomSheetDialog.th(R.drawable.guild_live_aio_msgmenu_bg);
            q qVar = new q();
            qVar.h(Integer.valueOf(R.drawable.guild_live_top_msg_action_sheet_item_bg));
            qVar.g(0);
            p pVar = new p();
            pVar.e(Integer.valueOf(R.color.bq8));
            pVar.f(Integer.valueOf(R.color.brx));
            baseBottomSheetDialog.xh(new s(pVar, qVar, null, 4, null));
            if (supportFragmentManager.isStateSaved()) {
                QLog.e("BaseBottomSheetDialog", 1, "isStateSaved==true");
            } else {
                baseBottomSheetDialog.show(supportFragmentManager, "BaseBottomSheetDialog");
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.i) {
            j(((a.i) intent).getMsgItem());
        }
    }
}
