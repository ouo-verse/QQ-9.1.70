package com.tencent.mobileqq.nearbypro.chats.part;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qqnt.chats.core.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\"\u0010\u001e\u001a\u00020\u00078\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "Lmqq/app/IAccountCallback;", "Lcom/tencent/qqnt/chats/biz/main/part/b;", "frameProxy", "", "C9", "Lcom/tencent/mobileqq/nearbypro/chats/part/b;", "binding", "D9", "Landroidx/lifecycle/LifecycleCoroutineScope;", "z9", "Lcom/tencent/qqnt/chats/core/ui/n;", "handler", "x9", "Landroid/content/Context;", "B9", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "d", "Lcom/tencent/mobileqq/nearbypro/chats/part/b;", "A9", "()Lcom/tencent/mobileqq/nearbypro/chats/part/b;", "E9", "(Lcom/tencent/mobileqq/nearbypro/chats/part/b;)V", "_binding", "e", "Lcom/tencent/qqnt/chats/biz/main/part/b;", "_frameProxy", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class a extends Part implements IAccountCallback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected b _binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.chats.biz.main.part.b _frameProxy;

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final b A9() {
        b bVar = this._binding;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_binding");
        return null;
    }

    @NotNull
    public final Context B9() {
        com.tencent.qqnt.chats.biz.main.part.b bVar = this._frameProxy;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_frameProxy");
            bVar = null;
        }
        return bVar.requireContext();
    }

    public final void C9(@NotNull com.tencent.qqnt.chats.biz.main.part.b frameProxy) {
        Intrinsics.checkNotNullParameter(frameProxy, "frameProxy");
        this._frameProxy = frameProxy;
    }

    public final void D9(@NotNull b binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        E9(binding);
    }

    protected final void E9(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this._binding = bVar;
    }

    public final void x9(@NotNull n handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        com.tencent.qqnt.chats.biz.main.part.b bVar = this._frameProxy;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_frameProxy");
            bVar = null;
        }
        bVar.G4(handler);
    }

    @NotNull
    public final LifecycleCoroutineScope z9() {
        com.tencent.qqnt.chats.biz.main.part.b bVar = this._frameProxy;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_frameProxy");
            bVar = null;
        }
        return bVar.M9();
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
    }

    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
    }
}
