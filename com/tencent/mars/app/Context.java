package com.tencent.mars.app;

import android.util.Log;
import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Context {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MicroMsg.MMContext";
    public static final String libMarsBase = "wechatbase";
    public static final String libMarsMM = "wechatmm";
    public static final String libMarsNetwork = "wechatnetwork";
    private BridgeMap interfaceMap;
    private long nativeHandle;

    public Context(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.nativeHandle = 0L;
        this.interfaceMap = new BridgeMap();
        Log.i(TAG, "MMContext");
        if (!h.b(libMarsBase)) {
            h.b(libMarsBase, getClass().getClassLoader());
        }
        OnJniCreateContext(str);
    }

    private native void OnJniAddManager(String str, Object obj);

    private native void OnJniCreateContext(String str);

    private native void OnJniCreateContextFromHandle(long j3);

    private native void OnJniDestroyContext();

    private native long OnJniGetManager(String str);

    private native int OnJniInit();

    private native void OnJniRemoveManager(String str, Object obj);

    private native int OnJniUnInit();

    public <T> void addManager(Class<T> cls, BaseManager baseManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cls, (Object) baseManager);
        } else {
            if (baseManager != null) {
                w.d(TAG, "mars2 addManager clazz:%s, process:%s", cls.getName(), z.i());
                OnJniAddManager(cls.getName(), baseManager);
                this.interfaceMap.put(baseManager.getNativeHandle(), baseManager);
                return;
            }
            w.b(TAG, "mars2 addManager fail. empty manager. clazz:%s, process:%s", cls.getName(), z.i());
        }
    }

    public <T extends BaseManager> T getManager(Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, (Object) this, (Object) cls);
        }
        w.g(TAG, "mars2 getManager clazz:%s, process:%s, stack:%s", cls.getName(), z.i(), w0.b());
        Object transfer = this.interfaceMap.transfer(OnJniGetManager(cls.getName()), cls.getName());
        if (transfer != null) {
            return (T) transfer;
        }
        return null;
    }

    public long getNativeHandle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.nativeHandle;
    }

    public int init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return OnJniInit();
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            OnJniDestroyContext();
            this.nativeHandle = -1L;
        }
    }

    public <T> void removeManager(Class<T> cls, BaseManager baseManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cls, (Object) baseManager);
        } else {
            if (baseManager != null) {
                w.d(TAG, "mars2 removeManager clazz:%s, process:%s", cls.getName(), z.i());
                OnJniRemoveManager(cls.getName(), baseManager);
                this.interfaceMap.delete(baseManager);
                return;
            }
            w.b(TAG, "mars2 removeManager fail. empty manager. clazz:%s, process:%s", cls.getName(), z.i());
        }
    }

    public int unInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return OnJniUnInit();
    }

    public Context(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        this.nativeHandle = 0L;
        this.interfaceMap = new BridgeMap();
        OnJniCreateContextFromHandle(j3);
    }
}
