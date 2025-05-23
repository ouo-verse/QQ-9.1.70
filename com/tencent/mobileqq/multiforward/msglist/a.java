package com.tencent.mobileqq.multiforward.msglist;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.aio.utils.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/multiforward/msglist/a;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "f", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        }
    }

    private final CharSequence f(AIOMsgItem msgItem) {
        boolean z16;
        boolean z17;
        MsgRecord msgRecord = msgItem.getMsgRecord();
        boolean z18 = true;
        if (msgItem.U().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return msgItem.U();
        }
        String str = msgRecord.sendRemarkName;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.sendRemarkName");
        if (str.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            String str2 = msgRecord.sendRemarkName;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n            msgRecord.sendRemarkName\n        }");
            return str2;
        }
        String str3 = msgRecord.sendNickName;
        Intrinsics.checkNotNullExpressionValue(str3, "msgRecord.sendNickName");
        if (str3.length() <= 0) {
            z18 = false;
        }
        if (z18) {
            String str4 = msgRecord.sendNickName;
            Intrinsics.checkNotNullExpressionValue(str4, "{\n            msgRecord.sendNickName\n        }");
            return str4;
        }
        long j3 = msgRecord.senderUin;
        if (j3 == 0) {
            return "";
        }
        return String.valueOf(j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        MsgRecordParams msgRecordParams = (MsgRecordParams) b().g().l().getParcelable("key_multiforward_root_msg_record");
        MsgRecordParams msgRecordParams2 = (MsgRecordParams) b().g().l().getParcelable("key_multiforward_parent_msg_record");
        for (com.tencent.aio.data.msglist.a aVar : displayList) {
            if (aVar instanceof AIOMsgItem) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                aIOMsgItem.O1(msgRecordParams);
                aIOMsgItem.J1(msgRecordParams2);
                aIOMsgItem.Y1(n.f194168a.f(b().c().getContext(), aIOMsgItem));
                aIOMsgItem.X0();
                aIOMsgItem.W1(f(aIOMsgItem));
            }
        }
        return displayList;
    }
}
