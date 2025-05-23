package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UriCompat {
    UriCompat() {
    }

    @NonNull
    public static String toSafeString(@NonNull Uri uri) {
        String str;
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (!scheme.equalsIgnoreCase("tel") && !scheme.equalsIgnoreCase(TPReportKeys.LiveExKeys.LIVE_EX_S_IP) && !scheme.equalsIgnoreCase("sms") && !scheme.equalsIgnoreCase("smsto") && !scheme.equalsIgnoreCase("mailto") && !scheme.equalsIgnoreCase("nfc")) {
                if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https") || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("//");
                    String str2 = "";
                    if (uri.getHost() == null) {
                        str = "";
                    } else {
                        str = uri.getHost();
                    }
                    sb5.append(str);
                    if (uri.getPort() != -1) {
                        str2 = ":" + uri.getPort();
                    }
                    sb5.append(str2);
                    sb5.append("/...");
                    schemeSpecificPart = sb5.toString();
                }
            } else {
                StringBuilder sb6 = new StringBuilder(64);
                sb6.append(scheme);
                sb6.append(':');
                if (schemeSpecificPart != null) {
                    for (int i3 = 0; i3 < schemeSpecificPart.length(); i3++) {
                        char charAt = schemeSpecificPart.charAt(i3);
                        if (charAt != '-' && charAt != '@' && charAt != '.') {
                            sb6.append('x');
                        } else {
                            sb6.append(charAt);
                        }
                    }
                }
                return sb6.toString();
            }
        }
        StringBuilder sb7 = new StringBuilder(64);
        if (scheme != null) {
            sb7.append(scheme);
            sb7.append(':');
        }
        if (schemeSpecificPart != null) {
            sb7.append(schemeSpecificPart);
        }
        return sb7.toString();
    }
}
