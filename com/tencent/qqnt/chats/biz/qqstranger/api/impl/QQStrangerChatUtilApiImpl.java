package com.tencent.qqnt.chats.biz.qqstranger.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.biz.qqstranger.api.IQQStrangerChatUtilApi;
import com.tencent.qqnt.chats.biz.qqstranger.e;
import com.tencent.qqnt.chats.core.uievent.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/biz/qqstranger/api/impl/QQStrangerChatUtilApiImpl;", "Lcom/tencent/qqnt/chats/biz/qqstranger/api/IQQStrangerChatUtilApi;", "Lcom/tencent/qqnt/chats/core/uievent/b;", "event", "", "sendEventToChat", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class QQStrangerChatUtilApiImpl implements IQQStrangerChatUtilApi {
    static IPatchRedirector $redirector_;

    public QQStrangerChatUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.qqstranger.api.IQQStrangerChatUtilApi
    public boolean sendEventToChat(@NotNull b event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        return e.f354390a.b(event);
    }
}
