package com.tencent.mobileqq.graytip;

import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pushdialog.PushDialogHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.luckycharacter.api.TroopLuckyCharacterConstant;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.xweb.FileReaderHelper;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.oidb.cmd0x857.TroopTips0x857$GrayData;
import tencent.im.oidb.cmd0xe3e.oidb_0xe3e$ResvAttr;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122$MsgBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f213701a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f213702b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72490);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f213701a = "UniteGrayTip";
            f213702b = new c();
        }
    }

    private static boolean a(UniteEntity.Note note, UniteEntity.Note note2, XmlPullParser xmlPullParser) {
        note.setParent(note2);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (attributeName.equals(FileReaderHelper.TXT_EXT)) {
                note.addField(2, attributeValue);
            } else if (attributeName.equals("jp")) {
                note.addField(4, attributeValue);
            } else if (attributeName.equals("uin")) {
                note.addField(6, attributeValue);
            } else if (attributeName.equals("nm")) {
                note.addField(7, attributeValue);
            } else if (attributeName.equals("tp")) {
                note.addField(9, attributeValue);
            } else if (attributeName.equals("si")) {
                note.addField(3, attributeValue);
            } else if (attributeName.equals("col")) {
                note.addField(5, attributeValue);
            } else if (attributeName.equals("src")) {
                note.addField(8, attributeValue);
            } else if (attributeName.equals("align")) {
                note.addField(1, attributeValue);
            } else if (attributeName.equals(QCircleSchemeAttr.Polymerize.ALT)) {
                note.addField(10, attributeValue);
            } else if (attributeName.equals("status")) {
                note.addField(11, attributeValue);
            } else if (attributeName.equals("ex_status")) {
                note.addField(12, attributeValue);
            } else if (attributeName.equals("battery_status")) {
                note.addField(13, attributeValue);
            } else {
                if (!QLog.isColorLevel()) {
                    return false;
                }
                QLog.i(f213701a, 2, "parseXML, illegel field: " + attributeName);
                return false;
            }
        }
        return true;
    }

    public static MessageForUniteGrayTip b(QQAppInterface qQAppInterface, String str, int i3, int i16, long j3, String str2, long j16, long j17, long j18, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.e(f213701a, 2, "createUniteGrayTip contentXml " + str2);
        }
        UniteEntity l3 = l(str2);
        if (l3 == null || n(str, qQAppInterface, j16, j17, bArr)) {
            return null;
        }
        g gVar = new g(str, qQAppInterface.getCurrentAccountUin(), "", i3, i16, 655397, j3);
        UniteEntity.Note rootNote = l3.getRootNote();
        if (rootNote == null) {
            return null;
        }
        HashMap<Integer, Object> fields = rootNote.getFields();
        String str3 = "";
        for (Integer num : fields.keySet()) {
            Object obj = fields.get(num);
            if (num.intValue() == 1) {
                str3 = (String) obj;
            }
        }
        k(qQAppInterface, gVar, rootNote, i3, str, j18, new JSONObject(), false);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        messageForUniteGrayTip.saveExtInfoToExtStr("unite_gray_tips_align", str3);
        messageForUniteGrayTip.saveExtInfoToExtStr(MessageForUniteGrayTip.KEY_UINT64_TEMPL_ID, String.valueOf(j18));
        QLog.d(f213701a, 2, "createUniteGrayTip content :" + str2);
        f213702b.b(messageForUniteGrayTip);
        i(qQAppInterface, str, i3, j16, j17, bArr);
        return messageForUniteGrayTip;
    }

    public static int c(int i3) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if ((i3 & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((i3 & 2) == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((i3 & 4) == 4) {
            z18 = true;
        }
        if (z16) {
            if (!z17 || z18) {
                return MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL;
            }
            return MessageRecord.MSG_TYPE_UNITE_GRAY_HISTORY_INVI;
        }
        if (z17) {
            if (z18) {
                return MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI;
            }
            return MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI;
        }
        return MessageRecord.MSG_TYPE_UNITE_TAB_DB_INVI;
    }

    private static UniteEntity.Note d(UniteEntity.Note note, UniteEntity.Note note2) {
        if (note != null) {
            return note.getParent();
        }
        return note2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int e(int i3) {
        int i16;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 160) {
                    if (i3 != 161) {
                        if (i3 != 172) {
                            if (i3 != 173) {
                                switch (i3) {
                                    case 58:
                                        i16 = 1024;
                                        break;
                                    case 121:
                                        i16 = 1021;
                                        break;
                                    case 124:
                                        i16 = 1001;
                                        break;
                                    case 137:
                                        i16 = 1010;
                                        break;
                                    case 140:
                                    case 142:
                                        i16 = 1008;
                                        break;
                                    case 144:
                                        i16 = AppConstants.VALUE.UIN_TYPE_DINGDONG_MSG_SESSION;
                                        break;
                                    case 149:
                                        i16 = 10002;
                                        break;
                                    case 153:
                                        i16 = 10004;
                                        break;
                                    case 156:
                                        i16 = 1032;
                                        break;
                                    case 163:
                                        i16 = 1044;
                                        break;
                                    case 201:
                                        i16 = 1005;
                                        break;
                                    default:
                                        switch (i3) {
                                            case 129:
                                                break;
                                            case 130:
                                                i16 = 1006;
                                                break;
                                            case 131:
                                                i16 = 1009;
                                                break;
                                            case 132:
                                                i16 = 1020;
                                                break;
                                            case 133:
                                                i16 = 1023;
                                                break;
                                            case 134:
                                                i16 = 1022;
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 165:
                                                        i16 = 10008;
                                                        break;
                                                    case 166:
                                                        i16 = 1045;
                                                        break;
                                                    case 167:
                                                        i16 = 10010;
                                                        break;
                                                    default:
                                                        i16 = -1;
                                                        break;
                                                }
                                        }
                                }
                            } else {
                                i16 = 10019;
                            }
                        } else {
                            i16 = 1046;
                        }
                    } else {
                        i16 = 1038;
                    }
                } else {
                    i16 = 1036;
                }
            } else {
                i16 = 1004;
            }
        } else {
            i16 = 1000;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f213701a, 2, "<---getTempUinType: dump info: serviceType:" + i3);
        }
        return i16;
    }

    public static void f(QQAppInterface qQAppInterface, byte[] bArr, MsgInfo msgInfo, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(f213701a, 2, "handleC2COnlinePushMsgGrayTipResp message prepared");
        }
        try {
            if (z16) {
                g(qQAppInterface, bArr, msgInfo);
            } else {
                h(qQAppInterface, bArr, msgInfo);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
        }
    }

    private static void g(QQAppInterface qQAppInterface, byte[] bArr, MsgInfo msgInfo) throws InvalidProtocolBufferMicroException, UnsupportedEncodingException {
        long j3;
        long j16;
        int i3;
        long j17;
        int i16;
        int i17;
        byte[] bArr2;
        String str;
        int e16;
        submsgtype0x122$MsgBody submsgtype0x122_msgbody = new submsgtype0x122$MsgBody();
        submsgtype0x122_msgbody.mergeFrom(bArr);
        long j18 = 0;
        if (submsgtype0x122_msgbody.uint64_busi_type.has()) {
            j3 = submsgtype0x122_msgbody.uint64_busi_type.get();
        } else {
            j3 = 0;
        }
        if (submsgtype0x122_msgbody.uint64_busi_id.has()) {
            j16 = submsgtype0x122_msgbody.uint64_busi_id.get();
        } else {
            j16 = 0;
        }
        int i18 = 0;
        if (submsgtype0x122_msgbody.uint32_ctrl_flag.has()) {
            i3 = submsgtype0x122_msgbody.uint32_ctrl_flag.get();
        } else {
            i3 = 0;
        }
        if (submsgtype0x122_msgbody.uint64_templ_id.has()) {
            j17 = submsgtype0x122_msgbody.uint64_templ_id.get();
        } else {
            j17 = 0;
        }
        if (submsgtype0x122_msgbody.uint32_c2c_type.has()) {
            i16 = submsgtype0x122_msgbody.uint32_c2c_type.get();
        } else {
            i16 = 0;
        }
        if (submsgtype0x122_msgbody.uint32_service_type.has()) {
            i17 = submsgtype0x122_msgbody.uint32_service_type.get();
        } else {
            i17 = 0;
        }
        byte[] bArr3 = null;
        if (submsgtype0x122_msgbody.bytes_content.has()) {
            bArr2 = submsgtype0x122_msgbody.bytes_content.get().toByteArray();
        } else {
            bArr2 = null;
        }
        if (submsgtype0x122_msgbody.bytes_pb_reserv.has()) {
            bArr3 = submsgtype0x122_msgbody.bytes_pb_reserv.get().toByteArray();
        }
        byte[] bArr4 = bArr3;
        if (submsgtype0x122_msgbody.uint64_tips_seq_id.has()) {
            j18 = submsgtype0x122_msgbody.uint64_tips_seq_id.get();
        }
        if (bArr2 != null && bArr2.length > 0) {
            str = new String(bArr2, "utf-8");
        } else {
            if (QLog.isColorLevel()) {
                QLog.e(f213701a, 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
            }
            str = "";
        }
        String str2 = str;
        int c16 = c(i3);
        if (i16 == 1 && (e16 = e(i17)) != -1) {
            i18 = e16;
        }
        int i19 = i17;
        MessageForUniteGrayTip b16 = b(qQAppInterface, String.valueOf(msgInfo.lFromUin), i18, c16, msgInfo.uMsgTime, str2, j3, j16, j17, bArr4);
        if (b16 == null) {
            return;
        }
        o(i19, b16, bArr4);
        b16.tipParam.f213693p = String.valueOf(j18);
        if (QLog.isColorLevel()) {
            QLog.d(f213701a, 2, "handleC2COnlinePushMsgGrayTipResp uint64_tips_seq_id" + j18);
        }
        b16.saveExtInfoToExtStr(MessageForUniteGrayTip.KEY_UINT64_BUSI_TYPE, String.valueOf(j3));
        b16.saveExtInfoToExtStr(MessageForUniteGrayTip.KEY_UINT64_BUSI_ID, String.valueOf(j16));
        b16.saveExtInfoToExtStr(MessageForUniteGrayTip.KEY_UINT64_TEMPL_ID, String.valueOf(j17));
        b16.saveExtInfoToExtStr(MessageForUniteGrayTip.KEY_BYTES_CONTENT, str2);
        b16.saveExtInfoToExtStr(MessageForUniteGrayTip.KEY_UINT64_TIPS_SEQ_ID, String.valueOf(j18));
        b16.msgUid = msgInfo.lMsgUid;
        b16.shmsgseq = msgInfo.shMsgSeq;
        b16.prewrite();
        f.a(qQAppInterface, b16);
    }

    private static void h(QQAppInterface qQAppInterface, byte[] bArr, MsgInfo msgInfo) throws InvalidProtocolBufferMicroException {
        submsgtype0x122$MsgBody submsgtype0x122_msgbody = new submsgtype0x122$MsgBody();
        submsgtype0x122_msgbody.mergeFrom(bArr);
        PushDialogHandler.b().c(submsgtype0x122_msgbody, msgInfo, qQAppInterface);
    }

    private static void i(QQAppInterface qQAppInterface, String str, int i3, long j3, long j16, byte[] bArr) {
        TroopManager troopManager;
        long j17;
        String str2;
        int i16 = 0;
        if (QLog.isColorLevel()) {
            QLog.d(f213701a, 2, String.format("handleReserveData, friendUin: %s, uinType: %s, busiType: %s, busiId: %s", str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16)));
        }
        if (com.tencent.mobileqq.troop.honor.util.a.f(j3, j16)) {
            if (bArr != null && i3 == 1) {
                ((ITroopHonorService) qQAppInterface.getRuntimeService(ITroopHonorService.class, "")).updatePushTroopHonor(str, bArr, 1);
            }
        } else if (j16 == 1038 && bArr != null && i3 == 1 && (troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)) != null) {
            troopManager.N(str, bArr, 1);
        }
        if (1011 == j16 && 1 == j3 && bArr != null && i3 == 1) {
            try {
                TroopTips0x857$GrayData troopTips0x857$GrayData = new TroopTips0x857$GrayData();
                troopTips0x857$GrayData.mergeFrom(bArr);
                if (troopTips0x857$GrayData.all_read.has()) {
                    j17 = troopTips0x857$GrayData.all_read.get();
                } else {
                    j17 = 0;
                }
                if (!troopTips0x857$GrayData.feed_id.has()) {
                    str2 = "";
                } else {
                    str2 = troopTips0x857$GrayData.feed_id.get();
                }
                if (0 == j17) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Utils.KEY_BUSINESS_ID, str2);
                    jSONObject.put("gc", str);
                } catch (JSONException e16) {
                    QLog.e(f213701a, 1, "jsonObj.put", e16);
                }
                try {
                    ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.mannounce", "", "UpdateAnnounce", jSONObject.toString());
                    ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.announce.lua", "", "UpdateAnnounce", jSONObject.toString());
                } catch (UnsatisfiedLinkError e17) {
                    QLog.e(f213701a, 1, "Error: arkNotify com.tencent.mannounce error. UpdateaAllConfirm.", e17);
                }
            } catch (InvalidProtocolBufferMicroException e18) {
                e18.printStackTrace();
                QLog.d(f213701a, 1, "updatePushTroopGray", e18);
            }
        }
        if (50001 == j16 && bArr != null) {
            try {
                oidb_0xe3e$ResvAttr oidb_0xe3e_resvattr = new oidb_0xe3e$ResvAttr();
                oidb_0xe3e_resvattr.mergeFrom(bArr);
                if (oidb_0xe3e_resvattr.uint32_gray_tips_from.has()) {
                    i16 = oidb_0xe3e_resvattr.uint32_gray_tips_from.get();
                }
                if (1 == i16) {
                    ReportController.o(null, "dc00898", "", "", "0X800AD1F", "0X800AD1F", 1, 0, "0", "0", "", "");
                } else if (2 == i16) {
                    ReportController.o(null, "dc00898", "", "", "0X800AD1F", "0X800AD1F", 2, 0, "0", "0", "", "");
                }
            } catch (InvalidProtocolBufferMicroException e19) {
                e19.printStackTrace();
                QLog.d(f213701a, 1, "updatePushTroopGray", e19);
            }
        }
    }

    public static boolean j(String str, QQAppInterface qQAppInterface, long j3, long j16) {
        TroopLuckyCharacterConstant.f297770a.contains(Long.valueOf(j16));
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void k(QQAppInterface qQAppInterface, g gVar, UniteEntity.Note note, int i3, String str, long j3, JSONObject jSONObject, boolean z16) {
        Iterator<UniteEntity.Note> it;
        boolean z17;
        StringBuilder sb5;
        String str2;
        HashMap<Integer, Object> hashMap;
        int i16;
        int i17;
        int length;
        g gVar2 = gVar;
        if (gVar.f() != null) {
            gVar.d();
        }
        StringBuilder sb6 = new StringBuilder();
        Iterator<UniteEntity.Note> it5 = note.mSubNotes.iterator();
        boolean z18 = true;
        while (it5.hasNext()) {
            UniteEntity.Note next = it5.next();
            int i18 = next.noteType;
            if (i18 != 2) {
                String str3 = "key_action_DATA";
                it = it5;
                if (i18 != 3) {
                    if (i18 != 4) {
                        if (i18 != 5) {
                            sb5 = sb6;
                            z17 = z18;
                        } else {
                            HashMap<Integer, Object> fields = next.getFields();
                            Set<Integer> keySet = fields.keySet();
                            int length2 = sb6.length();
                            int length3 = sb6.length();
                            Bundle bundle = new Bundle();
                            Iterator<Integer> it6 = keySet.iterator();
                            String str4 = "";
                            String str5 = str4;
                            while (it6.hasNext()) {
                                Integer next2 = it6.next();
                                Iterator<Integer> it7 = it6;
                                boolean z19 = z18;
                                if (next2.intValue() == 8) {
                                    length = length2 + 4;
                                    bundle.putString("image_resource", (String) fields.get(next2));
                                    str5 = "icon";
                                } else {
                                    if (next2.intValue() == 4) {
                                        String str6 = (String) fields.get(next2);
                                        if (!str6.startsWith("http://") && !str6.startsWith("https://")) {
                                            if (str6.startsWith("mqq")) {
                                                bundle.putInt("key_action", 3);
                                                bundle.putString("key_action_DATA", str6);
                                            }
                                        } else {
                                            bundle.putInt("key_action", 1);
                                            bundle.putString("key_action_DATA", str6);
                                        }
                                    } else if (next2.intValue() == 10) {
                                        String str7 = (String) fields.get(next2);
                                        if (!TextUtils.isEmpty(str7)) {
                                            length = str7.length() + length2;
                                            bundle.putString("image_alt", str7);
                                            str4 = str7;
                                        } else {
                                            str4 = str7;
                                        }
                                    }
                                    it6 = it7;
                                    z18 = z19;
                                }
                                length3 = length;
                                it6 = it7;
                                z18 = z19;
                            }
                            z17 = z18;
                            if (TextUtils.isEmpty(str4)) {
                                sb6.append(str5);
                            } else {
                                sb6.append(str4);
                            }
                            gVar2.b(length2, length3, bundle);
                            sb5 = sb6;
                        }
                    } else {
                        boolean z26 = z18;
                        HashMap<Integer, Object> fields2 = next.getFields();
                        Set<Integer> keySet2 = fields2.keySet();
                        int length4 = sb6.length();
                        sb6.length();
                        Bundle bundle2 = new Bundle();
                        Iterator<Integer> it8 = keySet2.iterator();
                        String str8 = "";
                        String str9 = str8;
                        boolean z27 = false;
                        StringBuilder sb7 = sb6;
                        String str10 = str9;
                        while (true) {
                            str2 = str10;
                            if (!it8.hasNext()) {
                                break;
                            }
                            Integer next3 = it8.next();
                            Iterator<Integer> it9 = it8;
                            if (next3.intValue() == 6) {
                                str8 = (String) fields2.get(next3);
                            } else if (next3.intValue() == 7) {
                                str9 = (String) fields2.get(next3);
                            } else if (next3.intValue() == 9) {
                                str10 = (String) fields2.get(next3);
                                hashMap = fields2;
                                it8 = it9;
                                fields2 = hashMap;
                            } else if (next3.intValue() == 5) {
                                String str11 = (String) fields2.get(next3);
                                if (str11.equals("2")) {
                                    bundle2.putString("textColor", "#FFFF596A");
                                } else if (str11.equals("3")) {
                                    bundle2.putString("textColor", "#FF4D94FF");
                                }
                            } else if (next3.intValue() == 4) {
                                String str12 = (String) fields2.get(next3);
                                if (!str12.startsWith("http://") && !str12.startsWith("https://")) {
                                    if (str12.startsWith("mqq")) {
                                        hashMap = fields2;
                                    } else if (j3 != 10180 && j3 != 10179) {
                                        hashMap = fields2;
                                        str12 = null;
                                        i16 = -1;
                                        i17 = -1;
                                        if (i17 != i16) {
                                            bundle2.putInt("key_action", i17);
                                            bundle2.putString("key_action_DATA", str12);
                                        }
                                        str10 = str2;
                                        it8 = it9;
                                        fields2 = hashMap;
                                    } else {
                                        hashMap = fields2;
                                        str12 = String.format(HardCodeUtil.qqStr(R.string.f23261751), str12);
                                    }
                                    i16 = -1;
                                    i17 = 3;
                                } else {
                                    hashMap = fields2;
                                    i16 = -1;
                                    i17 = 1;
                                }
                                z27 = true;
                                if (i17 != i16) {
                                }
                                str10 = str2;
                                it8 = it9;
                                fields2 = hashMap;
                            }
                            hashMap = fields2;
                            str10 = str2;
                            it8 = it9;
                            fields2 = hashMap;
                        }
                        if (str8.equals(qQAppInterface.getCurrentAccountUin())) {
                            str9 = HardCodeUtil.qqStr(R.string.uu6);
                            gVar2 = gVar;
                            if (z26) {
                                gVar2.f213696s = true;
                            }
                            if (TextUtils.equals("1", str2)) {
                                str9 = BaseApplication.getContext().getString(R.string.f13793087);
                            }
                        } else {
                            gVar2 = gVar;
                            if (ao.r(i3)) {
                                str9 = ac.y(qQAppInterface, str8);
                            } else if (ao.u(i3)) {
                                TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str8, null, f213701a);
                                if (troopMemberInfoSync != null) {
                                    str9 = troopMemberInfoSync.nickInfo.getShowName();
                                }
                                String str13 = str9;
                                if (!QLog.isColorLevel()) {
                                    QLog.e(f213701a, 2, "parseUniteGrayTipsContent name : " + str13 + ",isUiThread=" + z16 + ",hasPreloadShowInfo=" + gVar.g() + ",p=" + gVar.hashCode());
                                }
                                sb5 = sb7;
                                sb5.append(str13);
                                int length5 = length4 + str13.length();
                                if (z27) {
                                    gVar2.b(length4, length5, bundle2);
                                }
                                z18 = false;
                                sb6 = sb5;
                                it5 = it;
                            }
                        }
                        String str132 = str9;
                        if (!QLog.isColorLevel()) {
                        }
                        sb5 = sb7;
                        sb5.append(str132);
                        int length52 = length4 + str132.length();
                        if (z27) {
                        }
                        z18 = false;
                        sb6 = sb5;
                        it5 = it;
                    }
                } else {
                    sb5 = sb6;
                    z17 = z18;
                    HashMap<Integer, Object> fields3 = next.getFields();
                    Set<Integer> keySet3 = fields3.keySet();
                    int length6 = sb5.length();
                    int length7 = sb5.length();
                    Bundle bundle3 = new Bundle();
                    Iterator<Integer> it10 = keySet3.iterator();
                    int i19 = length7;
                    while (it10.hasNext()) {
                        Iterator<Integer> it11 = it10;
                        Integer next4 = it10.next();
                        String str14 = str3;
                        if (next4.intValue() == 2) {
                            String str15 = (String) fields3.get(next4);
                            sb5.append(str15);
                            i19 = str15.length() + length6;
                        } else if (next4.intValue() == 5) {
                            String str16 = (String) fields3.get(next4);
                            if (str16.equals("2")) {
                                bundle3.putString("textColor", "#FFFF596A");
                            } else if (str16.equals("3")) {
                                bundle3.putString("textColor", "#FF4D94FF");
                            }
                        } else if (next4.intValue() == 4) {
                            String str17 = (String) fields3.get(next4);
                            if (!str17.startsWith("http://") && !str17.startsWith("https://")) {
                                if (str17.startsWith("mqq")) {
                                    bundle3.putInt("key_action", 3);
                                    str3 = str14;
                                    bundle3.putString(str3, str17);
                                    gVar2 = gVar;
                                    it10 = it11;
                                }
                            } else {
                                str3 = str14;
                                bundle3.putInt("key_action", 1);
                                bundle3.putString(str3, str17);
                                gVar2 = gVar;
                                it10 = it11;
                            }
                        }
                        str3 = str14;
                        gVar2 = gVar;
                        it10 = it11;
                    }
                    gVar2.b(length6, i19, bundle3);
                }
            } else {
                it = it5;
                z17 = z18;
                sb5 = sb6;
                HashMap<Integer, Object> fields4 = next.getFields();
                for (Integer num : fields4.keySet()) {
                    Object obj = fields4.get(num);
                    if (num.intValue() == 2) {
                        sb5.append(obj);
                    }
                }
            }
            z18 = z17;
            sb6 = sb5;
            it5 = it;
        }
        StringBuilder sb8 = sb6;
        gVar2.f213683f = sb8.toString();
        QLog.d(f213701a, 2, "parseUniteGrayTipsContent content :" + ((Object) sb8));
        f213702b.c(gVar, note, i3, str, j3);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x024f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0251  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static UniteEntity l(String str) {
        UniteEntity uniteEntity;
        boolean z16;
        int i3;
        UniteEntity.Note note;
        UniteEntity.Note d16;
        if (QLog.isColorLevel()) {
            QLog.d(f213701a, 2, "parseXML " + str);
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(byteArrayInputStream, "utf-8");
            int eventType = newPullParser.getEventType();
            int i16 = 1;
            boolean z17 = true;
            uniteEntity = null;
            UniteEntity.Note note2 = null;
            UniteEntity.Note note3 = null;
            while (true) {
                if (eventType != i16) {
                    try {
                        String name = newPullParser.getName();
                        boolean z18 = z17;
                        UniteEntity uniteEntity2 = uniteEntity;
                        if (eventType != 2) {
                            if (eventType != 3) {
                                if (eventType == 4) {
                                    String text = newPullParser.getText();
                                    if (note2 != null && note2.isNorText() && !TextUtils.isEmpty(text)) {
                                        note2.addField(2, text);
                                    }
                                }
                                i3 = 1;
                                z17 = z18;
                            } else {
                                if (!name.equals("gtip") && !name.equals("dialog")) {
                                    if (name.equals("nor")) {
                                        d16 = d(note2, note3);
                                    } else if (name.equals("url")) {
                                        d16 = d(note2, note3);
                                    } else if (name.equals("qq")) {
                                        d16 = d(note2, note3);
                                    } else if (name.equals("img")) {
                                        d16 = d(note2, note3);
                                    } else if (name.equals("title")) {
                                        d16 = d(note2, note3);
                                    } else if (name.equals("alert")) {
                                        if (note2 == null) {
                                            note2 = note3;
                                        }
                                        d16 = d(note2, note3);
                                    } else if (name.equals("btn")) {
                                        if (note2 == null) {
                                            note2 = note3;
                                        }
                                        d16 = d(note2, note3);
                                    } else if (name.equals(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                                        d16 = d(note2, note3);
                                    } else if (name.equals("olstatus")) {
                                        d16 = d(note2, note3);
                                    }
                                    note3 = d16;
                                }
                                z17 = z18;
                                i3 = 1;
                                note2 = null;
                            }
                        } else {
                            if (name.equals("gtip")) {
                                if (uniteEntity2 != null) {
                                    i3 = 1;
                                    z17 = z18;
                                } else {
                                    UniteEntity uniteEntity3 = new UniteEntity(1);
                                    try {
                                        UniteEntity.Note rootNote = uniteEntity3.getRootNote();
                                        int attributeCount = newPullParser.getAttributeCount();
                                        for (int i17 = 0; i17 < attributeCount; i17++) {
                                            String attributeName = newPullParser.getAttributeName(i17);
                                            String attributeValue = newPullParser.getAttributeValue(i17);
                                            if (attributeName.equals("align")) {
                                                rootNote.addField(1, attributeValue);
                                            }
                                        }
                                        uniteEntity2 = uniteEntity3;
                                        note2 = rootNote;
                                        note3 = note2;
                                        z17 = z18;
                                        i3 = 1;
                                    } catch (Exception e16) {
                                        e = e16;
                                        uniteEntity = uniteEntity3;
                                        if (QLog.isColorLevel()) {
                                        }
                                        z16 = false;
                                        if (!z16) {
                                        }
                                    }
                                }
                            } else {
                                i3 = 1;
                                if (name.equals("dialog")) {
                                    if (uniteEntity2 == null) {
                                        UniteEntity uniteEntity4 = new UniteEntity(6);
                                        uniteEntity2 = uniteEntity4;
                                        note2 = uniteEntity4.getRootNote();
                                        note3 = note2;
                                    }
                                    z17 = z18;
                                } else {
                                    if (name.equals("nor")) {
                                        note = new UniteEntity.Note(2);
                                    } else if (name.equals("url")) {
                                        note = new UniteEntity.Note(3);
                                    } else if (name.equals("qq")) {
                                        note = new UniteEntity.Note(4);
                                    } else if (name.equals("img")) {
                                        note = new UniteEntity.Note(5);
                                    } else if (name.equals("title")) {
                                        note = new UniteEntity.Note(7);
                                    } else if (name.equals("alert")) {
                                        note = new UniteEntity.Note(8);
                                    } else if (name.equals("btn")) {
                                        note = new UniteEntity.Note(9);
                                    } else if (name.equals(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                                        note = new UniteEntity.Note(10);
                                    } else if (name.equals("olstatus")) {
                                        note = new UniteEntity.Note(11);
                                    } else {
                                        if (QLog.isColorLevel()) {
                                            QLog.i(f213701a, 2, "parseXML, illegel note: " + name);
                                        }
                                        z17 = false;
                                    }
                                    note2 = note;
                                }
                                z17 = z18;
                            }
                            if (z17) {
                                if (note3 != null) {
                                    z17 = a(note2, note3, newPullParser);
                                }
                                note3 = note2;
                            }
                        }
                        if (!z17) {
                            z16 = z17;
                            uniteEntity = uniteEntity2;
                            break;
                        }
                        try {
                            eventType = newPullParser.next();
                            i16 = i3;
                            uniteEntity = uniteEntity2;
                        } catch (Exception e17) {
                            e = e17;
                            uniteEntity = uniteEntity2;
                            if (QLog.isColorLevel()) {
                                QLog.e(f213701a, 2, "parseXML, exception: ", e);
                            }
                            z16 = false;
                            if (!z16) {
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                    }
                } else {
                    z16 = z17;
                    break;
                }
            }
        } catch (Exception e19) {
            e = e19;
            uniteEntity = null;
        }
        if (!z16) {
            return null;
        }
        return uniteEntity;
    }

    public static boolean m(String str, QQAppInterface qQAppInterface, long j3, long j16) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(f213701a, 2, "friendUin friendUin :" + str + " busiId:" + j16 + "isHideGrayfalse");
            }
            return false;
        }
        ITroopHonorService iTroopHonorService = (ITroopHonorService) qQAppInterface.getRuntimeService(ITroopHonorService.class, "");
        iTroopHonorService.isSupportTroopHonor(str);
        if (com.tencent.mobileqq.troop.honor.util.a.f(j3, j16) && (SimpleUIUtil.getSimpleUISwitch() || !iTroopHonorService.isSupportTroopHonor(str))) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f213701a, 2, "friendUin:" + str + " busiId:" + j16 + " isHideGray" + z16);
        }
        return z16;
    }

    public static boolean n(String str, QQAppInterface qQAppInterface, long j3, long j16, byte[] bArr) {
        boolean z16;
        TroopInfo troopInfo;
        boolean z17 = false;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(f213701a, 2, "shieldTroopInteractionIconGrayTip friendUin :" + str + " busiId:" + j16 + "isHideGrayfalse");
            }
            return false;
        }
        if (j16 == 1038) {
            z16 = true;
            if (((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(str)) {
                TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null) {
                    troopInfo = troopManager.B(str);
                } else {
                    troopInfo = null;
                }
                if (troopInfo != null && (troopInfo.isHomeworkTroop() || troopInfo.isQidianPrivateTroop())) {
                    z17 = true;
                }
                z16 = z17;
            }
        } else {
            boolean m3 = m(str, qQAppInterface, j3, j16);
            if (!m3) {
                z16 = j(str, qQAppInterface, j3, j16);
            } else {
                z16 = m3;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f213701a, 2, "shieldTroopInteractionIconGrayTip friendUin :" + str + " busiId:" + j16 + ",isHideGray:" + z16);
        }
        return z16;
    }

    private static void o(int i3, MessageForUniteGrayTip messageForUniteGrayTip, byte[] bArr) {
        if (i3 == 172) {
            oidb_0xe3e$ResvAttr oidb_0xe3e_resvattr = new oidb_0xe3e$ResvAttr();
            try {
                oidb_0xe3e_resvattr.mergeFrom(bArr);
                messageForUniteGrayTip.frienduin = String.valueOf(oidb_0xe3e_resvattr.uint64_qqstranger_to_tinyid.get());
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.d(f213701a, 1, "decoding tinyId is fail");
            }
        }
    }
}
