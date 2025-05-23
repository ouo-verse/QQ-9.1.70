package com.tencent.aio.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.aio.api.frame.IAIOFramesProvider;
import com.tencent.aio.widget.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00030\nH\u0016J \u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/aio/widget/a;", "Lcom/tencent/aio/api/frame/IAIOFramesProvider;", "Landroid/widget/FrameLayout;", "Lcom/tencent/aio/widget/b;", "Landroid/content/Context;", "context", "k", "containerView", "", "j", "Lkotlin/Pair;", "Ljava/lang/Class;", "d", "Landroid/view/View;", "chatFrame", "Lcom/tencent/aio/api/frame/a;", "framesConfig", "l", "<init>", "()V", "f", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a extends IAIOFramesProvider<FrameLayout, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/widget/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.widget.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53606);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.frame.IAIOFramesProvider
    @NotNull
    public Pair<Class<b>, b> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TuplesKt.to(b.class, b.a.f69964e);
    }

    @Override // com.tencent.aio.api.frame.IAIOFramesProvider
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull FrameLayout containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) containerView);
            return;
        }
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        com.tencent.aio.base.log.a.f69187b.d("AIODefaultFrameProvider", "onClearAllFrame containerView " + containerView + " children " + containerView.getChildCount());
    }

    @Override // com.tencent.aio.api.frame.IAIOFramesProvider
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public FrameLayout g(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new FrameLayout(context);
    }

    @Override // com.tencent.aio.api.frame.IAIOFramesProvider
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull FrameLayout containerView, @NotNull View chatFrame, @NotNull com.tencent.aio.api.frame.a framesConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, containerView, chatFrame, framesConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(chatFrame, "chatFrame");
        Intrinsics.checkNotNullParameter(framesConfig, "framesConfig");
        com.tencent.aio.base.log.a.f69187b.d("AIODefaultFrameProvider", "onFramesAdd containerView children " + containerView.getChildCount() + "  chatFrame Parent " + chatFrame.getParent());
        containerView.addView(chatFrame);
    }
}
