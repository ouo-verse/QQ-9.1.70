package com.tencent.qfsmonet.module.operator.vr;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetVRSphereOperator extends MonetOperator {
    static IPatchRedirector $redirector_ = null;
    private static final String OP_TYPE_NAME = "VRSphere";
    public static final String SPHERE_VR_HEIGHT_KEY = "sphere_vr_height";
    public static final String SPHERE_VR_MODE_KEY = "sphere_vr_mode";
    public static final String SPHERE_VR_MVP_MATRIX_KEY = "sphere_vr_mvp_matrix";
    public static final String SPHERE_VR_MV_MATRIX_KEY = "sphere_vr_mv_matrix";
    public static final String SPHERE_VR_WIDTH_KEY = "sphere_vr_width";

    public MonetVRSphereOperator() {
        super(OP_TYPE_NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
