package com.tencent.mobileqq.nativememorymonitor.library;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CallMethodHookBuilder {
    static IPatchRedirector $redirector_;
    private static volatile boolean hooked;
    private final List<CallMethodCallback> callbacks;
    private final List<Class> classes;
    private final Context context;
    private final List<String> methodNames;
    private final List<String> methodSigs;
    private final List<CallMethodCallback> staticCallbacks;
    private final List<Class> staticMethodClasses;
    private final List<String> staticMethodNames;
    private final List<String> staticMethodSigs;

    public CallMethodHookBuilder(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.classes = new ArrayList();
        this.methodNames = new ArrayList();
        this.methodSigs = new ArrayList();
        this.callbacks = new ArrayList();
        this.staticMethodClasses = new ArrayList();
        this.staticMethodNames = new ArrayList();
        this.staticMethodSigs = new ArrayList();
        this.staticCallbacks = new ArrayList();
        this.context = context;
    }

    public void build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (hooked) {
                return;
            }
            hooked = true;
            NativeMemoryMonitor.getInstance().nativeJavaMethodHook((Class[]) this.classes.toArray(new Class[0]), (String[]) this.methodNames.toArray(new String[0]), (String[]) this.methodSigs.toArray(new String[0]), (CallMethodCallback[]) this.callbacks.toArray(new CallMethodCallback[0]), (Class[]) this.staticMethodClasses.toArray(new Class[0]), (String[]) this.staticMethodNames.toArray(new String[0]), (String[]) this.staticMethodSigs.toArray(new String[0]), (CallMethodCallback[]) this.staticCallbacks.toArray(new CallMethodCallback[0]));
        }
    }

    public CallMethodHookBuilder hookMethod(Class cls, String str, String str2, CallMethodCallback callMethodCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CallMethodHookBuilder) iPatchRedirector.redirect((short) 2, this, cls, str, str2, callMethodCallback);
        }
        this.classes.add(cls);
        this.methodNames.add(str);
        this.methodSigs.add(str2);
        this.callbacks.add(callMethodCallback);
        return this;
    }

    public CallMethodHookBuilder hookStaticMethod(Class cls, String str, String str2, CallMethodCallback callMethodCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CallMethodHookBuilder) iPatchRedirector.redirect((short) 3, this, cls, str, str2, callMethodCallback);
        }
        this.staticMethodClasses.add(cls);
        this.staticMethodNames.add(str);
        this.staticMethodSigs.add(str2);
        this.staticCallbacks.add(callMethodCallback);
        return this;
    }
}
