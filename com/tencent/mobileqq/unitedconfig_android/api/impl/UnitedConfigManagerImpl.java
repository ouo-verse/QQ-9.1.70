package com.tencent.mobileqq.unitedconfig_android.api.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.freesia.BeaconBridge;
import com.tencent.freesia.CommandType;
import com.tencent.freesia.ConfigParserBridgeImpl;
import com.tencent.freesia.CustomField;
import com.tencent.freesia.CustomRuleBridge;
import com.tencent.freesia.Extend;
import com.tencent.freesia.ExtraInitInfo;
import com.tencent.freesia.FetchType;
import com.tencent.freesia.GetConfigReq;
import com.tencent.freesia.GroupInfo;
import com.tencent.freesia.HTTPBridge;
import com.tencent.freesia.IConfigData;
import com.tencent.freesia.IKVBridgeCreator;
import com.tencent.freesia.ILogger;
import com.tencent.freesia.ISoLoader;
import com.tencent.freesia.KV;
import com.tencent.freesia.MSFServletBridge;
import com.tencent.freesia.PBUtils;
import com.tencent.freesia.ReportBridge;
import com.tencent.freesia.SoLoader;
import com.tencent.freesia.SsoReportReq;
import com.tencent.freesia.Tick;
import com.tencent.freesia.UnitedConfig;
import com.tencent.freesia.UpperBridgesImpl;
import com.tencent.mobileqq.aio.msglist.holder.component.template.freesia.TemplateMsgFreesiaConfigParser;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.highway.api.impl.ConfigImplKt;
import com.tencent.mobileqq.mini.config.ad.MiniAdConfigParser;
import com.tencent.mobileqq.minigame.config.MiniGameCenterLaunchConfig;
import com.tencent.mobileqq.minigame.config.MiniGameConfig;
import com.tencent.mobileqq.minigame.config.MiniGameCustomLoadingConfig;
import com.tencent.mobileqq.minigame.config.MiniGamePallasConfig;
import com.tencent.mobileqq.minigame.config.MiniGamePreDownloadConfig;
import com.tencent.mobileqq.minigame.config.MiniGameSDKConfig;
import com.tencent.mobileqq.minigame.config.MiniGameVACustomConfig;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.config.WxMiniGameCenterLaunchConfig;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqcommon.api.INetworkUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoDeclare;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.unitedconfig_android.UnitedConfigServlet;
import com.tencent.mobileqq.unitedconfig_android.api.IFreesiaFetcher;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.unitedconfig_android.g;
import com.tencent.mobileqq.unitedconfig_android.h;
import com.tencent.mobileqq.unitedconfig_android.i;
import com.tencent.mobileqq.unitedconfig_android.k;
import com.tencent.mobileqq.unitedconfig_android.m;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasQQMcConstKt;
import com.tencent.mobileqq.vas.adv.maskad.config.MaskAdConfigParser;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import com.tencent.state.data.SwitchConfig;
import com.tencent.trpcprotocol.group_pro.configdistribution.config_distribution_svr.configDistributionSvr;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes17.dex */
public class UnitedConfigManagerImpl implements IUnitedConfigManager, IFreesiaFetcher, MSFServletBridge, INetInfoHandler, IWeakNetStatusHandler, IGuardInterface {
    static IPatchRedirector $redirector_ = null;
    private static final String CDN_DIR = "freesia/cdn";
    private static final long DEFAULT_FETCH_INTERVAL = 21600000;
    private static final String DEFAULT_UIN = "000";
    private static final String KEY_DEBUG_ENABLE = "key_debug_enable";
    private static final String KEY_FETCH_DISABLE = "100148";
    private static final int MAX_FETCH_COUNT = 10;
    private static final long ONE_HOUR = 3600000;
    private static final String PROJECT_ID = "10006";
    private static final String PROJECT_ID_TEST = "37";
    private static final Long PUSH_TYPE_FREESIA;
    private static final String REPORT_EVENT_FREQ_CONTROL = "unitedConfig_freq_control";
    private static final String REPORT_KEY_NO_LOGIN = "no_login";
    private static final String TAG = "FreesiaManager";
    private static final ArrayMap<String, Long> UIN_TO_FETCH_TIME;
    private static int fetchCount;

    @QAutoDeclare(configPath = "AutoInjectYml/Foundation/UnitedConfig-sdk/Inject_config.yml", version = 1)
    public static HashMap<String, String> injectParsersConfig;

