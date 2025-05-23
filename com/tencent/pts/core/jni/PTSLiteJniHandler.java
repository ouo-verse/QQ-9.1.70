package com.tencent.pts.core.jni;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSJNIHandler;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;

/* loaded from: classes22.dex */
public class PTSLiteJniHandler {
    static IPatchRedirector $redirector_;
    private static String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37261);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = "PTSLiteJniHandler";
        }
    }

    public PTSLiteJniHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void create(PTSAppInstance pTSAppInstance, String str) {
        if (pTSAppInstance == null) {
            return;
        }
        PTSJNIHandler.addPTSAppInstance(pTSAppInstance);
        try {
            int uniqueID = pTSAppInstance.getUniqueID();
            float rootViewWidth = pTSAppInstance.getRootViewWidth();
            float screenScale = PTSDeviceUtil.getScreenScale();
            float rPXScaling = PTSDeviceUtil.getRPXScaling(pTSAppInstance.getRootViewWidth());
            boolean z16 = true;
            if (pTSAppInstance.getRootNodeType() != 1) {
                z16 = false;
            }
            createPTSLitePage(uniqueID, rootViewWidth, screenScale, rPXScaling, z16, str);
        } catch (Throwable th5) {
            PTSLog.e(TAG, "[create] no implementation found for PTSLiteJniHandler createPTSLitePage, error = " + th5);
        }
    }

    private static native void createPTSLitePage(int i3, float f16, float f17, float f18, boolean z16, String str);

    public static void destroy(PTSAppInstance pTSAppInstance) {
        if (pTSAppInstance == null) {
            return;
        }
        PTSJNIHandler.removePTSAppInstance(pTSAppInstance);
        try {
            destroyPTSLitePage(pTSAppInstance.getUniqueID());
        } catch (Throwable th5) {
            PTSLog.e(TAG, "[destroy] no implementation found for PTSLiteJniHandler destroyPTSLitePage, error = " + th5);
        }
    }

    private static native void destroyPTSLitePage(int i3);

    public static void setData(PTSAppInstance pTSAppInstance, String str) {
        if (pTSAppInstance == null) {
            return;
        }
        try {
            setPTSLiteData(pTSAppInstance.getUniqueID(), str);
        } catch (Throwable th5) {
            PTSLog.e(TAG, "[setData] no implementation found for PTSLiteJniHandler setPTSLiteData, error = " + th5);
        }
    }

    private static native void setPTSLiteData(int i3, String str);

    public static String updateData(PTSAppInstance pTSAppInstance, String str) {
        if (pTSAppInstance == null) {
            return "";
        }
        try {
            return updatePTSLiteData(pTSAppInstance.getUniqueID(), str);
        } catch (Throwable th5) {
            PTSLog.e(TAG, "[updateData] no implementation found for PTSLiteJniHandler updatePTSLiteData, error = " + th5);
            return "";
        }
    }

    private static native String updatePTSLiteData(int i3, String str);
}
