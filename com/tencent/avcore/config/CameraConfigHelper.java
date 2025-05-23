package com.tencent.avcore.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CameraConfigHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String SP_DEFAULT_VALUE = "preview-size-values=320x240,640x480;";
    private static final String SP_DEFAULT_VALUE_V29 = "preview-size-values=320x240,640x480,1280*720;";
    private static final String SP_KEY = "CP";
    private static final String SP_NAME = "AV_CameraParameters";
    private static CameraConfigHelper sInstance;
    private String mCameraParameters;
    private WeakReference<Context> mRef;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13471);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            sInstance = null;
        }
    }

    CameraConfigHelper(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mCameraParameters = null;
        this.mRef = new WeakReference<>(context);
        if (context != null) {
            this.mCameraParameters = context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY, getDefaultValue());
        }
    }

    private String getDefaultValue() {
        if (Build.VERSION.SDK_INT >= 29) {
            return SP_DEFAULT_VALUE_V29;
        }
        return SP_DEFAULT_VALUE;
    }

    public static CameraConfigHelper getInstance(Context context) {
        CameraConfigHelper cameraConfigHelper = sInstance;
        if (cameraConfigHelper == null) {
            synchronized (CameraConfigHelper.class) {
                if (sInstance == null) {
                    sInstance = new CameraConfigHelper(context);
                }
            }
        } else {
            cameraConfigHelper.updateContext(context);
        }
        return sInstance;
    }

    private void updateContext(Context context) {
        if (context != null) {
            WeakReference<Context> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                this.mRef = new WeakReference<>(context);
            }
        }
    }

    public synchronized String getCameraParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = this.mCameraParameters;
        if (str == null) {
            str = getDefaultValue();
        }
        return str;
    }

    public void setCameraParameters(String str) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.mCameraParameters = str;
        WeakReference<Context> weakReference = this.mRef;
        if (weakReference == null) {
            context = null;
        } else {
            context = weakReference.get();
        }
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SP_NAME, 0).edit();
            edit.putString(SP_KEY, str);
            edit.apply();
        }
    }
}
