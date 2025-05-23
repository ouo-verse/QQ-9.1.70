package com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher;

import android.annotation.SuppressLint;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \b*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0001\u0010B\u001b\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%\u00a2\u0006\u0004\b(\u0010)J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0016J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0015J=\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0001H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00128\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R2\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030\u00198\u0004X\u0085\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR*\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/InlineBtnClickDispatcher;", "DispatchContext", "Payload", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "", "actionType", "handler", "", "e", "c", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "a", "(Ljava/lang/Object;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Ljava/lang/Object;)V", "", "J", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "lastClickTime", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "handlers", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "d", "()Lkotlin/jvm/functions/Function0;", "f", "(Lkotlin/jvm/functions/Function0;)V", "permissionDeniedCallback", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/a;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/a;", "permissionChecker", "<init>", "(Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/a;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public class InlineBtnClickDispatcher<DispatchContext, Payload> implements b<DispatchContext, Payload> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({})
    private long lastClickTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({})
    @NotNull
    private final Map<Integer, b<DispatchContext, Payload>> handlers;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> permissionDeniedCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final a<DispatchContext, Payload> permissionChecker;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/InlineBtnClickDispatcher$a;", "", "", "CLICK_GAP_MILLIS", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.InlineBtnClickDispatcher$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17052);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InlineBtnClickDispatcher(@NotNull a<DispatchContext, Payload> permissionChecker) {
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionChecker");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) permissionChecker);
        } else {
            this.permissionChecker = permissionChecker;
            this.handlers = new LinkedHashMap();
        }
    }

    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
    public void a(final DispatchContext ctx, @NotNull final InlineBtnView<DispatchContext, Payload> btnView, @NotNull final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable final Payload payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, ctx, btnView, btnModel, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime < 100) {
            com.tencent.android.androidbypass.config.a.f72049a.d("InlineBtnClickDispatcher", "[onClick] filter fast click");
        } else {
            this.lastClickTime = currentTimeMillis;
            this.permissionChecker.a(ctx, btnModel, btnModel.a().b(), payload, new Function0<Unit>(btnModel, ctx, btnView, payload) { // from class: com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.InlineBtnClickDispatcher$performClick$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a $btnModel;
                final /* synthetic */ InlineBtnView $btnView;
                final /* synthetic */ Object $ctx;
                final /* synthetic */ Object $payload;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$btnModel = btnModel;
                    this.$ctx = ctx;
                    this.$btnView = btnView;
                    this.$payload = payload;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, InlineBtnClickDispatcher.this, btnModel, ctx, btnView, payload);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    b c16 = InlineBtnClickDispatcher.this.c(this.$btnModel.a().c());
                    if (c16 != null) {
                        c16.a(this.$ctx, this.$btnView, this.$btnModel, this.$payload);
                    }
                }
            }, new Function0<Unit>() { // from class: com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.InlineBtnClickDispatcher$performClick$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) InlineBtnClickDispatcher.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    com.tencent.android.androidbypass.config.a.f72049a.e("InlineBtnClickDispatcher", "[onClick]: permission requirement not met");
                    Function0<Unit> d16 = InlineBtnClickDispatcher.this.d();
                    if (d16 != null) {
                        d16.invoke();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Map<Integer, b<DispatchContext, Payload>> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.handlers;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({})
    @Nullable
    public b<DispatchContext, Payload> c(int actionType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, actionType);
        }
        b<DispatchContext, Payload> bVar = this.handlers.get(Integer.valueOf(actionType));
        if (bVar == null) {
            return this.handlers.get(-1);
        }
        return bVar;
    }

    @Nullable
    public final Function0<Unit> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Function0) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.permissionDeniedCallback;
    }

    public void e(int actionType, @NotNull b<DispatchContext, Payload> handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, actionType, (Object) handler);
            return;
        }
        Intrinsics.checkNotNullParameter(handler, "handler");
        Map<Integer, b<DispatchContext, Payload>> map = this.handlers;
        if (!(!map.containsKey(Integer.valueOf(actionType)))) {
            map = null;
        }
        if (map != null) {
            map.put(Integer.valueOf(actionType), handler);
        }
    }

    public final void f(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function0);
        } else {
            this.permissionDeniedCallback = function0;
        }
    }
}
