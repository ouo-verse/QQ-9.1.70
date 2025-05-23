package o01;

import com.heytap.databaseengine.type.DataTableNameType;
import com.heytap.databaseengine.type.SportMode;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.bugly.traffic.custom.HttpErrorUtils;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.hippy.qq.update.qarchive.tools.zip.UnixStat;
import com.tencent.luggage.wxa.gf.u;
import com.tencent.luggage.wxa.gf.y;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.luggage.wxa.kf.c;
import com.tencent.luggage.wxa.nf.f;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.cardcontainer.api.impl.CardContainerDataServiceImpl;
import com.tencent.mobileqq.icgame.data.nano.EchoDrawAndGuessGiftSvr;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.mini.servlet.MiniAppObserver;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.utils.abtest.ExpMgrListProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqnt.kernel.nativeinterface.UfsGROUPMASK;
import com.tencent.state.map.MapItemKt;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import com.tencent.view.FilterEnum;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.util.WnsError;
import cooperation.qzone.util.WnsNetworkConst;
import kotlin.text.Regex;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f421693a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static final int[][] f421694b = {new int[0], new int[]{6, 18}, new int[]{6, 22}, new int[]{6, 26}, new int[]{6, 30}, new int[]{6, 34}, new int[]{6, 22, 38}, new int[]{6, 24, 42}, new int[]{6, 26, 46}, new int[]{6, 28, 50}, new int[]{6, 30, 54}, new int[]{6, 32, 58}, new int[]{6, 34, 62}, new int[]{6, 26, 46, 66}, new int[]{6, 26, 48, 70}, new int[]{6, 26, 50, 74}, new int[]{6, 30, 54, 78}, new int[]{6, 30, 56, 82}, new int[]{6, 30, 58, 86}, new int[]{6, 34, 62, 90}, new int[]{6, 28, 50, 72, 94}, new int[]{6, 26, 50, 74, 98}, new int[]{6, 30, 54, 78, 102}, new int[]{6, 28, 54, 80, 106}, new int[]{6, 32, 58, 84, 110}, new int[]{6, 30, 58, 86, 114}, new int[]{6, 34, 62, 90, 118}, new int[]{6, 26, 50, 74, 98, 122}, new int[]{6, 30, 54, 78, 102, 126}, new int[]{6, 26, 52, 78, 104, 130}, new int[]{6, 30, 56, 82, 108, 134}, new int[]{6, 34, 60, 86, 112, 138}, new int[]{6, 30, 58, 86, 114, 142}, new int[]{6, 34, 62, 90, 118, 146}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: c, reason: collision with root package name */
    public static final int[][][] f421695c = {new int[][]{new int[]{41, 25, 17, 10}, new int[]{34, 20, 14, 8}, new int[]{27, 16, 11, 7}, new int[]{17, 10, 7, 4}}, new int[][]{new int[]{77, 47, 32, 20}, new int[]{63, 38, 26, 16}, new int[]{48, 29, 20, 12}, new int[]{34, 20, 14, 8}}, new int[][]{new int[]{127, 77, 53, 32}, new int[]{101, 61, 42, 26}, new int[]{77, 47, 32, 20}, new int[]{58, 35, 24, 15}}, new int[][]{new int[]{187, 114, 78, 48}, new int[]{149, 90, 62, 38}, new int[]{111, 67, 46, 28}, new int[]{82, 50, 34, 21}}, new int[][]{new int[]{255, 154, 106, 65}, new int[]{202, 122, 84, 52}, new int[]{144, 87, 60, 37}, new int[]{106, 64, 44, 27}}, new int[][]{new int[]{322, 195, 134, 82}, new int[]{255, 154, 106, 65}, new int[]{178, 108, 74, 45}, new int[]{139, 84, 58, 36}}, new int[][]{new int[]{370, 224, 154, 95}, new int[]{293, 178, 122, 75}, new int[]{207, 125, 86, 53}, new int[]{154, 93, 64, 39}}, new int[][]{new int[]{461, FilterEnum.MIC_PTU_TRANS_ROUHE, 192, 118}, new int[]{365, 221, 152, 93}, new int[]{259, 157, 108, 66}, new int[]{202, 122, 84, 52}}, new int[][]{new int[]{552, 335, 230, 141}, new int[]{432, 262, 180, 111}, new int[]{312, 189, 130, 80}, new int[]{235, 143, 98, 60}}, new int[][]{new int[]{com.tencent.luggage.wxa.eg.b.CTRL_INDEX, com.tencent.luggage.wxa.v1.b.CTRL_INDEX, 271, 167}, new int[]{513, 311, 213, 131}, new int[]{364, 221, 151, 93}, new int[]{288, 174, 119, 74}}, new int[][]{new int[]{772, c.d.CTRL_INDEX, 321, 198}, new int[]{604, 366, 251, 155}, new int[]{427, 259, 177, 109}, new int[]{331, 200, 137, 85}}, new int[][]{new int[]{883, 535, 367, 226}, new int[]{691, 419, 287, 177}, new int[]{489, 296, 203, 125}, new int[]{374, 227, 155, 96}}, new int[][]{new int[]{1022, 619, 425, 262}, new int[]{796, 483, 331, 204}, new int[]{580, com.tencent.luggage.wxa.rf.g.CTRL_INDEX, 241, 149}, new int[]{427, 259, 177, 109}}, new int[][]{new int[]{1101, QVipGiftProcessor.CMD, 458, FilterEnum.MIC_PTU_BAIXI}, new int[]{871, 528, 362, 223}, new int[]{621, 376, 258, 159}, new int[]{c.d.CTRL_INDEX, 283, 194, 120}}, new int[][]{new int[]{UfsGROUPMASK.GROUP_MASK_PRECISE_RICH, 758, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST, 320}, new int[]{991, 600, 412, 254}, new int[]{703, PlayUI.UIType.BIG_CARD_SHAPED_PIC, 292, 180}, new int[]{530, 321, 220, 136}}, new int[][]{new int[]{1408, 854, 586, 361}, new int[]{1082, 656, 450, 277}, new int[]{775, 470, 322, 198}, new int[]{602, 365, 250, 154}}, new int[][]{new int[]{1548, com.tencent.luggage.wxa.i2.b.CTRL_INDEX, 644, 397}, new int[]{1212, com.tencent.luggage.wxa.ci.a.CTRL_INDEX, 504, 310}, new int[]{876, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED, 364, 224}, new int[]{674, 408, FilterEnum.MIC_PTU_TRANS_XINXIAN, 173}}, new int[][]{new int[]{1725, 1046, 718, 442}, new int[]{1346, 816, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, 345}, new int[]{948, 574, 394, 243}, new int[]{746, 452, 310, 191}}, new int[][]{new int[]{WnsError.WNS_CODE_LOGIN_A2_ILLEGAL, gdt_analysis_event.EVENT_GET_VERSION_CODENAME, com.tencent.luggage.wxa.uf.l.CTRL_INDEX, 488}, new int[]{1500, SportMode.PLAYGROUND_RUN, 624, MsgConstant.KRMFILETHUMBSIZE384}, new int[]{1063, 644, 442, 272}, new int[]{com.tencent.luggage.wxa.uf.e.CTRL_INDEX, UnixStat.DEFAULT_DIR_PERM, 338, 208}}, new int[][]{new int[]{2061, 1249, 858, 528}, new int[]{1600, 970, 666, 410}, new int[]{1159, 702, 482, 297}, new int[]{919, PlayerResources.ViewId.PLAYER_DURATION, 382, 235}}, new int[][]{new int[]{2232, CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID, 929, PlayerResources.ViewId.EXTENDED_VIEW_TV_COUNTDOWN}, new int[]{1708, 1035, 711, 438}, new int[]{gdt_analysis_event.EVENT_VIDEO_FIRST_FRAME_RENDERED, ExpMgrListProcessor.CONFIG_ID, 509, 314}, new int[]{969, LpReportInfoConfig.ACTION_HOMEPAGE_GUEST, 403, 248}}, new int[][]{new int[]{2409, 1460, 1003, 618}, new int[]{1872, 1134, com.tencent.luggage.wxa.gg.e.CTRL_INDEX, 480}, new int[]{1358, 823, PlayerResources.ViewId.EXTENDED_VIEW_NAME_PLUS_HEAD, f.b.CTRL_INDEX}, new int[]{1056, 640, com.tencent.luggage.wxa.yd.a.CTRL_INDEX, 270}}, new int[][]{new int[]{2620, 1588, MiniAppObserver.MINI_APP_BATCH_GET_GAME_FOLLOW_COUNT, 672}, new int[]{2059, 1248, u.CTRL_INDEX, 528}, new int[]{EchoDrawAndGuessGiftSvr.ECHO_DRAW_AND_GUESS_GIFT_SVR, y.CTRL_INDEX, 611, 376}, new int[]{1108, 672, 461, 284}}, new int[][]{new int[]{2812, FSUploadConst.ERR_UPLOAD_RESULT_ILLEGAL, 1171, 721}, new int[]{2188, 1326, HttpErrorUtils.CONNECTION_RESET_EXCEPTION, PlayerResources.ViewId.GET_MORE_TOGGLE_ARROW_BTN}, new int[]{1588, 963, LpReportInfoConfig.ACTION_SPECIAL_FOLLOW_TOAST, 407}, new int[]{gdt_analysis_event.EVENT_REWARDED_VIDEO_DATA_WITH_EXT_JSON, 744, 511, 315}}, new int[][]{new int[]{3057, 1853, 1273, 784}, new int[]{2395, 1451, 997, 614}, new int[]{1718, 1041, 715, 440}, new int[]{1286, com.tencent.luggage.wxa.gg.e.CTRL_INDEX, 535, MapItemKt.ITEM_AVATAR_MIN_WIDTH}}, new int[][]{new int[]{3283, SubAccountBindActivity.SUBACCOUNTBINDACTIVITY_CLOSE_DIALOG, 1367, com.tencent.luggage.wxa.uf.h.CTRL_INDEX}, new int[]{2544, 1542, 1059, com.tencent.luggage.wxa.eg.b.CTRL_INDEX}, new int[]{1804, 1094, com.tencent.luggage.wxa.sm.e.O, 462}, new int[]{1425, 864, LpReportInfoConfig.ACTION_TYPE_COMMON_SETTING, 365}}, new int[][]{new int[]{3517, 2132, 1465, 902}, new int[]{JsonGrayBusiId.AIO_PUSH_GUIDE_GRAY_TIPS, 1637, gdt_analysis_event.EVENT_GET_USER_AGENT, 692}, new int[]{1933, 1172, 805, w.CTRL_INDEX}, new int[]{1501, 910, 625, 385}}, new int[][]{new int[]{3669, Constants.Action.ACTION_AFTER_FETCH_CONFIG_LOG_REPORT, 1528, 940}, new int[]{2857, 1732, 1190, TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION}, new int[]{2085, 1263, 868, 534}, new int[]{1581, 958, 658, 405}}, new int[][]{new int[]{3909, 2369, 1628, 1002}, new int[]{LaunchScene.LAUNCH_SCENE_GAME_CENTER_FROM_GUILD, 1839, InitSkin.COLOR_COUNT, 778}, new int[]{2181, gdt_analysis_event.EVENT_FEEDBACK_CLICK, 908, PlayerResources.ViewId.ADVTISMENT_VIDEO_TIP}, new int[]{1677, 1016, 698, 430}}, new int[][]{new int[]{4158, 2520, 1732, DataTableNameType.TABLE_SNORE_OSA_MODEL}, new int[]{3289, 1994, 1370, com.tencent.luggage.wxa.uf.j.CTRL_INDEX}, new int[]{2358, 1429, 982, 604}, new int[]{1782, 1080, ExpMgrListProcessor.CONFIG_ID, 457}}, new int[][]{new int[]{4417, 2677, 1840, 1132}, new int[]{3486, Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST, 1452, 894}, new int[]{2473, 1499, 1030, 634}, new int[]{1897, 1150, com.tencent.luggage.wxa.uf.c.CTRL_INDEX, 486}}, new int[][]{new int[]{4686, 2840, 1952, 1201}, new int[]{3693, 2238, 1538, 947}, new int[]{2670, 1618, 1112, com.tencent.luggage.wxa.yf.d.CTRL_INDEX}, new int[]{2022, 1226, com.tencent.luggage.wxa.uf.h.CTRL_INDEX, WnsNetworkConst.WRITE_FAIL}}, new int[][]{new int[]{4965, 3009, 2068, 1273}, new int[]{3909, 2369, 1628, 1002}, new int[]{2805, FSUploadConst.ERR_FILE_NOT_EXIST, 1168, 719}, new int[]{2157, 1307, 898, PlayerResources.ViewId.LOADING}}, new int[][]{new int[]{5253, 3183, 2188, 1347}, new int[]{4134, 2506, 1722, 1060}, new int[]{2949, 1787, gdt_analysis_event.EVENT_REWARDED_VIDEO_DATA_WITH_EXT_JSON, 756}, new int[]{JsonGrayBusiId.AIO_ZPLAN_EMOTICON_GUIDE, 1394, 958, c0.CTRL_INDEX}}};

    public final int a(String str) {
        if (new Regex("^[0-9A-Z $%*+\\-./:]+$").matches(str)) {
            return new Regex("^\\d+$").matches(str) ? 1 : 2;
        }
        return 3;
    }
}
