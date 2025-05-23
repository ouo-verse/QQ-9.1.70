package com.tencent.mobileqq.service.message;

import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.bo;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes18.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<Integer> f286332a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<Integer> f286333b;

    /* renamed from: c, reason: collision with root package name */
    public static final short[] f286334c;

    /* renamed from: d, reason: collision with root package name */
    public static final short[] f286335d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f286332a = new ArrayList<>(Arrays.asList(-1002, -1001, -1004, Integer.valueOf(MessageRecord.MSG_TYPE_TEXT_GROUP_CREATED), -1013, Integer.valueOf(MessageRecord.MSG_TYPE_TROOP_GAP_GRAY_TIPS), -1019, -1018, -4000, -4001, Integer.valueOf(MessageRecord.MSG_TYPE_ONLINE_FILE_REQ), -1012, Integer.valueOf(MessageRecord.MSG_TYPE_SHIELD_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_FAILED_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_FILE_RECEIPT), Integer.valueOf(MessageRecord.MSG_TYPE_QLINK_FILE_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_RENEWAL_TAIL_TIP), -3010, Integer.valueOf(MessageRecord.MSG_TYPE_BAT_PROCESS_FILE), Integer.valueOf(MessageRecord.MSG_TYPE_TIM_GUIDE), Integer.valueOf(MessageRecord.MSG_TYPE_QLINK_AP_CREATE_SUC_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED), Integer.valueOf(MessageRecord.MSG_TYPE_QQSTORY_LATEST_FEED), -4008, -4002, -4003, -4005, -1014, -1016, -1017, Integer.valueOf(MessageRecord.MSG_TYPE_DISCUSS_UPGRADE_TO_GROUP_TIPS), -4004, Integer.valueOf(MessageRecord.MSG_TYPE_SINGLE_WAY_FRIEND_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_SINGLE_WAY_FRIEND_ADD_ALLOW_ALL_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_OPERATE_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_SOUGOU_INPUT_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_RED_PACKET_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_HONGBAO_KEYWORDS_TIPS), -5000, -5001, 1018, Integer.valueOf(MessageRecord.MSG_TYPE_SHARE_LBS_PUSH), -1024, Integer.valueOf(MessageRecord.MSG_TYPE_NEARBY_DATING_SAFETY_TIP), Integer.valueOf(MessageRecord.MSG_TYPE_INCOMPATIBLE_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_CONFIGURABLE_TAB_VISIBLE_GRAY_TIPS), -1026, Integer.valueOf(MessageRecord.MSG_TYPE_UNCOMMONLY_USED_CONTACTS_CANCEL_SET), Integer.valueOf(MessageRecord.MSG_TYPE_SPECIALCARE_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_SENSITIVE_MSG_MASK_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_NEARBY_MARKET), Integer.valueOf(MessageRecord.MSG_TYPE_NEARBY_FLOWER_TIP), Integer.valueOf(MessageRecord.MSG_TYPE_DEVICE_OPENGROUPCHAT), Integer.valueOf(MessageRecord.MSG_TYPE_DEVICE_CLOSEGROUPCHAT), Integer.valueOf(MessageRecord.MSG_TYPE_DEVICE_DISMISSBIND), Integer.valueOf(MessageRecord.MSG_TYPE_NEARBY_RECOMMENDER), Integer.valueOf(MessageRecord.MSG_TYPE_MEETING_NOTIFY), Integer.valueOf(MessageRecord.MSG_TYPE_RECOMMAND_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_QQWALLET_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_REVOKE_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_SHARE_HOT_CHAT_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_DING_DONG_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_PA_PHONE_MSG_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_APPROVAL_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_HOMEWORK_PRAISE), Integer.valueOf(MessageRecord.MSG_TYPE_VIP_KEYWORD), Integer.valueOf(MessageRecord.MSG_TYPE_VIP_AIO_SEND_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_FOLD_MSG_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_SPLIT_LINE_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_PL_NEWS), Integer.valueOf(MessageRecord.MSG_TYPE_MEDAL_NEWS), Integer.valueOf(MessageRecord.MSG_TYPE_CONFESS_NEWS), Integer.valueOf(MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_TIM_AIOMSG_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC), Integer.valueOf(MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC_RECEIVER), -4025, -4026, Integer.valueOf(MessageRecord.MSG_TYPE_QCIRCLE_NEWEST_FEED), -7010, -7009, -7011, -7012, -7013, -7015, -4027, Integer.valueOf(MessageRecord.MSG_TYPE_GUILD_REVOKE_GRAY_TIP), Integer.valueOf(MessageRecord.MSG_TYPE_GUILD_ROBOT_BLACK_GRAY), Integer.valueOf(MessageRecord.MSG_TYPE_GUILD_SUBSCRIBE_CHANNEL_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_GUILD_MSG_NOTIFY_SETTING_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_GUILD_ROBOT_DIRECT_MSG_LIMIT_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_DISCUSS_TO_TROOP_TIP)));
        f286333b = new ArrayList<>(Arrays.asList(-1002, -1001, -1004, -4000, -4001, Integer.valueOf(MessageRecord.MSG_TYPE_ONLINE_FILE_REQ), -1012, Integer.valueOf(MessageRecord.MSG_TYPE_SHIELD_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_FAILED_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_FILE_RECEIPT), Integer.valueOf(MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED), Integer.valueOf(MessageRecord.MSG_TYPE_QQSTORY_LATEST_FEED), -4002, -4003, -4004, Integer.valueOf(MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_STRUCT_TROOP_NOTIFICATION), -5000, -5001, Integer.valueOf(MessageRecord.MSG_TYPE_DING_DONG_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_SHARE_HOT_CHAT_GRAY_TIPS), -1016, Integer.valueOf(MessageRecord.MSG_TYPE_PL_NEWS), Integer.valueOf(MessageRecord.MSG_TYPE_MEDAL_NEWS), Integer.valueOf(MessageRecord.MSG_TYPE_CONFESS_NEWS), Integer.valueOf(MessageRecord.MSG_TYPE_CONFESS_CARD), Integer.valueOf(MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS), -2023, Integer.valueOf(MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_TIM_AIOMSG_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC), Integer.valueOf(MessageRecord.MSG_TYPE_LIMIT_CHAT_TOPIC_RECEIVER), -4025, -4026, Integer.valueOf(MessageRecord.MSG_TYPE_BIRTHDAY_NOTICE), Integer.valueOf(MessageRecord.MSG_TYPE_SPLIT_LINE_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_QCIRCLE_NEWEST_FEED), -7010, -7009, -7011, -7012, -7013, -7015, -4027));
        f286334c = new short[]{13, 12, 27, 20, 39, 38, 97, 46, 63, 5, 9, 33, 16, 18, 106, 59, 55, 112, 21, 2, 6, 4, 19, 14, 11, 10, 26, 96, 66, 116, 22, 23, 15, 0, 32, 8, 109, 28, 42, 36, 1, 108, 30, 3, 103, 49, 101, 85, 105, 34, 29, 111, 76, 77, 78, 79, 118, 64, 61, 53, 89, 113, 117, 119, 124, 122, 60, 50, 75, 81, 56, 41, 121, 120, 67, 74, 69, 57, 37, 129, 54, 24, 25, 31, 35, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 43, 86, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9};
        f286335d = new short[]{33, 40, 19, 43, 21, 9, 20, 106, 35, 250, 25, 24, 1, 0, 23, 32, 12, -1, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, -1, 71, 38, 95, -1, -1, 7, -1, -1, 45, 67, -1, -1, 59, 80, 16, 70, 77, -1, 15, 66, 58, -1, 8, 57, -1, 28, 74, -1, 76, -1, -1, -1, -1, 75, 68, 52, 53, 54, 55, -1, 69, -1, -1, -1, 47, 96, -1, -1, 60, -1, -1, -1, -1, -1, -1, 27, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 61, 92, 93, 29, 62, 56, 63, 73, 72, 65, 94, 64, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219};
    }

    public static int a() {
        return Math.abs(new Random().nextInt());
    }

    public static long b(long j3, int i3) {
        if (ao.r(i3)) {
            return (short) j3;
        }
        return 0L;
    }

    public static String c(String str, boolean z16) {
        return d(str, z16, null);
    }

    public static String d(String str, boolean z16, ArrayList<AtTroopMemberInfo> arrayList) {
        short s16;
        if (str == null) {
            return "";
        }
        char[] charArray = str.toCharArray();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i3 < charArray.length) {
            AtTroopMemberInfo atTroopMemberInfo = null;
            if (arrayList != null) {
                while (true) {
                    if (i17 < arrayList.size()) {
                        AtTroopMemberInfo atTroopMemberInfo2 = arrayList.get(i17);
                        if (atTroopMemberInfo2 != null && atTroopMemberInfo2.isValid()) {
                            atTroopMemberInfo = atTroopMemberInfo2;
                            break;
                        }
                        i17++;
                    } else {
                        break;
                    }
                }
            }
            if (atTroopMemberInfo != null && (s16 = atTroopMemberInfo.startPos) <= i3) {
                if (s16 == i3) {
                    i18 = i16;
                }
                short s17 = atTroopMemberInfo.textLen;
                if (i3 < s16 + s17) {
                    if (charArray[i3] == 20) {
                        i19 -= 2;
                        i16 -= 2;
                        i3++;
                        i3++;
                    }
                } else {
                    atTroopMemberInfo.startPos = (short) (s16 + i18);
                    atTroopMemberInfo.textLen = (short) (s17 + i19);
                    i17++;
                    i18 = 0;
                    i19 = 0;
                }
            }
            char c16 = charArray[i3];
            if (c16 == '\r' && (!z16 || i3 <= 0 || charArray[i3 - 1] != 20)) {
                charArray[i3 + i16] = '\n';
                int i26 = i3 + 1;
                if (i26 < charArray.length && charArray[i26] == '\n') {
                    i16--;
                    i3 = i26;
                }
            } else if (i16 != 0) {
                charArray[i3 + i16] = c16;
            }
            i3++;
        }
        return new String(charArray, 0, charArray.length + i16);
    }

    public static int e(long j3) {
        return (int) (j3 & (-1));
    }

    public static long f(int i3) {
        return 72057594037927936L | i3;
    }

    public static int g(long j3) {
        return (int) (j3 & (-1));
    }

    public static boolean h(MessageRecord messageRecord) {
        if (messageRecord.msgtype != -1000) {
            return false;
        }
        String str = messageRecord.f203106msg;
        if (str != null && str.length() != 0 && (messageRecord.f203106msg.trim().length() != 0 || messageRecord.f203106msg.charAt(0) == 20)) {
            return false;
        }
        return true;
    }

    public static boolean i(int i3) {
        if (i3 != 9 && i3 != 10 && i3 != 31 && i3 != 79 && i3 != 97 && i3 != 120 && i3 != 132 && i3 != 133 && i3 != 166 && i3 != 167) {
            return false;
        }
        return true;
    }

    public static boolean j(int i3) {
        return f286332a.contains(Integer.valueOf(i3));
    }

    public static boolean k(String str, int i3) {
        String lowerCase = str.toLowerCase();
        if (i3 != 0) {
            if (lowerCase.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) || lowerCase.endsWith(".png") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".bmp")) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean l(String str, int i3) {
        String lowerCase = str.toLowerCase();
        if (i3 != 0 && lowerCase.endsWith(".amr")) {
            return true;
        }
        return false;
    }

    public static String[] m(String str) {
        String group;
        int i3;
        String[] strArr = new String[3];
        int indexOf = str.indexOf(bo.f307494a.a());
        if (indexOf >= 0) {
            String substring = str.substring(indexOf);
            Matcher matcher = Pattern.compile("\\s*(loc:)?-?\\d+(.\\d+)?\\s*,\\s*-?\\d+(.\\d+)?").matcher(substring);
            if (matcher.find()) {
                String group2 = matcher.group();
                if (group2 != null && group2.length() > 0) {
                    int indexOf2 = group2.indexOf(44);
                    int indexOf3 = group2.indexOf("loc:");
                    if (indexOf2 >= 0) {
                        if (indexOf3 >= 0) {
                            i3 = indexOf3 + 4;
                        } else {
                            i3 = 0;
                        }
                        strArr[0] = group2.substring(i3, indexOf2);
                        strArr[1] = group2.substring(indexOf2 + 1, group2.length());
                    }
                }
                Matcher matcher2 = Pattern.compile("\\(.+\\)").matcher(substring);
                if (matcher2.find() && (group = matcher2.group()) != null && group.length() > 2) {
                    strArr[2] = group.substring(1, group.length() - 1);
                }
            }
        }
        if (strArr[2] == null) {
            strArr[2] = "";
        }
        return strArr;
    }
}
