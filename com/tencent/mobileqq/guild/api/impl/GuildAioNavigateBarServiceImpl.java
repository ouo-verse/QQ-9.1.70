package com.tencent.mobileqq.guild.api.impl;

import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.guild.api.IGuildAioNavigateBarService;
import com.tencent.mobileqq.guild.navigatebar.GuildAioNavigateBarManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildAioNavigateBarServiceImpl implements IGuildAioNavigateBarService {
    private static final String TAG = "GuildAio.NavigateBar.Service.Impl";
    private AppRuntime app;

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = appRuntime;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAioNavigateBarService
    public void removeGuildMsgNavigateInfo(String str, long j3) {
        QLog.i(TAG, 1, "GuildAioNavigateBarServiceImpl, channelId = " + str + ", msgSeq = " + j3);
        GuildAioNavigateBarManager guildAioNavigateBarManager = (GuildAioNavigateBarManager) this.app.getManager(QQManagerFactory.GUILD_AIO_NAVIGATE_BAR);
        boolean s16 = guildAioNavigateBarManager != null ? guildAioNavigateBarManager.s(str, j3) : false;
        MqqHandler handler = ((AppInterface) this.app).getHandler(ChatActivity.class);
        if (!s16 || handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(102);
        Bundle bundle = new Bundle();
        bundle.putString("channelId", str);
        bundle.putLong("revokeMsgSeq", j3);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
