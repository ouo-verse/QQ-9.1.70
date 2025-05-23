package fn4;

import android.view.View;
import com.tencent.timi.game.utils.l;
import gh4.e;
import gh4.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mm4.b;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAchievement;
import trpc.yes.common.YoloRoomOuterClass$YoloGiftConfig;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    private static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        e I0 = ((f) b.b(f.class)).I0();
        if (I0 != null) {
            hashMap.putAll(I0.m0().h());
            hashMap.putAll(I0.m0().E());
            hashMap.put("yes_game_id", String.valueOf(I0.o1()));
        }
        return hashMap;
    }

    private static void b(View view, String str, Map<String, String> map, String str2) {
        ((ug4.b) b.b(ug4.b.class)).a(view, true, str, "em_yes_teamlist_panel_smoba_team", map);
        e I0 = ((f) b.b(f.class)).I0();
        if (I0 != null && I0.m0() != null) {
            try {
                I0.m0().Z(Long.parseLong(str), str2);
            } catch (NumberFormatException unused) {
                l.e("TeamListReport", "NumberFormatException:" + str);
            }
        }
    }

    private static void c(View view, String str, Map<String, String> map, String str2) {
        ((ug4.b) b.b(ug4.b.class)).a(view, true, str, "em_yes_slidecard_smoba_team", map);
        e I0 = ((f) b.b(f.class)).I0();
        if (I0 != null && I0.m0() != null) {
            try {
                I0.m0().Z(Long.parseLong(str), str2);
            } catch (NumberFormatException unused) {
                l.e("TeamListReport", "NumberFormatException:" + str);
            }
        }
    }

    public static void d(View view) {
        ((ug4.b) b.b(ug4.b.class)).a(view, true, null, "em_yes_create_team", a());
    }

    public static void e(View view) {
        ((ug4.b) b.b(ug4.b.class)).a(view, true, null, "em_yes_slidecard_more_team", a());
    }

    public static void f(View view, String str, String str2, List<Integer> list, List<Integer> list2, String str3, List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> list3, YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig) {
        String str4;
        String str5;
        String str6;
        Map<String, String> a16 = a();
        a16.put("yes_team_id", str);
        a16.put("yes_team_name", str2);
        StringBuilder sb5 = new StringBuilder();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(",");
        }
        a16.put("yes_team_rank", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        Iterator<Integer> it5 = list2.iterator();
        while (it5.hasNext()) {
            sb6.append(it5.next());
            sb6.append(",");
        }
        a16.put("yes_team_branch", sb6.toString());
        a16.put("yes_game_mode", str3);
        if (yoloRoomOuterClass$YoloGiftConfig != null && yoloRoomOuterClass$YoloGiftConfig.gift_material_id.get() != 0 && yoloRoomOuterClass$YoloGiftConfig.gift_num.get() != 0) {
            str5 = String.valueOf(yoloRoomOuterClass$YoloGiftConfig.gift_id.get());
            str6 = String.valueOf(yoloRoomOuterClass$YoloGiftConfig.gift_num.get());
            str4 = "1";
        } else {
            str4 = "0";
            str5 = "";
            str6 = str5;
        }
        a16.put("yes_team_type", str4);
        a16.put("yes_gift_id", str5);
        a16.put("yes_gift_nums", str6);
        String str7 = "";
        for (int i3 = 0; i3 < list3.size(); i3++) {
            List<YesGameInfoOuterClass$YesGameRoleAchievement> list4 = list3.get(i3).role_achievement.get();
            if (list4.size() > 0) {
                str7 = str7 + "," + list4.get(0).type.get();
            }
        }
        String replaceFirst = str7.replaceFirst(",", "");
        a16.put("yes_member_tag_id", replaceFirst);
        c(view, str, a16, replaceFirst);
    }

    public static void g(View view) {
        ((ug4.b) b.b(ug4.b.class)).a(view, true, null, "em_yes_slidecard_view_more", a());
    }

    public static void h(View view) {
        ((ug4.b) b.b(ug4.b.class)).a(view, true, null, "em_yes_teamfilter_panel_close", a());
    }

    public static void i(View view) {
        ((ug4.b) b.b(ug4.b.class)).a(view, true, null, "em_yes_teamfilter_panel_confirm", a());
    }

    public static void j(View view) {
        ((ug4.b) b.b(ug4.b.class)).a(view, true, null, "em_yes_teamfilter_panel_create_team", a());
    }

    public static void k(View view) {
        ((ug4.b) b.b(ug4.b.class)).a(view, true, null, "em_yes_teamfilter_panel_reset", a());
    }

    public static void l(View view) {
        ((ug4.b) b.b(ug4.b.class)).a(view, true, null, "em_yes_teamfilter_panel_teamfilter", a());
    }

    public static void m(View view, String str, String str2, List<Integer> list, List<Integer> list2, String str3, List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> list3, YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig) {
        String str4;
        String str5;
        String str6;
        Map<String, String> a16 = a();
        a16.put("yes_team_id", str);
        a16.put("yes_team_name", str2);
        StringBuilder sb5 = new StringBuilder();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(",");
        }
        a16.put("yes_team_rank", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        Iterator<Integer> it5 = list2.iterator();
        while (it5.hasNext()) {
            sb6.append(it5.next());
            sb6.append(",");
        }
        a16.put("yes_team_branch", sb6.toString());
        a16.put("yes_game_mode", str3);
        if (yoloRoomOuterClass$YoloGiftConfig != null && yoloRoomOuterClass$YoloGiftConfig.gift_material_id.get() != 0 && yoloRoomOuterClass$YoloGiftConfig.gift_num.get() != 0) {
            str5 = String.valueOf(yoloRoomOuterClass$YoloGiftConfig.gift_id.get());
            str6 = String.valueOf(yoloRoomOuterClass$YoloGiftConfig.gift_num.get());
            str4 = "1";
        } else {
            str4 = "0";
            str5 = "";
            str6 = str5;
        }
        a16.put("yes_team_type", str4);
        a16.put("yes_gift_id", str5);
        a16.put("yes_gift_nums", str6);
        String str7 = "";
        for (int i3 = 0; i3 < list3.size(); i3++) {
            List<YesGameInfoOuterClass$YesGameRoleAchievement> list4 = list3.get(i3).role_achievement.get();
            if (list4.size() > 0) {
                str7 = str7 + "," + list4.get(0).type.get();
            }
        }
        String replaceFirst = str7.replaceFirst(",", "");
        a16.put("yes_member_tag_id", replaceFirst);
        b(view, str, a16, replaceFirst);
    }
}
