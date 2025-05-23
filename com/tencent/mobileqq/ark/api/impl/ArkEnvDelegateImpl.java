package com.tencent.mobileqq.ark.api.impl;

import android.util.DisplayMetrics;
import com.tencent.ark.aio.BaseArkAppContainer;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkSoPreLoader;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkEnvDelegateImpl implements IArkEnvDelegate {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyJscLoaded$0() {
        com.tencent.mobileqq.activity.aio.item.b.doArkAppEvent(3);
        BaseArkAppContainer.doArkAppEvent(3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvDelegate
    public String getAppConfigForCurrentTheme() {
        return f.b();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvDelegate
    public float getDisplayDensity() {
        return f.c();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvDelegate
    public DisplayMetrics getDisplayMetrics() {
        return f.f199489i;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvDelegate
    public String getLibJSCPath() {
        return ((IArkSoPreLoader) QRoute.api(IArkSoPreLoader.class)).getLibJscPath();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvDelegate
    public void notifyJscLoaded() {
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToLogicThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                ArkEnvDelegateImpl.lambda$notifyJscLoaded$0();
            }
        });
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvDelegate
    public boolean shouldCheckURLDomain() {
        return !f.e();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkEnvDelegate
    public void stopArkSilkAudio() {
        com.tencent.mobileqq.ark.api.silk.a.c();
    }
}
