package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class x {
    static IPatchRedirector $redirector_;

    public static String a(String str, boolean z16) {
        return b(str, z16, null);
    }

    public static String b(String str, boolean z16, ArrayList<AtTroopMemberInfo> arrayList) {
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
}
