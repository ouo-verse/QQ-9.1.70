package com.tencent.qzonehub.api.impl;

import android.content.Context;
import com.qzone.app.ImageEnvImpl;
import com.qzone.app.ImageLogger;
import com.qzone.app.j;
import com.qzone.reborn.runtime.QZoneRuntime;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneEnvApi;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QZoneEnvApiImpl implements IQZoneEnvApi {
    private static final String TAG = "QZoneEnvApiImpl";

    @Override // com.tencent.qzonehub.api.IQZoneEnvApi
    public boolean initImageEnv(Context context) {
        try {
            ImageManagerEnv.init(context.getApplicationContext(), new ImageEnvImpl(), new ImageLogger());
            if (!j.b()) {
                j.d();
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "initImageEnv error", th5);
            return false;
        }
    }

    @Override // com.tencent.qzonehub.api.IQZoneEnvApi
    public boolean isInQZoneEnv() {
        return QZoneRuntime.j().m();
    }

    @Override // com.tencent.qzonehub.api.IQZoneEnvApi
    public void onEnterQZoneEnv(boolean z16, boolean z17) {
        QZoneRuntime.j().o(z16, z17);
    }

    @Override // com.tencent.qzonehub.api.IQZoneEnvApi
    public void onLeaveQZoneEnv(boolean z16, boolean z17) {
        QZoneRuntime.j().p(z16, z17);
    }

    @Override // com.tencent.qzonehub.api.IQZoneEnvApi
    public void initImageEnv() {
        ImageManagerEnv.init(BaseApplication.getContext(), new ImageEnvImpl(), new ImageLogger());
    }
}
