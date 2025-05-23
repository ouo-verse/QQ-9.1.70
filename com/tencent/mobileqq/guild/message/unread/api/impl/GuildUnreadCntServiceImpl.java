package com.tencent.mobileqq.guild.message.unread.api.impl;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildUnreadCntServiceImpl implements IGuildUnreadCntService {
    private final CopyOnWriteArraySet<Observer> mDelayObservers = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<Observer> mImmediateObservers = new CopyOnWriteArraySet<>();

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService
    public void addImmediateObserver(Observer observer) {
        this.mImmediateObservers.add(observer);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService
    public void addObserver(Observer observer) {
        this.mDelayObservers.add(observer);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService
    public synchronized void deleteObserver(Observer observer) {
        this.mDelayObservers.remove(observer);
        this.mImmediateObservers.remove(observer);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService
    public IGuildUnreadCntService.b getChannelUnreadCnt(String str, int i3) {
        return new IGuildUnreadCntService.b();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
