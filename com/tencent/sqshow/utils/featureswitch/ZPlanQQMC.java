package com.tencent.sqshow.utils.featureswitch;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.model.CleanZPlanMMKVConfig;
import com.tencent.sqshow.utils.featureswitch.model.CreateRoleRetentionConfig;
import com.tencent.sqshow.utils.featureswitch.model.DressInfoRequestConfig;
import com.tencent.sqshow.utils.featureswitch.model.NameplateClickJumpTo;
import com.tencent.sqshow.utils.featureswitch.model.PortalFaceConfig;
import com.tencent.sqshow.utils.featureswitch.model.PortalPreRecordAction;
import com.tencent.sqshow.utils.featureswitch.model.ReloadAvatarDelaySlotConfig;
import com.tencent.sqshow.utils.featureswitch.model.ShowSilverGuideConditionsConfig;
import com.tencent.sqshow.utils.featureswitch.model.StartupConfig;
import com.tencent.sqshow.utils.featureswitch.model.SuperQQShowConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanAioMiniHomeConnEntranceConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanBrandMallConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanCoupleAvatarBodyTypeConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanCoupleAvatarConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanCoupleAvatarRenderConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanEmoticonSizeConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanEmoticonTabCloudCacheRequestConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanFilamentRecommendAntiDisturbConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanIntermittentFetchCoupleProfileConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanMiniHomeGuidanceConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanRRCResourceExpireConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanSettingOfficialGroupEntranceConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanShareConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanShareTemplateConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanTofuAvatarConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanXWConnectFlowerConfig;
import com.tencent.sqshow.utils.featureswitch.model.ae;
import com.tencent.sqshow.utils.featureswitch.model.af;
import com.tencent.sqshow.utils.featureswitch.model.ah;
import com.tencent.sqshow.utils.featureswitch.model.an;
import com.tencent.sqshow.utils.featureswitch.model.ao;
import com.tencent.sqshow.utils.featureswitch.model.aq;
import com.tencent.sqshow.utils.featureswitch.model.i;
import com.tencent.sqshow.utils.featureswitch.model.x;
import com.tencent.zplan.common.utils.GsonUtil;
import com.tencent.zplan.record.a;
import com.tencent.zplan.record.model.GeneralRecordSwitches;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
import wk3.CoupleAvatarDestroyConfig;
import wk3.PortalStoreDressUpRecordParamConfig;
import wk3.ZPlanCoupleAvatarSwitchConfig;
import wk3.c;
import wk3.e;
import wk3.f;
import wk3.g;
import yx4.c;

