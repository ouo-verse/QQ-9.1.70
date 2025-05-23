package com.squareup.wire;

import com.gcore.abase.utils.PatternUtils;
import com.squareup.wire.Message;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.ReflectionKt;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 Y*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002YZB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u00a2\u0006\u0002\u0010\u0007B%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fB'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u0010B/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\u0011B7\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0013B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0014J\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f0\u0000J\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f0\u0000J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020.H&\u00a2\u0006\u0002\u0010/J\u0013\u0010,\u001a\u00028\u00002\u0006\u00100\u001a\u000201\u00a2\u0006\u0002\u00102J\u0013\u0010,\u001a\u00028\u00002\u0006\u00103\u001a\u000204\u00a2\u0006\u0002\u00105J\u0013\u0010,\u001a\u00028\u00002\u0006\u00106\u001a\u000207\u00a2\u0006\u0002\u00108J\u0013\u0010,\u001a\u00028\u00002\u0006\u00103\u001a\u000209\u00a2\u0006\u0002\u0010:J\u0013\u0010;\u001a\u0002042\u0006\u0010<\u001a\u00028\u0000\u00a2\u0006\u0002\u0010=J\u001d\u0010;\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010<\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010AJ\u001b\u0010;\u001a\u00020>2\u0006\u00100\u001a\u00020B2\u0006\u0010<\u001a\u00028\u0000\u00a2\u0006\u0002\u0010CJ\u001b\u0010;\u001a\u00020>2\u0006\u0010D\u001a\u00020E2\u0006\u0010<\u001a\u00028\u0000\u00a2\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u0002092\u0006\u0010<\u001a\u00028\u0000\u00a2\u0006\u0002\u0010HJ'\u0010I\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010J\u001a\u00020K2\b\u0010<\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010LJ\u0015\u0010M\u001a\u00020K2\u0006\u0010<\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010NJ\u001f\u0010O\u001a\u00020K2\u0006\u0010J\u001a\u00020K2\b\u0010<\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010PJ\u0015\u0010Q\u001a\u00028\u00002\u0006\u0010<\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010RJ\u0015\u0010S\u001a\u00020\t2\u0006\u0010<\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010TJ\u0019\u0010U\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010V\u001a\u00020WH\u0000\u00a2\u0006\u0002\bXR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0012\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u001b8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0018\u00010\u0000X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\"\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0018\u00010\u0000X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u00a8\u0006["}, d2 = {"Lcom/squareup/wire/ProtoAdapter;", "E", "", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "type", "Ljava/lang/Class;", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;)V", "typeUrl", "", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;Ljava/lang/String;)V", "syntax", "Lcom/squareup/wire/Syntax;", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;Ljava/lang/String;Lcom/squareup/wire/Syntax;)V", "Lkotlin/reflect/KClass;", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;)V", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;Ljava/lang/String;)V", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;Ljava/lang/String;Lcom/squareup/wire/Syntax;)V", "identity", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;Ljava/lang/String;Lcom/squareup/wire/Syntax;Ljava/lang/Object;)V", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;Ljava/lang/String;Lcom/squareup/wire/Syntax;Ljava/lang/Object;)V", "getFieldEncoding$wire_runtime", "()Lcom/squareup/wire/FieldEncoding;", "getIdentity", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isStruct", "", "isStruct$wire_runtime", "()Z", "packedAdapter", "", "getPackedAdapter$wire_runtime", "()Lcom/squareup/wire/ProtoAdapter;", "repeatedAdapter", "getRepeatedAdapter$wire_runtime", "getSyntax", "()Lcom/squareup/wire/Syntax;", "getType", "()Lkotlin/reflect/KClass;", "getTypeUrl", "()Ljava/lang/String;", "asPacked", "asRepeated", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Object;", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)Ljava/lang/Object;", "bytes", "", "([B)Ljava/lang/Object;", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)Ljava/lang/Object;", "Lokio/ByteString;", "(Lokio/ByteString;)Ljava/lang/Object;", "encode", "value", "(Ljava/lang/Object;)[B", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "(Lcom/squareup/wire/ProtoWriter;Ljava/lang/Object;)V", "Ljava/io/OutputStream;", "(Ljava/io/OutputStream;Ljava/lang/Object;)V", "sink", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/lang/Object;)V", "encodeByteString", "(Ljava/lang/Object;)Lokio/ByteString;", "encodeWithTag", "tag", "", "(Lcom/squareup/wire/ProtoWriter;ILjava/lang/Object;)V", "encodedSize", "(Ljava/lang/Object;)I", "encodedSizeWithTag", "(ILjava/lang/Object;)I", "redact", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "(Ljava/lang/Object;)Ljava/lang/String;", "withLabel", "label", "Lcom/squareup/wire/WireField$Label;", "withLabel$wire_runtime", "Companion", "EnumConstantNotFoundException", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class ProtoAdapter<E> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<Boolean> BOOL;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Boolean> BOOL_VALUE;

    @JvmField
    @NotNull
    public static final ProtoAdapter<ByteString> BYTES;

    @JvmField
    @NotNull
    public static final ProtoAdapter<ByteString> BYTES_VALUE;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final ProtoAdapter<Double> DOUBLE;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Double> DOUBLE_VALUE;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Duration> DURATION;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Unit> EMPTY;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Integer> FIXED32;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Long> FIXED64;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Float> FLOAT;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Float> FLOAT_VALUE;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Instant> INSTANT;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Integer> INT32;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Integer> INT32_VALUE;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Long> INT64;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Long> INT64_VALUE;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Integer> SFIXED32;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Long> SFIXED64;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Integer> SINT32;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Long> SINT64;

    @JvmField
    @NotNull
    public static final ProtoAdapter<String> STRING;

    @JvmField
    @NotNull
    public static final ProtoAdapter<String> STRING_VALUE;

    @JvmField
    @NotNull
    public static final ProtoAdapter<List<?>> STRUCT_LIST;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Map<String, ?>> STRUCT_MAP;

    @JvmField
    @NotNull
    public static final ProtoAdapter STRUCT_NULL;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Object> STRUCT_VALUE;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Integer> UINT32;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Integer> UINT32_VALUE;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Long> UINT64;

    @JvmField
    @NotNull
    public static final ProtoAdapter<Long> UINT64_VALUE;

    @NotNull
    private final FieldEncoding fieldEncoding;

    @Nullable
    private final E identity;

    @Nullable
    private final ProtoAdapter<List<E>> packedAdapter;

    @Nullable
    private final ProtoAdapter<List<E>> repeatedAdapter;

    @NotNull
    private final Syntax syntax;

    @Nullable
    private final KClass<?> type;

    @Nullable
    private final String typeUrl;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001IB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J-\u00102\u001a\b\u0012\u0004\u0012\u0002H30\u0004\"\u0010\b\u0001\u00103*\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003042\u0006\u00105\u001a\u0002H3H\u0007\u00a2\u0006\u0002\u00106J\"\u00102\u001a\b\u0012\u0004\u0012\u0002H30\u0004\"\u0004\b\u0001\u001032\f\u00107\u001a\b\u0012\u0004\u0012\u0002H308H\u0007J\u0014\u00102\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u00109\u001a\u00020%H\u0007J&\u0010:\u001a\b\u0012\u0004\u0012\u0002H<0;\"\b\b\u0001\u0010<*\u00020=2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H<08H\u0007JB\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u0002H@0*0\u0004\"\u0004\b\u0001\u0010?\"\u0004\b\u0002\u0010@2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0\u00042\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0\u0004H\u0007JH\u0010C\u001a\b\u0012\u0004\u0012\u0002H30\u0004\"\u0014\b\u0001\u00103*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD04\"\u0014\b\u0002\u0010D*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD0E2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H308H\u0007JP\u0010C\u001a\b\u0012\u0004\u0012\u0002H30\u0004\"\u0014\b\u0001\u00103*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD04\"\u0014\b\u0002\u0010D*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD0E2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H3082\u0006\u0010F\u001a\u00020%H\u0007JX\u0010C\u001a\b\u0012\u0004\u0012\u0002H30\u0004\"\u0014\b\u0001\u00103*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD04\"\u0014\b\u0002\u0010D*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD0E2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H3082\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020HH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u001aj\u0002`\u001b0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010(0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0002\b\u0003\u0018\u00010*0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lcom/squareup/wire/ProtoAdapter$Companion;", "", "()V", "BOOL", "Lcom/squareup/wire/ProtoAdapter;", "", "BOOL_VALUE", "BYTES", "Lokio/ByteString;", "BYTES_VALUE", "DOUBLE", "", "DOUBLE_VALUE", "DURATION", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", PatternUtils.NO_MATCH, "", "FIXED32", "", "FIXED64", "", "FLOAT", "", "FLOAT_VALUE", "INSTANT", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "INT32", "INT32_VALUE", "INT64", "INT64_VALUE", "SFIXED32", "SFIXED64", "SINT32", "SINT64", "STRING", "", "STRING_VALUE", "STRUCT_LIST", "", "STRUCT_MAP", "", "STRUCT_NULL", "", "STRUCT_VALUE", "UINT32", "UINT32_VALUE", "UINT64", "UINT64_VALUE", "get", "M", "Lcom/squareup/wire/Message;", "message", "(Lcom/squareup/wire/Message;)Lcom/squareup/wire/ProtoAdapter;", "type", "Ljava/lang/Class;", "adapterString", "newEnumAdapter", "Lcom/squareup/wire/EnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "newMapAdapter", "K", "V", "keyAdapter", "valueAdapter", "newMessageAdapter", "B", "Lcom/squareup/wire/Message$Builder;", "typeUrl", "syntax", "Lcom/squareup/wire/Syntax;", "UnsupportedTypeProtoAdapter", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/squareup/wire/ProtoAdapter$Companion$UnsupportedTypeProtoAdapter;", "Lcom/squareup/wire/ProtoAdapter;", "", "()V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "redact", "wire-runtime"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes3.dex */
        public static final class UnsupportedTypeProtoAdapter extends ProtoAdapter {
            public UnsupportedTypeProtoAdapter() {
                super(FieldEncoding.LENGTH_DELIMITED, (KClass<?>) Reflection.getOrCreateKotlinClass(Void.class));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
                return ((Number) encodedSize((Void) obj)).intValue();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Void decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Void encode(@NotNull ProtoWriter writer, @NotNull Void value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            @NotNull
            public Void encodedSize(@NotNull Void value) {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Void redact(@NotNull Void value) {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new IllegalStateException("Operation not supported.");
            }
        }

        Companion() {
        }

        @JvmStatic
        @NotNull
        public final <M extends Message<?, ?>> ProtoAdapter<M> get(@NotNull M message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return get(message.getClass());
        }

        @JvmStatic
        @NotNull
        public final <E extends WireEnum> EnumAdapter<E> newEnumAdapter(@NotNull Class<E> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new RuntimeEnumAdapter(type);
        }

        @JvmStatic
        @NotNull
        public final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(@NotNull ProtoAdapter<K> keyAdapter, @NotNull ProtoAdapter<V> valueAdapter) {
            Intrinsics.checkNotNullParameter(keyAdapter, "keyAdapter");
            Intrinsics.checkNotNullParameter(valueAdapter, "valueAdapter");
            return new MapProtoAdapter(keyAdapter, valueAdapter);
        }

        @JvmStatic
        @NotNull
        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(@NotNull Class<M> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return ReflectionKt.createRuntimeMessageAdapter(type, null, Syntax.PROTO_2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final <M> ProtoAdapter<M> get(@NotNull Class<M> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                Object obj = type.getField("ADAPTER").get(null);
                if (obj != null) {
                    return (ProtoAdapter) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<M>");
            } catch (IllegalAccessException e16) {
                throw new IllegalArgumentException("failed to access " + type.getName() + "#ADAPTER", e16);
            } catch (NoSuchFieldException e17) {
                throw new IllegalArgumentException("failed to access " + type.getName() + "#ADAPTER", e17);
            }
        }

        @JvmStatic
        @NotNull
        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(@NotNull Class<M> type, @NotNull String typeUrl) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(typeUrl, "typeUrl");
            return ReflectionKt.createRuntimeMessageAdapter(type, typeUrl, Syntax.PROTO_2);
        }

        @JvmStatic
        @NotNull
        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(@NotNull Class<M> type, @NotNull String typeUrl, @NotNull Syntax syntax) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(typeUrl, "typeUrl");
            Intrinsics.checkNotNullParameter(syntax, "syntax");
            return ReflectionKt.createRuntimeMessageAdapter(type, typeUrl, syntax);
        }

        @JvmStatic
        @NotNull
        public final ProtoAdapter<?> get(@NotNull String adapterString) {
            int indexOf$default;
            Intrinsics.checkNotNullParameter(adapterString, "adapterString");
            try {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) adapterString, '#', 0, false, 6, (Object) null);
                String substring = adapterString.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                String substring2 = adapterString.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                Object obj = Class.forName(substring).getField(substring2).get(null);
                if (obj != null) {
                    return (ProtoAdapter) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
            } catch (ClassNotFoundException e16) {
                throw new IllegalArgumentException("failed to access " + adapterString, e16);
            } catch (IllegalAccessException e17) {
                throw new IllegalArgumentException("failed to access " + adapterString, e17);
            } catch (NoSuchFieldException e18) {
                throw new IllegalArgumentException("failed to access " + adapterString, e18);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u00a2\u0006\u0002\u0010\u0007B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u00a2\u0006\u0002\u0010\tR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/squareup/wire/ProtoAdapter$EnumConstantNotFoundException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "value", "", "type", "Ljava/lang/Class;", "(ILjava/lang/Class;)V", "Lkotlin/reflect/KClass;", "(ILkotlin/reflect/KClass;)V", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {

        @JvmField
        public final int value;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public EnumConstantNotFoundException(int i3, @Nullable KClass<?> kClass) {
            super(r0.toString());
            Class javaClass;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Unknown enum tag ");
            sb5.append(i3);
            sb5.append(" for ");
            sb5.append((kClass == null || (javaClass = JvmClassMappingKt.getJavaClass((KClass) kClass)) == null) ? null : javaClass.getName());
            this.value = i3;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EnumConstantNotFoundException(int i3, @NotNull Class<?> type) {
            this(i3, (KClass<?>) JvmClassMappingKt.getKotlinClass(type));
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }

    static {
        ProtoAdapter<Duration> unsupportedTypeProtoAdapter;
        ProtoAdapter<Instant> unsupportedTypeProtoAdapter2;
        ProtoAdapter<Boolean> commonBool = ProtoAdapterKt.commonBool();
        BOOL = commonBool;
        ProtoAdapter<Integer> commonInt32 = ProtoAdapterKt.commonInt32();
        INT32 = commonInt32;
        ProtoAdapter<Integer> commonUint32 = ProtoAdapterKt.commonUint32();
        UINT32 = commonUint32;
        SINT32 = ProtoAdapterKt.commonSint32();
        FIXED32 = ProtoAdapterKt.commonFixed32();
        SFIXED32 = ProtoAdapterKt.commonSfixed32();
        ProtoAdapter<Long> commonInt64 = ProtoAdapterKt.commonInt64();
        INT64 = commonInt64;
        ProtoAdapter<Long> commonUint64 = ProtoAdapterKt.commonUint64();
        UINT64 = commonUint64;
        SINT64 = ProtoAdapterKt.commonSint64();
        FIXED64 = ProtoAdapterKt.commonFixed64();
        SFIXED64 = ProtoAdapterKt.commonSfixed64();
        ProtoAdapter<Float> commonFloat = ProtoAdapterKt.commonFloat();
        FLOAT = commonFloat;
        ProtoAdapter<Double> commonDouble = ProtoAdapterKt.commonDouble();
        DOUBLE = commonDouble;
        ProtoAdapter<ByteString> commonBytes = ProtoAdapterKt.commonBytes();
        BYTES = commonBytes;
        ProtoAdapter<String> commonString = ProtoAdapterKt.commonString();
        STRING = commonString;
        EMPTY = ProtoAdapterKt.commonEmpty();
        STRUCT_MAP = ProtoAdapterKt.commonStructMap();
        STRUCT_LIST = ProtoAdapterKt.commonStructList();
        STRUCT_NULL = ProtoAdapterKt.commonStructNull();
        STRUCT_VALUE = ProtoAdapterKt.commonStructValue();
        DOUBLE_VALUE = ProtoAdapterKt.commonWrapper(commonDouble, "type.googleapis.com/google.protobuf.DoubleValue");
        FLOAT_VALUE = ProtoAdapterKt.commonWrapper(commonFloat, "type.googleapis.com/google.protobuf.FloatValue");
        INT64_VALUE = ProtoAdapterKt.commonWrapper(commonInt64, "type.googleapis.com/google.protobuf.Int64Value");
        UINT64_VALUE = ProtoAdapterKt.commonWrapper(commonUint64, "type.googleapis.com/google.protobuf.UInt64Value");
        INT32_VALUE = ProtoAdapterKt.commonWrapper(commonInt32, "type.googleapis.com/google.protobuf.Int32Value");
        UINT32_VALUE = ProtoAdapterKt.commonWrapper(commonUint32, "type.googleapis.com/google.protobuf.UInt32Value");
        BOOL_VALUE = ProtoAdapterKt.commonWrapper(commonBool, "type.googleapis.com/google.protobuf.BoolValue");
        STRING_VALUE = ProtoAdapterKt.commonWrapper(commonString, "type.googleapis.com/google.protobuf.StringValue");
        BYTES_VALUE = ProtoAdapterKt.commonWrapper(commonBytes, "type.googleapis.com/google.protobuf.BytesValue");
        try {
            unsupportedTypeProtoAdapter = ProtoAdapterKt.commonDuration();
        } catch (NoClassDefFoundError unused) {
            unsupportedTypeProtoAdapter = new Companion.UnsupportedTypeProtoAdapter();
        }
        DURATION = unsupportedTypeProtoAdapter;
        try {
            unsupportedTypeProtoAdapter2 = ProtoAdapterKt.commonInstant();
        } catch (NoClassDefFoundError unused2) {
            unsupportedTypeProtoAdapter2 = new Companion.UnsupportedTypeProtoAdapter();
        }
        INSTANT = unsupportedTypeProtoAdapter2;
    }

    public /* synthetic */ ProtoAdapter(FieldEncoding fieldEncoding, KClass kClass, String str, Syntax syntax, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fieldEncoding, (KClass<?>) kClass, str, syntax, (i3 & 16) != 0 ? null : obj);
    }

    @JvmStatic
    @NotNull
    public static final <M extends Message<?, ?>> ProtoAdapter<M> get(@NotNull M m3) {
        return INSTANCE.get((Companion) m3);
    }

    @JvmStatic
    @NotNull
    public static final <E extends WireEnum> EnumAdapter<E> newEnumAdapter(@NotNull Class<E> cls) {
        return INSTANCE.newEnumAdapter(cls);
    }

    @JvmStatic
    @NotNull
    public static final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(@NotNull ProtoAdapter<K> protoAdapter, @NotNull ProtoAdapter<V> protoAdapter2) {
        return INSTANCE.newMapAdapter(protoAdapter, protoAdapter2);
    }

    @JvmStatic
    @NotNull
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(@NotNull Class<M> cls) {
        return INSTANCE.newMessageAdapter(cls);
    }

    @NotNull
    public final ProtoAdapter<List<E>> asPacked() {
        boolean z16;
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            throw new UnsupportedOperationException("Can't create a packed adapter from a packed or repeated adapter.");
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    }

    @NotNull
    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        throw new UnsupportedOperationException("Can't create a repeated adapter from a repeated or packed adapter.");
    }

    public abstract E decode(@NotNull ProtoReader reader) throws IOException;

    public final E decode(@NotNull InputStream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        return decode(Okio.buffer(Okio.source(stream)));
    }

    public abstract void encode(@NotNull ProtoWriter writer, E value) throws IOException;

    public final void encode(@NotNull OutputStream stream, E value) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        BufferedSink buffer = Okio.buffer(Okio.sink(stream));
        encode(buffer, (BufferedSink) value);
        buffer.emit();
    }

    @NotNull
    public final ByteString encodeByteString(E value) {
        Buffer buffer = new Buffer();
        encode((BufferedSink) buffer, (Buffer) value);
        return buffer.readByteString();
    }

    public void encodeWithTag(@NotNull ProtoWriter writer, int tag, @Nullable E value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value != null) {
            writer.writeTag(tag, getFieldEncoding());
            if (getFieldEncoding() == FieldEncoding.LENGTH_DELIMITED) {
                writer.writeVarint32(encodedSize(value));
            }
            encode(writer, (ProtoWriter) value);
        }
    }

    public abstract int encodedSize(E value);

    public int encodedSizeWithTag(int tag, @Nullable E value) {
        if (value == null) {
            return 0;
        }
        int encodedSize = encodedSize(value);
        if (getFieldEncoding() == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += ProtoWriter.INSTANCE.varint32Size$wire_runtime(encodedSize);
        }
        return ProtoWriter.INSTANCE.tagSize$wire_runtime(tag) + encodedSize;
    }

    @NotNull
    /* renamed from: getFieldEncoding$wire_runtime, reason: from getter */
    public final FieldEncoding getFieldEncoding() {
        return this.fieldEncoding;
    }

    @Nullable
    public final E getIdentity() {
        return this.identity;
    }

    @Nullable
    public final ProtoAdapter<List<E>> getPackedAdapter$wire_runtime() {
        return this.packedAdapter;
    }

    @Nullable
    public final ProtoAdapter<List<E>> getRepeatedAdapter$wire_runtime() {
        return this.repeatedAdapter;
    }

    @NotNull
    public final Syntax getSyntax() {
        return this.syntax;
    }

    @Nullable
    public final KClass<?> getType() {
        return this.type;
    }

    @Nullable
    public final String getTypeUrl() {
        return this.typeUrl;
    }

    public final boolean isStruct$wire_runtime() {
        if (!Intrinsics.areEqual(this, STRUCT_MAP) && !Intrinsics.areEqual(this, STRUCT_LIST) && !Intrinsics.areEqual(this, STRUCT_VALUE) && !Intrinsics.areEqual(this, STRUCT_NULL)) {
            return false;
        }
        return true;
    }

    public abstract E redact(E value);

    @NotNull
    public String toString(E value) {
        return String.valueOf(value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final ProtoAdapter<?> withLabel$wire_runtime(@NotNull WireField.Label label) {
        Intrinsics.checkNotNullParameter(label, "label");
        if (label.isRepeated()) {
            if (label.isPacked()) {
                return asPacked();
            }
            return asRepeated();
        }
        return this;
    }

    public ProtoAdapter(@NotNull FieldEncoding fieldEncoding, @Nullable KClass<?> kClass, @Nullable String str, @NotNull Syntax syntax, @Nullable E e16) {
        PackedProtoAdapter packedProtoAdapter;
        FieldEncoding fieldEncoding2;
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        this.fieldEncoding = fieldEncoding;
        this.type = kClass;
        this.typeUrl = str;
        this.syntax = syntax;
        this.identity = e16;
        boolean z16 = this instanceof PackedProtoAdapter;
        RepeatedProtoAdapter repeatedProtoAdapter = null;
        if (z16 || (this instanceof RepeatedProtoAdapter) || fieldEncoding == (fieldEncoding2 = FieldEncoding.LENGTH_DELIMITED)) {
            packedProtoAdapter = null;
        } else {
            if (getFieldEncoding() != fieldEncoding2) {
                packedProtoAdapter = new PackedProtoAdapter(this);
            } else {
                throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
            }
        }
        this.packedAdapter = packedProtoAdapter;
        if (!(this instanceof RepeatedProtoAdapter) && !z16) {
            repeatedProtoAdapter = new RepeatedProtoAdapter(this);
        }
        this.repeatedAdapter = repeatedProtoAdapter;
    }

    @JvmStatic
    @NotNull
    public static final <M> ProtoAdapter<M> get(@NotNull Class<M> cls) {
        return INSTANCE.get(cls);
    }

    @JvmStatic
    @NotNull
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(@NotNull Class<M> cls, @NotNull String str) {
        return INSTANCE.newMessageAdapter(cls, str);
    }

    public final E decode(@NotNull byte[] bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return decode(new Buffer().write(bytes));
    }

    @JvmStatic
    @NotNull
    public static final ProtoAdapter<?> get(@NotNull String str) {
        return INSTANCE.get(str);
    }

    @JvmStatic
    @NotNull
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(@NotNull Class<M> cls, @NotNull String str, @NotNull Syntax syntax) {
        return INSTANCE.newMessageAdapter(cls, str, syntax);
    }

    public final E decode(@NotNull ByteString bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return decode(new Buffer().write(bytes));
    }

    public final E decode(@NotNull BufferedSource source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        return decode(new ProtoReader(source));
    }

    public final void encode(@NotNull BufferedSink sink, E value) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        encode(new ProtoWriter(sink), (ProtoWriter) value);
    }

    @NotNull
    public final byte[] encode(E value) {
        Buffer buffer = new Buffer();
        encode((BufferedSink) buffer, (Buffer) value);
        return buffer.readByteArray();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(@NotNull FieldEncoding fieldEncoding, @NotNull Class<?> type) {
        this(fieldEncoding, (KClass<?>) JvmClassMappingKt.getKotlinClass(type));
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        Intrinsics.checkNotNullParameter(type, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(@NotNull FieldEncoding fieldEncoding, @NotNull Class<?> type, @Nullable String str) {
        this(fieldEncoding, (KClass<?>) JvmClassMappingKt.getKotlinClass(type), str, Syntax.PROTO_2);
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        Intrinsics.checkNotNullParameter(type, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(@NotNull FieldEncoding fieldEncoding, @NotNull Class<?> type, @Nullable String str, @NotNull Syntax syntax) {
        this(fieldEncoding, (KClass<?>) JvmClassMappingKt.getKotlinClass(type), str, syntax);
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(@NotNull FieldEncoding fieldEncoding, @Nullable KClass<?> kClass) {
        this(fieldEncoding, kClass, (String) null, Syntax.PROTO_2);
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(@NotNull FieldEncoding fieldEncoding, @Nullable KClass<?> kClass, @Nullable String str) {
        this(fieldEncoding, kClass, str, Syntax.PROTO_2);
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(@NotNull FieldEncoding fieldEncoding, @Nullable KClass<?> kClass, @Nullable String str, @NotNull Syntax syntax) {
        this(fieldEncoding, kClass, str, syntax, (Object) null);
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(@NotNull FieldEncoding fieldEncoding, @NotNull Class<?> type, @Nullable String str, @NotNull Syntax syntax, @Nullable E e16) {
        this(fieldEncoding, (KClass<?>) JvmClassMappingKt.getKotlinClass(type), str, syntax, e16);
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }
}
