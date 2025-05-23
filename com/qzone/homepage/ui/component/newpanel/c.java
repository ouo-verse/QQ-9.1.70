package com.qzone.homepage.ui.component.newpanel;

import NS_MOBILE_MAIN_PAGE.s_red_comm;
import NS_MOBILE_MAIN_PAGE.s_red_info;
import NS_MOBILE_MAIN_PAGE.s_tab_list_item;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {
    public static Pair<Integer, ArrayList<RedInfo>> h(Map<Integer, s_red_comm> map, int i3) {
        ArrayList arrayList = new ArrayList();
        s_red_comm g16 = g(map, i3);
        int i16 = 0;
        if (g16 != null) {
            ArrayList<Integer> arrayList2 = g16.subid;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                int i17 = 0;
                while (i16 < g16.subid.size()) {
                    int intValue = g16.subid.get(i16).intValue();
                    s_red_comm g17 = g(map, intValue);
                    if (g17 != null) {
                        i17 = (int) (i17 + g17.undealnum);
                        f(g17.redinfo, arrayList, intValue);
                    }
                    i16++;
                }
                i16 = i17;
            } else {
                i16 = (int) g16.undealnum;
                f(g16.redinfo, arrayList, i3);
            }
        }
        return new Pair<>(Integer.valueOf(i16), arrayList);
    }

    public static ArrayList<s_tab_list_item> a(ArrayList<HomePanelItem> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<s_tab_list_item> arrayList2 = new ArrayList<>();
        Iterator<HomePanelItem> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(b(it.next()));
        }
        return arrayList2;
    }

    public static s_tab_list_item b(HomePanelItem homePanelItem) {
        if (homePanelItem == null) {
            return null;
        }
        return new s_tab_list_item(homePanelItem.tabId, homePanelItem.iconUrl, homePanelItem.jumpUrl, homePanelItem.text, homePanelItem.isCustom, homePanelItem.redIdMainpage, homePanelItem.redIdUndelcount, homePanelItem.canEdit, false, homePanelItem.rightText, homePanelItem.extInfo);
    }

    public static ArrayList<HomePanelItem> c(ArrayList<s_tab_list_item> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<HomePanelItem> arrayList2 = new ArrayList<>();
        Iterator<s_tab_list_item> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(d(it.next()));
        }
        return arrayList2;
    }

    public static HomePanelItem d(s_tab_list_item s_tab_list_itemVar) {
        if (s_tab_list_itemVar == null) {
            return null;
        }
        return new HomePanelItem(s_tab_list_itemVar.tab_id, s_tab_list_itemVar.icon_url, s_tab_list_itemVar.jump_url, s_tab_list_itemVar.text, s_tab_list_itemVar.is_custom, s_tab_list_itemVar.red_id_mainpage, s_tab_list_itemVar.red_id_undelcount, s_tab_list_itemVar.can_edit, s_tab_list_itemVar.need_clear_red, s_tab_list_itemVar.right_text, s_tab_list_itemVar.extInfo);
    }

    public static s_red_comm g(Map<Integer, s_red_comm> map, int i3) {
        if (map == null) {
            return null;
        }
        return map.get(Integer.valueOf(i3));
    }

    public static ArrayList<HomePanelItem> e(ArrayList<HomePanelItem> arrayList, Map<Integer, s_red_comm> map) {
        Pair<Integer, ArrayList<RedInfo>> h16;
        if (arrayList != null && map != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                HomePanelItem homePanelItem = arrayList.get(i3);
                if (homePanelItem != null && (h16 = h(map, homePanelItem.redIdMainpage)) != null) {
                    homePanelItem.redCount = h16.first.intValue();
                    homePanelItem.redInfos = h16.second;
                    arrayList.set(i3, homePanelItem);
                }
            }
        }
        return arrayList;
    }

    public static void f(List<s_red_info> list, List<RedInfo> list2, int i3) {
        if (list == null || list2 == null) {
            return;
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            list2.add(RedInfo.createFrom(list.get(i16)));
        }
    }
}
