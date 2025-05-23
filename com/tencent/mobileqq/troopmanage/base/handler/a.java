package com.tencent.mobileqq.troopmanage.base.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troopmanage.base.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/base/handler/a;", "Lcom/tencent/mobileqq/troopmanage/base/handler/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Lcom/tencent/mobileqq/troopmanage/base/f;", "a", "Lcom/tencent/mobileqq/troopmanage/base/f;", "getObserver", "()Lcom/tencent/mobileqq/troopmanage/base/f;", "observer", "<init>", "(Lcom/tencent/mobileqq/troopmanage/base/f;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f observer;

    public a(@NotNull f observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) observer);
        } else {
            this.observer = observer;
        }
    }

    @Override // com.tencent.mobileqq.troopmanage.base.handler.b
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
        } else {
            this.observer.o(isSuccess, data);
        }
    }
}
