package com.tencent.mobileqq.settings.business.api.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.newsetting.custom.group.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.business.api.IGrowthPushSwitchApi;
import com.tencent.mobileqq.settings.business.b;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/settings/business/api/impl/GrowthPushSwitchApiImpl;", "Lcom/tencent/mobileqq/settings/business/api/IGrowthPushSwitchApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/activity/newsetting/custom/group/a;", "createSettingGroup", "", "isContrastGroup", "", "reportTabExposure", "isForceEnabled", NodeProps.ENABLED, "setForceEnabled", "forceEnabled", "Z", "report_exp_exposure$delegate", "Lkotlin/Lazy;", "getReport_exp_exposure", "()Z", "report_exp_exposure", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class GrowthPushSwitchApiImpl implements IGrowthPushSwitchApi {
    private static final String TAG = "GrowthPushSwitch.Api";
    private boolean forceEnabled;

    /* renamed from: report_exp_exposure$delegate, reason: from kotlin metadata */
    private final Lazy report_exp_exposure;

    public GrowthPushSwitchApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.settings.business.api.impl.GrowthPushSwitchApiImpl$report_exp_exposure$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("growth_push_report_exp_exposure_9090", true));
            }
        });
        this.report_exp_exposure = lazy;
    }

    private final boolean getReport_exp_exposure() {
        return ((Boolean) this.report_exp_exposure.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.settings.business.api.IGrowthPushSwitchApi
    public a createSettingGroup(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new b(context);
    }

    @Override // com.tencent.mobileqq.settings.business.api.IGrowthPushSwitchApi
    public boolean isContrastGroup() {
        if (this.forceEnabled) {
            return false;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_msg_push_switch_public");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026s.ABTEST_EXPERIMENT_NAME)");
        QLog.i(TAG, 1, "[isContrastGroup] isContrastGroup: " + (!expEntity.isExperiment()));
        return !expEntity.isExperiment();
    }

    @Override // com.tencent.mobileqq.settings.business.api.IGrowthPushSwitchApi
    /* renamed from: isForceEnabled, reason: from getter */
    public boolean getForceEnabled() {
        return this.forceEnabled;
    }

    @Override // com.tencent.mobileqq.settings.business.api.IGrowthPushSwitchApi
    public void reportTabExposure() {
        if (getReport_exp_exposure()) {
            try {
                ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_msg_push_switch_public");
                Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026s.ABTEST_EXPERIMENT_NAME)");
                expEntity.reportExpExposure();
            } catch (Exception e16) {
                QLog.w(TAG, 1, "[reportExperiment] error=" + e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.settings.business.api.IGrowthPushSwitchApi
    public void setForceEnabled(boolean enabled) {
        this.forceEnabled = enabled;
    }
}
