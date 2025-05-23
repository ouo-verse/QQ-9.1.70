package com.tencent.mobileqq.zplan.utils.featureswitch.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020#H\u0016J\b\u0010*\u001a\u00020\u0019H\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020&H\u0016J\b\u0010/\u001a\u00020\u0019H\u0016J\b\u00100\u001a\u00020\u0019H\u0016J\b\u00101\u001a\u00020\u0019H\u0016J\b\u00102\u001a\u00020\u0019H\u0016J\b\u00103\u001a\u00020\u0019H\u0016J\b\u00104\u001a\u00020#H\u0016J\b\u00105\u001a\u00020#H\u0016J\b\u00106\u001a\u00020#H\u0016J\u0010\u00107\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u000108H\u0016J\b\u00109\u001a\u00020#H\u0016J\b\u0010:\u001a\u00020\u0019H\u0016J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190<H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\u0019H\u0016J\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0019H\u0016J\b\u0010B\u001a\u00020\u0019H\u0016J\b\u0010C\u001a\u00020\u0019H\u0016J\b\u0010D\u001a\u00020\u0019H\u0016J\b\u0010E\u001a\u00020\u0004H\u0016J\b\u0010F\u001a\u00020\u0004H\u0016J\b\u0010G\u001a\u00020\u0004H\u0016J\b\u0010H\u001a\u00020\u0004H\u0016J\b\u0010I\u001a\u00020\u0004H\u0016J\b\u0010J\u001a\u00020\u0004H\u0016J\b\u0010K\u001a\u00020\u0004H\u0016J\b\u0010L\u001a\u00020\u0004H\u0016\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/featureswitch/api/impl/ZPlanFeatureSwitchHelperImpl;", "Lcom/tencent/mobileqq/zplan/utils/featureswitch/api/IZPlanFeatureSwitchHelper;", "()V", "disableCMShowRequest", "", "disableCm", "enableAvatarDressShare", "enableCmShowGameMiniApiUsgReduce", "enableEmotionRecordOptimization", "enableFilamentUseSomanager", "enableGLSurfaceTypeConfigure", "enableGuestZplanAvatarEntrance", "enableMemeRecordOnGenderChanged", "enablePreloadWorld", "enableQzoneConsiseDynamicAvatar", "enableQzoneRecordLoadingAnim", "enableRecordInNewObject", "enableReportDynamicAvatarToDaTong", "enableReportEasterEgg", "enableReportZPlanAvatar", "enableUploadUnRecordZPlanAvatar", "enableV2ShpImageCache", "enableZPlanAIOMakeGifEntrance", "enableZPlanApngAvatar", "enableZPlanEasterEgg", "", "enableZPlanFilamentStaticImageview", "enableZPlanGifText", "enableZPlanModDiffUpdate", "getAIOFrameAnimBubbleText", "getAIOFrameAnimConfig", "getActionSheetGoPortalString", "getActionSheetGoSmallHomeString", "getAvatarDressShareType", "getCMShowMemeActionMaximumFrameCount", "", "getDynamicAvatarRecordRepeatTime", "getEasterEggPlayTimeOutGap", "", "getEasterEggShowAvatarAnimateDuration", "getHomePageTabConfigV2", "getMemeCoverMaximumFrameCount", "getNewerGuideCmShowAvatarEntranceLink", "getNewerGuideCmShowAvatarEntranceName", "getNewerGuideZplanCmShowAvatarEntranceLink", "getOfficialAppearanceKey", "getOfficialAppearanceKeyTimeStamp", "getQzoneConsiseDynamicAvatarConfig", "getQzoneConsiseDynamicRecordConfig", "getSettingEntranceDesc", "getUploadUnRecordZPlanAvatarHint", "getZPlanAvatarBackgroundColor", "getZPlanAvatarFrameRate", "getZPlanEasterEggSupportVersion", "getZPlanOffscreenHeight", "getZPlanPagSoDecoderPhoneList", "", "getZPlanPortalTabDoubleClickRefreshLimitSeconds", "getZPlanQZoneAvatarPlayStrategy", "getZPlanUeEnvConfig", "", "getZootopiaBackConfig", "Lorg/json/JSONObject;", "getZplanSettingCDKeyUrl", "getZplanSettingFeedbackName", "getZplanSettingFeedbackUrl", "getZplanSettingQzoneSwitchDesc", "getZplanSettingQzoneSwitchName", "getZplanSettingTitle", "isAioEntranceBtnShow", "isCmShowKeywordAssociationEnabled", "isCmShowMemeTabInFaceDisabled", "isMemoryThresholdEnableDynamicAvatar", "isNewerGuideCmShowAvatarEntranceShow", "isPreloadEnable", "killZplanWhenPortalExit", "needOutBoundAvatar2EasterEgg", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanFeatureSwitchHelperImpl implements IZPlanFeatureSwitchHelper {
    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean disableCMShowRequest() {
        return ZPlanFeatureSwitch.f369852a.e();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean disableCm() {
        return ZPlanFeatureSwitch.f369852a.f();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableAvatarDressShare() {
        return ZPlanFeatureSwitch.f369852a.l();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableCmShowGameMiniApiUsgReduce() {
        return ZPlanFeatureSwitch.f369852a.o();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableEmotionRecordOptimization() {
        return ZPlanFeatureSwitch.f369852a.w();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableFilamentUseSomanager() {
        return ZPlanFeatureSwitch.f369852a.y();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableGLSurfaceTypeConfigure() {
        return ZPlanFeatureSwitch.f369852a.z();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableGuestZplanAvatarEntrance() {
        return ZPlanFeatureSwitch.f369852a.D();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableMemeRecordOnGenderChanged() {
        return ZPlanFeatureSwitch.f369852a.H();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enablePreloadWorld() {
        return ZPlanFeatureSwitch.f369852a.O();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableQzoneConsiseDynamicAvatar() {
        return ZPlanFeatureSwitch.f369852a.P();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableQzoneRecordLoadingAnim() {
        return ZPlanFeatureSwitch.f369852a.Q();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableRecordInNewObject() {
        return ZPlanFeatureSwitch.f369852a.R();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableReportDynamicAvatarToDaTong() {
        return ZPlanFeatureSwitch.f369852a.W();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableReportEasterEgg() {
        return ZPlanFeatureSwitch.f369852a.X();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableReportZPlanAvatar() {
        return ZPlanFeatureSwitch.f369852a.Y();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableUploadUnRecordZPlanAvatar() {
        return ZPlanFeatureSwitch.f369852a.c0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableV2ShpImageCache() {
        return ZPlanFeatureSwitch.f369852a.e0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableZPlanAIOMakeGifEntrance() {
        return ZPlanFeatureSwitch.f369852a.i();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableZPlanApngAvatar() {
        return ZPlanFeatureSwitch.f369852a.h0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String enableZPlanEasterEgg() {
        return ZPlanFeatureSwitch.f369852a.o0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableZPlanFilamentStaticImageview() {
        return ZPlanFeatureSwitch.f369852a.A0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableZPlanGifText() {
        return ZPlanFeatureSwitch.f369852a.f0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean enableZPlanModDiffUpdate() {
        return ZPlanFeatureSwitch.f369852a.B0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getAIOFrameAnimBubbleText() {
        return ZPlanFeatureSwitch.f369852a.H0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getAIOFrameAnimConfig() {
        return ZPlanFeatureSwitch.f369852a.I0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getActionSheetGoPortalString() {
        return ZPlanFeatureSwitch.f369852a.J0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getActionSheetGoSmallHomeString() {
        return ZPlanFeatureSwitch.f369852a.K0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getAvatarDressShareType() {
        return ZPlanFeatureSwitch.f369852a.P0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public int getCMShowMemeActionMaximumFrameCount() {
        return ZPlanFeatureSwitch.f369852a.S0();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public int getDynamicAvatarRecordRepeatTime() {
        return ZPlanFeatureSwitch.f369852a.f1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public long getEasterEggPlayTimeOutGap() {
        return ZPlanFeatureSwitch.f369852a.g1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public long getEasterEggShowAvatarAnimateDuration() {
        return ZPlanFeatureSwitch.f369852a.k1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getHomePageTabConfigV2() {
        return ZPlanFeatureSwitch.f369852a.n1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public int getMemeCoverMaximumFrameCount() {
        return ZPlanFeatureSwitch.f369852a.s1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getNewerGuideCmShowAvatarEntranceLink() {
        return ZPlanFeatureSwitch.f369852a.z1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getNewerGuideCmShowAvatarEntranceName() {
        return ZPlanFeatureSwitch.f369852a.A1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getNewerGuideZplanCmShowAvatarEntranceLink() {
        return ZPlanFeatureSwitch.f369852a.B1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getOfficialAppearanceKey() {
        return ZPlanFeatureSwitch.f369852a.C1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public long getOfficialAppearanceKeyTimeStamp() {
        return ZPlanFeatureSwitch.f369852a.D1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getQzoneConsiseDynamicAvatarConfig() {
        return ZPlanFeatureSwitch.f369852a.G1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getQzoneConsiseDynamicRecordConfig() {
        return ZPlanFeatureSwitch.f369852a.H1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getSettingEntranceDesc() {
        return ZPlanFeatureSwitch.f369852a.S1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getUploadUnRecordZPlanAvatarHint() {
        return ZPlanFeatureSwitch.f369852a.W1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getZPlanAvatarBackgroundColor() {
        return ZPlanFeatureSwitch.f369852a.X1();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public int getZPlanAvatarFrameRate() {
        return ZPlanFeatureSwitch.f369852a.d2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public int getZPlanEasterEggSupportVersion() {
        return ZPlanFeatureSwitch.f369852a.q2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public int getZPlanOffscreenHeight() {
        return ZPlanFeatureSwitch.f369852a.B2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public List<String> getZPlanPagSoDecoderPhoneList() {
        return ZPlanFeatureSwitch.f369852a.E2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public int getZPlanPortalTabDoubleClickRefreshLimitSeconds() {
        return ZPlanFeatureSwitch.f369852a.F2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getZPlanQZoneAvatarPlayStrategy() {
        return ZPlanFeatureSwitch.f369852a.I2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public Map<String, String> getZPlanUeEnvConfig() {
        return ZPlanFeatureSwitch.f369852a.M2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public JSONObject getZootopiaBackConfig() {
        return ZPlanFeatureSwitch.f369852a.N2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getZplanSettingCDKeyUrl() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("key_cd_key_url", ZPlanQQMC.INSTANCE.getZplanSettingCDKeyUrl());
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getZplanSettingFeedbackName() {
        return ZPlanFeatureSwitch.f369852a.Q2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getZplanSettingFeedbackUrl() {
        return ZPlanFeatureSwitch.f369852a.R2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getZplanSettingQzoneSwitchDesc() {
        return ZPlanFeatureSwitch.f369852a.S2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getZplanSettingQzoneSwitchName() {
        return ZPlanFeatureSwitch.f369852a.T2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public String getZplanSettingTitle() {
        return ZPlanFeatureSwitch.f369852a.U2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean isAioEntranceBtnShow() {
        return ZPlanFeatureSwitch.f369852a.W2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean isCmShowKeywordAssociationEnabled() {
        return ZPlanFeatureSwitch.f369852a.X2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean isCmShowMemeTabInFaceDisabled() {
        return !ZPlanFeatureSwitch.f369852a.Y2();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean isMemoryThresholdEnableDynamicAvatar() {
        return ZPlanFeatureSwitch.f369852a.d3();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean isNewerGuideCmShowAvatarEntranceShow() {
        return ZPlanFeatureSwitch.f369852a.e3();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean isPreloadEnable() {
        return ZPlanFeatureSwitch.f369852a.f3();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean killZplanWhenPortalExit() {
        return ZPlanFeatureSwitch.f369852a.o3();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper
    public boolean needOutBoundAvatar2EasterEgg() {
        return ZPlanFeatureSwitch.f369852a.p3();
    }
}
