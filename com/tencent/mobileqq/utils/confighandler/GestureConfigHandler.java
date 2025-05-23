package com.tencent.mobileqq.utils.confighandler;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.gesture.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public class GestureConfigHandler extends ConfigHandler<DownloadInfo> {
    public GestureConfigHandler() {
        super("QavGesture", null);
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
    public int getConfigVer() {
        return ConfigHandler.getConfigVer(getSP(), DownloadInfo.spKey_Config, "ver");
    }

    public SharedPreferences getSP() {
        return DownloadInfo.getSP();
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
    public void saveConfig(String str, int i3) {
        SharedPreferences sp5 = getSP();
        if (TextUtils.isEmpty(str)) {
            sp5.edit().remove(DownloadInfo.spKey_Config);
        } else {
            sp5.edit().putString(DownloadInfo.spKey_Config, str);
        }
        sp5.edit().putInt("ver", i3);
        sp5.edit().commit();
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
    public void onGetConfigFinish(QQAppInterface qQAppInterface, String str, DownloadInfo downloadInfo) {
        b.b(qQAppInterface, str, downloadInfo);
    }
}
