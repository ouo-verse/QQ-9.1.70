package com.tencent.oscarcamera.particlesystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AttributeConst {
    static IPatchRedirector $redirector_ = null;
    public static final String A = "colorA";
    public static final int ATTR_A = 6;
    public static final int ATTR_B = 5;
    public static final int ATTR_CNT = 10;
    public static final int ATTR_G = 4;
    public static final int ATTR_HEIGHT = 1;
    public static final Map<String, Integer> ATTR_INDEX_MAP;
    public static final int ATTR_LIFE = 2;
    public static final int ATTR_R = 3;
    public static final int ATTR_WIDTH = 0;
    public static final int ATTR_X = 7;
    public static final int ATTR_Y = 8;
    public static final int ATTR_Z = 9;
    public static final String B = "colorB";
    public static final String EMISSION_RATE = "emissionRate";
    public static final String G = "colorG";
    public static final String HEIGHT = "height";
    public static final String LIFE = "life";
    public static final String MAX_COUNT = "particleCountMax";
    public static final String NAME = "name";
    public static final int PARAM_CNT = 11;
    public static final int PARAM_R0 = 0;
    public static final int PARAM_R1 = 1;
    public static final int PARAM_R2 = 2;
    public static final int PARAM_R3 = 3;
    public static final int PARAM_R4 = 4;
    public static final int PARAM_R5 = 5;
    public static final int PARAM_R6 = 6;
    public static final int PARAM_R7 = 7;
    public static final int PARAM_R8 = 8;
    public static final int PARAM_R9 = 9;
    public static final int PARAM_T = 10;
    public static final String R = "colorR";
    public static final String WIDTH = "width";
    public static final String X = "positionX";
    public static final String Y = "positionY";
    public static final String Z = "positionZ";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12840);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        ATTR_INDEX_MAP = hashMap;
        hashMap.put(LIFE, 2);
        hashMap.put("width", 0);
        hashMap.put("height", 1);
        hashMap.put("positionX", 7);
        hashMap.put("positionY", 8);
        hashMap.put(Z, 9);
        hashMap.put(R, 3);
        hashMap.put(G, 4);
        hashMap.put(B, 5);
        hashMap.put(A, 6);
    }

    public AttributeConst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
