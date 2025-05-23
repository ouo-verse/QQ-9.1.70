package com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.input.draft.InputDraftMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.GrayTipsIntent;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.b;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.j;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/i;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/aio/data/msglist/a;", "mr", "", "B", "", "res", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, UserInfo.SEX_FEMALE, "D", "Lcom/tencent/qqnt/aio/holder/a;", "intent", "o", "<init>", "()V", "f", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class i extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/i$a;", "", "", "SECONDS_ALLOWED_FOR_EDIT", "I", "UNIT_SECOND", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.i$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60882);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void B(com.tencent.aio.data.msglist.a mr5) {
        List mutableListOf;
        Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) mr5;
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        Contact contact = new Contact(aIOMsgItem.getMsgRecord().chatType, aIOMsgItem.getMsgRecord().peerUid, aIOMsgItem.getMsgRecord().guildId);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(aIOMsgItem.getMsgRecord().msgId));
        Intrinsics.checkNotNull(mutableListOf, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Long> }");
        iMsgService.getRecallMsgsByMsgId(contact, (ArrayList) mutableListOf, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.h
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                i.C(i.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(i this$0, int i3, String str, ArrayList msgList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        this$0.F(i3, str, msgList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D(com.tencent.aio.data.msglist.a mr5) {
        Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.OnDeleteMsg(((AIOMsgItem) mr5).getMsgRecord()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(int res, String errMsg, ArrayList<MsgRecord> msgList) {
        if (res != 0 || msgList.isEmpty()) {
            return;
        }
        MsgRecord msgRecord = msgList.get(0);
        Intrinsics.checkNotNullExpressionValue(msgRecord, "msgList[0]");
        MsgRecord msgRecord2 = msgRecord;
        if (msgRecord2.msgType != 5) {
            return;
        }
        j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        ArrayList<MsgElement> arrayList = msgRecord2.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        e16.h(new InputDraftMsgIntent.RecoverMsgElements(arrayList));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GrayTipsIntent.ReEditMsgSave(msgRecord2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.C7299b) {
            D(((b.C7299b) intent).a());
        } else if (intent instanceof b.a) {
            B(((b.a) intent).a());
        } else if (intent instanceof f.a) {
            ((f.a) intent).b(new com.tencent.mobileqq.aio.msglist.holder.component.graptips.a((com.tencent.aio.api.runtime.a) getMContext()));
        }
    }
}
