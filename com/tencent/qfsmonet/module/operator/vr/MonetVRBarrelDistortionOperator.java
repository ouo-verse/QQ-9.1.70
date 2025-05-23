package com.tencent.qfsmonet.module.operator.vr;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetVRBarrelDistortionOperator extends MonetOperator {
    static IPatchRedirector $redirector_ = null;
    public static final String BARREL_DISTORTION_HEIGHT_KEY = "barrel_distortion_height";
    public static final String BARREL_DISTORTION_WIDTH_KEY = "barrel_distortion_width";
    public static final String BD_VR_ENABLE_KEY = "enable_barrel_distortion";
    public static final String MVP_MATRIX_KEY = "barrel_distortion_mvp_matrix";
    private static final String OP_TYPE_NAME = "VRBarrelDistortion";

    public MonetVRBarrelDistortionOperator() {
        super(OP_TYPE_NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
