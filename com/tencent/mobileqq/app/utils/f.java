package com.tencent.mobileqq.app.utils;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/app/utils/f;", "", "Landroid/content/Context;", "context", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "c", "b", "a", "Ljava/lang/Boolean;", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f196660a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean switch;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37325);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f196660a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Boolean bool = switch;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void b(@NotNull Context context) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (switch == null) {
                String read = PropertiesUtils.read(context, "fold_density_switch_9125", "1");
                Intrinsics.checkNotNullExpressionValue(read, "read(context, FOLD_DENSITY_SWITCH, \"1\")");
                if (Integer.parseInt(read) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                switch = Boolean.valueOf(z16);
            }
        } catch (Throwable th5) {
            QLog.i("DisplayFoldMetricsTwoCheckSwitch", 1, "[readCheckSwitch]: " + th5);
        }
    }

    public final void c(@NotNull Context context, boolean r95) {
        String str = "0";
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(r95));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String read = PropertiesUtils.read(context, "fold_density_switch_9125", "0");
            Intrinsics.checkNotNullExpressionValue(read, "read(context, FOLD_DENSITY_SWITCH, \"0\")");
            if (Integer.parseInt(read) == 1) {
                z16 = true;
            }
            if (z16 != r95) {
                if (r95) {
                    str = "1";
                }
                PropertiesUtils.save(context, "fold_density_switch_9125", str);
            }
        } catch (Throwable th5) {
            QLog.i("DisplayFoldMetricsTwoCheckSwitch", 1, "[saveCheckSwitch]: " + th5);
        }
    }
}
