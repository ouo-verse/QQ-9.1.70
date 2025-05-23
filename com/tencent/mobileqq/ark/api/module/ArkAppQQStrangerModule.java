package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.module.e;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.utils.f;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class ArkAppQQStrangerModule extends b {
    public ArkAppQQStrangerModule(ark.Application application, int i3) {
        super(application, i3);
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        super.Destruct();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "QQStranger";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        return str.equals("GetDarkModeToggle");
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (str.equals("GetDarkModeToggle")) {
            variantWrapper.SetBool(f.b());
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ark.qqstranger.module", 1, "Invoke method is error!");
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
