package com.qzone.reborn.configx;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wn.QZonePhotoOprConfig;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\bD\u0018\u0000 \u009c\u00012\u00020\u0001:\u0002\u009d\u0001B\t\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010\"\u001a\u00020\u0011J\u0006\u0010#\u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0011J\u0006\u0010'\u001a\u00020&J\u0006\u0010(\u001a\u00020&J\u0006\u0010)\u001a\u00020&J\u0006\u0010*\u001a\u00020&J\u0006\u0010+\u001a\u00020&J\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0005J\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0002J\u0006\u00103\u001a\u00020\u0002J\u0006\u00104\u001a\u00020\u0011J\u0006\u00105\u001a\u00020\u0005J\u0006\u00106\u001a\u00020\u0002J\u0006\u00107\u001a\u00020\u0013J\u0006\u00108\u001a\u00020\u0011J\u0006\u00109\u001a\u00020\u0005J\u0006\u0010:\u001a\u00020\u0005J\u0006\u0010;\u001a\u00020\u0011J\u0006\u0010<\u001a\u00020\u0005J\u0006\u0010=\u001a\u00020\u0005J\u0006\u0010>\u001a\u00020\u0005J\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020\u0005J\u0006\u0010A\u001a\u00020\u0005J\u0006\u0010B\u001a\u00020\u0005J\u0006\u0010C\u001a\u00020\u0005J\u0006\u0010D\u001a\u00020\u0005J\u0006\u0010E\u001a\u00020\u0005J\u0006\u0010F\u001a\u00020\u0002J\u0006\u0010G\u001a\u00020\u0002J\u0006\u0010H\u001a\u00020\u0002J\u0006\u0010I\u001a\u00020\u0005J\u0006\u0010J\u001a\u00020\u0005J\u0006\u0010K\u001a\u00020\u0005J\u0006\u0010L\u001a\u00020\u0005J\u0006\u0010M\u001a\u00020\u0005J\u0006\u0010N\u001a\u00020\u0005J\u0006\u0010O\u001a\u00020\u0005J\u0006\u0010P\u001a\u00020\u0002J\u0006\u0010Q\u001a\u00020\u0005J\u0006\u0010R\u001a\u00020\u0005J\u0006\u0010S\u001a\u00020\u0005J\u0006\u0010T\u001a\u00020\u0005J\u0006\u0010U\u001a\u00020\u0005J\u0006\u0010V\u001a\u00020\u0005J\u0006\u0010W\u001a\u00020\u0005J\u0006\u0010X\u001a\u00020\u0002J\u0006\u0010Y\u001a\u00020\u0002J\u0006\u0010[\u001a\u00020ZJ\u0006\u0010\\\u001a\u00020\u0005J\u0006\u0010]\u001a\u00020\u0005J\u0006\u0010^\u001a\u00020\u0005J\u0006\u0010_\u001a\u00020\u0005J\u0006\u0010`\u001a\u00020\u0005J\u0006\u0010a\u001a\u00020\u0005J\u0006\u0010b\u001a\u00020\u0011J\u0006\u0010c\u001a\u00020\u0011J\u0006\u0010d\u001a\u00020\u0011J\u0006\u0010e\u001a\u00020\u0005J\u0006\u0010f\u001a\u00020\u0005J\u0006\u0010g\u001a\u00020\u0005J\u0006\u0010h\u001a\u00020\u0005J\u0006\u0010i\u001a\u00020&J\u0006\u0010j\u001a\u00020&J\u0006\u0010k\u001a\u00020\u0002J\u0006\u0010l\u001a\u00020\u0013J\u0006\u0010m\u001a\u00020\u0005J\u0006\u0010n\u001a\u00020\u0005J\u0006\u0010o\u001a\u00020\u0002J\u0006\u0010p\u001a\u00020\u0005J\u0006\u0010q\u001a\u00020\u0005J\u0006\u0010r\u001a\u00020\u0002J\u0006\u0010s\u001a\u00020\u0002J\u0006\u0010t\u001a\u00020\u0002J\u0006\u0010u\u001a\u00020&J\u0006\u0010v\u001a\u00020\u0002J\u0006\u0010w\u001a\u00020\u0002J\u0006\u0010x\u001a\u00020\u0005J\u0006\u0010y\u001a\u00020\u0005J\u0006\u0010z\u001a\u00020\u0005J\u0006\u0010{\u001a\u00020\u0005J\u0006\u0010|\u001a\u00020\u0005J\u0006\u0010}\u001a\u00020\u0005J\u0006\u0010~\u001a\u00020\u0005J\u0006\u0010\u007f\u001a\u00020\u0005J\u0007\u0010\u0080\u0001\u001a\u00020\u0005J\u0007\u0010\u0081\u0001\u001a\u00020\u0005J\u0007\u0010\u0082\u0001\u001a\u00020\u0005J\u0007\u0010\u0083\u0001\u001a\u00020\u0005J\u0007\u0010\u0084\u0001\u001a\u00020\u0005J\u0007\u0010\u0085\u0001\u001a\u00020\u0005J\u0007\u0010\u0086\u0001\u001a\u00020\u0005J\u0007\u0010\u0087\u0001\u001a\u00020\u0005J\u0007\u0010\u0088\u0001\u001a\u00020\u0005J\u0007\u0010\u0089\u0001\u001a\u00020\u0005J\u0007\u0010\u008a\u0001\u001a\u00020\u0005J\u0007\u0010\u008b\u0001\u001a\u00020\u0005J\u0007\u0010\u008c\u0001\u001a\u00020\u0005J\u0007\u0010\u008d\u0001\u001a\u00020\u0002J\u0007\u0010\u008e\u0001\u001a\u00020\u0005J\u0007\u0010\u008f\u0001\u001a\u00020\u0005J\u0007\u0010\u0090\u0001\u001a\u00020\u0005J\u0007\u0010\u0091\u0001\u001a\u00020\u0005J\u0007\u0010\u0092\u0001\u001a\u00020\u0005J\u0007\u0010\u0093\u0001\u001a\u00020\u0005J\u0007\u0010\u0094\u0001\u001a\u00020\u0002J\u0007\u0010\u0095\u0001\u001a\u00020\u0002J\u0007\u0010\u0096\u0001\u001a\u00020\u0005J\u0007\u0010\u0097\u0001\u001a\u00020\u0011J\u0007\u0010\u0098\u0001\u001a\u00020\u0011J\u0007\u0010\u0099\u0001\u001a\u00020\u0005\u00a8\u0006\u009e\u0001"}, d2 = {"Lcom/qzone/reborn/configx/e;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, "", Constants.BASE_IN_PLUGIN_ID, "U1", "C0", "q1", "A1", "E1", "B1", "J1", "F1", "L1", "u", "", "T0", "", "r1", ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "C1", "J0", "r", "e1", "z1", "y0", "c0", "L", "M0", "Q0", "N0", "M", "L0", "", "H0", "I0", "D0", "G0", "F0", Constants.APK_CERTIFICATE, "H1", "K", "T1", "a0", "j", "A0", "B0", "E0", "b0", "o1", "Y0", "Z0", "m0", "t0", "S0", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "w1", "K1", "y1", "x1", "f0", "o0", "v", "u0", "W0", "X0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "U", "v0", "w0", "R1", "E", "r0", "W1", "v1", "N", "V1", "P1", "N1", "O1", "Q1", "I1", "h1", "g1", "Lwn/a;", "f1", "S1", "M1", "w", "e0", "H", "s0", "u1", "t1", ICustomDataEditor.STRING_PARAM_1, "Z", "B", "p1", "k0", "c1", "b1", "R0", "K0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "X", "i1", "h0", "g0", "j1", "m1", "U0", "V0", ICustomDataEditor.NUMBER_PARAM_1, "l1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "p0", "q0", "y", "l0", "d0", "n0", ExifInterface.LATITUDE_SOUTH, "T", "J", "G", "O", "I", "P", "p", DomainData.DOMAIN_NAME, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "o", "k1", "V", BdhLogUtil.LogTag.Tag_Req, "W", "l", "i0", "j0", "d1", "z0", "Y", "P0", "O0", "x0", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends d {
    public final boolean A() {
        return f("enable_clear_when_low_memory", true);
    }

    public final boolean A1() {
        return f("is_disable_recommend_check_peak_in_foreground", false);
    }

    public final boolean B() {
        return f("qzone_enable_msg_list_push_detail_carry_feed", true);
    }

    public final boolean B1() {
        return f("keyboard_disable_use_thread_switch_way", false);
    }

    public final boolean C() {
        return f("enable_facade_show_async", true);
    }

    public final String C0() {
        return e("RECOMMEND_PHOTO_CLASSFY_TITLE", "");
    }

    public final boolean C1() {
        return f("is_disable_video_preload_in_qzone_process", true);
    }

    public final boolean D() {
        return f("enable_feed_detail_cache", true);
    }

    public final float D0() {
        return a("qzone_feed_dragon_badge_default_width", 0.0f);
    }

    public final boolean D1() {
        return f("enter_intimate_native_activate_page", true);
    }

    public final boolean E() {
        return f("enable_feed_pro_convert_old_feed_attr_info", false);
    }

    public final int E0() {
        return b("qzone_client_report_sample_rate", 10);
    }

    public final boolean E1() {
        return f("action_panel_is_hide_keyboard_on_pause", false);
    }

    public final boolean F() {
        return f("enable_feed_visitor_report", true);
    }

    public final float F0() {
        return a("qzone_feed_compose_dragon_badge_stack_width", 0.0f);
    }

    public final boolean F1() {
        return f("is_new_long_pic_mode_open", false);
    }

    public final boolean G() {
        return f("enable_fix_music_bar_anr", true);
    }

    public final float G0() {
        return a("qzone_feed_compose_dragon_badge_left_padding", 33.0f);
    }

    public final boolean G1() {
        return f("request_dragon_when_refresh", true);
    }

    public final boolean H() {
        return f("qzone_enable_fix_scroll_bug_when_floating_window_mode", true);
    }

    public final float H0() {
        return a("qzone_feed_dragon_max_level_new_rate", 0.68f);
    }

    public final boolean H1() {
        return f("show_dragon_anim_when_refresh", true);
    }

    public final boolean I() {
        return f("enable_fix_sharing_owner_data_cache", true);
    }

    public final float I0() {
        return a("qzone_feed_dragon_min_level_new_rate", 0.145f);
    }

    public final boolean I1() {
        return f("qzone_enable_plus_menu_tian_shu_item", true);
    }

    public final boolean J() {
        return f("enable_get_a2_async", false);
    }

    public final int J0() {
        return b("key_feed_external_comment_count", 20);
    }

    public final boolean J1() {
        return f("update_size_when_configuration_changed", true);
    }

    public final boolean K() {
        return f("enable_holiday_first_comment_fail_reload", true);
    }

    public final long K0() {
        return c("qzone_show_bottom_recommend_function_time", 86400L) * 1000;
    }

    public final boolean K1() {
        return !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() || f("is_use_compat_factory2", true);
    }

    public final boolean L() {
        return f("qzone_holiday_dragon_alert_web_after_publish_enable", true);
    }

    public final int L0() {
        return b("qzone_feed_dragon_max_level", 20);
    }

    public final boolean L1() {
        return f("use_qq_open_and_close_animation", false);
    }

    public final boolean M() {
        return f("enable_jsp_download_video_new_api", true);
    }

    public final int M0() {
        return b("qzone_feed_head_nick_name_gap", 170);
    }

    public final boolean M1() {
        return f("configx_close_feedx_activity_new_intent_jump", true);
    }

    public final boolean N() {
        return f("jump_new_pic_info_panel", true);
    }

    public final int N0() {
        return b("qzone_feed_head_nick_name_gap_with_dragon", 100);
    }

    public final boolean N1() {
        return f("open_watermark_album_batch_download", true);
    }

    public final boolean O() {
        return f("enable_sub_thread_assemble_origin_pic", true);
    }

    public final int O0() {
        return b("qzone_detail_comment_load_more_reply_page_count", 10);
    }

    public final boolean O1() {
        return f("open_watermark_feed_share", true);
    }

    public final boolean P() {
        return f("enable_layer_open_scan_qrcode_action", true);
    }

    public final int P0() {
        return b("qzone_detail_comment_default_show_reply_count", 10);
    }

    public final boolean P1() {
        return f("open_watermark_layer_download_share", true);
    }

    public final boolean Q() {
        return !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() || f("qzone_enable_layer_use_region_scale_9090", true);
    }

    public final int Q0() {
        return b("qzone_feed_pro_head_nick_name_gap", 90);
    }

    public final boolean Q1() {
        return f("open_watermark_publish_sync_wx_moment", true);
    }

    public final boolean R() {
        return f("qzone_mood_time_ntcompose_enable", false);
    }

    public final boolean R1() {
        return f("preload_video_trim_support", true);
    }

    public final boolean S() {
        return f("enable_new_album_select_photo_layer", false);
    }

    public final int S0() {
        return b("feedx_request_time_out_threshold", 20000);
    }

    public final boolean S1() {
        return f("publish_sync_wx_moment_use_logo_pic", true);
    }

    public final boolean T() {
        return f("enable_new_album_select_preview_photo_layer", false);
    }

    public final int T0() {
        return b("enable_media_location_permission_check", 1000);
    }

    public final boolean T1() {
        return f("refresh_dragon_width_when_background_show", true);
    }

    public final boolean U() {
        return f("qzone_new_event_tag_blur_enable", false);
    }

    public final boolean U1() {
        return f("remove_qzone_feed_detail_ad_banner", false);
    }

    public final boolean V() {
        return f("enable_new_layer_share_pic", true);
    }

    public final float V0() {
        return a("qzone_publish_image_ai_min_userate", 0.5f);
    }

    public final boolean V1() {
        return f("remove_sp_param_async", true);
    }

    public final boolean W() {
        return f("enable_new_publish_pic_loader", false);
    }

    public final String W0() {
        return e("intimate_private_space_day_bg", "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/lock/day-lock.png");
    }

    public final boolean W1() {
        return f("reset_web_view_config_when_destroy", true);
    }

    public final boolean X() {
        return f("enable_new_single_video_item_click", true);
    }

    public final String X0() {
        return e("intimate_private_space_night_bg", "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/lock/night-lock.png");
    }

    public final boolean Y() {
        return f("enable_old_style_passive_message_page", false);
    }

    public final long Y0() {
        return c("intimate_show_entrance_avatar_interval", JoinTimeType.THIRTY_MINUTES);
    }

    public final boolean Z() {
        return f("qzone_enable_original_photo_degrade", true);
    }

    public final int Z0() {
        return b("intimate_entrance_avatar_show_max_times", 20);
    }

    public final boolean a0() {
        return f("aio_page_partner_space_entrance", true);
    }

    public final String a1() {
        return e("intimate_space_main_page_qrcode_url", "https://h5.qzone.qq.com/intimate-space/h5/jump-schema?_wv=3&pagetype=space-main");
    }

    public final boolean b0() {
        return f("qzone_enable_perf_report", true);
    }

    public final float b1() {
        return a("qzone_length_width_ratio_for_long_pic", 2.0f);
    }

    public final boolean c0() {
        return f("enable_option_group_key", true);
    }

    public final float c1() {
        return a("qzone_magnification_standard_for_long_pic", 2.0f);
    }

    public final boolean d0() {
        return f("enable_picker_edit_export_optimize", true);
    }

    public final String d1() {
        return e("moment_main_page_tips", "");
    }

    public final boolean e0() {
        return f("qzone_enable_preload_favorite_data", true);
    }

    public final long e1() {
        return c("qzone_new_comment_keyboard_delay_time", 200L);
    }

    public final boolean f0() {
        return f("qzone_enable_preload_item_layout_when_scroll", true);
    }

    public final QZonePhotoOprConfig f1() {
        return (QZonePhotoOprConfig) d("qzone_photo_opr_config", new QZonePhotoOprConfig(false, null, null, false, 15, null));
    }

    public final boolean g0() {
        return f("qzone_publish_image_ai_tail_switch", true);
    }

    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_CANG_LAN";
    }

    public final boolean h0() {
        return f("qzone_publish_image_ai_text_switch", true);
    }

    public final String h1() {
        return e("qzone_photo_repair_share_brand_image", "https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/shuiying@2x.png");
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return "";
    }

    public final boolean i0() {
        return f("publish_x_clear_listener", true);
    }

    public final boolean j() {
        return f("clear_data_async_when_logout", true);
    }

    public final boolean j0() {
        return f("enable_qq_thread_in_zip_cache_helper", true);
    }

    public final boolean k() {
        return f("clear_data_center_when_refresh", true);
    }

    public final boolean k0() {
        return f("qzone_enable_qui_profile_for_album", true);
    }

    public final String k1() {
        return e("publish_box_weak_network_hint", "\u5f53\u524d\u7f51\u7edc\u8fde\u63a5\u8f83\u5f31\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85~");
    }

    public final boolean l() {
        return f("clear_view_model_when_fragment_destroy", true);
    }

    public final boolean l0() {
        return f("qzone_send_pic_comment_by_nt_upload_channel", false);
    }

    public final boolean m() {
        return f("qzone_disable_bssid", true);
    }

    public final boolean m0() {
        return f("enable_qzone_share_activity_restore_instance", false);
    }

    public final boolean n() {
        return f("disable_feeds_incremental_update", false);
    }

    public final boolean n0() {
        return f("enable_recreate_friend_feed_when_theme_change", true);
    }

    public final String n1() {
        return e("qzone_publish_image_ai_text_logo", "https://qzonestyle.gtimg.cn/qzone/client/mqq/publisher/ai_img2text.png");
    }

    public final boolean o() {
        return f("disable_pre_locate_in_publish_page", true);
    }

    public final boolean o0() {
        return f("reload_nickname_after_cache_clean", false);
    }

    public final String o1() {
        return e("qzone_moment_face_mask_resource_url", IAEDownloadMaterial.QZONE_CIKE_CAMERA_DEFAULT_MATERIAL_URL);
    }

    public final boolean p() {
        return f("disable_silent_locate_for_qzone_request", true);
    }

    public final boolean p0() {
        return f("enable_show_intimate_resign_in", true);
    }

    public final boolean p1() {
        int b16 = b("qzone_enable_share_xhs", 1);
        QLog.i("QZoneCangLanCommonConfig", 1, "[getQzoneEnableShareXHS] qzoneEnableShareXHS=" + b16);
        return b16 == 1;
    }

    public final boolean q() {
        return f("disable_silent_locate_for_in_qzone", true);
    }

    public final boolean q0() {
        return f("enable_show_intimate_share_entrance", false);
    }

    public final String q1() {
        return e("qzone_recommend_album_config", "");
    }

    public final boolean r() {
        return f("qzone_disable_spring_comment_success_anim", false);
    }

    public final boolean r0() {
        gd.a aVar = gd.a.f401926a;
        if (aVar.b() && aVar.c("KEY_ASYNC_INIT_WEB_VIEW", true)) {
            return false;
        }
        return f("sync_init_web_view", true);
    }

    public final long r1() {
        return c("show_loading_state_delay_time", 1500L);
    }

    public final boolean s() {
        return f("enable_aio_feedx_login_report_part", true);
    }

    public final boolean s0() {
        return f("qzone_enable_ttt_realtime_report_feed_expose", true);
    }

    public final int s1() {
        return b("qzone_ttt_realtime_report_interval", 10);
    }

    public final boolean t() {
        return f("qzone_aio_reship_photo_v2", true);
    }

    public final boolean t0() {
        return f("support_texture_view_recycled", true);
    }

    public final int t1() {
        return b("qzone_ttt_realtime_report_limit_size", 10);
    }

    public final boolean u() {
        return f("enable_media_location_permission_check", true);
    }

    public final boolean u0() {
        return f("QZONE_GALLERY_USE_ARGB_8888", true);
    }

    public final int u1() {
        return b("qzone_ttt_realtime_report_max_cache_size", 3);
    }

    public final boolean v() {
        return f("enable_auto_magnify_external_small_pic", false);
    }

    public final boolean v0() {
        return f("qzone_enable_use_comment_panel_new", false);
    }

    public final String v1() {
        return e("qzone_upload_quality_normal_text", "\u666e\u901a");
    }

    public final boolean w() {
        return f("qzone_enable_business_feed_data_new_parser", true);
    }

    public final boolean w0() {
        return f("qzone_enable_use_web_comment_panel_new", true);
    }

    public final boolean w1() {
        return f("is_clone_inflater_in_sub_thread", true);
    }

    public final boolean x() {
        return f("enable_cancel_album_cover_request", true);
    }

    public final boolean x0() {
        return f("fix_custom_praise_preload_res_crash", true);
    }

    public final boolean x1() {
        return !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() || f("is_delegate_resource", false);
    }

    public final boolean y() {
        return f("enable_check_replace_export_path", true);
    }

    public final int y0() {
        return b("qzone_friend_feed_cache_clear_threshold", 100);
    }

    public final boolean y1() {
        return !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() || f("is_delegate_layoutinflater", false);
    }

    public final boolean z() {
        return f("enable_clear_feed_cache_when_timeout", true);
    }

    public final String z0() {
        return e("qzone_ai_comment", "");
    }

    public final boolean z1() {
        return f("is_disable_nick_name_cast", false);
    }

    public final String A0() {
        String a16 = com.qzone.util.l.a(R.string.f2191265k);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026ter_active_entrance_text)");
        return e("qzone_album_head_active_entrance_text", a16);
    }

    public final String B0() {
        String a16 = com.qzone.util.l.a(R.string.f2191165j);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026ve_entrance_default_text)");
        return e("qzone_album_head_active_entrance_default_text", a16);
    }

    public final String R0() {
        String a16 = com.qzone.util.l.a(R.string.sig);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_fee\u2026e_xhs_title_default_text)");
        return e("qzone_share_xhs_title", a16);
    }

    public final String U0() {
        String a16 = com.qzone.util.l.a(R.string.f2198367h);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026ic_to_dialog_bottom_text)");
        return e("qzone_publish_image_ai_text_dialog_bottom_text", a16);
    }

    public final String g1() {
        String a16 = com.qzone.util.l.a(R.string.wah);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_pho\u2026ayer_share_preview_title)");
        return e("qzone_photo_repair_share_bottom_text", a16);
    }

    public final String i1() {
        String a16 = com.qzone.util.l.a(R.string.f2198467i);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026h_pic_to_guide_left_text)");
        return e("qzone_publish_image_ai_text_guide_left_text", a16);
    }

    public final String j1() {
        return e("qzone_publish_image_ai_tail_text", "\n#" + com.qzone.util.l.a(R.string.f2198767l));
    }

    public final String l1() {
        String a16 = com.qzone.util.l.a(R.string.f2197867c);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026ge_ai_empty_content_text)");
        return e("qzone_publish_image_ai_empty_text", a16);
    }

    public final String m1() {
        String a16 = com.qzone.util.l.a(R.string.f2198767l);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026zone_publish_pic_to_text)");
        return e("qzone_publish_image_ai_text", a16);
    }
}
