package com.tencent.mobileqq.webview.swift.cookie;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.g;
import com.tencent.mobileqq.webview.swift.injector.i;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J$\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J,\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J0\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J,\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/cookie/a;", "", "", "domain", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/webview/swift/injector/g;", "callback", "", "b", "d", "", "forceOutDate", "c", "", "domains", "a", "e", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f314560a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40929);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314560a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull List<String> domains, boolean forceOutDate, @Nullable AppRuntime appRuntime, @NotNull g callback) {
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!domains.isEmpty() && appRuntime != null && appRuntime.isLogin()) {
            if (forceOutDate) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Iterator<T> it = domains.iterator();
                while (it.hasNext()) {
                    t.INSTANCE.b("busi_cookie_").d("webview_newpskey_" + ((String) it.next()) + "_" + appRuntime.getAccount(), Long.valueOf(elapsedRealtime)).g();
                }
                i iVar = (i) aa.k(i.class);
                Object[] array = domains.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                iVar.b((String[]) array, callback);
            } else {
                i iVar2 = (i) aa.k(i.class);
                Object[] array2 = domains.toArray(new String[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                iVar2.d((String[]) array2, callback);
            }
            QLog.d("CookieHelper", 1, "getPskey forceOutDate=" + forceOutDate);
        }
    }

    @JvmStatic
    public static final void b(@Nullable String domain, @Nullable AppRuntime appRuntime, @NotNull g callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        c(domain, false, appRuntime, callback);
    }

    @JvmStatic
    public static final void c(@Nullable String domain, boolean forceOutDate, @Nullable AppRuntime appRuntime, @NotNull g callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TextUtils.isEmpty(domain) && appRuntime != null && appRuntime.getAccount() != null) {
            String str = "webview_newpskey_" + domain + "_" + appRuntime.getAccount();
            t.Companion companion = t.INSTANCE;
            long longValue = ((Number) companion.b("busi_cookie_").b(str, 0L)).longValue();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z16 = false;
            String[] strArr = {domain};
            if (!forceOutDate) {
                long j3 = elapsedRealtime - longValue;
                if (j3 <= MiniBoxNoticeInfo.HOUR_8 && j3 >= 0) {
                    ((i) aa.k(i.class)).d(strArr, callback);
                    QLog.d("CookieHelper", 1, "getPskeyWithOutDateCheck replace=" + z16 + " forceOutDate=" + forceOutDate);
                }
            }
            companion.b("busi_cookie_").d(str, Long.valueOf(elapsedRealtime)).g();
            ((i) aa.k(i.class)).b(strArr, callback);
            z16 = true;
            QLog.d("CookieHelper", 1, "getPskeyWithOutDateCheck replace=" + z16 + " forceOutDate=" + forceOutDate);
        }
    }

    @JvmStatic
    public static final void d(@Nullable String domain, @Nullable AppRuntime appRuntime, @NotNull g callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        e(domain, false, appRuntime, callback);
    }

    @JvmStatic
    public static final void e(@Nullable String domain, boolean forceOutDate, @Nullable AppRuntime appRuntime, @NotNull g callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TextUtils.isEmpty(domain) && appRuntime != null && appRuntime.getAccount() != null) {
            String str = "webview_uskey_" + domain + "_" + appRuntime.getAccount();
            t.Companion companion = t.INSTANCE;
            long longValue = ((Number) companion.b("busi_cookie_").b(str, 0L)).longValue();
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean z16 = false;
            String[] strArr = {domain};
            if (!forceOutDate && uptimeMillis - longValue <= MiniBoxNoticeInfo.HOUR_8) {
                ((i) aa.k(i.class)).c(strArr, callback);
            } else {
                companion.b("busi_cookie_").d(str, Long.valueOf(uptimeMillis)).g();
                ((i) aa.k(i.class)).f(strArr, callback);
                z16 = true;
            }
            QLog.d("CookieHelper", 1, "getUskeyWithOutDateCheck replace=" + z16 + " forceOutDate=" + forceOutDate);
        }
    }
}
