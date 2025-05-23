package m10;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {
    public static a a(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1966948971:
                if (str.equals("aio_enter_c_link")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1141620334:
                if (str.equals("recommend_tab")) {
                    c16 = 1;
                    break;
                }
                break;
            case 2070304934:
                if (str.equals("essence_tab")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 1:
                return new e();
            case 2:
                if ("monofeed_tab".equals(uy.a.f440578a.a())) {
                    return new e();
                }
                return null;
            default:
                return null;
        }
    }
}
