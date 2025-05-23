package com.tencent.aelight.camera.ae.report;

import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.open.BeaconInitException;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f65705a = 10;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static b f65706a = new b();
    }

    b() {
        try {
            UserAction.initUserAction(BaseApplication.getContext());
        } catch (Exception e16) {
            if (e16 instanceof BeaconInitException) {
                return;
            }
            QLog.e("AEBaseDataReporter", 1, "[initUserAction] error, ", e16);
        }
    }

    private void V1(String str, HashMap<String, String> hashMap, int i3, boolean z16) {
        if ((AEBaseReportParam.U().V() || z16) && ((int) (Math.random() * i3)) == 0) {
            String appKey = UserAction.getAppKey();
            UserAction.setAppKey("0AND0PWXC34GZX1C");
            UserAction.onUserAction(str, true, -1L, -1L, hashMap, false, false);
            UserAction.setAppKey(appKey);
        }
    }

    public static b b() {
        return a.f65706a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(boolean z16, String str, HashMap hashMap) {
        if (AEBaseReportParam.U().V() || z16) {
            UserAction.onUserAction(str, true, -1L, -1L, hashMap, true, false);
            String appKey = UserAction.getAppKey();
            UserAction.setAppKey("0AND0PWXC34GZX1C");
            UserAction.onUserAction(str, true, -1L, -1L, hashMap, true, false);
            UserAction.setAppKey(appKey);
        }
    }

    private void g0(final String str, final HashMap<String, String> hashMap, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.report.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(z16, str, hashMap);
            }
        }, 128, null, false);
    }

    public void A(int i3) {
        S1("click#shoot_edit#change_scale", AEBaseReportParam.U().n(i3));
    }

    public void A0(String str) {
        S1("click#emoticon_view#filter_item", AEBaseReportParam.U().x(str));
    }

    public void A1() {
        S1("click#shoot_view#photo_make", AEBaseReportParam.U().g0());
    }

    public void B(boolean z16) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("combine_type", str);
        S1("click#shoot_edit#combine_btn", hashMap);
    }

    public void B0() {
        S1("click#shoot_view#emoticon_switch", null);
    }

    public void B1() {
        S1("click#shoot_view#now_make", AEBaseReportParam.U().g0());
    }

    public void C(int i3) {
        S1("click#shoot_edit#pick_done", AEBaseReportParam.U().T(i3));
    }

    public void C0(long j3) {
        S1("enter#shoot_view#view", AEBaseReportParam.U().y(j3));
    }

    public void C1(long j3, boolean z16, boolean z17, String str, boolean z18) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("cost_time", j3 + "");
        hashMap.put("is_download_res", z16 + "");
        hashMap.put("is_cold_launch", z17 + "");
        hashMap.put("camera_scene", str);
        hashMap.put("is_from_switch_tab", z18 + "");
        T1("run#shoot_view#view", hashMap, true);
        ms.a.f("AEBaseDataReporter", "reportRealFirstFrameTime|cost_time:" + j3 + ",is_download_res:" + z16 + ",is_cold_launch:" + z17 + ",camera_scene:" + str + ",is_from_switch_tab:" + z18);
    }

    public void D() {
        S1("click#shoot_view#face_item_list", AEBaseReportParam.U().l());
    }

    public void D0() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("is_ai_btn", AEBaseReportParam.U().i() + "");
        T1("expose#shoot_view#ai_beauty", hashMap, true);
    }

    public void D1(Long l3) {
        S1("click#transmit_view#receiver", AEBaseReportParam.U().i0(l3));
    }

    public void E(LocalMediaInfo localMediaInfo) {
        T1("export#basics_view#video", AEBaseReportParam.U().p(localMediaInfo), true);
    }

    public void E1() {
        S1("click#shoot_edit#rephoto_btn", null);
    }

    public void F() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("is_ai_btn", AEBaseReportParam.U().i() + "");
        T1("click#shoot_view#ai_beauty", hashMap, true);
    }

    public void F0() {
        S1("expose#watermark_view#default_watermark", null);
    }

    public void F1() {
        S1("click#emoticon_edit#save_btn", AEBaseReportParam.U().j0());
    }

    public void G0(String str) {
        S1("expose#shoot_view#tab_item", AEBaseReportParam.U().C(str));
    }

    public void G1() {
        S1("click#shoot_view#done_btn", AEBaseReportParam.U().l0());
    }

    public void H0(String str, String str2, String str3) {
        S1("expose#shoot_view#tab_item", AEBaseReportParam.U().D(str, str2, str3));
    }

    public void H1() {
        S1("click#shoot_view#rephoto_btn", AEBaseReportParam.U().l0());
    }

    public void I(String str) {
        S1("click#shoot_view#filter_item", AEBaseReportParam.U().q(str));
    }

    public void I0(String str) {
        S1("expose#shoot_view#gift_btn", AEBaseReportParam.U().C(str));
    }

    public void I1(String str) {
        S1("click#emoticon_edit#text_ai", AEBaseReportParam.U().m0(str));
    }

    public void J() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("face_id", AEBaseReportParam.U().o0());
        T1("click#shoot_view#face_item_tip", hashMap, true);
    }

    public void J0() {
        S1("expose#current_position#view", null);
    }

    public void J1() {
        S1("click#shoot_view#switch_btn", null);
    }

    public void K(String str) {
        S1("click#shoot_view#gift_btn", AEBaseReportParam.U().C(str));
    }

    public void K0() {
        S1("click#shoot_view#face_btn", null);
    }

    public void K1() {
        S1("click#transmit_view#cancel_btn", AEBaseReportParam.U().n0());
    }

    public void L(String str) {
        S1("click#watermark_view#watermark_edit", AEBaseReportParam.U().p0(str));
    }

    public void L0(String str) {
        S1("click#shoot_view#face_item", AEBaseReportParam.U().B(str));
    }

    public void L1() {
        S1("click#shoot_view#watermark", null);
    }

    public void M(String str) {
        S1("click#current_position#position", AEBaseReportParam.U().q0(str));
    }

    public void M0() {
        S1("click#shoot_view#face_outbtn", null);
    }

    public void M1() {
        S1("click#shoot_view#watermark_icon", null);
    }

    public void N() {
        S1("click#current_position#cancel_btn", null);
    }

    public void N0(String str) {
        S1("click#shoot_view#filter_ai", AEBaseReportParam.U().G(str));
    }

    public void N1(HashMap<String, String> hashMap) {
        W1("performance#image_editor_page#fluency", hashMap, true);
    }

    public void O(HashMap<String, String> hashMap) {
        S1("expose#shoot_view#view", hashMap);
    }

    public void O0(boolean z16) {
        if (c.c()) {
            S1("performance#camera_app#res_ready", AEBaseReportParam.U().H(z16));
            c.f();
        }
    }

    public void O1(HashMap<String, String> hashMap) {
        W1("performance#clipping_page#seek", hashMap, true);
    }

    public void P(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ratio_status", str);
        S1("click#shoot_view#ratio_change", hashMap);
    }

    public void P0() {
        S1("click#shoot_view#flash_btn", null);
    }

    public void P1(HashMap<String, String> hashMap) {
        T1("performance#editor_page#fluency", hashMap, true);
    }

    public void Q(String str, String str2, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("beauty_name", str);
        hashMap.put("beauty_subname", str2);
        hashMap.put("beauty_value", String.valueOf(i3));
        S1("click#shoot_view#basic_beauty_face", hashMap);
    }

    public void Q0(String str, boolean z16, float f16, double d16, double d17, String str2) {
        S1("performance#camera_app#video", AEBaseReportParam.U().I(str, z16, f16, d16, d17, str2));
    }

    public void Q1(HashMap<String, String> hashMap) {
        T1("performance#editor_page#import", hashMap, true);
    }

    public void R(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("beauty_name", str);
        S1("click#shoot_view#basic_beauty_seekbar", hashMap);
    }

    public void R0() {
        S1("click#emoticon_view#photo_btn", AEBaseReportParam.U().J());
    }

    public void R1(HashMap<String, String> hashMap) {
        T1("performance#editor_page#template", hashMap, true);
    }

    public void S() {
        S1("click#shoot_view#basic_beauty_tab", null);
    }

    public void S0() {
        S1("click#emoticon_view#emoticon_item", AEBaseReportParam.U().K());
    }

    public void T(String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("body_name", str);
        hashMap.put("body_value", String.valueOf(i3));
        S1("click#shoot_view#basic_body_icon", hashMap);
    }

    public void T0() {
        S1("click#emoticon_edit#send_btn", AEBaseReportParam.U().L());
    }

    public void U() {
        S1("click#shoot_view#beautify_btn", null);
    }

    public void U0() {
        S1("click#emoticon_edit#save_btn", AEBaseReportParam.U().L());
    }

    public void U1(HashMap<String, String> hashMap) {
        W1("wink#soload#error", hashMap, true);
    }

    public void V() {
        S1("click#shoot_view#basic_body_tab", null);
    }

    public void V0() {
        S1("enter#emoticon_edit#view", AEBaseReportParam.U().M());
    }

    public void W(String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, str);
        hashMap.put("filter_value", String.valueOf(i3));
        S1("click#shoot_view#filter_item", hashMap);
    }

    public void W0() {
        S1("click#emoticon_view#emo_background", null);
    }

    public void X(String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, str);
        hashMap.put("filter_value", String.valueOf(i3));
        S1("click#shoot_view#filter_seekbar", hashMap);
    }

    public void X0(int i3, String str) {
        S1("click#emoticon_edit#recomm_save_btn", AEBaseReportParam.U().N(i3, str));
    }

    public void Y() {
        S1("click#shoot_view#filter_tab", null);
    }

    public void Y0() {
        S1("expose#emoticon_view#view", null);
    }

    public void Z(String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("makeup_name", str);
        hashMap.put("makeup_value", String.valueOf(i3));
        S1("click#shoot_view#basic_makeup_face", hashMap);
    }

    public void Z0() {
        S1("click#emoticon_view#emo_sort_tab", AEBaseReportParam.U().P());
    }

    public void a0(String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("makeup_name", str);
        hashMap.put("makeup_value", String.valueOf(i3));
        S1("click#shoot_view#basic_makeup_seekbar", hashMap);
    }

    public void a1() {
        S1("click#emoticon_edit#word_return", AEBaseReportParam.U().Q());
    }

    public void b0() {
        S1("click#shoot_view#basic_makeup_tab", null);
    }

    public void b1() {
        S1("click#emoticon_edit#word_done", AEBaseReportParam.U().Q());
    }

    public boolean c() {
        return ((int) (Math.random() * 100.0d)) == 5;
    }

    public void c0(HashMap<String, String> hashMap) {
        S1("click#shoot_view#face_item_edit", hashMap);
    }

    public void c1(String str) {
        S1("expose#emoticon_edit#edit_word", AEBaseReportParam.U().R(str));
    }

    public void d0(HashMap<String, String> hashMap) {
        S1("click#shoot_view#face_item_finish", hashMap);
    }

    public void d1(HashMap<String, String> hashMap) {
        T1("bundle#gzip#light_info", hashMap, true);
    }

    public void e0(HashMap<String, String> hashMap) {
        S1("click#shoot_view#photo_btn", hashMap);
    }

    public void e1() {
        S1("click#shoot_view#banner_icon", AEBaseReportParam.U().S());
    }

    public void f(boolean z16, int i3, String str, String str2, long j3, long j16) {
        if (c()) {
            ms.a.f("AEBaseDataReporter", "reportAEKitBaseDownloadResult");
            W1("performance#camera_app#res_download", AEBaseReportParam.U().g(z16, i3, str, str2, j3, j16), true);
        }
    }

    public void f0(String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, str);
        hashMap.put("filter_value", String.valueOf(i3));
        S1("click#shoot_view#filter_sliding", hashMap);
    }

    public void f1() {
        S1("expose#shoot_view#banner_icon", AEBaseReportParam.U().S());
    }

    public void g1() {
        if (AEBaseReportParam.U().r0()) {
            S1("performance#camera_app#launch", AEBaseReportParam.U().W());
            AEBaseReportParam.U().y0();
        }
    }

    public void h() {
        S1("ARcake_sclick", null);
    }

    public void h0() {
        T1("click#shoot_edit#download_btn", AEBaseReportParam.U().t(), true);
    }

    public void h1() {
        S1("click#shoot_view#local_btn", null);
    }

    public void i() {
        S1("ARvedio_sclick", null);
    }

    public void i0() {
        S1("enter#shoot_edit#view", AEBaseReportParam.U().v());
    }

    public void i1(String str, int i3, long j3, long j16, String str2) {
        S1("performance#camera_app#material_zip_download", AEBaseReportParam.U().Y(str, i3, j3, j16, str2));
    }

    public void j() {
        S1("ARvediodone_downloadsclick", null);
    }

    public void j0() {
        S1("expose#shoot_edit#view", AEBaseReportParam.U().u());
    }

    public void j1(String str) {
        S1("expose#emoticon_edit#emoticon_item", AEBaseReportParam.U().Z(str));
    }

    public void k() {
        S1("ARvediodone_exp", null);
    }

    public void k0() {
        T1("click#edit_page#cut_btn", AEBaseReportParam.U().w(), true);
    }

    public void k1(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("face_id", AEBaseReportParam.U().o0());
        hashMap.put("trigger_code", str);
        T1("run#shoot_view#face_action", hashMap, true);
    }

    public void l() {
        S1("ARvediodone_sharesclick", null);
    }

    public void l0() {
        T1("click#edit_page#enhance_btn", AEBaseReportParam.U().w(), true);
    }

    public void l1() {
        S1("click#shoot_view#module_btn", null);
    }

    public void m() {
        S1("ARweb_exp", null);
    }

    public void m0(String str) {
        HashMap<String, String> w3 = AEBaseReportParam.U().w();
        w3.put("btn_type", str);
        T1("click#edit_page#enhance_adjust", w3, true);
    }

    public void m1() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("is_ai_btn", AEBaseReportParam.U().i() + "");
        hashMap.put("face_info", AEBaseReportParam.U().h());
        T1("expose#shoot_view#get_face_first", hashMap, true);
    }

    public void n() {
        S1("click#shoot_view#aggregate_icon", AEBaseReportParam.U().o());
    }

    public void n0(String str) {
        HashMap<String, String> w3 = AEBaseReportParam.U().w();
        w3.put("btn_type", str);
        T1("click#edit_page#enhance_home", w3, true);
    }

    public void n1(long j3) {
        S1("click#shoot_view#photo_btn", AEBaseReportParam.U().a0(j3));
    }

    public void o(HashMap<String, String> hashMap) {
        T1("bundle#check_md5#light_info", hashMap, true);
    }

    public void o0() {
        T1("click#edit_page#filter_btn", AEBaseReportParam.U().w(), true);
    }

    public void o1() {
        S1("click#shoot_view#photo_switch", null);
    }

    public void p(HashMap<String, String> hashMap) {
        T1("bundle#download#light_info", hashMap, true);
    }

    public void p0(int i3, String str) {
        HashMap<String, String> w3 = AEBaseReportParam.U().w();
        w3.put("filter_type", i3 + "");
        w3.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, str);
        T1("click#edit_page#filter_type", w3, true);
    }

    public void p1() {
        S1("click#shoot_view#next_btn", AEBaseReportParam.U().b0());
    }

    public void q(HashMap<String, String> hashMap) {
        if (c()) {
            g0("cache#capture_size#file_list", hashMap, true);
        }
    }

    public void q0() {
        T1("click#edit_page#graffiti_btn", AEBaseReportParam.U().w(), true);
    }

    public void q1(String str) {
        S1("expose#shoot_view#face_item", AEBaseReportParam.U().c0(str));
    }

    public void r(int i3) {
        S1("performance#camera_app#api_level", AEBaseReportParam.U().j(i3));
    }

    public void r0(int i3) {
        HashMap<String, String> w3 = AEBaseReportParam.U().w();
        w3.put("graffiti_type", i3 + "");
        T1("click#edit_page#graffiti_type", w3, true);
    }

    public void r1() {
        S1("click#shoot_view#play_switch", null);
    }

    public void s() {
        S1("expose#camera_app#view", null);
    }

    public void s0() {
        T1("click#edit_page#mark_btn", AEBaseReportParam.U().w(), true);
    }

    public void s1() {
        HashMap<String, String> d06 = AEBaseReportParam.U().d0();
        Map<String, String> a16 = e.b().a();
        if (d06 != null) {
            d06.putAll(a16);
        }
        T1("click#shoot_edit#post_btn", d06, true);
    }

    public void t() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("is_ai_btn", AEBaseReportParam.U().i() + "");
        S1("expose#shoot_view#view", hashMap);
    }

    public void t0() {
        T1("click#edit_page#mark_input", AEBaseReportParam.U().w(), true);
    }

    public void t1(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        T1("click#shoot_edit#post_btn", AEBaseReportParam.U().e0(str, i3), true);
    }

    public void u(HashMap<String, String> hashMap) {
        g0("performance#editor_page#camera2editor", hashMap, true);
    }

    public void u0(int i3) {
        HashMap<String, String> w3 = AEBaseReportParam.U().w();
        w3.put("mark_type", i3 + "");
        T1("click#edit_page#mark_type", w3, true);
    }

    public void u1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        S1("click#shoot_edit#post_btn", AEBaseReportParam.U().h0(str));
    }

    public void v0() {
        T1("click#edit_page#music_btn", AEBaseReportParam.U().w(), true);
    }

    public void v1() {
        S1("click#shoot_edit#pic_switch", AEBaseReportParam.U().g0());
    }

    public void w(int i3, String str, String str2, int i16) {
        if (c()) {
            S1("performance#camera_app#server", AEBaseReportParam.U().k(i3, str, str2, i16));
        }
    }

    public void w0() {
        T1("click#edit_page#sticker_btn", AEBaseReportParam.U().w(), true);
    }

    public void w1() {
        S1("click#shoot_edit#text_edit", AEBaseReportParam.U().g0());
    }

    public void x(HashMap<String, String> hashMap) {
        g0("performance#camera_app#recover", hashMap, true);
    }

    public void x0() {
        T1("click#edit_page#text_btn", AEBaseReportParam.U().w(), true);
    }

    public void x1() {
        S1("click#shoot_view#make_btn", AEBaseReportParam.U().g0());
    }

    public void y() {
        S1("click#shoot_view#cancel_btn", null);
    }

    public void y0(String str) {
        HashMap<String, String> w3 = AEBaseReportParam.U().w();
        w3.put("text_id", str);
        T1("click#edit_page#text_type", w3, true);
    }

    public void y1() {
        S1("click#shoot_edit#preview_btn", AEBaseReportParam.U().g0());
    }

    public void z(long j3) {
        S1("click#shoot_edit#edit_choose", AEBaseReportParam.U().m(j3));
    }

    public void z0(HashMap<String, String> hashMap) {
        T1("wink#preload_error#first_frame", hashMap, true);
    }

    public void z1() {
        S1("click#shoot_edit#video_edit", AEBaseReportParam.U().g0());
    }

    private void S1(String str, HashMap<String, String> hashMap) {
        T1(str, hashMap, false);
    }

    public void e(String str, HashMap<String, String> hashMap) {
        g0(str, hashMap, true);
    }

    public void g(HashMap<String, String> hashMap, String str) {
        T1(str, hashMap, true);
    }

    public void v(String str, HashMap<String, String> hashMap) {
        T1(str, hashMap, true);
    }

    private void T1(String str, HashMap<String, String> hashMap, boolean z16) {
        if (hashMap == null) {
            g0(str, AEBaseReportParam.U().r(), z16);
        } else {
            g0(str, c.g(AEBaseReportParam.U().r(), hashMap), z16);
        }
    }

    public void E0() {
        T1("expose#shoot_view#ai_label", null, true);
    }

    public void G() {
        T1("click#shoot_view#ai_beauty_desc", null, true);
    }

    public void H() {
        T1("click#shoot_view#ai_label", null, true);
    }

    private void W1(String str, HashMap<String, String> hashMap, boolean z16) {
        if (hashMap == null) {
            V1(str, AEBaseReportParam.U().r(), 10, z16);
        } else {
            V1(str, c.g(AEBaseReportParam.U().r(), hashMap), 10, z16);
        }
    }
}
