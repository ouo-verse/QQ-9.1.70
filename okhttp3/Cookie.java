package okhttp3;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.http.cookie.ClientCookie;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002%&BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\r\u0010\r\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\u0018J\r\u0010\u000b\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001dJ\r\u0010\b\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001eJ\r\u0010\f\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\u001fJ\r\u0010\t\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b J\b\u0010!\u001a\u00020\u0003H\u0016J\u0015\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH\u0000\u00a2\u0006\u0002\b#J\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b$R\u0013\u0010\u0007\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\b\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\f\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f\u00a8\u0006'"}, d2 = {"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", "domain", "path", ClientCookie.SECURE_ATTR, "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", "other", "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class Cookie {

    @NotNull
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;

    @NotNull
    private final String name;

    @NotNull
    private final String path;
    private final boolean persistent;
    private final boolean secure;

    @NotNull
    private final String value;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lokhttp3/Cookie$Builder;", "", "()V", "domain", "", "expiresAt", "", "hostOnly", "", "httpOnly", "name", "path", "persistent", ClientCookie.SECURE_ATTR, "value", "build", "Lokhttp3/Cookie;", "hostOnlyDomain", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;
        private String path = "/";

        @NotNull
        public final Cookie build() {
            String str = this.name;
            if (str != null) {
                String str2 = this.value;
                if (str2 != null) {
                    long j3 = this.expiresAt;
                    String str3 = this.domain;
                    if (str3 != null) {
                        return new Cookie(str, str2, j3, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
                    }
                    throw new NullPointerException("builder.domain == null");
                }
                throw new NullPointerException("builder.value == null");
            }
            throw new NullPointerException("builder.name == null");
        }

        @NotNull
        public final Builder domain(@NotNull String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            return domain(domain, false);
        }

        @NotNull
        public final Builder expiresAt(long expiresAt) {
            if (expiresAt <= 0) {
                expiresAt = Long.MIN_VALUE;
            }
            if (expiresAt > DatesKt.MAX_DATE) {
                expiresAt = 253402300799999L;
            }
            this.expiresAt = expiresAt;
            this.persistent = true;
            return this;
        }

        @NotNull
        public final Builder hostOnlyDomain(@NotNull String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            return domain(domain, true);
        }

        @NotNull
        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        @NotNull
        public final Builder name(@NotNull String name) {
            CharSequence trim;
            Intrinsics.checkNotNullParameter(name, "name");
            trim = StringsKt__StringsKt.trim((CharSequence) name);
            if (Intrinsics.areEqual(trim.toString(), name)) {
                this.name = name;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        @NotNull
        public final Builder path(@NotNull String path) {
            boolean startsWith$default;
            Intrinsics.checkNotNullParameter(path, "path");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "/", false, 2, null);
            if (startsWith$default) {
                this.path = path;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        @NotNull
        public final Builder secure() {
            this.secure = true;
            return this;
        }

        @NotNull
        public final Builder value(@NotNull String value) {
            CharSequence trim;
            Intrinsics.checkNotNullParameter(value, "value");
            trim = StringsKt__StringsKt.trim((CharSequence) value);
            if (Intrinsics.areEqual(trim.toString(), value)) {
                this.value = value;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        private final Builder domain(String domain, boolean hostOnly) {
            String canonicalHost = HostnamesKt.toCanonicalHost(domain);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = hostOnly;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + domain);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000\u00a2\u0006\u0002\b\u001bJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", c.G, "limit", "invert", "", "domainMatch", "urlHost", "domain", "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", ReportConstant.COSTREPORT_PREFIX, "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        private final int dateCharacterOffset(String input, int pos, int limit, boolean invert) {
            boolean z16;
            while (pos < limit) {
                char charAt = input.charAt(pos);
                if ((charAt >= ' ' || charAt == '\t') && charAt < '\u007f' && (('0' > charAt || '9' < charAt) && (('a' > charAt || 'z' < charAt) && (('A' > charAt || 'Z' < charAt) && charAt != ':')))) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16 == (!invert)) {
                    return pos;
                }
                pos++;
            }
            return limit;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String urlHost, String domain) {
            boolean endsWith$default;
            if (!Intrinsics.areEqual(urlHost, domain)) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(urlHost, domain, false, 2, null);
                if (endsWith$default && urlHost.charAt((urlHost.length() - domain.length()) - 1) == '.' && !Util.canParseAsIpAddress(urlHost)) {
                    return true;
                }
                return false;
            }
            return true;
        }

        private final String parseDomain(String s16) {
            boolean endsWith$default;
            String removePrefix;
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(s16, ".", false, 2, null);
            if (!endsWith$default) {
                removePrefix = StringsKt__StringsKt.removePrefix(s16, (CharSequence) ".");
                String canonicalHost = HostnamesKt.toCanonicalHost(removePrefix);
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseExpires(String s16, int pos, int limit) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            int indexOf$default;
            int dateCharacterOffset = dateCharacterOffset(s16, pos, limit, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(s16);
            int i3 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            int i26 = -1;
            while (dateCharacterOffset < limit) {
                int dateCharacterOffset2 = dateCharacterOffset(s16, dateCharacterOffset + 1, limit, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i16 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group, "matcher.group(1)");
                    i16 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group2, "matcher.group(2)");
                    i19 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(group3, "matcher.group(3)");
                    i26 = Integer.parseInt(group3);
                } else if (i17 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group4, "matcher.group(1)");
                    i17 = Integer.parseInt(group4);
                } else if (i18 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                    if (group5 != null) {
                        String lowerCase = group5.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        String pattern = Cookie.MONTH_PATTERN.pattern();
                        Intrinsics.checkNotNullExpressionValue(pattern, "MONTH_PATTERN.pattern()");
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) pattern, lowerCase, 0, false, 6, (Object) null);
                        i18 = indexOf$default / 4;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else if (i3 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group6, "matcher.group(1)");
                    i3 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(s16, dateCharacterOffset2 + 1, limit, false);
            }
            if (70 <= i3 && 99 >= i3) {
                i3 += 1900;
            }
            if (i3 >= 0 && 69 >= i3) {
                i3 += 2000;
            }
            if (i3 >= 1601) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (i18 != -1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (1 <= i17 && 31 >= i17) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        if (i16 >= 0 && 23 >= i16) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            if (i19 >= 0 && 59 >= i19) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                if (i26 >= 0 && 59 >= i26) {
                                    z27 = true;
                                } else {
                                    z27 = false;
                                }
                                if (z27) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i3);
                                    gregorianCalendar.set(2, i18 - 1);
                                    gregorianCalendar.set(5, i17);
                                    gregorianCalendar.set(11, i16);
                                    gregorianCalendar.set(12, i19);
                                    gregorianCalendar.set(13, i26);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseMaxAge(String s16) {
            boolean startsWith$default;
            try {
                long parseLong = Long.parseLong(s16);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e16) {
                if (new Regex("-?\\d+").matches(s16)) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(s16, "-", false, 2, null);
                    if (startsWith$default) {
                        return Long.MIN_VALUE;
                    }
                    return Long.MAX_VALUE;
                }
                throw e16;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl url, String path) {
            boolean startsWith$default;
            boolean endsWith$default;
            String encodedPath = url.encodedPath();
            if (!Intrinsics.areEqual(encodedPath, path)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(encodedPath, path, false, 2, null);
                if (startsWith$default) {
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, "/", false, 2, null);
                    if (endsWith$default || encodedPath.charAt(path.length()) == '/') {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        @JvmStatic
        @Nullable
        public final Cookie parse(@NotNull HttpUrl url, @NotNull String setCookie) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        /* JADX WARN: Code restructure failed: missing block: B:88:0x010b, code lost:
        
            if (r1 > okhttp3.internal.http.DatesKt.MAX_DATE) goto L59;
         */
        /* JADX WARN: Removed duplicated region for block: B:56:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0148  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0164  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0120  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Cookie parse$okhttp(long currentTimeMillis, @NotNull HttpUrl url, @NotNull String setCookie) {
            boolean z16;
            long j3;
            long j16;
            long j17;
            String host;
            Cookie cookie;
            String str;
            String str2;
            int lastIndexOf$default;
            String str3;
            boolean startsWith$default;
            String str4;
            boolean equals;
            boolean equals2;
            boolean equals3;
            boolean equals4;
            boolean equals5;
            boolean equals6;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            int delimiterOffset$default = Util.delimiterOffset$default(setCookie, ';', 0, 0, 6, (Object) null);
            int delimiterOffset$default2 = Util.delimiterOffset$default(setCookie, '=', 0, delimiterOffset$default, 2, (Object) null);
            if (delimiterOffset$default2 == delimiterOffset$default) {
                return null;
            }
            String trimSubstring$default = Util.trimSubstring$default(setCookie, 0, delimiterOffset$default2, 1, null);
            if (trimSubstring$default.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || Util.indexOfControlOrNonAscii(trimSubstring$default) != -1) {
                return null;
            }
            String trimSubstring = Util.trimSubstring(setCookie, delimiterOffset$default2 + 1, delimiterOffset$default);
            if (Util.indexOfControlOrNonAscii(trimSubstring) != -1) {
                return null;
            }
            int i3 = delimiterOffset$default + 1;
            int length = setCookie.length();
            String str5 = null;
            String str6 = null;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            boolean z26 = true;
            long j18 = -1;
            long j19 = DatesKt.MAX_DATE;
            while (i3 < length) {
                int delimiterOffset = Util.delimiterOffset(setCookie, ';', i3, length);
                int delimiterOffset2 = Util.delimiterOffset(setCookie, '=', i3, delimiterOffset);
                String trimSubstring2 = Util.trimSubstring(setCookie, i3, delimiterOffset2);
                if (delimiterOffset2 < delimiterOffset) {
                    str4 = Util.trimSubstring(setCookie, delimiterOffset2 + 1, delimiterOffset);
                } else {
                    str4 = "";
                }
                equals = StringsKt__StringsJVMKt.equals(trimSubstring2, "expires", true);
                if (!equals) {
                    equals2 = StringsKt__StringsJVMKt.equals(trimSubstring2, "max-age", true);
                    if (!equals2) {
                        equals3 = StringsKt__StringsJVMKt.equals(trimSubstring2, "domain", true);
                        if (!equals3) {
                            equals4 = StringsKt__StringsJVMKt.equals(trimSubstring2, "path", true);
                            if (!equals4) {
                                equals5 = StringsKt__StringsJVMKt.equals(trimSubstring2, ClientCookie.SECURE_ATTR, true);
                                if (!equals5) {
                                    equals6 = StringsKt__StringsJVMKt.equals(trimSubstring2, "httponly", true);
                                    if (equals6) {
                                        z18 = true;
                                    }
                                } else {
                                    z17 = true;
                                }
                            } else {
                                str6 = str4;
                            }
                        } else {
                            str5 = parseDomain(str4);
                            z26 = false;
                        }
                        i3 = delimiterOffset + 1;
                    } else {
                        j18 = parseMaxAge(str4);
                    }
                } else {
                    try {
                        j19 = parseExpires(str4, 0, str4.length());
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                }
                z19 = true;
                i3 = delimiterOffset + 1;
            }
            long j26 = Long.MIN_VALUE;
            if (j18 != Long.MIN_VALUE) {
                if (j18 != -1) {
                    if (j18 <= 9223372036854775L) {
                        j16 = j18 * 1000;
                    } else {
                        j16 = Long.MAX_VALUE;
                    }
                    j26 = currentTimeMillis + j16;
                    if (j26 >= currentTimeMillis) {
                        j17 = DatesKt.MAX_DATE;
                    } else {
                        j17 = DatesKt.MAX_DATE;
                    }
                    j3 = j17;
                } else {
                    j3 = j19;
                }
                host = url.host();
                if (str5 != null) {
                    str = host;
                    cookie = null;
                } else {
                    if (!domainMatch(host, str5)) {
                        return null;
                    }
                    cookie = null;
                    str = str5;
                }
                if (host.length() == str.length() && PublicSuffixDatabase.INSTANCE.get().getEffectiveTldPlusOne(str) == null) {
                    return cookie;
                }
                String str7 = "/";
                str2 = str6;
                if (str2 != null) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "/", false, 2, cookie);
                    if (startsWith$default) {
                        str3 = str2;
                        return new Cookie(trimSubstring$default, trimSubstring, j3, str, str3, z17, z18, z19, z26, null);
                    }
                }
                String encodedPath = url.encodedPath();
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) encodedPath, '/', 0, false, 6, (Object) null);
                if (lastIndexOf$default != 0) {
                    if (encodedPath != null) {
                        str7 = encodedPath.substring(0, lastIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(str7, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                str3 = str7;
                return new Cookie(trimSubstring$default, trimSubstring, j3, str, str3, z17, z18, z19, z26, null);
            }
            j3 = j26;
            host = url.host();
            if (str5 != null) {
            }
            if (host.length() == str.length()) {
            }
            String str72 = "/";
            str2 = str6;
            if (str2 != null) {
            }
            String encodedPath2 = url.encodedPath();
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) encodedPath2, '/', 0, false, 6, (Object) null);
            if (lastIndexOf$default != 0) {
            }
            str3 = str72;
            return new Cookie(trimSubstring$default, trimSubstring, j3, str, str3, z17, z18, z19, z26, null);
        }

        @JvmStatic
        @NotNull
        public final List<Cookie> parseAll(@NotNull HttpUrl url, @NotNull Headers headers) {
            List<Cookie> emptyList;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            for (int i3 = 0; i3 < size; i3++) {
                Cookie parse = parse(url, values.get(i3));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(cookies)");
            return unmodifiableList;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    Cookie(String str, String str2, long j3, String str3, String str4, boolean z16, boolean z17, boolean z18, boolean z19) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j3;
        this.domain = str3;
        this.path = str4;
        this.secure = z16;
        this.httpOnly = z17;
        this.persistent = z18;
        this.hostOnly = z19;
    }

    @JvmStatic
    @Nullable
    public static final Cookie parse(@NotNull HttpUrl httpUrl, @NotNull String str) {
        return INSTANCE.parse(httpUrl, str);
    }

    @JvmStatic
    @NotNull
    public static final List<Cookie> parseAll(@NotNull HttpUrl httpUrl, @NotNull Headers headers) {
        return INSTANCE.parseAll(httpUrl, headers);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "domain", imports = {}))
    @JvmName(name = "-deprecated_domain")
    @NotNull
    /* renamed from: -deprecated_domain, reason: not valid java name and from getter */
    public final String getDomain() {
        return this.domain;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}))
    @JvmName(name = "-deprecated_expiresAt")
    /* renamed from: -deprecated_expiresAt, reason: not valid java name and from getter */
    public final long getExpiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}))
    @JvmName(name = "-deprecated_hostOnly")
    /* renamed from: -deprecated_hostOnly, reason: not valid java name and from getter */
    public final boolean getHostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}))
    @JvmName(name = "-deprecated_httpOnly")
    /* renamed from: -deprecated_httpOnly, reason: not valid java name and from getter */
    public final boolean getHttpOnly() {
        return this.httpOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "name", imports = {}))
    @JvmName(name = "-deprecated_name")
    @NotNull
    /* renamed from: -deprecated_name, reason: not valid java name and from getter */
    public final String getName() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}))
    @JvmName(name = "-deprecated_path")
    @NotNull
    /* renamed from: -deprecated_path, reason: not valid java name and from getter */
    public final String getPath() {
        return this.path;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}))
    @JvmName(name = "-deprecated_persistent")
    /* renamed from: -deprecated_persistent, reason: not valid java name and from getter */
    public final boolean getPersistent() {
        return this.persistent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ClientCookie.SECURE_ATTR, imports = {}))
    @JvmName(name = "-deprecated_secure")
    /* renamed from: -deprecated_secure, reason: not valid java name and from getter */
    public final boolean getSecure() {
        return this.secure;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "value", imports = {}))
    @JvmName(name = "-deprecated_value")
    @NotNull
    /* renamed from: -deprecated_value, reason: not valid java name and from getter */
    public final String getValue() {
        return this.value;
    }

    @JvmName(name = "domain")
    @NotNull
    public final String domain() {
        return this.domain;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof Cookie) {
            Cookie cookie = (Cookie) other;
            if (Intrinsics.areEqual(cookie.name, this.name) && Intrinsics.areEqual(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.areEqual(cookie.domain, this.domain) && Intrinsics.areEqual(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "expiresAt")
    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + androidx.fragment.app.a.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + com.tencent.aio.widget.textView.param.a.a(this.secure)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.httpOnly)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.persistent)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.hostOnly);
    }

    @JvmName(name = "hostOnly")
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    @JvmName(name = "httpOnly")
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(@NotNull HttpUrl url) {
        boolean domainMatch;
        Intrinsics.checkNotNullParameter(url, "url");
        if (!this.hostOnly) {
            domainMatch = INSTANCE.domainMatch(url.host(), this.domain);
        } else {
            domainMatch = Intrinsics.areEqual(url.host(), this.domain);
        }
        if (!domainMatch || !INSTANCE.pathMatch(url, this.path)) {
            return false;
        }
        if (this.secure && !url.getIsHttps()) {
            return false;
        }
        return true;
    }

    @JvmName(name = "name")
    @NotNull
    public final String name() {
        return this.name;
    }

    @JvmName(name = "path")
    @NotNull
    public final String path() {
        return this.path;
    }

    @JvmName(name = "persistent")
    public final boolean persistent() {
        return this.persistent;
    }

    @JvmName(name = ClientCookie.SECURE_ATTR)
    public final boolean secure() {
        return this.secure;
    }

    @NotNull
    public String toString() {
        return toString$okhttp(false);
    }

    @NotNull
    public final String toString$okhttp(boolean forObsoleteRfc2965) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.name);
        sb5.append('=');
        sb5.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb5.append("; max-age=0");
            } else {
                sb5.append("; expires=");
                sb5.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb5.append("; domain=");
            if (forObsoleteRfc2965) {
                sb5.append(".");
            }
            sb5.append(this.domain);
        }
        sb5.append("; path=");
        sb5.append(this.path);
        if (this.secure) {
            sb5.append("; secure");
        }
        if (this.httpOnly) {
            sb5.append("; httponly");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "toString()");
        return sb6;
    }

    @JvmName(name = "value")
    @NotNull
    public final String value() {
        return this.value;
    }

    public /* synthetic */ Cookie(String str, String str2, long j3, String str3, String str4, boolean z16, boolean z17, boolean z18, boolean z19, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j3, str3, str4, z16, z17, z18, z19);
    }
}
