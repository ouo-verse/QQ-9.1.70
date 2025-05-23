package com.tencent.aekit.plugin.core;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class AIAttrProvider {
    static IPatchRedirector $redirector_ = null;
    private static final int DETECT_WAIT_TIMEOUT = 500;
    private static final String TAG = "AIAttrProvider";
    private AIDataSet aiDataSet;
    private Object mFaceAttr;
    private float[] mRotationMatrix;

    public AIAttrProvider(AIDataSet aIDataSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIDataSet);
        } else {
            this.mRotationMatrix = new float[16];
            this.aiDataSet = aIDataSet;
        }
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.mFaceAttr = null;
        this.aiDataSet.clear();
        this.aiDataSet = null;
    }

    public Object getAvailableData(String str) {
        AIData aIData;
        Object lastAttr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        AIDataSet aIDataSet = this.aiDataSet;
        if (aIDataSet == null || (aIData = aIDataSet.getAIData(str)) == null) {
            return null;
        }
        synchronized (aIData.getLock()) {
            if (aIData.getAttr() != null) {
                lastAttr = aIData.getAttr();
            } else {
                lastAttr = aIData.getLastAttr();
            }
        }
        return lastAttr;
    }

    public Object getFaceAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mFaceAttr;
    }

    public Object getRealtimeData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        AIDataSet aIDataSet = this.aiDataSet;
        if (aIDataSet == null) {
            if (!str.equals(AEDetectorType.FACE.value)) {
                return null;
            }
            return this.mFaceAttr;
        }
        AIData aIData = aIDataSet.getAIData(str);
        if (aIData == null) {
            return null;
        }
        synchronized (aIData.getLock()) {
            while (aIData.getAttr() == null) {
                try {
                    aIData.getLock().wait(500L);
                } catch (InterruptedException e16) {
                    Log.e(TAG, str + "getRealtimeData failed : " + e16.getMessage());
                }
            }
        }
        if (aIData.getAttr() == null && str.equals(AEDetectorType.FACE.value)) {
            return this.mFaceAttr;
        }
        return aIData.getAttr();
    }

    public float[] getRotationMatrix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (float[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mRotationMatrix;
    }

    public void setFaceAttr(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
        } else {
            this.mFaceAttr = obj;
        }
    }

    public void setRotationMatrix(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fArr);
        } else {
            System.arraycopy(fArr, 0, this.mRotationMatrix, 0, 16);
        }
    }
}
