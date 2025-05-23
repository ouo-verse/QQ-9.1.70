package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.luggage.wxa.gf.d0;
import com.tencent.luggage.wxa.nf.f;
import com.tencent.luggage.wxa.yf.e0;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.data.type.IUserPlatformType;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.view.FilterEnum;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/emoticon/q;", "", "", "emCodeStr", "", "b", "emCode", "e", "f", "d", "content", "a", "emoCode", "c", "Ljava/util/regex/Pattern;", "Ljava/util/regex/Pattern;", "qzoneEmoPatternOnlyNumber", "", "Ljava/util/Map;", "SYS_FACE_EM_CODE_TO_QSID", "EMOJI_EM_CODE_TO_QSID", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f204858a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Pattern qzoneEmoPatternOnlyNumber;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> SYS_FACE_EM_CODE_TO_QSID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> EMOJI_EM_CODE_TO_QSID;

    static {
        Map<Integer, Integer> mapOf;
        Map<Integer, String> mapOf2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31428);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f204858a = new q();
        Pattern compile = Pattern.compile("\\[em\\]e(\\d{1,}+)\\[/em\\]");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(\"\\\\[em\\\\]e(\\\\d{1,}+)\\\\[/em\\\\]\")");
        qzoneEmoPatternOnlyNumber = compile;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(114, 0), TuplesKt.to(101, 1), TuplesKt.to(102, 2), TuplesKt.to(103, 3), TuplesKt.to(104, 4), TuplesKt.to(105, 5), TuplesKt.to(106, 6), TuplesKt.to(107, 7), TuplesKt.to(108, 8), TuplesKt.to(109, 9), TuplesKt.to(110, 10), TuplesKt.to(111, 11), TuplesKt.to(112, 12), TuplesKt.to(113, 13), TuplesKt.to(100, 14), TuplesKt.to(115, 15), TuplesKt.to(116, 16), TuplesKt.to(118, 18), TuplesKt.to(119, 19), TuplesKt.to(120, 20), TuplesKt.to(121, 21), TuplesKt.to(122, 22), TuplesKt.to(123, 23), TuplesKt.to(124, 24), TuplesKt.to(125, 25), TuplesKt.to(126, 26), TuplesKt.to(127, 27), TuplesKt.to(128, 28), TuplesKt.to(129, 29), TuplesKt.to(130, 30), TuplesKt.to(131, 31), TuplesKt.to(132, 32), TuplesKt.to(133, 33), TuplesKt.to(134, 34), TuplesKt.to(135, 35), TuplesKt.to(136, 36), TuplesKt.to(137, 37), TuplesKt.to(138, 38), TuplesKt.to(139, 39), TuplesKt.to(193, 41), TuplesKt.to(190, 42), TuplesKt.to(192, 43), TuplesKt.to(162, 46), TuplesKt.to(178, 49), TuplesKt.to(168, 53), TuplesKt.to(170, 55), TuplesKt.to(171, 56), TuplesKt.to(174, 59), TuplesKt.to(160, 60), TuplesKt.to(163, 63), TuplesKt.to(164, 64), TuplesKt.to(166, 66), TuplesKt.to(167, 67), TuplesKt.to(176, 74), TuplesKt.to(175, 75), TuplesKt.to(179, 76), TuplesKt.to(180, 77), TuplesKt.to(181, 78), TuplesKt.to(182, 79), TuplesKt.to(191, 85), TuplesKt.to(194, 86), TuplesKt.to(156, 89), TuplesKt.to(117, 96), TuplesKt.to(140, 97), TuplesKt.to(141, 98), TuplesKt.to(142, 99), TuplesKt.to(143, 100), TuplesKt.to(144, 101), TuplesKt.to(145, 102), TuplesKt.to(146, 103), TuplesKt.to(147, 104), TuplesKt.to(148, 105), TuplesKt.to(149, 106), TuplesKt.to(150, 107), TuplesKt.to(151, 108), TuplesKt.to(152, 109), TuplesKt.to(153, 110), TuplesKt.to(154, 111), TuplesKt.to(155, 112), TuplesKt.to(158, 114), TuplesKt.to(165, 116), TuplesKt.to(183, 118), TuplesKt.to(184, 119), TuplesKt.to(185, 120), TuplesKt.to(186, 121), TuplesKt.to(187, 122), TuplesKt.to(188, 123), TuplesKt.to(189, 124), TuplesKt.to(195, 125), TuplesKt.to(199, 129), TuplesKt.to(121002, 137), TuplesKt.to(121009, 144), TuplesKt.to(121011, 146), TuplesKt.to(121012, 147), TuplesKt.to(121013, 148), TuplesKt.to(121034, 169), TuplesKt.to(241, 171), TuplesKt.to(242, 172), TuplesKt.to(243, 173), TuplesKt.to(244, 174), TuplesKt.to(245, 175), TuplesKt.to(246, 176), TuplesKt.to(247, 177), TuplesKt.to(248, 178), TuplesKt.to(249, 179), TuplesKt.to(250, 180), TuplesKt.to(251, 181), TuplesKt.to(252, 182), TuplesKt.to(253, 183), TuplesKt.to(255, 185), TuplesKt.to(257, 187), TuplesKt.to(263, 193), TuplesKt.to(264, 194), TuplesKt.to(268, 198), TuplesKt.to(270, 200), TuplesKt.to(271, 201), TuplesKt.to(272, 202), TuplesKt.to(273, 203), TuplesKt.to(274, 204), TuplesKt.to(276, 206), TuplesKt.to(Integer.valueOf(FilterEnum.MIC_PTU_TRANS_XINXIAN), 210), TuplesKt.to(Integer.valueOf(FilterEnum.MIC_PTU_TRANS_KONGCHENG), 211), TuplesKt.to(Integer.valueOf(FilterEnum.MIC_PTU_BAIXI), 212), TuplesKt.to(284, 214), TuplesKt.to(285, 215), TuplesKt.to(286, 216), TuplesKt.to(287, 217), TuplesKt.to(288, 218), TuplesKt.to(Integer.valueOf(FilterEnum.MIC_PTU_ZIRAN), 219), TuplesKt.to(291, 221), TuplesKt.to(292, 222), TuplesKt.to(293, 223), TuplesKt.to(295, 224), TuplesKt.to(296, 225), TuplesKt.to(297, 226), TuplesKt.to(294, 227), TuplesKt.to(299, 229), TuplesKt.to(300, 230), TuplesKt.to(301, 231), TuplesKt.to(302, 232), TuplesKt.to(303, 233), TuplesKt.to(305, 235), TuplesKt.to(307, 237), TuplesKt.to(308, 238), TuplesKt.to(309, 239), TuplesKt.to(310, 240), TuplesKt.to(311, 241), TuplesKt.to(313, 243), TuplesKt.to(312, 244), TuplesKt.to(10262, 262), TuplesKt.to(10263, 263), TuplesKt.to(10264, 264), TuplesKt.to(10265, 265), TuplesKt.to(10266, 266), TuplesKt.to(10267, 267), TuplesKt.to(10268, 268), TuplesKt.to(10269, 269), TuplesKt.to(10270, 270), TuplesKt.to(10271, 271), TuplesKt.to(10272, 272), TuplesKt.to(10273, 273), TuplesKt.to(10277, 277), TuplesKt.to(20237, 278), TuplesKt.to(10281, Integer.valueOf(FilterEnum.MIC_PTU_TRANS_KONGCHENG)), TuplesKt.to(10282, Integer.valueOf(FilterEnum.MIC_PTU_BAIXI)), TuplesKt.to(10283, 283), TuplesKt.to(10284, 284), TuplesKt.to(10285, 285), TuplesKt.to(10286, 286), TuplesKt.to(10287, 287), TuplesKt.to(10288, 288), TuplesKt.to(10289, Integer.valueOf(FilterEnum.MIC_PTU_ZIRAN)), TuplesKt.to(20240, 290), TuplesKt.to(20242, 292), TuplesKt.to(10293, 293), TuplesKt.to(10294, 294), TuplesKt.to(10295, 295), TuplesKt.to(10297, 297), TuplesKt.to(10298, 298), TuplesKt.to(10299, 299), TuplesKt.to(10300, 300), TuplesKt.to(10301, 301), TuplesKt.to(10302, 302), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_CLIP_START), 303), TuplesKt.to(10305, 305), TuplesKt.to(10306, 306), TuplesKt.to(10307, 307), TuplesKt.to(10311, 311), TuplesKt.to(10312, 312), TuplesKt.to(10314, 314), TuplesKt.to(10317, 317), TuplesKt.to(10318, 318), TuplesKt.to(10319, 319), TuplesKt.to(10320, 320), TuplesKt.to(10322, 322), TuplesKt.to(10323, 323), TuplesKt.to(10324, 324), TuplesKt.to(10325, 325), TuplesKt.to(10326, 326), TuplesKt.to(10332, 332), TuplesKt.to(10333, 333), TuplesKt.to(10334, 334), TuplesKt.to(10336, 336), TuplesKt.to(10337, 337), TuplesKt.to(10338, 338), TuplesKt.to(10339, 339), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_CGI_BUILD_REQUEST_PARAMS_START), 341), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_CGI_LOOK_UP_LOCAL_CACHE_START), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.coverview.a.CTRL_INDEX)), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_CGI_HTTP_REQUEST), Integer.valueOf(d0.CTRL_INDEX)), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_CGI_HTTP_RESPONSE), Integer.valueOf(com.tencent.luggage.wxa.fe.a.CTRL_INDEX)), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_CGI_LOOK_UP_OFFLINE_RESOURCE_FOR_QUICK_PLAY_START), 345), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_CGI_HANDLE_RESPONSE_SUCCESS), 346), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_CGI_RESPONSE_HEADERS), Integer.valueOf(com.tencent.luggage.wxa.nf.i.CTRL_INDEX)), TuplesKt.to(10348, Integer.valueOf(f.b.CTRL_INDEX)), TuplesKt.to(10349, 349), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_PRE_AD_CGI_HTTP_REQUEST), Integer.valueOf(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID)), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_PRE_AD_CGI_HTTP_RESPONSE), 351), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_PRE_AD_PREPARE_START), Integer.valueOf(com.tencent.luggage.wxa.rf.g.CTRL_INDEX)), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_PRE_AD_NOT_FOUNT), Integer.valueOf(com.tencent.luggage.wxa.rf.f.CTRL_INDEX)), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_PRE_AD_ON_PREPARED), Integer.valueOf(com.tencent.luggage.wxa.rf.h.CTRL_INDEX)), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_PRE_AD_TIMEOUT), 355), TuplesKt.to(10356, 356), TuplesKt.to(10357, 357), TuplesKt.to(10358, Integer.valueOf(com.tencent.luggage.wxa.rf.d.CTRL_INDEX)), TuplesKt.to(10359, 359), TuplesKt.to(Integer.valueOf(TVKEventId.PLAYER_STATE_ERROR_RETRY), 360), TuplesKt.to(Integer.valueOf(IUserPlatformType.PLATFORM_PC_WEB), 361), TuplesKt.to(Integer.valueOf(IUserPlatformType.PLATFORM_MOBILE_WEB), 362), TuplesKt.to(Integer.valueOf(IUserPlatformType.PLATFORM_PCQQ_WEB), 363), TuplesKt.to(10364, 364), TuplesKt.to(10365, 365), TuplesKt.to(10366, 366), TuplesKt.to(10367, 367), TuplesKt.to(10368, 368), TuplesKt.to(10369, 369), TuplesKt.to(10370, 370), TuplesKt.to(10371, 371), TuplesKt.to(10372, Integer.valueOf(com.tencent.luggage.wxa.se.b.CTRL_INDEX)), TuplesKt.to(10373, Integer.valueOf(com.tencent.luggage.wxa.se.c.CTRL_INDEX)), TuplesKt.to(10374, 374), TuplesKt.to(10375, Integer.valueOf(QidPagView.DESIGN_PAG_WIDTH)), TuplesKt.to(10376, 376), TuplesKt.to(10377, Integer.valueOf(NotificationUtil.Constants.NOTIFY_ID_UNIFORM_DOWNLOAD_END)), TuplesKt.to(10378, Integer.valueOf(NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN)), TuplesKt.to(10379, 379), TuplesKt.to(10380, Integer.valueOf(LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT)), TuplesKt.to(10381, 381), TuplesKt.to(10382, 382), TuplesKt.to(10383, 383), TuplesKt.to(10384, Integer.valueOf(MsgConstant.KRMFILETHUMBSIZE384)), TuplesKt.to(10385, 385), TuplesKt.to(10386, 386), TuplesKt.to(10387, Integer.valueOf(tlv_t183.CMD_183)), TuplesKt.to(10388, 388), TuplesKt.to(10389, Integer.valueOf(e0.CTRL_INDEX)), TuplesKt.to(10390, 390), TuplesKt.to(10391, 391), TuplesKt.to(10392, Integer.valueOf(QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE)), TuplesKt.to(10393, Integer.valueOf(QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_EXTERNAL_COMMENT_TYPE)), TuplesKt.to(10394, 394), TuplesKt.to(10395, Integer.valueOf(com.tencent.luggage.wxa.v1.b.CTRL_INDEX)), TuplesKt.to(10396, 396), TuplesKt.to(10397, 397), TuplesKt.to(10398, 398), TuplesKt.to(10399, 399), TuplesKt.to(Integer.valueOf(PlayUI.UIType.WEAKEN_SMALL_CARD_NG), 400), TuplesKt.to(Integer.valueOf(PlayUI.UIType.WEAKEN_MEDIUM_CARD_NG), 401), TuplesKt.to(10402, 402), TuplesKt.to(10403, 403), TuplesKt.to(10404, 404), TuplesKt.to(Integer.valueOf(JsonGrayBusiId.TROOP_BREAK_ICE), 405), TuplesKt.to(10406, 406), TuplesKt.to(10407, 407), TuplesKt.to(10408, 408), TuplesKt.to(10409, 409), TuplesKt.to(10410, 410), TuplesKt.to(10411, 411), TuplesKt.to(10412, 412), TuplesKt.to(10413, 413), TuplesKt.to(10414, 414), TuplesKt.to(10415, 415), TuplesKt.to(10416, 416), TuplesKt.to(10417, 417));
        SYS_FACE_EM_CODE_TO_QSID = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(401328, "\u2600"), TuplesKt.to(401262, "\u2615"), TuplesKt.to(401181, "\u263a"), TuplesKt.to(401210, "\u270c"), TuplesKt.to(401137, "\u2728"), TuplesKt.to(401145, "\u2754"), TuplesKt.to(400116, "\u1f339"), TuplesKt.to(400132, "\u1f349"), TuplesKt.to(400137, "\u1f34e"), TuplesKt.to(400142, "\u1f353"), TuplesKt.to(400151, "\u1f35c"), TuplesKt.to(400153, "\u1f35e"), TuplesKt.to(400162, "\u1f367"), TuplesKt.to(400181, "\u1f37a"), TuplesKt.to(400182, "\u1f37b"), TuplesKt.to(400198, "\u1f389"), TuplesKt.to(400281, "\u1f3ea"), TuplesKt.to(400302, "\u1f40e"), TuplesKt.to(400308, "\u1f414"), TuplesKt.to(400315, "\u1f41b"), TuplesKt.to(400334, "\u1f42e"), TuplesKt.to(400339, "\u1f433"), TuplesKt.to(400341, "\u1f435"), TuplesKt.to(400342, "\u1f436"), TuplesKt.to(400343, "\u1f437"), TuplesKt.to(400344, "\u1f438"), TuplesKt.to(400351, "\u1f440"), TuplesKt.to(400390, "\u1f44a"), TuplesKt.to(400402, "\u1f44c"), TuplesKt.to(400408, "\u1f44d"), TuplesKt.to(400414, "\u1f44e"), TuplesKt.to(400420, "\u1f44f"), TuplesKt.to(400449, "\u1f462"), TuplesKt.to(400453, "\u1f466"), TuplesKt.to(400459, "\u1f467"), TuplesKt.to(400562, "\u1f47b"), TuplesKt.to(400611, "\u1f489"), TuplesKt.to(400621, "\u1f493"), TuplesKt.to(400631, "\u1f49d"), TuplesKt.to(400637, "\u1f4a3"), TuplesKt.to(400638, "\u1f4a4"), TuplesKt.to(400640, "\u1f4a6"), TuplesKt.to(400642, "\u1f4a8"), TuplesKt.to(400643, "\u1f4a9"), TuplesKt.to(400644, "\u1f4aa"), TuplesKt.to(400714, "\u1f4eb"), TuplesKt.to(400768, "\u1f525"), TuplesKt.to(400774, "\u1f52b"), TuplesKt.to(400823, "\u1f601"), TuplesKt.to(400824, "\u1f602"), TuplesKt.to(400826, "\u1f604"), TuplesKt.to(400832, "\u1f60a"), TuplesKt.to(400834, "\u1f60c"), TuplesKt.to(400835, "\u1f60d"), TuplesKt.to(400837, "\u1f60f"), TuplesKt.to(400840, "\u1f612"), TuplesKt.to(400841, "\u1f613"), TuplesKt.to(400842, "\u1f614"), TuplesKt.to(400846, "\u1f618"), TuplesKt.to(400848, "\u1f61a"), TuplesKt.to(400850, "\u1f61c"), TuplesKt.to(400851, "\u1f61d"), TuplesKt.to(400867, "\u1f62d"), TuplesKt.to(400870, "\u1f630"), TuplesKt.to(400871, "\u1f631"), TuplesKt.to(400873, "\u1f633"), TuplesKt.to(400396, "\u1f64f"), TuplesKt.to(400987, "\u1f6ac"));
        EMOJI_EM_CODE_TO_QSID = mapOf2;
    }

    q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int b(String emCodeStr) {
        String group;
        if (TextUtils.isEmpty(emCodeStr)) {
            return -1;
        }
        Matcher matcher = qzoneEmoPatternOnlyNumber.matcher(emCodeStr);
        if (matcher.find() && (group = matcher.group(1)) != null) {
            try {
                return Integer.parseInt(group);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    @JvmStatic
    @NotNull
    public static final String d(int emCode) {
        String str = EMOJI_EM_CODE_TO_QSID.get(Integer.valueOf(emCode));
        if (str == null) {
            return "";
        }
        return str;
    }

    @JvmStatic
    public static final int e(int emCode) {
        Integer num = SYS_FACE_EM_CODE_TO_QSID.get(Integer.valueOf(emCode));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @JvmStatic
    public static final int f(@NotNull String emCodeStr) {
        Integer num;
        Intrinsics.checkNotNullParameter(emCodeStr, "emCodeStr");
        int b16 = f204858a.b(emCodeStr);
        if (b16 < 0 || (num = SYS_FACE_EM_CODE_TO_QSID.get(Integer.valueOf(b16))) == null) {
            return -1;
        }
        return num.intValue();
    }

    @NotNull
    public final String a(@NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        Matcher matcher = qzoneEmoPatternOnlyNumber.matcher(content);
        String str = content;
        while (matcher.find()) {
            String targetString = matcher.group(0);
            String targetNumber = matcher.group(1);
            Intrinsics.checkNotNullExpressionValue(targetNumber, "targetNumber");
            String c16 = c(targetNumber);
            if (c16 != null) {
                Intrinsics.checkNotNullExpressionValue(targetString, "targetString");
                str = StringsKt__StringsJVMKt.replace$default(str, targetString, c16, false, 4, (Object) null);
            }
        }
        return str;
    }

    @Nullable
    public final String c(@NotNull String emoCode) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoCode);
        }
        Intrinsics.checkNotNullParameter(emoCode, "emoCode");
        if (TextUtils.isEmpty(emoCode)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(emoCode);
            if (10000 <= parseInt && parseInt < 40000) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return QQSysFaceUtil.getFaceString(parseInt - 10000);
            }
            int e16 = e(parseInt);
            if (e16 != -1) {
                return QQSysFaceUtil.getFaceString(QQSysAndEmojiResMgr.getInstance().getResImpl(1).getLocalId(e16));
            }
            String d16 = d(parseInt);
            if (!TextUtils.isEmpty(d16)) {
                return d16;
            }
            return "";
        } catch (Exception e17) {
            QLog.e("QzoneEMCodeUtils", 1, e17, new Object[0]);
            return "";
        }
    }
}