@Metadata(d1 = {"\u0000\u00c6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u00c3\u0001\u0010\u00c4\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J5\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\rJ\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u0004J\u0006\u00101\u001a\u000200J\u0006\u00103\u001a\u000202J\u0006\u00105\u001a\u000204J\u0006\u00107\u001a\u000206J\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020;2\u0006\u0010\u0017\u001a\u00020:J\u0006\u0010=\u001a\u00020\u0004J\u0006\u0010>\u001a\u00020\u0004J\u0006\u0010?\u001a\u00020\u0004J\u0006\u0010A\u001a\u00020@J\u0006\u0010B\u001a\u00020\u0004J\u0006\u0010C\u001a\u00020\u0004J\u0006\u0010E\u001a\u00020DJ\u0006\u0010F\u001a\u00020\u0002J\u0006\u0010G\u001a\u00020\u0002J\u0016\u0010K\u001a\u00020\u00022\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\u0002J\u0006\u0010L\u001a\u00020\u0002J\u0006\u0010M\u001a\u00020\u0004J\u0006\u0010N\u001a\u00020\u0004J\u0006\u0010P\u001a\u00020OJ\u0006\u0010Q\u001a\u00020\u0004J\u0006\u0010R\u001a\u00020\u0004J\u0006\u0010S\u001a\u00020\u0004J\u0006\u0010T\u001a\u00020\u0004J\u0006\u0010U\u001a\u00020\u0004J\u0006\u0010W\u001a\u00020VJ\u0006\u0010Y\u001a\u00020XJ\u0006\u0010Z\u001a\u00020\u0004J\u0006\u0010\\\u001a\u00020[J\u0006\u0010^\u001a\u00020]J\u0006\u0010`\u001a\u00020_J\u0006\u0010b\u001a\u00020aJ\u0006\u0010c\u001a\u00020HJ\u0006\u0010e\u001a\u00020dJ\u0006\u0010f\u001a\u00020\u0002J\u0006\u0010h\u001a\u00020gJ\u0006\u0010i\u001a\u00020\u0004J\u0017\u0010k\u001a\u0004\u0018\u00010\u00132\u0006\u0010j\u001a\u00020\u0002\u00a2\u0006\u0004\bk\u0010lJ\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00130mJ\u0006\u0010p\u001a\u00020oJ\u0006\u0010r\u001a\u00020qJ\b\u0010t\u001a\u00020sH\u0016J\b\u0010u\u001a\u00020\u0004H\u0016J\b\u0010v\u001a\u00020\u0004H\u0016J\u0006\u0010w\u001a\u00020HJ\u0006\u0010x\u001a\u00020HJ\u0006\u0010z\u001a\u00020yJ\u0006\u0010{\u001a\u00020\u0004J\u0006\u0010|\u001a\u00020\u0004J\b\u0010}\u001a\u00020\u0004H\u0016J\u0006\u0010~\u001a\u00020\u0002J\t\u0010\u0080\u0001\u001a\u00020\u007fH\u0016J\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001J\u0007\u0010\u0083\u0001\u001a\u00020\u0004J\u0007\u0010\u0084\u0001\u001a\u00020\u0004J\u0007\u0010\u0085\u0001\u001a\u00020\u0004J\u0007\u0010\u0086\u0001\u001a\u00020\u0004J\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001J\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001J\u0007\u0010\u008b\u0001\u001a\u00020\u0004J\u0007\u0010\u008c\u0001\u001a\u00020\u0004J\u0007\u0010\u008d\u0001\u001a\u00020\u0004J\u0007\u0010\u008e\u0001\u001a\u00020\u0004J\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001J\u0007\u0010\u0091\u0001\u001a\u00020HJ\u0007\u0010\u0092\u0001\u001a\u00020HJ\u0007\u0010\u0093\u0001\u001a\u00020HJ\u0007\u0010\u0094\u0001\u001a\u00020HJ\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001J\b\u0010\u0098\u0001\u001a\u00030\u0097\u0001J\u0007\u0010\u0099\u0001\u001a\u00020\u0004J\u0007\u0010\u009a\u0001\u001a\u00020\u0004J\u0007\u0010\u009b\u0001\u001a\u00020\u0004J\b\u0010\u009d\u0001\u001a\u00030\u009c\u0001J\u0007\u0010\u009e\u0001\u001a\u00020\u0004J\u0007\u0010\u009f\u0001\u001a\u00020\u0004J\u0007\u0010\u00a0\u0001\u001a\u00020\u0004J\t\u0010\u00a1\u0001\u001a\u00020\u0004H\u0016J\b\u0010\u00a3\u0001\u001a\u00030\u00a2\u0001J\u0007\u0010\u00a4\u0001\u001a\u00020\u0004J\u0007\u0010\u00a5\u0001\u001a\u00020\u0004J\t\u0010\u00a6\u0001\u001a\u00020\u0004H\u0016J\u0007\u0010\u00a7\u0001\u001a\u00020\u0004J\u0007\u0010\u00a8\u0001\u001a\u00020\u0004J\u0007\u0010\u00a9\u0001\u001a\u00020\u0004J\u0007\u0010\u00aa\u0001\u001a\u00020\u0004J\u0007\u0010\u00ab\u0001\u001a\u00020\u0004J\u0007\u0010\u00ac\u0001\u001a\u00020\u0004J\b\u0010\u00ae\u0001\u001a\u00030\u00ad\u0001J\u0007\u0010\u00af\u0001\u001a\u00020\u0004J\u0007\u0010\u00b0\u0001\u001a\u00020HJ\u0007\u0010\u00b1\u0001\u001a\u00020\u0013J\u0007\u0010\u00b2\u0001\u001a\u00020\u0004J\b\u0010\u00b4\u0001\u001a\u00030\u00b3\u0001J\b\u0010\u00b6\u0001\u001a\u00030\u00b5\u0001J\u0007\u0010\u00b7\u0001\u001a\u00020\u0013J\u0007\u0010\u00b8\u0001\u001a\u00020\u0004J\u0007\u0010\u00b9\u0001\u001a\u00020\u0004J\u0007\u0010\u00ba\u0001\u001a\u00020\u0004J\u0007\u0010\u00bb\u0001\u001a\u00020\u0004J\u0007\u0010\u00bc\u0001\u001a\u00020\u0004J\u0007\u0010\u00bd\u0001\u001a\u00020\u0004J\u0007\u0010\u00be\u0001\u001a\u00020\u0004J\u0007\u0010\u00bf\u0001\u001a\u00020\u0004J\u0007\u0010\u00c0\u0001\u001a\u00020\u0004R\u0017\u0010\u00c1\u0001\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001\u00a8\u0006\u00c5\u0001"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/ZPlanQQMC;", "Lcom/tencent/mobileqq/zplan/utils/featureswitch/api/IZPlanQQMC;", "", VipFunCallConstants.KEY_GROUP, "", AdMetricTag.FALLBACK, "isSwitchOn", "T", "groupId", "Ljava/lang/Class;", "configClass", "getConfig", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "enableFilamentPortalSecondLoading", "enableZPlanEmoticonDetail", "Lwk3/f;", "getZPlanEmoticonDetailConfig", "getZPlanEmoticonCreateRoleScheme", "", "getPortalUpdateColorRate", "enableCreateRoleFromEmoticon", "Lcom/tencent/mobileqq/zplan/meme/ZPlanRecordScene;", "scene", "enableFilamentRecord", "enableFilamentRecordResultUpload", "enableFilamentRecordCloudCache", "enableFriendsDressUpMiniAio", "enableZPlanFriendDressBuyUinReport", "getDressInfoRequestTimeout", "enableOpenTelemetryReport", "enableErrorBubbleOnQZone", "Lwk3/g;", "getZPlanEmoticonGrayTipsConfig", "enableMemeResetPriority", "enableAvatarTimeCostOptimization", "enableRequestPortalBottomTabsWhenEnter", "enableCancelGlassesMetallic", "enableZPlanPayModuleUpdate", "Lcom/tencent/sqshow/utils/featureswitch/model/b;", "getCreateRoleRetentionConfig", "enableFilamentRecordParallelDownload", "Lcom/tencent/sqshow/utils/featureswitch/model/v;", "getZPlanEmoticonTabCloudCacheRequestConfig", "enableGifEncodeWithMediaCut", "enableGifFFMpegPalette", "enableZPlanStorePreload", "enableZPlanStoreShowDiyButton", "Lwk3/c;", "getZPlanBirthdayCareRecordConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/h;", "getPortalPreRecordAction", "Lcom/tencent/sqshow/utils/featureswitch/model/w;", "getFilamentRecommendAntiDisturbConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/u;", "getZPlanEmoticonSizeConfig", "enableCreateRoleExp", "enableNewPortalStore", "Lcom/tencent/zplan/record/a;", "Lcom/tencent/zplan/record/model/c;", "getGeneralRecordSwitchesByScene", "enableRenderCompelteCallback", "enablePortalSyncLoadInitAnim", "enablePortalFilamentPreLaunch", "Lcom/tencent/sqshow/utils/featureswitch/model/j;", "getPortalFilamentReloadAvatarDelaySlotConfig", "enableCenterLoadingTips", "enableBottomLoadingHint", "Lcom/tencent/sqshow/utils/featureswitch/model/ai;", "getZPlanShareConfig", "getAIGCCreateJumpMyBagScheme", "getUGCJumpMyBagAllScheme", "", "ugcId", "subPageId", "getAIGCScheme", "getZplanSettingCDKeyUrl", "disableZPlanAIGCEntrance", "brandMallUseOldVersion", "Lcom/tencent/sqshow/utils/featureswitch/model/f;", "getNameplateClickJumpTo", "enablePortalCreateToFirstFrameReport", "enableAvatarChangeRefresh", "enableZPlanEditAvatarV2", "enableZPlanEditInitDataOnResume", "enableUpdateZPlanUserInfoWithEmptyAppearanceKey", "Lcom/tencent/sqshow/utils/featureswitch/model/n;", "getSuperQQShowGuideConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/l;", "getPortalSilverGuideConfig2", "enablePortalSilverGuide", "Lcom/tencent/sqshow/utils/featureswitch/model/an;", "getXWConnectConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/ao;", "enableXWConnect", "Lcom/tencent/sqshow/utils/featureswitch/model/aq;", "getXWConnectTipPage", "Lcom/tencent/sqshow/utils/featureswitch/model/ap;", "getXWConnectFlowerConfig", "getXwConnectOpRequestTimeInterval", "Lcom/tencent/sqshow/utils/featureswitch/model/m;", "getXWConnectStartupConfig", "getZootopiaParaiseConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/ZPlanSettingOfficialGroupEntranceConfig;", "getSettingOfficialGroupEntranceConfig", "enableRecommendRecord", "intimateType", "getCoupleAvatarDefaultScene", "(Ljava/lang/String;)Ljava/lang/Integer;", "", "getCoupleAvatarDefaultSceneIDList", "Lcom/tencent/sqshow/utils/featureswitch/model/q;", "getCoupleAvatarBodyTypeConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/s;", "getCoupleAvatarRenderConfig", "Lwk3/d;", "getCoupleAvatarSwitchConfig", "enableZPlanFilamentNewPortal", "enableLocalShaderBinary", "getDrawerShowStaticDelayTime", "getDrawerJumpPortalDelayTime", "Lcom/tencent/sqshow/utils/featureswitch/model/aa;", "getIntermittentFetchCoupleProfileInfo", "enableRefrshFilmentSwitch", "enableFilterMyClothes", "enableSendMsgIntentOnPartResume", "getZPlanCoupleIntimateGuideBubbleRichText", "Lwk3/a;", "getCoupleAvatarDestroyConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/ab;", "getMiniHomeGuidanceConfig", "enableMiniHome", "enableXiaoWoUseNormalFont", "enableZPlanQuality", "enableCoupleAvatarSwitchCache", "Lcom/tencent/sqshow/utils/featureswitch/model/ah;", "getSameStyleConfig", "Lwk3/b;", "getPortalStoreDressUpRecordParamConfig", "enableAIOSceneLinkage", "enableCompareSaveAvatarGradientColor", "enableFetchAppearanceKeyWhenLaunch", "enableEmoticonStickerIdConfigFromAllConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/ac;", "getZPlanRRCResourceExpireConfig", "getMemeRecordTimeoutTime", "getMemeRecordFileCacheSize", "getRecordResourceCenterFileCacheSize", "getEmoticonTabFileCacheSize", "Lyx4/c$b;", "getZPlanCloudCacheCommonConfig", "Lyx4/c$e;", "getZPlanRecordForceDeleteConfig", "disableUEHotPatch", "enableAIOTofu", "enableShowRewardWhenPagPlayFail", "Lcom/tencent/sqshow/utils/featureswitch/model/al;", "getZPlanTofuAvatarConfig", "enableFileManagerLoadAllDBData", "enableRemoveColorInfo", "destroyDataBaseHelper", "enableMiniHomeEdit", "Lcom/tencent/sqshow/utils/featureswitch/model/o;", "getZPlanAioMiniHomeConnEntranceConfig", "enableLoadReddotOnSubThread", "destroyMiniConnectWhenJumpOut", "enableZPlanFold", "enableFlushAccessableDiskCacheOnce", "enableBadgeVisibilityControlByStudyMode", "enableQuitMemeEncoderThreadHandler", "enableInterceptOpenHomeConnected", "enableFixWidthOnPortalShareCard", "enableHeadEffect", "Lcom/tencent/sqshow/utils/featureswitch/model/ak;", "getZPlanShareTemplateConfig", "enableZPlanShareTemplate", "getMiniHomeConnectStrangerVisitRecommendTimeInterval", "getMiniHomeConnectVisitStrangerTimeThreshold", "enableCleanZPlanMMKV", "Lcom/tencent/sqshow/utils/featureswitch/model/a;", "getCleanMMKVConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/g;", "getFaceAdConfig", "getDynamicNativeAppFps", "enableCameraAnimation", "enableRequestFaceAdFromTianShu", "enableCppRetainSurfaceTexture", "enableShareDressToXhs", "enableZPlanXwConnectHuaTeng", "enablePreloadUEAvatarInPortal", "enablePreloadUEXWInPortal", "enableLoadBrandBg", "enableUseFilamentPinchFace", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanQQMC implements IZPlanQQMC {
    public static final ZPlanQQMC INSTANCE = new ZPlanQQMC();
    private static final String TAG = "ZPlanQQMC";

    ZPlanQQMC() {
    }

    public final boolean brandMallUseOldVersion() {
        return ((ZPlanBrandMallConfig) getConfig("zplan_brand_mall_use_old_version", new ZPlanBrandMallConfig(0, 1, null))).getUseOldVersion() != 0;
    }

    public final boolean destroyDataBaseHelper() {
        return isSwitchOn("zplan_destroy_data_base_helper", true);
    }

    public final boolean destroyMiniConnectWhenJumpOut() {
        return isSwitchOn("zplan_destroy_mini_connect_when_jump_out", false);
    }

    public final boolean disableUEHotPatch() {
        return isSwitchOn("zplan_disable_ue_hotpatch", false);
    }

    public final boolean disableZPlanAIGCEntrance() {
        return isSwitchOn("zplan_aigc_blacklist", false);
    }

    public final boolean enableAIOSceneLinkage() {
        return isSwitchOn("zplan_scene_linkage_blacklist", true);
    }

    public final boolean enableAIOTofu() {
        return isSwitchOn("zplan_lite_aio_tofu_resource_config", true);
    }

    public final boolean enableAvatarChangeRefresh() {
        return isSwitchOn("zplan_filament_enable_avatar_change_refresh", true);
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableAvatarTimeCostOptimization() {
        return isSwitchOn("zplan_enable_avatar_time_cost_optimization", false);
    }

    public final boolean enableBadgeVisibilityControlByStudyMode() {
        return isSwitchOn("zplan_badge_visibility_control_by_study_mode", true);
    }

    public final boolean enableBottomLoadingHint() {
        return isSwitchOn("enable_zplan_portal_bottom_loading_hint", false);
    }

    public final boolean enableCameraAnimation() {
        return isSwitchOn("zplan_enable_portal_camera_animation", true);
    }

    public final boolean enableCancelGlassesMetallic() {
        return isSwitchOn("enable_cancel_glasses_metallic", false);
    }

    public final boolean enableCenterLoadingTips() {
        return isSwitchOn("enable_zplan_portal_center_loading_tips", false);
    }

    public final boolean enableCleanZPlanMMKV() {
        return isSwitchOn("zplan_clean_mmkv_config", true);
    }

    public final boolean enableCompareSaveAvatarGradientColor() {
        return isSwitchOn("zplan_enable_compare_save_avatar_gradient_color", false);
    }

    public final boolean enableCoupleAvatarSwitchCache() {
        return isSwitchOn("zplan_enable_couple_avatar_switch_cache", false);
    }

    public final boolean enableCppRetainSurfaceTexture() {
        return isSwitchOn("enable_cpp_retain_surface_texture", true);
    }

    public final boolean enableCreateRoleExp() {
        return isSwitchOn("enable_zplan_create_role_exp_switch", false);
    }

    public final boolean enableCreateRoleFromEmoticon() {
        return isSwitchOn("zplan_create_role_from_emoticon", true);
    }

    public final boolean enableEmoticonStickerIdConfigFromAllConfig() {
        return isSwitchOn("zplan_enable_emoticon_sticker_id_config_from_all_config", true);
    }

    public final boolean enableErrorBubbleOnQZone() {
        return isSwitchOn("zplan_enable_error_bubble_on_qzone", false);
    }

    public final boolean enableFetchAppearanceKeyWhenLaunch() {
        return isSwitchOn("zplan_enable_fetch_appearancekey_when_launch", true);
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableFilamentPortalSecondLoading() {
        return isSwitchOn("zplan_filament_portal_second_loading", false);
    }

    public final boolean enableFilamentRecord(ZPlanRecordScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (!isSwitchOn("100197", false)) {
            return false;
        }
        x xVar = (x) getConfig("100197", x.class, "");
        List<Integer> b16 = xVar != null ? xVar.b() : null;
        List<Integer> list = b16;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<Integer> it = b16.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == scene.getValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean enableFilamentRecordCloudCache(ZPlanRecordScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (!isSwitchOn("100197", false)) {
            return false;
        }
        x xVar = (x) getConfig("100197", x.class, "");
        List<Integer> a16 = xVar != null ? xVar.a() : null;
        List<Integer> list = a16;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<Integer> it = a16.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == scene.getValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean enableFilamentRecordParallelDownload() {
        return isSwitchOn("enable_filament_record_parallel_download", false);
    }

    public final boolean enableFilamentRecordResultUpload(ZPlanRecordScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (!isSwitchOn("100197", false)) {
            return false;
        }
        x xVar = (x) getConfig("100197", x.class, "");
        List<Integer> c16 = xVar != null ? xVar.c() : null;
        List<Integer> list = c16;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<Integer> it = c16.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == scene.getValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean enableFileManagerLoadAllDBData() {
        return isSwitchOn("zplan_enable_file_manager_load_all_db_data", false);
    }

    public final boolean enableFilterMyClothes() {
        return isSwitchOn("zplan_enable_filter_my_clothes", true);
    }

    public final boolean enableFixWidthOnPortalShareCard() {
        return isSwitchOn("zplan_fix_width_on_portal_share_card", true);
    }

    public final boolean enableFlushAccessableDiskCacheOnce() {
        return isSwitchOn("zplan_enable_flush_accessable_disk_cache_once", false);
    }

    public final boolean enableFriendsDressUpMiniAio() {
        return isSwitchOn("zplan_friends_dress_up_mini_aio", false);
    }

    public final boolean enableGifEncodeWithMediaCut() {
        return isSwitchOn("zplan_gif_encoder_median_cut_algorithm", false);
    }

    public final boolean enableGifFFMpegPalette() {
        return isSwitchOn("zplan_gif_ffmpeg_palette", false);
    }

    public final boolean enableHeadEffect() {
        return isSwitchOn("zplan_enable_head_effect", false);
    }

    public final boolean enableInterceptOpenHomeConnected() {
        return isSwitchOn("zplan_enable_intercept_open_home_connected", true);
    }

    public final boolean enableLoadBrandBg() {
        return isSwitchOn("zplan_enable_load_brand_bg", false);
    }

    public final boolean enableLoadReddotOnSubThread() {
        return isSwitchOn("zplan_enable_load_reddot_on_sub_thread", true);
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableLocalShaderBinary() {
        return isSwitchOn("enable_filament_local_shader_binary", false);
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableMemeResetPriority() {
        return isSwitchOn("enable_zplan_meme_reset_priority", false);
    }

    public final boolean enableMiniHome() {
        return isSwitchOn("zplan_enable_minihome", true);
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableMiniHomeEdit() {
        return isSwitchOn("zplan_enable_mini_home_edit", false);
    }

    public final boolean enableNewPortalStore() {
        return isSwitchOn("enable_new_portal_store_switch", true);
    }

    public final boolean enableOpenTelemetryReport() {
        return isSwitchOn("zplan_enable_open_telemetry_report", false);
    }

    public final boolean enablePortalCreateToFirstFrameReport() {
        return isSwitchOn("zplan_filament_enable_create_to_first_frame_report", true);
    }

    public final boolean enablePortalFilamentPreLaunch() {
        return isSwitchOn("zplan_filament_enable_pre_launch", false);
    }

    public final boolean enablePortalSilverGuide() {
        return isSwitchOn("zplan_enable_portal_silver_guide", true);
    }

    public final boolean enablePortalSyncLoadInitAnim() {
        return isSwitchOn("zplan_enable_portal_sync_load_init_anim", true);
    }

    public final boolean enablePreloadUEAvatarInPortal() {
        return isSwitchOn("zplan_enable_preload_ue_avatar_portal", false);
    }

    public final boolean enablePreloadUEXWInPortal() {
        return isSwitchOn("zplan_enable_preload_ue_xw_portal", false);
    }

    public final boolean enableQuitMemeEncoderThreadHandler() {
        return isSwitchOn("zplan_meme_encoder_thread_handler_quit_safely", true);
    }

    public final boolean enableRecommendRecord() {
        return isSwitchOn("enable_zplan_recommend_record", true);
    }

    public final boolean enableRefrshFilmentSwitch() {
        return isSwitchOn("zplan_enable_refresh_filament_switch_config", true);
    }

    public final boolean enableRemoveColorInfo() {
        return isSwitchOn("zplan_enable_remove_color_info", true);
    }

    public final boolean enableRenderCompelteCallback() {
        return isSwitchOn("zplan_enable_render_complete_callback", true);
    }

    public final boolean enableRequestFaceAdFromTianShu() {
        return ((Boolean) getConfig("zplan_enable_request_face_ad_from_tian_shu", Boolean.TRUE)).booleanValue();
    }

    public final boolean enableRequestPortalBottomTabsWhenEnter() {
        return isSwitchOn("enable_request_portal_bottom_tabs_when_enter", true);
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableSendMsgIntentOnPartResume() {
        return isSwitchOn("zplan_enable_send_msg_intent_on_part_resume", true);
    }

    public final boolean enableShareDressToXhs() {
        return isSwitchOn("zplan_share_dress_xhs", true);
    }

    public final boolean enableShowRewardWhenPagPlayFail() {
        return isSwitchOn("zplan_enable_show_reward_when_pag_play_fail", true);
    }

    public final boolean enableUpdateZPlanUserInfoWithEmptyAppearanceKey() {
        return isSwitchOn("enable_zplan_user_info_update_with_empty_appearance_key", true);
    }

    public final boolean enableUseFilamentPinchFace() {
        return isSwitchOn("zplan_enable_use_filament_pinch_face", true);
    }

    public final ao enableXWConnect() {
        return (ao) getConfig("zplan_xw_connect_switch_and", new ao());
    }

    public final boolean enableXiaoWoUseNormalFont() {
        return isSwitchOn("zplan_enable_xiaowo_use_normal_font", true);
    }

    public final boolean enableZPlanEditAvatarV2() {
        return isSwitchOn("enable_zplan_edit_avatar_v2", true);
    }

    public final boolean enableZPlanEditInitDataOnResume() {
        return isSwitchOn("enable_zplan_edit_init_data_on_resume", false);
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableZPlanEmoticonDetail() {
        return isSwitchOn("zplan_emoticon_detail_config", true);
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableZPlanFilamentNewPortal() {
        ZPlanFeatureSwitch.f369852a.p();
        return isSwitchOn("zplan_filament_new_portal", false);
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean enableZPlanFold() {
        return isSwitchOn("zplan_fold_enable", true);
    }

    public final boolean enableZPlanFriendDressBuyUinReport() {
        return isSwitchOn("zplan_friend_dress_buy_uin_report", false);
    }

    public final boolean enableZPlanPayModuleUpdate() {
        return isSwitchOn("enable_zplan_pay_module_update", true);
    }

    public final boolean enableZPlanQuality() {
        return isSwitchOn("zplan_enable_quality", false);
    }

    public final boolean enableZPlanShareTemplate() {
        return isSwitchOn("zplan_enable_share_template", true);
    }

    public final boolean enableZPlanStorePreload() {
        return isSwitchOn("zplan_store_preload_switch_and", false);
    }

    public final boolean enableZPlanStoreShowDiyButton() {
        return isSwitchOn("zplan_store_show_diy_button", false);
    }

    public final boolean enableZPlanXwConnectHuaTeng() {
        return isSwitchOn("zplan_enable_xw_connect_huateng", true);
    }

    public final String getAIGCCreateJumpMyBagScheme() {
        return (String) getConfig("get_aigc_create_jump_my_bag_scheme", "mqqapi://zplan/enterAvatarScene?src_type=app&version=1.0&referer=12&sceneType=1&sceneData={\"ViewType\":1,\"SubScene\":{\"SceneType\":1,\"SceneParams\":{\"active_id\":\"my:2:5\"}}}");
    }

    public final String getAIGCScheme(long ugcId, String subPageId) {
        String replace$default;
        Intrinsics.checkNotNullParameter(subPageId, "subPageId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("subPageId", subPageId);
        jSONObject.put("ugcId", String.valueOf(ugcId));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mqqapi://zplan/openPage?src_type=app&version=1.0&pageID=18&");
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        replace$default = StringsKt__StringsJVMKt.replace$default(jSONObject2, "\"", "\\\"", false, 4, (Object) null);
        sb5.append(replace$default);
        return sb5.toString();
    }

    public final CleanZPlanMMKVConfig getCleanMMKVConfig() {
        return (CleanZPlanMMKVConfig) getConfig("zplan_clean_mmkv_config", new CleanZPlanMMKVConfig(0L, 0L, 3, null));
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public <T> T getConfig(String groupId, Class<T> configClass, String fallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(configClass, "configClass");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        byte[] bytes = fallback.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] loadRawConfig = iUnitedConfigManager.loadRawConfig(groupId, bytes);
        if (loadRawConfig == null) {
            return null;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        try {
            return (T) GsonUtil.f385283b.a().fromJson(new String(loadRawConfig, UTF_8), (Class) configClass);
        } catch (JsonSyntaxException e16) {
            QLog.e(TAG, 1, "parse fail. ", e16);
            return null;
        }
    }

    public final ZPlanCoupleAvatarBodyTypeConfig getCoupleAvatarBodyTypeConfig() {
        return (ZPlanCoupleAvatarBodyTypeConfig) getConfig("zplan_couple_avatar_config", new ZPlanCoupleAvatarBodyTypeConfig(false, null, null, 7, null));
    }

    public final Integer getCoupleAvatarDefaultScene(String intimateType) {
        Intrinsics.checkNotNullParameter(intimateType, "intimateType");
        return ((ZPlanCoupleAvatarConfig) getConfig("zplan_couple_avatar_config", new ZPlanCoupleAvatarConfig(null, 0L, 3, null))).a().get(intimateType);
    }

    public final Collection<Integer> getCoupleAvatarDefaultSceneIDList() {
        return ((ZPlanCoupleAvatarConfig) getConfig("zplan_couple_avatar_config", new ZPlanCoupleAvatarConfig(null, 0L, 3, null))).a().values();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public CoupleAvatarDestroyConfig getCoupleAvatarDestroyConfig() {
        return (CoupleAvatarDestroyConfig) getConfig("zplan_couple_avatar_destroy_config", new CoupleAvatarDestroyConfig(false, 0L, 3, null));
    }

    public final ZPlanCoupleAvatarRenderConfig getCoupleAvatarRenderConfig() {
        return (ZPlanCoupleAvatarRenderConfig) getConfig("zplan_couple_avatar_render_config", new ZPlanCoupleAvatarRenderConfig(0, 1, null));
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public ZPlanCoupleAvatarSwitchConfig getCoupleAvatarSwitchConfig() {
        return (ZPlanCoupleAvatarSwitchConfig) getConfig("zplan_couple_avatar_qqmc_switch", new ZPlanCoupleAvatarSwitchConfig(false, 0L, 3, null));
    }

    public final CreateRoleRetentionConfig getCreateRoleRetentionConfig() {
        return (CreateRoleRetentionConfig) getConfig("createRoleRetentionConfig", new CreateRoleRetentionConfig(null, null, null, null, 15, null));
    }

    public final int getDressInfoRequestTimeout() {
        return ((DressInfoRequestConfig) getConfig("zplan_dress_info_request_config", new DressInfoRequestConfig(0, 1, null))).getTimeout();
    }

    public final PortalFaceConfig getFaceAdConfig() {
        return (PortalFaceConfig) getConfig("portal_face_photos_config", new PortalFaceConfig(0, 1, null));
    }

    public final ZPlanFilamentRecommendAntiDisturbConfig getFilamentRecommendAntiDisturbConfig() {
        return (ZPlanFilamentRecommendAntiDisturbConfig) getConfig("zplan_filament_recommend_anti_disturb", new ZPlanFilamentRecommendAntiDisturbConfig(0, 1, null));
    }

    public final GeneralRecordSwitches getGeneralRecordSwitchesByScene(a scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        af afVar = (af) getConfig("zplan_record_render_switch_config", af.class, "{\"engineType\":{\"filament\":[2,3,6,9]},\"zplan_record_enableAntiAliasing\":{\"ue4\":[2]},\"enable_cancel_glasses_metallic\":{\"filament\":[2,3,6,9]}}");
        if (afVar == null) {
            afVar = new af();
        }
        ae aeVar = (ae) getConfig("zplan_record_cloud_switch_config", ae.class, "{\"enable_cloud_cache_scene\":{\"filament\":[2,3,6,9],\"ue4\":[2,3,5,6,7,8,9,10]},\"enable_upload_scene\":{\"filament\":[],\"ue4\":[3,7,8]},\"upload_to_idc\":{\"ue4\":[3]}}");
        if (aeVar == null) {
            aeVar = new ae();
        }
        return new GeneralRecordSwitches(afVar.d(scene), aeVar.c(scene, afVar.c(scene)));
    }

    public final ZPlanIntermittentFetchCoupleProfileConfig getIntermittentFetchCoupleProfileInfo() {
        return (ZPlanIntermittentFetchCoupleProfileConfig) getConfig("zplan_intermittent_fetch_couple_profile_info", new ZPlanIntermittentFetchCoupleProfileConfig(false, 0L, 3, null));
    }

    public final ZPlanMiniHomeGuidanceConfig getMiniHomeGuidanceConfig() {
        return (ZPlanMiniHomeGuidanceConfig) getConfig("zplan_minihome_guidance_config", new ZPlanMiniHomeGuidanceConfig(null, null, null, null, 15, null));
    }

    public final NameplateClickJumpTo getNameplateClickJumpTo() {
        return (NameplateClickJumpTo) getConfig("zplan_svip_nameplate_jump_url", new NameplateClickJumpTo("https://ti.qq.com/super-qqshow/nameplate-setting/index.html?_wv=3&_wwv=1", "https://ti.qq.com/super-qqshow/nameplate-setting/detail.html?_wv=3&_wwv=1&nameplate_id={nameplate_id}"));
    }

    public final ReloadAvatarDelaySlotConfig getPortalFilamentReloadAvatarDelaySlotConfig() {
        return (ReloadAvatarDelaySlotConfig) getConfig("zplan_filament_portal_reload_avatar_delay_slot_config", new ReloadAvatarDelaySlotConfig(false, null, 3, 0 == true ? 1 : 0));
    }

    public final PortalPreRecordAction getPortalPreRecordAction() {
        return (PortalPreRecordAction) getConfig("zplan_spring_share_ids", new PortalPreRecordAction(null, null, 3, null));
    }

    public final ShowSilverGuideConditionsConfig getPortalSilverGuideConfig2() {
        return (ShowSilverGuideConditionsConfig) getConfig("portal_page_silver_guide_config", new ShowSilverGuideConditionsConfig(0, null, 0, null, 15, null));
    }

    public final PortalStoreDressUpRecordParamConfig getPortalStoreDressUpRecordParamConfig() {
        return (PortalStoreDressUpRecordParamConfig) getConfig("zplan_portal_store_dress_up_record_param_config", new PortalStoreDressUpRecordParamConfig(0, 0, 0, null, 0, null, null, 127, null));
    }

    public final int getPortalUpdateColorRate() {
        i iVar = (i) getConfig("update_color_rate", i.class, "");
        if (iVar != null) {
            return iVar.getUpdateColorRate();
        }
        return 5;
    }

    public final ah getSameStyleConfig() {
        return (ah) getConfig("zplan_same_style_config", new ah());
    }

    public final ZPlanSettingOfficialGroupEntranceConfig getSettingOfficialGroupEntranceConfig() {
        return (ZPlanSettingOfficialGroupEntranceConfig) getConfig("zplan_setting_official_group_entrance_config", new ZPlanSettingOfficialGroupEntranceConfig());
    }

    public final SuperQQShowConfig getSuperQQShowGuideConfig() {
        return (SuperQQShowConfig) getConfig("aio_super_qq_show_float_dialog", new SuperQQShowConfig(null, null, null, null, 0, 31, null));
    }

    public final String getUGCJumpMyBagAllScheme() {
        return (String) getConfig("get_ugc_jump_my_bag_scheme", "mqqapi://zplan/enterAvatarScene?src_type=app&version=1.0&referer=12&sceneType=1&sceneData={\"ViewType\":1,\"SubScene\":{\"SceneType\":1,\"SceneParams\":{\"active_id\":\"my:2\", \"TryOnSource\": \"clothing_dyeing\", \"JumpToSource\": \"clothing_dyeing\", \"zplan_page_open_source\": \"pg_zplan_clothing_dyeing\"}}}");
    }

    public final an getXWConnectConfig() {
        return (an) getConfig("enable_xw_connect_base_config", new an());
    }

    public final ZPlanXWConnectFlowerConfig getXWConnectFlowerConfig() {
        return (ZPlanXWConnectFlowerConfig) getConfig("wx_connect_flower_config", new ZPlanXWConnectFlowerConfig(null, null, null, null, null, null, 63, null));
    }

    public final StartupConfig getXWConnectStartupConfig() {
        return (StartupConfig) getConfig("zplan_xw_connect_startup_param", new StartupConfig(0.0f, 0.0f, 0, 0, 0, 0, 63, null));
    }

    public final aq getXWConnectTipPage() {
        return (aq) getConfig("zplan_xw_connect_tip_page", new aq());
    }

    public final ZPlanAioMiniHomeConnEntranceConfig getZPlanAioMiniHomeConnEntranceConfig() {
        return (ZPlanAioMiniHomeConnEntranceConfig) getConfig("zplan_aio_mini_home_conn_entrance_config", new ZPlanAioMiniHomeConnEntranceConfig(false, 1, null));
    }

    public final c getZPlanBirthdayCareRecordConfig() {
        c cVar = (c) getConfig("get_zplan_birthday_care_record_config", c.class, "");
        return cVar == null ? new c() : cVar;
    }

    public final c.CloudCommonConfig getZPlanCloudCacheCommonConfig() {
        return (c.CloudCommonConfig) getConfig("zplan_record_cloud_cache_common_config", new c.CloudCommonConfig(false, null, 3, 0 == true ? 1 : 0));
    }

    public final String getZPlanCoupleIntimateGuideBubbleRichText() {
        return (String) getConfig("zplan_couple_intimate_guide_bubble_rich_text", "<b>\u8bd5\u8bd5\u53d1\u52a8\u4f5c</b>");
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public String getZPlanEmoticonCreateRoleScheme() {
        return ((e) getConfig("zplan_get_create_role_from_emoticon_scheme", new e())).getScheme();
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public f getZPlanEmoticonDetailConfig() {
        return (f) getConfig("zplan_emoticon_detail_config", new f());
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public g getZPlanEmoticonGrayTipsConfig() {
        g gVar = (g) getConfig("zplan_get_emoticon_gray_tips_config", g.class, "");
        return gVar == null ? new g() : gVar;
    }

    public final ZPlanEmoticonSizeConfig getZPlanEmoticonSizeConfig() {
        return (ZPlanEmoticonSizeConfig) getConfig("get_zplan_emoticon_size_config", new ZPlanEmoticonSizeConfig(false, 0, 0, 0, 0, 31, null));
    }

    public final ZPlanEmoticonTabCloudCacheRequestConfig getZPlanEmoticonTabCloudCacheRequestConfig() {
        return (ZPlanEmoticonTabCloudCacheRequestConfig) getConfig("zplan_emoticon_tab_cloud_cache_request_config", new ZPlanEmoticonTabCloudCacheRequestConfig(false, 0L, 0, 7, null));
    }

    public final ZPlanRRCResourceExpireConfig getZPlanRRCResourceExpireConfig() {
        return (ZPlanRRCResourceExpireConfig) getConfig("zplan_rrc_resource_expire_config", new ZPlanRRCResourceExpireConfig(0L, 0L, 0L, 7, null));
    }

    public final c.ForceDeleteResourceConfig getZPlanRecordForceDeleteConfig() {
        return (c.ForceDeleteResourceConfig) getConfig("zplan_record_force_delete_config", new c.ForceDeleteResourceConfig(0L, null, 3, null));
    }

    public final ZPlanShareConfig getZPlanShareConfig() {
        return (ZPlanShareConfig) getConfig("zplan_portal_share_configs", new ZPlanShareConfig(null, null, null, 0, null, 31, null));
    }

    public final ZPlanShareTemplateConfig getZPlanShareTemplateConfig() {
        return (ZPlanShareTemplateConfig) getConfig("zplan_share_template_configs", new ZPlanShareTemplateConfig(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public final ZPlanTofuAvatarConfig getZPlanTofuAvatarConfig() {
        return (ZPlanTofuAvatarConfig) getConfig("zplan_lite_aio_tofu_resource_config", new ZPlanTofuAvatarConfig(null, null, 3, null));
    }

    public final String getZootopiaParaiseConfig() {
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("zplan_zootopia_manager_config", new byte[0]);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getZootopiaParaiseConfig ");
        Charset charset = Charsets.UTF_8;
        sb5.append(new String(loadRawConfig, charset));
        QLog.i(TAG, 2, sb5.toString());
        if (loadRawConfig.length == 0) {
            return "{}";
        }
        return new String(loadRawConfig, charset);
    }

    public final String getZplanSettingCDKeyUrl() {
        return (String) getConfig("get_zplan_setting_cdkey_url", "https://show.qq.com/cp/a20220815dhzx/mobile.html");
    }

    @Override // com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC
    public boolean isSwitchOn(String group, boolean fallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(group, fallback);
    }

    public final long getDrawerJumpPortalDelayTime() {
        return ((Number) getConfig("zplan_drawer_jump_portal_delay_time", 100L)).longValue();
    }

    public final long getDrawerShowStaticDelayTime() {
        return ((Number) getConfig("zplan_drawer_portal_show_static_delay_time", 1000L)).longValue();
    }

    public final int getDynamicNativeAppFps() {
        return ((Number) getConfig("zplan_dynamic_native_app_fps", 30)).intValue();
    }

    public final long getEmoticonTabFileCacheSize() {
        return ((Number) getConfig("zplan_emoticon_tab_file_cache_size", 500L)).longValue();
    }

    public final long getMemeRecordFileCacheSize() {
        return ((Number) getConfig("zplan_meme_record_file_cache_size", 200L)).longValue();
    }

    public final long getMiniHomeConnectStrangerVisitRecommendTimeInterval() {
        return ((Number) getConfig("zplan_mini_home_connect_stranger_visit_recommend_time_interval", 1000L)).longValue();
    }

    public final int getMiniHomeConnectVisitStrangerTimeThreshold() {
        return ((Number) getConfig("zplan_mini_home_connect_stranger_visit_time_threshold", 10)).intValue();
    }

    public final long getRecordResourceCenterFileCacheSize() {
        return ((Number) getConfig("zplan_record_resource_center_file_cache_size", 500L)).longValue();
    }

    public final long getXwConnectOpRequestTimeInterval() {
        return ((Number) getConfig("xw_connect_op_request_time_interval", 1000L)).longValue();
    }

    public final long getMemeRecordTimeoutTime() {
        return ((Number) getConfig("zplan_meme_record_timeout", 65000L)).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T getConfig(String groupId, T fallback) {
        byte[] bArr;
        Object obj;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        try {
            bArr = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(groupId, new byte[0]);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "loadRawConfig " + groupId + " fail.", th5);
            bArr = null;
        }
        if (bArr == null) {
            return fallback;
        }
        if (bArr.length == 0) {
            return fallback;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(bArr, UTF_8);
        try {
            if (fallback instanceof Integer) {
                obj = Integer.valueOf(Integer.parseInt(str));
            } else if (fallback instanceof Long) {
                obj = Long.valueOf(Long.parseLong(str));
            } else if (fallback instanceof Boolean) {
                obj = Boolean.valueOf(Boolean.parseBoolean(str));
            } else {
                Gson a16 = GsonUtil.f385283b.a();
                Intrinsics.checkNotNull(fallback);
                obj = a16.fromJson(str, (Class<Object>) fallback.getClass());
            }
            return obj;
        } catch (Throwable th6) {
            QLog.e(TAG, 1, "parse config " + groupId + " fail. content:" + str, th6);
            return fallback;
        }
    }
}
