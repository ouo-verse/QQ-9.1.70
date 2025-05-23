package com.tencent.qqnt.aio.assistedchat.adapter.impl;

import android.view.View;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/adapter/impl/AssistedChatAdapterApiNtImpl;", "Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatAdapterApi;", "", "chatType", "", "isExperiment", "isReplySuggestionExperiment", "", "reportExpExposure", "Landroid/view/View;", "view", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "setDtReportPageInfo", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatAdapterApiNtImpl implements IAssistedChatAdapterApi {
    static IPatchRedirector $redirector_;

    public AssistedChatAdapterApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi
    public boolean isExperiment(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, chatType)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi
    public boolean isReplySuggestionExperiment(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, chatType)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi
    public void reportExpExposure(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, chatType);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi
    public void setDtReportPageInfo(@NotNull View view, @NotNull a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) aioContext);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        }
    }
}
