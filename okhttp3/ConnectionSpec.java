package okhttp3;

import com.tencent.mobileqq.msf.core.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0002#$B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0000\u00a2\u0006\u0002\b\u0017J\u0015\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007\u00a2\u0006\u0002\b\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0015J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b J\u0015\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bH\u0007\u00a2\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8G\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\rR\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8G\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000e\u00a8\u0006%"}, d2 = {"Lokhttp3/ConnectionSpec;", "", "isTls", "", "supportsTlsExtensions", "cipherSuitesAsString", "", "", "tlsVersionsAsString", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "cipherSuites", "", "Lokhttp3/CipherSuite;", "()Ljava/util/List;", "[Ljava/lang/String;", "()Z", "tlsVersions", "Lokhttp3/TlsVersion;", "apply", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "apply$okhttp", "-deprecated_cipherSuites", "equals", "other", "hashCode", "", "isCompatible", d.f247918u, "supportedSpec", "-deprecated_supportsTlsExtensions", "-deprecated_tlsVersions", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class ConnectionSpec {
    private static final CipherSuite[] APPROVED_CIPHER_SUITES;

    @JvmField
    @NotNull
    public static final ConnectionSpec CLEARTEXT;

    @JvmField
    @NotNull
    public static final ConnectionSpec COMPATIBLE_TLS;

    @JvmField
    @NotNull
    public static final ConnectionSpec MODERN_TLS;
    private static final CipherSuite[] RESTRICTED_CIPHER_SUITES;

    @JvmField
    @NotNull
    public static final ConnectionSpec RESTRICTED_TLS;
    private final String[] cipherSuitesAsString;
    private final boolean isTls;
    private final boolean supportsTlsExtensions;
    private final String[] tlsVersionsAsString;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u0000J\u0006\u0010\u001a\u001a\u00020\u0000J\u0006\u0010\u001b\u001a\u00020\u0006J\u001f\u0010\b\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n\u00a2\u0006\u0002\u0010\u001cJ\u001f\u0010\b\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\t\"\u00020\u001d\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003H\u0007J\u001f\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n\u00a2\u0006\u0002\u0010\u001cJ\u001f\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\t\"\u00020\u001f\u00a2\u0006\u0002\u0010 R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0004R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e\u00a8\u0006!"}, d2 = {"Lokhttp3/ConnectionSpec$Builder;", "", "tls", "", "(Z)V", "connectionSpec", "Lokhttp3/ConnectionSpec;", "(Lokhttp3/ConnectionSpec;)V", "cipherSuites", "", "", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "supportsTlsExtensions", "getSupportsTlsExtensions$okhttp", "()Z", "setSupportsTlsExtensions$okhttp", "getTls$okhttp", "setTls$okhttp", "tlsVersions", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "allEnabledCipherSuites", "allEnabledTlsVersions", "build", "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/CipherSuite;", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/TlsVersion;", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Builder {

        @Nullable
        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;

        @Nullable
        private String[] tlsVersions;

        public Builder(boolean z16) {
            this.tls = z16;
        }

        @NotNull
        public final Builder allEnabledCipherSuites() {
            if (this.tls) {
                this.cipherSuites = null;
                return this;
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        @NotNull
        public final Builder allEnabledTlsVersions() {
            if (this.tls) {
                this.tlsVersions = null;
                return this;
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        @NotNull
        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        @NotNull
        public final Builder cipherSuites(@NotNull CipherSuite... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (this.tls) {
                ArrayList arrayList = new ArrayList(cipherSuites.length);
                for (CipherSuite cipherSuite : cipherSuites) {
                    arrayList.add(cipherSuite.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    return cipherSuites((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        @Nullable
        /* renamed from: getCipherSuites$okhttp, reason: from getter */
        public final String[] getCipherSuites() {
            return this.cipherSuites;
        }

        /* renamed from: getSupportsTlsExtensions$okhttp, reason: from getter */
        public final boolean getSupportsTlsExtensions() {
            return this.supportsTlsExtensions;
        }

        /* renamed from: getTls$okhttp, reason: from getter */
        public final boolean getTls() {
            return this.tls;
        }

        @Nullable
        /* renamed from: getTlsVersions$okhttp, reason: from getter */
        public final String[] getTlsVersions() {
            return this.tlsVersions;
        }

        public final void setCipherSuites$okhttp(@Nullable String[] strArr) {
            this.cipherSuites = strArr;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean z16) {
            this.supportsTlsExtensions = z16;
        }

        public final void setTls$okhttp(boolean z16) {
            this.tls = z16;
        }

        public final void setTlsVersions$okhttp(@Nullable String[] strArr) {
            this.tlsVersions = strArr;
        }

        @Deprecated(message = "since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        @NotNull
        public final Builder supportsTlsExtensions(boolean supportsTlsExtensions) {
            if (this.tls) {
                this.supportsTlsExtensions = supportsTlsExtensions;
                return this;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        @NotNull
        public final Builder tlsVersions(@NotNull TlsVersion... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (this.tls) {
                ArrayList arrayList = new ArrayList(tlsVersions.length);
                for (TlsVersion tlsVersion : tlsVersions) {
                    arrayList.add(tlsVersion.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    return tlsVersions((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public Builder(@NotNull ConnectionSpec connectionSpec) {
            Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
            this.tls = connectionSpec.getIsTls();
            this.cipherSuites = connectionSpec.cipherSuitesAsString;
            this.tlsVersions = connectionSpec.tlsVersionsAsString;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions();
        }

        @NotNull
        public final Builder cipherSuites(@NotNull String... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (!this.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(cipherSuites.length == 0)) {
                Object clone = cipherSuites.clone();
                if (clone == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                this.cipherSuites = (String[]) clone;
                return this;
            }
            throw new IllegalArgumentException("At least one cipher suite is required".toString());
        }

        @NotNull
        public final Builder tlsVersions(@NotNull String... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (!this.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(tlsVersions.length == 0)) {
                Object clone = tlsVersions.clone();
                if (clone == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                this.tlsVersions = (String[]) clone;
                return this;
            }
            throw new IllegalArgumentException("At least one TLS version is required".toString());
        }
    }

    static {
        CipherSuite cipherSuite = CipherSuite.TLS_AES_128_GCM_SHA256;
        CipherSuite cipherSuite2 = CipherSuite.TLS_AES_256_GCM_SHA384;
        CipherSuite cipherSuite3 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite4 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite5 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite6 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite7 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite8 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite9 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9};
        RESTRICTED_CIPHER_SUITES = cipherSuiteArr;
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        APPROVED_CIPHER_SUITES = cipherSuiteArr2;
        Builder cipherSuites = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, cipherSuiteArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        RESTRICTED_TLS = cipherSuites.tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        MODERN_TLS = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length)).tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length)).tlsVersions(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }

    public ConnectionSpec(boolean z16, boolean z17, @Nullable String[] strArr, @Nullable String[] strArr2) {
        this.isTls = z16;
        this.supportsTlsExtensions = z17;
        this.cipherSuitesAsString = strArr;
        this.tlsVersionsAsString = strArr2;
    }

    private final ConnectionSpec supportedSpec(SSLSocket sslSocket, boolean isFallback) {
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        Comparator naturalOrder;
        if (this.cipherSuitesAsString != null) {
            String[] enabledCipherSuites = sslSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = Util.intersect(enabledCipherSuites, this.cipherSuitesAsString, CipherSuite.INSTANCE.getORDER_BY_NAME$okhttp());
        } else {
            cipherSuitesIntersection = sslSocket.getEnabledCipherSuites();
        }
        if (this.tlsVersionsAsString != null) {
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols, "sslSocket.enabledProtocols");
            String[] strArr = this.tlsVersionsAsString;
            naturalOrder = ComparisonsKt__ComparisonsKt.naturalOrder();
            tlsVersionsIntersection = Util.intersect(enabledProtocols, strArr, naturalOrder);
        } else {
            tlsVersionsIntersection = sslSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "supportedCipherSuites");
        int indexOf = Util.indexOf(supportedCipherSuites, "TLS_FALLBACK_SCSV", CipherSuite.INSTANCE.getORDER_BY_NAME$okhttp());
        if (isFallback && indexOf != -1) {
            Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[indexOf];
            Intrinsics.checkNotNullExpressionValue(str, "supportedCipherSuites[indexOfFallbackScsv]");
            cipherSuitesIntersection = Util.concat(cipherSuitesIntersection, str);
        }
        Builder builder = new Builder(this);
        Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
        Builder cipherSuites = builder.cipherSuites((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        return cipherSuites.tlsVersions((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).build();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuites", imports = {}))
    @JvmName(name = "-deprecated_cipherSuites")
    @Nullable
    /* renamed from: -deprecated_cipherSuites, reason: not valid java name */
    public final List<CipherSuite> m2087deprecated_cipherSuites() {
        return cipherSuites();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "supportsTlsExtensions", imports = {}))
    @JvmName(name = "-deprecated_supportsTlsExtensions")
    /* renamed from: -deprecated_supportsTlsExtensions, reason: not valid java name and from getter */
    public final boolean getSupportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersions", imports = {}))
    @JvmName(name = "-deprecated_tlsVersions")
    @Nullable
    /* renamed from: -deprecated_tlsVersions, reason: not valid java name */
    public final List<TlsVersion> m2089deprecated_tlsVersions() {
        return tlsVersions();
    }

    public final void apply$okhttp(@NotNull SSLSocket sslSocket, boolean isFallback) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        ConnectionSpec supportedSpec = supportedSpec(sslSocket, isFallback);
        if (supportedSpec.tlsVersions() != null) {
            sslSocket.setEnabledProtocols(supportedSpec.tlsVersionsAsString);
        }
        if (supportedSpec.cipherSuites() != null) {
            sslSocket.setEnabledCipherSuites(supportedSpec.cipherSuitesAsString);
        }
    }

    @JvmName(name = "cipherSuites")
    @Nullable
    public final List<CipherSuite> cipherSuites() {
        List<CipherSuite> list;
        String[] strArr = this.cipherSuitesAsString;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(CipherSuite.INSTANCE.forJavaName(str));
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            return list;
        }
        return null;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof ConnectionSpec)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        boolean z16 = this.isTls;
        ConnectionSpec connectionSpec = (ConnectionSpec) other;
        if (z16 != connectionSpec.isTls) {
            return false;
        }
        if (z16 && (!Arrays.equals(this.cipherSuitesAsString, connectionSpec.cipherSuitesAsString) || !Arrays.equals(this.tlsVersionsAsString, connectionSpec.tlsVersionsAsString) || this.supportsTlsExtensions != connectionSpec.supportsTlsExtensions)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        if (this.isTls) {
            String[] strArr = this.cipherSuitesAsString;
            int i16 = 0;
            if (strArr != null) {
                i3 = Arrays.hashCode(strArr);
            } else {
                i3 = 0;
            }
            int i17 = (527 + i3) * 31;
            String[] strArr2 = this.tlsVersionsAsString;
            if (strArr2 != null) {
                i16 = Arrays.hashCode(strArr2);
            }
            return ((i17 + i16) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
        }
        return 17;
    }

    public final boolean isCompatible(@NotNull SSLSocket socket) {
        Comparator naturalOrder;
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.isTls) {
            return false;
        }
        String[] strArr = this.tlsVersionsAsString;
        if (strArr != null) {
            String[] enabledProtocols = socket.getEnabledProtocols();
            naturalOrder = ComparisonsKt__ComparisonsKt.naturalOrder();
            if (!Util.hasIntersection(strArr, enabledProtocols, naturalOrder)) {
                return false;
            }
        }
        String[] strArr2 = this.cipherSuitesAsString;
        if (strArr2 != null && !Util.hasIntersection(strArr2, socket.getEnabledCipherSuites(), CipherSuite.INSTANCE.getORDER_BY_NAME$okhttp())) {
            return false;
        }
        return true;
    }

    @JvmName(name = "isTls")
    /* renamed from: isTls, reason: from getter */
    public final boolean getIsTls() {
        return this.isTls;
    }

    @JvmName(name = "supportsTlsExtensions")
    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @JvmName(name = "tlsVersions")
    @Nullable
    public final List<TlsVersion> tlsVersions() {
        List<TlsVersion> list;
        String[] strArr = this.tlsVersionsAsString;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(TlsVersion.INSTANCE.forJavaName(str));
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            return list;
        }
        return null;
    }

    @NotNull
    public String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(cipherSuites(), "[all enabled]") + ", tlsVersions=" + Objects.toString(tlsVersions(), "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }
}
