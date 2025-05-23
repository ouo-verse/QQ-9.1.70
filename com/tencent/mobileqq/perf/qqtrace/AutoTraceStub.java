package com.tencent.mobileqq.perf.qqtrace;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.Keep;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
@Keep
/* loaded from: classes16.dex */
public class AutoTraceStub {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_METHOD_ID_LEN = 125;
    private static final String TAG = "AutoTraceStub";
    private static boolean isMainProcess;
    private static boolean isSwitchOn;
    private static final ThreadLocal<ArrayDeque<String>> sTagStack;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends ThreadLocal<ArrayDeque<String>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayDeque<String> initialValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ArrayDeque) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new ArrayDeque<>();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        isMainProcess = false;
        isSwitchOn = false;
        sTagStack = new a();
        if (Build.VERSION.SDK_INT < 31) {
            try {
                Trace.class.getMethod("setAppTracingAllowed", Boolean.TYPE).invoke(null, Boolean.TRUE);
                QLog.d(TAG, 1, "enableAppTracing success!");
            } catch (Exception e16) {
                QLog.e(TAG, 1, "Unable to enable trace via reflection", e16);
            }
        }
    }

    public AutoTraceStub() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void addMissingSection() {
        Trace.beginSection("bindApplication");
        Trace.beginSection("makeApplication");
    }

    public static void finish() {
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.perf.qqtrace.AutoTraceStub.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AutoTraceStub.i("QQ:AutoTraceFinish");
                AutoTraceStub.isSwitchOn = false;
                AutoTraceStub.o("QQ:AutoTraceFinish");
                QLog.d(AutoTraceStub.TAG, 1, "Trace main finish and print stack size:" + ((ArrayDeque) AutoTraceStub.sTagStack.get()).size());
                Iterator it = ((ArrayDeque) AutoTraceStub.sTagStack.get()).iterator();
                while (it.hasNext()) {
                    QLog.d(AutoTraceStub.TAG, 1, "sTagStack key:" + ((String) it.next()));
                }
            }
        });
    }

    public static void i(String str) {
        if (isMainProcess && isSwitchOn) {
            sTagStack.get().push(str);
            if (str.length() > 125) {
                str = str.substring(0, 125);
            }
            Trace.beginSection(str);
        }
    }

    public static void o(String str) {
        if (!isMainProcess) {
            return;
        }
        ThreadLocal<ArrayDeque<String>> threadLocal = sTagStack;
        if (!threadLocal.get().isEmpty()) {
            if (str.startsWith("TQQ")) {
                QLog.d(TAG, 1, "end method with throw:" + str);
                str = str.substring(1);
            }
            Trace.endSection();
            String pop = threadLocal.get().pop();
            if (!str.equals(pop)) {
                String name = Thread.currentThread().getName();
                Log.d(TAG, "Tag not match: " + name + ", methodId:" + str + ", but stack name:" + pop + ", sEventStack:" + threadLocal.get().size());
                Iterator<String> it = threadLocal.get().iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    Log.d(TAG, "Tag not match: " + name + ", find top Stack:" + next);
                    i3++;
                    if (str.equals(next)) {
                        Log.d(TAG, "Tag not match: " + name + ", found target:" + next + ", index:" + i3);
                        break;
                    }
                }
                if (i3 < sTagStack.get().size()) {
                    for (int i16 = 0; i16 < i3; i16++) {
                        Log.d(TAG, "Tag not match: " + name + ", pop top event and endSection:" + sTagStack.get().pop());
                        Trace.endSection();
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (isSwitchOn) {
            Log.d(TAG, "Tag not match, isSwitchOn but is Empty:" + str);
        }
    }

    public static void start() {
        if (MobileQQ.sProcessId == 1) {
            isSwitchOn = true;
            isMainProcess = true;
            i("QQ:AutoTraceStart");
            QLog.d(TAG, 1, "Trace main start!");
            o("QQ:AutoTraceStart");
        }
    }

    public static void startup(Context context) {
        QLog.d(TAG, 1, "Trace main start! context:" + context);
        if (MobileQQ.PACKAGE_NAME.equals(MsfSdkUtils.getProcessName(context))) {
            isSwitchOn = true;
            isMainProcess = true;
            i("QQ:AutoTraceStart");
            QLog.d(TAG, 1, "Trace main start!");
            o("QQ:AutoTraceStart");
        }
    }
}
