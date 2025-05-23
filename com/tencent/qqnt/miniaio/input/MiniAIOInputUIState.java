package com.tencent.qqnt.miniaio.input;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/miniaio/input/MiniAIOInputUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "AfterInputEmoji", "ShowKeyboard", "UnselectEmoBtn", "Lcom/tencent/qqnt/miniaio/input/MiniAIOInputUIState$AfterInputEmoji;", "Lcom/tencent/qqnt/miniaio/input/MiniAIOInputUIState$ShowKeyboard;", "Lcom/tencent/qqnt/miniaio/input/MiniAIOInputUIState$UnselectEmoBtn;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public abstract class MiniAIOInputUIState implements InputUIState {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/miniaio/input/MiniAIOInputUIState$AfterInputEmoji;", "Lcom/tencent/qqnt/miniaio/input/MiniAIOInputUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class AfterInputEmoji extends MiniAIOInputUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AfterInputEmoji f359480d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65742);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f359480d = new AfterInputEmoji();
            }
        }

        AfterInputEmoji() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/miniaio/input/MiniAIOInputUIState$ShowKeyboard;", "Lcom/tencent/qqnt/miniaio/input/MiniAIOInputUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class ShowKeyboard extends MiniAIOInputUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowKeyboard f359481d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65743);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f359481d = new ShowKeyboard();
            }
        }

        ShowKeyboard() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/miniaio/input/MiniAIOInputUIState$UnselectEmoBtn;", "Lcom/tencent/qqnt/miniaio/input/MiniAIOInputUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class UnselectEmoBtn extends MiniAIOInputUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final UnselectEmoBtn f359482d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65744);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f359482d = new UnselectEmoBtn();
            }
        }

        UnselectEmoBtn() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ MiniAIOInputUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    MiniAIOInputUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
