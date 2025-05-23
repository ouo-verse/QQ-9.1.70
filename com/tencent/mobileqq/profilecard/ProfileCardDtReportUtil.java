package com.tencent.mobileqq.profilecard;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes16.dex */
public class ProfileCardDtReportUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String DTREPORT_PAGE_PARAMS_HOST_GUEST_TYPE = "user_profile_host_guest_type";
    public static final String DTREPORT_PAGE_PARAMS_IS_QQ_FRI = "is_qq_fri";
    public static final String DTREPORT_PAGE_PARAMS_PROFILE_VERSION = "profile_version";
    public static final String DTREPORT_PAGE_PARAMS_TO_UIN = "to_uin";
    public static final String DT_EM_PROFILE_SMALLWORLD_CARD = "em_profile_smallworld_card";
    public static final String DT_PLAY_DURATION = "dt_play_duration";
    public static final String DT_REPORT_ACCOUNT = "em_profile_account";
    public static final String DT_REPORT_ADD_FRIEND = "em_profile_addfriend";
    public static final String DT_REPORT_AVATAR = "em_profile_avatar";
    public static final String DT_REPORT_BASEINFO = "em_profile_basic";
    public static final String DT_REPORT_BUBBLE_TIPS = "em_profile_bubbletips";
    public static final String DT_REPORT_CIRCLE = "em_profile_smallworld";
    public static final String DT_REPORT_CIRCLE_PLUS = "em_profile_smallworld_plus";
    public static final String DT_REPORT_COMPLETEFILE = "em_profile_completefile";
    public static final String DT_REPORT_COVER = "em_profile_cover";
    public static final String DT_REPORT_EDIT = "em_profile_edit";
    public static final String DT_REPORT_EID = "eid";
    public static final String DT_REPORT_EM_NEW_BACK = "em_profile_back";
    public static final String DT_REPORT_EM_NEW_MESSAGE = "em_profile_message_list";
    public static final String DT_REPORT_EM_NEW_SET = "em_profile_set";
    public static final String DT_REPORT_EM_XSJ_ENTRANCE_TEXT = "em_xsj_entrance_text";
    public static final String DT_REPORT_EM_XSJ_GUIDANCE_DOC = "em_xsj_guidance_doc";
    public static final String DT_REPORT_ENERGY = "em_profile_energy";
    public static final String DT_REPORT_EXTEND_FRIEND = "em_profile_kuolie";
    public static final String DT_REPORT_GAME = "em_profile_game";
    public static final String DT_REPORT_GIFT = "em_profile_gift";
    public static final String DT_REPORT_GIFT_GET = "em_profile_giftget";
    public static final String DT_REPORT_INTERACT_TAG = "em_profile_interact_tag";
    public static final String DT_REPORT_LEVEL = "em_profile_level";
    public static final String DT_REPORT_LIKE = "em_profile_like";
    public static final String DT_REPORT_MUSIC = "em_profile_music";
    public static final String DT_REPORT_MUSICBOX = "em_profile_musicbox";
    public static final String DT_REPORT_NAME = "em_profile_name";
    public static final String DT_REPORT_NAMEPLATE = "em_profile_nameplate";
    public static final String DT_REPORT_NUMBER = "em_profile_number";
    public static final String DT_REPORT_PARAM_COMPLETEFILE_VERSION = "completefile_version";
    public static final String DT_REPORT_PARAM_COVER_TYPE = "cover_type";
    public static final String DT_REPORT_PARAM_FEED_ID = "feed_id";
    public static final String DT_REPORT_PARAM_GUEST_EMPTY_IS_NEW = "profile_em_guest_empty_is_new";
    public static final String DT_REPORT_PARAM_IS_EMPTY = "profile_em_is_empty";
    public static final int DT_REPORT_PARAM_IS_NOT_EMPTY = 2;
    public static final int DT_REPORT_PARAM_ITEM_IS_EMPTY = 1;
    public static final String DT_REPORT_PARAM_TALK_TAG_ID = "talk_tag_id";
    public static final String DT_REPORT_PARAM_TEXT_CHAIN_TYPE = "text_chain_type";
    public static final String DT_REPORT_PARAM_TIANSHU_AD_ID = "tianshu_ad_id";
    public static final String DT_REPORT_PICTURE = "em_profile_picture";
    public static final String DT_REPORT_QZONE = "em_profile_zone";
    public static final String DT_REPORT_QZONE_PLUS = "em_profile_zone_plus";
    public static final String DT_REPORT_RGID = "pgid";
    public static final String DT_REPORT_SEED = "em_profile_send";
    public static final String DT_REPORT_SIGNATURE = "em_profile_signature";
    public static final String DT_REPORT_SPACE_ENTRANCE = "em_bas_space_entrance";
    public static final String DT_REPORT_STATUS_ICON = "em_bas_status_icon";
    public static final String DT_REPORT_STICKY_NOTE = "em_profile_casualpost";
    public static final String DT_REPORT_TAG = "em_profile_tag";
    public static final String DT_REPORT_VIDEO_CALL = "em_profile_videocall";
    public static final String DT_REPORT_VIP = "em_profile_vip";
    public static final String DT_REPORT_ZPLAN_NAMEPLATE_TYPE = "zplan_nameplate_type";
    public static final String DT_XSJ_COVER_SET_EID = "em_cover_set_xsj";
    public static final String IS_REDDOT = "is_reddot";
    public static final String NO = "2";
    public static final String STATUS_ID = "status_id";
    public static final String YES = "1";

    public ProfileCardDtReportUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void dtReportClick(View view) {
        VideoReport.reportEvent("clck", view, null);
    }

    public static void dtReportExpose(View view) {
        VideoReport.reportEvent("imp", view, null);
    }

    public static void initElementNoExposure(View view, String str) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
    }

    public static void initElementWithExposure(View view, String str) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    public static void initElementWithExposureClick(View view, String str) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    public static void initElementWithExposureClickAndParams(View view, String str, Map<String, String> map) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, map);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    public static void initElementWithExposureParams(View view, String str, Map<String, String> map) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, map);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    public static void reportCommonEvent(AppInterface appInterface, String str, String str2) {
        int i3;
        int i16;
        if (appInterface != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            int i17 = 2;
            if (ProfileUtils.isFriend(appInterface, str)) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put("is_qq_fri", Integer.valueOf(i3));
            boolean z16 = !str.equals(appInterface.getCurrentAccountUin());
            if (z16) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            hashMap.put("user_profile_host_guest_type", Integer.valueOf(i16));
            if (!((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isElegantVersion()) {
                i17 = 1;
            }
            hashMap.put("profile_version", Integer.valueOf(i17));
            if (z16) {
                hashMap.put("to_uin", str);
            }
            VideoReport.reportEvent(str2, hashMap);
        }
    }

    public static void initElementWithExposure(View view, String str, Map<String, Object> map) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, map);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    public static void initElementWithExposureClickAndParams(View view, String str, Map<String, String> map, IDynamicParams iDynamicParams) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, map);
        if (iDynamicParams != null) {
            VideoReport.setEventDynamicParams(view, iDynamicParams);
        }
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }
}
