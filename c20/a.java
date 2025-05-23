package c20;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.parser.et;
import com.tencent.mobileqq.app.parser.ev;
import com.tencent.mobileqq.app.parser.ex;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.utils.ax;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static ax b(Context context, String str, Object obj) {
        Uri d16 = bb.d(str);
        if (c(d16)) {
            return null;
        }
        String a16 = a(d16.getPathSegments());
        a16.hashCode();
        char c16 = '\uffff';
        switch (a16.hashCode()) {
            case -1505392042:
                if (a16.equals("miniapp_player")) {
                    c16 = 0;
                    break;
                }
                break;
            case -213632750:
                if (a16.equals("waterfall")) {
                    c16 = 1;
                    break;
                }
                break;
            case 113021637:
                if (a16.equals("wesee")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return new ex().a(bb.t(), context, str, null);
            case 1:
                return new et().a(bb.t(), context, str, null);
            case 2:
                return new ev(obj).a(bb.t(), context, str, null);
            default:
                return null;
        }
    }

    public static boolean d(Context context, String str, Object obj) {
        x.f("WSQQSchemeUtilsLog", "[WSQQSchemeUtils.java][jump] schema:" + str);
        ax b16 = b(context, str, obj);
        if (b16 != null) {
            return b16.b();
        }
        return false;
    }

    private static String a(List<String> list) {
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return "";
    }

    private static boolean c(Uri uri) {
        return (uri != null && TextUtils.equals(uri.getScheme(), SchemaUtils.SCHEMA_MQQAPI) && TextUtils.equals(uri.getHost(), "wsgzh")) ? false : true;
    }
}
