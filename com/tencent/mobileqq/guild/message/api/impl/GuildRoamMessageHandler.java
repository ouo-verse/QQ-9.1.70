package com.tencent.mobileqq.guild.message.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.message.api.IGuildRoamMessageHandler;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.n;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRoamMessageHandler extends BaseGuildMessageHandler implements IGuildRoamMessageHandler {
    public static final int PULLROAMMSG_COMMON = 1;
    public static final int PULLROAMMSG_EVENTFLOW = 2;
    public static final String TAG = "BaseGuildMessageHandler.GuildRoamMessageHandler";
    private volatile boolean isDestroyed;
    private ConcurrentHashMap<Long, ut1.a> logicMaps;
    IMessageFacade messageFacade;
    private AtomicLong pullSeq;

    protected GuildRoamMessageHandler(AppInterface appInterface) {
        super(appInterface);
        this.isDestroyed = false;
        this.logicMaps = new ConcurrentHashMap<>();
        this.pullSeq = new AtomicLong(1L);
        this.messageFacade = (IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "");
    }

    private ut1.a createPullRoamMsgLogicByType(int i3) {
        if (i3 == 1) {
            return new ut1.b(this.appRuntime, this);
        }
        if (i3 == 2) {
            return new ut1.c(this.appRuntime, this);
        }
        return null;
    }

    private ut1.a getPullRoamMsgLogic(ToServiceMsg toServiceMsg) {
        return this.logicMaps.get(Long.valueOf(toServiceMsg.extraData.getBundle("context").getLong("pullSeq")));
    }

    private int getPullRoamMsgType(Bundle bundle) {
        if (bundle == null || !bundle.getBoolean("pull_roammsg_from_eventflow", false)) {
            return 1;
        }
        return 2;
    }

    private boolean onReceiveFailed(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str) {
        return false;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            this.allowCmdSet = new HashSet();
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return n.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        super.onDestroy();
        this.isDestroyed = true;
    }

    public void removePullRoamMsgLogic(ToServiceMsg toServiceMsg) {
        long j3 = toServiceMsg.extraData.getBundle("context").getLong("pullSeq");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "removePullRoamMsgLogic pullSeq:" + j3);
        }
        this.logicMaps.remove(Long.valueOf(j3));
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildRoamMessageHandler
    public boolean reqPullRoamMsg(String str, long j3, long j16, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (bundle2.getLong("pullSeq", -1L) == -1) {
            bundle2.putLong("pullSeq", this.pullSeq.incrementAndGet());
        }
        long j17 = bundle2.getLong("pullSeq");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "reqPullRoamMsg pullSeq:" + j17);
        }
        return getPullRoamMsgLogic(bundle2).b(str, j3, j16, bundle2);
    }

    private ut1.a getPullRoamMsgLogic(Bundle bundle) {
        long j3 = bundle.getLong("pullSeq");
        if (!this.logicMaps.containsKey(Long.valueOf(j3))) {
            this.logicMaps.put(Long.valueOf(j3), createPullRoamMsgLogicByType(getPullRoamMsgType(bundle)));
        }
        return this.logicMaps.get(Long.valueOf(j3));
    }

    private void onReceiveReqPullRoamMsg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }

    private void onReceiveSuccess(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, String str) {
    }
}
