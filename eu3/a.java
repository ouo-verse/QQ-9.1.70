package eu3;

import android.text.TextUtils;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {
    public static int[] a(String str) {
        if (!TextUtils.isEmpty(str) && !HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(str)) {
            String[] split = str.replaceAll("[\\[\\s\\]]", "").split(",");
            int[] iArr = new int[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                try {
                    iArr[i3] = Integer.parseInt(split[i3]);
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                }
            }
            return iArr;
        }
        return new int[0];
    }
}
