package com.tencent.mobileqq.aio.input.panel.adapter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "CheckInputSoftModeUIState", "Lcom/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterUIState$CheckInputSoftModeUIState;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public abstract class PanelContainerAdapterUIState implements MviUIState {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterUIState$CheckInputSoftModeUIState;", "Lcom/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class CheckInputSoftModeUIState extends PanelContainerAdapterUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final CheckInputSoftModeUIState f189777d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56428);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189777d = new CheckInputSoftModeUIState();
            }
        }

        CheckInputSoftModeUIState() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ PanelContainerAdapterUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    PanelContainerAdapterUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
