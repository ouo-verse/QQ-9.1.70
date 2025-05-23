package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.message.api.IGuildDispersionRoamMsgService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildDispersionRoamMsgServiceImpl implements IGuildDispersionRoamMsgService {
    private static final int MAX_GET_COUNT = 40;
    private static final String TAG = "GuildDispersionRoamMsgServiceImpl";
    private AppRuntime mAppRuntime;

    @Override // com.tencent.mobileqq.guild.message.api.IGuildDispersionRoamMsgService
    public boolean getDispersionRoamMsg(String str, String str2, List<Long> list, st1.a aVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && aVar != null) {
            if (!list.isEmpty() && list.size() <= 40) {
                QLog.i(TAG, 1, "getDispersionRoamMsg run! guildId = " + str + " channelId = " + str2 + " size = " + list.size());
                new tt1.a(this.mAppRuntime, str, str2, list, aVar).l();
                return true;
            }
            QLog.i(TAG, 1, "getDispersionRoamMsg count error! size = " + list.size());
            return false;
        }
        QLog.i(TAG, 1, "getDispersionRoamMsg args error!");
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mAppRuntime = appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
