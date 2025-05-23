package com.tencent.qqnt.miniaio.title;

import android.os.Bundle;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.miniaio.title.MiniAIOTitleUIState;
import com.tencent.qqnt.miniaio.title.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/miniaio/title/d;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/qqnt/miniaio/title/a;", "Lcom/tencent/qqnt/miniaio/title/MiniAIOTitleUIState;", "", "l", DomainData.DOMAIN_NAME, "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d extends com.tencent.qqnt.aio.baseVM.a<a, MiniAIOTitleUIState> {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        updateUI(new MiniAIOTitleUIState.Update(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().g()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        Bundle bundle = new Bundle();
        AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
        bundle.putInt("key_chat_type", c16.e());
        bundle.putString("key_peerId", c16.j());
        bundle.putString("key_chat_name", c16.g());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new ExternalCommIntent("jump_to_normal_aio", bundle));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            l();
        } else if (intent instanceof a.C9652a) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new ExternalCommIntent("close_aio", new Bundle()));
        } else if (intent instanceof a.c) {
            n();
        }
    }
}
