package com.tencent.mobileqq.panel;

import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(com.tencent.aio.api.runtime.a aVar) {
        h.b bVar;
        if (aVar == null || (bVar = (h.b) aVar.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d)) == null) {
            return 750;
        }
        return bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int b(com.tencent.aio.api.runtime.a aVar) {
        h.b bVar;
        if (aVar == null || (bVar = (h.b) aVar.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d)) == null) {
            return 750;
        }
        return bVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c(com.tencent.aio.api.runtime.a aVar, int i3) {
        if (aVar == null) {
            return;
        }
        aVar.e().h(new PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent("RichTextPanel", i3, true));
    }
}
