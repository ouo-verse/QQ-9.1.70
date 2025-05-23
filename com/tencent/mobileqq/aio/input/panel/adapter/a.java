package com.tencent.mobileqq.aio.input.panel.adapter;

import com.tencent.aio.api.factory.i;
import com.tencent.input.base.panelcontainer.c;
import com.tencent.mobileqq.aio.panel.photo.PhotoPanelVB;
import com.tencent.mobileqq.aio.panel.richtext.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.qqnt.aio.api.IPttPanelApi;
import com.tencent.qqnt.aio.api.IQWalletPanelApi;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.qqnt.pluspanel.api.IPlusPanelApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\t\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\b0\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/input/panel/adapter/a;", "Lcom/tencent/input/base/panelcontainer/c;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/factory/i;", "", "panelId", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "b", "Lcom/tencent/aio/base/mvvm/a;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements c<com.tencent.aio.api.runtime.a>, i {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.factory.i
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a(int panelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 3, (Object) this, panelId);
        }
        switch (panelId) {
            case 1000:
                try {
                    return ((IPttPanelApi) QRoute.api(IPttPanelApi.class)).getPanelVB();
                } catch (Exception unused) {
                    return new com.tencent.mobileqq.aio.panel.ptt.b();
                }
            case 1001:
                return new com.tencent.mobileqq.aio.panel.emoticon.c();
            case 1002:
            case 1005:
            case 1011:
            case 1012:
            case 1013:
            default:
                return new com.tencent.mobileqq.aio.panel.b();
            case 1003:
                return new PhotoPanelVB();
            case 1004:
                return ((IQWalletPanelApi) QRoute.api(IQWalletPanelApi.class)).getPanelVB();
            case 1006:
                return ((IPlusPanelApi) QRoute.api(IPlusPanelApi.class)).getPanelVB(1006);
            case 1007:
                return new d();
            case 1008:
                return new com.tencent.mobileqq.aio.panel.debug.a();
            case 1009:
                return ((IPlusPanelApi) QRoute.api(IPlusPanelApi.class)).getPanelVB(1009);
            case 1010:
                return ((IPlusPanelApi) QRoute.api(IPlusPanelApi.class)).getPanelVB(1010);
            case 1014:
                return ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).getAssistedChatPanelVB();
        }
    }

    @Override // com.tencent.input.base.panelcontainer.c
    @NotNull
    public BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a> b(int panelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVB) iPatchRedirector.redirect((short) 2, (Object) this, panelId);
        }
        return a(panelId);
    }
}
