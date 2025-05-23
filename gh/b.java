package gh;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.util.s;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static void a(Activity activity, String str, BusinessFeedData businessFeedData) {
        int i3;
        if (activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        QLog.i("QZoneDittoJumpHelper", 1, "handleDittoScheme scheme = " + str);
        if (str.startsWith("ditto://")) {
            String substring = str.substring(8);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            Uri parse = Uri.parse(str);
            if (substring.startsWith("openMiniAIO")) {
                String queryParameter = parse.getQueryParameter("uin");
                String queryParameter2 = parse.getQueryParameter("nickname");
                String queryParameter3 = parse.getQueryParameter("type");
                boolean equals = "1".equals(parse.getQueryParameter("autoSendArkMsg"));
                try {
                    i3 = Integer.parseInt(queryParameter3);
                } catch (NumberFormatException e16) {
                    QLog.e("QZoneDittoJumpHelper", 1, "handleDittoScheme  e = " + e16.getMessage());
                    i3 = 0;
                }
                if (equals) {
                    s.e(activity, i3, queryParameter, queryParameter2, businessFeedData);
                } else {
                    s.a(activity, i3, queryParameter, queryParameter2);
                }
            }
        }
    }
}
