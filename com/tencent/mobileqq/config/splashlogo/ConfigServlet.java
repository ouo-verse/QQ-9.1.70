package com.tencent.mobileqq.config.splashlogo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Xml;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;
import com.tencent.aelight.camera.qqstory.api.IQIMBeautyManager;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.av.l;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.nf.i;
import com.tencent.luggage.wxa.rf.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.m;
import com.tencent.mobileqq.activity.shortvideo.e;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.soso.LbsInfoReportManager;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.config.aj;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.h;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Screen;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.ReportedBanner;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.f;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pttlogic.api.IPttConfigService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.o;
import com.tencent.mobileqq.search.util.v;
import com.tencent.mobileqq.search.util.w;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.r;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.aa;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.upgrade.UpgradeConfigTypeParser;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.upgrade.k;
import com.tencent.mobileqq.upgrade.n;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.bg;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.p;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.util.notification.NotificationController;
import com.tencent.view.FilterEnum;
import com.tencent.xweb.FileReaderHelper;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.IQWalletHelper;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.InflaterInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mqq.app.AppRuntime;
import mqq.app.api.ProcessConstant;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import xc0.c;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ConfigServlet {

    /* renamed from: b, reason: collision with root package name */
    public static String f202907b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f202908c = HardCodeUtil.qqStr(R.string.kzw);

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f202909d = {1, 2, 3, 10, 13, 23, 31, 38, 42, 44, 47, 49, 55, 56, 57, 61, 62, 63, 64, 65, 66, 69, 205, 385, 94, 78, 79, 80, 223, 82, 101, 102, 147, 93, 90, 97, 108, 109, 115, 286, 119, 116, 130, 142, 157, 211, 201, 129, 140, 257, 232, 233, 148, 139, 145, 149, 155, 165, 185, 171, 180, 177, 371, 184, 187, 191, 193, 188, 195, 227, 210, 212, 407, c.b(R.integer.f167217y), c.b(R.integer.f167218z), c.b(R.integer.f167219a0), c.b(R.integer.f167215v), c.b(R.integer.f167216w), 218, 226, 225, 222, 256, 228, 235, 234, 238, 247, 244, 245, 253, 254, 259, 260, 262, 204, 275, d.CTRL_INDEX, 268, 269, 274, FilterEnum.MIC_PTU_TRANS_ROUHE, FilterEnum.MIC_PTU_TRANS_KONGCHENG, 283, 284, FilterEnum.MIC_PTU_ZIRAN, 301, i.CTRL_INDEX, 326, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 336, 349, 355, MsgConstant.KRMFILETHUMBSIZE384, 379, 273, 364, 365, 369, tlv_t183.CMD_183, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_EXTERNAL_COMMENT_TYPE, 394, 401, 400, 403, 405, 408, 194, 596, 705};

    /* renamed from: a, reason: collision with root package name */
    private boolean f202910a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f202938a;

        a(QQAppInterface qQAppInterface) {
            this.f202938a = qQAppInterface;
        }

        @Override // com.tencent.mobileqq.config.splashlogo.ConfigServlet.b
        public void a(List<String> list) {
            if (list != null && list.size() > 0) {
                r.c(this.f202938a.getApp(), list);
            }
        }

        @Override // com.tencent.mobileqq.config.splashlogo.ConfigServlet.b
        public int b() {
            return r.a(this.f202938a.getApp());
        }

        @Override // com.tencent.mobileqq.config.splashlogo.ConfigServlet.b
        public void c(int i3) {
            r.b(this.f202938a.getApp(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void a(List<String> list);

        int b();

        void c(int i3);
    }

    private void C0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        E(qQAppInterface, configurationService$Config, "handleShortVideoMsgTailConfig", new a(qQAppInterface));
    }

    private void D(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
        if (pBRepeatField != null && pBRepeatField.size() > 0) {
            String str = configurationService$Config.content_list.get(0);
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 61,content: " + str + ",version: " + configurationService$Config.version.get());
            }
            int i3 = configurationService$Config.version.get();
            int w3 = ea.w(qQAppInterface.getApp());
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG remote version: " + i3 + " | localVersion: " + w3);
            }
            if (i3 != w3) {
                ea.E3(qQAppInterface.getApp(), i3);
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save version: " + i3);
                }
                ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).updateCompatibleList(str, true);
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save to sps");
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 61,content_list is empty ,version: " + configurationService$Config.version.get());
        }
    }

    private void D0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
        if (pBRepeatField != null && pBRepeatField.size() > 0) {
            String str = configurationService$Config.content_list.get(0);
            int i3 = configurationService$Config.version.get();
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 64,content: " + str + ",version: " + configurationService$Config.version.get());
            }
            if (i3 != ea.x1(qQAppInterface.getApp())) {
                ea.V4(qQAppInterface.getApp(), i3);
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save version: " + i3);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save to sps");
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 64,content_list is empty ,version: " + configurationService$Config.version.get());
        }
    }

    private void E0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        try {
            PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
            if (pBRepeatField != null && pBRepeatField.size() > 0) {
                for (int i3 = 0; i3 < configurationService$Config.content_list.size(); i3++) {
                    String str = configurationService$Config.content_list.get(i3);
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 66,content: " + str + ",version: " + configurationService$Config.version.get());
                    }
                    int i16 = configurationService$Config.version.get();
                    int D1 = ea.D1(qQAppInterface.getApp(), qQAppInterface.getAccount());
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD remote version: " + i16 + " | localVersion: " + D1);
                    }
                    if (i16 == D1 && configurationService$Config.content_list.size() <= 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD IGNORE THIS ACTION  because of SAME VERSION");
                        }
                    }
                    if (((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).updateSubscriptRecommendConfig(qQAppInterface, str) && QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD save version: " + i16);
                    }
                    ea.Y4(qQAppInterface.getApplication(), qQAppInterface.getAccount(), i16);
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 66,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServlet", 2, "received subscript recommend config error,cmd : 66");
            }
        }
    }

    public static String F(ConfigurationService$Config configurationService$Config, int i3, int i16) {
        return aj.d(configurationService$Config, i3, i16);
    }

    private void H(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        JSONArray jSONArray;
        int i3 = configurationService$Config.version.get();
        int K = ea.K(BaseApplication.getContext(), f202907b);
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: ,version: " + configurationService$Config.version.get() + "| localVersion: " + K);
        }
        if (i3 != K) {
            ea.Q3(BaseApplication.getContext(), f202907b, i3);
            List<String> X0 = X0(configurationService$Config);
            HashSet hashSet = new HashSet();
            if (X0 != null && X0.size() > 0) {
                for (String str : X0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: config_content =" + str);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("enable")) {
                            int i16 = jSONObject.getInt("enable");
                            m a16 = m.a();
                            boolean z16 = true;
                            if (i16 != 1) {
                                z16 = false;
                            }
                            a16.k(qQAppInterface, z16);
                        } else {
                            m.a().k(qQAppInterface, false);
                        }
                        if (jSONObject.has("list") && (jSONArray = jSONObject.getJSONArray("list")) != null && jSONArray.length() > 0) {
                            int length = jSONArray.length();
                            for (int i17 = 0; i17 < length; i17++) {
                                String optString = jSONArray.optString(i17);
                                if (!TextUtils.isEmpty(optString)) {
                                    hashSet.add(optString);
                                }
                            }
                        }
                        m.a().l(qQAppInterface, hashSet);
                    } catch (JSONException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig  error =" + e16.getMessage());
                        }
                        m.a().k(qQAppInterface, false);
                        m.a().l(qQAppInterface, null);
                    }
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig:localVersiont == version ");
        }
    }

    private void J0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        List<String> X0;
        boolean z16;
        int i3 = configurationService$Config.version.get();
        BaseApplication app = qQAppInterface.getApp();
        String currentUin = qQAppInterface.getCurrentUin();
        int intValue = ((Integer) p.b(app, currentUin, AppConstants.Preferences.CONFIG_TIM_TEAM_VERSION_CODE, 0)).intValue();
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "handleTimTeamConfig received Config remote version:" + i3 + " localVersion= " + intValue);
        }
        if (i3 != intValue && (X0 = X0(configurationService$Config)) != null && X0.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(X0.get(0));
                String str = "";
                if (jSONObject.has("isWeb")) {
                    z16 = jSONObject.getBoolean("isWeb");
                } else {
                    z16 = false;
                }
                if (jSONObject.has("url")) {
                    str = jSONObject.getString("url");
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "handleTimTeamConfig isWeb=" + z16 + " url=" + str);
                }
                p.g(app, currentUin, false, AppConstants.Preferences.CONFIG_TIM_TEAM_IS_WEB, Boolean.valueOf(z16));
                p.g(app, currentUin, false, AppConstants.Preferences.CONFIG_TIM_TEAM_URL, str);
                p.g(app, currentUin, true, AppConstants.Preferences.CONFIG_TIM_TEAM_VERSION_CODE, Integer.valueOf(i3));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, e16.getMessage());
                }
            }
        }
    }

    private void K(final QQAppInterface qQAppInterface, final ConfigurationService$Config configurationService$Config) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.config.splashlogo.ConfigServlet.7
            @Override // java.lang.Runnable
            public void run() {
                PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
                if (pBRepeatField != null && pBRepeatField.size() > 0) {
                    ConfigurationService$Config configurationService$Config2 = configurationService$Config;
                    if (configurationService$Config2.version != null) {
                        String str = configurationService$Config2.content_list.get(0);
                        int i3 = configurationService$Config.version.get();
                        int T = ea.T(qQAppInterface.getApp());
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 63,content: " + str + ",version: " + configurationService$Config.version.get());
                        }
                        if (i3 > T) {
                            com.tencent.mobileqq.app.p.d(qQAppInterface, str, i3);
                            return;
                        }
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 63,content_list is empty ,version: " + configurationService$Config.version.get());
                }
            }
        }, 5, null, false);
    }

    private void L(QQAppInterface qQAppInterface, Intent intent, ConfigurationService$Config configurationService$Config) {
        List<String> list;
        boolean z16;
        int i3;
        boolean z17;
        String[] split;
        PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
        if (pBRepeatField != null && pBRepeatField.size() > 0) {
            list = configurationService$Config.content_list.get();
        } else {
            list = null;
        }
        if (list != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            for (int i16 = 0; i16 < list.size(); i16++) {
                String str = list.get(i16);
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 101,content: " + str + ",version: " + configurationService$Config.version.get());
                }
                if (!TextUtils.isEmpty(str) && (split = str.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length == 2) {
                    hashMap.put(split[0], split[1]);
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "GENERAL_CONFIGS_CMD, name=" + split[0] + ", val=" + split[1]);
                    }
                }
            }
            String str2 = (String) hashMap.get("ptlogin_flag");
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
            sharedPreferences.edit().putBoolean("ptlogin_flag" + qQAppInterface.getAccount(), "1".equalsIgnoreCase(str2)).commit();
            String str3 = (String) hashMap.get("lmr_block");
            if (QLog.isColorLevel()) {
                QLog.i("new_regprxy_switch", 2, "GENERAL_CONFIGS_CMD, new_regprxy_switch=" + str3);
            }
            if (str3 != null) {
                BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("new_regprxy_switch", "1".equalsIgnoreCase(str3)).commit();
            }
            String str4 = (String) hashMap.get("qfind_report_gps_bt_stat");
            String str5 = (String) hashMap.get("qfind_searching");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("qfind_searching" + qQAppInterface.getAccount(), "1".equals(str5));
            edit.putBoolean("qfind_report_gps_bt_stat" + qQAppInterface.getAccount(), "1".equals(str4));
            edit.commit();
            String str6 = (String) hashMap.get("enable_public_device");
            if (str6 != null) {
                BaseApplication.getContext().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("enable_public_device_" + qQAppInterface.getAccount(), "1".equalsIgnoreCase(str6)).commit();
            }
            String str7 = (String) hashMap.get("search_device_enable_https");
            if (str7 != null) {
                BaseApplication.getContext().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("search_device_enable_https_" + qQAppInterface.getAccount(), "1".equalsIgnoreCase(str7)).commit();
                if (QLog.isColorLevel()) {
                    QLog.w(ProcessConstant.SMARTDEVICE, 2, "search_device_enable_https=" + str7);
                }
            }
            String str8 = (String) hashMap.get("mqq_calltab");
            String str9 = (String) hashMap.get("mqq_calltab_setting");
            if (str8 != null || str9 != null) {
                Integer[] numArr = new Integer[7];
                if (str8 != null) {
                    if (str8.indexOf(124) > 0) {
                        numArr[1] = Integer.valueOf(str8.split("|")[0].equals("1") ? 1 : 0);
                    } else {
                        numArr[1] = Integer.valueOf(str8.equals("1") ? 1 : 0);
                    }
                }
                if (str9 != null) {
                    numArr[5] = Integer.valueOf(str9.equals("1") ? 1 : 0);
                }
                qQAppInterface.writeCallTabStateVal(numArr);
            }
            String str10 = (String) hashMap.get("subscribe_discovery");
            if (!TextUtils.isEmpty(str10)) {
                SubscriptRecommendController.F(qQAppInterface, "1".equals(str10));
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "subscribe discovery btn config : " + str10);
                }
            }
            if (str8 == null || str9 == null) {
                Integer[] numArr2 = new Integer[7];
                if (str8 == null) {
                    numArr2[1] = Integer.valueOf(AppConstants.CallTabType.CALLTAB_DEFAULTVAL.charAt(1) - '0');
                    numArr2[2] = Integer.valueOf(AppConstants.CallTabType.CALLTAB_DEFAULTVAL.charAt(2) - '0');
                }
                if (str9 == null) {
                    numArr2[5] = Integer.valueOf(AppConstants.CallTabType.CALLTAB_DEFAULTVAL.charAt(5) - '0');
                    numArr2[6] = Integer.valueOf(AppConstants.CallTabType.CALLTAB_DEFAULTVAL.charAt(6) - '0');
                }
                qQAppInterface.writeCallTabStateVal(numArr2);
            }
            ea.Y3(qQAppInterface.getApplication(), configurationService$Config.version.get(), f202907b);
            if (intent != null && intent.hasExtra("update101Version")) {
                SettingCloneUtil.writeValueForInt(qQAppInterface.getApplication(), f202907b, null, AppConstants.QQSETTING_CALLTAB_SHOW_KEY_VERSION, intent.getIntExtra("update101Version", 0));
            }
            ((IArkConfig) QRoute.api(IArkConfig.class)).setPANonShow((String) hashMap.get("arkapp_pa_nshow"));
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(qQAppInterface.getAccount(), INearbySPUtil.HOTCHAT_DEMO_SWITCH, Boolean.valueOf("1".equals(hashMap.get("hotchat_demo"))));
            IPttConfigService iPttConfigService = (IPttConfigService) qQAppInterface.getRuntimeService(IPttConfigService.class, "all");
            iPttConfigService.onGetStreamSliceCfg((String) hashMap.get(IPttConfigService.TAG_STREAM_SLICE_CFG));
            iPttConfigService.onGetPttOptimizeCfg((String) hashMap.get(IPttConfigService.TAG_PTT_OPTIMIZE_CFG));
            iPttConfigService.onGetPreDownloadCfg((String) hashMap.get(IPttConfigService.TAG_PRE_DOWNLOAD_CFG));
            String str11 = (String) hashMap.get("kFreezeTipsShow");
            if (!TextUtils.isEmpty(str11) && !"1".equals(str11)) {
                z16 = false;
            } else {
                z16 = true;
            }
            g.l(IQWalletHelper.PREF_KEY_MULTI_IS_TENPAY_YELLOWTIP_VALID, z16);
            SharedPreferences sharedPreferences2 = qQAppInterface.getApp().getSharedPreferences(IQWalletHelper.PREF_NAME_MULTI_PROCESS, 4);
            if (sharedPreferences2 != null) {
                SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                if (!TextUtils.isEmpty(str11) && !"1".equals(str11)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                edit2.putBoolean(IQWalletHelper.PREF_KEY_MULTI_IS_TENPAY_YELLOWTIP_VALID, z17);
                String str12 = (String) hashMap.get("publicWhiteList");
                ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).updatePublicAccWhiteMap(str12);
                edit2.putString(IQWalletHelper.PREF_KEY_MULTI_PUBLICACC_WHITE_LIST, str12);
                edit2.commit();
            }
            ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).updateHongBaoSpeedWitch(qQAppInterface, (String) hashMap.get("hongbao_speed"));
            String str13 = (String) hashMap.get("shortvideo_predownload_strategy");
            if (str13 != null) {
                try {
                    qQAppInterface.getShortVideoPredownloer().E.set(Integer.valueOf(str13).intValue());
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, e16.getMessage());
                    }
                }
            }
            String str14 = (String) hashMap.get("camera_compatible_list");
            if (str14 != null) {
                try {
                    ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).updateCompatibleList(str14, true);
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "camera_compatible_list ERROR = " + e17.getMessage());
                    }
                }
            }
            String str15 = (String) hashMap.get("qqwifi_provider_mask");
            if (str15 != null) {
                sharedPreferences.edit().putString("qqwifi_provider_mask", str15).commit();
            }
            String str16 = (String) hashMap.get("signalling_switch");
            if (QLog.isColorLevel()) {
                QLog.i("signalling_switch", 2, "GENERAL_CONFIGS_CMD, signalling_switch=" + str16);
            }
            if (str16 != null) {
                qQAppInterface.getMsgCache().T1("1".equals(str16) ? 1 : 0);
            }
            String str17 = (String) hashMap.get("public_offline_search_enable");
            if (QLog.isColorLevel()) {
                QLog.i("PAOfflineSearchManager", 2, "GENERAL_CONFIGS_CMD, public_offline_search_enable=" + str17);
            }
            if (str17 != null) {
                o.a().f285064c = "1".equals(str17);
            }
            String str18 = (String) hashMap.get("public_advance_search_freq");
            if (QLog.isColorLevel()) {
                QLog.i("searchutils", 2, "GENERAL_CONFIGS_CMD, netsearchlevel=" + str18);
            }
            if (str18 != null) {
                try {
                    SearchUtils.f284959h = Integer.valueOf(str18).intValue();
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
            e.a((String) hashMap.get("shortvideo_progressive_enable"));
            String str19 = (String) hashMap.get("aio_autoinput_time");
            if (str19 != null) {
                try {
                    i3 = Integer.parseInt(str19);
                } catch (NumberFormatException unused) {
                    QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, aio_autoinput_time not a int");
                    i3 = 900;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, aio_autoinput_time=" + str19);
                }
                BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("aio_autoinput_time", i3).commit();
            }
            String str20 = (String) hashMap.get("Show_Business_Card");
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCara_Manager", 2, "Show_Business_Card= " + str20);
            }
            String str21 = (String) hashMap.get("TIMDocLimitSettingFlag");
            if (QLog.isColorLevel()) {
                QLog.i("TIMDocLimitSettingFlag", 2, "GENERAL_CONFIGS_CMD, TIMDocLimitSettingFlag = " + str21);
            }
            if (str21 != null) {
                BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit().putBoolean("TIMDocLimitSettingFlag", "1".equalsIgnoreCase(str21)).commit();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 101,content_list is empty ,version: " + configurationService$Config.version.get());
        }
    }

    private void L0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3;
        String str;
        String str2;
        String str3;
        int i16;
        boolean z16;
        boolean z17;
        int i17 = configurationService$Config.version.get();
        int F1 = ea.F1(qQAppInterface.getApp(), qQAppInterface.getAccount());
        int E1 = ea.E1(qQAppInterface.getApp(), qQAppInterface.getAccount());
        int f16 = AppSetting.f();
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, String.format("received TimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", Integer.valueOf(i17), Integer.valueOf(F1), Integer.valueOf(E1), Integer.valueOf(f16)));
        }
        if (E1 != f16) {
            ea.b5(qQAppInterface.getApp(), qQAppInterface.getAccount(), f16);
            F1 = 0;
        }
        if (i17 != F1) {
            List<String> X0 = X0(configurationService$Config);
            if (X0 != null && X0.size() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(X0.get(0));
                    if (jSONObject.has("TIMPersonality")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("TIMPersonality");
                        if (jSONObject2.has("aioTitleBgSwitch")) {
                            i16 = jSONObject2.getInt("aioTitleBgSwitch");
                            z16 = true;
                        } else {
                            i16 = 0;
                            z16 = false;
                        }
                        if (jSONObject2.has("androidResourceURL")) {
                            str2 = jSONObject2.getString("androidResourceURL");
                        } else {
                            str2 = null;
                        }
                        if (jSONObject2.has("androidMD5")) {
                            str3 = jSONObject2.getString("androidMD5");
                        } else {
                            str3 = null;
                        }
                    } else {
                        str2 = null;
                        str3 = null;
                        i16 = 0;
                        z16 = false;
                    }
                    if (z16 && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        String k3 = com.tencent.mobileqq.activity.aio.tim.a.i().k(qQAppInterface);
                        String j3 = com.tencent.mobileqq.activity.aio.tim.a.i().j(qQAppInterface);
                        try {
                            if (k3.equals(str2) && j3.equals(str3)) {
                                z17 = false;
                                com.tencent.mobileqq.activity.aio.tim.a.i().o(0, i16, str2, "", str3, "", z17, 0);
                                int i18 = i16;
                                String str4 = str2;
                                i3 = 2;
                                str = "SPLASH_ConfigServlet";
                                ea.a5(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), i17, 0, i18, str4, str3, "", "", z17, 0);
                                return;
                            }
                            ea.a5(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), i17, 0, i18, str4, str3, "", "", z17, 0);
                            return;
                        } catch (JSONException e16) {
                            e = e16;
                            if (QLog.isColorLevel()) {
                                QLog.d(str, i3, "receiveAllConfigs|type: 256 exception =" + e.toString());
                                return;
                            }
                            return;
                        }
                        z17 = true;
                        com.tencent.mobileqq.activity.aio.tim.a.i().o(0, i16, str2, "", str3, "", z17, 0);
                        int i182 = i16;
                        String str42 = str2;
                        i3 = 2;
                        str = "SPLASH_ConfigServlet";
                    }
                } catch (JSONException e17) {
                    e = e17;
                    i3 = 2;
                    str = "SPLASH_ConfigServlet";
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 256,configStrList is empty ,version: " + configurationService$Config.version.get());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void M(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        IOCRService iOCRService = (IOCRService) qQAppInterface.getRuntimeService(IOCRService.class, "");
        int configVersion = iOCRService.getConfigVersion();
        int i3 = configurationService$Config.version.get();
        boolean z16 = true;
        QLog.d("SPLASH_ConfigServlet", 1, "handleGetOCRConfig, version:" + i3 + ",localVersion:" + configVersion);
        OcrConfig ocrConfig = null;
        r5 = null;
        r5 = null;
        r5 = null;
        String stringUtf8 = null;
        ocrConfig = null;
        ocrConfig = null;
        ocrConfig = null;
        if (configVersion != i3) {
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                if (configurationService$Content != null) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                        if (d16 != null) {
                            try {
                                stringUtf8 = new String(d16, "UTF-8");
                            } catch (Throwable th5) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, "Throwable:" + th5.getMessage());
                                }
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "inflateConfigString error!");
                        }
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    OcrConfig parse = OcrConfig.parse(stringUtf8);
                    if (parse != null) {
                        parse.version = i3;
                        ocrConfig = parse;
                    } else {
                        ocrConfig = parse;
                    }
                }
            } else {
                OcrConfig.deleteLocalConfig(f202907b);
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "handleGetOCRConfig, msg_content_list is null");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleGetOCRConfig, isSucc = " + z16 + ", ocrConfig = " + ocrConfig);
            }
            iOCRService.onGetOCRConfig(z16, ocrConfig);
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        iOCRService.onGetOCRConfig(z16, ocrConfig);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01b7 A[Catch: Exception -> 0x020b, TryCatch #1 {Exception -> 0x020b, blocks: (B:3:0x0020, B:5:0x0024, B:8:0x002b, B:10:0x0033, B:12:0x0045, B:13:0x0069, B:15:0x007b, B:18:0x0081, B:21:0x0090, B:26:0x00ef, B:28:0x0133, B:29:0x0145, B:31:0x014f, B:32:0x0161, B:34:0x016b, B:35:0x017d, B:37:0x0187, B:38:0x0199, B:39:0x01be, B:41:0x01dc, B:44:0x01b1, B:46:0x01b7, B:52:0x01cc, B:54:0x01d5, B:60:0x01e6, B:62:0x01ec), top: B:2:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void M0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        String str;
        int i3;
        String str2;
        int i16;
        JSONObject jSONObject;
        String optString;
        String optString2;
        String optString3;
        QQAppInterface qQAppInterface2 = qQAppInterface;
        ConfigurationService$Config configurationService$Config2 = configurationService$Config;
        String str3 = AppConstants.Preferences.TROOP_COMMON_CONFIG_VERSION;
        int i17 = 2;
        try {
            PBRepeatField<String> pBRepeatField = configurationService$Config2.content_list;
            if (pBRepeatField != null && pBRepeatField.size() > 0) {
                int i18 = 0;
                while (i18 < configurationService$Config2.content_list.size()) {
                    String trim = configurationService$Config2.content_list.get(i18).trim();
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet.troop_common_config", i17, "receiveAllConfigs|type: 142,content: " + trim + ",version: " + configurationService$Config2.version.get());
                    }
                    int i19 = configurationService$Config2.version.get();
                    if (i19 != ea.P1(qQAppInterface.getApp(), str3, f202907b) && !TextUtils.isEmpty(trim)) {
                        try {
                            jSONObject = new JSONObject(trim);
                            i3 = i18;
                        } catch (JSONException unused) {
                            str2 = str3;
                            i3 = i18;
                        }
                        try {
                            ea.h4(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), jSONObject.optString(AppConstants.Preferences.HOT_CHAT_LINK));
                            ea.g4(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), jSONObject.optInt(AppConstants.Preferences.HOT_CHAT_AIO_POST_TAB_PLUGIN));
                            ((ITroopRobotService) qQAppInterface2.getRuntimeService(ITroopRobotService.class, "all")).configRobotFromServer(jSONObject);
                            ((LbsInfoReportManager) qQAppInterface2.getManager(QQManagerFactory.LBS_REPORT_MANAGER)).p(jSONObject);
                            ea.R3(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), jSONObject.optInt(AppConstants.Preferences.CREATE_TROOP_MAX_INVITE_NUM));
                            optString = jSONObject.optString("nearby_faceVideo_show");
                            optString2 = jSONObject.optString("nearby_faceVideo_LV");
                            optString3 = jSONObject.optString("nearby_heart_switch");
                            str2 = str3;
                            i16 = i19;
                        } catch (JSONException unused2) {
                            str2 = str3;
                            i16 = i19;
                            if (QLog.isColorLevel()) {
                            }
                            str = str2;
                            ea.l5(qQAppInterface.getApp(), str, f202907b, i16);
                            i18 = i3 + 1;
                            qQAppInterface2 = qQAppInterface;
                            configurationService$Config2 = configurationService$Config;
                            str3 = str;
                            i17 = 2;
                        }
                        try {
                            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("nearby_enters", 4);
                            sharedPreferences.edit().putString("config_content", trim).commit();
                            sharedPreferences.edit().putString("nearby_faceVideo_show", optString).commit();
                            sharedPreferences.edit().putString("nearby_heart_switch", optString3).commit();
                            sharedPreferences.edit().putString("nearby_faceVideo_LV", optString2).commit();
                            JSONObject optJSONObject = jSONObject.optJSONObject("face_score_enter_config");
                            if (!TextUtils.isEmpty(optJSONObject.optString("title"))) {
                                sharedPreferences.edit().putString("face_title", optJSONObject.optString("title")).commit();
                            }
                            if (!TextUtils.isEmpty(optJSONObject.optString("detail_default"))) {
                                sharedPreferences.edit().putString("face_detail_default", optJSONObject.optString("detail_default")).commit();
                            }
                            if (!TextUtils.isEmpty(optJSONObject.optString("jump_url"))) {
                                sharedPreferences.edit().putString("face_jump_url", optJSONObject.optString("jump_url")).commit();
                            }
                            if (!TextUtils.isEmpty(optJSONObject.optString("detail_num"))) {
                                sharedPreferences.edit().putString("face_detail_num", optJSONObject.optString("detail_num")).commit();
                            }
                            ea.f5(qQAppInterface.getApp(), jSONObject.optString("group_houseKeeper_switch"));
                        } catch (JSONException unused3) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received JSONException ");
                            }
                            str = str2;
                            ea.l5(qQAppInterface.getApp(), str, f202907b, i16);
                            i18 = i3 + 1;
                            qQAppInterface2 = qQAppInterface;
                            configurationService$Config2 = configurationService$Config;
                            str3 = str;
                            i17 = 2;
                        }
                        str = str2;
                        ea.l5(qQAppInterface.getApp(), str, f202907b, i16);
                    } else {
                        str = str3;
                        i3 = i18;
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
                        }
                    }
                    i18 = i3 + 1;
                    qQAppInterface2 = qQAppInterface;
                    configurationService$Config2 = configurationService$Config;
                    str3 = str;
                    i17 = 2;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "receiveAllConfigs|type: 142,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received change machine config error,cmd : 142" + e16.toString());
            }
        }
    }

    private void O(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        try {
            int i3 = configurationService$Config.version.get();
            int g06 = ea.g0(qQAppInterface.getApp(), qQAppInterface.getAccount());
            PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
            boolean z16 = false;
            if (pBRepeatField != null && pBRepeatField.size() > 0) {
                String str = configurationService$Config.content_list.get(0);
                if (QLog.isColorLevel()) {
                    QLog.d("HeadsUp", 2, "received Headsup Notify configVersion:" + i3 + " ,localVersion:" + g06 + " ,configContent" + str);
                }
                if (i3 != g06) {
                    if (str.contains("headsup_switch")) {
                        z16 = str.split(ContainerUtils.KEY_VALUE_DELIMITER)[1].trim().equals("true");
                    }
                    ea.e4(qQAppInterface.getApp(), qQAppInterface.getAccount(), i3, true, z16);
                    return;
                }
                return;
            }
            if (i3 != g06) {
                ea.e4(qQAppInterface.getApp(), qQAppInterface.getAccount(), i3, false, true);
                qQAppInterface.mqqService.f286095k = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("HeadsUp", 2, "received Headsup Notify configVersion:" + i3 + " ,localVersion:" + g06);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("HeadsUp", 2, "received Headsup Notify error", e16);
            }
        }
    }

    private void Q(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        int d16 = bg.d();
        int i3 = configurationService$Config.version.get();
        if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|received remote version: " + i3 + " | localVersion: " + d16);
        }
        if (i3 != d16) {
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                if (configurationService$Content != null) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] d17 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                        if (d17 != null) {
                            try {
                                stringUtf8 = new String(d17, "UTF-8");
                            } catch (Throwable th5) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|Throwable:" + th5.getMessage());
                                }
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|inflateConfigString error!");
                        }
                        stringUtf8 = "";
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    bg.f().n(qQAppInterface.getApp(), stringUtf8, i3);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]| content==null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]| msg_content_list is empty ,version: " + i3 + ",localVersion:" + d16);
            }
            bg.f().a(i3);
        }
    }

    private void R(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        QLog.i(NotificationController.TAG, 1, "[handleLimitNotifyConfig]");
        int i3 = configurationService$Config.version.get();
        int f16 = AppSetting.f();
        NotificationController notificationController = (NotificationController) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER);
        int configVersion = notificationController.getConfigVersion(BaseApplication.getContext(), qQAppInterface.getAccount());
        if (notificationController.getConfigAppId(BaseApplication.getContext(), qQAppInterface.getAccount()) != f16) {
            configVersion = 0;
        }
        if (i3 != configVersion) {
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                for (ConfigurationService$Content configurationService$Content : configurationService$Config.msg_content_list.get()) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] decodeXML = notificationController.decodeXML(configurationService$Content.content.get().toByteArray());
                        if (decodeXML != null) {
                            stringUtf8 = new String(decodeXML);
                        } else {
                            stringUtf8 = null;
                        }
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    try {
                        notificationController.parseXMLAndSave(stringUtf8, i3, f16);
                    } catch (Exception e16) {
                        QLog.e(NotificationController.TAG, 1, "[handleLimitNotifyConfig] parse fail", e16);
                        return;
                    }
                }
                return;
            }
            QLog.i(NotificationController.TAG, 1, "[hangleLimitNotifyConfig] config has no data");
            notificationController.cleanConfig(f202907b);
        }
    }

    private void R0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField;
        ConfigurationService$Content configurationService$Content;
        String stringUtf8;
        String str;
        int i3 = configurationService$Config.version.get();
        int J1 = ea.J1(qQAppInterface.getApp());
        if (QLog.isColorLevel()) {
            QLog.d("TroopRankConfig", 2, "handleTroopRankConfigCmd, serverVersion=" + i3 + "|localVersion=" + J1);
        }
        if (i3 != J1 && (pBRepeatMessageField = configurationService$Config.msg_content_list) != null && pBRepeatMessageField.size() > 0 && (configurationService$Content = configurationService$Config.msg_content_list.get(0)) != null) {
            if (configurationService$Content.compress.get() == 1) {
                byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                stringUtf8 = null;
                if (d16 != null) {
                    try {
                        str = new String(d16, "UTF-8");
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", e16);
                        }
                    } catch (OutOfMemoryError e17) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", e17);
                        }
                        System.gc();
                        try {
                            str = new String(d16, "UTF-8");
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", th5);
                            }
                        }
                    }
                    stringUtf8 = str;
                }
            } else {
                stringUtf8 = configurationService$Content.content.get().toStringUtf8();
            }
            if (!TextUtils.isEmpty(stringUtf8)) {
                boolean f16 = aa.f(stringUtf8);
                if (f16) {
                    ea.p3(qQAppInterface.getApp(), i3);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopRankConfig", 2, "refreshConfig ret=" + f16);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "handleTroopRankConfigCmd, config_content is empty");
            }
        }
    }

    private void S(ConfigurationService$Config configurationService$Config) {
        int i3 = configurationService$Config.version.get();
        int n06 = ea.n0(AppConstants.Preferences.LOCAL_QR_LOGIN_VERSION);
        QLog.i("SPLASH_ConfigServlet", 1, "handleLocalQRConfig: ,version: " + configurationService$Config.version.get() + "| localVersion: " + n06);
        if (i3 == n06) {
            QLog.e("SPLASH_ConfigServlet", 1, "handleLocalQRConfig version is same of local version");
            return;
        }
        ea.B2(AppConstants.Preferences.LOCAL_QR_LOGIN_VERSION, Integer.valueOf(i3));
        List<String> X0 = X0(configurationService$Config);
        if (X0 != null && !X0.isEmpty()) {
            try {
                String str = X0.get(X0.size() - 1);
                QLog.d("SPLASH_ConfigServlet", 1, "localQrLoginConfig is ", str);
                ea.B2(AppConstants.Preferences.LOCAL_QR_LOGIN_CONFIG, str);
                return;
            } catch (Exception e16) {
                QLog.e("SPLASH_ConfigServlet", 1, "get local qr login config error : ", e16.getMessage());
                return;
            }
        }
        QLog.e("SPLASH_ConfigServlet", 1, "handleLocalQRConfig configStrList is null or empty");
    }

    private void S0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3 = configurationService$Config.version.get();
        int R1 = ea.R1(qQAppInterface.getApp());
        if (QLog.isColorLevel()) {
            QLog.d("VideoDownCTWhiteList", 2, String.format("received VideoDownCTWhiteList remote version: %d, localVersion: %d, cmd: %d", Integer.valueOf(i3), Integer.valueOf(R1), 80));
        }
        if (i3 != R1) {
            PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
            if (pBRepeatField != null && pBRepeatField.size() > 0) {
                String str = configurationService$Config.content_list.get(0);
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 80,content: " + str + ",version: " + configurationService$Config.version.get());
                }
                ea.m5(qQAppInterface.getApp(), i3, str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 80,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        }
    }

    private void T(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        boolean z16;
        boolean z17;
        boolean z18;
        int parseInt;
        try {
            int i3 = configurationService$Config.version.get();
            int u06 = ea.u0(qQAppInterface.getApp(), qQAppInterface.getAccount());
            if (QLog.isColorLevel()) {
                QLog.d("longText", 2, "received LongTextMsgConfig configVersion:" + i3 + " ,localVersion:" + u06);
            }
            PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
            if (pBRepeatField != null && pBRepeatField.size() > 0) {
                boolean z19 = false;
                String str = configurationService$Config.content_list.get(0);
                if (QLog.isColorLevel()) {
                    QLog.d("longText", 2, "received LongTextMsgConfig configContent" + str);
                }
                if (i3 != u06) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            int parseInt2 = Integer.parseInt(jSONObject.optString("largeMsgOp"));
                            if (parseInt2 == 1) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            try {
                                parseInt = Integer.parseInt(jSONObject.optString("msfPullFilter"));
                                if (parseInt != 0) {
                                    z19 = true;
                                }
                            } catch (Exception e16) {
                                e = e16;
                                z16 = true;
                            }
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("longText", 2, "received LongTextMsgConfig, parse content ltValue:" + parseInt2 + ",ltSwitch:" + z18 + ",mpfValue:" + parseInt + ",mpfSwitch:" + z19);
                                }
                                z17 = z19;
                                z19 = z18;
                            } catch (Exception e17) {
                                e = e17;
                                z16 = z19;
                                z19 = z18;
                                if (QLog.isColorLevel()) {
                                    QLog.d("longText", 2, "received LongTextMsgConfig, parse content error!", e);
                                }
                                z17 = z16;
                                f fVar = (f) qQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER);
                                fVar.f251597d = true;
                                fVar.f251598e = z19;
                                qQAppInterface.isMsfPullFilterConfigInited = true;
                                qQAppInterface.msfPullFilterSwitch = z17;
                                ea.n4(qQAppInterface.getApp(), qQAppInterface.getAccount(), i3, z19, z17);
                                return;
                            }
                        } else {
                            z17 = true;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        z16 = true;
                    }
                    f fVar2 = (f) qQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER);
                    fVar2.f251597d = true;
                    fVar2.f251598e = z19;
                    qQAppInterface.isMsfPullFilterConfigInited = true;
                    qQAppInterface.msfPullFilterSwitch = z17;
                    ea.n4(qQAppInterface.getApp(), qQAppInterface.getAccount(), i3, z19, z17);
                    return;
                }
                return;
            }
            if (i3 == u06) {
                if (QLog.isColorLevel()) {
                    QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, ignored because of SAME VERSION");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, use default config");
            }
        } catch (Exception e19) {
            if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServlet", 2, "received LongTextMsgConfig error", e19);
            }
        }
    }

    private void T0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        boolean z16;
        int i3 = configurationService$Config.version.get();
        int W1 = ea.W1(BaseApplication.getContext(), f202907b);
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: ,version: " + configurationService$Config.version.get() + "| localVersion: " + W1);
        }
        if (i3 != W1) {
            ea.n5(BaseApplication.getContext(), f202907b, i3);
            List<String> X0 = X0(configurationService$Config);
            if (X0 != null && X0.size() > 0) {
                for (String str : X0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: config_content =" + str);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        boolean z17 = false;
                        if (jSONObject.has("kMarioConfigEnable")) {
                            int i16 = jSONObject.getInt("kMarioConfigEnable");
                            ZhituManager I = ZhituManager.I(qQAppInterface);
                            if (i16 == 1) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            I.N0(z16);
                        }
                        if (jSONObject.has("kMarioPageLen")) {
                            ZhituManager.I(qQAppInterface).K0(jSONObject.getInt("kMarioPageLen"));
                        }
                        if (jSONObject.has("kMarioSaveAndShareEnable")) {
                            int i17 = jSONObject.getInt("kMarioSaveAndShareEnable");
                            ZhituManager I2 = ZhituManager.I(qQAppInterface);
                            if (i17 == 1) {
                                z17 = true;
                            }
                            I2.S0(z17);
                        }
                        if (jSONObject.has("kMarioSafeGateRequestInterval")) {
                            ZhituManager.I(qQAppInterface).O0(jSONObject.getInt("kMarioSafeGateRequestInterval"));
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig:localVersiont == version ");
        }
    }

    private void U(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        String str;
        String str2;
        int i3;
        String str3;
        String str4 = "";
        if (QLog.isColorLevel()) {
            QLog.d("Medal_SPLASH_ConfigServlet", 2, "handleMedalConfig|type= " + configurationService$Config.type.get());
        }
        int i16 = configurationService$Config.version.get();
        PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
        if (pBRepeatField != null && pBRepeatField.size() > 0) {
            String str5 = configurationService$Config.content_list.get(0);
            if (QLog.isColorLevel()) {
                QLog.d("Medal_SPLASH_ConfigServlet", 2, "content" + str5);
            }
            if (str5 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    str3 = jSONObject.optString("hosturl", "");
                    try {
                        str2 = jSONObject.optString("customurl", "");
                        try {
                            str4 = jSONObject.optString("shareurl", "");
                            i3 = jSONObject.optInt("entrance_visibility", 0);
                        } catch (Exception e16) {
                            e = e16;
                            String str6 = str4;
                            str4 = str3;
                            str = str6;
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.i("SPLASH_ConfigServlet", 2, e.getMessage(), e);
                                }
                                i3 = 0;
                                String str7 = str4;
                                str4 = str;
                                str3 = str7;
                                ((MedalWallMng) qQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).p(i3, str3, str2, str4);
                                ea.p4(qQAppInterface.getApp(), i16, qQAppInterface.getCurrentAccountUin());
                                ea.o4(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), i3);
                            } catch (Exception e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("SPLASH_ConfigServlet", 2, e17, new Object[0]);
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str2 = "";
                        str4 = str3;
                        str = str2;
                    }
                } catch (Exception e19) {
                    e = e19;
                    str = "";
                    str2 = str;
                }
                ((MedalWallMng) qQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).p(i3, str3, str2, str4);
                ea.p4(qQAppInterface.getApp(), i16, qQAppInterface.getCurrentAccountUin());
                ea.o4(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), i3);
            }
        }
    }

    public static byte[] U0(byte[] bArr) {
        InflaterInputStream inflaterInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = inflaterInputStream.read(bArr2);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                inflaterInputStream.close();
            } catch (IOException e16) {
                QLog.d("OlympicUtil", 2, "inflateConfigString, clos stream, ", e16);
            }
            return byteArray;
        } catch (Throwable th6) {
            th = th6;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("OlympicUtil", 2, "inflateConfigString");
                    th.printStackTrace();
                }
                return null;
            } finally {
                if (inflaterInputStream != null) {
                    try {
                        inflaterInputStream.close();
                    } catch (IOException e17) {
                        QLog.d("OlympicUtil", 2, "inflateConfigString, clos stream, ", e17);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void V(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3;
        int i16;
        JSONObject jSONObject;
        int i17 = configurationService$Config.version.get();
        int z06 = ea.z0(qQAppInterface.getApp(), f202907b, 2);
        String str = null;
        if (i17 != z06) {
            if (configurationService$Config.msg_content_list.size() > 0) {
                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                if (configurationService$Content == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig content is null !");
                    }
                    i3 = 1;
                } else if (configurationService$Content.compress.get() == 1) {
                    byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                    if (d16 != null) {
                        try {
                            String str2 = new String(d16, "UTF-8");
                            i3 = 0;
                            str = str2;
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig Throwable:" + th5.getMessage());
                            }
                            i3 = 2;
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig inflateConfigString error!");
                        }
                        i3 = 3;
                    }
                } else {
                    str = configurationService$Content.content.get().toStringUtf8();
                    i3 = 0;
                }
            } else {
                i3 = 4;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    i3 = 5;
                }
                if (jSONObject.has("medal_strong_reminder_off")) {
                    i16 = jSONObject.getInt("medal_strong_reminder_off");
                    if (i3 == 0) {
                        ea.q4(qQAppInterface.getApp(), f202907b, 3, i16);
                        int i18 = QQManagerFactory.MEDAL_WALL_MNG;
                        if (qQAppInterface.isCreateManager(i18)) {
                            ((MedalWallMng) qQAppInterface.getManager(i18)).q(i16);
                        }
                    }
                    ea.q4(qQAppInterface.getApp(), f202907b, 2, i17);
                } else {
                    i3 = 6;
                }
            }
            i16 = 0;
            if (i3 == 0) {
            }
            ea.q4(qQAppInterface.getApp(), f202907b, 2, i17);
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handleMedalStrongReminderConfig localVersion: %s, version: %s, result: %s, value: %s, strContent: %s", Integer.valueOf(z06), Integer.valueOf(i17), Integer.valueOf(i3), Integer.valueOf(i16), str));
        }
    }

    private void W(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        try {
            PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
            if (pBRepeatField != null && pBRepeatField.size() > 0) {
                for (int i3 = 0; i3 < configurationService$Config.content_list.size(); i3++) {
                    String trim = configurationService$Config.content_list.get(i3).trim();
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 201,content: " + trim + ",version: " + configurationService$Config.version.get());
                    }
                    int i16 = configurationService$Config.version.get();
                    if (i16 != ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_CONFIG_VERSION, f202907b) && !TextUtils.isEmpty(trim)) {
                        try {
                            ea.s4(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), new JSONObject(trim));
                        } catch (JSONException unused) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received JSONException ");
                            }
                        }
                        ea.l5(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_CONFIG_VERSION, f202907b, i16);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 201,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received change machine config error,cmd : 201" + e16.toString());
            }
        }
    }

    private void W0(final QQAppInterface qQAppInterface, String str, final int i3) {
        final float f16;
        float parseFloat;
        String str2;
        Document document;
        float f17;
        String str3;
        String str4 = "width";
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("utf-8")));
            NodeList elementsByTagName = parse.getElementsByTagName("splash_birth");
            String str5 = "left";
            final String str6 = "left";
            String str7 = "";
            final String str8 = str7;
            final String str9 = str8;
            int i16 = 0;
            float f18 = 0.0f;
            final float f19 = 0.0f;
            final float f26 = 0.0f;
            final float f27 = 0.0f;
            final boolean z16 = false;
            while (i16 < elementsByTagName.getLength()) {
                str7 = parse.getElementsByTagName("img").item(i16).getFirstChild().getNodeValue();
                String nodeValue = parse.getElementsByTagName("md5").item(i16).getFirstChild().getNodeValue();
                f19 = Float.parseFloat(parse.getElementsByTagName(HippyTKDListViewAdapter.X).item(i16).getFirstChild().getNodeValue());
                try {
                    parseFloat = Float.parseFloat(parse.getElementsByTagName("ay").item(i16).getFirstChild().getNodeValue());
                    z16 = true;
                } catch (Exception unused) {
                    parseFloat = Float.parseFloat(parse.getElementsByTagName("y").item(i16).getFirstChild().getNodeValue());
                }
                boolean z17 = z16;
                float parseFloat2 = Float.parseFloat(parse.getElementsByTagName(str4).item(i16).getFirstChild().getNodeValue());
                float parseFloat3 = Float.parseFloat(parse.getElementsByTagName("height").item(i16).getFirstChild().getNodeValue());
                String nodeValue2 = parse.getElementsByTagName("color").item(i16).getFirstChild().getNodeValue();
                float parseFloat4 = Float.parseFloat(parse.getElementsByTagName("size").item(i16).getFirstChild().getNodeValue());
                NodeList nodeList = elementsByTagName;
                float parseFloat5 = Float.parseFloat(parse.getElementsByTagName(str4).item(i16).getFirstChild().getNodeValue());
                String str10 = str4;
                try {
                    str2 = parse.getElementsByTagName("align").item(i16).getFirstChild().getNodeValue();
                } catch (Exception unused2) {
                    str2 = str5;
                }
                if (QLog.isColorLevel()) {
                    document = parse;
                    f17 = parseFloat5;
                    StringBuilder sb5 = new StringBuilder();
                    str3 = str5;
                    sb5.append("birthday-splash parse result,img == ");
                    sb5.append(str7);
                    sb5.append(" ,md5 = ");
                    sb5.append(nodeValue);
                    sb5.append(" ,x=");
                    sb5.append(f19);
                    sb5.append(" ,y=");
                    sb5.append(parseFloat);
                    sb5.append(" ,useAy=");
                    sb5.append(z17);
                    sb5.append(" ,width=");
                    sb5.append(parseFloat2);
                    sb5.append(" ,height=");
                    sb5.append(parseFloat3);
                    sb5.append(" ,color=");
                    sb5.append(nodeValue2);
                    sb5.append(" ,font_size=");
                    sb5.append(parseFloat4);
                    sb5.append(" ,align=");
                    sb5.append(str2);
                    QLog.i("SPLASH_ConfigServlet", 2, sb5.toString());
                } else {
                    document = parse;
                    f17 = parseFloat5;
                    str3 = str5;
                }
                i16++;
                str6 = str2;
                str8 = nodeValue2;
                str9 = nodeValue;
                z16 = z17;
                f27 = parseFloat4;
                f18 = f17;
                elementsByTagName = nodeList;
                str4 = str10;
                parse = document;
                str5 = str3;
                f26 = parseFloat;
            }
            if (str7 != null && !str7.trim().equals("")) {
                final String str11 = qQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/" + f202907b + "/birthdayflashlogo.png";
                final String insertMtype = MsfSdkUtils.insertMtype("ConfigCheck", str7);
                if (f18 < 0.0f) {
                    f16 = 50.0f;
                } else {
                    f16 = f18;
                }
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.config.splashlogo.ConfigServlet.4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:103:0x0337  */
                    /* JADX WARN: Removed duplicated region for block: B:107:0x0342 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:114:? A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:11:0x0290  */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x029b  */
                    /* JADX WARN: Removed duplicated region for block: B:19:0x02a6 A[Catch: IOException -> 0x02ab, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x02ab, blocks: (B:19:0x02a6, B:94:0x02e3, B:79:0x0324), top: B:4:0x004c }] */
                    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:69:0x02f2 A[Catch: all -> 0x0328, TRY_LEAVE, TryCatch #2 {all -> 0x0328, blocks: (B:82:0x02be, B:84:0x02c4, B:67:0x02ec, B:69:0x02f2), top: B:5:0x004c }] */
                    /* JADX WARN: Removed duplicated region for block: B:71:0x030e  */
                    /* JADX WARN: Removed duplicated region for block: B:75:0x0319  */
                    /* JADX WARN: Removed duplicated region for block: B:79:0x0324 A[Catch: IOException -> 0x02ab, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x02ab, blocks: (B:19:0x02a6, B:94:0x02e3, B:79:0x0324), top: B:4:0x004c }] */
                    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:84:0x02c4 A[Catch: all -> 0x0328, TRY_LEAVE, TryCatch #2 {all -> 0x0328, blocks: (B:82:0x02be, B:84:0x02c4, B:67:0x02ec, B:69:0x02f2), top: B:5:0x004c }] */
                    /* JADX WARN: Removed duplicated region for block: B:86:0x02cd  */
                    /* JADX WARN: Removed duplicated region for block: B:90:0x02d8  */
                    /* JADX WARN: Removed duplicated region for block: B:94:0x02e3 A[Catch: IOException -> 0x02ab, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x02ab, blocks: (B:19:0x02a6, B:94:0x02e3, B:79:0x0324), top: B:4:0x004c }] */
                    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:99:0x032c  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        Throwable th5;
                        Bitmap bitmap;
                        Bitmap bitmap2;
                        Bitmap bitmap3;
                        Bitmap bitmap4;
                        Bitmap bitmap5;
                        BufferedOutputStream bufferedOutputStream;
                        BufferedOutputStream bufferedOutputStream2;
                        BufferedOutputStream bufferedOutputStream3;
                        Bitmap bitmap6;
                        Bitmap decodeFile;
                        float measureText;
                        boolean z18;
                        boolean z19;
                        float f28;
                        BufferedOutputStream bufferedOutputStream4;
                        Bitmap bitmap7;
                        String str12 = str11 + "~tmp";
                        if (HttpDownloadUtil.download(qQAppInterface, insertMtype, new File(str12))) {
                            int x16 = (int) ah.x();
                            int w3 = (int) ah.w();
                            float f29 = x16;
                            float f36 = ConfigServlet.this.f(f19, f29);
                            float f37 = w3;
                            float g16 = ConfigServlet.this.g(f26, f37, f29);
                            float h16 = ConfigServlet.this.h(f16);
                            try {
                                try {
                                    try {
                                        decodeFile = BitmapFactory.decodeFile(str12);
                                    } catch (Exception e16) {
                                        e = e16;
                                        bitmap3 = null;
                                    } catch (OutOfMemoryError unused3) {
                                        bitmap2 = null;
                                    } catch (Throwable th6) {
                                        th5 = th6;
                                        bitmap = null;
                                    }
                                    if (decodeFile != null) {
                                        try {
                                        } catch (Exception e17) {
                                            e = e17;
                                            bitmap3 = decodeFile;
                                            bitmap4 = null;
                                            bufferedOutputStream3 = null;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (bitmap3 != null) {
                                                bitmap3.recycle();
                                            }
                                            if (bitmap4 != null) {
                                                bitmap4.recycle();
                                            }
                                            if (bufferedOutputStream3 != null) {
                                            }
                                        } catch (OutOfMemoryError unused4) {
                                            bitmap2 = decodeFile;
                                            bitmap4 = null;
                                            bufferedOutputStream2 = null;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (bitmap2 != null) {
                                                bitmap2.recycle();
                                            }
                                            if (bitmap4 != null) {
                                                bitmap4.recycle();
                                            }
                                            if (bufferedOutputStream2 != null) {
                                            }
                                        } catch (Throwable th7) {
                                            th5 = th7;
                                            bitmap = decodeFile;
                                            bitmap4 = null;
                                            bitmap5 = bitmap;
                                            bufferedOutputStream = null;
                                            bitmap6 = bitmap5;
                                            if (bitmap6 != 0) {
                                                bitmap6.recycle();
                                            }
                                            if (bitmap4 != null) {
                                                bitmap4.recycle();
                                            }
                                            if (bufferedOutputStream != null) {
                                            }
                                        }
                                        if (!decodeFile.isRecycled()) {
                                            bitmap4 = Bitmap.createBitmap(x16, w3, Bitmap.Config.ARGB_8888);
                                            if (bitmap4 != null) {
                                                try {
                                                } catch (Exception e18) {
                                                    e = e18;
                                                    bitmap3 = decodeFile;
                                                } catch (OutOfMemoryError unused5) {
                                                    bitmap2 = decodeFile;
                                                } catch (Throwable th8) {
                                                    th5 = th8;
                                                    bitmap5 = decodeFile;
                                                }
                                                if (!bitmap4.isRecycled()) {
                                                    Canvas canvas = new Canvas(bitmap4);
                                                    canvas.drawBitmap(decodeFile, new Rect(0, 0, decodeFile.getWidth(), decodeFile.getHeight()), new Rect(0, 0, x16, w3), new Paint());
                                                    decodeFile.recycle();
                                                    try {
                                                        TextPaint textPaint = new TextPaint();
                                                        int i17 = 1;
                                                        textPaint.setAntiAlias(true);
                                                        textPaint.setColor(Color.parseColor(str8));
                                                        if (QLog.isColorLevel()) {
                                                            QLog.i("SPLASH_ConfigServlet", 2, "final_x = " + f36 + "  ,final_y = " + g16 + " ,fontColor = " + str8);
                                                        }
                                                        String str13 = "";
                                                        float f38 = 0.0f;
                                                        if ("left".equalsIgnoreCase(str6)) {
                                                            textPaint.setTextSize(x.c(qQAppInterface.getApplication(), f27));
                                                            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                                                            if (z16) {
                                                                f38 = fontMetrics.ascent;
                                                            }
                                                            float f39 = g16 - f38;
                                                            if (textPaint.measureText(ConfigServlet.f202908c) > h16) {
                                                                loop0: while (true) {
                                                                    int i18 = i17;
                                                                    while (i17 != 0) {
                                                                        str13 = ConfigServlet.f202908c.substring(0, ConfigServlet.f202908c.length() - i18) + "..";
                                                                        if (textPaint.measureText(str13) > h16) {
                                                                            i18++;
                                                                        }
                                                                    }
                                                                    i17 = 0;
                                                                }
                                                                canvas.drawText(str13, f36, f39, textPaint);
                                                            } else {
                                                                canvas.drawText(ConfigServlet.f202908c, f36, f39, textPaint);
                                                            }
                                                        } else if ("middle".equalsIgnoreCase(str6)) {
                                                            float f46 = f27;
                                                            if (f46 < 12.0f) {
                                                                f46 = 12.0f;
                                                            }
                                                            while (true) {
                                                                textPaint.setTextSize(x.c(qQAppInterface.getApplication(), f46));
                                                                measureText = textPaint.measureText(ConfigServlet.f202908c);
                                                                if (measureText <= h16) {
                                                                    z18 = true;
                                                                    break;
                                                                }
                                                                float f47 = f46 - 12.0f;
                                                                if (f47 > 1.0f) {
                                                                    f46 -= 1.0f;
                                                                } else if (f47 > 0.0f) {
                                                                    f46 = 12.0f;
                                                                } else {
                                                                    z18 = false;
                                                                    break;
                                                                }
                                                            }
                                                            if (z18) {
                                                                Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
                                                                if (z16) {
                                                                    f38 = fontMetrics2.ascent;
                                                                }
                                                                canvas.drawText(ConfigServlet.f202908c, f36 - (measureText / 2.0f), g16 - f38, textPaint);
                                                            } else {
                                                                int length = ConfigServlet.f202908c.length();
                                                                int i19 = 1;
                                                                while (true) {
                                                                    if (i19 <= length) {
                                                                        StringBuilder sb6 = new StringBuilder();
                                                                        boolean z26 = z18;
                                                                        sb6.append(ConfigServlet.f202908c.substring(0, ConfigServlet.f202908c.length() - i19));
                                                                        sb6.append("..");
                                                                        str13 = sb6.toString();
                                                                        measureText = textPaint.measureText(str13);
                                                                        if (measureText > h16) {
                                                                            i19++;
                                                                            z18 = z26;
                                                                        } else {
                                                                            z19 = true;
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        z19 = z18;
                                                                        break;
                                                                    }
                                                                }
                                                                if (z19) {
                                                                    Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
                                                                    if (z16) {
                                                                        f28 = fontMetrics3.ascent;
                                                                    } else {
                                                                        f28 = 0.0f;
                                                                    }
                                                                    canvas.drawText(str13, f36 - (measureText / 2.0f), g16 - f28, textPaint);
                                                                } else {
                                                                    QLog.e("SPLASH_ConfigServlet", 1, "Error Font Size");
                                                                }
                                                            }
                                                        } else {
                                                            QLog.e("SPLASH_ConfigServlet", 1, "Error align:" + str6);
                                                        }
                                                        canvas.save();
                                                        canvas.restore();
                                                        File file = new File(str11);
                                                        File file2 = new File(str12);
                                                        BufferedOutputStream bufferedOutputStream5 = new BufferedOutputStream(new FileOutputStream(file2));
                                                        try {
                                                            bitmap4.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream5);
                                                            bufferedOutputStream5.flush();
                                                            if (file.exists()) {
                                                                file.delete();
                                                            }
                                                            file2.renameTo(file);
                                                            ea.z3(qQAppInterface.getApplication(), i3, str9, ConfigServlet.f202907b);
                                                            bufferedOutputStream4 = bufferedOutputStream5;
                                                            bitmap7 = null;
                                                            if (bitmap7 != null && !bitmap7.isRecycled()) {
                                                                bitmap7.recycle();
                                                            }
                                                            if (bitmap4 != null && !bitmap4.isRecycled()) {
                                                                bitmap4.recycle();
                                                            }
                                                        } catch (Exception e19) {
                                                            e = e19;
                                                            bufferedOutputStream3 = bufferedOutputStream5;
                                                            bitmap3 = null;
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            if (bitmap3 != null) {
                                                            }
                                                            if (bitmap4 != null) {
                                                            }
                                                            if (bufferedOutputStream3 != null) {
                                                            }
                                                        } catch (OutOfMemoryError unused6) {
                                                            bufferedOutputStream2 = bufferedOutputStream5;
                                                            bitmap2 = null;
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            if (bitmap2 != null) {
                                                            }
                                                            if (bitmap4 != null) {
                                                            }
                                                            if (bufferedOutputStream2 != null) {
                                                            }
                                                        } catch (Throwable th9) {
                                                            th5 = th9;
                                                            bufferedOutputStream = bufferedOutputStream5;
                                                            bitmap6 = 0;
                                                            if (bitmap6 != 0) {
                                                            }
                                                            if (bitmap4 != null) {
                                                            }
                                                            if (bufferedOutputStream != null) {
                                                            }
                                                        }
                                                    } catch (Exception e26) {
                                                        e = e26;
                                                        bitmap3 = null;
                                                        bufferedOutputStream3 = null;
                                                        if (QLog.isColorLevel()) {
                                                            QLog.i("SPLASH_ConfigServlet", 2, "decode birthday-splash bitmap exception:" + e.getMessage());
                                                        }
                                                        if (bitmap3 != null && !bitmap3.isRecycled()) {
                                                            bitmap3.recycle();
                                                        }
                                                        if (bitmap4 != null && !bitmap4.isRecycled()) {
                                                            bitmap4.recycle();
                                                        }
                                                        if (bufferedOutputStream3 != null) {
                                                            bufferedOutputStream3.close();
                                                            return;
                                                        }
                                                        return;
                                                    } catch (OutOfMemoryError unused7) {
                                                        bitmap2 = null;
                                                        bufferedOutputStream2 = null;
                                                        if (QLog.isColorLevel()) {
                                                            QLog.i("SPLASH_ConfigServlet", 2, "decode birthday-splash bitmap OOM Error Catched");
                                                        }
                                                        if (bitmap2 != null && !bitmap2.isRecycled()) {
                                                            bitmap2.recycle();
                                                        }
                                                        if (bitmap4 != null && !bitmap4.isRecycled()) {
                                                            bitmap4.recycle();
                                                        }
                                                        if (bufferedOutputStream2 != null) {
                                                            bufferedOutputStream2.close();
                                                            return;
                                                        }
                                                        return;
                                                    } catch (Throwable th10) {
                                                        th5 = th10;
                                                        bitmap5 = null;
                                                        bufferedOutputStream = null;
                                                        bitmap6 = bitmap5;
                                                        if (bitmap6 != 0 && !bitmap6.isRecycled()) {
                                                            bitmap6.recycle();
                                                        }
                                                        if (bitmap4 != null && !bitmap4.isRecycled()) {
                                                            bitmap4.recycle();
                                                        }
                                                        if (bufferedOutputStream != null) {
                                                            try {
                                                                bufferedOutputStream.close();
                                                                throw th5;
                                                            } catch (IOException e27) {
                                                                e27.printStackTrace();
                                                                throw th5;
                                                            }
                                                        }
                                                        throw th5;
                                                    }
                                                    if (bufferedOutputStream4 != null) {
                                                        bufferedOutputStream4.close();
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                            bitmap7 = decodeFile;
                                            bufferedOutputStream4 = null;
                                            if (bitmap7 != null) {
                                                bitmap7.recycle();
                                            }
                                            if (bitmap4 != null) {
                                                bitmap4.recycle();
                                            }
                                            if (bufferedOutputStream4 != null) {
                                            }
                                        }
                                    }
                                    bitmap7 = decodeFile;
                                    bitmap4 = null;
                                    bufferedOutputStream4 = null;
                                    if (bitmap7 != null) {
                                    }
                                    if (bitmap4 != null) {
                                    }
                                    if (bufferedOutputStream4 != null) {
                                    }
                                } catch (Throwable th11) {
                                    th5 = th11;
                                    bitmap6 = f37;
                                }
                            } catch (IOException e28) {
                                e28.printStackTrace();
                            }
                        }
                    }
                }, 2, null, false);
            }
        } catch (Exception unused3) {
        }
    }

    private void X(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3 = 2;
        try {
            SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences("NearbyActivity.nearByTabUrl", 4).edit();
            PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
            if (pBRepeatField != null && pBRepeatField.size() > 0) {
                int i16 = 0;
                while (i16 < configurationService$Config.content_list.size()) {
                    String trim = configurationService$Config.content_list.get(i16).trim();
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", i3, "receiveAllConfigs|type: 129,content: " + trim + ",version: " + configurationService$Config.version.get());
                    }
                    int i17 = configurationService$Config.version.get();
                    if (i17 != ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_NOWLIVE_TAB_CONFIG_VERSION, f202907b) && !TextUtils.isEmpty(trim)) {
                        try {
                            JSONObject jSONObject = new JSONObject(trim);
                            String string = jSONObject.getJSONObject("android").getString("url");
                            String string2 = jSONObject.getJSONObject("android").getString("menuCell_startLive");
                            String string3 = jSONObject.getJSONObject("android").getString("menuCell_personalCenter");
                            String string4 = jSONObject.getJSONObject("android").getString("menuCell_help");
                            edit.putString("nearByTabUrl", string);
                            edit.putString("menuCell_startLive", string2);
                            edit.putString("menuCell_personalCenter", string3);
                            edit.putString("menuCell_help", string4);
                            edit.apply();
                            if (QLog.isColorLevel()) {
                                QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received NearbyActivity.nearByTabUrl " + jSONObject.getJSONObject("android"));
                            }
                        } catch (JSONException unused) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received JSONException in get NearbyActivity.nearByTabUrl");
                            }
                        }
                        ea.l5(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_NOWLIVE_TAB_CONFIG_VERSION, f202907b, i17);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
                    }
                    i16++;
                    i3 = 2;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 129,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received change machine config error,cmd : 129" + e16.toString());
            }
        }
    }

    public static List<String> X0(ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig: list.size() " + configurationService$Config.msg_content_list.size());
            }
            for (ConfigurationService$Content configurationService$Content : configurationService$Config.msg_content_list.get()) {
                if (configurationService$Content != null && configurationService$Content.content.has()) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] U0 = U0(configurationService$Content.content.get().toByteArray());
                        if (U0 != null) {
                            try {
                                stringUtf8 = new String(U0, "UTF-8");
                            } catch (Exception e16) {
                                QLog.e("SPLASH_ConfigServlet", 1, "parseCommonConfig|uncompress failed" + e16);
                            }
                        }
                        stringUtf8 = null;
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig: contentitem.content =  " + stringUtf8);
                    }
                    if (!TextUtils.isEmpty(stringUtf8)) {
                        arrayList.add(stringUtf8);
                    }
                } else {
                    QLog.i("SPLASH_ConfigServlet", 1, "empty contentitem");
                }
            }
            return arrayList;
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig:msg_content_list is empty ,version: " + configurationService$Config.version.get());
        return null;
    }

    public static String Y0(int i3, int i16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append('-');
        sb5.append(i16);
        return sb5.toString();
    }

    private void Z(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3;
        try {
            int i16 = configurationService$Config.version.get();
            int P1 = ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_VIDEOCHAT_BANNER_CONFIG_VERSION, f202907b);
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null) {
                i3 = pBRepeatMessageField.size();
            } else {
                i3 = -1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatBannerConfig, serverVersion[%s], localVersion[%s], size[%s]", Integer.valueOf(i16), Integer.valueOf(P1), Integer.valueOf(i3)));
            }
            if (i16 == P1) {
                return;
            }
            if (i3 > 0) {
                String F = F(configurationService$Config, P1, 269);
                if (!TextUtils.isEmpty(F)) {
                    ((com.tencent.mobileqq.troop.utils.i) qQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)).d(F);
                    ea.l5(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_VIDEOCHAT_BANNER_CONFIG_VERSION, f202907b, i16);
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatBannerConfig, content: \n" + F);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatBannerConfig null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 269,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatBannerConfig error,cmd : 269", e16);
            }
        }
    }

    public static boolean Z0(PicAndAdConf picAndAdConf, String str, Set<String> set) {
        boolean z16;
        NodeList nodeList;
        String str2;
        Set<String> set2 = set;
        String str3 = "/";
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("utf-8")));
            NodeList elementsByTagName = parse.getElementsByTagName("pushbanner");
            String str4 = "";
            int i3 = 0;
            while (i3 < elementsByTagName.getLength()) {
                long parseLong = Long.parseLong(parse.getElementsByTagName(WadlProxyConsts.CHANNEL).item(i3).getFirstChild().getNodeValue());
                String nodeValue = parse.getElementsByTagName("img").item(i3).getFirstChild().getNodeValue();
                String nodeValue2 = parse.getElementsByTagName(PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME).item(i3).getFirstChild().getNodeValue();
                int parseInt = Integer.parseInt(parse.getElementsByTagName("weight").item(i3).getFirstChild().getNodeValue());
                Node firstChild = parse.getElementsByTagName("md5").item(i3).getFirstChild();
                if (firstChild != null) {
                    str4 = firstChild.getNodeValue();
                }
                String nodeValue3 = parse.getElementsByTagName("end").item(i3).getFirstChild().getNodeValue();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str5 = str3;
                long time = simpleDateFormat.parse(nodeValue3).getTime();
                long time2 = simpleDateFormat.parse(parse.getElementsByTagName("begin").item(i3).getFirstChild().getNodeValue()).getTime();
                if (System.currentTimeMillis() > time) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner out of date, cid = " + parseLong + ", endTime = " + nodeValue3);
                    }
                    nodeList = elementsByTagName;
                } else {
                    nodeList = elementsByTagName;
                    if (str4.length() < 15) {
                        if (QLog.isColorLevel()) {
                            QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner md5 length < 15, cid = " + parseLong);
                        }
                    } else {
                        if (set2 != null) {
                            if (set2.contains(parseLong + str4)) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner " + parseLong + " had been closed, throw it");
                                }
                            }
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i16 = 0; i16 < parse.getElementsByTagName("url").item(i3).getChildNodes().getLength(); i16++) {
                            stringBuffer.append(parse.getElementsByTagName("url").item(i3).getChildNodes().item(i16).getNodeValue());
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
                        str2 = str5;
                        sb5.append(str2);
                        sb5.append("NearbyBannerPic");
                        sb5.append(str2);
                        sb5.append(str4);
                        picAndAdConf.a(picAndAdConf.u(parseLong, nodeValue2, (byte) 3, nodeValue, stringBuffer2, sb5.toString(), time2 + "|" + time, (short) parseInt, str4));
                        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_HAS_NEW_BANNER, Boolean.TRUE);
                        i3++;
                        set2 = set;
                        str3 = str2;
                        elementsByTagName = nodeList;
                    }
                }
                str2 = str5;
                i3++;
                set2 = set;
                str3 = str2;
                elementsByTagName = nodeList;
            }
            z16 = true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", e16);
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "parseNearbyBannerXml,result = " + z16 + ",bannerContent =" + str);
        }
        return z16;
    }

    private void a0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3;
        try {
            int i16 = configurationService$Config.version.get();
            int P1 = ea.P1(qQAppInterface.getApp(), "change_machine_version", f202907b);
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null) {
                i3 = pBRepeatMessageField.size();
            } else {
                i3 = -1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatConfig, serverVersion[%s], localVersion[%s], size[%s]", Integer.valueOf(i16), Integer.valueOf(P1), Integer.valueOf(i3)));
            }
            if (i16 == P1) {
                return;
            }
            com.tencent.mobileqq.troop.utils.i iVar = (com.tencent.mobileqq.troop.utils.i) qQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
            if (i3 > 0) {
                String F = F(configurationService$Config, P1, 195);
                iVar.h(F);
                if (!TextUtils.isEmpty(F)) {
                    ea.l5(qQAppInterface.getApp(), "change_machine_version", f202907b, i16);
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatConfig, content: \n" + F);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatConfig null");
                    return;
                }
                return;
            }
            iVar.h("");
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 195,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatConfig error,cmd : 195", e16);
            }
        }
    }

    private void a1(QQAppInterface qQAppInterface, String str, int i3) {
        NodeList nodeList;
        String str2;
        Document document;
        String str3;
        int i16;
        boolean z16;
        Document document2;
        int i17;
        String str4;
        EntityManager entityManager;
        boolean z17;
        EntityManager entityManager2;
        String str5 = "url";
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("utf-8")));
            NodeList elementsByTagName = parse.getElementsByTagName("pushbanner");
            String str6 = "";
            int i18 = 0;
            while (i18 < elementsByTagName.getLength()) {
                long parseLong = Long.parseLong(parse.getElementsByTagName(WadlProxyConsts.CHANNEL).item(i18).getFirstChild().getNodeValue());
                final String nodeValue = parse.getElementsByTagName("img").item(i18).getFirstChild().getNodeValue();
                String nodeValue2 = parse.getElementsByTagName(PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME).item(i18).getFirstChild().getNodeValue();
                int parseInt = Integer.parseInt(parse.getElementsByTagName("weight").item(i18).getFirstChild().getNodeValue());
                Node firstChild = parse.getElementsByTagName("md5").item(i18).getFirstChild();
                if (firstChild != null) {
                    str6 = firstChild.getNodeValue();
                }
                String str7 = str6;
                String nodeValue3 = parse.getElementsByTagName("end").item(i18).getFirstChild().getNodeValue();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long time = simpleDateFormat.parse(nodeValue3).getTime();
                int i19 = i18;
                Document document3 = parse;
                long time2 = simpleDateFormat.parse(parse.getElementsByTagName("begin").item(i19).getFirstChild().getNodeValue()).getTime();
                if (System.currentTimeMillis() > time) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner is outdate , throw it");
                    }
                    nodeList = elementsByTagName;
                    i17 = i19;
                    document2 = document3;
                    str3 = str5;
                    str4 = str7;
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    int i26 = 0;
                    while (true) {
                        nodeList = elementsByTagName;
                        str2 = nodeValue2;
                        document = document3;
                        if (i26 >= document.getElementsByTagName(str5).item(i19).getChildNodes().getLength()) {
                            break;
                        }
                        stringBuffer.append(document.getElementsByTagName(str5).item(i19).getChildNodes().item(i26).getNodeValue());
                        i26++;
                        document3 = document;
                        nodeValue2 = str2;
                        elementsByTagName = nodeList;
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                    List<? extends Entity> query = createEntityManager.query(ExpiredPushBanner.class);
                    str3 = str5;
                    if (query != null) {
                        Iterator<? extends Entity> it = query.iterator();
                        z16 = false;
                        while (it.hasNext()) {
                            Iterator<? extends Entity> it5 = it;
                            int i27 = i19;
                            if (((ExpiredPushBanner) it.next()).cid == parseLong) {
                                z16 = true;
                            }
                            i19 = i27;
                            it = it5;
                        }
                        i16 = i19;
                    } else {
                        i16 = i19;
                        z16 = false;
                    }
                    if (z16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner had been close or click , throw it");
                        }
                    } else if (str7.length() < 15) {
                        if (QLog.isColorLevel()) {
                            QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner md5 length < 15 .throw");
                        }
                    } else {
                        String str8 = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + str7;
                        if (!h.e(str7)) {
                            try {
                                ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.config.splashlogo.ConfigServlet.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.tencent.mobileqq.config.e.f202867e.C(nodeValue);
                                    }
                                });
                            } catch (Exception e16) {
                                e = e16;
                                e.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    QLog.i("SPLASH_ConfigServlet", 2, "push exception : " + e.getMessage());
                                    return;
                                }
                                return;
                            }
                        }
                        PicAndAdConf picAndAdConf = com.tencent.mobileqq.config.e.f202867e;
                        document2 = document;
                        EntityManager entityManager3 = createEntityManager;
                        i17 = i16;
                        picAndAdConf.a(picAndAdConf.u(parseLong, str2, (byte) 3, nodeValue, stringBuffer2, str8, time2 + "|" + time, (short) parseInt, str7));
                        try {
                            List<? extends Entity> query2 = entityManager3.query(ReportedBanner.class, false, null, null, null, null, "endtime DESC", null);
                            if (query2 != null && query2.size() > 0) {
                                Iterator<? extends Entity> it6 = query2.iterator();
                                while (true) {
                                    if (it6.hasNext()) {
                                        ReportedBanner reportedBanner = (ReportedBanner) it6.next();
                                        if (reportedBanner != null && reportedBanner.cid == parseLong) {
                                            z17 = false;
                                            break;
                                        }
                                    } else {
                                        z17 = true;
                                        break;
                                    }
                                }
                                if (query2.size() > 18) {
                                    int size = query2.size() - 1;
                                    while (size >= 9) {
                                        ReportedBanner reportedBanner2 = (ReportedBanner) query2.get(size);
                                        if (reportedBanner2 != null && reportedBanner2.cid != parseLong) {
                                            entityManager2 = entityManager3;
                                            entityManager2.remove(reportedBanner2);
                                        } else {
                                            entityManager2 = entityManager3;
                                        }
                                        size--;
                                        entityManager3 = entityManager2;
                                    }
                                }
                                entityManager = entityManager3;
                            } else {
                                entityManager = entityManager3;
                                z17 = true;
                            }
                            if (z17) {
                                ReportController.o(qQAppInterface, "dc00898", "", "", "0X80087C0", "0X80087C0", (int) parseLong, 0, "", "", "", "");
                                ReportedBanner reportedBanner3 = new ReportedBanner();
                                reportedBanner3.cid = parseLong;
                                str4 = str7;
                                try {
                                    reportedBanner3.md5 = str4;
                                    reportedBanner3.endtime = time;
                                    entityManager.persist(reportedBanner3);
                                    if (QLog.isColorLevel()) {
                                        QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report cid: %d", Long.valueOf(parseLong)));
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (QLog.isColorLevel()) {
                                        QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report exception t: %s", th));
                                        i18 = i17 + 1;
                                        str6 = str4;
                                        str5 = str3;
                                        elementsByTagName = nodeList;
                                        parse = document2;
                                    }
                                    i18 = i17 + 1;
                                    str6 = str4;
                                    str5 = str3;
                                    elementsByTagName = nodeList;
                                    parse = document2;
                                }
                            } else {
                                str4 = str7;
                                if (QLog.isColorLevel()) {
                                    QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report repeat cid: %d", Long.valueOf(parseLong)));
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            str4 = str7;
                        }
                    }
                    document2 = document;
                    str4 = str7;
                    i17 = i16;
                }
                i18 = i17 + 1;
                str6 = str4;
                str5 = str3;
                elementsByTagName = nodeList;
                parse = document2;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void b0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3;
        try {
            int i16 = configurationService$Config.version.get();
            int P1 = ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_VIDEOCHAT_DIALOG_CONFIG_VERSION, f202907b);
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null) {
                i3 = pBRepeatMessageField.size();
            } else {
                i3 = -1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatDialogConfig, serverVersion[%s], localVersion[%s], size[%s]", Integer.valueOf(i16), Integer.valueOf(P1), Integer.valueOf(i3)));
            }
            if (i16 == P1) {
                return;
            }
            if (i3 > 0) {
                String F = F(configurationService$Config, P1, 268);
                if (!TextUtils.isEmpty(F)) {
                    ((com.tencent.mobileqq.troop.utils.i) qQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)).f(F);
                    ea.l5(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_VIDEOCHAT_DIALOG_CONFIG_VERSION, f202907b, i16);
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatDialogConfig, content: \n" + F);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatDialogConfig null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 268,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatDialogConfig error,cmd : 268", e16);
            }
        }
    }

    private void b1(QQAppInterface qQAppInterface, String str, int i3) {
        try {
            String i16 = i(new ByteArrayInputStream(str.getBytes("utf-8")));
            if (i16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "qav_anychat_time_limit stream = " + i16);
                }
                ea.S0(qQAppInterface.getCurrentAccountUin()).edit().putString(AppConstants.Preferences.QAV_ANYCHAT_TIME_VALUE, i16).commit();
                ea.D4(qQAppInterface.getApplication(), i3, f202907b);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "parse qav_anychat_time_limit  exception : " + e16.getMessage());
            }
        }
    }

    private void c0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        int i3 = qQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
        int i16 = configurationService$Config.version.get();
        QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend, localVersion:" + i3 + ",serverVersion:" + i16);
        if (i3 != i16) {
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                if (configurationService$Content != null) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                        stringUtf8 = null;
                        if (d16 != null) {
                            try {
                                stringUtf8 = new String(d16, "UTF-8");
                            } catch (Exception e16) {
                                QLog.e(LogTag.TAG_LEBA_NEW, 1, "handleNewTroopRecommend uncompress failed" + e16);
                            }
                        }
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    if (TextUtils.isEmpty(stringUtf8)) {
                        QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend config_content is empty!");
                        return;
                    }
                    return;
                }
                QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend content is empty!");
                return;
            }
            QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend msg_content_list is empty!");
        }
    }

    private void c1(QQAppInterface qQAppInterface, String str, int i3) {
        try {
            String i16 = i(new ByteArrayInputStream(str.getBytes("utf-8")));
            if (i16 != null) {
                String str2 = i16.substring(i16.indexOf("<?xml"), i16.indexOf("</msg><msg")) + "</msg>";
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "qav_upgrade_invite msg1 = " + str2);
                }
                String str3 = (i16.substring(i16.indexOf("<?xml"), i16.indexOf("?>")) + "?>") + i16.substring(i16.indexOf("</msg><msg"), i16.lastIndexOf("</msg>")).substring(6) + "</msg>";
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "qav_upgrade_invite msg2 = " + str3);
                }
                SharedPreferences X0 = ea.X0(qQAppInterface.getCurrentAccountUin());
                X0.edit().putString(AppConstants.Preferences.QAV_UPGRADE_INVITE_VIDEO, str2).commit();
                X0.edit().putString(AppConstants.Preferences.QAV_UPGRADE_INVITE_MULTI, str3).commit();
                ea.E4(qQAppInterface.getApplication(), i3, f202907b);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "parse qav_upgrade_invite xml  exception : " + e16.getMessage());
            }
        }
    }

    private void d0(QQAppInterface qQAppInterface, Intent intent, ConfigurationService$Config configurationService$Config) {
        int i3;
        int i16 = configurationService$Config.version.get();
        int F0 = ea.F0(qQAppInterface.getApp(), f202907b);
        if (i16 == F0) {
            return;
        }
        ea.a3(qQAppInterface.getApp(), i16, f202907b);
        try {
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null) {
                i3 = pBRepeatMessageField.size();
            } else {
                i3 = -1;
            }
            com.tencent.mobileqq.intervideo.now.b bVar = (com.tencent.mobileqq.intervideo.now.b) qQAppInterface.getManager(QQManagerFactory.NOW_DOWNLOAD_ENGINE_MANAGER);
            if (i3 > 0) {
                String F = F(configurationService$Config, F0, 286);
                bVar.a(F);
                if (!TextUtils.isEmpty(F)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNowDownloadEngineConfigCmd, content: \n" + F);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNowDownloadEngineConfigCmd null");
                    return;
                }
                return;
            }
            bVar.a("");
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 286,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        } catch (Exception e16) {
            QLog.e("SPLASH_ConfigServlet", 2, "Exception e = " + e16.toString());
        }
    }

    private void d1(final QQAppInterface qQAppInterface, String str, int i3) {
        try {
            final String str2 = qQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/splashpic/";
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("utf-8")));
            NodeList elementsByTagName = parse.getElementsByTagName("splash");
            final String str3 = "";
            final String str4 = str3;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            for (int i16 = 0; i16 < elementsByTagName.getLength(); i16++) {
                str5 = parse.getElementsByTagName("img").item(i16).getFirstChild().getNodeValue();
                str6 = parse.getElementsByTagName("begin").item(i16).getFirstChild().getNodeValue();
                str7 = parse.getElementsByTagName("end").item(i16).getFirstChild().getNodeValue();
                str3 = parse.getElementsByTagName("md5").item(i16).getFirstChild().getNodeValue();
                str4 = parse.getElementsByTagName(WadlProxyConsts.CHANNEL).item(i16).getFirstChild().getNodeValue();
                String nodeValue = parse.getElementsByTagName("title").item(i16).getFirstChild().getNodeValue();
                if (QLog.isColorLevel()) {
                    QLog.i("SPLASH_ConfigServlet", 2, "parse result,img == " + str5 + " ,begin = " + str6 + " ,end=" + str7 + ",md5=" + str3 + " title = " + nodeValue);
                }
            }
            if (str5 != null && !str5.trim().equals("")) {
                final String insertMtype = MsfSdkUtils.insertMtype("ConfigCheck", str5);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final String str8 = simpleDateFormat.parse(str6).getTime() + "|" + simpleDateFormat.parse(str7).getTime();
                ea.X4(qQAppInterface.getApplication(), i3, str8, str3);
                new File(qQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/splashpic");
                if (simpleDateFormat.parse(str7).getTime() < System.currentTimeMillis()) {
                    File file = new File(str2 + str3);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "this splash is outdate, throw it");
                        return;
                    }
                    return;
                }
                final File file2 = new File(str2 + str3);
                final File file3 = new File(str2 + str8 + "_" + str3 + "_" + str4);
                if (!file3.exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "begin a thread try to download");
                    }
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.config.splashlogo.ConfigServlet.5
                        /* JADX WARN: Removed duplicated region for block: B:11:0x005b A[ADDED_TO_REGION] */
                        /* JADX WARN: Removed duplicated region for block: B:15:0x00a4  */
                        /* JADX WARN: Removed duplicated region for block: B:57:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:68:0x005d A[EDGE_INSN: B:68:0x005d->B:13:0x005d BREAK  A[LOOP:0: B:4:0x000e->B:67:?], SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            boolean download;
                            boolean z16;
                            Throwable th5;
                            boolean z17 = false;
                            if (!file2.exists()) {
                                int i17 = 0;
                                do {
                                    download = HttpDownloadUtil.download(qQAppInterface, insertMtype, file2);
                                    if (download) {
                                        if (file2.exists()) {
                                            try {
                                                if (!MD5.getFileMD5(file2).equalsIgnoreCase(str3)) {
                                                    try {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("SPLASH_ConfigServlet", 2, "down load success but check md5 failed");
                                                        }
                                                    } catch (Throwable th6) {
                                                        th5 = th6;
                                                        z16 = false;
                                                        th5.printStackTrace();
                                                        download = z16;
                                                        i17++;
                                                        if (!download) {
                                                        }
                                                        z17 = download;
                                                        if (!z17) {
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th7) {
                                                z16 = download;
                                                th5 = th7;
                                            }
                                        }
                                        download = false;
                                    } else if (QLog.isColorLevel()) {
                                        QLog.d("SPLASH_ConfigServlet", 2, "down load pic failed try again");
                                    }
                                    i17++;
                                    if (!download) {
                                        break;
                                    }
                                } while (i17 < 2);
                                z17 = download;
                            } else {
                                try {
                                    z17 = MD5.getFileMD5(file2).equalsIgnoreCase(str3);
                                } catch (Exception e16) {
                                    if (file2.exists()) {
                                        file2.delete();
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.i("SPLASH_ConfigServlet", 2, "splash has a file don't need download but check md5 get a exception");
                                    }
                                    e16.printStackTrace();
                                }
                            }
                            if (!z17) {
                                try {
                                    file3.createNewFile();
                                    if (QLog.isColorLevel()) {
                                        QLog.i("SPLASH_ConfigServlet", 2, "create a not outdate splash config");
                                        return;
                                    }
                                    return;
                                } catch (Exception e17) {
                                    e17.printStackTrace();
                                    return;
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "a splash download or check md5 failed ,save url");
                            }
                            File file4 = new File(str2 + str8 + "." + str3 + "." + str4);
                            FileOutputStream fileOutputStream = null;
                            try {
                                try {
                                    try {
                                        if (file2.exists()) {
                                            file2.delete();
                                        }
                                        file4.createNewFile();
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file4);
                                        try {
                                            fileOutputStream2.write(insertMtype.getBytes("UTF-8"));
                                            fileOutputStream2.flush();
                                            fileOutputStream2.close();
                                        } catch (Exception e18) {
                                            e = e18;
                                            fileOutputStream = fileOutputStream2;
                                            e.printStackTrace();
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SPLASH_ConfigServlet", 2, "create save url file failed");
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            fileOutputStream = fileOutputStream2;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e19) {
                                                    e19.printStackTrace();
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                    }
                                } catch (Exception e26) {
                                    e = e26;
                                }
                            } catch (IOException e27) {
                                e27.printStackTrace();
                            }
                        }
                    }, 5, null, true);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x002f. Please report as an issue. */
    private void e(QQAppInterface qQAppInterface, Intent intent, ConfigurationService$ReqGetConfig configurationService$ReqGetConfig, int[] iArr, List<ConfigurationService$ConfigSeq> list, List<Integer> list2) {
        boolean z16;
        int i3;
        int i16;
        String str;
        List<ConfigurationService$ConfigSeq> list3;
        int[] iArr2 = iArr;
        ConfigurationService$ReqGetConfig configurationService$ReqGetConfig2 = configurationService$ReqGetConfig;
        int i17 = 0;
        for (int length = iArr2.length; i17 < length; length = i3) {
            ConfigurationService$ConfigSeq configurationService$ConfigSeq = new ConfigurationService$ConfigSeq();
            int i18 = iArr2[i17];
            configurationService$ConfigSeq.type.set(i18);
            switch (i18) {
                case 1:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.B1(qQAppInterface.getApp()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 2:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.N0(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 3:
                    i3 = length;
                    i16 = i17;
                    ea.U2(qQAppInterface.getApplication(), qQAppInterface.getCurrentAccountUin());
                    if (qQAppInterface.getCurrentAccountUin() != null) {
                        f202908c = qQAppInterface.getCurrentNickname();
                        Card I = ProfileCardUtil.I(qQAppInterface, qQAppInterface.getCurrentAccountUin());
                        if (I != null) {
                            if (QLog.isColorLevel()) {
                                QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
                            }
                            int i19 = (int) I.lBirthday;
                            int b16 = com.tencent.mobileqq.service.profile.c.b(i19);
                            int a16 = com.tencent.mobileqq.service.profile.c.a(i19);
                            ea.k5(qQAppInterface.getApp(), Y0(b16, a16));
                            int j3 = j(new SimpleDateFormat("MM-dd").format(new Date()), Y0(b16, a16));
                            if (QLog.isColorLevel()) {
                                QLog.i("SPLASH_ConfigServlet_birth", 2, "birthday date diff is " + j3);
                            }
                            if (j3 >= 0 && j3 <= 3) {
                                configurationService$ConfigSeq.version.set(ea.s(qQAppInterface.getApp(), f202907b));
                                list3 = list;
                                list3.add(configurationService$ConfigSeq);
                                list2.add(Integer.valueOf(i18));
                                break;
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.i("SPLASH_ConfigServlet_birth", 2, "card===null");
                        }
                    }
                    break;
                case 6:
                    i3 = length;
                    i16 = i17;
                    configurationService$ReqGetConfig2 = ((IDPCApi) QRoute.api(IDPCApi.class)).buidldReqConfig(qQAppInterface);
                    break;
                case 10:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.Y(qQAppInterface.getApp()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 12:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(((com.tencent.mobileqq.config.struct.c) qQAppInterface.getManager(QQManagerFactory.NEARBY_BANNER_MANAGER)).c());
                    String stringExtra = intent.getStringExtra("key_province");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    String stringExtra2 = intent.getStringExtra("key_city");
                    str = stringExtra2 != null ? stringExtra2 : "";
                    configurationService$ReqGetConfig2.province.set(stringExtra);
                    configurationService$ReqGetConfig2.city.set(str);
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 13:
                    i3 = length;
                    i16 = i17;
                    BridgeHelper.b(BaseApplication.getContext(), f202907b).e();
                    configurationService$ConfigSeq.version.set(ea.W(qQAppInterface.getApp(), qQAppInterface.getAccount()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 23:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.C0(qQAppInterface.getApp()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 31:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.e0(qQAppInterface.getApp(), qQAppInterface.getAccount()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 34:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(((PhoneUnityManager) qQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).d());
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 38:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.i1(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 42:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.g1(qQAppInterface.getApp(), f202907b));
                    long longExtra = intent.getLongExtra("k_adcode", 0L);
                    String stringExtra3 = intent.getStringExtra("key_province");
                    if (stringExtra3 == null) {
                        stringExtra3 = "";
                    }
                    String stringExtra4 = intent.getStringExtra("key_city");
                    str = stringExtra4 != null ? stringExtra4 : "";
                    configurationService$ReqGetConfig2.province.set(stringExtra3);
                    configurationService$ReqGetConfig2.city.set(str);
                    configurationService$ReqGetConfig2.adcode.set(longExtra);
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 43:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.l1(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 44:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.i0(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 49:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.j0(qQAppInterface.getApp()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 55:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.f2(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 56:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.I0(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 57:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.d1(qQAppInterface.getApp()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 61:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.w(qQAppInterface.getApp()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 63:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.T(qQAppInterface.getApp()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 64:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.x1(qQAppInterface.getApp()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 66:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.D1(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 69:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.n1(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 78:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.D0(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 79:
                case 119:
                    i3 = length;
                    i16 = i17;
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 80:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.R1(qQAppInterface.getApp()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 82:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.u0(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 90:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.J0(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 93:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.h1(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 94:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.k0(qQAppInterface.getApp(), qQAppInterface.getAccount()));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 97:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).getsAllEntranceConfigVersion());
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 101:
                    i3 = length;
                    i16 = i17;
                    int a17 = com.tencent.mobileqq.cooperation.a.a(BaseApplication.getContext());
                    if (SettingCloneUtil.readValueForInt(BaseApplication.getContext(), f202907b, null, AppConstants.QQSETTING_CALLTAB_SHOW_KEY_VERSION, 0) < a17) {
                        configurationService$ConfigSeq.version.set(0);
                        intent.putExtra("update101Version", a17);
                    } else {
                        configurationService$ConfigSeq.version.set(ea.a0(qQAppInterface.getApp(), qQAppInterface.getAccount()));
                    }
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 102:
                    i3 = length;
                    i16 = i17;
                    if (SettingCloneUtil.readValueForInt(BaseApplication.getContext(), f202907b, null, AppConstants.QQSETTING_CALLTAB_SHOW_KEY_VERSION, 0) < com.tencent.mobileqq.cooperation.a.a(BaseApplication.getContext())) {
                        configurationService$ConfigSeq.version.set(0);
                    } else {
                        configurationService$ConfigSeq.version.set(ea.o(qQAppInterface.getApp(), qQAppInterface.getAccount()));
                    }
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 109:
                    i3 = length;
                    i16 = i17;
                    int e16 = com.tencent.mobileqq.camera.utils.a.e(BaseApplication.getContext());
                    configurationService$ConfigSeq.version.set(e16);
                    configurationService$ConfigSeq.compress.set(1);
                    intent.putExtra("qcamera_conf_version", e16);
                    intent.putExtra("uin", qQAppInterface.getCurrentAccountUin());
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.camera.configServlet", 2, "request QCAMERA_PHONE_CONFIG version: " + e16);
                    }
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 115:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.G0(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 116:
                    i3 = length;
                    i16 = i17;
                    if (!UpgradeConfigTypeParser.d()) {
                        QLog.d("SPLASH_ConfigServlet", 1, "addAllConfigs|GET_CONFIG_UPGRADE useFreesia");
                        break;
                    } else {
                        int K0 = ea.K0(qQAppInterface.getApp(), f202907b);
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|GET_CONFIG_UPGRADE version=" + K0);
                        }
                        configurationService$ConfigSeq.version.set(K0);
                        qQAppInterface.getPreloadSwitch();
                        OpenConfig.i(qQAppInterface.getApp(), String.valueOf(AppSetting.f()));
                        ((ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).q3();
                        list3 = list;
                        list3.add(configurationService$ConfigSeq);
                        list2.add(Integer.valueOf(i18));
                        break;
                    }
                case 129:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_NOWLIVE_TAB_CONFIG_VERSION, f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 130:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.g0(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 139:
                    i3 = length;
                    i16 = i17;
                    int P = PtvTemplateManager.o() ? ea.P(qQAppInterface.getApp()) : 0;
                    configurationService$ConfigSeq.version.set(P);
                    configurationService$ConfigSeq.compress.set(1);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 4, String.format("\u4e2a\u6027\u7b14\u89e6\u914d\u7f6e\u7248\u672c\u53f7[%s]", Integer.valueOf(P)));
                    }
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 140:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.y0(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 142:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.TROOP_COMMON_CONFIG_VERSION, f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 145:
                    i3 = length;
                    i16 = i17;
                    if (!PtvTemplateManager.n()) {
                        configurationService$ConfigSeq.version.set(0);
                    } else {
                        configurationService$ConfigSeq.version.set(ea.t(qQAppInterface.getApp()));
                    }
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 147:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.P1(qQAppInterface.getApp(), "shop_tab", f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 148:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.J1(qQAppInterface.getApp()));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 149:
                case 180:
                case 218:
                    i3 = length;
                    i16 = i17;
                    l.b(i18, f202907b, configurationService$ConfigSeq);
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 155:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.q1(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 157:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.y(qQAppInterface.getApp(), f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 165:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.u(qQAppInterface.getApp(), f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 171:
                    i3 = length;
                    i16 = i17;
                    configurationService$ConfigSeq.version.set(ea.H1(qQAppInterface.getApp(), f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 174:
                    i3 = length;
                    if (((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(f202907b, "key_app_id", (Object) 0)).intValue() != AppSetting.f()) {
                        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_TABS_CONFIG_VERSION, (Object) 0);
                        i16 = i17;
                        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, "key_app_id", Integer.valueOf(AppSetting.f()));
                    } else {
                        i16 = i17;
                    }
                    configurationService$ConfigSeq.version.set(((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(f202907b, INearbySPUtil.KEY_TABS_CONFIG_VERSION, (Object) 0)).intValue());
                    configurationService$ConfigSeq.compress.set(1);
                    String stringExtra5 = intent.getStringExtra("key_province");
                    if (stringExtra5 == null) {
                        stringExtra5 = "";
                    }
                    String stringExtra6 = intent.getStringExtra("key_city");
                    str = stringExtra6 != null ? stringExtra6 : "";
                    configurationService$ReqGetConfig2.province.set(stringExtra5);
                    configurationService$ReqGetConfig2.city.set(str);
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 177:
                    configurationService$ConfigSeq.version.set(ea.f1(qQAppInterface.getApp(), f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 184:
                    configurationService$ConfigSeq.version.set(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountQQMailConfigVersionCode(qQAppInterface));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 185:
                    configurationService$ConfigSeq.version.set(ea.r1(qQAppInterface.getApp()));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 187:
                    configurationService$ConfigSeq.version.set(com.tencent.mobileqq.activity.aio.photo.l.b(qQAppInterface.getApp(), f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 188:
                    ARGlobalConfigManager aRGlobalConfigManager = (ARGlobalConfigManager) qQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
                    if (aRGlobalConfigManager != null) {
                        int g16 = aRGlobalConfigManager.g();
                        if (QLog.isColorLevel()) {
                            QLog.d("handleResp_GetArGlobalConfig", 2, " local version = " + g16);
                        }
                        if (aRGlobalConfigManager.a()) {
                            configurationService$ConfigSeq.version.set(g16);
                        } else {
                            configurationService$ConfigSeq.version.set(0);
                            g16 = 0;
                        }
                        configurationService$ConfigSeq.compress.set(1);
                        intent.putExtra("ar_global_key_config_version", g16);
                    }
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 191:
                    configurationService$ConfigSeq.version.set(ea.p(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 193:
                    int M1 = ea.M1(qQAppInterface.getApp(), f202907b);
                    configurationService$ConfigSeq.version.set(M1);
                    if (QLog.isColorLevel()) {
                        QLog.d("UpgradeTIMWrapper", 2, "ConfigServlet req :193, version: " + M1);
                    }
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 194:
                    configurationService$ConfigSeq.version.set(ea.I1(qQAppInterface.getApp(), f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 195:
                    configurationService$ConfigSeq.version.set(ea.P1(qQAppInterface.getApp(), "change_machine_version", f202907b));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 201:
                    configurationService$ConfigSeq.version.set(ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_CONFIG_VERSION, f202907b));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 204:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt(AppConstants.Preferences.ZHITU_CONFIG_VERSION, 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 205:
                    int f16 = FaceScanDownloadManager.f(qQAppInterface);
                    configurationService$ConfigSeq.version.set(f16);
                    configurationService$ConfigSeq.compress.set(1);
                    intent.putExtra("key_download_cfg_version", f16);
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_FACE_PRE_DOWN_CONFIG, version = " + f16);
                    }
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 210:
                    int configVersion = ((IOCRService) qQAppInterface.getRuntimeService(IOCRService.class, "")).getConfigVersion();
                    configurationService$ConfigSeq.version.set(configVersion);
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet OCR_CONFIG ocrVersion:" + configVersion);
                    }
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 211:
                    v.b(qQAppInterface, configurationService$ConfigSeq);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 212:
                    int m16 = ea.m1(BaseApplication.getContext(), f202907b);
                    configurationService$ConfigSeq.version.set(m16);
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet receipt ,receiptVersion:" + m16);
                    }
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 215:
                    int w3 = AEOldShortVideoResManager.w();
                    configurationService$ConfigSeq.version.set(w3);
                    configurationService$ConfigSeq.compress.set(1);
                    if (QLog.isColorLevel()) {
                        QLog.i("AEOldShortVideoResManager", 2, "SHORT_VIDEO_RESOURCE_CONFIG  ,versionRes:" + w3);
                    }
                    AEOldShortVideoResManager.B();
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 222:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 223:
                case 364:
                case 365:
                    BusinessCommonConfig.getInstance(qQAppInterface).fillConfigVersion(i18, configurationService$ConfigSeq);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 225:
                    configurationService$ConfigSeq.version.set(((ICaptureVideoFilterManager) QRoute.api(ICaptureVideoFilterManager.class)).getQQShortVideoFilterConfigVersion(qQAppInterface.getApp()));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 226:
                    if (!CapturePtvTemplateManager.j()) {
                        configurationService$ConfigSeq.version.set(0);
                    } else {
                        configurationService$ConfigSeq.version.set(ea.B0(qQAppInterface.getApp()));
                    }
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 227:
                    configurationService$ConfigSeq.version.set(ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_AUTH_VIDEO_CONFIG_VERSION, f202907b));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 228:
                    int k16 = ea.k1(qQAppInterface.getApp(), f202907b);
                    if (ea.j1(qQAppInterface.getApp(), qQAppInterface.getAccount()) != AppSetting.f()) {
                        k16 = 0;
                    }
                    configurationService$ConfigSeq.version.set(k16);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 232:
                    v.c(configurationService$ConfigSeq);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 234:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt("tim_login_jump", 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 238:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt("tim_upgrade_hongdian_version", 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 244:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt("call_tim_config_version", 0));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 245:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt("tim_pc_banner", 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 247:
                    int b06 = ea.b0(qQAppInterface.getApp(), f202907b);
                    int f17 = AppSetting.f();
                    if (b06 != f17) {
                        ea.a4(qQAppInterface.getApp(), f202907b, 0);
                        ea.Z3(qQAppInterface.getApp(), f202907b, f17);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "[GreenVideo]onsend : appIdRecord = " + b06 + ", appId = " + f17 + ", GREEN_VIDEO_CONFI version = " + ea.c0(qQAppInterface.getApp(), f202907b));
                    }
                    configurationService$ConfigSeq.version.set(ea.c0(qQAppInterface.getApp(), f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 253:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt("troop_link_config_version", 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 254:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 256:
                    int F1 = ea.F1(qQAppInterface.getApp(), f202907b);
                    if (ea.E1(qQAppInterface.getApp(), qQAppInterface.getAccount()) != AppSetting.f()) {
                        F1 = 0;
                    }
                    configurationService$ConfigSeq.version.set(F1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 257:
                    if (ea.z0(qQAppInterface.getApp(), f202907b, 1) != AppSetting.f()) {
                        ea.q4(qQAppInterface.getApp(), f202907b, 1, AppSetting.f());
                        ea.q4(qQAppInterface.getApp(), f202907b, 2, 0);
                        configurationService$ConfigSeq.version.set(0);
                    } else {
                        configurationService$ConfigSeq.version.set(ea.z0(qQAppInterface.getApp(), f202907b, 2));
                    }
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 259:
                    configurationService$ConfigSeq.version.set(cr2.a.e(qQAppInterface.getApp()));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 260:
                    try {
                        if (((Integer) ea.Q0(qQAppInterface.getApp(), f202907b, 1)).intValue() != AppSetting.f()) {
                            ea.B4(qQAppInterface.getApp(), f202907b, 1, Integer.valueOf(AppSetting.f()));
                            ea.B4(qQAppInterface.getApp(), f202907b, 2, 0);
                            configurationService$ConfigSeq.version.set(0);
                        } else {
                            configurationService$ConfigSeq.version.set(((Integer) ea.Q0(qQAppInterface.getApp(), f202907b, 2)).intValue());
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.i("SPLASH_ConfigServlet", 2, "PUSH_RECOMMEND_SHIELD_CONFIG", th5);
                        }
                    }
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 262:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt("data_migration_tim_version", 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 268:
                    configurationService$ConfigSeq.version.set(ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_VIDEOCHAT_DIALOG_CONFIG_VERSION, f202907b));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 269:
                    configurationService$ConfigSeq.version.set(ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.NEARBY_VIDEOCHAT_BANNER_CONFIG_VERSION, f202907b));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 273:
                    configurationService$ConfigSeq.version.set(com.tencent.biz.troopgift.a.b(f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 274:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt(AppConstants.Preferences.HOMEWORK_TROOP_CONFIG_VERSION_CODE, 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case FilterEnum.MIC_PTU_TRANS_KONGCHENG /* 281 */:
                    configurationService$ConfigSeq.version.set(ea.P1(qQAppInterface.getApplication(), "troop_gift_anim_limit", "0"));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 283:
                    configurationService$ConfigSeq.version.set(0);
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 284:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt(AppConstants.Preferences.TASK_ENTRY_CONFIG_VERSION_CODE, 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 286:
                    configurationService$ConfigSeq.version.set(ea.F0(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case FilterEnum.MIC_PTU_ZIRAN /* 289 */:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt(AppConstants.Preferences.BULUO_ENTER_CONFIG_VERSION + qQAppInterface.getCurrentUin(), 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 301:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt(AppConstants.Preferences.QZONE_XP_CONFIG_VERSION, 0));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE /* 328 */:
                    configurationService$ConfigSeq.version.set(qQAppInterface.getPreferences().getInt("new_troop_recommend", 0));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 336:
                    configurationService$ConfigSeq.version.set(ea.E0(qQAppInterface.getApp(), qQAppInterface.getAccount()));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case i.CTRL_INDEX /* 347 */:
                    configurationService$ConfigSeq.version.set(((IQIMBeautyManager) QRoute.api(IQIMBeautyManager.class)).getBeautyConfigVersion(qQAppInterface.getApp()));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 349:
                    configurationService$ConfigSeq.version.set(((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).s().d(qQAppInterface.getApp(), f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 371:
                    configurationService$ConfigSeq.version.set(ea.H(qQAppInterface.getApp(), f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case MsgConstant.KRMFILETHUMBSIZE384 /* 384 */:
                    configurationService$ConfigSeq.version.set(com.tencent.mobileqq.weiyun.utils.c.c(qQAppInterface.getApp(), f202907b));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 385:
                    NotificationController notificationController = (NotificationController) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER);
                    int configVersion2 = notificationController.getConfigVersion(qQAppInterface.getApp(), f202907b);
                    int configAppId = notificationController.getConfigAppId(qQAppInterface.getApp(), f202907b);
                    int f18 = AppSetting.f();
                    if (configAppId != f18) {
                        configVersion2 = 0;
                    }
                    QLog.i(NotificationController.TAG, 1, String.format("request NOTIFICATION_LIMIT_CONFIG localVersion: %d ,originalAppId:%d, currentAppId:%d", Integer.valueOf(configVersion2), Integer.valueOf(configAppId), Integer.valueOf(f18)));
                    configurationService$ConfigSeq.version.set(configVersion2);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case tlv_t183.CMD_183 /* 387 */:
                    configurationService$ConfigSeq.version.set(ea.K(qQAppInterface.getApp(), f202907b));
                    configurationService$ConfigSeq.compress.set(1);
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 394:
                    int d16 = bg.d();
                    configurationService$ConfigSeq.version.set(d16);
                    configurationService$ConfigSeq.compress.set(1);
                    if (QLog.isColorLevel()) {
                        QLog.i("JumpForwardPkgManager", 2, "JUMP_PKG_TOAST_CONFIG  ,version:" + d16);
                    }
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 400:
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 403:
                    configurationService$ConfigSeq.version.set(ea.k(BaseApplication.getContext(), f202907b));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 596:
                    configurationService$ConfigSeq.version.set(((Integer) p.b(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), AppConstants.Preferences.CONFIG_TIM_TEAM_VERSION_CODE, 0)).intValue());
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                case 705:
                    configurationService$ConfigSeq.version.set(ea.n0(AppConstants.Preferences.LOCAL_QR_LOGIN_VERSION));
                    list3 = list;
                    i3 = length;
                    i16 = i17;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
                default:
                    i3 = length;
                    i16 = i17;
                    try {
                        qQAppInterface.getConfigProcess().f(configurationService$ConfigSeq, qQAppInterface, i18);
                    } catch (Exception e17) {
                        QLog.d("QConfigManager", 1, "exception " + i18, e17);
                    }
                    list3 = list;
                    list3.add(configurationService$ConfigSeq);
                    list2.add(Integer.valueOf(i18));
                    break;
            }
            i17 = i16 + 1;
            iArr2 = iArr;
        }
        ConfigurationService$DeviceInfo configurationService$DeviceInfo = new ConfigurationService$DeviceInfo();
        if (list2.contains(1) || list2.contains(2) || list2.contains(3) || list2.contains(12)) {
            ConfigurationService$Screen configurationService$Screen = new ConfigurationService$Screen();
            configurationService$Screen.setHasFlag(true);
            configurationService$Screen.width.set((int) ah.M());
            configurationService$Screen.height.set((int) ah.L());
            configurationService$DeviceInfo.screen = configurationService$Screen;
            configurationService$DeviceInfo.setHasFlag(true);
            configurationService$ReqGetConfig2.device_info = configurationService$DeviceInfo;
        }
        if (list2.contains(47) || list2.contains(65) || list2.contains(156)) {
            ConfigurationService$OS configurationService$OS = new ConfigurationService$OS();
            configurationService$OS.setHasFlag(true);
            configurationService$OS.type.set(2);
            configurationService$OS.kernel.set(ah.B());
            configurationService$OS.sdk.set(String.valueOf(ah.K()));
            configurationService$OS.version.set(ah.t());
            configurationService$OS.rom.set(ah.S());
            configurationService$DeviceInfo.brand.set(ah.C());
            configurationService$DeviceInfo.model.set(ah.s());
            if (QLog.isDevelopLevel()) {
                z16 = true;
                QLog.w("SPLASH_ConfigServlet", 1, "addAllConfigs, brand[" + configurationService$DeviceInfo.brand.get() + "], model[" + configurationService$DeviceInfo.model.get() + "]");
            } else {
                z16 = true;
            }
            configurationService$DeviceInfo.f202980os = configurationService$OS;
            configurationService$DeviceInfo.setHasFlag(z16);
            configurationService$ReqGetConfig2.device_info = configurationService$DeviceInfo;
        }
    }

    private void e0(QQAppInterface qQAppInterface, Intent intent, ConfigurationService$Config configurationService$Config) {
        List<String> list;
        String[] split;
        int i3 = configurationService$Config.version.get();
        if (i3 == ea.G0(qQAppInterface.getApp(), f202907b)) {
            return;
        }
        ea.b3(qQAppInterface.getApp(), i3, f202907b);
        PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
        if (pBRepeatField != null && pBRepeatField.size() > 0 && (list = configurationService$Config.content_list.get()) != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            for (int i16 = 0; i16 < list.size(); i16++) {
                String str = list.get(i16);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_STORY_FOUR_TAB, 2, "receiveAllConfigs|type: 115,content: " + str + ",version: " + configurationService$Config.version.get());
                }
                if (!TextUtils.isEmpty(str) && (split = str.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length == 2) {
                    hashMap.put(split[0], split[1]);
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TAG_STORY_FOUR_TAB, 2, "NowTabConfigCmd, name=" + split[0] + ", val=" + split[1]);
                    }
                }
            }
            String str2 = (String) hashMap.get("mqq_nowtab_plan");
            if (QLog.isColorLevel()) {
                QLog.i("nowtabPlan", 2, "nowtabPlan=" + str2);
            }
            if (str2 != null) {
                try {
                    int intValue = Integer.valueOf("" + qQAppInterface.getNowLiveManager().e().charAt(2)).intValue();
                    int intValue2 = Integer.valueOf(str2).intValue();
                    if (intValue != intValue2) {
                        Integer[] numArr = new Integer[5];
                        if (intValue2 != 0 && intValue2 != 1) {
                            if (intValue2 != 2) {
                                if (intValue2 == 3) {
                                    numArr[2] = Integer.valueOf(intValue2);
                                    numArr[1] = 1;
                                    qQAppInterface.getNowLiveManager().j(numArr);
                                    if (QLog.isColorLevel()) {
                                        QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 3 nowtabPlan=" + str2);
                                    }
                                }
                            } else {
                                numArr[1] = 0;
                                numArr[2] = Integer.valueOf(intValue2);
                                qQAppInterface.getNowLiveManager().j(numArr);
                                if (QLog.isColorLevel()) {
                                    QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 2 nowtabPlan=" + str2);
                                }
                            }
                        } else {
                            for (int i17 = 0; i17 < 5; i17++) {
                                numArr[i17] = 0;
                            }
                            numArr[2] = Integer.valueOf(intValue2);
                            if (QLog.isColorLevel()) {
                                QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 0 1 nowtabPlan=" + str2);
                            }
                            qQAppInterface.getNowLiveManager().j(numArr);
                        }
                    }
                    qQAppInterface.getNowLiveManager().D = str2.charAt(0);
                } catch (Exception e16) {
                    QLog.w("Q.qqstory.fourTab:nowtabPlan", 2, "" + e16.getMessage(), e16);
                }
            }
            String str3 = (String) hashMap.get("mqq_nowtab_index");
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory.fourTab:nowtabIndex", 2, "nowtabIndex=" + str3);
            }
            if (str3 != null) {
                try {
                    qQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).edit().putInt("now_index_key", Integer.valueOf(str3).intValue());
                    qQAppInterface.getNowLiveManager().f446629i = Integer.valueOf(str3).intValue();
                } catch (Exception unused) {
                    QLog.w("Q.qqstory.fourTab:nowtabIndex", 2, "nowtabIndex is not value of Int!");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float f(float f16, float f17) {
        return ((f16 + 50.0f) / 100.0f) * f17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0134, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0127, code lost:
    
        r0.Q();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0125, code lost:
    
        if (r4 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0131, code lost:
    
        if (r4 != false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int f0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config, String str) {
        boolean z16;
        int i3;
        AEOldShortVideoResManager v3 = AEOldShortVideoResManager.v(qQAppInterface);
        int i16 = 0;
        if (v3 == null && "ConfigurationService.ReqGetConfigNoLogin".equals(str)) {
            v3 = new AEOldShortVideoResManager(qQAppInterface);
            z16 = true;
        } else {
            z16 = false;
        }
        int w3 = AEOldShortVideoResManager.w();
        int i17 = configurationService$Config.version.get();
        QLog.d("AEOldShortVideoResManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|received remote version: " + i17 + " | localVersion: " + w3);
        try {
            if (i17 != w3) {
                try {
                    PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
                    int i18 = -125;
                    if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField2 = configurationService$Config.msg_content_list;
                        ConfigurationService$Content configurationService$Content = pBRepeatMessageField2.get(pBRepeatMessageField2.size() - 1);
                        if (configurationService$Content != null) {
                            String str2 = "";
                            if (configurationService$Content.compress.get() == 1) {
                                byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                                if (d16 != null) {
                                    try {
                                        str2 = new String(d16, "UTF-8");
                                    } catch (Throwable th5) {
                                        QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|Throwable:" + th5.getMessage());
                                    }
                                } else {
                                    QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|inflateConfigString error!");
                                }
                            } else {
                                str2 = configurationService$Content.content.get().toStringUtf8();
                            }
                            QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|config_content " + str2);
                            if ("ConfigurationService.ReqGetConfigNoLogin".equals(str)) {
                                i3 = v3.R(str2, i17);
                            } else {
                                if (v3 != null) {
                                    i18 = v3.S(qQAppInterface.getApp(), str2, i17);
                                }
                                i3 = i18;
                            }
                            i16 = i3;
                        } else {
                            QLog.d("AEOldShortVideoResManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| content==null");
                        }
                    } else {
                        QLog.d("AEOldShortVideoResManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| msg_content_list is empty ,version: " + i17 + ",localVersion:" + w3);
                    }
                    i16 = -125;
                } catch (Exception e16) {
                    QLog.d("AEOldShortVideoResManager", 1, "handleShortVideoResourceConfig error: " + e16);
                }
            }
        } catch (Throwable th6) {
            if (z16) {
                v3.Q();
            }
            throw th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float g(float f16, float f17, float f18) {
        return (f17 / 2.0f) - ((f16 * f18) / 100.0f);
    }

    private void g0(final QQAppInterface qQAppInterface, final ConfigurationService$Config configurationService$Config) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.config.splashlogo.ConfigServlet.8
            /* JADX WARN: Removed duplicated region for block: B:55:0x0140  */
            /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i3;
                boolean z16;
                JSONArray optJSONArray;
                IPasswdRedBagService iPasswdRedBagService = (IPasswdRedBagService) qQAppInterface.getRuntimeService(IPasswdRedBagService.class);
                HashSet<String> hashSet = new HashSet<>();
                int I0 = ea.I0(qQAppInterface.getApp(), ConfigServlet.f202907b);
                int i16 = configurationService$Config.version.get();
                if (i16 != I0) {
                    if (i16 != I0) {
                        i3 = i16;
                    } else {
                        i3 = I0;
                    }
                    PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
                    if (pBRepeatField != null && pBRepeatField.size() > 0) {
                        int size = configurationService$Config.content_list.size();
                        for (int i17 = 0; i17 < size; i17++) {
                            String str = configurationService$Config.content_list.get(i17);
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 56,content: " + str + ",version: " + configurationService$Config.version.get());
                            }
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    Iterator keys = jSONObject.keys();
                                    while (keys.hasNext()) {
                                        String str2 = (String) keys.next();
                                        if ("passwordPlaceholder".equals(str2) && (optJSONArray = jSONObject.optJSONArray(str2)) != null) {
                                            int length = optJSONArray.length();
                                            for (int i18 = 0; i18 < length; i18++) {
                                                String optString = optJSONArray.optString(i18);
                                                if (!TextUtils.isEmpty(optString) && !hashSet.contains(optString)) {
                                                    hashSet.add(optString);
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG error", e16);
                                    }
                                }
                            }
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 56,content_list is empty ,version: " + configurationService$Config.version.get());
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG remote version: " + i16 + " | localVersion: " + I0);
                    }
                    i3 = I0;
                }
                if (i3 != I0) {
                    try {
                        ea.u4(qQAppInterface.getApp(), ConfigServlet.f202907b, i3);
                        iPasswdRedBagService.updatePasswdConfig(hashSet);
                        z16 = true;
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG error", e17);
                        }
                    }
                    if (z16) {
                        iPasswdRedBagService.loadConfigs();
                        return;
                    }
                    return;
                }
                z16 = false;
                if (z16) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h(float f16) {
        return (f16 / 100.0f) * ((float) ah.x());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:10|(2:100|(1:102))(2:14|(8:18|(1:20)|21|22|23|(7:25|27|28|29|(3:(3:34|35|(3:37|(3:39|(2:41|42)(2:44|(2:46|47)(2:48|(2:50|51)(2:52|(2:54|55)(2:56|(2:58|59)(2:60|(2:62|63)(3:64|65|(2:67|68)(2:69|(2:71|72)(1:73))))))))|43)|74)(2:75|(1:77)(2:78|(1:80)(2:81|(1:83)))))|32|33)|90|91)(1:96)|88|89))|99|21|22|23|(0)(0)|88|89) */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01f2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f3, code lost:
    
        r12 = "";
        r13 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c3 A[Catch: all -> 0x01f2, TRY_LEAVE, TryCatch #1 {all -> 0x01f2, blocks: (B:23:0x00bd, B:25:0x00c3), top: B:22:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        String str;
        String str2;
        String str3;
        int i3;
        int i16 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("MobileUnityManager", 2, "CMD_PHONE_UNITY_BANNER_CONFIG");
        }
        PhoneUnityManager phoneUnityManager = (PhoneUnityManager) qQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
        int d16 = phoneUnityManager.d();
        int i17 = configurationService$Config.version.get();
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "newVersion " + i17);
        }
        if (d16 == i17) {
            return;
        }
        PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
        com.tencent.mobileqq.activity.contact.phonecontact.a aVar = null;
        int i18 = 0;
        if (pBRepeatField != null && pBRepeatField.size() > 0) {
            List<String> list = configurationService$Config.content_list.get();
            if (list != null && list.size() > 0) {
                str = list.get(0);
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 34,content: " + str + ",version: " + configurationService$Config.version.get());
                }
                int i19 = 1;
                if (!TextUtils.isEmpty(str)) {
                    str2 = "";
                    str3 = str2;
                    i3 = 0;
                } else {
                    com.tencent.mobileqq.activity.contact.phonecontact.a aVar2 = new com.tencent.mobileqq.activity.contact.phonecontact.a();
                    try {
                        XmlPullParser newPullParser = Xml.newPullParser();
                        newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
                        str2 = "";
                        str3 = str2;
                        int i26 = 0;
                        int i27 = 0;
                        while (i26 != i19) {
                            if (i26 == i16) {
                                try {
                                    String name = newPullParser.getName();
                                    if (name.equalsIgnoreCase("banner")) {
                                        int attributeCount = newPullParser.getAttributeCount();
                                        for (int i28 = i18; i28 < attributeCount; i28++) {
                                            String attributeName = newPullParser.getAttributeName(i28);
                                            if ("text".equals(attributeName)) {
                                                aVar2.f181295b = newPullParser.getAttributeValue(i28);
                                            } else if ("url".equals(attributeName)) {
                                                aVar2.f181294a = newPullParser.getAttributeValue(i28);
                                            } else if ("dayNum".equals(attributeName)) {
                                                aVar2.f181296c = Integer.valueOf(newPullParser.getAttributeValue(i28)).intValue();
                                            } else if ("dayIntervalNum".equals(attributeName)) {
                                                aVar2.f181297d = Integer.valueOf(newPullParser.getAttributeValue(i28)).intValue();
                                            } else if ("totalNum".equals(attributeName)) {
                                                aVar2.f181298e = Integer.valueOf(newPullParser.getAttributeValue(i28)).intValue();
                                            } else if ("loginNum".equals(attributeName)) {
                                                aVar2.f181300g = Integer.valueOf(newPullParser.getAttributeValue(i28)).intValue();
                                            } else if ("banner".equals(attributeName)) {
                                                aVar2.f181301h = "1".equals(newPullParser.getAttributeValue(i28));
                                            } else if ("setEntry".equals(attributeName)) {
                                                aVar2.f181302i = "1".equals(newPullParser.getAttributeValue(i28));
                                            }
                                        }
                                    } else if (name.equalsIgnoreCase("bindGuideWording")) {
                                        str2 = newPullParser.nextText();
                                    } else if (name.equalsIgnoreCase("bindGuideStyle")) {
                                        i27 = Integer.valueOf(newPullParser.nextText()).intValue();
                                    } else if (name.equalsIgnoreCase("guideWording")) {
                                        str3 = newPullParser.nextText();
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    aVar = aVar2;
                                    i3 = i27;
                                    QLog.e("IMCore.PhoneContact", 1, "", th);
                                    phoneUnityManager.l(i17, str, aVar);
                                    ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).saveBindConfig(i3, str2, str3);
                                }
                            }
                            i26 = newPullParser.next();
                            i16 = 2;
                            i19 = 1;
                            i18 = 0;
                        }
                        aVar = aVar2;
                        i3 = i27;
                    } catch (Throwable th6) {
                        th = th6;
                        str2 = "";
                        str3 = str2;
                        aVar = aVar2;
                        i3 = 0;
                        QLog.e("IMCore.PhoneContact", 1, "", th);
                        phoneUnityManager.l(i17, str, aVar);
                        ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).saveBindConfig(i3, str2, str3);
                    }
                }
                phoneUnityManager.l(i17, str, aVar);
                ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).saveBindConfig(i3, str2, str3);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 34,content_list is empty ,version: " + configurationService$Config.version.get());
        }
        str = null;
        int i192 = 1;
        if (!TextUtils.isEmpty(str)) {
        }
        phoneUnityManager.l(i17, str, aVar);
        ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).saveBindConfig(i3, str2, str3);
    }

    private String i(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                } catch (IOException e17) {
                    e17.printStackTrace();
                    inputStream.close();
                }
            } catch (Throwable th5) {
                try {
                    inputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                throw th5;
            }
        }
        inputStream.close();
        return sb5.toString();
    }

    private static int j(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        try {
            return (int) ((simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime()) / 86400000);
        } catch (ParseException e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public static String k(ConfigurationService$Config configurationService$Config, int i3, int i16) {
        if (configurationService$Config.version.get() == i3) {
            QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| config content will be null localVersion is same as config.version(" + i3 + "). type=" + i16);
            return null;
        }
        if (configurationService$Config.content_list.size() > 0) {
            return configurationService$Config.content_list.get(0);
        }
        if (configurationService$Config.msg_content_list.size() == 0) {
            QLog.i("SPLASH_ConfigServlet", 1, String.format(Locale.getDefault(), "extractConfigContent| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", Integer.valueOf(configurationService$Config.version.get()), Integer.valueOf(i3), Integer.valueOf(i16)));
            return "";
        }
        byte[] byteArray = configurationService$Config.msg_content_list.get(0).content.get().toByteArray();
        if (configurationService$Config.msg_content_list.get(0).compress.get() == 1 && (byteArray = com.tencent.mobileqq.ar.i.c(byteArray)) == null) {
            QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| decompress is failed. type=" + i16 + ", data=null");
            return null;
        }
        try {
            String str = new String(byteArray, "utf-8");
            String format = String.format(Locale.getDefault(), "extractConfigContent| config is update. version=%d, type=%d", Integer.valueOf(configurationService$Config.version.get()), Integer.valueOf(i16));
            if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, format + "content=" + str);
            } else {
                QLog.i("SPLASH_ConfigServlet", 1, format);
            }
            return str;
        } catch (UnsupportedEncodingException e16) {
            QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| data[] to String failed. type=" + i16, e16);
            return null;
        }
    }

    private void k0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3;
        try {
            int i16 = configurationService$Config.version.get();
            int intValue = ((Integer) ea.Q0(qQAppInterface.getApp(), f202907b, 2)).intValue();
            String str = null;
            if (i16 != intValue) {
                if (configurationService$Config.msg_content_list.size() > 0) {
                    ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                    if (configurationService$Content == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig content is null !");
                        }
                        i3 = 1;
                    } else if (configurationService$Content.compress.get() == 1) {
                        byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                        if (d16 != null) {
                            try {
                                String str2 = new String(d16, "UTF-8");
                                i3 = 0;
                                str = str2;
                            } catch (Throwable th5) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig Throwable:" + th5.getMessage());
                                }
                                i3 = 2;
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig inflateConfigString error!");
                            }
                            i3 = 3;
                        }
                    } else {
                        str = configurationService$Content.content.get().toStringUtf8();
                        i3 = 0;
                    }
                } else {
                    i3 = 4;
                }
                if (str == null) {
                    str = "";
                }
                if (i3 == 0) {
                    ea.B4(qQAppInterface.getApp(), f202907b, 3, str);
                    int i17 = QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER;
                    if (qQAppInterface.isCreateManager(i17)) {
                        ((MayknowRecommendManager) qQAppInterface.getManager(i17)).t(str);
                    }
                }
                ea.B4(qQAppInterface.getApp(), f202907b, 2, Integer.valueOf(i16));
            } else {
                i3 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handlePushRecommendShieldConfig localVersion: %s, version: %s, result: %s, strContent: %s", Integer.valueOf(intValue), Integer.valueOf(i16), Integer.valueOf(i3), str));
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
    }

    public static String k1(SharedPreferences sharedPreferences, String str, boolean z16) {
        String string = sharedPreferences.getString("data_migration_tim_uins", "");
        if (TextUtils.isEmpty(string)) {
            if (!z16) {
                return string;
            }
            return str;
        }
        int i3 = 0;
        if (z16) {
            String[] split = string.split(";");
            int length = split.length;
            while (i3 < length) {
                if (split[i3].equals(str)) {
                    return string;
                }
                i3++;
            }
            return string + ";" + str;
        }
        String[] split2 = string.split(";");
        StringBuilder sb5 = new StringBuilder();
        int length2 = split2.length;
        while (i3 < length2) {
            String str2 = split2[i3];
            if (!str2.equals(str)) {
                sb5.append(str2);
                sb5.append(";");
            }
            i3++;
        }
        if (sb5.length() > 0 && sb5.charAt(sb5.length() - 1) == ';') {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        return sb5.toString();
    }

    public static List<String> l(ConfigurationService$Config configurationService$Config, int i3, int i16) {
        if (configurationService$Config.version.get() == i3) {
            QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContentList| config content is null. type=" + i16);
            return null;
        }
        if (configurationService$Config.content_list.size() > 0) {
            return configurationService$Config.content_list.get();
        }
        int size = configurationService$Config.msg_content_list.size();
        if (size == 0) {
            QLog.i("SPLASH_ConfigServlet", 1, String.format(Locale.getDefault(), "extractConfigContentList| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", Integer.valueOf(configurationService$Config.version.get()), Integer.valueOf(i3), Integer.valueOf(i16)));
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(size);
        for (int i17 = 0; i17 < size; i17++) {
            byte[] byteArray = configurationService$Config.msg_content_list.get(0).content.get().toByteArray();
            if (configurationService$Config.msg_content_list.get(0).compress.get() == 1 && (byteArray = com.tencent.mobileqq.ar.i.c(byteArray)) == null) {
                QLog.e("SPLASH_ConfigServlet", 1, i17 + ": extractConfigContentList| decompress is failed. type=" + i16 + ", data=null");
            } else {
                try {
                    String str = new String(byteArray, "utf-8");
                    arrayList.add(str);
                    String format = String.format(Locale.getDefault(), "%d: extractConfigContent| config is update. version=%d, type=%d", Integer.valueOf(i17), Integer.valueOf(configurationService$Config.version.get()), Integer.valueOf(i16));
                    if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, format + "content=" + str);
                    } else {
                        QLog.i("SPLASH_ConfigServlet", 1, format);
                    }
                } catch (UnsupportedEncodingException e16) {
                    QLog.e("SPLASH_ConfigServlet", 1, i17 + ": extractConfigContentList| data[] to String failed. type=" + i16, e16);
                }
            }
        }
        return arrayList;
    }

    public static void m(QQAppInterface qQAppInterface, String str) {
        am.c(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0284  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        SAXException sAXException;
        String str;
        String str2;
        int i3;
        int i16;
        ParserConfigurationException parserConfigurationException;
        NumberFormatException numberFormatException;
        NullPointerException nullPointerException;
        IOException iOException;
        UnsupportedEncodingException unsupportedEncodingException;
        String str3;
        String str4;
        boolean z16;
        int i17;
        boolean z17;
        int i18;
        Node firstChild;
        int i19 = configurationService$Config.version.get();
        int k16 = ea.k1(qQAppInterface.getApp(), qQAppInterface.getAccount());
        int j16 = ea.j1(qQAppInterface.getApp(), qQAppInterface.getAccount());
        int f16 = AppSetting.f();
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, String.format("received QimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", Integer.valueOf(i19), Integer.valueOf(k16), Integer.valueOf(j16), Integer.valueOf(f16)));
        }
        if (j16 != f16) {
            ea.G4(qQAppInterface.getApp(), qQAppInterface.getAccount(), f16);
            k16 = 0;
        }
        if (i19 != k16) {
            String F = F(configurationService$Config, k16, 228);
            if (QLog.isColorLevel()) {
                QLog.d("QIMUserManager", 2, F);
            }
            if (!TextUtils.isEmpty(F)) {
                String str5 = "";
                String str6 = null;
                try {
                    Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(F.getBytes("utf-8")));
                    String nodeValue = parse.getElementsByTagName("avatar_switch").item(0).getFirstChild().getNodeValue();
                    String nodeValue2 = parse.getElementsByTagName("aio_title_bg_switch").item(0).getFirstChild().getNodeValue();
                    String nodeValue3 = parse.getElementsByTagName("aio_bubble_switch").item(0).getFirstChild().getNodeValue();
                    String nodeValue4 = parse.getElementsByTagName("theme_name").item(0).getFirstChild().getNodeValue();
                    try {
                        str2 = parse.getElementsByTagName("android_resource").item(0).getFirstChild().getNodeValue();
                    } catch (UnsupportedEncodingException e16) {
                        unsupportedEncodingException = e16;
                        str = null;
                        str2 = null;
                    } catch (IOException e17) {
                        iOException = e17;
                        str = null;
                        str2 = null;
                    } catch (NullPointerException e18) {
                        nullPointerException = e18;
                        str = null;
                        str2 = null;
                    } catch (NumberFormatException e19) {
                        numberFormatException = e19;
                        str = null;
                        str2 = null;
                    } catch (ParserConfigurationException e26) {
                        parserConfigurationException = e26;
                        str = null;
                        str2 = null;
                    } catch (SAXException e27) {
                        sAXException = e27;
                        str = null;
                        str2 = null;
                    }
                    try {
                        str6 = parse.getElementsByTagName("android_md5").item(0).getFirstChild().getNodeValue();
                        NodeList elementsByTagName = parse.getElementsByTagName("qim_website");
                        if (elementsByTagName != null && elementsByTagName.getLength() > 0 && (firstChild = elementsByTagName.item(0).getFirstChild()) != null) {
                            str5 = firstChild.getNodeValue();
                        }
                        if (!TextUtils.isEmpty(nodeValue) && !TextUtils.isEmpty(nodeValue2) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str6) && !TextUtils.isEmpty(nodeValue4) && !TextUtils.isEmpty(nodeValue3)) {
                            i3 = Integer.valueOf(nodeValue).intValue();
                            try {
                                i16 = Integer.valueOf(nodeValue2).intValue();
                            } catch (UnsupportedEncodingException e28) {
                                unsupportedEncodingException = e28;
                                str = str6;
                                i16 = 0;
                            } catch (IOException e29) {
                                iOException = e29;
                                str = str6;
                                i16 = 0;
                            } catch (NullPointerException e36) {
                                nullPointerException = e36;
                                str = str6;
                                i16 = 0;
                            } catch (NumberFormatException e37) {
                                numberFormatException = e37;
                                str = str6;
                                i16 = 0;
                            } catch (ParserConfigurationException e38) {
                                parserConfigurationException = e38;
                                str = str6;
                                i16 = 0;
                            } catch (SAXException e39) {
                                sAXException = e39;
                                str = str6;
                                i16 = 0;
                            }
                            try {
                                i18 = Integer.valueOf(nodeValue3).intValue();
                                if (i3 >= 0 && i3 <= 1 && i16 >= 0 && i16 <= 1 && i18 >= 0 && i18 <= 1) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                            } catch (UnsupportedEncodingException e46) {
                                unsupportedEncodingException = e46;
                                str = str6;
                                str6 = nodeValue4;
                                if (QLog.isColorLevel()) {
                                    QLog.d("QIMUserManager", 2, unsupportedEncodingException, new Object[0]);
                                }
                                str3 = str;
                                str4 = str6;
                                z16 = false;
                                i17 = 0;
                                String str7 = str2;
                                int i26 = i3;
                                String str8 = str5;
                                if (z16) {
                                }
                            } catch (IOException e47) {
                                iOException = e47;
                                str = str6;
                                str6 = nodeValue4;
                                if (QLog.isColorLevel()) {
                                    QLog.d("QIMUserManager", 2, iOException, new Object[0]);
                                }
                                str3 = str;
                                str4 = str6;
                                z16 = false;
                                i17 = 0;
                                String str72 = str2;
                                int i262 = i3;
                                String str82 = str5;
                                if (z16) {
                                }
                            } catch (NullPointerException e48) {
                                nullPointerException = e48;
                                str = str6;
                                str6 = nodeValue4;
                                if (QLog.isColorLevel()) {
                                    QLog.d("QIMUserManager", 2, nullPointerException, new Object[0]);
                                }
                                str3 = str;
                                str4 = str6;
                                z16 = false;
                                i17 = 0;
                                String str722 = str2;
                                int i2622 = i3;
                                String str822 = str5;
                                if (z16) {
                                }
                            } catch (NumberFormatException e49) {
                                numberFormatException = e49;
                                str = str6;
                                str6 = nodeValue4;
                                if (QLog.isColorLevel()) {
                                    QLog.d("QIMUserManager", 2, numberFormatException, new Object[0]);
                                }
                                str3 = str;
                                str4 = str6;
                                z16 = false;
                                i17 = 0;
                                String str7222 = str2;
                                int i26222 = i3;
                                String str8222 = str5;
                                if (z16) {
                                }
                            } catch (ParserConfigurationException e56) {
                                parserConfigurationException = e56;
                                str = str6;
                                str6 = nodeValue4;
                                if (QLog.isColorLevel()) {
                                    QLog.d("QIMUserManager", 2, parserConfigurationException, new Object[0]);
                                }
                                str3 = str;
                                str4 = str6;
                                z16 = false;
                                i17 = 0;
                                String str72222 = str2;
                                int i262222 = i3;
                                String str82222 = str5;
                                if (z16) {
                                }
                            } catch (SAXException e57) {
                                sAXException = e57;
                                str = str6;
                                str6 = nodeValue4;
                                if (QLog.isColorLevel()) {
                                    QLog.d("QIMUserManager", 2, sAXException, new Object[0]);
                                }
                                str3 = str;
                                str4 = str6;
                                z16 = false;
                                i17 = 0;
                                String str722222 = str2;
                                int i2622222 = i3;
                                String str822222 = str5;
                                if (z16) {
                                }
                            }
                        } else {
                            i18 = 0;
                            i3 = 0;
                            z16 = false;
                            i16 = 0;
                        }
                        i17 = i18;
                        str3 = str6;
                        str4 = nodeValue4;
                    } catch (UnsupportedEncodingException e58) {
                        unsupportedEncodingException = e58;
                        str = str6;
                        i3 = 0;
                        i16 = 0;
                        str6 = nodeValue4;
                        if (QLog.isColorLevel()) {
                        }
                        str3 = str;
                        str4 = str6;
                        z16 = false;
                        i17 = 0;
                        String str7222222 = str2;
                        int i26222222 = i3;
                        String str8222222 = str5;
                        if (z16) {
                        }
                    } catch (IOException e59) {
                        iOException = e59;
                        str = str6;
                        i3 = 0;
                        i16 = 0;
                        str6 = nodeValue4;
                        if (QLog.isColorLevel()) {
                        }
                        str3 = str;
                        str4 = str6;
                        z16 = false;
                        i17 = 0;
                        String str72222222 = str2;
                        int i262222222 = i3;
                        String str82222222 = str5;
                        if (z16) {
                        }
                    } catch (NullPointerException e65) {
                        nullPointerException = e65;
                        str = str6;
                        i3 = 0;
                        i16 = 0;
                        str6 = nodeValue4;
                        if (QLog.isColorLevel()) {
                        }
                        str3 = str;
                        str4 = str6;
                        z16 = false;
                        i17 = 0;
                        String str722222222 = str2;
                        int i2622222222 = i3;
                        String str822222222 = str5;
                        if (z16) {
                        }
                    } catch (NumberFormatException e66) {
                        numberFormatException = e66;
                        str = str6;
                        i3 = 0;
                        i16 = 0;
                        str6 = nodeValue4;
                        if (QLog.isColorLevel()) {
                        }
                        str3 = str;
                        str4 = str6;
                        z16 = false;
                        i17 = 0;
                        String str7222222222 = str2;
                        int i26222222222 = i3;
                        String str8222222222 = str5;
                        if (z16) {
                        }
                    } catch (ParserConfigurationException e67) {
                        parserConfigurationException = e67;
                        str = str6;
                        i3 = 0;
                        i16 = 0;
                        str6 = nodeValue4;
                        if (QLog.isColorLevel()) {
                        }
                        str3 = str;
                        str4 = str6;
                        z16 = false;
                        i17 = 0;
                        String str72222222222 = str2;
                        int i262222222222 = i3;
                        String str82222222222 = str5;
                        if (z16) {
                        }
                    } catch (SAXException e68) {
                        sAXException = e68;
                        str = str6;
                        i3 = 0;
                        i16 = 0;
                        str6 = nodeValue4;
                        if (QLog.isColorLevel()) {
                        }
                        str3 = str;
                        str4 = str6;
                        z16 = false;
                        i17 = 0;
                        String str722222222222 = str2;
                        int i2622222222222 = i3;
                        String str822222222222 = str5;
                        if (z16) {
                        }
                    }
                } catch (UnsupportedEncodingException e69) {
                    unsupportedEncodingException = e69;
                    str = null;
                    str2 = null;
                    i3 = 0;
                    i16 = 0;
                } catch (IOException e75) {
                    iOException = e75;
                    str = null;
                    str2 = null;
                    i3 = 0;
                    i16 = 0;
                } catch (NullPointerException e76) {
                    nullPointerException = e76;
                    str = null;
                    str2 = null;
                    i3 = 0;
                    i16 = 0;
                } catch (NumberFormatException e77) {
                    numberFormatException = e77;
                    str = null;
                    str2 = null;
                    i3 = 0;
                    i16 = 0;
                } catch (ParserConfigurationException e78) {
                    parserConfigurationException = e78;
                    str = null;
                    str2 = null;
                    i3 = 0;
                    i16 = 0;
                } catch (SAXException e79) {
                    sAXException = e79;
                    str = null;
                    str2 = null;
                    i3 = 0;
                    i16 = 0;
                }
                String str7222222222222 = str2;
                int i26222222222222 = i3;
                String str8222222222222 = str5;
                if (z16) {
                    String k3 = com.tencent.mobileqq.activity.aio.qim.a.i().k(qQAppInterface);
                    String j3 = com.tencent.mobileqq.activity.aio.qim.a.i().j(qQAppInterface);
                    if (k3.equals(str7222222222222) && j3.equals(str3)) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    com.tencent.mobileqq.activity.aio.qim.a.i().o(i26222222222222, i16, str7222222222222, str8222222222222, str3, str4, z17, i17);
                    ea.F4(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), i19, i26222222222222, i16, str7222222222222, str3, str8222222222222, str4, z17, i17);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 228,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        }
    }

    public static void n(QQAppInterface qQAppInterface, int i3, String str) {
        boolean z16;
        if (!qQAppInterface.isLogin() && i3 == 215) {
            z16 = true;
        } else {
            z16 = false;
        }
        am.m(new int[]{i3}, str, z16);
    }

    public static void n0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3 = configurationService$Config.version.get();
        int m16 = ea.m1(BaseApplication.getContext(), f202907b);
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig: ,version: " + configurationService$Config.version.get() + "| localVersion: " + m16);
        }
        if (i3 != m16) {
            ea.J4(BaseApplication.getContext(), f202907b, i3);
            List<String> X0 = X0(configurationService$Config);
            if (X0 != null && X0.size() > 0) {
                Iterator<String> it = X0.iterator();
                while (it.hasNext()) {
                    try {
                        JSONObject jSONObject = new JSONObject(it.next());
                        if (jSONObject.has("kReceiptMsgEnable")) {
                            ea.I4(BaseApplication.getContext(), f202907b, "receipt_kReceiptMsgEnable", jSONObject.getInt("kReceiptMsgEnable"));
                        }
                        if (jSONObject.has("kReceiptMsgMaxSendTimes")) {
                            ea.I4(BaseApplication.getContext(), f202907b, "receipt_kReceiptMsgSendTimes", jSONObject.getInt("kReceiptMsgMaxSendTimes"));
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
        }
    }

    public static void o(QQAppInterface qQAppInterface, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            com.tencent.mobileqq.nearby.l.b("GENERAL_LBS_CONFIGS_CMD", "getGeneralLBSConfigs", str, Long.valueOf(currentTimeMillis));
        }
        am.l(new int[]{12, 174, 189}, str);
    }

    private void o0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3 = configurationService$Config.version.get();
        int n16 = ea.n1(qQAppInterface.getApp(), qQAppInterface.getAccount());
        if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, "received RedBagFoldMsgConfig remote version: " + i3 + " | localVersion: " + n16);
        }
        PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
        if (pBRepeatField != null && pBRepeatField.size() > 0) {
            String str = configurationService$Config.content_list.get(0);
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 69,content: " + str + ",version: " + configurationService$Config.version.get());
            }
            if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, "received RedBagFoldMsgConfig content: " + str);
            }
            if (i3 != n16) {
                com.tencent.mobileqq.managers.g.j(qQAppInterface, i3, str);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 69,content_list is empty ,version: " + configurationService$Config.version.get());
        }
        if (i3 == n16) {
            if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, ignored because of SAME VERSION");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, use default config");
        }
        com.tencent.mobileqq.managers.g gVar = (com.tencent.mobileqq.managers.g) qQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
        gVar.f243714e = true;
        gVar.f243715f = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
        gVar.f243716h = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
        gVar.f243717i = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
        gVar.f243718m = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
        ea.K4(qQAppInterface.getApp(), qQAppInterface.getAccount(), i3, gVar.f243715f, gVar.f243716h, gVar.f243717i, gVar.f243718m);
    }

    public static void p(QQAppInterface qQAppInterface, String str, int i3) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            if (i3 != -1 && ea.j0(qQAppInterface.getApp()) == i3) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY, 2, "HOTCHAT_SCENE_CONFIGS_CMD, same version " + i3);
                    return;
                }
                return;
            }
            n(qQAppInterface, 49, str);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.NEARBY, 2, "HOTCHAT_SCENE_CONFIGS_CMD, " + i3);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.NEARBY, 2, "HOTCHAT_SCENE_CONFIGS_CMD, app is null, or uin is empty");
        }
    }

    private void p0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "handleRespClassicHeadConfig|type= " + configurationService$Config.type.get());
        }
        int i3 = configurationService$Config.version.get();
        if (i3 == ea.y(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin())) {
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "ClassicHeadConfig serverVersion is equals to localVersion ");
                return;
            }
            return;
        }
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "ClassicHeadConfig size:" + configurationService$Config.msg_content_list.size() + "ClassicHeadConfig content:" + configurationService$Config.msg_content_list.get(0));
            }
            ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
            if (configurationService$Content != null) {
                String str2 = null;
                if (configurationService$Content.compress.get() == 1) {
                    byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                    if (d16 != null) {
                        try {
                            stringUtf8 = new String(d16, "UTF-8");
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "Throwable:" + th5.getMessage());
                            }
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "inflateConfigString error!");
                    }
                    stringUtf8 = null;
                } else {
                    stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                }
                if (stringUtf8 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead xmlContent = " + stringUtf8);
                    }
                    XmlPullParser newPullParser = Xml.newPullParser();
                    try {
                        newPullParser.setInput(new ByteArrayInputStream(stringUtf8.getBytes()), "utf-8");
                        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                            if (eventType == 2) {
                                String name = newPullParser.getName();
                                if (name != null && name.equalsIgnoreCase("beginTime")) {
                                    str = newPullParser.nextText();
                                } else if (name != null && name.equalsIgnoreCase("endTime")) {
                                    str = str2 + "|" + newPullParser.nextText();
                                }
                                str2 = str;
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead entrence:" + str2);
                        }
                        if (str2 != null && str2.length() > 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead getContent success");
                            }
                            ea.F3(qQAppInterface.getApp(), i3, qQAppInterface.getCurrentAccountUin(), str2);
                            com.tencent.mobileqq.app.utils.b bVar = (com.tencent.mobileqq.app.utils.b) qQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
                            if (bVar != null) {
                                bVar.i();
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SPLASH_ConfigServlet", 2, "ClassicHeadConfig appear exception:", e16);
                        }
                    }
                }
            }
        }
    }

    public static void q(QQAppInterface qQAppInterface) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "onSend configXml request");
        }
    }

    public static void q0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3 = configurationService$Config.version.get();
        int E0 = ea.E0(BaseApplication.getContext(), f202907b);
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig: ,version: " + configurationService$Config.version.get() + "| localVersion: " + E0);
        }
        if (i3 != E0) {
            ea.t4(BaseApplication.getContext(), i3, f202907b);
            List<String> X0 = X0(configurationService$Config);
            if (X0 != null && X0.size() > 0) {
                com.tencent.mobileqq.mutualmark.oldlogic.a.j(qQAppInterface, X0.get(0));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig:localVersiont == version ");
        }
    }

    public static void r(QQAppInterface qQAppInterface, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("AEOldShortVideoResManager", 2, "getOldShortVideoResourceConfig| getType=" + i3);
        }
        AEOldShortVideoResManager.f394453i = System.currentTimeMillis();
        n(qQAppInterface, 215, null);
    }

    public static void s(QQAppInterface qQAppInterface, String str) {
        n(qQAppInterface, 185, str);
    }

    private void s0(QQAppInterface qQAppInterface, Intent intent, ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfig", 2, "handleResp_GetArGlobalConfig |  type= " + configurationService$Config.type.get());
        }
        ARGlobalConfigManager aRGlobalConfigManager = (ARGlobalConfigManager) qQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
        if (configurationService$Config.type.get() == 188) {
            if (intent.getIntExtra("ar_global_key_config_version", 0) != configurationService$Config.version.get()) {
                PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
                if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                    ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                    if (configurationService$Content != null) {
                        if (configurationService$Content.compress.get() == 1) {
                            byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                            stringUtf8 = null;
                            if (d16 != null) {
                                try {
                                    str = new String(d16, "UTF-8");
                                } catch (UnsupportedEncodingException e16) {
                                    if (QLog.isColorLevel()) {
                                        e16.printStackTrace();
                                    }
                                } catch (OutOfMemoryError e17) {
                                    if (QLog.isColorLevel()) {
                                        e17.printStackTrace();
                                    }
                                    System.gc();
                                    try {
                                        str = new String(d16, "UTF-8");
                                    } catch (Throwable unused) {
                                    }
                                }
                                stringUtf8 = str;
                            }
                        } else {
                            stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                        }
                        if (stringUtf8 != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config_content is " + stringUtf8);
                            }
                            int i3 = configurationService$Config.version.get();
                            if (aRGlobalConfigManager.l(stringUtf8)) {
                                aRGlobalConfigManager.k(i3);
                                aRGlobalConfigManager.j();
                            }
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, content is null");
                    }
                } else {
                    if (aRGlobalConfigManager != null) {
                        aRGlobalConfigManager.c();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "we delete ARConfig info here");
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, version same");
            }
            if (QLog.isColorLevel()) {
                QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config type 188");
            }
        }
    }

    public static void t(QQAppInterface qQAppInterface, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("ShortVideoResourceManager", 2, "getShortVideoResourceConfig| getType=" + i3);
        }
        ShortVideoResourceManager.f287682i = System.currentTimeMillis();
    }

    public static void u(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3 = configurationService$Config.version.get();
        int k3 = ea.k(BaseApplication.getContext(), f202907b);
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleAIOConfig: ,version: " + configurationService$Config.version.get() + "| localVersion: " + k3);
        }
        if (i3 != k3) {
            ea.v3(BaseApplication.getContext(), f202907b, i3);
            List<String> X0 = X0(configurationService$Config);
            if (X0 != null && X0.size() > 0) {
                try {
                    ea.u3(BaseApplication.getContext(), f202907b, "aio_config_key", X0.get(X0.size() - 1));
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
        }
    }

    private void u0(QQAppInterface qQAppInterface, Intent intent, ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        PtvTemplateManager h16 = PtvTemplateManager.h(qQAppInterface);
        int i3 = configurationService$Config.version.get();
        int t16 = ea.t(qQAppInterface.getApp());
        if (!PtvTemplateManager.n()) {
            t16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PtvTemplateManager", 2, "GetBlessSpecialPendantConfig serverVersion=" + i3 + "|localVersion=" + t16);
        }
        if (i3 != t16) {
            ea.A2(qQAppInterface.getApp(), i3);
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                if (configurationService$Content != null) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                        if (d16 != null) {
                            try {
                                stringUtf8 = new String(d16, "UTF-8");
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                        stringUtf8 = null;
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    h16.l(stringUtf8, qQAppInterface);
                    if (QLog.isColorLevel()) {
                        QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 145,content: " + stringUtf8 + ",version: " + configurationService$Config.version.get());
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 145,content_list is empty ,version: " + configurationService$Config.version.get());
            }
        }
    }

    private void v(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
        if (pBRepeatField != null && pBRepeatField.size() > 0) {
            IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
            if (configurationService$Config.content_list.size() > 0) {
                String str = configurationService$Config.content_list.get(0);
                int i3 = configurationService$Config.version.get();
                int i16 = iPhoneContactService.getsAllEntranceConfigVersion();
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 97,content: " + str + ",version: " + configurationService$Config.version.get());
                }
                if (i3 != i16 || configurationService$Config.content_list.size() > 0) {
                    iPhoneContactService.updateAllEntranceConfig(i3, str);
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 97,content_list is empty ,version: " + configurationService$Config.version.get());
        }
    }

    private void v0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3;
        PtvTemplateManager h16 = PtvTemplateManager.h(qQAppInterface);
        int i16 = configurationService$Config.version.get();
        int P = ea.P(qQAppInterface.getApp());
        if (!PtvTemplateManager.o()) {
            P = 0;
        }
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
        if (pBRepeatMessageField != null) {
            i3 = pBRepeatMessageField.size();
        } else {
            i3 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, String.format("\u4e2a\u6027\u7b14\u89e6\u914d\u7f6e\u56de\u5305, serverVersion[%s], localVersion[%s], size[%s]", Integer.valueOf(i16), Integer.valueOf(P), Integer.valueOf(i3)));
        }
        if (i16 == P) {
            return;
        }
        if (i3 > 0) {
            String F = F(configurationService$Config, P, 139);
            if (!TextUtils.isEmpty(F)) {
                h16.k(F, qQAppInterface);
                ea.H2(qQAppInterface.getApp(), i16);
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServletDoodle_Strokes_", 2, "GetDoodleTemplateConfig|type: \u4e2a\u6027\u7b14\u89e6\u914d\u7f6e\u56de\u5305\u5185\u5bb9, content: \n" + F);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: \u4e2a\u6027\u7b14\u89e6\u914d\u7f6e\u56de\u5305\u5185\u5bb9\u4e3a\u7a7a");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: \u4e2a\u6027\u7b14\u89e6\u914d\u7f6e\u56de\u5305\u4e3a\u7a7a");
        }
        h16.d();
    }

    private void w(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        List<String> list;
        ea.w3(qQAppInterface.getApplication(), configurationService$Config.version.get(), f202907b);
        PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
        if (pBRepeatField != null && pBRepeatField.size() > 0) {
            list = configurationService$Config.content_list.get();
        } else {
            list = null;
        }
        if (list != null && list.size() > 0) {
            String str = list.get(0);
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 102,content: " + str + ",version: " + configurationService$Config.version.get());
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
                    for (int i3 = 0; i3 != 1; i3 = newPullParser.next()) {
                        if (i3 == 2) {
                            if (newPullParser.getName().equalsIgnoreCase("JA_Switch")) {
                                JumpActivity.initJASwitch(newPullParser.nextText(), true);
                            }
                        }
                    }
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 102,content_list is empty ,version: " + configurationService$Config.version.get());
        }
    }

    private void w0(final QQAppInterface qQAppInterface, Intent intent, ConfigurationService$Config configurationService$Config) {
        String str;
        String str2;
        final String str3;
        if (!TextUtils.isEmpty(intent.getStringExtra("key_uin"))) {
            int i3 = configurationService$Config.version.get();
            int C0 = ea.C0(qQAppInterface.getApp());
            int i16 = 2;
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "serverVersion=" + i3 + "|localVersion=" + C0);
            }
            if (i3 != C0) {
                ea.Z2(qQAppInterface.getApp(), i3);
                final NearbyGrayTipsManager nearbyGrayTipsManager = (NearbyGrayTipsManager) qQAppInterface.getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER);
                if (configurationService$Config.content_list.has() && configurationService$Config.content_list.get().size() > 0) {
                    List<String> list = configurationService$Config.content_list.get();
                    if (list != null && QLog.isColorLevel()) {
                        QLog.d(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "config.content_list size=" + list.size());
                    }
                    if (list != null && list.size() > 0) {
                        nearbyGrayTipsManager.a();
                        for (String str4 : list) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", i16, "receiveAllConfigs|type: 23,content: " + str4 + ",version: " + configurationService$Config.version.get());
                            }
                            if (!StringUtil.isEmpty(str4)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str4);
                                    if (!jSONObject.isNull(KeyPropertiesCompact.DIGEST_MD5)) {
                                        String string = jSONObject.getString(KeyPropertiesCompact.DIGEST_MD5);
                                        if (!TextUtils.isEmpty(string)) {
                                            string = string.toLowerCase();
                                        }
                                        str2 = string;
                                    } else {
                                        str2 = null;
                                    }
                                    if (!jSONObject.isNull(Global.TRACKING_URL)) {
                                        str3 = jSONObject.getString(Global.TRACKING_URL);
                                    } else {
                                        str3 = null;
                                    }
                                    if (!StringUtil.isEmpty(str3)) {
                                        final File file = new File(NearbyGrayTipsManager.b() + "temp.txt");
                                        final String str5 = str2;
                                        str = str4;
                                        try {
                                            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.config.splashlogo.ConfigServlet.6
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        if (HttpDownloadUtil.download(qQAppInterface, str3, file)) {
                                                            if (QLog.isColorLevel()) {
                                                                QLog.d(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "file download succeed. url=" + str3);
                                                            }
                                                            String fileMD5 = MD5.getFileMD5(file);
                                                            if (StringUtil.isEmpty(str5) || (fileMD5 != null && str5.equals(fileMD5.toLowerCase()))) {
                                                                NearbyGrayTipsManager.GrayTipsConfig g16 = NearbyGrayTipsManager.g(file);
                                                                if (g16 != null) {
                                                                    nearbyGrayTipsManager.z(g16);
                                                                    nearbyGrayTipsManager.y(g16, true);
                                                                    nearbyGrayTipsManager.w(g16, true);
                                                                    NearbyGrayTipsManager.v(g16);
                                                                }
                                                                file.delete();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "file download failed. url=" + str3);
                                                        }
                                                    } catch (Exception e16) {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "download file exp=", e16);
                                                        }
                                                    }
                                                }
                                            }, 8, null, false);
                                        } catch (JSONException e16) {
                                            e = e16;
                                            if (QLog.isColorLevel()) {
                                                QLog.d(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "JSONException was thrown when parse json!!! string=" + str);
                                            }
                                            e.printStackTrace();
                                            i16 = 2;
                                        }
                                    }
                                } catch (JSONException e17) {
                                    e = e17;
                                    str = str4;
                                }
                            }
                            i16 = 2;
                        }
                        nearbyGrayTipsManager.x();
                        nearbyGrayTipsManager.n(true);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 23,content_list is empty ,version: " + configurationService$Config.version.get());
                }
                nearbyGrayTipsManager.a();
            }
        }
    }

    private void x0(QQAppInterface qQAppInterface, Intent intent, ConfigurationService$Config configurationService$Config) {
        CapturePtvTemplateManager e16 = CapturePtvTemplateManager.e();
        int i3 = configurationService$Config.version.get();
        int B0 = ea.B0(qQAppInterface.getApp());
        if (!CapturePtvTemplateManager.j()) {
            B0 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager_VideoRedbag", 2, "serverVersion=" + i3 + "|localVersion=" + B0);
        }
        if (i3 != B0) {
            ea.Y2(qQAppInterface.getApp(), i3);
            try {
                String F = F(configurationService$Config, B0, 226);
                if (F != null) {
                    e16.f(qQAppInterface, F, 1);
                    if (QLog.isColorLevel()) {
                        QLog.d("CapturePtvTemplateManager", 2, "receiveAllConfigs|type: 226,content: " + F + ",version: " + configurationService$Config.version.get());
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("CapturePtvTemplateManager", 2, "receiveAllConfigs|type: 226,content_list is empty ,version: " + configurationService$Config.version.get());
                }
                e16.f(qQAppInterface, "", 1);
            } catch (OutOfMemoryError e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("CapturePtvTemplateManager", 2, "receiveAllConfigs|exception:" + e17.getMessage());
                }
            }
        }
    }

    private void y0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        ConfigurationService$Content configurationService$Content;
        String str;
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
        String str2 = null;
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0 && (configurationService$Content = configurationService$Config.msg_content_list.get(0)) != null) {
            if (configurationService$Content.compress.get() == 1) {
                byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                if (d16 != null) {
                    try {
                        str = new String(d16, "UTF-8");
                    } catch (UnsupportedEncodingException e16) {
                        if (QLog.isColorLevel()) {
                            e16.printStackTrace();
                        }
                    } catch (OutOfMemoryError e17) {
                        if (QLog.isColorLevel()) {
                            e17.printStackTrace();
                        }
                        System.gc();
                        try {
                            str = new String(d16, "UTF-8");
                        } catch (Throwable unused) {
                        }
                    }
                    str2 = str;
                }
            } else {
                str2 = configurationService$Content.content.get().toStringUtf8();
            }
        }
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(IPtvFilterUtil.DynamicAdjustmentTag, 4).edit();
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "SVDNAdjustment config : " + str2);
                }
                JSONObject jSONObject = new JSONObject(str2).getJSONObject("SVDNAdjustment").getJSONArray(Constants.Configs.CONFIGS).getJSONObject(0).getJSONObject(DownloadInfo.spKey_Config);
                edit.putFloat("SVDNAdjustment_data_type", (float) jSONObject.optDouble("data_type", 0.5d));
                edit.putInt("SVDNAdjustment_max_downmark", jSONObject.optInt("max_downmark", 2));
                edit.putInt("SVDNAdjustment_max_upmark", jSONObject.optInt("max_upmark", 2));
                edit.putInt("SVDNAdjustment_up_threshold_base", jSONObject.optInt("up_threshold_base", 11));
                edit.putInt("SVDNAdjustment_down_threshold_base", jSONObject.optInt("down_threshold_base", 25));
                edit.putInt("SVDNAdjustment_quality_up_threshold", jSONObject.optInt("up_threshold_base", 11));
                edit.putInt("SVDNAdjustment_quality_down_threshold", jSONObject.optInt("down_threshold_base", 25));
                edit.putFloat("SVDNAdjustment_up_threshold_coefficient", (float) jSONObject.optDouble("up_threshold_coefficient", 0.7d));
                edit.putFloat("SVDNAdjustment_down_threshold_coefficient", (float) jSONObject.optDouble("down_threshold_coefficient", 1.3d));
                edit.commit();
            }
        } catch (Exception e18) {
            if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServlet", 2, "error: " + e18.toString());
            }
            e18.printStackTrace();
        }
        ((IVideoFilterTools) QRoute.api(IVideoFilterTools.class)).handleQQShortVideoCommonConfig(str2);
        ea.O4(qQAppInterface.getApp(), configurationService$Config.version.get(), f202907b);
    }

    void A(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField;
        ConfigurationService$Content configurationService$Content;
        String stringUtf8;
        if (configurationService$Config.type.get() != 165) {
            return;
        }
        int u16 = ea.u(qQAppInterface.getApp(), f202907b);
        int i3 = configurationService$Config.version.get();
        if (u16 != i3 && (pBRepeatMessageField = configurationService$Config.msg_content_list) != null && pBRepeatMessageField.size() > 0 && (configurationService$Content = configurationService$Config.msg_content_list.get(0)) != null) {
            if (configurationService$Content.compress.get() == 1) {
                byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                stringUtf8 = null;
                if (d16 != null) {
                    try {
                        stringUtf8 = new String(d16, "UTF-8");
                    } catch (Exception unused) {
                        QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoConfig|uncompress failed");
                    }
                }
            } else {
                stringUtf8 = configurationService$Content.content.get().toStringUtf8();
            }
            if (stringUtf8 != null) {
                try {
                    boolean z16 = new JSONObject(stringUtf8).getBoolean("isShowBuluoNumRedDot");
                    ea.B3(qQAppInterface.getApp(), f202907b, i3);
                    ea.j4(qQAppInterface.getApp(), f202907b, z16);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    void A0(final QQAppInterface qQAppInterface, final ConfigurationService$Config configurationService$Config) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.config.splashlogo.ConfigServlet.9
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                String stringUtf8;
                String str;
                ScribbleResMgr L = ScribbleResMgr.L();
                int i16 = configurationService$Config.version.get();
                int r16 = ea.r1(qQAppInterface.getApp());
                PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
                if (pBRepeatMessageField != null) {
                    i3 = pBRepeatMessageField.size();
                } else {
                    i3 = -1;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("handleScribbleConfigSPLASH_ConfigServlet", 2, String.format("scribble\u56de\u5305, serverVersion[%s], localVersion[%s], size[%s]", Integer.valueOf(i16), Integer.valueOf(r16), Integer.valueOf(i3)));
                }
                if (i16 == r16) {
                    return;
                }
                if (i3 > 0) {
                    boolean z16 = false;
                    boolean z17 = false;
                    for (int i17 = 0; i17 < i3; i17++) {
                        ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(i17);
                        if (configurationService$Content != null) {
                            int i18 = configurationService$Content.task_id.get();
                            if (configurationService$Content.compress.get() == 1) {
                                byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                                stringUtf8 = null;
                                if (d16 == null) {
                                    QLog.d("handleScribbleConfigSPLASH_ConfigServlet", 2, "\u89e3\u538b\u9519\u8bef");
                                } else {
                                    try {
                                        str = new String(d16, "UTF-8");
                                    } catch (UnsupportedEncodingException e16) {
                                        if (QLog.isColorLevel()) {
                                            e16.printStackTrace();
                                        }
                                    } catch (OutOfMemoryError e17) {
                                        if (QLog.isColorLevel()) {
                                            e17.printStackTrace();
                                        }
                                        System.gc();
                                        try {
                                            str = new String(d16, "UTF-8");
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    stringUtf8 = str;
                                }
                            } else {
                                stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                            }
                            if (!TextUtils.isEmpty(stringUtf8)) {
                                if (i18 != 2599 && i18 != 4446) {
                                    if (i18 == 2598 || i18 == 4448) {
                                        z17 = L.M(stringUtf8, qQAppInterface, 2598);
                                    }
                                } else {
                                    z16 = L.M(stringUtf8, qQAppInterface, 2599);
                                }
                            }
                        }
                    }
                    if (z16 && z17) {
                        ea.P4(qQAppInterface.getApp().getBaseContext(), i16);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("handleScribbleConfigSPLASH_ConfigServlet", 2, "\u56de\u5305\u4e3a\u7a7a");
                }
                L.T();
            }
        });
    }

    public void B(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3 = configurationService$Config.version.get();
        int P1 = ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.BULUO_ENTER_CONFIG_VERSION, f202907b);
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig: ,version: " + configurationService$Config.version.get() + "| localVersion: " + P1);
        }
        if (i3 != P1) {
            List<String> X0 = X0(configurationService$Config);
            if (X0 != null && X0.size() > 0) {
                String str = X0.get(0);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("jump_url")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("jump_url");
                        if (jSONObject2.has("android")) {
                            JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("android"));
                            if (jSONObject3.has("url") && jSONObject3.has(ZPlanPublishSource.FROM_SCHEME)) {
                                String str2 = jSONObject3.getString(ZPlanPublishSource.FROM_SCHEME) + PluginBaseInfoHelper.Base64Helper.encodeToString(jSONObject3.getString("url").getBytes(), 0);
                                ea.A3(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), str2);
                                if (QLog.isColorLevel()) {
                                    QLog.e("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig. buluoEntryUrl: ", str2);
                                }
                            }
                        }
                    } else if (jSONObject.has("tribe_summary_url")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("tribe_summary_url");
                        if (optJSONObject.has("android")) {
                            ea.C3(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), optJSONObject.optString("android"));
                        }
                    }
                } catch (JSONException unused) {
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[2];
                        objArr[0] = "handleBuluoEnterConfig json fail. content: ";
                        if (str == null) {
                            str = "";
                        }
                        objArr[1] = str;
                        QLog.e("SPLASH_ConfigServlet", 2, objArr);
                    }
                }
                ea.l5(qQAppInterface.getApp(), AppConstants.Preferences.BULUO_ENTER_CONFIG_VERSION, f202907b, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig json fail. configContent is empty ,version: " + configurationService$Config.version.get());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig:localVersion == version = " + i3);
        }
    }

    void B0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        PBRepeatField<String> pBRepeatField;
        if (configurationService$Config.type.get() != 147) {
            return;
        }
        int P1 = ea.P1(qQAppInterface.getApp(), "shop_tab", f202907b);
        int i3 = configurationService$Config.version.get();
        if (P1 != i3 && (pBRepeatField = configurationService$Config.content_list) != null && pBRepeatField.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(configurationService$Config.content_list.get(0));
                boolean z16 = jSONObject.getBoolean("android");
                ea.l5(qQAppInterface.getApp(), "shop_tab", f202907b, i3);
                EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) qQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
                ecShopAssistantManager.s(z16);
                ecShopAssistantManager.f79575m = jSONObject.optBoolean("preload_web_process", false);
                ecShopAssistantManager.f79573h = jSONObject.optLong("stay_time", 5000L);
                ecShopAssistantManager.f79574i = jSONObject.optInt("day_limit", 3);
                EcShopAssistantManager.j().edit().putBoolean("preload_web", ecShopAssistantManager.f79575m).putLong("stayTime", ecShopAssistantManager.f79573h).putInt("dayLimit", ecShopAssistantManager.f79574i).commit();
                if (QLog.isColorLevel()) {
                    QLog.i("Ecshop", 2, "current config set tab show:" + z16 + ",preload:" + ecShopAssistantManager.f79575m + ",stayTime:" + ecShopAssistantManager.f79573h + ",dayLimit:" + ecShopAssistantManager.f79574i);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void C(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3 = configurationService$Config.version.get();
        if (i3 != qQAppInterface.getPreferences().getInt("call_tim_config_version", 0)) {
            List<String> X0 = X0(configurationService$Config);
            SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(AppConstants.Preferences.CALL_TIM_CONFIG_PRE + qQAppInterface.getCurrentUin(), 0).edit();
            if (X0 != null && X0.size() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(X0.get(0));
                    if (jSONObject.has("TIMFreeCloud")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("TIMFreeCloud");
                        if (jSONObject2.has("On")) {
                            edit.putBoolean(AppConstants.Preferences.CALL_TIM_CONFIG_SWITCH, "1".equals(jSONObject2.getString("On")));
                        }
                        if (jSONObject2.has("Title")) {
                            edit.putString(AppConstants.Preferences.CALL_TIM_CONFIG_TITLE, jSONObject2.getString("Title"));
                        }
                        if (jSONObject2.has("androidURL")) {
                            edit.putString(AppConstants.Preferences.CALL_TIM_CONFIG_URL, jSONObject2.getString("androidURL"));
                        }
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            } else {
                edit.putBoolean(AppConstants.Preferences.CALL_TIM_CONFIG_SWITCH, false);
            }
            edit.commit();
            SharedPreferences.Editor edit2 = qQAppInterface.getPreferences().edit();
            edit2.putInt("call_tim_config_version", i3);
            edit2.apply();
        }
    }

    protected void E(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config, String str, b bVar) {
        String stringUtf8;
        String str2;
        int i3 = configurationService$Config.version.get();
        int b16 = bVar.b();
        if (QLog.isColorLevel()) {
            QLog.d("TroopRankConfig", 2, str + ", serverVersion=" + i3 + "|localVersion=" + b16);
        }
        if (i3 != b16 && configurationService$Config.msg_content_list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = configurationService$Config.msg_content_list.size();
            for (int i16 = 0; i16 < size; i16++) {
                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                if (configurationService$Content != null) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                        stringUtf8 = null;
                        if (d16 != null) {
                            try {
                                str2 = new String(d16, "UTF-8");
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.w("SPLASH_ConfigServlet", 2, str, e16);
                                }
                            } catch (OutOfMemoryError e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.w("SPLASH_ConfigServlet", 2, str, e17);
                                }
                                System.gc();
                                try {
                                    str2 = new String(d16, "UTF-8");
                                } catch (Throwable th5) {
                                    if (QLog.isColorLevel()) {
                                        QLog.w("SPLASH_ConfigServlet", 2, str, th5);
                                    }
                                }
                            }
                            stringUtf8 = str2;
                        }
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    if (!TextUtils.isEmpty(stringUtf8)) {
                        arrayList.add(stringUtf8);
                    }
                }
            }
            if (arrayList.size() > 0) {
                bVar.c(i3);
                bVar.a(arrayList);
            } else if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, str + ", config_content is empty");
            }
        }
    }

    public void F0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        if (configurationService$Config.type.get() == 284 && qQAppInterface != null) {
            int P1 = ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.TASK_ENTRY_CONFIG_VERSION_CODE, f202907b);
            int i3 = configurationService$Config.version.get();
            if (QLog.isColorLevel()) {
                QLog.w("zivonchen", 2, "handleTaskEntryConfig reqVersion = " + P1);
            }
            if (P1 != i3) {
                SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(AppConstants.Preferences.TASK_ENTRY_CONFIG + f202907b, 0).edit();
                List<String> X0 = X0(configurationService$Config);
                if (X0 != null && X0.size() > 0) {
                    String str = X0.get(0);
                    if (QLog.isColorLevel()) {
                        QLog.w("zivonchen", 2, "handleTaskEntryConfig configJson = " + str);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String optString = jSONObject.optString("icon_url");
                        String optString2 = jSONObject.optString(AppConstants.Preferences.TASK_ENTRY_CONFIG_ICON_URL_FOR_NIGHT);
                        String optString3 = jSONObject.optString("jump_url");
                        String optString4 = jSONObject.optString("word");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3)) {
                            edit.putBoolean("open", true);
                            edit.putString("icon_url", optString);
                            edit.putString(AppConstants.Preferences.TASK_ENTRY_CONFIG_ICON_URL_FOR_NIGHT, optString2);
                            edit.putString("jump_url", optString3);
                            edit.putString("word", optString4);
                        } else {
                            edit.putBoolean("open", false);
                            edit.remove("icon_url");
                            edit.remove(AppConstants.Preferences.TASK_ENTRY_CONFIG_ICON_URL_FOR_NIGHT);
                            edit.remove("jump_url");
                            edit.remove("word");
                        }
                    } catch (JSONException unused) {
                        edit.clear();
                        if (QLog.isColorLevel()) {
                            Object[] objArr = new Object[2];
                            objArr[0] = "handleTaskEntryConfig json fail. content: ";
                            if (str == null) {
                                str = "";
                            }
                            objArr[1] = str;
                            QLog.e("zivonchen", 2, objArr);
                        }
                    }
                } else {
                    edit.clear();
                }
                ea.l5(qQAppInterface.getApp(), AppConstants.Preferences.TASK_ENTRY_CONFIG_VERSION_CODE, f202907b, i3);
                edit.commit();
            }
        }
    }

    void G(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        QLog.i("Contact.RecommendTabConfig", 1, String.format("receive handleContactRecommendTabConfig", new Object[0]));
        if (configurationService$Config.type.get() != 371) {
            return;
        }
        int H = ea.H(qQAppInterface.getApp(), f202907b);
        int i3 = configurationService$Config.version.get();
        if (H == i3) {
            QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, req-version equals to rsp-version, ver=%d", Integer.valueOf(H)));
            return;
        }
        String str = null;
        if (configurationService$Config.msg_content_list.size() > 0) {
            ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
            if (configurationService$Content != null) {
                if (configurationService$Content.compress.get() == 1) {
                    byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                    if (d16 != null) {
                        try {
                            str = new String(d16, "UTF-8");
                        } catch (Exception unused) {
                            QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, uncompress failed, buf-len=%d", Integer.valueOf(d16.length)));
                        }
                    }
                } else {
                    str = configurationService$Content.content.get().toStringUtf8();
                }
            } else {
                QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, content is null", new Object[0]));
            }
        } else {
            QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, msg content list is empty", new Object[0]));
        }
        if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleContactRecommendTabConfig config_content:" + str);
        }
        ea.N3(qQAppInterface.getApp(), f202907b, str);
        ea.O3(qQAppInterface.getApp(), f202907b, i3);
    }

    public void G0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3 = configurationService$Config.version.get();
        int i16 = qQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
        if (pBRepeatMessageField != null && !pBRepeatMessageField.isEmpty()) {
            if (i3 != i16) {
                qQAppInterface.getPreferences().edit().putInt("tim_aio_tips_bar_version", i3).apply();
                List<String> X0 = X0(configurationService$Config);
                if (X0 != null && X0.size() > 0) {
                    AppGuideTipsConfig appGuideTipsConfig = new AppGuideTipsConfig();
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "handleTimAIOTipsBar| Get Config ", 254, MsgSummary.STR_COLON, X0.get(0));
                        }
                        JSONObject jSONObject = new JSONObject(X0.get(0));
                        if (jSONObject.has("SendMessageAIOTopTip")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("SendMessageAIOTopTip");
                            appGuideTipsConfig.switchKey = jSONObject2.getString(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                            appGuideTipsConfig.maxCount = Integer.valueOf(jSONObject2.getString("total")).intValue();
                            appGuideTipsConfig.duration = Long.valueOf(jSONObject2.getString("duration")).longValue();
                            appGuideTipsConfig.tipsUrl = jSONObject2.getString("androidURL");
                            appGuideTipsConfig.tipsMsg = jSONObject2.getString("title");
                            appGuideTipsConfig.msgTypeStr = jSONObject2.getString("androidtypes");
                            appGuideTipsConfig.aioTypeStr = jSONObject2.getString("androidAIOTypes");
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    AppGuideTipsManager appGuideTipsManager = (AppGuideTipsManager) qQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER);
                    appGuideTipsManager.l(appGuideTipsConfig);
                    appGuideTipsManager.j();
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "handleTimAIOTipsBar| config empty, delete config, version=", Integer.valueOf(i3));
        }
        qQAppInterface.getPreferences().edit().remove("tim_aio_tips_bar_version").apply();
        ((AppGuideTipsManager) qQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).g();
    }

    public void H0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        List<String> X0;
        int i3 = configurationService$Config.version.get();
        if (i3 != qQAppInterface.getPreferences().getInt("tim_login_jump", 0) && (X0 = X0(configurationService$Config)) != null && X0.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(X0.get(0));
                if (jSONObject.has("LoginedTipForTIM")) {
                    boolean z16 = false;
                    SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(AppConstants.Preferences.TIM_LOGIN_SHARED_PRE + qQAppInterface.getCurrentUin(), 0).edit();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("LoginedTipForTIM");
                    if (jSONObject2.has("On")) {
                        if (jSONObject2.getInt("On") == 1) {
                            z16 = true;
                        }
                        edit.putBoolean(AppConstants.Preferences.TIM_LOGIN_SWITCH, z16);
                    }
                    if (jSONObject2.has("ShowTipTimeIntervalAfterLogined")) {
                        edit.putInt(AppConstants.Preferences.TIM_LOGIN_SHOW_TIME_AFTER_LOGIN, jSONObject2.getInt("ShowTipTimeIntervalAfterLogined"));
                    }
                    if (jSONObject2.has("ShowTipDay")) {
                        edit.putString(AppConstants.Preferences.TIM_LOGIN_SHOW_TIPS_DAY, jSONObject2.getJSONArray("ShowTipDay").toString());
                    }
                    if (jSONObject2.has("ShowTipTime")) {
                        edit.putString(AppConstants.Preferences.TIM_LOGIN_SHOW_TIPS_TIME, jSONObject2.getJSONArray("ShowTipTime").toString());
                    }
                    if (jSONObject2.has("AndroidLimit")) {
                        edit.putInt(AppConstants.Preferences.TIM_LOGIN_ANDROID_LIMIT, jSONObject2.getInt("AndroidLimit"));
                    }
                    if (jSONObject2.has("ShowTipTotalCount")) {
                        edit.putInt(AppConstants.Preferences.TIM_LOGIN_TOTAL_COUNT, jSONObject2.getInt("ShowTipTotalCount"));
                    }
                    if (jSONObject2.has("ShowTipHourInterval")) {
                        edit.putInt(AppConstants.Preferences.TIM_LOGIN_SHOW_TIME_INTERVAL, jSONObject2.getInt("ShowTipHourInterval"));
                    }
                    if (jSONObject2.has("Title")) {
                        edit.putString(AppConstants.Preferences.TIM_LOGIN_TITLE, jSONObject2.getString("Title"));
                    }
                    if (jSONObject2.has("Message")) {
                        edit.putString(AppConstants.Preferences.TIM_LOGIN_CONTENT, jSONObject2.getString("Message"));
                    }
                    if (jSONObject2.has("Buttons")) {
                        edit.putString(AppConstants.Preferences.TIM_LOGIN_BTN_TEXT, jSONObject2.getJSONArray("Buttons").toString());
                    }
                    edit.commit();
                    SharedPreferences.Editor edit2 = qQAppInterface.getPreferences().edit();
                    edit2.putInt("tim_login_jump", i3);
                    edit2.apply();
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void I(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        List<String> X0;
        int i3 = configurationService$Config.version.get();
        if (i3 != cr2.a.e(qQAppInterface.getApp()) && (X0 = X0(configurationService$Config)) != null && X0.size() > 0) {
            cr2.a.p(X0.get(0), i3, qQAppInterface.getApp());
        }
    }

    public void I0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        List<String> X0;
        int i3 = configurationService$Config.version.get();
        boolean z16 = false;
        if (i3 != qQAppInterface.getPreferences().getInt("tim_pc_banner", 0) && (X0 = X0(configurationService$Config)) != null && X0.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(X0.get(0));
                if (jSONObject.has("PCTIMLoginBanner")) {
                    SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(AppConstants.Preferences.TIM_PC_BANNER_SHARED_PRE + qQAppInterface.getCurrentUin(), 0).edit();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("PCTIMLoginBanner");
                    if (jSONObject2.has("On")) {
                        if (jSONObject2.getInt("On") == 1) {
                            z16 = true;
                        }
                        edit.putBoolean(AppConstants.Preferences.TIM_PC_BANNER_SWITCH, z16);
                    }
                    if (jSONObject2.has("bannerURL")) {
                        edit.putString(AppConstants.Preferences.TIM_PC_BANNER_IMAGE_URL, jSONObject2.getString("bannerURL"));
                    }
                    if (jSONObject2.has("bannerVersion")) {
                        edit.putInt(AppConstants.Preferences.TIM_PC_BANNER_IMAGE_VER, jSONObject2.getInt("bannerVersion"));
                    }
                    if (jSONObject2.has("androidURL")) {
                        edit.putString(AppConstants.Preferences.TIM_PC_BANNER_CLICK_URL, jSONObject2.getString("androidURL"));
                    }
                    if (jSONObject2.has("linkText")) {
                        edit.putString(AppConstants.Preferences.TIM_PC_BANNER_LINK_TEXT, jSONObject2.getString("linkText"));
                    }
                    if (jSONObject2.has("androidLinkURL")) {
                        edit.putString(AppConstants.Preferences.TIM_PC_BANNER_LINK_URL, jSONObject2.getString("androidLinkURL"));
                    }
                    edit.commit();
                    SharedPreferences.Editor edit2 = qQAppInterface.getPreferences().edit();
                    edit2.putInt("tim_pc_banner", i3);
                    edit2.apply();
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void J(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int i3;
        String str;
        boolean z16;
        boolean z17;
        String str2;
        String str3;
        boolean z18;
        String str4;
        boolean z19;
        int i16 = configurationService$Config.version.get();
        if (i16 != qQAppInterface.getPreferences().getInt("data_migration_tim_version", 0)) {
            List<String> X0 = X0(configurationService$Config);
            SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences("data_migration_tim", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (X0 != null && X0.size() > 0) {
                i3 = i16;
                try {
                    str = "data_migration_tim_version";
                } catch (JSONException e16) {
                    e = e16;
                    str = "data_migration_tim_version";
                }
                try {
                    JSONObject jSONObject = new JSONObject(X0.get(0));
                    if (jSONObject.has("DataMigration")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("DataMigration");
                        if (jSONObject2.has(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH) && jSONObject2.getInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH) == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (jSONObject2.has("uninstall") && jSONObject2.getInt("uninstall") == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        String str5 = "";
                        if (!jSONObject2.has("title")) {
                            str2 = "";
                        } else {
                            str2 = jSONObject2.getString("title");
                        }
                        if (!jSONObject2.has("content")) {
                            str3 = "";
                        } else {
                            str3 = jSONObject2.getString("content");
                        }
                        if (jSONObject2.has("uninstallNotify")) {
                            if (jSONObject2.getInt("uninstallNotify") == 1) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            z18 = z19;
                        } else {
                            z18 = false;
                        }
                        if (!jSONObject2.has("uninstallTitle")) {
                            str4 = "";
                        } else {
                            str4 = jSONObject2.getString("uninstallTitle");
                        }
                        if (jSONObject2.has("uninstallContent")) {
                            str5 = jSONObject2.getString("uninstallContent");
                        }
                        String k16 = k1(sharedPreferences, qQAppInterface.getCurrentAccountUin(), z16);
                        if (TextUtils.isEmpty(k16)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "handleDataMigrationForTIM| remove all uins");
                            }
                            edit.clear();
                        } else {
                            edit.putString("data_migration_tim_uins", k16);
                            edit.putBoolean("data_migration_tim_uninstall_flag", z17);
                            edit.putString("data_migration_tim_title", str2);
                            edit.putString("data_migration_tim_content", str3);
                            edit.putBoolean("data_migration_tim_uninstall_notify", z18);
                            edit.putString("data_migration_tim_uninstall_title", str4);
                            edit.putString("data_migration_tim_uninstall_content", str5);
                        }
                    }
                } catch (JSONException e17) {
                    e = e17;
                    e.printStackTrace();
                    edit.apply();
                    SharedPreferences.Editor edit2 = qQAppInterface.getPreferences().edit();
                    edit2.putInt(str, i3);
                    edit2.apply();
                }
            } else {
                i3 = i16;
                str = "data_migration_tim_version";
                String k17 = k1(sharedPreferences, qQAppInterface.getCurrentAccountUin(), false);
                if (TextUtils.isEmpty(k17)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "handleDataMigrationForTIM| remove all uins");
                    }
                    edit.clear();
                } else {
                    edit.putString("data_migration_tim_uins", k17);
                }
            }
            edit.apply();
            SharedPreferences.Editor edit22 = qQAppInterface.getPreferences().edit();
            edit22.putInt(str, i3);
            edit22.apply();
        }
    }

    public void K0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        boolean z16;
        int i3 = configurationService$Config.version.get();
        if (i3 != qQAppInterface.getPreferences().getInt("tim_upgrade_hongdian_version", 0)) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean isAppInstalled = PackageUtil.isAppInstalled(qQAppInterface.getApp(), AppConstants.TIM_PACKAGE_NAME);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("TimUpgradeHondianManager", 2, "is install TIM = " + isAppInstalled + " time cost = " + (currentTimeMillis2 - currentTimeMillis));
            }
            if (!isAppInstalled) {
                List<String> X0 = X0(configurationService$Config);
                if (X0 != null && X0.size() > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(X0.get(0));
                        if (jSONObject.has("AboutTIMRedDot")) {
                            SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_PRE + qQAppInterface.getCurrentUin(), 0).edit();
                            JSONObject jSONObject2 = jSONObject.getJSONObject("AboutTIMRedDot");
                            if (jSONObject2.has("On")) {
                                if (jSONObject2.getInt("On") == 1) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                edit.putBoolean(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_SWITCH, z16);
                            }
                            if (jSONObject2.has("AboutTitle")) {
                                edit.putString(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_TITLE, jSONObject2.getString("AboutTitle"));
                            }
                            if (jSONObject2.has("AboutSubtitle")) {
                                edit.putString(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_SUB_TITLE, jSONObject2.getString("AboutSubtitle"));
                            }
                            if (jSONObject2.has("AndroidAboutURL")) {
                                String string = jSONObject2.getString("AndroidAboutURL");
                                edit.putString(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_URL, string);
                                ((UpgradeTIMManager) qQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_DOWNLOAD_MANAGER)).i(string);
                            }
                            edit.commit();
                            SharedPreferences.Editor edit2 = qQAppInterface.getPreferences().edit();
                            edit2.putInt("tim_upgrade_hongdian_version", i3);
                            edit2.apply();
                            return;
                        }
                        return;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                return;
            }
            ((com.tencent.mobileqq.managers.l) qQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER)).b();
        }
    }

    void N(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        ConfigurationService$Content configurationService$Content;
        String stringUtf8;
        if (configurationService$Config.type.get() != 247) {
            return;
        }
        int c06 = ea.c0(qQAppInterface.getApp(), f202907b);
        int i3 = configurationService$Config.version.get();
        if (QLog.isColorLevel()) {
            QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig reqVersion = " + c06 + ", version=" + i3);
        }
        if (c06 != i3) {
            ea.a4(qQAppInterface.getApp(), f202907b, i3);
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0 && (configurationService$Content = configurationService$Config.msg_content_list.get(0)) != null) {
                if (configurationService$Content.compress.get() == 1) {
                    byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                    stringUtf8 = null;
                    if (d16 != null) {
                        try {
                            stringUtf8 = new String(d16, "UTF-8");
                        } catch (Exception unused) {
                            if (QLog.isColorLevel()) {
                                QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig|uncompress failed");
                            }
                        }
                    }
                } else {
                    stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                }
                if (stringUtf8 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GreenVideo", 1, "handleGreenVideoConfig content : " + stringUtf8);
                    }
                    ea.b4(qQAppInterface.getApp(), stringUtf8);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("GreenVideo", 1, "handleGreenVideoConfig content is null");
                }
                ea.v2(qQAppInterface.getApp());
            }
        }
    }

    public void N0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        if (configurationService$Config.type.get() == 281 && qQAppInterface != null) {
            String k3 = k(configurationService$Config, ea.P1(qQAppInterface.getApp(), "troop_gift_anim_limit", "0"), FilterEnum.MIC_PTU_TRANS_KONGCHENG);
            if (!TextUtils.isEmpty(k3)) {
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig content: " + k3);
                }
                ea.l5(qQAppInterface.getApp(), "troop_gift_anim_limit", "0", configurationService$Config.version.get());
                try {
                    int i3 = new JSONObject(k3).getInt("limitGiftAnimCount");
                    AIOAnimationControlManager.S = i3;
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp()).edit();
                    edit.putInt("AIOAnimationControlManager_limit_gif_count_MAX", i3);
                    edit.commit();
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig error" + e16.getMessage());
                    }
                }
            }
        }
    }

    void O0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField;
        ConfigurationService$Content configurationService$Content;
        String stringUtf8;
        int H1 = ea.H1(qQAppInterface.getApp(), f202907b);
        int i3 = configurationService$Config.version.get();
        if (H1 != i3 && (pBRepeatMessageField = configurationService$Config.msg_content_list) != null && pBRepeatMessageField.size() > 0 && (configurationService$Content = configurationService$Config.msg_content_list.get(0)) != null) {
            if (configurationService$Content.compress.get() == 1) {
                byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                stringUtf8 = null;
                if (d16 != null) {
                    try {
                        stringUtf8 = new String(d16, "UTF-8");
                    } catch (Exception unused) {
                        QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoConfig|uncompress failed");
                    }
                }
            } else {
                stringUtf8 = configurationService$Content.content.get().toStringUtf8();
            }
            if (stringUtf8 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(stringUtf8);
                    String string = jSONObject.getString("url");
                    String string2 = jSONObject.getString("wantWord");
                    String string3 = jSONObject.getString("thxWord");
                    ea.o3(qQAppInterface.getApp(), "url", string);
                    ea.o3(qQAppInterface.getApp(), "thxWord", string3);
                    ea.o3(qQAppInterface.getApp(), "wantWord", string2);
                    ea.e5(qQAppInterface.getApp(), f202907b, i3);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public void P0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        List<String> X0;
        int i3 = configurationService$Config.version.get();
        if (i3 != qQAppInterface.getPreferences().getInt("troop_link_config_version", 0) && (X0 = X0(configurationService$Config)) != null && X0.size() > 0) {
            if (((ITroopLinkApi) QRoute.api(ITroopLinkApi.class)).saveConfig(X0.get(0))) {
                qQAppInterface.getPreferences().edit().putInt("troop_link_config_version", i3).commit();
            }
        }
    }

    void Q0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        if (configurationService$Config.type.get() != 194) {
            return;
        }
        int I1 = ea.I1(qQAppInterface.getApp(), f202907b);
        int i3 = configurationService$Config.version.get();
        if (QLog.isColorLevel()) {
            QLog.d("PobingSPLASH_ConfigServlet", 2, "handleTroopPobingConfig reqVersion=" + I1 + "version=" + i3);
        }
        if (I1 != i3) {
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                if (configurationService$Content != null) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                        stringUtf8 = null;
                        if (d16 != null) {
                            try {
                                stringUtf8 = new String(d16, "UTF-8");
                            } catch (Exception unused) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("PobingSPLASH_ConfigServlet", 2, "handleTroopPobingConfig|uncompress failed");
                                }
                            }
                        }
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    if (stringUtf8 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Pobing", 1, "handleTroopPobingConfig content" + stringUtf8);
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(stringUtf8);
                            JSONArray jSONArray = jSONObject.getJSONArray("left");
                            JSONArray jSONArray2 = jSONObject.getJSONArray("right");
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig content" + stringUtf8 + " left: " + jSONArray);
                                QLog.d("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig content" + stringUtf8 + " right: " + jSONArray2);
                            }
                            TroopManager.i0(qQAppInterface, f202907b, jSONArray, jSONArray2);
                        } catch (Exception e16) {
                            QLog.e("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig failed" + e16);
                        }
                    }
                }
            } else {
                JSONArray jSONArray3 = new JSONArray();
                TroopManager.i0(qQAppInterface, f202907b, jSONArray3, jSONArray3);
                QLog.i("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig, empty config clear local");
            }
        }
        ea.t3(qQAppInterface.getApp(), f202907b, i3);
    }

    public boolean V0(AppRuntime appRuntime, int[] iArr) {
        if (iArr == null || iArr.length != 1 || iArr[0] != 215 || appRuntime.isLogin()) {
            return false;
        }
        return true;
    }

    protected void Y(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int size;
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField;
        String stringUtf8;
        try {
            int intValue = ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(f202907b, INearbySPUtil.KEY_TABS_CONFIG_VERSION, (Object) 0)).intValue();
            int i3 = configurationService$Config.version.get();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleNearbyTabsConfig, l :");
            sb5.append(intValue);
            sb5.append(" s : ");
            sb5.append(i3);
            sb5.append("content_list_size=");
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField2 = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField2 == null) {
                size = 0;
            } else {
                size = pBRepeatMessageField2.size();
            }
            sb5.append(size);
            QLog.d(LogTag.TAB_NEARBY_TAG_CONFIG, 1, sb5.toString());
            if (intValue != i3 && (pBRepeatMessageField = configurationService$Config.msg_content_list) != null && pBRepeatMessageField.size() > 0) {
                for (int i16 = 0; i16 < configurationService$Config.msg_content_list.size(); i16++) {
                    QLog.d(LogTag.TAB_NEARBY_TAG_CONFIG, 1, "content task_id :" + configurationService$Config.msg_content_list.get(i16).task_id.get());
                }
                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                if (configurationService$Content != null) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                        if (d16 != null) {
                            try {
                                stringUtf8 = new String(d16, "UTF-8");
                            } catch (Exception e16) {
                                QLog.e(LogTag.TAB_NEARBY_TAG_CONFIG, 1, "handleNearbyTabsConfig|uncompress failed" + e16);
                            }
                        }
                        stringUtf8 = null;
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    if (stringUtf8 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.i(LogTag.TAB_NEARBY_TAG_CONFIG, 1, "handleNearbyTabsConfig content" + stringUtf8);
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(stringUtf8);
                            JSONArray optJSONArray = jSONObject.optJSONArray("tabs");
                            if (optJSONArray.length() > 0) {
                                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_TABS_ARRAY, optJSONArray.toString());
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("werewolves");
                            if (optJSONObject != null) {
                                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_WEREWOLVES_CONFIG, optJSONObject.toString());
                            }
                            int optInt = jSONObject.optInt("AutoEnterWithoutReddot");
                            if (optJSONObject != null) {
                                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_AUTOENTER_WITHOUTREDOT, Integer.valueOf(optInt));
                            }
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("now_nearby");
                            if (optJSONObject2 != null) {
                                int optInt2 = optJSONObject2.optInt("match_secs");
                                int optInt3 = optJSONObject2.optInt("match_times");
                                int optInt4 = optJSONObject2.optInt("open_switch");
                                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.NOW_NEARBY_MATCH_SECS, Integer.valueOf(optInt2));
                                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.NOW_NEARBY_MATCH_TIMES, Integer.valueOf(optInt3));
                                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.NOW_NEARBY_1V1_OPEN_SWITCH, Integer.valueOf(optInt4));
                            }
                            JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_items");
                            if (optJSONArray2 != null) {
                                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_BANNER_ENTER_ITEMS, optJSONArray2.toString());
                            } else {
                                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_BANNER_ENTER_ITEMS, "");
                            }
                            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_TABS_CONFIG_VERSION, Integer.valueOf(configurationService$Config.version.get()));
                            int optInt5 = jSONObject.optInt(INearbySPUtil.KEY_NEARBY_USERCARD_TAB_HOST, 0);
                            int optInt6 = jSONObject.optInt(INearbySPUtil.KEY_NEARBY_USERCARD_TAB_GUEST, -1);
                            int optInt7 = jSONObject.optInt(INearbySPUtil.KEY_NEARBY_USERCARD_PUBLISH, 0);
                            int optInt8 = jSONObject.optInt(INearbySPUtil.KEY_NEARBY_FACE_SCORE_SWITCH, 0);
                            String optString = jSONObject.optString("mine_page_url");
                            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_NEARBY_USERCARD_TAB_HOST, Integer.valueOf(optInt5));
                            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_NEARBY_USERCARD_TAB_GUEST, Integer.valueOf(optInt6));
                            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_NEARBY_USERCARD_PUBLISH, Integer.valueOf(optInt7));
                            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_NEARBY_FACE_SCORE_SWITCH, Integer.valueOf(optInt8));
                            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_NEARBY_MINE_URL, optString);
                            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_NOW_IP_CONN_SWITCH, Integer.valueOf(jSONObject.optInt(INearbySPUtil.KEY_NOW_IP_CONN_SWITCH)));
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("nearby_guide_config");
                            if (optJSONObject3 != null) {
                                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(f202907b, INearbySPUtil.KEY_CIKE_GUIDE_CONTENT, optJSONObject3.toString());
                            }
                            qQAppInterface.notifyObservers(com.tencent.mobileqq.nearby.f.class, 1, true, null);
                        } catch (Exception e17) {
                            QLog.e(LogTag.TAB_NEARBY_TAG_CONFIG, 1, "handleNearbyTabsConfig failed" + e17);
                        }
                    }
                }
            }
        } catch (Exception e18) {
            QLog.e(LogTag.TAB_NEARBY_TAG_CONFIG, 1, "handleNearbyTabsConfig exp:", e18);
        }
    }

    public void f1(AppRuntime appRuntime, Intent intent, ConfigurationService$ReqGetConfig configurationService$ReqGetConfig, int[] iArr, List<ConfigurationService$ConfigSeq> list, List<Integer> list2, String str) {
        f202907b = str;
        e((QQAppInterface) appRuntime, intent, configurationService$ReqGetConfig, iArr, list, list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v3 */
    public void g1(AppRuntime appRuntime, ConfigurationService$RespGetConfig configurationService$RespGetConfig, Intent intent, int[] iArr, boolean z16) {
        int i3;
        boolean z17;
        QQAppInterface qQAppInterface;
        PBRepeatMessageField<ConfigurationService$Config> pBRepeatMessageField;
        int[] iArr2 = iArr;
        QQAppInterface qQAppInterface2 = (QQAppInterface) appRuntime;
        if (z16 && configurationService$RespGetConfig.result.get() == 0 && (pBRepeatMessageField = configurationService$RespGetConfig.config_list) != null && pBRepeatMessageField.size() != 0) {
            return;
        }
        ?? r142 = 0;
        int i16 = 0;
        while (i16 < iArr2.length) {
            int i17 = iArr2[i16];
            if (!am.s().Q(i17)) {
                if (QLog.isColorLevel()) {
                    QLog.i("SPLASH_ConfigServlet", 2, "receiveAllConfigs|failed type: " + i17);
                }
                switch (i17) {
                    case 69:
                        i3 = i16;
                        z17 = r142;
                        qQAppInterface = qQAppInterface2;
                        if (z16 && configurationService$RespGetConfig.result.get() == 0) {
                            break;
                        } else {
                            com.tencent.mobileqq.managers.g gVar = (com.tencent.mobileqq.managers.g) qQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
                            gVar.f243714e = true;
                            gVar.f243715f = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
                            gVar.f243716h = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
                            gVar.f243718m = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
                            ea.K4(qQAppInterface.getApp(), qQAppInterface.getAccount(), 0, gVar.f243715f, gVar.f243716h, gVar.f243717i, gVar.f243718m);
                            continue;
                        }
                        break;
                    case 116:
                        if (!UpgradeConfigTypeParser.d()) {
                            QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigForFail|GET_CONFIG_UPGRADE useFreesia");
                            break;
                        } else if (!z16 || configurationService$RespGetConfig.result.get() != 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE get config fail.");
                            }
                            if (!this.f202910a) {
                                i3 = i16;
                                z17 = r142;
                                qQAppInterface = qQAppInterface2;
                                ReportController.o(qQAppInterface2, "CliOper", "", "", "0X800716D", "0X800716D", 0, 0, "", "", "", "");
                                this.f202910a = true;
                            } else {
                                i3 = i16;
                                z17 = r142;
                                qQAppInterface = qQAppInterface2;
                            }
                            ((ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).m3(k.i().j());
                            break;
                        }
                        break;
                    case 119:
                    case 156:
                        break;
                    case 140:
                        int i18 = configurationService$RespGetConfig.result.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "ScanFu. GET_SCAN_FU_CONFIG failed, resultCode:" + i18);
                        }
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("failedCode", i18 + "");
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pullMedalConfigFailed", false, 0L, 0L, hashMap, null);
                        break;
                    case 149:
                    case 180:
                    case 218:
                        l.f(i17, z16, configurationService$RespGetConfig);
                        break;
                    case 165:
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "BuluoRedDot. BULUO_REDDOT_CONFIG failed, resultCode:" + configurationService$RespGetConfig.result.get());
                            break;
                        }
                        break;
                    case 174:
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "Nearby. NEARBY_TABS_CONFIG failed, resultCode:" + configurationService$RespGetConfig.result.get());
                            break;
                        }
                        break;
                    case 185:
                        ScribbleResMgr.L().Q();
                        break;
                    case 188:
                        if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "AR_GLOBAL_CONTROL_COFIG failed, resultCode:" + configurationService$RespGetConfig.result.get());
                            break;
                        }
                        break;
                    case 210:
                        IOCRService iOCRService = (IOCRService) qQAppInterface2.getRuntimeService(IOCRService.class, "");
                        QLog.d("SPLASH_ConfigServlet", 1, "OCR_CONFIG failed, resultCode:" + configurationService$RespGetConfig.result.get());
                        iOCRService.onGetOCRConfig(r142, null);
                        break;
                    case 215:
                        AEOldShortVideoResManager.D(configurationService$RespGetConfig.result.get());
                        break;
                    case 223:
                    case 364:
                    case 365:
                        BusinessCommonConfig.getInstance(qQAppInterface2).handleResp_Config_Fail(qQAppInterface2, i17, z16, configurationService$RespGetConfig);
                        break;
                    case 257:
                        if (QLog.isColorLevel()) {
                            int i19 = configurationService$RespGetConfig.result.get();
                            Locale locale = Locale.getDefault();
                            Object[] objArr = new Object[1];
                            objArr[r142] = Integer.valueOf(i19);
                            QLog.d("SPLASH_ConfigServlet", 2, String.format(locale, "MEDAL_STRONG_REMINDER_CONFIG fail code: %s", objArr));
                            break;
                        }
                        break;
                    case 260:
                        if (QLog.isColorLevel()) {
                            int i26 = configurationService$RespGetConfig.result.get();
                            Locale locale2 = Locale.getDefault();
                            Object[] objArr2 = new Object[1];
                            objArr2[r142] = Integer.valueOf(i26);
                            QLog.d("SPLASH_ConfigServlet", 2, String.format(locale2, "PUSH_RECOMMEND_SHIELD_CONFIG fail code: %s", objArr2));
                            break;
                        }
                        break;
                    case 273:
                        if (QLog.isColorLevel()) {
                            QLog.d("GiftConfigManager", 2, "get config failed, resultCode:" + configurationService$RespGetConfig.result.get());
                            break;
                        }
                        break;
                    case 283:
                        com.tencent.qqperf.crashdefend.d.e().h(1, r142);
                        SafeModeUtil.c();
                        break;
                    case 705:
                        int i27 = configurationService$RespGetConfig.result.get();
                        Object[] objArr3 = new Object[2];
                        objArr3[r142] = "get local qr login switch failed : ";
                        objArr3[1] = Integer.valueOf(i27);
                        QLog.e("SPLASH_ConfigServlet", 1, objArr3);
                        break;
                    default:
                        i3 = i16;
                        z17 = r142;
                        qQAppInterface = qQAppInterface2;
                        qQAppInterface.getConfigProcess().e(qQAppInterface, i17, z16, configurationService$RespGetConfig.result.get());
                        continue;
                }
            }
            i3 = i16;
            z17 = r142;
            qQAppInterface = qQAppInterface2;
            i16 = i3 + 1;
            qQAppInterface2 = qQAppInterface;
            r142 = z17;
            iArr2 = iArr;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x005a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0f17  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0f34 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h1(AppRuntime appRuntime, ConfigurationService$RespGetConfig configurationService$RespGetConfig, Intent intent, List<Integer> list, int[] iArr, boolean z16) {
        int i3;
        String str;
        Exception exc;
        PBRepeatField<String> pBRepeatField;
        Iterator<String> it;
        Iterator<String> it5;
        String stringUtf8;
        Intent intent2 = intent;
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        int i17 = 0;
        boolean z17 = false;
        UpgradeTIMWrapper upgradeTIMWrapper = null;
        for (int size = configurationService$RespGetConfig.config_list.size(); i17 < size; size = i3) {
            ConfigurationService$Config configurationService$Config = configurationService$RespGetConfig.config_list.get(i17);
            if (configurationService$Config != null && configurationService$Config.type.has()) {
                int i18 = configurationService$Config.type.get();
                if (!am.s().Q(i18)) {
                    list.remove(Integer.valueOf(i18));
                    if (QLog.isColorLevel()) {
                        arrayList.add(Integer.valueOf(i18));
                    }
                    switch (i18) {
                        case 1:
                            i3 = size;
                            PBRepeatField<String> pBRepeatField2 = configurationService$Config.content_list;
                            if (pBRepeatField2 != null && pBRepeatField2.size() > 0) {
                                File file = new File(qQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/splashpic");
                                if (!file.exists()) {
                                    file.mkdirs();
                                } else if (file.isDirectory()) {
                                    File[] listFiles = file.listFiles();
                                    int length = listFiles.length;
                                    for (int i19 = i16; i19 < length; i19++) {
                                        File file2 = listFiles[i19];
                                        if (file2 != null && file2.exists()) {
                                            file2.delete();
                                        }
                                    }
                                }
                                for (String str2 : configurationService$Config.content_list.get()) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 1,content: " + str2 + ",version: " + configurationService$Config.version.get());
                                    }
                                    d1(qQAppInterface, str2, configurationService$Config.version.get());
                                    if (QLog.isColorLevel()) {
                                        QLog.i("SPLASH_ConfigServlet", 2, "onreceive cmd==1 version_back is " + configurationService$Config.version.get());
                                    }
                                }
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 1,content_list is empty ,version: " + configurationService$Config.version.get());
                                }
                                new File(qQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/flashlogo.png").delete();
                                ea.X4(qQAppInterface.getApplication(), configurationService$Config.version.get(), "1|2", "");
                            }
                            i17++;
                            intent2 = intent;
                            break;
                        case 2:
                            i3 = size;
                            try {
                                pBRepeatField = configurationService$Config.content_list;
                            } catch (Exception e16) {
                                e = e16;
                                i16 = 0;
                                exc = e;
                                if (QLog.isColorLevel()) {
                                }
                                i17++;
                                intent2 = intent;
                            }
                            if (pBRepeatField != null && pBRepeatField.size() > 0) {
                                com.tencent.mobileqq.config.e.f202867e.g();
                                for (String str3 : configurationService$Config.content_list.get()) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 2,content: " + str3 + ",version: " + configurationService$Config.version.get());
                                    }
                                    a1(qQAppInterface, str3, configurationService$Config.version.get());
                                }
                                com.tencent.mobileqq.config.g gVar = new com.tencent.mobileqq.config.g(qQAppInterface.getApplication(), f202907b);
                                gVar.c();
                                gVar.i();
                                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
                                sharedPreferences.edit().putBoolean(AppConstants.Preferences.PUSH_BANNER_REVEIVE_NEW + qQAppInterface.getAccount(), true).commit();
                                sharedPreferences.edit().putBoolean(AppConstants.Preferences.PUSH_BANNER_DISPLAY + qQAppInterface.getAccount(), true).commit();
                                ea.A4(qQAppInterface.getApplication(), configurationService$Config.version.get(), f202907b);
                                if (QLog.isColorLevel()) {
                                    QLog.i("SPLASH_ConfigServlet", 2, "pushbanner onreceive cmd==2 version_back is " + configurationService$Config.version.get());
                                }
                                i16 = 0;
                                i17++;
                                intent2 = intent;
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 2,content_list is empty ,version: " + configurationService$Config.version.get());
                                }
                                com.tencent.mobileqq.config.e.f202867e.g();
                                com.tencent.mobileqq.config.e.f202867e.k();
                                com.tencent.mobileqq.config.g gVar2 = new com.tencent.mobileqq.config.g(qQAppInterface.getApplication(), f202907b);
                                gVar2.c();
                                gVar2.i();
                                i16 = 0;
                                BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean(AppConstants.Preferences.PUSH_BANNER_DISPLAY + qQAppInterface.getAccount(), false).commit();
                                ea.A4(qQAppInterface.getApplication(), configurationService$Config.version.get(), f202907b);
                                i17++;
                                intent2 = intent;
                            }
                            break;
                        case 3:
                            i3 = size;
                            PBRepeatField<String> pBRepeatField3 = configurationService$Config.content_list;
                            if (pBRepeatField3 != null && pBRepeatField3.size() > 0) {
                                try {
                                    String str4 = configurationService$Config.content_list.get(0);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 3,content: " + str4 + ",version: " + configurationService$Config.version.get());
                                    }
                                    W0(qQAppInterface, str4, configurationService$Config.version.get());
                                } catch (Exception e17) {
                                    exc = e17;
                                    i16 = 0;
                                    if (QLog.isColorLevel()) {
                                    }
                                    i17++;
                                    intent2 = intent;
                                }
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 3,content_list is empty ,version: " + configurationService$Config.version.get());
                                }
                                File file3 = new File(qQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/" + f202907b + "/birthdayflashlogo.png");
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                ea.z3(qQAppInterface.getApplication(), configurationService$Config.version.get(), "", f202907b);
                            }
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                            break;
                        case 6:
                            i3 = size;
                            ((IDPCApi) QRoute.api(IDPCApi.class)).onDPCResponse(configurationService$RespGetConfig, "");
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 10:
                            i3 = size;
                            try {
                                PBRepeatField<String> pBRepeatField4 = configurationService$Config.content_list;
                                List<String> list2 = (pBRepeatField4 == null || pBRepeatField4.size() <= 0) ? null : configurationService$Config.content_list.get();
                                if (list2 != null && list2.size() > 0) {
                                    try {
                                        String str5 = list2.get(0);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 10,content: " + str5 + ",version: " + configurationService$Config.version.get());
                                        }
                                        nx.a.k(str5);
                                        for (String str6 : list2) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 10,content: " + str6 + ",version: " + configurationService$Config.version.get());
                                            }
                                            if (com.tencent.mobileqq.activity.aio.tips.b.d(str6)) {
                                            }
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        i16 = 0;
                                        exc = e;
                                        if (QLog.isColorLevel()) {
                                        }
                                        i17++;
                                        intent2 = intent;
                                    }
                                } else {
                                    try {
                                        nx.a.k(null);
                                        com.tencent.mobileqq.activity.aio.tips.b.c();
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 10,content_list is empty ,version: " + configurationService$Config.version.get());
                                        }
                                    } catch (Exception e19) {
                                        e = e19;
                                        exc = e;
                                        i16 = 0;
                                        if (QLog.isColorLevel()) {
                                        }
                                        i17++;
                                        intent2 = intent;
                                    }
                                }
                                ea.W3(qQAppInterface.getApplication(), configurationService$Config.version.get());
                                i16 = 0;
                            } catch (Exception e26) {
                                e = e26;
                            }
                            i17++;
                            intent2 = intent;
                            break;
                        case 12:
                            i3 = size;
                            com.tencent.mobileqq.config.struct.c cVar = (com.tencent.mobileqq.config.struct.c) qQAppInterface.getManager(QQManagerFactory.NEARBY_BANNER_MANAGER);
                            Set<String> d16 = cVar.d();
                            PicAndAdConf picAndAdConf = new PicAndAdConf((short) 21, (byte) 2);
                            PBRepeatField<String> pBRepeatField5 = configurationService$Config.content_list;
                            if (pBRepeatField5 != null && pBRepeatField5.size() > 0) {
                                Iterator<String> it6 = configurationService$Config.content_list.get().iterator();
                                while (it6.hasNext()) {
                                    String next = it6.next();
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb5 = new StringBuilder();
                                        it = it6;
                                        sb5.append("receiveAllConfigs|type: 12,content: ");
                                        sb5.append(next);
                                        sb5.append(",version: ");
                                        sb5.append(configurationService$Config.version.get());
                                        QLog.d("SPLASH_ConfigServlet", 2, sb5.toString());
                                    } else {
                                        it = it6;
                                    }
                                    Z0(picAndAdConf, next, d16);
                                    cVar.e(picAndAdConf, configurationService$Config.version.get());
                                    it6 = it;
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 12,content_list is empty ,version: " + configurationService$Config.version.get());
                            }
                            if (QLog.isColorLevel()) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("NearbyBanner onreceive, content count = ");
                                PBRepeatField<String> pBRepeatField6 = configurationService$Config.content_list;
                                sb6.append(pBRepeatField6 == null ? 0 : pBRepeatField6.get().size());
                                sb6.append(" , item count = ");
                                sb6.append(picAndAdConf.c());
                                sb6.append(", version = ");
                                sb6.append(configurationService$Config.version.get());
                                QLog.i("SPLASH_ConfigServlet", 2, sb6.toString());
                            }
                            cVar.f(configurationService$Config.version.get());
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                            break;
                        case 13:
                            i3 = size;
                            BridgeHelper.b(BaseApplication.getContext(), qQAppInterface.getAccount()).f(configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 23:
                            i3 = size;
                            w0(qQAppInterface, intent2, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 31:
                            i3 = size;
                            PBRepeatField<String> pBRepeatField7 = configurationService$Config.content_list;
                            if (pBRepeatField7 != null && pBRepeatField7.size() > 0) {
                                String str7 = configurationService$Config.content_list.get(0);
                                qQAppInterface.getAVNotifyCenter().z0(qQAppInterface, str7, configurationService$Config.version.get());
                                if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 31,content: " + str7 + ",version: " + configurationService$Config.version.get());
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 31,content_list is empty ,version: " + configurationService$Config.version.get());
                            }
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                            break;
                        case 34:
                            i3 = size;
                            h0(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 38:
                            i3 = size;
                            try {
                                PBRepeatField<String> pBRepeatField8 = configurationService$Config.content_list;
                                if (pBRepeatField8 != null && pBRepeatField8.size() > 0) {
                                    for (String str8 : configurationService$Config.content_list.get()) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 38,content: " + str8 + ",version: " + configurationService$Config.version.get());
                                        }
                                        c1(qQAppInterface, str8, configurationService$Config.version.get());
                                    }
                                } else if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 38,content_list is empty ,version: " + configurationService$Config.version.get());
                                }
                            } catch (Exception e27) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("SPLASH_ConfigServlet", 2, "qav_upgrade_invite error: " + e27.toString());
                                }
                                e27.printStackTrace();
                            }
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                            break;
                        case 42:
                            i3 = size;
                            ((IQWalletConfigService) qQAppInterface.getRuntimeService(IQWalletConfigService.class)).handleQWalletSettingCofig(configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 43:
                        case 79:
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 44:
                            i3 = size;
                            PBRepeatField<String> pBRepeatField9 = configurationService$Config.content_list;
                            if (pBRepeatField9 != null && pBRepeatField9.size() > 0) {
                                ea.A4(qQAppInterface.getApplication(), configurationService$Config.version.get(), f202907b);
                                for (int i26 = 0; i26 < configurationService$Config.content_list.size(); i26++) {
                                    String str9 = configurationService$Config.content_list.get(i26);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 44,content: " + str9 + ",version: " + configurationService$Config.version.get());
                                    }
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 44content_list is emtpy,version: " + configurationService$Config.version.get());
                            }
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                            break;
                        case 49:
                            i3 = size;
                            P(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 55:
                            i3 = size;
                            int f26 = ea.f2(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin());
                            PBInt32Field pBInt32Field = configurationService$Config.version;
                            int i27 = pBInt32Field != null ? pBInt32Field.get() : f26;
                            PBRepeatField<String> pBRepeatField10 = configurationService$Config.content_list;
                            if (pBRepeatField10 != null && pBRepeatField10.size() > 0) {
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append("bless receiveAllConfigs|type: 55,new version: ");
                                    sb7.append(i27);
                                    sb7.append(" old version:");
                                    sb7.append(f26);
                                    sb7.append(", size:");
                                    sb7.append(configurationService$Config.content_list.size());
                                    sb7.append(",content: ");
                                    try {
                                        sb7.append(configurationService$Config.content_list.get(0));
                                        QLog.d("SPLASH_ConfigServlet", 2, sb7.toString());
                                    } catch (Exception e28) {
                                        exc = e28;
                                        i16 = 0;
                                        if (QLog.isColorLevel()) {
                                        }
                                        i17++;
                                        intent2 = intent;
                                    }
                                }
                                HashSet hashSet = new HashSet();
                                for (int i28 = 0; i28 < configurationService$Config.content_list.size(); i28++) {
                                    hashSet.add(configurationService$Config.content_list.get(i28));
                                }
                                ((BlessManager) qQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).A0(hashSet);
                                ea.U4(qQAppInterface.getApplication(), qQAppInterface.getAccount(), i27);
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, "bless receiveAllConfigs|type: 55,content_list is empty ,new version: " + i27 + " old version:" + f26);
                                }
                                if (f26 != i27) {
                                    ((BlessManager) qQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).r();
                                    ea.U4(qQAppInterface.getApplication(), qQAppInterface.getAccount(), i27);
                                }
                            }
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                            break;
                        case 56:
                            i3 = size;
                            g0(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 61:
                            i3 = size;
                            D(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 63:
                            i3 = size;
                            K(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 64:
                            i3 = size;
                            D0(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 66:
                            i3 = size;
                            E0(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 69:
                            i3 = size;
                            o0(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 80:
                            i3 = size;
                            S0(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 82:
                            i3 = size;
                            T(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 90:
                            i3 = size;
                            PBRepeatField<String> pBRepeatField11 = configurationService$Config.content_list;
                            if (pBRepeatField11 != null && pBRepeatField11.size() > 0) {
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append("receiveAllConfigs|type: ");
                                    sb8.append(i18);
                                    sb8.append(",content: ");
                                    sb8.append(configurationService$Config.content_list.get(0));
                                    sb8.append(",version: ");
                                    sb8.append(configurationService$Config.version.get());
                                    QLog.d("SPLASH_ConfigServlet", 2, sb8.toString());
                                }
                                if (((PhotoPlusManager) qQAppInterface.getManager(QQManagerFactory.PHOTO_PLUS_MANAGER)).g(configurationService$Config.content_list.get(0))) {
                                    ea.v4(qQAppInterface.getApplication(), qQAppInterface.getAccount(), configurationService$Config.version.get());
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: " + i18 + ",content_list is empty ,version: " + configurationService$Config.version.get());
                            }
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                            break;
                        case 93:
                            i3 = size;
                            try {
                                PBRepeatField<String> pBRepeatField12 = configurationService$Config.content_list;
                                if (pBRepeatField12 != null && pBRepeatField12.size() > 0) {
                                    Iterator<String> it7 = configurationService$Config.content_list.get().iterator();
                                    while (it7.hasNext()) {
                                        String next2 = it7.next();
                                        if (QLog.isColorLevel()) {
                                            StringBuilder sb9 = new StringBuilder();
                                            it5 = it7;
                                            sb9.append("receiveAllConfigs|type: 93,content: ");
                                            sb9.append(next2);
                                            sb9.append(",version: ");
                                            sb9.append(configurationService$Config.version.get());
                                            QLog.d("SPLASH_ConfigServlet", 2, sb9.toString());
                                        } else {
                                            it5 = it7;
                                        }
                                        b1(qQAppInterface, next2, configurationService$Config.version.get());
                                        it7 = it5;
                                    }
                                } else if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 93,content_list is empty ,version: " + configurationService$Config.version.get());
                                }
                            } catch (Exception e29) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("SPLASH_ConfigServlet", 2, "qav_anychat_time_limit_error: " + e29.toString());
                                }
                                e29.printStackTrace();
                            }
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                            break;
                        case 97:
                            i3 = size;
                            v(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 101:
                            i3 = size;
                            L(qQAppInterface, intent2, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 102:
                            i3 = size;
                            w(qQAppInterface, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 109:
                            i3 = size;
                            try {
                                r0(intent2, z16, configurationService$Config, configurationService$RespGetConfig.result.get());
                                i16 = 0;
                            } catch (Exception e36) {
                                e = e36;
                                exc = e;
                                i16 = 0;
                                if (QLog.isColorLevel()) {
                                }
                                i17++;
                                intent2 = intent;
                            }
                            i17++;
                            intent2 = intent;
                            break;
                        case 115:
                            i3 = size;
                            e0(qQAppInterface, intent2, configurationService$Config);
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 116:
                            try {
                            } catch (Exception e37) {
                                e = e37;
                                i3 = size;
                                exc = e;
                                i16 = 0;
                                if (QLog.isColorLevel()) {
                                }
                                i17++;
                                intent2 = intent;
                            }
                            if (!UpgradeConfigTypeParser.d()) {
                                QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigForSuccess|GET_CONFIG_UPGRADE useFreesia");
                                i3 = size;
                                i16 = 0;
                                i17++;
                                intent2 = intent;
                            } else {
                                int K0 = ea.K0(qQAppInterface.getApplication(), f202907b);
                                int i29 = configurationService$Config.version.get();
                                if (QLog.isColorLevel()) {
                                    i3 = size;
                                    try {
                                        QLog.d("SPLASH_ConfigServlet", 2, String.format("receiveAllConfigs|GET_CONFIG_UPGRADE localVersion=%s newVersion=%s", Integer.valueOf(K0), Integer.valueOf(i29)));
                                    } catch (Exception e38) {
                                        e = e38;
                                        exc = e;
                                        i16 = 0;
                                        if (QLog.isColorLevel()) {
                                        }
                                        i17++;
                                        intent2 = intent;
                                    }
                                } else {
                                    i3 = size;
                                }
                                if (K0 != i29) {
                                    PBRepeatField<String> pBRepeatField13 = configurationService$Config.content_list;
                                    if (pBRepeatField13 != null && !pBRepeatField13.isEmpty()) {
                                        i16 = 0;
                                        try {
                                            str = configurationService$Config.content_list.get(0);
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE configContent=" + str);
                                            }
                                            if (TextUtils.isEmpty(str)) {
                                                com.tencent.mobileqq.upgrade.f.a("config_upgrade_", f202907b);
                                            } else {
                                                com.tencent.mobileqq.upgrade.f.c("config_upgrade_", f202907b, str);
                                            }
                                            ea.y4(qQAppInterface.getApplication(), f202907b, i29);
                                        } catch (Exception e39) {
                                            exc = e39;
                                            if (QLog.isColorLevel()) {
                                            }
                                            i17++;
                                            intent2 = intent;
                                        }
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE no content in config, delete local config.");
                                    }
                                    com.tencent.mobileqq.upgrade.f.a("config_upgrade_", f202907b);
                                    str = null;
                                    ea.y4(qQAppInterface.getApplication(), f202907b, i29);
                                } else {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE the same version.");
                                    }
                                    str = null;
                                }
                                ConfigHandler configHandler = (ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
                                if (!TextUtils.isEmpty(str)) {
                                    UpgradeDetailWrapper j3 = k.i().j();
                                    j3.e(str, "manager");
                                    if (!j3.f306171e.isValid) {
                                        QLog.d("SPLASH_ConfigServlet", 1, "[receiveAllConfigs] config invalid.");
                                    } else {
                                        if (QLog.isColorLevel()) {
                                            Object[] objArr = new Object[2];
                                            try {
                                                objArr[0] = Integer.valueOf(AppSetting.f());
                                                objArr[1] = Integer.valueOf(j3.f306171e.iUpgradeSdkId);
                                                QLog.d("SPLASH_ConfigServlet", 2, String.format("receiveAllConfigs|GET_CONFIG_UPGRADE localAppID=%s configAppID=%s", objArr));
                                            } catch (Exception e46) {
                                                exc = e46;
                                                i16 = 0;
                                                if (QLog.isColorLevel()) {
                                                }
                                                i17++;
                                                intent2 = intent;
                                            }
                                        }
                                        n.a(j3);
                                        if (AppSetting.f() >= j3.f306171e.iUpgradeSdkId) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE config APP_ID not correctly?");
                                            }
                                            try {
                                                ea.y4(qQAppInterface.getApp(), f202907b, 0);
                                                com.tencent.mobileqq.upgrade.f.a("config_upgrade_", f202907b);
                                                j3.f306171e.iUpgradeType = 0;
                                                configHandler.m3(j3);
                                                configHandler.t3();
                                            } catch (Exception e47) {
                                                exc = e47;
                                                i16 = 0;
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfig..parse error:" + exc.getMessage());
                                                }
                                                i17++;
                                                intent2 = intent;
                                            }
                                        } else {
                                            try {
                                                ea.i5(qQAppInterface.getApplication(), f202907b, System.currentTimeMillis());
                                                synchronized (j3) {
                                                    if (!j3.f306175m) {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE waiting switch bit.");
                                                        }
                                                        i16 = 0;
                                                        z17 = true;
                                                    } else {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE do upgrade.");
                                                        }
                                                        if (j3.D == 0) {
                                                            ConfigHandler.w3(qQAppInterface, j3.C == 1);
                                                        }
                                                        configHandler.t3();
                                                        k.i().o(j3.f306171e, configHandler);
                                                        z17 = true;
                                                    }
                                                }
                                            } catch (Exception e48) {
                                                exc = e48;
                                                i16 = 0;
                                                z17 = true;
                                                if (QLog.isColorLevel()) {
                                                }
                                                i17++;
                                                intent2 = intent;
                                            }
                                            i17++;
                                            intent2 = intent;
                                        }
                                    }
                                } else {
                                    configHandler.t3();
                                    configHandler.m3(k.i().j());
                                }
                                i16 = 0;
                                i17++;
                                intent2 = intent;
                            }
                            break;
                        case 119:
                            y(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 129:
                            X(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 130:
                            O(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 139:
                            v0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 140:
                            U(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 142:
                            M0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 145:
                            u0(qQAppInterface, intent2, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 147:
                            B0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 148:
                            R0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 149:
                        case 180:
                        case 218:
                            l.e(i18, qQAppInterface.getCurrentUin(), configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 155:
                            y0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 156:
                        case 400:
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 157:
                            p0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 165:
                            A(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 171:
                            O0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 174:
                            Y(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 177:
                            l0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 184:
                            j0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 185:
                            A0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 187:
                            i0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 188:
                            s0(qQAppInterface, intent2, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 191:
                            x(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i16 = 0;
                            i17++;
                            intent2 = intent;
                        case 193:
                            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
                            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(i16);
                                if (configurationService$Content != null) {
                                    if (configurationService$Content.compress.get() == 1) {
                                        byte[] d17 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                                        if (d17 != null) {
                                            try {
                                                try {
                                                    stringUtf8 = new String(d17, "UTF-8");
                                                } catch (OutOfMemoryError e49) {
                                                    if (QLog.isColorLevel()) {
                                                        e49.printStackTrace();
                                                    }
                                                    System.gc();
                                                    try {
                                                        stringUtf8 = new String(d17, "UTF-8");
                                                    } catch (Throwable unused) {
                                                    }
                                                }
                                            } catch (UnsupportedEncodingException e56) {
                                                if (QLog.isColorLevel()) {
                                                    e56.printStackTrace();
                                                }
                                            }
                                        }
                                        stringUtf8 = null;
                                    } else {
                                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                                    }
                                    if (stringUtf8 != null) {
                                        int i36 = configurationService$Config.version.get();
                                        if (QLog.isColorLevel()) {
                                            StringBuilder sb10 = new StringBuilder();
                                            try {
                                                sb10.append("receiveAllConfigs|UpgradeTIMWrapper receive version: ");
                                                sb10.append(i36);
                                                sb10.append(", content: ");
                                                sb10.append(stringUtf8);
                                                QLog.i("UpgradeTIMWrapper", 2, sb10.toString());
                                            } catch (Exception e57) {
                                                e = e57;
                                                i3 = size;
                                                i16 = 0;
                                                exc = e;
                                                if (QLog.isColorLevel()) {
                                                }
                                                i17++;
                                                intent2 = intent;
                                            }
                                        }
                                        upgradeTIMWrapper = UpgradeTIMWrapper.a(stringUtf8);
                                        ea.j5(qQAppInterface.getApplication(), f202907b, i36);
                                        if (!PackageUtil.isAppInstalled(qQAppInterface.getApp(), AppConstants.TIM_PACKAGE_NAME)) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("UpgradeTIMWrapper", 2, "TIM not installed, save config");
                                            }
                                            UpgradeTIMWrapper.c(stringUtf8);
                                            UpgradeTIMWrapper.b(qQAppInterface, upgradeTIMWrapper);
                                        } else if (QLog.isColorLevel()) {
                                            QLog.d("UpgradeTIMWrapper", 2, "TIM installed, do not save config");
                                        }
                                    }
                                } else if (QLog.isColorLevel()) {
                                    QLog.d("UpgradeTIMWrapper", 2, "receiveAllConfigs|UpgradeTIMWrapper content == null ");
                                }
                                i3 = size;
                                i16 = 0;
                                i17++;
                                intent2 = intent;
                            }
                            i3 = size;
                            i17++;
                            intent2 = intent;
                            break;
                        case 194:
                            Q0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 195:
                            a0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 201:
                            W(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 204:
                            T0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 205:
                            t0(qQAppInterface, intent2, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 210:
                            M(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 211:
                            v.a(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 212:
                            n0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 215:
                            AEOldShortVideoResManager.F(f0(qQAppInterface, configurationService$Config, intent2.getStringExtra("k_cmd_name")));
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 223:
                        case 364:
                        case 365:
                            BusinessCommonConfig.getInstance(qQAppInterface).decodeConfig(qQAppInterface, i18, intent2, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 225:
                            String F = F(configurationService$Config, ((ICaptureVideoFilterManager) QRoute.api(ICaptureVideoFilterManager.class)).getQQShortVideoFilterConfigVersion(qQAppInterface.getApplication()), 225);
                            if (F != null) {
                                ((ICaptureVideoFilterManager) QRoute.api(ICaptureVideoFilterManager.class)).updateQQShortVideoFilterConfig(qQAppInterface.getApplication(), F, configurationService$Config.version.get());
                            }
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 226:
                            x0(qQAppInterface, intent2, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 228:
                            m0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 232:
                            w.r(configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 234:
                            H0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 235:
                            C0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 238:
                            K0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 244:
                            C(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 245:
                            I0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 247:
                            N(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 253:
                            P0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 254:
                            G0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 256:
                            L0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 257:
                            V(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 259:
                            I(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 260:
                            k0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 262:
                            J(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 268:
                            b0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 269:
                            Z(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 273:
                            com.tencent.biz.troopgift.a.c(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 274:
                            HomeworkTroopController.g(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case FilterEnum.MIC_PTU_TRANS_KONGCHENG /* 281 */:
                            N0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 283:
                            z0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 284:
                            F0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 286:
                            d0(qQAppInterface, intent2, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case FilterEnum.MIC_PTU_ZIRAN /* 289 */:
                            B(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 301:
                            com.tencent.mobileqq.statistics.n.i(qQAppInterface, configurationService$Config, i18, f202907b);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE /* 328 */:
                            c0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 336:
                            q0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case i.CTRL_INDEX /* 347 */:
                            z(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 349:
                            ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).s().h(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 371:
                            G(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 385:
                            R(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case tlv_t183.CMD_183 /* 387 */:
                            H(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_EXTERNAL_COMMENT_TYPE /* 393 */:
                            ((com.tencent.mobileqq.intervideo.groupvideo.h) qQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).f(configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 394:
                            Q(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 403:
                            u(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 596:
                            J0(qQAppInterface, configurationService$Config);
                            i3 = size;
                            i17++;
                            intent2 = intent;
                        case 705:
                            try {
                                S(configurationService$Config);
                                i3 = size;
                            } catch (Exception e58) {
                                e = e58;
                                i3 = size;
                                exc = e;
                                if (QLog.isColorLevel()) {
                                }
                                i17++;
                                intent2 = intent;
                            }
                            i17++;
                            intent2 = intent;
                            break;
                        default:
                            i3 = size;
                            try {
                                qQAppInterface.getConfigProcess().d(qQAppInterface, configurationService$Config, i18);
                            } catch (Exception e59) {
                                e = e59;
                                exc = e;
                                if (QLog.isColorLevel()) {
                                }
                                i17++;
                                intent2 = intent;
                            }
                            i17++;
                            intent2 = intent;
                            break;
                    }
                }
            }
            i3 = size;
            i16 = 0;
            i17++;
            intent2 = intent;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb11 = new StringBuilder("onReceive old type, len=" + arrayList.size() + ", type:");
            Iterator it8 = arrayList.iterator();
            while (it8.hasNext()) {
                sb11.append(((Integer) it8.next()).intValue());
                sb11.append(",");
            }
            QLog.d("QConfigServlet.CORE", 2, sb11.toString());
        }
        if (upgradeTIMWrapper != null) {
            if (!z17 && !PackageUtil.isAppInstalled(qQAppInterface.getApp(), AppConstants.TIM_PACKAGE_NAME)) {
                ((UpgradeTIMManager) qQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_DOWNLOAD_MANAGER)).h(qQAppInterface, upgradeTIMWrapper);
            }
        } else if (QLog.isColorLevel()) {
            QLog.i("UpgradeTIMWrapper", 2, "receiveAllConfigs timWrapper == null");
        }
        if (QLog.isColorLevel()) {
            QLog.w("SPLASH_ConfigServlet", 2, "hasQQConfig: " + z17);
        }
    }

    void i0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        int i3;
        int i16;
        JSONObject jSONObject;
        int i17 = 0;
        QLog.i("PhotoListConfig", 1, String.format("receive config", new Object[0]));
        int b16 = com.tencent.mobileqq.activity.aio.photo.l.b(qQAppInterface.getApp(), f202907b);
        int i18 = configurationService$Config.version.get();
        if (b16 != i18) {
            HashSet hashSet = new HashSet();
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                if (configurationService$Content != null && configurationService$Content.content.has()) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                        stringUtf8 = null;
                        if (d16 != null) {
                            try {
                                stringUtf8 = new String(d16, "UTF-8");
                            } catch (Exception e16) {
                                QLog.e("PhotoListConfig", 1, "handlePhotoListConfig|uncompress failed" + e16);
                            }
                        }
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    if (stringUtf8 != null) {
                        try {
                            jSONObject = new JSONObject(stringUtf8);
                            QLog.i("PhotoListConfig", 1, "handlePhotoListConfig content" + stringUtf8);
                            i16 = jSONObject.getInt("limitSize");
                            try {
                                i3 = jSONObject.getInt("limitWidth");
                            } catch (Exception e17) {
                                e = e17;
                                i3 = 0;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            i3 = 0;
                        }
                        try {
                            JSONArray jSONArray = jSONObject.getJSONArray("blackPathList");
                            if (jSONArray != null && jSONArray.length() > 0) {
                                while (i17 < jSONArray.length()) {
                                    String string = ((JSONObject) jSONArray.get(i17)).getString("blackPath");
                                    if (!TextUtils.isEmpty(string)) {
                                        hashSet.add(string);
                                    }
                                    i17++;
                                }
                            }
                        } catch (Exception e19) {
                            e = e19;
                            i17 = i16;
                            QLog.e("PhotoListConfig", 1, "handlePttSttConfig failed" + e);
                            i16 = i17;
                            com.tencent.mobileqq.activity.aio.photo.l.a(qQAppInterface).e(qQAppInterface, i16, i3, hashSet);
                            com.tencent.mobileqq.activity.aio.photo.l.d(qQAppInterface.getApp(), f202907b, i18);
                            return;
                        }
                        com.tencent.mobileqq.activity.aio.photo.l.a(qQAppInterface).e(qQAppInterface, i16, i3, hashSet);
                    }
                } else {
                    QLog.i("PhotoListConfig", 1, "empty content");
                }
            } else {
                QLog.i("PhotoListConfig", 1, "empty config clear local");
                com.tencent.mobileqq.activity.aio.photo.l.a(qQAppInterface).e(qQAppInterface, 0, 0, hashSet);
            }
            com.tencent.mobileqq.activity.aio.photo.l.d(qQAppInterface.getApp(), f202907b, i18);
            return;
        }
        QLog.e("PhotoListConfig", 1, String.format("same version", Integer.valueOf(b16)));
    }

    public void i1(AppRuntime appRuntime, List<Integer> list) {
        File[] listFiles;
        final QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        for (Integer num : list) {
            if (!am.s().Q(num.intValue())) {
                if (QLog.isColorLevel()) {
                    QLog.w("SPLASH_ConfigServlet", 2, "receiveAllConfigs|noReceiveType: " + num + ",length: " + list.size());
                }
                int intValue = num.intValue();
                boolean z16 = false;
                if (intValue != 1) {
                    if (intValue != 38) {
                        if (intValue != 42) {
                            if (intValue != 116) {
                                if (intValue != 185) {
                                    if (intValue != 188) {
                                        if (intValue != 191) {
                                            if (intValue != 205) {
                                                if (intValue != 215) {
                                                    if (intValue == 223 || intValue == 364 || intValue == 365) {
                                                        BusinessCommonConfig.getInstance(qQAppInterface).handleResp_Config_NoResp(qQAppInterface, num.intValue());
                                                    }
                                                } else {
                                                    AEOldShortVideoResManager.E();
                                                }
                                            } else if (QLog.isColorLevel()) {
                                                QLog.d("SPLASH_ConfigServlet", 2, "config is newest .handleResp_GetArScanFacePreDownConfig  no receive respConfig");
                                            }
                                        } else {
                                            ((AppGuideTipsManager) qQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).h();
                                        }
                                    } else if (QLog.isColorLevel()) {
                                        QLog.d("ArConfig_AR_GLOBAL_CONTROL_COFIG", 2, "handleResp_AR_GLOBAL_CONTROL_COFIG:no receive respConfig");
                                    }
                                } else {
                                    ScribbleResMgr.L().T();
                                }
                            } else if (!UpgradeConfigTypeParser.d()) {
                                QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigNoReceive|GET_CONFIG_UPGRADE useFreesia");
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE no config, use local config.");
                                }
                                ConfigHandler configHandler = (ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
                                String b16 = com.tencent.mobileqq.upgrade.f.b("config_upgrade_", f202907b);
                                if (QLog.isColorLevel()) {
                                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE configContent=" + b16);
                                }
                                if (TextUtils.isEmpty(b16)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE local config is empty, reset local version to 0.");
                                    }
                                    ea.y4(qQAppInterface.getApp(), f202907b, 0);
                                    com.tencent.mobileqq.upgrade.f.a("config_upgrade_", f202907b);
                                    configHandler.m3(k.i().j());
                                } else {
                                    UpgradeDetailWrapper j3 = k.i().j();
                                    j3.e(b16, "manager");
                                    if (!j3.f306171e.isValid) {
                                        QLog.d("SPLASH_ConfigServlet", 1, "[receiveAllConfigNoReceive] config invalid.");
                                    } else {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SPLASH_ConfigServlet", 2, String.format("receiveAllConfigs|GET_CONFIG_UPGRADE localAppID=%s configAppID=%s", Integer.valueOf(AppSetting.f()), Integer.valueOf(j3.f306171e.iUpgradeSdkId)));
                                        }
                                        if (AppSetting.f() >= j3.f306171e.iUpgradeSdkId) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE already upgraded, delete local config.");
                                            }
                                            ea.y4(qQAppInterface.getApp(), f202907b, 0);
                                            com.tencent.mobileqq.upgrade.f.a("config_upgrade_", f202907b);
                                            j3.f306171e.iUpgradeType = 0;
                                            configHandler.m3(j3);
                                            configHandler.t3();
                                        } else {
                                            synchronized (j3) {
                                                if (!j3.f306175m) {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE waiting switch bit.");
                                                    }
                                                } else {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE do upgrade.");
                                                    }
                                                    if (j3.D == 0) {
                                                        if (j3.C == 1) {
                                                            z16 = true;
                                                        }
                                                        ConfigHandler.w3(qQAppInterface, z16);
                                                    }
                                                    k.i().o(j3.f306171e, configHandler);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            ((IQWalletConfigService) qQAppInterface.getRuntimeService(IQWalletConfigService.class)).handleQWalletSettingCofig(null);
                        }
                    } else {
                        SharedPreferences X0 = ea.X0(qQAppInterface.getCurrentAccountUin());
                        X0.edit().remove(AppConstants.Preferences.QAV_UPGRADE_INVITE_VIDEO).commit();
                        X0.edit().remove(AppConstants.Preferences.QAV_UPGRADE_INVITE_MULTI).commit();
                    }
                } else {
                    final String str = qQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/splashpic/";
                    File file = new File(str);
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                        for (final File file2 : listFiles) {
                            if (file2 != null) {
                                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.config.splashlogo.ConfigServlet.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        String[] split = file2.getName().split("\\.");
                                        if (split != null && split.length == 3) {
                                            if (QLog.isColorLevel()) {
                                                QLog.i("SPLASH_ConfigServlet", 2, "has a failed splash task, begin to check time ");
                                            }
                                            boolean z17 = false;
                                            String str2 = split[0];
                                            long j16 = 0;
                                            if (str2 != null && !str2.trim().equals("")) {
                                                try {
                                                    int indexOf = str2.indexOf("|");
                                                    Long.parseLong(str2.substring(0, indexOf));
                                                    j16 = Long.parseLong(str2.substring(indexOf + 1));
                                                } catch (Exception unused) {
                                                }
                                            }
                                            if (System.currentTimeMillis() < j16) {
                                                FileInputStream fileInputStream = null;
                                                try {
                                                    try {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.i("SPLASH_ConfigServlet", 2, "time is effective, begin to retry download and check a splash ");
                                                        }
                                                        FileInputStream fileInputStream2 = new FileInputStream(file2);
                                                        try {
                                                            byte[] bArr = new byte[fileInputStream2.available()];
                                                            fileInputStream2.read(bArr);
                                                            String str3 = new String(bArr, "UTF-8");
                                                            if (str3.length() > 5) {
                                                                File file3 = new File(str + split[1]);
                                                                if (file3.exists()) {
                                                                    file3.delete();
                                                                }
                                                                boolean download = HttpDownloadUtil.download(qQAppInterface, str3, file3);
                                                                if (download && file3.exists()) {
                                                                    try {
                                                                        if (MD5.getFileMD5(file3).equalsIgnoreCase(split[1])) {
                                                                            if (QLog.isColorLevel()) {
                                                                                QLog.d("SPLASH_ConfigServlet", 2, "retry download and check successed");
                                                                            }
                                                                            new File(str + split[0] + "_" + split[1] + "_" + split[2]).createNewFile();
                                                                            z17 = true;
                                                                        }
                                                                    } catch (FileNotFoundException e16) {
                                                                        e16.printStackTrace();
                                                                        if (QLog.isColorLevel()) {
                                                                            QLog.d("SPLASH_ConfigServlet", 2, "retry download successed  but check get a file not found exception", e16);
                                                                        }
                                                                    }
                                                                }
                                                                if (!download || !z17) {
                                                                    if (QLog.isColorLevel()) {
                                                                        QLog.i("SPLASH_ConfigServlet", 2, "retry download and check a splash failed");
                                                                    }
                                                                    if (file3.exists()) {
                                                                        file3.delete();
                                                                    }
                                                                    if (file2.exists()) {
                                                                        file2.delete();
                                                                    }
                                                                }
                                                            }
                                                            try {
                                                                fileInputStream2.close();
                                                            } catch (Exception e17) {
                                                                e = e17;
                                                                e.printStackTrace();
                                                                if (!QLog.isColorLevel()) {
                                                                    return;
                                                                }
                                                                QLog.d("SPLASH_ConfigServlet", 2, "close inputstream got a exception", e);
                                                            }
                                                        } catch (Exception e18) {
                                                            e = e18;
                                                            fileInputStream = fileInputStream2;
                                                            if (QLog.isColorLevel()) {
                                                                QLog.d("SPLASH_ConfigServlet", 2, "retry download and check but get a exception", e);
                                                            }
                                                            if (file2.exists()) {
                                                                file2.delete();
                                                            }
                                                            if (fileInputStream != null) {
                                                                try {
                                                                    fileInputStream.close();
                                                                } catch (Exception e19) {
                                                                    e = e19;
                                                                    e.printStackTrace();
                                                                    if (!QLog.isColorLevel()) {
                                                                        return;
                                                                    }
                                                                    QLog.d("SPLASH_ConfigServlet", 2, "close inputstream got a exception", e);
                                                                }
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            fileInputStream = fileInputStream2;
                                                            if (fileInputStream != null) {
                                                                try {
                                                                    fileInputStream.close();
                                                                } catch (Exception e26) {
                                                                    e26.printStackTrace();
                                                                    if (QLog.isColorLevel()) {
                                                                        QLog.d("SPLASH_ConfigServlet", 2, "close inputstream got a exception", e26);
                                                                    }
                                                                }
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                    }
                                                } catch (Exception e27) {
                                                    e = e27;
                                                }
                                            } else {
                                                if (QLog.isColorLevel()) {
                                                    QLog.i("SPLASH_ConfigServlet", 2, "has a failed splash task but is outdate ");
                                                }
                                                if (file2.exists()) {
                                                    file2.delete();
                                                }
                                            }
                                        }
                                    }
                                }, 5, null, true);
                            }
                        }
                    }
                }
            }
        }
    }

    void j0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG response");
        }
        try {
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                int i3 = configurationService$Config.version.get();
                int publicAccountQQMailConfigVersionCode = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountQQMailConfigVersionCode(qQAppInterface);
                if (i3 != publicAccountQQMailConfigVersionCode) {
                    for (int i16 = 0; i16 < configurationService$Config.msg_content_list.size(); i16++) {
                        ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(i16);
                        if (configurationService$Content != null) {
                            if (configurationService$Content.compress.get() == 1) {
                                byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                                if (d16 != null) {
                                    try {
                                        stringUtf8 = new String(d16, "UTF-8");
                                    } catch (Exception e16) {
                                        e16.printStackTrace();
                                    }
                                }
                                stringUtf8 = null;
                            } else {
                                stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 184, version:" + configurationService$Config.version.get() + ", content:" + stringUtf8);
                            }
                            ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).updatePublicAccountQQMailConfigData(qQAppInterface, stringUtf8, i3);
                        } else if (QLog.isColorLevel()) {
                            QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG remote version: " + i3 + " | localVersion: " + publicAccountQQMailConfigVersionCode);
                        }
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG content_list is empty");
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG error", e17);
            }
            e17.printStackTrace();
        }
    }

    public void j1(int[] iArr, FromServiceMsg fromServiceMsg) {
        com.tencent.mobileqq.soload.config.b.a(iArr, fromServiceMsg);
        for (int i3 : iArr) {
            if (i3 == 215) {
                AEOldShortVideoResManager.D(-5);
                ms.a.c("SPLASH_ConfigServlet", "\u3010SHORT_VIDEO_RESOURCE_CONFIG\u3011RES_OVERTIME");
            }
        }
    }

    void l0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField;
        ConfigurationService$Content configurationService$Content;
        String stringUtf8;
        int f16 = ea.f1(qQAppInterface.getApp(), f202907b);
        int i3 = configurationService$Config.version.get();
        if (f16 != i3 && (pBRepeatMessageField = configurationService$Config.msg_content_list) != null && pBRepeatMessageField.size() > 0 && (configurationService$Content = configurationService$Config.msg_content_list.get(0)) != null) {
            if (configurationService$Content.compress.get() == 1) {
                byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                stringUtf8 = null;
                if (d16 != null) {
                    try {
                        stringUtf8 = new String(d16, "UTF-8");
                    } catch (Exception unused) {
                        QLog.d("SPLASH_ConfigServlet", 2, "handleQQPreDownYYBConfig|uncompress failed");
                    }
                }
            } else {
                stringUtf8 = configurationService$Content.content.get().toStringUtf8();
            }
            if (stringUtf8 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(stringUtf8);
                    boolean z16 = jSONObject.getBoolean("wifiAutoPreDown");
                    boolean z17 = jSONObject.getBoolean("noSafeDown");
                    ea.h3(qQAppInterface.getApp(), "wifiAutoPreDown", "" + z16);
                    ea.h3(qQAppInterface.getApp(), "noSafeDown", "" + z17);
                    ea.C4(qQAppInterface.getApp(), f202907b, i3);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public void r0(Intent intent, boolean z16, ConfigurationService$Config configurationService$Config, int i3) {
        int i16;
        int i17;
        int i18 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] ENTER success=" + z16 + " result=" + i3);
        }
        String stringExtra = intent.getStringExtra("uin");
        int i19 = 0;
        if (z16 && configurationService$Config != null && configurationService$Config.type.get() == 109 && i3 == 0) {
            i16 = configurationService$Config.version.get();
            i17 = intent.getIntExtra("qcamera_conf_version", 0);
            QLog.i("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] reqVersion=" + i17 + " receiveVersion=" + i16);
            if (i16 != i17) {
                com.tencent.mobileqq.camera.utils.a.r(BaseApplication.getContext(), i16);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] save version: " + i16 + " and check config version: " + com.tencent.mobileqq.camera.utils.a.e(BaseApplication.getContext()));
                }
                PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
                if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                    ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                    int i26 = configurationService$Content.task_id.get();
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] c16 = com.tencent.mobileqq.camera.utils.a.c(configurationService$Content.content.get().toByteArray());
                        if (c16 == null) {
                            com.tencent.mobileqq.camera.utils.a.q(BaseApplication.getContext(), true);
                            QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] uncompress failed");
                            i19 = 4;
                        } else {
                            String str = new String(c16);
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig] zip");
                            }
                            try {
                                com.tencent.mobileqq.camera.utils.a.m(BaseApplication.getContext(), str, i16);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                i19 = 3;
                            }
                        }
                    } else {
                        String stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig]");
                        }
                        try {
                            com.tencent.mobileqq.camera.utils.a.m(BaseApplication.getContext(), stringUtf8, i16);
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            i18 = 3;
                        }
                    }
                    i18 = i19;
                    i19 = i26;
                } else {
                    QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] no data, current disableCameraSDK=" + com.tencent.mobileqq.camera.utils.a.d(BaseApplication.getContext()));
                    i18 = 5;
                }
            }
        } else {
            i16 = 0;
            i17 = 0;
            i18 = 1;
        }
        QLog.i("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] rptResult=" + i18);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("rpt_type", String.valueOf(109));
        hashMap.put("rpt_task_id", String.valueOf(i19));
        hashMap.put("rpt_req_version", String.valueOf(i17));
        hashMap.put("rpt_version", String.valueOf(i16));
        hashMap.put("rpt_report_type", String.valueOf(1));
        hashMap.put("rpt_result", String.valueOf(i18));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(stringExtra, "qcamera_phone_config_pull_event", z16, 0L, 0L, hashMap, String.valueOf(i18));
    }

    void t0(QQAppInterface qQAppInterface, Intent intent, ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig |  type= " + configurationService$Config.type.get());
        }
        if (configurationService$Config.type.get() != 205) {
            return;
        }
        if (intent.getIntExtra("key_download_cfg_version", 0) == configurationService$Config.version.get()) {
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, version same");
                return;
            }
            return;
        }
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
            ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
            if (configurationService$Content == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, content is null");
                    return;
                }
                return;
            }
            if (configurationService$Content.compress.get() == 1) {
                byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                stringUtf8 = null;
                if (d16 != null) {
                    try {
                        str = new String(d16, "UTF-8");
                    } catch (UnsupportedEncodingException e16) {
                        if (QLog.isColorLevel()) {
                            e16.printStackTrace();
                        }
                    } catch (OutOfMemoryError e17) {
                        if (QLog.isColorLevel()) {
                            e17.printStackTrace();
                        }
                        System.gc();
                        try {
                            str = new String(d16, "UTF-8");
                        } catch (Throwable unused) {
                        }
                    }
                    stringUtf8 = str;
                }
            } else {
                stringUtf8 = configurationService$Content.content.get().toStringUtf8();
            }
            if (stringUtf8 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, config_content is " + stringUtf8);
                }
                FaceScanDownloadManager.l(qQAppInterface, stringUtf8, configurationService$Config.version.get());
            } else {
                FaceScanDownloadManager.c(qQAppInterface);
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig we delete ARConfig info here");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, config type 205");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig we delete ARConfig info here");
        }
    }

    void x(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        ConfigurationService$Content configurationService$Content;
        String stringUtf8;
        if (configurationService$Config.type.get() != 191) {
            return;
        }
        int p16 = ea.p(qQAppInterface.getApp(), f202907b);
        int i3 = configurationService$Config.version.get();
        if (i3 != p16) {
            if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "handleAppGuideTipsConfig, new version : " + i3);
            }
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0 && (configurationService$Content = configurationService$Config.msg_content_list.get(0)) != null) {
                if (configurationService$Content.compress.get() == 1) {
                    byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                    stringUtf8 = null;
                    if (d16 != null) {
                        try {
                            stringUtf8 = new String(d16, "UTF-8");
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                }
                if (stringUtf8 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "handleAppGuideTipsConfig content" + stringUtf8);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(stringUtf8);
                        if (jSONObject.length() > 0) {
                            ArrayList arrayList = new ArrayList();
                            Iterator keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String str = (String) keys.next();
                                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                                AppGuideTipsConfig appGuideTipsConfig = new AppGuideTipsConfig();
                                appGuideTipsConfig.tipsType = str;
                                appGuideTipsConfig.switchKey = optJSONObject.getString(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                                appGuideTipsConfig.maxCount = Integer.valueOf(optJSONObject.getString("total")).intValue();
                                appGuideTipsConfig.duration = Long.valueOf(optJSONObject.getString("duration")).longValue();
                                appGuideTipsConfig.tipsUrl = optJSONObject.getString("url");
                                appGuideTipsConfig.opkey = optJSONObject.getString("opkey");
                                appGuideTipsConfig.msgTypeStr = optJSONObject.getString("androidtypes");
                                if ("1".equals(str)) {
                                    if (optJSONObject.has("message")) {
                                        appGuideTipsConfig.tipsMsg = optJSONObject.getString("message");
                                    } else {
                                        appGuideTipsConfig.tipsMsg = optJSONObject.getString(FileReaderHelper.TXT_EXT);
                                    }
                                    if (optJSONObject.has("title")) {
                                        appGuideTipsConfig.tipsHighLight = optJSONObject.getString("title");
                                    } else {
                                        appGuideTipsConfig.tipsHighLight = optJSONObject.getString("htxt");
                                    }
                                } else {
                                    appGuideTipsConfig.tipsMsg = optJSONObject.getString(FileReaderHelper.TXT_EXT);
                                    appGuideTipsConfig.tipsHighLight = optJSONObject.getString("htxt");
                                }
                                arrayList.add(appGuideTipsConfig);
                            }
                            AppGuideTipsManager appGuideTipsManager = (AppGuideTipsManager) qQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER);
                            appGuideTipsManager.m(arrayList);
                            appGuideTipsManager.h();
                            ea.x3(qQAppInterface.getApp(), f202907b, i3);
                        }
                    } catch (Exception e16) {
                        QLog.e("SPLASH_ConfigServlet", 1, "handleAppGuideTipsConfig failed" + e16);
                    }
                }
            }
        }
    }

    public void z(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        List<String> X0;
        int i3 = configurationService$Config.version.get();
        if (i3 != ((IQIMBeautyManager) QRoute.api(IQIMBeautyManager.class)).getBeautyConfigVersion(qQAppInterface.getApp()) && (X0 = X0(configurationService$Config)) != null && X0.size() > 0) {
            ((IQIMBeautyManager) QRoute.api(IQIMBeautyManager.class)).saveBeautyConfig(X0.get(0), i3, qQAppInterface.getApp());
        }
    }

    public void z0(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        if (configurationService$Config != null && configurationService$Config.type.get() == 283) {
            List<String> X0 = X0(configurationService$Config);
            if (X0 != null && X0.size() > 0) {
                String str = X0.get(0);
                QLog.d("SafeModeUtil", 1, "handleSafeModeCmd configJson = " + str);
                MsfCmdConfig.executeManageSafeModeCmd(configurationService$Config.version.get(), str);
            } else {
                QLog.d("SafeModeUtil", 1, "handleSafeModeCmd null");
                com.tencent.qqperf.crashdefend.d.e().h(1, false);
            }
            SafeModeUtil.c();
            return;
        }
        QLog.d("SafeModeUtil", 2, "handleSafeModeCmd configJson = null");
        com.tencent.qqperf.crashdefend.d.e().h(1, false);
    }

    public void e1(ConfigurationService$RespGetConfig configurationService$RespGetConfig) {
    }

    private void P(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
    }

    private void y(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
    }
}
