package cp2;

import java.util.ArrayList;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    public static void a(ArrayList<b> arrayList, String str, Object obj) {
        if ("cover".equals(str)) {
            arrayList.clear();
        }
        arrayList.add(b(str, obj));
    }

    private static b b(String str, Object obj) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 115029:
                if (str.equals("top")) {
                    c16 = 0;
                    break;
                }
                break;
            case 3202370:
                if (str.equals("hide")) {
                    c16 = 1;
                    break;
                }
                break;
            case 3529469:
                if (str.equals("show")) {
                    c16 = 2;
                    break;
                }
                break;
            case 94852023:
                if (str.equals("cover")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return new h(c(obj));
            case 1:
                return new f(c(obj));
            case 2:
                return new g(c(obj));
            case 3:
                return new e(c(obj));
            default:
                return null;
        }
    }

    private static int[] c(Object obj) {
        if (!(obj instanceof JSONArray)) {
            return new int[0];
        }
        JSONArray jSONArray = (JSONArray) obj;
        int[] iArr = new int[jSONArray.length()];
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            iArr[i3] = jSONArray.optInt(i3);
        }
        return iArr;
    }
}
