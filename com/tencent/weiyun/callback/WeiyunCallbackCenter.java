package com.tencent.weiyun.callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class WeiyunCallbackCenter {
    static IPatchRedirector $redirector_ = null;
    public static final long INVALID_SERIAL_NUM = 0;
    private static final String TAG = "CallbackCenter";
    private final HashMap<Long, WeiyunCallback> mCallbackMap;
    private final Object mLock;
    private final Random mRandom;

    public WeiyunCallbackCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mRandom = new Random();
        this.mLock = new Object();
        this.mCallbackMap = new HashMap<>();
    }

    public long addCallback(WeiyunCallback weiyunCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunCallback)).longValue();
        }
        if (weiyunCallback == null) {
            return 0L;
        }
        long nextLong = this.mRandom.nextLong();
        synchronized (this.mLock) {
            this.mCallbackMap.put(Long.valueOf(nextLong), weiyunCallback);
        }
        return nextLong;
    }

    public int deleteCallback(WeiyunCallback weiyunCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) weiyunCallback)).intValue();
        }
        int i3 = 0;
        if (weiyunCallback != null) {
            synchronized (this.mLock) {
                Iterator<Map.Entry<Long, WeiyunCallback>> it = this.mCallbackMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (weiyunCallback.equals(it.next().getValue())) {
                        it.remove();
                        i3++;
                    }
                }
            }
        }
        return i3;
    }

    public WeiyunCallback getCallback(long j3) {
        WeiyunCallback weiyunCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (WeiyunCallback) iPatchRedirector.redirect((short) 5, (Object) this, j3);
        }
        if (j3 == 0) {
            return null;
        }
        synchronized (this.mLock) {
            weiyunCallback = this.mCallbackMap.get(Long.valueOf(j3));
        }
        return weiyunCallback;
    }

    public void onCallback(long j3, long j16, int i3, boolean z16, int i16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), str, Boolean.valueOf(z17));
            return;
        }
        WeiyunCallback callback = getCallback(j3);
        if (callback == null) {
            return;
        }
        callback.onNativeCallback(j16, i3, i16, str, z16);
        if (z17) {
            deleteCallback(j3);
        }
    }

    public void deleteCallback(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            if (j3 == 0) {
                return;
            }
            synchronized (this.mLock) {
                this.mCallbackMap.remove(Long.valueOf(j3));
            }
        }
    }
}
