package com.tencent.pts.core.jni;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSJNIHandler;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.utils.PTSDeviceUtil;

/* loaded from: classes22.dex */
public class PTSJsJniHandler {
    static IPatchRedirector $redirector_;
    private static String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = "PTSJsJniHandler";
            init();
        }
    }

    public PTSJsJniHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void callJSEventFunction(PTSAppInstance pTSAppInstance, String str, int i3, String str2, String str3, String[] strArr, String[] strArr2, float[] fArr, float[] fArr2, int i16) {
        if (pTSAppInstance == null) {
            return;
        }
        callJSEventFunction(str, i3, str2, str3, strArr, strArr2, fArr, fArr2, pTSAppInstance.getUniqueID(), i16);
    }

    private static native void callJSEventFunction(String str, int i3, String str2, String str3, String[] strArr, String[] strArr2, float[] fArr, float[] fArr2, int i16, int i17);

    public static void callJSFunction(PTSAppInstance pTSAppInstance, String str, Object[] objArr, int i3) {
        if (pTSAppInstance == null) {
            return;
        }
        callJSFunction(str, objArr, pTSAppInstance.getUniqueID(), i3);
    }

    private static native void callJSFunction(String str, Object[] objArr, int i3, int i16);

    public static void create(PTSAppInstance pTSAppInstance, String str, String str2, int i3) {
        if (pTSAppInstance == null) {
            return;
        }
        PTSJNIHandler.addPTSAppInstance(pTSAppInstance);
        int uniqueID = pTSAppInstance.getUniqueID();
        float rootViewWidth = pTSAppInstance.getRootViewWidth();
        float screenScale = PTSDeviceUtil.getScreenScale();
        float rPXScaling = PTSDeviceUtil.getRPXScaling(pTSAppInstance.getRootViewWidth());
        boolean z16 = true;
        if (pTSAppInstance.getRootNodeType() != 1) {
            z16 = false;
        }
        createPTSPage(uniqueID, rootViewWidth, screenScale, rPXScaling, z16, str, str2, i3);
    }

    public static native void createJSEnvironment(int i3);

    private static native void createPTSPage(int i3, float f16, float f17, float f18, boolean z16, String str, String str2, int i16);

    public static void destroy(PTSAppInstance pTSAppInstance, int i3) {
        if (pTSAppInstance == null) {
            return;
        }
        PTSJNIHandler.removePTSAppInstance(pTSAppInstance);
        destroyPTSPage(pTSAppInstance.getUniqueID(), i3);
    }

    public static native void destroyJSEnvironment(int i3);

    private static native void destroyPTSPage(int i3, int i16);

    public static native void evaluateJavaScript(int i3, String str);

    private static native void init();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void jsFunctionCallback(long j3, Object[] objArr);

    public static void jsFunctionCallbackAsync(long j3, Object[] objArr) {
        PTSThreadUtil.runOnSubThread(new Runnable(j3, objArr) { // from class: com.tencent.pts.core.jni.PTSJsJniHandler.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Object[] val$args;
            final /* synthetic */ long val$callbackPtr;

            {
                this.val$callbackPtr = j3;
                this.val$args = objArr;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), objArr);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    PTSJsJniHandler.jsFunctionCallback(this.val$callbackPtr, this.val$args);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void jsFunctionCallbackWithHttpResponse(long j3, long j16, byte[] bArr, long j17);

    public static void jsFunctionCallbackWithHttpResponseAsync(long j3, long j16, byte[] bArr, long j17) {
        PTSThreadUtil.runOnSubThread(new Runnable(j3, j16, bArr, j17) { // from class: com.tencent.pts.core.jni.PTSJsJniHandler.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ byte[] val$buffer;
            final /* synthetic */ long val$bufferLength;
            final /* synthetic */ long val$callbackPtr;
            final /* synthetic */ long val$statusCode;

            {
                this.val$callbackPtr = j3;
                this.val$statusCode = j16;
                this.val$buffer = bArr;
                this.val$bufferLength = j17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), bArr, Long.valueOf(j17));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    PTSJsJniHandler.jsFunctionCallbackWithHttpResponse(this.val$callbackPtr, this.val$statusCode, this.val$buffer, this.val$bufferLength);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }
}
