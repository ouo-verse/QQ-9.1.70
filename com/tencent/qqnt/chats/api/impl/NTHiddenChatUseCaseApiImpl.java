package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.INTHiddenChatUseCaseApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/NTHiddenChatUseCaseApiImpl;", "Lcom/tencent/qqnt/chats/api/INTHiddenChatUseCaseApi;", "()V", "TAG", "", "delHiddenChat", "", "peerUin", "chatType", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class NTHiddenChatUseCaseApiImpl implements INTHiddenChatUseCaseApi {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    public NTHiddenChatUseCaseApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "NTHiddenChatUseCaseApiImpl";
        }
    }

    @Override // com.tencent.qqnt.chats.api.INTHiddenChatUseCaseApi
    public void delHiddenChat(@NotNull String peerUin, int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) peerUin, chatType);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (chatType != 1) {
            if (chatType == 2) {
                QLog.d(this.TAG, 1, "Troop cancel Hidden");
                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).setGroupMsgMaskV2_4(peerUin, qQAppInterface.getCurrentUid(), 0, 512, (int) NetConnInfoCenter.getServerTime(), null, null);
                return;
            }
            return;
        }
        QLog.d(this.TAG, 1, "Friend cancel Hidden");
        BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendListHandler");
        ((FriendListHandler) businessHandler).setHiddenChat(new String[]{peerUin}, new boolean[]{false}, new int[]{0});
    }
}
