package com.tencent.feedback.eup.jni;

import android.content.Context;
import com.tencent.bugly.proguard.be;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NativeExceptionHandlerRqdImp implements NativeExceptionHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    static NativeExceptionHandlerRqdImp f105562b;
    public static CrashHandleListener listener;

    /* renamed from: a, reason: collision with root package name */
    Context f105563a;

    /* renamed from: c, reason: collision with root package name */
    private String f105564c;

    NativeExceptionHandlerRqdImp(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f105563a = context;
        }
    }

    public static synchronized NativeExceptionHandlerRqdImp getInstance(Context context) {
        NativeExceptionHandlerRqdImp nativeExceptionHandlerRqdImp;
        synchronized (NativeExceptionHandlerRqdImp.class) {
            if (f105562b == null) {
                f105562b = new NativeExceptionHandlerRqdImp(context);
            }
            nativeExceptionHandlerRqdImp = f105562b;
        }
        return nativeExceptionHandlerRqdImp;
    }

    public synchronized String getTombDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f105564c;
    }

    @Override // com.tencent.feedback.eup.jni.NativeExceptionHandler
    public void handleNativeException(int i3, int i16, long j3, long j16, String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            handleNativeException(i3, i16, j3, j16, str, str2, str3, str4, str5, -1234567890, "", -1, -1, -1, "", "unknown");
        } else {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), str, str2, str3, str4, str5);
        }
    }

    public synchronized void setTombDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f105564c = str;
        }
    }

    @Override // com.tencent.feedback.eup.jni.NativeExceptionHandler
    public void handleNativeException(int i3, int i16, long j3, long j16, String str, String str2, String str3, String str4, String str5, int i17, String str6, int i18, int i19, int i26, String str7, String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            handleNativeException(i3, i16, j3, j16, str, str2, str3, str4, str5, i17, str6, i18, i19, i26, str7, str8, null);
        } else {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), str, str2, str3, str4, str5, Integer.valueOf(i17), str6, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), str7, str8);
        }
    }

    @Override // com.tencent.feedback.eup.jni.NativeExceptionHandler
    public void handleNativeException(int i3, int i16, long j3, long j16, String str, String str2, String str3, String str4, String str5, int i17, String str6, int i18, int i19, int i26, String str7, String str8, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            be.a().f98230x.getNativeExceptionHandler().handleNativeException2(i3, i16, j3, j16, str, str2, str3, str4, str5, i17, str6, i18, i19, i26, str7, str8, strArr);
        } else {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), str, str2, str3, str4, str5, Integer.valueOf(i17), str6, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), str7, str8, strArr);
        }
    }

    public static synchronized NativeExceptionHandlerRqdImp getInstance() {
        NativeExceptionHandlerRqdImp nativeExceptionHandlerRqdImp;
        synchronized (NativeExceptionHandlerRqdImp.class) {
            nativeExceptionHandlerRqdImp = f105562b;
        }
        return nativeExceptionHandlerRqdImp;
    }
}
