package nd4;

import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nd4.f;

/* compiled from: P */
/* loaded from: classes26.dex */
final class k implements c {
    @Override // nd4.c
    public List<f> a() {
        ArrayList arrayList = new ArrayList();
        for (String str : b()) {
            arrayList.add(new f.b().d(str).e(c(str)).c());
        }
        return arrayList;
    }

    public List<String> b() {
        return Arrays.asList("app_version", "app_bundle_name", "os_version", "platform", "model", "brand", "sdk_version", "network_type");
    }

    public String c(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -901870406:
                if (str.equals("app_version")) {
                    c16 = 0;
                    break;
                }
                break;
            case -376724013:
                if (str.equals("sdk_version")) {
                    c16 = 1;
                    break;
                }
                break;
            case -19457365:
                if (str.equals("network_type")) {
                    c16 = 2;
                    break;
                }
                break;
            case 47035146:
                if (str.equals("app_bundle_name")) {
                    c16 = 3;
                    break;
                }
                break;
            case 93997959:
                if (str.equals("brand")) {
                    c16 = 4;
                    break;
                }
                break;
            case 104069929:
                if (str.equals("model")) {
                    c16 = 5;
                    break;
                }
                break;
            case 672836989:
                if (str.equals("os_version")) {
                    c16 = 6;
                    break;
                }
                break;
            case 1874684019:
                if (str.equals("platform")) {
                    c16 = 7;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return u.d();
            case 1:
                return "0.0.7";
            case 2:
                return e.g();
            case 3:
                return u.c();
            case 4:
                return b.a();
            case 5:
                return b.b();
            case 6:
                return Build.VERSION.SDK_INT + "";
            case 7:
                return "Android";
            default:
                return "";
        }
    }
}
