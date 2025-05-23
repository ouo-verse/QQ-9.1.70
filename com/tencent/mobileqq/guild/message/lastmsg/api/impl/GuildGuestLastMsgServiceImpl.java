package com.tencent.mobileqq.guild.message.lastmsg.api.impl;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.message.lastmsg.GuildLastMsgItem;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildGuestLastMsgService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildGuestLastMsgServiceImpl extends Observable implements IGuildGuestLastMsgService {
    private static final int DELAY_TIMER = 1000;
    private static final int MESSAGE_TYPE_NOTIFY_UI = 11;
    private static final String TAG = "GuildGuestLastMsgServiceImpl";
    private volatile long lastNotifyTime = 0;
    private ConcurrentHashMap<String, GuildLastMsgItem> lastMsgItemMapForGuest = new ConcurrentHashMap<>();
    private final HashSet<com.tencent.mobileqq.guild.message.lastmsg.c> lazyNotifySet = new HashSet<>();
    private Handler mHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), new a());

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what == 11) {
                ArrayList arrayList = new ArrayList();
                synchronized (GuildGuestLastMsgServiceImpl.this.lazyNotifySet) {
                    arrayList.addAll(GuildGuestLastMsgServiceImpl.this.lazyNotifySet);
                    GuildGuestLastMsgServiceImpl.this.lazyNotifySet.clear();
                }
                GuildGuestLastMsgServiceImpl.this.setChanged();
                GuildGuestLastMsgServiceImpl.this.notifyObservers(arrayList);
                GuildGuestLastMsgServiceImpl.this.lastNotifyTime = System.currentTimeMillis();
                QLog.i(GuildGuestLastMsgServiceImpl.TAG, 1, "lazyNotifyLastMsgChange done. notifyEvents size: " + arrayList.size());
                return false;
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildGuestLastMsgService
    public GuildLastMsgItem getLastMsgItemForGuest(String str) {
        if (TextUtils.isEmpty(str)) {
            return new GuildLastMsgItem();
        }
        GuildLastMsgItem guildLastMsgItem = this.lastMsgItemMapForGuest.get(str);
        if (guildLastMsgItem != null) {
            return guildLastMsgItem.m192clone();
        }
        com.tencent.imcore.message.Message message = new com.tencent.imcore.message.Message();
        message.frienduin = str;
        message.istroop = 10014;
        GuildLastMsgItem guildLastMsgItem2 = new GuildLastMsgItem();
        guildLastMsgItem2.message = message;
        return guildLastMsgItem2;
    }

    public void lazyNotifyLastMsgChange(String str, GuildLastMsgItem guildLastMsgItem) {
        boolean add;
        if (guildLastMsgItem == null) {
            QLog.i(TAG, 1, "lazyNotifyLastMsgChange channelId:" + str + " msgItem:null");
            return;
        }
        com.tencent.mobileqq.guild.message.lastmsg.c cVar = new com.tencent.mobileqq.guild.message.lastmsg.c(str, true, false, 1, guildLastMsgItem.m192clone());
        synchronized (this.lazyNotifySet) {
            if (this.lazyNotifySet.contains(cVar)) {
                this.lazyNotifySet.remove(cVar);
            }
            add = this.lazyNotifySet.add(cVar);
        }
        if (!add) {
            QLog.e(TAG, 1, "lazyNotifyLastMsgChange FAIL! channelId: " + str + ", shmsgseq: " + guildLastMsgItem.message.shmsgseq + ", unreadCnt: " + guildLastMsgItem.msgCnt);
        }
        if (this.mHandler.hasMessages(11)) {
            return;
        }
        if (System.currentTimeMillis() - this.lastNotifyTime > 1000) {
            Message message = new Message();
            message.what = 11;
            this.mHandler.sendMessage(message);
        } else {
            Message message2 = new Message();
            message2.what = 11;
            this.mHandler.sendMessageDelayed(message2, 1000L);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildGuestLastMsgService
    public void updateLastMsgItemForGuest(String str, GuildLastMsgItem guildLastMsgItem) {
        if (!TextUtils.isEmpty(str) && guildLastMsgItem != null) {
            this.lastMsgItemMapForGuest.put(str, guildLastMsgItem);
            lazyNotifyLastMsgChange(str, guildLastMsgItem);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
