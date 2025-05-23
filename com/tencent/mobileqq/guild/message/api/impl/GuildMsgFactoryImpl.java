package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.aa;
import com.tencent.mobileqq.guild.message.ab;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.base.s;
import com.tencent.mobileqq.guild.message.l;
import com.tencent.mobileqq.guild.message.q;
import com.tencent.mobileqq.guild.message.x;
import com.tencent.mobileqq.guild.message.y;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMsgFactoryImpl implements IGuildMsgFactory {
    private AppRuntime app;
    protected Map<Integer, s> processorMap = new ConcurrentHashMap();
    private l msgCache = new l();

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgFactory
    public s getMessageProcessor(int i3) {
        s sVar;
        if (!this.processorMap.containsKey(Integer.valueOf(i3))) {
            synchronized (this.processorMap) {
                if (!this.processorMap.containsKey(Integer.valueOf(i3))) {
                    if (i3 == 0) {
                        sVar = new y((AppInterface) this.app);
                    } else if (2 == i3) {
                        sVar = new com.tencent.mobileqq.guild.message.s((AppInterface) this.app);
                    } else if (3 == i3) {
                        sVar = new ab((AppInterface) this.app);
                    } else if (4 == i3) {
                        sVar = new com.tencent.mobileqq.guild.message.i((AppInterface) this.app);
                    } else if (5 == i3) {
                        sVar = new x((AppInterface) this.app);
                    } else if (6 == i3) {
                        sVar = new com.tencent.mobileqq.guild.message.e((AppInterface) this.app);
                    } else if (7 == i3) {
                        sVar = new aa((AppInterface) this.app);
                    } else if (8 == i3) {
                        sVar = new q((AppInterface) this.app);
                    } else {
                        sVar = null;
                    }
                    if (sVar == null) {
                        return null;
                    }
                    this.processorMap.put(Integer.valueOf(i3), sVar);
                }
            }
        }
        return this.processorMap.get(Integer.valueOf(i3));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.msgCache.i();
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgFactory
    public l getMsgCache() {
        return this.msgCache;
    }
}
