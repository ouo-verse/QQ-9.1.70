package com.tencent.aio.runtime.provider;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aio.base.chat.ChatPieManager;
import com.tencent.aio.main.fragment.ChatFragment;
import com.tencent.aio.runtime.message.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import ts.e;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010(\u001a\u00020&\u0012\u0006\u0010+\u001a\u00020)\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u000f\u0010\u001f\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u001f\u0010 R\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/aio/runtime/provider/ChatFragmentProvider;", "Lus/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "a", "", "actionCode", "Lcom/tencent/aio/runtime/message/b;", "action", "i", "l", "", "onBackPressed", "Landroidx/fragment/app/Fragment;", h.F, "Lts/e;", "g", "Landroidx/fragment/app/FragmentManager;", "fm", "j", "f", "Landroid/graphics/drawable/Drawable;", "drawable", "k", "clearAIOCache", "fitSystemWindows", "d", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "e", "c", "()V", "Lcom/tencent/aio/runtime/provider/a;", "Lkotlin/Lazy;", "b", "()Lcom/tencent/aio/runtime/provider/a;", "attachProvider", "Lcom/tencent/aio/base/chat/ChatPieManager;", "Lcom/tencent/aio/base/chat/ChatPieManager;", "chatPieManager", "Lcom/tencent/aio/main/fragment/ChatFragment;", "Lcom/tencent/aio/main/fragment/ChatFragment;", "fragment", "<init>", "(Lcom/tencent/aio/base/chat/ChatPieManager;Lcom/tencent/aio/main/fragment/ChatFragment;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ChatFragmentProvider implements us.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy attachProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ChatPieManager chatPieManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ChatFragment fragment;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/runtime/provider/ChatFragmentProvider$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.runtime.provider.ChatFragmentProvider$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatFragmentProvider(@NotNull ChatPieManager chatPieManager, @NotNull ChatFragment fragment) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(chatPieManager, "chatPieManager");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) chatPieManager, (Object) fragment);
            return;
        }
        this.chatPieManager = chatPieManager;
        this.fragment = fragment;
        lazy = LazyKt__LazyJVMKt.lazy(ChatFragmentProvider$attachProvider$2.INSTANCE);
        this.attachProvider = lazy;
    }

    private final a b() {
        return (a) this.attachProvider.getValue();
    }

    @Override // us.a
    public void a(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            this.chatPieManager.u(msgIntent);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            b().c();
        }
    }

    @Override // us.a
    public void clearAIOCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            com.tencent.aio.base.log.a.f69187b.d("ChatFragmentProvider", "clearAIOCache");
            this.chatPieManager.a();
        }
    }

    @Override // us.a
    public void d(boolean fitSystemWindows) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, fitSystemWindows);
        } else {
            this.chatPieManager.v(fitSystemWindows);
        }
    }

    @Override // us.a
    public void e(@NotNull Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) rect);
            return;
        }
        Intrinsics.checkNotNullParameter(rect, "rect");
        com.tencent.aio.base.log.a.f69187b.d("ChatFragmentProvider", "resetFitsSystemWindow " + rect);
        this.chatPieManager.t(rect);
    }

    @Override // us.a
    public void f(@NotNull FragmentManager fm5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) fm5);
            return;
        }
        Intrinsics.checkNotNullParameter(fm5, "fm");
        FragmentTransaction beginTransaction = fm5.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
        beginTransaction.remove(this.fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // us.a
    @NotNull
    public e g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (e) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return b();
    }

    @Override // us.a
    @NotNull
    public Fragment h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Fragment) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.fragment;
    }

    @Override // us.a
    public void i(@NotNull String actionCode, @NotNull b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        this.chatPieManager.s(actionCode, action);
    }

    @Override // us.a
    public void j(@NotNull FragmentManager fm5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) fm5);
            return;
        }
        Intrinsics.checkNotNullParameter(fm5, "fm");
        FragmentTransaction beginTransaction = fm5.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
        beginTransaction.hide(this.fragment);
        beginTransaction.commitNowAllowingStateLoss();
    }

    @Override // us.a
    public void k(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable);
        } else {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.fragment.setBackground$sdk_debug(drawable);
        }
    }

    @Override // us.a
    public void l(@NotNull String actionCode, @NotNull b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        this.chatPieManager.w(actionCode, action);
    }

    @Override // us.a
    public boolean onBackPressed() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Object frameProvider$sdk_debug = this.fragment.getFrameProvider$sdk_debug();
        if (!(frameProvider$sdk_debug instanceof com.tencent.aio.api.runtime.emitter.a)) {
            frameProvider$sdk_debug = null;
        }
        com.tencent.aio.api.runtime.emitter.a aVar = (com.tencent.aio.api.runtime.emitter.a) frameProvider$sdk_debug;
        if (aVar != null) {
            z16 = aVar.onBackEvent();
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return this.chatPieManager.h();
    }
}
