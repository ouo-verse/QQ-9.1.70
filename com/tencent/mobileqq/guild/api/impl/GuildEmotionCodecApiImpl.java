package com.tencent.mobileqq.guild.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildEmotionCodecApiImpl implements IGuildEmotionCodecApi {
    private static final ArrayList<Integer> SYS_EMOTICON_SYMBOL_EX;
    private static final String TAG = "GuildEmotionCodecApiImpl";

    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        SYS_EMOTICON_SYMBOL_EX = arrayList;
        arrayList.add(324);
        arrayList.add(271);
    }

    private static String convertDesToSysEmotcationString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.contains("/")) {
            return str;
        }
        try {
            Map<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> sysConfigItemMap = QQSysFaceUtil.sysConfigItemMap();
            Iterator<Integer> it = SYS_EMOTICON_SYMBOL_EX.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (sysConfigItemMap.containsKey(next)) {
                    String str2 = (char) 20 + sysConfigItemMap.get(next).QDes;
                    if (str.contains(str2)) {
                        str = str.replace(str2, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(next.intValue()));
                    }
                }
            }
            for (Map.Entry<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> entry : sysConfigItemMap.entrySet()) {
                int intValue = entry.getKey().intValue();
                String str3 = (char) 20 + entry.getValue().QDes;
                if (str.contains(str3)) {
                    str = str.replace(str3, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(intValue));
                }
            }
            for (Map.Entry<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> entry2 : sysConfigItemMap.entrySet()) {
                int intValue2 = entry2.getKey().intValue();
                String str4 = entry2.getValue().QDes;
                if (str.contains(str4)) {
                    str = str.replace(str4, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(intValue2));
                }
            }
            int i3 = 0;
            int i16 = 0;
            while (true) {
                String[] strArr = EmotcationConstants.SYS_EMOTICON_SYMBOL;
                if (i16 >= strArr.length) {
                    break;
                }
                String str5 = (char) 20 + strArr[i16];
                if (str.contains(str5)) {
                    str = str.replace(str5, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i16));
                }
                i16++;
            }
            while (true) {
                String[] strArr2 = EmotcationConstants.SYS_EMOTICON_SYMBOL;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str6 = strArr2[i3];
                if (str.contains(str6)) {
                    str = str.replace(str6, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i3));
                }
                i3++;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "convertMsg exception", e16);
            }
        }
        return str;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi
    public String decodeQQEmotion(String str) {
        return com.tencent.mobileqq.service.message.b.c(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi
    public String encodeQQEmotion(String str) {
        return com.tencent.mobileqq.service.message.b.e(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi
    public String fromQQTextBuilder(QQTextBuilder qQTextBuilder) {
        return convertEmotionDescription(qQTextBuilder);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi
    public QQText toQQText(String str, int i3) {
        return new QQText(convertDesToSysEmotcationString(str), 3, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi
    public QQText toQQTextWithAnimation(String str, int i3) {
        return new QQText(convertDesToSysEmotcationString(str), 7, i3);
    }

    public static String convertEmotionDescription(QQTextBuilder qQTextBuilder) {
        String str;
        if (qQTextBuilder == null) {
            return "";
        }
        int length = qQTextBuilder.length();
        char[] cArr = new char[length];
        qQTextBuilder.getChars(0, length, cArr, 0);
        StringBuilder sb5 = new StringBuilder();
        EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) qQTextBuilder.getSpans(0, length, EmoticonSpan.class);
        if (emoticonSpanArr != null && emoticonSpanArr.length > 0) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(cArr);
            ArrayList arrayList = new ArrayList(emoticonSpanArr.length);
            for (EmoticonSpan emoticonSpan : emoticonSpanArr) {
                if (emoticonSpan != null) {
                    arrayList.add(com.tencent.av.chatroom.d.a(emoticonSpan, qQTextBuilder.getSpanStart(emoticonSpan), qQTextBuilder.getSpanEnd(emoticonSpan)));
                }
            }
            Collections.sort(arrayList, com.tencent.av.chatroom.d.f73537h);
            Iterator it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                com.tencent.av.chatroom.d dVar = (com.tencent.av.chatroom.d) it.next();
                EmoticonSpan emoticonSpan2 = dVar.f73538a;
                int i16 = dVar.f73539b;
                int i17 = dVar.f73540c;
                int i18 = emoticonSpan2.emojiType;
                if (i18 == 1) {
                    str = (char) 20 + QQSysFaceUtil.getFaceDescription(emoticonSpan2.getIndex());
                } else if (i18 != 2) {
                    str = sb6.substring(i16, i17);
                } else {
                    str = (char) 20 + emoticonSpan2.getDescription();
                }
                if (i3 < i16) {
                    sb5.append(sb6.substring(i3, i16));
                }
                sb5.append(str);
                i3 = i17;
            }
            if (i3 < sb6.length()) {
                sb5.append(sb6.substring(i3));
            }
            com.tencent.av.chatroom.d.c(arrayList);
        } else {
            sb5.append(cArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("getConvertMsg, src[%s], convert[%s], plain[%s]", qQTextBuilder, sb5, qQTextBuilder.toPlainText()));
        }
        return sb5.toString();
    }
}
