package com.tencent.mobileqq.aio.msglist.holder.component.msgaction;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackDataForMsg;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgaction/e;", "Ld81/a;", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "buttonInfo", "", "b", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e implements d81.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgaction/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgaction.e$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/msgaction/e$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "", "result", "", "errMsg", "", "onResult", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements IOperateCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int result, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, result, (Object) errMsg);
                return;
            }
            QLog.i("DefaultMsgRecommendClickProcessor", 1, "[feedBackReportForMsg]: result is " + result + ", errMsg is " + errMsg);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61943);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(com.tencent.aio.api.runtime.a context, AIOMsgItem msgItem, InlineKeyboardButton buttonInfo) {
        AIOContact c16 = context.g().r().c();
        Contact contact = new Contact(c16.e(), c16.j(), "");
        MsgRecord msgRecord = msgItem.getMsgRecord();
        FeedBackMsgInfo feedBackMsgInfo = new FeedBackMsgInfo(msgRecord.msgId, msgRecord.msgRandom, msgRecord.msgSeq, msgRecord.clientSeq);
        FeedBackDataForMsg feedBackDataForMsg = new FeedBackDataForMsg(5, true, buttonInfo.data);
        if (QLog.isDevelopLevel()) {
            QLog.i("DefaultMsgRecommendClickProcessor", 1, "[reportEventToDeveloper]\uff1acontact is " + contact + ", feedbackMsgInfo is " + feedBackMsgInfo + ", feedbackData is " + feedBackDataForMsg);
        }
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.feedBackReportForMsg(contact, feedBackMsgInfo, feedBackDataForMsg, new b());
        }
    }

    @Override // d81.a
    public boolean a(@NotNull com.tencent.aio.api.runtime.a context, @Nullable AIOMsgItem msgItem, @NotNull InlineKeyboardButton buttonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, context, msgItem, buttonInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buttonInfo, "buttonInfo");
        j e16 = context.e();
        String str = buttonInfo.label;
        Intrinsics.checkNotNullExpressionValue(str, "buttonInfo.label");
        e16.h(new AIOMsgSendEvent.TextSendEvent(str));
        if (msgItem != null) {
            b(context, msgItem, buttonInfo);
            return true;
        }
        return true;
    }
}
