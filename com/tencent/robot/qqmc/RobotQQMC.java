package com.tencent.robot.qqmc;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.adelie.qqmc.model.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.create.CreateTextLimitNumber;
import com.tencent.robot.adelie.homepage.mine.part.CreateCenterBanner;
import com.tencent.robot.adelie.homepage.utils.n;
import com.tencent.robot.qqmc.model.RobotHomePageMineTabConfig;
import com.tencent.robot.qqmc.model.RobotHomeSuperResolutionConfig;
import com.tencent.robot.qqmc.model.RobotHomeSuperResolutionUinBlacklist;
import com.tencent.robot.qqmc.model.b;
import com.tencent.robot.qqmc.model.f;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t14.c;
import t14.d;
import t14.e;
import y14.GuidePicConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J3\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\rJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020#J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020\u0002J\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020*J\u0006\u0010-\u001a\u00020,J\u0006\u0010/\u001a\u00020.J\u0006\u00101\u001a\u000200J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0006\u00106\u001a\u000205R\u0014\u00107\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006;"}, d2 = {"Lcom/tencent/robot/qqmc/RobotQQMC;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", VipFunCallConstants.KEY_GROUP, "", AdMetricTag.FALLBACK, "isSwitchOn", "T", "groupId", "Ljava/lang/Class;", "configClass", "getConfig", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "Lcom/tencent/adelie/qqmc/model/a;", "getAdelieHomePageShareConfig", "enableAdelieHomePageShare", "Lt14/b;", "getHomePageBannerConfig", "disableHomePageRobotGuideExpandAnimation", "disableHomePageRobotGuideView", "enableHomePageBottomTab", "Lcom/tencent/robot/qqmc/model/g;", "getHomePageMineTabConfig", "Lcom/tencent/robot/qqmc/model/d;", "getHomePageSearchConfig", "Lcom/tencent/robot/qqmc/model/h;", "getHomePageSuperResolutionConfig", "Lcom/tencent/robot/qqmc/model/RobotHomeSuperResolutionUinBlacklist;", "getHomePageSuperResolutionUinBlacklist", "Lcom/tencent/robot/qqmc/model/c;", "getCreationAvatarConfig", "Lcom/tencent/robot/qqmc/model/b;", "getAiGenerateAvatarConfig", "enablePlusTabToTemplateList", "Lcom/tencent/robot/adelie/homepage/create/al;", "getAdelieCreateTextLimitNumber", "Lcom/tencent/robot/qqmc/model/e;", "getHomePageSubTitleText", "getGuidePicUrl", "enableSettingHighLight", "enableQQPicLoader", "Lcom/tencent/robot/adelie/homepage/mine/part/g;", "getCreateCenterBanner", "Lcom/tencent/robot/adelie/homepage/utils/n$a;", "getAdelieKuiklyScheme", "Lcom/tencent/robot/qqmc/model/a;", "getAiGenerateConfig", "Lcom/tencent/robot/qqmc/model/f;", "getRobotAssistantUrl", "enablePromptConversation", "disableCreativeCenterNtCpmpose", "enableCategoryHomeNtCompose", "Lt14/c;", "getCommunityRuleEntrance", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public final class RobotQQMC implements QRouteApi {

    @NotNull
    public static final RobotQQMC INSTANCE = new RobotQQMC();

    @NotNull
    private static final String TAG = "RobotQQMC";

    RobotQQMC() {
    }

    public final boolean disableCreativeCenterNtCpmpose() {
        return isSwitchOn("disable_adelie_creative_center_nt_compose", false);
    }

    public final boolean disableHomePageRobotGuideExpandAnimation() {
        return Intrinsics.areEqual(((d) getConfig("ibot_home_guide_config", new d())).getExpandOrNot(), "1");
    }

    public final boolean disableHomePageRobotGuideView() {
        return Intrinsics.areEqual(((d) getConfig("ibot_home_guide_config", new d())).getRobotGuideOrNot(), "1");
    }

    public final boolean enableAdelieHomePageShare() {
        return false;
    }

    public final boolean enableCategoryHomeNtCompose() {
        return isSwitchOn("enable_adelie_category_home_nt_compose", true);
    }

    public final boolean enableHomePageBottomTab() {
        return isSwitchOn("RobotHomePageBottomTab", true);
    }

    public final boolean enablePlusTabToTemplateList() {
        return isSwitchOn("RobotHomePagePlusTabToTemplateList", false);
    }

    public final boolean enablePromptConversation() {
        return isSwitchOn("adelie_prompt_conversation_switch", true);
    }

    public final boolean enableQQPicLoader() {
        return isSwitchOn("robot_enable_qq_pic_loader", true);
    }

    public final boolean enableSettingHighLight() {
        return isSwitchOn("robot_setting_high_light_enable", true);
    }

    @NotNull
    public final CreateTextLimitNumber getAdelieCreateTextLimitNumber() {
        return (CreateTextLimitNumber) getConfig("ibot_create_page_config", new CreateTextLimitNumber(0, 0, 0, 0, 15, null));
    }

    @NotNull
    public final a getAdelieHomePageShareConfig() {
        return (a) getConfig("102216", new a(null, null, null, null, null, 31, null));
    }

    @NotNull
    public final n.KuiklySchemeConfig getAdelieKuiklyScheme() {
        return (n.KuiklySchemeConfig) getConfig("adelie_kuikly_scheme", new n.KuiklySchemeConfig(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    @NotNull
    public final b getAiGenerateAvatarConfig() {
        return (b) getConfig("ibot_gen_avatar_max_count", new b());
    }

    @NotNull
    public final com.tencent.robot.qqmc.model.a getAiGenerateConfig() {
        return (com.tencent.robot.qqmc.model.a) getConfig("ibot_createpage_ai_gen_config", new com.tencent.robot.qqmc.model.a());
    }

    @NotNull
    public final c getCommunityRuleEntrance() {
        return (c) getConfig("adelie_community_rule_entrance", new c());
    }

    @Nullable
    public final <T> T getConfig(@NotNull String groupId, @NotNull Class<T> configClass, @NotNull String fallback) {
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
            return (T) GsonUtil.f368209a.a().fromJson(new String(loadRawConfig, UTF_8), (Class) configClass);
        } catch (JsonSyntaxException e16) {
            QLog.e(TAG, 1, "parse fail. ", e16);
            return null;
        }
    }

    @NotNull
    public final CreateCenterBanner getCreateCenterBanner() {
        return (CreateCenterBanner) getConfig("adelie_create_center_banner", new CreateCenterBanner(null, null, null, null, null, 31, null));
    }

    @NotNull
    public final com.tencent.robot.qqmc.model.c getCreationAvatarConfig() {
        return (com.tencent.robot.qqmc.model.c) getConfig("adelie_creation_avatar_config", new com.tencent.robot.qqmc.model.c());
    }

    @NotNull
    public final String getGuidePicUrl() {
        GuidePicConfig guidePicConfig = (GuidePicConfig) getConfig("robot_guide_pic_config", new GuidePicConfig(null, null, 3, null));
        if (QQTheme.isNowThemeIsNight()) {
            return guidePicConfig.getNightUrl();
        }
        return guidePicConfig.getDayUrl();
    }

    @NotNull
    public final t14.b getHomePageBannerConfig() {
        t14.b bVar = (t14.b) getConfig("robot_home_page_banner_config", new t14.b());
        List<e> a16 = bVar.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : a16) {
            if (((e) obj).i()) {
                arrayList.add(obj);
            }
        }
        bVar.c(arrayList);
        return bVar;
    }

    @NotNull
    public final RobotHomePageMineTabConfig getHomePageMineTabConfig() {
        return (RobotHomePageMineTabConfig) getConfig("RobotHomePageMineTabConfig", new RobotHomePageMineTabConfig(false, 1, null));
    }

    @NotNull
    public final com.tencent.robot.qqmc.model.d getHomePageSearchConfig() {
        return (com.tencent.robot.qqmc.model.d) getConfig("robot_home_page_search_config", new com.tencent.robot.qqmc.model.d());
    }

    @NotNull
    public final com.tencent.robot.qqmc.model.e getHomePageSubTitleText() {
        return (com.tencent.robot.qqmc.model.e) getConfig("robot_home_page_sub_title_config", new com.tencent.robot.qqmc.model.e());
    }

    @NotNull
    public final RobotHomeSuperResolutionConfig getHomePageSuperResolutionConfig() {
        return (RobotHomeSuperResolutionConfig) getConfig("robot_home_page_super_resolution_config", new RobotHomeSuperResolutionConfig(false, null, null, null, false, null, 63, null));
    }

    @NotNull
    public final RobotHomeSuperResolutionUinBlacklist getHomePageSuperResolutionUinBlacklist() {
        return (RobotHomeSuperResolutionUinBlacklist) getConfig("robot_home_page_super_resolution_uin_blacklist", new RobotHomeSuperResolutionUinBlacklist(null, 1, null));
    }

    @NotNull
    public final f getRobotAssistantUrl() {
        return (f) getConfig("adelie_assistant_entrance_config", new f());
    }

    public final boolean isSwitchOn(@NotNull String group, boolean fallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(group, fallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T getConfig(@NotNull String groupId, T fallback) {
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
                Gson a16 = GsonUtil.f368209a.a();
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
