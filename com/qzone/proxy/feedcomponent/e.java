package com.qzone.proxy.feedcomponent;

import android.app.Application;
import android.content.Context;
import com.qzone.adapter.feedcomponent.q;
import com.qzone.app.ResourcePreloader;
import com.qzone.canvasui.content.res.DittoConfig;
import com.qzone.canvasui.content.res.FeedCanvasResourcesImpl;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.utils.Log;
import com.tencent.mobileqq.R;
import cooperation.qzone.QUA;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.util.QZLog;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f50151a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements j {
        a() {
        }

        @Override // com.qzone.proxy.feedcomponent.j
        public void e(String str, String str2, Throwable th5) {
            QZLog.e(str, str2, th5);
        }

        @Override // com.qzone.proxy.feedcomponent.j
        public boolean isColorLevel() {
            return QZLog.isColorLevel();
        }

        @Override // com.qzone.proxy.feedcomponent.j
        public void w(String str, String str2, Throwable th5) {
            QZLog.w(str, str2, th5);
        }

        @Override // com.qzone.proxy.feedcomponent.j
        public void d(String str, String str2, Throwable th5) {
            QZLog.d(str, 2, str2, th5);
        }

        @Override // com.qzone.proxy.feedcomponent.j
        public void i(String str, String str2, Throwable th5) {
            QZLog.i(str, 2, str2, th5);
        }
    }

    private static void a() {
        DittoUIEngine.g().addResourceIdCache("@layout/qzone_widget_feed_bottom_guide", R.layout.f169051ce2);
        DittoUIEngine.g().addResourceIdCache("@layout/qzone_widget_feed_app_share_card", R.layout.f169050ce1);
    }

    static void b() {
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_ad_cover_up", R.drawable.f162163fu1);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_adv_single_pic_background_down", R.drawable.f162166fu4);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_adv_single_pic_background_up", R.drawable.fu5);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_album_friends_selected_bg", R.drawable.fuw);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_album_headerview_parent_cover_birthday_bg", R.drawable.fuy);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_album_localphoto_exp_viewbg", R.drawable.fve);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_album_text_bg", R.drawable.fwo);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_album_travel_map_window", R.drawable.fwr);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_album_travel_text_bg", R.drawable.fwu);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_avatar_back", R.drawable.fxg);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_banner_background", R.drawable.fxm);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_btn_addapp", R.drawable.fy7);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_btn_addapp_click", R.drawable.fy8);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_btn_forbidden", R.drawable.fye);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_btn_forbidden_click", R.drawable.fyf);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_change_voice_check", R.drawable.fyu);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_comment_bg", R.drawable.fyz);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_comment_send_button_disabled", R.drawable.qzone_skin_comment_send_button_disabled);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_comment_send_button_normal", R.drawable.f162210fz1);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_comment_send_button_pressed", R.drawable.f162211fz2);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_common_shadow_bg", R.drawable.fz6);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_feed_container_border", R.drawable.qzone_skin_feed_container_border);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_banner_bg", R.drawable.g18);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_feed_card_bg_shadow_8", R.drawable.qzone_skin_feed_card_bg_shadow_8);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_card_shadow_12", R.drawable.g1c);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_dpa_btn_play", R.drawable.g1i);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_guidance_popup_bg", R.drawable.g1u);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_guidance_popup_bg_white", R.drawable.g1v);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_icon_wrapper", R.drawable.g2b);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_icon_wrapper_click", R.drawable.g2c);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_music_schedule", R.drawable.g2n);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_purchase_btn_blue", R.drawable.g2y);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_purchase_btn_green", R.drawable.g2z);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_purchase_btn_yellow", R.drawable.f162227g30);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feed_theme_album_hazylayer", R.drawable.g3e);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feedparticipate_remind_bg", R.drawable.g3n);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_feeds_video_time_bg", R.drawable.g3u);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_follow_btn_followed", R.drawable.g3z);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_follow_btn_normal", R.drawable.f162237g40);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_frd_like_video_feed_video_bg", R.drawable.g46);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_friendvideo_redhot", R.drawable.g4b);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_home_page_popupwidows_bg", R.drawable.g4x);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_homepage_timeline_item_selected_bg", R.drawable.qzone_skin_homepage_timeline_item_selected_bg);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_homepage_timeline_shadow", R.drawable.g5e);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_icon_limit_bg", R.drawable.g6z);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_icon_seal_default", R.drawable.g7f);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_icon_star_vip_process_value", R.drawable.g7p);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_local_picture_viewer_marker_result", R.drawable.g8l);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_local_picture_viewer_marker_result_del", R.drawable.g8m);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_localalbum_bg_selectphoto_selectedamount", R.drawable.g8n);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_mood_recent_photo_bg", R.drawable.g9k);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_msg_shadow_bg", R.drawable.g_k);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_notice_bg", R.drawable.f162288ga0);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_passive_feed_bubble_stretch", R.drawable.gan);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_passive_feed_lv9_bubble_stretch", R.drawable.gap);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_photo_bubble_bg", R.drawable.f162292gb2);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_pic_viewer_more_webpic_bg", R.drawable.gbi);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_player_bottom_shadow", R.drawable.f162303gc2);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_player_controller_bg", R.drawable.gcb);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_player_text_background", R.drawable.gck);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_publish_video_time_bg", R.drawable.gdb);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_selector_feed_music_bar", R.drawable.qzone_selector_feed_music_bar);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_feed_shadow_bg", R.drawable.qzone_skin_feed_shadow_bg);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_share_to_friend", R.drawable.f162340ge1);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_shuoshuo_video_vip_tips_bg_1", R.drawable.ge7);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_common_btn_red_pressed", R.drawable.gec);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_common_btn_red_unpressed", R.drawable.ged);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_dropdown_btm_bg", R.drawable.qzone_skin_dropdown_btm_bg);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_dropdown_item_btm_click", R.drawable.qzone_skin_dropdown_item_btm_click);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_dropdown_item_def_click", R.drawable.qzone_skin_dropdown_item_def_click);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_dropdown_item_top_click", R.drawable.qzone_skin_dropdown_item_top_click);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_dropdown_top_bg", R.drawable.qzone_skin_dropdown_top_bg);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_feed_bg", R.drawable.gek);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_feed_btn_leftbottom", R.drawable.gel);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_feed_btn_leftbottom_click", R.drawable.gem);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_feed_btn_middle", R.drawable.gen);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_feed_btn_middle_click", R.drawable.geo);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_feed_btn_rightbottom", R.drawable.gep);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_skin_feed_btn_rightbottom_click", R.drawable.geq);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_smart_beautify_short_bubble", R.drawable.gff);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_status_bar_shadow", R.drawable.gfk);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_take_video_tip_bubble", R.drawable.gfz);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_transparent_shadow_8", R.drawable.f162360gh3);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_union_bg_progress_value", R.drawable.gh7);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_union_vip_progress_bg", R.drawable.gh9);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_union_vip_widget_progress_value", R.drawable.gh_);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_uploadphoto_item_marker", R.drawable.ghb);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_url_share_style_bg", R.drawable.ghc);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_video2_bg_comments", R.drawable.ghg);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_video2_bg_comments_mutant", R.drawable.ghh);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_video_free_traffic_play_icon_bg", R.drawable.ghx);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_video_network_popup_window_bg", R.drawable.gi_);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_video_play_b", R.drawable.gia);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_video_recommend_next_video_btn_enter", R.drawable.gif);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_video_rounded_cover", R.drawable.gii);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_video_window_play_shadow", R.drawable.giw);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_videofloat_forward_normal_bg", R.drawable.gix);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_videofloat_forward_selected_bg", R.drawable.giy);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_weishi_btn_normal", R.drawable.gj8);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_widget_font_tag_specify", R.drawable.gjh);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_widget_font_tag_svip", R.drawable.gji);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_widget_font_tag_vip", R.drawable.gjj);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_widget_friend", R.drawable.gjk);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_widget_friend_pressed", R.drawable.gjl);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_widget_vip_progress_bg", R.drawable.gjp);
        DittoUIEngine.g().addResourceIdCache("@drawable/qzone_widget_vip_progress_value", R.drawable.gjr);
    }

    public static synchronized void c(Context context, Application application) {
        synchronized (e.class) {
            if (f50151a) {
                return;
            }
            f50151a = true;
            jo.h hVar = jo.h.f410717a;
            hVar.h("qzone_init").x("FEED_ENV_INIT");
            FeedGlobalEnv.init(context, application, new g(), new a());
            com.qzone.adapter.feedcomponent.i.P0(new FeedEnvImpl());
            hVar.h("qzone_init").m("FEED_ENV_INIT");
            hVar.h("qzone_init").x("FEED_RESOURCE_INIT");
            com.qzone.adapter.feedcomponent.j.P(new f());
            hVar.h("qzone_init").m("FEED_RESOURCE_INIT");
            hVar.h("qzone_init").x("FEED_DITTO_INIT");
            if (QZoneApiProxy.isInQZoneEnvironment()) {
                context = ResourcePreloader.b().c();
            }
            DittoUIEngine.g().init(context, new b());
            DittoUIEngine.g().initExtra(new FeedCanvasResourcesImpl(), new c(), QUA.getQUA3(), "qzone/feeds", R.class, DittoConfig.jsonContentMap, DittoConfig.jsonMd5Map);
            com.qzone.proxy.feedcomponent.a.a();
            a();
            b();
            hVar.h("qzone_init").m("FEED_DITTO_INIT");
            q.n(new k());
            r8.a aVar = new r8.a();
            s8.k.d(aVar, aVar.f430940e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c implements DittoUIEngine.IReporter {
        c() {
        }

        @Override // com.tencent.ditto.shell.DittoUIEngine.IReporter
        public void compassReport(int[] iArr) {
            LpReportInfo_pf00064 lpReportInfo_pf00064;
            if (iArr != null && iArr.length != 1) {
                int length = iArr.length;
                if (length == 1) {
                    lpReportInfo_pf00064 = new LpReportInfo_pf00064(iArr[0], 0, 0);
                } else if (length != 2) {
                    lpReportInfo_pf00064 = new LpReportInfo_pf00064(iArr[0], iArr[1], iArr[2]);
                } else {
                    lpReportInfo_pf00064 = new LpReportInfo_pf00064(iArr[0], iArr[1], 0);
                }
                if (QZLog.isColorLevel()) {
                    QZLog.i("CANVASUI", "compassReport report params data = " + Arrays.toString(iArr));
                }
                lpReportInfo_pf00064.reportImediately();
                return;
            }
            QZLog.e("CANVASUI", "report params should not be an empty array");
        }

        @Override // com.tencent.ditto.shell.DittoUIEngine.IReporter
        public void haboReport(String str, int i3, String str2, int i16) {
            AccManager.createStatistic(str, i3, str2, i16);
            if (QZLog.isColorLevel()) {
                QZLog.i("CANVASUI", "haboReport report params cmd = " + str + " resultCode = " + i3 + " detail = " + str2 + " frequency = " + i16);
            }
        }

        @Override // com.tencent.ditto.shell.DittoUIEngine.IReporter
        public void reportTTTClick(String str) {
        }

        @Override // com.tencent.ditto.shell.DittoUIEngine.IReporter
        public void reportTTTLongClick(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b implements Log {
        b() {
        }

        @Override // com.tencent.ditto.utils.Log
        public boolean isColoredLevel() {
            return false;
        }

        @Override // com.tencent.ditto.utils.Log
        public void d(String str, String str2, Throwable th5) {
        }

        @Override // com.tencent.ditto.utils.Log
        public void e(String str, String str2, Throwable th5) {
        }

        @Override // com.tencent.ditto.utils.Log
        public void i(String str, String str2, Throwable th5) {
        }

        @Override // com.tencent.ditto.utils.Log
        public void v(String str, String str2, Throwable th5) {
        }

        @Override // com.tencent.ditto.utils.Log
        public void w(String str, String str2, Throwable th5) {
        }
    }
}
