package com.tencent.mobileqq.zplan.utils.featureswitch.api.impl;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wk3.CoupleAvatarDestroyConfig;
import wk3.ZPlanCoupleAvatarSwitchConfig;
import wk3.f;
import wk3.g;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0004\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0001J\t\u0010\b\u001a\u00020\u0002H\u0096\u0001J\t\u0010\t\u001a\u00020\u0002H\u0096\u0001J\t\u0010\n\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u0096\u0001J6\u0010\u0012\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0015\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u0018\u001a\u00020\rH\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u001bH\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0096\u0001\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/featureswitch/api/impl/ZPlanQQMCImpl;", "Lcom/tencent/mobileqq/zplan/utils/featureswitch/api/IZPlanQQMC;", "", "enableAvatarTimeCostOptimization", "enableFilamentPortalSecondLoading", "enableLocalShaderBinary", "enableMemeResetPriority", "enableMiniHomeEdit", "enableSendMsgIntentOnPartResume", "enableZPlanEmoticonDetail", "enableZPlanFilamentNewPortal", "enableZPlanFold", "T", "", "groupId", "Ljava/lang/Class;", "configClass", AdMetricTag.FALLBACK, "getConfig", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "Lwk3/a;", "getCoupleAvatarDestroyConfig", "Lwk3/d;", "getCoupleAvatarSwitchConfig", "getZPlanEmoticonCreateRoleScheme", "Lwk3/f;", "getZPlanEmoticonDetailConfig", "Lwk3/g;", "getZPlanEmoticonGrayTipsConfig", VipFunCallConstants.KEY_GROUP, "isSwitchOn", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanQQMCImpl implements IZPlanQQMC {
    private final /* synthetic */ ZPlanQQMC $$delegate_0 = ZPlanQQMC.INSTANCE;

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableAvatarTimeCostOptimization() {
        return this.$$delegate_0.enableAvatarTimeCostOptimization();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableFilamentPortalSecondLoading() {
        return this.$$delegate_0.enableFilamentPortalSecondLoading();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableLocalShaderBinary() {
        return this.$$delegate_0.enableLocalShaderBinary();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableMemeResetPriority() {
        return this.$$delegate_0.enableMemeResetPriority();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableMiniHomeEdit() {
        return this.$$delegate_0.enableMiniHomeEdit();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableSendMsgIntentOnPartResume() {
        return this.$$delegate_0.enableSendMsgIntentOnPartResume();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableZPlanEmoticonDetail() {
        return this.$$delegate_0.enableZPlanEmoticonDetail();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableZPlanFilamentNewPortal() {
        return this.$$delegate_0.enableZPlanFilamentNewPortal();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableZPlanFold() {
        return this.$$delegate_0.enableZPlanFold();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public <T> T getConfig(String groupId, Class<T> configClass, String fallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(configClass, "configClass");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        return (T) this.$$delegate_0.getConfig(groupId, configClass, fallback);
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public CoupleAvatarDestroyConfig getCoupleAvatarDestroyConfig() {
        return this.$$delegate_0.getCoupleAvatarDestroyConfig();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public ZPlanCoupleAvatarSwitchConfig getCoupleAvatarSwitchConfig() {
        return this.$$delegate_0.getCoupleAvatarSwitchConfig();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public String getZPlanEmoticonCreateRoleScheme() {
        return this.$$delegate_0.getZPlanEmoticonCreateRoleScheme();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public f getZPlanEmoticonDetailConfig() {
        return this.$$delegate_0.getZPlanEmoticonDetailConfig();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public g getZPlanEmoticonGrayTipsConfig() {
        return this.$$delegate_0.getZPlanEmoticonGrayTipsConfig();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean isSwitchOn(String group, boolean fallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        return this.$$delegate_0.isSwitchOn(group, fallback);
    }
}
