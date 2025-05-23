package com.tencent.input.base.panelcontainer.keyboard;

import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/input/base/panelcontainer/keyboard/KeyboardHeightStrategyLoader;", "", "Lcom/tencent/input/base/panelcontainer/keyboard/b;", "listener", "", "d", "e", "Lcom/tencent/mvi/api/runtime/b;", "a", "Lcom/tencent/mvi/api/runtime/b;", "mContext", "Lcom/tencent/input/base/panelcontainer/keyboard/g;", "b", "Lcom/tencent/input/base/panelcontainer/keyboard/g;", "mStrategyLoadData", "Lcom/tencent/input/base/panelcontainer/keyboard/c;", "c", "Lkotlin/Lazy;", "()Lcom/tencent/input/base/panelcontainer/keyboard/c;", "mStrategy", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/input/base/panelcontainer/keyboard/g;)V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class KeyboardHeightStrategyLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.api.runtime.b mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mStrategyLoadData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mStrategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/input/base/panelcontainer/keyboard/KeyboardHeightStrategyLoader$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.input.base.panelcontainer.keyboard.KeyboardHeightStrategyLoader$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33432);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public KeyboardHeightStrategyLoader(@NotNull com.tencent.mvi.api.runtime.b mContext, @NotNull g mStrategyLoadData) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mStrategyLoadData, "mStrategyLoadData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext, (Object) mStrategyLoadData);
            return;
        }
        this.mContext = mContext;
        this.mStrategyLoadData = mStrategyLoadData;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AdjustCommonStrategy>() { // from class: com.tencent.input.base.panelcontainer.keyboard.KeyboardHeightStrategyLoader$mStrategy$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KeyboardHeightStrategyLoader.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AdjustCommonStrategy invoke() {
                com.tencent.mvi.api.runtime.b bVar;
                g gVar;
                com.tencent.mvi.api.runtime.b bVar2;
                g gVar2;
                g gVar3;
                Window window;
                WindowManager.LayoutParams attributes;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AdjustCommonStrategy) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bVar = KeyboardHeightStrategyLoader.this.mContext;
                FragmentActivity activity = bVar.c().getActivity();
                int i3 = 0;
                if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                    i3 = attributes.softInputMode;
                }
                if ((i3 & 240) != 16) {
                    gVar3 = KeyboardHeightStrategyLoader.this.mStrategyLoadData;
                    com.tencent.mvi.log.b a16 = gVar3.a();
                    if (a16 != null) {
                        a16.e("KeyboardHeightStrategyLoader", "windowMode = " + i3 + " error!");
                    }
                } else {
                    gVar = KeyboardHeightStrategyLoader.this.mStrategyLoadData;
                    com.tencent.mvi.log.b a17 = gVar.a();
                    if (a17 != null) {
                        a17.i("KeyboardHeightStrategyLoader", "windowMode = " + i3 + " success.");
                    }
                }
                bVar2 = KeyboardHeightStrategyLoader.this.mContext;
                gVar2 = KeyboardHeightStrategyLoader.this.mStrategyLoadData;
                return new AdjustCommonStrategy(bVar2, gVar2);
            }
        });
        this.mStrategy = lazy;
    }

    private final c c() {
        return (c) this.mStrategy.getValue();
    }

    public final void d(@NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            c().b(listener);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            c().a();
        }
    }
}
