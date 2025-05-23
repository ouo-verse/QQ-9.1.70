package com.tencent.qfsmonet.module.operator.renderprocessing;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetImageCropOperator extends MonetOperator {
    static IPatchRedirector $redirector_ = null;
    public static final String CROP_H_KEY = "crop_rect_h";
    public static final String CROP_W_KEY = "crop_rect_w";
    public static final String CROP_X_KEY = "crop_rect_x";
    public static final String CROP_Y_KEY = "crop_rect_y";
    private static final String OP_TYPE_NAME = "ImageCrop";

    public MonetImageCropOperator() {
        super(OP_TYPE_NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
