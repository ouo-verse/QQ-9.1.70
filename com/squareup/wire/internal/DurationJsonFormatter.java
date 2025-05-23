package com.squareup.wire.internal;

import java.time.Duration;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/squareup/wire/internal/DurationJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "()V", "fromString", "value", "", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class DurationJsonFormatter implements JsonFormatter<Duration> {
    public static final DurationJsonFormatter INSTANCE = new DurationJsonFormatter();

    DurationJsonFormatter() {
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    @NotNull
    public Duration fromString(@NotNull String value) {
        int indexOf$default;
        int indexOf$default2;
        boolean startsWith$default;
        int i3;
        Duration ofSeconds;
        Duration ofSeconds2;
        Intrinsics.checkNotNullParameter(value, "value");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) value, 's', 0, false, 6, (Object) null);
        if (indexOf$default == value.length() - 1) {
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) value, '.', 0, false, 6, (Object) null);
            if (indexOf$default2 == -1) {
                String substring = value.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                ofSeconds2 = Duration.ofSeconds(Long.parseLong(substring));
                Intrinsics.checkNotNullExpressionValue(ofSeconds2, "Duration.ofSeconds(seconds)");
                return ofSeconds2;
            }
            String substring2 = value.substring(0, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            long parseLong = Long.parseLong(substring2);
            int i16 = indexOf$default2 + 1;
            String substring3 = value.substring(i16, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            long parseLong2 = Long.parseLong(substring3);
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(value, "-", false, 2, null);
            if (startsWith$default) {
                parseLong2 = -parseLong2;
            }
            int i17 = indexOf$default - i16;
            int i18 = i17;
            while (true) {
                if (i18 >= 9) {
                    break;
                }
                parseLong2 *= 10;
                i18++;
            }
            for (i3 = 9; i3 < i17; i3++) {
                parseLong2 /= 10;
            }
            ofSeconds = Duration.ofSeconds(parseLong, parseLong2);
            Intrinsics.checkNotNullExpressionValue(ofSeconds, "Duration.ofSeconds(seconds, nanos)");
            return ofSeconds;
        }
        throw new NumberFormatException();
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    @NotNull
    public String toStringOrNumber(@NotNull Duration value) {
        long seconds;
        int nano;
        String str;
        Intrinsics.checkNotNullParameter(value, "value");
        seconds = value.getSeconds();
        nano = value.getNano();
        if (seconds < 0) {
            if (seconds == Long.MIN_VALUE) {
                str = "-922337203685477580";
                seconds = 8;
            } else {
                seconds = -seconds;
                str = "-";
            }
            if (nano != 0) {
                seconds--;
                nano = 1000000000 - nano;
            }
        } else {
            str = "";
        }
        if (nano == 0) {
            String format = String.format("%s%ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
            return format;
        }
        if (nano % 1000000 == 0) {
            String format2 = String.format("%s%d.%03ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds), Long.valueOf(nano / 1000000)}, 3));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(this, *args)");
            return format2;
        }
        if (nano % 1000 == 0) {
            String format3 = String.format("%s%d.%06ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds), Long.valueOf(nano / 1000)}, 3));
            Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(this, *args)");
            return format3;
        }
        String format4 = String.format("%s%d.%09ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds), Long.valueOf(nano / 1)}, 3));
        Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(this, *args)");
        return format4;
    }
}
