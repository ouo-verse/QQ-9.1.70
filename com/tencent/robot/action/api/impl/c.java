package com.tencent.robot.action.api.impl;

import android.net.Uri;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mvi.base.route.j;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n14.AIOSchemeActionContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/action/api/impl/c;", "Ln14/b;", "Ln14/a;", "ctx", "Landroid/net/Uri;", ZPlanPublishSource.FROM_SCHEME, "", "d", "Ln14/c;", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends n14.b<AIOSchemeActionContext> {
    @Override // n14.b
    public boolean c(@NotNull n14.c ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return ctx instanceof AIOSchemeActionContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n14.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull AIOSchemeActionContext ctx, @NotNull Uri scheme) {
        boolean z16;
        Object msgRecord;
        MsgRecord msgRecord2;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        String queryParameter = scheme.getQueryParameter("command");
        if (queryParameter == null) {
            queryParameter = "";
        }
        if (ctx.getAioContext().g().r().c().e() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AIOMsgItem msgItemRef = ctx.getMsgItemRef();
            if (msgItemRef == null || (msgRecord = msgItemRef.getMsgRecord()) == null) {
                msgRecord = ctx.getMsgRecord();
            }
            if (msgRecord instanceof MsgRecord) {
                msgRecord2 = (MsgRecord) msgRecord;
            } else {
                msgRecord2 = null;
            }
            if (msgRecord2 == null) {
                return false;
            }
            j e16 = ctx.getAioContext().e();
            String valueOf = String.valueOf(msgRecord2.senderUin);
            String senderUid = msgRecord2.senderUid;
            String a16 = u64.c.a(msgRecord2);
            Intrinsics.checkNotNullExpressionValue(senderUid, "senderUid");
            e16.h(new AIOMsgSendEvent.AtMsgSendEvent(queryParameter, senderUid, valueOf, a16));
        } else {
            ctx.getAioContext().e().h(new AIOMsgSendEvent.TextSendEvent(queryParameter));
        }
        return true;
    }
}
