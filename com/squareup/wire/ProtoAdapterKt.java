package com.squareup.wire;

import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0000\u001a\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0000\u001a\u0012\u0010\u000b\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u0005H\u0000\u001a\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0000\u001a\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005H\u0000\u001a\u0012\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u0005H\u0000\u001a\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001aC\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0\u001b0\u0005\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0005H\u0080\b\u001a\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0005H\u0000\u001a\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010'0\u0005H\u0000\u001a\u001a\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0002\b\u0003\u0018\u00010\u001b0\u0005H\u0000\u001a\u0010\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u0005H\u0000\u001a\u0010\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u0005H\u0000\u001a\u001c\u0010-\u001a\u00020%\"\u0004\b\u0000\u0010.2\u0006\u0010/\u001a\u0002H.H\u0080\b\u00a2\u0006\u0002\u00100\u001a\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a0\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H40\u0005\"\b\b\u0000\u00104*\u00020,2\f\u00105\u001a\b\u0012\u0004\u0012\u0002H40\u00052\u0006\u00106\u001a\u00020%H\u0000\u001a%\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H.0'0\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u0005H\u0080\b\u001a%\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H.0'0\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u0005H\u0080\b\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010:\u001a\u00020;H\u0080\b\u00a2\u0006\u0002\u0010<\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010=\u001a\u00020>H\u0080\b\u00a2\u0006\u0002\u0010?\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010:\u001a\u00020\bH\u0080\b\u00a2\u0006\u0002\u0010@\u001a&\u0010A\u001a\u00020;\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010/\u001a\u0002H.H\u0080\b\u00a2\u0006\u0002\u0010B\u001a.\u0010A\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010C\u001a\u00020D2\u0006\u0010/\u001a\u0002H.H\u0080\b\u00a2\u0006\u0002\u0010E\u001a&\u0010F\u001a\u00020\b\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010/\u001a\u0002H.H\u0080\b\u00a2\u0006\u0002\u0010G\u001a8\u0010H\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\b\u0010/\u001a\u0004\u0018\u0001H.H\u0080\b\u00a2\u0006\u0002\u0010L\u001a0\u0010M\u001a\u00020\u0001\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010K\u001a\u00020\u00012\b\u0010/\u001a\u0004\u0018\u0001H.H\u0080\b\u00a2\u0006\u0002\u0010N\u001a%\u0010O\u001a\u0006\u0012\u0002\b\u00030\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010P\u001a\u00020QH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006R"}, d2 = {"FIXED_32_SIZE", "", "FIXED_64_SIZE", "FIXED_BOOL_SIZE", "commonBool", "Lcom/squareup/wire/ProtoAdapter;", "", "commonBytes", "Lokio/ByteString;", "commonDouble", "", "commonDuration", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "commonEmpty", "", "commonFixed32", "commonFixed64", "", "commonFloat", "", "commonInstant", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "commonInt32", "commonInt64", "commonNewMapAdapter", "", "K", "V", "keyAdapter", "valueAdapter", "commonSfixed32", "commonSfixed64", "commonSint32", "commonSint64", "commonString", "", "commonStructList", "", "commonStructMap", "commonStructNull", "", "commonStructValue", "", "commonToString", "E", "value", "(Ljava/lang/Object;)Ljava/lang/String;", "commonUint32", "commonUint64", "commonWrapper", "T", "delegate", "typeUrl", "commonCreatePacked", "commonCreateRepeated", "commonDecode", "bytes", "", "(Lcom/squareup/wire/ProtoAdapter;[B)Ljava/lang/Object;", "source", "Lokio/BufferedSource;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/BufferedSource;)Ljava/lang/Object;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)Ljava/lang/Object;", "commonEncode", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)[B", "sink", "Lokio/BufferedSink;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/BufferedSink;Ljava/lang/Object;)V", "commonEncodeByteString", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)Lokio/ByteString;", "commonEncodeWithTag", "writer", "Lcom/squareup/wire/ProtoWriter;", "tag", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoWriter;ILjava/lang/Object;)V", "commonEncodedSizeWithTag", "(Lcom/squareup/wire/ProtoAdapter;ILjava/lang/Object;)I", "commonWithLabel", "label", "Lcom/squareup/wire/WireField$Label;", "wire-runtime"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class ProtoAdapterKt {
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;

    @NotNull
    public static final ProtoAdapter<Boolean> commonBool() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final Boolean bool = Boolean.FALSE;
        return new ProtoAdapter<Boolean>(fieldEncoding, orCreateKotlinClass, str, syntax, bool) { // from class: com.squareup.wire.ProtoAdapterKt$commonBool$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Boolean bool2) {
                encode(protoWriter, bool2.booleanValue());
            }

            public int encodedSize(boolean value) {
                return 1;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Boolean redact(Boolean bool2) {
                return redact(bool2.booleanValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Boolean decode(@NotNull ProtoReader reader) throws IOException {
                boolean z16;
                int checkRadix;
                String padStart;
                Intrinsics.checkNotNullParameter(reader, "reader");
                int readVarint32 = reader.readVarint32();
                if (readVarint32 != 0) {
                    z16 = true;
                    if (readVarint32 != 1) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Invalid boolean value 0x");
                        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                        String num = Integer.toString(readVarint32, checkRadix);
                        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
                        padStart = StringsKt__StringsKt.padStart(num, 2, '0');
                        sb5.append(padStart);
                        throw new IOException(sb5.toString());
                    }
                } else {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            }

            public void encode(@NotNull ProtoWriter writer, boolean value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(value ? 1 : 0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Boolean bool2) {
                return encodedSize(bool2.booleanValue());
            }

            @NotNull
            public Boolean redact(boolean value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<ByteString> commonBytes() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ByteString.class);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final ByteString byteString = ByteString.EMPTY;
        return new ProtoAdapter<ByteString>(fieldEncoding, orCreateKotlinClass, str, syntax, byteString) { // from class: com.squareup.wire.ProtoAdapterKt$commonBytes$1
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ByteString decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return reader.readBytes();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull ByteString value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                writer.writeBytes(value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull ByteString value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value.size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ByteString redact(@NotNull ByteString value) {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final <E> ProtoAdapter<List<E>> commonCreatePacked(@NotNull ProtoAdapter<E> commonCreatePacked) {
        boolean z16;
        Intrinsics.checkNotNullParameter(commonCreatePacked, "$this$commonCreatePacked");
        if (commonCreatePacked.getFieldEncoding() != FieldEncoding.LENGTH_DELIMITED) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new PackedProtoAdapter(commonCreatePacked);
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    }

    @NotNull
    public static final <E> ProtoAdapter<List<E>> commonCreateRepeated(@NotNull ProtoAdapter<E> commonCreateRepeated) {
        Intrinsics.checkNotNullParameter(commonCreateRepeated, "$this$commonCreateRepeated");
        return new RepeatedProtoAdapter(commonCreateRepeated);
    }

    public static final <E> E commonDecode(@NotNull ProtoAdapter<E> commonDecode, @NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(commonDecode, "$this$commonDecode");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return commonDecode.decode(new Buffer().write(bytes));
    }

    @NotNull
    public static final ProtoAdapter<Double> commonDouble() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED64;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Double.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final Double valueOf = Double.valueOf(0.0d);
        return new ProtoAdapter<Double>(fieldEncoding, orCreateKotlinClass, str, syntax, valueOf) { // from class: com.squareup.wire.ProtoAdapterKt$commonDouble$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Double d16) {
                encode(protoWriter, d16.doubleValue());
            }

            public int encodedSize(double value) {
                return 8;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Double redact(Double d16) {
                return redact(d16.doubleValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Double decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
                return Double.valueOf(Double.longBitsToDouble(reader.readFixed64()));
            }

            public void encode(@NotNull ProtoWriter writer, double value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed64(Double.doubleToLongBits(value));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Double d16) {
                return encodedSize(d16.doubleValue());
            }

            @NotNull
            public Double redact(double value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Duration> commonDuration() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Duration.class);
        final String str = "type.googleapis.com/google.protobuf.Duration";
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Duration>(fieldEncoding, orCreateKotlinClass, str, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonDuration$1
            private final int getSameSignNanos(Duration duration) {
                long seconds;
                int nano;
                int nano2;
                int nano3;
                seconds = duration.getSeconds();
                if (seconds < 0) {
                    nano2 = duration.getNano();
                    if (nano2 != 0) {
                        nano3 = duration.getNano();
                        return nano3 - 1000000000;
                    }
                }
                nano = duration.getNano();
                return nano;
            }

            private final long getSameSignSeconds(Duration duration) {
                long seconds;
                long seconds2;
                int nano;
                long seconds3;
                seconds = duration.getSeconds();
                if (seconds < 0) {
                    nano = duration.getNano();
                    if (nano != 0) {
                        seconds3 = duration.getSeconds();
                        return seconds3 + 1;
                    }
                }
                seconds2 = duration.getSeconds();
                return seconds2;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Duration redact(@NotNull Duration value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Duration decode(@NotNull ProtoReader reader) {
                Duration ofSeconds;
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                long j3 = 0;
                int i3 = 0;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        ofSeconds = Duration.ofSeconds(j3, i3);
                        Intrinsics.checkNotNullExpressionValue(ofSeconds, "Duration.ofSeconds(seconds, nano)");
                        return ofSeconds;
                    }
                    if (nextTag == 1) {
                        j3 = ProtoAdapter.INT64.decode(reader).longValue();
                    } else if (nextTag != 2) {
                        reader.readUnknownField(nextTag);
                    } else {
                        i3 = ProtoAdapter.INT32.decode(reader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Duration value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                long sameSignSeconds = getSameSignSeconds(value);
                if (sameSignSeconds != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, Long.valueOf(sameSignSeconds));
                }
                int sameSignNanos = getSameSignNanos(value);
                if (sameSignNanos != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(sameSignNanos));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Duration value) {
                Intrinsics.checkNotNullParameter(value, "value");
                long sameSignSeconds = getSameSignSeconds(value);
                int encodedSizeWithTag = sameSignSeconds != 0 ? 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(sameSignSeconds)) : 0;
                int sameSignNanos = getSameSignNanos(value);
                return sameSignNanos != 0 ? encodedSizeWithTag + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(sameSignNanos)) : encodedSizeWithTag;
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Unit> commonEmpty() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        final String str = "type.googleapis.com/google.protobuf.Empty";
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Unit>(fieldEncoding, orCreateKotlinClass, str, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonEmpty$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Unit decode(ProtoReader protoReader) {
                decode2(protoReader);
                return Unit.INSTANCE;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Unit value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Unit value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return 0;
            }

            /* renamed from: redact, reason: avoid collision after fix types in other method */
            public void redact2(@NotNull Unit value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            /* renamed from: decode, reason: avoid collision after fix types in other method */
            public void decode2(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return;
                    }
                    reader.readUnknownField(nextTag);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Unit redact(Unit unit) {
                redact2(unit);
                return Unit.INSTANCE;
            }
        };
    }

    public static final <E> void commonEncode(@NotNull ProtoAdapter<E> commonEncode, @NotNull BufferedSink sink, E e16) {
        Intrinsics.checkNotNullParameter(commonEncode, "$this$commonEncode");
        Intrinsics.checkNotNullParameter(sink, "sink");
        commonEncode.encode(new ProtoWriter(sink), (ProtoWriter) e16);
    }

    @NotNull
    public static final <E> ByteString commonEncodeByteString(@NotNull ProtoAdapter<E> commonEncodeByteString, E e16) {
        Intrinsics.checkNotNullParameter(commonEncodeByteString, "$this$commonEncodeByteString");
        Buffer buffer = new Buffer();
        commonEncodeByteString.encode((BufferedSink) buffer, (Buffer) e16);
        return buffer.readByteString();
    }

    public static final <E> void commonEncodeWithTag(@NotNull ProtoAdapter<E> commonEncodeWithTag, @NotNull ProtoWriter writer, int i3, @Nullable E e16) {
        Intrinsics.checkNotNullParameter(commonEncodeWithTag, "$this$commonEncodeWithTag");
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (e16 == null) {
            return;
        }
        writer.writeTag(i3, commonEncodeWithTag.getFieldEncoding());
        if (commonEncodeWithTag.getFieldEncoding() == FieldEncoding.LENGTH_DELIMITED) {
            writer.writeVarint32(commonEncodeWithTag.encodedSize(e16));
        }
        commonEncodeWithTag.encode(writer, (ProtoWriter) e16);
    }

    public static final <E> int commonEncodedSizeWithTag(@NotNull ProtoAdapter<E> commonEncodedSizeWithTag, int i3, @Nullable E e16) {
        Intrinsics.checkNotNullParameter(commonEncodedSizeWithTag, "$this$commonEncodedSizeWithTag");
        if (e16 == null) {
            return 0;
        }
        int encodedSize = commonEncodedSizeWithTag.encodedSize(e16);
        if (commonEncodedSizeWithTag.getFieldEncoding() == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += ProtoWriter.INSTANCE.varint32Size$wire_runtime(encodedSize);
        }
        return encodedSize + ProtoWriter.INSTANCE.tagSize$wire_runtime(i3);
    }

    @NotNull
    public static final ProtoAdapter<Integer> commonFixed32() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED32;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final int i3 = 0;
        return new ProtoAdapter<Integer>(fieldEncoding, orCreateKotlinClass, str, syntax, i3) { // from class: com.squareup.wire.ProtoAdapterKt$commonFixed32$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            public int encodedSize(int value) {
                return 4;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Integer decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(reader.readFixed32());
            }

            public void encode(@NotNull ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed32(value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @NotNull
            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Long> commonFixed64() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED64;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final long j3 = 0L;
        return new ProtoAdapter<Long>(fieldEncoding, orCreateKotlinClass, str, syntax, j3) { // from class: com.squareup.wire.ProtoAdapterKt$commonFixed64$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l3) {
                encode(protoWriter, l3.longValue());
            }

            public int encodedSize(long value) {
                return 8;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l3) {
                return redact(l3.longValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Long decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(reader.readFixed64());
            }

            public void encode(@NotNull ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed64(value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l3) {
                return encodedSize(l3.longValue());
            }

            @NotNull
            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Float> commonFloat() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED32;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Float.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final Float valueOf = Float.valueOf(0.0f);
        return new ProtoAdapter<Float>(fieldEncoding, orCreateKotlinClass, str, syntax, valueOf) { // from class: com.squareup.wire.ProtoAdapterKt$commonFloat$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Float f16) {
                encode(protoWriter, f16.floatValue());
            }

            public int encodedSize(float value) {
                return 4;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Float redact(Float f16) {
                return redact(f16.floatValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Float decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                return Float.valueOf(Float.intBitsToFloat(reader.readFixed32()));
            }

            public void encode(@NotNull ProtoWriter writer, float value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed32(Float.floatToIntBits(value));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Float f16) {
                return encodedSize(f16.floatValue());
            }

            @NotNull
            public Float redact(float value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Instant> commonInstant() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Instant.class);
        final String str = "type.googleapis.com/google.protobuf.Timestamp";
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Instant>(fieldEncoding, orCreateKotlinClass, str, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonInstant$1
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Instant redact(@NotNull Instant value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Instant decode(@NotNull ProtoReader reader) {
                Instant ofEpochSecond;
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                long j3 = 0;
                int i3 = 0;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        ofEpochSecond = Instant.ofEpochSecond(j3, i3);
                        Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "Instant.ofEpochSecond(epochSecond, nano)");
                        return ofEpochSecond;
                    }
                    if (nextTag == 1) {
                        j3 = ProtoAdapter.INT64.decode(reader).longValue();
                    } else if (nextTag != 2) {
                        reader.readUnknownField(nextTag);
                    } else {
                        i3 = ProtoAdapter.INT32.decode(reader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Instant value) {
                long epochSecond;
                int nano;
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                epochSecond = value.getEpochSecond();
                if (epochSecond != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, Long.valueOf(epochSecond));
                }
                nano = value.getNano();
                if (nano != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(nano));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Instant value) {
                long epochSecond;
                int nano;
                Intrinsics.checkNotNullParameter(value, "value");
                epochSecond = value.getEpochSecond();
                int encodedSizeWithTag = epochSecond != 0 ? 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(epochSecond)) : 0;
                nano = value.getNano();
                return nano != 0 ? encodedSizeWithTag + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(nano)) : encodedSizeWithTag;
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Integer> commonInt32() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final int i3 = 0;
        return new ProtoAdapter<Integer>(fieldEncoding, orCreateKotlinClass, str, syntax, i3) { // from class: com.squareup.wire.ProtoAdapterKt$commonInt32$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Integer decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(reader.readVarint32());
            }

            public void encode(@NotNull ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeSignedVarint32$wire_runtime(value);
            }

            public int encodedSize(int value) {
                return ProtoWriter.INSTANCE.int32Size$wire_runtime(value);
            }

            @NotNull
            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Long> commonInt64() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final long j3 = 0L;
        return new ProtoAdapter<Long>(fieldEncoding, orCreateKotlinClass, str, syntax, j3) { // from class: com.squareup.wire.ProtoAdapterKt$commonInt64$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l3) {
                encode(protoWriter, l3.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l3) {
                return encodedSize(l3.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l3) {
                return redact(l3.longValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Long decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(reader.readVarint64());
            }

            public void encode(@NotNull ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(value);
            }

            public int encodedSize(long value) {
                return ProtoWriter.INSTANCE.varint64Size$wire_runtime(value);
            }

            @NotNull
            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final <K, V> ProtoAdapter<Map<K, V>> commonNewMapAdapter(@NotNull ProtoAdapter<K> keyAdapter, @NotNull ProtoAdapter<V> valueAdapter) {
        Intrinsics.checkNotNullParameter(keyAdapter, "keyAdapter");
        Intrinsics.checkNotNullParameter(valueAdapter, "valueAdapter");
        return new MapProtoAdapter(keyAdapter, valueAdapter);
    }

    @NotNull
    public static final ProtoAdapter<Integer> commonSfixed32() {
        return commonFixed32();
    }

    @NotNull
    public static final ProtoAdapter<Long> commonSfixed64() {
        return commonFixed64();
    }

    @NotNull
    public static final ProtoAdapter<Integer> commonSint32() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final int i3 = 0;
        return new ProtoAdapter<Integer>(fieldEncoding, orCreateKotlinClass, str, syntax, i3) { // from class: com.squareup.wire.ProtoAdapterKt$commonSint32$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Integer decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(ProtoWriter.INSTANCE.decodeZigZag32$wire_runtime(reader.readVarint32()));
            }

            public void encode(@NotNull ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(ProtoWriter.INSTANCE.encodeZigZag32$wire_runtime(value));
            }

            public int encodedSize(int value) {
                ProtoWriter.Companion companion = ProtoWriter.INSTANCE;
                return companion.varint32Size$wire_runtime(companion.encodeZigZag32$wire_runtime(value));
            }

            @NotNull
            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Long> commonSint64() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final long j3 = 0L;
        return new ProtoAdapter<Long>(fieldEncoding, orCreateKotlinClass, str, syntax, j3) { // from class: com.squareup.wire.ProtoAdapterKt$commonSint64$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l3) {
                encode(protoWriter, l3.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l3) {
                return encodedSize(l3.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l3) {
                return redact(l3.longValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Long decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(ProtoWriter.INSTANCE.decodeZigZag64$wire_runtime(reader.readVarint64()));
            }

            public void encode(@NotNull ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(ProtoWriter.INSTANCE.encodeZigZag64$wire_runtime(value));
            }

            public int encodedSize(long value) {
                ProtoWriter.Companion companion = ProtoWriter.INSTANCE;
                return companion.varint64Size$wire_runtime(companion.encodeZigZag64$wire_runtime(value));
            }

            @NotNull
            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<String> commonString() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final String str2 = "";
        return new ProtoAdapter<String>(fieldEncoding, orCreateKotlinClass, str, syntax, str2) { // from class: com.squareup.wire.ProtoAdapterKt$commonString$1
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public String decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return reader.readString();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull String value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                writer.writeString(value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (int) Utf8.size$default(value, 0, 0, 3, null);
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public String redact(@NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<List<?>> commonStructList() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Map.class);
        final String str = "type.googleapis.com/google.protobuf.ListValue";
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<List<?>>(fieldEncoding, orCreateKotlinClass, str, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructList$1
            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public List<?> decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return arrayList;
                    }
                    if (nextTag != 1) {
                        reader.skip();
                    } else {
                        arrayList.add(ProtoAdapter.STRUCT_VALUE.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @Nullable List<?> value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    return;
                }
                Iterator<?> it = value.iterator();
                while (it.hasNext()) {
                    ProtoAdapter.STRUCT_VALUE.encodeWithTag(writer, 1, it.next());
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@Nullable List<?> value) {
                int i3 = 0;
                if (value == null) {
                    return 0;
                }
                Iterator<?> it = value.iterator();
                while (it.hasNext()) {
                    i3 += ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(1, it.next());
                }
                return i3;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public List<Object> redact(@Nullable List<?> value) {
                int collectionSizeOrDefault;
                if (value == null) {
                    return null;
                }
                List<?> list = value;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(ProtoAdapter.STRUCT_VALUE.redact(it.next()));
                }
                return arrayList;
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Map<String, ?>> commonStructMap() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Map.class);
        final String str = "type.googleapis.com/google.protobuf.Struct";
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Map<String, ?>>(fieldEncoding, orCreateKotlinClass, str, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructMap$1
            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Map<String, ?> decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                long beginMessage = reader.beginMessage();
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return linkedHashMap;
                    }
                    if (nextTag != 1) {
                        reader.skip();
                    } else {
                        long beginMessage2 = reader.beginMessage();
                        String str2 = null;
                        Object obj = null;
                        while (true) {
                            int nextTag2 = reader.nextTag();
                            if (nextTag2 == -1) {
                                break;
                            }
                            if (nextTag2 == 1) {
                                str2 = ProtoAdapter.STRING.decode(reader);
                            } else if (nextTag2 != 2) {
                                reader.readUnknownField(nextTag2);
                            } else {
                                obj = ProtoAdapter.STRUCT_VALUE.decode(reader);
                            }
                        }
                        reader.endMessageAndGetUnknownFields(beginMessage2);
                        if (str2 != null) {
                            Intrinsics.checkNotNull(str2);
                            linkedHashMap.put(str2, obj);
                        }
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @Nullable Map<String, ?> value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    return;
                }
                for (Map.Entry<String, ?> entry : value.entrySet()) {
                    String key = entry.getKey();
                    Object value2 = entry.getValue();
                    ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
                    int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, key);
                    ProtoAdapter<Object> protoAdapter2 = ProtoAdapter.STRUCT_VALUE;
                    int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(2, value2);
                    writer.writeTag(1, FieldEncoding.LENGTH_DELIMITED);
                    writer.writeVarint32(encodedSizeWithTag2);
                    protoAdapter.encodeWithTag(writer, 1, key);
                    protoAdapter2.encodeWithTag(writer, 2, value2);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@Nullable Map<String, ?> value) {
                int i3 = 0;
                if (value == null) {
                    return 0;
                }
                for (Map.Entry<String, ?> entry : value.entrySet()) {
                    int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, entry.getKey()) + ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(2, entry.getValue());
                    ProtoWriter.Companion companion = ProtoWriter.INSTANCE;
                    i3 += companion.tagSize$wire_runtime(1) + companion.varint32Size$wire_runtime(encodedSizeWithTag) + encodedSizeWithTag;
                }
                return i3;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Map<String, Object> redact(@Nullable Map<String, ?> value) {
                int mapCapacity;
                if (value == null) {
                    return null;
                }
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(value.size());
                LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
                Iterator<T> it = value.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), ProtoAdapter.STRUCT_VALUE.redact(entry));
                }
                return linkedHashMap;
            }
        };
    }

    @NotNull
    public static final ProtoAdapter commonStructNull() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Void.class);
        final String str = "type.googleapis.com/google.protobuf.NullValue";
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter(fieldEncoding, orCreateKotlinClass, str, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructNull$1
            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Void redact(@Nullable Void value) {
                return null;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Void decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                int readVarint32 = reader.readVarint32();
                if (readVarint32 == 0) {
                    return null;
                }
                throw new IOException("expected 0 but was " + readVarint32);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @Nullable Void value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(@NotNull ProtoWriter writer, int tag, @Nullable Void value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeTag(tag, getFieldEncoding());
                encode(writer, value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@Nullable Void value) {
                return ProtoWriter.INSTANCE.varint32Size$wire_runtime(0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int tag, @Nullable Void value) {
                int encodedSize = encodedSize(value);
                ProtoWriter.Companion companion = ProtoWriter.INSTANCE;
                return companion.tagSize$wire_runtime(tag) + companion.varint32Size$wire_runtime(encodedSize);
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Object> commonStructValue() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        final String str = "type.googleapis.com/google.protobuf.Value";
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Object>(fieldEncoding, orCreateKotlinClass, str, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructValue$1
            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Object decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                Object obj = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return obj;
                    }
                    switch (nextTag) {
                        case 1:
                            obj = ProtoAdapter.STRUCT_NULL.decode(reader);
                            break;
                        case 2:
                            obj = ProtoAdapter.DOUBLE.decode(reader);
                            break;
                        case 3:
                            obj = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            obj = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 5:
                            obj = ProtoAdapter.STRUCT_MAP.decode(reader);
                            break;
                        case 6:
                            obj = ProtoAdapter.STRUCT_LIST.decode(reader);
                            break;
                        default:
                            reader.skip();
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @Nullable Object value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    ProtoAdapter.STRUCT_NULL.encodeWithTag(writer, 1, value);
                    return;
                }
                if (value instanceof Number) {
                    ProtoAdapter.DOUBLE.encodeWithTag(writer, 2, Double.valueOf(((Number) value).doubleValue()));
                    return;
                }
                if (value instanceof String) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value);
                    return;
                }
                if (value instanceof Boolean) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 4, value);
                    return;
                }
                if (value instanceof Map) {
                    ProtoAdapter.STRUCT_MAP.encodeWithTag(writer, 5, (Map) value);
                } else {
                    if (value instanceof List) {
                        ProtoAdapter.STRUCT_LIST.encodeWithTag(writer, 6, value);
                        return;
                    }
                    throw new IllegalArgumentException("unexpected struct value: " + value);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(@NotNull ProtoWriter writer, int tag, @Nullable Object value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    writer.writeTag(tag, getFieldEncoding());
                    writer.writeVarint32(encodedSize(value));
                    encode(writer, value);
                    return;
                }
                super.encodeWithTag(writer, tag, value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@Nullable Object value) {
                if (value == null) {
                    return ProtoAdapter.STRUCT_NULL.encodedSizeWithTag(1, value);
                }
                if (value instanceof Number) {
                    return ProtoAdapter.DOUBLE.encodedSizeWithTag(2, Double.valueOf(((Number) value).doubleValue()));
                }
                if (value instanceof String) {
                    return ProtoAdapter.STRING.encodedSizeWithTag(3, value);
                }
                if (value instanceof Boolean) {
                    return ProtoAdapter.BOOL.encodedSizeWithTag(4, value);
                }
                if (value instanceof Map) {
                    return ProtoAdapter.STRUCT_MAP.encodedSizeWithTag(5, (Map) value);
                }
                if (value instanceof List) {
                    return ProtoAdapter.STRUCT_LIST.encodedSizeWithTag(6, value);
                }
                throw new IllegalArgumentException("unexpected struct value: " + value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int tag, @Nullable Object value) {
                if (value == null) {
                    int encodedSize = encodedSize(value);
                    ProtoWriter.Companion companion = ProtoWriter.INSTANCE;
                    return companion.tagSize$wire_runtime(tag) + companion.varint32Size$wire_runtime(encodedSize) + encodedSize;
                }
                return super.encodedSizeWithTag(tag, value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Object redact(@Nullable Object value) {
                if (value == null) {
                    return ProtoAdapter.STRUCT_NULL.redact(value);
                }
                if (!(value instanceof Number)) {
                    if (value instanceof String) {
                        return null;
                    }
                    if (!(value instanceof Boolean)) {
                        if (value instanceof Map) {
                            return ProtoAdapter.STRUCT_MAP.redact((Map) value);
                        }
                        if (value instanceof List) {
                            return ProtoAdapter.STRUCT_LIST.redact(value);
                        }
                        throw new IllegalArgumentException("unexpected struct value: " + value);
                    }
                    return value;
                }
                return value;
            }
        };
    }

    @NotNull
    public static final <E> String commonToString(E e16) {
        return String.valueOf(e16);
    }

    @NotNull
    public static final ProtoAdapter<Integer> commonUint32() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final int i3 = 0;
        return new ProtoAdapter<Integer>(fieldEncoding, orCreateKotlinClass, str, syntax, i3) { // from class: com.squareup.wire.ProtoAdapterKt$commonUint32$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Integer decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(reader.readVarint32());
            }

            public void encode(@NotNull ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(value);
            }

            public int encodedSize(int value) {
                return ProtoWriter.INSTANCE.varint32Size$wire_runtime(value);
            }

            @NotNull
            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Long> commonUint64() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.TYPE);
        final String str = null;
        final Syntax syntax = Syntax.PROTO_2;
        final long j3 = 0L;
        return new ProtoAdapter<Long>(fieldEncoding, orCreateKotlinClass, str, syntax, j3) { // from class: com.squareup.wire.ProtoAdapterKt$commonUint64$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l3) {
                encode(protoWriter, l3.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l3) {
                return encodedSize(l3.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l3) {
                return redact(l3.longValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Long decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(reader.readVarint64());
            }

            public void encode(@NotNull ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(value);
            }

            public int encodedSize(long value) {
                return ProtoWriter.INSTANCE.varint64Size$wire_runtime(value);
            }

            @NotNull
            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> ProtoAdapter<?> commonWithLabel(@NotNull ProtoAdapter<E> commonWithLabel, @NotNull WireField.Label label) {
        Intrinsics.checkNotNullParameter(commonWithLabel, "$this$commonWithLabel");
        Intrinsics.checkNotNullParameter(label, "label");
        if (label.isRepeated()) {
            if (label.isPacked()) {
                return commonWithLabel.asPacked();
            }
            return commonWithLabel.asRepeated();
        }
        return commonWithLabel;
    }

    @NotNull
    public static final <T> ProtoAdapter<T> commonWrapper(@NotNull final ProtoAdapter<T> delegate, @NotNull final String typeUrl) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(typeUrl, "typeUrl");
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass<?> type = delegate.getType();
        final Syntax syntax = Syntax.PROTO_3;
        final Object obj = null;
        return new ProtoAdapter<T>(fieldEncoding, type, typeUrl, syntax, obj) { // from class: com.squareup.wire.ProtoAdapterKt$commonWrapper$1
            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public T decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                T t16 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return t16;
                    }
                    if (nextTag != 1) {
                        reader.readUnknownField(nextTag);
                    } else {
                        t16 = (T) ProtoAdapter.this.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @Nullable T value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value != null) {
                    ProtoAdapter.this.encodeWithTag(writer, 1, value);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@Nullable T value) {
                if (value == null) {
                    return 0;
                }
                return ProtoAdapter.this.encodedSizeWithTag(1, value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public T redact(@Nullable T value) {
                if (value == null) {
                    return null;
                }
                return (T) ProtoAdapter.this.redact(value);
            }
        };
    }

    public static final <E> E commonDecode(@NotNull ProtoAdapter<E> commonDecode, @NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(commonDecode, "$this$commonDecode");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return commonDecode.decode(new Buffer().write(bytes));
    }

    @NotNull
    public static final <E> byte[] commonEncode(@NotNull ProtoAdapter<E> commonEncode, E e16) {
        Intrinsics.checkNotNullParameter(commonEncode, "$this$commonEncode");
        Buffer buffer = new Buffer();
        commonEncode.encode((BufferedSink) buffer, (Buffer) e16);
        return buffer.readByteArray();
    }

    public static final <E> E commonDecode(@NotNull ProtoAdapter<E> commonDecode, @NotNull BufferedSource source) {
        Intrinsics.checkNotNullParameter(commonDecode, "$this$commonDecode");
        Intrinsics.checkNotNullParameter(source, "source");
        return commonDecode.decode(new ProtoReader(source));
    }
}
