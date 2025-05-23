package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014\u00a8\u0006\""}, d2 = {"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();

    @JvmField
    @NotNull
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", "build", "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j3) {
            if (j3 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j3;
        }

        @NotNull
        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        @NotNull
        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        @NotNull
        public final Builder maxAge(int maxAge, @NotNull TimeUnit timeUnit) {
            boolean z16;
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (maxAge >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(maxAge));
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + maxAge).toString());
        }

        @NotNull
        public final Builder maxStale(int maxStale, @NotNull TimeUnit timeUnit) {
            boolean z16;
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (maxStale >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(maxStale));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + maxStale).toString());
        }

        @NotNull
        public final Builder minFresh(int minFresh, @NotNull TimeUnit timeUnit) {
            boolean z16;
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (minFresh >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds(minFresh));
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + minFresh).toString());
        }

        @NotNull
        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        @NotNull
        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        @NotNull
        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        @NotNull
        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        private final int indexOfElement(String str, String str2, int i3) {
            boolean contains$default;
            int length = str.length();
            while (i3 < length) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, str.charAt(i3), false, 2, (Object) null);
                if (contains$default) {
                    return i3;
                }
                i3++;
            }
            return str.length();
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            return companion.indexOfElement(str, str2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00e9  */
        @JvmStatic
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final CacheControl parse(@NotNull Headers headers) {
            String str;
            boolean equals;
            boolean equals2;
            int i3;
            int i16;
            CharSequence trim;
            boolean z16;
            int i17;
            String str2;
            boolean equals3;
            boolean equals4;
            boolean equals5;
            char c16;
            boolean equals6;
            boolean equals7;
            boolean equals8;
            boolean equals9;
            boolean equals10;
            boolean equals11;
            boolean equals12;
            boolean equals13;
            boolean equals14;
            CharSequence trim2;
            int indexOf$default;
            Headers headers2 = headers;
            Intrinsics.checkNotNullParameter(headers2, "headers");
            int size = headers.size();
            boolean z17 = true;
            boolean z18 = true;
            int i18 = 0;
            String str3 = null;
            boolean z19 = false;
            boolean z26 = false;
            int i19 = -1;
            int i26 = -1;
            boolean z27 = false;
            boolean z28 = false;
            boolean z29 = false;
            int i27 = -1;
            int i28 = -1;
            boolean z36 = false;
            boolean z37 = false;
            boolean z38 = false;
            while (i18 < size) {
                String name = headers2.name(i18);
                String value = headers2.value(i18);
                equals = StringsKt__StringsJVMKt.equals(name, "Cache-Control", z17);
                if (!equals) {
                    equals2 = StringsKt__StringsJVMKt.equals(name, "Pragma", z17);
                    if (!equals2) {
                        i3 = size;
                        i18++;
                        headers2 = headers;
                        size = i3;
                    }
                } else if (str3 == null) {
                    str3 = value;
                    i16 = 0;
                    while (i16 < value.length()) {
                        int indexOfElement = indexOfElement(value, "=,;", i16);
                        String substring = value.substring(i16, indexOfElement);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        if (substring != null) {
                            trim = StringsKt__StringsKt.trim((CharSequence) substring);
                            String obj = trim.toString();
                            int i29 = size;
                            if (indexOfElement != value.length()) {
                                z16 = z18;
                                if (value.charAt(indexOfElement) != ',' && value.charAt(indexOfElement) != ';') {
                                    int indexOfNonWhitespace = Util.indexOfNonWhitespace(value, indexOfElement + 1);
                                    if (indexOfNonWhitespace < value.length() && value.charAt(indexOfNonWhitespace) == '\"') {
                                        int i36 = indexOfNonWhitespace + 1;
                                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) value, '\"', i36, false, 4, (Object) null);
                                        str2 = value.substring(i36, indexOf$default);
                                        Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                                        i17 = indexOf$default + 1;
                                    } else {
                                        i17 = indexOfElement(value, ",;", indexOfNonWhitespace);
                                        String substring2 = value.substring(indexOfNonWhitespace, i17);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                                        if (substring2 != null) {
                                            trim2 = StringsKt__StringsKt.trim((CharSequence) substring2);
                                            str2 = trim2.toString();
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                        }
                                    }
                                    z17 = true;
                                    equals3 = StringsKt__StringsJVMKt.equals("no-cache", obj, true);
                                    if (equals3) {
                                        equals4 = StringsKt__StringsJVMKt.equals("no-store", obj, true);
                                        if (!equals4) {
                                            equals5 = StringsKt__StringsJVMKt.equals("max-age", obj, true);
                                            if (equals5) {
                                                c16 = '\uffff';
                                                i19 = Util.toNonNegativeInt(str2, -1);
                                            } else {
                                                c16 = '\uffff';
                                                equals6 = StringsKt__StringsJVMKt.equals("s-maxage", obj, true);
                                                if (!equals6) {
                                                    equals7 = StringsKt__StringsJVMKt.equals("private", obj, true);
                                                    if (!equals7) {
                                                        equals8 = StringsKt__StringsJVMKt.equals("public", obj, true);
                                                        if (!equals8) {
                                                            equals9 = StringsKt__StringsJVMKt.equals("must-revalidate", obj, true);
                                                            if (!equals9) {
                                                                equals10 = StringsKt__StringsJVMKt.equals("max-stale", obj, true);
                                                                if (!equals10) {
                                                                    equals11 = StringsKt__StringsJVMKt.equals("min-fresh", obj, true);
                                                                    if (!equals11) {
                                                                        equals12 = StringsKt__StringsJVMKt.equals("only-if-cached", obj, true);
                                                                        if (!equals12) {
                                                                            equals13 = StringsKt__StringsJVMKt.equals("no-transform", obj, true);
                                                                            if (!equals13) {
                                                                                equals14 = StringsKt__StringsJVMKt.equals("immutable", obj, true);
                                                                                if (equals14) {
                                                                                    z38 = true;
                                                                                }
                                                                            } else {
                                                                                z37 = true;
                                                                            }
                                                                        } else {
                                                                            z36 = true;
                                                                        }
                                                                    } else {
                                                                        i28 = Util.toNonNegativeInt(str2, -1);
                                                                    }
                                                                    i16 = i17;
                                                                    size = i29;
                                                                    z18 = z16;
                                                                } else {
                                                                    i27 = Util.toNonNegativeInt(str2, Integer.MAX_VALUE);
                                                                }
                                                            } else {
                                                                z29 = true;
                                                            }
                                                        } else {
                                                            z28 = true;
                                                        }
                                                    } else {
                                                        z27 = true;
                                                    }
                                                } else {
                                                    i26 = Util.toNonNegativeInt(str2, -1);
                                                }
                                            }
                                            i16 = i17;
                                            size = i29;
                                            z18 = z16;
                                        } else {
                                            z26 = true;
                                        }
                                    } else {
                                        z19 = true;
                                    }
                                    i16 = i17;
                                    size = i29;
                                    z18 = z16;
                                }
                            } else {
                                z16 = z18;
                            }
                            i17 = indexOfElement + 1;
                            str2 = null;
                            z17 = true;
                            equals3 = StringsKt__StringsJVMKt.equals("no-cache", obj, true);
                            if (equals3) {
                            }
                            i16 = i17;
                            size = i29;
                            z18 = z16;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    }
                    i3 = size;
                    i18++;
                    headers2 = headers;
                    size = i3;
                }
                z18 = false;
                i16 = 0;
                while (i16 < value.length()) {
                }
                i3 = size;
                i18++;
                headers2 = headers;
                size = i3;
            }
            if (!z18) {
                str = null;
            } else {
                str = str3;
            }
            return new CacheControl(z19, z26, i19, i26, z27, z28, z29, i27, i28, z36, z37, z38, str, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    CacheControl(boolean z16, boolean z17, int i3, int i16, boolean z18, boolean z19, boolean z26, int i17, int i18, boolean z27, boolean z28, boolean z29, String str) {
        this.noCache = z16;
        this.noStore = z17;
        this.maxAgeSeconds = i3;
        this.sMaxAgeSeconds = i16;
        this.isPrivate = z18;
        this.isPublic = z19;
        this.mustRevalidate = z26;
        this.maxStaleSeconds = i17;
        this.minFreshSeconds = i18;
        this.onlyIfCached = z27;
        this.noTransform = z28;
        this.immutable = z29;
        this.headerValue = str;
    }

    @JvmStatic
    @NotNull
    public static final CacheControl parse(@NotNull Headers headers) {
        return INSTANCE.parse(headers);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}))
    @JvmName(name = "-deprecated_immutable")
    /* renamed from: -deprecated_immutable, reason: not valid java name and from getter */
    public final boolean getImmutable() {
        return this.immutable;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}))
    @JvmName(name = "-deprecated_maxAgeSeconds")
    /* renamed from: -deprecated_maxAgeSeconds, reason: not valid java name and from getter */
    public final int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}))
    @JvmName(name = "-deprecated_maxStaleSeconds")
    /* renamed from: -deprecated_maxStaleSeconds, reason: not valid java name and from getter */
    public final int getMaxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}))
    @JvmName(name = "-deprecated_minFreshSeconds")
    /* renamed from: -deprecated_minFreshSeconds, reason: not valid java name and from getter */
    public final int getMinFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}))
    @JvmName(name = "-deprecated_mustRevalidate")
    /* renamed from: -deprecated_mustRevalidate, reason: not valid java name and from getter */
    public final boolean getMustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}))
    @JvmName(name = "-deprecated_noCache")
    /* renamed from: -deprecated_noCache, reason: not valid java name and from getter */
    public final boolean getNoCache() {
        return this.noCache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}))
    @JvmName(name = "-deprecated_noStore")
    /* renamed from: -deprecated_noStore, reason: not valid java name and from getter */
    public final boolean getNoStore() {
        return this.noStore;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}))
    @JvmName(name = "-deprecated_noTransform")
    /* renamed from: -deprecated_noTransform, reason: not valid java name and from getter */
    public final boolean getNoTransform() {
        return this.noTransform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}))
    @JvmName(name = "-deprecated_onlyIfCached")
    /* renamed from: -deprecated_onlyIfCached, reason: not valid java name and from getter */
    public final boolean getOnlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}))
    @JvmName(name = "-deprecated_sMaxAgeSeconds")
    /* renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name and from getter */
    public final int getSMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @JvmName(name = "immutable")
    public final boolean immutable() {
        return this.immutable;
    }

    /* renamed from: isPrivate, reason: from getter */
    public final boolean getIsPrivate() {
        return this.isPrivate;
    }

    /* renamed from: isPublic, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    @JvmName(name = "maxAgeSeconds")
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @JvmName(name = "maxStaleSeconds")
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @JvmName(name = "minFreshSeconds")
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @JvmName(name = "mustRevalidate")
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @JvmName(name = "noCache")
    public final boolean noCache() {
        return this.noCache;
    }

    @JvmName(name = "noStore")
    public final boolean noStore() {
        return this.noStore;
    }

    @JvmName(name = "noTransform")
    public final boolean noTransform() {
        return this.noTransform;
    }

    @JvmName(name = "onlyIfCached")
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @JvmName(name = "sMaxAgeSeconds")
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @NotNull
    public String toString() {
        boolean z16;
        String str = this.headerValue;
        if (str == null) {
            StringBuilder sb5 = new StringBuilder();
            if (this.noCache) {
                sb5.append("no-cache, ");
            }
            if (this.noStore) {
                sb5.append("no-store, ");
            }
            if (this.maxAgeSeconds != -1) {
                sb5.append("max-age=");
                sb5.append(this.maxAgeSeconds);
                sb5.append(", ");
            }
            if (this.sMaxAgeSeconds != -1) {
                sb5.append("s-maxage=");
                sb5.append(this.sMaxAgeSeconds);
                sb5.append(", ");
            }
            if (this.isPrivate) {
                sb5.append("private, ");
            }
            if (this.isPublic) {
                sb5.append("public, ");
            }
            if (this.mustRevalidate) {
                sb5.append("must-revalidate, ");
            }
            if (this.maxStaleSeconds != -1) {
                sb5.append("max-stale=");
                sb5.append(this.maxStaleSeconds);
                sb5.append(", ");
            }
            if (this.minFreshSeconds != -1) {
                sb5.append("min-fresh=");
                sb5.append(this.minFreshSeconds);
                sb5.append(", ");
            }
            if (this.onlyIfCached) {
                sb5.append("only-if-cached, ");
            }
            if (this.noTransform) {
                sb5.append("no-transform, ");
            }
            if (this.immutable) {
                sb5.append("immutable, ");
            }
            if (sb5.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return "";
            }
            sb5.delete(sb5.length() - 2, sb5.length());
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
            this.headerValue = sb6;
            return sb6;
        }
        return str;
    }

    public /* synthetic */ CacheControl(boolean z16, boolean z17, int i3, int i16, boolean z18, boolean z19, boolean z26, int i17, int i18, boolean z27, boolean z28, boolean z29, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, z17, i3, i16, z18, z19, z26, i17, i18, z27, z28, z29, str);
    }
}
