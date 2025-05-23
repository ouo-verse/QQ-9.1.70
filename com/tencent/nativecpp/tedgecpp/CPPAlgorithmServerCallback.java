package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedgecontext.a;
import com.tencent.tedgecontext.b;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes21.dex */
public class CPPAlgorithmServerCallback extends b implements ICPPAlgorithmServerCallback {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CPPLog";
    private static final int logLevel = 4;
    private long mNativePoint;

    public CPPAlgorithmServerCallback(a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.mNativePoint = 0L;
            this.mNativePoint = createNativePoint();
        }
    }

    private native long createNativePoint();

    /* JADX INFO: Access modifiers changed from: private */
    public native void playRunner(long j3);

    public void asyncRunINJNIThread(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            asyncRun(new Runnable(this, j3) { // from class: com.tencent.nativecpp.tedgecpp.CPPAlgorithmServerCallback.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CPPAlgorithmServerCallback f337804d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f337805e;

                {
                    this.f337804d = this;
                    this.f337805e = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, CPPAlgorithmServerCallback.this, this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        this.f337804d.playRunner(this.f337805e);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public boolean edgeTrsUpload(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3)).booleanValue();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject.get(str2));
            }
            getRouter().f375303a.c(hashMap);
            return true;
        } catch (Exception e16) {
            logE("edgeTrsUpload error:" + e16);
            return false;
        }
    }

    public String getFilePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        return getRouter().f375305c.C() + "/" + str;
    }

    protected long getNativePointAndCreateIfNecessary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.mNativePoint;
    }

    public int getTrainSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean inferenceCenterReload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        EdgeStatus edgeStatus = new EdgeStatus();
        getRouter().f375313k.reload(edgeStatus);
        logD("inferenceCenterReload status:" + edgeStatus + ", modelName:" + str);
        if (edgeStatus.getCode() == 0) {
            return true;
        }
        return false;
    }

    public void logD(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mLog.d(TAG, str);
        }
    }

    public void logE(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mLog.e(TAG, 7, str);
        }
    }

    public void logI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mLog.c(TAG, str);
        }
    }
}
