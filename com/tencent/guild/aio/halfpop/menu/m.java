package com.tencent.guild.aio.halfpop.menu;

import android.view.View;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/m;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/menu/g;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Landroid/view/View;", "view", "data", "", "r", "<init>", "()V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class m extends com.tencent.guild.aio.reserve2.busi.chosen.menu.g<GuildMsgItem> {
    public m() {
        super(R.string.f153051b2);
    }

    @Override // com.tencent.guild.aio.reserve2.busi.chosen.menu.g, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.b(view, data);
        QLog.d("GuildResendTextMenu", 1, "resend msg, msgId = " + data.getMsgId() + ", msgType = " + data.getMsgRecord().msgType);
        if (data.getMsgRecord().msgType != 7 && !qr0.d.p(data)) {
            ChannelAIOMsgService.f112613a.z(h().g().r(), data.getMsgId());
        } else {
            h().e().h(new GuildVideoMsgResendIntent(data.getMsgId()));
        }
        h().e().h(new GuildMsgResendStatusIntent(data.getMsgId()));
    }
}
