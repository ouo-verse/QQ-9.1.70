package com.tencent.mobileqq.confess;

import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.luggage.wxa.yf.o;
import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqnt.kernel.nativeinterface.UfsGROUPMASK;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.state.map.MapItemKt;
import com.tencent.thumbplayer.api.common.TPErrorType;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.view.FilterEnum;
import cooperation.qzone.report.lp.LpReportInfoConfig;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f202169a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f202170a;

        /* renamed from: b, reason: collision with root package name */
        public int f202171b;

        /* renamed from: c, reason: collision with root package name */
        public int f202172c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f202173d;

        /* renamed from: e, reason: collision with root package name */
        public float f202174e;

        public a(int i3, int i16, int i17, boolean z16, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Float.valueOf(f16));
                return;
            }
            this.f202170a = i3;
            this.f202171b = i16;
            this.f202172c = i17;
            this.f202173d = z16;
            this.f202174e = f16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f202169a = new String[]{"#B45EFF", "#3C8DFE", "#00B0C7", "#FF6565"};
        }
    }

    public static a[] a(int i3, int i16) {
        if (i3 == 0) {
            if (i16 == 0) {
                return new a[]{new a(R.drawable.eox, 60, 60, true, 0.75f), new a(R.drawable.f161725ep2, 458, 84, true, 0.75f), new a(R.drawable.f161726ep3, 142, 250, true, 0.75f), new a(R.drawable.eox, 368, 188, true, 0.75f), new a(R.drawable.eov, 168, 120, true, 0.75f), new a(R.drawable.epr, 120, 40, true, 0.75f), new a(R.drawable.eps, 120, 110, true, 0.75f), new a(R.drawable.epp, 30, 150, true, 0.75f), new a(R.drawable.epp, 180, 200, true, 0.75f), new a(R.drawable.epr, 420, 160, true, 0.75f), new a(R.drawable.eps, 495, 150, true, 0.75f), new a(R.drawable.epo, 257, 82, false, 1.0f)};
            }
            if (i16 == 1) {
                return new a[]{new a(R.drawable.f161727ep4, 60, 88, true, 0.75f), new a(R.drawable.eow, 226, 56, true, 0.75f), new a(R.drawable.f161726ep3, 480, 140, true, 0.75f), new a(R.drawable.f161724ep1, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 198, true, 0.75f), new a(R.drawable.f161725ep2, 168, 244, true, 0.75f), new a(R.drawable.epr, 300, 50, true, 0.75f), new a(R.drawable.eps, LocaleManager.MOBILE_COUNTRY_CODE_CN_INT, 50, true, 0.75f), new a(R.drawable.epp, 60, 230, true, 0.75f), new a(R.drawable.epr, 120, 120, true, 0.75f), new a(R.drawable.epr, 440, 270, true, 0.75f), new a(R.drawable.epo, 257, 82, false, 1.0f)};
            }
            if (i16 == 2) {
                return new a[]{new a(R.drawable.eox, 174, 58, true, 0.75f), new a(R.drawable.eoz, 70, 146, true, 0.75f), new a(R.drawable.f161724ep1, 390, 106, true, 0.75f), new a(R.drawable.eow, 206, 240, true, 0.75f), new a(R.drawable.eoy, 470, 225, true, 0.75f), new a(R.drawable.eps, 120, 88, true, 0.75f), new a(R.drawable.eps, 480, 70, true, 0.75f), new a(R.drawable.epp, 110, 230, true, 0.75f), new a(R.drawable.epr, 340, 210, true, 0.75f), new a(R.drawable.epo, 257, 82, false, 1.0f)};
            }
            if (i16 == 3) {
                return new a[]{new a(R.drawable.f161726ep3, 138, 88, true, 0.75f), new a(R.drawable.eox, 68, 232, true, 0.75f), new a(R.drawable.f161724ep1, 298, 206, true, 0.75f), new a(R.drawable.f161727ep4, 480, 140, true, 0.75f), new a(R.drawable.epw, 382, 140, true, 0.75f), new a(R.drawable.epr, 60, 90, true, 0.75f), new a(R.drawable.epp, 182, 64, true, 0.75f), new a(R.drawable.epp, 440, 210, true, 0.75f), new a(R.drawable.epr, 440, 30, true, 0.75f), new a(R.drawable.epr, 190, 200, true, 0.75f), new a(R.drawable.epo, 257, 82, false, 1.0f)};
            }
        } else if (i3 == 1) {
            if (i16 == 0) {
                return new a[]{new a(R.drawable.eoy, 110, 230, true, 1.0f), new a(R.drawable.f161724ep1, 656, 170, true, 1.0f), new a(R.drawable.eow, 516, ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, true, 1.0f), new a(R.drawable.eox, 84, 550, true, 1.0f), new a(R.drawable.f161725ep2, 656, 586, true, 1.0f), new a(R.drawable.eox, 526, com.tencent.luggage.wxa.ci.b.CTRL_INDEX, true, 1.0f), new a(R.drawable.f161726ep3, 198, 830, true, 1.0f), new a(R.drawable.eoz, 70, 1016, true, 1.0f), new a(R.drawable.f161724ep1, 397, 952, true, 1.0f), new a(R.drawable.f161727ep4, TbsListener.ErrorCode.STATIC_TBS_INSTALL_TMP_RENAME_ERR, x.CTRL_INDEX, true, 1.0f), new a(R.drawable.eow, 220, 1257, true, 1.0f), new a(R.drawable.f161723ep0, 606, TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_VIDEO_NOT_SUPPORT, true, 1.0f), new a(R.drawable.epw, 452, 475, true, 1.0f), new a(R.drawable.eov, 240, MiniReportManager.EventId.PAGE_LOAD_END, true, 1.0f), new a(R.drawable.epp, 160, 300, true, 1.0f), new a(R.drawable.eps, TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION, MapItemKt.ITEM_AVATAR_MIN_WIDTH, true, 1.0f), new a(R.drawable.epq, 620, 450, true, 1.0f), new a(R.drawable.epr, 175, 500, true, 1.0f), new a(R.drawable.epr, LocaleManager.MOBILE_COUNTRY_CODE_CN_INT, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, true, 1.0f), new a(R.drawable.eps, 180, 630, true, 1.0f), new a(R.drawable.epp, 40, 690, true, 1.0f), new a(R.drawable.epp, 260, 750, true, 1.0f), new a(R.drawable.eps, 710, 600, true, 1.0f), new a(R.drawable.epr, 600, 710, true, 1.0f), new a(R.drawable.epr, 140, 970, true, 1.0f), new a(R.drawable.epp, 85, 1200, true, 1.0f), new a(R.drawable.epp, 600, 1050, true, 1.0f), new a(R.drawable.eps, 420, 1100, true, 1.0f), new a(R.drawable.epr, 540, UfsGROUPMASK.GROUP_MASK_PRECISE_RICH, true, 1.0f), new a(R.drawable.epv, QidPagView.DESIGN_PAG_WIDTH, 134, false, 1.0f)};
            }
            if (i16 == 1) {
                return new a[]{new a(R.drawable.f161724ep1, 110, 368, true, 1.0f), new a(R.drawable.f161725ep2, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, 256, true, 1.0f), new a(R.drawable.eox, 655, 475, true, 1.0f), new a(R.drawable.f161727ep4, 75, 740, true, 1.0f), new a(R.drawable.eow, 320, LpReportInfoConfig.ACTION_TYPE_DAWANG, true, 1.0f), new a(R.drawable.f161726ep3, TbsListener.ErrorCode.STATIC_TBS_INSTALL_TMP_RENAME_ERR, 832, true, 1.0f), new a(R.drawable.f161724ep1, 505, o.CTRL_INDEX, true, 1.0f), new a(R.drawable.f161725ep2, 260, 1020, true, 1.0f), new a(R.drawable.f161723ep0, 75, LaunchParam.SCENE_ABOUT, true, 1.0f), new a(R.drawable.eow, PlayerResources.ViewId.EXTENDED_VIEW_NAME_PLUS_HEAD, 1235, true, 1.0f), new a(R.drawable.epw, 430, 355, true, 1.0f), new a(R.drawable.eov, 110, 174, true, 1.0f), new a(R.drawable.epp, 140, 250, true, 1.0f), new a(R.drawable.eps, 640, 195, true, 1.0f), new a(R.drawable.epp, 170, 450, true, 1.0f), new a(R.drawable.epr, P2VGlobalConfig.WATER_MARKER_WIDTH, TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_VIDEO_NOT_SUPPORT, true, 1.0f), new a(R.drawable.epq, ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST, true, 1.0f), new a(R.drawable.epq, 630, 410, true, 1.0f), new a(R.drawable.eps, 60, 500, true, 1.0f), new a(R.drawable.eps, 680, 655, true, 1.0f), new a(R.drawable.eps, 310, 1110, true, 1.0f), new a(R.drawable.epr, 470, TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION, true, 1.0f), new a(R.drawable.epr, 190, MiniReportManager.EventId.SDK_EMBEDDED_SUPPORT_RESULT, true, 1.0f), new a(R.drawable.epr, 680, 1060, true, 1.0f), new a(R.drawable.epp, 180, TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_NOT_SUPPORT, true, 1.0f), new a(R.drawable.epv, QidPagView.DESIGN_PAG_WIDTH, 134, false, 1.0f)};
            }
            if (i16 == 2) {
                return new a[]{new a(R.drawable.eox, 110, 220, true, 1.0f), new a(R.drawable.f161726ep3, 654, 240, true, 1.0f), new a(R.drawable.f161724ep1, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 482, true, 1.0f), new a(R.drawable.eoz, 95, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_END, true, 1.0f), new a(R.drawable.eow, 295, 672, true, 1.0f), new a(R.drawable.eoy, LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE, TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION, true, 1.0f), new a(R.drawable.f161723ep0, 60, 850, true, 1.0f), new a(R.drawable.f161725ep2, 442, 872, true, 1.0f), new a(R.drawable.eow, 114, 1046, true, 1.0f), new a(R.drawable.eox, 680, 950, true, 1.0f), new a(R.drawable.f161725ep2, 230, 1197, true, 1.0f), new a(R.drawable.f161727ep4, 480, 1260, true, 1.0f), new a(R.drawable.epw, TbsListener.ErrorCode.STATIC_TBS_INSTALL_TMP_RENAME_ERR, 1200, true, 1.0f), new a(R.drawable.epp, 140, 630, true, 1.0f), new a(R.drawable.epp, 500, 960, true, 1.0f), new a(R.drawable.epp, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 1050, true, 1.0f), new a(R.drawable.epp, 50, 1150, true, 1.0f), new a(R.drawable.epq, 290, 430, true, 1.0f), new a(R.drawable.epq, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 760, true, 1.0f), new a(R.drawable.epr, 60, 310, true, 1.0f), new a(R.drawable.epr, 480, 580, true, 1.0f), new a(R.drawable.epr, 220, 820, true, 1.0f), new a(R.drawable.eps, 600, 150, true, 1.0f), new a(R.drawable.eps, 700, 410, true, 1.0f), new a(R.drawable.eps, 25, 900, true, 1.0f), new a(R.drawable.eps, 150, 430, true, 1.0f), new a(R.drawable.epv, QidPagView.DESIGN_PAG_WIDTH, 134, false, 1.0f)};
            }
            if (i16 == 3) {
                return new a[]{new a(R.drawable.eox, 104, 278, true, 1.0f), new a(R.drawable.f161723ep0, 588, 200, true, 1.0f), new a(R.drawable.eow, 690, 390, true, 1.0f), new a(R.drawable.eoz, 420, 534, true, 1.0f), new a(R.drawable.eoy, 92, com.tencent.luggage.wxa.v6.d.CTRL_INDEX, true, 1.0f), new a(R.drawable.f161725ep2, TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION, 624, true, 1.0f), new a(R.drawable.eox, 475, com.tencent.luggage.wxa.ci.b.CTRL_INDEX, true, 1.0f), new a(R.drawable.f161726ep3, 192, 818, true, 1.0f), new a(R.drawable.f161727ep4, 696, x.CTRL_INDEX, true, 1.0f), new a(R.drawable.f161724ep1, 430, 990, true, 1.0f), new a(R.drawable.eow, 64, 1034, true, 1.0f), new a(R.drawable.eow, 272, UfsGROUPMASK.GROUP_MASK_PRECISE_RICH, true, 1.0f), new a(R.drawable.f161723ep0, 584, 1205, true, 1.0f), new a(R.drawable.eov, 254, 638, true, 1.0f), new a(R.drawable.epp, 200, 320, true, 1.0f), new a(R.drawable.epp, 260, MiniReportManager.EventId.SDK_EMBEDDED_SUPPORT_RESULT, true, 1.0f), new a(R.drawable.epp, 620, 1000, true, 1.0f), new a(R.drawable.epp, 150, UfsGROUPMASK.GROUP_MASK_PRECISE_RICH, true, 1.0f), new a(R.drawable.epq, 70, 420, true, 1.0f), new a(R.drawable.epq, LocaleManager.MOBILE_COUNTRY_CODE_CN_INT, c0.CTRL_INDEX, true, 1.0f), new a(R.drawable.epq, 630, 450, true, 1.0f), new a(R.drawable.epr, 70, 800, true, 1.0f), new a(R.drawable.epr, FilterEnum.MIC_PTU_TRANS_XINXIAN, 980, true, 1.0f), new a(R.drawable.epr, 610, 720, true, 1.0f), new a(R.drawable.epr, 480, TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_VIDEO_NOT_SUPPORT, true, 1.0f), new a(R.drawable.eps, 170, c0.CTRL_INDEX, true, 1.0f), new a(R.drawable.eps, MapItemKt.ITEM_AVATAR_MIN_WIDTH, gdt_analysis_event.EVENT_GET_MANUFACTURER, true, 1.0f), new a(R.drawable.eps, 700, 680, true, 1.0f), new a(R.drawable.eps, TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION, 290, true, 1.0f), new a(R.drawable.epv, QidPagView.DESIGN_PAG_WIDTH, 134, false, 1.0f)};
            }
        } else if (i3 == 2) {
            return new a[]{new a(R.drawable.eoy, 110, 310, true, 1.0f), new a(R.drawable.f161724ep1, 650, 216, true, 1.0f), new a(R.drawable.eow, 516, ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, true, 1.0f), new a(R.drawable.eoy, 92, com.tencent.luggage.wxa.v6.d.CTRL_INDEX, true, 1.0f), new a(R.drawable.f161725ep2, 656, 586, true, 1.0f), new a(R.drawable.eox, 470, 716, true, 1.0f), new a(R.drawable.f161726ep3, 198, 830, true, 1.0f), new a(R.drawable.f161727ep4, TbsListener.ErrorCode.STATIC_TBS_INSTALL_TMP_RENAME_ERR, 980, true, 1.0f), new a(R.drawable.f161724ep1, 397, 1060, true, 1.0f), new a(R.drawable.eoz, 70, 1016, true, 1.0f), new a(R.drawable.epp, 200, 320, true, 1.0f), new a(R.drawable.eov, 240, 438, true, 1.0f), new a(R.drawable.epw, 452, 475, true, 0.75f), new a(R.drawable.epp, 200, 600, true, 1.0f), new a(R.drawable.epp, 1000, 620, true, 1.0f), new a(R.drawable.epq, 70, 420, true, 1.0f)};
        }
        return new a[0];
    }

    public static String b(String str, float f16) {
        if (e.a(str) > f16) {
            int max = Math.max(0, (int) (f16 - 3.0f));
            int i3 = max;
            while (max < str.length()) {
                if (e.a(str.substring(0, max) + "\u2026") > f16) {
                    break;
                }
                i3 = max;
                max++;
            }
            return str.substring(0, i3) + "\u2026";
        }
        return str;
    }
}
