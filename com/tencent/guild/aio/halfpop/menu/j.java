package com.tencent.guild.aio.halfpop.menu;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/j;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/menu/g;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Landroid/view/View;", "view", "data", "", "t", "<init>", "()V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class j extends com.tencent.guild.aio.reserve2.busi.chosen.menu.g<GuildMsgItem> {
    public j() {
        super(R.string.f16491274);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final j this$0, final GuildMsgItem data, int i3, String str) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        QLog.i("DeleteGrayTipsMsgForSelf", 1, "[onItemClick] res = " + i3 + ", errMsg = " + str);
        if (com.tencent.guild.aio.util.y.b(i3) && (activity = this$0.h().c().getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.guild.aio.halfpop.menu.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.v(j.this, data);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(j this$0, GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        QLog.i("DeleteGrayTipsMsgForSelf", 1, "[onItemClick] send intent");
        this$0.h().e().h(new DeleteGrayTipsMsgIntent(data));
    }

    @Override // com.tencent.guild.aio.reserve2.busi.chosen.menu.g, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull View view, @NotNull final GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.b(view, data);
        QLog.i("DeleteGrayTipsMsgForSelf", 1, "[onItemClick] ");
        GProContact gProContact = new GProContact(data.getMsgRecord().chatType, data.getMsgRecord().peerUid, data.getMsgRecord().guildId);
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.deleteRecallMsgForLocal(gProContact, data.getMsgId(), new IGuildOperateCallback() { // from class: com.tencent.guild.aio.halfpop.menu.h
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    j.u(j.this, data, i3, str);
                }
            });
        }
    }
}
