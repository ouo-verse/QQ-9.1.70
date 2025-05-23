package lp;

import android.text.TextUtils;
import com.qzone.util.am;
import com.qzonex.utils.richtext.element.AtElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    private static AtElement a(String str) {
        int indexOf = str.indexOf("uin:") + 4;
        int indexOf2 = str.indexOf(",nick:");
        if (indexOf == -1 || indexOf2 == -1) {
            return null;
        }
        int indexOf3 = str.indexOf(",who:");
        int i3 = 1;
        if (indexOf3 == -1) {
            indexOf3 = str.length() - 1;
        } else {
            try {
                i3 = Integer.parseInt(str.substring(indexOf3 + 5, str.length() - 1));
            } catch (Exception unused) {
            }
        }
        String substring = str.substring(indexOf, indexOf2);
        String substring2 = str.substring(indexOf2 + 6, indexOf3);
        String str2 = "@";
        if (!str.startsWith("@")) {
            str2 = "";
        }
        AtElement atElement = new AtElement();
        atElement.nickName = str2 + am.b(substring2);
        atElement.who = i3;
        if (i3 != 2) {
            atElement.uin = substring;
        } else {
            atElement.uin = String.valueOf(0);
        }
        return atElement;
    }

    public static ArrayList<AtElement> b(StringBuilder sb5) {
        ArrayList<AtElement> arrayList = new ArrayList<>();
        Matcher matcher = c.f415324k.matcher(sb5);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group();
            AtElement a16 = a(group);
            if (a16 != null) {
                a16.startPosition = start;
                a16.endPosition = end;
                a16.offset = group.length() - a16.nickName.length();
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        StringBuffer stringBuffer = new StringBuffer(str);
        Iterator<AtElement> it = b(sb5).iterator();
        int i3 = 0;
        while (it.hasNext()) {
            AtElement next = it.next();
            int i16 = next.startPosition - i3;
            int i17 = next.endPosition - i3;
            String str2 = next.nickName;
            if (i16 < 0 || i17 > stringBuffer.length()) {
                break;
            }
            stringBuffer.replace(i16, i17, str2);
            i3 += (next.offset + next.nickName.length()) - str2.length();
        }
        return stringBuffer.toString();
    }
}
