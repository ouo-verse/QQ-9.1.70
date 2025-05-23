package com.tencent.mobileqq.zplan.utils.featureswitch.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0018H&J\b\u0010\u001d\u001a\u00020\u0018H&J\b\u0010\u001e\u001a\u00020\u0018H&J\b\u0010\u001f\u001a\u00020\u0018H&J\b\u0010 \u001a\u00020\u0018H&J\b\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020\"H&J\b\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020%H&J\b\u0010'\u001a\u00020\u0018H&J\b\u0010(\u001a\u00020\"H&J\b\u0010)\u001a\u00020\u0018H&J\b\u0010*\u001a\u00020\u0018H&J\b\u0010+\u001a\u00020\u0018H&J\b\u0010,\u001a\u00020\u0018H&J\b\u0010-\u001a\u00020%H&J\b\u0010.\u001a\u00020\u0018H&J\b\u0010/\u001a\u00020\u0018H&J\b\u00100\u001a\u00020\u0018H&J\b\u00101\u001a\u00020\u0018H&J\b\u00102\u001a\u00020\u0018H&J\b\u00103\u001a\u00020\"H&J\b\u00104\u001a\u00020\"H&J\b\u00105\u001a\u00020\"H&J\u0010\u00106\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u000107H&J\b\u00108\u001a\u00020\"H&J\b\u00109\u001a\u00020\u0018H&J\u0014\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180;H&J\n\u0010<\u001a\u0004\u0018\u00010=H&J\b\u0010>\u001a\u00020\u0018H&J\b\u0010?\u001a\u00020\u0018H&J\b\u0010@\u001a\u00020\u0018H&J\b\u0010A\u001a\u00020\u0018H&J\b\u0010B\u001a\u00020\u0018H&J\b\u0010C\u001a\u00020\u0018H&J\b\u0010D\u001a\u00020\u0003H&J\b\u0010E\u001a\u00020\u0003H&J\b\u0010F\u001a\u00020\u0003H&J\b\u0010G\u001a\u00020\u0003H&J\b\u0010H\u001a\u00020\u0003H&J\b\u0010I\u001a\u00020\u0003H&J\b\u0010J\u001a\u00020\u0003H&J\b\u0010K\u001a\u00020\u0003H&\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/featureswitch/api/IZPlanFeatureSwitchHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "disableCMShowRequest", "", "disableCm", "enableAvatarDressShare", "enableCmShowGameMiniApiUsgReduce", "enableEmotionRecordOptimization", "enableFilamentUseSomanager", "enableGLSurfaceTypeConfigure", "enableGuestZplanAvatarEntrance", "enableMemeRecordOnGenderChanged", "enablePreloadWorld", "enableQzoneConsiseDynamicAvatar", "enableQzoneRecordLoadingAnim", "enableRecordInNewObject", "enableReportDynamicAvatarToDaTong", "enableReportEasterEgg", "enableReportZPlanAvatar", "enableUploadUnRecordZPlanAvatar", "enableV2ShpImageCache", "enableZPlanAIOMakeGifEntrance", "enableZPlanApngAvatar", "enableZPlanEasterEgg", "", "enableZPlanFilamentStaticImageview", "enableZPlanGifText", "enableZPlanModDiffUpdate", "getAIOFrameAnimBubbleText", "getAIOFrameAnimConfig", "getActionSheetGoPortalString", "getActionSheetGoSmallHomeString", "getAvatarDressShareType", "getCMShowMemeActionMaximumFrameCount", "", "getDynamicAvatarRecordRepeatTime", "getEasterEggPlayTimeOutGap", "", "getEasterEggShowAvatarAnimateDuration", "getHomePageTabConfigV2", "getMemeCoverMaximumFrameCount", "getNewerGuideCmShowAvatarEntranceLink", "getNewerGuideCmShowAvatarEntranceName", "getNewerGuideZplanCmShowAvatarEntranceLink", "getOfficialAppearanceKey", "getOfficialAppearanceKeyTimeStamp", "getQzoneConsiseDynamicAvatarConfig", "getQzoneConsiseDynamicRecordConfig", "getSettingEntranceDesc", "getUploadUnRecordZPlanAvatarHint", "getZPlanAvatarBackgroundColor", "getZPlanAvatarFrameRate", "getZPlanEasterEggSupportVersion", "getZPlanOffscreenHeight", "getZPlanPagSoDecoderPhoneList", "", "getZPlanPortalTabDoubleClickRefreshLimitSeconds", "getZPlanQZoneAvatarPlayStrategy", "getZPlanUeEnvConfig", "", "getZootopiaBackConfig", "Lorg/json/JSONObject;", "getZplanSettingCDKeyUrl", "getZplanSettingFeedbackName", "getZplanSettingFeedbackUrl", "getZplanSettingQzoneSwitchDesc", "getZplanSettingQzoneSwitchName", "getZplanSettingTitle", "isAioEntranceBtnShow", "isCmShowKeywordAssociationEnabled", "isCmShowMemeTabInFaceDisabled", "isMemoryThresholdEnableDynamicAvatar", "isNewerGuideCmShowAvatarEntranceShow", "isPreloadEnable", "killZplanWhenPortalExit", "needOutBoundAvatar2EasterEgg", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanFeatureSwitchHelper extends QRouteApi {
    boolean disableCMShowRequest();

    boolean disableCm();

    boolean enableAvatarDressShare();

    boolean enableCmShowGameMiniApiUsgReduce();

    boolean enableEmotionRecordOptimization();

    boolean enableFilamentUseSomanager();

    boolean enableGLSurfaceTypeConfigure();

    boolean enableGuestZplanAvatarEntrance();

    boolean enableMemeRecordOnGenderChanged();

    boolean enablePreloadWorld();

    boolean enableQzoneConsiseDynamicAvatar();

    boolean enableQzoneRecordLoadingAnim();

    boolean enableRecordInNewObject();

    boolean enableReportDynamicAvatarToDaTong();

    boolean enableReportEasterEgg();

    boolean enableReportZPlanAvatar();

    boolean enableUploadUnRecordZPlanAvatar();

    boolean enableV2ShpImageCache();

    boolean enableZPlanAIOMakeGifEntrance();

    boolean enableZPlanApngAvatar();

    @NotNull
    String enableZPlanEasterEgg();

    boolean enableZPlanFilamentStaticImageview();

    boolean enableZPlanGifText();

    boolean enableZPlanModDiffUpdate();

    @NotNull
    String getAIOFrameAnimBubbleText();

    @NotNull
    String getAIOFrameAnimConfig();

    @NotNull
    String getActionSheetGoPortalString();

    @NotNull
    String getActionSheetGoSmallHomeString();

    @NotNull
    String getAvatarDressShareType();

    int getCMShowMemeActionMaximumFrameCount();

    int getDynamicAvatarRecordRepeatTime();

    long getEasterEggPlayTimeOutGap();

    long getEasterEggShowAvatarAnimateDuration();

    @NotNull
    String getHomePageTabConfigV2();

    int getMemeCoverMaximumFrameCount();

    @NotNull
    String getNewerGuideCmShowAvatarEntranceLink();

    @NotNull
    String getNewerGuideCmShowAvatarEntranceName();

    @NotNull
    String getNewerGuideZplanCmShowAvatarEntranceLink();

    @NotNull
    String getOfficialAppearanceKey();

    long getOfficialAppearanceKeyTimeStamp();

    @NotNull
    String getQzoneConsiseDynamicAvatarConfig();

    @NotNull
    String getQzoneConsiseDynamicRecordConfig();

    @NotNull
    String getSettingEntranceDesc();

    @NotNull
    String getUploadUnRecordZPlanAvatarHint();

    @NotNull
    String getZPlanAvatarBackgroundColor();

    int getZPlanAvatarFrameRate();

    int getZPlanEasterEggSupportVersion();

    int getZPlanOffscreenHeight();

    @Nullable
    List<String> getZPlanPagSoDecoderPhoneList();

    int getZPlanPortalTabDoubleClickRefreshLimitSeconds();

    @NotNull
    String getZPlanQZoneAvatarPlayStrategy();

    @NotNull
    Map<String, String> getZPlanUeEnvConfig();

    @Nullable
    JSONObject getZootopiaBackConfig();

    @NotNull
    String getZplanSettingCDKeyUrl();

    @NotNull
    String getZplanSettingFeedbackName();

    @NotNull
    String getZplanSettingFeedbackUrl();

    @NotNull
    String getZplanSettingQzoneSwitchDesc();

    @NotNull
    String getZplanSettingQzoneSwitchName();

    @NotNull
    String getZplanSettingTitle();

    boolean isAioEntranceBtnShow();

    boolean isCmShowKeywordAssociationEnabled();

    boolean isCmShowMemeTabInFaceDisabled();

    boolean isMemoryThresholdEnableDynamicAvatar();

    boolean isNewerGuideCmShowAvatarEntranceShow();

    boolean isPreloadEnable();

    boolean killZplanWhenPortalExit();

    boolean needOutBoundAvatar2EasterEgg();
}
