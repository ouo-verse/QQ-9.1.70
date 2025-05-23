package com.tencent.guild.aio.msglist.video;

import com.tencent.aio.msgservice.j;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guild.api.msg.service.l;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/msglist/video/e;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/aio/api/runtime/a;", "mContext", "", "d", "c", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f111990a = new e();

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Ref.ObjectRef sendMsgsCB, int i3, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(sendMsgsCB, "$sendMsgsCB");
        Function1 function1 = (Function1) sendMsgsCB.element;
        if (function1 != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            function1.invoke(new j(z16, i3, str, ""));
        }
    }

    public final void b(@NotNull MsgRecord msgRecord, @NotNull com.tencent.aio.api.runtime.a mContext) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Logger.f235387a.d().d("GuildVideoSendProcessor", 1, "handleCancelSendVideoMsg, msgId = " + msgRecord.msgId);
        ChannelAIOMsgService.f112613a.g(msgRecord.msgId, mContext.g().r().c().j(), mContext.g().r().c().e());
    }

    public final void c(@NotNull MsgRecord msgRecord, @NotNull com.tencent.aio.api.runtime.a mContext) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Logger.f235387a.d().d("GuildVideoSendProcessor", 1, "handleResendVideoMsg, msgId = " + msgRecord.msgId);
        ChannelAIOMsgService.f112613a.z(mContext.g().r(), msgRecord.msgId);
    }

    public final void d(@NotNull MsgRecord msgRecord, @NotNull com.tencent.aio.api.runtime.a mContext) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Logger.f235387a.d().d("GuildVideoSendProcessor", 1, "handle sendVideo msg , msgId = " + msgRecord.msgId);
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        if (arrayList.isEmpty()) {
            return;
        }
        Contact c16 = l.f112634a.c(mContext.g().r());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ((IMsgService) QRoute.api(IMsgService.class)).sendMsgWithMsgId(c16, msgRecord.msgId, arrayList, new IOperateCallback() { // from class: com.tencent.guild.aio.msglist.video.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                e.e(Ref.ObjectRef.this, i3, str);
            }
        });
    }
}
