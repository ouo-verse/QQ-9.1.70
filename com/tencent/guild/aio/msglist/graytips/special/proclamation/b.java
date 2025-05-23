package com.tencent.guild.aio.msglist.graytips.special.proclamation;

import android.text.TextUtils;
import com.tencent.guild.aio.msglist.graytips.special.proclamation.GuildProclamationGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.special.proclamation.a;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.guild.aio.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.ProclamationElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/proclamation/b;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/ProclamationElement;", "proclamationElement", "", "l", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends t {
    private final void l(MsgRecord msgRecord, ProclamationElement proclamationElement) {
        String nickName = msgRecord.sendMemberName;
        if (TextUtils.isEmpty(nickName)) {
            nickName = msgRecord.sendNickName;
        }
        if (TextUtils.isEmpty(nickName)) {
            nickName = l.b(l.f112411a, R.string.f143010kx, null, 2, null).toString();
        }
        Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
        updateUI(new GuildProclamationGrayTipsUIState.SetProclamationText(nickName));
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C1198a) {
            a.C1198a c1198a = (a.C1198a) intent;
            l(c1198a.getMsgRecord(), c1198a.getProclamationElement());
        }
    }
}
