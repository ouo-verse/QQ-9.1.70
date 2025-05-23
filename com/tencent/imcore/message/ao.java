package com.tencent.imcore.message;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.UinType;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ao {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f116567a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f116568b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f116569c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f116570d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f116571e;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f116572f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f116573g;

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f116574h;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f116575i;

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f116576j;

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f116577k;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37477);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f116567a = new int[]{1, 3000, 1006, 7000, 9501, 10005, 1033, 1034, 1036, 10014, 6005, 6000, 6003};
        f116568b = new int[]{-2006, MessageRecord.MSG_TYPE_TEXT_FRIEND_FEED, MessageRecord.MSG_TYPE_DATE_FEED, MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED, MessageRecord.MSG_TYPE_QQSTORY_LATEST_FEED, -4002, -4003, -4004, -1001, MessageRecord.MSG_TYPE_TEXT_GROUP_CREATED, -1013, MessageRecord.MSG_TYPE_TROOP_GAP_GRAY_TIPS, -1019, -1018, MessageRecord.MSG_TYPE_SHIELD_MSG, -1014, -1004, -1016, -1017, MessageRecord.MSG_TYPE_DISCUSS_UPGRADE_TO_GROUP_TIPS, MessageRecord.MSG_TYPE_STRUCT_TROOP_NOTIFICATION, MessageRecord.MSG_TYPE_QLINK_AP_CREATE_SUC_TIPS, MessageRecord.MSG_TYPE_RENEWAL_TAIL_TIP, MessageRecord.MSG_TYPE_QLINK_FILE_TIPS, -3010, MessageRecord.MSG_TYPE_OPERATE_TIPS, MessageRecord.MSG_TYPE_SOUGOU_INPUT_TIPS, MessageRecord.MSG_TYPE_RED_PACKET_TIPS, MessageRecord.MSG_TYPE_HONGBAO_KEYWORDS_TIPS, -5000, -5001, -1024, MessageRecord.MSG_TYPE_NEARBY_DATING_SAFETY_TIP, 1018, MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS, MessageRecord.MSG_TYPE_CONFIGURABLE_TAB_VISIBLE_GRAY_TIPS, -1012, MessageRecord.MSG_TYPE_SENSITIVE_MSG_MASK_TIPS, MessageRecord.MSG_TYPE_NEARBY_MARKET, MessageRecord.MSG_TYPE_QQWALLET_TIPS, MessageRecord.MSG_TYPE_HOMEWORK_PRAISE, MessageRecord.MSG_TYPE_VIP_KEYWORD, MessageRecord.MSG_TYPE_VIP_AIO_SEND_TIPS, MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS, MessageRecord.MSG_TYPE_UNITE_GRAY_HISTORY_INVI, MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI, MessageRecord.MSG_TYPE_CONFESS_NEWS, MessageRecord.MSG_TYPE_PL_NEWS, MessageRecord.MSG_TYPE_MEDAL_NEWS, MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC, MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC_RECEIVER, -4025, -4026, -4027, MessageRecord.MSG_TYPE_BIRTHDAY_NOTICE, MessageRecord.MSG_TYPE_QCIRCLE_NEWEST_FEED, -7010, -7009, -7011, -7012, -7013, -7015, -7016};
        f116569c = new String[]{AppConstants.LBS_HELLO_UIN, AppConstants.SAME_STATE_BOX_UIN, AppConstants.DATE_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN, AppConstants.DATE_SAY_HELLO_LIST_UIN, AppConstants.RECOMMEND_CONTACT_UIN, AppConstants.SYSTEM_MSG_UIN, AppConstants.CONFESS_UIN};
        f116570d = new int[]{0, 1000, 1004, 1020, 1006, 1001, 10002, 10004, 1009, 1003, 1005, 1008, 1023, 1021, 1022, 1024, 1025, 1010, AppConstants.VALUE.UIN_TYPE_DINGDONG_MSG_SESSION, 1044, 1045, 1046, 1032, 1033, 1034, 1036, 1038, 10007, 10008, 10010, 10011};
        f116571e = new int[]{-1004, -1001, -1002, MessageRecord.MSG_TYPE_SHIELD_MSG, -2006, -4001, 193, com.tencent.luggage.wxa.ci.a.CTRL_INDEX, 230, -4002, -4003, -4004, MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED, -1014, MessageRecord.MSG_TYPE_QQSTORY_LATEST_FEED, -4008, MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS, MessageRecord.MSG_TYPE_SPLIT_LINE_GRAY_TIPS, MessageRecord.MSG_TYPE_STRUCT_TROOP_NOTIFICATION, MessageRecord.MSG_TYPE_SYSTEM_STRUCT_MSG, MessageRecord.MSG_TYPE_TEXT_RECOMMEND_TROOP_BUSINESS, MessageRecord.MSG_TYPE_TEXT_RECOMMEND_TROOP, -4005, MessageRecord.MSG_TYPE_QLINK_FILE_TIPS, MessageRecord.MSG_TYPE_RENEWAL_TAIL_TIP, -3010, MessageRecord.MSG_TYPE_QLINK_AP_CREATE_SUC_TIPS, MessageRecord.MSG_TYPE_SINGLE_WAY_FRIEND_MSG, MessageRecord.MSG_TYPE_SINGLE_WAY_FRIEND_ADD_ALLOW_ALL_MSG, MessageRecord.MSG_TYPE_OPERATE_TIPS, MessageRecord.MSG_TYPE_SOUGOU_INPUT_TIPS, MessageRecord.MSG_TYPE_RED_PACKET_TIPS, MessageRecord.MSG_TYPE_HONGBAO_KEYWORDS_TIPS, -5000, MessageRecord.MSG_TYPE_MEETING_NOTIFY, -1017, 1018, MessageRecord.MSG_TYPE_DATE_FEED, MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS, -1026, MessageRecord.MSG_TYPE_UNCOMMONLY_USED_CONTACTS_CANCEL_SET, MessageRecord.MSG_TYPE_NEARBY_DATING_SAFETY_TIP, MessageRecord.MSG_TYPE_SPECIALCARE_TIPS, MessageRecord.MSG_TYPE_SENSITIVE_MSG_MASK_TIPS, MessageRecord.MSG_TYPE_NEARBY_MARKET, MessageRecord.MSG_TYPE_NEARBY_FLOWER_TIP, MessageRecord.MSG_TYPE_BAT_PROCESS_FILE, MessageRecord.MSG_TYPE_TIM_GUIDE, MessageRecord.MSG_TYPE_TIM_DOUFU_GUIDE, MessageRecord.MSG_TYPE_RECOMMAND_TIPS, MessageRecord.MSG_TYPE_TROOP_GAP_GRAY_TIPS, MessageRecord.MSG_TYPE_VIP_KEYWORD, MessageRecord.MSG_TYPE_VIP_AIO_SEND_TIPS, MessageRecord.MSG_TYPE_FOLD_MSG_GRAY_TIPS, -1013, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, MessageRecord.MSG_TYPE_UNITE_TAB_DB_INVI, MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI, MessageRecord.MSG_TYPE_PL_NEWS, MessageRecord.MSG_TYPE_MEDAL_NEWS, -2023, MessageRecord.MSG_TYPE_CONFESS_NEWS, MessageRecord.MSG_TYPE_MASTER_UIN_NAVIGATION, MessageRecord.MSG_TYPE_TIM_AIOMSG_TIPS, MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS, MessageRecord.MSG_TYPE_GRAY_DATALINE_TIM_TIPS, MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS_DL, MessageRecord.MSG_TYPE_BIRTHDAY_NOTICE, MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC_RECEIVER, -4026, -4027, MessageRecord.MSG_TYPE_QCIRCLE_NEWEST_FEED, -7010, -7009, -7011, -7012, -7013, -7015, -7016, MessageRecord.MSG_TYPE_TEXT_FRIEND_FEED, MessageRecord.MSG_TYPE_AIO_FOR_STORY_VIDEO, MessageRecord.MSG_TYPE_DISCUSS_TO_TROOP_TIP};
        f116572f = new String[]{AppConstants.KANDIAN_MERGE_UIN};
        f116573g = new int[]{MessageRecord.MSG_TYPE_TEXT_FRIEND_FEED, MessageRecord.MSG_TYPE_DATE_FEED, MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED, MessageRecord.MSG_TYPE_QQSTORY_LATEST_FEED, -2003, -2004, -2009, -1001, MessageRecord.MSG_TYPE_AIO_FOR_LOCATION_SHARE, MessageRecord.MSG_TYPE_SHIELD_MSG, -1013, MessageRecord.MSG_TYPE_TROOP_GAP_GRAY_TIPS, -1019, -1018, -1014, MessageRecord.MSG_TYPE_SOUGOU_INPUT_TIPS, MessageRecord.MSG_TYPE_HONGBAO_KEYWORDS_TIPS, -5000, -5001, -1024, MessageRecord.MSG_TYPE_NEARBY_DATING_SAFETY_TIP, MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS, MessageRecord.MSG_TYPE_CONFIGURABLE_TAB_VISIBLE_GRAY_TIPS, MessageRecord.MSG_TYPE_SPECIALCARE_TIPS, MessageRecord.MSG_TYPE_SENSITIVE_MSG_MASK_TIPS, MessageRecord.MSG_TYPE_NEARBY_MARKET, MessageRecord.MSG_TYPE_NEARBY_FLOWER_TIP, MessageRecord.MSG_TYPE_MEETING_NOTIFY, MessageRecord.MSG_TYPE_NEARBY_RECOMMENDER, MessageRecord.MSG_TYPE_SPLIT_LINE_GRAY_TIPS, MessageRecord.MSG_TYPE_QQWALLET_TIPS, MessageRecord.MSG_TYPE_DING_DONG_GRAY_TIPS, MessageRecord.MSG_TYPE_SHARE_HOT_CHAT_GRAY_TIPS, MessageRecord.MSG_TYPE_APPROVAL_GRAY_TIPS, MessageRecord.MSG_TYPE_PL_NEWS, MessageRecord.MSG_TYPE_MEDAL_NEWS, MessageRecord.MSG_TYPE_CONFESS_NEWS, MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS, MessageRecord.MSG_TYPE_CONFESS_CARD, MessageRecord.MSG_TYPE_TIM_AIOMSG_TIPS, MessageRecord.MSG_TYPE_BIRTHDAY_NOTICE, -7010, -7009, -7011, -7012, -7015};
        f116574h = new int[]{-4004, -4003, MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS, MessageRecord.MSG_TYPE_RENEWAL_TAIL_TIP, -3010, MessageRecord.MSG_TYPE_QLINK_AP_CREATE_SUC_TIPS, MessageRecord.MSG_TYPE_RED_PACKET_TIPS, MessageRecord.MSG_TYPE_SPECIALCARE_TIPS, MessageRecord.MSG_TYPE_VIP_KEYWORD, MessageRecord.MSG_TYPE_VIP_AIO_SEND_TIPS, MessageRecord.MSG_TYPE_FOLD_MSG_GRAY_TIPS, MessageRecord.MSG_TYPE_TIM_GUIDE, MessageRecord.MSG_TYPE_MASTER_UIN_NAVIGATION, MessageRecord.MSG_TYPE_LIMIT_CHAT_CONFIRM, MessageRecord.MSG_TYPE_UNITE_TAB_DB_INVI, -7013};
        f116575i = new int[0];
        f116576j = new int[0];
        f116577k = new int[]{1008};
    }

    public static boolean A(String str) {
        return AppConstants.MSG_BOX_MYMOMMENT_UIN.equals(str);
    }

    public static boolean B(MessageRecord messageRecord) {
        if ((messageRecord.extLong & 1) == 1 && !TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("one_way"))) {
            return true;
        }
        return false;
    }

    public static boolean C(int i3) {
        for (int i16 : f116573g) {
            if (i16 == i3) {
                return false;
            }
        }
        return true;
    }

    public static boolean D(MessageRecord messageRecord, MessageRecord messageRecord2) {
        if (messageRecord.isLongMsg() && messageRecord2.isLongMsg() && messageRecord.longMsgId == messageRecord2.longMsgId && messageRecord.longMsgCount == messageRecord2.longMsgCount && TextUtils.equals(messageRecord.senderuin, messageRecord2.senderuin) && Math.abs(messageRecord.time - messageRecord2.time) <= 480) {
            return true;
        }
        return false;
    }

    public static boolean E(String str, String str2, int i3, int i16) {
        if (!p(i3) && !p(i16)) {
            return TextUtils.equals(str, str2);
        }
        if (i3 == i16 && TextUtils.equals(str, str2)) {
            return true;
        }
        return false;
    }

    public static boolean F(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(str) && !AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean G(int i3) {
        int[] iArr = f116575i;
        if (iArr.length == 0) {
            return false;
        }
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean H(int i3) {
        if (i3 != 1001 && i3 != 10002) {
            return false;
        }
        return true;
    }

    public static boolean I(String str) {
        for (String str2 : f116569c) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static List<MessageRecord> a(List<MessageRecord> list, List<MessageRecord> list2) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (list != null && list2 != null) {
            for (MessageRecord messageRecord : list2) {
                Iterator<MessageRecord> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        MessageRecord next = it.next();
                        if (messageRecord.getId() == messageRecord.getId() && messageRecord.shmsgseq == next.shmsgseq && messageRecord.msgtype == next.msgtype && messageRecord.time == next.time && messageRecord.msgUid == next.msgUid && messageRecord.longMsgIndex == next.longMsgIndex && messageRecord.longMsgId == next.longMsgId) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    arrayList.add(messageRecord);
                }
            }
            return arrayList;
        }
        return null;
    }

    public static List<MessageRecord> b(List<MessageRecord> list) {
        int i3;
        ArrayList arrayList = new ArrayList();
        for (MessageRecord messageRecord : list) {
            if (!s(messageRecord.msgtype) && (((i3 = messageRecord.istroop) != 3000 && i3 != 1) || messageRecord.shmsgseq > 0)) {
                arrayList.add(messageRecord);
            }
        }
        return arrayList;
    }

    public static int c(int i3) {
        int i16 = 1001;
        if (i3 != 1001 && i3 != 10002) {
            i16 = 1009;
            if (i3 != 1009) {
                i16 = 1010;
                if (i3 != 1010) {
                    i16 = 1044;
                    if (i3 != 1044 && i3 != 1045) {
                        switch (i3) {
                            case 1032:
                            case 1033:
                            case 1034:
                                return 1032;
                            default:
                                return i3;
                        }
                    }
                }
            }
        }
        return i16;
    }

    public static String d(MessageRecord messageRecord) {
        int i3 = messageRecord.istroop;
        int i16 = 1034;
        if (i3 == 1032) {
            if (messageRecord.isSelfConfessor()) {
                i16 = 1033;
            }
            return e(messageRecord.senderuin, i16, messageRecord.getConfessTopicId());
        }
        if (i3 != 1033 && i3 != 1034) {
            return messageRecord.senderuin;
        }
        return e(messageRecord.frienduin, i3, messageRecord.getConfessTopicId());
    }

    public static String e(String str, int i3, int i16) {
        return str + ContainerUtils.FIELD_DELIMITER + i3 + ContainerUtils.FIELD_DELIMITER + i16;
    }

    public static String f(String str, int i3) {
        if (p(i3)) {
            return str + ContainerUtils.FIELD_DELIMITER + i3;
        }
        if (str == null) {
            return "0";
        }
        return str;
    }

    public static String g(MessageRecord messageRecord) {
        return messageRecord.longMsgId + ContainerUtils.FIELD_DELIMITER + messageRecord.senderuin + ContainerUtils.FIELD_DELIMITER + messageRecord.longMsgCount;
    }

    public static String h() {
        StringBuilder sb5 = new StringBuilder(f116568b.length * 8);
        sb5.append("not in (");
        int i3 = 0;
        while (true) {
            int[] iArr = f116568b;
            if (i3 < iArr.length) {
                sb5.append(iArr[i3]);
                if (i3 == iArr.length - 1) {
                    sb5.append(")");
                } else {
                    sb5.append(",");
                }
                i3++;
            } else {
                return sb5.toString();
            }
        }
    }

    public static String i() {
        StringBuilder sb5 = new StringBuilder(f116573g.length * 8);
        sb5.append("not in (");
        int i3 = 0;
        while (true) {
            int[] iArr = f116573g;
            if (i3 < iArr.length) {
                sb5.append(iArr[i3]);
                if (i3 == iArr.length - 1) {
                    sb5.append(")");
                } else {
                    sb5.append(",");
                }
                i3++;
            } else {
                return sb5.toString();
            }
        }
    }

    public static String j() {
        int[] iArr = f116576j;
        if (iArr.length == 0) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(iArr.length * 8);
        sb5.append("not in (");
        int i3 = 0;
        while (true) {
            int[] iArr2 = f116576j;
            if (i3 < iArr2.length) {
                sb5.append(iArr2[i3]);
                if (i3 == iArr2.length - 1) {
                    sb5.append(")");
                } else {
                    sb5.append(",");
                }
                i3++;
            } else {
                return sb5.toString();
            }
        }
    }

    public static String k() {
        StringBuilder sb5 = new StringBuilder(f116571e.length * 8);
        sb5.append("not in (");
        int i3 = 0;
        while (true) {
            int[] iArr = f116571e;
            if (i3 < iArr.length) {
                sb5.append(iArr[i3]);
                if (i3 == iArr.length - 1) {
                    sb5.append(")");
                } else {
                    sb5.append(",");
                }
                i3++;
            } else {
                return sb5.toString();
            }
        }
    }

    public static String l(String str, int i3) {
        return str + ContainerUtils.FIELD_DELIMITER + i3;
    }

    public static boolean m(String str, int i3, List<MessageRecord> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        HashMap hashMap = new HashMap();
        int i16 = 0;
        for (MessageRecord messageRecord : list) {
            if (messageRecord.isLongMsg()) {
                String g16 = g(messageRecord);
                if (hashMap.containsKey(g16)) {
                    if (Math.abs(((MessageRecord) ((ArrayList) hashMap.get(g16)).get(0)).time - messageRecord.time) <= 480) {
                        ((ArrayList) hashMap.get(g16)).add(messageRecord);
                    } else {
                        i16++;
                        hashMap.put(l(g16, i16), (ArrayList) hashMap.get(g16));
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(messageRecord);
                        hashMap.put(g16, arrayList);
                    }
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(messageRecord);
                    hashMap.put(g16, arrayList2);
                }
            }
        }
        if (hashMap.isEmpty()) {
            return false;
        }
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get((String) it.next());
            if (!arrayList3.isEmpty() && ((MessageRecord) arrayList3.get(0)).longMsgCount > arrayList3.size() && !((MessageRecord) arrayList3.get(0)).isSendFromLocal()) {
                return true;
            }
        }
        return false;
    }

    public static boolean n(int i3) {
        int[] iArr = f116577k;
        if (iArr.length == 0) {
            return false;
        }
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean o(List<MessageRecord> list) {
        int i3;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (MessageRecord messageRecord : list) {
            if (messageRecord != null && (i3 = messageRecord.msgtype) != -2006 && i3 != -2058) {
                return false;
            }
        }
        return true;
    }

    public static boolean p(int i3) {
        for (int i16 : f116567a) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean q(int i3) {
        if (c(i3) != 1001 && c(i3) != 10002 && c(i3) != 1009 && c(i3) != 1010 && c(i3) != 1032) {
            return false;
        }
        return true;
    }

    public static boolean r(int i3) {
        for (int i16 : f116570d) {
            if (i16 == i3) {
                return true;
            }
        }
        UinType valueOf = UinType.valueOf(i3);
        if (valueOf == null) {
            return false;
        }
        return valueOf.isC2CConversation();
    }

    public static boolean s(int i3) {
        for (int i16 : f116574h) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean t(int i3, String str) {
        if (str == null) {
            return false;
        }
        Long l3 = 0L;
        if (!str.equals("")) {
            try {
                l3 = Long.valueOf(str);
            } catch (Exception unused) {
                l3 = 0L;
            }
        }
        if ((i3 != 0 && i3 != 1 && i3 != 3000 && i3 != 1008 && i3 != 1000 && i3 != 1001 && i3 != 1004 && i3 != 1022 && i3 != 1006 && i3 != 1024 && i3 != 1025 && i3 != 10007 && i3 != 10008 && i3 != 1046 && i3 != 1038 && i3 != 10019 && i3 != 1005) || str.equals(AppConstants.REMINDER_UIN) || str.equals(AppConstants.DATALINE_NEW_VERSION_UIN) || l3.longValue() <= 10000) {
            return false;
        }
        return true;
    }

    public static boolean u(int i3) {
        if (i3 == 3000 || i3 == 1 || i3 == 1026) {
            return true;
        }
        return false;
    }

    public static boolean v(int i3) {
        if (i3 == 10014) {
            return true;
        }
        return false;
    }

    public static boolean w(String str) {
        if (!AppConstants.MSG_BOX_INTERACT_UIN.equals(str) && !AppConstants.MSG_BOX_FOLLOW_UIN.equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean x(int i3) {
        if (i3 == -2006) {
            return true;
        }
        return false;
    }

    public static boolean y(int i3) {
        int[] iArr = f116576j;
        if (iArr.length == 0) {
            return false;
        }
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean z(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (((c(i3) != 1001 && c(i3) != 10002) || !AppConstants.LBS_HELLO_UIN.equals(str)) && (((c(i3) != 1001 && c(i3) != 10002) || !AppConstants.NEARBY_LBS_HELLO_UIN.equals(str)) && ((c(i3) != 1009 || !AppConstants.SAME_STATE_BOX_UIN.equals(str)) && ((c(i3) != 1010 || !AppConstants.DATE_UIN.equals(str)) && ((c(i3) != 1001 || !AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(str)) && ((c(i3) != 1010 || !AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(str)) && ((c(i3) != 1010 || !AppConstants.LBS_HELLO_UIN.equals(str)) && ((c(i3) != 1010 || !AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(str)) && ((c(i3) != 1032 || !AppConstants.CONFESS_UIN.equals(str)) && ((c(i3) != 1044 || !AppConstants.MATCH_CHAT_UIN.equals(str)) && (c(i3) != 10008 || !AppConstants.QCIRCLE_CHAT_UIN.equals(str)))))))))))) {
            return false;
        }
        return true;
    }
}
