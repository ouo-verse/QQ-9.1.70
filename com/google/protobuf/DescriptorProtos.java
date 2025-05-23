package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.a;
import com.google.protobuf.ad;
import com.google.protobuf.cc;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.state.map.MapItemKt;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes2.dex */
public final class DescriptorProtos {
    private static final Descriptors.b A;
    private static final GeneratedMessageV3.e B;
    private static final Descriptors.b C;
    private static final GeneratedMessageV3.e D;
    private static final Descriptors.b E;
    private static final GeneratedMessageV3.e F;
    private static final Descriptors.b G;
    private static final GeneratedMessageV3.e H;
    private static final Descriptors.b I;
    private static final GeneratedMessageV3.e J;
    private static final Descriptors.b K;
    private static final GeneratedMessageV3.e L;
    private static final Descriptors.b M;
    private static final GeneratedMessageV3.e N;
    private static final Descriptors.b O;
    private static final GeneratedMessageV3.e P;
    private static final Descriptors.b Q;
    private static final GeneratedMessageV3.e R;
    private static final Descriptors.b S;
    private static final GeneratedMessageV3.e T;
    private static final Descriptors.b U;
    private static final GeneratedMessageV3.e V;
    private static final Descriptors.b W;
    private static final GeneratedMessageV3.e X;
    private static final Descriptors.b Y;
    private static final GeneratedMessageV3.e Z;

    /* renamed from: a, reason: collision with root package name */
    private static final Descriptors.b f35264a;

    /* renamed from: a0, reason: collision with root package name */
    private static final Descriptors.b f35265a0;

    /* renamed from: b, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35266b;

    /* renamed from: b0, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35267b0;

    /* renamed from: c, reason: collision with root package name */
    private static final Descriptors.b f35268c;

    /* renamed from: c0, reason: collision with root package name */
    private static Descriptors.FileDescriptor f35269c0 = Descriptors.FileDescriptor.u(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"\u00db\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u0012\u0019\n\u0011public_dependency\u0018\n \u0003(\u0005\u0012\u0017\n\u000fweak_dependency\u0018\u000b \u0003(\u0005\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\u0012\u000e\n\u0006syntax\u0018\f \u0001(\t\"\u00a9\u0005\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fextension_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00129\n\noneof_decl\u0018\b \u0003(\u000b2%.google.protobuf.OneofDescriptorProto\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u0012F\n\u000ereserved_range\u0018\t \u0003(\u000b2..google.protobuf.DescriptorProto.ReservedRange\u0012\u0015\n\rreserved_name\u0018\n \u0003(\t\u001ae\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\u00127\n\u0007options\u0018\u0003 \u0001(\u000b2&.google.protobuf.ExtensionRangeOptions\u001a+\n\rReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"g\n\u0015ExtensionRangeOptions\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u00bc\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012\u0013\n\u000boneof_index\u0018\t \u0001(\u0005\u0012\u0011\n\tjson_name\u0018\n \u0001(\t\u0012.\n\u0007options\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"\u00b6\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUIRED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"T\n\u0014OneofDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012.\n\u0007options\u0018\u0002 \u0001(\u000b2\u001d.google.protobuf.OneofOptions\"\u00a4\u0002\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\u0012N\n\u000ereserved_range\u0018\u0004 \u0003(\u000b26.google.protobuf.EnumDescriptorProto.EnumReservedRange\u0012\u0015\n\rreserved_name\u0018\u0005 \u0003(\t\u001a/\n\u0011EnumReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0090\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.google.protobuf.ServiceOptions\"\u00c1\u0001\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\u0012\u001f\n\u0010client_streaming\u0018\u0005 \u0001(\b:\u0005false\u0012\u001f\n\u0010server_streaming\u0018\u0006 \u0001(\b:\u0005false\"\u00a6\u0006\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012)\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\bB\u0002\u0018\u0001\u0012%\n\u0016java_string_check_utf8\u0018\u001b \u0001(\b:\u0005false\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012\u0012\n\ngo_package\u0018\u000b \u0001(\t\u0012\"\n\u0013cc_generic_services\u0018\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012#\n\u0014php_generic_services\u0018* \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0017 \u0001(\b:\u0005false\u0012\u001f\n\u0010cc_enable_arenas\u0018\u001f \u0001(\b:\u0005false\u0012\u0019\n\u0011objc_class_prefix\u0018$ \u0001(\t\u0012\u0018\n\u0010csharp_namespace\u0018% \u0001(\t\u0012\u0014\n\fswift_prefix\u0018' \u0001(\t\u0012\u0018\n\u0010php_class_prefix\u0018( \u0001(\t\u0012\u0015\n\rphp_namespace\u0018) \u0001(\t\u0012\u001e\n\u0016php_metadata_namespace\u0018, \u0001(\t\u0012\u0014\n\fruby_package\u0018- \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b&\u0010'\"\u00f2\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0011\n\tmap_entry\u0018\u0007 \u0001(\b\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\b\u0010\tJ\u0004\b\t\u0010\n\"\u009e\u0003\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012?\n\u0006jstype\u0018\u0006 \u0001(\u000e2$.google.protobuf.FieldOptions.JSType:\tJS_NORMAL\u0012\u0013\n\u0004lazy\u0018\u0005 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0013\n\u0004weak\u0018\n \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002\"5\n\u0006JSType\u0012\r\n\tJS_NORMAL\u0010\u0000\u0012\r\n\tJS_STRING\u0010\u0001\u0012\r\n\tJS_NUMBER\u0010\u0002*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\u0004\u0010\u0005\"^\n\fOneofOptions\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u0093\u0001\n\u000bEnumOptions\u0012\u0013\n\u000ballow_alias\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\u0005\u0010\u0006\"}\n\u0010EnumValueOptions\u0012\u0019\n\ndeprecated\u0018\u0001 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"{\n\u000eServiceOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u00ad\u0002\n\rMethodOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012_\n\u0011idempotency_level\u0018\" \u0001(\u000e2/.google.protobuf.MethodOptions.IdempotencyLevel:\u0013IDEMPOTENCY_UNKNOWN\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"P\n\u0010IdempotencyLevel\u0012\u0017\n\u0013IDEMPOTENCY_UNKNOWN\u0010\u0000\u0012\u0013\n\u000fNO_SIDE_EFFECTS\u0010\u0001\u0012\u000e\n\nIDEMPOTENT\u0010\u0002*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u009e\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012positive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\b\"\u00d5\u0001\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001a\u0086\u0001\n\bLocation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0018\n\u0010leading_comments\u0018\u0003 \u0001(\t\u0012\u0019\n\u0011trailing_comments\u0018\u0004 \u0001(\t\u0012!\n\u0019leading_detached_comments\u0018\u0006 \u0003(\t\"\u00a7\u0001\n\u0011GeneratedCodeInfo\u0012A\n\nannotation\u0018\u0001 \u0003(\u000b2-.google.protobuf.GeneratedCodeInfo.Annotation\u001aO\n\nAnnotation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0013\n\u000bsource_file\u0018\u0002 \u0001(\t\u0012\r\n\u0005begin\u0018\u0003 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0004 \u0001(\u0005B\u008f\u0001\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001Z>github.com/golang/protobuf/protoc-gen-go/descriptor;descriptor\u00f8\u0001\u0001\u00a2\u0002\u0003GPB\u00aa\u0002\u001aGoogle.Protobuf.Reflection"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: d, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35270d;

    /* renamed from: e, reason: collision with root package name */
    private static final Descriptors.b f35271e;

    /* renamed from: f, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35272f;

    /* renamed from: g, reason: collision with root package name */
    private static final Descriptors.b f35273g;

    /* renamed from: h, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35274h;

    /* renamed from: i, reason: collision with root package name */
    private static final Descriptors.b f35275i;

    /* renamed from: j, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35276j;

    /* renamed from: k, reason: collision with root package name */
    private static final Descriptors.b f35277k;

    /* renamed from: l, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35278l;

    /* renamed from: m, reason: collision with root package name */
    private static final Descriptors.b f35279m;

    /* renamed from: n, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35280n;

    /* renamed from: o, reason: collision with root package name */
    private static final Descriptors.b f35281o;

    /* renamed from: p, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35282p;

    /* renamed from: q, reason: collision with root package name */
    private static final Descriptors.b f35283q;

    /* renamed from: r, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35284r;

    /* renamed from: s, reason: collision with root package name */
    private static final Descriptors.b f35285s;

    /* renamed from: t, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35286t;

    /* renamed from: u, reason: collision with root package name */
    private static final Descriptors.b f35287u;

    /* renamed from: v, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35288v;

    /* renamed from: w, reason: collision with root package name */
    private static final Descriptors.b f35289w;

    /* renamed from: x, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35290x;

    /* renamed from: y, reason: collision with root package name */
    private static final Descriptors.b f35291y;

    /* renamed from: z, reason: collision with root package name */
    private static final GeneratedMessageV3.e f35292z;

    /* loaded from: classes2.dex */
    public static final class DescriptorProto extends GeneratedMessageV3 implements b {
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int ONEOF_DECL_FIELD_NUMBER = 8;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        public static final int RESERVED_NAME_FIELD_NUMBER = 10;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<EnumDescriptorProto> enumType_;
        private List<ExtensionRange> extensionRange_;
        private List<FieldDescriptorProto> extension_;
        private List<FieldDescriptorProto> field_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private List<DescriptorProto> nestedType_;
        private List<OneofDescriptorProto> oneofDecl_;
        private MessageOptions options_;
        private ah reservedName_;
        private List<ReservedRange> reservedRange_;

        /* renamed from: d, reason: collision with root package name */
        private static final DescriptorProto f35293d = new DescriptorProto();

        @Deprecated
        public static final bg<DescriptorProto> PARSER = new a();

        /* loaded from: classes2.dex */
        public static final class ExtensionRange extends GeneratedMessageV3 implements c {
            public static final int END_FIELD_NUMBER = 2;
            public static final int OPTIONS_FIELD_NUMBER = 3;
            public static final int START_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized;
            private ExtensionRangeOptions options_;
            private int start_;

            /* renamed from: d, reason: collision with root package name */
            private static final ExtensionRange f35294d = new ExtensionRange();

            @Deprecated
            public static final bg<ExtensionRange> PARSER = new a();

            /* loaded from: classes2.dex */
            static class a extends com.google.protobuf.c<ExtensionRange> {
                a() {
                }

                @Override // com.google.protobuf.bg
                /* renamed from: G, reason: merged with bridge method [inline-methods] */
                public ExtensionRange g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                    return new ExtensionRange(kVar, tVar);
                }
            }

            public static ExtensionRange getDefaultInstance() {
                return f35294d;
            }

            public static final Descriptors.b getDescriptor() {
                return DescriptorProtos.f35273g;
            }

            public static b newBuilder() {
                return f35294d.toBuilder();
            }

            public static ExtensionRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static ExtensionRange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.d(byteBuffer);
            }

            public static bg<ExtensionRange> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ExtensionRange)) {
                    return super.equals(obj);
                }
                ExtensionRange extensionRange = (ExtensionRange) obj;
                if (hasStart() != extensionRange.hasStart()) {
                    return false;
                }
                if ((hasStart() && getStart() != extensionRange.getStart()) || hasEnd() != extensionRange.hasEnd()) {
                    return false;
                }
                if ((hasEnd() && getEnd() != extensionRange.getEnd()) || hasOptions() != extensionRange.hasOptions()) {
                    return false;
                }
                if ((!hasOptions() || getOptions().equals(extensionRange.getOptions())) && this.unknownFields.equals(extensionRange.unknownFields)) {
                    return true;
                }
                return false;
            }

            public int getEnd() {
                return this.end_;
            }

            public ExtensionRangeOptions getOptions() {
                ExtensionRangeOptions extensionRangeOptions = this.options_;
                if (extensionRangeOptions == null) {
                    return ExtensionRangeOptions.getDefaultInstance();
                }
                return extensionRangeOptions;
            }

            public g getOptionsOrBuilder() {
                ExtensionRangeOptions extensionRangeOptions = this.options_;
                if (extensionRangeOptions == null) {
                    return ExtensionRangeOptions.getDefaultInstance();
                }
                return extensionRangeOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
            public bg<ExtensionRange> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
            public int getSerializedSize() {
                int i3 = this.memoizedSize;
                if (i3 != -1) {
                    return i3;
                }
                int i16 = 0;
                if ((this.bitField0_ & 1) != 0) {
                    i16 = 0 + CodedOutputStream.x(1, this.start_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    i16 += CodedOutputStream.x(2, this.end_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    i16 += CodedOutputStream.G(3, getOptions());
                }
                int serializedSize = i16 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
            public final cc getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasEnd() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            public boolean hasOptions() {
                if ((this.bitField0_ & 4) != 0) {
                    return true;
                }
                return false;
            }

            public boolean hasStart() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i3 = this.memoizedHashCode;
                if (i3 != 0) {
                    return i3;
                }
                int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
                if (hasStart()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getStart();
                }
                if (hasEnd()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getEnd();
                }
                if (hasOptions()) {
                    hashCode = (((hashCode * 37) + 3) * 53) + getOptions().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f35274h.e(ExtensionRange.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
            public final boolean isInitialized() {
                byte b16 = this.memoizedIsInitialized;
                if (b16 == 1) {
                    return true;
                }
                if (b16 == 0) {
                    return false;
                }
                if (hasOptions() && !getOptions().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.f fVar) {
                return new ExtensionRange();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) != 0) {
                    codedOutputStream.G0(1, this.start_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    codedOutputStream.G0(2, this.end_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    codedOutputStream.K0(3, getOptions());
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* loaded from: classes2.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements c {
                private int C;
                private ExtensionRangeOptions D;
                private bu<ExtensionRangeOptions, ExtensionRangeOptions.b, g> E;

                /* renamed from: i, reason: collision with root package name */
                private int f35295i;

                /* renamed from: m, reason: collision with root package name */
                private int f35296m;

                private void maybeForceBuilderInitialization() {
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        w();
                    }
                }

                private bu<ExtensionRangeOptions, ExtensionRangeOptions.b, g> w() {
                    if (this.E == null) {
                        this.E = new bu<>(v(), h(), isClean());
                        this.D = null;
                    }
                    return this.E;
                }

                public b A(ExtensionRangeOptions extensionRangeOptions) {
                    ExtensionRangeOptions extensionRangeOptions2;
                    bu<ExtensionRangeOptions, ExtensionRangeOptions.b, g> buVar = this.E;
                    if (buVar == null) {
                        if ((this.f35295i & 4) != 0 && (extensionRangeOptions2 = this.D) != null && extensionRangeOptions2 != ExtensionRangeOptions.getDefaultInstance()) {
                            this.D = ExtensionRangeOptions.newBuilder(this.D).H(extensionRangeOptions).buildPartial();
                        } else {
                            this.D = extensionRangeOptions;
                        }
                        onChanged();
                    } else {
                        buVar.g(extensionRangeOptions);
                    }
                    this.f35295i |= 4;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
                /* renamed from: B, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                public final b mo52mergeUnknownFields(cc ccVar) {
                    return (b) super.mo52mergeUnknownFields(ccVar);
                }

                public b C(int i3) {
                    this.f35295i |= 2;
                    this.C = i3;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
                /* renamed from: D, reason: merged with bridge method [inline-methods] */
                public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.setField(fieldDescriptor, obj);
                }

                public b E(int i3) {
                    this.f35295i |= 1;
                    this.f35296m = i3;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
                /* renamed from: F, reason: merged with bridge method [inline-methods] */
                public final b setUnknownFields(cc ccVar) {
                    return (b) super.setUnknownFields(ccVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
                public Descriptors.b getDescriptorForType() {
                    return DescriptorProtos.f35273g;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e i() {
                    return DescriptorProtos.f35274h.e(ExtensionRange.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
                /* renamed from: o, reason: merged with bridge method [inline-methods] */
                public ExtensionRange build() {
                    ExtensionRange buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
                }

                @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public ExtensionRange buildPartial() {
                    int i3;
                    ExtensionRange extensionRange = new ExtensionRange(this);
                    int i16 = this.f35295i;
                    if ((i16 & 1) != 0) {
                        extensionRange.start_ = this.f35296m;
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if ((i16 & 2) != 0) {
                        extensionRange.end_ = this.C;
                        i3 |= 2;
                    }
                    if ((i16 & 4) != 0) {
                        bu<ExtensionRangeOptions, ExtensionRangeOptions.b, g> buVar = this.E;
                        if (buVar == null) {
                            extensionRange.options_ = this.D;
                        } else {
                            extensionRange.options_ = buVar.b();
                        }
                        i3 |= 4;
                    }
                    extensionRange.bitField0_ = i3;
                    onBuilt();
                    return extensionRange;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
                /* renamed from: q, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                public b clear() {
                    super.clear();
                    this.f35296m = 0;
                    int i3 = this.f35295i & (-2);
                    this.C = 0;
                    this.f35295i = i3 & (-3);
                    bu<ExtensionRangeOptions, ExtensionRangeOptions.b, g> buVar = this.E;
                    if (buVar == null) {
                        this.D = null;
                    } else {
                        buVar.c();
                    }
                    this.f35295i &= -5;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (b) super.clearField(fieldDescriptor);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: s, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                public b clearOneof(Descriptors.g gVar) {
                    return (b) super.clearOneof(gVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: t, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                public b mo50clone() {
                    return (b) super.mo50clone();
                }

                @Override // com.google.protobuf.av, com.google.protobuf.ax
                /* renamed from: u, reason: merged with bridge method [inline-methods] */
                public ExtensionRange getDefaultInstanceForType() {
                    return ExtensionRange.getDefaultInstance();
                }

                public ExtensionRangeOptions v() {
                    bu<ExtensionRangeOptions, ExtensionRangeOptions.b, g> buVar = this.E;
                    if (buVar == null) {
                        ExtensionRangeOptions extensionRangeOptions = this.D;
                        if (extensionRangeOptions == null) {
                            return ExtensionRangeOptions.getDefaultInstance();
                        }
                        return extensionRangeOptions;
                    }
                    return buVar.f();
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
                /* renamed from: x, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                    ExtensionRange extensionRange = null;
                    try {
                        try {
                            ExtensionRange g16 = ExtensionRange.PARSER.g(kVar, tVar);
                            if (g16 != null) {
                                y(g16);
                            }
                            return this;
                        } catch (Throwable th5) {
                            th = th5;
                            if (extensionRange != null) {
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        ExtensionRange extensionRange2 = (ExtensionRange) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th6) {
                            th = th6;
                            extensionRange = extensionRange2;
                            if (extensionRange != null) {
                                y(extensionRange);
                            }
                            throw th;
                        }
                    }
                }

                public b y(ExtensionRange extensionRange) {
                    if (extensionRange == ExtensionRange.getDefaultInstance()) {
                        return this;
                    }
                    if (extensionRange.hasStart()) {
                        E(extensionRange.getStart());
                    }
                    if (extensionRange.hasEnd()) {
                        C(extensionRange.getEnd());
                    }
                    if (extensionRange.hasOptions()) {
                        A(extensionRange.getOptions());
                    }
                    mergeUnknownFields(extensionRange.unknownFields);
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
                /* renamed from: z, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(ar arVar) {
                    if (arVar instanceof ExtensionRange) {
                        return y((ExtensionRange) arVar);
                    }
                    super.mergeFrom(arVar);
                    return this;
                }

                b() {
                    maybeForceBuilderInitialization();
                }

                b(GeneratedMessageV3.c cVar) {
                    super(cVar);
                    maybeForceBuilderInitialization();
                }
            }

            public static b newBuilder(ExtensionRange extensionRange) {
                return f35294d.toBuilder().y(extensionRange);
            }

            public static ExtensionRange parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
                return PARSER.m(byteBuffer, tVar);
            }

            ExtensionRange(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static ExtensionRange parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
            }

            public static ExtensionRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.b(byteString);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
            public ExtensionRange getDefaultInstanceForType() {
                return f35294d;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
            public b toBuilder() {
                return this == f35294d ? new b() : new b().y(this);
            }

            public static ExtensionRange parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
                return PARSER.a(byteString, tVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
            public b newBuilderForType() {
                return newBuilder();
            }

            ExtensionRange() {
                this.memoizedIsInitialized = (byte) -1;
            }

            public static ExtensionRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.j(bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public b newBuilderForType(GeneratedMessageV3.c cVar) {
                return new b(cVar);
            }

            public static ExtensionRange parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
                return PARSER.i(bArr, tVar);
            }

            ExtensionRange(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                this();
                tVar.getClass();
                cc.b g16 = cc.g();
                boolean z16 = false;
                while (!z16) {
                    try {
                        try {
                            try {
                                int J = kVar.J();
                                if (J != 0) {
                                    if (J == 8) {
                                        this.bitField0_ |= 1;
                                        this.start_ = kVar.x();
                                    } else if (J == 16) {
                                        this.bitField0_ |= 2;
                                        this.end_ = kVar.x();
                                    } else if (J != 26) {
                                        if (!parseUnknownField(kVar, g16, tVar, J)) {
                                        }
                                    } else {
                                        ExtensionRangeOptions.b builder = (this.bitField0_ & 4) != 0 ? this.options_.toBuilder() : null;
                                        ExtensionRangeOptions extensionRangeOptions = (ExtensionRangeOptions) kVar.z(ExtensionRangeOptions.PARSER, tVar);
                                        this.options_ = extensionRangeOptions;
                                        if (builder != null) {
                                            builder.H(extensionRangeOptions);
                                            this.options_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 4;
                                    }
                                }
                                z16 = true;
                            } catch (IOException e16) {
                                throw new InvalidProtocolBufferException(e16).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e17) {
                            throw e17.setUnfinishedMessage(this);
                        }
                    } finally {
                        this.unknownFields = g16.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static ExtensionRange parseFrom(InputStream inputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static ExtensionRange parseFrom(InputStream inputStream, t tVar) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
            }

            public static ExtensionRange parseFrom(com.google.protobuf.k kVar) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
            }

            public static ExtensionRange parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
            }
        }

        /* loaded from: classes2.dex */
        public static final class ReservedRange extends GeneratedMessageV3 implements d {
            public static final int END_FIELD_NUMBER = 2;
            public static final int START_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized;
            private int start_;

            /* renamed from: d, reason: collision with root package name */
            private static final ReservedRange f35297d = new ReservedRange();

            @Deprecated
            public static final bg<ReservedRange> PARSER = new a();

            /* loaded from: classes2.dex */
            static class a extends com.google.protobuf.c<ReservedRange> {
                a() {
                }

                @Override // com.google.protobuf.bg
                /* renamed from: G, reason: merged with bridge method [inline-methods] */
                public ReservedRange g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                    return new ReservedRange(kVar, tVar);
                }
            }

            public static ReservedRange getDefaultInstance() {
                return f35297d;
            }

            public static final Descriptors.b getDescriptor() {
                return DescriptorProtos.f35275i;
            }

            public static b newBuilder() {
                return f35297d.toBuilder();
            }

            public static ReservedRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static ReservedRange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.d(byteBuffer);
            }

            public static bg<ReservedRange> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ReservedRange)) {
                    return super.equals(obj);
                }
                ReservedRange reservedRange = (ReservedRange) obj;
                if (hasStart() != reservedRange.hasStart()) {
                    return false;
                }
                if ((hasStart() && getStart() != reservedRange.getStart()) || hasEnd() != reservedRange.hasEnd()) {
                    return false;
                }
                if ((!hasEnd() || getEnd() == reservedRange.getEnd()) && this.unknownFields.equals(reservedRange.unknownFields)) {
                    return true;
                }
                return false;
            }

            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
            public bg<ReservedRange> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
            public int getSerializedSize() {
                int i3 = this.memoizedSize;
                if (i3 != -1) {
                    return i3;
                }
                int i16 = 0;
                if ((this.bitField0_ & 1) != 0) {
                    i16 = 0 + CodedOutputStream.x(1, this.start_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    i16 += CodedOutputStream.x(2, this.end_);
                }
                int serializedSize = i16 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
            public final cc getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasEnd() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            public boolean hasStart() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i3 = this.memoizedHashCode;
                if (i3 != 0) {
                    return i3;
                }
                int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
                if (hasStart()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getStart();
                }
                if (hasEnd()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getEnd();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f35276j.e(ReservedRange.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
            public final boolean isInitialized() {
                byte b16 = this.memoizedIsInitialized;
                if (b16 == 1) {
                    return true;
                }
                if (b16 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.f fVar) {
                return new ReservedRange();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) != 0) {
                    codedOutputStream.G0(1, this.start_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    codedOutputStream.G0(2, this.end_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* loaded from: classes2.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements d {
                private int C;

                /* renamed from: i, reason: collision with root package name */
                private int f35298i;

                /* renamed from: m, reason: collision with root package name */
                private int f35299m;

                private void maybeForceBuilderInitialization() {
                    boolean z16 = GeneratedMessageV3.alwaysUseFieldBuilders;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
                /* renamed from: A, reason: merged with bridge method [inline-methods] */
                public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.setField(fieldDescriptor, obj);
                }

                public b B(int i3) {
                    this.f35298i |= 1;
                    this.f35299m = i3;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
                /* renamed from: C, reason: merged with bridge method [inline-methods] */
                public final b setUnknownFields(cc ccVar) {
                    return (b) super.setUnknownFields(ccVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
                public Descriptors.b getDescriptorForType() {
                    return DescriptorProtos.f35275i;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e i() {
                    return DescriptorProtos.f35276j.e(ReservedRange.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
                /* renamed from: o, reason: merged with bridge method [inline-methods] */
                public ReservedRange build() {
                    ReservedRange buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
                }

                @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public ReservedRange buildPartial() {
                    int i3;
                    ReservedRange reservedRange = new ReservedRange(this);
                    int i16 = this.f35298i;
                    if ((i16 & 1) != 0) {
                        reservedRange.start_ = this.f35299m;
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if ((i16 & 2) != 0) {
                        reservedRange.end_ = this.C;
                        i3 |= 2;
                    }
                    reservedRange.bitField0_ = i3;
                    onBuilt();
                    return reservedRange;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
                /* renamed from: q, reason: merged with bridge method [inline-methods] */
                public b clear() {
                    super.clear();
                    this.f35299m = 0;
                    int i3 = this.f35298i & (-2);
                    this.C = 0;
                    this.f35298i = i3 & (-3);
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (b) super.clearField(fieldDescriptor);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: s, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                public b clearOneof(Descriptors.g gVar) {
                    return (b) super.clearOneof(gVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: t, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                public b mo50clone() {
                    return (b) super.mo50clone();
                }

                @Override // com.google.protobuf.av, com.google.protobuf.ax
                /* renamed from: u, reason: merged with bridge method [inline-methods] */
                public ReservedRange getDefaultInstanceForType() {
                    return ReservedRange.getDefaultInstance();
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
                /* renamed from: v, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                    ReservedRange reservedRange = null;
                    try {
                        try {
                            ReservedRange g16 = ReservedRange.PARSER.g(kVar, tVar);
                            if (g16 != null) {
                                w(g16);
                            }
                            return this;
                        } catch (Throwable th5) {
                            th = th5;
                            if (reservedRange != null) {
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        ReservedRange reservedRange2 = (ReservedRange) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th6) {
                            th = th6;
                            reservedRange = reservedRange2;
                            if (reservedRange != null) {
                                w(reservedRange);
                            }
                            throw th;
                        }
                    }
                }

                public b w(ReservedRange reservedRange) {
                    if (reservedRange == ReservedRange.getDefaultInstance()) {
                        return this;
                    }
                    if (reservedRange.hasStart()) {
                        B(reservedRange.getStart());
                    }
                    if (reservedRange.hasEnd()) {
                        z(reservedRange.getEnd());
                    }
                    mo52mergeUnknownFields(reservedRange.unknownFields);
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
                /* renamed from: x, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(ar arVar) {
                    if (arVar instanceof ReservedRange) {
                        return w((ReservedRange) arVar);
                    }
                    super.mergeFrom(arVar);
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
                /* renamed from: y, reason: merged with bridge method [inline-methods] */
                public final b mo52mergeUnknownFields(cc ccVar) {
                    return (b) super.mo52mergeUnknownFields(ccVar);
                }

                public b z(int i3) {
                    this.f35298i |= 2;
                    this.C = i3;
                    onChanged();
                    return this;
                }

                b() {
                    maybeForceBuilderInitialization();
                }

                b(GeneratedMessageV3.c cVar) {
                    super(cVar);
                    maybeForceBuilderInitialization();
                }
            }

            public static b newBuilder(ReservedRange reservedRange) {
                return f35297d.toBuilder().w(reservedRange);
            }

            public static ReservedRange parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
                return PARSER.m(byteBuffer, tVar);
            }

            ReservedRange(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static ReservedRange parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
            }

            public static ReservedRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.b(byteString);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
            public ReservedRange getDefaultInstanceForType() {
                return f35297d;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
            public b toBuilder() {
                return this == f35297d ? new b() : new b().w(this);
            }

            public static ReservedRange parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
                return PARSER.a(byteString, tVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
            public b newBuilderForType() {
                return newBuilder();
            }

            ReservedRange() {
                this.memoizedIsInitialized = (byte) -1;
            }

            public static ReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.j(bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public b newBuilderForType(GeneratedMessageV3.c cVar) {
                return new b(cVar);
            }

            public static ReservedRange parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
                return PARSER.i(bArr, tVar);
            }

            ReservedRange(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                this();
                tVar.getClass();
                cc.b g16 = cc.g();
                boolean z16 = false;
                while (!z16) {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J == 8) {
                                    this.bitField0_ |= 1;
                                    this.start_ = kVar.x();
                                } else if (J != 16) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.end_ = kVar.x();
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        } catch (IOException e17) {
                            throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                        }
                    } finally {
                        this.unknownFields = g16.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static ReservedRange parseFrom(InputStream inputStream) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static ReservedRange parseFrom(InputStream inputStream, t tVar) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
            }

            public static ReservedRange parseFrom(com.google.protobuf.k kVar) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
            }

            public static ReservedRange parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
            }
        }

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<DescriptorProto> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public DescriptorProto g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new DescriptorProto(kVar, tVar);
            }
        }

        /* loaded from: classes2.dex */
        public interface c extends ax {
        }

        /* loaded from: classes2.dex */
        public interface d extends ax {
        }

        public static DescriptorProto getDefaultInstance() {
            return f35293d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f35271e;
        }

        public static b newBuilder() {
            return f35293d.toBuilder();
        }

        public static DescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<DescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProto descriptorProto = (DescriptorProto) obj;
            if (hasName() != descriptorProto.hasName()) {
                return false;
            }
            if ((hasName() && !getName().equals(descriptorProto.getName())) || !getFieldList().equals(descriptorProto.getFieldList()) || !getExtensionList().equals(descriptorProto.getExtensionList()) || !getNestedTypeList().equals(descriptorProto.getNestedTypeList()) || !getEnumTypeList().equals(descriptorProto.getEnumTypeList()) || !getExtensionRangeList().equals(descriptorProto.getExtensionRangeList()) || !getOneofDeclList().equals(descriptorProto.getOneofDeclList()) || hasOptions() != descriptorProto.hasOptions()) {
                return false;
            }
            if ((!hasOptions() || getOptions().equals(descriptorProto.getOptions())) && getReservedRangeList().equals(descriptorProto.getReservedRangeList()) && m46getReservedNameList().equals(descriptorProto.m46getReservedNameList()) && this.unknownFields.equals(descriptorProto.unknownFields)) {
                return true;
            }
            return false;
        }

        public EnumDescriptorProto getEnumType(int i3) {
            return this.enumType_.get(i3);
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public c getEnumTypeOrBuilder(int i3) {
            return this.enumType_.get(i3);
        }

        public List<? extends c> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        public FieldDescriptorProto getExtension(int i3) {
            return this.extension_.get(i3);
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public h getExtensionOrBuilder(int i3) {
            return this.extension_.get(i3);
        }

        public List<? extends h> getExtensionOrBuilderList() {
            return this.extension_;
        }

        public ExtensionRange getExtensionRange(int i3) {
            return this.extensionRange_.get(i3);
        }

        public int getExtensionRangeCount() {
            return this.extensionRange_.size();
        }

        public List<ExtensionRange> getExtensionRangeList() {
            return this.extensionRange_;
        }

        public c getExtensionRangeOrBuilder(int i3) {
            return this.extensionRange_.get(i3);
        }

        public List<? extends c> getExtensionRangeOrBuilderList() {
            return this.extensionRange_;
        }

        public FieldDescriptorProto getField(int i3) {
            return this.field_.get(i3);
        }

        public int getFieldCount() {
            return this.field_.size();
        }

        public List<FieldDescriptorProto> getFieldList() {
            return this.field_;
        }

        public h getFieldOrBuilder(int i3) {
            return this.field_.get(i3);
        }

        public List<? extends h> getFieldOrBuilderList() {
            return this.field_;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public DescriptorProto getNestedType(int i3) {
            return this.nestedType_.get(i3);
        }

        public int getNestedTypeCount() {
            return this.nestedType_.size();
        }

        public List<DescriptorProto> getNestedTypeList() {
            return this.nestedType_;
        }

        public b getNestedTypeOrBuilder(int i3) {
            return this.nestedType_.get(i3);
        }

        public List<? extends b> getNestedTypeOrBuilderList() {
            return this.nestedType_;
        }

        public OneofDescriptorProto getOneofDecl(int i3) {
            return this.oneofDecl_.get(i3);
        }

        public int getOneofDeclCount() {
            return this.oneofDecl_.size();
        }

        public List<OneofDescriptorProto> getOneofDeclList() {
            return this.oneofDecl_;
        }

        public n getOneofDeclOrBuilder(int i3) {
            return this.oneofDecl_.get(i3);
        }

        public List<? extends n> getOneofDeclOrBuilderList() {
            return this.oneofDecl_;
        }

        public MessageOptions getOptions() {
            MessageOptions messageOptions = this.options_;
            if (messageOptions == null) {
                return MessageOptions.getDefaultInstance();
            }
            return messageOptions;
        }

        public k getOptionsOrBuilder() {
            MessageOptions messageOptions = this.options_;
            if (messageOptions == null) {
                return MessageOptions.getDefaultInstance();
            }
            return messageOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<DescriptorProto> getParserForType() {
            return PARSER;
        }

        public String getReservedName(int i3) {
            return this.reservedName_.get(i3);
        }

        public ByteString getReservedNameBytes(int i3) {
            return this.reservedName_.getByteString(i3);
        }

        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        public ReservedRange getReservedRange(int i3) {
            return this.reservedRange_.get(i3);
        }

        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        public List<ReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public d getReservedRangeOrBuilder(int i3) {
            return this.reservedRange_.get(i3);
        }

        public List<? extends d> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.field_.size(); i17++) {
                i3 += CodedOutputStream.G(2, this.field_.get(i17));
            }
            for (int i18 = 0; i18 < this.nestedType_.size(); i18++) {
                i3 += CodedOutputStream.G(3, this.nestedType_.get(i18));
            }
            for (int i19 = 0; i19 < this.enumType_.size(); i19++) {
                i3 += CodedOutputStream.G(4, this.enumType_.get(i19));
            }
            for (int i26 = 0; i26 < this.extensionRange_.size(); i26++) {
                i3 += CodedOutputStream.G(5, this.extensionRange_.get(i26));
            }
            for (int i27 = 0; i27 < this.extension_.size(); i27++) {
                i3 += CodedOutputStream.G(6, this.extension_.get(i27));
            }
            if ((this.bitField0_ & 2) != 0) {
                i3 += CodedOutputStream.G(7, getOptions());
            }
            for (int i28 = 0; i28 < this.oneofDecl_.size(); i28++) {
                i3 += CodedOutputStream.G(8, this.oneofDecl_.get(i28));
            }
            for (int i29 = 0; i29 < this.reservedRange_.size(); i29++) {
                i3 += CodedOutputStream.G(9, this.reservedRange_.get(i29));
            }
            int i36 = 0;
            for (int i37 = 0; i37 < this.reservedName_.size(); i37++) {
                i36 += GeneratedMessageV3.computeStringSizeNoTag(this.reservedName_.c(i37));
            }
            int size = i3 + i36 + (m46getReservedNameList().size() * 1) + this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOptions() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (getFieldCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getFieldList().hashCode();
            }
            if (getExtensionCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getExtensionList().hashCode();
            }
            if (getNestedTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getNestedTypeList().hashCode();
            }
            if (getEnumTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getEnumTypeList().hashCode();
            }
            if (getExtensionRangeCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getExtensionRangeList().hashCode();
            }
            if (getOneofDeclCount() > 0) {
                hashCode = (((hashCode * 37) + 8) * 53) + getOneofDeclList().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getOptions().hashCode();
            }
            if (getReservedRangeCount() > 0) {
                hashCode = (((hashCode * 37) + 9) * 53) + getReservedRangeList().hashCode();
            }
            if (getReservedNameCount() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + m46getReservedNameList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f35272f.e(DescriptorProto.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getFieldCount(); i3++) {
                if (!getField(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i16 = 0; i16 < getExtensionCount(); i16++) {
                if (!getExtension(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i17 = 0; i17 < getNestedTypeCount(); i17++) {
                if (!getNestedType(i17).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i18 = 0; i18 < getEnumTypeCount(); i18++) {
                if (!getEnumType(i18).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i19 = 0; i19 < getExtensionRangeCount(); i19++) {
                if (!getExtensionRange(i19).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i26 = 0; i26 < getOneofDeclCount(); i26++) {
                if (!getOneofDecl(i26).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new DescriptorProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            for (int i3 = 0; i3 < this.field_.size(); i3++) {
                codedOutputStream.K0(2, this.field_.get(i3));
            }
            for (int i16 = 0; i16 < this.nestedType_.size(); i16++) {
                codedOutputStream.K0(3, this.nestedType_.get(i16));
            }
            for (int i17 = 0; i17 < this.enumType_.size(); i17++) {
                codedOutputStream.K0(4, this.enumType_.get(i17));
            }
            for (int i18 = 0; i18 < this.extensionRange_.size(); i18++) {
                codedOutputStream.K0(5, this.extensionRange_.get(i18));
            }
            for (int i19 = 0; i19 < this.extension_.size(); i19++) {
                codedOutputStream.K0(6, this.extension_.get(i19));
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.K0(7, getOptions());
            }
            for (int i26 = 0; i26 < this.oneofDecl_.size(); i26++) {
                codedOutputStream.K0(8, this.oneofDecl_.get(i26));
            }
            for (int i27 = 0; i27 < this.reservedRange_.size(); i27++) {
                codedOutputStream.K0(9, this.reservedRange_.get(i27));
            }
            for (int i28 = 0; i28 < this.reservedName_.size(); i28++) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.reservedName_.c(i28));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements b {
            private List<FieldDescriptorProto> C;
            private bp<FieldDescriptorProto, FieldDescriptorProto.b, h> D;
            private List<FieldDescriptorProto> E;
            private bp<FieldDescriptorProto, FieldDescriptorProto.b, h> F;
            private List<DescriptorProto> G;
            private bp<DescriptorProto, b, b> H;
            private List<EnumDescriptorProto> I;
            private bp<EnumDescriptorProto, EnumDescriptorProto.b, c> J;
            private List<ExtensionRange> K;
            private bp<ExtensionRange, ExtensionRange.b, c> L;
            private List<OneofDescriptorProto> M;
            private bp<OneofDescriptorProto, OneofDescriptorProto.b, n> N;
            private MessageOptions P;
            private bu<MessageOptions, MessageOptions.b, k> Q;
            private List<ReservedRange> R;
            private bp<ReservedRange, ReservedRange.b, d> S;
            private ah T;

            /* renamed from: i, reason: collision with root package name */
            private int f35300i;

            /* renamed from: m, reason: collision with root package name */
            private Object f35301m;

            private void A() {
                if ((this.f35300i & 64) == 0) {
                    this.M = new ArrayList(this.M);
                    this.f35300i |= 64;
                }
            }

            private void B() {
                if ((this.f35300i & 512) == 0) {
                    this.T = new ag(this.T);
                    this.f35300i |= 512;
                }
            }

            private void C() {
                if ((this.f35300i & 256) == 0) {
                    this.R = new ArrayList(this.R);
                    this.f35300i |= 256;
                }
            }

            private bp<EnumDescriptorProto, EnumDescriptorProto.b, c> E() {
                boolean z16;
                if (this.J == null) {
                    List<EnumDescriptorProto> list = this.I;
                    if ((this.f35300i & 16) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.J = new bp<>(list, z16, h(), isClean());
                    this.I = null;
                }
                return this.J;
            }

            private bp<FieldDescriptorProto, FieldDescriptorProto.b, h> F() {
                boolean z16;
                if (this.F == null) {
                    List<FieldDescriptorProto> list = this.E;
                    if ((this.f35300i & 4) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.F = new bp<>(list, z16, h(), isClean());
                    this.E = null;
                }
                return this.F;
            }

            private bp<ExtensionRange, ExtensionRange.b, c> G() {
                boolean z16;
                if (this.L == null) {
                    List<ExtensionRange> list = this.K;
                    if ((this.f35300i & 32) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.L = new bp<>(list, z16, h(), isClean());
                    this.K = null;
                }
                return this.L;
            }

            private bp<FieldDescriptorProto, FieldDescriptorProto.b, h> H() {
                boolean z16;
                if (this.D == null) {
                    List<FieldDescriptorProto> list = this.C;
                    if ((this.f35300i & 2) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.D = new bp<>(list, z16, h(), isClean());
                    this.C = null;
                }
                return this.D;
            }

            private bp<DescriptorProto, b, b> I() {
                boolean z16;
                if (this.H == null) {
                    List<DescriptorProto> list = this.G;
                    if ((this.f35300i & 8) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.H = new bp<>(list, z16, h(), isClean());
                    this.G = null;
                }
                return this.H;
            }

            private bp<OneofDescriptorProto, OneofDescriptorProto.b, n> J() {
                boolean z16;
                if (this.N == null) {
                    List<OneofDescriptorProto> list = this.M;
                    if ((this.f35300i & 64) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.N = new bp<>(list, z16, h(), isClean());
                    this.M = null;
                }
                return this.N;
            }

            private bu<MessageOptions, MessageOptions.b, k> L() {
                if (this.Q == null) {
                    this.Q = new bu<>(K(), h(), isClean());
                    this.P = null;
                }
                return this.Q;
            }

            private bp<ReservedRange, ReservedRange.b, d> M() {
                boolean z16;
                if (this.S == null) {
                    List<ReservedRange> list = this.R;
                    if ((this.f35300i & 256) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.S = new bp<>(list, z16, h(), isClean());
                    this.R = null;
                }
                return this.S;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    H();
                    F();
                    I();
                    E();
                    G();
                    J();
                    L();
                    M();
                }
            }

            private void v() {
                if ((this.f35300i & 16) == 0) {
                    this.I = new ArrayList(this.I);
                    this.f35300i |= 16;
                }
            }

            private void w() {
                if ((this.f35300i & 4) == 0) {
                    this.E = new ArrayList(this.E);
                    this.f35300i |= 4;
                }
            }

            private void x() {
                if ((this.f35300i & 32) == 0) {
                    this.K = new ArrayList(this.K);
                    this.f35300i |= 32;
                }
            }

            private void y() {
                if ((this.f35300i & 2) == 0) {
                    this.C = new ArrayList(this.C);
                    this.f35300i |= 2;
                }
            }

            private void z() {
                if ((this.f35300i & 8) == 0) {
                    this.G = new ArrayList(this.G);
                    this.f35300i |= 8;
                }
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public DescriptorProto getDefaultInstanceForType() {
                return DescriptorProto.getDefaultInstance();
            }

            public MessageOptions K() {
                bu<MessageOptions, MessageOptions.b, k> buVar = this.Q;
                if (buVar == null) {
                    MessageOptions messageOptions = this.P;
                    if (messageOptions == null) {
                        return MessageOptions.getDefaultInstance();
                    }
                    return messageOptions;
                }
                return buVar.f();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: N, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                DescriptorProto descriptorProto = null;
                try {
                    try {
                        DescriptorProto g16 = DescriptorProto.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            O(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (descriptorProto != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    DescriptorProto descriptorProto2 = (DescriptorProto) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        descriptorProto = descriptorProto2;
                        if (descriptorProto != null) {
                            O(descriptorProto);
                        }
                        throw th;
                    }
                }
            }

            public b O(DescriptorProto descriptorProto) {
                bp<FieldDescriptorProto, FieldDescriptorProto.b, h> bpVar;
                bp<FieldDescriptorProto, FieldDescriptorProto.b, h> bpVar2;
                bp<DescriptorProto, b, b> bpVar3;
                bp<EnumDescriptorProto, EnumDescriptorProto.b, c> bpVar4;
                bp<ExtensionRange, ExtensionRange.b, c> bpVar5;
                bp<OneofDescriptorProto, OneofDescriptorProto.b, n> bpVar6;
                if (descriptorProto == DescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (descriptorProto.hasName()) {
                    this.f35300i |= 1;
                    this.f35301m = descriptorProto.name_;
                    onChanged();
                }
                bp<ReservedRange, ReservedRange.b, d> bpVar7 = null;
                if (this.D == null) {
                    if (!descriptorProto.field_.isEmpty()) {
                        if (this.C.isEmpty()) {
                            this.C = descriptorProto.field_;
                            this.f35300i &= -3;
                        } else {
                            y();
                            this.C.addAll(descriptorProto.field_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.field_.isEmpty()) {
                    if (this.D.j()) {
                        this.D.f();
                        this.D = null;
                        this.C = descriptorProto.field_;
                        this.f35300i &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = H();
                        } else {
                            bpVar = null;
                        }
                        this.D = bpVar;
                    } else {
                        this.D.b(descriptorProto.field_);
                    }
                }
                if (this.F == null) {
                    if (!descriptorProto.extension_.isEmpty()) {
                        if (this.E.isEmpty()) {
                            this.E = descriptorProto.extension_;
                            this.f35300i &= -5;
                        } else {
                            w();
                            this.E.addAll(descriptorProto.extension_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.extension_.isEmpty()) {
                    if (this.F.j()) {
                        this.F.f();
                        this.F = null;
                        this.E = descriptorProto.extension_;
                        this.f35300i &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar2 = F();
                        } else {
                            bpVar2 = null;
                        }
                        this.F = bpVar2;
                    } else {
                        this.F.b(descriptorProto.extension_);
                    }
                }
                if (this.H == null) {
                    if (!descriptorProto.nestedType_.isEmpty()) {
                        if (this.G.isEmpty()) {
                            this.G = descriptorProto.nestedType_;
                            this.f35300i &= -9;
                        } else {
                            z();
                            this.G.addAll(descriptorProto.nestedType_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.nestedType_.isEmpty()) {
                    if (this.H.j()) {
                        this.H.f();
                        this.H = null;
                        this.G = descriptorProto.nestedType_;
                        this.f35300i &= -9;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar3 = I();
                        } else {
                            bpVar3 = null;
                        }
                        this.H = bpVar3;
                    } else {
                        this.H.b(descriptorProto.nestedType_);
                    }
                }
                if (this.J == null) {
                    if (!descriptorProto.enumType_.isEmpty()) {
                        if (this.I.isEmpty()) {
                            this.I = descriptorProto.enumType_;
                            this.f35300i &= -17;
                        } else {
                            v();
                            this.I.addAll(descriptorProto.enumType_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.enumType_.isEmpty()) {
                    if (this.J.j()) {
                        this.J.f();
                        this.J = null;
                        this.I = descriptorProto.enumType_;
                        this.f35300i &= -17;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar4 = E();
                        } else {
                            bpVar4 = null;
                        }
                        this.J = bpVar4;
                    } else {
                        this.J.b(descriptorProto.enumType_);
                    }
                }
                if (this.L == null) {
                    if (!descriptorProto.extensionRange_.isEmpty()) {
                        if (this.K.isEmpty()) {
                            this.K = descriptorProto.extensionRange_;
                            this.f35300i &= -33;
                        } else {
                            x();
                            this.K.addAll(descriptorProto.extensionRange_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.extensionRange_.isEmpty()) {
                    if (this.L.j()) {
                        this.L.f();
                        this.L = null;
                        this.K = descriptorProto.extensionRange_;
                        this.f35300i &= -33;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar5 = G();
                        } else {
                            bpVar5 = null;
                        }
                        this.L = bpVar5;
                    } else {
                        this.L.b(descriptorProto.extensionRange_);
                    }
                }
                if (this.N == null) {
                    if (!descriptorProto.oneofDecl_.isEmpty()) {
                        if (this.M.isEmpty()) {
                            this.M = descriptorProto.oneofDecl_;
                            this.f35300i &= -65;
                        } else {
                            A();
                            this.M.addAll(descriptorProto.oneofDecl_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.oneofDecl_.isEmpty()) {
                    if (this.N.j()) {
                        this.N.f();
                        this.N = null;
                        this.M = descriptorProto.oneofDecl_;
                        this.f35300i &= -65;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar6 = J();
                        } else {
                            bpVar6 = null;
                        }
                        this.N = bpVar6;
                    } else {
                        this.N.b(descriptorProto.oneofDecl_);
                    }
                }
                if (descriptorProto.hasOptions()) {
                    Q(descriptorProto.getOptions());
                }
                if (this.S == null) {
                    if (!descriptorProto.reservedRange_.isEmpty()) {
                        if (this.R.isEmpty()) {
                            this.R = descriptorProto.reservedRange_;
                            this.f35300i &= -257;
                        } else {
                            C();
                            this.R.addAll(descriptorProto.reservedRange_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.reservedRange_.isEmpty()) {
                    if (this.S.j()) {
                        this.S.f();
                        this.S = null;
                        this.R = descriptorProto.reservedRange_;
                        this.f35300i &= -257;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar7 = M();
                        }
                        this.S = bpVar7;
                    } else {
                        this.S.b(descriptorProto.reservedRange_);
                    }
                }
                if (!descriptorProto.reservedName_.isEmpty()) {
                    if (this.T.isEmpty()) {
                        this.T = descriptorProto.reservedName_;
                        this.f35300i &= -513;
                    } else {
                        B();
                        this.T.addAll(descriptorProto.reservedName_);
                    }
                    onChanged();
                }
                mo52mergeUnknownFields(descriptorProto.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: P, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof DescriptorProto) {
                    return O((DescriptorProto) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b Q(MessageOptions messageOptions) {
                MessageOptions messageOptions2;
                bu<MessageOptions, MessageOptions.b, k> buVar = this.Q;
                if (buVar == null) {
                    if ((this.f35300i & 128) != 0 && (messageOptions2 = this.P) != null && messageOptions2 != MessageOptions.getDefaultInstance()) {
                        this.P = MessageOptions.newBuilder(this.P).H(messageOptions).buildPartial();
                    } else {
                        this.P = messageOptions;
                    }
                    onChanged();
                } else {
                    buVar.g(messageOptions);
                }
                this.f35300i |= 128;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: R, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: S, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b T(String str) {
                str.getClass();
                this.f35300i |= 1;
                this.f35301m = str;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: U, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f35271e;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.f35272f.e(DescriptorProto.class, b.class);
            }

            public b n(ExtensionRange extensionRange) {
                bp<ExtensionRange, ExtensionRange.b, c> bpVar = this.L;
                if (bpVar == null) {
                    extensionRange.getClass();
                    x();
                    this.K.add(extensionRange);
                    onChanged();
                } else {
                    bpVar.c(extensionRange);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public DescriptorProto build() {
                DescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public DescriptorProto buildPartial() {
                int i3;
                DescriptorProto descriptorProto = new DescriptorProto(this);
                int i16 = this.f35300i;
                if ((i16 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                descriptorProto.name_ = this.f35301m;
                bp<FieldDescriptorProto, FieldDescriptorProto.b, h> bpVar = this.D;
                if (bpVar != null) {
                    descriptorProto.field_ = bpVar.d();
                } else {
                    if ((this.f35300i & 2) != 0) {
                        this.C = Collections.unmodifiableList(this.C);
                        this.f35300i &= -3;
                    }
                    descriptorProto.field_ = this.C;
                }
                bp<FieldDescriptorProto, FieldDescriptorProto.b, h> bpVar2 = this.F;
                if (bpVar2 != null) {
                    descriptorProto.extension_ = bpVar2.d();
                } else {
                    if ((this.f35300i & 4) != 0) {
                        this.E = Collections.unmodifiableList(this.E);
                        this.f35300i &= -5;
                    }
                    descriptorProto.extension_ = this.E;
                }
                bp<DescriptorProto, b, b> bpVar3 = this.H;
                if (bpVar3 != null) {
                    descriptorProto.nestedType_ = bpVar3.d();
                } else {
                    if ((this.f35300i & 8) != 0) {
                        this.G = Collections.unmodifiableList(this.G);
                        this.f35300i &= -9;
                    }
                    descriptorProto.nestedType_ = this.G;
                }
                bp<EnumDescriptorProto, EnumDescriptorProto.b, c> bpVar4 = this.J;
                if (bpVar4 != null) {
                    descriptorProto.enumType_ = bpVar4.d();
                } else {
                    if ((this.f35300i & 16) != 0) {
                        this.I = Collections.unmodifiableList(this.I);
                        this.f35300i &= -17;
                    }
                    descriptorProto.enumType_ = this.I;
                }
                bp<ExtensionRange, ExtensionRange.b, c> bpVar5 = this.L;
                if (bpVar5 != null) {
                    descriptorProto.extensionRange_ = bpVar5.d();
                } else {
                    if ((this.f35300i & 32) != 0) {
                        this.K = Collections.unmodifiableList(this.K);
                        this.f35300i &= -33;
                    }
                    descriptorProto.extensionRange_ = this.K;
                }
                bp<OneofDescriptorProto, OneofDescriptorProto.b, n> bpVar6 = this.N;
                if (bpVar6 != null) {
                    descriptorProto.oneofDecl_ = bpVar6.d();
                } else {
                    if ((this.f35300i & 64) != 0) {
                        this.M = Collections.unmodifiableList(this.M);
                        this.f35300i &= -65;
                    }
                    descriptorProto.oneofDecl_ = this.M;
                }
                if ((i16 & 128) != 0) {
                    bu<MessageOptions, MessageOptions.b, k> buVar = this.Q;
                    if (buVar == null) {
                        descriptorProto.options_ = this.P;
                    } else {
                        descriptorProto.options_ = buVar.b();
                    }
                    i3 |= 2;
                }
                bp<ReservedRange, ReservedRange.b, d> bpVar7 = this.S;
                if (bpVar7 != null) {
                    descriptorProto.reservedRange_ = bpVar7.d();
                } else {
                    if ((this.f35300i & 256) != 0) {
                        this.R = Collections.unmodifiableList(this.R);
                        this.f35300i &= -257;
                    }
                    descriptorProto.reservedRange_ = this.R;
                }
                if ((this.f35300i & 512) != 0) {
                    this.T = this.T.getUnmodifiableView();
                    this.f35300i &= -513;
                }
                descriptorProto.reservedName_ = this.T;
                descriptorProto.bitField0_ = i3;
                onBuilt();
                return descriptorProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f35301m = "";
                this.f35300i &= -2;
                bp<FieldDescriptorProto, FieldDescriptorProto.b, h> bpVar = this.D;
                if (bpVar == null) {
                    this.C = Collections.emptyList();
                    this.f35300i &= -3;
                } else {
                    bpVar.e();
                }
                bp<FieldDescriptorProto, FieldDescriptorProto.b, h> bpVar2 = this.F;
                if (bpVar2 == null) {
                    this.E = Collections.emptyList();
                    this.f35300i &= -5;
                } else {
                    bpVar2.e();
                }
                bp<DescriptorProto, b, b> bpVar3 = this.H;
                if (bpVar3 == null) {
                    this.G = Collections.emptyList();
                    this.f35300i &= -9;
                } else {
                    bpVar3.e();
                }
                bp<EnumDescriptorProto, EnumDescriptorProto.b, c> bpVar4 = this.J;
                if (bpVar4 == null) {
                    this.I = Collections.emptyList();
                    this.f35300i &= -17;
                } else {
                    bpVar4.e();
                }
                bp<ExtensionRange, ExtensionRange.b, c> bpVar5 = this.L;
                if (bpVar5 == null) {
                    this.K = Collections.emptyList();
                    this.f35300i &= -33;
                } else {
                    bpVar5.e();
                }
                bp<OneofDescriptorProto, OneofDescriptorProto.b, n> bpVar6 = this.N;
                if (bpVar6 == null) {
                    this.M = Collections.emptyList();
                    this.f35300i &= -65;
                } else {
                    bpVar6.e();
                }
                bu<MessageOptions, MessageOptions.b, k> buVar = this.Q;
                if (buVar == null) {
                    this.P = null;
                } else {
                    buVar.c();
                }
                this.f35300i &= -129;
                bp<ReservedRange, ReservedRange.b, d> bpVar7 = this.S;
                if (bpVar7 == null) {
                    this.R = Collections.emptyList();
                    this.f35300i &= -257;
                } else {
                    bpVar7.e();
                }
                this.T = ag.f35656h;
                this.f35300i &= -513;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            b() {
                this.f35301m = "";
                this.C = Collections.emptyList();
                this.E = Collections.emptyList();
                this.G = Collections.emptyList();
                this.I = Collections.emptyList();
                this.K = Collections.emptyList();
                this.M = Collections.emptyList();
                this.R = Collections.emptyList();
                this.T = ag.f35656h;
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f35301m = "";
                this.C = Collections.emptyList();
                this.E = Collections.emptyList();
                this.G = Collections.emptyList();
                this.I = Collections.emptyList();
                this.K = Collections.emptyList();
                this.M = Collections.emptyList();
                this.R = Collections.emptyList();
                this.T = ag.f35656h;
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(DescriptorProto descriptorProto) {
            return f35293d.toBuilder().O(descriptorProto);
        }

        public static DescriptorProto parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        /* renamed from: getReservedNameList, reason: merged with bridge method [inline-methods] */
        public bl m46getReservedNameList() {
            return this.reservedName_;
        }

        DescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DescriptorProto parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static DescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public DescriptorProto getDefaultInstanceForType() {
            return f35293d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35293d ? new b() : new b().O(this);
        }

        public static DescriptorProto parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        DescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.field_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.nestedType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.extensionRange_ = Collections.emptyList();
            this.oneofDecl_ = Collections.emptyList();
            this.reservedRange_ = Collections.emptyList();
            this.reservedName_ = ag.f35656h;
        }

        public static DescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static DescriptorProto parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static DescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DescriptorProto parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static DescriptorProto parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static DescriptorProto parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0013. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        DescriptorProto(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        switch (J) {
                            case 0:
                                z16 = true;
                            case 10:
                                ByteString q16 = kVar.q();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.name_ = q16;
                            case 18:
                                if ((i3 & 2) == 0) {
                                    this.field_ = new ArrayList();
                                    i3 |= 2;
                                }
                                this.field_.add(kVar.z(FieldDescriptorProto.PARSER, tVar));
                            case 26:
                                if ((i3 & 8) == 0) {
                                    this.nestedType_ = new ArrayList();
                                    i3 |= 8;
                                }
                                this.nestedType_.add(kVar.z(PARSER, tVar));
                            case 34:
                                if ((i3 & 16) == 0) {
                                    this.enumType_ = new ArrayList();
                                    i3 |= 16;
                                }
                                this.enumType_.add(kVar.z(EnumDescriptorProto.PARSER, tVar));
                            case 42:
                                if ((i3 & 32) == 0) {
                                    this.extensionRange_ = new ArrayList();
                                    i3 |= 32;
                                }
                                this.extensionRange_.add(kVar.z(ExtensionRange.PARSER, tVar));
                            case 50:
                                if ((i3 & 4) == 0) {
                                    this.extension_ = new ArrayList();
                                    i3 |= 4;
                                }
                                this.extension_.add(kVar.z(FieldDescriptorProto.PARSER, tVar));
                            case 58:
                                MessageOptions.b builder = (this.bitField0_ & 2) != 0 ? this.options_.toBuilder() : null;
                                MessageOptions messageOptions = (MessageOptions) kVar.z(MessageOptions.PARSER, tVar);
                                this.options_ = messageOptions;
                                if (builder != null) {
                                    builder.H(messageOptions);
                                    this.options_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            case 66:
                                if ((i3 & 64) == 0) {
                                    this.oneofDecl_ = new ArrayList();
                                    i3 |= 64;
                                }
                                this.oneofDecl_.add(kVar.z(OneofDescriptorProto.PARSER, tVar));
                            case 74:
                                if ((i3 & 256) == 0) {
                                    this.reservedRange_ = new ArrayList();
                                    i3 |= 256;
                                }
                                this.reservedRange_.add(kVar.z(ReservedRange.PARSER, tVar));
                            case 82:
                                ByteString q17 = kVar.q();
                                if ((i3 & 512) == 0) {
                                    this.reservedName_ = new ag();
                                    i3 |= 512;
                                }
                                this.reservedName_.f(q17);
                            default:
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    z16 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i3 & 2) != 0) {
                        this.field_ = Collections.unmodifiableList(this.field_);
                    }
                    if ((i3 & 8) != 0) {
                        this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
                    }
                    if ((i3 & 16) != 0) {
                        this.enumType_ = Collections.unmodifiableList(this.enumType_);
                    }
                    if ((i3 & 32) != 0) {
                        this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
                    }
                    if ((i3 & 4) != 0) {
                        this.extension_ = Collections.unmodifiableList(this.extension_);
                    }
                    if ((i3 & 64) != 0) {
                        this.oneofDecl_ = Collections.unmodifiableList(this.oneofDecl_);
                    }
                    if ((i3 & 256) != 0) {
                        this.reservedRange_ = Collections.unmodifiableList(this.reservedRange_);
                    }
                    if ((i3 & 512) != 0) {
                        this.reservedName_ = this.reservedName_.getUnmodifiableView();
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class EnumDescriptorProto extends GeneratedMessageV3 implements c {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        public static final int RESERVED_NAME_FIELD_NUMBER = 5;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private EnumOptions options_;
        private ah reservedName_;
        private List<EnumReservedRange> reservedRange_;
        private List<EnumValueDescriptorProto> value_;

        /* renamed from: d, reason: collision with root package name */
        private static final EnumDescriptorProto f35302d = new EnumDescriptorProto();

        @Deprecated
        public static final bg<EnumDescriptorProto> PARSER = new a();

        /* loaded from: classes2.dex */
        public static final class EnumReservedRange extends GeneratedMessageV3 implements c {
            public static final int END_FIELD_NUMBER = 2;
            public static final int START_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized;
            private int start_;

            /* renamed from: d, reason: collision with root package name */
            private static final EnumReservedRange f35303d = new EnumReservedRange();

            @Deprecated
            public static final bg<EnumReservedRange> PARSER = new a();

            /* loaded from: classes2.dex */
            static class a extends com.google.protobuf.c<EnumReservedRange> {
                a() {
                }

                @Override // com.google.protobuf.bg
                /* renamed from: G, reason: merged with bridge method [inline-methods] */
                public EnumReservedRange g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                    return new EnumReservedRange(kVar, tVar);
                }
            }

            public static EnumReservedRange getDefaultInstance() {
                return f35303d;
            }

            public static final Descriptors.b getDescriptor() {
                return DescriptorProtos.f35285s;
            }

            public static b newBuilder() {
                return f35303d.toBuilder();
            }

            public static EnumReservedRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (EnumReservedRange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static EnumReservedRange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.d(byteBuffer);
            }

            public static bg<EnumReservedRange> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof EnumReservedRange)) {
                    return super.equals(obj);
                }
                EnumReservedRange enumReservedRange = (EnumReservedRange) obj;
                if (hasStart() != enumReservedRange.hasStart()) {
                    return false;
                }
                if ((hasStart() && getStart() != enumReservedRange.getStart()) || hasEnd() != enumReservedRange.hasEnd()) {
                    return false;
                }
                if ((!hasEnd() || getEnd() == enumReservedRange.getEnd()) && this.unknownFields.equals(enumReservedRange.unknownFields)) {
                    return true;
                }
                return false;
            }

            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
            public bg<EnumReservedRange> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
            public int getSerializedSize() {
                int i3 = this.memoizedSize;
                if (i3 != -1) {
                    return i3;
                }
                int i16 = 0;
                if ((this.bitField0_ & 1) != 0) {
                    i16 = 0 + CodedOutputStream.x(1, this.start_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    i16 += CodedOutputStream.x(2, this.end_);
                }
                int serializedSize = i16 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
            public final cc getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasEnd() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            public boolean hasStart() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i3 = this.memoizedHashCode;
                if (i3 != 0) {
                    return i3;
                }
                int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
                if (hasStart()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getStart();
                }
                if (hasEnd()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getEnd();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f35286t.e(EnumReservedRange.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
            public final boolean isInitialized() {
                byte b16 = this.memoizedIsInitialized;
                if (b16 == 1) {
                    return true;
                }
                if (b16 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.f fVar) {
                return new EnumReservedRange();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) != 0) {
                    codedOutputStream.G0(1, this.start_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    codedOutputStream.G0(2, this.end_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* loaded from: classes2.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements c {
                private int C;

                /* renamed from: i, reason: collision with root package name */
                private int f35304i;

                /* renamed from: m, reason: collision with root package name */
                private int f35305m;

                private void maybeForceBuilderInitialization() {
                    boolean z16 = GeneratedMessageV3.alwaysUseFieldBuilders;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
                /* renamed from: A, reason: merged with bridge method [inline-methods] */
                public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.setField(fieldDescriptor, obj);
                }

                public b B(int i3) {
                    this.f35304i |= 1;
                    this.f35305m = i3;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
                /* renamed from: C, reason: merged with bridge method [inline-methods] */
                public final b setUnknownFields(cc ccVar) {
                    return (b) super.setUnknownFields(ccVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
                public Descriptors.b getDescriptorForType() {
                    return DescriptorProtos.f35285s;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e i() {
                    return DescriptorProtos.f35286t.e(EnumReservedRange.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
                /* renamed from: o, reason: merged with bridge method [inline-methods] */
                public EnumReservedRange build() {
                    EnumReservedRange buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
                }

                @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public EnumReservedRange buildPartial() {
                    int i3;
                    EnumReservedRange enumReservedRange = new EnumReservedRange(this);
                    int i16 = this.f35304i;
                    if ((i16 & 1) != 0) {
                        enumReservedRange.start_ = this.f35305m;
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if ((i16 & 2) != 0) {
                        enumReservedRange.end_ = this.C;
                        i3 |= 2;
                    }
                    enumReservedRange.bitField0_ = i3;
                    onBuilt();
                    return enumReservedRange;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
                /* renamed from: q, reason: merged with bridge method [inline-methods] */
                public b clear() {
                    super.clear();
                    this.f35305m = 0;
                    int i3 = this.f35304i & (-2);
                    this.C = 0;
                    this.f35304i = i3 & (-3);
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (b) super.clearField(fieldDescriptor);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: s, reason: merged with bridge method [inline-methods] */
                public b clearOneof(Descriptors.g gVar) {
                    return (b) super.clearOneof(gVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: t, reason: merged with bridge method [inline-methods] */
                public b mo50clone() {
                    return (b) super.mo50clone();
                }

                @Override // com.google.protobuf.av, com.google.protobuf.ax
                /* renamed from: u, reason: merged with bridge method [inline-methods] */
                public EnumReservedRange getDefaultInstanceForType() {
                    return EnumReservedRange.getDefaultInstance();
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
                /* renamed from: v, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                    EnumReservedRange enumReservedRange = null;
                    try {
                        try {
                            EnumReservedRange g16 = EnumReservedRange.PARSER.g(kVar, tVar);
                            if (g16 != null) {
                                w(g16);
                            }
                            return this;
                        } catch (Throwable th5) {
                            th = th5;
                            if (enumReservedRange != null) {
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        EnumReservedRange enumReservedRange2 = (EnumReservedRange) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th6) {
                            th = th6;
                            enumReservedRange = enumReservedRange2;
                            if (enumReservedRange != null) {
                                w(enumReservedRange);
                            }
                            throw th;
                        }
                    }
                }

                public b w(EnumReservedRange enumReservedRange) {
                    if (enumReservedRange == EnumReservedRange.getDefaultInstance()) {
                        return this;
                    }
                    if (enumReservedRange.hasStart()) {
                        B(enumReservedRange.getStart());
                    }
                    if (enumReservedRange.hasEnd()) {
                        z(enumReservedRange.getEnd());
                    }
                    mo52mergeUnknownFields(enumReservedRange.unknownFields);
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
                /* renamed from: x, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(ar arVar) {
                    if (arVar instanceof EnumReservedRange) {
                        return w((EnumReservedRange) arVar);
                    }
                    super.mergeFrom(arVar);
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
                /* renamed from: y, reason: merged with bridge method [inline-methods] */
                public final b mo52mergeUnknownFields(cc ccVar) {
                    return (b) super.mo52mergeUnknownFields(ccVar);
                }

                public b z(int i3) {
                    this.f35304i |= 2;
                    this.C = i3;
                    onChanged();
                    return this;
                }

                b() {
                    maybeForceBuilderInitialization();
                }

                b(GeneratedMessageV3.c cVar) {
                    super(cVar);
                    maybeForceBuilderInitialization();
                }
            }

            public static b newBuilder(EnumReservedRange enumReservedRange) {
                return f35303d.toBuilder().w(enumReservedRange);
            }

            public static EnumReservedRange parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
                return PARSER.m(byteBuffer, tVar);
            }

            EnumReservedRange(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static EnumReservedRange parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
                return (EnumReservedRange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
            }

            public static EnumReservedRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.b(byteString);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
            public EnumReservedRange getDefaultInstanceForType() {
                return f35303d;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
            public b toBuilder() {
                return this == f35303d ? new b() : new b().w(this);
            }

            public static EnumReservedRange parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
                return PARSER.a(byteString, tVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
            public b newBuilderForType() {
                return newBuilder();
            }

            EnumReservedRange() {
                this.memoizedIsInitialized = (byte) -1;
            }

            public static EnumReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.j(bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public b newBuilderForType(GeneratedMessageV3.c cVar) {
                return new b(cVar);
            }

            public static EnumReservedRange parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
                return PARSER.i(bArr, tVar);
            }

            EnumReservedRange(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                this();
                tVar.getClass();
                cc.b g16 = cc.g();
                boolean z16 = false;
                while (!z16) {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J == 8) {
                                    this.bitField0_ |= 1;
                                    this.start_ = kVar.x();
                                } else if (J != 16) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.end_ = kVar.x();
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        } catch (IOException e17) {
                            throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                        }
                    } finally {
                        this.unknownFields = g16.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static EnumReservedRange parseFrom(InputStream inputStream) throws IOException {
                return (EnumReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static EnumReservedRange parseFrom(InputStream inputStream, t tVar) throws IOException {
                return (EnumReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
            }

            public static EnumReservedRange parseFrom(com.google.protobuf.k kVar) throws IOException {
                return (EnumReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
            }

            public static EnumReservedRange parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                return (EnumReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
            }
        }

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<EnumDescriptorProto> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public EnumDescriptorProto g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new EnumDescriptorProto(kVar, tVar);
            }
        }

        /* loaded from: classes2.dex */
        public interface c extends ax {
        }

        public static EnumDescriptorProto getDefaultInstance() {
            return f35302d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f35283q;
        }

        public static b newBuilder() {
            return f35302d.toBuilder();
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EnumDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<EnumDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumDescriptorProto)) {
                return super.equals(obj);
            }
            EnumDescriptorProto enumDescriptorProto = (EnumDescriptorProto) obj;
            if (hasName() != enumDescriptorProto.hasName()) {
                return false;
            }
            if ((hasName() && !getName().equals(enumDescriptorProto.getName())) || !getValueList().equals(enumDescriptorProto.getValueList()) || hasOptions() != enumDescriptorProto.hasOptions()) {
                return false;
            }
            if ((!hasOptions() || getOptions().equals(enumDescriptorProto.getOptions())) && getReservedRangeList().equals(enumDescriptorProto.getReservedRangeList()) && m53getReservedNameList().equals(enumDescriptorProto.m53getReservedNameList()) && this.unknownFields.equals(enumDescriptorProto.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public EnumOptions getOptions() {
            EnumOptions enumOptions = this.options_;
            if (enumOptions == null) {
                return EnumOptions.getDefaultInstance();
            }
            return enumOptions;
        }

        public d getOptionsOrBuilder() {
            EnumOptions enumOptions = this.options_;
            if (enumOptions == null) {
                return EnumOptions.getDefaultInstance();
            }
            return enumOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<EnumDescriptorProto> getParserForType() {
            return PARSER;
        }

        public String getReservedName(int i3) {
            return this.reservedName_.get(i3);
        }

        public ByteString getReservedNameBytes(int i3) {
            return this.reservedName_.getByteString(i3);
        }

        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        public EnumReservedRange getReservedRange(int i3) {
            return this.reservedRange_.get(i3);
        }

        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        public List<EnumReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public c getReservedRangeOrBuilder(int i3) {
            return this.reservedRange_.get(i3);
        }

        public List<? extends c> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.value_.size(); i17++) {
                i3 += CodedOutputStream.G(2, this.value_.get(i17));
            }
            if ((this.bitField0_ & 2) != 0) {
                i3 += CodedOutputStream.G(3, getOptions());
            }
            for (int i18 = 0; i18 < this.reservedRange_.size(); i18++) {
                i3 += CodedOutputStream.G(4, this.reservedRange_.get(i18));
            }
            int i19 = 0;
            for (int i26 = 0; i26 < this.reservedName_.size(); i26++) {
                i19 += GeneratedMessageV3.computeStringSizeNoTag(this.reservedName_.c(i26));
            }
            int size = i3 + i19 + (m53getReservedNameList().size() * 1) + this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public EnumValueDescriptorProto getValue(int i3) {
            return this.value_.get(i3);
        }

        public int getValueCount() {
            return this.value_.size();
        }

        public List<EnumValueDescriptorProto> getValueList() {
            return this.value_;
        }

        public e getValueOrBuilder(int i3) {
            return this.value_.get(i3);
        }

        public List<? extends e> getValueOrBuilderList() {
            return this.value_;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOptions() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (getValueCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getValueList().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getOptions().hashCode();
            }
            if (getReservedRangeCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getReservedRangeList().hashCode();
            }
            if (getReservedNameCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + m53getReservedNameList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f35284r.e(EnumDescriptorProto.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getValueCount(); i3++) {
                if (!getValue(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new EnumDescriptorProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            for (int i3 = 0; i3 < this.value_.size(); i3++) {
                codedOutputStream.K0(2, this.value_.get(i3));
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.K0(3, getOptions());
            }
            for (int i16 = 0; i16 < this.reservedRange_.size(); i16++) {
                codedOutputStream.K0(4, this.reservedRange_.get(i16));
            }
            for (int i17 = 0; i17 < this.reservedName_.size(); i17++) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.reservedName_.c(i17));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {
            private List<EnumValueDescriptorProto> C;
            private bp<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> D;
            private EnumOptions E;
            private bu<EnumOptions, EnumOptions.b, d> F;
            private List<EnumReservedRange> G;
            private bp<EnumReservedRange, EnumReservedRange.b, c> H;
            private ah I;

            /* renamed from: i, reason: collision with root package name */
            private int f35306i;

            /* renamed from: m, reason: collision with root package name */
            private Object f35307m;

            private bp<EnumReservedRange, EnumReservedRange.b, c> A() {
                boolean z16;
                if (this.H == null) {
                    List<EnumReservedRange> list = this.G;
                    if ((this.f35306i & 8) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.H = new bp<>(list, z16, h(), isClean());
                    this.G = null;
                }
                return this.H;
            }

            private bp<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> B() {
                boolean z16;
                if (this.D == null) {
                    List<EnumValueDescriptorProto> list = this.C;
                    if ((this.f35306i & 2) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.D = new bp<>(list, z16, h(), isClean());
                    this.C = null;
                }
                return this.D;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    B();
                    z();
                    A();
                }
            }

            private void u() {
                if ((this.f35306i & 16) == 0) {
                    this.I = new ag(this.I);
                    this.f35306i |= 16;
                }
            }

            private void v() {
                if ((this.f35306i & 8) == 0) {
                    this.G = new ArrayList(this.G);
                    this.f35306i |= 8;
                }
            }

            private void w() {
                if ((this.f35306i & 2) == 0) {
                    this.C = new ArrayList(this.C);
                    this.f35306i |= 2;
                }
            }

            private bu<EnumOptions, EnumOptions.b, d> z() {
                if (this.F == null) {
                    this.F = new bu<>(y(), h(), isClean());
                    this.E = null;
                }
                return this.F;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                EnumDescriptorProto enumDescriptorProto = null;
                try {
                    try {
                        EnumDescriptorProto g16 = EnumDescriptorProto.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            D(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (enumDescriptorProto != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    EnumDescriptorProto enumDescriptorProto2 = (EnumDescriptorProto) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        enumDescriptorProto = enumDescriptorProto2;
                        if (enumDescriptorProto != null) {
                            D(enumDescriptorProto);
                        }
                        throw th;
                    }
                }
            }

            public b D(EnumDescriptorProto enumDescriptorProto) {
                bp<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> bpVar;
                if (enumDescriptorProto == EnumDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (enumDescriptorProto.hasName()) {
                    this.f35306i |= 1;
                    this.f35307m = enumDescriptorProto.name_;
                    onChanged();
                }
                bp<EnumReservedRange, EnumReservedRange.b, c> bpVar2 = null;
                if (this.D == null) {
                    if (!enumDescriptorProto.value_.isEmpty()) {
                        if (this.C.isEmpty()) {
                            this.C = enumDescriptorProto.value_;
                            this.f35306i &= -3;
                        } else {
                            w();
                            this.C.addAll(enumDescriptorProto.value_);
                        }
                        onChanged();
                    }
                } else if (!enumDescriptorProto.value_.isEmpty()) {
                    if (this.D.j()) {
                        this.D.f();
                        this.D = null;
                        this.C = enumDescriptorProto.value_;
                        this.f35306i &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = B();
                        } else {
                            bpVar = null;
                        }
                        this.D = bpVar;
                    } else {
                        this.D.b(enumDescriptorProto.value_);
                    }
                }
                if (enumDescriptorProto.hasOptions()) {
                    F(enumDescriptorProto.getOptions());
                }
                if (this.H == null) {
                    if (!enumDescriptorProto.reservedRange_.isEmpty()) {
                        if (this.G.isEmpty()) {
                            this.G = enumDescriptorProto.reservedRange_;
                            this.f35306i &= -9;
                        } else {
                            v();
                            this.G.addAll(enumDescriptorProto.reservedRange_);
                        }
                        onChanged();
                    }
                } else if (!enumDescriptorProto.reservedRange_.isEmpty()) {
                    if (this.H.j()) {
                        this.H.f();
                        this.H = null;
                        this.G = enumDescriptorProto.reservedRange_;
                        this.f35306i &= -9;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar2 = A();
                        }
                        this.H = bpVar2;
                    } else {
                        this.H.b(enumDescriptorProto.reservedRange_);
                    }
                }
                if (!enumDescriptorProto.reservedName_.isEmpty()) {
                    if (this.I.isEmpty()) {
                        this.I = enumDescriptorProto.reservedName_;
                        this.f35306i &= -17;
                    } else {
                        u();
                        this.I.addAll(enumDescriptorProto.reservedName_);
                    }
                    onChanged();
                }
                mo52mergeUnknownFields(enumDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof EnumDescriptorProto) {
                    return D((EnumDescriptorProto) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b F(EnumOptions enumOptions) {
                EnumOptions enumOptions2;
                bu<EnumOptions, EnumOptions.b, d> buVar = this.F;
                if (buVar == null) {
                    if ((this.f35306i & 4) != 0 && (enumOptions2 = this.E) != null && enumOptions2 != EnumOptions.getDefaultInstance()) {
                        this.E = EnumOptions.newBuilder(this.E).H(enumOptions).buildPartial();
                    } else {
                        this.E = enumOptions;
                    }
                    onChanged();
                } else {
                    buVar.g(enumOptions);
                }
                this.f35306i |= 4;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: H, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f35283q;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.f35284r.e(EnumDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public EnumDescriptorProto build() {
                EnumDescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public EnumDescriptorProto buildPartial() {
                int i3;
                EnumDescriptorProto enumDescriptorProto = new EnumDescriptorProto(this);
                int i16 = this.f35306i;
                if ((i16 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                enumDescriptorProto.name_ = this.f35307m;
                bp<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> bpVar = this.D;
                if (bpVar != null) {
                    enumDescriptorProto.value_ = bpVar.d();
                } else {
                    if ((this.f35306i & 2) != 0) {
                        this.C = Collections.unmodifiableList(this.C);
                        this.f35306i &= -3;
                    }
                    enumDescriptorProto.value_ = this.C;
                }
                if ((i16 & 4) != 0) {
                    bu<EnumOptions, EnumOptions.b, d> buVar = this.F;
                    if (buVar == null) {
                        enumDescriptorProto.options_ = this.E;
                    } else {
                        enumDescriptorProto.options_ = buVar.b();
                    }
                    i3 |= 2;
                }
                bp<EnumReservedRange, EnumReservedRange.b, c> bpVar2 = this.H;
                if (bpVar2 != null) {
                    enumDescriptorProto.reservedRange_ = bpVar2.d();
                } else {
                    if ((this.f35306i & 8) != 0) {
                        this.G = Collections.unmodifiableList(this.G);
                        this.f35306i &= -9;
                    }
                    enumDescriptorProto.reservedRange_ = this.G;
                }
                if ((this.f35306i & 16) != 0) {
                    this.I = this.I.getUnmodifiableView();
                    this.f35306i &= -17;
                }
                enumDescriptorProto.reservedName_ = this.I;
                enumDescriptorProto.bitField0_ = i3;
                onBuilt();
                return enumDescriptorProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f35307m = "";
                this.f35306i &= -2;
                bp<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> bpVar = this.D;
                if (bpVar == null) {
                    this.C = Collections.emptyList();
                    this.f35306i &= -3;
                } else {
                    bpVar.e();
                }
                bu<EnumOptions, EnumOptions.b, d> buVar = this.F;
                if (buVar == null) {
                    this.E = null;
                } else {
                    buVar.c();
                }
                this.f35306i &= -5;
                bp<EnumReservedRange, EnumReservedRange.b, c> bpVar2 = this.H;
                if (bpVar2 == null) {
                    this.G = Collections.emptyList();
                    this.f35306i &= -9;
                } else {
                    bpVar2.e();
                }
                this.I = ag.f35656h;
                this.f35306i &= -17;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public EnumDescriptorProto getDefaultInstanceForType() {
                return EnumDescriptorProto.getDefaultInstance();
            }

            public EnumOptions y() {
                bu<EnumOptions, EnumOptions.b, d> buVar = this.F;
                if (buVar == null) {
                    EnumOptions enumOptions = this.E;
                    if (enumOptions == null) {
                        return EnumOptions.getDefaultInstance();
                    }
                    return enumOptions;
                }
                return buVar.f();
            }

            b() {
                this.f35307m = "";
                this.C = Collections.emptyList();
                this.G = Collections.emptyList();
                this.I = ag.f35656h;
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f35307m = "";
                this.C = Collections.emptyList();
                this.G = Collections.emptyList();
                this.I = ag.f35656h;
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(EnumDescriptorProto enumDescriptorProto) {
            return f35302d.toBuilder().D(enumDescriptorProto);
        }

        public static EnumDescriptorProto parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        /* renamed from: getReservedNameList, reason: merged with bridge method [inline-methods] */
        public bl m53getReservedNameList() {
            return this.reservedName_;
        }

        EnumDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static EnumDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public EnumDescriptorProto getDefaultInstanceForType() {
            return f35302d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35302d ? new b() : new b().D(this);
        }

        public static EnumDescriptorProto parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        EnumDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.value_ = Collections.emptyList();
            this.reservedRange_ = Collections.emptyList();
            this.reservedName_ = ag.f35656h;
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static EnumDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static EnumDescriptorProto parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        EnumDescriptorProto(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 10) {
                                ByteString q16 = kVar.q();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.name_ = q16;
                            } else if (J == 18) {
                                if ((i3 & 2) == 0) {
                                    this.value_ = new ArrayList();
                                    i3 |= 2;
                                }
                                this.value_.add(kVar.z(EnumValueDescriptorProto.PARSER, tVar));
                            } else if (J == 26) {
                                EnumOptions.b builder = (this.bitField0_ & 2) != 0 ? this.options_.toBuilder() : null;
                                EnumOptions enumOptions = (EnumOptions) kVar.z(EnumOptions.PARSER, tVar);
                                this.options_ = enumOptions;
                                if (builder != null) {
                                    builder.H(enumOptions);
                                    this.options_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (J == 34) {
                                if ((i3 & 8) == 0) {
                                    this.reservedRange_ = new ArrayList();
                                    i3 |= 8;
                                }
                                this.reservedRange_.add(kVar.z(EnumReservedRange.PARSER, tVar));
                            } else if (J != 42) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                ByteString q17 = kVar.q();
                                if ((i3 & 16) == 0) {
                                    this.reservedName_ = new ag();
                                    i3 |= 16;
                                }
                                this.reservedName_.f(q17);
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i3 & 2) != 0) {
                        this.value_ = Collections.unmodifiableList(this.value_);
                    }
                    if ((i3 & 8) != 0) {
                        this.reservedRange_ = Collections.unmodifiableList(this.reservedRange_);
                    }
                    if ((i3 & 16) != 0) {
                        this.reservedName_ = this.reservedName_.getUnmodifiableView();
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static EnumDescriptorProto parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static EnumDescriptorProto parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class EnumOptions extends GeneratedMessageV3.ExtendableMessage<EnumOptions> implements d {
        public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private boolean allowAlias_;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;

        /* renamed from: d, reason: collision with root package name */
        private static final EnumOptions f35308d = new EnumOptions();

        @Deprecated
        public static final bg<EnumOptions> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<EnumOptions> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public EnumOptions g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new EnumOptions(kVar, tVar);
            }
        }

        public static EnumOptions getDefaultInstance() {
            return f35308d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.I;
        }

        public static b newBuilder() {
            return f35308d.toBuilder();
        }

        public static EnumOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EnumOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<EnumOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumOptions)) {
                return super.equals(obj);
            }
            EnumOptions enumOptions = (EnumOptions) obj;
            if (hasAllowAlias() != enumOptions.hasAllowAlias()) {
                return false;
            }
            if ((hasAllowAlias() && getAllowAlias() != enumOptions.getAllowAlias()) || hasDeprecated() != enumOptions.hasDeprecated()) {
                return false;
            }
            if ((!hasDeprecated() || getDeprecated() == enumOptions.getDeprecated()) && getUninterpretedOptionList().equals(enumOptions.getUninterpretedOptionList()) && this.unknownFields.equals(enumOptions.unknownFields) && getExtensionFields().equals(enumOptions.getExtensionFields())) {
                return true;
            }
            return false;
        }

        public boolean getAllowAlias() {
            return this.allowAlias_;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<EnumOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = CodedOutputStream.e(2, this.allowAlias_) + 0;
            } else {
                i3 = 0;
            }
            if ((2 & this.bitField0_) != 0) {
                i3 += CodedOutputStream.e(3, this.deprecated_);
            }
            for (int i17 = 0; i17 < this.uninterpretedOption_.size(); i17++) {
                i3 += CodedOutputStream.G(999, this.uninterpretedOption_.get(i17));
            }
            int extensionsSerializedSize = i3 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public UninterpretedOption getUninterpretedOption(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasAllowAlias() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasDeprecated() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasAllowAlias()) {
                hashCode = (((hashCode * 37) + 2) * 53) + ad.c(getAllowAlias());
            }
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 3) * 53) + ad.c(getDeprecated());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, getExtensionFields()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.J.e(EnumOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getUninterpretedOptionCount(); i3++) {
                if (!getUninterpretedOption(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new EnumOptions();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.m0(2, this.allowAlias_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.m0(3, this.deprecated_);
            }
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                codedOutputStream.K0(999, this.uninterpretedOption_.get(i3));
            }
            newExtensionWriter.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.d<EnumOptions, b> implements d {
            private boolean C;
            private boolean D;
            private List<UninterpretedOption> E;
            private bp<UninterpretedOption, UninterpretedOption.b, s> F;

            /* renamed from: m, reason: collision with root package name */
            private int f35309m;

            private void D() {
                if ((this.f35309m & 4) == 0) {
                    this.E = new ArrayList(this.E);
                    this.f35309m |= 4;
                }
            }

            private bp<UninterpretedOption, UninterpretedOption.b, s> F() {
                boolean z16;
                if (this.F == null) {
                    List<UninterpretedOption> list = this.E;
                    if ((this.f35309m & 4) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.F = new bp<>(list, z16, h(), isClean());
                    this.E = null;
                }
                return this.F;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    F();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public EnumOptions getDefaultInstanceForType() {
                return EnumOptions.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                EnumOptions enumOptions = null;
                try {
                    try {
                        EnumOptions g16 = EnumOptions.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            H(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (enumOptions != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    EnumOptions enumOptions2 = (EnumOptions) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        enumOptions = enumOptions2;
                        if (enumOptions != null) {
                            H(enumOptions);
                        }
                        throw th;
                    }
                }
            }

            public b H(EnumOptions enumOptions) {
                if (enumOptions == EnumOptions.getDefaultInstance()) {
                    return this;
                }
                if (enumOptions.hasAllowAlias()) {
                    K(enumOptions.getAllowAlias());
                }
                if (enumOptions.hasDeprecated()) {
                    L(enumOptions.getDeprecated());
                }
                if (this.F == null) {
                    if (!enumOptions.uninterpretedOption_.isEmpty()) {
                        if (this.E.isEmpty()) {
                            this.E = enumOptions.uninterpretedOption_;
                            this.f35309m &= -5;
                        } else {
                            D();
                            this.E.addAll(enumOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!enumOptions.uninterpretedOption_.isEmpty()) {
                    if (this.F.j()) {
                        this.F.f();
                        bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = null;
                        this.F = null;
                        this.E = enumOptions.uninterpretedOption_;
                        this.f35309m &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = F();
                        }
                        this.F = bpVar;
                    } else {
                        this.F.b(enumOptions.uninterpretedOption_);
                    }
                }
                t(enumOptions);
                mo52mergeUnknownFields(enumOptions.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof EnumOptions) {
                    return H((EnumOptions) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b K(boolean z16) {
                this.f35309m |= 1;
                this.C = z16;
                onChanged();
                return this;
            }

            public b L(boolean z16) {
                this.f35309m |= 2;
                this.D = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: M, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: N, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.I;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.J.e(EnumOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public EnumOptions build() {
                EnumOptions buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public EnumOptions buildPartial() {
                int i3;
                EnumOptions enumOptions = new EnumOptions(this);
                int i16 = this.f35309m;
                if ((i16 & 1) != 0) {
                    enumOptions.allowAlias_ = this.C;
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if ((i16 & 2) != 0) {
                    enumOptions.deprecated_ = this.D;
                    i3 |= 2;
                }
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.F;
                if (bpVar != null) {
                    enumOptions.uninterpretedOption_ = bpVar.d();
                } else {
                    if ((this.f35309m & 4) != 0) {
                        this.E = Collections.unmodifiableList(this.E);
                        this.f35309m &= -5;
                    }
                    enumOptions.uninterpretedOption_ = this.E;
                }
                enumOptions.bitField0_ = i3;
                onBuilt();
                return enumOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: z, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.C = false;
                int i3 = this.f35309m & (-2);
                this.D = false;
                this.f35309m = i3 & (-3);
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.F;
                if (bpVar == null) {
                    this.E = Collections.emptyList();
                    this.f35309m &= -5;
                } else {
                    bpVar.e();
                }
                return this;
            }

            b() {
                this.E = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.E = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(EnumOptions enumOptions) {
            return f35308d.toBuilder().H(enumOptions);
        }

        public static EnumOptions parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        EnumOptions(GeneratedMessageV3.d<EnumOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static EnumOptions parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static EnumOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public EnumOptions getDefaultInstanceForType() {
            return f35308d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35308d ? new b() : new b().H(this);
        }

        public static EnumOptions parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        EnumOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static EnumOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static EnumOptions parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static EnumOptions parseFrom(InputStream inputStream) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        EnumOptions(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J == 16) {
                                    this.bitField0_ |= 1;
                                    this.allowAlias_ = kVar.p();
                                } else if (J == 24) {
                                    this.bitField0_ |= 2;
                                    this.deprecated_ = kVar.p();
                                } else if (J != 7994) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    if ((i3 & 4) == 0) {
                                        this.uninterpretedOption_ = new ArrayList();
                                        i3 |= 4;
                                    }
                                    this.uninterpretedOption_.add(kVar.z(UninterpretedOption.PARSER, tVar));
                                }
                            }
                            z16 = true;
                        } catch (IOException e16) {
                            throw new InvalidProtocolBufferException(e16).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e17) {
                        throw e17.setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i3 & 4) != 0) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static EnumOptions parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static EnumOptions parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static EnumOptions parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class EnumValueDescriptorProto extends GeneratedMessageV3 implements e {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int number_;
        private EnumValueOptions options_;

        /* renamed from: d, reason: collision with root package name */
        private static final EnumValueDescriptorProto f35310d = new EnumValueDescriptorProto();

        @Deprecated
        public static final bg<EnumValueDescriptorProto> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<EnumValueDescriptorProto> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public EnumValueDescriptorProto g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new EnumValueDescriptorProto(kVar, tVar);
            }
        }

        public static EnumValueDescriptorProto getDefaultInstance() {
            return f35310d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f35287u;
        }

        public static b newBuilder() {
            return f35310d.toBuilder();
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<EnumValueDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumValueDescriptorProto)) {
                return super.equals(obj);
            }
            EnumValueDescriptorProto enumValueDescriptorProto = (EnumValueDescriptorProto) obj;
            if (hasName() != enumValueDescriptorProto.hasName()) {
                return false;
            }
            if ((hasName() && !getName().equals(enumValueDescriptorProto.getName())) || hasNumber() != enumValueDescriptorProto.hasNumber()) {
                return false;
            }
            if ((hasNumber() && getNumber() != enumValueDescriptorProto.getNumber()) || hasOptions() != enumValueDescriptorProto.hasOptions()) {
                return false;
            }
            if ((!hasOptions() || getOptions().equals(enumValueDescriptorProto.getOptions())) && this.unknownFields.equals(enumValueDescriptorProto.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getNumber() {
            return this.number_;
        }

        public EnumValueOptions getOptions() {
            EnumValueOptions enumValueOptions = this.options_;
            if (enumValueOptions == null) {
                return EnumValueOptions.getDefaultInstance();
            }
            return enumValueOptions;
        }

        public f getOptionsOrBuilder() {
            EnumValueOptions enumValueOptions = this.options_;
            if (enumValueOptions == null) {
                return EnumValueOptions.getDefaultInstance();
            }
            return enumValueOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<EnumValueDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if ((this.bitField0_ & 1) != 0) {
                i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            if ((this.bitField0_ & 2) != 0) {
                i16 += CodedOutputStream.x(2, this.number_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i16 += CodedOutputStream.G(3, getOptions());
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasNumber() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOptions() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasNumber()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getNumber();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getOptions().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f35288v.e(EnumValueDescriptorProto.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new EnumValueDescriptorProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.G0(2, this.number_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.K0(3, getOptions());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements e {
            private int C;
            private EnumValueOptions D;
            private bu<EnumValueOptions, EnumValueOptions.b, f> E;

            /* renamed from: i, reason: collision with root package name */
            private int f35311i;

            /* renamed from: m, reason: collision with root package name */
            private Object f35312m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private bu<EnumValueOptions, EnumValueOptions.b, f> w() {
                if (this.E == null) {
                    this.E = new bu<>(v(), h(), isClean());
                    this.D = null;
                }
                return this.E;
            }

            public b A(EnumValueOptions enumValueOptions) {
                EnumValueOptions enumValueOptions2;
                bu<EnumValueOptions, EnumValueOptions.b, f> buVar = this.E;
                if (buVar == null) {
                    if ((this.f35311i & 4) != 0 && (enumValueOptions2 = this.D) != null && enumValueOptions2 != EnumValueOptions.getDefaultInstance()) {
                        this.D = EnumValueOptions.newBuilder(this.D).H(enumValueOptions).buildPartial();
                    } else {
                        this.D = enumValueOptions;
                    }
                    onChanged();
                } else {
                    buVar.g(enumValueOptions);
                }
                this.f35311i |= 4;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b D(String str) {
                str.getClass();
                this.f35311i |= 1;
                this.f35312m = str;
                onChanged();
                return this;
            }

            public b E(int i3) {
                this.f35311i |= 2;
                this.C = i3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: F, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f35287u;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.f35288v.e(EnumValueDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public EnumValueDescriptorProto build() {
                EnumValueDescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public EnumValueDescriptorProto buildPartial() {
                int i3;
                EnumValueDescriptorProto enumValueDescriptorProto = new EnumValueDescriptorProto(this);
                int i16 = this.f35311i;
                if ((i16 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                enumValueDescriptorProto.name_ = this.f35312m;
                if ((i16 & 2) != 0) {
                    enumValueDescriptorProto.number_ = this.C;
                    i3 |= 2;
                }
                if ((i16 & 4) != 0) {
                    bu<EnumValueOptions, EnumValueOptions.b, f> buVar = this.E;
                    if (buVar == null) {
                        enumValueDescriptorProto.options_ = this.D;
                    } else {
                        enumValueDescriptorProto.options_ = buVar.b();
                    }
                    i3 |= 4;
                }
                enumValueDescriptorProto.bitField0_ = i3;
                onBuilt();
                return enumValueDescriptorProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f35312m = "";
                int i3 = this.f35311i & (-2);
                this.C = 0;
                this.f35311i = i3 & (-3);
                bu<EnumValueOptions, EnumValueOptions.b, f> buVar = this.E;
                if (buVar == null) {
                    this.D = null;
                } else {
                    buVar.c();
                }
                this.f35311i &= -5;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public EnumValueDescriptorProto getDefaultInstanceForType() {
                return EnumValueDescriptorProto.getDefaultInstance();
            }

            public EnumValueOptions v() {
                bu<EnumValueOptions, EnumValueOptions.b, f> buVar = this.E;
                if (buVar == null) {
                    EnumValueOptions enumValueOptions = this.D;
                    if (enumValueOptions == null) {
                        return EnumValueOptions.getDefaultInstance();
                    }
                    return enumValueOptions;
                }
                return buVar.f();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                EnumValueDescriptorProto enumValueDescriptorProto = null;
                try {
                    try {
                        EnumValueDescriptorProto g16 = EnumValueDescriptorProto.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            y(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (enumValueDescriptorProto != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    EnumValueDescriptorProto enumValueDescriptorProto2 = (EnumValueDescriptorProto) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        enumValueDescriptorProto = enumValueDescriptorProto2;
                        if (enumValueDescriptorProto != null) {
                            y(enumValueDescriptorProto);
                        }
                        throw th;
                    }
                }
            }

            public b y(EnumValueDescriptorProto enumValueDescriptorProto) {
                if (enumValueDescriptorProto == EnumValueDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (enumValueDescriptorProto.hasName()) {
                    this.f35311i |= 1;
                    this.f35312m = enumValueDescriptorProto.name_;
                    onChanged();
                }
                if (enumValueDescriptorProto.hasNumber()) {
                    E(enumValueDescriptorProto.getNumber());
                }
                if (enumValueDescriptorProto.hasOptions()) {
                    A(enumValueDescriptorProto.getOptions());
                }
                mo52mergeUnknownFields(enumValueDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof EnumValueDescriptorProto) {
                    return y((EnumValueDescriptorProto) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            b() {
                this.f35312m = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f35312m = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(EnumValueDescriptorProto enumValueDescriptorProto) {
            return f35310d.toBuilder().y(enumValueDescriptorProto);
        }

        public static EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        EnumValueDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static EnumValueDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public EnumValueDescriptorProto getDefaultInstanceForType() {
            return f35310d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35310d ? new b() : new b().y(this);
        }

        public static EnumValueDescriptorProto parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        EnumValueDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static EnumValueDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        EnumValueDescriptorProto(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J == 10) {
                                    ByteString q16 = kVar.q();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.name_ = q16;
                                } else if (J == 16) {
                                    this.bitField0_ |= 2;
                                    this.number_ = kVar.x();
                                } else if (J != 26) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    EnumValueOptions.b builder = (this.bitField0_ & 4) != 0 ? this.options_.toBuilder() : null;
                                    EnumValueOptions enumValueOptions = (EnumValueOptions) kVar.z(EnumValueOptions.PARSER, tVar);
                                    this.options_ = enumValueOptions;
                                    if (builder != null) {
                                        builder.H(enumValueOptions);
                                        this.options_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                }
                            }
                            z16 = true;
                        } catch (IOException e16) {
                            throw new InvalidProtocolBufferException(e16).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e17) {
                        throw e17.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static EnumValueDescriptorProto parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static EnumValueDescriptorProto parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static EnumValueDescriptorProto parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class EnumValueOptions extends GeneratedMessageV3.ExtendableMessage<EnumValueOptions> implements f {
        public static final int DEPRECATED_FIELD_NUMBER = 1;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;

        /* renamed from: d, reason: collision with root package name */
        private static final EnumValueOptions f35313d = new EnumValueOptions();

        @Deprecated
        public static final bg<EnumValueOptions> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<EnumValueOptions> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public EnumValueOptions g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new EnumValueOptions(kVar, tVar);
            }
        }

        public static EnumValueOptions getDefaultInstance() {
            return f35313d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.K;
        }

        public static b newBuilder() {
            return f35313d.toBuilder();
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EnumValueOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<EnumValueOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumValueOptions)) {
                return super.equals(obj);
            }
            EnumValueOptions enumValueOptions = (EnumValueOptions) obj;
            if (hasDeprecated() != enumValueOptions.hasDeprecated()) {
                return false;
            }
            if ((!hasDeprecated() || getDeprecated() == enumValueOptions.getDeprecated()) && getUninterpretedOptionList().equals(enumValueOptions.getUninterpretedOptionList()) && this.unknownFields.equals(enumValueOptions.unknownFields) && getExtensionFields().equals(enumValueOptions.getExtensionFields())) {
                return true;
            }
            return false;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<EnumValueOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = CodedOutputStream.e(1, this.deprecated_) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.uninterpretedOption_.size(); i17++) {
                i3 += CodedOutputStream.G(999, this.uninterpretedOption_.get(i17));
            }
            int extensionsSerializedSize = i3 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public UninterpretedOption getUninterpretedOption(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasDeprecated() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 1) * 53) + ad.c(getDeprecated());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, getExtensionFields()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.L.e(EnumValueOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getUninterpretedOptionCount(); i3++) {
                if (!getUninterpretedOption(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new EnumValueOptions();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.m0(1, this.deprecated_);
            }
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                codedOutputStream.K0(999, this.uninterpretedOption_.get(i3));
            }
            newExtensionWriter.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.d<EnumValueOptions, b> implements f {
            private boolean C;
            private List<UninterpretedOption> D;
            private bp<UninterpretedOption, UninterpretedOption.b, s> E;

            /* renamed from: m, reason: collision with root package name */
            private int f35314m;

            private void D() {
                if ((this.f35314m & 2) == 0) {
                    this.D = new ArrayList(this.D);
                    this.f35314m |= 2;
                }
            }

            private bp<UninterpretedOption, UninterpretedOption.b, s> F() {
                boolean z16;
                if (this.E == null) {
                    List<UninterpretedOption> list = this.D;
                    if ((this.f35314m & 2) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.E = new bp<>(list, z16, h(), isClean());
                    this.D = null;
                }
                return this.E;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    F();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public EnumValueOptions getDefaultInstanceForType() {
                return EnumValueOptions.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                EnumValueOptions enumValueOptions = null;
                try {
                    try {
                        EnumValueOptions g16 = EnumValueOptions.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            H(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (enumValueOptions != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    EnumValueOptions enumValueOptions2 = (EnumValueOptions) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        enumValueOptions = enumValueOptions2;
                        if (enumValueOptions != null) {
                            H(enumValueOptions);
                        }
                        throw th;
                    }
                }
            }

            public b H(EnumValueOptions enumValueOptions) {
                if (enumValueOptions == EnumValueOptions.getDefaultInstance()) {
                    return this;
                }
                if (enumValueOptions.hasDeprecated()) {
                    K(enumValueOptions.getDeprecated());
                }
                if (this.E == null) {
                    if (!enumValueOptions.uninterpretedOption_.isEmpty()) {
                        if (this.D.isEmpty()) {
                            this.D = enumValueOptions.uninterpretedOption_;
                            this.f35314m &= -3;
                        } else {
                            D();
                            this.D.addAll(enumValueOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!enumValueOptions.uninterpretedOption_.isEmpty()) {
                    if (this.E.j()) {
                        this.E.f();
                        bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = null;
                        this.E = null;
                        this.D = enumValueOptions.uninterpretedOption_;
                        this.f35314m &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = F();
                        }
                        this.E = bpVar;
                    } else {
                        this.E.b(enumValueOptions.uninterpretedOption_);
                    }
                }
                t(enumValueOptions);
                mo52mergeUnknownFields(enumValueOptions.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof EnumValueOptions) {
                    return H((EnumValueOptions) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b K(boolean z16) {
                this.f35314m |= 1;
                this.C = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: M, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.K;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.L.e(EnumValueOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public EnumValueOptions build() {
                EnumValueOptions buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public EnumValueOptions buildPartial() {
                EnumValueOptions enumValueOptions = new EnumValueOptions(this);
                int i3 = 1;
                if ((this.f35314m & 1) != 0) {
                    enumValueOptions.deprecated_ = this.C;
                } else {
                    i3 = 0;
                }
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.E;
                if (bpVar != null) {
                    enumValueOptions.uninterpretedOption_ = bpVar.d();
                } else {
                    if ((this.f35314m & 2) != 0) {
                        this.D = Collections.unmodifiableList(this.D);
                        this.f35314m &= -3;
                    }
                    enumValueOptions.uninterpretedOption_ = this.D;
                }
                enumValueOptions.bitField0_ = i3;
                onBuilt();
                return enumValueOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: z, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.C = false;
                this.f35314m &= -2;
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.E;
                if (bpVar == null) {
                    this.D = Collections.emptyList();
                    this.f35314m &= -3;
                } else {
                    bpVar.e();
                }
                return this;
            }

            b() {
                this.D = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.D = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(EnumValueOptions enumValueOptions) {
            return f35313d.toBuilder().H(enumValueOptions);
        }

        public static EnumValueOptions parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        EnumValueOptions(GeneratedMessageV3.d<EnumValueOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static EnumValueOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public EnumValueOptions getDefaultInstanceForType() {
            return f35313d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35313d ? new b() : new b().H(this);
        }

        public static EnumValueOptions parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        EnumValueOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static EnumValueOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static EnumValueOptions parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static EnumValueOptions parseFrom(InputStream inputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        EnumValueOptions(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 8) {
                                this.bitField0_ |= 1;
                                this.deprecated_ = kVar.p();
                            } else if (J != 7994) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                if ((i3 & 2) == 0) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    i3 |= 2;
                                }
                                this.uninterpretedOption_.add(kVar.z(UninterpretedOption.PARSER, tVar));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i3 & 2) != 0) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static EnumValueOptions parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static EnumValueOptions parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static EnumValueOptions parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ExtensionRangeOptions extends GeneratedMessageV3.ExtendableMessage<ExtensionRangeOptions> implements g {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;

        /* renamed from: d, reason: collision with root package name */
        private static final ExtensionRangeOptions f35315d = new ExtensionRangeOptions();

        @Deprecated
        public static final bg<ExtensionRangeOptions> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<ExtensionRangeOptions> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ExtensionRangeOptions g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ExtensionRangeOptions(kVar, tVar);
            }
        }

        public static ExtensionRangeOptions getDefaultInstance() {
            return f35315d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f35277k;
        }

        public static b newBuilder() {
            return f35315d.toBuilder();
        }

        public static ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ExtensionRangeOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<ExtensionRangeOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ExtensionRangeOptions)) {
                return super.equals(obj);
            }
            ExtensionRangeOptions extensionRangeOptions = (ExtensionRangeOptions) obj;
            if (getUninterpretedOptionList().equals(extensionRangeOptions.getUninterpretedOptionList()) && this.unknownFields.equals(extensionRangeOptions.unknownFields) && getExtensionFields().equals(extensionRangeOptions.getExtensionFields())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ExtensionRangeOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.uninterpretedOption_.size(); i17++) {
                i16 += CodedOutputStream.G(999, this.uninterpretedOption_.get(i17));
            }
            int extensionsSerializedSize = i16 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public UninterpretedOption getUninterpretedOption(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, getExtensionFields()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f35278l.e(ExtensionRangeOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getUninterpretedOptionCount(); i3++) {
                if (!getUninterpretedOption(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new ExtensionRangeOptions();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                codedOutputStream.K0(999, this.uninterpretedOption_.get(i3));
            }
            newExtensionWriter.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.d<ExtensionRangeOptions, b> implements g {
            private List<UninterpretedOption> C;
            private bp<UninterpretedOption, UninterpretedOption.b, s> D;

            /* renamed from: m, reason: collision with root package name */
            private int f35316m;

            private void D() {
                if ((this.f35316m & 1) == 0) {
                    this.C = new ArrayList(this.C);
                    this.f35316m |= 1;
                }
            }

            private bp<UninterpretedOption, UninterpretedOption.b, s> F() {
                if (this.D == null) {
                    List<UninterpretedOption> list = this.C;
                    boolean z16 = true;
                    if ((this.f35316m & 1) == 0) {
                        z16 = false;
                    }
                    this.D = new bp<>(list, z16, h(), isClean());
                    this.C = null;
                }
                return this.D;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    F();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public ExtensionRangeOptions getDefaultInstanceForType() {
                return ExtensionRangeOptions.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                ExtensionRangeOptions extensionRangeOptions = null;
                try {
                    try {
                        ExtensionRangeOptions g16 = ExtensionRangeOptions.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            H(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (extensionRangeOptions != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    ExtensionRangeOptions extensionRangeOptions2 = (ExtensionRangeOptions) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        extensionRangeOptions = extensionRangeOptions2;
                        if (extensionRangeOptions != null) {
                            H(extensionRangeOptions);
                        }
                        throw th;
                    }
                }
            }

            public b H(ExtensionRangeOptions extensionRangeOptions) {
                if (extensionRangeOptions == ExtensionRangeOptions.getDefaultInstance()) {
                    return this;
                }
                if (this.D == null) {
                    if (!extensionRangeOptions.uninterpretedOption_.isEmpty()) {
                        if (this.C.isEmpty()) {
                            this.C = extensionRangeOptions.uninterpretedOption_;
                            this.f35316m &= -2;
                        } else {
                            D();
                            this.C.addAll(extensionRangeOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!extensionRangeOptions.uninterpretedOption_.isEmpty()) {
                    if (this.D.j()) {
                        this.D.f();
                        bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = null;
                        this.D = null;
                        this.C = extensionRangeOptions.uninterpretedOption_;
                        this.f35316m &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = F();
                        }
                        this.D = bpVar;
                    } else {
                        this.D.b(extensionRangeOptions.uninterpretedOption_);
                    }
                }
                t(extensionRangeOptions);
                mo52mergeUnknownFields(extensionRangeOptions.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ExtensionRangeOptions) {
                    return H((ExtensionRangeOptions) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: K, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f35277k;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.f35278l.e(ExtensionRangeOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public ExtensionRangeOptions build() {
                ExtensionRangeOptions buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public ExtensionRangeOptions buildPartial() {
                ExtensionRangeOptions extensionRangeOptions = new ExtensionRangeOptions(this);
                int i3 = this.f35316m;
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.D;
                if (bpVar != null) {
                    extensionRangeOptions.uninterpretedOption_ = bpVar.d();
                } else {
                    if ((i3 & 1) != 0) {
                        this.C = Collections.unmodifiableList(this.C);
                        this.f35316m &= -2;
                    }
                    extensionRangeOptions.uninterpretedOption_ = this.C;
                }
                onBuilt();
                return extensionRangeOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: z, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.D;
                if (bpVar == null) {
                    this.C = Collections.emptyList();
                    this.f35316m &= -2;
                } else {
                    bpVar.e();
                }
                return this;
            }

            b() {
                this.C = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ExtensionRangeOptions extensionRangeOptions) {
            return f35315d.toBuilder().H(extensionRangeOptions);
        }

        public static ExtensionRangeOptions parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        ExtensionRangeOptions(GeneratedMessageV3.d<ExtensionRangeOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static ExtensionRangeOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ExtensionRangeOptions getDefaultInstanceForType() {
            return f35315d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35315d ? new b() : new b().H(this);
        }

        public static ExtensionRangeOptions parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ExtensionRangeOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static ExtensionRangeOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ExtensionRangeOptions parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static ExtensionRangeOptions parseFrom(InputStream inputStream) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        ExtensionRangeOptions(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J != 7994) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                if (!(z17 & true)) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.uninterpretedOption_.add(kVar.z(UninterpretedOption.PARSER, tVar));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z17 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ExtensionRangeOptions parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static ExtensionRangeOptions parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static ExtensionRangeOptions parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class FieldDescriptorProto extends GeneratedMessageV3 implements h {
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int JSON_NAME_FIELD_NUMBER = 10;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object defaultValue_;
        private volatile Object extendee_;
        private volatile Object jsonName_;
        private int label_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int number_;
        private int oneofIndex_;
        private FieldOptions options_;
        private volatile Object typeName_;
        private int type_;

        /* renamed from: d, reason: collision with root package name */
        private static final FieldDescriptorProto f35317d = new FieldDescriptorProto();

        @Deprecated
        public static final bg<FieldDescriptorProto> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum Label implements bk {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);

            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;
            private final int value;
            private static final ad.d<Label> internalValueMap = new a();
            private static final Label[] VALUES = values();

            /* loaded from: classes2.dex */
            static class a implements ad.d<Label> {
                a() {
                }

                @Override // com.google.protobuf.ad.d
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Label findValueByNumber(int i3) {
                    return Label.forNumber(i3);
                }
            }

            Label(int i3) {
                this.value = i3;
            }

            public static Label forNumber(int i3) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return null;
                        }
                        return LABEL_REPEATED;
                    }
                    return LABEL_REQUIRED;
                }
                return LABEL_OPTIONAL;
            }

            public static final Descriptors.c getDescriptor() {
                return FieldDescriptorProto.getDescriptor().p().get(1);
            }

            public static ad.d<Label> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.c getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ad.c
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.d getValueDescriptor() {
                return getDescriptor().o().get(ordinal());
            }

            @Deprecated
            public static Label valueOf(int i3) {
                return forNumber(i3);
            }

            public static Label valueOf(Descriptors.d dVar) {
                if (dVar.m() == getDescriptor()) {
                    return VALUES[dVar.l()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes2.dex */
        public enum Type implements bk {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);

            public static final int TYPE_BOOL_VALUE = 8;
            public static final int TYPE_BYTES_VALUE = 12;
            public static final int TYPE_DOUBLE_VALUE = 1;
            public static final int TYPE_ENUM_VALUE = 14;
            public static final int TYPE_FIXED32_VALUE = 7;
            public static final int TYPE_FIXED64_VALUE = 6;
            public static final int TYPE_FLOAT_VALUE = 2;
            public static final int TYPE_GROUP_VALUE = 10;
            public static final int TYPE_INT32_VALUE = 5;
            public static final int TYPE_INT64_VALUE = 3;
            public static final int TYPE_MESSAGE_VALUE = 11;
            public static final int TYPE_SFIXED32_VALUE = 15;
            public static final int TYPE_SFIXED64_VALUE = 16;
            public static final int TYPE_SINT32_VALUE = 17;
            public static final int TYPE_SINT64_VALUE = 18;
            public static final int TYPE_STRING_VALUE = 9;
            public static final int TYPE_UINT32_VALUE = 13;
            public static final int TYPE_UINT64_VALUE = 4;
            private final int value;
            private static final ad.d<Type> internalValueMap = new a();
            private static final Type[] VALUES = values();

            /* loaded from: classes2.dex */
            static class a implements ad.d<Type> {
                a() {
                }

                @Override // com.google.protobuf.ad.d
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Type findValueByNumber(int i3) {
                    return Type.forNumber(i3);
                }
            }

            Type(int i3) {
                this.value = i3;
            }

            public static Type forNumber(int i3) {
                switch (i3) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static final Descriptors.c getDescriptor() {
                return FieldDescriptorProto.getDescriptor().p().get(0);
            }

            public static ad.d<Type> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.c getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ad.c
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.d getValueDescriptor() {
                return getDescriptor().o().get(ordinal());
            }

            @Deprecated
            public static Type valueOf(int i3) {
                return forNumber(i3);
            }

            public static Type valueOf(Descriptors.d dVar) {
                if (dVar.m() == getDescriptor()) {
                    return VALUES[dVar.l()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<FieldDescriptorProto> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public FieldDescriptorProto g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new FieldDescriptorProto(kVar, tVar);
            }
        }

        public static FieldDescriptorProto getDefaultInstance() {
            return f35317d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f35279m;
        }

        public static b newBuilder() {
            return f35317d.toBuilder();
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FieldDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<FieldDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FieldDescriptorProto)) {
                return super.equals(obj);
            }
            FieldDescriptorProto fieldDescriptorProto = (FieldDescriptorProto) obj;
            if (hasName() != fieldDescriptorProto.hasName()) {
                return false;
            }
            if ((hasName() && !getName().equals(fieldDescriptorProto.getName())) || hasNumber() != fieldDescriptorProto.hasNumber()) {
                return false;
            }
            if ((hasNumber() && getNumber() != fieldDescriptorProto.getNumber()) || hasLabel() != fieldDescriptorProto.hasLabel()) {
                return false;
            }
            if ((hasLabel() && this.label_ != fieldDescriptorProto.label_) || hasType() != fieldDescriptorProto.hasType()) {
                return false;
            }
            if ((hasType() && this.type_ != fieldDescriptorProto.type_) || hasTypeName() != fieldDescriptorProto.hasTypeName()) {
                return false;
            }
            if ((hasTypeName() && !getTypeName().equals(fieldDescriptorProto.getTypeName())) || hasExtendee() != fieldDescriptorProto.hasExtendee()) {
                return false;
            }
            if ((hasExtendee() && !getExtendee().equals(fieldDescriptorProto.getExtendee())) || hasDefaultValue() != fieldDescriptorProto.hasDefaultValue()) {
                return false;
            }
            if ((hasDefaultValue() && !getDefaultValue().equals(fieldDescriptorProto.getDefaultValue())) || hasOneofIndex() != fieldDescriptorProto.hasOneofIndex()) {
                return false;
            }
            if ((hasOneofIndex() && getOneofIndex() != fieldDescriptorProto.getOneofIndex()) || hasJsonName() != fieldDescriptorProto.hasJsonName()) {
                return false;
            }
            if ((hasJsonName() && !getJsonName().equals(fieldDescriptorProto.getJsonName())) || hasOptions() != fieldDescriptorProto.hasOptions()) {
                return false;
            }
            if ((!hasOptions() || getOptions().equals(fieldDescriptorProto.getOptions())) && this.unknownFields.equals(fieldDescriptorProto.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getDefaultValue() {
            Object obj = this.defaultValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.defaultValue_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getDefaultValueBytes() {
            Object obj = this.defaultValue_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.defaultValue_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getExtendee() {
            Object obj = this.extendee_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.extendee_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getExtendeeBytes() {
            Object obj = this.extendee_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.extendee_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getJsonName() {
            Object obj = this.jsonName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.jsonName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getJsonNameBytes() {
            Object obj = this.jsonName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.jsonName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Label getLabel() {
            Label valueOf = Label.valueOf(this.label_);
            if (valueOf == null) {
                return Label.LABEL_OPTIONAL;
            }
            return valueOf;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getNumber() {
            return this.number_;
        }

        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        public FieldOptions getOptions() {
            FieldOptions fieldOptions = this.options_;
            if (fieldOptions == null) {
                return FieldOptions.getDefaultInstance();
            }
            return fieldOptions;
        }

        public i getOptionsOrBuilder() {
            FieldOptions fieldOptions = this.options_;
            if (fieldOptions == null) {
                return FieldOptions.getDefaultInstance();
            }
            return fieldOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<FieldDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if ((this.bitField0_ & 1) != 0) {
                i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            if ((this.bitField0_ & 32) != 0) {
                i16 += GeneratedMessageV3.computeStringSize(2, this.extendee_);
            }
            if ((this.bitField0_ & 2) != 0) {
                i16 += CodedOutputStream.x(3, this.number_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i16 += CodedOutputStream.l(4, this.label_);
            }
            if ((this.bitField0_ & 8) != 0) {
                i16 += CodedOutputStream.l(5, this.type_);
            }
            if ((this.bitField0_ & 16) != 0) {
                i16 += GeneratedMessageV3.computeStringSize(6, this.typeName_);
            }
            if ((this.bitField0_ & 64) != 0) {
                i16 += GeneratedMessageV3.computeStringSize(7, this.defaultValue_);
            }
            if ((this.bitField0_ & 512) != 0) {
                i16 += CodedOutputStream.G(8, getOptions());
            }
            if ((this.bitField0_ & 128) != 0) {
                i16 += CodedOutputStream.x(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) != 0) {
                i16 += GeneratedMessageV3.computeStringSize(10, this.jsonName_);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public Type getType() {
            Type valueOf = Type.valueOf(this.type_);
            if (valueOf == null) {
                return Type.TYPE_DOUBLE;
            }
            return valueOf;
        }

        public String getTypeName() {
            Object obj = this.typeName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.typeName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getTypeNameBytes() {
            Object obj = this.typeName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.typeName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasDefaultValue() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasExtendee() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasJsonName() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasLabel() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasNumber() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOneofIndex() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOptions() {
            if ((this.bitField0_ & 512) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasType() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasTypeName() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasNumber()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getNumber();
            }
            if (hasLabel()) {
                hashCode = (((hashCode * 37) + 4) * 53) + this.label_;
            }
            if (hasType()) {
                hashCode = (((hashCode * 37) + 5) * 53) + this.type_;
            }
            if (hasTypeName()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getTypeName().hashCode();
            }
            if (hasExtendee()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getExtendee().hashCode();
            }
            if (hasDefaultValue()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getDefaultValue().hashCode();
            }
            if (hasOneofIndex()) {
                hashCode = (((hashCode * 37) + 9) * 53) + getOneofIndex();
            }
            if (hasJsonName()) {
                hashCode = (((hashCode * 37) + 10) * 53) + getJsonName().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getOptions().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f35280n.e(FieldDescriptorProto.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new FieldDescriptorProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if ((this.bitField0_ & 32) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.extendee_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.G0(3, this.number_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.u0(4, this.label_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.u0(5, this.type_);
            }
            if ((this.bitField0_ & 16) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.typeName_);
            }
            if ((this.bitField0_ & 64) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.defaultValue_);
            }
            if ((this.bitField0_ & 512) != 0) {
                codedOutputStream.K0(8, getOptions());
            }
            if ((this.bitField0_ & 128) != 0) {
                codedOutputStream.G0(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.jsonName_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements h {
            private int C;
            private int D;
            private int E;
            private Object F;
            private Object G;
            private Object H;
            private int I;
            private Object J;
            private FieldOptions K;
            private bu<FieldOptions, FieldOptions.b, i> L;

            /* renamed from: i, reason: collision with root package name */
            private int f35318i;

            /* renamed from: m, reason: collision with root package name */
            private Object f35319m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private bu<FieldOptions, FieldOptions.b, i> w() {
                if (this.L == null) {
                    this.L = new bu<>(v(), h(), isClean());
                    this.K = null;
                }
                return this.L;
            }

            public b A(FieldOptions fieldOptions) {
                FieldOptions fieldOptions2;
                bu<FieldOptions, FieldOptions.b, i> buVar = this.L;
                if (buVar == null) {
                    if ((this.f35318i & 512) != 0 && (fieldOptions2 = this.K) != null && fieldOptions2 != FieldOptions.getDefaultInstance()) {
                        this.K = FieldOptions.newBuilder(this.K).H(fieldOptions).buildPartial();
                    } else {
                        this.K = fieldOptions;
                    }
                    onChanged();
                } else {
                    buVar.g(fieldOptions);
                }
                this.f35318i |= 512;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b D(Label label) {
                label.getClass();
                this.f35318i |= 4;
                this.D = label.getNumber();
                onChanged();
                return this;
            }

            public b E(int i3) {
                this.f35318i |= 2;
                this.C = i3;
                onChanged();
                return this;
            }

            public b F(int i3) {
                this.f35318i |= 128;
                this.I = i3;
                onChanged();
                return this;
            }

            public b G(Type type) {
                type.getClass();
                this.f35318i |= 8;
                this.E = type.getNumber();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: H, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f35279m;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.f35280n.e(FieldDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public FieldDescriptorProto build() {
                FieldDescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public FieldDescriptorProto buildPartial() {
                int i3;
                FieldDescriptorProto fieldDescriptorProto = new FieldDescriptorProto(this);
                int i16 = this.f35318i;
                if ((i16 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                fieldDescriptorProto.name_ = this.f35319m;
                if ((i16 & 2) != 0) {
                    fieldDescriptorProto.number_ = this.C;
                    i3 |= 2;
                }
                if ((i16 & 4) != 0) {
                    i3 |= 4;
                }
                fieldDescriptorProto.label_ = this.D;
                if ((i16 & 8) != 0) {
                    i3 |= 8;
                }
                fieldDescriptorProto.type_ = this.E;
                if ((i16 & 16) != 0) {
                    i3 |= 16;
                }
                fieldDescriptorProto.typeName_ = this.F;
                if ((i16 & 32) != 0) {
                    i3 |= 32;
                }
                fieldDescriptorProto.extendee_ = this.G;
                if ((i16 & 64) != 0) {
                    i3 |= 64;
                }
                fieldDescriptorProto.defaultValue_ = this.H;
                if ((i16 & 128) != 0) {
                    fieldDescriptorProto.oneofIndex_ = this.I;
                    i3 |= 128;
                }
                if ((i16 & 256) != 0) {
                    i3 |= 256;
                }
                fieldDescriptorProto.jsonName_ = this.J;
                if ((i16 & 512) != 0) {
                    bu<FieldOptions, FieldOptions.b, i> buVar = this.L;
                    if (buVar == null) {
                        fieldDescriptorProto.options_ = this.K;
                    } else {
                        fieldDescriptorProto.options_ = buVar.b();
                    }
                    i3 |= 512;
                }
                fieldDescriptorProto.bitField0_ = i3;
                onBuilt();
                return fieldDescriptorProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f35319m = "";
                int i3 = this.f35318i & (-2);
                this.C = 0;
                this.D = 1;
                this.E = 1;
                this.F = "";
                this.G = "";
                this.H = "";
                this.I = 0;
                this.J = "";
                this.f35318i = i3 & (-3) & (-5) & (-9) & (-17) & (-33) & (-65) & (-129) & (-257);
                bu<FieldOptions, FieldOptions.b, i> buVar = this.L;
                if (buVar == null) {
                    this.K = null;
                } else {
                    buVar.c();
                }
                this.f35318i &= -513;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public FieldDescriptorProto getDefaultInstanceForType() {
                return FieldDescriptorProto.getDefaultInstance();
            }

            public FieldOptions v() {
                bu<FieldOptions, FieldOptions.b, i> buVar = this.L;
                if (buVar == null) {
                    FieldOptions fieldOptions = this.K;
                    if (fieldOptions == null) {
                        return FieldOptions.getDefaultInstance();
                    }
                    return fieldOptions;
                }
                return buVar.f();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                FieldDescriptorProto fieldDescriptorProto = null;
                try {
                    try {
                        FieldDescriptorProto g16 = FieldDescriptorProto.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            y(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fieldDescriptorProto != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    FieldDescriptorProto fieldDescriptorProto2 = (FieldDescriptorProto) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        fieldDescriptorProto = fieldDescriptorProto2;
                        if (fieldDescriptorProto != null) {
                            y(fieldDescriptorProto);
                        }
                        throw th;
                    }
                }
            }

            public b y(FieldDescriptorProto fieldDescriptorProto) {
                if (fieldDescriptorProto == FieldDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (fieldDescriptorProto.hasName()) {
                    this.f35318i |= 1;
                    this.f35319m = fieldDescriptorProto.name_;
                    onChanged();
                }
                if (fieldDescriptorProto.hasNumber()) {
                    E(fieldDescriptorProto.getNumber());
                }
                if (fieldDescriptorProto.hasLabel()) {
                    D(fieldDescriptorProto.getLabel());
                }
                if (fieldDescriptorProto.hasType()) {
                    G(fieldDescriptorProto.getType());
                }
                if (fieldDescriptorProto.hasTypeName()) {
                    this.f35318i |= 16;
                    this.F = fieldDescriptorProto.typeName_;
                    onChanged();
                }
                if (fieldDescriptorProto.hasExtendee()) {
                    this.f35318i |= 32;
                    this.G = fieldDescriptorProto.extendee_;
                    onChanged();
                }
                if (fieldDescriptorProto.hasDefaultValue()) {
                    this.f35318i |= 64;
                    this.H = fieldDescriptorProto.defaultValue_;
                    onChanged();
                }
                if (fieldDescriptorProto.hasOneofIndex()) {
                    F(fieldDescriptorProto.getOneofIndex());
                }
                if (fieldDescriptorProto.hasJsonName()) {
                    this.f35318i |= 256;
                    this.J = fieldDescriptorProto.jsonName_;
                    onChanged();
                }
                if (fieldDescriptorProto.hasOptions()) {
                    A(fieldDescriptorProto.getOptions());
                }
                mo52mergeUnknownFields(fieldDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof FieldDescriptorProto) {
                    return y((FieldDescriptorProto) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            b() {
                this.f35319m = "";
                this.D = 1;
                this.E = 1;
                this.F = "";
                this.G = "";
                this.H = "";
                this.J = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f35319m = "";
                this.D = 1;
                this.E = 1;
                this.F = "";
                this.G = "";
                this.H = "";
                this.J = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(FieldDescriptorProto fieldDescriptorProto) {
            return f35317d.toBuilder().y(fieldDescriptorProto);
        }

        public static FieldDescriptorProto parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        FieldDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static FieldDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public FieldDescriptorProto getDefaultInstanceForType() {
            return f35317d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35317d ? new b() : new b().y(this);
        }

        public static FieldDescriptorProto parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        FieldDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.label_ = 1;
            this.type_ = 1;
            this.typeName_ = "";
            this.extendee_ = "";
            this.defaultValue_ = "";
            this.jsonName_ = "";
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static FieldDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static FieldDescriptorProto parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static FieldDescriptorProto parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static FieldDescriptorProto parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
        FieldDescriptorProto(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        switch (J) {
                            case 0:
                                z16 = true;
                            case 10:
                                ByteString q16 = kVar.q();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.name_ = q16;
                            case 18:
                                ByteString q17 = kVar.q();
                                this.bitField0_ |= 32;
                                this.extendee_ = q17;
                            case 24:
                                this.bitField0_ |= 2;
                                this.number_ = kVar.x();
                            case 32:
                                int s16 = kVar.s();
                                if (Label.valueOf(s16) == null) {
                                    g16.r(4, s16);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.label_ = s16;
                                }
                            case 40:
                                int s17 = kVar.s();
                                if (Type.valueOf(s17) == null) {
                                    g16.r(5, s17);
                                } else {
                                    this.bitField0_ |= 8;
                                    this.type_ = s17;
                                }
                            case 50:
                                ByteString q18 = kVar.q();
                                this.bitField0_ |= 16;
                                this.typeName_ = q18;
                            case 58:
                                ByteString q19 = kVar.q();
                                this.bitField0_ |= 64;
                                this.defaultValue_ = q19;
                            case 66:
                                FieldOptions.b builder = (this.bitField0_ & 512) != 0 ? this.options_.toBuilder() : null;
                                FieldOptions fieldOptions = (FieldOptions) kVar.z(FieldOptions.PARSER, tVar);
                                this.options_ = fieldOptions;
                                if (builder != null) {
                                    builder.H(fieldOptions);
                                    this.options_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 512;
                            case 72:
                                this.bitField0_ |= 128;
                                this.oneofIndex_ = kVar.x();
                            case 82:
                                ByteString q26 = kVar.q();
                                this.bitField0_ |= 256;
                                this.jsonName_ = q26;
                            default:
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    z16 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class FieldOptions extends GeneratedMessageV3.ExtendableMessage<FieldOptions> implements i {
        public static final int CTYPE_FIELD_NUMBER = 1;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int JSTYPE_FIELD_NUMBER = 6;
        public static final int LAZY_FIELD_NUMBER = 5;
        public static final int PACKED_FIELD_NUMBER = 2;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int WEAK_FIELD_NUMBER = 10;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int ctype_;
        private boolean deprecated_;
        private int jstype_;
        private boolean lazy_;
        private byte memoizedIsInitialized;
        private boolean packed_;
        private List<UninterpretedOption> uninterpretedOption_;
        private boolean weak_;

        /* renamed from: d, reason: collision with root package name */
        private static final FieldOptions f35320d = new FieldOptions();

        @Deprecated
        public static final bg<FieldOptions> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum CType implements bk {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);

            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;
            private final int value;
            private static final ad.d<CType> internalValueMap = new a();
            private static final CType[] VALUES = values();

            /* loaded from: classes2.dex */
            static class a implements ad.d<CType> {
                a() {
                }

                @Override // com.google.protobuf.ad.d
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public CType findValueByNumber(int i3) {
                    return CType.forNumber(i3);
                }
            }

            CType(int i3) {
                this.value = i3;
            }

            public static CType forNumber(int i3) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return null;
                        }
                        return STRING_PIECE;
                    }
                    return CORD;
                }
                return STRING;
            }

            public static final Descriptors.c getDescriptor() {
                return FieldOptions.getDescriptor().p().get(0);
            }

            public static ad.d<CType> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.c getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ad.c
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.d getValueDescriptor() {
                return getDescriptor().o().get(ordinal());
            }

            @Deprecated
            public static CType valueOf(int i3) {
                return forNumber(i3);
            }

            public static CType valueOf(Descriptors.d dVar) {
                if (dVar.m() == getDescriptor()) {
                    return VALUES[dVar.l()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes2.dex */
        public enum JSType implements bk {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);

            public static final int JS_NORMAL_VALUE = 0;
            public static final int JS_NUMBER_VALUE = 2;
            public static final int JS_STRING_VALUE = 1;
            private final int value;
            private static final ad.d<JSType> internalValueMap = new a();
            private static final JSType[] VALUES = values();

            /* loaded from: classes2.dex */
            static class a implements ad.d<JSType> {
                a() {
                }

                @Override // com.google.protobuf.ad.d
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public JSType findValueByNumber(int i3) {
                    return JSType.forNumber(i3);
                }
            }

            JSType(int i3) {
                this.value = i3;
            }

            public static JSType forNumber(int i3) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return null;
                        }
                        return JS_NUMBER;
                    }
                    return JS_STRING;
                }
                return JS_NORMAL;
            }

            public static final Descriptors.c getDescriptor() {
                return FieldOptions.getDescriptor().p().get(1);
            }

            public static ad.d<JSType> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.c getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ad.c
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.d getValueDescriptor() {
                return getDescriptor().o().get(ordinal());
            }

            @Deprecated
            public static JSType valueOf(int i3) {
                return forNumber(i3);
            }

            public static JSType valueOf(Descriptors.d dVar) {
                if (dVar.m() == getDescriptor()) {
                    return VALUES[dVar.l()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<FieldOptions> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public FieldOptions g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new FieldOptions(kVar, tVar);
            }
        }

        public static FieldOptions getDefaultInstance() {
            return f35320d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.E;
        }

        public static b newBuilder() {
            return f35320d.toBuilder();
        }

        public static FieldOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FieldOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<FieldOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FieldOptions)) {
                return super.equals(obj);
            }
            FieldOptions fieldOptions = (FieldOptions) obj;
            if (hasCtype() != fieldOptions.hasCtype()) {
                return false;
            }
            if ((hasCtype() && this.ctype_ != fieldOptions.ctype_) || hasPacked() != fieldOptions.hasPacked()) {
                return false;
            }
            if ((hasPacked() && getPacked() != fieldOptions.getPacked()) || hasJstype() != fieldOptions.hasJstype()) {
                return false;
            }
            if ((hasJstype() && this.jstype_ != fieldOptions.jstype_) || hasLazy() != fieldOptions.hasLazy()) {
                return false;
            }
            if ((hasLazy() && getLazy() != fieldOptions.getLazy()) || hasDeprecated() != fieldOptions.hasDeprecated()) {
                return false;
            }
            if ((hasDeprecated() && getDeprecated() != fieldOptions.getDeprecated()) || hasWeak() != fieldOptions.hasWeak()) {
                return false;
            }
            if ((!hasWeak() || getWeak() == fieldOptions.getWeak()) && getUninterpretedOptionList().equals(fieldOptions.getUninterpretedOptionList()) && this.unknownFields.equals(fieldOptions.unknownFields) && getExtensionFields().equals(fieldOptions.getExtensionFields())) {
                return true;
            }
            return false;
        }

        public CType getCtype() {
            CType valueOf = CType.valueOf(this.ctype_);
            if (valueOf == null) {
                return CType.STRING;
            }
            return valueOf;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        public JSType getJstype() {
            JSType valueOf = JSType.valueOf(this.jstype_);
            if (valueOf == null) {
                return JSType.JS_NORMAL;
            }
            return valueOf;
        }

        public boolean getLazy() {
            return this.lazy_;
        }

        public boolean getPacked() {
            return this.packed_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<FieldOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = CodedOutputStream.l(1, this.ctype_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) != 0) {
                i3 += CodedOutputStream.e(2, this.packed_);
            }
            if ((this.bitField0_ & 16) != 0) {
                i3 += CodedOutputStream.e(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) != 0) {
                i3 += CodedOutputStream.e(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i3 += CodedOutputStream.l(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) != 0) {
                i3 += CodedOutputStream.e(10, this.weak_);
            }
            for (int i17 = 0; i17 < this.uninterpretedOption_.size(); i17++) {
                i3 += CodedOutputStream.G(999, this.uninterpretedOption_.get(i17));
            }
            int extensionsSerializedSize = i3 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public UninterpretedOption getUninterpretedOption(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean getWeak() {
            return this.weak_;
        }

        public boolean hasCtype() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasDeprecated() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasJstype() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasLazy() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasPacked() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasWeak() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasCtype()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.ctype_;
            }
            if (hasPacked()) {
                hashCode = (((hashCode * 37) + 2) * 53) + ad.c(getPacked());
            }
            if (hasJstype()) {
                hashCode = (((hashCode * 37) + 6) * 53) + this.jstype_;
            }
            if (hasLazy()) {
                hashCode = (((hashCode * 37) + 5) * 53) + ad.c(getLazy());
            }
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 3) * 53) + ad.c(getDeprecated());
            }
            if (hasWeak()) {
                hashCode = (((hashCode * 37) + 10) * 53) + ad.c(getWeak());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, getExtensionFields()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.F.e(FieldOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getUninterpretedOptionCount(); i3++) {
                if (!getUninterpretedOption(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new FieldOptions();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.u0(1, this.ctype_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.m0(2, this.packed_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.m0(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.m0(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.u0(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputStream.m0(10, this.weak_);
            }
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                codedOutputStream.K0(999, this.uninterpretedOption_.get(i3));
            }
            newExtensionWriter.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.d<FieldOptions, b> implements i {
            private int C;
            private boolean D;
            private int E;
            private boolean F;
            private boolean G;
            private boolean H;
            private List<UninterpretedOption> I;
            private bp<UninterpretedOption, UninterpretedOption.b, s> J;

            /* renamed from: m, reason: collision with root package name */
            private int f35321m;

            private void D() {
                if ((this.f35321m & 64) == 0) {
                    this.I = new ArrayList(this.I);
                    this.f35321m |= 64;
                }
            }

            private bp<UninterpretedOption, UninterpretedOption.b, s> F() {
                boolean z16;
                if (this.J == null) {
                    List<UninterpretedOption> list = this.I;
                    if ((this.f35321m & 64) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.J = new bp<>(list, z16, h(), isClean());
                    this.I = null;
                }
                return this.J;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    F();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public FieldOptions getDefaultInstanceForType() {
                return FieldOptions.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                FieldOptions fieldOptions = null;
                try {
                    try {
                        FieldOptions g16 = FieldOptions.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            H(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fieldOptions != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    FieldOptions fieldOptions2 = (FieldOptions) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        fieldOptions = fieldOptions2;
                        if (fieldOptions != null) {
                            H(fieldOptions);
                        }
                        throw th;
                    }
                }
            }

            public b H(FieldOptions fieldOptions) {
                if (fieldOptions == FieldOptions.getDefaultInstance()) {
                    return this;
                }
                if (fieldOptions.hasCtype()) {
                    K(fieldOptions.getCtype());
                }
                if (fieldOptions.hasPacked()) {
                    P(fieldOptions.getPacked());
                }
                if (fieldOptions.hasJstype()) {
                    N(fieldOptions.getJstype());
                }
                if (fieldOptions.hasLazy()) {
                    O(fieldOptions.getLazy());
                }
                if (fieldOptions.hasDeprecated()) {
                    L(fieldOptions.getDeprecated());
                }
                if (fieldOptions.hasWeak()) {
                    R(fieldOptions.getWeak());
                }
                if (this.J == null) {
                    if (!fieldOptions.uninterpretedOption_.isEmpty()) {
                        if (this.I.isEmpty()) {
                            this.I = fieldOptions.uninterpretedOption_;
                            this.f35321m &= -65;
                        } else {
                            D();
                            this.I.addAll(fieldOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!fieldOptions.uninterpretedOption_.isEmpty()) {
                    if (this.J.j()) {
                        this.J.f();
                        bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = null;
                        this.J = null;
                        this.I = fieldOptions.uninterpretedOption_;
                        this.f35321m &= -65;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = F();
                        }
                        this.J = bpVar;
                    } else {
                        this.J.b(fieldOptions.uninterpretedOption_);
                    }
                }
                t(fieldOptions);
                mo52mergeUnknownFields(fieldOptions.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof FieldOptions) {
                    return H((FieldOptions) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b K(CType cType) {
                cType.getClass();
                this.f35321m |= 1;
                this.C = cType.getNumber();
                onChanged();
                return this;
            }

            public b L(boolean z16) {
                this.f35321m |= 16;
                this.G = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: M, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b N(JSType jSType) {
                jSType.getClass();
                this.f35321m |= 4;
                this.E = jSType.getNumber();
                onChanged();
                return this;
            }

            public b O(boolean z16) {
                this.f35321m |= 8;
                this.F = z16;
                onChanged();
                return this;
            }

            public b P(boolean z16) {
                this.f35321m |= 2;
                this.D = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: Q, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            public b R(boolean z16) {
                this.f35321m |= 32;
                this.H = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.E;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.F.e(FieldOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public FieldOptions build() {
                FieldOptions buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public FieldOptions buildPartial() {
                int i3;
                FieldOptions fieldOptions = new FieldOptions(this);
                int i16 = this.f35321m;
                if ((i16 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                fieldOptions.ctype_ = this.C;
                if ((i16 & 2) != 0) {
                    fieldOptions.packed_ = this.D;
                    i3 |= 2;
                }
                if ((i16 & 4) != 0) {
                    i3 |= 4;
                }
                fieldOptions.jstype_ = this.E;
                if ((i16 & 8) != 0) {
                    fieldOptions.lazy_ = this.F;
                    i3 |= 8;
                }
                if ((i16 & 16) != 0) {
                    fieldOptions.deprecated_ = this.G;
                    i3 |= 16;
                }
                if ((i16 & 32) != 0) {
                    fieldOptions.weak_ = this.H;
                    i3 |= 32;
                }
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.J;
                if (bpVar != null) {
                    fieldOptions.uninterpretedOption_ = bpVar.d();
                } else {
                    if ((this.f35321m & 64) != 0) {
                        this.I = Collections.unmodifiableList(this.I);
                        this.f35321m &= -65;
                    }
                    fieldOptions.uninterpretedOption_ = this.I;
                }
                fieldOptions.bitField0_ = i3;
                onBuilt();
                return fieldOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.C = 0;
                int i3 = this.f35321m & (-2);
                this.D = false;
                this.E = 0;
                this.F = false;
                this.G = false;
                this.H = false;
                this.f35321m = i3 & (-3) & (-5) & (-9) & (-17) & (-33);
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.J;
                if (bpVar == null) {
                    this.I = Collections.emptyList();
                    this.f35321m &= -65;
                } else {
                    bpVar.e();
                }
                return this;
            }

            b() {
                this.C = 0;
                this.E = 0;
                this.I = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = 0;
                this.E = 0;
                this.I = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(FieldOptions fieldOptions) {
            return f35320d.toBuilder().H(fieldOptions);
        }

        public static FieldOptions parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        FieldOptions(GeneratedMessageV3.d<FieldOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FieldOptions parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static FieldOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public FieldOptions getDefaultInstanceForType() {
            return f35320d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35320d ? new b() : new b().H(this);
        }

        public static FieldOptions parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        FieldOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.ctype_ = 0;
            this.jstype_ = 0;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static FieldOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static FieldOptions parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static FieldOptions parseFrom(InputStream inputStream) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static FieldOptions parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        FieldOptions(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 8) {
                                int s16 = kVar.s();
                                if (CType.valueOf(s16) == null) {
                                    g16.r(1, s16);
                                } else {
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.ctype_ = s16;
                                }
                            } else if (J == 16) {
                                this.bitField0_ |= 2;
                                this.packed_ = kVar.p();
                            } else if (J == 24) {
                                this.bitField0_ |= 16;
                                this.deprecated_ = kVar.p();
                            } else if (J == 40) {
                                this.bitField0_ |= 8;
                                this.lazy_ = kVar.p();
                            } else if (J == 48) {
                                int s17 = kVar.s();
                                if (JSType.valueOf(s17) == null) {
                                    g16.r(6, s17);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.jstype_ = s17;
                                }
                            } else if (J == 80) {
                                this.bitField0_ |= 32;
                                this.weak_ = kVar.p();
                            } else if (J != 7994) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                if ((i3 & 64) == 0) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    i3 |= 64;
                                }
                                this.uninterpretedOption_.add(kVar.z(UninterpretedOption.PARSER, tVar));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i3 & 64) != 0) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static FieldOptions parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static FieldOptions parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class FileDescriptorProto extends GeneratedMessageV3 implements ax {
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        public static final int SYNTAX_FIELD_NUMBER = 12;
        public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private ah dependency_;
        private List<EnumDescriptorProto> enumType_;
        private List<FieldDescriptorProto> extension_;
        private byte memoizedIsInitialized;
        private List<DescriptorProto> messageType_;
        private volatile Object name_;
        private FileOptions options_;
        private volatile Object package_;
        private ad.g publicDependency_;
        private List<ServiceDescriptorProto> service_;
        private SourceCodeInfo sourceCodeInfo_;
        private volatile Object syntax_;
        private ad.g weakDependency_;

        /* renamed from: d, reason: collision with root package name */
        private static final FileDescriptorProto f35322d = new FileDescriptorProto();

        @Deprecated
        public static final bg<FileDescriptorProto> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<FileDescriptorProto> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public FileDescriptorProto g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new FileDescriptorProto(kVar, tVar);
            }
        }

        public static FileDescriptorProto getDefaultInstance() {
            return f35322d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f35268c;
        }

        public static b newBuilder() {
            return f35322d.toBuilder();
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FileDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<FileDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FileDescriptorProto)) {
                return super.equals(obj);
            }
            FileDescriptorProto fileDescriptorProto = (FileDescriptorProto) obj;
            if (hasName() != fileDescriptorProto.hasName()) {
                return false;
            }
            if ((hasName() && !getName().equals(fileDescriptorProto.getName())) || hasPackage() != fileDescriptorProto.hasPackage()) {
                return false;
            }
            if ((hasPackage() && !getPackage().equals(fileDescriptorProto.getPackage())) || !m54getDependencyList().equals(fileDescriptorProto.m54getDependencyList()) || !getPublicDependencyList().equals(fileDescriptorProto.getPublicDependencyList()) || !getWeakDependencyList().equals(fileDescriptorProto.getWeakDependencyList()) || !getMessageTypeList().equals(fileDescriptorProto.getMessageTypeList()) || !getEnumTypeList().equals(fileDescriptorProto.getEnumTypeList()) || !getServiceList().equals(fileDescriptorProto.getServiceList()) || !getExtensionList().equals(fileDescriptorProto.getExtensionList()) || hasOptions() != fileDescriptorProto.hasOptions()) {
                return false;
            }
            if ((hasOptions() && !getOptions().equals(fileDescriptorProto.getOptions())) || hasSourceCodeInfo() != fileDescriptorProto.hasSourceCodeInfo()) {
                return false;
            }
            if ((hasSourceCodeInfo() && !getSourceCodeInfo().equals(fileDescriptorProto.getSourceCodeInfo())) || hasSyntax() != fileDescriptorProto.hasSyntax()) {
                return false;
            }
            if ((!hasSyntax() || getSyntax().equals(fileDescriptorProto.getSyntax())) && this.unknownFields.equals(fileDescriptorProto.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getDependency(int i3) {
            return this.dependency_.get(i3);
        }

        public ByteString getDependencyBytes(int i3) {
            return this.dependency_.getByteString(i3);
        }

        public int getDependencyCount() {
            return this.dependency_.size();
        }

        public EnumDescriptorProto getEnumType(int i3) {
            return this.enumType_.get(i3);
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public c getEnumTypeOrBuilder(int i3) {
            return this.enumType_.get(i3);
        }

        public List<? extends c> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        public FieldDescriptorProto getExtension(int i3) {
            return this.extension_.get(i3);
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public h getExtensionOrBuilder(int i3) {
            return this.extension_.get(i3);
        }

        public List<? extends h> getExtensionOrBuilderList() {
            return this.extension_;
        }

        public DescriptorProto getMessageType(int i3) {
            return this.messageType_.get(i3);
        }

        public int getMessageTypeCount() {
            return this.messageType_.size();
        }

        public List<DescriptorProto> getMessageTypeList() {
            return this.messageType_;
        }

        public b getMessageTypeOrBuilder(int i3) {
            return this.messageType_.get(i3);
        }

        public List<? extends b> getMessageTypeOrBuilderList() {
            return this.messageType_;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public FileOptions getOptions() {
            FileOptions fileOptions = this.options_;
            if (fileOptions == null) {
                return FileOptions.getDefaultInstance();
            }
            return fileOptions;
        }

        public j getOptionsOrBuilder() {
            FileOptions fileOptions = this.options_;
            if (fileOptions == null) {
                return FileOptions.getDefaultInstance();
            }
            return fileOptions;
        }

        public String getPackage() {
            Object obj = this.package_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.package_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPackageBytes() {
            Object obj = this.package_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.package_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<FileDescriptorProto> getParserForType() {
            return PARSER;
        }

        public int getPublicDependency(int i3) {
            return this.publicDependency_.getInt(i3);
        }

        public int getPublicDependencyCount() {
            return this.publicDependency_.size();
        }

        public List<Integer> getPublicDependencyList() {
            return this.publicDependency_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) != 0) {
                i3 += GeneratedMessageV3.computeStringSize(2, this.package_);
            }
            int i17 = 0;
            for (int i18 = 0; i18 < this.dependency_.size(); i18++) {
                i17 += GeneratedMessageV3.computeStringSizeNoTag(this.dependency_.c(i18));
            }
            int size = i3 + i17 + (m54getDependencyList().size() * 1);
            for (int i19 = 0; i19 < this.messageType_.size(); i19++) {
                size += CodedOutputStream.G(4, this.messageType_.get(i19));
            }
            for (int i26 = 0; i26 < this.enumType_.size(); i26++) {
                size += CodedOutputStream.G(5, this.enumType_.get(i26));
            }
            for (int i27 = 0; i27 < this.service_.size(); i27++) {
                size += CodedOutputStream.G(6, this.service_.get(i27));
            }
            for (int i28 = 0; i28 < this.extension_.size(); i28++) {
                size += CodedOutputStream.G(7, this.extension_.get(i28));
            }
            if ((this.bitField0_ & 4) != 0) {
                size += CodedOutputStream.G(8, getOptions());
            }
            if ((this.bitField0_ & 8) != 0) {
                size += CodedOutputStream.G(9, getSourceCodeInfo());
            }
            int i29 = 0;
            for (int i36 = 0; i36 < this.publicDependency_.size(); i36++) {
                i29 += CodedOutputStream.y(this.publicDependency_.getInt(i36));
            }
            int size2 = size + i29 + (getPublicDependencyList().size() * 1);
            int i37 = 0;
            for (int i38 = 0; i38 < this.weakDependency_.size(); i38++) {
                i37 += CodedOutputStream.y(this.weakDependency_.getInt(i38));
            }
            int size3 = size2 + i37 + (getWeakDependencyList().size() * 1);
            if ((this.bitField0_ & 16) != 0) {
                size3 += GeneratedMessageV3.computeStringSize(12, this.syntax_);
            }
            int serializedSize = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public ServiceDescriptorProto getService(int i3) {
            return this.service_.get(i3);
        }

        public int getServiceCount() {
            return this.service_.size();
        }

        public List<ServiceDescriptorProto> getServiceList() {
            return this.service_;
        }

        public p getServiceOrBuilder(int i3) {
            return this.service_.get(i3);
        }

        public List<? extends p> getServiceOrBuilderList() {
            return this.service_;
        }

        public SourceCodeInfo getSourceCodeInfo() {
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo_;
            if (sourceCodeInfo == null) {
                return SourceCodeInfo.getDefaultInstance();
            }
            return sourceCodeInfo;
        }

        public r getSourceCodeInfoOrBuilder() {
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo_;
            if (sourceCodeInfo == null) {
                return SourceCodeInfo.getDefaultInstance();
            }
            return sourceCodeInfo;
        }

        public String getSyntax() {
            Object obj = this.syntax_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.syntax_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getSyntaxBytes() {
            Object obj = this.syntax_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.syntax_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public int getWeakDependency(int i3) {
            return this.weakDependency_.getInt(i3);
        }

        public int getWeakDependencyCount() {
            return this.weakDependency_.size();
        }

        public List<Integer> getWeakDependencyList() {
            return this.weakDependency_;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOptions() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasPackage() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasSourceCodeInfo() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasSyntax() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasPackage()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getPackage().hashCode();
            }
            if (getDependencyCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + m54getDependencyList().hashCode();
            }
            if (getPublicDependencyCount() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + getPublicDependencyList().hashCode();
            }
            if (getWeakDependencyCount() > 0) {
                hashCode = (((hashCode * 37) + 11) * 53) + getWeakDependencyList().hashCode();
            }
            if (getMessageTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getMessageTypeList().hashCode();
            }
            if (getEnumTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getEnumTypeList().hashCode();
            }
            if (getServiceCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getServiceList().hashCode();
            }
            if (getExtensionCount() > 0) {
                hashCode = (((hashCode * 37) + 7) * 53) + getExtensionList().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getOptions().hashCode();
            }
            if (hasSourceCodeInfo()) {
                hashCode = (((hashCode * 37) + 9) * 53) + getSourceCodeInfo().hashCode();
            }
            if (hasSyntax()) {
                hashCode = (((hashCode * 37) + 12) * 53) + getSyntax().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f35270d.e(FileDescriptorProto.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getMessageTypeCount(); i3++) {
                if (!getMessageType(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i16 = 0; i16 < getEnumTypeCount(); i16++) {
                if (!getEnumType(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i17 = 0; i17 < getServiceCount(); i17++) {
                if (!getService(i17).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i18 = 0; i18 < getExtensionCount(); i18++) {
                if (!getExtension(i18).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new FileDescriptorProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if ((this.bitField0_ & 2) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.package_);
            }
            for (int i3 = 0; i3 < this.dependency_.size(); i3++) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.dependency_.c(i3));
            }
            for (int i16 = 0; i16 < this.messageType_.size(); i16++) {
                codedOutputStream.K0(4, this.messageType_.get(i16));
            }
            for (int i17 = 0; i17 < this.enumType_.size(); i17++) {
                codedOutputStream.K0(5, this.enumType_.get(i17));
            }
            for (int i18 = 0; i18 < this.service_.size(); i18++) {
                codedOutputStream.K0(6, this.service_.get(i18));
            }
            for (int i19 = 0; i19 < this.extension_.size(); i19++) {
                codedOutputStream.K0(7, this.extension_.get(i19));
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.K0(8, getOptions());
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.K0(9, getSourceCodeInfo());
            }
            for (int i26 = 0; i26 < this.publicDependency_.size(); i26++) {
                codedOutputStream.G0(10, this.publicDependency_.getInt(i26));
            }
            for (int i27 = 0; i27 < this.weakDependency_.size(); i27++) {
                codedOutputStream.G0(11, this.weakDependency_.getInt(i27));
            }
            if ((this.bitField0_ & 16) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.syntax_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements ax {
            private Object C;
            private ah D;
            private ad.g E;
            private ad.g F;
            private List<DescriptorProto> G;
            private bp<DescriptorProto, DescriptorProto.b, b> H;
            private List<EnumDescriptorProto> I;
            private bp<EnumDescriptorProto, EnumDescriptorProto.b, c> J;
            private List<ServiceDescriptorProto> K;
            private bp<ServiceDescriptorProto, ServiceDescriptorProto.b, p> L;
            private List<FieldDescriptorProto> M;
            private bp<FieldDescriptorProto, FieldDescriptorProto.b, h> N;
            private FileOptions P;
            private bu<FileOptions, FileOptions.b, j> Q;
            private SourceCodeInfo R;
            private bu<SourceCodeInfo, SourceCodeInfo.b, r> S;
            private Object T;

            /* renamed from: i, reason: collision with root package name */
            private int f35323i;

            /* renamed from: m, reason: collision with root package name */
            private Object f35324m;

            private void A() {
                if ((this.f35323i & 128) == 0) {
                    this.K = new ArrayList(this.K);
                    this.f35323i |= 128;
                }
            }

            private void B() {
                if ((this.f35323i & 16) == 0) {
                    this.F = GeneratedMessageV3.mutableCopy(this.F);
                    this.f35323i |= 16;
                }
            }

            private bp<EnumDescriptorProto, EnumDescriptorProto.b, c> D() {
                boolean z16;
                if (this.J == null) {
                    List<EnumDescriptorProto> list = this.I;
                    if ((this.f35323i & 64) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.J = new bp<>(list, z16, h(), isClean());
                    this.I = null;
                }
                return this.J;
            }

            private bp<FieldDescriptorProto, FieldDescriptorProto.b, h> E() {
                boolean z16;
                if (this.N == null) {
                    List<FieldDescriptorProto> list = this.M;
                    if ((this.f35323i & 256) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.N = new bp<>(list, z16, h(), isClean());
                    this.M = null;
                }
                return this.N;
            }

            private bp<DescriptorProto, DescriptorProto.b, b> F() {
                boolean z16;
                if (this.H == null) {
                    List<DescriptorProto> list = this.G;
                    if ((this.f35323i & 32) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.H = new bp<>(list, z16, h(), isClean());
                    this.G = null;
                }
                return this.H;
            }

            private bu<FileOptions, FileOptions.b, j> H() {
                if (this.Q == null) {
                    this.Q = new bu<>(G(), h(), isClean());
                    this.P = null;
                }
                return this.Q;
            }

            private bp<ServiceDescriptorProto, ServiceDescriptorProto.b, p> I() {
                boolean z16;
                if (this.L == null) {
                    List<ServiceDescriptorProto> list = this.K;
                    if ((this.f35323i & 128) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.L = new bp<>(list, z16, h(), isClean());
                    this.K = null;
                }
                return this.L;
            }

            private bu<SourceCodeInfo, SourceCodeInfo.b, r> K() {
                if (this.S == null) {
                    this.S = new bu<>(J(), h(), isClean());
                    this.R = null;
                }
                return this.S;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    F();
                    D();
                    I();
                    E();
                    H();
                    K();
                }
            }

            private void v() {
                if ((this.f35323i & 4) == 0) {
                    this.D = new ag(this.D);
                    this.f35323i |= 4;
                }
            }

            private void w() {
                if ((this.f35323i & 64) == 0) {
                    this.I = new ArrayList(this.I);
                    this.f35323i |= 64;
                }
            }

            private void x() {
                if ((this.f35323i & 256) == 0) {
                    this.M = new ArrayList(this.M);
                    this.f35323i |= 256;
                }
            }

            private void y() {
                if ((this.f35323i & 32) == 0) {
                    this.G = new ArrayList(this.G);
                    this.f35323i |= 32;
                }
            }

            private void z() {
                if ((this.f35323i & 8) == 0) {
                    this.E = GeneratedMessageV3.mutableCopy(this.E);
                    this.f35323i |= 8;
                }
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public FileDescriptorProto getDefaultInstanceForType() {
                return FileDescriptorProto.getDefaultInstance();
            }

            public FileOptions G() {
                bu<FileOptions, FileOptions.b, j> buVar = this.Q;
                if (buVar == null) {
                    FileOptions fileOptions = this.P;
                    if (fileOptions == null) {
                        return FileOptions.getDefaultInstance();
                    }
                    return fileOptions;
                }
                return buVar.f();
            }

            public SourceCodeInfo J() {
                bu<SourceCodeInfo, SourceCodeInfo.b, r> buVar = this.S;
                if (buVar == null) {
                    SourceCodeInfo sourceCodeInfo = this.R;
                    if (sourceCodeInfo == null) {
                        return SourceCodeInfo.getDefaultInstance();
                    }
                    return sourceCodeInfo;
                }
                return buVar.f();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                FileDescriptorProto fileDescriptorProto = null;
                try {
                    try {
                        FileDescriptorProto g16 = FileDescriptorProto.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            M(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileDescriptorProto != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    FileDescriptorProto fileDescriptorProto2 = (FileDescriptorProto) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        fileDescriptorProto = fileDescriptorProto2;
                        if (fileDescriptorProto != null) {
                            M(fileDescriptorProto);
                        }
                        throw th;
                    }
                }
            }

            public b M(FileDescriptorProto fileDescriptorProto) {
                bp<DescriptorProto, DescriptorProto.b, b> bpVar;
                bp<EnumDescriptorProto, EnumDescriptorProto.b, c> bpVar2;
                bp<ServiceDescriptorProto, ServiceDescriptorProto.b, p> bpVar3;
                if (fileDescriptorProto == FileDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (fileDescriptorProto.hasName()) {
                    this.f35323i |= 1;
                    this.f35324m = fileDescriptorProto.name_;
                    onChanged();
                }
                if (fileDescriptorProto.hasPackage()) {
                    this.f35323i |= 2;
                    this.C = fileDescriptorProto.package_;
                    onChanged();
                }
                if (!fileDescriptorProto.dependency_.isEmpty()) {
                    if (this.D.isEmpty()) {
                        this.D = fileDescriptorProto.dependency_;
                        this.f35323i &= -5;
                    } else {
                        v();
                        this.D.addAll(fileDescriptorProto.dependency_);
                    }
                    onChanged();
                }
                if (!fileDescriptorProto.publicDependency_.isEmpty()) {
                    if (this.E.isEmpty()) {
                        this.E = fileDescriptorProto.publicDependency_;
                        this.f35323i &= -9;
                    } else {
                        z();
                        this.E.addAll(fileDescriptorProto.publicDependency_);
                    }
                    onChanged();
                }
                if (!fileDescriptorProto.weakDependency_.isEmpty()) {
                    if (this.F.isEmpty()) {
                        this.F = fileDescriptorProto.weakDependency_;
                        this.f35323i &= -17;
                    } else {
                        B();
                        this.F.addAll(fileDescriptorProto.weakDependency_);
                    }
                    onChanged();
                }
                bp<FieldDescriptorProto, FieldDescriptorProto.b, h> bpVar4 = null;
                if (this.H == null) {
                    if (!fileDescriptorProto.messageType_.isEmpty()) {
                        if (this.G.isEmpty()) {
                            this.G = fileDescriptorProto.messageType_;
                            this.f35323i &= -33;
                        } else {
                            y();
                            this.G.addAll(fileDescriptorProto.messageType_);
                        }
                        onChanged();
                    }
                } else if (!fileDescriptorProto.messageType_.isEmpty()) {
                    if (this.H.j()) {
                        this.H.f();
                        this.H = null;
                        this.G = fileDescriptorProto.messageType_;
                        this.f35323i &= -33;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = F();
                        } else {
                            bpVar = null;
                        }
                        this.H = bpVar;
                    } else {
                        this.H.b(fileDescriptorProto.messageType_);
                    }
                }
                if (this.J == null) {
                    if (!fileDescriptorProto.enumType_.isEmpty()) {
                        if (this.I.isEmpty()) {
                            this.I = fileDescriptorProto.enumType_;
                            this.f35323i &= -65;
                        } else {
                            w();
                            this.I.addAll(fileDescriptorProto.enumType_);
                        }
                        onChanged();
                    }
                } else if (!fileDescriptorProto.enumType_.isEmpty()) {
                    if (this.J.j()) {
                        this.J.f();
                        this.J = null;
                        this.I = fileDescriptorProto.enumType_;
                        this.f35323i &= -65;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar2 = D();
                        } else {
                            bpVar2 = null;
                        }
                        this.J = bpVar2;
                    } else {
                        this.J.b(fileDescriptorProto.enumType_);
                    }
                }
                if (this.L == null) {
                    if (!fileDescriptorProto.service_.isEmpty()) {
                        if (this.K.isEmpty()) {
                            this.K = fileDescriptorProto.service_;
                            this.f35323i &= -129;
                        } else {
                            A();
                            this.K.addAll(fileDescriptorProto.service_);
                        }
                        onChanged();
                    }
                } else if (!fileDescriptorProto.service_.isEmpty()) {
                    if (this.L.j()) {
                        this.L.f();
                        this.L = null;
                        this.K = fileDescriptorProto.service_;
                        this.f35323i &= -129;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar3 = I();
                        } else {
                            bpVar3 = null;
                        }
                        this.L = bpVar3;
                    } else {
                        this.L.b(fileDescriptorProto.service_);
                    }
                }
                if (this.N == null) {
                    if (!fileDescriptorProto.extension_.isEmpty()) {
                        if (this.M.isEmpty()) {
                            this.M = fileDescriptorProto.extension_;
                            this.f35323i &= -257;
                        } else {
                            x();
                            this.M.addAll(fileDescriptorProto.extension_);
                        }
                        onChanged();
                    }
                } else if (!fileDescriptorProto.extension_.isEmpty()) {
                    if (this.N.j()) {
                        this.N.f();
                        this.N = null;
                        this.M = fileDescriptorProto.extension_;
                        this.f35323i &= -257;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar4 = E();
                        }
                        this.N = bpVar4;
                    } else {
                        this.N.b(fileDescriptorProto.extension_);
                    }
                }
                if (fileDescriptorProto.hasOptions()) {
                    O(fileDescriptorProto.getOptions());
                }
                if (fileDescriptorProto.hasSourceCodeInfo()) {
                    P(fileDescriptorProto.getSourceCodeInfo());
                }
                if (fileDescriptorProto.hasSyntax()) {
                    this.f35323i |= 2048;
                    this.T = fileDescriptorProto.syntax_;
                    onChanged();
                }
                mo52mergeUnknownFields(fileDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: N, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof FileDescriptorProto) {
                    return M((FileDescriptorProto) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b O(FileOptions fileOptions) {
                FileOptions fileOptions2;
                bu<FileOptions, FileOptions.b, j> buVar = this.Q;
                if (buVar == null) {
                    if ((this.f35323i & 512) != 0 && (fileOptions2 = this.P) != null && fileOptions2 != FileOptions.getDefaultInstance()) {
                        this.P = FileOptions.newBuilder(this.P).H(fileOptions).buildPartial();
                    } else {
                        this.P = fileOptions;
                    }
                    onChanged();
                } else {
                    buVar.g(fileOptions);
                }
                this.f35323i |= 512;
                return this;
            }

            public b P(SourceCodeInfo sourceCodeInfo) {
                SourceCodeInfo sourceCodeInfo2;
                bu<SourceCodeInfo, SourceCodeInfo.b, r> buVar = this.S;
                if (buVar == null) {
                    if ((this.f35323i & 1024) != 0 && (sourceCodeInfo2 = this.R) != null && sourceCodeInfo2 != SourceCodeInfo.getDefaultInstance()) {
                        this.R = SourceCodeInfo.newBuilder(this.R).y(sourceCodeInfo).buildPartial();
                    } else {
                        this.R = sourceCodeInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(sourceCodeInfo);
                }
                this.f35323i |= 1024;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: Q, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: R, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b S(String str) {
                str.getClass();
                this.f35323i |= 1;
                this.f35324m = str;
                onChanged();
                return this;
            }

            public b T(String str) {
                str.getClass();
                this.f35323i |= 2;
                this.C = str;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: U, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f35268c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.f35270d.e(FileDescriptorProto.class, b.class);
            }

            public b n(DescriptorProto descriptorProto) {
                bp<DescriptorProto, DescriptorProto.b, b> bpVar = this.H;
                if (bpVar == null) {
                    descriptorProto.getClass();
                    y();
                    this.G.add(descriptorProto);
                    onChanged();
                } else {
                    bpVar.c(descriptorProto);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public FileDescriptorProto build() {
                FileDescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public FileDescriptorProto buildPartial() {
                int i3;
                FileDescriptorProto fileDescriptorProto = new FileDescriptorProto(this);
                int i16 = this.f35323i;
                if ((i16 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                fileDescriptorProto.name_ = this.f35324m;
                if ((i16 & 2) != 0) {
                    i3 |= 2;
                }
                fileDescriptorProto.package_ = this.C;
                if ((this.f35323i & 4) != 0) {
                    this.D = this.D.getUnmodifiableView();
                    this.f35323i &= -5;
                }
                fileDescriptorProto.dependency_ = this.D;
                if ((this.f35323i & 8) != 0) {
                    this.E.y();
                    this.f35323i &= -9;
                }
                fileDescriptorProto.publicDependency_ = this.E;
                if ((this.f35323i & 16) != 0) {
                    this.F.y();
                    this.f35323i &= -17;
                }
                fileDescriptorProto.weakDependency_ = this.F;
                bp<DescriptorProto, DescriptorProto.b, b> bpVar = this.H;
                if (bpVar != null) {
                    fileDescriptorProto.messageType_ = bpVar.d();
                } else {
                    if ((this.f35323i & 32) != 0) {
                        this.G = Collections.unmodifiableList(this.G);
                        this.f35323i &= -33;
                    }
                    fileDescriptorProto.messageType_ = this.G;
                }
                bp<EnumDescriptorProto, EnumDescriptorProto.b, c> bpVar2 = this.J;
                if (bpVar2 != null) {
                    fileDescriptorProto.enumType_ = bpVar2.d();
                } else {
                    if ((this.f35323i & 64) != 0) {
                        this.I = Collections.unmodifiableList(this.I);
                        this.f35323i &= -65;
                    }
                    fileDescriptorProto.enumType_ = this.I;
                }
                bp<ServiceDescriptorProto, ServiceDescriptorProto.b, p> bpVar3 = this.L;
                if (bpVar3 != null) {
                    fileDescriptorProto.service_ = bpVar3.d();
                } else {
                    if ((this.f35323i & 128) != 0) {
                        this.K = Collections.unmodifiableList(this.K);
                        this.f35323i &= -129;
                    }
                    fileDescriptorProto.service_ = this.K;
                }
                bp<FieldDescriptorProto, FieldDescriptorProto.b, h> bpVar4 = this.N;
                if (bpVar4 != null) {
                    fileDescriptorProto.extension_ = bpVar4.d();
                } else {
                    if ((this.f35323i & 256) != 0) {
                        this.M = Collections.unmodifiableList(this.M);
                        this.f35323i &= -257;
                    }
                    fileDescriptorProto.extension_ = this.M;
                }
                if ((i16 & 512) != 0) {
                    bu<FileOptions, FileOptions.b, j> buVar = this.Q;
                    if (buVar == null) {
                        fileDescriptorProto.options_ = this.P;
                    } else {
                        fileDescriptorProto.options_ = buVar.b();
                    }
                    i3 |= 4;
                }
                if ((i16 & 1024) != 0) {
                    bu<SourceCodeInfo, SourceCodeInfo.b, r> buVar2 = this.S;
                    if (buVar2 == null) {
                        fileDescriptorProto.sourceCodeInfo_ = this.R;
                    } else {
                        fileDescriptorProto.sourceCodeInfo_ = buVar2.b();
                    }
                    i3 |= 8;
                }
                if ((i16 & 2048) != 0) {
                    i3 |= 16;
                }
                fileDescriptorProto.syntax_ = this.T;
                fileDescriptorProto.bitField0_ = i3;
                onBuilt();
                return fileDescriptorProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f35324m = "";
                int i3 = this.f35323i & (-2);
                this.C = "";
                int i16 = i3 & (-3);
                this.f35323i = i16;
                this.D = ag.f35656h;
                this.f35323i = i16 & (-5);
                this.E = GeneratedMessageV3.emptyIntList();
                this.f35323i &= -9;
                this.F = GeneratedMessageV3.emptyIntList();
                this.f35323i &= -17;
                bp<DescriptorProto, DescriptorProto.b, b> bpVar = this.H;
                if (bpVar == null) {
                    this.G = Collections.emptyList();
                    this.f35323i &= -33;
                } else {
                    bpVar.e();
                }
                bp<EnumDescriptorProto, EnumDescriptorProto.b, c> bpVar2 = this.J;
                if (bpVar2 == null) {
                    this.I = Collections.emptyList();
                    this.f35323i &= -65;
                } else {
                    bpVar2.e();
                }
                bp<ServiceDescriptorProto, ServiceDescriptorProto.b, p> bpVar3 = this.L;
                if (bpVar3 == null) {
                    this.K = Collections.emptyList();
                    this.f35323i &= -129;
                } else {
                    bpVar3.e();
                }
                bp<FieldDescriptorProto, FieldDescriptorProto.b, h> bpVar4 = this.N;
                if (bpVar4 == null) {
                    this.M = Collections.emptyList();
                    this.f35323i &= -257;
                } else {
                    bpVar4.e();
                }
                bu<FileOptions, FileOptions.b, j> buVar = this.Q;
                if (buVar == null) {
                    this.P = null;
                } else {
                    buVar.c();
                }
                this.f35323i &= -513;
                bu<SourceCodeInfo, SourceCodeInfo.b, r> buVar2 = this.S;
                if (buVar2 == null) {
                    this.R = null;
                } else {
                    buVar2.c();
                }
                int i17 = this.f35323i & (-1025);
                this.T = "";
                this.f35323i = i17 & MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            b() {
                this.f35324m = "";
                this.C = "";
                this.D = ag.f35656h;
                this.E = GeneratedMessageV3.emptyIntList();
                this.F = GeneratedMessageV3.emptyIntList();
                this.G = Collections.emptyList();
                this.I = Collections.emptyList();
                this.K = Collections.emptyList();
                this.M = Collections.emptyList();
                this.T = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f35324m = "";
                this.C = "";
                this.D = ag.f35656h;
                this.E = GeneratedMessageV3.emptyIntList();
                this.F = GeneratedMessageV3.emptyIntList();
                this.G = Collections.emptyList();
                this.I = Collections.emptyList();
                this.K = Collections.emptyList();
                this.M = Collections.emptyList();
                this.T = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(FileDescriptorProto fileDescriptorProto) {
            return f35322d.toBuilder().M(fileDescriptorProto);
        }

        public static FileDescriptorProto parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        /* renamed from: getDependencyList, reason: merged with bridge method [inline-methods] */
        public bl m54getDependencyList() {
            return this.dependency_;
        }

        FileDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static FileDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public FileDescriptorProto getDefaultInstanceForType() {
            return f35322d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35322d ? new b() : new b().M(this);
        }

        public static FileDescriptorProto parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        FileDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.package_ = "";
            this.dependency_ = ag.f35656h;
            this.publicDependency_ = GeneratedMessageV3.emptyIntList();
            this.weakDependency_ = GeneratedMessageV3.emptyIntList();
            this.messageType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.service_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.syntax_ = "";
        }

        public static FileDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static FileDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static FileDescriptorProto parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static FileDescriptorProto parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static FileDescriptorProto parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0014. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v9 */
        FileDescriptorProto(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            char c16 = 0;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        switch (J) {
                            case 0:
                                z16 = true;
                            case 10:
                                ByteString q16 = kVar.q();
                                this.bitField0_ |= 1;
                                this.name_ = q16;
                            case 18:
                                ByteString q17 = kVar.q();
                                this.bitField0_ |= 2;
                                this.package_ = q17;
                            case 26:
                                ByteString q18 = kVar.q();
                                int i3 = (c16 == true ? 1 : 0) & 4;
                                c16 = c16;
                                if (i3 == 0) {
                                    this.dependency_ = new ag();
                                    c16 = (c16 == true ? 1 : 0) | 4;
                                }
                                this.dependency_.f(q18);
                            case 34:
                                int i16 = (c16 == true ? 1 : 0) & 32;
                                c16 = c16;
                                if (i16 == 0) {
                                    this.messageType_ = new ArrayList();
                                    c16 = (c16 == true ? 1 : 0) | TokenParser.SP;
                                }
                                this.messageType_.add(kVar.z(DescriptorProto.PARSER, tVar));
                            case 42:
                                int i17 = (c16 == true ? 1 : 0) & 64;
                                c16 = c16;
                                if (i17 == 0) {
                                    this.enumType_ = new ArrayList();
                                    c16 = (c16 == true ? 1 : 0) | '@';
                                }
                                this.enumType_.add(kVar.z(EnumDescriptorProto.PARSER, tVar));
                            case 50:
                                int i18 = (c16 == true ? 1 : 0) & 128;
                                c16 = c16;
                                if (i18 == 0) {
                                    this.service_ = new ArrayList();
                                    c16 = (c16 == true ? 1 : 0) | '\u0080';
                                }
                                this.service_.add(kVar.z(ServiceDescriptorProto.PARSER, tVar));
                            case 58:
                                int i19 = (c16 == true ? 1 : 0) & 256;
                                c16 = c16;
                                if (i19 == 0) {
                                    this.extension_ = new ArrayList();
                                    c16 = (c16 == true ? 1 : 0) | '\u0100';
                                }
                                this.extension_.add(kVar.z(FieldDescriptorProto.PARSER, tVar));
                            case 66:
                                FileOptions.b builder = (this.bitField0_ & 4) != 0 ? this.options_.toBuilder() : null;
                                FileOptions fileOptions = (FileOptions) kVar.z(FileOptions.PARSER, tVar);
                                this.options_ = fileOptions;
                                if (builder != null) {
                                    builder.H(fileOptions);
                                    this.options_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            case 74:
                                SourceCodeInfo.b builder2 = (this.bitField0_ & 8) != 0 ? this.sourceCodeInfo_.toBuilder() : null;
                                SourceCodeInfo sourceCodeInfo = (SourceCodeInfo) kVar.z(SourceCodeInfo.PARSER, tVar);
                                this.sourceCodeInfo_ = sourceCodeInfo;
                                if (builder2 != null) {
                                    builder2.y(sourceCodeInfo);
                                    this.sourceCodeInfo_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 8;
                            case 80:
                                int i26 = (c16 == true ? 1 : 0) & 8;
                                c16 = c16;
                                if (i26 == 0) {
                                    this.publicDependency_ = GeneratedMessageV3.newIntList();
                                    c16 = (c16 == true ? 1 : 0) | '\b';
                                }
                                this.publicDependency_.e(kVar.x());
                            case 82:
                                int o16 = kVar.o(kVar.B());
                                int i27 = (c16 == true ? 1 : 0) & 8;
                                c16 = c16;
                                if (i27 == 0) {
                                    c16 = c16;
                                    if (kVar.d() > 0) {
                                        this.publicDependency_ = GeneratedMessageV3.newIntList();
                                        c16 = (c16 == true ? 1 : 0) | '\b';
                                    }
                                }
                                while (kVar.d() > 0) {
                                    this.publicDependency_.e(kVar.x());
                                }
                                kVar.n(o16);
                            case 88:
                                int i28 = (c16 == true ? 1 : 0) & 16;
                                c16 = c16;
                                if (i28 == 0) {
                                    this.weakDependency_ = GeneratedMessageV3.newIntList();
                                    c16 = (c16 == true ? 1 : 0) | 16;
                                }
                                this.weakDependency_.e(kVar.x());
                            case 90:
                                int o17 = kVar.o(kVar.B());
                                int i29 = (c16 == true ? 1 : 0) & 16;
                                c16 = c16;
                                if (i29 == 0) {
                                    c16 = c16;
                                    if (kVar.d() > 0) {
                                        this.weakDependency_ = GeneratedMessageV3.newIntList();
                                        c16 = (c16 == true ? 1 : 0) | 16;
                                    }
                                }
                                while (kVar.d() > 0) {
                                    this.weakDependency_.e(kVar.x());
                                }
                                kVar.n(o17);
                            case 98:
                                ByteString q19 = kVar.q();
                                this.bitField0_ |= 16;
                                this.syntax_ = q19;
                            default:
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    z16 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if (((c16 == true ? 1 : 0) & 4) != 0) {
                        this.dependency_ = this.dependency_.getUnmodifiableView();
                    }
                    if (((c16 == true ? 1 : 0) & 32) != 0) {
                        this.messageType_ = Collections.unmodifiableList(this.messageType_);
                    }
                    if (((c16 == true ? 1 : 0) & 64) != 0) {
                        this.enumType_ = Collections.unmodifiableList(this.enumType_);
                    }
                    if (((c16 == true ? 1 : 0) & 128) != 0) {
                        this.service_ = Collections.unmodifiableList(this.service_);
                    }
                    if (((c16 == true ? 1 : 0) & 256) != 0) {
                        this.extension_ = Collections.unmodifiableList(this.extension_);
                    }
                    if (((c16 == true ? 1 : 0) & 8) != 0) {
                        this.publicDependency_.y();
                    }
                    if (((c16 == true ? 1 : 0) & 16) != 0) {
                        this.weakDependency_.y();
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class FileOptions extends GeneratedMessageV3.ExtendableMessage<FileOptions> implements j {
        public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
        public static final int DEPRECATED_FIELD_NUMBER = 23;
        public static final int GO_PACKAGE_FIELD_NUMBER = 11;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
        public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
        public static final int PHP_GENERIC_SERVICES_FIELD_NUMBER = 42;
        public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
        public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
        public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean ccEnableArenas_;
        private boolean ccGenericServices_;
        private volatile Object csharpNamespace_;
        private boolean deprecated_;
        private volatile Object goPackage_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private volatile Object javaOuterClassname_;
        private volatile Object javaPackage_;
        private boolean javaStringCheckUtf8_;
        private byte memoizedIsInitialized;
        private volatile Object objcClassPrefix_;
        private int optimizeFor_;
        private volatile Object phpClassPrefix_;
        private boolean phpGenericServices_;
        private volatile Object phpMetadataNamespace_;
        private volatile Object phpNamespace_;
        private boolean pyGenericServices_;
        private volatile Object rubyPackage_;
        private volatile Object swiftPrefix_;
        private List<UninterpretedOption> uninterpretedOption_;

        /* renamed from: d, reason: collision with root package name */
        private static final FileOptions f35325d = new FileOptions();

        @Deprecated
        public static final bg<FileOptions> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum OptimizeMode implements bk {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);

            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;
            private final int value;
            private static final ad.d<OptimizeMode> internalValueMap = new a();
            private static final OptimizeMode[] VALUES = values();

            /* loaded from: classes2.dex */
            static class a implements ad.d<OptimizeMode> {
                a() {
                }

                @Override // com.google.protobuf.ad.d
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public OptimizeMode findValueByNumber(int i3) {
                    return OptimizeMode.forNumber(i3);
                }
            }

            OptimizeMode(int i3) {
                this.value = i3;
            }

            public static OptimizeMode forNumber(int i3) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return null;
                        }
                        return LITE_RUNTIME;
                    }
                    return CODE_SIZE;
                }
                return SPEED;
            }

            public static final Descriptors.c getDescriptor() {
                return FileOptions.getDescriptor().p().get(0);
            }

            public static ad.d<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.c getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ad.c
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.d getValueDescriptor() {
                return getDescriptor().o().get(ordinal());
            }

            @Deprecated
            public static OptimizeMode valueOf(int i3) {
                return forNumber(i3);
            }

            public static OptimizeMode valueOf(Descriptors.d dVar) {
                if (dVar.m() == getDescriptor()) {
                    return VALUES[dVar.l()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<FileOptions> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public FileOptions g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new FileOptions(kVar, tVar);
            }
        }

        public static FileOptions getDefaultInstance() {
            return f35325d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.A;
        }

        public static b newBuilder() {
            return f35325d.toBuilder();
        }

        public static FileOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FileOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<FileOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FileOptions)) {
                return super.equals(obj);
            }
            FileOptions fileOptions = (FileOptions) obj;
            if (hasJavaPackage() != fileOptions.hasJavaPackage()) {
                return false;
            }
            if ((hasJavaPackage() && !getJavaPackage().equals(fileOptions.getJavaPackage())) || hasJavaOuterClassname() != fileOptions.hasJavaOuterClassname()) {
                return false;
            }
            if ((hasJavaOuterClassname() && !getJavaOuterClassname().equals(fileOptions.getJavaOuterClassname())) || hasJavaMultipleFiles() != fileOptions.hasJavaMultipleFiles()) {
                return false;
            }
            if ((hasJavaMultipleFiles() && getJavaMultipleFiles() != fileOptions.getJavaMultipleFiles()) || hasJavaGenerateEqualsAndHash() != fileOptions.hasJavaGenerateEqualsAndHash()) {
                return false;
            }
            if ((hasJavaGenerateEqualsAndHash() && getJavaGenerateEqualsAndHash() != fileOptions.getJavaGenerateEqualsAndHash()) || hasJavaStringCheckUtf8() != fileOptions.hasJavaStringCheckUtf8()) {
                return false;
            }
            if ((hasJavaStringCheckUtf8() && getJavaStringCheckUtf8() != fileOptions.getJavaStringCheckUtf8()) || hasOptimizeFor() != fileOptions.hasOptimizeFor()) {
                return false;
            }
            if ((hasOptimizeFor() && this.optimizeFor_ != fileOptions.optimizeFor_) || hasGoPackage() != fileOptions.hasGoPackage()) {
                return false;
            }
            if ((hasGoPackage() && !getGoPackage().equals(fileOptions.getGoPackage())) || hasCcGenericServices() != fileOptions.hasCcGenericServices()) {
                return false;
            }
            if ((hasCcGenericServices() && getCcGenericServices() != fileOptions.getCcGenericServices()) || hasJavaGenericServices() != fileOptions.hasJavaGenericServices()) {
                return false;
            }
            if ((hasJavaGenericServices() && getJavaGenericServices() != fileOptions.getJavaGenericServices()) || hasPyGenericServices() != fileOptions.hasPyGenericServices()) {
                return false;
            }
            if ((hasPyGenericServices() && getPyGenericServices() != fileOptions.getPyGenericServices()) || hasPhpGenericServices() != fileOptions.hasPhpGenericServices()) {
                return false;
            }
            if ((hasPhpGenericServices() && getPhpGenericServices() != fileOptions.getPhpGenericServices()) || hasDeprecated() != fileOptions.hasDeprecated()) {
                return false;
            }
            if ((hasDeprecated() && getDeprecated() != fileOptions.getDeprecated()) || hasCcEnableArenas() != fileOptions.hasCcEnableArenas()) {
                return false;
            }
            if ((hasCcEnableArenas() && getCcEnableArenas() != fileOptions.getCcEnableArenas()) || hasObjcClassPrefix() != fileOptions.hasObjcClassPrefix()) {
                return false;
            }
            if ((hasObjcClassPrefix() && !getObjcClassPrefix().equals(fileOptions.getObjcClassPrefix())) || hasCsharpNamespace() != fileOptions.hasCsharpNamespace()) {
                return false;
            }
            if ((hasCsharpNamespace() && !getCsharpNamespace().equals(fileOptions.getCsharpNamespace())) || hasSwiftPrefix() != fileOptions.hasSwiftPrefix()) {
                return false;
            }
            if ((hasSwiftPrefix() && !getSwiftPrefix().equals(fileOptions.getSwiftPrefix())) || hasPhpClassPrefix() != fileOptions.hasPhpClassPrefix()) {
                return false;
            }
            if ((hasPhpClassPrefix() && !getPhpClassPrefix().equals(fileOptions.getPhpClassPrefix())) || hasPhpNamespace() != fileOptions.hasPhpNamespace()) {
                return false;
            }
            if ((hasPhpNamespace() && !getPhpNamespace().equals(fileOptions.getPhpNamespace())) || hasPhpMetadataNamespace() != fileOptions.hasPhpMetadataNamespace()) {
                return false;
            }
            if ((hasPhpMetadataNamespace() && !getPhpMetadataNamespace().equals(fileOptions.getPhpMetadataNamespace())) || hasRubyPackage() != fileOptions.hasRubyPackage()) {
                return false;
            }
            if ((!hasRubyPackage() || getRubyPackage().equals(fileOptions.getRubyPackage())) && getUninterpretedOptionList().equals(fileOptions.getUninterpretedOptionList()) && this.unknownFields.equals(fileOptions.unknownFields) && getExtensionFields().equals(fileOptions.getExtensionFields())) {
                return true;
            }
            return false;
        }

        public boolean getCcEnableArenas() {
            return this.ccEnableArenas_;
        }

        public boolean getCcGenericServices() {
            return this.ccGenericServices_;
        }

        public String getCsharpNamespace() {
            Object obj = this.csharpNamespace_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.csharpNamespace_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCsharpNamespaceBytes() {
            Object obj = this.csharpNamespace_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.csharpNamespace_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        public String getGoPackage() {
            Object obj = this.goPackage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.goPackage_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getGoPackageBytes() {
            Object obj = this.goPackage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goPackage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Deprecated
        public boolean getJavaGenerateEqualsAndHash() {
            return this.javaGenerateEqualsAndHash_;
        }

        public boolean getJavaGenericServices() {
            return this.javaGenericServices_;
        }

        public boolean getJavaMultipleFiles() {
            return this.javaMultipleFiles_;
        }

        public String getJavaOuterClassname() {
            Object obj = this.javaOuterClassname_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.javaOuterClassname_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getJavaOuterClassnameBytes() {
            Object obj = this.javaOuterClassname_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.javaOuterClassname_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getJavaPackage() {
            Object obj = this.javaPackage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.javaPackage_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getJavaPackageBytes() {
            Object obj = this.javaPackage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.javaPackage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean getJavaStringCheckUtf8() {
            return this.javaStringCheckUtf8_;
        }

        public String getObjcClassPrefix() {
            Object obj = this.objcClassPrefix_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.objcClassPrefix_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getObjcClassPrefixBytes() {
            Object obj = this.objcClassPrefix_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.objcClassPrefix_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public OptimizeMode getOptimizeFor() {
            OptimizeMode valueOf = OptimizeMode.valueOf(this.optimizeFor_);
            if (valueOf == null) {
                return OptimizeMode.SPEED;
            }
            return valueOf;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<FileOptions> getParserForType() {
            return PARSER;
        }

        public String getPhpClassPrefix() {
            Object obj = this.phpClassPrefix_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.phpClassPrefix_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPhpClassPrefixBytes() {
            Object obj = this.phpClassPrefix_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.phpClassPrefix_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean getPhpGenericServices() {
            return this.phpGenericServices_;
        }

        public String getPhpMetadataNamespace() {
            Object obj = this.phpMetadataNamespace_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.phpMetadataNamespace_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPhpMetadataNamespaceBytes() {
            Object obj = this.phpMetadataNamespace_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.phpMetadataNamespace_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getPhpNamespace() {
            Object obj = this.phpNamespace_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.phpNamespace_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPhpNamespaceBytes() {
            Object obj = this.phpNamespace_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.phpNamespace_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean getPyGenericServices() {
            return this.pyGenericServices_;
        }

        public String getRubyPackage() {
            Object obj = this.rubyPackage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.rubyPackage_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getRubyPackageBytes() {
            Object obj = this.rubyPackage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.rubyPackage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = GeneratedMessageV3.computeStringSize(1, this.javaPackage_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) != 0) {
                i3 += GeneratedMessageV3.computeStringSize(8, this.javaOuterClassname_);
            }
            if ((this.bitField0_ & 32) != 0) {
                i3 += CodedOutputStream.l(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i3 += CodedOutputStream.e(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) != 0) {
                i3 += GeneratedMessageV3.computeStringSize(11, this.goPackage_);
            }
            if ((this.bitField0_ & 128) != 0) {
                i3 += CodedOutputStream.e(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) != 0) {
                i3 += CodedOutputStream.e(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) != 0) {
                i3 += CodedOutputStream.e(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) != 0) {
                i3 += CodedOutputStream.e(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 2048) != 0) {
                i3 += CodedOutputStream.e(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) != 0) {
                i3 += CodedOutputStream.e(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 4096) != 0) {
                i3 += CodedOutputStream.e(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 8192) != 0) {
                i3 += GeneratedMessageV3.computeStringSize(36, this.objcClassPrefix_);
            }
            if ((this.bitField0_ & 16384) != 0) {
                i3 += GeneratedMessageV3.computeStringSize(37, this.csharpNamespace_);
            }
            if ((this.bitField0_ & 32768) != 0) {
                i3 += GeneratedMessageV3.computeStringSize(39, this.swiftPrefix_);
            }
            if ((this.bitField0_ & 65536) != 0) {
                i3 += GeneratedMessageV3.computeStringSize(40, this.phpClassPrefix_);
            }
            if ((this.bitField0_ & 131072) != 0) {
                i3 += GeneratedMessageV3.computeStringSize(41, this.phpNamespace_);
            }
            if ((this.bitField0_ & 1024) != 0) {
                i3 += CodedOutputStream.e(42, this.phpGenericServices_);
            }
            if ((this.bitField0_ & 262144) != 0) {
                i3 += GeneratedMessageV3.computeStringSize(44, this.phpMetadataNamespace_);
            }
            if ((this.bitField0_ & 524288) != 0) {
                i3 += GeneratedMessageV3.computeStringSize(45, this.rubyPackage_);
            }
            for (int i17 = 0; i17 < this.uninterpretedOption_.size(); i17++) {
                i3 += CodedOutputStream.G(999, this.uninterpretedOption_.get(i17));
            }
            int extensionsSerializedSize = i3 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public String getSwiftPrefix() {
            Object obj = this.swiftPrefix_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.swiftPrefix_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getSwiftPrefixBytes() {
            Object obj = this.swiftPrefix_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.swiftPrefix_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public UninterpretedOption getUninterpretedOption(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasCcEnableArenas() {
            if ((this.bitField0_ & 4096) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasCcGenericServices() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasCsharpNamespace() {
            if ((this.bitField0_ & 16384) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasDeprecated() {
            if ((this.bitField0_ & 2048) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasGoPackage() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Deprecated
        public boolean hasJavaGenerateEqualsAndHash() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasJavaGenericServices() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasJavaMultipleFiles() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasJavaOuterClassname() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasJavaPackage() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasJavaStringCheckUtf8() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasObjcClassPrefix() {
            if ((this.bitField0_ & 8192) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOptimizeFor() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasPhpClassPrefix() {
            if ((this.bitField0_ & 65536) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasPhpGenericServices() {
            if ((this.bitField0_ & 1024) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasPhpMetadataNamespace() {
            if ((this.bitField0_ & 262144) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasPhpNamespace() {
            if ((this.bitField0_ & 131072) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasPyGenericServices() {
            if ((this.bitField0_ & 512) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasRubyPackage() {
            if ((this.bitField0_ & 524288) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasSwiftPrefix() {
            if ((this.bitField0_ & 32768) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasJavaPackage()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getJavaPackage().hashCode();
            }
            if (hasJavaOuterClassname()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getJavaOuterClassname().hashCode();
            }
            if (hasJavaMultipleFiles()) {
                hashCode = (((hashCode * 37) + 10) * 53) + ad.c(getJavaMultipleFiles());
            }
            if (hasJavaGenerateEqualsAndHash()) {
                hashCode = (((hashCode * 37) + 20) * 53) + ad.c(getJavaGenerateEqualsAndHash());
            }
            if (hasJavaStringCheckUtf8()) {
                hashCode = (((hashCode * 37) + 27) * 53) + ad.c(getJavaStringCheckUtf8());
            }
            if (hasOptimizeFor()) {
                hashCode = (((hashCode * 37) + 9) * 53) + this.optimizeFor_;
            }
            if (hasGoPackage()) {
                hashCode = (((hashCode * 37) + 11) * 53) + getGoPackage().hashCode();
            }
            if (hasCcGenericServices()) {
                hashCode = (((hashCode * 37) + 16) * 53) + ad.c(getCcGenericServices());
            }
            if (hasJavaGenericServices()) {
                hashCode = (((hashCode * 37) + 17) * 53) + ad.c(getJavaGenericServices());
            }
            if (hasPyGenericServices()) {
                hashCode = (((hashCode * 37) + 18) * 53) + ad.c(getPyGenericServices());
            }
            if (hasPhpGenericServices()) {
                hashCode = (((hashCode * 37) + 42) * 53) + ad.c(getPhpGenericServices());
            }
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 23) * 53) + ad.c(getDeprecated());
            }
            if (hasCcEnableArenas()) {
                hashCode = (((hashCode * 37) + 31) * 53) + ad.c(getCcEnableArenas());
            }
            if (hasObjcClassPrefix()) {
                hashCode = (((hashCode * 37) + 36) * 53) + getObjcClassPrefix().hashCode();
            }
            if (hasCsharpNamespace()) {
                hashCode = (((hashCode * 37) + 37) * 53) + getCsharpNamespace().hashCode();
            }
            if (hasSwiftPrefix()) {
                hashCode = (((hashCode * 37) + 39) * 53) + getSwiftPrefix().hashCode();
            }
            if (hasPhpClassPrefix()) {
                hashCode = (((hashCode * 37) + 40) * 53) + getPhpClassPrefix().hashCode();
            }
            if (hasPhpNamespace()) {
                hashCode = (((hashCode * 37) + 41) * 53) + getPhpNamespace().hashCode();
            }
            if (hasPhpMetadataNamespace()) {
                hashCode = (((hashCode * 37) + 44) * 53) + getPhpMetadataNamespace().hashCode();
            }
            if (hasRubyPackage()) {
                hashCode = (((hashCode * 37) + 45) * 53) + getRubyPackage().hashCode();
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, getExtensionFields()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.B.e(FileOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getUninterpretedOptionCount(); i3++) {
                if (!getUninterpretedOption(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new FileOptions();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.javaPackage_);
            }
            if ((this.bitField0_ & 2) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.javaOuterClassname_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputStream.u0(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.m0(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.goPackage_);
            }
            if ((this.bitField0_ & 128) != 0) {
                codedOutputStream.m0(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) != 0) {
                codedOutputStream.m0(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) != 0) {
                codedOutputStream.m0(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.m0(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 2048) != 0) {
                codedOutputStream.m0(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.m0(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 4096) != 0) {
                codedOutputStream.m0(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 8192) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 36, this.objcClassPrefix_);
            }
            if ((this.bitField0_ & 16384) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 37, this.csharpNamespace_);
            }
            if ((this.bitField0_ & 32768) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 39, this.swiftPrefix_);
            }
            if ((this.bitField0_ & 65536) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 40, this.phpClassPrefix_);
            }
            if ((this.bitField0_ & 131072) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 41, this.phpNamespace_);
            }
            if ((this.bitField0_ & 1024) != 0) {
                codedOutputStream.m0(42, this.phpGenericServices_);
            }
            if ((this.bitField0_ & 262144) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 44, this.phpMetadataNamespace_);
            }
            if ((this.bitField0_ & 524288) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 45, this.rubyPackage_);
            }
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                codedOutputStream.K0(999, this.uninterpretedOption_.get(i3));
            }
            newExtensionWriter.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.d<FileOptions, b> implements j {
            private Object C;
            private Object D;
            private boolean E;
            private boolean F;
            private boolean G;
            private int H;
            private Object I;
            private boolean J;
            private boolean K;
            private boolean L;
            private boolean M;
            private boolean N;
            private boolean P;
            private Object Q;
            private Object R;
            private Object S;
            private Object T;
            private Object U;
            private Object V;
            private Object W;
            private List<UninterpretedOption> X;
            private bp<UninterpretedOption, UninterpretedOption.b, s> Y;

            /* renamed from: m, reason: collision with root package name */
            private int f35326m;

            private void D() {
                if ((this.f35326m & 1048576) == 0) {
                    this.X = new ArrayList(this.X);
                    this.f35326m |= 1048576;
                }
            }

            private bp<UninterpretedOption, UninterpretedOption.b, s> F() {
                boolean z16;
                if (this.Y == null) {
                    List<UninterpretedOption> list = this.X;
                    if ((this.f35326m & 1048576) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.Y = new bp<>(list, z16, h(), isClean());
                    this.X = null;
                }
                return this.Y;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    F();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public FileOptions getDefaultInstanceForType() {
                return FileOptions.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                FileOptions fileOptions = null;
                try {
                    try {
                        FileOptions g16 = FileOptions.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            H(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileOptions != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    FileOptions fileOptions2 = (FileOptions) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        fileOptions = fileOptions2;
                        if (fileOptions != null) {
                            H(fileOptions);
                        }
                        throw th;
                    }
                }
            }

            public b H(FileOptions fileOptions) {
                if (fileOptions == FileOptions.getDefaultInstance()) {
                    return this;
                }
                if (fileOptions.hasJavaPackage()) {
                    this.f35326m |= 1;
                    this.C = fileOptions.javaPackage_;
                    onChanged();
                }
                if (fileOptions.hasJavaOuterClassname()) {
                    this.f35326m |= 2;
                    this.D = fileOptions.javaOuterClassname_;
                    onChanged();
                }
                if (fileOptions.hasJavaMultipleFiles()) {
                    Q(fileOptions.getJavaMultipleFiles());
                }
                if (fileOptions.hasJavaGenerateEqualsAndHash()) {
                    O(fileOptions.getJavaGenerateEqualsAndHash());
                }
                if (fileOptions.hasJavaStringCheckUtf8()) {
                    R(fileOptions.getJavaStringCheckUtf8());
                }
                if (fileOptions.hasOptimizeFor()) {
                    S(fileOptions.getOptimizeFor());
                }
                if (fileOptions.hasGoPackage()) {
                    this.f35326m |= 64;
                    this.I = fileOptions.goPackage_;
                    onChanged();
                }
                if (fileOptions.hasCcGenericServices()) {
                    L(fileOptions.getCcGenericServices());
                }
                if (fileOptions.hasJavaGenericServices()) {
                    P(fileOptions.getJavaGenericServices());
                }
                if (fileOptions.hasPyGenericServices()) {
                    U(fileOptions.getPyGenericServices());
                }
                if (fileOptions.hasPhpGenericServices()) {
                    T(fileOptions.getPhpGenericServices());
                }
                if (fileOptions.hasDeprecated()) {
                    M(fileOptions.getDeprecated());
                }
                if (fileOptions.hasCcEnableArenas()) {
                    K(fileOptions.getCcEnableArenas());
                }
                if (fileOptions.hasObjcClassPrefix()) {
                    this.f35326m |= 8192;
                    this.Q = fileOptions.objcClassPrefix_;
                    onChanged();
                }
                if (fileOptions.hasCsharpNamespace()) {
                    this.f35326m |= 16384;
                    this.R = fileOptions.csharpNamespace_;
                    onChanged();
                }
                if (fileOptions.hasSwiftPrefix()) {
                    this.f35326m |= 32768;
                    this.S = fileOptions.swiftPrefix_;
                    onChanged();
                }
                if (fileOptions.hasPhpClassPrefix()) {
                    this.f35326m |= 65536;
                    this.T = fileOptions.phpClassPrefix_;
                    onChanged();
                }
                if (fileOptions.hasPhpNamespace()) {
                    this.f35326m |= 131072;
                    this.U = fileOptions.phpNamespace_;
                    onChanged();
                }
                if (fileOptions.hasPhpMetadataNamespace()) {
                    this.f35326m |= 262144;
                    this.V = fileOptions.phpMetadataNamespace_;
                    onChanged();
                }
                if (fileOptions.hasRubyPackage()) {
                    this.f35326m |= 524288;
                    this.W = fileOptions.rubyPackage_;
                    onChanged();
                }
                if (this.Y == null) {
                    if (!fileOptions.uninterpretedOption_.isEmpty()) {
                        if (this.X.isEmpty()) {
                            this.X = fileOptions.uninterpretedOption_;
                            this.f35326m &= -1048577;
                        } else {
                            D();
                            this.X.addAll(fileOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!fileOptions.uninterpretedOption_.isEmpty()) {
                    if (this.Y.j()) {
                        this.Y.f();
                        bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = null;
                        this.Y = null;
                        this.X = fileOptions.uninterpretedOption_;
                        this.f35326m = (-1048577) & this.f35326m;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = F();
                        }
                        this.Y = bpVar;
                    } else {
                        this.Y.b(fileOptions.uninterpretedOption_);
                    }
                }
                t(fileOptions);
                mo52mergeUnknownFields(fileOptions.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof FileOptions) {
                    return H((FileOptions) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b K(boolean z16) {
                this.f35326m |= 4096;
                this.P = z16;
                onChanged();
                return this;
            }

            public b L(boolean z16) {
                this.f35326m |= 128;
                this.J = z16;
                onChanged();
                return this;
            }

            public b M(boolean z16) {
                this.f35326m |= 2048;
                this.N = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: N, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Deprecated
            public b O(boolean z16) {
                this.f35326m |= 8;
                this.F = z16;
                onChanged();
                return this;
            }

            public b P(boolean z16) {
                this.f35326m |= 256;
                this.K = z16;
                onChanged();
                return this;
            }

            public b Q(boolean z16) {
                this.f35326m |= 4;
                this.E = z16;
                onChanged();
                return this;
            }

            public b R(boolean z16) {
                this.f35326m |= 16;
                this.G = z16;
                onChanged();
                return this;
            }

            public b S(OptimizeMode optimizeMode) {
                optimizeMode.getClass();
                this.f35326m |= 32;
                this.H = optimizeMode.getNumber();
                onChanged();
                return this;
            }

            public b T(boolean z16) {
                this.f35326m |= 1024;
                this.M = z16;
                onChanged();
                return this;
            }

            public b U(boolean z16) {
                this.f35326m |= 512;
                this.L = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: V, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.A;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.B.e(FileOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public FileOptions build() {
                FileOptions buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public FileOptions buildPartial() {
                int i3;
                FileOptions fileOptions = new FileOptions(this);
                int i16 = this.f35326m;
                if ((i16 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                fileOptions.javaPackage_ = this.C;
                if ((i16 & 2) != 0) {
                    i3 |= 2;
                }
                fileOptions.javaOuterClassname_ = this.D;
                if ((i16 & 4) != 0) {
                    fileOptions.javaMultipleFiles_ = this.E;
                    i3 |= 4;
                }
                if ((i16 & 8) != 0) {
                    fileOptions.javaGenerateEqualsAndHash_ = this.F;
                    i3 |= 8;
                }
                if ((i16 & 16) != 0) {
                    fileOptions.javaStringCheckUtf8_ = this.G;
                    i3 |= 16;
                }
                if ((i16 & 32) != 0) {
                    i3 |= 32;
                }
                fileOptions.optimizeFor_ = this.H;
                if ((i16 & 64) != 0) {
                    i3 |= 64;
                }
                fileOptions.goPackage_ = this.I;
                if ((i16 & 128) != 0) {
                    fileOptions.ccGenericServices_ = this.J;
                    i3 |= 128;
                }
                if ((i16 & 256) != 0) {
                    fileOptions.javaGenericServices_ = this.K;
                    i3 |= 256;
                }
                if ((i16 & 512) != 0) {
                    fileOptions.pyGenericServices_ = this.L;
                    i3 |= 512;
                }
                if ((i16 & 1024) != 0) {
                    fileOptions.phpGenericServices_ = this.M;
                    i3 |= 1024;
                }
                if ((i16 & 2048) != 0) {
                    fileOptions.deprecated_ = this.N;
                    i3 |= 2048;
                }
                if ((i16 & 4096) != 0) {
                    fileOptions.ccEnableArenas_ = this.P;
                    i3 |= 4096;
                }
                if ((i16 & 8192) != 0) {
                    i3 |= 8192;
                }
                fileOptions.objcClassPrefix_ = this.Q;
                if ((i16 & 16384) != 0) {
                    i3 |= 16384;
                }
                fileOptions.csharpNamespace_ = this.R;
                if ((i16 & 32768) != 0) {
                    i3 |= 32768;
                }
                fileOptions.swiftPrefix_ = this.S;
                if ((i16 & 65536) != 0) {
                    i3 |= 65536;
                }
                fileOptions.phpClassPrefix_ = this.T;
                if ((i16 & 131072) != 0) {
                    i3 |= 131072;
                }
                fileOptions.phpNamespace_ = this.U;
                if ((i16 & 262144) != 0) {
                    i3 |= 262144;
                }
                fileOptions.phpMetadataNamespace_ = this.V;
                if ((i16 & 524288) != 0) {
                    i3 |= 524288;
                }
                fileOptions.rubyPackage_ = this.W;
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.Y;
                if (bpVar != null) {
                    fileOptions.uninterpretedOption_ = bpVar.d();
                } else {
                    if ((this.f35326m & 1048576) != 0) {
                        this.X = Collections.unmodifiableList(this.X);
                        this.f35326m &= -1048577;
                    }
                    fileOptions.uninterpretedOption_ = this.X;
                }
                fileOptions.bitField0_ = i3;
                onBuilt();
                return fileOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.C = "";
                int i3 = this.f35326m & (-2);
                this.D = "";
                this.E = false;
                this.F = false;
                this.G = false;
                this.H = 1;
                this.I = "";
                this.J = false;
                this.K = false;
                this.L = false;
                this.M = false;
                this.N = false;
                int i16 = i3 & (-3) & (-5) & (-9) & (-17) & (-33) & (-65) & (-129) & (-257) & (-513) & (-1025) & MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
                this.P = false;
                this.Q = "";
                this.R = "";
                this.S = "";
                this.T = "";
                this.U = "";
                this.V = "";
                this.W = "";
                this.f35326m = (-524289) & i16 & (-4097) & (-8193) & (-16385) & (-32769) & (-65537) & (-131073) & (-262145);
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.Y;
                if (bpVar == null) {
                    this.X = Collections.emptyList();
                    this.f35326m &= -1048577;
                } else {
                    bpVar.e();
                }
                return this;
            }

            b() {
                this.C = "";
                this.D = "";
                this.H = 1;
                this.I = "";
                this.Q = "";
                this.R = "";
                this.S = "";
                this.T = "";
                this.U = "";
                this.V = "";
                this.W = "";
                this.X = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = "";
                this.D = "";
                this.H = 1;
                this.I = "";
                this.Q = "";
                this.R = "";
                this.S = "";
                this.T = "";
                this.U = "";
                this.V = "";
                this.W = "";
                this.X = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(FileOptions fileOptions) {
            return f35325d.toBuilder().H(fileOptions);
        }

        public static FileOptions parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        FileOptions(GeneratedMessageV3.d<FileOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FileOptions parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static FileOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public FileOptions getDefaultInstanceForType() {
            return f35325d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35325d ? new b() : new b().H(this);
        }

        public static FileOptions parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        FileOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.javaPackage_ = "";
            this.javaOuterClassname_ = "";
            this.optimizeFor_ = 1;
            this.goPackage_ = "";
            this.objcClassPrefix_ = "";
            this.csharpNamespace_ = "";
            this.swiftPrefix_ = "";
            this.phpClassPrefix_ = "";
            this.phpNamespace_ = "";
            this.phpMetadataNamespace_ = "";
            this.rubyPackage_ = "";
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static FileOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static FileOptions parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static FileOptions parseFrom(InputStream inputStream) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static FileOptions parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static FileOptions parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static FileOptions parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0015. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v3 */
        FileOptions(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            char c16 = 0;
            while (true) {
                char c17 = 0;
                ?? r36 = 1048576;
                if (z16) {
                    return;
                }
                try {
                    try {
                        try {
                            int J = kVar.J();
                            switch (J) {
                                case 0:
                                    z16 = true;
                                case 10:
                                    ByteString q16 = kVar.q();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.javaPackage_ = q16;
                                case 66:
                                    ByteString q17 = kVar.q();
                                    this.bitField0_ |= 2;
                                    this.javaOuterClassname_ = q17;
                                case 72:
                                    int s16 = kVar.s();
                                    if (OptimizeMode.valueOf(s16) == null) {
                                        g16.r(9, s16);
                                    } else {
                                        this.bitField0_ |= 32;
                                        this.optimizeFor_ = s16;
                                    }
                                case 80:
                                    this.bitField0_ |= 4;
                                    this.javaMultipleFiles_ = kVar.p();
                                case 90:
                                    ByteString q18 = kVar.q();
                                    this.bitField0_ |= 64;
                                    this.goPackage_ = q18;
                                case 128:
                                    this.bitField0_ |= 128;
                                    this.ccGenericServices_ = kVar.p();
                                case 136:
                                    this.bitField0_ |= 256;
                                    this.javaGenericServices_ = kVar.p();
                                case 144:
                                    this.bitField0_ |= 512;
                                    this.pyGenericServices_ = kVar.p();
                                case 160:
                                    this.bitField0_ |= 8;
                                    this.javaGenerateEqualsAndHash_ = kVar.p();
                                case 184:
                                    this.bitField0_ |= 2048;
                                    this.deprecated_ = kVar.p();
                                case 216:
                                    this.bitField0_ |= 16;
                                    this.javaStringCheckUtf8_ = kVar.p();
                                case 248:
                                    this.bitField0_ |= 4096;
                                    this.ccEnableArenas_ = kVar.p();
                                case 290:
                                    ByteString q19 = kVar.q();
                                    this.bitField0_ |= 8192;
                                    this.objcClassPrefix_ = q19;
                                case 298:
                                    ByteString q26 = kVar.q();
                                    this.bitField0_ |= 16384;
                                    this.csharpNamespace_ = q26;
                                case 314:
                                    ByteString q27 = kVar.q();
                                    this.bitField0_ |= 32768;
                                    this.swiftPrefix_ = q27;
                                case 322:
                                    ByteString q28 = kVar.q();
                                    this.bitField0_ |= 65536;
                                    this.phpClassPrefix_ = q28;
                                case MapItemKt.ITEM_AVATAR_MIN_WIDTH /* 330 */:
                                    ByteString q29 = kVar.q();
                                    this.bitField0_ |= 131072;
                                    this.phpNamespace_ = q29;
                                case 336:
                                    this.bitField0_ |= 1024;
                                    this.phpGenericServices_ = kVar.p();
                                case com.tencent.luggage.wxa.rf.f.CTRL_INDEX /* 354 */:
                                    ByteString q36 = kVar.q();
                                    this.bitField0_ |= 262144;
                                    this.phpMetadataNamespace_ = q36;
                                case 362:
                                    ByteString q37 = kVar.q();
                                    this.bitField0_ |= 524288;
                                    this.rubyPackage_ = q37;
                                case 7994:
                                    int i3 = (c16 == true ? 1 : 0) & 1048576;
                                    c16 = c16;
                                    if (i3 == 0) {
                                        this.uninterpretedOption_ = new ArrayList();
                                        c16 = (c16 == true ? 1 : 0) | 0;
                                    }
                                    this.uninterpretedOption_.add(kVar.z(UninterpretedOption.PARSER, tVar));
                                default:
                                    r36 = parseUnknownField(kVar, g16, tVar, J);
                                    if (r36 == 0) {
                                        z16 = true;
                                    }
                            }
                        } catch (IOException e16) {
                            throw new InvalidProtocolBufferException(e16).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e17) {
                        throw e17.setUnfinishedMessage(this);
                    }
                } finally {
                    if (((c16 == true ? 1 : 0) & r36) != 0) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class MessageOptions extends GeneratedMessageV3.ExtendableMessage<MessageOptions> implements k {
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int MAP_ENTRY_FIELD_NUMBER = 7;
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean deprecated_;
        private boolean mapEntry_;
        private byte memoizedIsInitialized;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private List<UninterpretedOption> uninterpretedOption_;

        /* renamed from: d, reason: collision with root package name */
        private static final MessageOptions f35327d = new MessageOptions();

        @Deprecated
        public static final bg<MessageOptions> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<MessageOptions> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public MessageOptions g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new MessageOptions(kVar, tVar);
            }
        }

        public static MessageOptions getDefaultInstance() {
            return f35327d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.C;
        }

        public static b newBuilder() {
            return f35327d.toBuilder();
        }

        public static MessageOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MessageOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<MessageOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MessageOptions)) {
                return super.equals(obj);
            }
            MessageOptions messageOptions = (MessageOptions) obj;
            if (hasMessageSetWireFormat() != messageOptions.hasMessageSetWireFormat()) {
                return false;
            }
            if ((hasMessageSetWireFormat() && getMessageSetWireFormat() != messageOptions.getMessageSetWireFormat()) || hasNoStandardDescriptorAccessor() != messageOptions.hasNoStandardDescriptorAccessor()) {
                return false;
            }
            if ((hasNoStandardDescriptorAccessor() && getNoStandardDescriptorAccessor() != messageOptions.getNoStandardDescriptorAccessor()) || hasDeprecated() != messageOptions.hasDeprecated()) {
                return false;
            }
            if ((hasDeprecated() && getDeprecated() != messageOptions.getDeprecated()) || hasMapEntry() != messageOptions.hasMapEntry()) {
                return false;
            }
            if ((!hasMapEntry() || getMapEntry() == messageOptions.getMapEntry()) && getUninterpretedOptionList().equals(messageOptions.getUninterpretedOptionList()) && this.unknownFields.equals(messageOptions.unknownFields) && getExtensionFields().equals(messageOptions.getExtensionFields())) {
                return true;
            }
            return false;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        public boolean getMapEntry() {
            return this.mapEntry_;
        }

        public boolean getMessageSetWireFormat() {
            return this.messageSetWireFormat_;
        }

        public boolean getNoStandardDescriptorAccessor() {
            return this.noStandardDescriptorAccessor_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<MessageOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = CodedOutputStream.e(1, this.messageSetWireFormat_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) != 0) {
                i3 += CodedOutputStream.e(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i3 += CodedOutputStream.e(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) != 0) {
                i3 += CodedOutputStream.e(7, this.mapEntry_);
            }
            for (int i17 = 0; i17 < this.uninterpretedOption_.size(); i17++) {
                i3 += CodedOutputStream.G(999, this.uninterpretedOption_.get(i17));
            }
            int extensionsSerializedSize = i3 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public UninterpretedOption getUninterpretedOption(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasDeprecated() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasMapEntry() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasMessageSetWireFormat() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasNoStandardDescriptorAccessor() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasMessageSetWireFormat()) {
                hashCode = (((hashCode * 37) + 1) * 53) + ad.c(getMessageSetWireFormat());
            }
            if (hasNoStandardDescriptorAccessor()) {
                hashCode = (((hashCode * 37) + 2) * 53) + ad.c(getNoStandardDescriptorAccessor());
            }
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 3) * 53) + ad.c(getDeprecated());
            }
            if (hasMapEntry()) {
                hashCode = (((hashCode * 37) + 7) * 53) + ad.c(getMapEntry());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, getExtensionFields()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.D.e(MessageOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getUninterpretedOptionCount(); i3++) {
                if (!getUninterpretedOption(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new MessageOptions();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.m0(1, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.m0(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.m0(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.m0(7, this.mapEntry_);
            }
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                codedOutputStream.K0(999, this.uninterpretedOption_.get(i3));
            }
            newExtensionWriter.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.d<MessageOptions, b> implements k {
            private boolean C;
            private boolean D;
            private boolean E;
            private boolean F;
            private List<UninterpretedOption> G;
            private bp<UninterpretedOption, UninterpretedOption.b, s> H;

            /* renamed from: m, reason: collision with root package name */
            private int f35328m;

            private void D() {
                if ((this.f35328m & 16) == 0) {
                    this.G = new ArrayList(this.G);
                    this.f35328m |= 16;
                }
            }

            private bp<UninterpretedOption, UninterpretedOption.b, s> F() {
                boolean z16;
                if (this.H == null) {
                    List<UninterpretedOption> list = this.G;
                    if ((this.f35328m & 16) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.H = new bp<>(list, z16, h(), isClean());
                    this.G = null;
                }
                return this.H;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    F();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public MessageOptions getDefaultInstanceForType() {
                return MessageOptions.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                MessageOptions messageOptions = null;
                try {
                    try {
                        MessageOptions g16 = MessageOptions.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            H(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (messageOptions != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    MessageOptions messageOptions2 = (MessageOptions) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        messageOptions = messageOptions2;
                        if (messageOptions != null) {
                            H(messageOptions);
                        }
                        throw th;
                    }
                }
            }

            public b H(MessageOptions messageOptions) {
                if (messageOptions == MessageOptions.getDefaultInstance()) {
                    return this;
                }
                if (messageOptions.hasMessageSetWireFormat()) {
                    N(messageOptions.getMessageSetWireFormat());
                }
                if (messageOptions.hasNoStandardDescriptorAccessor()) {
                    O(messageOptions.getNoStandardDescriptorAccessor());
                }
                if (messageOptions.hasDeprecated()) {
                    K(messageOptions.getDeprecated());
                }
                if (messageOptions.hasMapEntry()) {
                    M(messageOptions.getMapEntry());
                }
                if (this.H == null) {
                    if (!messageOptions.uninterpretedOption_.isEmpty()) {
                        if (this.G.isEmpty()) {
                            this.G = messageOptions.uninterpretedOption_;
                            this.f35328m &= -17;
                        } else {
                            D();
                            this.G.addAll(messageOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!messageOptions.uninterpretedOption_.isEmpty()) {
                    if (this.H.j()) {
                        this.H.f();
                        bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = null;
                        this.H = null;
                        this.G = messageOptions.uninterpretedOption_;
                        this.f35328m &= -17;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = F();
                        }
                        this.H = bpVar;
                    } else {
                        this.H.b(messageOptions.uninterpretedOption_);
                    }
                }
                t(messageOptions);
                mo52mergeUnknownFields(messageOptions.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof MessageOptions) {
                    return H((MessageOptions) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b K(boolean z16) {
                this.f35328m |= 4;
                this.E = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b M(boolean z16) {
                this.f35328m |= 8;
                this.F = z16;
                onChanged();
                return this;
            }

            public b N(boolean z16) {
                this.f35328m |= 1;
                this.C = z16;
                onChanged();
                return this;
            }

            public b O(boolean z16) {
                this.f35328m |= 2;
                this.D = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: P, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.C;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.D.e(MessageOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public MessageOptions build() {
                MessageOptions buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public MessageOptions buildPartial() {
                int i3;
                MessageOptions messageOptions = new MessageOptions(this);
                int i16 = this.f35328m;
                if ((i16 & 1) != 0) {
                    messageOptions.messageSetWireFormat_ = this.C;
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if ((i16 & 2) != 0) {
                    messageOptions.noStandardDescriptorAccessor_ = this.D;
                    i3 |= 2;
                }
                if ((i16 & 4) != 0) {
                    messageOptions.deprecated_ = this.E;
                    i3 |= 4;
                }
                if ((i16 & 8) != 0) {
                    messageOptions.mapEntry_ = this.F;
                    i3 |= 8;
                }
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.H;
                if (bpVar != null) {
                    messageOptions.uninterpretedOption_ = bpVar.d();
                } else {
                    if ((this.f35328m & 16) != 0) {
                        this.G = Collections.unmodifiableList(this.G);
                        this.f35328m &= -17;
                    }
                    messageOptions.uninterpretedOption_ = this.G;
                }
                messageOptions.bitField0_ = i3;
                onBuilt();
                return messageOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.C = false;
                int i3 = this.f35328m & (-2);
                this.D = false;
                this.E = false;
                this.F = false;
                this.f35328m = i3 & (-3) & (-5) & (-9);
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.H;
                if (bpVar == null) {
                    this.G = Collections.emptyList();
                    this.f35328m &= -17;
                } else {
                    bpVar.e();
                }
                return this;
            }

            b() {
                this.G = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.G = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(MessageOptions messageOptions) {
            return f35327d.toBuilder().H(messageOptions);
        }

        public static MessageOptions parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        MessageOptions(GeneratedMessageV3.d<MessageOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MessageOptions parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static MessageOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public MessageOptions getDefaultInstanceForType() {
            return f35327d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35327d ? new b() : new b().H(this);
        }

        public static MessageOptions parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        MessageOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static MessageOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static MessageOptions parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static MessageOptions parseFrom(InputStream inputStream) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        MessageOptions(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 8) {
                                this.bitField0_ |= 1;
                                this.messageSetWireFormat_ = kVar.p();
                            } else if (J == 16) {
                                this.bitField0_ |= 2;
                                this.noStandardDescriptorAccessor_ = kVar.p();
                            } else if (J == 24) {
                                this.bitField0_ |= 4;
                                this.deprecated_ = kVar.p();
                            } else if (J == 56) {
                                this.bitField0_ |= 8;
                                this.mapEntry_ = kVar.p();
                            } else if (J != 7994) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                if ((i3 & 16) == 0) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    i3 |= 16;
                                }
                                this.uninterpretedOption_.add(kVar.z(UninterpretedOption.PARSER, tVar));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i3 & 16) != 0) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static MessageOptions parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static MessageOptions parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static MessageOptions parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class MethodDescriptorProto extends GeneratedMessageV3 implements l {
        public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean clientStreaming_;
        private volatile Object inputType_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private MethodOptions options_;
        private volatile Object outputType_;
        private boolean serverStreaming_;

        /* renamed from: d, reason: collision with root package name */
        private static final MethodDescriptorProto f35329d = new MethodDescriptorProto();

        @Deprecated
        public static final bg<MethodDescriptorProto> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<MethodDescriptorProto> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public MethodDescriptorProto g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new MethodDescriptorProto(kVar, tVar);
            }
        }

        public static MethodDescriptorProto getDefaultInstance() {
            return f35329d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f35291y;
        }

        public static b newBuilder() {
            return f35329d.toBuilder();
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MethodDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<MethodDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MethodDescriptorProto)) {
                return super.equals(obj);
            }
            MethodDescriptorProto methodDescriptorProto = (MethodDescriptorProto) obj;
            if (hasName() != methodDescriptorProto.hasName()) {
                return false;
            }
            if ((hasName() && !getName().equals(methodDescriptorProto.getName())) || hasInputType() != methodDescriptorProto.hasInputType()) {
                return false;
            }
            if ((hasInputType() && !getInputType().equals(methodDescriptorProto.getInputType())) || hasOutputType() != methodDescriptorProto.hasOutputType()) {
                return false;
            }
            if ((hasOutputType() && !getOutputType().equals(methodDescriptorProto.getOutputType())) || hasOptions() != methodDescriptorProto.hasOptions()) {
                return false;
            }
            if ((hasOptions() && !getOptions().equals(methodDescriptorProto.getOptions())) || hasClientStreaming() != methodDescriptorProto.hasClientStreaming()) {
                return false;
            }
            if ((hasClientStreaming() && getClientStreaming() != methodDescriptorProto.getClientStreaming()) || hasServerStreaming() != methodDescriptorProto.hasServerStreaming()) {
                return false;
            }
            if ((!hasServerStreaming() || getServerStreaming() == methodDescriptorProto.getServerStreaming()) && this.unknownFields.equals(methodDescriptorProto.unknownFields)) {
                return true;
            }
            return false;
        }

        public boolean getClientStreaming() {
            return this.clientStreaming_;
        }

        public String getInputType() {
            Object obj = this.inputType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.inputType_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getInputTypeBytes() {
            Object obj = this.inputType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.inputType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public MethodOptions getOptions() {
            MethodOptions methodOptions = this.options_;
            if (methodOptions == null) {
                return MethodOptions.getDefaultInstance();
            }
            return methodOptions;
        }

        public m getOptionsOrBuilder() {
            MethodOptions methodOptions = this.options_;
            if (methodOptions == null) {
                return MethodOptions.getDefaultInstance();
            }
            return methodOptions;
        }

        public String getOutputType() {
            Object obj = this.outputType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.outputType_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getOutputTypeBytes() {
            Object obj = this.outputType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.outputType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<MethodDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if ((this.bitField0_ & 1) != 0) {
                i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            if ((this.bitField0_ & 2) != 0) {
                i16 += GeneratedMessageV3.computeStringSize(2, this.inputType_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i16 += GeneratedMessageV3.computeStringSize(3, this.outputType_);
            }
            if ((this.bitField0_ & 8) != 0) {
                i16 += CodedOutputStream.G(4, getOptions());
            }
            if ((this.bitField0_ & 16) != 0) {
                i16 += CodedOutputStream.e(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) != 0) {
                i16 += CodedOutputStream.e(6, this.serverStreaming_);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public boolean getServerStreaming() {
            return this.serverStreaming_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasClientStreaming() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasInputType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOptions() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOutputType() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasServerStreaming() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasInputType()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getInputType().hashCode();
            }
            if (hasOutputType()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getOutputType().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getOptions().hashCode();
            }
            if (hasClientStreaming()) {
                hashCode = (((hashCode * 37) + 5) * 53) + ad.c(getClientStreaming());
            }
            if (hasServerStreaming()) {
                hashCode = (((hashCode * 37) + 6) * 53) + ad.c(getServerStreaming());
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f35292z.e(MethodDescriptorProto.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new MethodDescriptorProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if ((this.bitField0_ & 2) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.inputType_);
            }
            if ((this.bitField0_ & 4) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.outputType_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.K0(4, getOptions());
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.m0(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputStream.m0(6, this.serverStreaming_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements l {
            private Object C;
            private Object D;
            private MethodOptions E;
            private bu<MethodOptions, MethodOptions.b, m> F;
            private boolean G;
            private boolean H;

            /* renamed from: i, reason: collision with root package name */
            private int f35330i;

            /* renamed from: m, reason: collision with root package name */
            private Object f35331m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private bu<MethodOptions, MethodOptions.b, m> w() {
                if (this.F == null) {
                    this.F = new bu<>(v(), h(), isClean());
                    this.E = null;
                }
                return this.F;
            }

            public b A(MethodOptions methodOptions) {
                MethodOptions methodOptions2;
                bu<MethodOptions, MethodOptions.b, m> buVar = this.F;
                if (buVar == null) {
                    if ((this.f35330i & 8) != 0 && (methodOptions2 = this.E) != null && methodOptions2 != MethodOptions.getDefaultInstance()) {
                        this.E = MethodOptions.newBuilder(this.E).H(methodOptions).buildPartial();
                    } else {
                        this.E = methodOptions;
                    }
                    onChanged();
                } else {
                    buVar.g(methodOptions);
                }
                this.f35330i |= 8;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b C(boolean z16) {
                this.f35330i |= 16;
                this.G = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b E(boolean z16) {
                this.f35330i |= 32;
                this.H = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: F, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f35291y;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.f35292z.e(MethodDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public MethodDescriptorProto build() {
                MethodDescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public MethodDescriptorProto buildPartial() {
                int i3;
                MethodDescriptorProto methodDescriptorProto = new MethodDescriptorProto(this);
                int i16 = this.f35330i;
                if ((i16 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                methodDescriptorProto.name_ = this.f35331m;
                if ((i16 & 2) != 0) {
                    i3 |= 2;
                }
                methodDescriptorProto.inputType_ = this.C;
                if ((i16 & 4) != 0) {
                    i3 |= 4;
                }
                methodDescriptorProto.outputType_ = this.D;
                if ((i16 & 8) != 0) {
                    bu<MethodOptions, MethodOptions.b, m> buVar = this.F;
                    if (buVar == null) {
                        methodDescriptorProto.options_ = this.E;
                    } else {
                        methodDescriptorProto.options_ = buVar.b();
                    }
                    i3 |= 8;
                }
                if ((i16 & 16) != 0) {
                    methodDescriptorProto.clientStreaming_ = this.G;
                    i3 |= 16;
                }
                if ((i16 & 32) != 0) {
                    methodDescriptorProto.serverStreaming_ = this.H;
                    i3 |= 32;
                }
                methodDescriptorProto.bitField0_ = i3;
                onBuilt();
                return methodDescriptorProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f35331m = "";
                int i3 = this.f35330i & (-2);
                this.C = "";
                this.D = "";
                this.f35330i = i3 & (-3) & (-5);
                bu<MethodOptions, MethodOptions.b, m> buVar = this.F;
                if (buVar == null) {
                    this.E = null;
                } else {
                    buVar.c();
                }
                int i16 = this.f35330i & (-9);
                this.G = false;
                this.H = false;
                this.f35330i = i16 & (-17) & (-33);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public MethodDescriptorProto getDefaultInstanceForType() {
                return MethodDescriptorProto.getDefaultInstance();
            }

            public MethodOptions v() {
                bu<MethodOptions, MethodOptions.b, m> buVar = this.F;
                if (buVar == null) {
                    MethodOptions methodOptions = this.E;
                    if (methodOptions == null) {
                        return MethodOptions.getDefaultInstance();
                    }
                    return methodOptions;
                }
                return buVar.f();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                MethodDescriptorProto methodDescriptorProto = null;
                try {
                    try {
                        MethodDescriptorProto g16 = MethodDescriptorProto.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            y(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (methodDescriptorProto != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    MethodDescriptorProto methodDescriptorProto2 = (MethodDescriptorProto) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        methodDescriptorProto = methodDescriptorProto2;
                        if (methodDescriptorProto != null) {
                            y(methodDescriptorProto);
                        }
                        throw th;
                    }
                }
            }

            public b y(MethodDescriptorProto methodDescriptorProto) {
                if (methodDescriptorProto == MethodDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (methodDescriptorProto.hasName()) {
                    this.f35330i |= 1;
                    this.f35331m = methodDescriptorProto.name_;
                    onChanged();
                }
                if (methodDescriptorProto.hasInputType()) {
                    this.f35330i |= 2;
                    this.C = methodDescriptorProto.inputType_;
                    onChanged();
                }
                if (methodDescriptorProto.hasOutputType()) {
                    this.f35330i |= 4;
                    this.D = methodDescriptorProto.outputType_;
                    onChanged();
                }
                if (methodDescriptorProto.hasOptions()) {
                    A(methodDescriptorProto.getOptions());
                }
                if (methodDescriptorProto.hasClientStreaming()) {
                    C(methodDescriptorProto.getClientStreaming());
                }
                if (methodDescriptorProto.hasServerStreaming()) {
                    E(methodDescriptorProto.getServerStreaming());
                }
                mo52mergeUnknownFields(methodDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof MethodDescriptorProto) {
                    return y((MethodDescriptorProto) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            b() {
                this.f35331m = "";
                this.C = "";
                this.D = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f35331m = "";
                this.C = "";
                this.D = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(MethodDescriptorProto methodDescriptorProto) {
            return f35329d.toBuilder().y(methodDescriptorProto);
        }

        public static MethodDescriptorProto parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        MethodDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static MethodDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public MethodDescriptorProto getDefaultInstanceForType() {
            return f35329d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35329d ? new b() : new b().y(this);
        }

        public static MethodDescriptorProto parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        MethodDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.inputType_ = "";
            this.outputType_ = "";
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static MethodDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MethodDescriptorProto parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        MethodDescriptorProto(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J == 10) {
                                    ByteString q16 = kVar.q();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.name_ = q16;
                                } else if (J == 18) {
                                    ByteString q17 = kVar.q();
                                    this.bitField0_ |= 2;
                                    this.inputType_ = q17;
                                } else if (J == 26) {
                                    ByteString q18 = kVar.q();
                                    this.bitField0_ |= 4;
                                    this.outputType_ = q18;
                                } else if (J == 34) {
                                    MethodOptions.b builder = (this.bitField0_ & 8) != 0 ? this.options_.toBuilder() : null;
                                    MethodOptions methodOptions = (MethodOptions) kVar.z(MethodOptions.PARSER, tVar);
                                    this.options_ = methodOptions;
                                    if (builder != null) {
                                        builder.H(methodOptions);
                                        this.options_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 8;
                                } else if (J == 40) {
                                    this.bitField0_ |= 16;
                                    this.clientStreaming_ = kVar.p();
                                } else if (J != 48) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.bitField0_ |= 32;
                                    this.serverStreaming_ = kVar.p();
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        }
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static MethodDescriptorProto parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static MethodDescriptorProto parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class MethodOptions extends GeneratedMessageV3.ExtendableMessage<MethodOptions> implements m {
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean deprecated_;
        private int idempotencyLevel_;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;

        /* renamed from: d, reason: collision with root package name */
        private static final MethodOptions f35332d = new MethodOptions();

        @Deprecated
        public static final bg<MethodOptions> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum IdempotencyLevel implements bk {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);

            public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
            public static final int IDEMPOTENT_VALUE = 2;
            public static final int NO_SIDE_EFFECTS_VALUE = 1;
            private final int value;
            private static final ad.d<IdempotencyLevel> internalValueMap = new a();
            private static final IdempotencyLevel[] VALUES = values();

            /* loaded from: classes2.dex */
            static class a implements ad.d<IdempotencyLevel> {
                a() {
                }

                @Override // com.google.protobuf.ad.d
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public IdempotencyLevel findValueByNumber(int i3) {
                    return IdempotencyLevel.forNumber(i3);
                }
            }

            IdempotencyLevel(int i3) {
                this.value = i3;
            }

            public static IdempotencyLevel forNumber(int i3) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return null;
                        }
                        return IDEMPOTENT;
                    }
                    return NO_SIDE_EFFECTS;
                }
                return IDEMPOTENCY_UNKNOWN;
            }

            public static final Descriptors.c getDescriptor() {
                return MethodOptions.getDescriptor().p().get(0);
            }

            public static ad.d<IdempotencyLevel> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.c getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ad.c
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.d getValueDescriptor() {
                return getDescriptor().o().get(ordinal());
            }

            @Deprecated
            public static IdempotencyLevel valueOf(int i3) {
                return forNumber(i3);
            }

            public static IdempotencyLevel valueOf(Descriptors.d dVar) {
                if (dVar.m() == getDescriptor()) {
                    return VALUES[dVar.l()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<MethodOptions> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public MethodOptions g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new MethodOptions(kVar, tVar);
            }
        }

        public static MethodOptions getDefaultInstance() {
            return f35332d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.O;
        }

        public static b newBuilder() {
            return f35332d.toBuilder();
        }

        public static MethodOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MethodOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<MethodOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MethodOptions)) {
                return super.equals(obj);
            }
            MethodOptions methodOptions = (MethodOptions) obj;
            if (hasDeprecated() != methodOptions.hasDeprecated()) {
                return false;
            }
            if ((hasDeprecated() && getDeprecated() != methodOptions.getDeprecated()) || hasIdempotencyLevel() != methodOptions.hasIdempotencyLevel()) {
                return false;
            }
            if ((!hasIdempotencyLevel() || this.idempotencyLevel_ == methodOptions.idempotencyLevel_) && getUninterpretedOptionList().equals(methodOptions.getUninterpretedOptionList()) && this.unknownFields.equals(methodOptions.unknownFields) && getExtensionFields().equals(methodOptions.getExtensionFields())) {
                return true;
            }
            return false;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        public IdempotencyLevel getIdempotencyLevel() {
            IdempotencyLevel valueOf = IdempotencyLevel.valueOf(this.idempotencyLevel_);
            if (valueOf == null) {
                return IdempotencyLevel.IDEMPOTENCY_UNKNOWN;
            }
            return valueOf;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<MethodOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = CodedOutputStream.e(33, this.deprecated_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) != 0) {
                i3 += CodedOutputStream.l(34, this.idempotencyLevel_);
            }
            for (int i17 = 0; i17 < this.uninterpretedOption_.size(); i17++) {
                i3 += CodedOutputStream.G(999, this.uninterpretedOption_.get(i17));
            }
            int extensionsSerializedSize = i3 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public UninterpretedOption getUninterpretedOption(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasDeprecated() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasIdempotencyLevel() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 33) * 53) + ad.c(getDeprecated());
            }
            if (hasIdempotencyLevel()) {
                hashCode = (((hashCode * 37) + 34) * 53) + this.idempotencyLevel_;
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, getExtensionFields()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.P.e(MethodOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getUninterpretedOptionCount(); i3++) {
                if (!getUninterpretedOption(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new MethodOptions();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.m0(33, this.deprecated_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.u0(34, this.idempotencyLevel_);
            }
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                codedOutputStream.K0(999, this.uninterpretedOption_.get(i3));
            }
            newExtensionWriter.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.d<MethodOptions, b> implements m {
            private boolean C;
            private int D;
            private List<UninterpretedOption> E;
            private bp<UninterpretedOption, UninterpretedOption.b, s> F;

            /* renamed from: m, reason: collision with root package name */
            private int f35333m;

            private void D() {
                if ((this.f35333m & 4) == 0) {
                    this.E = new ArrayList(this.E);
                    this.f35333m |= 4;
                }
            }

            private bp<UninterpretedOption, UninterpretedOption.b, s> F() {
                boolean z16;
                if (this.F == null) {
                    List<UninterpretedOption> list = this.E;
                    if ((this.f35333m & 4) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.F = new bp<>(list, z16, h(), isClean());
                    this.E = null;
                }
                return this.F;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    F();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public MethodOptions getDefaultInstanceForType() {
                return MethodOptions.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                MethodOptions methodOptions = null;
                try {
                    try {
                        MethodOptions g16 = MethodOptions.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            H(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (methodOptions != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    MethodOptions methodOptions2 = (MethodOptions) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        methodOptions = methodOptions2;
                        if (methodOptions != null) {
                            H(methodOptions);
                        }
                        throw th;
                    }
                }
            }

            public b H(MethodOptions methodOptions) {
                if (methodOptions == MethodOptions.getDefaultInstance()) {
                    return this;
                }
                if (methodOptions.hasDeprecated()) {
                    K(methodOptions.getDeprecated());
                }
                if (methodOptions.hasIdempotencyLevel()) {
                    M(methodOptions.getIdempotencyLevel());
                }
                if (this.F == null) {
                    if (!methodOptions.uninterpretedOption_.isEmpty()) {
                        if (this.E.isEmpty()) {
                            this.E = methodOptions.uninterpretedOption_;
                            this.f35333m &= -5;
                        } else {
                            D();
                            this.E.addAll(methodOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!methodOptions.uninterpretedOption_.isEmpty()) {
                    if (this.F.j()) {
                        this.F.f();
                        bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = null;
                        this.F = null;
                        this.E = methodOptions.uninterpretedOption_;
                        this.f35333m &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = F();
                        }
                        this.F = bpVar;
                    } else {
                        this.F.b(methodOptions.uninterpretedOption_);
                    }
                }
                t(methodOptions);
                mo52mergeUnknownFields(methodOptions.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof MethodOptions) {
                    return H((MethodOptions) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b K(boolean z16) {
                this.f35333m |= 1;
                this.C = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b M(IdempotencyLevel idempotencyLevel) {
                idempotencyLevel.getClass();
                this.f35333m |= 2;
                this.D = idempotencyLevel.getNumber();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: N, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.O;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.P.e(MethodOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public MethodOptions build() {
                MethodOptions buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public MethodOptions buildPartial() {
                int i3;
                MethodOptions methodOptions = new MethodOptions(this);
                int i16 = this.f35333m;
                if ((i16 & 1) != 0) {
                    methodOptions.deprecated_ = this.C;
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if ((i16 & 2) != 0) {
                    i3 |= 2;
                }
                methodOptions.idempotencyLevel_ = this.D;
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.F;
                if (bpVar != null) {
                    methodOptions.uninterpretedOption_ = bpVar.d();
                } else {
                    if ((this.f35333m & 4) != 0) {
                        this.E = Collections.unmodifiableList(this.E);
                        this.f35333m &= -5;
                    }
                    methodOptions.uninterpretedOption_ = this.E;
                }
                methodOptions.bitField0_ = i3;
                onBuilt();
                return methodOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.C = false;
                int i3 = this.f35333m & (-2);
                this.D = 0;
                this.f35333m = i3 & (-3);
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.F;
                if (bpVar == null) {
                    this.E = Collections.emptyList();
                    this.f35333m &= -5;
                } else {
                    bpVar.e();
                }
                return this;
            }

            b() {
                this.D = 0;
                this.E = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.D = 0;
                this.E = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(MethodOptions methodOptions) {
            return f35332d.toBuilder().H(methodOptions);
        }

        public static MethodOptions parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        MethodOptions(GeneratedMessageV3.d<MethodOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MethodOptions parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static MethodOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public MethodOptions getDefaultInstanceForType() {
            return f35332d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35332d ? new b() : new b().H(this);
        }

        public static MethodOptions parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        MethodOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.idempotencyLevel_ = 0;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static MethodOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static MethodOptions parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static MethodOptions parseFrom(InputStream inputStream) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        MethodOptions(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 264) {
                                this.bitField0_ |= 1;
                                this.deprecated_ = kVar.p();
                            } else if (J == 272) {
                                int s16 = kVar.s();
                                if (IdempotencyLevel.valueOf(s16) == null) {
                                    g16.r(34, s16);
                                } else {
                                    this.bitField0_ |= 2;
                                    this.idempotencyLevel_ = s16;
                                }
                            } else if (J != 7994) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                if ((i3 & 4) == 0) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    i3 |= 4;
                                }
                                this.uninterpretedOption_.add(kVar.z(UninterpretedOption.PARSER, tVar));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i3 & 4) != 0) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static MethodOptions parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static MethodOptions parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static MethodOptions parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class OneofDescriptorProto extends GeneratedMessageV3 implements n {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private OneofOptions options_;

        /* renamed from: d, reason: collision with root package name */
        private static final OneofDescriptorProto f35334d = new OneofDescriptorProto();

        @Deprecated
        public static final bg<OneofDescriptorProto> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<OneofDescriptorProto> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public OneofDescriptorProto g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new OneofDescriptorProto(kVar, tVar);
            }
        }

        public static OneofDescriptorProto getDefaultInstance() {
            return f35334d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f35281o;
        }

        public static b newBuilder() {
            return f35334d.toBuilder();
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static OneofDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<OneofDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OneofDescriptorProto)) {
                return super.equals(obj);
            }
            OneofDescriptorProto oneofDescriptorProto = (OneofDescriptorProto) obj;
            if (hasName() != oneofDescriptorProto.hasName()) {
                return false;
            }
            if ((hasName() && !getName().equals(oneofDescriptorProto.getName())) || hasOptions() != oneofDescriptorProto.hasOptions()) {
                return false;
            }
            if ((!hasOptions() || getOptions().equals(oneofDescriptorProto.getOptions())) && this.unknownFields.equals(oneofDescriptorProto.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public OneofOptions getOptions() {
            OneofOptions oneofOptions = this.options_;
            if (oneofOptions == null) {
                return OneofOptions.getDefaultInstance();
            }
            return oneofOptions;
        }

        public o getOptionsOrBuilder() {
            OneofOptions oneofOptions = this.options_;
            if (oneofOptions == null) {
                return OneofOptions.getDefaultInstance();
            }
            return oneofOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<OneofDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if ((this.bitField0_ & 1) != 0) {
                i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            if ((this.bitField0_ & 2) != 0) {
                i16 += CodedOutputStream.G(2, getOptions());
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOptions() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getOptions().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f35282p.e(OneofDescriptorProto.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new OneofDescriptorProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.K0(2, getOptions());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements n {
            private OneofOptions C;
            private bu<OneofOptions, OneofOptions.b, o> D;

            /* renamed from: i, reason: collision with root package name */
            private int f35335i;

            /* renamed from: m, reason: collision with root package name */
            private Object f35336m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private bu<OneofOptions, OneofOptions.b, o> w() {
                if (this.D == null) {
                    this.D = new bu<>(v(), h(), isClean());
                    this.C = null;
                }
                return this.D;
            }

            public b A(OneofOptions oneofOptions) {
                OneofOptions oneofOptions2;
                bu<OneofOptions, OneofOptions.b, o> buVar = this.D;
                if (buVar == null) {
                    if ((this.f35335i & 2) != 0 && (oneofOptions2 = this.C) != null && oneofOptions2 != OneofOptions.getDefaultInstance()) {
                        this.C = OneofOptions.newBuilder(this.C).H(oneofOptions).buildPartial();
                    } else {
                        this.C = oneofOptions;
                    }
                    onChanged();
                } else {
                    buVar.g(oneofOptions);
                }
                this.f35335i |= 2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f35281o;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.f35282p.e(OneofDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public OneofDescriptorProto build() {
                OneofDescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public OneofDescriptorProto buildPartial() {
                int i3;
                OneofDescriptorProto oneofDescriptorProto = new OneofDescriptorProto(this);
                int i16 = this.f35335i;
                if ((i16 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                oneofDescriptorProto.name_ = this.f35336m;
                if ((i16 & 2) != 0) {
                    bu<OneofOptions, OneofOptions.b, o> buVar = this.D;
                    if (buVar == null) {
                        oneofDescriptorProto.options_ = this.C;
                    } else {
                        oneofDescriptorProto.options_ = buVar.b();
                    }
                    i3 |= 2;
                }
                oneofDescriptorProto.bitField0_ = i3;
                onBuilt();
                return oneofDescriptorProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f35336m = "";
                this.f35335i &= -2;
                bu<OneofOptions, OneofOptions.b, o> buVar = this.D;
                if (buVar == null) {
                    this.C = null;
                } else {
                    buVar.c();
                }
                this.f35335i &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public OneofDescriptorProto getDefaultInstanceForType() {
                return OneofDescriptorProto.getDefaultInstance();
            }

            public OneofOptions v() {
                bu<OneofOptions, OneofOptions.b, o> buVar = this.D;
                if (buVar == null) {
                    OneofOptions oneofOptions = this.C;
                    if (oneofOptions == null) {
                        return OneofOptions.getDefaultInstance();
                    }
                    return oneofOptions;
                }
                return buVar.f();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                OneofDescriptorProto oneofDescriptorProto = null;
                try {
                    try {
                        OneofDescriptorProto g16 = OneofDescriptorProto.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            y(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (oneofDescriptorProto != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    OneofDescriptorProto oneofDescriptorProto2 = (OneofDescriptorProto) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        oneofDescriptorProto = oneofDescriptorProto2;
                        if (oneofDescriptorProto != null) {
                            y(oneofDescriptorProto);
                        }
                        throw th;
                    }
                }
            }

            public b y(OneofDescriptorProto oneofDescriptorProto) {
                if (oneofDescriptorProto == OneofDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (oneofDescriptorProto.hasName()) {
                    this.f35335i |= 1;
                    this.f35336m = oneofDescriptorProto.name_;
                    onChanged();
                }
                if (oneofDescriptorProto.hasOptions()) {
                    A(oneofDescriptorProto.getOptions());
                }
                mo52mergeUnknownFields(oneofDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof OneofDescriptorProto) {
                    return y((OneofDescriptorProto) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            b() {
                this.f35336m = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f35336m = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(OneofDescriptorProto oneofDescriptorProto) {
            return f35334d.toBuilder().y(oneofDescriptorProto);
        }

        public static OneofDescriptorProto parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        OneofDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static OneofDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public OneofDescriptorProto getDefaultInstanceForType() {
            return f35334d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35334d ? new b() : new b().y(this);
        }

        public static OneofDescriptorProto parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        OneofDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static OneofDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        OneofDescriptorProto(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 10) {
                                ByteString q16 = kVar.q();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.name_ = q16;
                            } else if (J != 18) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                OneofOptions.b builder = (this.bitField0_ & 2) != 0 ? this.options_.toBuilder() : null;
                                OneofOptions oneofOptions = (OneofOptions) kVar.z(OneofOptions.PARSER, tVar);
                                this.options_ = oneofOptions;
                                if (builder != null) {
                                    builder.H(oneofOptions);
                                    this.options_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static OneofDescriptorProto parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static OneofDescriptorProto parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static OneofDescriptorProto parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class OneofOptions extends GeneratedMessageV3.ExtendableMessage<OneofOptions> implements o {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;

        /* renamed from: d, reason: collision with root package name */
        private static final OneofOptions f35337d = new OneofOptions();

        @Deprecated
        public static final bg<OneofOptions> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<OneofOptions> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public OneofOptions g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new OneofOptions(kVar, tVar);
            }
        }

        public static OneofOptions getDefaultInstance() {
            return f35337d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.G;
        }

        public static b newBuilder() {
            return f35337d.toBuilder();
        }

        public static OneofOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static OneofOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<OneofOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OneofOptions)) {
                return super.equals(obj);
            }
            OneofOptions oneofOptions = (OneofOptions) obj;
            if (getUninterpretedOptionList().equals(oneofOptions.getUninterpretedOptionList()) && this.unknownFields.equals(oneofOptions.unknownFields) && getExtensionFields().equals(oneofOptions.getExtensionFields())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<OneofOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.uninterpretedOption_.size(); i17++) {
                i16 += CodedOutputStream.G(999, this.uninterpretedOption_.get(i17));
            }
            int extensionsSerializedSize = i16 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public UninterpretedOption getUninterpretedOption(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, getExtensionFields()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.H.e(OneofOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getUninterpretedOptionCount(); i3++) {
                if (!getUninterpretedOption(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new OneofOptions();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                codedOutputStream.K0(999, this.uninterpretedOption_.get(i3));
            }
            newExtensionWriter.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.d<OneofOptions, b> implements o {
            private List<UninterpretedOption> C;
            private bp<UninterpretedOption, UninterpretedOption.b, s> D;

            /* renamed from: m, reason: collision with root package name */
            private int f35338m;

            private void D() {
                if ((this.f35338m & 1) == 0) {
                    this.C = new ArrayList(this.C);
                    this.f35338m |= 1;
                }
            }

            private bp<UninterpretedOption, UninterpretedOption.b, s> F() {
                if (this.D == null) {
                    List<UninterpretedOption> list = this.C;
                    boolean z16 = true;
                    if ((this.f35338m & 1) == 0) {
                        z16 = false;
                    }
                    this.D = new bp<>(list, z16, h(), isClean());
                    this.C = null;
                }
                return this.D;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    F();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public OneofOptions getDefaultInstanceForType() {
                return OneofOptions.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                OneofOptions oneofOptions = null;
                try {
                    try {
                        OneofOptions g16 = OneofOptions.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            H(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (oneofOptions != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    OneofOptions oneofOptions2 = (OneofOptions) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        oneofOptions = oneofOptions2;
                        if (oneofOptions != null) {
                            H(oneofOptions);
                        }
                        throw th;
                    }
                }
            }

            public b H(OneofOptions oneofOptions) {
                if (oneofOptions == OneofOptions.getDefaultInstance()) {
                    return this;
                }
                if (this.D == null) {
                    if (!oneofOptions.uninterpretedOption_.isEmpty()) {
                        if (this.C.isEmpty()) {
                            this.C = oneofOptions.uninterpretedOption_;
                            this.f35338m &= -2;
                        } else {
                            D();
                            this.C.addAll(oneofOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!oneofOptions.uninterpretedOption_.isEmpty()) {
                    if (this.D.j()) {
                        this.D.f();
                        bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = null;
                        this.D = null;
                        this.C = oneofOptions.uninterpretedOption_;
                        this.f35338m &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = F();
                        }
                        this.D = bpVar;
                    } else {
                        this.D.b(oneofOptions.uninterpretedOption_);
                    }
                }
                t(oneofOptions);
                mo52mergeUnknownFields(oneofOptions.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof OneofOptions) {
                    return H((OneofOptions) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: K, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.G;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.H.e(OneofOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public OneofOptions build() {
                OneofOptions buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public OneofOptions buildPartial() {
                OneofOptions oneofOptions = new OneofOptions(this);
                int i3 = this.f35338m;
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.D;
                if (bpVar != null) {
                    oneofOptions.uninterpretedOption_ = bpVar.d();
                } else {
                    if ((i3 & 1) != 0) {
                        this.C = Collections.unmodifiableList(this.C);
                        this.f35338m &= -2;
                    }
                    oneofOptions.uninterpretedOption_ = this.C;
                }
                onBuilt();
                return oneofOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.D;
                if (bpVar == null) {
                    this.C = Collections.emptyList();
                    this.f35338m &= -2;
                } else {
                    bpVar.e();
                }
                return this;
            }

            b() {
                this.C = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(OneofOptions oneofOptions) {
            return f35337d.toBuilder().H(oneofOptions);
        }

        public static OneofOptions parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        OneofOptions(GeneratedMessageV3.d<OneofOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static OneofOptions parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static OneofOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public OneofOptions getDefaultInstanceForType() {
            return f35337d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35337d ? new b() : new b().H(this);
        }

        public static OneofOptions parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        OneofOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static OneofOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static OneofOptions parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static OneofOptions parseFrom(InputStream inputStream) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        OneofOptions(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J != 7994) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                if (!(z17 & true)) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.uninterpretedOption_.add(kVar.z(UninterpretedOption.PARSER, tVar));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z17 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static OneofOptions parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static OneofOptions parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static OneofOptions parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ServiceDescriptorProto extends GeneratedMessageV3 implements p {
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private List<MethodDescriptorProto> method_;
        private volatile Object name_;
        private ServiceOptions options_;

        /* renamed from: d, reason: collision with root package name */
        private static final ServiceDescriptorProto f35339d = new ServiceDescriptorProto();

        @Deprecated
        public static final bg<ServiceDescriptorProto> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<ServiceDescriptorProto> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ServiceDescriptorProto g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ServiceDescriptorProto(kVar, tVar);
            }
        }

        public static ServiceDescriptorProto getDefaultInstance() {
            return f35339d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f35289w;
        }

        public static b newBuilder() {
            return f35339d.toBuilder();
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<ServiceDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ServiceDescriptorProto)) {
                return super.equals(obj);
            }
            ServiceDescriptorProto serviceDescriptorProto = (ServiceDescriptorProto) obj;
            if (hasName() != serviceDescriptorProto.hasName()) {
                return false;
            }
            if ((hasName() && !getName().equals(serviceDescriptorProto.getName())) || !getMethodList().equals(serviceDescriptorProto.getMethodList()) || hasOptions() != serviceDescriptorProto.hasOptions()) {
                return false;
            }
            if ((!hasOptions() || getOptions().equals(serviceDescriptorProto.getOptions())) && this.unknownFields.equals(serviceDescriptorProto.unknownFields)) {
                return true;
            }
            return false;
        }

        public MethodDescriptorProto getMethod(int i3) {
            return this.method_.get(i3);
        }

        public int getMethodCount() {
            return this.method_.size();
        }

        public List<MethodDescriptorProto> getMethodList() {
            return this.method_;
        }

        public l getMethodOrBuilder(int i3) {
            return this.method_.get(i3);
        }

        public List<? extends l> getMethodOrBuilderList() {
            return this.method_;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public ServiceOptions getOptions() {
            ServiceOptions serviceOptions = this.options_;
            if (serviceOptions == null) {
                return ServiceOptions.getDefaultInstance();
            }
            return serviceOptions;
        }

        public q getOptionsOrBuilder() {
            ServiceOptions serviceOptions = this.options_;
            if (serviceOptions == null) {
                return ServiceOptions.getDefaultInstance();
            }
            return serviceOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ServiceDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.method_.size(); i17++) {
                i3 += CodedOutputStream.G(2, this.method_.get(i17));
            }
            if ((this.bitField0_ & 2) != 0) {
                i3 += CodedOutputStream.G(3, getOptions());
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasOptions() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (getMethodCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getMethodList().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getOptions().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f35290x.e(ServiceDescriptorProto.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getMethodCount(); i3++) {
                if (!getMethod(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new ServiceDescriptorProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            for (int i3 = 0; i3 < this.method_.size(); i3++) {
                codedOutputStream.K0(2, this.method_.get(i3));
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.K0(3, getOptions());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements p {
            private List<MethodDescriptorProto> C;
            private bp<MethodDescriptorProto, MethodDescriptorProto.b, l> D;
            private ServiceOptions E;
            private bu<ServiceOptions, ServiceOptions.b, q> F;

            /* renamed from: i, reason: collision with root package name */
            private int f35340i;

            /* renamed from: m, reason: collision with root package name */
            private Object f35341m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                    y();
                }
            }

            private void u() {
                if ((this.f35340i & 2) == 0) {
                    this.C = new ArrayList(this.C);
                    this.f35340i |= 2;
                }
            }

            private bp<MethodDescriptorProto, MethodDescriptorProto.b, l> w() {
                boolean z16;
                if (this.D == null) {
                    List<MethodDescriptorProto> list = this.C;
                    if ((this.f35340i & 2) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.D = new bp<>(list, z16, h(), isClean());
                    this.C = null;
                }
                return this.D;
            }

            private bu<ServiceOptions, ServiceOptions.b, q> y() {
                if (this.F == null) {
                    this.F = new bu<>(x(), h(), isClean());
                    this.E = null;
                }
                return this.F;
            }

            public b A(ServiceDescriptorProto serviceDescriptorProto) {
                if (serviceDescriptorProto == ServiceDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (serviceDescriptorProto.hasName()) {
                    this.f35340i |= 1;
                    this.f35341m = serviceDescriptorProto.name_;
                    onChanged();
                }
                if (this.D == null) {
                    if (!serviceDescriptorProto.method_.isEmpty()) {
                        if (this.C.isEmpty()) {
                            this.C = serviceDescriptorProto.method_;
                            this.f35340i &= -3;
                        } else {
                            u();
                            this.C.addAll(serviceDescriptorProto.method_);
                        }
                        onChanged();
                    }
                } else if (!serviceDescriptorProto.method_.isEmpty()) {
                    if (this.D.j()) {
                        this.D.f();
                        bp<MethodDescriptorProto, MethodDescriptorProto.b, l> bpVar = null;
                        this.D = null;
                        this.C = serviceDescriptorProto.method_;
                        this.f35340i &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = w();
                        }
                        this.D = bpVar;
                    } else {
                        this.D.b(serviceDescriptorProto.method_);
                    }
                }
                if (serviceDescriptorProto.hasOptions()) {
                    C(serviceDescriptorProto.getOptions());
                }
                mo52mergeUnknownFields(serviceDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ServiceDescriptorProto) {
                    return A((ServiceDescriptorProto) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b C(ServiceOptions serviceOptions) {
                ServiceOptions serviceOptions2;
                bu<ServiceOptions, ServiceOptions.b, q> buVar = this.F;
                if (buVar == null) {
                    if ((this.f35340i & 4) != 0 && (serviceOptions2 = this.E) != null && serviceOptions2 != ServiceOptions.getDefaultInstance()) {
                        this.E = ServiceOptions.newBuilder(this.E).H(serviceOptions).buildPartial();
                    } else {
                        this.E = serviceOptions;
                    }
                    onChanged();
                } else {
                    buVar.g(serviceOptions);
                }
                this.f35340i |= 4;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: F, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f35289w;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.f35290x.e(ServiceDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ServiceDescriptorProto build() {
                ServiceDescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ServiceDescriptorProto buildPartial() {
                int i3;
                ServiceDescriptorProto serviceDescriptorProto = new ServiceDescriptorProto(this);
                int i16 = this.f35340i;
                if ((i16 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                serviceDescriptorProto.name_ = this.f35341m;
                bp<MethodDescriptorProto, MethodDescriptorProto.b, l> bpVar = this.D;
                if (bpVar != null) {
                    serviceDescriptorProto.method_ = bpVar.d();
                } else {
                    if ((this.f35340i & 2) != 0) {
                        this.C = Collections.unmodifiableList(this.C);
                        this.f35340i &= -3;
                    }
                    serviceDescriptorProto.method_ = this.C;
                }
                if ((i16 & 4) != 0) {
                    bu<ServiceOptions, ServiceOptions.b, q> buVar = this.F;
                    if (buVar == null) {
                        serviceDescriptorProto.options_ = this.E;
                    } else {
                        serviceDescriptorProto.options_ = buVar.b();
                    }
                    i3 |= 2;
                }
                serviceDescriptorProto.bitField0_ = i3;
                onBuilt();
                return serviceDescriptorProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f35341m = "";
                this.f35340i &= -2;
                bp<MethodDescriptorProto, MethodDescriptorProto.b, l> bpVar = this.D;
                if (bpVar == null) {
                    this.C = Collections.emptyList();
                    this.f35340i &= -3;
                } else {
                    bpVar.e();
                }
                bu<ServiceOptions, ServiceOptions.b, q> buVar = this.F;
                if (buVar == null) {
                    this.E = null;
                } else {
                    buVar.c();
                }
                this.f35340i &= -5;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public ServiceDescriptorProto getDefaultInstanceForType() {
                return ServiceDescriptorProto.getDefaultInstance();
            }

            public ServiceOptions x() {
                bu<ServiceOptions, ServiceOptions.b, q> buVar = this.F;
                if (buVar == null) {
                    ServiceOptions serviceOptions = this.E;
                    if (serviceOptions == null) {
                        return ServiceOptions.getDefaultInstance();
                    }
                    return serviceOptions;
                }
                return buVar.f();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                ServiceDescriptorProto serviceDescriptorProto = null;
                try {
                    try {
                        ServiceDescriptorProto g16 = ServiceDescriptorProto.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            A(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (serviceDescriptorProto != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    ServiceDescriptorProto serviceDescriptorProto2 = (ServiceDescriptorProto) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        serviceDescriptorProto = serviceDescriptorProto2;
                        if (serviceDescriptorProto != null) {
                            A(serviceDescriptorProto);
                        }
                        throw th;
                    }
                }
            }

            b() {
                this.f35341m = "";
                this.C = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f35341m = "";
                this.C = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ServiceDescriptorProto serviceDescriptorProto) {
            return f35339d.toBuilder().A(serviceDescriptorProto);
        }

        public static ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        ServiceDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static ServiceDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ServiceDescriptorProto getDefaultInstanceForType() {
            return f35339d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35339d ? new b() : new b().A(this);
        }

        public static ServiceDescriptorProto parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ServiceDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.method_ = Collections.emptyList();
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static ServiceDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        ServiceDescriptorProto(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 10) {
                                ByteString q16 = kVar.q();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.name_ = q16;
                            } else if (J == 18) {
                                if ((i3 & 2) == 0) {
                                    this.method_ = new ArrayList();
                                    i3 |= 2;
                                }
                                this.method_.add(kVar.z(MethodDescriptorProto.PARSER, tVar));
                            } else if (J != 26) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                ServiceOptions.b builder = (this.bitField0_ & 2) != 0 ? this.options_.toBuilder() : null;
                                ServiceOptions serviceOptions = (ServiceOptions) kVar.z(ServiceOptions.PARSER, tVar);
                                this.options_ = serviceOptions;
                                if (builder != null) {
                                    builder.H(serviceOptions);
                                    this.options_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i3 & 2) != 0) {
                        this.method_ = Collections.unmodifiableList(this.method_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ServiceDescriptorProto parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static ServiceDescriptorProto parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static ServiceDescriptorProto parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ServiceOptions extends GeneratedMessageV3.ExtendableMessage<ServiceOptions> implements q {
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;

        /* renamed from: d, reason: collision with root package name */
        private static final ServiceOptions f35342d = new ServiceOptions();

        @Deprecated
        public static final bg<ServiceOptions> PARSER = new a();

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<ServiceOptions> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ServiceOptions g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ServiceOptions(kVar, tVar);
            }
        }

        public static ServiceOptions getDefaultInstance() {
            return f35342d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.M;
        }

        public static b newBuilder() {
            return f35342d.toBuilder();
        }

        public static ServiceOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ServiceOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<ServiceOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ServiceOptions)) {
                return super.equals(obj);
            }
            ServiceOptions serviceOptions = (ServiceOptions) obj;
            if (hasDeprecated() != serviceOptions.hasDeprecated()) {
                return false;
            }
            if ((!hasDeprecated() || getDeprecated() == serviceOptions.getDeprecated()) && getUninterpretedOptionList().equals(serviceOptions.getUninterpretedOptionList()) && this.unknownFields.equals(serviceOptions.unknownFields) && getExtensionFields().equals(serviceOptions.getExtensionFields())) {
                return true;
            }
            return false;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ServiceOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) != 0) {
                i3 = CodedOutputStream.e(33, this.deprecated_) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.uninterpretedOption_.size(); i17++) {
                i3 += CodedOutputStream.G(999, this.uninterpretedOption_.get(i17));
            }
            int extensionsSerializedSize = i3 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public UninterpretedOption getUninterpretedOption(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i3) {
            return this.uninterpretedOption_.get(i3);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasDeprecated() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 33) * 53) + ad.c(getDeprecated());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, getExtensionFields()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.N.e(ServiceOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getUninterpretedOptionCount(); i3++) {
                if (!getUninterpretedOption(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new ServiceOptions();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.m0(33, this.deprecated_);
            }
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                codedOutputStream.K0(999, this.uninterpretedOption_.get(i3));
            }
            newExtensionWriter.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.d<ServiceOptions, b> implements q {
            private boolean C;
            private List<UninterpretedOption> D;
            private bp<UninterpretedOption, UninterpretedOption.b, s> E;

            /* renamed from: m, reason: collision with root package name */
            private int f35343m;

            private void D() {
                if ((this.f35343m & 2) == 0) {
                    this.D = new ArrayList(this.D);
                    this.f35343m |= 2;
                }
            }

            private bp<UninterpretedOption, UninterpretedOption.b, s> F() {
                boolean z16;
                if (this.E == null) {
                    List<UninterpretedOption> list = this.D;
                    if ((this.f35343m & 2) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.E = new bp<>(list, z16, h(), isClean());
                    this.D = null;
                }
                return this.E;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    F();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public ServiceOptions getDefaultInstanceForType() {
                return ServiceOptions.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                ServiceOptions serviceOptions = null;
                try {
                    try {
                        ServiceOptions g16 = ServiceOptions.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            H(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (serviceOptions != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    ServiceOptions serviceOptions2 = (ServiceOptions) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        serviceOptions = serviceOptions2;
                        if (serviceOptions != null) {
                            H(serviceOptions);
                        }
                        throw th;
                    }
                }
            }

            public b H(ServiceOptions serviceOptions) {
                if (serviceOptions == ServiceOptions.getDefaultInstance()) {
                    return this;
                }
                if (serviceOptions.hasDeprecated()) {
                    K(serviceOptions.getDeprecated());
                }
                if (this.E == null) {
                    if (!serviceOptions.uninterpretedOption_.isEmpty()) {
                        if (this.D.isEmpty()) {
                            this.D = serviceOptions.uninterpretedOption_;
                            this.f35343m &= -3;
                        } else {
                            D();
                            this.D.addAll(serviceOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!serviceOptions.uninterpretedOption_.isEmpty()) {
                    if (this.E.j()) {
                        this.E.f();
                        bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = null;
                        this.E = null;
                        this.D = serviceOptions.uninterpretedOption_;
                        this.f35343m &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = F();
                        }
                        this.E = bpVar;
                    } else {
                        this.E.b(serviceOptions.uninterpretedOption_);
                    }
                }
                t(serviceOptions);
                mo52mergeUnknownFields(serviceOptions.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ServiceOptions) {
                    return H((ServiceOptions) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b K(boolean z16) {
                this.f35343m |= 1;
                this.C = z16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: M, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.M;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.N.e(ServiceOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public ServiceOptions build() {
                ServiceOptions buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public ServiceOptions buildPartial() {
                ServiceOptions serviceOptions = new ServiceOptions(this);
                int i3 = 1;
                if ((this.f35343m & 1) != 0) {
                    serviceOptions.deprecated_ = this.C;
                } else {
                    i3 = 0;
                }
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.E;
                if (bpVar != null) {
                    serviceOptions.uninterpretedOption_ = bpVar.d();
                } else {
                    if ((this.f35343m & 2) != 0) {
                        this.D = Collections.unmodifiableList(this.D);
                        this.f35343m &= -3;
                    }
                    serviceOptions.uninterpretedOption_ = this.D;
                }
                serviceOptions.bitField0_ = i3;
                onBuilt();
                return serviceOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.C = false;
                this.f35343m &= -2;
                bp<UninterpretedOption, UninterpretedOption.b, s> bpVar = this.E;
                if (bpVar == null) {
                    this.D = Collections.emptyList();
                    this.f35343m &= -3;
                } else {
                    bpVar.e();
                }
                return this;
            }

            b() {
                this.D = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.D = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ServiceOptions serviceOptions) {
            return f35342d.toBuilder().H(serviceOptions);
        }

        public static ServiceOptions parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        ServiceOptions(GeneratedMessageV3.d<ServiceOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ServiceOptions parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static ServiceOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ServiceOptions getDefaultInstanceForType() {
            return f35342d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35342d ? new b() : new b().H(this);
        }

        public static ServiceOptions parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ServiceOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static ServiceOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ServiceOptions parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static ServiceOptions parseFrom(InputStream inputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        ServiceOptions(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 264) {
                                this.bitField0_ |= 1;
                                this.deprecated_ = kVar.p();
                            } else if (J != 7994) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                if ((i3 & 2) == 0) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    i3 |= 2;
                                }
                                this.uninterpretedOption_.add(kVar.z(UninterpretedOption.PARSER, tVar));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i3 & 2) != 0) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ServiceOptions parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static ServiceOptions parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static ServiceOptions parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class SourceCodeInfo extends GeneratedMessageV3 implements r {
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<Location> location_;
        private byte memoizedIsInitialized;

        /* renamed from: d, reason: collision with root package name */
        private static final SourceCodeInfo f35344d = new SourceCodeInfo();

        @Deprecated
        public static final bg<SourceCodeInfo> PARSER = new a();

        /* loaded from: classes2.dex */
        public static final class Location extends GeneratedMessageV3 implements c {
            public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
            public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private volatile Object leadingComments_;
            private ah leadingDetachedComments_;
            private byte memoizedIsInitialized;
            private int pathMemoizedSerializedSize;
            private ad.g path_;
            private int spanMemoizedSerializedSize;
            private ad.g span_;
            private volatile Object trailingComments_;

            /* renamed from: d, reason: collision with root package name */
            private static final Location f35345d = new Location();

            @Deprecated
            public static final bg<Location> PARSER = new a();

            /* loaded from: classes2.dex */
            static class a extends com.google.protobuf.c<Location> {
                a() {
                }

                @Override // com.google.protobuf.bg
                /* renamed from: G, reason: merged with bridge method [inline-methods] */
                public Location g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                    return new Location(kVar, tVar);
                }
            }

            public static Location getDefaultInstance() {
                return f35345d;
            }

            public static final Descriptors.b getDescriptor() {
                return DescriptorProtos.W;
            }

            public static b newBuilder() {
                return f35345d.toBuilder();
            }

            public static Location parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Location) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Location parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.d(byteBuffer);
            }

            public static bg<Location> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Location)) {
                    return super.equals(obj);
                }
                Location location = (Location) obj;
                if (!getPathList().equals(location.getPathList()) || !getSpanList().equals(location.getSpanList()) || hasLeadingComments() != location.hasLeadingComments()) {
                    return false;
                }
                if ((hasLeadingComments() && !getLeadingComments().equals(location.getLeadingComments())) || hasTrailingComments() != location.hasTrailingComments()) {
                    return false;
                }
                if ((!hasTrailingComments() || getTrailingComments().equals(location.getTrailingComments())) && m55getLeadingDetachedCommentsList().equals(location.m55getLeadingDetachedCommentsList()) && this.unknownFields.equals(location.unknownFields)) {
                    return true;
                }
                return false;
            }

            public String getLeadingComments() {
                Object obj = this.leadingComments_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.leadingComments_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getLeadingCommentsBytes() {
                Object obj = this.leadingComments_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.leadingComments_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public String getLeadingDetachedComments(int i3) {
                return this.leadingDetachedComments_.get(i3);
            }

            public ByteString getLeadingDetachedCommentsBytes(int i3) {
                return this.leadingDetachedComments_.getByteString(i3);
            }

            public int getLeadingDetachedCommentsCount() {
                return this.leadingDetachedComments_.size();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
            public bg<Location> getParserForType() {
                return PARSER;
            }

            public int getPath(int i3) {
                return this.path_.getInt(i3);
            }

            public int getPathCount() {
                return this.path_.size();
            }

            public List<Integer> getPathList() {
                return this.path_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
            public int getSerializedSize() {
                int i3 = this.memoizedSize;
                if (i3 != -1) {
                    return i3;
                }
                int i16 = 0;
                for (int i17 = 0; i17 < this.path_.size(); i17++) {
                    i16 += CodedOutputStream.y(this.path_.getInt(i17));
                }
                int i18 = 0 + i16;
                if (!getPathList().isEmpty()) {
                    i18 = i18 + 1 + CodedOutputStream.y(i16);
                }
                this.pathMemoizedSerializedSize = i16;
                int i19 = 0;
                for (int i26 = 0; i26 < this.span_.size(); i26++) {
                    i19 += CodedOutputStream.y(this.span_.getInt(i26));
                }
                int i27 = i18 + i19;
                if (!getSpanList().isEmpty()) {
                    i27 = i27 + 1 + CodedOutputStream.y(i19);
                }
                this.spanMemoizedSerializedSize = i19;
                if ((this.bitField0_ & 1) != 0) {
                    i27 += GeneratedMessageV3.computeStringSize(3, this.leadingComments_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    i27 += GeneratedMessageV3.computeStringSize(4, this.trailingComments_);
                }
                int i28 = 0;
                for (int i29 = 0; i29 < this.leadingDetachedComments_.size(); i29++) {
                    i28 += GeneratedMessageV3.computeStringSizeNoTag(this.leadingDetachedComments_.c(i29));
                }
                int size = i27 + i28 + (m55getLeadingDetachedCommentsList().size() * 1) + this.unknownFields.getSerializedSize();
                this.memoizedSize = size;
                return size;
            }

            public int getSpan(int i3) {
                return this.span_.getInt(i3);
            }

            public int getSpanCount() {
                return this.span_.size();
            }

            public List<Integer> getSpanList() {
                return this.span_;
            }

            public String getTrailingComments() {
                Object obj = this.trailingComments_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.trailingComments_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getTrailingCommentsBytes() {
                Object obj = this.trailingComments_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.trailingComments_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
            public final cc getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasLeadingComments() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            public boolean hasTrailingComments() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i3 = this.memoizedHashCode;
                if (i3 != 0) {
                    return i3;
                }
                int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
                if (getPathCount() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getPathList().hashCode();
                }
                if (getSpanCount() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getSpanList().hashCode();
                }
                if (hasLeadingComments()) {
                    hashCode = (((hashCode * 37) + 3) * 53) + getLeadingComments().hashCode();
                }
                if (hasTrailingComments()) {
                    hashCode = (((hashCode * 37) + 4) * 53) + getTrailingComments().hashCode();
                }
                if (getLeadingDetachedCommentsCount() > 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + m55getLeadingDetachedCommentsList().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.X.e(Location.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
            public final boolean isInitialized() {
                byte b16 = this.memoizedIsInitialized;
                if (b16 == 1) {
                    return true;
                }
                if (b16 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.f fVar) {
                return new Location();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if (getPathList().size() > 0) {
                    codedOutputStream.c1(10);
                    codedOutputStream.c1(this.pathMemoizedSerializedSize);
                }
                for (int i3 = 0; i3 < this.path_.size(); i3++) {
                    codedOutputStream.H0(this.path_.getInt(i3));
                }
                if (getSpanList().size() > 0) {
                    codedOutputStream.c1(18);
                    codedOutputStream.c1(this.spanMemoizedSerializedSize);
                }
                for (int i16 = 0; i16 < this.span_.size(); i16++) {
                    codedOutputStream.H0(this.span_.getInt(i16));
                }
                if ((this.bitField0_ & 1) != 0) {
                    GeneratedMessageV3.writeString(codedOutputStream, 3, this.leadingComments_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    GeneratedMessageV3.writeString(codedOutputStream, 4, this.trailingComments_);
                }
                for (int i17 = 0; i17 < this.leadingDetachedComments_.size(); i17++) {
                    GeneratedMessageV3.writeString(codedOutputStream, 6, this.leadingDetachedComments_.c(i17));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* loaded from: classes2.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements c {
                private ad.g C;
                private Object D;
                private Object E;
                private ah F;

                /* renamed from: i, reason: collision with root package name */
                private int f35346i;

                /* renamed from: m, reason: collision with root package name */
                private ad.g f35347m;

                private void maybeForceBuilderInitialization() {
                    boolean z16 = GeneratedMessageV3.alwaysUseFieldBuilders;
                }

                private void u() {
                    if ((this.f35346i & 16) == 0) {
                        this.F = new ag(this.F);
                        this.f35346i |= 16;
                    }
                }

                private void v() {
                    if ((this.f35346i & 1) == 0) {
                        this.f35347m = GeneratedMessageV3.mutableCopy(this.f35347m);
                        this.f35346i |= 1;
                    }
                }

                private void w() {
                    if ((this.f35346i & 2) == 0) {
                        this.C = GeneratedMessageV3.mutableCopy(this.C);
                        this.f35346i |= 2;
                    }
                }

                @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
                /* renamed from: A, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(ar arVar) {
                    if (arVar instanceof Location) {
                        return z((Location) arVar);
                    }
                    super.mergeFrom(arVar);
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
                /* renamed from: B, reason: merged with bridge method [inline-methods] */
                public final b mo52mergeUnknownFields(cc ccVar) {
                    return (b) super.mo52mergeUnknownFields(ccVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
                /* renamed from: C, reason: merged with bridge method [inline-methods] */
                public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.setField(fieldDescriptor, obj);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
                /* renamed from: D, reason: merged with bridge method [inline-methods] */
                public final b setUnknownFields(cc ccVar) {
                    return (b) super.setUnknownFields(ccVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
                public Descriptors.b getDescriptorForType() {
                    return DescriptorProtos.W;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e i() {
                    return DescriptorProtos.X.e(Location.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
                /* renamed from: o, reason: merged with bridge method [inline-methods] */
                public Location build() {
                    Location buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
                }

                @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public Location buildPartial() {
                    int i3;
                    Location location = new Location(this);
                    int i16 = this.f35346i;
                    if ((i16 & 1) != 0) {
                        this.f35347m.y();
                        this.f35346i &= -2;
                    }
                    location.path_ = this.f35347m;
                    if ((this.f35346i & 2) != 0) {
                        this.C.y();
                        this.f35346i &= -3;
                    }
                    location.span_ = this.C;
                    if ((i16 & 4) != 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    location.leadingComments_ = this.D;
                    if ((i16 & 8) != 0) {
                        i3 |= 2;
                    }
                    location.trailingComments_ = this.E;
                    if ((this.f35346i & 16) != 0) {
                        this.F = this.F.getUnmodifiableView();
                        this.f35346i &= -17;
                    }
                    location.leadingDetachedComments_ = this.F;
                    location.bitField0_ = i3;
                    onBuilt();
                    return location;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
                /* renamed from: q, reason: merged with bridge method [inline-methods] */
                public b clear() {
                    super.clear();
                    this.f35347m = GeneratedMessageV3.emptyIntList();
                    this.f35346i &= -2;
                    this.C = GeneratedMessageV3.emptyIntList();
                    int i3 = this.f35346i & (-3);
                    this.D = "";
                    this.E = "";
                    int i16 = i3 & (-5) & (-9);
                    this.f35346i = i16;
                    this.F = ag.f35656h;
                    this.f35346i = i16 & (-17);
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (b) super.clearField(fieldDescriptor);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: s, reason: merged with bridge method [inline-methods] */
                public b clearOneof(Descriptors.g gVar) {
                    return (b) super.clearOneof(gVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: t, reason: merged with bridge method [inline-methods] */
                public b mo50clone() {
                    return (b) super.mo50clone();
                }

                @Override // com.google.protobuf.av, com.google.protobuf.ax
                /* renamed from: x, reason: merged with bridge method [inline-methods] */
                public Location getDefaultInstanceForType() {
                    return Location.getDefaultInstance();
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
                /* renamed from: y, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                    Location location = null;
                    try {
                        try {
                            Location g16 = Location.PARSER.g(kVar, tVar);
                            if (g16 != null) {
                                z(g16);
                            }
                            return this;
                        } catch (Throwable th5) {
                            th = th5;
                            if (location != null) {
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        Location location2 = (Location) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th6) {
                            th = th6;
                            location = location2;
                            if (location != null) {
                                z(location);
                            }
                            throw th;
                        }
                    }
                }

                public b z(Location location) {
                    if (location == Location.getDefaultInstance()) {
                        return this;
                    }
                    if (!location.path_.isEmpty()) {
                        if (this.f35347m.isEmpty()) {
                            this.f35347m = location.path_;
                            this.f35346i &= -2;
                        } else {
                            v();
                            this.f35347m.addAll(location.path_);
                        }
                        onChanged();
                    }
                    if (!location.span_.isEmpty()) {
                        if (this.C.isEmpty()) {
                            this.C = location.span_;
                            this.f35346i &= -3;
                        } else {
                            w();
                            this.C.addAll(location.span_);
                        }
                        onChanged();
                    }
                    if (location.hasLeadingComments()) {
                        this.f35346i |= 4;
                        this.D = location.leadingComments_;
                        onChanged();
                    }
                    if (location.hasTrailingComments()) {
                        this.f35346i |= 8;
                        this.E = location.trailingComments_;
                        onChanged();
                    }
                    if (!location.leadingDetachedComments_.isEmpty()) {
                        if (this.F.isEmpty()) {
                            this.F = location.leadingDetachedComments_;
                            this.f35346i &= -17;
                        } else {
                            u();
                            this.F.addAll(location.leadingDetachedComments_);
                        }
                        onChanged();
                    }
                    mo52mergeUnknownFields(location.unknownFields);
                    onChanged();
                    return this;
                }

                b() {
                    this.f35347m = GeneratedMessageV3.emptyIntList();
                    this.C = GeneratedMessageV3.emptyIntList();
                    this.D = "";
                    this.E = "";
                    this.F = ag.f35656h;
                    maybeForceBuilderInitialization();
                }

                b(GeneratedMessageV3.c cVar) {
                    super(cVar);
                    this.f35347m = GeneratedMessageV3.emptyIntList();
                    this.C = GeneratedMessageV3.emptyIntList();
                    this.D = "";
                    this.E = "";
                    this.F = ag.f35656h;
                    maybeForceBuilderInitialization();
                }
            }

            public static b newBuilder(Location location) {
                return f35345d.toBuilder().z(location);
            }

            public static Location parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
                return PARSER.m(byteBuffer, tVar);
            }

            /* renamed from: getLeadingDetachedCommentsList, reason: merged with bridge method [inline-methods] */
            public bl m55getLeadingDetachedCommentsList() {
                return this.leadingDetachedComments_;
            }

            Location(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
            }

            public static Location parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
                return (Location) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
            }

            public static Location parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.b(byteString);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
            public Location getDefaultInstanceForType() {
                return f35345d;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
            public b toBuilder() {
                return this == f35345d ? new b() : new b().z(this);
            }

            public static Location parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
                return PARSER.a(byteString, tVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
            public b newBuilderForType() {
                return newBuilder();
            }

            public static Location parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.j(bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public b newBuilderForType(GeneratedMessageV3.c cVar) {
                return new b(cVar);
            }

            public static Location parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
                return PARSER.i(bArr, tVar);
            }

            Location() {
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.path_ = GeneratedMessageV3.emptyIntList();
                this.span_ = GeneratedMessageV3.emptyIntList();
                this.leadingComments_ = "";
                this.trailingComments_ = "";
                this.leadingDetachedComments_ = ag.f35656h;
            }

            public static Location parseFrom(InputStream inputStream) throws IOException {
                return (Location) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static Location parseFrom(InputStream inputStream, t tVar) throws IOException {
                return (Location) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
            }

            public static Location parseFrom(com.google.protobuf.k kVar) throws IOException {
                return (Location) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
            }

            public static Location parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                return (Location) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
            }

            Location(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                this();
                tVar.getClass();
                cc.b g16 = cc.g();
                boolean z16 = false;
                int i3 = 0;
                while (!z16) {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J == 8) {
                                    if ((i3 & 1) == 0) {
                                        this.path_ = GeneratedMessageV3.newIntList();
                                        i3 |= 1;
                                    }
                                    this.path_.e(kVar.x());
                                } else if (J == 10) {
                                    int o16 = kVar.o(kVar.B());
                                    if ((i3 & 1) == 0 && kVar.d() > 0) {
                                        this.path_ = GeneratedMessageV3.newIntList();
                                        i3 |= 1;
                                    }
                                    while (kVar.d() > 0) {
                                        this.path_.e(kVar.x());
                                    }
                                    kVar.n(o16);
                                } else if (J == 16) {
                                    if ((i3 & 2) == 0) {
                                        this.span_ = GeneratedMessageV3.newIntList();
                                        i3 |= 2;
                                    }
                                    this.span_.e(kVar.x());
                                } else if (J == 18) {
                                    int o17 = kVar.o(kVar.B());
                                    if ((i3 & 2) == 0 && kVar.d() > 0) {
                                        this.span_ = GeneratedMessageV3.newIntList();
                                        i3 |= 2;
                                    }
                                    while (kVar.d() > 0) {
                                        this.span_.e(kVar.x());
                                    }
                                    kVar.n(o17);
                                } else if (J == 26) {
                                    ByteString q16 = kVar.q();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.leadingComments_ = q16;
                                } else if (J == 34) {
                                    ByteString q17 = kVar.q();
                                    this.bitField0_ |= 2;
                                    this.trailingComments_ = q17;
                                } else if (J != 50) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    ByteString q18 = kVar.q();
                                    if ((i3 & 16) == 0) {
                                        this.leadingDetachedComments_ = new ag();
                                        i3 |= 16;
                                    }
                                    this.leadingDetachedComments_.f(q18);
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        } catch (IOException e17) {
                            throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                        }
                    } finally {
                        if ((i3 & 1) != 0) {
                            this.path_.y();
                        }
                        if ((i3 & 2) != 0) {
                            this.span_.y();
                        }
                        if ((i3 & 16) != 0) {
                            this.leadingDetachedComments_ = this.leadingDetachedComments_.getUnmodifiableView();
                        }
                        this.unknownFields = g16.build();
                        makeExtensionsImmutable();
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<SourceCodeInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public SourceCodeInfo g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new SourceCodeInfo(kVar, tVar);
            }
        }

        /* loaded from: classes2.dex */
        public interface c extends ax {
        }

        public static SourceCodeInfo getDefaultInstance() {
            return f35344d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.U;
        }

        public static b newBuilder() {
            return f35344d.toBuilder();
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SourceCodeInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<SourceCodeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SourceCodeInfo)) {
                return super.equals(obj);
            }
            SourceCodeInfo sourceCodeInfo = (SourceCodeInfo) obj;
            if (getLocationList().equals(sourceCodeInfo.getLocationList()) && this.unknownFields.equals(sourceCodeInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public Location getLocation(int i3) {
            return this.location_.get(i3);
        }

        public int getLocationCount() {
            return this.location_.size();
        }

        public List<Location> getLocationList() {
            return this.location_;
        }

        public c getLocationOrBuilder(int i3) {
            return this.location_.get(i3);
        }

        public List<? extends c> getLocationOrBuilderList() {
            return this.location_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<SourceCodeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.location_.size(); i17++) {
                i16 += CodedOutputStream.G(1, this.location_.get(i17));
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (getLocationCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getLocationList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.V.e(SourceCodeInfo.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new SourceCodeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i3 = 0; i3 < this.location_.size(); i3++) {
                codedOutputStream.K0(1, this.location_.get(i3));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements r {
            private bp<Location, Location.b, c> C;

            /* renamed from: i, reason: collision with root package name */
            private int f35348i;

            /* renamed from: m, reason: collision with root package name */
            private List<Location> f35349m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private void u() {
                if ((this.f35348i & 1) == 0) {
                    this.f35349m = new ArrayList(this.f35349m);
                    this.f35348i |= 1;
                }
            }

            private bp<Location, Location.b, c> w() {
                if (this.C == null) {
                    List<Location> list = this.f35349m;
                    boolean z16 = true;
                    if ((this.f35348i & 1) == 0) {
                        z16 = false;
                    }
                    this.C = new bp<>(list, z16, h(), isClean());
                    this.f35349m = null;
                }
                return this.C;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.U;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.V.e(SourceCodeInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public SourceCodeInfo build() {
                SourceCodeInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public SourceCodeInfo buildPartial() {
                SourceCodeInfo sourceCodeInfo = new SourceCodeInfo(this);
                int i3 = this.f35348i;
                bp<Location, Location.b, c> bpVar = this.C;
                if (bpVar != null) {
                    sourceCodeInfo.location_ = bpVar.d();
                } else {
                    if ((i3 & 1) != 0) {
                        this.f35349m = Collections.unmodifiableList(this.f35349m);
                        this.f35348i &= -2;
                    }
                    sourceCodeInfo.location_ = this.f35349m;
                }
                onBuilt();
                return sourceCodeInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                bp<Location, Location.b, c> bpVar = this.C;
                if (bpVar == null) {
                    this.f35349m = Collections.emptyList();
                    this.f35348i &= -2;
                } else {
                    bpVar.e();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public SourceCodeInfo getDefaultInstanceForType() {
                return SourceCodeInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                SourceCodeInfo sourceCodeInfo = null;
                try {
                    try {
                        SourceCodeInfo g16 = SourceCodeInfo.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            y(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (sourceCodeInfo != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    SourceCodeInfo sourceCodeInfo2 = (SourceCodeInfo) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        sourceCodeInfo = sourceCodeInfo2;
                        if (sourceCodeInfo != null) {
                            y(sourceCodeInfo);
                        }
                        throw th;
                    }
                }
            }

            public b y(SourceCodeInfo sourceCodeInfo) {
                if (sourceCodeInfo == SourceCodeInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.C == null) {
                    if (!sourceCodeInfo.location_.isEmpty()) {
                        if (this.f35349m.isEmpty()) {
                            this.f35349m = sourceCodeInfo.location_;
                            this.f35348i &= -2;
                        } else {
                            u();
                            this.f35349m.addAll(sourceCodeInfo.location_);
                        }
                        onChanged();
                    }
                } else if (!sourceCodeInfo.location_.isEmpty()) {
                    if (this.C.j()) {
                        this.C.f();
                        bp<Location, Location.b, c> bpVar = null;
                        this.C = null;
                        this.f35349m = sourceCodeInfo.location_;
                        this.f35348i &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = w();
                        }
                        this.C = bpVar;
                    } else {
                        this.C.b(sourceCodeInfo.location_);
                    }
                }
                mo52mergeUnknownFields(sourceCodeInfo.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof SourceCodeInfo) {
                    return y((SourceCodeInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            b() {
                this.f35349m = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f35349m = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(SourceCodeInfo sourceCodeInfo) {
            return f35344d.toBuilder().y(sourceCodeInfo);
        }

        public static SourceCodeInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        SourceCodeInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static SourceCodeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public SourceCodeInfo getDefaultInstanceForType() {
            return f35344d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35344d ? new b() : new b().y(this);
        }

        public static SourceCodeInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        SourceCodeInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.location_ = Collections.emptyList();
        }

        public static SourceCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static SourceCodeInfo parseFrom(InputStream inputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        SourceCodeInfo(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J != 10) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                if (!(z17 & true)) {
                                    this.location_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.location_.add(kVar.z(Location.PARSER, tVar));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z17 & true) {
                        this.location_ = Collections.unmodifiableList(this.location_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static SourceCodeInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        public static SourceCodeInfo parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static SourceCodeInfo parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class UninterpretedOption extends GeneratedMessageV3 implements s {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private volatile Object aggregateValue_;
        private int bitField0_;
        private double doubleValue_;
        private volatile Object identifierValue_;
        private byte memoizedIsInitialized;
        private List<NamePart> name_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private ByteString stringValue_;

        /* renamed from: d, reason: collision with root package name */
        private static final UninterpretedOption f35350d = new UninterpretedOption();

        @Deprecated
        public static final bg<UninterpretedOption> PARSER = new a();

        /* loaded from: classes2.dex */
        public static final class NamePart extends GeneratedMessageV3 implements c {
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized;
            private volatile Object namePart_;

            /* renamed from: d, reason: collision with root package name */
            private static final NamePart f35351d = new NamePart();

            @Deprecated
            public static final bg<NamePart> PARSER = new a();

            /* loaded from: classes2.dex */
            static class a extends com.google.protobuf.c<NamePart> {
                a() {
                }

                @Override // com.google.protobuf.bg
                /* renamed from: G, reason: merged with bridge method [inline-methods] */
                public NamePart g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                    return new NamePart(kVar, tVar);
                }
            }

            public static NamePart getDefaultInstance() {
                return f35351d;
            }

            public static final Descriptors.b getDescriptor() {
                return DescriptorProtos.S;
            }

            public static b newBuilder() {
                return f35351d.toBuilder();
            }

            public static NamePart parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (NamePart) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static NamePart parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.d(byteBuffer);
            }

            public static bg<NamePart> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof NamePart)) {
                    return super.equals(obj);
                }
                NamePart namePart = (NamePart) obj;
                if (hasNamePart() != namePart.hasNamePart()) {
                    return false;
                }
                if ((hasNamePart() && !getNamePart().equals(namePart.getNamePart())) || hasIsExtension() != namePart.hasIsExtension()) {
                    return false;
                }
                if ((!hasIsExtension() || getIsExtension() == namePart.getIsExtension()) && this.unknownFields.equals(namePart.unknownFields)) {
                    return true;
                }
                return false;
            }

            public boolean getIsExtension() {
                return this.isExtension_;
            }

            public String getNamePart() {
                Object obj = this.namePart_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.namePart_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getNamePartBytes() {
                Object obj = this.namePart_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.namePart_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
            public bg<NamePart> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
            public int getSerializedSize() {
                int i3 = this.memoizedSize;
                if (i3 != -1) {
                    return i3;
                }
                int i16 = 0;
                if ((this.bitField0_ & 1) != 0) {
                    i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.namePart_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    i16 += CodedOutputStream.e(2, this.isExtension_);
                }
                int serializedSize = i16 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
            public final cc getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasIsExtension() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            public boolean hasNamePart() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i3 = this.memoizedHashCode;
                if (i3 != 0) {
                    return i3;
                }
                int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
                if (hasNamePart()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getNamePart().hashCode();
                }
                if (hasIsExtension()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + ad.c(getIsExtension());
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.T.e(NamePart.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
            public final boolean isInitialized() {
                byte b16 = this.memoizedIsInitialized;
                if (b16 == 1) {
                    return true;
                }
                if (b16 == 0) {
                    return false;
                }
                if (!hasNamePart()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                if (!hasIsExtension()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.f fVar) {
                return new NamePart();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) != 0) {
                    GeneratedMessageV3.writeString(codedOutputStream, 1, this.namePart_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    codedOutputStream.m0(2, this.isExtension_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* loaded from: classes2.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements c {
                private boolean C;

                /* renamed from: i, reason: collision with root package name */
                private int f35352i;

                /* renamed from: m, reason: collision with root package name */
                private Object f35353m;

                private void maybeForceBuilderInitialization() {
                    boolean z16 = GeneratedMessageV3.alwaysUseFieldBuilders;
                }

                public b A(boolean z16) {
                    this.f35352i |= 2;
                    this.C = z16;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
                /* renamed from: B, reason: merged with bridge method [inline-methods] */
                public final b setUnknownFields(cc ccVar) {
                    return (b) super.setUnknownFields(ccVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
                public Descriptors.b getDescriptorForType() {
                    return DescriptorProtos.S;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e i() {
                    return DescriptorProtos.T.e(NamePart.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
                /* renamed from: o, reason: merged with bridge method [inline-methods] */
                public NamePart build() {
                    NamePart buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
                }

                @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public NamePart buildPartial() {
                    int i3;
                    NamePart namePart = new NamePart(this);
                    int i16 = this.f35352i;
                    if ((i16 & 1) != 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    namePart.namePart_ = this.f35353m;
                    if ((i16 & 2) != 0) {
                        namePart.isExtension_ = this.C;
                        i3 |= 2;
                    }
                    namePart.bitField0_ = i3;
                    onBuilt();
                    return namePart;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
                /* renamed from: q, reason: merged with bridge method [inline-methods] */
                public b clear() {
                    super.clear();
                    this.f35353m = "";
                    int i3 = this.f35352i & (-2);
                    this.C = false;
                    this.f35352i = i3 & (-3);
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (b) super.clearField(fieldDescriptor);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: s, reason: merged with bridge method [inline-methods] */
                public b clearOneof(Descriptors.g gVar) {
                    return (b) super.clearOneof(gVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                /* renamed from: t, reason: merged with bridge method [inline-methods] */
                public b mo50clone() {
                    return (b) super.mo50clone();
                }

                @Override // com.google.protobuf.av, com.google.protobuf.ax
                /* renamed from: u, reason: merged with bridge method [inline-methods] */
                public NamePart getDefaultInstanceForType() {
                    return NamePart.getDefaultInstance();
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
                /* renamed from: v, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                    NamePart namePart = null;
                    try {
                        try {
                            NamePart g16 = NamePart.PARSER.g(kVar, tVar);
                            if (g16 != null) {
                                w(g16);
                            }
                            return this;
                        } catch (Throwable th5) {
                            th = th5;
                            if (namePart != null) {
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        NamePart namePart2 = (NamePart) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th6) {
                            th = th6;
                            namePart = namePart2;
                            if (namePart != null) {
                                w(namePart);
                            }
                            throw th;
                        }
                    }
                }

                public b w(NamePart namePart) {
                    if (namePart == NamePart.getDefaultInstance()) {
                        return this;
                    }
                    if (namePart.hasNamePart()) {
                        this.f35352i |= 1;
                        this.f35353m = namePart.namePart_;
                        onChanged();
                    }
                    if (namePart.hasIsExtension()) {
                        A(namePart.getIsExtension());
                    }
                    mo52mergeUnknownFields(namePart.unknownFields);
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
                /* renamed from: x, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(ar arVar) {
                    if (arVar instanceof NamePart) {
                        return w((NamePart) arVar);
                    }
                    super.mergeFrom(arVar);
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
                /* renamed from: y, reason: merged with bridge method [inline-methods] */
                public final b mo52mergeUnknownFields(cc ccVar) {
                    return (b) super.mo52mergeUnknownFields(ccVar);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
                /* renamed from: z, reason: merged with bridge method [inline-methods] */
                public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.setField(fieldDescriptor, obj);
                }

                b() {
                    this.f35353m = "";
                    maybeForceBuilderInitialization();
                }

                b(GeneratedMessageV3.c cVar) {
                    super(cVar);
                    this.f35353m = "";
                    maybeForceBuilderInitialization();
                }
            }

            public static b newBuilder(NamePart namePart) {
                return f35351d.toBuilder().w(namePart);
            }

            public static NamePart parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
                return PARSER.m(byteBuffer, tVar);
            }

            NamePart(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static NamePart parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
                return (NamePart) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
            }

            public static NamePart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.b(byteString);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
            public NamePart getDefaultInstanceForType() {
                return f35351d;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
            public b toBuilder() {
                return this == f35351d ? new b() : new b().w(this);
            }

            public static NamePart parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
                return PARSER.a(byteString, tVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
            public b newBuilderForType() {
                return newBuilder();
            }

            NamePart() {
                this.memoizedIsInitialized = (byte) -1;
                this.namePart_ = "";
            }

            public static NamePart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.j(bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public b newBuilderForType(GeneratedMessageV3.c cVar) {
                return new b(cVar);
            }

            public static NamePart parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
                return PARSER.i(bArr, tVar);
            }

            public static NamePart parseFrom(InputStream inputStream) throws IOException {
                return (NamePart) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            NamePart(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                this();
                tVar.getClass();
                cc.b g16 = cc.g();
                boolean z16 = false;
                while (!z16) {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J == 10) {
                                    ByteString q16 = kVar.q();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.namePart_ = q16;
                                } else if (J != 16) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.isExtension_ = kVar.p();
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        } catch (IOException e17) {
                            throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                        }
                    } finally {
                        this.unknownFields = g16.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static NamePart parseFrom(InputStream inputStream, t tVar) throws IOException {
                return (NamePart) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
            }

            public static NamePart parseFrom(com.google.protobuf.k kVar) throws IOException {
                return (NamePart) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
            }

            public static NamePart parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                return (NamePart) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
            }
        }

        /* loaded from: classes2.dex */
        static class a extends com.google.protobuf.c<UninterpretedOption> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public UninterpretedOption g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new UninterpretedOption(kVar, tVar);
            }
        }

        /* loaded from: classes2.dex */
        public interface c extends ax {
        }

        public static UninterpretedOption getDefaultInstance() {
            return f35350d;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.Q;
        }

        public static b newBuilder() {
            return f35350d.toBuilder();
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UninterpretedOption parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.d(byteBuffer);
        }

        public static bg<UninterpretedOption> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UninterpretedOption)) {
                return super.equals(obj);
            }
            UninterpretedOption uninterpretedOption = (UninterpretedOption) obj;
            if (!getNameList().equals(uninterpretedOption.getNameList()) || hasIdentifierValue() != uninterpretedOption.hasIdentifierValue()) {
                return false;
            }
            if ((hasIdentifierValue() && !getIdentifierValue().equals(uninterpretedOption.getIdentifierValue())) || hasPositiveIntValue() != uninterpretedOption.hasPositiveIntValue()) {
                return false;
            }
            if ((hasPositiveIntValue() && getPositiveIntValue() != uninterpretedOption.getPositiveIntValue()) || hasNegativeIntValue() != uninterpretedOption.hasNegativeIntValue()) {
                return false;
            }
            if ((hasNegativeIntValue() && getNegativeIntValue() != uninterpretedOption.getNegativeIntValue()) || hasDoubleValue() != uninterpretedOption.hasDoubleValue()) {
                return false;
            }
            if ((hasDoubleValue() && Double.doubleToLongBits(getDoubleValue()) != Double.doubleToLongBits(uninterpretedOption.getDoubleValue())) || hasStringValue() != uninterpretedOption.hasStringValue()) {
                return false;
            }
            if ((hasStringValue() && !getStringValue().equals(uninterpretedOption.getStringValue())) || hasAggregateValue() != uninterpretedOption.hasAggregateValue()) {
                return false;
            }
            if ((!hasAggregateValue() || getAggregateValue().equals(uninterpretedOption.getAggregateValue())) && this.unknownFields.equals(uninterpretedOption.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getAggregateValue() {
            Object obj = this.aggregateValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.aggregateValue_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAggregateValueBytes() {
            Object obj = this.aggregateValue_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.aggregateValue_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public double getDoubleValue() {
            return this.doubleValue_;
        }

        public String getIdentifierValue() {
            Object obj = this.identifierValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.identifierValue_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getIdentifierValueBytes() {
            Object obj = this.identifierValue_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.identifierValue_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public NamePart getName(int i3) {
            return this.name_.get(i3);
        }

        public int getNameCount() {
            return this.name_.size();
        }

        public List<NamePart> getNameList() {
            return this.name_;
        }

        public c getNameOrBuilder(int i3) {
            return this.name_.get(i3);
        }

        public List<? extends c> getNameOrBuilderList() {
            return this.name_;
        }

        public long getNegativeIntValue() {
            return this.negativeIntValue_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<UninterpretedOption> getParserForType() {
            return PARSER;
        }

        public long getPositiveIntValue() {
            return this.positiveIntValue_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.name_.size(); i17++) {
                i16 += CodedOutputStream.G(2, this.name_.get(i17));
            }
            if ((this.bitField0_ & 1) != 0) {
                i16 += GeneratedMessageV3.computeStringSize(3, this.identifierValue_);
            }
            if ((this.bitField0_ & 2) != 0) {
                i16 += CodedOutputStream.a0(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i16 += CodedOutputStream.z(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) != 0) {
                i16 += CodedOutputStream.j(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) != 0) {
                i16 += CodedOutputStream.h(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) != 0) {
                i16 += GeneratedMessageV3.computeStringSize(8, this.aggregateValue_);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public ByteString getStringValue() {
            return this.stringValue_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasAggregateValue() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasDoubleValue() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasIdentifierValue() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasNegativeIntValue() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasPositiveIntValue() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasStringValue() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (getNameCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getNameList().hashCode();
            }
            if (hasIdentifierValue()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getIdentifierValue().hashCode();
            }
            if (hasPositiveIntValue()) {
                hashCode = (((hashCode * 37) + 4) * 53) + ad.h(getPositiveIntValue());
            }
            if (hasNegativeIntValue()) {
                hashCode = (((hashCode * 37) + 5) * 53) + ad.h(getNegativeIntValue());
            }
            if (hasDoubleValue()) {
                hashCode = (((hashCode * 37) + 6) * 53) + ad.h(Double.doubleToLongBits(getDoubleValue()));
            }
            if (hasStringValue()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getStringValue().hashCode();
            }
            if (hasAggregateValue()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getAggregateValue().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.R.e(UninterpretedOption.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getNameCount(); i3++) {
                if (!getName(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new UninterpretedOption();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i3 = 0; i3 < this.name_.size(); i3++) {
                codedOutputStream.K0(2, this.name_.get(i3));
            }
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.identifierValue_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.d1(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.I0(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputStream.s0(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputStream.q0(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.aggregateValue_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements s {
            private bp<NamePart, NamePart.b, c> C;
            private Object D;
            private long E;
            private long F;
            private double G;
            private ByteString H;
            private Object I;

            /* renamed from: i, reason: collision with root package name */
            private int f35354i;

            /* renamed from: m, reason: collision with root package name */
            private List<NamePart> f35355m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private void u() {
                if ((this.f35354i & 1) == 0) {
                    this.f35355m = new ArrayList(this.f35355m);
                    this.f35354i |= 1;
                }
            }

            private bp<NamePart, NamePart.b, c> w() {
                if (this.C == null) {
                    List<NamePart> list = this.f35355m;
                    boolean z16 = true;
                    if ((this.f35354i & 1) == 0) {
                        z16 = false;
                    }
                    this.C = new bp<>(list, z16, h(), isClean());
                    this.f35355m = null;
                }
                return this.C;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b B(double d16) {
                this.f35354i |= 16;
                this.G = d16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b D(long j3) {
                this.f35354i |= 8;
                this.F = j3;
                onChanged();
                return this;
            }

            public b E(long j3) {
                this.f35354i |= 4;
                this.E = j3;
                onChanged();
                return this;
            }

            public b F(ByteString byteString) {
                byteString.getClass();
                this.f35354i |= 32;
                this.H = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.Q;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return DescriptorProtos.R.e(UninterpretedOption.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public UninterpretedOption build() {
                UninterpretedOption buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public UninterpretedOption buildPartial() {
                int i3;
                UninterpretedOption uninterpretedOption = new UninterpretedOption(this);
                int i16 = this.f35354i;
                bp<NamePart, NamePart.b, c> bpVar = this.C;
                if (bpVar != null) {
                    uninterpretedOption.name_ = bpVar.d();
                } else {
                    if ((i16 & 1) != 0) {
                        this.f35355m = Collections.unmodifiableList(this.f35355m);
                        this.f35354i &= -2;
                    }
                    uninterpretedOption.name_ = this.f35355m;
                }
                if ((i16 & 2) != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                uninterpretedOption.identifierValue_ = this.D;
                if ((i16 & 4) != 0) {
                    uninterpretedOption.positiveIntValue_ = this.E;
                    i3 |= 2;
                }
                if ((i16 & 8) != 0) {
                    uninterpretedOption.negativeIntValue_ = this.F;
                    i3 |= 4;
                }
                if ((i16 & 16) != 0) {
                    uninterpretedOption.doubleValue_ = this.G;
                    i3 |= 8;
                }
                if ((i16 & 32) != 0) {
                    i3 |= 16;
                }
                uninterpretedOption.stringValue_ = this.H;
                if ((i16 & 64) != 0) {
                    i3 |= 32;
                }
                uninterpretedOption.aggregateValue_ = this.I;
                uninterpretedOption.bitField0_ = i3;
                onBuilt();
                return uninterpretedOption;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                bp<NamePart, NamePart.b, c> bpVar = this.C;
                if (bpVar == null) {
                    this.f35355m = Collections.emptyList();
                    this.f35354i &= -2;
                } else {
                    bpVar.e();
                }
                this.D = "";
                int i3 = this.f35354i & (-3);
                this.E = 0L;
                this.F = 0L;
                this.G = 0.0d;
                int i16 = i3 & (-5) & (-9) & (-17);
                this.f35354i = i16;
                this.H = ByteString.EMPTY;
                this.I = "";
                this.f35354i = i16 & (-33) & (-65);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public UninterpretedOption getDefaultInstanceForType() {
                return UninterpretedOption.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                UninterpretedOption uninterpretedOption = null;
                try {
                    try {
                        UninterpretedOption g16 = UninterpretedOption.PARSER.g(kVar, tVar);
                        if (g16 != null) {
                            y(g16);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (uninterpretedOption != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    UninterpretedOption uninterpretedOption2 = (UninterpretedOption) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th6) {
                        th = th6;
                        uninterpretedOption = uninterpretedOption2;
                        if (uninterpretedOption != null) {
                            y(uninterpretedOption);
                        }
                        throw th;
                    }
                }
            }

            public b y(UninterpretedOption uninterpretedOption) {
                if (uninterpretedOption == UninterpretedOption.getDefaultInstance()) {
                    return this;
                }
                if (this.C == null) {
                    if (!uninterpretedOption.name_.isEmpty()) {
                        if (this.f35355m.isEmpty()) {
                            this.f35355m = uninterpretedOption.name_;
                            this.f35354i &= -2;
                        } else {
                            u();
                            this.f35355m.addAll(uninterpretedOption.name_);
                        }
                        onChanged();
                    }
                } else if (!uninterpretedOption.name_.isEmpty()) {
                    if (this.C.j()) {
                        this.C.f();
                        bp<NamePart, NamePart.b, c> bpVar = null;
                        this.C = null;
                        this.f35355m = uninterpretedOption.name_;
                        this.f35354i &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = w();
                        }
                        this.C = bpVar;
                    } else {
                        this.C.b(uninterpretedOption.name_);
                    }
                }
                if (uninterpretedOption.hasIdentifierValue()) {
                    this.f35354i |= 2;
                    this.D = uninterpretedOption.identifierValue_;
                    onChanged();
                }
                if (uninterpretedOption.hasPositiveIntValue()) {
                    E(uninterpretedOption.getPositiveIntValue());
                }
                if (uninterpretedOption.hasNegativeIntValue()) {
                    D(uninterpretedOption.getNegativeIntValue());
                }
                if (uninterpretedOption.hasDoubleValue()) {
                    B(uninterpretedOption.getDoubleValue());
                }
                if (uninterpretedOption.hasStringValue()) {
                    F(uninterpretedOption.getStringValue());
                }
                if (uninterpretedOption.hasAggregateValue()) {
                    this.f35354i |= 64;
                    this.I = uninterpretedOption.aggregateValue_;
                    onChanged();
                }
                mo52mergeUnknownFields(uninterpretedOption.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof UninterpretedOption) {
                    return y((UninterpretedOption) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            b() {
                this.f35355m = Collections.emptyList();
                this.D = "";
                this.H = ByteString.EMPTY;
                this.I = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f35355m = Collections.emptyList();
                this.D = "";
                this.H = ByteString.EMPTY;
                this.I = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(UninterpretedOption uninterpretedOption) {
            return f35350d.toBuilder().y(uninterpretedOption);
        }

        public static UninterpretedOption parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return PARSER.m(byteBuffer, tVar);
        }

        UninterpretedOption(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, tVar);
        }

        public static UninterpretedOption parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public UninterpretedOption getDefaultInstanceForType() {
            return f35350d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f35350d ? new b() : new b().y(this);
        }

        public static UninterpretedOption parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return PARSER.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        UninterpretedOption() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = Collections.emptyList();
            this.identifierValue_ = "";
            this.stringValue_ = ByteString.EMPTY;
            this.aggregateValue_ = "";
        }

        public static UninterpretedOption parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static UninterpretedOption parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return PARSER.i(bArr, tVar);
        }

        public static UninterpretedOption parseFrom(InputStream inputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UninterpretedOption parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, tVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        UninterpretedOption(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J == 18) {
                                    if (!(z17 & true)) {
                                        this.name_ = new ArrayList();
                                        z17 |= true;
                                    }
                                    this.name_.add(kVar.z(NamePart.PARSER, tVar));
                                } else if (J == 26) {
                                    ByteString q16 = kVar.q();
                                    this.bitField0_ |= 1;
                                    this.identifierValue_ = q16;
                                } else if (J == 32) {
                                    this.bitField0_ |= 2;
                                    this.positiveIntValue_ = kVar.L();
                                } else if (J == 40) {
                                    this.bitField0_ |= 4;
                                    this.negativeIntValue_ = kVar.y();
                                } else if (J == 49) {
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = kVar.r();
                                } else if (J == 58) {
                                    this.bitField0_ |= 16;
                                    this.stringValue_ = kVar.q();
                                } else if (J != 66) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    ByteString q17 = kVar.q();
                                    this.bitField0_ = 32 | this.bitField0_;
                                    this.aggregateValue_ = q17;
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        }
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z17 & true) {
                        this.name_ = Collections.unmodifiableList(this.name_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static UninterpretedOption parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseWithIOException(PARSER, kVar);
        }

        public static UninterpretedOption parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseWithIOException(PARSER, kVar, tVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface b extends ax {
    }

    /* loaded from: classes2.dex */
    public interface c extends ax {
    }

    /* loaded from: classes2.dex */
    public interface d extends ax {
    }

    /* loaded from: classes2.dex */
    public interface e extends ax {
    }

    /* loaded from: classes2.dex */
    public interface f extends ax {
    }

    /* loaded from: classes2.dex */
    public interface g extends ax {
    }

    /* loaded from: classes2.dex */
    public interface h extends ax {
    }

    /* loaded from: classes2.dex */
    public interface i extends ax {
    }

    /* loaded from: classes2.dex */
    public interface j extends ax {
    }

    /* loaded from: classes2.dex */
    public interface k extends ax {
    }

    /* loaded from: classes2.dex */
    public interface l extends ax {
    }

    /* loaded from: classes2.dex */
    public interface m extends ax {
    }

    /* loaded from: classes2.dex */
    public interface n extends ax {
    }

    /* loaded from: classes2.dex */
    public interface o extends ax {
    }

    /* loaded from: classes2.dex */
    public interface p extends ax {
    }

    /* loaded from: classes2.dex */
    public interface q extends ax {
    }

    /* loaded from: classes2.dex */
    public interface r extends ax {
    }

    /* loaded from: classes2.dex */
    public interface s extends ax {
    }

    static {
        Descriptors.b bVar = W().p().get(0);
        f35264a = bVar;
        f35266b = new GeneratedMessageV3.e(bVar, new String[]{"File"});
        Descriptors.b bVar2 = W().p().get(1);
        f35268c = bVar2;
        f35270d = new GeneratedMessageV3.e(bVar2, new String[]{"Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax"});
        Descriptors.b bVar3 = W().p().get(2);
        f35271e = bVar3;
        f35272f = new GeneratedMessageV3.e(bVar3, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName"});
        Descriptors.b bVar4 = bVar3.s().get(0);
        f35273g = bVar4;
        f35274h = new GeneratedMessageV3.e(bVar4, new String[]{"Start", "End", "Options"});
        Descriptors.b bVar5 = bVar3.s().get(1);
        f35275i = bVar5;
        f35276j = new GeneratedMessageV3.e(bVar5, new String[]{"Start", "End"});
        Descriptors.b bVar6 = W().p().get(3);
        f35277k = bVar6;
        f35278l = new GeneratedMessageV3.e(bVar6, new String[]{"UninterpretedOption"});
        Descriptors.b bVar7 = W().p().get(4);
        f35279m = bVar7;
        f35280n = new GeneratedMessageV3.e(bVar7, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options"});
        Descriptors.b bVar8 = W().p().get(5);
        f35281o = bVar8;
        f35282p = new GeneratedMessageV3.e(bVar8, new String[]{"Name", "Options"});
        Descriptors.b bVar9 = W().p().get(6);
        f35283q = bVar9;
        f35284r = new GeneratedMessageV3.e(bVar9, new String[]{"Name", "Value", "Options", "ReservedRange", "ReservedName"});
        Descriptors.b bVar10 = bVar9.s().get(0);
        f35285s = bVar10;
        f35286t = new GeneratedMessageV3.e(bVar10, new String[]{"Start", "End"});
        Descriptors.b bVar11 = W().p().get(7);
        f35287u = bVar11;
        f35288v = new GeneratedMessageV3.e(bVar11, new String[]{"Name", "Number", "Options"});
        Descriptors.b bVar12 = W().p().get(8);
        f35289w = bVar12;
        f35290x = new GeneratedMessageV3.e(bVar12, new String[]{"Name", "Method", "Options"});
        Descriptors.b bVar13 = W().p().get(9);
        f35291y = bVar13;
        f35292z = new GeneratedMessageV3.e(bVar13, new String[]{"Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming"});
        Descriptors.b bVar14 = W().p().get(10);
        A = bVar14;
        B = new GeneratedMessageV3.e(bVar14, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "PhpGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "SwiftPrefix", "PhpClassPrefix", "PhpNamespace", "PhpMetadataNamespace", "RubyPackage", "UninterpretedOption"});
        Descriptors.b bVar15 = W().p().get(11);
        C = bVar15;
        D = new GeneratedMessageV3.e(bVar15, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption"});
        Descriptors.b bVar16 = W().p().get(12);
        E = bVar16;
        F = new GeneratedMessageV3.e(bVar16, new String[]{"Ctype", "Packed", "Jstype", "Lazy", "Deprecated", "Weak", "UninterpretedOption"});
        Descriptors.b bVar17 = W().p().get(13);
        G = bVar17;
        H = new GeneratedMessageV3.e(bVar17, new String[]{"UninterpretedOption"});
        Descriptors.b bVar18 = W().p().get(14);
        I = bVar18;
        J = new GeneratedMessageV3.e(bVar18, new String[]{"AllowAlias", "Deprecated", "UninterpretedOption"});
        Descriptors.b bVar19 = W().p().get(15);
        K = bVar19;
        L = new GeneratedMessageV3.e(bVar19, new String[]{"Deprecated", "UninterpretedOption"});
        Descriptors.b bVar20 = W().p().get(16);
        M = bVar20;
        N = new GeneratedMessageV3.e(bVar20, new String[]{"Deprecated", "UninterpretedOption"});
        Descriptors.b bVar21 = W().p().get(17);
        O = bVar21;
        P = new GeneratedMessageV3.e(bVar21, new String[]{"Deprecated", "IdempotencyLevel", "UninterpretedOption"});
        Descriptors.b bVar22 = W().p().get(18);
        Q = bVar22;
        R = new GeneratedMessageV3.e(bVar22, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"});
        Descriptors.b bVar23 = bVar22.s().get(0);
        S = bVar23;
        T = new GeneratedMessageV3.e(bVar23, new String[]{"NamePart", "IsExtension"});
        Descriptors.b bVar24 = W().p().get(19);
        U = bVar24;
        V = new GeneratedMessageV3.e(bVar24, new String[]{"Location"});
        Descriptors.b bVar25 = bVar24.s().get(0);
        W = bVar25;
        X = new GeneratedMessageV3.e(bVar25, new String[]{"Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments"});
        Descriptors.b bVar26 = W().p().get(20);
        Y = bVar26;
        Z = new GeneratedMessageV3.e(bVar26, new String[]{"Annotation"});
        Descriptors.b bVar27 = bVar26.s().get(0);
        f35265a0 = bVar27;
        f35267b0 = new GeneratedMessageV3.e(bVar27, new String[]{"Path", "SourceFile", "Begin", "End"});
    }

    public static Descriptors.FileDescriptor W() {
        return f35269c0;
    }
}
