package com.tencent.mobileqq.guild.message.api.impl;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.t;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes14.dex */
public class GuildPullMultiMessageHandler extends BaseGuildMessageHandler implements st1.e {

    /* renamed from: d, reason: collision with root package name */
    private static final Map<Integer, ToServiceMsg> f230147d = new ConcurrentHashMap();

    protected GuildPullMultiMessageHandler(AppInterface appInterface) {
        super(appInterface);
    }

    @Override // st1.e
    public boolean V1(@NonNull String str, @NonNull String str2, long j3, long j16, @NonNull Bundle bundle) {
        return true;
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
        return t.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        f230147d.clear();
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
