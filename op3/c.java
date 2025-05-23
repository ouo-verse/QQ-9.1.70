package op3;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.open.base.f;
import com.tencent.open.business.base.MobileInfoUtil;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && (str.endsWith(QQWinkConstants.VALID_HOST) || str.endsWith(".myapp.com") || str.endsWith(".3gqq.com") || str.endsWith(".qzone.com"))) {
            f.a("CookieUtils", "host:" + str + " isAuthedDomain:true");
            return true;
        }
        f.a("CookieUtils", "host:" + str + " isAuthedDomain:false");
        return false;
    }

    public static synchronized void b(String str) {
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Uri parse = Uri.parse(str);
            if (parse != null && parse.getHost() != null) {
                if (!a(parse.getHost().toLowerCase())) {
                    return;
                }
                b bVar = new b(com.tencent.open.adapter.a.f().e());
                a aVar = new a();
                aVar.a(true);
                long l3 = com.tencent.open.adapter.a.f().l();
                String imei = MobileInfoUtil.getImei();
                String k3 = com.tencent.open.adapter.a.f().k();
                aVar.b("qq.com/", "uin=" + l3 + "; path=/; domain=.qq.com;");
                aVar.b("qq.com/", "skey=" + k3 + "; path=/; domain=.qq.com;");
                aVar.b("qq.com/", "imei=" + imei + "; path=/; domain=.qq.com;");
                bVar.a();
            }
        }
    }
}
