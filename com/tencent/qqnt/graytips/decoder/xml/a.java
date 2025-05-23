package com.tencent.qqnt.graytips.decoder.xml;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.e;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.graytips.action.f;
import com.tencent.qqnt.graytips.action.k;
import com.tencent.qqnt.graytips.action.p;
import com.tencent.qqnt.graytips.action.q;
import com.tencent.qqnt.graytips.action.r;
import com.tencent.qqnt.graytips.action.u;
import com.tencent.qqnt.graytips.c;
import com.tencent.qqnt.graytips.decoder.d;
import com.tencent.qqnt.graytips.decoder.xml.UniteEntity;
import com.tencent.qqnt.graytips.util.h;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.XmlElement;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static float a(SpannableStringBuilder spannableStringBuilder, String str, TextPaint textPaint, float f16, float f17, boolean z16) {
        if (!TextUtils.isEmpty(str) && textPaint != null) {
            float measureText = textPaint.measureText(str);
            float f18 = f16 + measureText;
            if (f18 > f17) {
                if (z16) {
                    spannableStringBuilder.append((CharSequence) ("\n" + str));
                    return measureText;
                }
                spannableStringBuilder.append((CharSequence) str);
                return f18 - f17;
            }
            spannableStringBuilder.append((CharSequence) str);
            return f18;
        }
        return f17;
    }

    private static boolean b(UniteEntity.Note note, UniteEntity.Note note2, XmlPullParser xmlPullParser) {
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
            } else if (attributeName.equals("ext_uin")) {
                note.addField(15, attributeValue);
            } else if (attributeName.equals(AppConstants.Key.COLUMN_MSG_SEQ)) {
                note.addField(16, attributeValue);
            } else if (attributeName.equals("type")) {
                note.addField(18, attributeValue);
            } else if (attributeName.equals("id")) {
                note.addField(17, attributeValue);
            } else {
                if (!QLog.isColorLevel()) {
                    return false;
                }
                QLog.i("XMLGrayTipsUtils", 2, "parseXML, illegel field: " + attributeName);
                return false;
            }
        }
        return true;
    }

    private static String[] c(UniteEntity.Note note) {
        ArrayList<UniteEntity.Note> subNotes = note.getSubNotes();
        int i3 = -1;
        String str = "";
        String str2 = "";
        int i16 = 0;
        while (true) {
            if (i16 >= subNotes.size()) {
                break;
            }
            UniteEntity.Note note2 = subNotes.get(i16);
            if (note2.getNoteType() == 4) {
                i3++;
                if (i3 == 0) {
                    str2 = (String) note2.getFields().get(6);
                }
                if (i3 == 1) {
                    str = (String) note2.getFields().get(6);
                    break;
                }
            }
            i16++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("XMLGrayTipsUtils", 2, "getPlayPaiYiPaiAvatars() fromUin = [" + str2 + "], toUin = [" + str + "]");
        }
        return new String[]{str2, str};
    }

    private static UniteEntity.Note d(UniteEntity.Note note, UniteEntity.Note note2) {
        if (note != null) {
            return note.getParent();
        }
        return note2;
    }

    private static boolean e(@Nullable XmlElement xmlElement) {
        if (xmlElement == null || xmlElement.getBusiId() != 1061 || xmlElement.getBusiType() != 12) {
            return false;
        }
        return true;
    }

    private static Pair<CharSequence, List<c>> f(AppRuntime appRuntime, UniteEntity.Note note, XmlElement xmlElement, String str) {
        ArrayList arrayList;
        float f16;
        TextPaint textPaint;
        Iterator<UniteEntity.Note> it;
        boolean z16;
        String str2;
        String str3;
        int i3;
        int i16;
        boolean z17;
        f fVar;
        long longValue;
        f uVar;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList2 = new ArrayList();
        e(xmlElement);
        float f17 = e.f194142a.f() - ViewUtils.dpToPx(72.0f);
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setTextSize(ViewUtils.dpToPx(12.0f));
        Iterator<UniteEntity.Note> it5 = note.mSubNotes.iterator();
        float f18 = 0.0f;
        while (it5.hasNext()) {
            UniteEntity.Note next = it5.next();
            int i17 = next.noteType;
            if (i17 != 2) {
                p pVar = null;
                String str4 = "";
                it = it5;
                if (i17 != 3) {
                    if (i17 != 4) {
                        if (i17 != 5) {
                            if (i17 == 12) {
                                HashMap<Integer, Object> fields = next.getFields();
                                int i18 = -1;
                                int i19 = -1;
                                for (Integer num : fields.keySet()) {
                                    try {
                                        if (num.intValue() == 18) {
                                            i18 = Integer.parseInt((String) fields.get(num));
                                        } else if (num.intValue() == 17) {
                                            i19 = Integer.parseInt((String) fields.get(num));
                                        }
                                    } catch (NumberFormatException e16) {
                                        QLog.d("XMLGrayTipsUtils", 1, "parseEntity2CharSequence error: " + e16);
                                    }
                                }
                                QLog.d("XMLGrayTipsUtils", 1, "parseEntity2CharSequence NOTE_FACE: faceType=" + i18 + " faceIndex=" + i19);
                                if (i18 != -1 && i19 != -1) {
                                    f18 += ViewUtils.dpToPx(10.0f);
                                    if (f18 > f17) {
                                        f18 = ViewUtils.dpToPx(10.0f);
                                    }
                                    spannableStringBuilder.append(((IEmojiSpanService) QRoute.api(IEmojiSpanService.class)).createSysAndEmojiSpanText(i18, i19, 0, true, 10));
                                }
                            }
                        } else {
                            f18 += ViewUtils.dpToPx(16.0f);
                            if (f18 > f17) {
                                f18 = ViewUtils.dpToPx(16.0f);
                            }
                            HashMap<Integer, Object> fields2 = next.getFields();
                            Set<Integer> keySet = fields2.keySet();
                            int length = spannableStringBuilder.length();
                            int length2 = spannableStringBuilder.length();
                            int i26 = length2;
                            f fVar2 = null;
                            String str5 = "";
                            String str6 = str5;
                            String str7 = str6;
                            for (Integer num2 : keySet) {
                                if (num2.intValue() == 8) {
                                    i26 = length + 1;
                                    str7 = (String) fields2.get(num2);
                                    str5 = " ";
                                } else if (num2.intValue() == 4) {
                                    String str8 = (String) fields2.get(num2);
                                    if (!str8.startsWith("http://") && !str8.startsWith("https://")) {
                                        if (str8.startsWith("mqq")) {
                                            uVar = new k(str8);
                                        }
                                    } else {
                                        uVar = new u(str8);
                                    }
                                    fVar2 = uVar;
                                } else if (num2.intValue() == 10) {
                                    str6 = (String) fields2.get(num2);
                                    if (!TextUtils.isEmpty(str6)) {
                                        i26 = length + str6.length();
                                    }
                                }
                            }
                            if (TextUtils.isEmpty(str6)) {
                                spannableStringBuilder.append((CharSequence) str5);
                            } else {
                                spannableStringBuilder.append((CharSequence) str6);
                            }
                            arrayList2.add(new c(length, i26, str7, str6, fVar2));
                        }
                        arrayList = arrayList2;
                        f16 = f17;
                        textPaint = textPaint2;
                    } else {
                        HashMap<Integer, Object> fields3 = next.getFields();
                        Set<Integer> keySet2 = fields3.keySet();
                        int length3 = spannableStringBuilder.length();
                        Iterator<Integer> it6 = keySet2.iterator();
                        String str9 = null;
                        String str10 = "";
                        String str11 = str10;
                        String str12 = str11;
                        int i27 = 1;
                        while (it6.hasNext()) {
                            Integer next2 = it6.next();
                            Iterator<Integer> it7 = it6;
                            int i28 = i27;
                            if (next2.intValue() == 6) {
                                str10 = (String) fields3.get(next2);
                            } else if (next2.intValue() == 7) {
                                str4 = (String) fields3.get(next2);
                            } else if (next2.intValue() == 9) {
                                str12 = (String) fields3.get(next2);
                            } else if (next2.intValue() == 5) {
                                String str13 = (String) fields3.get(next2);
                                if (str13.equals("2")) {
                                    i28 = 2;
                                } else if (str13.equals("3")) {
                                    i28 = 3;
                                }
                            } else if (next2.intValue() == 4) {
                                str9 = (String) fields3.get(next2);
                            } else if (next2.intValue() == 15) {
                                str11 = (String) fields3.get(next2);
                            }
                            i27 = i28;
                            it6 = it7;
                        }
                        int i29 = i27;
                        if (TextUtils.equals(appRuntime.getCurrentUid(), str10)) {
                            String string = BaseApplication.context.getResources().getString(R.string.f214145s4);
                            if (TextUtils.equals("1", str12)) {
                                string = BaseApplication.context.getResources().getString(R.string.f214155s5);
                            }
                            str4 = string;
                            i29 = 1;
                        } else {
                            HashMap<String, String> members = xmlElement.getMembers();
                            if (members != null && members.containsKey(str10)) {
                                str4 = ((INickNameApi) QRoute.api(INickNameApi.class)).getPurePlainText(members.get(str10), true).toString();
                            }
                        }
                        if (TextUtils.isEmpty(str4)) {
                            if (!TextUtils.isEmpty(str11)) {
                                str2 = str11;
                            } else {
                                str2 = str10;
                            }
                        } else {
                            str2 = str4;
                        }
                        if (!TextUtils.isEmpty(str10) && !TextUtils.isEmpty(str2)) {
                            str3 = str11;
                            pVar = new p(str10, str2, str3);
                            i16 = 1;
                            i3 = 3;
                        } else {
                            str3 = str11;
                            i3 = i29;
                            i16 = 1;
                        }
                        if (i3 != i16) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        String str14 = str10;
                        textPaint = textPaint2;
                        float f19 = f17;
                        f16 = f17;
                        int i36 = i3;
                        f18 = a(spannableStringBuilder, str2, textPaint2, f18, f19, z17);
                        int length4 = spannableStringBuilder.length();
                        if (!TextUtils.isEmpty(str9)) {
                            if (xmlElement.getTemplId() == null) {
                                longValue = 0;
                            } else {
                                longValue = xmlElement.getTemplId().longValue();
                            }
                            String str15 = str9;
                            if (!str15.startsWith("http://") && !str15.startsWith("https://")) {
                                if (!str15.startsWith("mqq") && !str15.startsWith(TenpayJumpActivity.TENPAY_SCHEME)) {
                                    if (longValue == 10180 || longValue == 10179 || longValue == 10382) {
                                        String qqStr = HardCodeUtil.qqStr(R.string.f23261751);
                                        if (!TextUtils.isEmpty(str)) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(qqStr);
                                            String str16 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                                            if (qqStr.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                                                str16 = ContainerUtils.FIELD_DELIMITER;
                                            }
                                            sb5.append(str16);
                                            qqStr = sb5.toString() + "peer_uid=" + str;
                                        }
                                        fVar = new q(String.format(qqStr, str15), str14, str2, str3);
                                    }
                                } else {
                                    fVar = new q(str15, str14, str2, str3);
                                }
                            } else {
                                fVar = new r(str15, str14, str2, str3);
                            }
                            if (!TextUtils.equals(appRuntime.getCurrentUid(), str14) && fVar != null) {
                                arrayList2.add(new c(length3, length4, i36, fVar));
                            }
                            arrayList = arrayList2;
                        }
                        fVar = pVar;
                        if (!TextUtils.equals(appRuntime.getCurrentUid(), str14)) {
                            arrayList2.add(new c(length3, length4, i36, fVar));
                        }
                        arrayList = arrayList2;
                    }
                } else {
                    f16 = f17;
                    textPaint = textPaint2;
                    HashMap<Integer, Object> fields4 = next.getFields();
                    Set<Integer> keySet3 = fields4.keySet();
                    int length5 = spannableStringBuilder.length();
                    spannableStringBuilder.length();
                    Iterator<Integer> it8 = keySet3.iterator();
                    int i37 = 1;
                    ArrayList arrayList3 = arrayList2;
                    f fVar3 = null;
                    while (it8.hasNext()) {
                        Integer next3 = it8.next();
                        Iterator<Integer> it9 = it8;
                        int i38 = length5;
                        if (next3.intValue() == 2) {
                            String str17 = (String) fields4.get(next3);
                            if (keySet3.contains(4)) {
                                str17 = com.tencent.qqnt.graytips.util.f.a(str17);
                            }
                            str4 = str17;
                        } else if (next3.intValue() == 5) {
                            String str18 = (String) fields4.get(next3);
                            if (str18.equals("2")) {
                                i37 = 2;
                            } else if (str18.equals("3")) {
                                i37 = 3;
                            }
                        } else if (next3.intValue() == 4) {
                            String str19 = (String) fields4.get(next3);
                            if (!str19.startsWith("http://") && !str19.startsWith("https://")) {
                                if (str19.startsWith("mqq")) {
                                    fVar3 = new k(str19);
                                }
                            } else {
                                fVar3 = new u(str19);
                            }
                        } else if (next3.intValue() == 16) {
                            try {
                                fVar3 = new com.tencent.qqnt.graytips.action.c(Long.parseLong((String) fields4.get(next3)));
                            } catch (NumberFormatException e17) {
                                QLog.d("XMLGrayTipsUtils", 1, "parseEntity2CharSequence error: " + e17);
                            }
                        }
                        it8 = it9;
                        length5 = i38;
                    }
                    int i39 = length5;
                    if (i37 != 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    f18 = a(spannableStringBuilder, str4, textPaint, f18, f16, z16);
                    int length6 = spannableStringBuilder.length();
                    if (fVar3 != null) {
                        arrayList = arrayList3;
                        arrayList.add(new c(i39, length6, i37, fVar3));
                    } else {
                        arrayList = arrayList3;
                    }
                }
            } else {
                arrayList = arrayList2;
                f16 = f17;
                textPaint = textPaint2;
                it = it5;
                HashMap<Integer, Object> fields5 = next.getFields();
                for (Integer num3 : fields5.keySet()) {
                    Object obj = fields5.get(num3);
                    if (num3.intValue() == 2) {
                        spannableStringBuilder.append((CharSequence) String.valueOf(obj));
                    }
                }
            }
            arrayList2 = arrayList;
            it5 = it;
            textPaint2 = textPaint;
            f17 = f16;
        }
        return new Pair<>(spannableStringBuilder, arrayList2);
    }

    public static d g(AppRuntime appRuntime, GrayTipElement grayTipElement, String str, int i3, int i16, String str2) {
        UniteEntity.Note note;
        if (grayTipElement != null && grayTipElement.getXmlElement() != null && grayTipElement.getXmlElement().getContent() != null) {
            XmlElement xmlElement = grayTipElement.getXmlElement();
            QLog.d("XMLGrayTipsUtils", 1, "buid " + xmlElement.busiId);
            if (QLog.isColorLevel() && xmlElement.busiId == 1068) {
                QLog.e("XMLGrayTipsUtils", 2, "content: " + xmlElement.getContent());
            }
            UniteEntity h16 = h(xmlElement.getContent());
            if (h16 != null && (note = h16.mRootNote) != null) {
                HashMap<Integer, Object> fields = note.getFields();
                String str3 = "";
                for (Integer num : fields.keySet()) {
                    Object obj = fields.get(num);
                    if (num.intValue() == 1) {
                        str3 = (String) obj;
                    }
                }
                UniteEntity.Note note2 = h16.mRootNote;
                if (note2.mSubNotes == null) {
                    return null;
                }
                Pair<CharSequence, List<c>> f16 = f(appRuntime, note2, xmlElement, str2);
                h.a c16 = h.c((CharSequence) f16.first, (List) f16.second, true);
                d dVar = new d(c16.f356916a, str3, c16.f356917b, c16.f356918c, (List) f16.second);
                if (e(xmlElement)) {
                    String[] c17 = c(h16.mRootNote);
                    dVar.g(c17[0]);
                    dVar.h(c17[1]);
                }
                return dVar;
            }
            QLog.d("XMLGrayTipsUtils", 1, "parse xml entity return null");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x022a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x024a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0228 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x021e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static UniteEntity h(String str) {
        UniteEntity uniteEntity;
        boolean z16;
        UniteEntity.Note note;
        UniteEntity uniteEntity2;
        UniteEntity.Note rootNote;
        UniteEntity.Note d16;
        String str2 = "XMLGrayTipsUtils";
        int i3 = 1;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(byteArrayInputStream, "utf-8");
            int eventType = newPullParser.getEventType();
            boolean z17 = true;
            uniteEntity = null;
            UniteEntity.Note note2 = null;
            UniteEntity.Note note3 = null;
            while (true) {
                if (eventType != i3) {
                    try {
                        String name = newPullParser.getName();
                        boolean z18 = z17;
                        String str3 = str2;
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
                                        str2 = str3;
                                        uniteEntity = uniteEntity3;
                                        QLog.e(str2, 1, "parseXML, exception: ", e);
                                        z16 = false;
                                        if (!z16) {
                                        }
                                    }
                                }
                                z17 = z18;
                                str2 = str3;
                                uniteEntity = uniteEntity3;
                                if (z17) {
                                    z16 = z17;
                                    break;
                                }
                                try {
                                    eventType = newPullParser.next();
                                    i3 = 1;
                                } catch (Exception e17) {
                                    e = e17;
                                    QLog.e(str2, 1, "parseXML, exception: ", e);
                                    z16 = false;
                                    if (!z16) {
                                    }
                                }
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
                                str2 = str3;
                                uniteEntity = uniteEntity3;
                                note2 = null;
                                if (z17) {
                                }
                            }
                        } else if (name.equals("gtip")) {
                            if (uniteEntity3 == null) {
                                uniteEntity2 = new UniteEntity(1);
                                try {
                                    rootNote = uniteEntity2.getRootNote();
                                    int attributeCount = newPullParser.getAttributeCount();
                                    for (int i16 = 0; i16 < attributeCount; i16++) {
                                        String attributeName = newPullParser.getAttributeName(i16);
                                        String attributeValue = newPullParser.getAttributeValue(i16);
                                        if (attributeName.equals("align")) {
                                            rootNote.addField(1, attributeValue);
                                        }
                                    }
                                    z17 = z18;
                                    note2 = rootNote;
                                    note3 = note2;
                                    uniteEntity = uniteEntity2;
                                    str2 = str3;
                                    if (z17) {
                                        if (note3 != null) {
                                            z17 = b(note2, note3, newPullParser);
                                        }
                                        note3 = note2;
                                    }
                                    if (z17) {
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                    uniteEntity = uniteEntity2;
                                    str2 = str3;
                                    QLog.e(str2, 1, "parseXML, exception: ", e);
                                    z16 = false;
                                    if (!z16) {
                                    }
                                }
                            } else {
                                z17 = z18;
                                str2 = str3;
                                uniteEntity = uniteEntity3;
                                if (z17) {
                                }
                            }
                        } else if (name.equals("dialog")) {
                            if (uniteEntity3 == null) {
                                uniteEntity2 = new UniteEntity(6);
                                rootNote = uniteEntity2.getRootNote();
                                z17 = z18;
                                note2 = rootNote;
                                note3 = note2;
                                uniteEntity = uniteEntity2;
                                str2 = str3;
                                if (z17) {
                                }
                                if (z17) {
                                }
                            }
                            z17 = z18;
                            str2 = str3;
                            uniteEntity = uniteEntity3;
                            if (z17) {
                            }
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
                            } else if (name.equals(PreDetect.FACE_DETECT)) {
                                note = new UniteEntity.Note(12);
                            } else {
                                if (QLog.isColorLevel()) {
                                    str2 = str3;
                                    try {
                                        QLog.i(str2, 2, "parseXML, illegel note: " + name);
                                    } catch (Exception e19) {
                                        e = e19;
                                        uniteEntity = uniteEntity3;
                                        QLog.e(str2, 1, "parseXML, exception: ", e);
                                        z16 = false;
                                        if (!z16) {
                                        }
                                    }
                                } else {
                                    str2 = str3;
                                }
                                uniteEntity = uniteEntity3;
                                z17 = false;
                                if (z17) {
                                }
                                if (z17) {
                                }
                            }
                            z17 = z18;
                            note2 = note;
                            str2 = str3;
                            uniteEntity = uniteEntity3;
                            if (z17) {
                            }
                            if (z17) {
                            }
                        }
                    } catch (Exception e26) {
                        e = e26;
                    }
                } else {
                    z16 = z17;
                    break;
                }
            }
        } catch (Exception e27) {
            e = e27;
            uniteEntity = null;
        }
        if (!z16) {
            return null;
        }
        return uniteEntity;
    }
}
