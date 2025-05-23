package com.tencent.qqnt.msg.graytip.ntactionhandler.troop;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J:\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/msg/graytip/ntactionhandler/troop/b;", "Lcom/tencent/qqnt/graytips/handler/c;", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "", "jp", "", "param", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/JsonGrayElement;", "jsonGrayElement", "Lgv3/a;", "aioAbility", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b implements com.tencent.qqnt.graytips.handler.c {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.graytips.handler.c
    public void a(@NotNull AppRuntime app, @NotNull Context context, int jp5, @NotNull String param, @NotNull JsonGrayElement jsonGrayElement, @Nullable gv3.a aioAbility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, context, Integer.valueOf(jp5), param, jsonGrayElement, aioAbility);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(jsonGrayElement, "jsonGrayElement");
        a b16 = c.f359640a.b(jp5);
        if (b16 != null) {
            b16.a(app, context, jp5, param, jsonGrayElement, aioAbility);
        }
    }
}
