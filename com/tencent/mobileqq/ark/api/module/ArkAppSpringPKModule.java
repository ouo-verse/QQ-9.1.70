package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.module.e;
import com.tencent.mobileqq.profilecard.base.utils.SpringPKReportUtil;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class ArkAppSpringPKModule extends b {
    public ArkAppSpringPKModule(ark.Application application, int i3) {
        super(application, i3);
    }

    private void p(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (variantWrapperArr != null && variantWrapperArr.length >= 4) {
            String GetString = variantWrapperArr[0].GetString();
            String GetString2 = variantWrapperArr[1].GetString();
            String GetString3 = variantWrapperArr[2].GetString();
            String GetString4 = variantWrapperArr[3].GetString();
            if ("imp".equals(GetString4)) {
                SpringPKReportUtil.pkArkImpReport(GetString, GetString2, GetString3);
            } else if ("click".equals(GetString4)) {
                SpringPKReportUtil.pkArkClickReport(GetString, GetString2, GetString3);
            }
        }
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        super.Destruct();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "QQMobilePkArk";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        return str.equals("PkArkReport");
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (str.equals("PkArkReport")) {
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
