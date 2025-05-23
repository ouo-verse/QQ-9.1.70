package nd4;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {
    private static void a(StringBuilder sb5, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            try {
                sb5.append('\t');
            } catch (Exception e16) {
                Log.i("TAB.JSONUtils", e16.getMessage());
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            int i3 = 0;
            char c16 = 0;
            boolean z16 = false;
            int i16 = 0;
            while (i3 < str.length()) {
                char charAt = str.charAt(i3);
                if (charAt != '\"') {
                    if (charAt != ',') {
                        if (charAt != '{') {
                            if (charAt != '}') {
                                switch (charAt) {
                                    case '[':
                                        break;
                                    case '\\':
                                        break;
                                    case ']':
                                        break;
                                    default:
                                        sb5.append(charAt);
                                        break;
                                }
                            }
                            if (!z16) {
                                sb5.append('\n');
                                i16--;
                                a(sb5, i16);
                            }
                            sb5.append(charAt);
                        }
                        sb5.append(charAt);
                        if (!z16) {
                            sb5.append('\n');
                            i16++;
                            a(sb5, i16);
                        }
                    } else {
                        sb5.append(charAt);
                        if (c16 != '\\' && !z16) {
                            sb5.append('\n');
                            a(sb5, i16);
                        }
                    }
                } else {
                    if (c16 != '\\') {
                        z16 = !z16;
                    }
                    sb5.append(charAt);
                }
                i3++;
                c16 = charAt;
            }
            return sb5.toString();
        } catch (Exception e16) {
            Log.w("TAB.JSONUtils", e16.getMessage());
            return "";
        }
    }
}
