package com.tencent.qfsmonet.module.operator.renderprocessing;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetOverlayOperator extends MonetOperator {
    static IPatchRedirector $redirector_ = null;
    private static final String OP_TYPE_NAME = "ImageOverlay";
    public static final String OVERLAY_H_KEY = "overlay_rect_h";
    public static final String OVERLAY_W_KEY = "overlay_rect_w";
    public static final String OVERLAY_X_KEY = "overlay_rect_x";
    public static final String OVERLAY_Y_KEY = "overlay_rect_y";

    public MonetOverlayOperator() {
        super(OP_TYPE_NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
