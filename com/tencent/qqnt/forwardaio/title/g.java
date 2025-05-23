package com.tencent.qqnt.forwardaio.title;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.forwardaio.ForwardAIOEvent;
import com.tencent.qqnt.forwardaio.title.ForwardAIOTitleUIState;
import com.tencent.qqnt.forwardaio.title.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/forwardaio/title/g;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/qqnt/forwardaio/title/d;", "Lcom/tencent/qqnt/forwardaio/title/ForwardAIOTitleUIState;", "intent", "", "l", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g extends com.tencent.qqnt.aio.baseVM.a<d, ForwardAIOTitleUIState> {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull d intent) {
        FragmentActivity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean z16 = true;
        boolean z17 = false;
        if (intent instanceof d.c) {
            AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
            updateUI(new ForwardAIOTitleUIState.UpdateTitle(c16.g()));
            if (c16.e() != 2) {
                z16 = false;
            }
            if (!((com.tencent.aio.api.runtime.a) getMContext()).g().l().getBoolean("key_forward_aio_show_custom_msg")) {
                z17 = z16;
            }
            updateUI(new ForwardAIOTitleUIState.UpdateMemBtn(z17));
            return;
        }
        if (intent instanceof d.C9624d) {
            com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            Bundle bundle = new Bundle();
            bundle.putInt("BG_ID", R.drawable.qui_common_bg_bottom_standard_bg_corner_6);
            Unit unit = Unit.INSTANCE;
            e16.h(new ExternalCommIntent("EVENT_UPDATE_BG", bundle));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new ForwardAIOEvent.UpdateMemView(true));
            return;
        }
        if (intent instanceof d.b) {
            com.tencent.mvi.base.route.j e17 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("BG_ID", R.drawable.skin_mni_aio_bg_2);
            Unit unit2 = Unit.INSTANCE;
            e17.h(new ExternalCommIntent("EVENT_UPDATE_BG", bundle2));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new ForwardAIOEvent.UpdateMemView(false));
            return;
        }
        if ((intent instanceof d.a) && (activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity()) != null) {
            activity.finish();
        }
    }
}
