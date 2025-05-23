package op2;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class b {
    public static String a(Uri uri, String str) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                return uri.getQueryParameter(str);
            } catch (Throwable th5) {
                com.tencent.xaction.log.b.c("QQSearchWXAdUriUtil", 1, "[getQueryParameter]", th5);
            }
        }
        return null;
    }

    public static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Uri.parse(str);
        } catch (Throwable th5) {
            com.tencent.xaction.log.b.c("QQSearchWXAdUriUtil", 1, "parse", th5);
            return null;
        }
    }

    public static String c(String str, String str2, String str3) {
        try {
            return URLEncoder.encode(str, str2);
        } catch (Throwable th5) {
            com.tencent.xaction.log.b.c("QQSearchWXAdUriUtil", 1, "[urlEncode]", th5);
            return str3;
        }
    }
}
