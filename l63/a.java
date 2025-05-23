package l63;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {
    public static final String a(String str) {
        return str + "_" + c(8);
    }

    public static final String b(String str) {
        int lastIndexOf = str.lastIndexOf("_");
        if (lastIndexOf < 0) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String c(int i3) {
        Random random = new Random();
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append("0123456789".charAt(random.nextInt(10)));
        }
        return sb5.toString();
    }
}
