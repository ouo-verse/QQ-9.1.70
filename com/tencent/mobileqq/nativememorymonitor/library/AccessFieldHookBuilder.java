package com.tencent.mobileqq.nativememorymonitor.library;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AccessFieldHookBuilder {
    static IPatchRedirector $redirector_;
    private static volatile boolean hooked;
    private final List<AccessFieldCallback> callbacks;
    private final List<Class> classes;
    private final Context context;
    private final List<String> fieldNames;
    private final List<String> fieldSigs;
    private final List<AccessFieldCallback> staticCallbacks;
    private final List<Class> staticFieldClasses;
    private final List<String> staticFieldNames;
    private final List<String> staticFieldSigs;

    public AccessFieldHookBuilder(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.classes = new ArrayList();
        this.fieldNames = new ArrayList();
        this.fieldSigs = new ArrayList();
        this.callbacks = new ArrayList();
        this.staticFieldClasses = new ArrayList();
        this.staticFieldNames = new ArrayList();
        this.staticFieldSigs = new ArrayList();
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
            NativeMemoryMonitor.getInstance().nativeJavaFieldHook((Class[]) this.classes.toArray(new Class[0]), (String[]) this.fieldNames.toArray(new String[0]), (String[]) this.fieldSigs.toArray(new String[0]), (AccessFieldCallback[]) this.callbacks.toArray(new AccessFieldCallback[0]), (Class[]) this.staticFieldClasses.toArray(new Class[0]), (String[]) this.staticFieldNames.toArray(new String[0]), (String[]) this.staticFieldSigs.toArray(new String[0]), (AccessFieldCallback[]) this.staticCallbacks.toArray(new AccessFieldCallback[0]));
        }
    }

    public AccessFieldHookBuilder hookField(Class cls, String str, String str2, AccessFieldCallback accessFieldCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AccessFieldHookBuilder) iPatchRedirector.redirect((short) 2, this, cls, str, str2, accessFieldCallback);
        }
        this.classes.add(cls);
        this.fieldNames.add(str);
        this.fieldSigs.add(str2);
        this.callbacks.add(accessFieldCallback);
        return this;
    }

    public AccessFieldHookBuilder hookStaticField(Class cls, String str, String str2, AccessFieldCallback accessFieldCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AccessFieldHookBuilder) iPatchRedirector.redirect((short) 3, this, cls, str, str2, accessFieldCallback);
        }
        this.staticFieldClasses.add(cls);
        this.staticFieldNames.add(str);
        this.staticFieldSigs.add(str2);
        this.staticCallbacks.add(accessFieldCallback);
        return this;
    }
}
