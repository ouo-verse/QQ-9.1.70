package com.tencent.mobileqq.guild.recent.service.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentChangedService;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentMsgService;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentNotifyService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ChannelRecentNotifyServiceImpl implements IChannelRecentNotifyService {
    private static final int REFRESH_INTERVAL_TIME = 1500;
    private static final String TAG = "ChannelRecentNotifyServiceImpl";
    private boolean mIsReadyToRefreshForLastMsgChanged = false;
    private pw1.a mRecentChannelObserver;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.recent.service.impl.ChannelRecentNotifyServiceImpl$3, reason: invalid class name */
    /* loaded from: classes14.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ChannelRecentNotifyServiceImpl this$0;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ChannelRecentNotifyServiceImpl.a(this.this$0);
                this.this$0.mIsReadyToRefreshForLastMsgChanged = false;
            }
        }
    }

    static /* bridge */ /* synthetic */ pw1.a a(ChannelRecentNotifyServiceImpl channelRecentNotifyServiceImpl) {
        channelRecentNotifyServiceImpl.getClass();
        return null;
    }

    private void handleRefreshRecentListFull() {
        QLog.d(TAG, 1, "handleRefreshRecentListFull");
        throw null;
    }

    private void handleRefreshRecentListSingleItem(Bundle bundle) {
        String string = bundle.getString("channelId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        QLog.d(TAG, 1, "handleRefreshRecentListSingleItem channelId = " + string);
        throw null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(final AppRuntime appRuntime) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.recent.service.impl.ChannelRecentNotifyServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                appRuntime.getRuntimeService(IChannelRecentChangedService.class, "");
                appRuntime.getRuntimeService(IChannelRecentMsgService.class, "");
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentNotifyService
    public void refreshRecentList(final int i3, final Bundle bundle) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.recent.service.impl.ChannelRecentNotifyServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    ChannelRecentNotifyServiceImpl.a(ChannelRecentNotifyServiceImpl.this);
                    QLog.d(ChannelRecentNotifyServiceImpl.TAG, 1, "mRecentChannelObserver null");
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentNotifyService
    public synchronized void refreshRecentListForLastMsgChanged(LastMessage lastMessage) {
        QLog.d(TAG, 1, "mRecentChannelObserver || lastMessage null");
    }

    @Override // com.tencent.mobileqq.guild.recent.service.IChannelRecentNotifyService
    public synchronized void setRecentChannelObserver(pw1.a aVar) {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
