package nx;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.z;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static long[] f421504a = {2355000000L, 2880000000L, 2885000000L, 2850121000L, 2852200000L, 3001000000L, 3003000000L, 3003400000L, 3006000000L};

    /* renamed from: b, reason: collision with root package name */
    private static long[] f421505b = {2355999999L, 2881999999L, 2885999999L, 2851999999L, 2854120999L, 3002999999L, 3003399999L, 3005999999L, 3008999999L};

    /* renamed from: c, reason: collision with root package name */
    private static volatile long[] f421506c = null;

    /* renamed from: d, reason: collision with root package name */
    private static volatile long[] f421507d = null;

    /* renamed from: e, reason: collision with root package name */
    private static volatile long[] f421508e = {2852200000L};

    /* renamed from: f, reason: collision with root package name */
    private static volatile long[] f421509f = {2852999999L};

    /* renamed from: g, reason: collision with root package name */
    private static volatile long[] f421510g = {1496000000};

    /* renamed from: h, reason: collision with root package name */
    private static volatile long[] f421511h = {1497000000};

    /* renamed from: i, reason: collision with root package name */
    private static volatile long[] f421512i = {2852000000L, 3003000000L};

    /* renamed from: j, reason: collision with root package name */
    private static volatile long[] f421513j = {2852199999L, 3003000000L};

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicBoolean f421514k = new AtomicBoolean(false);

    public static void a(Context context) {
        String str;
        try {
            str = ea.X(context);
        } catch (Exception unused) {
            str = null;
        }
        ea.V3(context, "");
        if (!TextUtils.isEmpty(str)) {
            k(SecurityUtile.decode(str));
            h(str, true);
        } else {
            try {
                z zVar = (z) BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
                if (zVar != null) {
                    h(zVar.c(), false);
                }
            } catch (Exception unused2) {
            }
        }
        f421514k.set(true);
    }

    public static boolean b(Context context, String str) {
        if (!f(str)) {
            return false;
        }
        if (!f421514k.get() && context != null) {
            a(context);
        }
        long longValue = Long.valueOf(str).longValue();
        if (f421506c == null || f421507d == null) {
            j();
        }
        if (f421506c != null && f421507d != null && f421506c.length == f421507d.length) {
            int length = f421506c.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (f421506c[i3] <= longValue && longValue <= f421507d[i3]) {
                    return true;
                }
            }
        }
        if (f421506c != null) {
            int length2 = f421506c.length;
            long[] jArr = f421504a;
            if (length2 != jArr.length) {
                int length3 = jArr.length;
                for (int i16 = 0; i16 < length3; i16++) {
                    if (f421504a[i16] <= longValue && longValue <= f421505b[i16]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean c(String str) {
        if (!f(str)) {
            return false;
        }
        long longValue = Long.valueOf(str).longValue();
        if (longValue >= 2355000000L && longValue <= 2355999999L) {
            return true;
        }
        if (longValue >= 2880000000L && longValue <= 2881999999L) {
            return true;
        }
        if (longValue >= 2885000000L && longValue <= 2885999999L) {
            return true;
        }
        if (longValue < 2850121000L || longValue > 2854120999L) {
            return false;
        }
        return true;
    }

    public static boolean d(String str) {
        if (!f(str) || !f421514k.get()) {
            return false;
        }
        return b(null, str);
    }

    public static boolean e(Context context, String str) {
        if (!f(str)) {
            return false;
        }
        if (!f421514k.get()) {
            a(context);
        }
        long longValue = Long.valueOf(str).longValue();
        if (f421508e == null || f421509f == null) {
            j();
        }
        if (f421508e == null || f421509f == null || f421508e.length != f421509f.length) {
            return false;
        }
        int length = f421508e.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (f421508e[i3] <= longValue && longValue <= f421509f[i3]) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(String str) {
        try {
            if (Long.parseLong(str) <= 10000) {
                return false;
            }
            return true;
        } catch (NumberFormatException | Exception unused) {
            return false;
        }
    }

    public static boolean g(Context context, String str) {
        if (!f(str)) {
            return false;
        }
        if (!f421514k.get() && context != null) {
            a(context);
        }
        if (f421510g == null || f421511h == null || f421510g.length != f421511h.length) {
            return false;
        }
        for (int i3 = 0; i3 < f421510g.length; i3++) {
            long longValue = Long.valueOf(str).longValue();
            if (longValue >= f421510g[i3] && longValue <= f421511h[i3]) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean h(String str, boolean z16) {
        DocumentBuilder documentBuilder;
        boolean z17;
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        if ("".equals(trim)) {
            return true;
        }
        Document document = null;
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e16) {
            e16.printStackTrace();
            documentBuilder = null;
        }
        if (documentBuilder == null) {
            return true;
        }
        if (z16) {
            trim = SecurityUtile.decode(trim);
        }
        try {
            document = documentBuilder.parse(new InputSource(new StringReader(trim)));
            z17 = true;
        } catch (IOException e17) {
            e17.printStackTrace();
            z17 = false;
            if (document != null) {
            }
            return z17;
        } catch (SAXException e18) {
            e18.printStackTrace();
            z17 = false;
            if (document != null) {
            }
            return z17;
        } catch (Exception e19) {
            e19.printStackTrace();
            z17 = false;
            if (document != null) {
            }
            return z17;
        }
        if (document != null) {
            i((Element) document.getElementsByTagName("hrtx-uin-segment").item(0), 1);
            i((Element) document.getElementsByTagName("crm3-ext-uin-segment").item(0), 2);
            i((Element) document.getElementsByTagName("crm3-wx-map-uin-segment").item(0), 3);
        }
        return z17;
    }

    private static void i(Element element, int i3) {
        long[] jArr;
        long[] jArr2;
        NodeList elementsByTagName;
        int length;
        if (element != null && (length = (elementsByTagName = element.getElementsByTagName("segment")).getLength()) > 0) {
            jArr = new long[length];
            jArr2 = new long[length];
            for (int i16 = 0; i16 < length; i16++) {
                Element element2 = (Element) elementsByTagName.item(i16);
                if (element2 != null) {
                    String attribute = element2.getAttribute("start");
                    String attribute2 = element2.getAttribute("end");
                    try {
                        long longValue = Long.valueOf(attribute.trim()).longValue();
                        long longValue2 = Long.valueOf(attribute2.trim()).longValue();
                        jArr[i16] = longValue;
                        jArr2[i16] = longValue2;
                    } catch (NumberFormatException | Exception unused) {
                    }
                }
            }
        } else {
            jArr = null;
            jArr2 = null;
        }
        l(i3, jArr, jArr2);
    }

    private static void j() {
        if (f421506c == null || f421507d == null) {
            f421506c = f421504a;
            f421507d = f421505b;
        }
        if (f421508e == null || f421509f == null) {
            f421508e = new long[]{2852200000L};
            f421509f = new long[]{2852999999L};
        }
    }

    public static void k(String str) {
        if (h(str, false)) {
            z zVar = (z) BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
            if (zVar != null) {
                if (TextUtils.isEmpty(str)) {
                    zVar.e("");
                    return;
                } else {
                    zVar.e(str);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("BmqqSegmentUtil", 2, "EqqDetailDataManager is null");
            }
        }
    }

    private static void l(int i3, long[] jArr, long[] jArr2) {
        if (jArr != null && jArr2 != null) {
            if (1 == i3) {
                synchronized (a.class) {
                    f421506c = jArr;
                    f421507d = jArr2;
                }
            } else if (2 == i3) {
                synchronized (a.class) {
                    f421508e = jArr;
                    f421509f = jArr2;
                }
            } else if (3 == i3) {
                synchronized (a.class) {
                    f421510g = jArr;
                    f421511h = jArr2;
                }
            }
        }
    }
}
