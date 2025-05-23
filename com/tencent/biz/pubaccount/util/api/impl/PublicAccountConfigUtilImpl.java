package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.c;
import com.tencent.cache.api.collection.QQHashMap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LebaIconDownloader;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.eb;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes32.dex */
public class PublicAccountConfigUtilImpl implements IPublicAccountConfigUtil {
    public static final String CONFIG_CUKINGCARD_DLG_SWITCH = "CUKingCard_Dlg";
    public static final String CONFIG_INTEREST_SETTING_RN_ENABLE = "rn_switch";
    public static final String CONFIG_MULTI_VIDEO_DYNAMIC_RECOMMEND_DURATION_LIMIT = "multi_video_dynamic_recommend_duration_limit";
    public static final String CONFIG_MULTI_VIDEO_DYNAMIC_RECOMMEND_DURATION_PERCENT = "multi_video_dynamic_recommend_duration_percent";
    public static final String CONFIG_MULTI_VIDEO_DYNAMIC_RECOMMEND_OPERATOR = "multi_video_dynamic_recommend_operator";
    public static final String CONFIG_MULTI_VIDEO_DYNAMIC_RECOMMEND_STRATEGY = "multi_video_dynamic_recommend_strategyid";
    public static final String CONFIG_PA_SUBSCRIBE_MSG_TAG = "msg";
    public static final String CONFIG_PA_SUBSCRIBE_SHOW_TAG = "show";
    public static final String CONFIG_PUBLIC_ACCOUNT_FOLDER_ICON_TAG = "icon";
    public static final String CONFIG_PUBLIC_ACCOUNT_FOLDER_ID_TAG = "id";
    public static final String CONFIG_PUBLIC_ACCOUNT_FOLDER_NAME_TAG = "name";
    public static final String CONFIG_PUBLIC_ACCOUNT_FOLDER_TAG = "public-account-folder";
    public static final String CONFIG_PUBLIC_ACCOUNT_VERSION = "version";
    public static final String CONFIG_SUBSCRIPT_FULL_RECOMMEND_TAG = "recommendFullScreen";
    public static final String CONFIG_SUBSCRIPT_FULL_RECOMMEND_URL_TAG = "recommendURL";
    public static final String CONFIG_SUBSCRIPT_FULL_RECOMMEND_VERSION = "recommendFullVersion";
    public static final String CONFIG_SUBSCRIPT_INNER_RECOMMEND_TAG = "recommendBottom";
    public static final String CONFIG_SUBSCRIPT_INNER_RECOMMEND_VERSION = "recommendBottomVersion";
    public static final String CONFIG_VIDEO_CHANNEL_AUTOPLAY_SWITCH = "videochannel_video_autoplay";
    public static final String CONFIG_VIDEO_CHANNEL_AUTOPLAY_SWITCH_VIDEO_FLOW = "videochannel_video_autoplay_18mo";
    public static final String CONFIG_VIDEO_CHANNEL_COVER_STYLE = "video_channel_style";
    public static final String CONFIG_VIDEO_CHANNEL_FEEDS_CLICK_SWITCH = "click_videocard_jump_comment";
    public static final String CONFIG_VIDEO_CHANNEL_INFO_ID = "channel_id";
    public static final String CONFIG_VIDEO_CHANNEL_INFO_NAME = "channel_name";
    public static final String CONFIG_VIDEO_CHANNEL_INFO_TYPE = "channel_type";
    public static final String CONFIG_VIDEO_CHANNEL_INFO_VERSION = "channel_version";
    public static final String CONFIG_VIDEO_DEFAULT_BITRATE = "defaultBitRate";
    public static final String CONFIG_VIDEO_DYNAMIC_RECOMMEND_DURATION_LIMIT = "video_dynamic_recommend_duration_limit";
    public static final String CONFIG_VIDEO_DYNAMIC_RECOMMEND_DURATION_PERCENT = "video_dynamic_recommend_duration_percent";
    public static final String CONFIG_VIDEO_DYNAMIC_RECOMMEND_OPERATOR = "video_dynamic_recommend_operator";
    public static final String CONFIG_VIDEO_DYNAMIC_RECOMMEND_STRATEGY = "video_dynamic_recommend_strategyid";
    public static final String CONFIG_VIDEO_JUMP_DEFAULT_VALUE = "video_jump_to";
    public static final String CONFIG_VIDEO_MULTI_VIDEO_SUPPORT_ENABLE = "multi_video_support_enable";
    public static final String CONFIG_VIDEO_SOCIAL_SWITCH = "video_social_switch";
    public static final String CONFIG_VIDEO_SOUND = "video_sound";
    public static final String CONFIG_VIDEO_STRUCTMSG_SWITCH = "video_struct_switch";
    public static final String CONFIG_VIOLA_DYNAMIC = "viola_dynamic_switch";
    public static final String CONFIG_VIOLA_DYNAMIC_DISCOVER = "viola_discover_switch";
    public static final String CONFIG_VIOLA_DYNAMIC_MESSAGE_BOX = "viola_message_box_switch";
    public static final String CONFIG_VIOLA_DYNAMIC_WEISHI = "viola_dynamic_weishi_switch";
    public static final String CONFIG_WEB_NATIVE_RENDER = "web_viola_render_switch";
    public static final String CONFIG_WEB_NATIVE_RENDER_MODE = "web_viola_render_mode";
    public static final int PUBLIC_ACCOUNT_SUBSCRIPT_FOLDER_DEFAULT_ICON = 2131237137;
    public static final int PUBLIC_ACCOUNT_SUBSCRIPT_FOLDER_DEFAULT_NAME = 2131897174;
    public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_FOLDER_DEFAULT_ICON = 2131237142;
    public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_FOLDER_DEFAULT_NAME = 2131896140;
    public static final String READINJOY_FOLDER_CONFIG_ID_TAG = "id";
    public static final String READINJOY_FOLDER_ICON_TAG = "icon";
    public static final String READINJOY_FOLDER_NICKNAME_TAG = "name";
    public static final String READINJOY_READ_DATA_TAG = "kandian_read_data";
    private static String SERVICE_ACCOUNT_FOLDER_ICON;
    public static String SERVICE_ACCOUNT_FOLDER_NAME;
    private static final AtomicBoolean initiatedCache = new AtomicBoolean(false);
    private static QQHashMap<Integer, IPublicAccountConfigUtil.a> list = null;
    public static final String PUBLIC_ACCOUNT_CENTER_DEFAULT_URL = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    public static String PUBLIC_ACCOUNT_CENTER_URL = PUBLIC_ACCOUNT_CENTER_DEFAULT_URL;
    public static final String PUBLIC_ACCOUNT_CATEGORY_DEFAULT_URL = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    public static String PUBLIC_ACCOUNT_CATEGORY_URL = PUBLIC_ACCOUNT_CATEGORY_DEFAULT_URL;
    public static String READINJOY_SEARCH_URL = null;
    public static boolean SERVICE_ACCOUNT_FOLDER_DELETE = true;
    public static boolean SERVICE_FOLDER_REDSPOTS = false;
    public static boolean SERVICE_FOLDER_RED_DELETE = false;
    public static boolean IMAGE_COLLECTION_COMMENT = false;
    public static boolean readInJoyFeedsPreload = false;
    public static boolean readInJoyFeedsPreloadWifi = false;
    public static boolean readInJoyFeedsPreload4G = false;
    public static boolean readInJoyFeedsPreload3G = false;
    public static boolean readInJoyFeedsPreload2G = false;
    public static boolean readInJoyFeedsImagePreload = false;
    public static String readInJoyflingLToRHost = "";
    public static long readInJoyADBackgroundShowTime = 3000;
    public static int readInJoyADGuideCardShowTime = 10;
    public static boolean preloadToolProcess = true;
    public static String readInJoyPreloadToolConfig = "";
    public static String readInJoyReleaseWebServiceConfig = "";
    public static boolean needPABottomBar = false;
    public static boolean readInJoyIpConnect = false;
    public static int readInJoyIpConnectReportSwitch = 0;
    public static String readInJoyIpConnectReportTail = "";
    public static boolean readInJoyLoadImg = false;
    public static boolean disableBigDataChannel = false;
    public static ArrayList<String> bigDataChannelWhiteList = new ArrayList<>();
    public static int imageCollectionPreload = 0;
    public static int imageCollectionPreloadCover = 0;
    public static int imageCollectionPreloadImage = 0;
    public static boolean ServiceFolder_RedClean_After_Enter = false;

    /* loaded from: classes32.dex */
    public static class b implements LebaIconDownloader.b {

        /* renamed from: a, reason: collision with root package name */
        IPublicAccountConfigUtil.a f80206a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<AppInterface> f80207b;

        /* renamed from: c, reason: collision with root package name */
        String f80208c;

        public b(IPublicAccountConfigUtil.a aVar, AppInterface appInterface, String str) {
            this.f80207b = null;
            this.f80208c = "";
            this.f80206a = aVar;
            this.f80207b = new WeakReference<>(appInterface);
            this.f80208c = str;
        }

