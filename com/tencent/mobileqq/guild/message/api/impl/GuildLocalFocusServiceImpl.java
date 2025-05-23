package com.tencent.mobileqq.guild.message.api.impl;

import android.os.Looper;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLocalFocusServiceImpl implements IGuildLocalFocusService {
    private static final String TAG = "GuildLocalFocusServiceImpl";
    private AppRuntime app;
    private final CopyOnWriteArraySet<Observer> observers = new CopyOnWriteArraySet<>();
    protected Object lock = new Object();
    private boolean isAppOnForeground = true;
    private int selTab = 0;
    private a channelActiveStrategy = new a();
    private b guildActiveStrategy = new b();

    private void notifyObservers(final IGuildLocalFocusService.a aVar) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.app.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.GuildLocalFocusServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    for (Observer observer : (Observer[]) GuildLocalFocusServiceImpl.this.observers.toArray(new Observer[0])) {
                        observer.update(null, aVar);
                    }
                }
            });
            return;
        }
        for (Observer observer : (Observer[]) this.observers.toArray(new Observer[0])) {
            observer.update(null, aVar);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public void deleteObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public long getActiveChannelId() {
        long b16;
        synchronized (this.lock) {
            b16 = this.channelActiveStrategy.b();
        }
        return b16;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public com.tencent.mobileqq.guild.message.d getActiveGuild() {
        com.tencent.mobileqq.guild.message.d a16;
        synchronized (this.lock) {
            a16 = this.guildActiveStrategy.a();
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public long getActiveGuildId() {
        long b16;
        synchronized (this.lock) {
            b16 = this.guildActiveStrategy.b();
        }
        return b16;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public boolean getAppOnForeground() {
        boolean z16;
        synchronized (this.lock) {
            z16 = this.isAppOnForeground;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public int getSelTab() {
        int i3;
        synchronized (this.lock) {
            i3 = this.selTab;
        }
        return i3;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = appRuntime;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            this.isAppOnForeground = guardManager.isApplicationForeground();
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public void onTabChange(int i3) {
        boolean z16;
        synchronized (this.lock) {
            z16 = true;
            QLog.i(TAG, 1, "onTabChange selTab: " + i3);
            if (this.selTab != i3) {
                this.selTab = i3;
            } else {
                z16 = false;
            }
        }
        if (z16) {
            notifyObservers(new IGuildLocalFocusService.a(4, Integer.valueOf(getSelTab())));
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public void setActiveChannel(com.tencent.mobileqq.guild.message.d dVar) {
        boolean d16;
        synchronized (this.lock) {
            d16 = this.channelActiveStrategy.d(dVar);
        }
        if (d16) {
            notifyObservers(new IGuildLocalFocusService.a(1, Long.valueOf(getActiveChannelId())));
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public void setActiveGuild(com.tencent.mobileqq.guild.message.d dVar) {
        boolean d16;
        synchronized (this.lock) {
            d16 = this.guildActiveStrategy.d(dVar);
        }
        if (d16) {
            notifyObservers(new IGuildLocalFocusService.a(2, Long.valueOf(getActiveGuildId())));
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService
    public void setAppForeground(boolean z16) {
        boolean z17;
        synchronized (this.lock) {
            z17 = true;
            QLog.i(TAG, 1, "setAppForeground isAppOnForeground: " + z16);
            if (this.isAppOnForeground != z16) {
                this.isAppOnForeground = z16;
            } else {
                z17 = false;
            }
        }
        if (z17) {
            notifyObservers(new IGuildLocalFocusService.a(3, Boolean.valueOf(getAppOnForeground())));
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
