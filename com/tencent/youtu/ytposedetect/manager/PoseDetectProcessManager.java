package com.tencent.youtu.ytposedetect.manager;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.data.PoseDetectData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;

/* loaded from: classes27.dex */
public class PoseDetectProcessManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FaceDetectProcess";
    public int mCameraRotateTag;
    public int mDesiredPreviewHeight;
    public int mDesiredPreviewWidth;
    public boolean mIsDetecting;

    public PoseDetectProcessManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsDetecting = false;
        this.mDesiredPreviewWidth = 1280;
        this.mDesiredPreviewHeight = 720;
    }

    public void clearAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void finalize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.finalize();
        }
    }

    public void initAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public int poseDetect(PoseDetectData poseDetectData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) poseDetectData)).intValue();
        }
        this.mDesiredPreviewWidth = poseDetectData.frameW;
        this.mDesiredPreviewHeight = poseDetectData.frameH;
        return YTPoseDetectJNIInterface.poseDetect(poseDetectData);
    }

    public void start(Context context, int i3, YTPoseDetectInterface.PoseDetectResult poseDetectResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(i3), poseDetectResult);
            return;
        }
        if (this.mIsDetecting) {
            YTPoseDetectJNIInterface.nativeLog(TAG, "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
        }
        this.mCameraRotateTag = i3;
        this.mIsDetecting = true;
        poseDetectResult.onSuccess();
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.mIsDetecting) {
            this.mIsDetecting = false;
            YTPoseDetectJNIInterface.resetDetect();
        }
    }
}
