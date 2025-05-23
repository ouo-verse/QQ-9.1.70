package com.tencent.facebeauty;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class FaceDetect {
    static IPatchRedirector $redirector_ = null;
    public static final int FACE_FEATURE_NUM = 83;
    public static final String TAG = "FaceDetect";
    protected int faceCount;
    protected boolean mDetectedFace;
    public List<FaceParam> mFaceParams;
    protected List<Boolean> mFemale;
    protected boolean mGetFaceFeatures;
    protected boolean mGetFaceGender;

    public FaceDetect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mFaceParams = new ArrayList();
        this.mFemale = new ArrayList();
        this.mGetFaceFeatures = false;
        this.mGetFaceGender = false;
        this.faceCount = 0;
    }

    public static Rect boundingRect(int[][] iArr, int i3, int i16) {
        int[] iArr2 = iArr[i3];
        int i17 = iArr2[0];
        int i18 = iArr2[1];
        int i19 = i17;
        int i26 = i19;
        int i27 = i18;
        for (int i28 = i3 + 1; i28 <= i16; i28++) {
            int[] iArr3 = iArr[i28];
            int i29 = iArr3[0];
            if (i29 < i19) {
                i19 = i29;
            } else if (i29 > i26) {
                i26 = i29;
            }
            int i36 = iArr3[1];
            if (i36 < i18) {
                i18 = i36;
            } else if (i36 > i27) {
                i27 = i36;
            }
        }
        return new Rect(i19, i18, i26, i27);
    }

    public final void detectFace(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        doDetectFace(bitmap);
        LogUtils.d(TAG, "detectFace() :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final boolean detectedFace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mDetectedFace;
    }

    protected abstract void doDetectFace(Bitmap bitmap);

    protected abstract void doInitial();

    protected abstract void doRelease();

    public Rect getEyes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Rect) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        if (i3 > this.mFaceParams.size() - 1) {
            return null;
        }
        return this.mFaceParams.get(i3).mEye;
    }

    public int getFaceCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.faceCount;
    }

    public int[][] getFaceFeatures(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (int[][]) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        if (i3 > this.mFaceParams.size() - 1) {
            return null;
        }
        return this.mFaceParams.get(i3).mFaceOutline;
    }

    public boolean getFaceFemale(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, i3)).booleanValue();
        }
        if (i3 > this.mFemale.size() - 1) {
            return false;
        }
        return this.mFemale.get(i3).booleanValue();
    }

    public FaceParam getFaceParams(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (FaceParam) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 > this.mFaceParams.size() - 1) {
            return null;
        }
        return this.mFaceParams.get(i3);
    }

    public Rect getFaces(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Rect) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        if (i3 > this.mFaceParams.size() - 1) {
            return null;
        }
        return this.mFaceParams.get(i3).mFace;
    }

    public Point getLeftEyeCenters(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Point) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        if (i3 > this.mFaceParams.size() - 1) {
            return null;
        }
        return this.mFaceParams.get(i3).mLeftEyeCenter;
    }

    public Rect getLeftEyes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Rect) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        if (i3 > this.mFaceParams.size() - 1) {
            return null;
        }
        return this.mFaceParams.get(i3).mLeftEye;
    }

    public Rect getMouths(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Rect) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        if (i3 > this.mFaceParams.size() - 1) {
            return null;
        }
        return this.mFaceParams.get(i3).mMouth;
    }

    public Point getRightEyeCenters(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Point) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        if (i3 > this.mFaceParams.size() - 1) {
            return null;
        }
        return this.mFaceParams.get(i3).mRightEyeCenter;
    }

    public Rect getRightEyes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Rect) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        if (i3 > this.mFaceParams.size() - 1) {
            return null;
        }
        return this.mFaceParams.get(i3).mRightEye;
    }

    public void needDetectFaceFeatures(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mGetFaceFeatures = z16;
        }
    }

    public void needDetectFaceGender(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mGetFaceGender = z16;
        }
    }

    public final void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            doRelease();
        }
    }

    public void resizeData(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        for (int i17 = 0; i17 < this.faceCount; i17++) {
            this.mFaceParams.get(i17).resetSize(i3, i16);
        }
    }
}
