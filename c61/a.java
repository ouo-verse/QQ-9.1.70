package c61;

import android.text.TextUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() <= 10) {
            return str;
        }
        return str.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }
}
