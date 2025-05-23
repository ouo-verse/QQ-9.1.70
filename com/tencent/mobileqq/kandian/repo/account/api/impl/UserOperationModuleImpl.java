package com.tencent.mobileqq.kandian.repo.account.api.impl;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import java.util.List;
import kotlin.Metadata;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0096\u0001J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0096\u0001\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/kandian/repo/account/api/impl/UserOperationModuleImpl;", "Lcom/tencent/mobileqq/kandian/repo/account/api/IUserOperationModule;", "()V", "request0x80aPushEffectEvent", "", "eventId", "", AdMetricTag.EVENT_NAME, "", "version", "attris", "", "Ltencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList;", "cmd", "command", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class UserOperationModuleImpl implements IUserOperationModule {
    private final /* synthetic */ UserOperationModule $$delegate_0 = UserOperationModule.getInstance();

    @Override // com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule
    public void request0x80aPushEffectEvent(int eventId, String eventName, int version, List<oidb_cmd0x80a.AttributeList> attris, String cmd, int command) {
        this.$$delegate_0.request0x80aPushEffectEvent(eventId, eventName, version, attris, cmd, command);
    }

    @Override // com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule
    public void request0x80aPushEffectEvent(int eventId, String eventName, List<oidb_cmd0x80a.AttributeList> attris) {
        this.$$delegate_0.request0x80aPushEffectEvent(eventId, eventName, attris);
    }
}
