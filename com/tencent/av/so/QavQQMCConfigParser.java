package com.tencent.av.so;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes3.dex */
public class QavQQMCConfigParser extends BaseConfigParser<a> {

    /* loaded from: classes3.dex */
    public static class a implements IConfigData {
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(a aVar) {
        QLog.i("QavQQMCConfigParser", 1, "doOnConfigUpdate");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("QavQQMCConfigParser", 1, "doOnConfigUpdate, appRuntime null");
            return;
        }
        MobileQQ application = peekAppRuntime.getApplication();
        if (application == null) {
            QLog.i("QavQQMCConfigParser", 1, "doOnConfigUpdate, app null");
            return;
        }
        Intent intent = new Intent("ACTION_QAV_RES_NEW_CONFIG_NOTIFY");
        intent.setPackage(application.getPackageName());
        application.sendBroadcast(intent);
        ArrayList<ResInfo> y16 = ResMgr.y(true);
        for (int i3 = 0; i3 < y16.size(); i3++) {
            ResInfo resInfo = y16.get(i3);
            if (resInfo.isAutoDownload) {
                if (!ResMgr.d(ResMgr.s(resInfo) + resInfo.resFileName, resInfo.resMd5)) {
                    ResMgr.q().B(resInfo.resId);
                }
            }
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        return new a();
    }
}
