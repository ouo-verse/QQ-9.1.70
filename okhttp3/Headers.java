package okhttp3;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 '2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002&'B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001b\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0019H\u0096\u0002J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\r\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!J\b\u0010#\u001a\u00020\u0003H\u0016J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010\u0012\u001a\u00020\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\n\u00a8\u0006("}, d2 = {"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "namesAndValues", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "size", "", "()I", "byteCount", "", "equals", "", "other", "", "get", "name", "getDate", "Ljava/util/Date;", "getInstant", "Ljava/time/Instant;", "hashCode", "iterator", "", "index", "names", "", "newBuilder", "Lokhttp3/Headers$Builder;", "-deprecated_size", "toMultimap", "", "", "toString", "value", "values", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String[] namesAndValues;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rJ\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\b\u0012J\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0010J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rH\u0086\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lokhttp3/Headers$Builder;", "", "()V", "namesAndValues", "", "", "getNamesAndValues$okhttp", "()Ljava/util/List;", "add", "line", "name", "value", "Ljava/time/Instant;", "Ljava/util/Date;", "addAll", "headers", "Lokhttp3/Headers;", "addLenient", "addLenient$okhttp", "addUnsafeNonAscii", "build", "get", "removeAll", "set", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Builder {

        @NotNull
        private final List<String> namesAndValues = new ArrayList(20);

        @NotNull
        public final Builder add(@NotNull String line) {
            int indexOf$default;
            CharSequence trim;
            Intrinsics.checkNotNullParameter(line, "line");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) line, ':', 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                String substring = line.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                if (substring == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                trim = StringsKt__StringsKt.trim((CharSequence) substring);
                String obj = trim.toString();
                String substring2 = line.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                add(obj, substring2);
                return this;
            }
            throw new IllegalArgumentException(("Unexpected header: " + line).toString());
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            int size = headers.size();
            for (int i3 = 0; i3 < size; i3++) {
                addLenient$okhttp(headers.name(i3), headers.value(i3));
            }
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String line) {
            int indexOf$default;
            Intrinsics.checkNotNullParameter(line, "line");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) line, ':', 1, false, 4, (Object) null);
            if (indexOf$default != -1) {
                String substring = line.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                String substring2 = line.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else if (line.charAt(0) == ':') {
                String substring3 = line.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", substring3);
            } else {
                addLenient$okhttp("", line);
            }
            return this;
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Headers.INSTANCE.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* JADX WARN: Incorrect condition in loop: B:8:0x0037 */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String get(@NotNull String name) {
            IntProgression downTo;
            IntProgression step;
            boolean equals;
            Intrinsics.checkNotNullParameter(name, "name");
            downTo = RangesKt___RangesKt.downTo(this.namesAndValues.size() - 2, 0);
            step = RangesKt___RangesKt.step(downTo, 2);
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
            return this.namesAndValues.get(first + 1);
        }

        @NotNull
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder removeAll(@NotNull String name) {
            boolean equals;
            Intrinsics.checkNotNullParameter(name, "name");
            int i3 = 0;
            while (i3 < this.namesAndValues.size()) {
                equals = StringsKt__StringsJVMKt.equals(name, this.namesAndValues.get(i3), true);
                if (equals) {
                    this.namesAndValues.remove(i3);
                    this.namesAndValues.remove(i3);
                    i3 -= 2;
                }
                i3 += 2;
            }
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull Date value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            set(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder set(@NotNull String name, @NotNull Instant value) {
            long epochMilli;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            epochMilli = value.toEpochMilli();
            return set(name, new Date(epochMilli));
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion companion = Headers.INSTANCE;
            companion.checkName(name);
            companion.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion companion = Headers.INSTANCE;
            companion.checkName(name);
            companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String name, @NotNull String value) {
            CharSequence trim;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.namesAndValues.add(name);
            List<String> list = this.namesAndValues;
            trim = StringsKt__StringsKt.trim((CharSequence) value);
            list.add(trim.toString());
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull Date value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            add(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder add(@NotNull String name, @NotNull Instant value) {
            long epochMilli;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            epochMilli = value.toEpochMilli();
            add(name, new Date(epochMilli));
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J%\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007\u00a2\u0006\u0002\b\u0011J\u001d\u0010\u0014\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007\u00a2\u0006\u0002\b\u000f\u00a8\u0006\u0015"}, d2 = {"Lokhttp3/Headers$Companion;", "", "()V", "checkName", "", "name", "", "checkValue", "value", "get", "namesAndValues", "", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "headersOf", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "-deprecated_of", "headers", "", "toHeaders", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String name) {
            boolean z16;
            boolean z17;
            if (name.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                int length = name.length();
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt = name.charAt(i3);
                    if ('!' <= charAt && '~' >= charAt) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i3), name).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String value, String name) {
            boolean z16;
            String str;
            int length = value.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = value.charAt(i3);
                if (charAt != '\t' && (' ' > charAt || '~' < charAt)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(charAt), Integer.valueOf(i3), name));
                    if (Util.isSensitiveHeader(name)) {
                        str = "";
                    } else {
                        str = MsgSummary.STR_COLON + value;
                    }
                    sb5.append(str);
                    throw new IllegalArgumentException(sb5.toString().toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Incorrect condition in loop: B:8:0x0026 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String get(String[] namesAndValues, String name) {
            IntProgression downTo;
            IntProgression step;
            boolean equals;
            downTo = RangesKt___RangesKt.downTo(namesAndValues.length - 2, 0);
            step = RangesKt___RangesKt.step(downTo, 2);
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
            return namesAndValues[first + 1];
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function name changed", replaceWith = @ReplaceWith(expression = "headersOf(*namesAndValues)", imports = {}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m2110deprecated_of(@NotNull String... namesAndValues) {
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final Headers of(@NotNull String... namesAndValues) {
            IntRange indices;
            IntProgression step;
            CharSequence trim;
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 == 0) {
                Object clone = namesAndValues.clone();
                if (clone != null) {
                    String[] strArr = (String[]) clone;
                    int length = strArr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        String str = strArr[i3];
                        if (!(str != null)) {
                            throw new IllegalArgumentException("Headers cannot be null".toString());
                        }
                        if (str == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        trim = StringsKt__StringsKt.trim((CharSequence) str);
                        strArr[i3] = trim.toString();
                    }
                    indices = ArraysKt___ArraysKt.getIndices(strArr);
                    step = RangesKt___RangesKt.step(indices, 2);
                    int first = step.getFirst();
                    int last = step.getLast();
                    int step2 = step.getStep();
                    if (step2 < 0 ? first >= last : first <= last) {
                        while (true) {
                            String str2 = strArr[first];
                            String str3 = strArr[first + 1];
                            checkName(str2);
                            checkValue(str3, str2);
                            if (first == last) {
                                break;
                            }
                            first += step2;
                        }
                    }
                    return new Headers(strArr, null);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function moved to extension", replaceWith = @ReplaceWith(expression = "headers.toHeaders()", imports = {}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m2109deprecated_of(@NotNull Map<String, String> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            return of(headers);
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final Headers of(@NotNull Map<String, String> toHeaders) {
            CharSequence trim;
            CharSequence trim2;
            Intrinsics.checkNotNullParameter(toHeaders, "$this$toHeaders");
            String[] strArr = new String[toHeaders.size() * 2];
            int i3 = 0;
            for (Map.Entry<String, String> entry : toHeaders.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null) {
                    trim = StringsKt__StringsKt.trim((CharSequence) key);
                    String obj = trim.toString();
                    if (value != null) {
                        trim2 = StringsKt__StringsKt.trim((CharSequence) value);
                        String obj2 = trim2.toString();
                        checkName(obj);
                        checkValue(obj2, obj);
                        strArr[i3] = obj;
                        strArr[i3 + 1] = obj2;
                        i3 += 2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return new Headers(strArr, null);
        }
    }

    Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final Headers of(@NotNull Map<String, String> map) {
        return INSTANCE.of(map);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m2108deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            length += this.namesAndValues[i3].length();
        }
        return length;
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) other).namesAndValues)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String get(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return INSTANCE.get(this.namesAndValues, name);
    }

    @Nullable
    public final Date getDate(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = get(name);
        if (str != null) {
            return DatesKt.toHttpDateOrNull(str);
        }
        return null;
    }

    @IgnoreJRERequirement
    @Nullable
    public final Instant getInstant(@NotNull String name) {
        Instant instant;
        Intrinsics.checkNotNullParameter(name, "name");
        Date date = getDate(name);
        if (date != null) {
            instant = date.toInstant();
            return instant;
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i3 = 0; i3 < size; i3++) {
            pairArr[i3] = TuplesKt.to(name(i3), value(i3));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    @NotNull
    public final String name(int index) {
        return this.namesAndValues[index * 2];
    }

    @NotNull
    public final Set<String> names() {
        Comparator case_insensitive_order;
        case_insensitive_order = StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE);
        TreeSet treeSet = new TreeSet(case_insensitive_order);
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            treeSet.add(name(i3));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    @JvmName(name = "size")
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @NotNull
    public final Map<String, List<String>> toMultimap() {
        Comparator case_insensitive_order;
        case_insensitive_order = StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE);
        TreeMap treeMap = new TreeMap(case_insensitive_order);
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            String name = name(i3);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            if (name != null) {
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                List list = (List) treeMap.get(lowerCase);
                if (list == null) {
                    list = new ArrayList(2);
                    treeMap.put(lowerCase, list);
                }
                list.add(value(i3));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return treeMap;
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            String name = name(i3);
            String value = value(i3);
            sb5.append(name);
            sb5.append(MsgSummary.STR_COLON);
            if (Util.isSensitiveHeader(name)) {
                value = "\u2588\u2588";
            }
            sb5.append(value);
            sb5.append("\n");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    @NotNull
    public final String value(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    @NotNull
    public final List<String> values(@NotNull String name) {
        List<String> emptyList;
        boolean equals;
        Intrinsics.checkNotNullParameter(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            equals = StringsKt__StringsJVMKt.equals(name, name(i3), true);
            if (equals) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i3));
            }
        }
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public /* synthetic */ Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final Headers of(@NotNull String... strArr) {
        return INSTANCE.of(strArr);
    }
}
