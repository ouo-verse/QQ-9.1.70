package com.tencent.biz.pubaccount.weishi.report;

import UserGrowth.stFriendLike;
import UserGrowth.stFriendLikes;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.richtext.d;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.v;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSFollowBeaconReport {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f81462a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private static String f81463b = "";

    public static void A(String str, Map<String, String> map, stSimpleMetaFeed stsimplemetafeed) {
        WSStatisticsReporter.Builder addParams = e(WSPublicAccReport.SOP_NAME_FOCUS).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(str, 0, stsimplemetafeed));
        if (map != null && !map.isEmpty()) {
            addParams.addExtParams(map);
        }
        f(addParams, "gzh_exposure");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WSStatisticsReporter.Builder e(String str) {
        return new WSStatisticsReporter.Builder().setSopName(str).setTestId(bb.x(9)).setPushId(v.b().c()).setFlush(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(WSStatisticsReporter.Builder builder, String str) {
        x.j("WSFollowBeaconReport", str + ", " + builder.getSopName() + MsgSummary.STR_COLON + builder.getParams().toString());
        builder.build(str).report();
    }

    public static void j(String str, int i3, String str2, Map<String, String> map, stSimpleMetaFeed stsimplemetafeed) {
        z("dynamics_" + str + i3, Integer.valueOf(str2).intValue(), map, stsimplemetafeed);
    }

    public static void l(String str, int i3, Map<String, String> map, stSimpleMetaFeed stsimplemetafeed) {
        A("dynamics_" + str + i3, map, stsimplemetafeed);
    }

    public static void m(final int i3, final stSimpleMetaFeed stsimplemetafeed, final boolean z16, final boolean z17, final boolean z18, final boolean z19, final boolean z26, final ArrayList<d.e> arrayList, final ArrayList<d.C0830d> arrayList2) {
        new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport.1
            @Override // java.lang.Runnable
            public void run() {
                stFriendLikes stfriendlikes;
                ArrayList<stFriendLike> arrayList3;
                HashMap hashMap = new HashMap();
                hashMap.put("index", String.valueOf(i3));
                hashMap.put("position_profile", "dynamics_nickname" + i3);
                hashMap.put("position_nickname", "dynamics_nickname" + i3);
                hashMap.put("position_content", "dynamics_content" + i3);
                hashMap.put("position_video", "dynamics_video" + i3);
                hashMap.put("position_more_operations", "dynamics_more_operations" + i3);
                if (z16) {
                    hashMap.put("position_close", "dynamics_close" + i3);
                    hashMap.put("position_follow", "dynamics_follow" + i3);
                }
                if (z17) {
                    hashMap.put("position_label_music", "dynamics_bottom_label_music" + i3);
                }
                if (z18) {
                    hashMap.put("position_label_magic", "dynamics_bottom_label_magic" + i3);
                }
                if (z19) {
                    hashMap.put("position_label_location", "dynamics_bottom_label_location" + i3);
                }
                if (z26) {
                    hashMap.put("position_qqgroup", "dynamics_qqgroup" + i3);
                }
                stSimpleMetaFeed stsimplemetafeed2 = stsimplemetafeed;
                if (stsimplemetafeed2 != null && (stfriendlikes = stsimplemetafeed2.friendLikes) != null && (arrayList3 = stfriendlikes.likeFriends) != null && arrayList3.size() > 0) {
                    hashMap.put("position_friend", "dynamics_friend" + i3);
                }
                stSimpleMetaFeed stsimplemetafeed3 = stsimplemetafeed;
                String str = "0";
                if (stsimplemetafeed3 != null && r.u(stsimplemetafeed3.poster)) {
                    str = "1";
                }
                hashMap.put("is_livenow", str);
                WSFollowBeaconReport.h(hashMap, arrayList, i3);
                WSFollowBeaconReport.g(hashMap, arrayList2, i3);
                WSFollowBeaconReport.f(WSFollowBeaconReport.e(WSPublicAccReport.SOP_NAME_FOCUS).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("dynamics_feed", 0, stsimplemetafeed)).addExtParams(hashMap), "gzh_exposure");
            }
        }.run();
    }

    public static void n(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(MiniAppPlugin.ATTR_PAGE_TYPE, str);
        f(e("backstage").addParams("position", "focus_pullout").addParams("feed_id", "").addParams("owner_id", "").addExtParams(hashMap), "gzh_exposure");
    }

    public static void p(int i3, int i16, stSimpleMetaFeed stsimplemetafeed, boolean z16, int i17) {
        stSimpleMetaPerson stsimplemetaperson;
        Object obj;
        Object obj2;
        Object obj3;
        HashMap hashMap = new HashMap();
        if (stsimplemetafeed != null && (stsimplemetaperson = stsimplemetafeed.poster) != null) {
            String str = "1";
            if (r.r(stsimplemetaperson.followStatus)) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("is_focus", obj);
            if (i17 > 1) {
                obj2 = "1";
            } else {
                obj2 = "0";
            }
            hashMap.put("is_fold", obj2);
            hashMap.put("fold_num", String.valueOf(i17));
            if (z16) {
                obj3 = "1";
            } else {
                obj3 = "0";
            }
            hashMap.put("is_unread", obj3);
            if (!r.u(stsimplemetafeed.poster)) {
                str = "0";
            }
            hashMap.put("is_livenow", str);
        }
        z("friend_video" + i3, i16, hashMap, stsimplemetafeed);
    }

    public static void q(int i3, stSimpleMetaFeed stsimplemetafeed, boolean z16, int i16) {
        stSimpleMetaPerson stsimplemetaperson;
        Object obj;
        Object obj2;
        Object obj3;
        HashMap hashMap = new HashMap();
        if (stsimplemetafeed != null && (stsimplemetaperson = stsimplemetafeed.poster) != null) {
            String str = "1";
            if (r.r(stsimplemetaperson.followStatus)) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("is_focus", obj);
            if (i16 > 1) {
                obj2 = "1";
            } else {
                obj2 = "0";
            }
            hashMap.put("is_fold", obj2);
            hashMap.put("fold_num", String.valueOf(i16));
            if (z16) {
                obj3 = "1";
            } else {
                obj3 = "0";
            }
            hashMap.put("is_unread", obj3);
            if (!r.u(stsimplemetafeed.poster)) {
                str = "0";
            }
            hashMap.put("is_livenow", str);
        }
        A("friend_video" + i3, hashMap, stsimplemetafeed);
    }

    public static void r(int i3, int i16, stSimpleMetaFeed stsimplemetafeed, boolean z16, int i17) {
        stSimpleMetaPerson stsimplemetaperson;
        Object obj;
        Object obj2;
        HashMap hashMap = new HashMap();
        if (stsimplemetafeed != null && (stsimplemetaperson = stsimplemetafeed.poster) != null) {
            String str = "1";
            if (r.r(stsimplemetaperson.followStatus)) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("is_focus", obj);
            if (i17 > 1) {
                obj2 = "1";
            } else {
                obj2 = "0";
            }
            hashMap.put("is_fold", obj2);
            hashMap.put("fold_num", String.valueOf(i17));
            if (!z16) {
                str = "0";
            }
            hashMap.put("is_unread", str);
        }
        z("friend_focus" + i3, i16, hashMap, stsimplemetafeed);
    }

    public static void s(int i3, stSimpleMetaFeed stsimplemetafeed, boolean z16, int i16) {
        stSimpleMetaPerson stsimplemetaperson;
        Object obj;
        Object obj2;
        HashMap hashMap = new HashMap();
        if (stsimplemetafeed != null && (stsimplemetaperson = stsimplemetafeed.poster) != null) {
            String str = "0";
            if (!r.r(stsimplemetaperson.followStatus)) {
                obj = "0";
            } else {
                obj = "1";
            }
            hashMap.put("is_focus", obj);
            if (i16 <= 1) {
                obj2 = "0";
            } else {
                obj2 = "1";
            }
            hashMap.put("is_fold", obj2);
            hashMap.put("fold_num", String.valueOf(i16));
            if (z16) {
                str = "1";
            }
            hashMap.put("is_unread", str);
            hashMap.put("is_livenow", "1");
        }
        z("friend_live_headpic" + i3, 1000001, hashMap, stsimplemetafeed);
    }

    public static void u() {
        A("friend_info_float", null, null);
    }

    public static void w(String str, int i3, String str2, String str3) {
        f(e(WSPublicAccReport.SOP_NAME_FOCUS).addParams("position", "recommend_" + str + i3).addParams("owner_id", str2).addParams("action_id", str3), "gzh_click");
    }

    public static void x(int i3, stSimpleMetaPerson stsimplemetaperson) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("index", String.valueOf(i3));
        hashMap.put("position_profile", "recommend_profile" + i3);
        hashMap.put("position_nickname", "recommend_nickname" + i3);
        hashMap.put("position_close", "recommend_close" + i3);
        if (stsimplemetaperson != null && !r.r(stsimplemetaperson.followStatus)) {
            hashMap.put("position_follow", "recommend_follow" + i3);
        }
        WSStatisticsReporter.Builder addParams = e(WSPublicAccReport.SOP_NAME_FOCUS).addParams("position", "recommend_profile_card");
        if (stsimplemetaperson != null) {
            str = stsimplemetaperson.f25130id;
        } else {
            str = "";
        }
        f(addParams.addParams("owner_id", str).addExtParams(hashMap), "gzh_exposure");
    }

    public static void y(int i3) {
        WSStatisticsReporter.Builder addParams = e(WSPublicAccReport.SOP_NAME_FOCUS).addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("focus_recommend_gap", 0));
        HashMap hashMap = new HashMap();
        hashMap.put("gap_type", String.valueOf(i3));
        addParams.addExtParams(hashMap);
        f(addParams, "gzh_exposure");
    }

    public static void z(String str, int i3, Map<String, String> map, stSimpleMetaFeed stsimplemetafeed) {
        WSStatisticsReporter.Builder addParams = e(WSPublicAccReport.SOP_NAME_FOCUS).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(str, i3, stsimplemetafeed));
        if (map != null && !map.isEmpty()) {
            addParams.addExtParams(map);
        }
        f(addParams, "gzh_click");
    }

    public static void D(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        B(2, eVar, z16);
    }

    public static void i(String str, int i3, String str2, stSimpleMetaFeed stsimplemetafeed) {
        j(str, i3, str2, null, stsimplemetafeed);
    }

    public static void k(String str, int i3, stSimpleMetaFeed stsimplemetafeed) {
        l(str, i3, null, stsimplemetafeed);
    }

    private static void B(int i3, com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        l lVar;
        if (eVar == null || (lVar = eVar.f81127c) == null || com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.b(f81462a, i3, lVar)) {
            return;
        }
        if (i3 == 1) {
            f81463b = com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.i(lVar.f81166a);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CGNonAgeReport.EVENT_TYPE, i3 + "");
        hashMap.put("feed_id", lVar.f81166a);
        hashMap.put("owner_id", lVar.f81181p);
        hashMap.put("global_key", c.b().c(lVar.f81182q));
        if (i3 == 2) {
            WSPlayerWrapper wSPlayerWrapper = eVar.f81129e;
            long Q = wSPlayerWrapper == null ? 0L : wSPlayerWrapper.Q(z16);
            long z17 = wSPlayerWrapper != null ? wSPlayerWrapper.z() : 0L;
            hashMap.put("duration", String.valueOf(Q));
            hashMap.put("last_location", String.valueOf(z17));
        }
        hashMap.put("video_length", String.valueOf(lVar.f81169d));
        hashMap.put("recommend_id", "");
        hashMap.put("poolType", String.valueOf(lVar.f81176k));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_ID, f81463b);
        x.j("WS_VIDEO_PLAY_TIME", "[WSFollowBeaconReport.java][reportVerticalVideoPlay] title:" + lVar.f81175j + ", map:" + hashMap.toString());
        f(e(WSPublicAccReport.SOP_NAME_FOCUS).addObjectParams("feed_pass_key", lVar.f81183r).addParams(hashMap), "gzh_video_play");
    }

    public static void C(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        B(1, eVar, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Map<String, String> map, ArrayList<d.C0830d> arrayList, int i3) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            sb5.append("dynamics_topic");
            sb5.append(i3);
            sb5.append(":");
            sb5.append(arrayList.get(i16).f81564a);
            if (i16 != arrayList.size() - 1) {
                sb5.append("#");
            }
        }
        map.put("position_topic", sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Map<String, String> map, ArrayList<d.e> arrayList, int i3) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            sb5.append("dynamics_user_at");
            sb5.append(i3);
            sb5.append(":");
            sb5.append(arrayList.get(i16).f81566a);
            if (i16 != arrayList.size() - 1) {
                sb5.append("#");
            }
        }
        map.put("position_at", sb5.toString());
    }

    public static void o() {
        z("friend_all", 1000001, null, null);
    }

    public static void t() {
        z("friend_info_float", 1000001, null, null);
    }

    public static void v() {
        z("friend_info", 1000001, null, null);
    }
}
