package com.qzone.common.event.ui.model;

import NS_MOBILE_FEEDS.s_join_list;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.util.e;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class JoinList implements SmartParcelable {

    @NeedParcel
    public int num = 0;

    @NeedParcel
    public int isjoined = 0;

    @NeedParcel
    public ArrayList<User> users = null;

    @NeedParcel
    public String desc = "";

    @NeedParcel
    public String actionUrl = "";

    @NeedParcel
    public int actionType = 0;

    public static JoinList create(s_join_list s_join_listVar) {
        if (s_join_listVar == null) {
            return null;
        }
        JoinList joinList = new JoinList();
        joinList.num = s_join_listVar.num;
        joinList.isjoined = s_join_listVar.isjoined;
        joinList.users = new ArrayList<>();
        if (s_join_listVar.users != null) {
            for (int i3 = 0; i3 < s_join_listVar.users.size(); i3++) {
                joinList.users.add(e.q(s_join_listVar.users.get(i3)));
            }
        }
        joinList.desc = s_join_listVar.desc;
        joinList.actionUrl = s_join_listVar.actionUrl;
        joinList.actionType = s_join_listVar.actionType;
        return joinList;
    }
}
