package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoPanelApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoPanelApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/aio/api/e;", "getPanelProvider", "", "emoticon", "Lcom/tencent/mobileqq/data/Emoticon;", "convertToNtEmoticon", "markFaceMessage", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "convertToNtMarkFaceMessage", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "source", "", "emoType", "", "openAIOEmoPanel", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOEmoPanelApiNtImpl implements IAIOEmoPanelApi {
    static IPatchRedirector $redirector_;

    public AIOEmoPanelApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi
    @Nullable
    public Emoticon convertToNtEmoticon(@Nullable Object emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Emoticon) iPatchRedirector.redirect((short) 3, (Object) this, emoticon);
        }
        if (emoticon instanceof Emoticon) {
            return (Emoticon) emoticon;
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi
    @Nullable
    public MarkFaceMessage convertToNtMarkFaceMessage(@Nullable Object markFaceMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MarkFaceMessage) iPatchRedirector.redirect((short) 4, (Object) this, markFaceMessage);
        }
        if (markFaceMessage instanceof MarkFaceMessage) {
            return (MarkFaceMessage) markFaceMessage;
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi
    @NotNull
    public com.tencent.qqnt.aio.api.e getPanelProvider(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.aio.api.e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new com.tencent.mobileqq.aio.panel.emoticon.a(context);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi
    public void openAIOEmoPanel(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String source, int emoType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, aioContext, source, Integer.valueOf(emoType));
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(source, "source");
        com.tencent.mvi.base.route.j e16 = aioContext.e();
        if (e16 != null) {
            e16.h(new PanelContainerMsgIntent.ShowPanelMsgIntent(source, 1001, false, 0, 12, null));
        }
    }
}
