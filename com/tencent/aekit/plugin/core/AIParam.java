package com.tencent.aekit.plugin.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class AIParam {
    static IPatchRedirector $redirector_ = null;
    public static final String AR_ROTATE = "ARRotate";
    public static final String BYTES_DATA_SIZE_HEIGHT = "bytesDataSizeHeight";
    public static final String BYTES_DATA_SIZE_WIDTH = "bytesDataSizeWidth";
    public static final String CAMERA2_TIMESTAMP = "camera2Timestamp";
    public static final String CAMERAINDEX = "cameraIndex";
    public static final String FACEINFOLIST = "faceInfoList";
    public static final String NEEDRESETGENDER = "resetGender";
    public static final String NEED_DETECT_HAND_BONE = "needDetectHandBone";
    public static final String SCALE = "scale";
    private AIAttr aiAttr;
    private Map<String, Map<String, Object>> aiModuleParams;
    private int height;
    private float[] mRotationMatrix;
    private int rotation;
    private long surfaceTime;
    private int width;

    public AIParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mRotationMatrix = new float[16];
            this.aiModuleParams = new HashMap();
        }
    }

    public AIAttr getAIAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (AIAttr) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.aiAttr;
    }

    public Integer getBytesDataSizeHeight(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        if (this.aiModuleParams.get(str) == null) {
            return null;
        }
        if (this.aiModuleParams.get(str).get(BYTES_DATA_SIZE_HEIGHT) != null && (this.aiModuleParams.get(str).get(BYTES_DATA_SIZE_HEIGHT) instanceof Integer)) {
            return (Integer) this.aiModuleParams.get(str).get(BYTES_DATA_SIZE_HEIGHT);
        }
        return 0;
    }

    public Integer getBytesDataSizeWidth(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if (this.aiModuleParams.get(str) == null) {
            return null;
        }
        if (this.aiModuleParams.get(str).get(BYTES_DATA_SIZE_WIDTH) != null && (this.aiModuleParams.get(str).get(BYTES_DATA_SIZE_WIDTH) instanceof Integer)) {
            return (Integer) this.aiModuleParams.get(str).get(BYTES_DATA_SIZE_WIDTH);
        }
        return 0;
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.height;
    }

    public Map<String, Object> getModuleParam(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Map) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        return this.aiModuleParams.get(str);
    }

    public int getRotation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.rotation;
    }

    public float[] getRotationMatrix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (float[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mRotationMatrix;
    }

    public Float getScale(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Float) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        if (this.aiModuleParams.get(str) == null || this.aiModuleParams.get(str).get("scale") == null || !(this.aiModuleParams.get(str).get("scale") instanceof Float)) {
            return null;
        }
        return (Float) this.aiModuleParams.get(str).get("scale");
    }

    public long getSurfaceTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.surfaceTime;
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.width;
    }

    public void setAIAttr(AIAttr aIAttr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) aIAttr);
        } else {
            this.aiAttr = aIAttr;
        }
    }

    public void setModuleParam(String str, String str2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, obj);
            return;
        }
        if (this.aiModuleParams.get(str) == null) {
            this.aiModuleParams.put(str, new HashMap());
        }
        this.aiModuleParams.get(str).put(str2, obj);
    }

    public void setRotationMatrix(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) fArr);
        } else {
            System.arraycopy(fArr, 0, this.mRotationMatrix, 0, 16);
        }
    }

    public void setSurfaceTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.surfaceTime = j3;
        }
    }

    public void update(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.width = i3;
        this.height = i16;
        this.rotation = i17;
    }
}
