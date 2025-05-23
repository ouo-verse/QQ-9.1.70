package com.tencent.qqnt.audio.tts.api.impl;

import android.content.Context;
import com.tencent.mobileqq.inject.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tts.ITtsController;
import com.tencent.mobileqq.tts.data.i;
import com.tencent.qqnt.audio.tts.api.ITtsAbility;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u001c\u0010\u0016\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/audio/tts/api/impl/TtsAbilityImpl;", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility;", "", "init", "stop", "destroy", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility$a;", "listener", "setStateListener", "", "isWorking", "Lcom/tencent/mobileqq/tts/data/i;", "ttsPlayParams", "speak", "Landroid/content/Context;", "context", "gainFocus", "muteAudioFocus", "", "robotUin", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility$b;", "voiceTypeListener", "getRobotTargetTtsId", "Lcom/tencent/mobileqq/tts/ITtsController;", "controller", "Lcom/tencent/mobileqq/tts/ITtsController;", "<init>", "()V", "Companion", "a", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TtsAbilityImpl implements ITtsAbility {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TtsAbilityImpl";

    @NotNull
    private static final Lazy<Boolean> usePskeyInsteadOfSkey$delegate;

    @NotNull
    private ITtsController controller;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/audio/tts/api/impl/TtsAbilityImpl$a;", "", "", "usePskeyInsteadOfSkey$delegate", "Lkotlin/Lazy;", "a", "()Z", "getUsePskeyInsteadOfSkey$annotations", "()V", "usePskeyInsteadOfSkey", "", "TAG", "Ljava/lang/String;", "<init>", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.audio.tts.api.impl.TtsAbilityImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return ((Boolean) TtsAbilityImpl.usePskeyInsteadOfSkey$delegate.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/qqnt/audio/tts/api/impl/TtsAbilityImpl$b", "Lxt2/a;", "", "g", "Lcom/tencent/mobileqq/tts/data/i;", "params", "f", "c", "b", "", "text", "e", "a", "", "retCode", "errorMsg", "onError", h.F, "d", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements xt2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ITtsAbility.a f352568a;

        b(ITtsAbility.a aVar) {
            this.f352568a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // xt2.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                this.f352568a.a();
            }
        }

        @Override // xt2.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                this.f352568a.b();
            }
        }

        @Override // xt2.a
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f352568a.c();
            }
        }

        @Override // xt2.a
        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            } else {
                this.f352568a.d();
            }
        }

        @Override // xt2.a
        public void e(@NotNull String text) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) text);
            } else {
                Intrinsics.checkNotNullParameter(text, "text");
                this.f352568a.e(text);
            }
        }

        @Override // xt2.a
        public void f(@NotNull i params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) params);
            } else {
                Intrinsics.checkNotNullParameter(params, "params");
                this.f352568a.f(params);
            }
        }

        @Override // xt2.a
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f352568a.g();
            }
        }

        @Override // xt2.a
        public void h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            } else {
                this.f352568a.h();
            }
        }

        @Override // xt2.a
        public void onError(int retCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, retCode, (Object) errorMsg);
            } else {
                this.f352568a.onError(retCode, errorMsg);
            }
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36409);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(TtsAbilityImpl$Companion$usePskeyInsteadOfSkey$2.INSTANCE);
        usePskeyInsteadOfSkey$delegate = lazy;
    }

    public TtsAbilityImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(ITtsController.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITtsController::class.java)");
        this.controller = (ITtsController) api;
    }

    public static final boolean getUsePskeyInsteadOfSkey() {
        return INSTANCE.a();
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.controller.destroy();
        }
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void getRobotTargetTtsId(@Nullable String robotUin, @Nullable final ITtsAbility.b voiceTypeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) robotUin, (Object) voiceTypeListener);
            return;
        }
        if (robotUin != null && voiceTypeListener != null) {
            com.tencent.mobileqq.inject.a.f238063a.c(robotUin, new f.a(voiceTypeListener) { // from class: com.tencent.qqnt.audio.tts.api.impl.a
                @Override // com.tencent.mobileqq.inject.f.a
                public final void a(String str) {
                    ((ITtsAbility.b) null).a(str);
                }
            });
        } else if (voiceTypeListener != null) {
            voiceTypeListener.a("");
        }
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            this.controller.init(2);
        }
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public boolean isWorking() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.controller.isWorking();
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void muteAudioFocus(@Nullable Context context, boolean gainFocus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, Boolean.valueOf(gainFocus));
        } else {
            QQAudioUtils.i(context, gainFocus);
        }
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void setStateListener(@NotNull ITtsAbility.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.controller.setTtsListener(new b(listener));
        }
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public boolean speak(@NotNull i ttsPlayParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) ttsPlayParams)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ttsPlayParams, "ttsPlayParams");
        return this.controller.speak(ttsPlayParams);
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.controller.stop();
        }
    }
}
