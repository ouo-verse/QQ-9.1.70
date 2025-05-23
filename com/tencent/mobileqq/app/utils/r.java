package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.os.Build;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/app/utils/r;", "", "", "b", "Landroid/content/Context;", "context", "", "a", "Z", "inited", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class r {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f196682a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean inited;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37363);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f196682a = new r();
        }
    }

    r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b() {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(Build.MANUFACTURER, "Samsung", true);
        return equals;
    }

    public final void a(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (inited) {
                return;
            }
            inited = true;
            if (!b()) {
                return;
            }
            String read = PropertiesUtils.read(context, "view_configuration_init_switch", "1");
            Intrinsics.checkNotNullExpressionValue(read, "read(context, SWITCH, \"1\")");
            if (Integer.parseInt(read) == 1) {
                QLog.i("ViewConfigurationInit", 1, "init ViewConfiguration");
                ViewConfiguration.get(context);
            }
        } catch (Throwable th5) {
            QLog.i("ViewConfigurationInit", 1, "init", th5);
        }
    }
}
