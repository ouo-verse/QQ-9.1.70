package okhttp3.internal.tls;

import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\f\u0010\u0017\u001a\u00020\b*\u00020\bH\u0002J\f\u0010\u0018\u001a\u00020\u000e*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", "host", SessionDbHelper.SESSION_ID, "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", "pattern", "verifyIpAddress", "ipAddress", "asciiToLowercase", "isAscii", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;

    @NotNull
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (isAscii(str)) {
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            if (str != null) {
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                return lowerCase;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return str;
    }

    private final List<String> getSubjectAltNames(X509Certificate certificate, int type) {
        List<String> emptyList;
        List<String> emptyList2;
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && !(!Intrinsics.areEqual(list.get(0), Integer.valueOf(type))) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    private final boolean isAscii(String str) {
        if (str.length() != ((int) Utf8.size$default(str, 0, 0, 3, null))) {
            return false;
        }
        return true;
    }

    private final boolean verifyHostname(String hostname, X509Certificate certificate) {
        String asciiToLowercase = asciiToLowercase(hostname);
        List<String> subjectAltNames = getSubjectAltNames(certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(asciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String ipAddress, X509Certificate certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(ipAddress);
        List<String> subjectAltNames = getSubjectAltNames(certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(canonicalHost, HostnamesKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<String> allSubjectAltNames(@NotNull X509Certificate certificate) {
        List<String> plus;
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        plus = CollectionsKt___CollectionsKt.plus((Collection) getSubjectAltNames(certificate, 7), (Iterable) getSubjectAltNames(certificate, 2));
        return plus;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String host, @NotNull SSLSession session) {
        Certificate certificate;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        if (isAscii(host)) {
            try {
                certificate = session.getPeerCertificates()[0];
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
            } catch (SSLException unused) {
                return false;
            }
        }
        return verify(host, (X509Certificate) certificate);
    }

    public final boolean verify(@NotNull String host, @NotNull X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String hostname, String pattern) {
        boolean startsWith$default;
        boolean endsWith$default;
        boolean startsWith$default2;
        boolean endsWith$default2;
        boolean endsWith$default3;
        boolean endsWith$default4;
        boolean contains$default;
        boolean startsWith$default3;
        int indexOf$default;
        boolean endsWith$default5;
        int lastIndexOf$default;
        if (!(hostname == null || hostname.length() == 0)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(hostname, ".", false, 2, null);
            if (!startsWith$default) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(hostname, "..", false, 2, null);
                if (!endsWith$default) {
                    if (!(pattern == null || pattern.length() == 0)) {
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(pattern, ".", false, 2, null);
                        if (!startsWith$default2) {
                            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(pattern, "..", false, 2, null);
                            if (!endsWith$default2) {
                                endsWith$default3 = StringsKt__StringsJVMKt.endsWith$default(hostname, ".", false, 2, null);
                                if (!endsWith$default3) {
                                    hostname = hostname + ".";
                                }
                                String str = hostname;
                                endsWith$default4 = StringsKt__StringsJVMKt.endsWith$default(pattern, ".", false, 2, null);
                                if (!endsWith$default4) {
                                    pattern = pattern + ".";
                                }
                                String asciiToLowercase = asciiToLowercase(pattern);
                                contains$default = StringsKt__StringsKt.contains$default((CharSequence) asciiToLowercase, (CharSequence) "*", false, 2, (Object) null);
                                if (contains$default) {
                                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(asciiToLowercase, "*.", false, 2, null);
                                    if (startsWith$default3) {
                                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) asciiToLowercase, '*', 1, false, 4, (Object) null);
                                        if (indexOf$default != -1 || str.length() < asciiToLowercase.length() || Intrinsics.areEqual("*.", asciiToLowercase)) {
                                            return false;
                                        }
                                        String substring = asciiToLowercase.substring(1);
                                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                                        endsWith$default5 = StringsKt__StringsJVMKt.endsWith$default(str, substring, false, 2, null);
                                        if (!endsWith$default5) {
                                            return false;
                                        }
                                        int length = str.length() - substring.length();
                                        if (length > 0) {
                                            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, '.', length - 1, false, 4, (Object) null);
                                            if (lastIndexOf$default != -1) {
                                                return false;
                                            }
                                        }
                                        return true;
                                    }
                                } else {
                                    return Intrinsics.areEqual(str, asciiToLowercase);
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
