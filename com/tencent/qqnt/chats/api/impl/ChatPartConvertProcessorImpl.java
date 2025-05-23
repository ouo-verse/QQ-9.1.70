package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.IChatPartConvertProcessor;
import com.tencent.qqnt.chats.data.processor.part.SummaryConvertProcessor;
import com.tencent.qqnt.chats.data.processor.part.TitleConvertProcessor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004H\u0016\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004H\u0016\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u0007\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004H\u0016\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004H\u0016\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatPartConvertProcessorImpl;", "Lcom/tencent/qqnt/chats/api/IChatPartConvertProcessor;", "()V", "createSummaryConvertProcessor", "T", "()Ljava/lang/Object;", "createTimeConvertProcessor", "createTitleConvertProcessor", "createUnreadConvertProcessor", "chats_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class ChatPartConvertProcessorImpl implements IChatPartConvertProcessor {
    static IPatchRedirector $redirector_;

    public ChatPartConvertProcessorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatPartConvertProcessor
    public <T> T createSummaryConvertProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (T) new SummaryConvertProcessor(false, 1, null);
    }

    @Override // com.tencent.qqnt.chats.api.IChatPartConvertProcessor
    public <T> T createTimeConvertProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (T) new com.tencent.qqnt.chats.data.processor.part.d();
    }

    @Override // com.tencent.qqnt.chats.api.IChatPartConvertProcessor
    public <T> T createTitleConvertProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (T) new TitleConvertProcessor();
    }

    @Override // com.tencent.qqnt.chats.api.IChatPartConvertProcessor
    public <T> T createUnreadConvertProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (T) new com.tencent.qqnt.chats.data.processor.part.e();
    }
}
