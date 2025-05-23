package com.tencent.mobileqq.textpreview;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.textpreview.inject.f;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/textpreview/TextPlayStateManager;", "", "Lcom/tencent/qqnt/textpreview/inject/f;", "ttsAbility", "", "c", "Ljava/lang/ref/WeakReference;", "a", "Ljava/lang/ref/WeakReference;", "playingTtsAbilityRef", "<init>", "()V", "b", "text_preview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TextPlayStateManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String f292741c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<TextPlayStateManager> f292742d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<f> playingTtsAbilityRef;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/textpreview/TextPlayStateManager$a;", "", "Lcom/tencent/mobileqq/textpreview/TextPlayStateManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/textpreview/TextPlayStateManager;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "text_preview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.textpreview.TextPlayStateManager$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

        @NotNull
        public final TextPlayStateManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TextPlayStateManager) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (TextPlayStateManager) TextPlayStateManager.f292742d.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<TextPlayStateManager> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30197);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        f292741c = "TextPlayStateManager";
        lazy = LazyKt__LazyJVMKt.lazy(TextPlayStateManager$Companion$instance$2.INSTANCE);
        f292742d = lazy;
    }

    public TextPlayStateManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public static final TextPlayStateManager b() {
        return INSTANCE.a();
    }

    public final void c(@NotNull f ttsAbility) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ttsAbility);
            return;
        }
        Intrinsics.checkNotNullParameter(ttsAbility, "ttsAbility");
        WeakReference<f> weakReference = this.playingTtsAbilityRef;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            if (Intrinsics.areEqual(ttsAbility, fVar)) {
                return;
            }
            if (fVar.isWorking()) {
                fVar.stop();
            }
        }
        this.playingTtsAbilityRef = new WeakReference<>(ttsAbility);
    }
}
