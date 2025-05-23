package com.tencent.mobileqq.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$FriendHelloInfo;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$FriendMiscInfo;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$GroupInfo;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$TongXunLuNickInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SystemMsg extends JceStruct {
    private static final String TAG = "Q.systemmsg.SystemMsg";
    public String append;
    public byte[] auth;
    public int cVession;
    public String inviteMemUin;
    public long lToMobile;
    public String managerUin;
    public String message;

    /* renamed from: op, reason: collision with root package name */
    public byte f203120op;
    public String requestUin;
    public String sMsg;
    public String strAddressBookNickName;
    public String strGroupName;
    public String strGroupNickName;
    public long strGroupUin;
    public String strNickName;
    public String troopCode;
    public byte troopType;
    public int wSourceID;
    public int wSourceSubID;
    public String strServerFromUinNickName = "";
    public String strGameName = "";

    /* JADX WARN: Failed to find 'out' block for switch in B:162:0x0559. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:163:0x055c. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0577 A[Catch: Exception -> 0x0a34, IOException -> 0x0a39, TRY_ENTER, TRY_LEAVE, TryCatch #22 {IOException -> 0x0a39, Exception -> 0x0a34, blocks: (B:4:0x0003, B:7:0x0012, B:151:0x0534, B:162:0x0559, B:163:0x055c, B:164:0x055f, B:166:0x056b, B:172:0x0577, B:220:0x0694, B:257:0x0755, B:292:0x081b, B:322:0x08e4, B:373:0x09f8, B:375:0x0a04, B:378:0x0a0d, B:380:0x0a19), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c A[Catch: Exception -> 0x052c, IOException -> 0x0530, TRY_ENTER, TryCatch #18 {IOException -> 0x0530, Exception -> 0x052c, blocks: (B:9:0x001b, B:18:0x007c, B:20:0x0080, B:23:0x0087, B:24:0x0092, B:26:0x0098, B:28:0x009e, B:30:0x00a2, B:32:0x00a8, B:33:0x00c9, B:34:0x00ed, B:36:0x00f1, B:38:0x00f7, B:39:0x011e, B:40:0x008a, B:41:0x0148, B:43:0x014f, B:45:0x0155, B:46:0x0173, B:47:0x0194, B:49:0x0198, B:52:0x01a3, B:53:0x01ae, B:55:0x01b7, B:57:0x01bd, B:58:0x01db, B:59:0x01a6, B:60:0x01fc, B:62:0x0200, B:65:0x0207, B:66:0x0212, B:73:0x0220, B:75:0x0227, B:77:0x022d, B:79:0x0231, B:81:0x0237, B:82:0x0258, B:83:0x027c, B:85:0x0280, B:87:0x0286, B:88:0x02ad, B:91:0x02da, B:93:0x02e1, B:95:0x02e7, B:97:0x02eb, B:99:0x02f1, B:100:0x0312, B:101:0x0336, B:103:0x033a, B:105:0x0340, B:106:0x0367, B:109:0x0394, B:111:0x0398, B:113:0x039e, B:115:0x03a2, B:117:0x03a8, B:118:0x0444, B:119:0x03c9, B:120:0x03ec, B:122:0x03f0, B:124:0x03f6, B:125:0x041c, B:126:0x0476, B:128:0x047d, B:130:0x0483, B:132:0x0487, B:134:0x048d, B:135:0x04ae, B:136:0x04d1, B:138:0x04d5, B:140:0x04db, B:141:0x0501, B:142:0x020a), top: B:8:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0694 A[Catch: Exception -> 0x0a34, IOException -> 0x0a39, TRY_ENTER, TRY_LEAVE, TryCatch #22 {IOException -> 0x0a39, Exception -> 0x0a34, blocks: (B:4:0x0003, B:7:0x0012, B:151:0x0534, B:162:0x0559, B:163:0x055c, B:164:0x055f, B:166:0x056b, B:172:0x0577, B:220:0x0694, B:257:0x0755, B:292:0x081b, B:322:0x08e4, B:373:0x09f8, B:375:0x0a04, B:378:0x0a0d, B:380:0x0a19), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0755 A[Catch: Exception -> 0x0a34, IOException -> 0x0a39, TRY_ENTER, TRY_LEAVE, TryCatch #22 {IOException -> 0x0a39, Exception -> 0x0a34, blocks: (B:4:0x0003, B:7:0x0012, B:151:0x0534, B:162:0x0559, B:163:0x055c, B:164:0x055f, B:166:0x056b, B:172:0x0577, B:220:0x0694, B:257:0x0755, B:292:0x081b, B:322:0x08e4, B:373:0x09f8, B:375:0x0a04, B:378:0x0a0d, B:380:0x0a19), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x081b A[Catch: Exception -> 0x0a34, IOException -> 0x0a39, TRY_ENTER, TRY_LEAVE, TryCatch #22 {IOException -> 0x0a39, Exception -> 0x0a34, blocks: (B:4:0x0003, B:7:0x0012, B:151:0x0534, B:162:0x0559, B:163:0x055c, B:164:0x055f, B:166:0x056b, B:172:0x0577, B:220:0x0694, B:257:0x0755, B:292:0x081b, B:322:0x08e4, B:373:0x09f8, B:375:0x0a04, B:378:0x0a0d, B:380:0x0a19), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x08e4 A[Catch: Exception -> 0x0a34, IOException -> 0x0a39, TRY_ENTER, TRY_LEAVE, TryCatch #22 {IOException -> 0x0a39, Exception -> 0x0a34, blocks: (B:4:0x0003, B:7:0x0012, B:151:0x0534, B:162:0x0559, B:163:0x055c, B:164:0x055f, B:166:0x056b, B:172:0x0577, B:220:0x0694, B:257:0x0755, B:292:0x081b, B:322:0x08e4, B:373:0x09f8, B:375:0x0a04, B:378:0x0a0d, B:380:0x0a19), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0148 A[Catch: Exception -> 0x052c, IOException -> 0x0530, TryCatch #18 {IOException -> 0x0530, Exception -> 0x052c, blocks: (B:9:0x001b, B:18:0x007c, B:20:0x0080, B:23:0x0087, B:24:0x0092, B:26:0x0098, B:28:0x009e, B:30:0x00a2, B:32:0x00a8, B:33:0x00c9, B:34:0x00ed, B:36:0x00f1, B:38:0x00f7, B:39:0x011e, B:40:0x008a, B:41:0x0148, B:43:0x014f, B:45:0x0155, B:46:0x0173, B:47:0x0194, B:49:0x0198, B:52:0x01a3, B:53:0x01ae, B:55:0x01b7, B:57:0x01bd, B:58:0x01db, B:59:0x01a6, B:60:0x01fc, B:62:0x0200, B:65:0x0207, B:66:0x0212, B:73:0x0220, B:75:0x0227, B:77:0x022d, B:79:0x0231, B:81:0x0237, B:82:0x0258, B:83:0x027c, B:85:0x0280, B:87:0x0286, B:88:0x02ad, B:91:0x02da, B:93:0x02e1, B:95:0x02e7, B:97:0x02eb, B:99:0x02f1, B:100:0x0312, B:101:0x0336, B:103:0x033a, B:105:0x0340, B:106:0x0367, B:109:0x0394, B:111:0x0398, B:113:0x039e, B:115:0x03a2, B:117:0x03a8, B:118:0x0444, B:119:0x03c9, B:120:0x03ec, B:122:0x03f0, B:124:0x03f6, B:125:0x041c, B:126:0x0476, B:128:0x047d, B:130:0x0483, B:132:0x0487, B:134:0x048d, B:135:0x04ae, B:136:0x04d1, B:138:0x04d5, B:140:0x04db, B:141:0x0501, B:142:0x020a), top: B:8:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0194 A[Catch: Exception -> 0x052c, IOException -> 0x0530, TryCatch #18 {IOException -> 0x0530, Exception -> 0x052c, blocks: (B:9:0x001b, B:18:0x007c, B:20:0x0080, B:23:0x0087, B:24:0x0092, B:26:0x0098, B:28:0x009e, B:30:0x00a2, B:32:0x00a8, B:33:0x00c9, B:34:0x00ed, B:36:0x00f1, B:38:0x00f7, B:39:0x011e, B:40:0x008a, B:41:0x0148, B:43:0x014f, B:45:0x0155, B:46:0x0173, B:47:0x0194, B:49:0x0198, B:52:0x01a3, B:53:0x01ae, B:55:0x01b7, B:57:0x01bd, B:58:0x01db, B:59:0x01a6, B:60:0x01fc, B:62:0x0200, B:65:0x0207, B:66:0x0212, B:73:0x0220, B:75:0x0227, B:77:0x022d, B:79:0x0231, B:81:0x0237, B:82:0x0258, B:83:0x027c, B:85:0x0280, B:87:0x0286, B:88:0x02ad, B:91:0x02da, B:93:0x02e1, B:95:0x02e7, B:97:0x02eb, B:99:0x02f1, B:100:0x0312, B:101:0x0336, B:103:0x033a, B:105:0x0340, B:106:0x0367, B:109:0x0394, B:111:0x0398, B:113:0x039e, B:115:0x03a2, B:117:0x03a8, B:118:0x0444, B:119:0x03c9, B:120:0x03ec, B:122:0x03f0, B:124:0x03f6, B:125:0x041c, B:126:0x0476, B:128:0x047d, B:130:0x0483, B:132:0x0487, B:134:0x048d, B:135:0x04ae, B:136:0x04d1, B:138:0x04d5, B:140:0x04db, B:141:0x0501, B:142:0x020a), top: B:8:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0220 A[Catch: Exception -> 0x052c, IOException -> 0x0530, TryCatch #18 {IOException -> 0x0530, Exception -> 0x052c, blocks: (B:9:0x001b, B:18:0x007c, B:20:0x0080, B:23:0x0087, B:24:0x0092, B:26:0x0098, B:28:0x009e, B:30:0x00a2, B:32:0x00a8, B:33:0x00c9, B:34:0x00ed, B:36:0x00f1, B:38:0x00f7, B:39:0x011e, B:40:0x008a, B:41:0x0148, B:43:0x014f, B:45:0x0155, B:46:0x0173, B:47:0x0194, B:49:0x0198, B:52:0x01a3, B:53:0x01ae, B:55:0x01b7, B:57:0x01bd, B:58:0x01db, B:59:0x01a6, B:60:0x01fc, B:62:0x0200, B:65:0x0207, B:66:0x0212, B:73:0x0220, B:75:0x0227, B:77:0x022d, B:79:0x0231, B:81:0x0237, B:82:0x0258, B:83:0x027c, B:85:0x0280, B:87:0x0286, B:88:0x02ad, B:91:0x02da, B:93:0x02e1, B:95:0x02e7, B:97:0x02eb, B:99:0x02f1, B:100:0x0312, B:101:0x0336, B:103:0x033a, B:105:0x0340, B:106:0x0367, B:109:0x0394, B:111:0x0398, B:113:0x039e, B:115:0x03a2, B:117:0x03a8, B:118:0x0444, B:119:0x03c9, B:120:0x03ec, B:122:0x03f0, B:124:0x03f6, B:125:0x041c, B:126:0x0476, B:128:0x047d, B:130:0x0483, B:132:0x0487, B:134:0x048d, B:135:0x04ae, B:136:0x04d1, B:138:0x04d5, B:140:0x04db, B:141:0x0501, B:142:0x020a), top: B:8:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02d7  */
    /* JADX WARN: Type inference failed for: r10v115 */
    /* JADX WARN: Type inference failed for: r10v116 */
    /* JADX WARN: Type inference failed for: r10v117 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.DataInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SystemMsg decode(AppInterface appInterface, String str, String str2, int i3) {
        SystemMsg systemMsg;
        SystemMsg systemMsg2;
        int i16;
        FrdSysMsg$FriendMiscInfo frdSysMsg$FriendMiscInfo;
        FrdSysMsg$GroupInfo frdSysMsg$GroupInfo;
        int i17;
        FrdSysMsg$FriendMiscInfo frdSysMsg$FriendMiscInfo2;
        int i18;
        FrdSysMsg$FriendHelloInfo frdSysMsg$FriendHelloInfo;
        FrdSysMsg$FriendMiscInfo frdSysMsg$FriendMiscInfo3;
        int i19;
        FrdSysMsg$FriendHelloInfo frdSysMsg$FriendHelloInfo2;
        FrdSysMsg$FriendMiscInfo frdSysMsg$FriendMiscInfo4;
        int i26;
        FrdSysMsg$FriendMiscInfo frdSysMsg$FriendMiscInfo5;
        FrdSysMsg$TongXunLuNickInfo frdSysMsg$TongXunLuNickInfo;
        FrdSysMsg$GroupInfo frdSysMsg$GroupInfo2;
        String string;
        byte b16;
        String str3;
        String str4;
        String string2;
        String str5;
        String string3;
        String str6;
        String str7;
        SystemMsg systemMsg3 = null;
        if (str == null) {
            return null;
        }
        try {
            if (isTroopSystemMessage(i3)) {
                byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
                SystemMsg systemMsg4 = new SystemMsg();
                try {
                    systemMsg4.troopCode = getTroopCodeFromTroopSysMsg(hexStr2Bytes);
                    systemMsg4.troopType = getTroopTypeFromTroopSysMsg(hexStr2Bytes);
                    systemMsg4.managerUin = getManagerUinFromTroopSysMsg(hexStr2Bytes, i3);
                    systemMsg4.sMsg = getStrMsgFromTroopSysMsg(hexStr2Bytes, i3);
                    systemMsg4.f203120op = getTroopOpFromTroopSysMsg(hexStr2Bytes, i3);
                    systemMsg4.requestUin = getRequestUinFromTroopSysMsg(hexStr2Bytes, i3);
                    systemMsg4.auth = getAuthFromTroopSysMsg(hexStr2Bytes, i3);
                    systemMsg4.inviteMemUin = getInviteUinFromTroopSysMsg(hexStr2Bytes, i3);
                    String g06 = ac.g0(appInterface, systemMsg4.troopCode, true);
                    String g16 = ac.g(appInterface, systemMsg4.requestUin, true);
                    String g17 = ac.g(appInterface, systemMsg4.managerUin, true);
                    String g18 = ac.g(appInterface, systemMsg4.inviteMemUin, true);
                    if (i3 != 46) {
                        switch (i3) {
                            case -1023:
                                break;
                            case -1022:
                                String str8 = systemMsg4.sMsg;
                                if (str8 != null && !"".equals(str8.trim())) {
                                    string2 = systemMsg4.sMsg;
                                    systemMsg4.sMsg = string2;
                                    str5 = systemMsg4.managerUin;
                                    if (str5 == null && !str5.equals(g17)) {
                                        systemMsg4.message = g17 + " " + BaseApplication.getContext().getString(R.string.h0d);
                                        break;
                                    } else {
                                        systemMsg4.message = "\"" + g17 + "\" " + BaseApplication.getContext().getString(R.string.h0d);
                                        break;
                                    }
                                }
                                string2 = BaseApplication.getContext().getString(R.string.cli);
                                systemMsg4.sMsg = string2;
                                str5 = systemMsg4.managerUin;
                                if (str5 == null) {
                                }
                                systemMsg4.message = "\"" + g17 + "\" " + BaseApplication.getContext().getString(R.string.h0d);
                                break;
                            case -1021:
                                String str9 = systemMsg4.managerUin;
                                if (str9 != null && !str9.equals(g17)) {
                                    systemMsg4.message = g17 + " " + BaseApplication.getContext().getString(R.string.f169980b2);
                                    break;
                                } else {
                                    systemMsg4.message = "\"" + g17 + "\" " + BaseApplication.getContext().getString(R.string.f169980b2);
                                    break;
                                }
                            case -1020:
                                String str10 = systemMsg4.sMsg;
                                if (str10 != null && !"".equals(str10)) {
                                    string3 = systemMsg4.sMsg;
                                    systemMsg4.sMsg = string3;
                                    str6 = systemMsg4.troopCode;
                                    if (str6 == null && !str6.equals(g06)) {
                                        String str11 = systemMsg4.requestUin;
                                        if (str11 != null && !str11.equals(g16)) {
                                            systemMsg4.message = g16 + " " + BaseApplication.getContext().getString(R.string.f170417pw) + g06;
                                            break;
                                        } else {
                                            systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.f170417pw) + g06;
                                            break;
                                        }
                                    } else {
                                        str7 = systemMsg4.requestUin;
                                        if (str7 == null && !str7.equals(g16)) {
                                            systemMsg4.message = g16 + " " + BaseApplication.getContext().getString(R.string.f170417pw) + "\"" + g06 + "\"";
                                            break;
                                        } else {
                                            systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.f170417pw) + "\"" + g06 + "\"";
                                            break;
                                        }
                                    }
                                }
                                string3 = BaseApplication.getContext().getString(R.string.cli);
                                systemMsg4.sMsg = string3;
                                str6 = systemMsg4.troopCode;
                                if (str6 == null) {
                                }
                                str7 = systemMsg4.requestUin;
                                if (str7 == null) {
                                }
                                systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.f170417pw) + "\"" + g06 + "\"";
                                break;
                            default:
                                switch (i3) {
                                    case 35:
                                        break;
                                    case 36:
                                        break;
                                    case 37:
                                        break;
                                    default:
                                        switch (i3) {
                                        }
                                }
                        }
                        return systemMsg4;
                    }
                    String str12 = systemMsg4.sMsg;
                    if (str12 != null && !"".equals(str12)) {
                        string = systemMsg4.sMsg;
                        systemMsg4.sMsg = string;
                        b16 = systemMsg4.f203120op;
                        if (b16 != 1 && b16 != 4) {
                            if (b16 != 2) {
                                String str13 = systemMsg4.troopCode;
                                if (str13 != null && !str13.equals(g06)) {
                                    String str14 = systemMsg4.requestUin;
                                    if (str14 != null && !str14.equals(g16)) {
                                        systemMsg4.message = g16 + " " + BaseApplication.getContext().getString(R.string.f169979b1) + g06;
                                    } else {
                                        systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.f169979b1) + g06;
                                    }
                                } else {
                                    String str15 = systemMsg4.requestUin;
                                    if (str15 != null && !str15.equals(g16)) {
                                        systemMsg4.message = g16 + " " + BaseApplication.getContext().getString(R.string.f169979b1) + "\"" + g06 + "\"";
                                    } else {
                                        systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.f169979b1) + "\"" + g06 + "\"";
                                    }
                                }
                            } else if (b16 == 3) {
                                String str16 = systemMsg4.troopCode;
                                if (str16 != null && !str16.equals(g06)) {
                                    String str17 = systemMsg4.requestUin;
                                    if (str17 != null && !str17.equals(g16)) {
                                        systemMsg4.message = g16 + " " + BaseApplication.getContext().getString(R.string.h0c) + g06;
                                    } else {
                                        systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.h0c) + g06;
                                    }
                                } else {
                                    String str18 = systemMsg4.requestUin;
                                    if (str18 != null && !str18.equals(g16)) {
                                        systemMsg4.message = g16 + " " + BaseApplication.getContext().getString(R.string.h0c) + "\"" + g06 + "\"";
                                    } else {
                                        systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.h0c) + "\"" + g06 + "\"";
                                    }
                                }
                            } else if (b16 == 5) {
                                String str19 = systemMsg4.troopCode;
                                if (str19 != null && !str19.equals(g06)) {
                                    String str20 = systemMsg4.requestUin;
                                    if (str20 != null && !str20.equals(g16)) {
                                        systemMsg4.message = g16 + " " + BaseApplication.getContext().getString(R.string.f170417pw) + g06;
                                    } else {
                                        systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.f170417pw) + g06;
                                    }
                                } else {
                                    String str21 = systemMsg4.requestUin;
                                    if (str21 != null && !str21.equals(g16)) {
                                        systemMsg4.message = g16 + " " + BaseApplication.getContext().getString(R.string.f170417pw) + "\"" + g06 + "\"";
                                    } else {
                                        systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.f170417pw) + "\"" + g06 + "\"";
                                    }
                                }
                                systemMsg4.sMsg = BaseApplication.getContext().getString(R.string.hul) + " " + g18 + " " + BaseApplication.getContext().getString(R.string.hup);
                            }
                            return systemMsg4;
                        }
                        str3 = systemMsg4.troopCode;
                        if (str3 == null && !str3.equals(g06)) {
                            String str22 = systemMsg4.requestUin;
                            if (str22 != null && !str22.equals(g16)) {
                                systemMsg4.message = g16 + " " + BaseApplication.getContext().getString(R.string.bzt) + g06;
                            } else {
                                systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.bzt) + g06;
                            }
                        } else {
                            str4 = systemMsg4.requestUin;
                            if (str4 == null && !str4.equals(g16)) {
                                systemMsg4.message = g16 + " " + BaseApplication.getContext().getString(R.string.bzt) + "\"" + g06 + "\"";
                            } else {
                                systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.bzt) + "\"" + g06 + "\"";
                            }
                        }
                        return systemMsg4;
                    }
                    string = BaseApplication.getContext().getString(R.string.cli);
                    systemMsg4.sMsg = string;
                    b16 = systemMsg4.f203120op;
                    if (b16 != 1) {
                        if (b16 != 2) {
                        }
                        return systemMsg4;
                    }
                    str3 = systemMsg4.troopCode;
                    if (str3 == null) {
                    }
                    str4 = systemMsg4.requestUin;
                    if (str4 == null) {
                    }
                    systemMsg4.message = "\"" + g16 + "\" " + BaseApplication.getContext().getString(R.string.bzt) + "\"" + g06 + "\"";
                    return systemMsg4;
                } catch (IOException e16) {
                    e = e16;
                    systemMsg3 = systemMsg4;
                    e.printStackTrace();
                    return systemMsg3;
                } catch (Exception e17) {
                    e = e17;
                    systemMsg3 = systemMsg4;
                    e.printStackTrace();
                    return systemMsg3;
                }
            }
            SystemMsg dataInputStream = new DataInputStream(new ByteArrayInputStream(HexUtil.hexStr2Bytes(str)));
            try {
                if (i3 != -2004) {
                    if (i3 != -2003 && i3 != 9) {
                        if (i3 != 513) {
                            int i27 = 0;
                            try {
                                try {
                                    switch (i3) {
                                        case -1010:
                                            systemMsg = new SystemMsg();
                                            systemMsg.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.f170082fd);
                                            try {
                                                systemMsg2 = new SystemMsg();
                                                try {
                                                    systemMsg2.cVession = dataInputStream.readUnsignedByte();
                                                    dataInputStream.read(new byte[dataInputStream.readUnsignedByte()]);
                                                    systemMsg2.wSourceID = dataInputStream.readUnsignedShort();
                                                    systemMsg2.wSourceSubID = dataInputStream.readUnsignedShort();
                                                    dataInputStream.skip(dataInputStream.readUnsignedShort());
                                                    if (dataInputStream.readUnsignedShort() != 0) {
                                                        i16 = dataInputStream.readUnsignedShort();
                                                    } else {
                                                        i16 = 0;
                                                    }
                                                    byte[] bArr = new byte[i16];
                                                    dataInputStream.read(bArr);
                                                    if (i16 == 0) {
                                                        systemMsg2.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.f170082fd);
                                                    } else {
                                                        com.tencent.mobileqq.service.message.b.d(bArr);
                                                        systemMsg2.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.f170082fd);
                                                    }
                                                    dataInputStream.skip(4L);
                                                    dataInputStream.read(new byte[dataInputStream.readUnsignedShort()]);
                                                    int readUnsignedByte = dataInputStream.readUnsignedByte();
                                                    while (i27 < readUnsignedByte) {
                                                        short readShort = dataInputStream.readShort();
                                                        byte[] bArr2 = new byte[dataInputStream.readShort()];
                                                        dataInputStream.read(bArr2);
                                                        if (readShort == 1000) {
                                                            try {
                                                                frdSysMsg$GroupInfo = new FrdSysMsg$GroupInfo().mergeFrom(bArr2);
                                                            } catch (Exception unused) {
                                                                frdSysMsg$GroupInfo = null;
                                                            }
                                                            if (frdSysMsg$GroupInfo != null) {
                                                                systemMsg2.strGroupName = frdSysMsg$GroupInfo.str_group_name.get();
                                                                systemMsg2.strGroupNickName = frdSysMsg$GroupInfo.str_group_nick.get();
                                                                systemMsg2.strGroupUin = frdSysMsg$GroupInfo.uint64_group_uin.get();
                                                            }
                                                        } else if (readShort == 1002) {
                                                            try {
                                                                frdSysMsg$FriendMiscInfo = new FrdSysMsg$FriendMiscInfo().mergeFrom(bArr2);
                                                            } catch (Exception unused2) {
                                                                frdSysMsg$FriendMiscInfo = null;
                                                            }
                                                            if (frdSysMsg$FriendMiscInfo != null) {
                                                                systemMsg2.strServerFromUinNickName = frdSysMsg$FriendMiscInfo.str_fromuin_nick.get();
                                                            }
                                                        }
                                                        i27++;
                                                    }
                                                    return systemMsg2;
                                                } catch (Exception unused3) {
                                                    systemMsg = systemMsg2;
                                                    break;
                                                }
                                            } catch (Exception unused4) {
                                                break;
                                            }
                                        case -1009:
                                            systemMsg = new SystemMsg();
                                            systemMsg.cVession = dataInputStream.readUnsignedByte();
                                            byte[] bArr3 = new byte[dataInputStream.readUnsignedByte()];
                                            dataInputStream.read(bArr3);
                                            String trim = new String(com.tencent.mobileqq.service.message.b.d(bArr3)).trim();
                                            if (trim == null || "".equals(trim)) {
                                                trim = BaseApplication.getContext().getString(R.string.cli);
                                            }
                                            systemMsg.sMsg = trim;
                                            if (dataInputStream.readUnsignedShort() != 0) {
                                                i17 = dataInputStream.readUnsignedShort();
                                            } else {
                                                i17 = 0;
                                            }
                                            byte[] bArr4 = new byte[i17];
                                            dataInputStream.read(bArr4);
                                            if (i17 == 0) {
                                                systemMsg.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.h0f);
                                            } else {
                                                com.tencent.mobileqq.service.message.b.d(bArr4);
                                                systemMsg.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.h0f);
                                            }
                                            dataInputStream.skip(4L);
                                            dataInputStream.read(new byte[dataInputStream.readUnsignedShort()]);
                                            dataInputStream.readUnsignedByte();
                                            int readUnsignedByte2 = dataInputStream.readUnsignedByte();
                                            while (i27 < readUnsignedByte2) {
                                                short readShort2 = dataInputStream.readShort();
                                                byte[] bArr5 = new byte[dataInputStream.readShort()];
                                                dataInputStream.read(bArr5);
                                                if (readShort2 == 1002) {
                                                    try {
                                                        frdSysMsg$FriendMiscInfo2 = new FrdSysMsg$FriendMiscInfo().mergeFrom(bArr5);
                                                    } catch (Exception unused5) {
                                                        frdSysMsg$FriendMiscInfo2 = null;
                                                    }
                                                    if (frdSysMsg$FriendMiscInfo2 != null) {
                                                        systemMsg.strServerFromUinNickName = frdSysMsg$FriendMiscInfo2.str_fromuin_nick.get();
                                                    }
                                                }
                                                i27++;
                                            }
                                            return systemMsg;
                                        case -1008:
                                            systemMsg2 = new SystemMsg();
                                            systemMsg2.cVession = dataInputStream.readUnsignedByte();
                                            dataInputStream.readUnsignedByte();
                                            if (dataInputStream.readUnsignedShort() != 0) {
                                                i18 = dataInputStream.readUnsignedShort();
                                            } else {
                                                i18 = 0;
                                            }
                                            byte[] bArr6 = new byte[i18];
                                            dataInputStream.read(bArr6);
                                            if (i18 == 0) {
                                                systemMsg2.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.f169981b3);
                                            } else {
                                                com.tencent.mobileqq.service.message.b.d(bArr6);
                                                systemMsg2.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.f169981b3);
                                            }
                                            dataInputStream.skip(4L);
                                            dataInputStream.read(new byte[dataInputStream.readUnsignedShort()]);
                                            int readUnsignedByte3 = dataInputStream.readUnsignedByte();
                                            while (i27 < readUnsignedByte3) {
                                                short readShort3 = dataInputStream.readShort();
                                                byte[] bArr7 = new byte[dataInputStream.readShort()];
                                                dataInputStream.read(bArr7);
                                                if (readShort3 == 1002) {
                                                    try {
                                                        frdSysMsg$FriendMiscInfo3 = new FrdSysMsg$FriendMiscInfo().mergeFrom(bArr7);
                                                    } catch (Exception unused6) {
                                                        frdSysMsg$FriendMiscInfo3 = null;
                                                    }
                                                    if (frdSysMsg$FriendMiscInfo3 != null) {
                                                        systemMsg2.strServerFromUinNickName = frdSysMsg$FriendMiscInfo3.str_fromuin_nick.get();
                                                    }
                                                } else if (readShort3 == 1003) {
                                                    try {
                                                        frdSysMsg$FriendHelloInfo = new FrdSysMsg$FriendHelloInfo().mergeFrom(bArr7);
                                                    } catch (Exception unused7) {
                                                        frdSysMsg$FriendHelloInfo = null;
                                                    }
                                                    if (frdSysMsg$FriendHelloInfo != null) {
                                                        systemMsg2.strGameName = frdSysMsg$FriendHelloInfo.str_source_name.get();
                                                    }
                                                }
                                                i27++;
                                            }
                                            return systemMsg2;
                                        case -1007:
                                            systemMsg2 = new SystemMsg();
                                            systemMsg2.cVession = dataInputStream.readUnsignedByte();
                                            dataInputStream.readUnsignedByte();
                                            if (dataInputStream.readUnsignedShort() != 0) {
                                                i19 = dataInputStream.readUnsignedShort();
                                            } else {
                                                i19 = 0;
                                            }
                                            byte[] bArr8 = new byte[i19];
                                            dataInputStream.read(bArr8);
                                            if (i19 == 0) {
                                                systemMsg2.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.f169982b4);
                                            } else {
                                                new String(com.tencent.mobileqq.service.message.b.d(bArr8));
                                                systemMsg2.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.f169982b4);
                                            }
                                            dataInputStream.skip(4L);
                                            dataInputStream.read(new byte[dataInputStream.readUnsignedShort()]);
                                            int readUnsignedByte4 = dataInputStream.readUnsignedByte();
                                            while (i27 < readUnsignedByte4) {
                                                short readShort4 = dataInputStream.readShort();
                                                byte[] bArr9 = new byte[dataInputStream.readShort()];
                                                dataInputStream.read(bArr9);
                                                if (readShort4 == 1002) {
                                                    try {
                                                        frdSysMsg$FriendMiscInfo4 = new FrdSysMsg$FriendMiscInfo().mergeFrom(bArr9);
                                                    } catch (Exception unused8) {
                                                        frdSysMsg$FriendMiscInfo4 = null;
                                                    }
                                                    if (frdSysMsg$FriendMiscInfo4 != null) {
                                                        systemMsg2.strServerFromUinNickName = frdSysMsg$FriendMiscInfo4.str_fromuin_nick.get();
                                                    }
                                                } else if (readShort4 == 1003) {
                                                    try {
                                                        frdSysMsg$FriendHelloInfo2 = new FrdSysMsg$FriendHelloInfo().mergeFrom(bArr9);
                                                    } catch (Exception unused9) {
                                                        frdSysMsg$FriendHelloInfo2 = null;
                                                    }
                                                    if (frdSysMsg$FriendHelloInfo2 != null) {
                                                        systemMsg2.strGameName = frdSysMsg$FriendHelloInfo2.str_source_name.get();
                                                    }
                                                }
                                                i27++;
                                            }
                                            return systemMsg2;
                                        case -1006:
                                            systemMsg = new SystemMsg();
                                            systemMsg.cVession = dataInputStream.readUnsignedByte();
                                            byte[] bArr10 = new byte[dataInputStream.readUnsignedByte()];
                                            dataInputStream.read(bArr10);
                                            systemMsg.sMsg = new String(com.tencent.mobileqq.service.message.b.d(bArr10), "utf-8").trim();
                                            dataInputStream.skip(1L);
                                            systemMsg.wSourceID = dataInputStream.readUnsignedShort();
                                            systemMsg.wSourceSubID = dataInputStream.readUnsignedShort();
                                            dataInputStream.skip(dataInputStream.readUnsignedShort());
                                            if (dataInputStream.readUnsignedShort() != 0) {
                                                i26 = dataInputStream.readUnsignedShort();
                                            } else {
                                                i26 = 0;
                                            }
                                            byte[] bArr11 = new byte[i26];
                                            dataInputStream.read(bArr11);
                                            if (i26 == 0) {
                                                systemMsg.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.f170058eb);
                                            } else {
                                                com.tencent.mobileqq.service.message.b.d(bArr11);
                                                systemMsg.message = "\"" + str2 + "\"" + BaseApplication.getContext().getString(R.string.f170058eb);
                                            }
                                            dataInputStream.skip(4L);
                                            dataInputStream.read(new byte[dataInputStream.readUnsignedShort()]);
                                            dataInputStream.readUnsignedByte();
                                            int readUnsignedByte5 = dataInputStream.readUnsignedByte();
                                            while (i27 < readUnsignedByte5) {
                                                short readShort5 = dataInputStream.readShort();
                                                byte[] bArr12 = new byte[dataInputStream.readShort()];
                                                dataInputStream.read(bArr12);
                                                if (readShort5 == 1000) {
                                                    try {
                                                        frdSysMsg$GroupInfo2 = new FrdSysMsg$GroupInfo().mergeFrom(bArr12);
                                                    } catch (Exception unused10) {
                                                        frdSysMsg$GroupInfo2 = null;
                                                    }
                                                    if (frdSysMsg$GroupInfo2 != null) {
                                                        systemMsg.strGroupName = frdSysMsg$GroupInfo2.str_group_name.get();
                                                        systemMsg.strGroupNickName = frdSysMsg$GroupInfo2.str_group_nick.get();
                                                        systemMsg.strGroupUin = frdSysMsg$GroupInfo2.uint64_group_uin.get();
                                                    }
                                                } else if (readShort5 == 1001) {
                                                    try {
                                                        frdSysMsg$TongXunLuNickInfo = new FrdSysMsg$TongXunLuNickInfo().mergeFrom(bArr12);
                                                    } catch (Exception unused11) {
                                                        frdSysMsg$TongXunLuNickInfo = null;
                                                    }
                                                    if (frdSysMsg$TongXunLuNickInfo != null) {
                                                        systemMsg.strAddressBookNickName = frdSysMsg$TongXunLuNickInfo.str_tongxunlu_nickname.get();
                                                    }
                                                } else if (readShort5 == 1002) {
                                                    try {
                                                        frdSysMsg$FriendMiscInfo5 = new FrdSysMsg$FriendMiscInfo().mergeFrom(bArr12);
                                                    } catch (Exception unused12) {
                                                        frdSysMsg$FriendMiscInfo5 = null;
                                                    }
                                                    if (frdSysMsg$FriendMiscInfo5 != null) {
                                                        systemMsg.strServerFromUinNickName = frdSysMsg$FriendMiscInfo5.str_fromuin_nick.get();
                                                    }
                                                }
                                                i27++;
                                            }
                                            return systemMsg;
                                        default:
                                            switch (i3) {
                                                case 187:
                                                    break;
                                                case 188:
                                                    break;
                                                case 189:
                                                    break;
                                                case 190:
                                                    break;
                                                case 191:
                                                    break;
                                                default:
                                                    if (!str2.equals(String.valueOf(AppConstants.QQBROADCAST_MSG_UIN))) {
                                                        return null;
                                                    }
                                                    SystemMsg systemMsg5 = new SystemMsg();
                                                    systemMsg5.message = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
                                                    dataInputStream = systemMsg5;
                                                    break;
                                            }
                                    }
                                } catch (IOException e18) {
                                    e = e18;
                                    systemMsg3 = 1003;
                                    e.printStackTrace();
                                    return systemMsg3;
                                } catch (Exception e19) {
                                    e = e19;
                                    systemMsg3 = 1003;
                                    e.printStackTrace();
                                    return systemMsg3;
                                }
                            } catch (IOException e26) {
                                e = e26;
                                systemMsg3 = i3;
                                e.printStackTrace();
                                return systemMsg3;
                            } catch (Exception e27) {
                                e = e27;
                                systemMsg3 = i3;
                                e.printStackTrace();
                                return systemMsg3;
                            }
                        }
                    } else {
                        if (!str2.equals(String.valueOf(AppConstants.QQBROADCAST_MSG_UIN))) {
                            return null;
                        }
                        SystemMsg systemMsg6 = new SystemMsg();
                        systemMsg6.message = str;
                        dataInputStream = systemMsg6;
                    }
                    return dataInputStream;
                }
                if (!str2.equals(String.valueOf(AppConstants.QQBROADCAST_MSG_UIN))) {
                    return null;
                }
                SystemMsg systemMsg7 = new SystemMsg();
                systemMsg7.message = PkgTools.decodeCgi(PkgTools.getParaVal("SUBJECT", str));
                dataInputStream = systemMsg7;
                return dataInputStream;
            } catch (IOException e28) {
                systemMsg3 = dataInputStream;
                e = e28;
            } catch (Exception e29) {
                systemMsg3 = dataInputStream;
                e = e29;
            }
        } catch (IOException e36) {
            e = e36;
        } catch (Exception e37) {
            e = e37;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001b, code lost:
    
        if (r4 != 87) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] getAuthFromTroopSysMsg(byte[] bArr, int i3) {
        if (bArr == null) {
            return null;
        }
        if (i3 != -1023) {
            if (i3 != -1020 && i3 != 35) {
                if (i3 != 46) {
                    if (i3 != 84) {
                    }
                }
            }
            int unsignedByte = PkgTools.getUnsignedByte(bArr[9]) + 10 + 2 + PkgTools.getShortData(bArr, PkgTools.getUnsignedByte(bArr[9]) + 10);
            int shortData = PkgTools.getShortData(bArr, unsignedByte);
            byte[] bArr2 = new byte[shortData];
            System.arraycopy(bArr, unsignedByte + 2, bArr2, 0, shortData);
            return bArr2;
        }
        byte troopOpFromTroopSysMsg = getTroopOpFromTroopSysMsg(bArr, i3);
        if (troopOpFromTroopSysMsg != 1 && troopOpFromTroopSysMsg != 4) {
            if (troopOpFromTroopSysMsg == 5) {
                int unsignedByte2 = PkgTools.getUnsignedByte(bArr[19]) + 19;
                int shortData2 = PkgTools.getShortData(bArr, unsignedByte2);
                byte[] bArr3 = new byte[shortData2];
                System.arraycopy(bArr, unsignedByte2 + 2, bArr3, 0, shortData2);
                return bArr3;
            }
            return null;
        }
        int unsignedByte3 = PkgTools.getUnsignedByte(bArr[15]) + 15;
        int shortData3 = PkgTools.getShortData(bArr, unsignedByte3);
        byte[] bArr4 = new byte[shortData3];
        System.arraycopy(bArr, unsignedByte3 + 2, bArr4, 0, shortData3);
        return bArr4;
    }

    public static String getInviteUinFromTroopSysMsg(byte[] bArr, int i3) {
        if (bArr == null) {
            return null;
        }
        if ((i3 != -1023 && i3 != 46 && i3 != 87) || getTroopOpFromTroopSysMsg(bArr, i3) != 5) {
            return null;
        }
        return String.valueOf(PkgTools.getLongData(bArr, 14));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0010. Please report as an issue. */
    public static String getManagerUinFromTroopSysMsg(byte[] bArr, int i3) {
        if (bArr == null) {
            return null;
        }
        if (i3 != 36 && i3 != 37) {
            if (i3 != 46) {
                switch (i3) {
                    case -1023:
                        break;
                    case -1022:
                    case -1021:
                        break;
                    default:
                        switch (i3) {
                            case 85:
                            case 86:
                                break;
                            case 87:
                                break;
                            default:
                                return null;
                        }
                }
            }
            return String.valueOf(PkgTools.getLongData(bArr, 10));
        }
        return String.valueOf(PkgTools.getLongData(bArr, 5));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0008. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x000b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getRequestUinFromTroopSysMsg(byte[] bArr, int i3) {
        if (bArr == null) {
            return null;
        }
        if (i3 != 46) {
            switch (i3) {
                case -1023:
                case -1022:
                case -1021:
                    break;
                case -1020:
                    return String.valueOf(PkgTools.getLongData(bArr, 5));
                default:
                    switch (i3) {
                        case 35:
                            break;
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i3) {
                                case 84:
                                    break;
                                case 85:
                                case 86:
                                case 87:
                                    break;
                                default:
                                    return null;
                            }
                    }
            }
        }
        return String.valueOf(PkgTools.getLongData(bArr, 10));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0009. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x000c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0013 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getStrMsgFromTroopSysMsg(byte[] bArr, int i3) {
        int unsignedByte;
        byte[] d16;
        if (bArr == null) {
            return null;
        }
        if (i3 != 46) {
            switch (i3) {
                case -1023:
                    break;
                case -1022:
                case -1021:
                case -1020:
                    int unsignedByte2 = PkgTools.getUnsignedByte(bArr[9]);
                    byte[] bArr2 = new byte[unsignedByte2];
                    PkgTools.copyData(bArr2, 0, bArr, 10, unsignedByte2);
                    return String.valueOf(PkgTools.utf8Byte2String(com.tencent.mobileqq.service.message.b.d(bArr2), 0, unsignedByte2));
                default:
                    switch (i3) {
                        default:
                            switch (i3) {
                                case 84:
                                case 85:
                                case 86:
                                    break;
                                case 87:
                                    break;
                                default:
                                    return null;
                            }
                        case 35:
                        case 36:
                        case 37:
                            break;
                    }
            }
        }
        if (getTroopOpFromTroopSysMsg(bArr, i3) == 5) {
            unsignedByte = PkgTools.getUnsignedByte(bArr[18]);
            byte[] bArr3 = new byte[unsignedByte];
            PkgTools.copyData(bArr3, 0, bArr, 19, unsignedByte);
            d16 = com.tencent.mobileqq.service.message.b.d(bArr3);
        } else {
            unsignedByte = PkgTools.getUnsignedByte(bArr[14]);
            byte[] bArr4 = new byte[unsignedByte];
            PkgTools.copyData(bArr4, 0, bArr, 15, unsignedByte);
            d16 = com.tencent.mobileqq.service.message.b.d(bArr4);
        }
        return String.valueOf(PkgTools.utf8Byte2String(d16, 0, unsignedByte));
    }

    public static String getTroopCodeFromTroopSysMsg(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return String.valueOf(PkgTools.getLongData(bArr, 0));
    }

    public static byte getTroopOpFromTroopSysMsg(byte[] bArr, int i3) {
        if (bArr == null) {
            return (byte) -1;
        }
        if (i3 != -1023 && i3 != 46 && i3 != 87) {
            return (byte) -1;
        }
        return bArr[5];
    }

    public static int getTroopSystemMsgType(int i3) {
        int i16 = -1020;
        if (i3 != -1020 && i3 != 84 && i3 != 35) {
            i16 = -1021;
            if (i3 != -1021 && i3 != 85 && i3 != 36) {
                i16 = -1022;
                if (i3 != -1022 && i3 != 86 && i3 != 37) {
                    i16 = -1023;
                    if (i3 != -1023 && i3 != 87 && i3 != 46) {
                        return -1000;
                    }
                }
            }
        }
        return i16;
    }

    public static byte getTroopTypeFromTroopSysMsg(byte[] bArr) {
        if (bArr == null) {
            return (byte) -1;
        }
        return bArr[4];
    }

    public static boolean isSystemMessage(int i3) {
        if ((i3 <= -1006 && i3 >= -1010) || i3 == -1011) {
            return true;
        }
        if (i3 >= 187 && i3 <= 191) {
            return true;
        }
        return false;
    }

    public static boolean isTroopSystemMessage(int i3) {
        if (i3 <= -1020 && i3 >= -1023) {
            return true;
        }
        if (i3 >= 84 && i3 <= 87) {
            return true;
        }
        if ((i3 >= 35 && i3 <= 37) || i3 == 46 || i3 == 45) {
            return true;
        }
        return false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        try {
            this.cVession = jceInputStream.read(this.cVession, 0, true);
            this.sMsg = jceInputStream.read(this.sMsg, 1, false);
            this.append = jceInputStream.read(this.append, 2, false);
            this.message = jceInputStream.read(this.message, 3, false);
            this.troopCode = jceInputStream.read(this.troopCode, 4, false);
            this.managerUin = jceInputStream.readString(5, false);
            this.requestUin = jceInputStream.readString(6, false);
            this.troopType = jceInputStream.read(this.troopType, 7, true);
            this.f203120op = jceInputStream.read(this.f203120op, 8, true);
            this.auth = jceInputStream.read(this.auth, 9, false);
            this.lToMobile = jceInputStream.read(this.lToMobile, 10, true);
            this.strNickName = jceInputStream.read(this.strNickName, 11, false);
        } catch (Exception unused) {
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cVession, 0);
        String str = this.sMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.append;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.message;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.troopCode;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.managerUin;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.requestUin;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        jceOutputStream.write(this.troopType, 7);
        jceOutputStream.write(this.f203120op, 8);
        byte[] bArr = this.auth;
        if (bArr != null) {
            jceOutputStream.write(bArr, 9);
        }
        jceOutputStream.write(this.lToMobile, 10);
        String str7 = this.strNickName;
        if (str7 != null) {
            jceOutputStream.write(str7, 11);
        }
    }
}