    @QAutoDeclare(configPath = "AutoInjectYml/Foundation/UnitedConfig-sdk/Inject_config_no_login.yml", version = 1)
    public static HashMap<String, String> injectParsersConfigNoLogin;
    private static long lastFetchTime;
    private static volatile long lastRefetchTime;
    private static long noLoginLastFetchTime;
    private static volatile long noLoginLastRefetchTime;
    private final ILogger logger;
    private volatile boolean pushObserved;
    private volatile boolean register;
    private final UnitedConfig unitedConfig;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends UpperBridgesImpl {
        static IPatchRedirector $redirector_;

        a(ConfigParserBridgeImpl configParserBridgeImpl, MSFServletBridge mSFServletBridge, IKVBridgeCreator iKVBridgeCreator, ILogger iLogger, CustomRuleBridge customRuleBridge, HTTPBridge hTTPBridge, String str, BeaconBridge beaconBridge, Tick tick) {
            super(configParserBridgeImpl, mSFServletBridge, iKVBridgeCreator, iLogger, customRuleBridge, hTTPBridge, str, beaconBridge, tick);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UnitedConfigManagerImpl.this, configParserBridgeImpl, mSFServletBridge, iKVBridgeCreator, iLogger, customRuleBridge, hTTPBridge, str, beaconBridge, tick);
            }
        }

        @Override // com.tencent.freesia.UpperBridges
        @NonNull
        public String getCurrentUin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                String uin = UnitedConfigManagerImpl.this.getUin();
                if (uin == null) {
                    return "";
                }
                return uin;
            }
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.freesia.UpperBridges
        public boolean isLogin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements ILogger {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UnitedConfigManagerImpl.this);
            }
        }

        @Override // com.tencent.freesia.ILogger
        public void d(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.d(str, 2, str2);
            }
        }

        @Override // com.tencent.freesia.ILogger
        public void e(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else {
                QLog.e(str, 1, str2);
            }
        }

        @Override // com.tencent.freesia.ILogger
        public void i(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.i(str, 2, str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35427);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
            return;
        }
        PUSH_TYPE_FREESIA = 360L;
        UIN_TO_FETCH_TIME = new ArrayMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        injectParsersConfig = hashMap;
        hashMap.put("106110", "com.tencent.mobileqq.guild.config.GuildFeedPreferConfigParser");
        injectParsersConfig.put("105814", "com.tencent.gdtad.config.parser.GdtWXMiniJumpConfigParser");
        injectParsersConfig.put("106076", "com.tencent.robot.aio.pluspanel.config.RobotMixMsgConfigParser");
        injectParsersConfig.put("106050", "com.tencent.mobileqq.vashealth.config.HealthCommonConfigParser");
        injectParsersConfig.put("105985", "com.tencent.mobileqq.guild.config.GuildFeedTextLineNumberConfigParser");
        injectParsersConfig.put("105929", "com.tencent.mobileqq.webviewplugin.config.StudyModeWebInterceptWhiteListConfigParser");
        injectParsersConfig.put("105926", "com.tencent.mobileqq.webviewplugin.config.StudyModeWebInterceptSwitchConfigParser");
        injectParsersConfig.put("qq_share_panel_config", "com.tencent.mobileqq.sharepanel.config.united.SharePanelSwitchConfigParser");
        injectParsersConfig.put("qq_search_audio_ai_config", "com.tencent.mobileqq.search.config.SearchAudioAIConfigParser");
        injectParsersConfig.put("105844", "com.tencent.mobileqq.guild.config.GuildOfficialIconConfigParser");
        injectParsersConfig.put("105835", "com.tencent.mobileqq.guild.config.GuildQUIProfileConfigParser");
        injectParsersConfig.put("105763", "com.tencent.mobileqq.vas.adv.negativefeedback.config.NFBHeartBeatConfigParser");
        injectParsersConfig.put("msf_quic_engine_config", "com.tencent.mobileqq.config.MSFCoreQuicEngineConfigParser");
        injectParsersConfig.put("msf_core_network_moduel_config", "com.tencent.mobileqq.config.MSFCoreNetworkConfigParser");
        injectParsersConfig.put(MiniGamePallasConfig.CONFIG_ID, "com.tencent.mobileqq.minigame.config.MiniGamePallasConfigParser");
        injectParsersConfig.put("105592", "com.tencent.mobileqq.perf.thread.proxy.ThreadProxyConfigParser");
        injectParsersConfig.put("105485", "com.tencent.mobileqq.troop.troopsquare.common.TroopSquareConfigParser");
        injectParsersConfig.put("105449", "com.tencent.mobileqq.guild.feed.guildbox.utils.GuildBoxConfigParser");
        injectParsersConfig.put("105477", "com.tencent.mobileqq.perf.thread.config.ThreadPoolMonitorParser");
        injectParsersConfig.put("msf_ssid_config", "com.tencent.mobileqq.config.MSFCoreSSIDConfigParser");
        injectParsersConfig.put("105440", "com.tencent.mobileqq.minigame.config.MiniGameRetainConfigParser");
        injectParsersConfig.put("ai_assisted_chat_config", "com.tencent.qqnt.aio.assistedchat.config.AiAssistedChatParser");
        injectParsersConfig.put("103213", "com.tencent.robot.aio.input.inputbar.config.RobotAtConfigParser");
        injectParsersConfig.put("103274", "com.tencent.gdtad.config.parser.LebaShoppingDisclaimerConfigParser");
        injectParsersConfig.put("tianshu_in_site_push_config", "com.tencent.mobileqq.tianshu.parser.PageSceneTimeParser");
        injectParsersConfig.put("tianshu_page_scene_manager_config", "com.tencent.mobileqq.tianshu.parser.PageSceneConfigParser");
        injectParsersConfig.put("103097", "com.tencent.mobileqq.guild.config.GuildChannelFeedForwardGrayConfigParser");
        injectParsersConfig.put("103139", "com.tencent.mobileqq.guild.feed.excellentcase.config.ExcellentCaseConfigParser");
        injectParsersConfig.put("102905", "com.tencent.mobileqq.perf.thread.config.ThreadBlockParser");
        injectParsersConfig.put("msf_core_monitor_config", "com.tencent.mobileqq.config.MSFCoreMonitorConfigParser");
        injectParsersConfig.put("102934", "com.tencent.mobileqq.guild.setting.guildmanage.feedsquare.config.FeedSquareConfParser");
        injectParsersConfig.put("105684", "com.tencent.mobileqq.guild.config.GuildArgusPreloadConfigParser");
        injectParsersConfig.put("103241", "com.tencent.mobileqq.guild.config.GuildShare2WechatParser");
        injectParsersConfig.put("102768", "com.tencent.mobileqq.guild.feed.nativedetail.dialog.FeedStandardConfParser");
        injectParsersConfig.put("103007", "com.tencent.mobileqq.gamecenter.search.SearchPopUnitedConfigParser");
        injectParsersConfig.put("102704", "com.tencent.mobileqq.springhb.config.GameHbUnitedConfigParser");
        injectParsersConfig.put("102715", "com.tencent.mobileqq.takedown.config.ConfigParser");
        injectParsersConfig.put("102606", "com.tencent.robot.share.config.RobotShareToWXConfigProcessor");
        injectParsersConfig.put("103108", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("102634", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("rich_ui_template_id_black", "com.tencent.qqnt.rich.config.RichUiTemplateIdBlackListConfigParser");
        injectParsersConfig.put("rich_ui_business_url_whitelist", "com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.RichSourceWhiteConfigParser");
        injectParsersConfig.put("rich_ui_msg_reply_jump_scheme", "com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.RichReplyClickConfigParser");
        injectParsersConfig.put("forward_rich_msg_white", "com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.RichForwardWhiteConfigParser");
        injectParsersConfig.put("robot_shot_config", "com.tencent.mobileqq.aio.longshot.RobotShotConfigProcessor");
        injectParsersConfig.put("102516", "com.tencent.gdtad.basics.config.AmsBannerAdConfigParser");
        injectParsersConfig.put("102407", "com.tencent.gdtad.basics.config.RealTimeSplashConfigParser");
        injectParsersConfig.put("102396", "com.tencent.mobileqq.guild.feed.config.GuildFeedSquareConfigParser");
        injectParsersConfig.put("qqstranger_square_publish_recommend", "com.tencent.mobileqq.matchfriend.reborn.publish.config.QQStrangerSquarePublishConfigParser");
        injectParsersConfig.put("102401", "com.tencent.mobileqq.qqlive.huya.QQLiveHuYaConfigParser");
        injectParsersConfig.put("102475", "com.tencent.mobileqq.perf.memory.largeobject.LargeObjectConfigParser");
        injectParsersConfig.put("stranger_mark_resource", "com.tencent.mobileqq.matchfriend.reborn.mark.config.QQStrangerMarkConfigParser");
        injectParsersConfig.put("msf_wake_lock_config", "com.tencent.mobileqq.config.MSFWakeLockConfigParser");
        injectParsersConfig.put("102405", "com.tencent.gdtad.basics.config.AdAppInstallConfigParser");
        injectParsersConfig.put(ConfigImplKt.CONFIG_GROUP, "com.tencent.mobileqq.highway.api.impl.KernelConfigParser");
        injectParsersConfig.put("102279", "com.tencent.qqperf.monitor.file.ExternFileMonitorConfigParser");
        injectParsersConfig.put("102199", "com.tencent.gdtad.basics.config.NsrConfigParser");
        injectParsersConfig.put("102093", "com.tencent.gdtad.basics.config.ScheduleAdConfigParser");
        injectParsersConfig.put("102174", "com.tencent.mobileqq.weather.config.WeatherRetainDialogConfigParser");
        injectParsersConfig.put("qzone_holiday_source_material", "com.tencent.mobileqq.service.qzone.parser.QZoneHolidaySourceConfigParser");
        injectParsersConfig.put("101851", "com.tencent.mobileqq.qqlive.kuikly.QQLiveKuiklyConfigParser");
        injectParsersConfig.put("101793", "com.tencent.mobileqq.minikuikly.config.MiniKuiklyConfigParser");
        injectParsersConfig.put("101586", "com.tencent.gdtad.basics.config.AmsSplashAdConfigParser");
        injectParsersConfig.put("101832", "com.tencent.mobileqq.zplan.aigc.parser.ZPlanSuitOutfitPreviewBgConfigParser");
        injectParsersConfig.put("101805", "com.tencent.mobileqq.zplan.aigc.parser.ZPlanSuitOutfitPreviewConfigParser");
        injectParsersConfig.put("101625", "com.tencent.mobileqq.springhb.interactive.config.DegradeConfigParser");
        injectParsersConfig.put("101533", "com.tencent.qqnt.emotion.stickerrecommended.config.CacheVersionParser");
        injectParsersConfig.put("101571", "com.tencent.qqnt.emotion.stickerrecommended.config.StickerRecConfigParser");
        injectParsersConfig.put("leba_plugin_data_patch", "com.tencent.mobileqq.leba.data.LebaPatchResourceUnitedConfigParser");
        injectParsersConfig.put("leba_patch_config", "com.tencent.mobileqq.leba.data.LebaPatchUnitedConfigParser");
        injectParsersConfig.put("quanjupeizhi_4042", "com.tencent.mobileqq.leba.data.LebaPluginListUnitedConfigParser");
        injectParsersConfig.put("mmkv_print_config", "com.tencent.mobileqq.qmmkv.MMKVPrintConfigParser");
        injectParsersConfig.put("mmkv_reduce_config", "com.tencent.mobileqq.qmmkv.MMKVReduceConfigParser");
        injectParsersConfig.put("mmkv_report_config", "com.tencent.mobileqq.qmmkv.MMKVConfigParser");
        injectParsersConfig.put("101595", "com.tencent.mobileqq.config.ThreadMonitorConfigParser");
        injectParsersConfig.put("101580", "com.tencent.mobileqq.config.business.ExtensionAniStickerConfProcessor");
        injectParsersConfig.put("manage_clean_ids", "com.tencent.mobileqq.config.QManageCleanConfigParser");
        injectParsersConfig.put("101491", "com.tencent.mobileqq.intervideo.groupvideo.GroupVideoConfig");
        injectParsersConfig.put("switch_account_restart_process", "com.tencent.mobileqq.login.restart.LoginProcessRestartConfigParser");
        injectParsersConfig.put("zplan_status_square_online_status_config", "com.tencent.mobileqq.config.square.SquareOnlineStatusConfigProcessor");
        injectParsersConfig.put(SwitchConfig.Group.filamentCoverRecord, "com.tencent.mobileqq.vas.qqmc.SquareFilamentCoverRecordConfigParser");
        injectParsersConfig.put("test_for_safemode_clear", "com.tencent.qqperf.safemode.SafeModeTestQQMCClearConfigProcessor");
        injectParsersConfig.put("light_msg_queue", "com.tencent.mobileqq.perf.thread.handlerthread.LightMessageQueueConfigProcessor");
        injectParsersConfig.put("fd_monitor_config", "com.tencent.qqperf.monitor.filedescriptor.FileDescriptorMonitorConfigProcessor");
        injectParsersConfig.put("aio_plus_panel_order_config", "com.tencent.qqnt.pluspanel.config.C2CPlusPanelAppOrderConfigProcessor");
        injectParsersConfig.put("aio_plus_panel_app_config", "com.tencent.qqnt.pluspanel.config.C2CPlusPanelAppInfoConfigProcessor");
        injectParsersConfig.put("102793", "com.tencent.mobileqq.troop.troopcreate.classify.detail.TroopCreateClassifyConfigParser");
        injectParsersConfig.put("102769", "com.tencent.mobileqq.troop.memberlevel.api.TroopMemberLevelConfigParser");
        injectParsersConfig.put("105422", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("102575", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("102642", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("102391", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("102522", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("101934", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("102125", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("102082", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("102002", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("101731", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("101420", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("qq_stranger_config", "com.tencent.mobileqq.matchfriend.reborn.config.QQStrangerConfigParser");
        injectParsersConfig.put(ITDocFileBrowserFacade.TDOC_FILE_BROWSER_LOAD_CONFIG_KEY, "com.tencent.mobileqq.teamwork.TDocLocalFileConfigParser");
        injectParsersConfig.put("101316", "com.tencent.mobileqq.config.business.qlink.QLinkEntranceConfigParser");
        injectParsersConfig.put("101322", "com.tencent.mobileqq.hippy.HippyBundleConfigParser");
        injectParsersConfig.put("101254", "com.tencent.mobileqq.search.config.SearchOptConfigParser");
        injectParsersConfig.put("qun_aigc_qrcode_card", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("101228", "com.tencent.mobileqq.ad.emoji.CommercialEmojiConfigParser");
        injectParsersConfig.put("101212", "com.tencent.mobileqq.guild.config.subconfig.parser.GuildSpeakRuleParser");
        injectParsersConfig.put("InputMaterialCacheKey", "com.tencent.qqnt.emotion.stickerrecommended.InputMaterialCacheKeyParser");
        injectParsersConfig.put("101147", "com.tencent.mobileqq.search.config.SearchEntryConfigParser");
        injectParsersConfig.put("101159", "com.tencent.gdtad.basics.config.DownloadAdDomainConfigParser");
        injectParsersConfig.put("upgrade_config_use_platform_type", "com.tencent.mobileqq.upgrade.UpgradeConfigTypeParser");
        injectParsersConfig.put("101162", "com.tencent.mobileqq.dt.StartUpDtSampleConfigParser");
        injectParsersConfig.put("101136", "com.tencent.qqnt.aio.pref.memory.AIOEnterLeaveMemConfigParser");
        injectParsersConfig.put("msf_multi_conn_config", "com.tencent.mobileqq.config.business.MsfMultiTcpParser");
        injectParsersConfig.put("msf_sample_rate_config", "com.tencent.mobileqq.config.business.msf.MSFSampleRateConfigParser");
        injectParsersConfig.put("runtime_srv_config", "com.tencent.mobileqq.mqqconfig.RuntimeSrvConfigParser");
        injectParsersConfig.put("aio_vh_config", "com.tencent.qqnt.aio.config.AIOVHCacheParamConfigParser");
        injectParsersConfig.put("beacon_channel_config", "com.tencent.mobileqq.statistics.BeaconChannelParser");
        injectParsersConfig.put("msf_udp_config", "com.tencent.mobileqq.config.business.MsfUdpConfigParser");
        injectParsersConfig.put("msf_common_config", "com.tencent.mobileqq.config.business.MSFConfigParser");
        injectParsersConfig.put("100863", "com.tencent.qqmini.config.MiniAppConfigParser");
        injectParsersConfig.put("100885", "com.tencent.mobileqq.config.business.MiniAppApiReportConfigParser");
        injectParsersConfig.put("100892", "com.tencent.mobileqq.mini.config.FileMaterialConfigParser");
        injectParsersConfig.put("setting_me_view_list_v3", "com.tencent.mobileqq.utils.QQSettingMeViewListConfigProccessor");
        injectParsersConfig.put("lightsdk_bundle_hotfix_android", "com.tencent.aelight.camera.ae.download.AEResNewManagerConfigParser");
        injectParsersConfig.put("tianshu_user_unlocking_report", "com.tencent.mobileqq.tianshu.parser.UnlockLimitTimeConfigParser");
        injectParsersConfig.put("tianshu_red_request_black_list", "com.tencent.mobileqq.tianshu.config.RedRequestBlackListParser");
        injectParsersConfig.put("tianshu_common_ad_reqpuest_black_list", "com.tencent.mobileqq.tianshu.config.AdRequestBlackListParser");
        injectParsersConfig.put("push_notify_dialog_tab", "com.tencent.mobileqq.tianshu.config.PushDialogParser");
        injectParsersConfig.put("tianshu_offline_push_block_time", "com.tencent.mobileqq.tianshu.parser.PushLimitTimeConfigParser");
        injectParsersConfig.put("tianshu_push", "com.tencent.mobileqq.notification.modularize.TianShuPushConfigParser");
        injectParsersConfig.put("aio_enter_perf_report", "com.tencent.qqnt.aio.report.AIOEnterPerfConfigParser");
        injectParsersConfig.put("100879", "com.tencent.mobileqq.groupvideo.config.ODUnitedConfigParser");
        injectParsersConfig.put("online_file_print", "com.tencent.mobileqq.filemanager.fileviewer.onlineprint.OnlinePrintConfigParser");
        injectParsersConfig.put("clean_main_db_msg", "com.tencent.mobileqq.fragment.overview.config.CleanMainDBConfigParser");
        injectParsersConfig.put("chat_list_card_container_config", "com.tencent.mobileqq.cardcontainer.config.CardContainerConfigParser");
        injectParsersConfig.put("notification_msg_reply_config", "com.tencent.mobileqq.notification.reply.MsgReplyConfigParse");
        injectParsersConfig.put("growth_business_push_switch_config", "com.tencent.mobileqq.settings.business.GrowthPushSwitchParse");
        injectParsersConfig.put("qq_conversation_second_button_config", "com.tencent.mobileqq.util.conversationtitlebutton.ConversationTitleBtnParse");
        injectParsersConfig.put("clean_up_thorough", "com.tencent.mobileqq.app.message.cleanup.config.CleanUpConfigParser");
        injectParsersConfig.put("100862", "com.tencent.qq.minibox.permissions.PermissionConfigProcessor");
        injectParsersConfig.put("100853", "com.tencent.mobileqq.minigame.publicaccount.config.MiniGameConfigProcessor");
        injectParsersConfig.put("102392", "com.tencent.mobileqq.guild.discoveryv2.config.GuildDiscRefreshConfigParser");
        injectParsersConfig.put("101977", "com.tencent.mobileqq.guild.discoveryv2.config.GuildMVPConfigParser");
        injectParsersConfig.put("102278", "com.tencent.robot.aio.helper.msgreport.RobotMsgReportConfigParser");
        injectParsersConfig.put("101141", "com.tencent.mobileqq.nearbypro.part.guide.NearbyProGuideConfigParser");
        injectParsersConfig.put("100973", "com.tencent.mobileqq.perf.process.config.CacheConfigParser");
        injectParsersConfig.put("100972", "com.tencent.mobileqq.perf.process.config.MainProcConfigParser");
        injectParsersConfig.put("100970", "com.tencent.mobileqq.perf.process.config.ForegroundConfigParser");
        injectParsersConfig.put("100969", "com.tencent.mobileqq.perf.process.config.BackgroundConfigParser");
        injectParsersConfig.put("100852", "com.tencent.mobileqq.mini.config.AppDetainFreqConfigProcessor");
        injectParsersConfig.put("android_eggs_config", "com.tencent.qqnt.aio.config.AIOAnimationParser");
        injectParsersConfig.put("105697", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("102735", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("102686", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("102675", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put(ITroopMemberCacheService.CONFIG_ID, "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("101734", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("101294", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("101079", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("101068", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100927", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100926", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100886", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100861", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100829", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100837", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100817", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100703", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100704", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100705", "com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser");
        injectParsersConfig.put("100795", "com.tencent.mobileqq.troop.honor.config.TroopHonorConfigParser");
        injectParsersConfig.put("100749", "com.tencent.mobileqq.upgrade.unitedconfig.UpgradeConfigParser");
        injectParsersConfig.put("100697", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("friend_clue_config", "com.tencent.mobileqq.relationx.friendclue.FriendClueConfigParser");
        injectParsersConfig.put("100525", "com.tencent.mobileqq.search.config.TnnGroupSearchResultConfigParser");
        injectParsersConfig.put("100524", "com.tencent.mobileqq.search.tnn.config.SearchTnnConfigParser");
        injectParsersConfig.put("100523", "com.tencent.mobileqq.search.config.GroupSearchResultConfigParser");
        injectParsersConfig.put("100522", "com.tencent.mobileqq.config.business.search.VerticalSearchParser");
        injectParsersConfig.put("100521", "com.tencent.mobileqq.config.business.search.SearchBusinessConfParser");
        injectParsersConfig.put("100520", "com.tencent.mobileqq.config.business.search.SearchHotWordConfParser");
        injectParsersConfig.put("100519", "com.tencent.mobileqq.config.business.GlobalSearchConfParser");
        injectParsersConfig.put("100515", "com.tencent.mobileqq.search.searchlocal.config.SearchFunctionModuleParser");
        injectParsersConfig.put("100501", "com.tencent.mobileqq.config.business.search.SearchRichConfParser");
        injectParsersConfig.put("101599", "com.tencent.mobileqq.activity.aio.intimate.config.InteractSendMsgConfigParser");
        injectParsersConfig.put("101643", "com.tencent.mobileqq.config.aio.ZhuoXusConfigParser");
        injectParsersConfig.put("101312", "com.tencent.mobileqq.config.aio.PokeItemConfigParser");
        injectParsersConfig.put("101556", "com.tencent.mobileqq.studymode.StudyModeSwitchDialogConfigProcessor");
        injectParsersConfig.put("101555", "com.tencent.mobileqq.studymode.StudyModePushConfigProcessor");
        injectParsersConfig.put("101534", "com.tencent.util.notification.NotificationConParser");
        injectParsersConfig.put("101531", "com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoConfigProcessor");
        injectParsersConfig.put("101318", "com.tencent.mobileqq.config.business.EmoticonQBoxConfProcessor");
        injectParsersConfig.put("105418", "com.tencent.mobileqq.wechatMsgAgent.WeChatMsgAgentIUnConfig");
        injectParsersConfig.put("101424", "com.tencent.mobileqq.tofumsg.TofuConfigParser");
        injectParsersConfig.put("100952", "com.tencent.mobileqq.config.business.OnlineStatusConfProcessor");
        injectParsersConfig.put("101230", "com.tencent.mobileqq.config.business.ScenesEmotionConfigProcessor");
        injectParsersConfig.put("101224", "com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor");
        injectParsersConfig.put("101223", "com.tencent.mobileqq.activity.recent.config.optpopbar.RecentOptPopBarSwitchProcessor");
        injectParsersConfig.put("101220", "com.tencent.mobileqq.config.aio.ZhiTuConfParser");
        injectParsersConfig.put("101325", "com.tencent.mobileqq.config.business.OnlineAutoStatusConfProcessor");
        injectParsersConfig.put("101219", "com.tencent.mobileqq.config.business.TroopFoldMsgConfProcessor");
        injectParsersConfig.put("101126", "com.tencent.mobileqq.config.business.QConfPushProcessor");
        injectParsersConfig.put("101124", "com.tencent.mobileqq.shortvideo.RedDotConfProcessor");
        injectParsersConfig.put("100978", "com.tencent.mobileqq.guild.config.GuildLeftbarGuideContentParser");
        injectParsersConfig.put("101021", "com.tencent.mobileqq.config.business.RichmediaHttpsConfProcessor");
        injectParsersConfig.put("101009", "com.tencent.mobileqq.config.business.MarketEmoticonConfProcessor");
        injectParsersConfig.put("101005", "com.tencent.mobileqq.config.aio.RichTextChatConfParser");
        injectParsersConfig.put("100933", "com.tencent.mobileqq.config.aio.DoutuConfParser");
        injectParsersConfig.put("100932", "com.tencent.mobileqq.selectmember.SelectMsgShareProcessor");
        injectParsersConfig.put("100931", "com.tencent.mobileqq.config.business.DonDisturbProcessor");
        injectParsersConfig.put("100887", "com.tencent.mobileqq.config.business.GifPreDownloadConfProcessor");
        injectParsersConfig.put("100828", "com.tencent.mobileqq.config.business.PttWithTextSwitchProcessor");
        injectParsersConfig.put("100813", "com.tencent.mobileqq.config.aio.MultiMsgConfParser");
        injectParsersConfig.put("100810", "com.tencent.mobileqq.config.business.NotificationBannerConfProcessor");
        injectParsersConfig.put("100839", "com.tencent.mobileqq.bigbrother.TeleScreenConfig");
        injectParsersConfig.put("100639", "com.tencent.mobileqq.guild.config.GuildArkStrokeConfigParser");
        injectParsersConfig.put(TemplateMsgFreesiaConfigParser.CONFIG_ID, "com.tencent.mobileqq.aio.msglist.holder.component.template.freesia.TemplateMsgFreesiaConfigParser");
        injectParsersConfig.put("100677", "com.tencent.mobileqq.ark.config.qqmc.AIDictParser");
        injectParsersConfig.put("100640", "com.tencent.mobileqq.ark.config.qqmc.ArkPlatformConfParser");
        injectParsersConfig.put("ark_extend_info", "com.tencent.mobileqq.ark.config.qqmc.ArkExtendConfParser");
        injectParsersConfig.put("101301", "com.tencent.mobileqq.ark.config.qqmc.ArkFavConfigParser");
        injectParsersConfig.put("100679", "com.tencent.mobileqq.ark.config.qqmc.ArkEnvironmentConfigParser");
        injectParsersConfig.put(IGameCenterUnitedConfigApi.GAMEPLAT_BUBBLE_REQUEST_INTERVAL, "com.tencent.mobileqq.reminder.config.ReminderConfigParser");
        injectParsersConfig.put("base_opentelemetry_config", "com.tencent.mobileqq.tianjige.ntkernel.NtMetricParser");
        injectParsersConfig.put("weiyun_miniapp_entrance", "com.tencent.mobileqq.config.WeiYunMiniAppProcessor");
        injectParsersConfig.put("tdoc_aio_plus_tdoc_entrance", "com.tencent.mobileqq.config.business.tendoc.TencentDocUserConfigProcessor");
        injectParsersConfig.put("tdoc_my_file_tencent_doc_name", "com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor");
        injectParsersConfig.put("tdoc_group_online_entrance_support_url", "com.tencent.mobileqq.config.business.tendoc.TenDocGroupListEntryConfigProcessor");
        injectParsersConfig.put("tdoc_import_tencent_doc_entrance", "com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor");
        injectParsersConfig.put("tdoc_local_file_safe_share", "com.tencent.mobileqq.config.business.tendoc.TenDocDirectShareConfigProcessor");
        injectParsersConfig.put("tdoc_is_docs_detail_page_config", "com.tencent.mobileqq.config.business.TencentDocsIsDetailPageProcessor");
        injectParsersConfig.put("tdoc_mini_app_config", "com.tencent.mobileqq.config.business.TencentDocsPushProcessor");
        injectParsersConfig.put("tdoc_local_file_web_online_preview", "com.tencent.mobileqq.filemanager.fileviewer.docs.TroopDocsPreviewConfigProcessor");
        injectParsersConfig.put("tdoc_local_form_key_words", "com.tencent.mobileqq.config.business.tendoc.TencentDocFormKeyWordsProcessor");
        injectParsersConfig.put("tdoc_local_file_cooperation_bottom_bar", "com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor");
        injectParsersConfig.put("tdoc_local_file_online_preview_use_tencent_doc", "com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor");
        injectParsersConfig.put("100689", "com.tencent.imcore.message.NtMsgFilterParser");
        injectParsersConfig.put("100311", "com.tencent.qqnt.aio.predownload.pic.config.freesia.GIFPreDownloadConfigParser");
        injectParsersConfig.put("100318", "com.tencent.qqnt.aio.predownload.pic.config.freesia.PicAIOExposurePreDownloadConfigParser");
        injectParsersConfig.put("100276", "com.tencent.qqnt.aio.predownload.pic.config.freesia.PicMsgReceivePreDownloadConfigParser");
        injectParsersConfig.put("spring_common_config", "com.tencent.mobileqq.springhb.config.SpringHbCommonConfProcessor");
        injectParsersConfig.put(EcshopConfProcessor.CONFIG_ID, "com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor");
        injectParsersConfig.put(IPreloadService.PREF_NAME_QWALLET_PRELOAD_CONFIG, "com.tencent.mobileqq.qwallet.config.PreloadConfProcessor");
        injectParsersConfig.put("cpuFrontMonitor", "com.tencent.mobileqq.power.config.CpuParser");
        injectParsersConfig.put("enable_filament_scene_config", "com.tencent.mobileqq.zplan.lite.util.ZPlanFilamentSceneConfigParser");
        injectParsersConfig.put("enable_filament_base_config", "com.tencent.mobileqq.zplan.lite.util.ZPlanFilamentBaseConfigParser");
        injectParsersConfig.put(MiniGameSDKConfig.CONFIG_ID, "com.tencent.mobileqq.minigame.config.MiniGameSDKConfigParser");
        injectParsersConfig.put("100646", "com.tencent.mobileqq.guild.client.GuildClientConfigParser");
        injectParsersConfig.put("100604", "com.tencent.mobileqq.config.business.qfile.QFileDownloadConfigParser");
        injectParsersConfig.put("100599", "com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfigParser");
        injectParsersConfig.put("100537", "com.tencent.mobileqq.guild.config.subconfig.parser.GuildShareConfigParser");
        injectParsersConfig.put("100529", "com.tencent.mobileqq.guild.config.subconfig.parser.GuildChannelMsgNotifyParser");
        injectParsersConfig.put("100528", "com.tencent.mobileqq.guild.config.subconfig.parser.GuildMemoryReleaseParser");
        injectParsersConfig.put("102227", "com.tencent.mobileqq.guild.config.subconfig.parser.GuildTabNameConfigParser");
        injectParsersConfig.put("100556", "com.tencent.mobileqq.guild.config.GuildCoverConfigParser");
        injectParsersConfig.put("106061", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("106048", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("105827", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("105813", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("105748", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("105455", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("103129", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("103101", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("102984", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("102890", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("102677", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("102564", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("102429", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("101719", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("101188", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100960", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100915", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100577", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100576", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100575", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100574", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100573", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100569", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100568", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100549", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100546", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100545", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100543", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100541", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100540", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100535", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100534", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100533", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100530", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100597", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100595", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100594", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100593", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100592", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100591", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100590", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100589", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100588", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100587", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100584", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100582", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100567", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100566", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100562", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100561", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100560", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100559", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100554", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100539", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100551", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("100544", "com.tencent.mobileqq.guild.config.QQGuildMCParser");
        injectParsersConfig.put("105884", "com.tencent.mobileqq.guild.config.GuildFeedShareConfigParser");
        injectParsersConfig.put("102943", "com.tencent.mobileqq.guild.config.GuildDrawerItemConfigParser");
        injectParsersConfig.put("100531", "com.tencent.mobileqq.guild.config.subconfig.parser.GuildNewUserNoticeConfigParser");
        injectParsersConfig.put("100693", "com.tencent.mobileqq.groupvideo.config.ODUnitedConfigParser");
        injectParsersConfig.put("100633", "com.tencent.mobileqq.qqguildsdk.config.GuildPicDomainNameConfigParser");
        injectParsersConfig.put("100611", "com.tencent.mobileqq.qqguildsdk.config.GProSdkTjgConfigParser");
        injectParsersConfig.put("102658", "com.tencent.gdtad.config.parser.GdtConfigParserForFeedback");
        injectParsersConfig.put("102923", "com.tencent.gdtad.config.parser.GdtConfigParserForMotiveHippyPreDownloadTemplate");
        injectParsersConfig.put("102670", "com.tencent.gdtad.config.parser.GdtConfigParserForMotiveHippy");
        injectParsersConfig.put("103109", "com.tencent.gdtad.config.parser.GdtConfigParserForMetricReport");
        injectParsersConfig.put("105716", "com.tencent.gdtad.config.parser.GdtConfigParserForWXCustomerService");
        injectParsersConfig.put("105538", "com.tencent.gdtad.config.parser.GdtConfigParserForDeeplinkLaunchTracer");
        injectParsersConfig.put("102518", "com.tencent.gdtad.config.parser.GdtConfigParserForAnalysisReport");
        injectParsersConfig.put("102454", "com.tencent.gdtad.config.parser.GdtConfigParserForLinkReport");
        injectParsersConfig.put("102399", "com.tencent.gdtad.config.parser.GdtConfigParserForMsgReport");
        injectParsersConfig.put("102445", "com.tencent.gdtad.config.parser.GdtConfigParserForQuickApp");
        injectParsersConfig.put("102436", "com.tencent.gdtad.config.parser.GdtConfigParserForDeviceInfo");
        injectParsersConfig.put("100411", "com.tencent.gdtad.splash.mcconfig.GdtSplashAdCacheConfigParser");
        injectParsersConfig.put("100410", "com.tencent.gdtad.splash.mcconfig.GdtSplashAdPreloadConfigParser");
        injectParsersConfig.put("100409", "com.tencent.gdtad.splash.mcconfig.GdtSplashAdSwitchConfigParser");
        injectParsersConfig.put("100500", "com.tencent.mobileqq.gamecenter.qa.config.GameRobotConfigParser");
        injectParsersConfig.put("101269", "com.tencent.mobileqq.gamecenter.qa.config.MetaDreamFrameworkConfigParser");
        injectParsersConfig.put("101637", "com.tencent.mobileqq.gamecenter.qa.config.MetaDreamNotificationConfigParser");
        injectParsersConfig.put("100909", "com.tencent.mobileqq.gamecenter.qa.config.MetaDreamHippyConfigParser");
        injectParsersConfig.put("100784", "com.tencent.mobileqq.gamecenter.qa.config.GameQAHippyConfigParser");
        injectParsersConfig.put("100497", "com.tencent.mobileqq.gamecenter.qa.config.GameRankConfigParser");
        injectParsersConfig.put("100492", "com.tencent.mobileqq.gamecenter.qa.config.QAArticleConfigParser");
        injectParsersConfig.put("105893", "com.tencent.mobileqq.vashealth.config.SportMainPageConfigParser");
        injectParsersConfig.put("100506", "com.tencent.mobileqq.vashealth.config.StepConfigParser");
        injectParsersConfig.put("100505", "com.tencent.mobileqq.vashealth.config.HealthTimerConfigParser");
        injectParsersConfig.put("100502", "com.tencent.mobileqq.vashealth.config.HealthJumpConfigParser");
        injectParsersConfig.put("100480", "com.tencent.mobileqq.vas.adv.config.AdConfigParser");
        injectParsersConfig.put("102720", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("101417", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("101505", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100474", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100387", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100386", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100372", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("102557", "com.tencent.mobileqq.perf.metric.config.ScrollHitchConfig");
        injectParsersConfig.put("qqperf_config", "com.tencent.mobileqq.perf.config.QQPerfConfigParser");
        injectParsersConfig.put("crash_report_config", "com.tencent.qqperf.monitor.crash.config.CrashConfigProcessorForQQmc");
        injectParsersConfig.put("102483", "com.tencent.gdtad.basics.config.SplashAdJumpDelayConfigParser");
        injectParsersConfig.put("100435", "com.tencent.gdtad.basics.config.SplashAdConfigParser");
        injectParsersConfig.put(NativeMonitorConfigHelper.f203157GROUP, "com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigParser");
        injectParsersConfig.put("105898", "com.tencent.qqperf.monitor.message.config.BarrierConfigParser");
        injectParsersConfig.put("100418", "com.tencent.mobileqq.config.MigrateBlackListParser");
        injectParsersConfig.put("migrate_manage_567", "com.tencent.mobileqq.config.business.BroadcastConfParser");
        injectParsersConfig.put("webview_filechooser_type_extension", "com.tencent.mobileqq.webview.config.WVFileChooserConfigParser");
        injectParsersConfig.put("webview_mainproc_config", "com.tencent.mobileqq.webview.config.WebViewMainProcConfigParser");
        injectParsersConfig.put("webview_html_agent_switch", "com.tencent.mobileqq.webview.config.HtmlAgentConfigParser");
        injectParsersConfig.put("profile_entrance_config_381", "com.tencent.mobileqq.profilecard.base.config.ProfileEntranceConfigParser");
        injectParsersConfig.put("qq_opensdk_addfriend_config", "com.tencent.mobileqq.addfriend.config.AddFriendOpenSdkConfigParser");
        injectParsersConfig.put("intimate_aio_rightframe_game_8970_config", "com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderConfigParser");
        injectParsersConfig.put("intimate_gray_tips_146", "com.tencent.mobileqq.config.business.mutualmark.MutualMarkGrayTipsConfigParser");
        injectParsersConfig.put("intimate_switch_455", "com.tencent.mobileqq.config.business.intimate.IntimateSwitchConfigParser");
        injectParsersConfig.put("elegant_mutualmark_config_524", "com.tencent.mobileqq.config.business.mutualmark.MutualMarkConfigParser");
        injectParsersConfig.put("troop_batch_add_friend_config", "com.tencent.mobileqq.relationx.batchAdd.TroopBatchAddFriendConfigParser");
        injectParsersConfig.put("yqh_entrance_config", "com.tencent.mobileqq.config.business.together.TogetherEntryConfigParser");
        injectParsersConfig.put(MiniGamePreDownloadConfig.CONFIG_ID, "com.tencent.mobileqq.minigame.config.MiniGamePreDownloadConfigParser");
        injectParsersConfig.put(MiniGameCustomLoadingConfig.CONFIG_ID, "com.tencent.mobileqq.minigame.config.MiniGameCustomLoadingConfigParser");
        injectParsersConfig.put(MiniGameVACustomConfig.CONFIG_ID, "com.tencent.mobileqq.minigame.config.MiniGameVACustomConfigParser");
        injectParsersConfig.put("102839", "com.tencent.qq.minibox.config.MiniGameMetaDreamEnvConfigParser");
        injectParsersConfig.put("105878", "com.tencent.mobileqq.wxmini.impl.config.WxMiniInterceptConfigParser");
        injectParsersConfig.put(MiniGameVAInterceptConfig.CONFIG_ID, "com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfigParser");
        injectParsersConfig.put(WxMiniGameCenterLaunchConfig.CONFIG_ID, "com.tencent.mobileqq.minigame.config.WxMiniGameCenterLaunchConfigParser");
        injectParsersConfig.put(MiniGameCenterLaunchConfig.CONFIG_ID, "com.tencent.mobileqq.minigame.config.MiniGameCenterLaunchConfigParser");
        injectParsersConfig.put(MiniGameConfig.CONFIG_ID, "com.tencent.mobileqq.minigame.config.MiniGameUnitedConfigParser");
        injectParsersConfig.put("100327", "com.tencent.mobileqq.config.business.msf.BeforeMsgSyncControlConfigParser");
        injectParsersConfig.put("100320", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100314", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100308", "com.tencent.mobileqq.guild.feed.feedoption.GuildFeedOptionConfigParser");
        injectParsersConfig.put("100307", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("qav_rtc_sdk_trae_so", "com.tencent.av.so.QavQQMCConfigParser");
        injectParsersConfig.put("qav_rtc_sdk_so", "com.tencent.av.so.QavQQMCConfigParser");
        injectParsersConfig.put("so_and_ai_model_res", "com.tencent.av.so.QavQQMCConfigParser");
        injectParsersConfig.put("100080", "com.tencent.mobileqq.config.business.msf.MSFMMKVConfigParser");
        injectParsersConfig.put("100256", "com.tencent.mobileqq.config.business.msf.ComplexConnectConfigParser");
        injectParsersConfig.put("100249", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("zplan_lite_resources_url_template", "com.tencent.mobileqq.zplan.proxy.filament.parser.ZPlanUrlTemplateConfigParser");
        injectParsersConfig.put("100248", "com.tencent.mobileqq.zplan.mod.impl.parser.ModCloudConfigParser");
        injectParsersConfig.put("100600", "com.tencent.mobileqq.guild.sign.config.GuildSignAndWalletConfig");
        injectParsersConfig.put("100446", "com.tencent.mobileqq.guild.media.config.MediaGuidanceConfig");
        injectParsersConfig.put("100228", "com.tencent.guildmedia.GuildMediaLottieEmojiConfigParser");
        injectParsersConfig.put("100202", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put(MiniAdConfigParser.GROUP_ID, "com.tencent.mobileqq.mini.config.ad.MiniAdConfigParser");
        injectParsersConfig.put("105618", "com.tencent.mobileqq.vas.adv.maskad.config.MaskAdReqFreqConfigParser");
        injectParsersConfig.put(MaskAdConfigParser.GROUP_ID, "com.tencent.mobileqq.vas.adv.maskad.config.MaskAdConfigParser");
        injectParsersConfig.put("103135", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("100191", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("100141", "com.tencent.mobileqq.mini.config.united.MiniConfigParser");
        injectParsersConfig.put(VasQQMcConstKt.QQMC_KEY_VAS_UPDATE_SYSTEM_HTTPDNS, "com.tencent.mobileqq.vas.qqmc.VasUpdateSystemHttpDnsSwitch");
        injectParsersConfig.put(VasQQMcConstKt.QQMC_KEY_VAS_TEST, "com.tencent.mobileqq.vas.qqmc.TestVasJsonQQMC");
        injectParsersConfig.put("zplan_zootopia_manager_config", "com.tencent.sqshow.zootopia.data.config.ZootopiaParadiseConfigParser");
        injectParsersConfig.put("zplan_aio_egg_manager_large_config", "com.tencent.mobileqq.zplan.easteregg.parser.ZPlanEasterEggConfigParser");
        injectParsersConfig.put("100124", "com.tencent.gdtad.basics.config.BannerAdConfigParser");
        injectParsersConfig.put("102869", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100168", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100114", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100113", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100112", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("100111", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100110", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100109", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100108", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100107", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100106", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100105", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100104", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("100103", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100102", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100101", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("105809", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("105808", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("100100", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("100099", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("100098", "com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser");
        injectParsersConfig.put("100097", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100096", "com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser");
        injectParsersConfig.put("100089", "com.tencent.mobileqq.config.business.msf.MSFCommonConfigParser");
        injectParsersConfig.put("100081", "com.tencent.mobileqq.config.business.msf.MSFWeakNetConfigParser");
        injectParsersConfig.put("100061", "com.tencent.mobileqq.unusedcodecheck.api.impl.UnusedCodeCheckConfigParser");
        injectParsersConfig.put("100014", "com.tencent.mobileqq.unitedconfig_android.ReportUnitedConfigParser");
        injectParsersConfig.put("100038", "com.tencent.mobileqq.qmethodmonitor.monitor.config.DexMonitorConfigParser");
        injectParsersConfig.put(QQLiveReportConstants.VALUE_APPID, "com.tencent.mobileqq.data.nativemonitor.traffic.NativeTrafficMonitorConfigParser");
        injectParsersConfig.put("106113", "com.tencent.mobileqq.webview.swift.utils.WebViewBgHostWhiteListConfigParser");
        HashMap<String, String> hashMap2 = new HashMap<>();
        injectParsersConfigNoLogin = hashMap2;
        hashMap2.put("msf_probe_config", "com.tencent.mobileqq.config.MSFProbeConfigParser");
        injectParsersConfigNoLogin.put("msf_core_dual_engine_config", "com.tencent.mobileqq.config.MSFCoreDualEngineConfigParser");
        injectParsersConfigNoLogin.put("102340", "com.tencent.mobileqq.config.MSFCorePkgCompressConfigParser");
        injectParsersConfigNoLogin.put("msf_core_tcp_engine_config", "com.tencent.mobileqq.config.MSFCoreTcpEngineConfigParser");
        injectParsersConfigNoLogin.put("msf_core_side_way_udp_config", "com.tencent.mobileqq.config.MSFCoreSideWayUdpConfigParser");
        injectParsersConfigNoLogin.put("msf_core_side_way_http_config", "com.tencent.mobileqq.config.MSFCoreSideWayHttpConfigParser");
        injectParsersConfigNoLogin.put("msf_core_pkg_statistics_config", "com.tencent.mobileqq.config.MSFCorePkgStatisticsConfigParser");
        injectParsersConfigNoLogin.put("msf_core_packet_combine_config", "com.tencent.mobileqq.config.MSFCorePacketCombineConfigParser");
        injectParsersConfigNoLogin.put("msf_core_multi_tcp_config", "com.tencent.mobileqq.config.MSFCoreMultiTcpConfigParser");
        injectParsersConfigNoLogin.put("msf_modify_version_enable_config", "com.tencent.mobileqq.config.MSFCoreModifyConfigParser");
        injectParsersConfigNoLogin.put("msf_core_network_moduel_config", "com.tencent.mobileqq.config.MSFCoreNetworkConfigParser");
        injectParsersConfigNoLogin.put("msf_quic_engine_config", "com.tencent.mobileqq.config.MSFCoreQuicEngineConfigParser");
        injectParsersConfigNoLogin.put("msfcore_sample_rate", "com.tencent.mobileqq.config.MSFCoreSampleRateConfigParser");
        injectParsersConfigNoLogin.put("test_for_safemode_crash", "com.tencent.qqperf.monitor.crash.safemode.SafeModeTestCrashConfigProcessor");
        injectParsersConfigNoLogin.put("crash_defend_switch", "com.tencent.qqperf.crashdefend.CrashDefendConfigProcessor");
        injectParsersConfigNoLogin.put("mmkv_with_account_delete_config", "com.tencent.mobileqq.qmmkv.MMKVWithAccountDeleteConfigParser");
        injectParsersConfigNoLogin.put("102227", "com.tencent.mobileqq.guild.config.subconfig.parser.GuildTabNameConfigParser");
        injectParsersConfigNoLogin.put("webview_dns_mapping", "com.tencent.mobileqq.webview.config.DnsMappingConfigParser");
        injectParsersConfigNoLogin.put("webview_hard_sandbox_switch", "com.tencent.mobileqq.webview.config.HardSandBoxConfigParser");
    }

    public UnitedConfigManagerImpl() {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.logger = new b();
        initQAutoInject();
        HashMap hashMap = new HashMap();
        for (String str2 : injectParsersConfig.keySet()) {
            if (hashMap.containsKey(str2)) {
                QLog.e(TAG, 1, "duplicated group: " + str2);
            }
            String str3 = injectParsersConfig.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put(str2, str3);
            }
        }
        HashMap hashMap2 = new HashMap();
        for (String str4 : injectParsersConfigNoLogin.keySet()) {
            if (hashMap2.containsKey(str4)) {
                QLog.e(TAG, 1, "duplicated group: " + str4);
            }
            String str5 = injectParsersConfigNoLogin.get(str4);
            if (!TextUtils.isEmpty(str5)) {
                hashMap2.put(str4, str5);
            }
        }
        SoLoader.INSTANCE.setLoader(new ISoLoader() { // from class: com.tencent.mobileqq.unitedconfig_android.api.impl.c
            @Override // com.tencent.freesia.ISoLoader
            public final boolean load(String str6) {
                boolean lambda$new$3;
                lambda$new$3 = UnitedConfigManagerImpl.lambda$new$3(str6);
                return lambda$new$3;
            }
        });
        if (!com.tencent.mobileqq.unitedconfig_android.a.g()) {
            z16 = QMMKV.from(MobileQQ.sMobileQQ, "united_config_mmkv_000").decodeBool(KEY_DEBUG_ENABLE, false);
        } else {
            z16 = false;
        }
        File externalFilesDir = MobileQQ.sMobileQQ.getExternalFilesDir(CDN_DIR);
        externalFilesDir = externalFilesDir == null ? new File(MobileQQ.sMobileQQ.getFilesDir(), CDN_DIR) : externalFilesDir;
        UnitedConfig.Companion companion = UnitedConfig.INSTANCE;
        a aVar = new a(new ConfigParserBridgeImpl(hashMap, hashMap2), this, new g(), this.logger, new com.tencent.mobileqq.unitedconfig_android.c(), new com.tencent.mobileqq.unitedconfig_android.e(), externalFilesDir.getAbsolutePath(), new com.tencent.mobileqq.unitedconfig_android.b(), new k());
        if (z16) {
            str = PROJECT_ID_TEST;
        } else {
            str = PROJECT_ID;
        }
        UnitedConfig companion2 = companion.getInstance(aVar, new ArrayList<>(Collections.singleton(str)), CommandType.COMMANDTYPEQQ, new Extend(new CustomField((ArrayList<KV>) new ArrayList()), com.tencent.mobileqq.unitedconfig_android.a.d() + "." + com.tencent.mobileqq.unitedconfig_android.a.c()), new ExtraInitInfo(com.tencent.mobileqq.unitedconfig_android.a.b()));
        this.unitedConfig = companion2;
        if (z16) {
            QLog.d(TAG, 1, "switch to debug env");
            companion2.setEnv(true);
        }
        try {
            int parseInt = Integer.parseInt(loadAsString("105487", "0"));
            if (parseInt > 0) {
                ReportBridge a16 = com.tencent.freesia.c.a();
                Objects.requireNonNull(a16);
                a16.setLoadReportRate(parseInt);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String getUin() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            return firstSimpleAccount.getUin();
        }
        return null;
    }

    @NonNull
    private String getUinDefaultIfNull() {
        String str;
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            str = firstSimpleAccount.getUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "000";
        }
        return str;
    }

    private long getUpdateInterval() {
        int updateInterval = this.unitedConfig.getUpdateInterval();
        if (updateInterval <= 0) {
            return 21600000L;
        }
        return updateInterval * 1000 * 60;
    }

    private boolean isLogin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLargeConfigAsStringAsync$1(py2.a aVar, String str, String str2) {
        aVar.a(new String(this.unitedConfig.loadLargeRawConfig(getUinDefaultIfNull(), str, str2.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLargeConfigAsync$0(py2.a aVar, String str) {
        aVar.a(this.unitedConfig.loadLargeConfig(getUinDefaultIfNull(), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$3(String str) {
        return SoLoadUtilNew.loadSoByName(MobileQQ.sMobileQQ, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onApplicationForeground$4() {
        if (this.unitedConfig.isIncFetchEnable(getUinDefaultIfNull())) {
            this.unitedConfig.onAppForeground();
        } else {
            fetchAll();
            fetchNoLogin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeAll$2(File file, String str) {
        if (str.startsWith("united_config_mmkv_") && !str.endsWith(".crc")) {
            return true;
        }
        return false;
    }

    private void refetch() {
        UnitedConfigServlet.Companion companion = UnitedConfigServlet.INSTANCE;
        if (companion.b() && !companion.d() && SystemClock.elapsedRealtime() - lastRefetchTime >= 3600000) {
            QLog.d(TAG, 1, "refetch");
            lastRefetchTime = SystemClock.elapsedRealtime();
            fetchAll(false);
        }
        if (companion.c() && !companion.e() && SystemClock.elapsedRealtime() - noLoginLastRefetchTime >= 3600000) {
            QLog.d(TAG, 1, "refetch no login");
            noLoginLastRefetchTime = SystemClock.elapsedRealtime();
            fetchNoLogin(false);
        }
    }

    public void clearInvalidData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.unitedConfig.clearInvalidData();
        }
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    public boolean fetch(@NonNull ArrayList<String> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, arrayList, Boolean.valueOf(z16))).booleanValue();
        }
        String uin = getUin();
        if (uin == null) {
            QLog.e(TAG, 1, "fetch configs failed: can not get runtime");
            return false;
        }
        if (this.unitedConfig.isSwitchOn(uin, KEY_FETCH_DISABLE, false)) {
            QLog.w(TAG, 1, "fetch disable");
            return false;
        }
        if (this.unitedConfig.isFetchMute(System.currentTimeMillis() / 1000)) {
            QLog.w(TAG, 1, "fetching is mute for now");
            return false;
        }
        if (fetchCount >= 10 && lastFetchTime > 0 && SystemClock.elapsedRealtime() - lastFetchTime < getUpdateInterval()) {
            QLog.w(TAG, 1, "fetch of a high frequency!");
            return false;
        }
        fetchCount++;
        lastFetchTime = SystemClock.elapsedRealtime();
        this.unitedConfig.fetch(uin, arrayList, z16);
        return true;
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IFreesiaFetcher
    public void fetchAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            fetchAll(true);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IFreesiaFetcher
    public void fetchNoLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            fetchNoLogin(true);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    public void fetchSwitch(@NonNull ArrayList<String> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, arrayList, Boolean.valueOf(z16));
            return;
        }
        String uin = getUin();
        if (uin == null) {
            QLog.e(TAG, 1, "fetch switches failed: can not get runtime");
            return;
        }
        if (this.unitedConfig.isSwitchOn(uin, KEY_FETCH_DISABLE, false)) {
            QLog.w(TAG, 1, "fetch disable");
            return;
        }
        if (this.unitedConfig.isFetchMute(System.currentTimeMillis() / 1000)) {
            QLog.w(TAG, 1, "fetching is mute for now");
            return;
        }
        if (fetchCount >= 10 && lastFetchTime > 0 && SystemClock.elapsedRealtime() - lastFetchTime < getUpdateInterval()) {
            QLog.w(TAG, 1, "fetch of a high frequency!");
            return;
        }
        fetchCount++;
        lastFetchTime = SystemClock.elapsedRealtime();
        this.unitedConfig.fetchSwitch(uin, arrayList, z16);
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    public int getConfigVersion(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).intValue();
        }
        return this.unitedConfig.getConfigVersion(getUinDefaultIfNull(), str);
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    @NonNull
    public ArrayList<String> getGroups(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ArrayList) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        return this.unitedConfig.getGroups(getUinDefaultIfNull(), str);
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    @Nullable
    public String getResourcePath(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        return this.unitedConfig.getResourcePath(getUinDefaultIfNull(), str);
    }

    @Override // com.tencent.freesia.MSFServletBridge
    public boolean isNetworkAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean isNetworkAvailable = ((INetworkUtilApi) QRoute.api(INetworkUtilApi.class)).isNetworkAvailable();
        if (!isNetworkAvailable) {
            QLog.w(TAG, 1, "network is not available");
        }
        return isNetworkAvailable;
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    public boolean isSwitchOn(@NonNull String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        return this.unitedConfig.isSwitchOn(getUinDefaultIfNull(), str, z16);
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    @NonNull
    public String loadAsString(@NonNull String str, @NonNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) str2);
        }
        return new String(this.unitedConfig.loadRawConfig(getUinDefaultIfNull(), str, str2.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    public <T extends IConfigData> T loadConfig(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (T) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        return (T) this.unitedConfig.loadConfig(getUinDefaultIfNull(), str);
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    public void loadLargeConfigAsStringAsync(@NonNull final String str, @NonNull final String str2, @NonNull final py2.a<String> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, aVar);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.unitedconfig_android.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    UnitedConfigManagerImpl.this.lambda$loadLargeConfigAsStringAsync$1(aVar, str, str2);
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    public <T extends IConfigData> void loadLargeConfigAsync(@NonNull final String str, @NonNull final py2.a<T> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) aVar);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.unitedconfig_android.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    UnitedConfigManagerImpl.this.lambda$loadLargeConfigAsync$0(aVar, str);
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    @NonNull
    public byte[] loadRawConfig(@NonNull String str, @NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (byte[]) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) bArr);
        }
        return this.unitedConfig.loadRawConfig(getUinDefaultIfNull(), str, bArr);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.unitedconfig_android.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    UnitedConfigManagerImpl.this.lambda$onApplicationForeground$4();
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            refetch();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            refetch();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
    public void onNormalToWeakNet(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
    public void onWeakNetToNormal(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            refetch();
        }
    }

    public void removeAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (!com.tencent.mobileqq.unitedconfig_android.a.g()) {
            IllegalStateException illegalStateException = new IllegalStateException("can't not access to method removeAll");
            StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
            if (stackTrace.length > 1 && !"com.tencent.qqperf.safemode.SafeModeClearHelper".equals(stackTrace[1].getClassName())) {
                throw illegalStateException;
            }
        }
        try {
            QLog.w(TAG, 1, "removeAll");
            String[] list = new File(MobileQQ.sMobileQQ.getFilesDir(), "mmkv").list(new FilenameFilter() { // from class: com.tencent.mobileqq.unitedconfig_android.api.impl.a
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    boolean lambda$removeAll$2;
                    lambda$removeAll$2 = UnitedConfigManagerImpl.lambda$removeAll$2(file, str);
                    return lambda$removeAll$2;
                }
            });
            if (list == null) {
                return;
            }
            for (String str : list) {
                if (str.length() <= 19) {
                    QLog.e(TAG, 1, "invalid mmkv file: " + str);
                } else {
                    new i(str.substring(19)).clearAll();
                }
            }
            this.unitedConfig.evictCache();
            FileUtils.deleteDirectory(new File(MobileQQ.sMobileQQ.getFilesDir(), CDN_DIR).getAbsolutePath());
            FileUtils.deleteDirectory(MobileQQ.sMobileQQ.getExternalFilesDir(CDN_DIR).getAbsolutePath());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager
    public void removeLocal(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        if (!com.tencent.mobileqq.unitedconfig_android.a.g()) {
            IllegalStateException illegalStateException = new IllegalStateException("can't not access to method removeLocal");
            StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
            if (stackTrace.length > 1 && !"com.tencent.qqperf.safemode.SafeModeClearHelper".equals(stackTrace[1].getClassName())) {
                throw illegalStateException;
            }
        }
        this.unitedConfig.removeLocal(getUinDefaultIfNull(), str);
    }

    @Override // com.tencent.freesia.MSFServletBridge
    public void report(String str, int i3, int i16, @NonNull SsoReportReq ssoReportReq, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), ssoReportReq, Boolean.valueOf(z16));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "app runtime is null");
            return;
        }
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, UnitedConfigServlet.class);
        newIntent.putExtra(CheckForwardServlet.KEY_CMD, str);
        configDistributionSvr.SsoReportReq createReportReq = PBUtils.INSTANCE.createReportReq(ssoReportReq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(createReportReq.toByteArray()));
        newIntent.putExtra("request_bytes", oidb_sso_oidbssopkg.toByteArray());
        if (z16) {
            newIntent.withouLogin = true;
        }
        peekAppRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.freesia.MSFServletBridge
    public void send(@NonNull String str, @NonNull String str2, @NonNull GetConfigReq getConfigReq, boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, getConfigReq, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        ArrayList<GroupInfo> groupInfos = getConfigReq.getGroupInfos();
        QLog.d(TAG, 1, "send fetch config request, seq: " + getConfigReq.getControlInfo().mConfigSeq + ", type: " + getConfigReq.mFetchType.name());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "app runtime is null");
            return;
        }
        if (getConfigReq.mFetchType == FetchType.SPECIFIC && groupInfos.isEmpty()) {
            QLog.e(TAG, 1, new IllegalArgumentException("fetch specific config with empty group"), new Object[0]);
            return;
        }
        if (getConfigReq.mFetchType == FetchType.PUSH) {
            new h().c(i3);
        }
        if (!this.register && 1 == MobileQQ.sProcessId) {
            this.register = true;
            AppNetConnInfo.registerConnectionChangeReceiver(null, this);
            AppNetConnInfo.registerWeakNetStatusHandler(null, this);
            GuardManagerCallbackDispatcher.registerCallBack(this);
        }
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, UnitedConfigServlet.class);
        newIntent.putExtra(CheckForwardServlet.KEY_CMD, str2);
        newIntent.putExtra("request_bytes", PBUtils.INSTANCE.createReqFromNativeObj(getConfigReq).toByteArray());
        newIntent.putExtra("uin", str);
        newIntent.putExtra("request_seq", i3);
        newIntent.putExtra("retry_count", i16);
        newIntent.setObserver(m.INSTANCE.a());
        if (z16) {
            newIntent.withouLogin = true;
        }
        peekAppRuntime.startServlet(newIntent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if (isSwitchOn("105520", false) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateIncFetch() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.unitedconfig_android.a.g() || Utils.K()) {
            z16 = false;
        }
        z16 = true;
        this.unitedConfig.setIncFetch(z16);
        QLog.d(TAG, 1, "updateIncFetch: " + z16);
    }

    private void fetchAll(boolean z16) {
        String uin = getUin();
        if (uin == null) {
            QLog.e(TAG, 1, "fetch all configs failed: can not get runtime");
            return;
        }
        if (!isLogin()) {
            QLog.e(TAG, 1, "skip fetch all configs: not login");
            return;
        }
        if (this.unitedConfig.isFetchMute(System.currentTimeMillis() / 1000)) {
            QLog.w(TAG, 1, "fetching is mute for now");
            return;
        }
        ArrayMap<String, Long> arrayMap = UIN_TO_FETCH_TIME;
        synchronized (arrayMap) {
            Long l3 = arrayMap.get(uin);
            if (z16 && l3 != null && SystemClock.elapsedRealtime() - l3.longValue() < getUpdateInterval()) {
                QLog.w(TAG, 1, "this uin has fetched before");
                if (new Random().nextInt(10000) == 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(REPORT_KEY_NO_LOGIN, Boolean.FALSE.toString());
                    QQBeaconReport.report(uin, REPORT_EVENT_FREQ_CONTROL, hashMap);
                }
                return;
            }
            arrayMap.put(uin, Long.valueOf(SystemClock.elapsedRealtime()));
            updateIncFetch();
            this.unitedConfig.fetchAll(uin, false);
        }
    }

    private void fetchNoLogin(boolean z16) {
        if (this.unitedConfig.isFetchMute(System.currentTimeMillis() / 1000)) {
            QLog.w(TAG, 1, "fetching is mute for now");
            return;
        }
        if (z16 && noLoginLastFetchTime > 0 && SystemClock.elapsedRealtime() - noLoginLastFetchTime < getUpdateInterval()) {
            QLog.w(TAG, 1, "no_login has fetched before");
            if (new Random().nextInt(10000) == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put(REPORT_KEY_NO_LOGIN, Boolean.TRUE.toString());
                QQBeaconReport.report(null, REPORT_EVENT_FREQ_CONTROL, hashMap);
                return;
            }
            return;
        }
        noLoginLastFetchTime = SystemClock.elapsedRealtime();
        updateIncFetch();
        this.unitedConfig.fetchNoLogin();
        QLog.d(TAG, 1, "inc enable: " + this.unitedConfig.isIncFetchEnable("000"));
    }

    @QAutoInitMethod
    void initQAutoInject() {
    }
}
