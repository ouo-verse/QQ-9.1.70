package iv2;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f408803a;

        /* renamed from: b, reason: collision with root package name */
        private String f408804b;

        a(String str, String str2) {
            this.f408803a = str;
            this.f408804b = str2;
        }

        public String a() {
            return this.f408804b;
        }

        public String b() {
            return this.f408803a;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Uri.decode(str);
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Uri.encode(str);
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                String str3 = split[0];
                String a16 = a(split[1]);
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(a16)) {
                    if (i3 > 0) {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb5.append(String.format("%s=%s", str3, b(a16)));
                    i3++;
                }
            }
        }
        return sb5.toString();
    }

    public static a d(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return null;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            str2 = c(str.substring(indexOf + 1));
            str = substring;
        }
        return new a(str, str2);
    }
}
