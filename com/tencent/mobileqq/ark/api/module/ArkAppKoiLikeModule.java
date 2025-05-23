package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.module.e;
import com.tencent.mobileqq.profilecard.base.utils.ProfileKoiLikeReportUtil;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class ArkAppKoiLikeModule extends b {
    public ArkAppKoiLikeModule(ark.Application application, int i3) {
        super(application, i3);
    }

    private void p(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        String str;
        if (variantWrapperArr != null && variantWrapperArr.length >= 3) {
            String GetString = variantWrapperArr[0].GetString();
            String GetString2 = variantWrapperArr[1].GetString();
            String GetString3 = variantWrapperArr[2].GetString();
            if (variantWrapperArr.length >= 4) {
                str = variantWrapperArr[3].GetString();
            } else {
                str = "";
            }
            ProfileKoiLikeReportUtil.getInstance().koiArkReport(GetString, GetString2, GetString3, str);
        }
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        super.Destruct();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "MobileQQKoiLike";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        return str.equals("KoiLikeReport");
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (str.equals("KoiLikeReport")) {
            p(variantWrapperArr, variantWrapper);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ark.koi.module", 1, "Invoke method is error!");
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    protected e[] e() {
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean n() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean o() {
        return false;
    }
}
