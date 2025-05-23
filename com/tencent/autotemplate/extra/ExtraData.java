package com.tencent.autotemplate.extra;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ExtraData {
    static IPatchRedirector $redirector_ = null;
    public static final String EXTRA_FACE_INFO = "extra_face_info";
    public static final String EXTRA_FRAME_INFO = "extra_frame_info";
    public Map<String, FaceInfo> faceInfoMap;
    public Map<String, FrameInfo> frameInfoMap;

    public ExtraData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.faceInfoMap = new HashMap();
            this.frameInfoMap = new HashMap();
        }
    }

    public FaceInfo getFaceInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FaceInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return this.faceInfoMap.get(str);
    }

    public FrameInfo getFrameInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FrameInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return this.frameInfoMap.get(str);
    }

    public void putFaceInfo(String str, FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) faceInfo);
        } else {
            this.faceInfoMap.put(str, faceInfo);
        }
    }

    public void putFrameInfo(String str, FrameInfo frameInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) frameInfo);
        } else {
            this.frameInfoMap.put(str, frameInfo);
        }
    }
}
