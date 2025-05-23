package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.g;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f37958a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f37959b;

    static {
        String[] strArr = {ac.f283467k0, "co", "com", "ed", "edu", ResourceAttributes.TelemetrySdkLanguageValues.GO, "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        f37959b = strArr;
        Arrays.sort(strArr);
    }

    public static final void a(String str, X509Certificate x509Certificate, boolean z16) throws SSLException {
        String[] a16 = a(x509Certificate);
        String[] b16 = b(x509Certificate);
        g.a("", "cn is : " + Arrays.toString(a16));
        g.a("", "san is : " + Arrays.toString(b16));
        a(str, a16, b16, z16);
    }

    public static String[] b(X509Certificate x509Certificate) {
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e16) {
            g.a("", "Error parsing certificate.", e16);
            collection = null;
        }
        if (collection != null) {
            for (List<?> list : collection) {
                if (((Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    private static boolean c(String str) {
        return f37958a.matcher(str).matches();
    }

    public static final void a(String str, String[] strArr, String[] strArr2, boolean z16) throws SSLException {
        String str2;
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && (str2 = strArr[0]) != null) {
            linkedList.add(str2);
        }
        if (strArr2 != null) {
            for (String str3 : strArr2) {
                if (str3 != null) {
                    linkedList.add(str3);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            Iterator it = linkedList.iterator();
            boolean z17 = false;
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                stringBuffer.append(" <");
                stringBuffer.append(lowerCase2);
                stringBuffer.append(Typography.greater);
                if (it.hasNext()) {
                    stringBuffer.append(" OR");
                }
                if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && a(lowerCase2) && !c(str)) {
                    boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    if (endsWith && z16) {
                        z17 = b(lowerCase) == b(lowerCase2);
                    } else {
                        z17 = endsWith;
                    }
                } else {
                    z17 = lowerCase.equals(lowerCase2);
                }
                if (z17) {
                    break;
                }
            }
            if (z17) {
                return;
            }
            throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) stringBuffer));
        }
        throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
    }

    public static int b(String str) {
        int i3 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            if (str.charAt(i16) == '.') {
                i3++;
            }
        }
        return i3;
    }

    public static boolean a(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i3 = length - 3;
        if (str.charAt(i3) == '.') {
            return Arrays.binarySearch(f37959b, str.substring(2, i3)) < 0;
        }
        return true;
    }

    public static String[] a(X509Certificate x509Certificate) {
        List<String> b16 = new a(x509Certificate.getSubjectX500Principal()).b("cn");
        if (b16.isEmpty()) {
            return null;
        }
        String[] strArr = new String[b16.size()];
        b16.toArray(strArr);
        return strArr;
    }
}
