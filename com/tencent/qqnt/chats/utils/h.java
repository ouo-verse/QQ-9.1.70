package com.tencent.qqnt.chats.utils;

import android.os.Trace;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J3\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\f\u0010\rJE\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/chats/utils/h;", "", "", "section", "", "a", "b", "T", "", "echo", "Lkotlin/Function0;", "block", "e", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "threshold", "", "toastOverLimitMillis", "c", "(Ljava/lang/String;ZFILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "d", "(Ljava/lang/String;ZILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Z", "getEnableToast", "()Z", "setEnableToast", "(Z)V", "enableToast", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f355549a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean enableToast;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45810);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f355549a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ Object f(h hVar, String str, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return hVar.e(str, z16, function0);
    }

    public final void a(@NotNull String section) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) section);
        } else {
            Intrinsics.checkNotNullParameter(section, "section");
            Trace.beginSection(section);
        }
    }

    public final void b(@NotNull String section) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) section);
        } else {
            Intrinsics.checkNotNullParameter(section, "section");
            Trace.endSection();
        }
    }

    public final <T> T c(@NotNull String section, boolean echo, float threshold, int toastOverLimitMillis, @NotNull Function0<? extends T> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, this, section, Boolean.valueOf(echo), Float.valueOf(threshold), Integer.valueOf(toastOverLimitMillis), block);
        }
        Intrinsics.checkNotNullParameter(section, "section");
        Intrinsics.checkNotNullParameter(block, "block");
        long nanoTime = System.nanoTime();
        a(section);
        T invoke = block.invoke();
        b(section);
        float nanoTime2 = ((float) (System.nanoTime() - nanoTime)) / 1000000;
        if (echo && nanoTime2 > threshold) {
            QLog.d("TraceUtils", 1, section + " cost: " + nanoTime2);
            if (nanoTime2 > toastOverLimitMillis && QLog.isDebugVersion() && enableToast) {
                QQToastUtil.showQQToastInUiThread(1, MobileQQ.sMobileQQ.getResources().getString(R.string.f23226743, section, Integer.valueOf((int) nanoTime2)));
            }
        }
        return invoke;
    }

    public final <T> T d(@NotNull String section, boolean echo, int toastOverLimitMillis, @NotNull Function0<? extends T> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, this, section, Boolean.valueOf(echo), Integer.valueOf(toastOverLimitMillis), block);
        }
        Intrinsics.checkNotNullParameter(section, "section");
        Intrinsics.checkNotNullParameter(block, "block");
        return (T) c(section, echo, 0.1f, toastOverLimitMillis, block);
    }

    public final <T> T e(@NotNull String section, boolean echo, @NotNull Function0<? extends T> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, this, section, Boolean.valueOf(echo), block);
        }
        Intrinsics.checkNotNullParameter(section, "section");
        Intrinsics.checkNotNullParameter(block, "block");
        long nanoTime = System.nanoTime();
        a(section);
        T invoke = block.invoke();
        b(section);
        if (echo) {
            QLog.d("TraceUtils", 1, section + " cost: " + (((float) (System.nanoTime() - nanoTime)) / 1000000));
        }
        return invoke;
    }
}
