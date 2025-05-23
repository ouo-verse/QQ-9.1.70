package com.tencent.qqnt.chats.main.vm.usecase.lifecycle;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/lifecycle/a;", "", "Lcom/tencent/qqnt/chats/main/vm/usecase/lifecycle/a$a;", "params", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/lifecycle/a$a;", "", "Landroid/content/Context;", "a", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "Landroidx/lifecycle/Lifecycle$State;", "b", "Landroidx/lifecycle/Lifecycle$State;", "()Landroidx/lifecycle/Lifecycle$State;", "state", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/Lifecycle$State;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.usecase.lifecycle.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9599a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lifecycle.State state;

        public C9599a(@NotNull Context context, @NotNull Lifecycle.State state) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(state, "state");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) state);
            } else {
                this.context = context;
                this.state = state;
            }
        }

        @NotNull
        public final Context a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.context;
        }

        @NotNull
        public final Lifecycle.State b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Lifecycle.State) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.state;
        }
    }

    @Nullable
    com.tencent.qqnt.chats.main.vm.usecase.result.a a(@NotNull C9599a params);
}
