package com.tencent.mobileqq.ark.api.impl;

import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.base.ArkAppCenter;
import com.tencent.mobileqq.ark.core.ArkMultiProc;
import com.tencent.mobileqq.ark.core.f;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkEnvironmentImpl implements IArkEnvironment {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConfigurationChanged$0() {
        if (ArkEnvironmentManager.getInstance().isLibraryLoad()) {
            com.tencent.mobileqq.ark.base.b.b(new Runnable() { // from class: com.tencent.mobileqq.ark.api.impl.ArkEnvironmentImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ark.Application.OnConfigurationChanged();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvironment
    public String getAppDebugInstallDirectory() {
        return h91.a.d().a();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvironment
    public String getRootDirectory() {
        return h91.a.d().g();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvironment
    public void initJSCLibPath() {
        f.h();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvironment
    public void initMultiProcEnv(IArkEnvDelegate iArkEnvDelegate, boolean z16) {
        ArkMultiProc.d(iArkEnvDelegate, z16);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvironment
    public boolean isDebugMode() {
        return r91.a.a();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvironment
    public boolean isJSCLibExist() {
        return f.k();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvironment
    public boolean isTestEnv() {
        if (h91.a.d().e() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvironment
    public void onConfigurationChanged() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ark.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                ArkEnvironmentImpl.this.lambda$onConfigurationChanged$0();
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvironment
    public void setDebugMode(boolean z16) {
        r91.a.b(z16);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvironment
    public void setScriptLeakCheckEnabled(boolean z16) {
        ArkAppCenter.g(z16);
    }
}
