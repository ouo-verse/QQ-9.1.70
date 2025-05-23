package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import com.tencent.mobileqq.utils.dr;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;

/* loaded from: classes20.dex */
public class VasH5PayUtilImpl implements IVasH5PayUtil {
    @Override // com.tencent.mobileqq.vas.api.IVasH5PayUtil
    public void openH5Page(String str, String str2, Context context) {
        dr.g(str, str2, context);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasH5PayUtil
    public void openH5PayByURL(Context context, String str) {
        VasH5PayUtil.openH5PayByURL(context, str);
    }
}
