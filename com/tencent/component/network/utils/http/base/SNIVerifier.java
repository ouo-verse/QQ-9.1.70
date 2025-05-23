package com.tencent.component.network.utils.http.base;

import com.tencent.mobileqq.search.model.ac;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlin.text.Typography;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.conn.util.InetAddressUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SNIVerifier implements X509HostnameVerifier {
    private static final String[] BAD_COUNTRY_2LDS;

    static {
        String[] strArr = {ac.f283467k0, "co", "com", "ed", "edu", ResourceAttributes.TelemetrySdkLanguageValues.GO, "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        BAD_COUNTRY_2LDS = strArr;
        Arrays.sort(strArr);
    }

    public static boolean acceptableCountryWildcard(String str) {
        String[] split = str.split("\\.");
        if (split.length != 3 || split[2].length() != 2 || Arrays.binarySearch(BAD_COUNTRY_2LDS, split[1]) < 0) {
            return true;
        }
        return false;
    }

    public static int countDots(String str) {
        int i3 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            if (str.charAt(i16) == '.') {
                i3++;
            }
        }
        return i3;
    }

    public static String[] getCNs(X509Certificate x509Certificate) {
        LinkedList linkedList = new LinkedList();
        StringTokenizer stringTokenizer = new StringTokenizer(x509Certificate.getSubjectX500Principal().toString(), ",");
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim.length() > 3 && trim.substring(0, 3).equalsIgnoreCase("CN=")) {
                linkedList.add(trim.substring(3));
            }
        }
        if (!linkedList.isEmpty()) {
            String[] strArr = new String[linkedList.size()];
            linkedList.toArray(strArr);
            return strArr;
        }
        return null;
    }

    public static String[] getDNSSubjectAlts(X509Certificate x509Certificate) {
        return getSubjectAlts(x509Certificate, null);
    }

    private static String[] getSubjectAlts(X509Certificate x509Certificate, String str) {
        int i3;
        Collection<List<?>> collection;
        if (isIPAddress(str)) {
            i3 = 7;
        } else {
            i3 = 2;
        }
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException unused) {
            collection = null;
        }
        if (collection != null) {
            for (List<?> list : collection) {
                if (((Integer) list.get(0)).intValue() == i3) {
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

    private static boolean isIPAddress(String str) {
        if (str != null && (InetAddressUtils.isIPv4Address(str) || InetAddressUtils.isIPv6Address(str))) {
            return true;
        }
        return false;
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String str, SSLSocket sSLSocket) throws IOException {
        if (str != null) {
            SniSSLSocketFactory.ensureSupportSNI(sSLSocket, str);
            SSLSession session = sSLSocket.getSession();
            if (session == null) {
                sSLSocket.getInputStream().available();
                session = sSLSocket.getSession();
                if (session == null) {
                    sSLSocket.startHandshake();
                    session = sSLSocket.getSession();
                }
            }
            verify(str, (X509Certificate) session.getPeerCertificates()[0]);
            return;
        }
        throw new NullPointerException("host to verify is null");
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier, javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException unused) {
            return false;
        }
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String str, X509Certificate x509Certificate) throws SSLException {
        verify(str, getCNs(x509Certificate), getSubjectAlts(x509Certificate, str));
    }

    public final void verify(String str, String[] strArr, String[] strArr2, boolean z16) throws SSLException {
        boolean endsWith;
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
            StringBuilder sb5 = new StringBuilder();
            String lowerCase = str.trim().toLowerCase(Locale.US);
            Iterator it = linkedList.iterator();
            boolean z17 = false;
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.US);
                sb5.append(" <");
                sb5.append(lowerCase2);
                sb5.append(Typography.greater);
                if (it.hasNext()) {
                    sb5.append(" OR");
                }
                String[] split = lowerCase2.split("\\.");
                if (split.length >= 3 && split[0].endsWith("*") && acceptableCountryWildcard(lowerCase2) && !isIPAddress(str)) {
                    String str4 = split[0];
                    if (str4.length() > 1) {
                        String substring = str4.substring(0, str4.length() - 1);
                        endsWith = lowerCase.startsWith(substring) && lowerCase.substring(substring.length()).endsWith(lowerCase2.substring(str4.length()));
                    } else {
                        endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    }
                    if (endsWith && z16) {
                        endsWith = countDots(lowerCase) == countDots(lowerCase2);
                    }
                    z17 = endsWith;
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
            throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) sb5));
        }
        throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
        verify(str, strArr, strArr2, false);
    }
}
