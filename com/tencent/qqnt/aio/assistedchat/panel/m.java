package com.tencent.qqnt.aio.assistedchat.panel;

import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelVB;
import com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelVB;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/m;", "", "", "subPanelId", "Lcom/tencent/aio/base/mvvm/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "a", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f349196a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58987);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f349196a = new m();
        }
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.aio.base.mvvm.a<? extends at.c, ? extends PanelUIState> a(int subPanelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this, subPanelId);
        }
        if (subPanelId != 1) {
            if (subPanelId != 2) {
                if (subPanelId == 3) {
                    return new com.tencent.mobileqq.aio.panel.richtext.b();
                }
                throw new IllegalArgumentException("subPanelId " + subPanelId + " is illegal");
            }
            return new AssistedChatPolishPanelVB();
        }
        return new AssistedChatTopicPanelVB();
    }
}
