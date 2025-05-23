package com.tencent.qqnt.chats.biz.main.part;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bE\u0010FJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0010J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\u0010\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0015H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\u0018\u00105\u001a\u00020\u00052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0015H\u0016J \u00107\u001a\u00020\u00052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u0015H\u0016J\u0010\u0010:\u001a\u00020\u00052\u0006\u00109\u001a\u000208H\u0016R\"\u0010A\u001a\u00020\u00078\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/qqnt/chats/biz/main/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "Lmqq/app/IAccountCallback;", "Lcom/tencent/qqnt/chats/biz/main/part/b;", "frameProxy", "", "U9", "Lcom/tencent/qqnt/chats/biz/main/a;", "binding", "V9", "Landroidx/lifecycle/LifecycleOwner;", "D9", "Landroidx/lifecycle/LifecycleCoroutineScope;", "E9", "Landroidx/lifecycle/ViewModelStoreOwner;", "F9", "Lcom/tencent/qqnt/chats/core/ui/n;", "handler", "z9", "Landroid/content/Context;", "S9", "", "index", "x9", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "app", "A9", "R9", "N9", "T9", "M9", "L9", "Landroid/os/Message;", "msg", "", "handleMessage", "onPostThemeChanged", "J9", "Q9", "I9", "from", "B9", "K9", "C9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "i", "O9", "i1", "P9", "Landroid/content/Intent;", "intent", "H9", "d", "Lcom/tencent/qqnt/chats/biz/main/a;", "G9", "()Lcom/tencent/qqnt/chats/biz/main/a;", "W9", "(Lcom/tencent/qqnt/chats/biz/main/a;)V", "_binding", "e", "Lcom/tencent/qqnt/chats/biz/main/part/b;", "_frameProxy", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a extends Part implements IAccountCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected com.tencent.qqnt.chats.biz.main.a _binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private b _frameProxy;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void A9(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) app);
        } else {
            Intrinsics.checkNotNullParameter(app, "app");
        }
    }

    public void B9(int from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, from);
        }
    }

    public void C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        }
    }

    @NotNull
    public final LifecycleOwner D9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        b bVar = this._frameProxy;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_frameProxy");
            bVar = null;
        }
        return bVar.getLifecycleOwner();
    }

    @NotNull
    public final LifecycleCoroutineScope E9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LifecycleCoroutineScope) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        b bVar = this._frameProxy;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_frameProxy");
            bVar = null;
        }
        return bVar.M9();
    }

    @NotNull
    public final ViewModelStoreOwner F9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ViewModelStoreOwner) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        b bVar = this._frameProxy;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_frameProxy");
            bVar = null;
        }
        return bVar.y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.qqnt.chats.biz.main.a G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.biz.main.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.qqnt.chats.biz.main.a aVar = this._binding;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_binding");
        return null;
    }

    public void H9(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
        }
    }

    public void I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        }
    }

    public void J9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    public void K9(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) app);
        } else {
            Intrinsics.checkNotNullParameter(app, "app");
        }
    }

    public void L9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    public void M9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    public void N9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    public void O9(@NotNull RecyclerView recyclerView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) recyclerView, i3);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        }
    }

    public void P9(@NotNull RecyclerView recyclerView, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        }
    }

    public void Q9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        }
    }

    public void R9(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) app);
        } else {
            Intrinsics.checkNotNullParameter(app, "app");
        }
    }

    @NotNull
    public final Context S9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Context) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        b bVar = this._frameProxy;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_frameProxy");
            bVar = null;
        }
        return bVar.requireContext();
    }

    public void T9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public final void U9(@NotNull b frameProxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) frameProxy);
        } else {
            Intrinsics.checkNotNullParameter(frameProxy, "frameProxy");
            this._frameProxy = frameProxy;
        }
    }

    public final void V9(@NotNull com.tencent.qqnt.chats.biz.main.a binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) binding);
        } else {
            Intrinsics.checkNotNullParameter(binding, "binding");
            W9(binding);
        }
    }

    protected final void W9(@NotNull com.tencent.qqnt.chats.biz.main.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this._binding = aVar;
        }
    }

    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return false;
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) newRuntime);
        }
    }

    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) newRuntime);
        }
    }

    public void onLogout(@Nullable Constants.LogoutReason reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) reason);
        }
    }

    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    public final void x9(int index, @NotNull n handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, index, (Object) handler);
            return;
        }
        Intrinsics.checkNotNullParameter(handler, "handler");
        b bVar = this._frameProxy;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_frameProxy");
            bVar = null;
        }
        bVar.Cg(index, handler);
    }

    public final void z9(@NotNull n handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) handler);
            return;
        }
        Intrinsics.checkNotNullParameter(handler, "handler");
        b bVar = this._frameProxy;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_frameProxy");
            bVar = null;
        }
        bVar.G4(handler);
    }
}
