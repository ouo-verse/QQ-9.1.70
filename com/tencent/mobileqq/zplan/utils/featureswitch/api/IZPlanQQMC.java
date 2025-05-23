package com.tencent.mobileqq.zplan.utils.featureswitch.api;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk3.CoupleAvatarDestroyConfig;
import wk3.ZPlanCoupleAvatarSwitchConfig;
import wk3.f;
import wk3.g;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J5\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0005\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0002H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0004H&J\b\u0010\u0015\u001a\u00020\u0004H&J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001a\u001a\u00020\u0004H&J\b\u0010\u001b\u001a\u00020\u0004H&J\b\u0010\u001c\u001a\u00020\u0004H&J\b\u0010\u001d\u001a\u00020\u0004H&J\b\u0010\u001e\u001a\u00020\u0004H&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/featureswitch/api/IZPlanQQMC;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", VipFunCallConstants.KEY_GROUP, "", AdMetricTag.FALLBACK, "isSwitchOn", "T", "groupId", "Ljava/lang/Class;", "configClass", "getConfig", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "enableFilamentPortalSecondLoading", "enableZPlanEmoticonDetail", "Lwk3/f;", "getZPlanEmoticonDetailConfig", "getZPlanEmoticonCreateRoleScheme", "Lwk3/g;", "getZPlanEmoticonGrayTipsConfig", "enableMemeResetPriority", "enableSendMsgIntentOnPartResume", "Lwk3/d;", "getCoupleAvatarSwitchConfig", "Lwk3/a;", "getCoupleAvatarDestroyConfig", "enableAvatarTimeCostOptimization", "enableMiniHomeEdit", "enableZPlanFold", "enableZPlanFilamentNewPortal", "enableLocalShaderBinary", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanQQMC extends QRouteApi {
    boolean enableAvatarTimeCostOptimization();

    boolean enableFilamentPortalSecondLoading();

    boolean enableLocalShaderBinary();

    boolean enableMemeResetPriority();

    boolean enableMiniHomeEdit();

    boolean enableSendMsgIntentOnPartResume();

    boolean enableZPlanEmoticonDetail();

    boolean enableZPlanFilamentNewPortal();

    boolean enableZPlanFold();

    @Nullable
    <T> T getConfig(@NotNull String groupId, @NotNull Class<T> configClass, @NotNull String fallback);

    @NotNull
    CoupleAvatarDestroyConfig getCoupleAvatarDestroyConfig();

    @NotNull
    ZPlanCoupleAvatarSwitchConfig getCoupleAvatarSwitchConfig();

    @NotNull
    String getZPlanEmoticonCreateRoleScheme();

    @NotNull
    f getZPlanEmoticonDetailConfig();

    @NotNull
    g getZPlanEmoticonGrayTipsConfig();

    boolean isSwitchOn(@NotNull String group, boolean fallback);
}
