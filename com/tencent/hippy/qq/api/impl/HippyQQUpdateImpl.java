package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippyQQUpdate;
import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.hippy.qq.update.HippyQQUpdateManager;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQUpdateImpl implements IHippyQQUpdate {
    @Override // com.tencent.hippy.qq.api.IHippyQQUpdate
    public void checkUpdate(String str, PackageUpdateListener packageUpdateListener) {
        new HippyQQUpdateManager().checkUpdate(str, packageUpdateListener);
    }

    @Override // com.tencent.hippy.qq.api.IHippyQQUpdate
    public void loadOnlineBundle(String str, String str2, PackageUpdateListener packageUpdateListener) {
        new HippyQQUpdateManager().loadOnlineBundle(str, str2, packageUpdateListener);
    }
}
