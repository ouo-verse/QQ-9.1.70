package com.tencent.qqnt.aio.assistedchat.polish.mvi;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/mvi/WriteWhilePolishingUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "<init>", "()V", "ClearLastShowInfo", "StopLoadingAnimation", "Lcom/tencent/qqnt/aio/assistedchat/polish/mvi/WriteWhilePolishingUIState$ClearLastShowInfo;", "Lcom/tencent/qqnt/aio/assistedchat/polish/mvi/WriteWhilePolishingUIState$StopLoadingAnimation;", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class WriteWhilePolishingUIState implements MviUIState {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/mvi/WriteWhilePolishingUIState$ClearLastShowInfo;", "Lcom/tencent/qqnt/aio/assistedchat/polish/mvi/WriteWhilePolishingUIState;", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class ClearLastShowInfo extends WriteWhilePolishingUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ClearLastShowInfo f349400d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59992);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f349400d = new ClearLastShowInfo();
            }
        }

        ClearLastShowInfo() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/mvi/WriteWhilePolishingUIState$StopLoadingAnimation;", "Lcom/tencent/qqnt/aio/assistedchat/polish/mvi/WriteWhilePolishingUIState;", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class StopLoadingAnimation extends WriteWhilePolishingUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final StopLoadingAnimation f349401d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59994);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f349401d = new StopLoadingAnimation();
            }
        }

        StopLoadingAnimation() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ WriteWhilePolishingUIState(DefaultConstructorMarker defaultConstructorMarker) {
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

    WriteWhilePolishingUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