        @Override // com.tencent.mobileqq.activity.LebaIconDownloader.b
        public void a(int i3, String str, Drawable drawable, Object... objArr) {
            IPublicAccountConfigUtil.a aVar;
            if (QLog.isColorLevel()) {
                QLog.d(IPublicAccountConfigUtil.TAG, 2, "PublicAccountConfigFolder IDownloadListener fail, status: " + i3 + " | icon: " + drawable + " | mFolder: " + this.f80206a);
            }
            if (i3 != 2 || drawable == null || (aVar = this.f80206a) == null) {
                return;
            }
            aVar.e(drawable);
            try {
                this.f80207b.get().getBusinessHandler(BusinessHandlerFactory.AVATAR_HANDLER).notifyUI(1, true, new Object[]{this.f80208c});
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(IPublicAccountConfigUtil.TAG, 2, "PublicAccountConfigFolder IDownloadListener fail", e16);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0461 A[Catch: Exception -> 0x05d9, TryCatch #0 {Exception -> 0x05d9, blocks: (B:7:0x0049, B:10:0x0057, B:11:0x005e, B:13:0x0064, B:14:0x0068, B:16:0x006f, B:18:0x0075, B:20:0x007f, B:22:0x00a6, B:24:0x00ac, B:26:0x00b8, B:28:0x00d4, B:30:0x00da, B:31:0x00fb, B:33:0x0101, B:35:0x010d, B:37:0x0129, B:39:0x012f, B:41:0x013b, B:43:0x0157, B:45:0x015d, B:47:0x0169, B:49:0x0185, B:51:0x018b, B:53:0x0197, B:55:0x01b3, B:57:0x01b9, B:59:0x01c5, B:61:0x01e1, B:63:0x01e7, B:65:0x01f3, B:67:0x020f, B:69:0x0215, B:71:0x0221, B:73:0x023d, B:75:0x0243, B:77:0x024f, B:79:0x026b, B:81:0x0271, B:83:0x0281, B:85:0x029a, B:87:0x02a4, B:89:0x02b4, B:91:0x02d3, B:93:0x02db, B:95:0x02e7, B:97:0x0303, B:99:0x030b, B:101:0x0314, B:103:0x0329, B:105:0x0350, B:107:0x0358, B:109:0x0364, B:111:0x0387, B:113:0x0390, B:115:0x039f, B:117:0x03c2, B:119:0x03cb, B:121:0x03da, B:124:0x03ff, B:126:0x0408, B:129:0x041c, B:131:0x0422, B:133:0x0433, B:135:0x044d, B:138:0x0456, B:140:0x0461, B:142:0x0470, B:144:0x048c, B:146:0x0495, B:148:0x04a4, B:150:0x04c0, B:152:0x04c9, B:154:0x04d8, B:156:0x04f4, B:158:0x04fd, B:160:0x050c, B:162:0x052f, B:164:0x0538, B:166:0x0542, B:168:0x056b, B:170:0x0574, B:172:0x057c, B:200:0x05c8, B:202:0x05d2), top: B:6:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0495 A[Catch: Exception -> 0x05d9, TryCatch #0 {Exception -> 0x05d9, blocks: (B:7:0x0049, B:10:0x0057, B:11:0x005e, B:13:0x0064, B:14:0x0068, B:16:0x006f, B:18:0x0075, B:20:0x007f, B:22:0x00a6, B:24:0x00ac, B:26:0x00b8, B:28:0x00d4, B:30:0x00da, B:31:0x00fb, B:33:0x0101, B:35:0x010d, B:37:0x0129, B:39:0x012f, B:41:0x013b, B:43:0x0157, B:45:0x015d, B:47:0x0169, B:49:0x0185, B:51:0x018b, B:53:0x0197, B:55:0x01b3, B:57:0x01b9, B:59:0x01c5, B:61:0x01e1, B:63:0x01e7, B:65:0x01f3, B:67:0x020f, B:69:0x0215, B:71:0x0221, B:73:0x023d, B:75:0x0243, B:77:0x024f, B:79:0x026b, B:81:0x0271, B:83:0x0281, B:85:0x029a, B:87:0x02a4, B:89:0x02b4, B:91:0x02d3, B:93:0x02db, B:95:0x02e7, B:97:0x0303, B:99:0x030b, B:101:0x0314, B:103:0x0329, B:105:0x0350, B:107:0x0358, B:109:0x0364, B:111:0x0387, B:113:0x0390, B:115:0x039f, B:117:0x03c2, B:119:0x03cb, B:121:0x03da, B:124:0x03ff, B:126:0x0408, B:129:0x041c, B:131:0x0422, B:133:0x0433, B:135:0x044d, B:138:0x0456, B:140:0x0461, B:142:0x0470, B:144:0x048c, B:146:0x0495, B:148:0x04a4, B:150:0x04c0, B:152:0x04c9, B:154:0x04d8, B:156:0x04f4, B:158:0x04fd, B:160:0x050c, B:162:0x052f, B:164:0x0538, B:166:0x0542, B:168:0x056b, B:170:0x0574, B:172:0x057c, B:200:0x05c8, B:202:0x05d2), top: B:6:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04c9 A[Catch: Exception -> 0x05d9, TryCatch #0 {Exception -> 0x05d9, blocks: (B:7:0x0049, B:10:0x0057, B:11:0x005e, B:13:0x0064, B:14:0x0068, B:16:0x006f, B:18:0x0075, B:20:0x007f, B:22:0x00a6, B:24:0x00ac, B:26:0x00b8, B:28:0x00d4, B:30:0x00da, B:31:0x00fb, B:33:0x0101, B:35:0x010d, B:37:0x0129, B:39:0x012f, B:41:0x013b, B:43:0x0157, B:45:0x015d, B:47:0x0169, B:49:0x0185, B:51:0x018b, B:53:0x0197, B:55:0x01b3, B:57:0x01b9, B:59:0x01c5, B:61:0x01e1, B:63:0x01e7, B:65:0x01f3, B:67:0x020f, B:69:0x0215, B:71:0x0221, B:73:0x023d, B:75:0x0243, B:77:0x024f, B:79:0x026b, B:81:0x0271, B:83:0x0281, B:85:0x029a, B:87:0x02a4, B:89:0x02b4, B:91:0x02d3, B:93:0x02db, B:95:0x02e7, B:97:0x0303, B:99:0x030b, B:101:0x0314, B:103:0x0329, B:105:0x0350, B:107:0x0358, B:109:0x0364, B:111:0x0387, B:113:0x0390, B:115:0x039f, B:117:0x03c2, B:119:0x03cb, B:121:0x03da, B:124:0x03ff, B:126:0x0408, B:129:0x041c, B:131:0x0422, B:133:0x0433, B:135:0x044d, B:138:0x0456, B:140:0x0461, B:142:0x0470, B:144:0x048c, B:146:0x0495, B:148:0x04a4, B:150:0x04c0, B:152:0x04c9, B:154:0x04d8, B:156:0x04f4, B:158:0x04fd, B:160:0x050c, B:162:0x052f, B:164:0x0538, B:166:0x0542, B:168:0x056b, B:170:0x0574, B:172:0x057c, B:200:0x05c8, B:202:0x05d2), top: B:6:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04fd A[Catch: Exception -> 0x05d9, TryCatch #0 {Exception -> 0x05d9, blocks: (B:7:0x0049, B:10:0x0057, B:11:0x005e, B:13:0x0064, B:14:0x0068, B:16:0x006f, B:18:0x0075, B:20:0x007f, B:22:0x00a6, B:24:0x00ac, B:26:0x00b8, B:28:0x00d4, B:30:0x00da, B:31:0x00fb, B:33:0x0101, B:35:0x010d, B:37:0x0129, B:39:0x012f, B:41:0x013b, B:43:0x0157, B:45:0x015d, B:47:0x0169, B:49:0x0185, B:51:0x018b, B:53:0x0197, B:55:0x01b3, B:57:0x01b9, B:59:0x01c5, B:61:0x01e1, B:63:0x01e7, B:65:0x01f3, B:67:0x020f, B:69:0x0215, B:71:0x0221, B:73:0x023d, B:75:0x0243, B:77:0x024f, B:79:0x026b, B:81:0x0271, B:83:0x0281, B:85:0x029a, B:87:0x02a4, B:89:0x02b4, B:91:0x02d3, B:93:0x02db, B:95:0x02e7, B:97:0x0303, B:99:0x030b, B:101:0x0314, B:103:0x0329, B:105:0x0350, B:107:0x0358, B:109:0x0364, B:111:0x0387, B:113:0x0390, B:115:0x039f, B:117:0x03c2, B:119:0x03cb, B:121:0x03da, B:124:0x03ff, B:126:0x0408, B:129:0x041c, B:131:0x0422, B:133:0x0433, B:135:0x044d, B:138:0x0456, B:140:0x0461, B:142:0x0470, B:144:0x048c, B:146:0x0495, B:148:0x04a4, B:150:0x04c0, B:152:0x04c9, B:154:0x04d8, B:156:0x04f4, B:158:0x04fd, B:160:0x050c, B:162:0x052f, B:164:0x0538, B:166:0x0542, B:168:0x056b, B:170:0x0574, B:172:0x057c, B:200:0x05c8, B:202:0x05d2), top: B:6:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0538 A[Catch: Exception -> 0x05d9, TryCatch #0 {Exception -> 0x05d9, blocks: (B:7:0x0049, B:10:0x0057, B:11:0x005e, B:13:0x0064, B:14:0x0068, B:16:0x006f, B:18:0x0075, B:20:0x007f, B:22:0x00a6, B:24:0x00ac, B:26:0x00b8, B:28:0x00d4, B:30:0x00da, B:31:0x00fb, B:33:0x0101, B:35:0x010d, B:37:0x0129, B:39:0x012f, B:41:0x013b, B:43:0x0157, B:45:0x015d, B:47:0x0169, B:49:0x0185, B:51:0x018b, B:53:0x0197, B:55:0x01b3, B:57:0x01b9, B:59:0x01c5, B:61:0x01e1, B:63:0x01e7, B:65:0x01f3, B:67:0x020f, B:69:0x0215, B:71:0x0221, B:73:0x023d, B:75:0x0243, B:77:0x024f, B:79:0x026b, B:81:0x0271, B:83:0x0281, B:85:0x029a, B:87:0x02a4, B:89:0x02b4, B:91:0x02d3, B:93:0x02db, B:95:0x02e7, B:97:0x0303, B:99:0x030b, B:101:0x0314, B:103:0x0329, B:105:0x0350, B:107:0x0358, B:109:0x0364, B:111:0x0387, B:113:0x0390, B:115:0x039f, B:117:0x03c2, B:119:0x03cb, B:121:0x03da, B:124:0x03ff, B:126:0x0408, B:129:0x041c, B:131:0x0422, B:133:0x0433, B:135:0x044d, B:138:0x0456, B:140:0x0461, B:142:0x0470, B:144:0x048c, B:146:0x0495, B:148:0x04a4, B:150:0x04c0, B:152:0x04c9, B:154:0x04d8, B:156:0x04f4, B:158:0x04fd, B:160:0x050c, B:162:0x052f, B:164:0x0538, B:166:0x0542, B:168:0x056b, B:170:0x0574, B:172:0x057c, B:200:0x05c8, B:202:0x05d2), top: B:6:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0574 A[Catch: Exception -> 0x05d9, TryCatch #0 {Exception -> 0x05d9, blocks: (B:7:0x0049, B:10:0x0057, B:11:0x005e, B:13:0x0064, B:14:0x0068, B:16:0x006f, B:18:0x0075, B:20:0x007f, B:22:0x00a6, B:24:0x00ac, B:26:0x00b8, B:28:0x00d4, B:30:0x00da, B:31:0x00fb, B:33:0x0101, B:35:0x010d, B:37:0x0129, B:39:0x012f, B:41:0x013b, B:43:0x0157, B:45:0x015d, B:47:0x0169, B:49:0x0185, B:51:0x018b, B:53:0x0197, B:55:0x01b3, B:57:0x01b9, B:59:0x01c5, B:61:0x01e1, B:63:0x01e7, B:65:0x01f3, B:67:0x020f, B:69:0x0215, B:71:0x0221, B:73:0x023d, B:75:0x0243, B:77:0x024f, B:79:0x026b, B:81:0x0271, B:83:0x0281, B:85:0x029a, B:87:0x02a4, B:89:0x02b4, B:91:0x02d3, B:93:0x02db, B:95:0x02e7, B:97:0x0303, B:99:0x030b, B:101:0x0314, B:103:0x0329, B:105:0x0350, B:107:0x0358, B:109:0x0364, B:111:0x0387, B:113:0x0390, B:115:0x039f, B:117:0x03c2, B:119:0x03cb, B:121:0x03da, B:124:0x03ff, B:126:0x0408, B:129:0x041c, B:131:0x0422, B:133:0x0433, B:135:0x044d, B:138:0x0456, B:140:0x0461, B:142:0x0470, B:144:0x048c, B:146:0x0495, B:148:0x04a4, B:150:0x04c0, B:152:0x04c9, B:154:0x04d8, B:156:0x04f4, B:158:0x04fd, B:160:0x050c, B:162:0x052f, B:164:0x0538, B:166:0x0542, B:168:0x056b, B:170:0x0574, B:172:0x057c, B:200:0x05c8, B:202:0x05d2), top: B:6:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05d2 A[Catch: Exception -> 0x05d9, TRY_LEAVE, TryCatch #0 {Exception -> 0x05d9, blocks: (B:7:0x0049, B:10:0x0057, B:11:0x005e, B:13:0x0064, B:14:0x0068, B:16:0x006f, B:18:0x0075, B:20:0x007f, B:22:0x00a6, B:24:0x00ac, B:26:0x00b8, B:28:0x00d4, B:30:0x00da, B:31:0x00fb, B:33:0x0101, B:35:0x010d, B:37:0x0129, B:39:0x012f, B:41:0x013b, B:43:0x0157, B:45:0x015d, B:47:0x0169, B:49:0x0185, B:51:0x018b, B:53:0x0197, B:55:0x01b3, B:57:0x01b9, B:59:0x01c5, B:61:0x01e1, B:63:0x01e7, B:65:0x01f3, B:67:0x020f, B:69:0x0215, B:71:0x0221, B:73:0x023d, B:75:0x0243, B:77:0x024f, B:79:0x026b, B:81:0x0271, B:83:0x0281, B:85:0x029a, B:87:0x02a4, B:89:0x02b4, B:91:0x02d3, B:93:0x02db, B:95:0x02e7, B:97:0x0303, B:99:0x030b, B:101:0x0314, B:103:0x0329, B:105:0x0350, B:107:0x0358, B:109:0x0364, B:111:0x0387, B:113:0x0390, B:115:0x039f, B:117:0x03c2, B:119:0x03cb, B:121:0x03da, B:124:0x03ff, B:126:0x0408, B:129:0x041c, B:131:0x0422, B:133:0x0433, B:135:0x044d, B:138:0x0456, B:140:0x0461, B:142:0x0470, B:144:0x048c, B:146:0x0495, B:148:0x04a4, B:150:0x04c0, B:152:0x04c9, B:154:0x04d8, B:156:0x04f4, B:158:0x04fd, B:160:0x050c, B:162:0x052f, B:164:0x0538, B:166:0x0542, B:168:0x056b, B:170:0x0574, B:172:0x057c, B:200:0x05c8, B:202:0x05d2), top: B:6:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x048a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkServiceAccountFolderConfigData(AppInterface appInterface, String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z46;
        JSONObject jSONObject;
        boolean z47;
        boolean z48;
        boolean z49;
        boolean z55;
        boolean z56;
        boolean z57;
        boolean z58;
        boolean z59;
        boolean z65;
        boolean z66;
        boolean z67;
        boolean z68;
        boolean z69;
        boolean z75;
        boolean z76;
        boolean z77;
        String str2;
        boolean z78;
        boolean z79;
        boolean z85;
        boolean z86;
        MqqHandler handler;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.has("service_folder_name") ? jSONObject2.getString("service_folder_name") : "";
            String string2 = jSONObject2.has("service_folder_icon") ? jSONObject2.getString("service_folder_icon") : "";
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                z16 = false;
            } else {
                SERVICE_ACCOUNT_FOLDER_NAME = string;
                SERVICE_ACCOUNT_FOLDER_ICON = string2;
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData SERVICE_ACCOUNT_FOLDER_NAME:" + SERVICE_ACCOUNT_FOLDER_NAME + " SERVICE_ACCOUNT_FOLDER_ICON:" + SERVICE_ACCOUNT_FOLDER_ICON);
                }
                z16 = true;
            }
            if (jSONObject2.has("service_folder_redspots")) {
                SERVICE_FOLDER_REDSPOTS = jSONObject2.getBoolean("service_folder_redspots");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:" + SERVICE_FOLDER_REDSPOTS);
                }
                z17 = true;
            } else {
                z17 = false;
            }
            if (jSONObject2.has("service_folder_delete")) {
                SERVICE_ACCOUNT_FOLDER_DELETE = jSONObject2.getBoolean("service_folder_delete");
                QLog.d(IPublicAccountConfigUtil.TAG, 1, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:" + SERVICE_ACCOUNT_FOLDER_DELETE);
                z18 = true;
            } else {
                z18 = false;
            }
            if (jSONObject2.has("ServiceFolder_RedClean_After_Enter")) {
                ServiceFolder_RedClean_After_Enter = jSONObject2.getBoolean("ServiceFolder_RedClean_After_Enter");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "ServiceFolder_RedClean_After_Enter = " + ServiceFolder_RedClean_After_Enter);
                }
                z19 = true;
            } else {
                z19 = false;
            }
            if (jSONObject2.has("readInJoy_feeds_preload")) {
                readInJoyFeedsPreload = jSONObject2.getBoolean("readInJoy_feeds_preload");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "readInJoy feeds preload:" + readInJoyFeedsPreload);
                }
                z26 = true;
            } else {
                z26 = false;
            }
            if (jSONObject2.has("readInJoy_feeds_preload_wifi")) {
                readInJoyFeedsPreloadWifi = jSONObject2.getBoolean("readInJoy_feeds_preload_wifi");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "readInJoy feeds preload wifi:" + readInJoyFeedsPreloadWifi);
                }
                z27 = true;
            } else {
                z27 = false;
            }
            if (jSONObject2.has("readInJoy_feeds_preload_4G")) {
                readInJoyFeedsPreload4G = jSONObject2.getBoolean("readInJoy_feeds_preload_4G");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "readInJoy feeds preload 4G:" + readInJoyFeedsPreload4G);
                }
                z28 = true;
            } else {
                z28 = false;
            }
            if (jSONObject2.has("readInJoy_feeds_preload_3G")) {
                readInJoyFeedsPreload3G = jSONObject2.getBoolean("readInJoy_feeds_preload_3G");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "readInJoy feeds preload 3G:" + readInJoyFeedsPreload3G);
                }
                z29 = true;
            } else {
                z29 = false;
            }
            if (jSONObject2.has("readInJoy_feeds_preload_2G")) {
                readInJoyFeedsPreload2G = jSONObject2.getBoolean("readInJoy_feeds_preload_2G");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "readInJoy feeds preload 2G:" + readInJoyFeedsPreload2G);
                }
                z36 = true;
            } else {
                z36 = false;
            }
            if (jSONObject2.has("pub_account_bottom_bar")) {
                needPABottomBar = jSONObject2.getBoolean("pub_account_bottom_bar");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "needPABottomBar: " + needPABottomBar);
                }
                z37 = true;
            } else {
                z37 = false;
            }
            if (jSONObject2.has("readInJoy_feeds_image_preload")) {
                readInJoyFeedsImagePreload = jSONObject2.getBoolean("readInJoy_feeds_image_preload");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "readInJoy feeds image preload" + readInJoyFeedsImagePreload);
                }
                z38 = true;
            } else {
                z38 = false;
            }
            if (jSONObject2.has("kandian_feeds_fling_LToR_host")) {
                readInJoyflingLToRHost = jSONObject2.optJSONArray("kandian_feeds_fling_LToR_host").toString();
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "kandian_feeds_fling_LToR_host" + readInJoyflingLToRHost);
                }
                z39 = true;
            } else {
                z39 = false;
            }
            boolean z87 = z38;
            if (jSONObject2.has("kandian_ad_background_showtime")) {
                z46 = z37;
                readInJoyADBackgroundShowTime = jSONObject2.optLong("kandian_ad_background_showtime", 3000L);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("kandian_ad_background_showtime");
                    jSONObject = jSONObject2;
                    sb5.append(readInJoyADBackgroundShowTime);
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, sb5.toString());
                } else {
                    jSONObject = jSONObject2;
                }
                z47 = true;
            } else {
                z46 = z37;
                jSONObject = jSONObject2;
                z47 = false;
            }
            if (jSONObject.has("readInJoy_ip_connect")) {
                readInJoyIpConnect = jSONObject.getBoolean("readInJoy_ip_connect");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "readInJoy_ip_connect:" + readInJoyIpConnect);
                }
                z48 = true;
            } else {
                z48 = false;
            }
            if (jSONObject.has("readInJoy_ip_connect_full_report") && jSONObject.has("readInJoy_ip_connect_report_tail")) {
                readInJoyIpConnectReportSwitch = jSONObject.getInt("readInJoy_ip_connect_full_report");
                readInJoyIpConnectReportTail = jSONObject.getString("readInJoy_ip_connect_report_tail");
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "readInJoy_ip_connect_full_report:" + readInJoyIpConnectReportSwitch + ", readInJoy_ip_connect_report_tail:" + readInJoyIpConnectReportTail);
                }
                z49 = true;
            } else {
                z49 = false;
            }
            if (jSONObject.has("readInJoy_load_img")) {
                readInJoyLoadImg = jSONObject.getBoolean("readInJoy_load_img");
                if (QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder();
                    z55 = z19;
                    sb6.append("readInJoyLoadImg:");
                    sb6.append(readInJoyLoadImg);
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, sb6.toString());
                } else {
                    z55 = z19;
                }
                z56 = true;
            } else {
                z55 = z19;
                z56 = false;
            }
            if (jSONObject.has("service_account_folder_redspots_delete")) {
                SERVICE_FOLDER_RED_DELETE = jSONObject.getBoolean("service_account_folder_redspots_delete");
                if (QLog.isColorLevel()) {
                    StringBuilder sb7 = new StringBuilder();
                    z57 = z47;
                    sb7.append("service_account_folder_redspots_delete:");
                    sb7.append(SERVICE_FOLDER_RED_DELETE);
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, sb7.toString());
                } else {
                    z57 = z47;
                }
                z58 = true;
            } else {
                z57 = z47;
                z58 = false;
            }
            if (jSONObject.has("disable_big_data_channel")) {
                disableBigDataChannel = jSONObject.getBoolean("disable_big_data_channel");
                if (QLog.isColorLevel()) {
                    StringBuilder sb8 = new StringBuilder();
                    z59 = z39;
                    sb8.append("disable big data channel is ");
                    sb8.append(disableBigDataChannel);
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, sb8.toString());
                } else {
                    z59 = z39;
                }
                z65 = true;
            } else {
                z59 = z39;
                z65 = false;
            }
            if (z65 && jSONObject.has("host_white_list")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("host_white_list");
                bigDataChannelWhiteList.clear();
                if (optJSONArray != null) {
                    z66 = z58;
                    z67 = z65;
                    int i3 = 0;
                    while (i3 < optJSONArray.length()) {
                        boolean z88 = z56;
                        bigDataChannelWhiteList.add(optJSONArray.getString(i3));
                        if (QLog.isColorLevel()) {
                            QLog.d(IPublicAccountConfigUtil.TAG, 2, " big data channel white host is " + optJSONArray.getString(i3));
                        }
                        i3++;
                        z56 = z88;
                    }
                    boolean z89 = z56;
                    if (jSONObject.has("album_predown_enable")) {
                        z68 = false;
                    } else {
                        imageCollectionPreload = jSONObject.getInt("album_predown_enable");
                        if (QLog.isColorLevel()) {
                            QLog.d(IPublicAccountConfigUtil.TAG, 2, "imageCollectionPreloadEnable is " + imageCollectionPreload);
                        }
                        z68 = true;
                    }
                    if (jSONObject.has("album_predown_photo_rule")) {
                        z69 = false;
                    } else {
                        imageCollectionPreloadCover = jSONObject.getInt("album_predown_photo_rule");
                        if (QLog.isColorLevel()) {
                            QLog.d(IPublicAccountConfigUtil.TAG, 2, "imageCollectionPreloadCoverEnable is " + imageCollectionPreloadCover);
                        }
                        z69 = true;
                    }
                    if (jSONObject.has("album_predown_slide_photocounts")) {
                        z75 = false;
                    } else {
                        imageCollectionPreloadImage = jSONObject.getInt("album_predown_slide_photocounts");
                        if (QLog.isColorLevel()) {
                            QLog.d(IPublicAccountConfigUtil.TAG, 2, "imageCollectionPreloadImageEnable is " + imageCollectionPreloadImage);
                        }
                        z75 = true;
                    }
                    if (jSONObject.has("preload_tool_process")) {
                        z76 = z75;
                        z77 = false;
                    } else {
                        preloadToolProcess = jSONObject.getBoolean("preload_tool_process");
                        if (QLog.isColorLevel()) {
                            StringBuilder sb9 = new StringBuilder();
                            z76 = z75;
                            sb9.append("preload tool progress is ");
                            sb9.append(preloadToolProcess);
                            QLog.d(IPublicAccountConfigUtil.TAG, 2, sb9.toString());
                        } else {
                            z76 = z75;
                        }
                        z77 = true;
                    }
                    if (jSONObject.has("useNewLogic")) {
                        str2 = str;
                        z78 = z69;
                        z79 = z77;
                        z85 = false;
                    } else {
                        str2 = str;
                        readInJoyPreloadToolConfig = str2;
                        if (QLog.isColorLevel()) {
                            z79 = z77;
                            StringBuilder sb10 = new StringBuilder();
                            z78 = z69;
                            sb10.append("read in joy preload tool progress config is ");
                            sb10.append(str2);
                            QLog.d(IPublicAccountConfigUtil.TAG, 2, sb10.toString());
                        } else {
                            z78 = z69;
                            z79 = z77;
                        }
                        z85 = true;
                    }
                    if (jSONObject.has("releaseServiceMinMem")) {
                        z86 = false;
                    } else {
                        readInJoyReleaseWebServiceConfig = str2;
                        if (QLog.isColorLevel()) {
                            QLog.d(IPublicAccountConfigUtil.TAG, 2, "release web service config is " + str2);
                        }
                        z86 = true;
                    }
                    if (!z16 && !z17 && !z18 && !z26 && !z27 && !z28 && !z29 && !z36 && !z46 && !z87 && !z48 && !z49 && !z89 && !z66 && !z67 && !z68 && !z78 && !z76 && !z79 && !z59 && !z85 && !z57 && !z86 && !z55) {
                        return false;
                    }
                    handler = appInterface.getHandler(Conversation.class);
                    if (handler != null) {
                        return true;
                    }
                    handler.sendEmptyMessage(1009);
                    return true;
                }
            }
            z66 = z58;
            z67 = z65;
            boolean z892 = z56;
            if (jSONObject.has("album_predown_enable")) {
            }
            if (jSONObject.has("album_predown_photo_rule")) {
            }
            if (jSONObject.has("album_predown_slide_photocounts")) {
            }
            if (jSONObject.has("preload_tool_process")) {
            }
            if (jSONObject.has("useNewLogic")) {
            }
            if (jSONObject.has("releaseServiceMinMem")) {
            }
            if (!z16) {
                return false;
            }
            handler = appInterface.getHandler(Conversation.class);
            if (handler != null) {
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(IPublicAccountConfigUtil.TAG, 2, "checkPublicAccountCenterUrlConfigData error", e16);
            }
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean checkUrlFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http") || str.startsWith("https");
    }

    private static final String getCertifiedAccountTitle() {
        return (String) VSConfigManager.c().e("subscribe_account_title", VSConfigManager.f97066i);
    }

    private static void init(AppInterface appInterface, Context context) {
        initList();
        if (!parseConfigXml(appInterface, context, ea.L0(context))) {
            list.put(1, new IPublicAccountConfigUtil.a(appInterface, context, 1, R.string.dyv, R.drawable.icon_recent_readinjoy));
        }
        initiatedCache.set(true);
    }

    private static void initList() {
        if (list == null) {
            QQHashMap<Integer, IPublicAccountConfigUtil.a> qQHashMap = new QQHashMap<>(Business.Conversation, "PublicAccountConfigFolder");
            list = qQHashMap;
            qQHashMap.setCacheListener(new a());
        }
    }

    public static boolean isGetFollowListUseNewProtocol() {
        return "1".equals((String) VSConfigManager.c().e("subscribe_entrance_enable", "1")) || "1".equals((String) VSConfigManager.c().e("newfollowlist", "1"));
    }

    public static boolean isPublishEntranceEnable() {
        return "1".equals((String) VSConfigManager.c().e("subscribe_publish_entrance_enable", "1"));
    }

    private static boolean parseConfigXml(AppInterface appInterface, Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountConfigUtil.TAG, 2, "parseConfigXml xml: " + str);
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.trim().getBytes("utf-8"))).getElementsByTagName(CONFIG_PUBLIC_ACCOUNT_FOLDER_TAG);
                int length = elementsByTagName.getLength();
                for (int i3 = 0; i3 < length; i3++) {
                    Element element = (Element) elementsByTagName.item(i3);
                    int parseInt = Integer.parseInt(element.getElementsByTagName("id").item(0).getFirstChild().getNodeValue());
                    String nodeValue = element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
                    String nodeValue2 = element.getElementsByTagName("icon").item(0).getFirstChild().getNodeValue();
                    IPublicAccountConfigUtil.a aVar = new IPublicAccountConfigUtil.a();
                    ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).initPublicAccountConfigFolder(aVar, appInterface, context, parseInt, nodeValue, nodeValue2);
                    initList();
                    list.put(Integer.valueOf(parseInt), aVar);
                }
                return true;
            }
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d(IPublicAccountConfigUtil.TAG, 2, "parsePublicAccountConfigXml xml is empty");
            return false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(IPublicAccountConfigUtil.TAG, 2, "parsePublicAccountConfigXml error", e16);
            }
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean updateConfig(AppInterface appInterface, Context context, String str) {
        boolean parseConfigXml = parseConfigXml(appInterface, context, str);
        if (parseConfigXml) {
            ea.z4(context, str);
        } else if (QLog.isColorLevel()) {
            QLog.e(IPublicAccountConfigUtil.TAG, 2, "updateEqqConfig fail");
        }
        return parseConfigXml;
    }

    public static void updateServiceAccountFolderConfigVersionCode(AppInterface appInterface, int i3) {
        String currentAccountUin = appInterface.getCurrentAccountUin();
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + currentAccountUin, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("service_account_folder_config_version", i3);
            edit.commit();
            QLog.d(IPublicAccountConfigUtil.TAG, 1, "updateServiceAccountFolderConfigVersionCode success  version:" + i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountConfigUtil.TAG, 2, "updateServiceAccountFolderConfigVersionCode failed, uin:" + currentAccountUin + ", version:" + i3);
        }
    }

    public static boolean updateSubscribeConfig(AppInterface appInterface, Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountConfigUtil.TAG, 2, "updateSubscribeConfig xml: " + str);
        }
        try {
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(IPublicAccountConfigUtil.TAG, 2, "updateSubscribeConfig error", e16);
            }
            e16.printStackTrace();
        }
        if (!TextUtils.isEmpty(str)) {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.trim().getBytes("utf-8")));
            int parseInt = Integer.parseInt(parse.getElementsByTagName("version").item(0).getFirstChild().getNodeValue());
            int g16 = SubscriptRecommendController.g((QQAppInterface) appInterface);
            if (QLog.isColorLevel()) {
                QLog.d(IPublicAccountConfigUtil.TAG, 2, "updateSubscribeConfig prevVersion = " + g16 + ", version = " + parseInt);
            }
            if (parseInt == g16) {
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "IGNORE THIS ACTION because of SAME VERSION");
                }
                return false;
            }
            NodeList elementsByTagName = parse.getElementsByTagName(CONFIG_PUBLIC_ACCOUNT_FOLDER_TAG);
            if (elementsByTagName.getLength() <= 0) {
                return true;
            }
            Element element = (Element) elementsByTagName.item(0);
            int parseInt2 = Integer.parseInt(element.getElementsByTagName("show").item(0).getFirstChild().getNodeValue());
            String nodeValue = element.getElementsByTagName("msg").item(0).getFirstChild().getNodeValue();
            SubscriptRecommendController.I((QQAppInterface) appInterface, parseInt);
            SubscriptRecommendController.u((QQAppInterface) appInterface, parseInt2, nodeValue);
            IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) appInterface.getRuntimeService(IWebProcessManagerService.class, "");
            if (iWebProcessManagerService == null) {
                return true;
            }
            iWebProcessManagerService.startWebProcess(22, null);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountConfigUtil.TAG, 2, "updateSubscribeConfig xml is empty");
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean checkNeedLongMessageChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = bigDataChannelWhiteList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next) && str.indexOf(next) != -1 && str.endsWith(next)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean checkPublicAccountCenterUrlConfigData(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("pacenter_url");
            String string2 = jSONObject.getString("pacategory_url");
            if (checkUrlFormat(string)) {
                PUBLIC_ACCOUNT_CENTER_URL = string;
                z16 = true;
            } else {
                z16 = false;
            }
            if (checkUrlFormat(string2)) {
                PUBLIC_ACCOUNT_CATEGORY_URL = string2;
                z16 = true;
            }
            if (jSONObject.has("readinjoy_search_url")) {
                String string3 = jSONObject.getString("readinjoy_search_url");
                if (checkUrlFormat(string3)) {
                    READINJOY_SEARCH_URL = string3;
                    z16 = true;
                }
            }
            if (!jSONObject.has("image_collection_comment")) {
                return z16;
            }
            IMAGE_COLLECTION_COMMENT = jSONObject.getBoolean("image_collection_comment");
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(IPublicAccountConfigUtil.TAG, 2, "checkPublicAccountCenterUrlConfigData error", e16);
            }
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public ArrayList<String> getBigDataChannelWhiteList() {
        return bigDataChannelWhiteList;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean getDisableBigDataChannel() {
        return disableBigDataChannel;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public int getImageCollectionPreload() {
        return imageCollectionPreload;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public int getImageCollectionPreloadCover() {
        return imageCollectionPreloadCover;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public int getImageCollectionPreloadImage() {
        return imageCollectionPreloadImage;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getName(AppInterface appInterface, Context context, int i3) {
        IPublicAccountConfigUtil.a folder = getFolder(appInterface, context, i3);
        if (folder != null) {
            return folder.c();
        }
        return getDefaultName(appInterface, context, i3);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getPublicAccountCategoryUrl() {
        return PUBLIC_ACCOUNT_CATEGORY_URL;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getPublicAccountCenterUrlConfigData(AppInterface appInterface) {
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("public_account_center_url_config_data", null);
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public int getPublicAccountCenterUrlConfigVersionCode(AppInterface appInterface) {
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("public_account_center_url_config_version", 0);
        }
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public int getPublicAccountQQMailConfigVersionCode(AppInterface appInterface) {
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("public_account_qq_mail_config_version", 0);
        }
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public final String getPublicAccountTitle() {
        if (isSwitchToCertifiedAccount()) {
            return getCertifiedAccountTitle();
        }
        return HardCodeUtil.qqStr(R.string.vjb);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public long getReadInJoyADBackgroundShowTime() {
        return readInJoyADBackgroundShowTime;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public int getReadInJoyIpConnectReportSwitch() {
        return readInJoyIpConnectReportSwitch;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getReadInJoyIpConnectReportTail() {
        return readInJoyIpConnectReportTail;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getReadInJoyPreloadToolConfig() {
        return readInJoyPreloadToolConfig;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getReadInJoyReleaseWebServiceConfig() {
        return readInJoyReleaseWebServiceConfig;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getReadInJoyflingLToRHost() {
        return readInJoyflingLToRHost;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getReadinjoySearchUrl() {
        return READINJOY_SEARCH_URL;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void getServiceAccountFolderConfigData(AppInterface appInterface, boolean z16) {
        String currentAccountUin = appInterface.getCurrentAccountUin();
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + currentAccountUin, 0);
        if (sharedPreferences != null) {
            SERVICE_ACCOUNT_FOLDER_NAME = sharedPreferences.getString("service_account_folder_name", null);
            SERVICE_ACCOUNT_FOLDER_ICON = sharedPreferences.getString("service_account_folder_icon", null);
            SERVICE_ACCOUNT_FOLDER_DELETE = sharedPreferences.getBoolean("service_account_folder_delete", true);
            ServiceFolder_RedClean_After_Enter = sharedPreferences.getBoolean("service_folder_redclean_after_enter", false);
            SERVICE_FOLDER_REDSPOTS = sharedPreferences.getBoolean("service_account_folder_redspots", false);
            readInJoyIpConnect = sharedPreferences.getBoolean("readInJoy_ip_connect", false);
            readInJoyIpConnectReportSwitch = sharedPreferences.getInt("readInJoy_ip_connect_full_report", 0);
            readInJoyIpConnectReportTail = sharedPreferences.getString("readInJoy_ip_connect_report_tail", "");
            SERVICE_FOLDER_RED_DELETE = sharedPreferences.getBoolean("service_account_folder_redspots_delete", false);
            disableBigDataChannel = sharedPreferences.getBoolean("big_data_share_channel", false);
            Set<String> a16 = eb.a(sharedPreferences, "big_data_share_channel_urls", null);
            if (a16 != null) {
                bigDataChannelWhiteList = new ArrayList<>(a16);
            }
            preloadToolProcess = sharedPreferences.getBoolean("ad_preload_tool_process", true);
            readInJoyPreloadToolConfig = sharedPreferences.getString("key_read_in_joy_preload_tool_config", "");
            readInJoyReleaseWebServiceConfig = sharedPreferences.getString("key_read_in_joy_release_service_config", "");
            if (z16) {
                readInJoyFeedsPreload = sharedPreferences.getBoolean("kandian_feeds_preload", false);
                readInJoyFeedsPreloadWifi = sharedPreferences.getBoolean("kandian_feeds_preload_wifi", false);
                readInJoyFeedsPreload4G = sharedPreferences.getBoolean("kandian_feeds_preload_4G", false);
                readInJoyFeedsPreload3G = sharedPreferences.getBoolean("kandian_feeds_preload_3G", false);
                readInJoyFeedsPreload2G = sharedPreferences.getBoolean("kandian_feeds_preload_2G", false);
                needPABottomBar = sharedPreferences.getBoolean("public_account_bottom_bar", false);
                readInJoyFeedsImagePreload = sharedPreferences.getBoolean("kandian_feeds_image_preload", false);
                readInJoyflingLToRHost = sharedPreferences.getString("kandian_feeds_fling_LToR_host", "");
                readInJoyADBackgroundShowTime = sharedPreferences.getLong("kandian_ad_background_showtime", 3000L);
                readInJoyLoadImg = sharedPreferences.getBoolean("readInJoy_loading_img", false);
                imageCollectionPreload = sharedPreferences.getInt("album_predown_enable", 0);
                imageCollectionPreloadCover = sharedPreferences.getInt("album_predown_photo_rule", 0);
                imageCollectionPreloadImage = sharedPreferences.getInt("album_predown_slide_photocounts", 0);
            }
            MqqHandler handler = appInterface.getHandler(Conversation.class);
            if (handler != null) {
                handler.sendEmptyMessage(1009);
            }
            if (QLog.isColorLevel()) {
                QLog.d(IPublicAccountConfigUtil.TAG, 2, "getServiceAccountFolderConfigData success, uin:" + currentAccountUin + ", delete:" + SERVICE_ACCOUNT_FOLDER_DELETE + ", clean:" + ServiceFolder_RedClean_After_Enter + ", redspot:" + SERVICE_FOLDER_REDSPOTS);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountConfigUtil.TAG, 2, "getServiceAccountFolderConfigData failed, uin:" + currentAccountUin);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public int getServiceAccountFolderConfigVersionCode(AppInterface appInterface) {
        String currentAccountUin = appInterface.getCurrentAccountUin();
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + currentAccountUin, 0);
        int i3 = sharedPreferences != null ? sharedPreferences.getInt("service_account_folder_config_version", 0) : 0;
        QLog.d(IPublicAccountConfigUtil.TAG, 1, "getServiceAccountFolderConfigVersionCode  version:" + i3);
        return i3;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getServiceAccountFolderIcon() {
        return SERVICE_ACCOUNT_FOLDER_ICON;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getServiceAccountFolderName() {
        return SERVICE_ACCOUNT_FOLDER_NAME;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getServiceAccountTitle() {
        if (isSwitchToCertifiedAccount()) {
            return getCertifiedAccountTitle();
        }
        return HardCodeUtil.qqStr(R.string.vjb);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean getServiceFolderRedDelete() {
        return SERVICE_FOLDER_RED_DELETE;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void initPublicAccountConfigFolder(IPublicAccountConfigUtil.a aVar, AppInterface appInterface, Context context, int i3, String str, String str2) {
        aVar.f80193a = i3;
        aVar.f80194b = str;
        aVar.f80195c = str2;
        aVar.f80197e = aVar.d(i3);
        aVar.f80196d = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(context, i3);
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountConfigUtil.TAG, 2, "PublicAccountConfigFolder mId: " + aVar.f80193a + " | mName: " + aVar.f80194b + " | mIconUrl: " + aVar.f80195c + " | mUin : " + aVar.f80197e);
        }
        if (!TextUtils.isEmpty(aVar.f80195c) && !TextUtils.isEmpty(aVar.f80197e)) {
            Drawable b16 = LebaIconDownloader.b(context, str2);
            if (b16 != null) {
                aVar.f80196d = b16;
                return;
            } else {
                LebaIconDownloader.a((QQAppInterface) appInterface, context, str2, new LebaIconDownloader.a(context, new b(aVar, appInterface, aVar.f80197e), new Object[0]));
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountConfigUtil.TAG, 2, "PublicAccountConfigFolder mIconUrl is empty");
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isClearAllPublicAccountFolderRedNumber() {
        return ServiceFolder_RedClean_After_Enter;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isDisableBigDataChannel() {
        return disableBigDataChannel;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isNeedPABottomBar() {
        return needPABottomBar;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isPreloadTooProcess() {
        return preloadToolProcess;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isPreloadToolProcess() {
        return preloadToolProcess;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isReadInJoyFeedsImagePreload() {
        return readInJoyFeedsImagePreload;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isReadInJoyFeedsPreload() {
        return readInJoyFeedsPreload;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isReadInJoyFeedsPreload2G() {
        return readInJoyFeedsPreload2G;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isReadInJoyFeedsPreload3G() {
        return readInJoyFeedsPreload3G;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isReadInJoyFeedsPreload4G() {
        return readInJoyFeedsPreload4G;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isReadInJoyFeedsPreloadWifi() {
        return readInJoyFeedsPreloadWifi;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isReadInJoyIpConnect() {
        return readInJoyIpConnect;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isReadInJoyLoadImg() {
        return readInJoyLoadImg;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isServiceAccountFolderDelete() {
        return SERVICE_ACCOUNT_FOLDER_DELETE;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isServiceFolderRedSpots() {
        return SERVICE_FOLDER_REDSPOTS;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isServiceFolderRedspots() {
        return SERVICE_FOLDER_REDSPOTS;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean isSwitchToCertifiedAccount() {
        try {
            return "1".equals((String) VSConfigManager.c().e("subscribe_entrance_enable", "1"));
        } catch (Exception e16) {
            QLog.e(IPublicAccountConfigUtil.TAG, 2, "isSwitchToCertifiedAccount error! ", e16);
            return false;
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void loadPublicAccountCenterUrlConfig(AppInterface appInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            PUBLIC_ACCOUNT_CENTER_URL = PUBLIC_ACCOUNT_CENTER_DEFAULT_URL;
            PUBLIC_ACCOUNT_CATEGORY_URL = PUBLIC_ACCOUNT_CATEGORY_DEFAULT_URL;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("pacenter_url");
            String string2 = jSONObject.getString("pacategory_url");
            if (checkUrlFormat(string)) {
                PUBLIC_ACCOUNT_CENTER_URL = string;
            } else {
                PUBLIC_ACCOUNT_CENTER_URL = PUBLIC_ACCOUNT_CENTER_DEFAULT_URL;
            }
            if (checkUrlFormat(string2)) {
                PUBLIC_ACCOUNT_CATEGORY_URL = string2;
            } else {
                PUBLIC_ACCOUNT_CATEGORY_URL = PUBLIC_ACCOUNT_CATEGORY_DEFAULT_URL;
            }
            if (jSONObject.has("readinjoy_search_url")) {
                String string3 = jSONObject.getString("readinjoy_search_url");
                if (checkUrlFormat(string3)) {
                    READINJOY_SEARCH_URL = string3;
                }
            } else {
                updatePublicAccountCenterUrlConfigVersionCode(appInterface, 0);
            }
            if (jSONObject.has("image_collection_comment")) {
                IMAGE_COLLECTION_COMMENT = jSONObject.getBoolean("image_collection_comment");
            } else {
                updatePublicAccountCenterUrlConfigVersionCode(appInterface, 0);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(IPublicAccountConfigUtil.TAG, 2, "loadPublicAccountCenterUrlConfig error", e16);
            }
            e16.printStackTrace();
            PUBLIC_ACCOUNT_CENTER_URL = PUBLIC_ACCOUNT_CENTER_DEFAULT_URL;
            PUBLIC_ACCOUNT_CATEGORY_URL = PUBLIC_ACCOUNT_CATEGORY_DEFAULT_URL;
            IMAGE_COLLECTION_COMMENT = false;
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public int readInJoyADGuideCardShowTime() {
        return readInJoyADGuideCardShowTime;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean readInJoyIpConnect() {
        return readInJoyIpConnect;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public int readInJoyIpConnectReportSwitch() {
        return readInJoyIpConnectReportSwitch;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String readInJoyIpConnectReportTail() {
        return readInJoyIpConnectReportTail;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String readInJoyPreloadToolConfig() {
        return readInJoyPreloadToolConfig;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String readInJoyReleaseWebServiceConfig() {
        return readInJoyReleaseWebServiceConfig;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void resetPublicAccountConfig(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountConfigUtil.TAG, 2, "resetPublicAccountConfig uin:" + str);
        }
        PUBLIC_ACCOUNT_CENTER_URL = PUBLIC_ACCOUNT_CENTER_DEFAULT_URL;
        PUBLIC_ACCOUNT_CATEGORY_URL = PUBLIC_ACCOUNT_CATEGORY_DEFAULT_URL;
        SERVICE_ACCOUNT_FOLDER_DELETE = true;
        SERVICE_FOLDER_REDSPOTS = false;
        SERVICE_FOLDER_RED_DELETE = false;
        IMAGE_COLLECTION_COMMENT = false;
        readInJoyFeedsPreload = false;
        readInJoyFeedsPreloadWifi = false;
        readInJoyFeedsPreload4G = false;
        readInJoyFeedsPreload3G = false;
        readInJoyFeedsPreload2G = false;
        readInJoyFeedsImagePreload = false;
        readInJoyflingLToRHost = "";
        readInJoyADBackgroundShowTime = 3000L;
        preloadToolProcess = true;
        readInJoyIpConnect = false;
        readInJoyIpConnectReportSwitch = 0;
        readInJoyIpConnectReportTail = "";
        readInJoyLoadImg = false;
        disableBigDataChannel = false;
        bigDataChannelWhiteList.clear();
        imageCollectionPreload = 0;
        imageCollectionPreloadCover = 0;
        imageCollectionPreloadImage = 0;
        readInJoyPreloadToolConfig = "";
        readInJoyReleaseWebServiceConfig = "";
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setBigDataChannelWhiteList(ArrayList<String> arrayList) {
        bigDataChannelWhiteList = arrayList;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setDisableBigDataChannel(boolean z16) {
        disableBigDataChannel = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setImageCollectionPreload(int i3) {
        imageCollectionPreload = i3;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setImageCollectionPreloadCover(int i3) {
        imageCollectionPreloadCover = i3;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setImageCollectionPreloadImage(int i3) {
        imageCollectionPreloadImage = i3;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setNeedPABottomBar(boolean z16) {
        needPABottomBar = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setPreloadToolProcess(boolean z16) {
        preloadToolProcess = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyADBackgroundShowTime(long j3) {
        readInJoyADBackgroundShowTime = j3;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyFeedsImagePreload(boolean z16) {
        readInJoyFeedsImagePreload = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyFeedsPreload(boolean z16) {
        readInJoyFeedsPreload = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyFeedsPreload2G(boolean z16) {
        readInJoyFeedsPreload2G = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyFeedsPreload3G(boolean z16) {
        readInJoyFeedsPreload3G = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyFeedsPreload4G(boolean z16) {
        readInJoyFeedsPreload4G = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyFeedsPreloadWifi(boolean z16) {
        readInJoyFeedsPreloadWifi = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyIpConnect(boolean z16) {
        readInJoyIpConnect = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyIpConnectReportSwitch(int i3) {
        readInJoyIpConnectReportSwitch = i3;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyIpConnectReportTail(String str) {
        readInJoyIpConnectReportTail = str;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyLoadImg(boolean z16) {
        readInJoyLoadImg = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyPreloadToolConfig(String str) {
        readInJoyPreloadToolConfig = str;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyReleaseWebServiceConfig(String str) {
        readInJoyReleaseWebServiceConfig = str;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setReadInJoyflingLToRHost(String str) {
        readInJoyflingLToRHost = str;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setServiceAccountFolderIcon(String str) {
        SERVICE_ACCOUNT_FOLDER_ICON = str;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setServiceAccountFolderName(String str) {
        SERVICE_ACCOUNT_FOLDER_NAME = str;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setServiceFolderDelete(boolean z16) {
        SERVICE_ACCOUNT_FOLDER_DELETE = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setServiceFolderRedCleanAfterEnter(boolean z16) {
        ServiceFolder_RedClean_After_Enter = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setServiceFolderRedDelete(boolean z16) {
        SERVICE_FOLDER_RED_DELETE = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void setServiceFolderRedSpots(boolean z16) {
        SERVICE_FOLDER_REDSPOTS = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void updatePublicAccountCenterUrlConfigData(AppInterface appInterface) {
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pacenter_url", PUBLIC_ACCOUNT_CENTER_URL);
                jSONObject.put("pacategory_url", PUBLIC_ACCOUNT_CATEGORY_URL);
                jSONObject.put("readinjoy_search_url", READINJOY_SEARCH_URL);
                jSONObject.put("image_collection_comment", IMAGE_COLLECTION_COMMENT);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("public_account_center_url_config_data", jSONObject.toString());
                edit.commit();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(IPublicAccountConfigUtil.TAG, 2, "updatePublicAccountCenterUrlConfigData error", e16);
                }
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void updatePublicAccountCenterUrlConfigVersionCode(AppInterface appInterface, int i3) {
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("public_account_center_url_config_version", i3);
            edit.commit();
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void updatePublicAccountQQMailConfigData(AppInterface appInterface, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = appInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + appInterface.getCurrentAccountUin(), 0).edit();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("tim_url")) {
                jSONObject.getString("tim_url");
            }
            String string = jSONObject.has("tim_url_card") ? jSONObject.getString("tim_url_card") : null;
            String string2 = jSONObject.has("tim_wording") ? jSONObject.getString("tim_wording") : null;
            String string3 = jSONObject.has("tim_url_icon") ? jSONObject.getString("tim_url_icon") : null;
            String string4 = jSONObject.has("tim_url_icon_725") ? jSONObject.getString("tim_url_icon_725") : null;
            String string5 = jSONObject.has("qim_url_card") ? jSONObject.getString("qim_url_card") : null;
            String string6 = jSONObject.has("qim_wording") ? jSONObject.getString("qim_wording") : null;
            String string7 = jSONObject.has("qim_url_icon") ? jSONObject.getString("qim_url_icon") : null;
            String string8 = jSONObject.has("qim_url_icon_720") ? jSONObject.getString("qim_url_icon_720") : null;
            String string9 = jSONObject.has("qim_url_icon_story") ? jSONObject.getString("qim_url_icon_story") : null;
            if (checkUrlFormat(string)) {
                edit.putString("profile_card_tim_online_url", string);
            }
            if (checkUrlFormat(string3)) {
                edit.putString("profile_card_tim_online_icon_url", string3);
            }
            if (checkUrlFormat(string4)) {
                edit.putString("profile_card_tim_online_icon_725_url", string4);
            }
            if (!TextUtils.isEmpty(string2)) {
                edit.putString("profile_card_tim_online_wording", string2);
            }
            if (checkUrlFormat(string5)) {
                edit.putString("profile_card_qim_online_url", string5);
            }
            if (checkUrlFormat(string7)) {
                edit.putString("profile_card_qim_online_icon_url", string7);
            }
            if (checkUrlFormat(string8)) {
                edit.putString("profile_card_qim_online_icon_url_720", string8);
            }
            if (checkUrlFormat(string9)) {
                edit.putString("key_story_qim_online_icon_url", string9);
            }
            if (!TextUtils.isEmpty(string6)) {
                edit.putString("profile_card_qim_online_wording", string6);
            }
            if (QLog.isColorLevel()) {
                QLog.d(IPublicAccountConfigUtil.TAG, 2, "updatePublicAccountQQMailConfigData url_card_tim_online:" + string + "; url_card_qim_online:" + string5);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e(IPublicAccountConfigUtil.TAG, 2, "update public account qq mail config error.", e16);
            }
        }
        edit.putInt("public_account_qq_mail_config_version", i3);
        edit.commit();
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public void updateServiceAccountFolderConfigData(final AppInterface appInterface) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl.2
            @Override // java.lang.Runnable
            public void run() {
                String currentAccountUin = appInterface.getCurrentAccountUin();
                SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + currentAccountUin, 0);
                if (sharedPreferences != null) {
                    try {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("service_account_folder_name", PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_NAME);
                        edit.putString("service_account_folder_icon", PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_ICON);
                        edit.putBoolean("service_account_folder_delete", PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_DELETE);
                        edit.putBoolean("service_folder_redclean_after_enter", PublicAccountConfigUtilImpl.ServiceFolder_RedClean_After_Enter);
                        edit.putBoolean("service_account_folder_redspots", PublicAccountConfigUtilImpl.SERVICE_FOLDER_REDSPOTS);
                        edit.putBoolean("kandian_feeds_preload", PublicAccountConfigUtilImpl.readInJoyFeedsPreload);
                        edit.putBoolean("kandian_feeds_preload_wifi", PublicAccountConfigUtilImpl.readInJoyFeedsPreloadWifi);
                        edit.putBoolean("kandian_feeds_preload_4G", PublicAccountConfigUtilImpl.readInJoyFeedsPreload4G);
                        edit.putBoolean("kandian_feeds_preload_3G", PublicAccountConfigUtilImpl.readInJoyFeedsPreload3G);
                        edit.putBoolean("kandian_feeds_preload_2G", PublicAccountConfigUtilImpl.readInJoyFeedsPreload2G);
                        edit.putBoolean("public_account_bottom_bar", PublicAccountConfigUtilImpl.needPABottomBar);
                        edit.putBoolean("kandian_feeds_image_preload", PublicAccountConfigUtilImpl.readInJoyFeedsImagePreload);
                        edit.putString("kandian_feeds_fling_LToR_host", PublicAccountConfigUtilImpl.readInJoyflingLToRHost);
                        edit.putLong("kandian_ad_background_showtime", PublicAccountConfigUtilImpl.readInJoyADBackgroundShowTime);
                        edit.putBoolean("readInJoy_ip_connect", PublicAccountConfigUtilImpl.readInJoyIpConnect);
                        edit.putInt("readInJoy_ip_connect_full_report", PublicAccountConfigUtilImpl.readInJoyIpConnectReportSwitch);
                        edit.putString("readInJoy_ip_connect_report_tail", PublicAccountConfigUtilImpl.readInJoyIpConnectReportTail);
                        edit.putBoolean("readInJoy_loading_img", PublicAccountConfigUtilImpl.readInJoyLoadImg);
                        edit.putBoolean("service_account_folder_redspots_delete", PublicAccountConfigUtilImpl.SERVICE_FOLDER_RED_DELETE);
                        edit.putBoolean("big_data_share_channel", PublicAccountConfigUtilImpl.disableBigDataChannel);
                        eb.c(edit, "big_data_share_channel_urls", PublicAccountConfigUtilImpl.bigDataChannelWhiteList.toArray());
                        edit.putInt("album_predown_enable", PublicAccountConfigUtilImpl.imageCollectionPreload);
                        edit.putInt("album_predown_photo_rule", PublicAccountConfigUtilImpl.imageCollectionPreloadCover);
                        edit.putInt("album_predown_slide_photocounts", PublicAccountConfigUtilImpl.imageCollectionPreloadImage);
                        edit.putBoolean("ad_preload_tool_process", PublicAccountConfigUtilImpl.preloadToolProcess);
                        edit.putString("key_read_in_joy_preload_tool_config", PublicAccountConfigUtilImpl.readInJoyPreloadToolConfig);
                        edit.putString("key_read_in_joy_release_service_config", PublicAccountConfigUtilImpl.readInJoyReleaseWebServiceConfig);
                        edit.commit();
                        if (QLog.isColorLevel()) {
                            QLog.d(IPublicAccountConfigUtil.TAG, 2, "updateServiceAccountFolderConfigData success, uin:" + currentAccountUin + ", delete:" + PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_DELETE + ", clean:" + PublicAccountConfigUtilImpl.ServiceFolder_RedClean_After_Enter + ", redspot:" + PublicAccountConfigUtilImpl.SERVICE_FOLDER_REDSPOTS);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(IPublicAccountConfigUtil.TAG, 2, "updateServiceAccountFolderConfigData error, uin:" + currentAccountUin, e16);
                        }
                        e16.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public boolean updateSubscriptRecommendConfig(AppInterface appInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountConfigUtil.TAG, 2, "updateSubscribeRecommendConfig xml: " + str);
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.trim().getBytes("utf-8")));
            NodeList elementsByTagName = parse.getElementsByTagName(CONFIG_SUBSCRIPT_FULL_RECOMMEND_VERSION);
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                int intValue = Integer.valueOf(((Element) elementsByTagName.item(0)).getFirstChild().getNodeValue()).intValue();
                int i3 = SubscriptRecommendController.i((QQAppInterface) appInterface);
                if (intValue > i3) {
                    Element element = (Element) parse.getElementsByTagName(CONFIG_SUBSCRIPT_FULL_RECOMMEND_TAG).item(0);
                    Element element2 = (Element) parse.getElementsByTagName(CONFIG_SUBSCRIPT_FULL_RECOMMEND_URL_TAG).item(0);
                    int intValue2 = Integer.valueOf(element.getFirstChild().getNodeValue()).intValue();
                    String nodeValue = element2.getFirstChild().getNodeValue();
                    SubscriptRecommendController.w(appInterface, intValue2 == 1, nodeValue);
                    SubscriptRecommendController.J((QQAppInterface) appInterface, intValue);
                    if (intValue2 == 1) {
                        ((IWebProcessManagerService) appInterface.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(22, null);
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("SubscriptRecommendConfig update fullrecommend config. version : ");
                        sb5.append(intValue);
                        sb5.append(" switch : ");
                        sb5.append(intValue2 == 1);
                        sb5.append(" url : ");
                        sb5.append(nodeValue);
                        sb5.append(" oldVersion : ");
                        sb5.append(i3);
                        QLog.d(IPublicAccountConfigUtil.TAG, 2, sb5.toString());
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "SubscriptRecommendConfig same version ! " + intValue);
                }
            }
            NodeList elementsByTagName2 = parse.getElementsByTagName(CONFIG_SUBSCRIPT_INNER_RECOMMEND_VERSION);
            if (elementsByTagName2 != null && elementsByTagName2.getLength() > 0) {
                int intValue3 = Integer.valueOf(((Element) elementsByTagName2.item(0)).getFirstChild().getNodeValue()).intValue();
                int j3 = SubscriptRecommendController.j((QQAppInterface) appInterface);
                if (intValue3 > j3) {
                    int intValue4 = Integer.valueOf(((Element) parse.getElementsByTagName(CONFIG_SUBSCRIPT_INNER_RECOMMEND_TAG).item(0)).getFirstChild().getNodeValue()).intValue();
                    SubscriptRecommendController.x((QQAppInterface) appInterface, intValue4 == 1);
                    SubscriptRecommendController.K((QQAppInterface) appInterface, intValue3);
                    if (QLog.isColorLevel()) {
                        QLog.d(IPublicAccountConfigUtil.TAG, 2, "SubscriptRecommendConfig update innerrecommend config. preversion -> version " + j3 + "->" + intValue3 + " switch : " + intValue4);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "SubscriptRecommendConfig update fail same version " + intValue3);
                }
            }
            NodeList elementsByTagName3 = parse.getElementsByTagName(CONFIG_VIDEO_CHANNEL_INFO_VERSION);
            if (elementsByTagName3 != null && elementsByTagName3.getLength() > 0) {
                int intValue5 = Integer.valueOf(((Element) elementsByTagName3.item(0)).getFirstChild().getNodeValue()).intValue();
                int readInJoyMultiVideoChannelInfoVersion = ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).getReadInJoyMultiVideoChannelInfoVersion();
                if (intValue5 > readInJoyMultiVideoChannelInfoVersion) {
                    Element element3 = (Element) parse.getElementsByTagName("channel_id").item(0);
                    Element element4 = (Element) parse.getElementsByTagName("channel_name").item(0);
                    Element element5 = (Element) parse.getElementsByTagName("channel_type").item(0);
                    int intValue6 = Integer.valueOf(element3.getFirstChild().getNodeValue()).intValue();
                    String valueOf = String.valueOf(element4.getFirstChild().getNodeValue());
                    int intValue7 = Integer.valueOf(element5.getFirstChild().getNodeValue()).intValue();
                    ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateReadInJoyMultiVideoChannelInfo(intValue6, valueOf, intValue7);
                    if (QLog.isColorLevel()) {
                        QLog.d(IPublicAccountConfigUtil.TAG, 2, "update channelInfo config. preversion -> version " + readInJoyMultiVideoChannelInfoVersion + "->" + intValue5 + " channelID : " + intValue6 + " channelName: " + valueOf + " channelType: " + intValue7);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "update channelInfo fail same version " + intValue5);
                }
            }
            NodeList elementsByTagName4 = parse.getElementsByTagName(CONFIG_VIDEO_MULTI_VIDEO_SUPPORT_ENABLE);
            if (elementsByTagName4 != null && elementsByTagName4.getLength() > 0) {
                int intValue8 = Integer.valueOf(((Element) elementsByTagName4.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateSupportMultiVideoSwitch(intValue8 > 0);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "updateSupportMultiVideoSwitch\uff0c supportEnable = " + intValue8);
                }
            }
            NodeList elementsByTagName5 = parse.getElementsByTagName(CONFIG_VIDEO_STRUCTMSG_SWITCH);
            if (elementsByTagName5 != null && elementsByTagName5.getLength() > 0) {
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateVideoStructMsgPlaySwitch(Integer.valueOf(((Element) elementsByTagName5.item(0)).getFirstChild().getNodeValue()).intValue() > 0);
            }
            NodeList elementsByTagName6 = parse.getElementsByTagName(CONFIG_VIDEO_SOCIAL_SWITCH);
            if (elementsByTagName6 != null && elementsByTagName6.getLength() > 0) {
                boolean z16 = Integer.valueOf(((Element) elementsByTagName6.item(0)).getFirstChild().getNodeValue()).intValue() > 0;
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "parse kandian video social switch = " + z16);
                }
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateKandianVideoSocialSwitch(z16);
            }
            NodeList elementsByTagName7 = parse.getElementsByTagName(CONFIG_VIDEO_CHANNEL_AUTOPLAY_SWITCH);
            if (elementsByTagName7 != null && elementsByTagName7.getLength() > 0) {
                int intValue9 = Integer.valueOf(((Element) elementsByTagName7.item(0)).getFirstChild().getNodeValue()).intValue();
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "video channel auto play switch default value = " + intValue9);
                }
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateVideoChannelAutoPlaySwitchDefaultValue(intValue9);
            }
            NodeList elementsByTagName8 = parse.getElementsByTagName(CONFIG_VIDEO_JUMP_DEFAULT_VALUE);
            if (elementsByTagName8 != null && elementsByTagName8.getLength() > 0) {
                int intValue10 = Integer.valueOf(((Element) elementsByTagName8.item(0)).getFirstChild().getNodeValue()).intValue();
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "video jump default value = " + intValue10);
                }
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateReadInJoyVideoJumpDefaultValue(intValue10);
            }
            NodeList elementsByTagName9 = parse.getElementsByTagName(CONFIG_VIDEO_DEFAULT_BITRATE);
            if (elementsByTagName9 != null && elementsByTagName9.getLength() > 0) {
                Element element6 = (Element) elementsByTagName9.item(0);
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateKandianConfigDefaultBitRate(element6.getFirstChild().getNodeValue());
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "defaultBitRate value = " + element6.getFirstChild().getNodeValue());
                }
            }
            NodeList elementsByTagName10 = parse.getElementsByTagName(CONFIG_CUKINGCARD_DLG_SWITCH);
            if (elementsByTagName10 != null && elementsByTagName10.getLength() > 0) {
                int intValue11 = Integer.valueOf(((Element) elementsByTagName10.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateCUKingCardDlgSwitch(intValue11);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "CUKingCardDlg value = " + intValue11);
                }
            }
            NodeList elementsByTagName11 = parse.getElementsByTagName(CONFIG_VIDEO_CHANNEL_COVER_STYLE);
            if (elementsByTagName11 != null && elementsByTagName11.getLength() > 0) {
                int intValue12 = Integer.valueOf(((Element) elementsByTagName11.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateVideoChannelCoverStyle(intValue12);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "video_channel_style value = " + intValue12);
                }
            }
            NodeList elementsByTagName12 = parse.getElementsByTagName(CONFIG_VIDEO_DYNAMIC_RECOMMEND_STRATEGY);
            if (elementsByTagName12 != null && elementsByTagName12.getLength() > 0) {
                int intValue13 = Integer.valueOf(((Element) elementsByTagName12.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateVideoDynamicRecommmendStrategy(intValue13);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "video_dynamic_recommend_strategyid value = " + intValue13);
                }
            }
            NodeList elementsByTagName13 = parse.getElementsByTagName(CONFIG_VIDEO_DYNAMIC_RECOMMEND_DURATION_LIMIT);
            if (elementsByTagName13 != null && elementsByTagName13.getLength() > 0) {
                int intValue14 = Integer.valueOf(((Element) elementsByTagName13.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateVideoDynamicRecommmendDurationLimit(intValue14);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "video_dynamic_recommend_duration_limit value = " + intValue14);
                }
            }
            NodeList elementsByTagName14 = parse.getElementsByTagName(CONFIG_VIDEO_DYNAMIC_RECOMMEND_DURATION_PERCENT);
            if (elementsByTagName14 != null && elementsByTagName14.getLength() > 0) {
                float floatValue = Float.valueOf(((Element) elementsByTagName14.item(0)).getFirstChild().getNodeValue()).floatValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateVideoDynamicRecommendDurationPercent(floatValue);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "video_dynamic_recommend_duration_percent value = " + floatValue);
                }
            }
            NodeList elementsByTagName15 = parse.getElementsByTagName(CONFIG_VIDEO_DYNAMIC_RECOMMEND_OPERATOR);
            if (elementsByTagName15 != null && elementsByTagName15.getLength() > 0) {
                int intValue15 = Integer.valueOf(((Element) elementsByTagName15.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateVideoDynamicRecommendOperator(intValue15);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "video_dynamic_recommend_operator value = " + intValue15);
                }
            }
            NodeList elementsByTagName16 = parse.getElementsByTagName(CONFIG_WEB_NATIVE_RENDER);
            if (elementsByTagName16 != null && elementsByTagName16.getLength() > 0) {
                int intValue16 = Integer.valueOf(((Element) elementsByTagName16.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateWebRenderConfig(intValue16);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "web_viola_render_switch value = " + intValue16);
                }
            }
            NodeList elementsByTagName17 = parse.getElementsByTagName(CONFIG_WEB_NATIVE_RENDER_MODE);
            if (elementsByTagName17 != null && elementsByTagName17.getLength() > 0) {
                int intValue17 = Integer.valueOf(((Element) elementsByTagName17.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateWebRenderModeConfig(intValue17);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "web_viola_render_mode value = " + intValue17);
                }
            }
            NodeList elementsByTagName18 = parse.getElementsByTagName(CONFIG_VIDEO_CHANNEL_AUTOPLAY_SWITCH_VIDEO_FLOW);
            if (elementsByTagName18 != null && elementsByTagName18.getLength() > 0) {
                int intValue18 = Integer.valueOf(((Element) elementsByTagName18.item(0)).getFirstChild().getNodeValue()).intValue();
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "video flow video channel auto play switch default value = " + intValue18);
                }
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow(intValue18);
            }
            NodeList elementsByTagName19 = parse.getElementsByTagName(CONFIG_VIDEO_CHANNEL_FEEDS_CLICK_SWITCH);
            if (elementsByTagName19 != null && elementsByTagName19.getLength() > 0) {
                int intValue19 = Integer.valueOf(((Element) elementsByTagName19.item(0)).getFirstChild().getNodeValue()).intValue();
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "video channel feeds click switch default value = " + intValue19);
                }
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateVideoChannelFeedsClickSwitchValue(intValue19);
            }
            NodeList elementsByTagName20 = parse.getElementsByTagName(CONFIG_VIOLA_DYNAMIC);
            if (elementsByTagName20 != null && elementsByTagName20.getLength() > 0) {
                int intValue20 = Integer.valueOf(((Element) elementsByTagName20.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateViolaDynamicConfig(intValue20);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "viola dynamic default value = " + intValue20);
                }
            }
            NodeList elementsByTagName21 = parse.getElementsByTagName(CONFIG_VIOLA_DYNAMIC_WEISHI);
            if (elementsByTagName21 != null && elementsByTagName21.getLength() > 0) {
                int intValue21 = Integer.valueOf(((Element) elementsByTagName21.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateViolaWeishiAdConfig(intValue21);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "viola dynamic weishi default value = " + intValue21);
                }
            }
            NodeList elementsByTagName22 = parse.getElementsByTagName(CONFIG_VIOLA_DYNAMIC_DISCOVER);
            if (elementsByTagName22 != null && elementsByTagName22.getLength() > 0) {
                int intValue22 = Integer.valueOf(((Element) elementsByTagName22.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateViolaDiscoverConfig(intValue22);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "viola dynamic discover default value = " + intValue22);
                }
            }
            NodeList elementsByTagName23 = parse.getElementsByTagName(CONFIG_VIOLA_DYNAMIC_MESSAGE_BOX);
            if (elementsByTagName23 != null && elementsByTagName23.getLength() > 0) {
                int intValue23 = Integer.valueOf(((Element) elementsByTagName23.item(0)).getFirstChild().getNodeValue()).intValue();
                ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateViolaMessageBoxConfig(intValue23);
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountConfigUtil.TAG, 2, "viola dynamic message box default value = " + intValue23);
                }
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(IPublicAccountConfigUtil.TAG, 2, "update subscript recommend config error." + e16);
            }
            return false;
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getMergerKandianName(AppInterface appInterface, Context context) {
        return getName(appInterface, context, 3);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getSubscriptName(AppInterface appInterface, Context context) {
        return getName(appInterface, context, 1);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public String getXinKandianName(AppInterface appInterface, Context context) {
        return getName(appInterface, context, 2);
    }

    public static void addFolders(ArrayList<IPublicAccountConfigUtil.a> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        initList();
        Iterator<IPublicAccountConfigUtil.a> it = arrayList.iterator();
        while (it.hasNext()) {
            IPublicAccountConfigUtil.a next = it.next();
            list.put(Integer.valueOf(next.b()), next);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public IPublicAccountConfigUtil.a getFolder(AppInterface appInterface, Context context, int i3) {
        if (i3 == 3) {
            i3 = 2;
        }
        if (!initiatedCache.get()) {
            init(appInterface, context);
        }
        return list.get(Integer.valueOf(i3));
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
    public Drawable getDefaultDrawable(Context context, int i3) {
        if (i3 == 1) {
            return context.getResources().getDrawable(R.drawable.icon_recent_readinjoy);
        }
        if (i3 != 2 && i3 != 3) {
            return context.getResources().getDrawable(R.drawable.f160830com);
        }
        return context.getResources().getDrawable(R.drawable.icon_recent_xin_kandian);
    }

    public static String getDefaultName(AppInterface appInterface, Context context, int i3) {
        if (i3 == 1) {
            return context.getString(R.string.dyv);
        }
        if (i3 == 2 || i3 == 3) {
            return context.getString(R.string.d6l);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements c {
        a() {
        }

        @Override // com.tencent.cache.api.c
        public void onClearEnd() {
            PublicAccountConfigUtilImpl.initiatedCache.set(false);
        }

        @Override // com.tencent.cache.api.c
        public void onClearStart() {
        }
    }
}
