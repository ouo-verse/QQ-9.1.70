package com.tencent.mobileqq.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForGrayTips extends ChatMessage {
    public static final int ABILITY_SUPPORT_COLOR = 2;
    public static final int ABILITY_SUPPORT_IMAGE = 1;
    private static final String KEY_NEW_HIGHTLIGHT_ITEM_TAG = "new_item_tag";
    public static final String KEY_TROOP_NEW_MEMBER_UIN = "troop_new_member_uin";
    private static final String TAG = "MessageForGrayTips";
    private static final com.tencent.mobileqq.graytip.c sTipsProxy = new com.tencent.mobileqq.graytip.c();

    public static String getOrginMsg(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("                    ##**##");
        if (indexOf == -1) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x01aa A[Catch: Exception -> 0x02c1, TRY_ENTER, TryCatch #0 {Exception -> 0x02c1, blocks: (B:12:0x0047, B:14:0x004d, B:15:0x0062, B:32:0x00a7, B:33:0x00bf, B:34:0x00d7, B:35:0x0190, B:38:0x01aa, B:40:0x01ce, B:41:0x01f0, B:43:0x0204, B:44:0x0226, B:46:0x0231, B:48:0x024e, B:50:0x02a2, B:52:0x02a6, B:56:0x0217, B:57:0x01e1, B:58:0x01bd, B:59:0x00ef, B:60:0x010a, B:63:0x011a, B:64:0x012d, B:65:0x0144, B:68:0x0154, B:70:0x016d, B:72:0x002b), top: B:71:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ce A[Catch: Exception -> 0x02c1, TryCatch #0 {Exception -> 0x02c1, blocks: (B:12:0x0047, B:14:0x004d, B:15:0x0062, B:32:0x00a7, B:33:0x00bf, B:34:0x00d7, B:35:0x0190, B:38:0x01aa, B:40:0x01ce, B:41:0x01f0, B:43:0x0204, B:44:0x0226, B:46:0x0231, B:48:0x024e, B:50:0x02a2, B:52:0x02a6, B:56:0x0217, B:57:0x01e1, B:58:0x01bd, B:59:0x00ef, B:60:0x010a, B:63:0x011a, B:64:0x012d, B:65:0x0144, B:68:0x0154, B:70:0x016d, B:72:0x002b), top: B:71:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0204 A[Catch: Exception -> 0x02c1, TryCatch #0 {Exception -> 0x02c1, blocks: (B:12:0x0047, B:14:0x004d, B:15:0x0062, B:32:0x00a7, B:33:0x00bf, B:34:0x00d7, B:35:0x0190, B:38:0x01aa, B:40:0x01ce, B:41:0x01f0, B:43:0x0204, B:44:0x0226, B:46:0x0231, B:48:0x024e, B:50:0x02a2, B:52:0x02a6, B:56:0x0217, B:57:0x01e1, B:58:0x01bd, B:59:0x00ef, B:60:0x010a, B:63:0x011a, B:64:0x012d, B:65:0x0144, B:68:0x0154, B:70:0x016d, B:72:0x002b), top: B:71:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0231 A[Catch: Exception -> 0x02c1, TryCatch #0 {Exception -> 0x02c1, blocks: (B:12:0x0047, B:14:0x004d, B:15:0x0062, B:32:0x00a7, B:33:0x00bf, B:34:0x00d7, B:35:0x0190, B:38:0x01aa, B:40:0x01ce, B:41:0x01f0, B:43:0x0204, B:44:0x0226, B:46:0x0231, B:48:0x024e, B:50:0x02a2, B:52:0x02a6, B:56:0x0217, B:57:0x01e1, B:58:0x01bd, B:59:0x00ef, B:60:0x010a, B:63:0x011a, B:64:0x012d, B:65:0x0144, B:68:0x0154, B:70:0x016d, B:72:0x002b), top: B:71:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x024e A[Catch: Exception -> 0x02c1, TryCatch #0 {Exception -> 0x02c1, blocks: (B:12:0x0047, B:14:0x004d, B:15:0x0062, B:32:0x00a7, B:33:0x00bf, B:34:0x00d7, B:35:0x0190, B:38:0x01aa, B:40:0x01ce, B:41:0x01f0, B:43:0x0204, B:44:0x0226, B:46:0x0231, B:48:0x024e, B:50:0x02a2, B:52:0x02a6, B:56:0x0217, B:57:0x01e1, B:58:0x01bd, B:59:0x00ef, B:60:0x010a, B:63:0x011a, B:64:0x012d, B:65:0x0144, B:68:0x0154, B:70:0x016d, B:72:0x002b), top: B:71:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0217 A[Catch: Exception -> 0x02c1, TryCatch #0 {Exception -> 0x02c1, blocks: (B:12:0x0047, B:14:0x004d, B:15:0x0062, B:32:0x00a7, B:33:0x00bf, B:34:0x00d7, B:35:0x0190, B:38:0x01aa, B:40:0x01ce, B:41:0x01f0, B:43:0x0204, B:44:0x0226, B:46:0x0231, B:48:0x024e, B:50:0x02a2, B:52:0x02a6, B:56:0x0217, B:57:0x01e1, B:58:0x01bd, B:59:0x00ef, B:60:0x010a, B:63:0x011a, B:64:0x012d, B:65:0x0144, B:68:0x0154, B:70:0x016d, B:72:0x002b), top: B:71:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e1 A[Catch: Exception -> 0x02c1, TryCatch #0 {Exception -> 0x02c1, blocks: (B:12:0x0047, B:14:0x004d, B:15:0x0062, B:32:0x00a7, B:33:0x00bf, B:34:0x00d7, B:35:0x0190, B:38:0x01aa, B:40:0x01ce, B:41:0x01f0, B:43:0x0204, B:44:0x0226, B:46:0x0231, B:48:0x024e, B:50:0x02a2, B:52:0x02a6, B:56:0x0217, B:57:0x01e1, B:58:0x01bd, B:59:0x00ef, B:60:0x010a, B:63:0x011a, B:64:0x012d, B:65:0x0144, B:68:0x0154, B:70:0x016d, B:72:0x002b), top: B:71:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bd A[Catch: Exception -> 0x02c1, TryCatch #0 {Exception -> 0x02c1, blocks: (B:12:0x0047, B:14:0x004d, B:15:0x0062, B:32:0x00a7, B:33:0x00bf, B:34:0x00d7, B:35:0x0190, B:38:0x01aa, B:40:0x01ce, B:41:0x01f0, B:43:0x0204, B:44:0x0226, B:46:0x0231, B:48:0x024e, B:50:0x02a2, B:52:0x02a6, B:56:0x0217, B:57:0x01e1, B:58:0x01bd, B:59:0x00ef, B:60:0x010a, B:63:0x011a, B:64:0x012d, B:65:0x0144, B:68:0x0154, B:70:0x016d, B:72:0x002b), top: B:71:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addHightlightItem(int i3, int i16, Bundle bundle) {
        int i17;
        String string;
        String string2;
        String string3;
        String str;
        String str2;
        String str3;
        int indexOf;
        int i18;
        if (i3 >= i16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "revoke msg addHightlightItem start >= end error");
                return;
            }
            return;
        }
        saveExtInfoToExtStr(KEY_NEW_HIGHTLIGHT_ITEM_TAG, Boolean.TRUE.toString());
        if (bundle == null) {
            string = null;
            string2 = null;
            string3 = null;
            i17 = -1;
        } else {
            try {
                i17 = bundle.getInt("key_action");
                string = bundle.getString("textColor");
                string2 = bundle.getString("image_resource");
                string3 = bundle.getString("image_alt");
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addHightlightItem ==>actionType:" + i17);
        }
        String str4 = "," + i17 + "," + i3 + "," + i16;
        if (i17 != 1 && i17 != 2 && i17 != 3) {
            if (i17 != 5) {
                if (i17 != 26) {
                    if (i17 != 28) {
                        if (i17 != 43) {
                            if (i17 != 74) {
                                switch (i17) {
                                    case 13:
                                        break;
                                    case 14:
                                        str4 = str4 + "," + bundle.getInt("group_id", -1);
                                        break;
                                    case 15:
                                        break;
                                    default:
                                        switch (i17) {
                                            case 18:
                                                str4 = str4 + "," + bundle.getString("key_action_DATA");
                                                break;
                                            case 19:
                                                str4 = str4 + "," + bundle.getString("troop_mem_uin");
                                                break;
                                            case 20:
                                                str4 = str4 + "," + bundle.getString("key_action_DATA");
                                                break;
                                        }
                                }
                            }
                        }
                        String string4 = bundle.getString("remark");
                        if (TextUtils.isEmpty(string4)) {
                            string4 = "";
                        }
                        str4 = str4 + "," + string4;
                    }
                } else {
                    str4 = str4 + "," + bundle.getString("key_action_DATA");
                }
                String str5 = str4 + ",icon";
                if (string2 != null) {
                    str = str5 + ",1," + string2;
                } else {
                    str = str5 + ",0";
                }
                if (string3 != null) {
                    str2 = str + ",1," + string3;
                } else {
                    str2 = str + ",0";
                }
                String str6 = str2 + ",color";
                if (string != null) {
                    str3 = str6 + ",1," + string;
                } else {
                    str3 = str6 + ",0";
                }
                indexOf = this.f203106msg.indexOf("                    ##**##");
                if (indexOf == -1) {
                    this.f203106msg += "                    ##**##1" + str3;
                    return;
                }
                String substring = this.f203106msg.substring(0, indexOf);
                String str7 = this.f203106msg;
                String substring2 = str7.substring(indexOf + 26, str7.length());
                int indexOf2 = substring2.indexOf(44);
                String substring3 = substring2.substring(0, indexOf2);
                String substring4 = substring2.substring(indexOf2, substring2.length());
                this.f203106msg = substring + "                    ##**##" + ((Integer.parseInt(substring3) + 1) + substring4 + str3);
                if (QLog.isColorLevel() && (this instanceof MessageForDeliverGiftTips)) {
                    QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "MessageForGrayTips.addHightlightItem:" + this.f203106msg);
                    return;
                }
                return;
            }
            String string5 = bundle.getString("troop_mem_uin");
            if (bundle.getBoolean("need_update_nick")) {
                i18 = 1;
            } else {
                i18 = 0;
            }
            str4 = str4 + "," + i18 + "," + string5;
            String str52 = str4 + ",icon";
            if (string2 != null) {
            }
            if (string3 != null) {
            }
            String str62 = str2 + ",color";
            if (string != null) {
            }
            indexOf = this.f203106msg.indexOf("                    ##**##");
            if (indexOf == -1) {
            }
        }
        str4 = str4 + "," + bundle.getString("key_action_DATA") + "," + bundle.getString("key_a_action_DATA");
        String str522 = str4 + ",icon";
        if (string2 != null) {
        }
        if (string3 != null) {
        }
        String str622 = str2 + ",color";
        if (string != null) {
        }
        indexOf = this.f203106msg.indexOf("                    ##**##");
        if (indexOf == -1) {
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean needShowTimeStamp() {
        if (this.msgtype == -7091) {
            return false;
        }
        return super.needShowTimeStamp();
    }

    public void setTextGravity(int i3) {
        saveExtInfoToExtStr("textGravity", "" + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
    }

    public void switch2HightlightMsg() {
    }
}
