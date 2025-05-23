package com.tencent.relation.common.config.toggle;

import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c extends a {
    static IPatchRedirector $redirector_;
    public static final c A;
    public static final c B;
    public static final c C;
    public static final c D;
    public static final c E;
    public static final c F;
    public static final c G;
    public static final c H;
    public static final c I;
    public static final c J;
    public static final c K;
    public static final c L;
    public static final c M;
    public static final c N;
    public static final c O;
    public static final c P;
    public static final c Q;
    public static final c R;
    public static final c S;
    public static final c T;
    public static final c U;
    public static final c V;
    public static final c W;
    public static final c X;
    public static final c Y;
    public static final c Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final c f364688a0;

    /* renamed from: b, reason: collision with root package name */
    public static final c f364689b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f364690c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f364691d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f364692e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f364693f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f364694g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f364695h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f364696i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f364697j;

    /* renamed from: k, reason: collision with root package name */
    public static final c f364698k;

    /* renamed from: l, reason: collision with root package name */
    public static final c f364699l;

    /* renamed from: m, reason: collision with root package name */
    public static final c f364700m;

    /* renamed from: n, reason: collision with root package name */
    public static final c f364701n;

    /* renamed from: o, reason: collision with root package name */
    public static final c f364702o;

    /* renamed from: p, reason: collision with root package name */
    public static final c f364703p;

    /* renamed from: q, reason: collision with root package name */
    public static final c f364704q;

    /* renamed from: r, reason: collision with root package name */
    public static final c f364705r;

    /* renamed from: s, reason: collision with root package name */
    public static final c f364706s;

    /* renamed from: t, reason: collision with root package name */
    public static final c f364707t;

    /* renamed from: u, reason: collision with root package name */
    public static final c f364708u;

    /* renamed from: v, reason: collision with root package name */
    public static final c f364709v;

    /* renamed from: w, reason: collision with root package name */
    public static final c f364710w;

    /* renamed from: x, reason: collision with root package name */
    public static final c f364711x;

    /* renamed from: y, reason: collision with root package name */
    public static final c f364712y;

    /* renamed from: z, reason: collision with root package name */
    public static final c f364713z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26814);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f364689b = new c("qqparty_room_enable_gm");
        f364690c = new c("gamemsgbox_restore_games");
        f364691d = new c(ProfileCardFeatureSwitch.PROFILE_CARD_EMPTY_ITEM_FOLD_OWNER);
        f364692e = new c("qqstranger_minicontainer_preload");
        f364693f = new c("nameplate_msg_can_use_ark");
        f364694g = new c("qqavatar_cache_not_remove_switch");
        f364695h = new c(ProfileCardFeatureSwitch.PROFILE_CARD_STICKY_NOTE_FIX_ADAPTER);
        f364696i = new c("profile_card_zan_ranking_config");
        f364697j = new c("qq_region_config");
        f364698k = new c("qqwebapi_business_config");
        f364699l = new c("qqavatar_action_sheet_order");
        f364700m = new c("qq_profilecard_recyclerView_fix");
        f364701n = new c("qq_profile_instep");
        f364702o = new c("profile_recommend_cover_offline");
        f364703p = new c("qq_new_contact_profile");
        f364704q = new c("mutualmark_8925_version_switch");
        f364705r = new c("qq_profilecard_koilike_switch");
        f364706s = new c("qq_profile_authority_tags");
        f364707t = new c("recent_nearby_inject_switch");
        f364708u = new c("qq_personality_tofu_8928_switch");
        f364709v = new c("qq_mutualmark_0xc7_pushurl_switch");
        f364710w = new c("qq_mutualmark_0xc7_pushurl_fabu_switch");
        f364711x = new c("qq_mutualmark_graytips_wording_switch");
        f364712y = new c("qq_intimate_8928_manage_switch");
        f364713z = new c("qq_mutualmark_forbid_vasappendurl");
        A = new c(ProfileCardFeatureSwitch.Elegant_PROFILE_CARD);
        B = new c("share_panel_show_recent_forward");
        C = new c("user_summary_profession_offline");
        D = new c("open_zplan_avatar");
        E = new c("qqstranger_enable_dark_mode");
        F = new c("qq_share_position");
        G = new c("qq_8918_troop_avatar_upload");
        H = new c("qq_8920_friend_fragment_show_opt");
        I = new c("relation_blacklist_toggle");
        J = new c("troopgamecard_sdcard_migrate_toggle");
        K = new c("wifisdk_getvid_toggle");
        L = new c("qq_mutualmark_detail_special_resource_config");
        M = new c("video_subthread_toggle");
        N = new c("resetFriendListMask_only_type_9");
        O = new c("relation_emojiegg_entrance_control");
        P = new c("baseprofile_old_tofu_display");
        Q = new c("qq_8933_select_friend_orientation");
        R = new c("qq_8933_profile_intercept_update");
        S = new c("qq_8933_start_0x5eb_combin");
        T = new c("qq_8933_discuss_forward_opt");
        U = new c("qq_8933_pager_adapter_fragment_manager");
        V = new c("qq_8933_troop_cover_opt");
        W = new c("qq_8933_friend_select_search_result_choose");
        X = new c("qq_8938_0x5eb_merge_cold_start");
        Y = new c("contact_aio_user_summary_enter");
        Z = new c("qq_8938_troopnotification_setfirstlinetext_subthread");
        f364688a0 = new c("qq_mutualmark_type_check_unuse_switch");
    }

    protected c(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.relation.common.config.toggle.a
    public /* bridge */ /* synthetic */ int a(int i3) {
        return super.a(i3);
    }

    @Override // com.tencent.relation.common.config.toggle.a
    public /* bridge */ /* synthetic */ JSONObject c() {
        return super.c();
    }

    @Override // com.tencent.relation.common.config.toggle.a
    public /* bridge */ /* synthetic */ String d(String str, String str2) {
        return super.d(str, str2);
    }

    @Override // com.tencent.relation.common.config.toggle.a
    public /* bridge */ /* synthetic */ boolean g(boolean z16) {
        return super.g(z16);
    }
}
