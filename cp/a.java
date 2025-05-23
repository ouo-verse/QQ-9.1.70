package cp;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static ArrayList<String> c(String str, String str2, boolean z16) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            if (z16) {
                str = str.toLowerCase();
            }
            for (String str3 : str.split(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    arrayList.add(str3.trim());
                }
            }
        }
        return arrayList;
    }

    public static boolean a(String str, String str2, String str3, String str4) {
        return b(c(str, str2, true), str3, str4);
    }

    public static boolean b(ArrayList<String> arrayList, String str, String str2) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            str = str.trim();
        }
        return arrayList.contains(str);
    }
}
