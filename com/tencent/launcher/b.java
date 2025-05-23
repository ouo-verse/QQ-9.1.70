package com.tencent.launcher;

import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u0018\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u001b\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/launcher/b;", "Lcom/tencent/launcher/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "a", "", "actionCode", "Lcom/tencent/mvi/base/route/a;", "action1", "b", "c", "Landroidx/lifecycle/Lifecycle$Event;", "event", "d", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "isInMultiWindowMode", "onMultiWindowModeChanged", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/runtime/a;", "getMContext", "()Lcom/tencent/base/api/runtime/a;", "mContext", "Lcom/tencent/mvi/api/runtime/b;", "getContext", "()Lcom/tencent/mvi/api/runtime/b;", "context", "<init>", "(Lcom/tencent/base/api/runtime/a;)V", "input-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.base.api.runtime.a<?> mContext;

    public b(@NotNull com.tencent.base.api.runtime.a<?> mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext);
        } else {
            this.mContext = mContext;
        }
    }

    @Override // com.tencent.launcher.a
    public void a(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            this.mContext.e().h(msgIntent);
        }
    }

    @Override // com.tencent.launcher.a
    public void b(@NotNull String actionCode, @NotNull com.tencent.mvi.base.route.a action1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) actionCode, (Object) action1);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action1, "action1");
        this.mContext.e().d(actionCode, action1);
    }

    @Override // com.tencent.launcher.a
    public void c(@NotNull String actionCode, @NotNull com.tencent.mvi.base.route.a action1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) actionCode, (Object) action1);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action1, "action1");
        this.mContext.e().b(actionCode, action1);
    }

    @Override // com.tencent.launcher.a
    public void d(@NotNull Lifecycle.Event event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    @Override // com.tencent.launcher.a
    @NotNull
    public com.tencent.mvi.api.runtime.b getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mvi.api.runtime.b) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mContext;
    }

    @Override // com.tencent.launcher.a
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        com.tencent.base.runtime.launcher.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        hx.a g16 = this.mContext.g();
        if (g16 instanceof com.tencent.base.runtime.launcher.c) {
            cVar = (com.tencent.base.runtime.launcher.c) g16;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cVar.c(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.launcher.a
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, isInMultiWindowMode);
        } else {
            ((jx.a) this.mContext.b().b(jx.a.class)).onMultiWindowModeChanged(isInMultiWindowMode);
        }
    }
}
