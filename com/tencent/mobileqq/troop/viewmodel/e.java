package com.tencent.mobileqq.troop.viewmodel;

import android.os.Bundle;
import com.tencent.mobileqq.app.ds;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/viewmodel/e;", "Lcom/tencent/mobileqq/troop/viewmodel/a;", "", "callbackId", "", "type", "", "isLiked", "", "a", "Lmqq/app/AppRuntime;", "Lmqq/app/AppRuntime;", "getAppRuntime", "()Lmqq/app/AppRuntime;", "appRuntime", "<init>", "(Lmqq/app/AppRuntime;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppRuntime appRuntime;

    public e(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.appRuntime = appRuntime;
        }
    }

    @Override // com.tencent.mobileqq.troop.viewmodel.a
    public void a(@NotNull String callbackId, int type, boolean isLiked) {
        Integer intOrNull;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, callbackId, Integer.valueOf(type), Boolean.valueOf(isLiked));
            return;
        }
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Bundle bundle = new Bundle();
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(callbackId);
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        bundle.putInt("seq", i3);
        bundle.putInt("click_view_type", type);
        bundle.putBoolean("like_state", isLiked);
        this.appRuntime.notifyObservers(ds.class, 0, true, bundle);
    }
}
