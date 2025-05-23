package com.tencent.qqnt.chathistory.business;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chathistory/business/b;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroid/os/Bundle;", "a", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "b", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b implements ViewModelProvider.Factory {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f353316b;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle bundle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/business/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29758);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f353316b = new a(null);
        }
    }

    public b(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
        } else {
            this.bundle = bundle;
        }
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
        }
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        com.tencent.qqnt.chathistory.util.d.f354054a.a("BusinessViewModelFactory", "bundle " + this.bundle);
        Object obj = this.bundle.get("nt_chat_history_chatType");
        String string = this.bundle.getString("nt_chat_history_peerId");
        Intrinsics.checkNotNull(string);
        String string2 = this.bundle.getString("nt_chat_history_session_name");
        boolean z16 = false;
        if (this.bundle.getInt("key_source", 0) == 1) {
            z16 = true;
        }
        if (Intrinsics.areEqual(obj, (Object) 1)) {
            return new C2CHistoryViewModel(string, string2, z16);
        }
        if (Intrinsics.areEqual(obj, (Object) 2)) {
            return new TroopHistoryViewModel(string, string2, z16);
        }
        if (Intrinsics.areEqual(obj, (Object) 4)) {
            return new d(string, string2);
        }
        if (!Intrinsics.areEqual(obj, (Object) 100) && !Intrinsics.areEqual(obj, (Object) 101) && !Intrinsics.areEqual(obj, (Object) 104) && !Intrinsics.areEqual(obj, (Object) 105) && !Intrinsics.areEqual(obj, (Object) 111) && !Intrinsics.areEqual(obj, (Object) 106) && !Intrinsics.areEqual(obj, (Object) 103) && !Intrinsics.areEqual(obj, (Object) 102) && !Intrinsics.areEqual(obj, (Object) 119) && !Intrinsics.areEqual(obj, (Object) 113)) {
            throw new IllegalArgumentException("can not deal type " + obj);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return new c(((Integer) obj).intValue(), string, string2, z16);
    }
}
