package com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.aio.api.IAIOEmoApi;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/action/c;", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/action/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", "actionItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c implements a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QQStrangerLIAItem actionItem, Contact contact) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(actionItem, "$actionItem");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        QRouteApi api = QRoute.api(IAIOEmoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAIOEmoApi::class.java)");
        IAIOEmoApi.a.c((IAIOEmoApi) api, actionItem.getResource().getEmojiId(), contact, true, null, 8, null);
        isBlank = StringsKt__StringsJVMKt.isBlank(actionItem.getResource().getTextMsg().toString());
        if (!isBlank) {
            IMsgSendHelper iMsgSendHelper = (IMsgSendHelper) QRoute.api(IMsgSendHelper.class);
            String str = contact.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
            iMsgSendHelper.syncSendText(str, contact.chatType, actionItem.getResource().getTextMsg().toString());
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action.a
    public void a(final QQStrangerLIAItem actionItem, final Contact contact) {
        Intrinsics.checkNotNullParameter(actionItem, "actionItem");
        Intrinsics.checkNotNullParameter(contact, "contact");
        QQStrangerLIAHelper.p(QQStrangerLIAHelper.f245114a, actionItem, 0, 2, null);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action.b
            @Override // java.lang.Runnable
            public final void run() {
                c.c(QQStrangerLIAItem.this, contact);
            }
        }, 16, null, true);
    }
}
