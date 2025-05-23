package com.tencent.input.base.launch;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/input/base/launch/a;", "Lcom/tencent/input/base/launch/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "a", "", "actionCode", "Lcom/tencent/mvi/base/route/a;", "action1", "b", "c", "Lcom/tencent/mvi/base/route/b;", "actionR1", "d", "action", "e", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", "mContext", "<init>", "(Lcom/tencent/mvi/api/runtime/b;)V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.api.runtime.b mContext;

    public a(@NotNull com.tencent.mvi.api.runtime.b mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext);
        } else {
            this.mContext = mContext;
        }
    }

    @Override // com.tencent.input.base.launch.b
    public void a(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            this.mContext.e().h(msgIntent);
        }
    }

    @Override // com.tencent.input.base.launch.b
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

    @Override // com.tencent.input.base.launch.b
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

    @Override // com.tencent.input.base.launch.b
    public void d(@NotNull String actionCode, @NotNull com.tencent.mvi.base.route.b actionR1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) actionCode, (Object) actionR1);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(actionR1, "actionR1");
        this.mContext.e().j(actionCode, actionR1);
    }

    @Override // com.tencent.input.base.launch.b
    public void e(@NotNull String actionCode, @NotNull com.tencent.mvi.base.route.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        this.mContext.e().a(actionCode);
    }
}
