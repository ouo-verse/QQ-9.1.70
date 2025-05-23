package com.tencent.robot.action.api.impl;

import android.net.Uri;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.dialog.msgintent.InputDialogPriorityMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import n14.AIOSchemeActionContext;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J:\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/action/api/impl/RobotParameterCmdSchemeAction;", "Ln14/b;", "Ln14/a;", "Lcom/tencent/aio/api/runtime/a;", "ctx", "", "isInGroup", "isReply", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "payload", "", "cmdName", "needShowKeyboard", "e", "Landroid/net/Uri;", ZPlanPublishSource.FROM_SCHEME, "d", "Ln14/c;", "c", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotParameterCmdSchemeAction extends n14.b<AIOSchemeActionContext> {
    private final boolean e(com.tencent.aio.api.runtime.a ctx, boolean isInGroup, boolean isReply, AIOMsgItem payload, String cmdName, boolean needShowKeyboard) {
        boolean z16;
        ctx.e().h(new InputDialogPriorityMsgIntent.AddProcessBarrier("RobotParameterCmdMatcher", 0, 2, null));
        if (isReply) {
            j e16 = ctx.e();
            Intrinsics.checkNotNull(payload);
            e16.h(new AIOMsgSendEvent.MsgOnClickReplyEvent(payload, 0, needShowKeyboard));
        } else if (isInGroup) {
            if (payload != null) {
                MsgRecord msgRecord = payload.getMsgRecord();
                j e17 = ctx.e();
                String str = msgRecord.senderUid;
                Intrinsics.checkNotNullExpressionValue(str, "msgRecord.senderUid");
                e17.h(new InputAtMsgIntent.InsertAtMemberSpan(str, String.valueOf(msgRecord.senderUin), u64.c.a(msgRecord), needShowKeyboard));
            } else {
                z16 = false;
                ctx.e().h(new InputEditTextMsgIntent.AppendTextToEditText(cmdName + " ", needShowKeyboard));
                ctx.e().h(new InputDialogPriorityMsgIntent.RemoveProcessBarrier("RobotParameterCmdMatcher", 0, 2, null));
                return z16;
            }
        }
        z16 = true;
        ctx.e().h(new InputEditTextMsgIntent.AppendTextToEditText(cmdName + " ", needShowKeyboard));
        ctx.e().h(new InputDialogPriorityMsgIntent.RemoveProcessBarrier("RobotParameterCmdMatcher", 0, 2, null));
        return z16;
    }

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
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        String queryParameter = scheme.getQueryParameter("command");
        if (queryParameter == null) {
            queryParameter = "";
        }
        String str = queryParameter;
        if (ctx.getMsgItemRef() != null && scheme.getBooleanQueryParameter("reply", false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (ctx.getAioContext().g().r().c().e() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (Intrinsics.areEqual(scheme.getQueryParameter("anchor"), "1") && !z17) {
            z18 = true;
        } else {
            z18 = false;
        }
        boolean e16 = e(ctx.getAioContext(), z17, z16, ctx.getMsgItemRef(), str, !z18);
        if (z18) {
            RobotCommandActionUtils.f365910a.a("RobotParameterCmdMatcher", ctx.getAioContext(), new Function2<Boolean, String, Unit>() { // from class: com.tencent.robot.action.api.impl.RobotParameterCmdSchemeAction$doAction$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                    invoke(bool.booleanValue(), str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z19, @NotNull String errorMsg) {
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    if (z19) {
                        return;
                    }
                    QLog.e("RobotParameterCmdMatcher", 1, "[checkPermissionAndInvokePhotoPanel]: " + errorMsg);
                }
            });
        }
        return e16;
    }
}
