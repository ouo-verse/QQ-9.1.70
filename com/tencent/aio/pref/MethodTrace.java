package com.tencent.aio.pref;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/* compiled from: P */
@Keep
/* loaded from: classes3.dex */
public class MethodTrace {
    static IPatchRedirector $redirector_ = null;
    public static volatile boolean METHOD_TRACE_TOGGLE = false;
    private static final String TAG = "AIOPref";
    private static ThreadLocal<Deque<b>> threadLocal;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends ThreadLocal<Deque<b>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Deque<b> initialValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Deque) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new LinkedList();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11123);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            METHOD_TRACE_TOGGLE = false;
            threadLocal = new a();
        }
    }

    public MethodTrace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static Long nowTime() {
        return Long.valueOf(SystemClock.elapsedRealtime());
    }

    public static void onMethodEnter(String str, String str2, String str3, String str4) {
        if (METHOD_TRACE_TOGGLE && threadLocal.get() != null) {
            onMethodEnter(str + str2 + str3 + str4);
        }
    }

    public static void onMethodExit(String str, String str2, String str3, String str4) {
        if (METHOD_TRACE_TOGGLE && threadLocal.get() != null) {
            onMethodExit(str + str2 + str3 + str4);
        }
    }

    private static String space(int i3) {
        char[] cArr = new char[i3];
        Arrays.fill(cArr, '\t');
        return new String(cArr);
    }

    public static void onMethodEnter(String str) {
        Deque<b> deque;
        if (METHOD_TRACE_TOGGLE && (deque = threadLocal.get()) != null) {
            deque.add(new b(nowTime().longValue(), str));
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static void onMethodExit(String str) {
        Deque<b> deque;
        if (!METHOD_TRACE_TOGGLE || (deque = threadLocal.get()) == null) {
            return;
        }
        while (!deque.isEmpty()) {
            b pollLast = deque.pollLast();
            if (pollLast.b().equals(str)) {
                long longValue = nowTime().longValue() - pollLast.a();
                if (longValue == 0) {
                    return;
                }
                com.tencent.aio.base.log.a.f69187b.d(TAG, String.format("%s%s: %d ms", space(deque.size()), str, Long.valueOf(longValue)));
                return;
            }
        }
    }
}
