package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b {
    public static String a(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < str.length()) {
            if (str.charAt(i16) == 20 && (i3 = i16 + 1) < str.length()) {
                char charAt = str.charAt(i3);
                if (c(charAt)) {
                    int convertToServer = QQSysFaceUtil.convertToServer(charAt);
                    sb5.append(str.charAt(i16));
                    sb5.append(convertToServer);
                    sb5.append("/");
                    if (convertToServer == charAt) {
                        QLog.w("expand.chat.ExpandSysEmotionHelper", 1, "unrecognized code? pos:" + i3 + ", " + convertToServer + ",  content:" + str);
                    }
                    if (QLog.isDebugVersion()) {
                        QLog.d("expand.chat.ExpandSysEmotionHelper", 2, "encodeQQEmotion value:[" + ((int) charAt) + ", " + convertToServer + ",  content:" + str);
                    }
                    i16 = i3;
                } else {
                    sb5.append(str.charAt(i16));
                }
            } else {
                sb5.append(str.charAt(i16));
            }
            i16++;
        }
        return sb5.toString();
    }

    public static Map<String, String> b(List<String> list) {
        HashMap hashMap = new HashMap();
        for (String str : list) {
            try {
                int parseInt = Integer.parseInt(str);
                String fullResPath = QQSysAndEmojiResMgr.getInstance().getFullResPath(2, parseInt);
                if (!(!TextUtils.isEmpty(fullResPath) ? new File(fullResPath).exists() : false)) {
                    try {
                        QQSysAndEmojiResMgr.getInstance().getResImpl(1).addReloadDrawable(QQSysFaceUtil.convertToLocal(parseInt));
                    } catch (Exception unused) {
                        QLog.w("expand.chat.ExpandSysEmotionHelper", 1, "getEmotionPath error serverId:" + str);
                    }
                }
                hashMap.put(str, fullResPath);
            } catch (Exception e16) {
                hashMap.put(str, "");
                QLog.w("expand.chat.ExpandSysEmotionHelper", 1, "getEmotionPath error:" + str + " " + e16);
            }
        }
        return hashMap;
    }

    public static boolean c(int i3) {
        if (QQSysAndEmojiResMgr.getInstance().getResImpl(1).getServerId(i3) != -1 || i3 < 247) {
            return true;
        }
        QLog.d("expand.chat.ExpandSysEmotionHelper", 1, "unrecognized localId:", Integer.valueOf(i3));
        return false;
    }
}
