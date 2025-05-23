package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.api.module.method.MethodViewMultiMsg;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.module.e;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class ArkAppQQMsgModule extends b {
    public ArkAppQQMsgModule(ark.Application application, int i3) {
        super(application, i3);
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        super.Destruct();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "QQMsg";
    }

    @Override // com.tencent.mobileqq.ark.module.b
    protected e[] e() {
        return new e[]{new MethodViewMultiMsg()};
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
