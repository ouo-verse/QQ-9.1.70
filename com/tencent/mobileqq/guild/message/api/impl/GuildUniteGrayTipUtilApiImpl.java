package com.tencent.mobileqq.guild.message.api.impl;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Xml;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.guild.data.l;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildNicknameApi;
import com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi;
import com.tencent.mobileqq.guild.message.base.p;
import com.tencent.mobileqq.guild.temp.api.CombineGrayTipFilter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.xweb.FileReaderHelper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.group_pro_proto.msgpush.servtype$CommGrayTips;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildUniteGrayTipUtilApiImpl implements IGuildUniteGrayTipUtilApi {
    private static final int GRAYTIPS_EMOREPLY_LENGTH_LIMIT = 13;
    private static final int NICKNAME_MAX_SIZE = 15;
    private static final int NICK_LENGTH_LIMIT_1 = 6;
    private static final int NICK_LENGTH_LIMIT_2 = 14;
    private static String TAG = "GuildUniteGrayTipUtilApiImpl";
    private static p grayTipUtilsCB;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Comparator<GrayTipsMessageConstants$HighlightItem> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem2) {
            return grayTipsMessageConstants$HighlightItem.start - grayTipsMessageConstants$HighlightItem2.start;
        }
    }

    static {
        try {
            ArrayList<Class<? extends p>> arrayList = vt1.a.f443342d;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Class<? extends p>> it = vt1.a.f443342d.iterator();
                while (it.hasNext()) {
                    grayTipUtilsCB = it.next().newInstance();
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[static] ", e16);
        }
    }

    private void addWordingNoteDataToList(MessageForUniteGrayTip messageForUniteGrayTip, int i3, String str, UniteEntity.Note note) {
        if (messageForUniteGrayTip != null && messageForUniteGrayTip.uniteCombineGrayTipParam != null) {
            com.tencent.mobileqq.graytip.j jVar = new com.tencent.mobileqq.graytip.j(i3, str, note);
            com.tencent.mobileqq.graytip.d dVar = messageForUniteGrayTip.uniteCombineGrayTipParam;
            if (dVar.f213673b == null) {
                dVar.f213673b = new ArrayList();
            }
            messageForUniteGrayTip.uniteCombineGrayTipParam.f213673b.add(jVar);
        }
    }

    private boolean checkNickNeedFrontSpace(StringBuilder sb5) {
        String sb6 = sb5.toString();
        boolean find = Pattern.compile("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~\uff01@#\uffe5\u2026\u2026&*\uff08\uff09\u2014\u2014|{}\u3010\u3011\u2018\uff1b\uff1a\u201d\u201c'\u3002\uff0c\u3001\uff1f]$").matcher(sb6).find();
        if (!TextUtils.isEmpty(sb6) && !sb6.equals("icon") && !find) {
            return true;
        }
        return false;
    }

    private boolean createNote(UniteEntity.Note note, UniteEntity.Note note2, XmlPullParser xmlPullParser) {
        note.setParent(note2);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (attributeName.equals(FileReaderHelper.TXT_EXT)) {
                note.addField(2, attributeValue);
            } else if (attributeName.equals("jp")) {
                note.addField(4, attributeValue);
            } else if (!attributeName.equals("uin") && !attributeName.equals("tinyid")) {
                if (attributeName.equals("nm")) {
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
                } else if (attributeName.equals("openid")) {
                    note.addField(14, attributeValue);
                } else {
                    if (!QLog.isColorLevel()) {
                        return false;
                    }
                    QLog.i(TAG, 2, "parseXML, illegel field: " + attributeName);
                    return false;
                }
            } else {
                note.addField(6, attributeValue);
            }
        }
        return true;
    }

    private void decodeImageSpan(l lVar, SpannableStringBuilder spannableStringBuilder, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getDisplayName(AppRuntime appRuntime, String str, String str2, String str3, String str4, StringBuilder sb5, boolean z16, MessageForUniteGrayTip messageForUniteGrayTip) {
        IGuildNicknameApi iGuildNicknameApi;
        String str5;
        boolean checkNickNeedFrontSpace = checkNickNeedFrontSpace(sb5);
        String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        boolean z17 = false;
        if (!TextUtils.isEmpty(str2) && (str2.equals(appRuntime.getCurrentAccountUin()) || str2.equals(selfTinyId))) {
            String qqStr = HardCodeUtil.qqStr(R.string.f158081on);
            if (TextUtils.equals("1", str3)) {
                qqStr = HardCodeUtil.qqStr(R.string.f158091oo);
            }
            str4 = qqStr;
            checkNickNeedFrontSpace = false;
        } else if (!TextUtils.isEmpty(str2)) {
            try {
                iGuildNicknameApi = (IGuildNicknameApi) QRoute.api(IGuildNicknameApi.class);
                if (TextUtils.isEmpty(str4)) {
                    str4 = iGuildNicknameApi.getDisplayName(appRuntime, str, str2, messageForUniteGrayTip);
                }
            } catch (Exception e16) {
                e = e16;
                z17 = true;
            }
            try {
                if (z16) {
                    str5 = iGuildNicknameApi.removeIncompleteEmoji(str4, getLimitLength(str4.length(), messageForUniteGrayTip));
                    if (str5.length() < str4.length()) {
                        str5 = str5 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                        QLog.d(TAG, 2, "parseUniteGrayTipsContent, getDisplayName, uin: " + str2 + ", result: " + str5 + ", bTrimNickname: " + z16 + ", nickName: " + str4);
                        str4 = str5;
                    }
                } else {
                    str5 = str4;
                }
                QLog.d(TAG, 2, "parseUniteGrayTipsContent, getDisplayName, uin: " + str2 + ", result: " + str5 + ", bTrimNickname: " + z16 + ", nickName: " + str4);
                str4 = str5;
            } catch (Exception e17) {
                e = e17;
                QLog.e(TAG, 1, "parseUniteGrayTipsContent, getDisplayName, uin: " + str2 + ", exception: " + e.toString());
                str4 = str2;
                if (checkNickNeedFrontSpace) {
                }
                if (z17) {
                }
                QLog.d(TAG, 2, "parseUniteGrayTipsContent, getDisplayName, uin: " + str2 + ", result: " + str4 + ", needFrontSpace: " + checkNickNeedFrontSpace + ", needBackSpace: " + z17 + ", content: " + sb5.toString());
                return str4;
            }
            z17 = true;
        } else {
            z17 = true;
        }
        if (checkNickNeedFrontSpace) {
            str4 = " " + str4;
        }
        if (z17) {
            str4 = str4 + " ";
        }
        QLog.d(TAG, 2, "parseUniteGrayTipsContent, getDisplayName, uin: " + str2 + ", result: " + str4 + ", needFrontSpace: " + checkNickNeedFrontSpace + ", needBackSpace: " + z17 + ", content: " + sb5.toString());
        return str4;
    }

    private int getLimitLength(int i3, MessageForUniteGrayTip messageForUniteGrayTip) {
        if (isGrayTipsEmoReply(messageForUniteGrayTip)) {
            if (FontSettingManager.getFontLevel() <= 16.0f) {
                if (i3 >= 13) {
                    return 12;
                }
                return i3;
            }
            if (i3 < 6) {
                return i3;
            }
        } else {
            if (i3 >= 15) {
                return 14;
            }
            if (i3 < 6) {
                return i3;
            }
        }
        return 6;
    }

    private static UniteEntity.Note getParentNote(UniteEntity.Note note, UniteEntity.Note note2) {
        if (note != null) {
            return note.getParent();
        }
        return note2;
    }

    private SpannableStringBuilder getSpannableStringBuilder(l lVar, String str, ArrayList<GrayTipsMessageConstants$HighlightItem> arrayList) {
        throw null;
    }

    private boolean isGrayTipsEmoReply(MessageForUniteGrayTip messageForUniteGrayTip) {
        String extInfoFromExtStr = messageForUniteGrayTip.getExtInfoFromExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_CONTENT);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "contentXml:" + extInfoFromExtStr);
        }
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            return false;
        }
        return extInfoFromExtStr.contains("mqqapi://channel/emotionReply");
    }

    private void parseUniteGrayTipsContent(AppRuntime appRuntime, com.tencent.mobileqq.graytip.g gVar, UniteEntity.Note note, String str, boolean z16, MessageForUniteGrayTip messageForUniteGrayTip) {
        Iterator<UniteEntity.Note> it;
        com.tencent.mobileqq.graytip.g gVar2;
        MessageForUniteGrayTip messageForUniteGrayTip2;
        Object obj;
        String str2;
        String str3;
        int i3;
        String str4;
        String str5;
        HashMap<Integer, Object> hashMap;
        int i16;
        String str6;
        String str7;
        String str8;
        Object obj2;
        String str9;
        Object obj3;
        String str10;
        GuildUniteGrayTipUtilApiImpl guildUniteGrayTipUtilApiImpl = this;
        com.tencent.mobileqq.graytip.g gVar3 = gVar;
        MessageForUniteGrayTip messageForUniteGrayTip3 = messageForUniteGrayTip;
        if (gVar.f() != null) {
            gVar.d();
        }
        if (CombineGrayTipFilter.b(messageForUniteGrayTip)) {
            com.tencent.mobileqq.graytip.d dVar = messageForUniteGrayTip3.uniteCombineGrayTipParam;
            if (dVar == null) {
                messageForUniteGrayTip3.uniteCombineGrayTipParam = new com.tencent.mobileqq.graytip.d();
            } else {
                dVar.a();
            }
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<UniteEntity.Note> it5 = note.getSubNotes().iterator();
        while (it5.hasNext()) {
            UniteEntity.Note next = it5.next();
            int noteType = next.getNoteType();
            if (noteType != 2) {
                String str11 = "#FFFF596A";
                String str12 = TenpayJumpActivity.TENPAY_SCHEME;
                it = it5;
                String str13 = "#3AB0FF";
                String str14 = "key_action";
                Object obj4 = "3";
                if (noteType != 3) {
                    String str15 = "";
                    if (noteType != 4) {
                        if (noteType == 5) {
                            HashMap<Integer, Object> fields = next.getFields();
                            Set<Integer> keySet = fields.keySet();
                            int length = sb5.length();
                            int length2 = sb5.length();
                            Bundle bundle = new Bundle();
                            Iterator<Integer> it6 = keySet.iterator();
                            int i17 = length2;
                            String str16 = str15;
                            String str17 = str16;
                            while (it6.hasNext()) {
                                Iterator<Integer> it7 = it6;
                                Integer next2 = it6.next();
                                if (next2.intValue() == 8) {
                                    bundle.putString("image_resource", (String) fields.get(next2));
                                    str17 = "icon";
                                    i17 = length + 4;
                                } else if (next2.intValue() == 4) {
                                    String str18 = (String) fields.get(next2);
                                    if (!str18.startsWith("http://") && !str18.startsWith("https://")) {
                                        if (str18.startsWith("mqq") || str18.startsWith(TenpayJumpActivity.TENPAY_SCHEME)) {
                                            bundle.putInt("key_action", 3);
                                            bundle.putString("key_action_DATA", str18);
                                        }
                                    } else {
                                        bundle.putInt("key_action", 1);
                                        bundle.putString("key_action_DATA", str18);
                                    }
                                } else if (next2.intValue() == 10) {
                                    String str19 = (String) fields.get(next2);
                                    if (!TextUtils.isEmpty(str19)) {
                                        int length3 = str19.length() + length;
                                        bundle.putString("image_alt", str19);
                                        i17 = length3;
                                    }
                                    str16 = str19;
                                }
                                it6 = it7;
                            }
                            if (TextUtils.isEmpty(str16)) {
                                sb5.append(str17);
                                guildUniteGrayTipUtilApiImpl = this;
                                messageForUniteGrayTip3 = messageForUniteGrayTip;
                                guildUniteGrayTipUtilApiImpl.addWordingNoteDataToList(messageForUniteGrayTip3, next.getNoteType(), str17, next);
                            } else {
                                guildUniteGrayTipUtilApiImpl = this;
                                messageForUniteGrayTip3 = messageForUniteGrayTip;
                                sb5.append(str16);
                                guildUniteGrayTipUtilApiImpl.addWordingNoteDataToList(messageForUniteGrayTip3, next.getNoteType(), str16, next);
                            }
                            gVar3 = gVar;
                            gVar3.b(length, i17, bundle);
                        }
                        gVar2 = gVar3;
                        messageForUniteGrayTip2 = messageForUniteGrayTip3;
                    } else {
                        HashMap<Integer, Object> fields2 = next.getFields();
                        Set<Integer> keySet2 = fields2.keySet();
                        int length4 = sb5.length();
                        sb5.length();
                        Bundle bundle2 = new Bundle();
                        Iterator<Integer> it8 = keySet2.iterator();
                        String str20 = str15;
                        boolean z17 = false;
                        String str21 = str20;
                        while (it8.hasNext()) {
                            Iterator<Integer> it9 = it8;
                            Integer next3 = it8.next();
                            UniteEntity.Note note2 = next;
                            if (next3.intValue() == 6) {
                                str15 = (String) fields2.get(next3);
                            } else if (next3.intValue() == 7) {
                                str20 = (String) fields2.get(next3);
                            } else if (next3.intValue() == 9) {
                                str21 = (String) fields2.get(next3);
                            } else if (next3.intValue() == 5) {
                                String str22 = (String) fields2.get(next3);
                                if (str22.equals("2")) {
                                    bundle2.putString("textColor", "#FFFF596A");
                                    str10 = str13;
                                    obj3 = obj4;
                                } else {
                                    obj3 = obj4;
                                    str10 = str13;
                                    if (str22.equals(obj3)) {
                                        bundle2.putString("textColor", str10);
                                    }
                                }
                                obj4 = obj3;
                                str13 = str10;
                            } else if (next3.intValue() == 4) {
                                String str23 = (String) fields2.get(next3);
                                if (!str23.startsWith("http://") && !str23.startsWith("https://")) {
                                    if (str23.startsWith("mqq") || str23.startsWith(TenpayJumpActivity.TENPAY_SCHEME)) {
                                        bundle2.putInt("key_action", 3);
                                        bundle2.putString("key_action_DATA", str23);
                                    }
                                } else {
                                    bundle2.putInt("key_action", 1);
                                    bundle2.putString("key_action_DATA", str23);
                                }
                                z17 = true;
                            }
                            next = note2;
                            it8 = it9;
                        }
                        UniteEntity.Note note3 = next;
                        String displayName = getDisplayName(appRuntime, str, str15, str21, str20, sb5, z16, messageForUniteGrayTip);
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "parseUniteGrayTipsContent name : " + displayName);
                        }
                        sb5.append(displayName);
                        int length5 = displayName.length() + length4;
                        if (z17) {
                            gVar.b(length4, length5, bundle2);
                        }
                        guildUniteGrayTipUtilApiImpl = this;
                        messageForUniteGrayTip2 = messageForUniteGrayTip;
                        guildUniteGrayTipUtilApiImpl.addWordingNoteDataToList(messageForUniteGrayTip2, note3.getNoteType(), displayName, note3);
                        gVar2 = gVar;
                    }
                } else {
                    messageForUniteGrayTip2 = messageForUniteGrayTip3;
                    HashMap<Integer, Object> fields3 = next.getFields();
                    Set<Integer> keySet3 = fields3.keySet();
                    int length6 = sb5.length();
                    int length7 = sb5.length();
                    String str24 = "key_action_DATA";
                    Bundle bundle3 = new Bundle();
                    Iterator<Integer> it10 = keySet3.iterator();
                    int i18 = length7;
                    while (it10.hasNext()) {
                        Iterator<Integer> it11 = it10;
                        Integer next4 = it10.next();
                        String str25 = str14;
                        String str26 = str12;
                        if (next4.intValue() == 2) {
                            String str27 = (String) fields3.get(next4);
                            sb5.append(str27);
                            int length8 = str27.length() + length6;
                            guildUniteGrayTipUtilApiImpl.addWordingNoteDataToList(messageForUniteGrayTip2, next.getNoteType(), str27, next);
                            str3 = str11;
                            i18 = length8;
                            obj = obj4;
                            str5 = str25;
                            str12 = str26;
                            str2 = str13;
                        } else if (next4.intValue() == 5) {
                            String str28 = (String) fields3.get(next4);
                            if (str28.equals("2")) {
                                bundle3.putString("textColor", str11);
                                str9 = str13;
                                obj2 = obj4;
                            } else {
                                obj2 = obj4;
                                if (str28.equals(obj2)) {
                                    str9 = str13;
                                    bundle3.putString("textColor", str9);
                                } else {
                                    str9 = str13;
                                }
                            }
                            str2 = str9;
                            str3 = str11;
                            obj = obj2;
                            str5 = str25;
                            str12 = str26;
                        } else {
                            obj = obj4;
                            str2 = str13;
                            if (next4.intValue() == 4) {
                                String str29 = (String) fields3.get(next4);
                                if (!str29.startsWith("http://") && !str29.startsWith("https://")) {
                                    if (str29.startsWith("mqq")) {
                                        str8 = str26;
                                    } else {
                                        str8 = str26;
                                        if (!str29.startsWith(str8) && !str29.startsWith(WadlProxyConsts.CHANNEL)) {
                                            str3 = str11;
                                            str6 = str25;
                                            str7 = str24;
                                            i3 = length6;
                                        }
                                    }
                                    str3 = str11;
                                    str6 = str25;
                                    bundle3.putInt(str6, 3);
                                    str7 = str24;
                                    bundle3.putString(str7, str29);
                                    i3 = length6;
                                } else {
                                    str3 = str11;
                                    str6 = str25;
                                    str7 = str24;
                                    str8 = str26;
                                    i3 = length6;
                                    bundle3.putInt(str6, 1);
                                    bundle3.putString(str7, str29);
                                }
                                str4 = str7;
                                str5 = str6;
                                str12 = str8;
                            } else {
                                str3 = str11;
                                String str30 = str24;
                                str12 = str26;
                                i3 = length6;
                                str4 = str30;
                                if (next4.intValue() == 14) {
                                    String str31 = (String) fields3.get(next4);
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(str31);
                                    sb6.append(ContainerUtils.FIELD_DELIMITER);
                                    str5 = str25;
                                    hashMap = fields3;
                                    i16 = i3;
                                    sb6.append(gVar.f213681d);
                                    sb6.append(ContainerUtils.FIELD_DELIMITER);
                                    sb6.append(str);
                                    bundle3.putString("key_a_action_DATA", sb6.toString());
                                    length6 = i16;
                                    str11 = str3;
                                    str13 = str2;
                                    fields3 = hashMap;
                                    it10 = it11;
                                    str24 = str4;
                                    str14 = str5;
                                    obj4 = obj;
                                } else {
                                    str5 = str25;
                                }
                            }
                            int i19 = i3;
                            hashMap = fields3;
                            i16 = i19;
                            length6 = i16;
                            str11 = str3;
                            str13 = str2;
                            fields3 = hashMap;
                            it10 = it11;
                            str24 = str4;
                            str14 = str5;
                            obj4 = obj;
                        }
                        str4 = str24;
                        hashMap = fields3;
                        i16 = length6;
                        length6 = i16;
                        str11 = str3;
                        str13 = str2;
                        fields3 = hashMap;
                        it10 = it11;
                        str24 = str4;
                        str14 = str5;
                        obj4 = obj;
                    }
                    gVar2 = gVar;
                    gVar2.b(length6, i18, bundle3);
                }
            } else {
                it = it5;
                gVar2 = gVar3;
                messageForUniteGrayTip2 = messageForUniteGrayTip3;
                HashMap<Integer, Object> fields4 = next.getFields();
                for (Integer num : fields4.keySet()) {
                    Object obj5 = fields4.get(num);
                    if (num.intValue() == 2) {
                        sb5.append(obj5);
                        guildUniteGrayTipUtilApiImpl.addWordingNoteDataToList(messageForUniteGrayTip2, next.getNoteType(), String.valueOf(obj5), next);
                    }
                }
            }
            messageForUniteGrayTip3 = messageForUniteGrayTip2;
            gVar3 = gVar2;
            it5 = it;
        }
        gVar3.f213683f = sb5.toString();
        QLog.d(TAG, 2, "parseUniteGrayTipsContent content :" + ((Object) sb5));
    }

    private ArrayList<GrayTipsMessageConstants$HighlightItem> sortHighlightItems(MessageForUniteGrayTip messageForUniteGrayTip) {
        ArrayList<GrayTipsMessageConstants$HighlightItem> f16 = messageForUniteGrayTip.tipParam.f();
        Collections.sort(f16, new a());
        return f16;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi
    public MessageForUniteGrayTip createUniteGrayTip(AppRuntime appRuntime, String str, String str2, int i3, int i16, long j3, String str3) {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "createUniteGrayTip contentXml " + str3);
        }
        UniteEntity parseXML = parseXML(str3);
        if (parseXML == null) {
            return null;
        }
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, appRuntime.getCurrentAccountUin(), "", i3, i16, 655397, j3);
        UniteEntity.Note rootNote = parseXML.getRootNote();
        if (rootNote == null) {
            return null;
        }
        HashMap<Integer, Object> fields = rootNote.getFields();
        String str4 = "";
        for (Integer num : fields.keySet()) {
            Object obj = fields.get(num);
            if (num.intValue() == 1) {
                str4 = (String) obj;
            }
        }
        parseUniteGrayTipsContent(appRuntime, gVar, rootNote, str2, false, null);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(appRuntime, gVar);
        messageForUniteGrayTip.saveExtInfoToExtStr("unite_gray_tips_align", str4);
        messageForUniteGrayTip.saveExtInfoToExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_SUMMERY, gVar.f213683f);
        return messageForUniteGrayTip;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi
    public String getBusiId(MessageRecord messageRecord) {
        if (!(messageRecord instanceof MessageForUniteGrayTip)) {
            return null;
        }
        return messageRecord.getExtInfoFromExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_BUSI_ID);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi
    public String getBytesContent(MessageRecord messageRecord) {
        if (!(messageRecord instanceof MessageForUniteGrayTip)) {
            return null;
        }
        return messageRecord.getExtInfoFromExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_CONTENT);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi
    public SpannableStringBuilder getHighlightMsgText(l lVar) {
        throw null;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi
    public int getMsgType(int i3, boolean z16) {
        boolean z17;
        boolean z18;
        int i16;
        boolean z19 = false;
        if ((i3 & 1) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((i3 & 2) == 2) {
            z18 = true;
        } else {
            z18 = false;
        }
        if ((i3 & 4) == 4) {
            z19 = true;
        }
        int i17 = MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL;
        if (z16) {
            i16 = -5040;
        } else {
            i16 = -4100;
        }
        if (z17) {
            if (z18) {
                if (z19) {
                    if (!z16) {
                        i17 = -4100;
                    }
                    return i17;
                }
                return MessageRecord.MSG_TYPE_UNITE_GRAY_HISTORY_INVI;
            }
            return i16;
        }
        if (z18) {
            if (z19) {
                return MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI;
            }
            return MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI;
        }
        return MessageRecord.MSG_TYPE_UNITE_TAB_DB_INVI;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi
    public String getTemplParamsJson(List<servtype$CommGrayTips.TemplParam> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (servtype$CommGrayTips.TemplParam templParam : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bytes_name", templParam.bytes_name.get().toStringUtf8());
                jSONObject.put("bytes_value", templParam.bytes_value.get().toStringUtf8());
                jSONArray.mo162put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
            return "";
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi
    public boolean isGrayTipMsg(MessageRecord messageRecord) {
        int i3 = messageRecord.msgtype;
        if (i3 != -5040 && i3 != -4100 && i3 != -5021 && i3 != -5020 && i3 != -5023 && i3 != -5022) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x024a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x024c  */
    @Override // com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UniteEntity parseXML(String str) {
        UniteEntity uniteEntity;
        boolean z16;
        boolean z17;
        int i3;
        UniteEntity.Note note;
        UniteEntity uniteEntity2;
        UniteEntity.Note rootNote;
        boolean z18;
        UniteEntity.Note parentNote;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "parseXML " + str);
        }
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(byteArrayInputStream, "utf-8");
            int eventType = newPullParser.getEventType();
            int i16 = 1;
            boolean z19 = true;
            uniteEntity = null;
            UniteEntity.Note note2 = null;
            UniteEntity.Note note3 = null;
            while (true) {
                if (eventType != i16) {
                    try {
                        String name = newPullParser.getName();
                        z17 = z19;
                        UniteEntity uniteEntity3 = uniteEntity;
                        if (eventType != 2) {
                            if (eventType != 3) {
                                if (eventType == 4) {
                                    try {
                                        String text = newPullParser.getText();
                                        if (note2 != null && note2.isNorText() && !TextUtils.isEmpty(text)) {
                                            note2.addField(2, text);
                                        }
                                    } catch (Exception e16) {
                                        e = e16;
                                        uniteEntity = uniteEntity3;
                                        if (QLog.isColorLevel()) {
                                        }
                                        z16 = false;
                                        if (z16) {
                                        }
                                    }
                                }
                                i3 = 1;
                                uniteEntity = uniteEntity3;
                            } else {
                                if (!name.equals("gtip") && !name.equals("dialog")) {
                                    if (name.equals("nor")) {
                                        parentNote = getParentNote(note2, note3);
                                    } else if (name.equals("url")) {
                                        parentNote = getParentNote(note2, note3);
                                    } else if (name.equals("qq")) {
                                        parentNote = getParentNote(note2, note3);
                                    } else if (name.equals("img")) {
                                        parentNote = getParentNote(note2, note3);
                                    } else if (name.equals("title")) {
                                        parentNote = getParentNote(note2, note3);
                                    } else if (name.equals("alert")) {
                                        if (note2 == null) {
                                            note2 = note3;
                                        }
                                        parentNote = getParentNote(note2, note3);
                                    } else if (name.equals("btn")) {
                                        if (note2 == null) {
                                            note2 = note3;
                                        }
                                        parentNote = getParentNote(note2, note3);
                                    } else if (name.equals(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                                        parentNote = getParentNote(note2, note3);
                                    } else if (name.equals("olstatus")) {
                                        parentNote = getParentNote(note2, note3);
                                    }
                                    note3 = parentNote;
                                }
                                i3 = 1;
                                note2 = null;
                                uniteEntity = uniteEntity3;
                            }
                        } else {
                            if (name.equals("gtip")) {
                                if (uniteEntity3 != null) {
                                    i3 = 1;
                                    uniteEntity = uniteEntity3;
                                } else {
                                    uniteEntity2 = new UniteEntity(1);
                                    try {
                                        rootNote = uniteEntity2.getRootNote();
                                        int attributeCount = newPullParser.getAttributeCount();
                                        for (int i17 = 0; i17 < attributeCount; i17++) {
                                            String attributeName = newPullParser.getAttributeName(i17);
                                            Object attributeValue = newPullParser.getAttributeValue(i17);
                                            if (attributeName.equals("align")) {
                                                rootNote.addField(1, attributeValue);
                                            }
                                        }
                                        i3 = 1;
                                    } catch (Exception e17) {
                                        e = e17;
                                        uniteEntity = uniteEntity2;
                                        if (QLog.isColorLevel()) {
                                            QLog.e(TAG, 2, "parseXML, exception: ", e);
                                        }
                                        z16 = false;
                                        if (z16) {
                                        }
                                    }
                                }
                            } else {
                                i3 = 1;
                                if (name.equals("dialog")) {
                                    if (uniteEntity3 == null) {
                                        uniteEntity2 = new UniteEntity(6);
                                        rootNote = uniteEntity2.getRootNote();
                                    }
                                    uniteEntity = uniteEntity3;
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
                                    } else {
                                        if (QLog.isColorLevel()) {
                                            QLog.i(TAG, 2, "parseXML, illegel note: " + name);
                                        }
                                        uniteEntity = uniteEntity3;
                                        z17 = false;
                                        if (z17) {
                                            if (note3 != null) {
                                                z18 = createNote(note2, note3, newPullParser);
                                            } else {
                                                z18 = z17;
                                            }
                                            z17 = z18;
                                            note3 = note2;
                                        }
                                    }
                                    note2 = note;
                                    uniteEntity = uniteEntity3;
                                    if (z17) {
                                    }
                                }
                            }
                            uniteEntity = uniteEntity2;
                            note2 = rootNote;
                            note3 = note2;
                            if (z17) {
                            }
                        }
                        if (!z17) {
                            break;
                        }
                        try {
                            eventType = newPullParser.next();
                            i16 = i3;
                            z19 = z17;
                        } catch (Exception e18) {
                            e = e18;
                            if (QLog.isColorLevel()) {
                            }
                            z16 = false;
                            if (z16) {
                            }
                        }
                    } catch (Exception e19) {
                        e = e19;
                    }
                } else {
                    z17 = z19;
                    break;
                }
            }
            z16 = z17;
        } catch (Exception e26) {
            e = e26;
            uniteEntity = null;
        }
        if (z16) {
            return null;
        }
        return uniteEntity;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi
    public void rebuildUniteTipsContent(AppRuntime appRuntime, MessageForUniteGrayTip messageForUniteGrayTip, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "rebuildUniteTipsContent");
        }
        com.tencent.mobileqq.graytip.g gVar = messageForUniteGrayTip.tipParam;
        String extInfoFromExtStr = messageForUniteGrayTip.getExtInfoFromExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_CONTENT);
        if (gVar != null && gVar.f213685h == 655397 && !TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                UniteEntity uniteEntity = messageForUniteGrayTip.entity;
                if (uniteEntity == null) {
                    UniteEntity parseXML = parseXML(extInfoFromExtStr);
                    if (parseXML != null) {
                        messageForUniteGrayTip.entity = parseXML;
                        parseUniteGrayTipsContent(appRuntime, gVar, parseXML.getRootNote(), String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(messageForUniteGrayTip)), z16, messageForUniteGrayTip);
                        String str = gVar.f213683f;
                        messageForUniteGrayTip.f203106msg = str;
                        messageForUniteGrayTip.saveExtInfoToExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_SUMMERY, str);
                    }
                } else if (com.tencent.mobileqq.guild.temp.api.a.c(messageForUniteGrayTip)) {
                    parseUniteGrayTipsContent(appRuntime, gVar, uniteEntity.getRootNote(), String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(messageForUniteGrayTip)), z16, messageForUniteGrayTip);
                    String str2 = gVar.f213683f;
                    messageForUniteGrayTip.f203106msg = str2;
                    messageForUniteGrayTip.saveExtInfoToExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_SUMMERY, str2);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }
}
