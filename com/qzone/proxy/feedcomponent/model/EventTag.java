package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_event_tag;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class EventTag implements SmartParcelable {

    @NeedParcel
    public Map<String, String> extendInfo;

    @NeedParcel
    public JoinList joinList;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public long time = 0;

    /* renamed from: id, reason: collision with root package name */
    @NeedParcel
    public String f50233id = "";

    @NeedParcel
    public String title = "";

    @NeedParcel
    public String showTxt = "";

    @NeedParcel
    public String showDesc = "";

    @NeedParcel
    public String picUrl = "";

    @NeedParcel
    public int picWidth = 0;

    @NeedParcel
    public int picHeight = 0;

    @NeedParcel
    public String count_desc = "";

    @NeedParcel
    public boolean isDefault = false;

    @NeedParcel
    public String joinDesc = "";

    @NeedParcel
    public int joinTruncateNum = 0;

    @NeedParcel
    public String backgd_picurl = "";

    @NeedParcel
    public boolean updateFlag = false;

    public static EventTag create(s_event_tag s_event_tagVar) {
        if (s_event_tagVar == null) {
            return null;
        }
        EventTag eventTag = new EventTag();
        eventTag.uin = s_event_tagVar.uin;
        eventTag.time = s_event_tagVar.time;
        eventTag.f50233id = s_event_tagVar.f24992id;
        eventTag.title = s_event_tagVar.title;
        eventTag.showTxt = s_event_tagVar.show_txt;
        eventTag.showDesc = s_event_tagVar.show_desc;
        eventTag.picUrl = s_event_tagVar.pic_url;
        eventTag.picWidth = s_event_tagVar.pic_width;
        eventTag.picHeight = s_event_tagVar.pic_height;
        eventTag.count_desc = s_event_tagVar.count_desc;
        JoinList create = JoinList.create(s_event_tagVar.join_list);
        eventTag.joinList = create;
        eventTag.isDefault = s_event_tagVar.is_default;
        eventTag.extendInfo = s_event_tagVar.extendInfo;
        Object[] joinListString = getJoinListString(create);
        if (joinListString != null) {
            eventTag.joinDesc = (String) joinListString[0];
            eventTag.joinTruncateNum = ((Integer) joinListString[1]).intValue();
        }
        eventTag.backgd_picurl = s_event_tagVar.backgd_picurl;
        eventTag.updateFlag = s_event_tagVar.update_flag;
        return eventTag;
    }

    public static Object[] getJoinListString(JoinList joinList) {
        String str;
        String str2;
        String str3 = null;
        if (joinList == null || (str = joinList.desc) == null) {
            return null;
        }
        ArrayList<User> arrayList = joinList.users;
        String valueOf = String.valueOf(joinList.num);
        if (joinList.num >= 10000) {
            valueOf = String.format("%.1f", Float.valueOf(joinList.num / 10000.0f)) + "\u4e07";
        }
        if (joinList.isjoined == 1) {
            int i3 = joinList.num;
            if (i3 != 1) {
                if (i3 == 2) {
                    if (arrayList.size() > 0) {
                        str3 = "\u6211\u3001" + arrayList.get(0).nickName;
                    }
                } else if (i3 > 2) {
                    if (arrayList.size() <= 0) {
                        str3 = "\u6211";
                    } else {
                        str3 = "\u6211\u3001" + arrayList.get(0).nickName;
                    }
                    str = "\u7b49" + valueOf + "\u4eba" + str;
                }
            }
            str3 = "\u6211";
        } else {
            int i16 = joinList.num;
            if (i16 == 1) {
                if (arrayList.size() > 0) {
                    str3 = arrayList.get(0).nickName;
                } else {
                    str = valueOf + "\u4eba" + str;
                }
            } else if (i16 == 2) {
                if (arrayList.size() == 1) {
                    str3 = arrayList.get(0).nickName;
                } else if (arrayList.size() > 1) {
                    str3 = arrayList.get(0).nickName + "\u3001" + arrayList.get(1).nickName;
                } else {
                    str = valueOf + "\u4eba" + str;
                }
            } else if (i16 > 2) {
                if (arrayList.size() == 1) {
                    str3 = arrayList.get(0).nickName;
                    str = "\u7b49" + valueOf + "\u4eba" + str;
                } else if (arrayList.size() > 1) {
                    str3 = arrayList.get(0).nickName + "\u3001" + arrayList.get(1).nickName;
                    str = "\u7b49" + valueOf + "\u4eba" + str;
                } else {
                    str = valueOf + "\u4eba" + str;
                }
            }
        }
        if (str3 != null) {
            str2 = str3 + str;
        } else {
            str2 = str;
        }
        return new Object[]{str2, Integer.valueOf(str.length())};
    }
}
