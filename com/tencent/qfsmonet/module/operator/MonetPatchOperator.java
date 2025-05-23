package com.tencent.qfsmonet.module.operator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;

/* loaded from: classes22.dex */
public class MonetPatchOperator extends MonetOperator {
    static IPatchRedirector $redirector_ = null;
    private static final String OP_TYPE_NAME = "PATCH";
    public static final String PATCH_COUNT = "patch_count";
    public static final String PATCH_LOC_DESC1_STR = "patch_loc_desc1_str";
    public static final String PATCH_LOC_DESC2_STR = "patch_loc_desc2_str";
    public static final String PATCH_LOC_DESC3_STR = "patch_loc_desc3_str";
    public static final String PATCH_TYPE_STR = "patch_type_str";

    public MonetPatchOperator() {
        super(OP_TYPE_NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
