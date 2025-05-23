package okhttp3;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lokhttp3/MediaType;", "", "mediaType", "", "type", "subtype", "parameterNamesAndValues", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "[Ljava/lang/String;", "()Ljava/lang/String;", HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", RemoteHandleConst.PARAM_DEFAULT_VALUE, "equals", "", "other", "hashCode", "", "parameter", "name", "-deprecated_subtype", "toString", "-deprecated_type", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;

    @NotNull
    private final String subtype;

    @NotNull
    private final String type;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\b\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\b\u000fJ\u0011\u0010\u0010\u001a\u00020\u000b*\u00020\u0007H\u0007\u00a2\u0006\u0002\b\nJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0007\u00a2\u0006\u0002\b\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lokhttp3/MediaType$Companion;", "", "()V", "PARAMETER", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "QUOTED", "", "TOKEN", "TYPE_SUBTYPE", "get", "Lokhttp3/MediaType;", "mediaType", "-deprecated_get", "parse", "-deprecated_parse", "toMediaType", "toMediaTypeOrNull", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaType()", imports = {"okhttp3.MediaType.Companion.toMediaType"}))
        @JvmName(name = "-deprecated_get")
        @NotNull
        /* renamed from: -deprecated_get */
        public final MediaType m2136deprecated_get(@NotNull String mediaType) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            return get(mediaType);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaTypeOrNull()", imports = {"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
        @JvmName(name = "-deprecated_parse")
        @Nullable
        /* renamed from: -deprecated_parse */
        public final MediaType m2137deprecated_parse(@NotNull String mediaType) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            return parse(mediaType);
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        public final MediaType get(@NotNull String toMediaType) {
            boolean startsWith$default;
            boolean endsWith$default;
            Intrinsics.checkNotNullParameter(toMediaType, "$this$toMediaType");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(toMediaType);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                if (group != null) {
                    String lowerCase = group.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String group2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group2, "typeSubtype.group(2)");
                    Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                    if (group2 != null) {
                        String lowerCase2 = group2.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        ArrayList arrayList = new ArrayList();
                        Matcher matcher2 = MediaType.PARAMETER.matcher(toMediaType);
                        int end = matcher.end();
                        while (end < toMediaType.length()) {
                            matcher2.region(end, toMediaType.length());
                            if (matcher2.lookingAt()) {
                                String group3 = matcher2.group(1);
                                if (group3 == null) {
                                    end = matcher2.end();
                                } else {
                                    String group4 = matcher2.group(2);
                                    if (group4 != null) {
                                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(group4, "'", false, 2, null);
                                        if (startsWith$default) {
                                            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(group4, "'", false, 2, null);
                                            if (endsWith$default && group4.length() > 2) {
                                                group4 = group4.substring(1, group4.length() - 1);
                                                Intrinsics.checkNotNullExpressionValue(group4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                                            }
                                        }
                                    } else {
                                        group4 = matcher2.group(3);
                                    }
                                    arrayList.add(group3);
                                    arrayList.add(group4);
                                    end = matcher2.end();
                                }
                            } else {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("Parameter is not formatted correctly: \"");
                                String substring = toMediaType.substring(end);
                                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                                sb5.append(substring);
                                sb5.append("\" for: \"");
                                sb5.append(toMediaType);
                                sb5.append('\"');
                                throw new IllegalArgumentException(sb5.toString().toString());
                            }
                        }
                        Object[] array = arrayList.toArray(new String[0]);
                        if (array != null) {
                            return new MediaType(toMediaType, lowerCase, lowerCase2, (String[]) array, null);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + toMediaType + '\"').toString());
        }

        @JvmStatic
        @JvmName(name = "parse")
        @Nullable
        public final MediaType parse(@NotNull String toMediaTypeOrNull) {
            Intrinsics.checkNotNullParameter(toMediaTypeOrNull, "$this$toMediaTypeOrNull");
            try {
                return get(toMediaTypeOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    MediaType(String str, String str2, String str3, String[] strArr) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    public static final MediaType get(@NotNull String str) {
        return INSTANCE.get(str);
    }

    @JvmStatic
    @JvmName(name = "parse")
    @Nullable
    public static final MediaType parse(@NotNull String str) {
        return INSTANCE.parse(str);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "subtype", imports = {}))
    @JvmName(name = "-deprecated_subtype")
    @NotNull
    /* renamed from: -deprecated_subtype, reason: from getter */
    public final String getSubtype() {
        return this.subtype;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    @JvmName(name = "-deprecated_type")
    @NotNull
    /* renamed from: -deprecated_type, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @JvmOverloads
    @Nullable
    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof MediaType) && Intrinsics.areEqual(((MediaType) other).mediaType, this.mediaType)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x002d */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String parameter(@NotNull String name) {
        IntRange indices;
        IntProgression step;
        boolean equals;
        Intrinsics.checkNotNullParameter(name, "name");
        indices = ArraysKt___ArraysKt.getIndices(this.parameterNamesAndValues);
        step = RangesKt___RangesKt.step(indices, 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 >= 0) {
            if (first > last) {
                return null;
            }
        } else if (first < last) {
            return null;
        }
        while (!equals) {
            if (first != last) {
                first += step2;
            } else {
                return null;
            }
        }
        return this.parameterNamesAndValues[first + 1];
    }

    @JvmName(name = "subtype")
    @NotNull
    public final String subtype() {
        return this.subtype;
    }

    @NotNull
    /* renamed from: toString, reason: from getter */
    public String getMediaType() {
        return this.mediaType;
    }

    @JvmName(name = "type")
    @NotNull
    public final String type() {
        return this.type;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, strArr);
    }

    @JvmOverloads
    @Nullable
    public final Charset charset(@Nullable Charset charset) {
        String parameter = parameter(HttpMsg.CHARSET);
        if (parameter == null) {
            return charset;
        }
        try {
            return Charset.forName(parameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
