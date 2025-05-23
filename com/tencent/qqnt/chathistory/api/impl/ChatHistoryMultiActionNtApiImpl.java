package com.tencent.qqnt.chathistory.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.api.IChatHistoryMultiActionApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/impl/ChatHistoryMultiActionNtApiImpl;", "Lcom/tencent/qqnt/chathistory/api/IChatHistoryMultiActionApi;", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class ChatHistoryMultiActionNtApiImpl implements IChatHistoryMultiActionApi {
    static IPatchRedirector $redirector_;

    public ChatHistoryMultiActionNtApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryMultiActionApi
    public void deleteChatFile(@NotNull Contact contact, @NotNull List<MsgRecord> list, @NotNull Function2<? super Integer, ? super String, Unit> function2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, contact, list, function2);
        } else {
            IChatHistoryMultiActionApi.a.a(this, contact, list, function2);
        }
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryMultiActionApi
    public void saveMedia(@NotNull Activity activity, @NotNull List<MsgRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) list);
        } else {
            IChatHistoryMultiActionApi.a.b(this, activity, list);
        }
    }
}
