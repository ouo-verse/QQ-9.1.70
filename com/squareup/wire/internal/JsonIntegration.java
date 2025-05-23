package com.squareup.wire.internal;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\b'()*+,-.B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00028\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH&\u00a2\u0006\u0002\u0010\rJE\u0010\u000e\u001a\u00028\u0001\"\b\b\u0002\u0010\u000f*\u00020\u0003\"\b\b\u0003\u0010\u0010*\u00020\u00032\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00100\u0014H\u0002\u00a2\u0006\u0002\u0010\u0015JA\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017\"\b\b\u0002\u0010\u000f*\u00020\u0003\"\b\b\u0003\u0010\u0010*\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00100\u00192\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002J\u0015\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010 J)\u0010!\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010#\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010$J\u0018\u0010%\u001a\u0006\u0012\u0002\b\u00030\u00072\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002J\u0015\u0010&\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010 \u00a8\u0006/"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration;", UserInfo.SEX_FEMALE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "()V", "formatterAdapter", "jsonStringAdapter", "Lcom/squareup/wire/internal/JsonFormatter;", "(Lcom/squareup/wire/internal/JsonFormatter;)Ljava/lang/Object;", "frameworkAdapter", "framework", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "jsonAdapter", "M", "B", "syntax", "Lcom/squareup/wire/Syntax;", "field", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "(Ljava/lang/Object;Lcom/squareup/wire/Syntax;Lcom/squareup/wire/internal/FieldOrOneOfBinding;)Ljava/lang/Object;", "jsonAdapters", "", "adapter", "Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "(Lcom/squareup/wire/internal/RuntimeMessageAdapter;Ljava/lang/Object;)Ljava/util/List;", "jsonFormatter", "protoAdapter", "Lcom/squareup/wire/ProtoAdapter;", "listAdapter", "elementAdapter", "(Ljava/lang/Object;)Ljava/lang/Object;", "mapAdapter", "keyFormatter", "valueAdapter", "(Ljava/lang/Object;Lcom/squareup/wire/internal/JsonFormatter;Ljava/lang/Object;)Ljava/lang/Object;", "mapKeyJsonFormatter", "structAdapter", "ByteStringJsonFormatter", "IntAsStringJsonFormatter", "LongAsStringJsonFormatter", "StringJsonFormatter", "UnsignedIntAsNumberJsonFormatter", "UnsignedIntAsStringJsonFormatter", "UnsignedLongAsNumberJsonFormatter", "UnsignedLongAsStringJsonFormatter", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class JsonIntegration<F, A> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$ByteStringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "Lokio/ByteString;", "()V", "fromString", "value", "", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class ByteStringJsonFormatter implements JsonFormatter<ByteString> {
        public static final ByteStringJsonFormatter INSTANCE = new ByteStringJsonFormatter();

        ByteStringJsonFormatter() {
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        @Nullable
        public ByteString fromString(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return ByteString.INSTANCE.decodeBase64(value);
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        @NotNull
        public String toStringOrNumber(@NotNull ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value.base64();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$IntAsStringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class IntAsStringJsonFormatter implements JsonFormatter<Integer> {
        public static final IntAsStringJsonFormatter INSTANCE = new IntAsStringJsonFormatter();

        IntAsStringJsonFormatter() {
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* bridge */ /* synthetic */ Object toStringOrNumber(Integer num) {
            return toStringOrNumber(num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        @NotNull
        public Integer fromString(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Integer.valueOf(Integer.parseInt(value));
        }

        @NotNull
        public String toStringOrNumber(int value) {
            return String.valueOf(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$LongAsStringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Long;", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class LongAsStringJsonFormatter implements JsonFormatter<Long> {
        public static final LongAsStringJsonFormatter INSTANCE = new LongAsStringJsonFormatter();

        LongAsStringJsonFormatter() {
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* bridge */ /* synthetic */ Object toStringOrNumber(Long l3) {
            return toStringOrNumber(l3.longValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        @NotNull
        public Long fromString(@NotNull String value) {
            long longValueExact;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                longValueExact = Long.parseLong(value);
            } catch (Exception unused) {
                longValueExact = new BigDecimal(value).longValueExact();
            }
            return Long.valueOf(longValueExact);
        }

        @NotNull
        public String toStringOrNumber(long value) {
            return String.valueOf(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$StringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "fromString", "value", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class StringJsonFormatter implements JsonFormatter<String> {
        public static final StringJsonFormatter INSTANCE = new StringJsonFormatter();

        StringJsonFormatter() {
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        @NotNull
        public String fromString(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        @NotNull
        public String toStringOrNumber(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$UnsignedIntAsNumberJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "maxInt", "", "power32", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "toStringOrNumber", "", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class UnsignedIntAsNumberJsonFormatter implements JsonFormatter<Integer> {
        public static final UnsignedIntAsNumberJsonFormatter INSTANCE = new UnsignedIntAsNumberJsonFormatter();
        private static final long maxInt = 2147483647L;
        private static final long power32 = 4294967296L;

        UnsignedIntAsNumberJsonFormatter() {
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* bridge */ /* synthetic */ Object toStringOrNumber(Integer num) {
            return toStringOrNumber(num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        @NotNull
        public Integer fromString(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long parseDouble = (long) Double.parseDouble(value);
            if (parseDouble >= 2147483647L) {
                parseDouble -= 4294967296L;
            }
            return Integer.valueOf((int) parseDouble);
        }

        @NotNull
        public Object toStringOrNumber(int value) {
            if (value < 0) {
                return Long.valueOf(value + 4294967296L);
            }
            return Integer.valueOf(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$UnsignedIntAsStringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "power32", "", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "toStringOrNumber", "", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class UnsignedIntAsStringJsonFormatter implements JsonFormatter<Integer> {
        public static final UnsignedIntAsStringJsonFormatter INSTANCE = new UnsignedIntAsStringJsonFormatter();
        private static final long power32 = 4294967296L;

        UnsignedIntAsStringJsonFormatter() {
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* bridge */ /* synthetic */ Object toStringOrNumber(Integer num) {
            return toStringOrNumber(num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        @NotNull
        public Integer fromString(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Integer.valueOf((int) Long.parseLong(value));
        }

        @NotNull
        public Object toStringOrNumber(int value) {
            if (value < 0) {
                return String.valueOf(value + 4294967296L);
            }
            return String.valueOf(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$UnsignedLongAsNumberJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "maxLong", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "power64", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Long;", "toStringOrNumber", "", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class UnsignedLongAsNumberJsonFormatter implements JsonFormatter<Long> {
        public static final UnsignedLongAsNumberJsonFormatter INSTANCE = new UnsignedLongAsNumberJsonFormatter();
        private static final BigInteger power64 = new BigInteger("18446744073709551616");
        private static final BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);

        UnsignedLongAsNumberJsonFormatter() {
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* bridge */ /* synthetic */ Object toStringOrNumber(Long l3) {
            return toStringOrNumber(l3.longValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        @NotNull
        public Long fromString(@NotNull String value) {
            BigInteger bigInteger;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                bigInteger = new BigInteger(value);
            } catch (Exception unused) {
                bigInteger = new BigDecimal(value).toBigInteger();
            }
            return Long.valueOf(bigInteger.compareTo(maxLong) > 0 ? bigInteger.subtract(power64).longValue() : bigInteger.longValue());
        }

        @NotNull
        public Object toStringOrNumber(long value) {
            Object valueOf;
            if (value < 0) {
                valueOf = power64.add(BigInteger.valueOf(value));
            } else {
                valueOf = Long.valueOf(value);
            }
            Intrinsics.checkNotNullExpressionValue(valueOf, "when {\n        value < 0\u2026    else -> value\n      }");
            return valueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$UnsignedLongAsStringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Long;", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class UnsignedLongAsStringJsonFormatter implements JsonFormatter<Long> {
        public static final UnsignedLongAsStringJsonFormatter INSTANCE = new UnsignedLongAsStringJsonFormatter();

        UnsignedLongAsStringJsonFormatter() {
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* bridge */ /* synthetic */ Object toStringOrNumber(Long l3) {
            return toStringOrNumber(l3.longValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        @NotNull
        public Long fromString(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return UnsignedLongAsNumberJsonFormatter.INSTANCE.fromString(value);
        }

        @NotNull
        public String toStringOrNumber(long value) {
            return UnsignedLongAsNumberJsonFormatter.INSTANCE.toStringOrNumber(value).toString();
        }
    }

    private final <M, B> A jsonAdapter(F framework, Syntax syntax, FieldOrOneOfBinding<M, B> field) {
        Class cls;
        A frameworkAdapter;
        if (field.getSingleAdapter().isStruct$wire_runtime()) {
            return structAdapter(framework);
        }
        JsonFormatter<?> jsonFormatter = jsonFormatter(syntax, field.getSingleAdapter());
        if (jsonFormatter != null) {
            frameworkAdapter = formatterAdapter(jsonFormatter);
        } else {
            KClass<?> type = field.getSingleAdapter().getType();
            if (type != null) {
                cls = JvmClassMappingKt.getJavaObjectType(type);
            } else {
                cls = null;
            }
            if (cls != null) {
                frameworkAdapter = frameworkAdapter(framework, cls);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Type");
            }
        }
        if (field.getLabel().isRepeated()) {
            return listAdapter(frameworkAdapter);
        }
        return field.isMap() ? mapAdapter(framework, mapKeyJsonFormatter(field.getKeyAdapter()), frameworkAdapter) : frameworkAdapter;
    }

    private final JsonFormatter<?> jsonFormatter(Syntax syntax, ProtoAdapter<?> protoAdapter) {
        if (Intrinsics.areEqual(protoAdapter, ProtoAdapter.BYTES) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.BYTES_VALUE)) {
            return ByteStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual(protoAdapter, ProtoAdapter.DURATION)) {
            return DurationJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual(protoAdapter, ProtoAdapter.INSTANT)) {
            return InstantJsonFormatter.INSTANCE;
        }
        if (protoAdapter instanceof EnumAdapter) {
            return new EnumJsonFormatter((EnumAdapter) protoAdapter);
        }
        if (syntax == Syntax.PROTO_2) {
            if (!Intrinsics.areEqual(protoAdapter, ProtoAdapter.UINT64) && !Intrinsics.areEqual(protoAdapter, ProtoAdapter.UINT64_VALUE)) {
                return null;
            }
            return UnsignedLongAsNumberJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual(protoAdapter, ProtoAdapter.UINT32) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.FIXED32) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.UINT32_VALUE)) {
            return UnsignedIntAsNumberJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual(protoAdapter, ProtoAdapter.INT64) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.SFIXED64) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.SINT64) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.INT64_VALUE)) {
            return LongAsStringJsonFormatter.INSTANCE;
        }
        if (!Intrinsics.areEqual(protoAdapter, ProtoAdapter.FIXED64) && !Intrinsics.areEqual(protoAdapter, ProtoAdapter.UINT64) && !Intrinsics.areEqual(protoAdapter, ProtoAdapter.UINT64_VALUE)) {
            return null;
        }
        return UnsignedLongAsStringJsonFormatter.INSTANCE;
    }

    private final JsonFormatter<?> mapKeyJsonFormatter(ProtoAdapter<?> protoAdapter) {
        if (Intrinsics.areEqual(protoAdapter, ProtoAdapter.STRING)) {
            return StringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual(protoAdapter, ProtoAdapter.INT32) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.SINT32) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.SFIXED32)) {
            return IntAsStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual(protoAdapter, ProtoAdapter.FIXED32) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.UINT32)) {
            return UnsignedIntAsStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual(protoAdapter, ProtoAdapter.INT64) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.SFIXED64) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.SINT64)) {
            return LongAsStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual(protoAdapter, ProtoAdapter.FIXED64) || Intrinsics.areEqual(protoAdapter, ProtoAdapter.UINT64)) {
            return UnsignedLongAsStringJsonFormatter.INSTANCE;
        }
        throw new IllegalStateException(("Unexpected map key type: " + protoAdapter.getType()).toString());
    }

    public abstract A formatterAdapter(@NotNull JsonFormatter<?> jsonStringAdapter);

    public abstract A frameworkAdapter(F framework, @NotNull Type type);

    @NotNull
    public final <M, B> List<A> jsonAdapters(@NotNull RuntimeMessageAdapter<M, B> adapter, F framework) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Object[] array = adapter.getFields().values().toArray(new FieldOrOneOfBinding[0]);
        if (array != null) {
            FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr = (FieldOrOneOfBinding[]) array;
            ArrayList arrayList = new ArrayList(fieldOrOneOfBindingArr.length);
            for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : fieldOrOneOfBindingArr) {
                arrayList.add(jsonAdapter(framework, adapter.getSyntax(), fieldOrOneOfBinding));
            }
            return arrayList;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public abstract A listAdapter(A elementAdapter);

    public abstract A mapAdapter(F framework, @NotNull JsonFormatter<?> keyFormatter, A valueAdapter);

    public abstract A structAdapter(F framework);
}
