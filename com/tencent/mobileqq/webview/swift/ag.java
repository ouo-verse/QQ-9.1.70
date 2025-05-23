package com.tencent.mobileqq.webview.swift;

import android.text.TextUtils;
import com.tencent.aelight.camera.aebase.AECameraPlugin;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountWebviewPluginImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.biz.subscribe.SubscribeJsPlugin;
import com.tencent.biz.webviewplugin.BusinessReportPlugin;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.biz.webviewplugin.ReadInJoyWebRenderPlugin;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.biz.webviewplugin.UrlCheckPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.comic.jsp.QQComicJsPlugin;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.gamecenter.wadl.biz.jsplugin.GameCenterInterruptPlugin;
import com.tencent.gamecenter.wadl.biz.jsplugin.WadlWebViewJsPlugin;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.gdtad.jsbridge.GdtAdWebPlugin;
import com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.dt.web.O3WebViewPlugin;
import com.tencent.mobileqq.gamecenter.metadream.MetaDreamJsPlugin;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.GuildOpenWebViewJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.impl.HuayangJsPluginImpl;
import com.tencent.mobileqq.intervideo.od.ODAppJSPlugin;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin;
import com.tencent.mobileqq.jsp.AVGameShareJsApiPlugin;
import com.tencent.mobileqq.jsp.AppPlugin;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.DeviceProtectJsApiPlugin;
import com.tencent.mobileqq.jsp.DocxApiPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.StudyModePlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniCreatePluginChecker;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebViewJsPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.profile.HistoryHeadWebViewPlugin;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.qcircle.api.hybird.QCircleJsPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.webview.QQLiveJsPlugin;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.webview.TVideoPublicJsPlugin;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.DailySignInWebviewPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiSubHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiSubPageUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.FunnyPicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.HippyJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ICGameJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividualRedPacketJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.KingCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.KuiklyJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.PraiseJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QLBQJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQAioBackgroundPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQLevelJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQReaderJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonHbJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SpringHbJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.TreasureCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.vaswebviewplugin.VipAppIconJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipComicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunCallJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunctionJsPlugin;
import com.tencent.mobileqq.webview.WebSecurityPluginV2;
import com.tencent.mobileqq.webviewplugin.SocialWeeklyWebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.mobileqq.zplan.web.api.impl.ZPlanJsPluginImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.task.ServiceCreateTask;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.timi.game.liveroom.impl.room.pendant.webview.QQLiveJsPendantPlugin;
import com.tencent.timi.game.web.business.impl.plugin.LivingInscriptionWebPlugin;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.webviewplugin.GDTReportPlugin;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import cooperation.qzone.webviewplugin.famous.QZoneFamousUserHomeJsPlugin;
import cooperation.qzone.webviewplugin.mood.QzoneSelectMoodPictureJsPlugin;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import cooperation.qzone.webviewplugin.personalize.QZonePersonalizePlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.vip.tianshu.js.TianShuWebPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ag {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_business_webviewplugin_map.yml", version = 5)
    public static HashMap<String, Class<? extends WebViewPlugin>> f314191a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_business_webviewplugin_createchecker_list.yml", version = 4)
    public static ArrayList<Class<? extends c>> f314192b;

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<c> f314193c;

    /* renamed from: d, reason: collision with root package name */
    static final HashMap<Class<? extends WebViewPlugin>, Integer> f314194d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49120);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Class<? extends WebViewPlugin>> hashMap = new HashMap<>();
        f314191a = hashMap;
        hashMap.put("interceptor", com.tencent.mobileqq.webviewplugin.b.class);
        f314191a.put("robotProfile", l44.b.class);
        f314191a.put("DocToolsModule", com.tencent.mobileqq.tbstool.web.a.class);
        f314191a.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, com.tencent.mobileqq.jsp.x.class);
        f314191a.put("Game", ba1.a.class);
        f314191a.put("ssoEnv", com.tencent.biz.webviewplugin.af.class);
        f314191a.put("qrcode", sd0.c.class);
        f314191a.put("metadream", MetaDreamJsPlugin.class);
        f314191a.put("freesia", com.tencent.mobileqq.unitedconfig_android.d.class);
        f314191a.put("NtMigration", com.tencent.qqnt.msg.migration.b.class);
        f314191a.put(QZoneJsConstants.PKGNAME_QZONE_INTIMATE_SPACE, QZoneWebViewPlugin.class);
        f314191a.put("tvideoPublicAccount", TVideoPublicJsPlugin.class);
        f314191a.put("TianShu", TianShuWebPlugin.class);
        f314191a.put("o3", O3WebViewPlugin.class);
        f314191a.put("q_download_gdt", com.tencent.gdtad.web.a.class);
        f314191a.put("guildGame", GuildOpenWebViewJsPlugin.class);
        f314191a.put("QQWebApi", com.tencent.mobileqq.crossend.communication.base.i.class);
        f314191a.put("PrivacyEventProtocol", com.tencent.mobileqq.jsp.u.class);
        f314191a.put("music", com.tencent.mobileqq.qqlive.webview.b.class);
        f314191a.put("qqlive", QQLiveJsPendantPlugin.class);
        f314191a.put("app", AppPlugin.class);
        f314191a.put("document", com.tencent.biz.webviewplugin.e.class);
        f314191a.put("timiEsports", LivingInscriptionWebPlugin.class);
        f314191a.put("studyMode", StudyModePlugin.class);
        f314191a.put("qq_gift", com.tencent.mobileqq.qqgift.webview.b.class);
        f314191a.put("qq_livestream", QQLiveJsPlugin.class);
        f314191a.put("guildfeed", ok1.f.class);
        f314191a.put("guild", com.tencent.mobileqq.guild.webview.g.class);
        f314191a.put("kuikly", KuiklyJsPlugin.class);
        f314191a.put("hippy", HippyJsPlugin.class);
        f314191a.put("forceHttps", com.tencent.mobileqq.webview.g.class);
        f314191a.put("gameCenter", GameCenterInterruptPlugin.class);
        f314191a.put("register", com.tencent.mobileqq.jsp.aa.class);
        f314191a.put("lightapp", b91.a.class);
        f314191a.put("ArkSecurity", n91.a.class);
        f314191a.put("splashADPlugin", com.tencent.mobileqq.splashad.f.class);
        f314191a.put("VipTroopUpgradePlugin", com.tencent.mobileqq.troop.browser.e.class);
        f314191a.put("ShareApiPlugin", com.tencent.biz.webviewplugin.ah.class);
        f314191a.put("ftssearch", com.tencent.mobileqq.jsp.ak.class);
        f314191a.put("comic", QQComicJsPlugin.class);
        f314191a.put("RealName", com.tencent.mobileqq.realname.a.class);
        f314191a.put("allpeoplevote", com.tencent.mobileqq.wholepeople.c.class);
        f314191a.put(IPublicAccountH5AbilityPlugin.PACKAGE_NAME, PublicAccountH5AbilityPluginImpl.class);
        f314191a.put(DailySignInWebviewPlugin.PLUGIN_NAMESPACE, DailySignInWebviewPlugin.class);
        f314191a.put(VipAppIconJsPlugin.BUSINESS_NAME, VipAppIconJsPlugin.class);
        f314191a.put(VipClubJsPlugin.BUSINESS_NAME, VipClubJsPlugin.class);
        f314191a.put(VipFunCallJsPlugin.BusinessName, VipFunCallJsPlugin.class);
        f314191a.put("aecamera", AECameraPlugin.class);
        f314191a.put("Troop", TroopWebviewPlugin.class);
        f314191a.put("pubAccountUI", com.tencent.biz.webviewplugin.z.class);
        f314191a.put("debug", VasWebReport.class);
        f314191a.put(MQPSecJsPlugin.NAMESPACE_PUZZLE_VERIFY_CODE, MQPSecJsPlugin.class);
        f314191a.put("medalwall", com.tencent.mobileqq.jsp.p.class);
        f314191a.put("QzoneUpload", QZoneWebViewPlugin.class);
        f314191a.put(NowLiveNativePlugin.PLUGIN_NAME, com.tencent.mobileqq.intervideo.now.d.class);
        f314191a.put(QZoneJsConstants.PKGNAME_QZONE_AUDIO_RECORD, QZoneWebViewPlugin.class);
        f314191a.put("Qzone", QZoneWebViewPlugin.class);
        f314191a.put(VasCommonJsPlugin.PLUGIN_NAMESPACE_QW_DEBUG, VasCommonJsPlugin.class);
        f314191a.put(QAdVrReportParams.ParamKey.MEDIA, MediaApiPlugin.class);
        f314191a.put(VipComicJsPlugin.NAMESPACE, VipComicJsPlugin.class);
        f314191a.put("aioShareMusic", q81.a.class);
        f314191a.put("interactionScore", com.tencent.mobileqq.intimate.b.class);
        f314191a.put(WebRTCSDK.PRIVILEGE_SENSOR, com.tencent.biz.webviewplugin.b.class);
        f314191a.put("QzMoodSelectPicture", QzoneSelectMoodPictureJsPlugin.class);
        f314191a.put("background", QQAioBackgroundPlugin.class);
        f314191a.put("tribe", s62.b.class);
        f314191a.put("newerguide", com.tencent.biz.webviewplugin.r.class);
        f314191a.put("GdtWebReportPlugin", com.tencent.gdtad.web.k.class);
        f314191a.put("MixSearchWeb", com.tencent.mobileqq.jsp.t.class);
        f314191a.put(QLBQJsPlugin.NAME_SPACE, QLBQJsPlugin.class);
        f314191a.put(GameCenterAPIJavaScript.TAG, GameCenterAPIJavaScript.class);
        f314191a.put(LocalDataJsPlugin.NAME_SPACE, LocalDataJsPlugin.class);
        f314191a.put(QWalletPayJsPlugin.OBJECT_NAME_NEW, QWalletPayJsPlugin.class);
        f314191a.put("ReportPlugin", com.tencent.biz.webviewplugin.ae.class);
        f314191a.put(ProcessConstant.AVGAME, AVGameShareJsApiPlugin.class);
        f314191a.put(FunnyPicJsPlugin.BUSINESS_NAME, FunnyPicJsPlugin.class);
        f314191a.put("SocialWeekly", SocialWeeklyWebViewPlugin.class);
        f314191a.put("troop_member_level_JS_API", com.tencent.biz.webviewplugin.ai.class);
        f314191a.put("sign", SignJsPlugin.class);
        f314191a.put("emoji", EmojiJsPlugin.class);
        f314191a.put("data", DataApiPlugin.class);
        f314191a.put(MQPSecJsPlugin.NAMESPACE_DEV_LOCK, MQPSecJsPlugin.class);
        f314191a.put("4194304", ColorRingUIPlugin.class);
        f314191a.put(QWalletBluetoothJsPlugin.PLUGIN_NAMESPACE, QWalletBluetoothJsPlugin.class);
        f314191a.put(RedTouchWebviewHandler.PLUGIN_NAMESPACE, RedTouchWebviewHandler.class);
        f314191a.put("accounts", com.tencent.mobileqq.jsp.a.class);
        f314191a.put(IndividualRedPacketJsPlugin.BUSINESS_NAME, IndividualRedPacketJsPlugin.class);
        f314191a.put("specialRing", com.tencent.mobileqq.activity.specialcare.i.class);
        f314191a.put("extendFriend", com.tencent.mobileqq.qqexpand.widget.i.class);
        f314191a.put("deviceProtect", DeviceProtectJsApiPlugin.class);
        f314191a.put("historyhead", HistoryHeadWebViewPlugin.class);
        f314191a.put("bless", com.tencent.mobileqq.jsp.c.class);
        f314191a.put(ChatBackgroundJsPlugin.BUSINESS_NAME, ChatBackgroundJsPlugin.class);
        f314191a.put("pubAccountPreload", com.tencent.biz.webviewplugin.y.class);
        f314191a.put(WebViewJumpPlugin.f315044m, WebViewJumpPlugin.class);
        f314191a.put("homework", TroopHWJsPlugin.class);
        f314191a.put("coupon", tx.a.class);
        f314191a.put("qbizApi", SensorAPIJavaScript.class);
        f314191a.put("emoticon", com.tencent.mobileqq.emotionintegrate.o.class);
        f314191a.put("qqgame_api", com.tencent.mobileqq.qqgamepub.web.d.class);
        f314191a.put("wadl_download", WadlWebViewJsPlugin.class);
        f314191a.put("event", com.tencent.mobileqq.jsp.h.class);
        f314191a.put("theme", ThemeJsPlugin.class);
        f314191a.put("share", com.tencent.mobileqq.jsp.ao.class);
        f314191a.put(AvatarPendantJsPlugin.BUSINESS_NAME, AvatarPendantJsPlugin.class);
        f314191a.put("sms", com.tencent.mobileqq.jsp.ab.class);
        f314191a.put("GroupAppPanel", com.tencent.mobileqq.troop.jsp.a.class);
        f314191a.put("bubble", BubbleJsPlugin.class);
        f314191a.put(QWalletMixJsPlugin.OBJECT_NAME_QWALLET_MIX, QWalletMixJsPlugin.class);
        f314191a.put("QZFamousUserHome", QZoneFamousUserHomeJsPlugin.class);
        f314191a.put("login", com.tencent.mobileqq.jsp.o.class);
        f314191a.put("healthkit", HealthStepCounterPlugin.class);
        f314191a.put("eqq", com.tencent.biz.eqq.a.class);
        f314191a.put("QQApi", com.tencent.mobileqq.jsp.w.class);
        f314191a.put("qidian", yq3.a.class);
        f314191a.put("JD_REPORT", BusinessReportPlugin.class);
        f314191a.put(IndividuationUrlHelper.UrlId.CARD_HOME, com.tencent.mobileqq.profile.h.class);
        f314191a.put("arcard", com.tencent.biz.webviewplugin.a.class);
        f314191a.put("miniApp", MiniAppPlugin.class);
        f314191a.put("readInJoyWebRender", ReadInJoyWebRenderPlugin.class);
        f314191a.put("healthpathtrace", com.tencent.mobileqq.vashealth.g.class);
        f314191a.put("push", com.tencent.mobileqq.jsp.v.class);
        f314191a.put("zplan", ZPlanJsPluginImpl.class);
        f314191a.put(VipFunctionJsPlugin.BusinessName, VipFunctionJsPlugin.class);
        f314191a.put("65536", HealthUiPlugin.class);
        f314191a.put(QZoneJsConstants.PKGNAME_QZONE_INTERACTIVE_VIDEO, QZoneWebViewPlugin.class);
        f314191a.put("gdtReportPlugin", GDTReportPlugin.class);
        f314191a.put("262144", SuitUIPlugin.class);
        f314191a.put("troopApi", com.tencent.mobileqq.jsp.ad.class);
        f314191a.put("PtloginPlugin", com.tencent.biz.webviewplugin.x.class);
        f314191a.put("healthSport", HealthBusinessPlugin.class);
        f314191a.put("Gdt", com.tencent.mobileqq.jsp.ac.class);
        f314191a.put("512", AvatarPendantUiPlugin.class);
        f314191a.put("userVerify", com.tencent.biz.webviewplugin.ag.class);
        f314191a.put("groupInteractionIcon", com.tencent.mobileqq.troop.honor.f.class);
        f314191a.put("huayang", HuayangJsPluginImpl.class);
        f314191a.put("minigame_api", MiniGamePublicAccountWebViewJsPlugin.class);
        f314191a.put(IPublicAccountWebviewPlugin.NAME_SPACE, PublicAccountWebviewPluginImpl.class);
        f314191a.put(QCircleDaTongConstant.ElementParamValue.GIFT, com.tencent.mobileqq.vipgift.c.class);
        f314191a.put("faceUnblockCamera", FaceUnblockCameraJsApiPlugin.class);
        f314191a.put("location", com.tencent.biz.webviewplugin.h.class);
        f314191a.put(QZoneJsConstants.PKGNAME_QZONE_EC_LIVE, QZoneWebViewPlugin.class);
        f314191a.put(QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_NAMESPACE, QZonePersonalizePlugin.class);
        f314191a.put("33554432", ChatBackgroundUiPlugin.class);
        f314191a.put("praise", PraiseJsPlugin.class);
        f314191a.put("jubao", com.tencent.mobileqq.jubao.a.class);
        f314191a.put("QzoneData", QzoneWebViewOfflinePlugin.class);
        f314191a.put("qsubscribe", SubscribeJsPlugin.class);
        f314191a.put("1048576", IndividuationUIPlugin.class);
        f314191a.put("lebaPlugin", com.tencent.biz.lebasearch.a.class);
        f314191a.put(QZoneJsConstants.PKGNAME_IMAGEPICKER, QZoneWebViewPlugin.class);
        f314191a.put("URL_CHECK", UrlCheckPlugin.class);
        f314191a.put("REMIND", com.tencent.mobileqq.remind.d.class);
        f314191a.put("common", ThemeAndBubbleCommonJsPlugin.class);
        f314191a.put("accountRelease", com.tencent.biz.webviewplugin.c.class);
        f314191a.put("groupVideo", com.tencent.mobileqq.intervideo.groupvideo.c.class);
        f314191a.put(TreasureCardJsPlugin.BUSINESS_NAME, TreasureCardJsPlugin.class);
        f314191a.put("GiftJsPlugin", GiftJsPlugin.class);
        f314191a.put("video", com.tencent.mobileqq.video.d.class);
        f314191a.put(QWalletCommonJsPlugin.PLUGIN_NAMESPACE, QWalletCommonJsPlugin.class);
        f314191a.put("redEnvelope", com.tencent.biz.webviewplugin.g.class);
        f314191a.put("emojiEggSetting", com.tencent.mobileqq.intimate.b.class);
        f314191a.put(IPreloadResource.ABI_64, BubbleUiPlugin.class);
        f314191a.put(ServiceCreateTask.SERVICE_TYPE_X5, com.tencent.mobileqq.jsp.ap.class);
        f314191a.put("recallFriend", com.tencent.mobileqq.relationx.friendclue.a.class);
        f314191a.put("NearbyTroopsPlugin", com.tencent.biz.webviewplugin.j.class);
        f314191a.put(IPublicAccountJavascriptInterface.NAME_SPACE, PublicAccountJavascriptInterfaceImpl.class);
        f314191a.put("qqmusic", MusicGeneWebViewPlugin.class);
        f314191a.put(GdtAdWebPlugin.NAME_SPACE, GdtAdWebPlugin.class);
        f314191a.put(QQLevelJsPlugin.BUSINESS_NAME, QQLevelJsPlugin.class);
        f314191a.put(QQReaderJsPlugin.NAMESPACE, QQReaderJsPlugin.class);
        f314191a.put(OpenConstants.ApiName.PAY, PayJsPlugin.class);
        f314191a.put("together_business", TogetherBusinessForWebPlugin.class);
        f314191a.put("sayHonest", ConfessPlugin.class);
        f314191a.put("newLogin", com.tencent.mobileqq.addcontacts.c.class);
        f314191a.put("robotsummary", com.tencent.biz.webviewplugin.aj.class);
        f314191a.put("addContact_SecCheck", com.tencent.biz.webviewplugin.d.class);
        f314191a.put("profileJS", com.tencent.mobileqq.profile.a.class);
        f314191a.put("UrlSaveVerifyV2", WebSecurityPluginV2.class);
        f314191a.put("ecommerce", lg2.b.class);
        f314191a.put(ProcessConstant.READINJOY, s62.a.class);
        f314191a.put(SensorJsPlugin.SENSOR_INTERVAL_UI, UiApiPlugin.class);
        f314191a.put("AvatarState", com.tencent.mobileqq.jsp.b.class);
        f314191a.put("kdSearchResult", com.tencent.mobileqq.jsp.l.class);
        f314191a.put(QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_NAMESPACE, QZonePersonalizePlugin.class);
        f314191a.put(QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_NAMESPACE, QZonePersonalizePlugin.class);
        f314191a.put("vasAdv", com.tencent.mobileqq.vas.adv.web.b.class);
        f314191a.put(QWalletPayJsPlugin.OBJECT_NAME_NEW_COMPATIBLE_IOS, QWalletCommonHbJsPlugin.class);
        f314191a.put("4096", ChatFontUiPlugin.class);
        f314191a.put("story", com.tencent.mobileqq.jsp.y.class);
        f314191a.put("font", ChatFontJsPlugin.class);
        f314191a.put(MQPSecJsPlugin.NAMESPACE_SET_PWD, MQPSecJsPlugin.class);
        f314191a.put("listenTogether", com.tencent.mobileqq.jsp.m.class);
        f314191a.put("msgForward", com.tencent.mobileqq.msgforward.b.class);
        f314191a.put("campus_circle", com.tencent.mobileqq.campuscircle.c.class);
        f314191a.put(PreDetect.FACE_DETECT, com.tencent.mobileqq.vas.avatar.p.class);
        f314191a.put(FileReaderHelper.DOCX_EXT, DocxApiPlugin.class);
        f314191a.put("openToAppDetail", com.tencent.biz.webviewplugin.w.class);
        f314191a.put(ODAppJSPlugin.NAMESPACE, ODAppJSPlugin.class);
        f314191a.put(QQPermissionConstants.Permission.CALENDAR_GROUP, com.tencent.mobileqq.remind.d.class);
        f314191a.put("32", ThemeUiPlugin.class);
        f314191a.put(UploadQualityReportBuilder.STATE_CONNECT, com.tencent.mobileqq.jsp.d.class);
        f314191a.put(MessageRoamJsPlugin.PKGNAME, MessageRoamJsPlugin.class);
        f314191a.put("troopAssistantFeeds", com.tencent.mobileqq.troop.jsp.b.class);
        f314191a.put(QzonePlugin.C, QzonePlugin.class);
        f314191a.put(IndividuationPlugin.BusinessName, IndividuationPlugin.class);
        f314191a.put("historicalSig", com.tencent.mobileqq.richstatus.i.class);
        f314191a.put("offline", OfflinePlugin.class);
        f314191a.put(AskAnonymouslyApiPlugin.NAME_SPACE, AskAnonymouslyApiPlugin.class);
        f314191a.put(KingCardJsPlugin.BUSINESS_NAME, KingCardJsPlugin.class);
        f314191a.put("WebSo", WebSoPlugin.class);
        f314191a.put(QZoneJsConstants.PKGNAME_QZUI, QZoneWebViewPlugin.class);
        f314191a.put("device", com.tencent.mobileqq.jsp.f.class);
        f314191a.put(VasCommonJsPlugin.PLUGIN_NAMESPACE_QW_DATA, VasCommonJsPlugin.class);
        f314191a.put(ICGameJsPlugin.BUSINESS_NAME, ICGameJsPlugin.class);
        f314191a.put(QQIliveJsPlugin.BUSINESS_NAME, QQIliveJsPlugin.class);
        f314191a.put("8", EmojiSubPageUiPlugin.class);
        f314191a.put("4", EmojiSubHomeUiPlugin.class);
        f314191a.put(ColorScreenJsPlugin.BUSINESS_NAME, ColorScreenJsPlugin.class);
        f314191a.put("gflivesdk", com.tencent.mobileqq.jsp.n.class);
        f314191a.put("2", EmojiHomeUiPlugin.class);
        f314191a.put(VasCommonJsPlugin.PLUGIN_NAMESPACE_FRIEND_DATA, VasCommonJsPlugin.class);
        f314191a.put(QzoneWebMusicJsPlugin.MUSIC_METHOD_NAMESPACE, QzoneWebMusicJsPlugin.class);
        f314191a.put("qw", QWalletJsPlugin.class);
        f314191a.put("InputClickEvent", com.tencent.mobileqq.antiphing.a.class);
        f314191a.put(ColorRingJsPlugin.BusinessName, ColorRingJsPlugin.class);
        f314191a.put("qzDynamicAlbum", QZoneWebViewPlugin.class);
        f314191a.put("floatingWindow", k53.a.class);
        f314191a.put("identification", com.tencent.mobileqq.jsp.k.class);
        f314191a.put(QZoneJsConstants.PKGNAME_QZONE_CHECKIN, QZoneWebViewPlugin.class);
        f314191a.put("friendApi", com.tencent.mobileqq.jsp.i.class);
        f314191a.put("qztodayinhistory", com.tencent.biz.webviewplugin.ab.class);
        f314191a.put(com.tencent.mobileqq.msf.core.x.q.f250387s, SSOWebviewPlugin.class);
        f314191a.put("qcircle", QCircleJsPlugin.class);
        f314191a.put(QQCardJsPlugin.BUSINESS_NAME, QQCardJsPlugin.class);
        f314191a.put("TroopMemberApiPlugin", com.tencent.biz.troop.c.class);
        f314191a.put(QZoneCoverStoreJsPlugin.PKG_NAME, QZoneCoverStoreJsPlugin.class);
        f314191a.put("troopNotice", TroopNoticeJsHandler.class);
        f314191a.put("springhb", SpringHbJsPlugin.class);
        f314191a.put("qav", ww.a.class);
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        f314192b = arrayList;
        arrayList.add(ok1.e.class);
        f314192b.add(com.tencent.mobileqq.guild.webview.f.class);
        f314192b.add(com.tencent.mobileqq.zplan.web.api.impl.a.class);
        f314192b.add(com.tencent.mobileqq.weiyun.b.class);
        f314192b.add(com.tencent.mobileqq.vashealth.d.class);
        f314192b.add(com.tencent.mobileqq.jsp.j.class);
        f314192b.add(com.tencent.biz.webviewplugin.ac.class);
        f314192b.add(MiniCreatePluginChecker.class);
        f314192b.add(l44.a.class);
        f314193c = new ArrayList<>();
        f314194d = new HashMap<>();
        int i3 = 0;
        for (Map.Entry<String, Class<? extends WebViewPlugin>> entry : f314191a.entrySet()) {
            HashMap<Class<? extends WebViewPlugin>, Integer> hashMap2 = f314194d;
            if (!hashMap2.containsKey(entry.getValue())) {
                i3++;
                hashMap2.put(entry.getValue(), Integer.valueOf(i3));
            }
        }
        if (f314191a.size() > 0) {
            if (QLog.isDevelopLevel()) {
                for (Map.Entry<String, Class<? extends WebViewPlugin>> entry2 : f314191a.entrySet()) {
                    QLog.i("WebViewPluginFactory", 2, "Key = " + entry2.getKey() + ", Value = " + entry2.getValue().toString());
                }
            }
        } else {
            QLog.e("WebViewPluginFactory", 1, "sWebViewTabBar inject failed !");
        }
        Iterator<Class<? extends c>> it = f314192b.iterator();
        while (it.hasNext()) {
            try {
                f314193c.add(it.next().newInstance());
            } catch (Throwable th5) {
                QLog.e("WebViewPluginFactory", 1, "preCreate plugin error: " + th5.getMessage(), th5);
            }
        }
        if (f314192b.size() > 0) {
            if (QLog.isDevelopLevel()) {
                Iterator<c> it5 = f314193c.iterator();
                while (it5.hasNext()) {
                    QLog.i("WebViewPluginFactory", 2, "checker = " + it5.next().toString());
                }
                return;
            }
            return;
        }
        QLog.e("WebViewPluginFactory", 1, "sWebViewTabBar inject failed !");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebViewPlugin a(int i3) {
        boolean isDebugVersion;
        RuntimeException runtimeException;
        for (Map.Entry<Class<? extends WebViewPlugin>, Integer> entry : f314194d.entrySet()) {
            if (entry.getValue().intValue() == i3) {
                try {
                    return entry.getKey().newInstance();
                } finally {
                    if (!isDebugVersion) {
                    }
                }
            }
        }
        return null;
    }

    public static WebViewPlugin b(String str) {
        boolean isDebugVersion;
        RuntimeException runtimeException;
        if (!TextUtils.isEmpty(str) && f314191a.containsKey(str)) {
            try {
                return f314191a.get(str).newInstance();
            } finally {
                if (!isDebugVersion) {
                }
            }
        } else {
            return null;
        }
    }
}
