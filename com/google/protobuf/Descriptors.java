package com.google.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.TextFormat;
import com.google.protobuf.WireFormat;
import com.google.protobuf.ad;
import com.google.protobuf.ar;
import com.google.protobuf.au;
import com.google.protobuf.z;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Descriptors {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f35356a = Logger.getLogger(Descriptors.class.getName());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class DescriptorPool {

        /* renamed from: b, reason: collision with root package name */
        private boolean f35358b;

        /* renamed from: c, reason: collision with root package name */
        private final Map<String, e> f35359c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        private final Map<a, FieldDescriptor> f35360d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final Map<a, d> f35361e = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        private final Set<FileDescriptor> f35357a = new HashSet();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum SearchFilter {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private final e f35362a;

            /* renamed from: b, reason: collision with root package name */
            private final int f35363b;

            a(e eVar, int i3) {
                this.f35362a = eVar;
                this.f35363b = i3;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.f35362a != aVar.f35362a || this.f35363b != aVar.f35363b) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return (this.f35362a.hashCode() * 65535) + this.f35363b;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class b extends e {

            /* renamed from: d, reason: collision with root package name */
            private final String f35364d;

            /* renamed from: e, reason: collision with root package name */
            private final String f35365e;

            /* renamed from: f, reason: collision with root package name */
            private final FileDescriptor f35366f;

            b(String str, String str2, FileDescriptor fileDescriptor) {
                super(null);
                this.f35366f = fileDescriptor;
                this.f35365e = str2;
                this.f35364d = str;
            }

            @Override // com.google.protobuf.Descriptors.e
            public String getName() {
                return this.f35364d;
            }

            @Override // com.google.protobuf.Descriptors.e
            public FileDescriptor h() {
                return this.f35366f;
            }

            @Override // com.google.protobuf.Descriptors.e
            public String i() {
                return this.f35365e;
            }

            @Override // com.google.protobuf.Descriptors.e
            public ar j() {
                return this.f35366f.j();
            }
        }

        DescriptorPool(FileDescriptor[] fileDescriptorArr, boolean z16) {
            this.f35358b = z16;
            for (int i3 = 0; i3 < fileDescriptorArr.length; i3++) {
                this.f35357a.add(fileDescriptorArr[i3]);
                i(fileDescriptorArr[i3]);
            }
            for (FileDescriptor fileDescriptor : this.f35357a) {
                try {
                    e(fileDescriptor.r(), fileDescriptor);
                } catch (DescriptorValidationException e16) {
                    throw new AssertionError(e16);
                }
            }
        }

        private void i(FileDescriptor fileDescriptor) {
            for (FileDescriptor fileDescriptor2 : fileDescriptor.s()) {
                if (this.f35357a.add(fileDescriptor2)) {
                    i(fileDescriptor2);
                }
            }
        }

        static void m(e eVar) throws DescriptorValidationException {
            String name = eVar.getName();
            a aVar = null;
            if (name.length() != 0) {
                for (int i3 = 0; i3 < name.length(); i3++) {
                    char charAt = name.charAt(i3);
                    if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && charAt != '_' && ('0' > charAt || charAt > '9' || i3 <= 0))) {
                        throw new DescriptorValidationException(eVar, '\"' + name + "\" is not a valid identifier.", aVar);
                    }
                }
                return;
            }
            throw new DescriptorValidationException(eVar, "Missing name.", aVar);
        }

        void c(d dVar) {
            a aVar = new a(dVar.m(), dVar.getNumber());
            d put = this.f35361e.put(aVar, dVar);
            if (put != null) {
                this.f35361e.put(aVar, put);
            }
        }

        void d(FieldDescriptor fieldDescriptor) throws DescriptorValidationException {
            a aVar = new a(fieldDescriptor.q(), fieldDescriptor.getNumber());
            FieldDescriptor put = this.f35360d.put(aVar, fieldDescriptor);
            if (put == null) {
                return;
            }
            this.f35360d.put(aVar, put);
            throw new DescriptorValidationException(fieldDescriptor, "Field number " + fieldDescriptor.getNumber() + " has already been used in \"" + fieldDescriptor.q().i() + "\" by field \"" + put.getName() + "\".", (a) null);
        }

        void e(String str, FileDescriptor fileDescriptor) throws DescriptorValidationException {
            String substring;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                substring = str;
            } else {
                e(str.substring(0, lastIndexOf), fileDescriptor);
                substring = str.substring(lastIndexOf + 1);
            }
            e put = this.f35359c.put(str, new b(substring, str, fileDescriptor));
            if (put != null) {
                this.f35359c.put(str, put);
                if (!(put instanceof b)) {
                    throw new DescriptorValidationException(fileDescriptor, '\"' + substring + "\" is already defined (as something other than a package) in file \"" + put.h().getName() + "\".", (a) null);
                }
            }
        }

        void f(e eVar) throws DescriptorValidationException {
            m(eVar);
            String i3 = eVar.i();
            e put = this.f35359c.put(i3, eVar);
            if (put != null) {
                this.f35359c.put(i3, put);
                a aVar = null;
                if (eVar.h() == put.h()) {
                    int lastIndexOf = i3.lastIndexOf(46);
                    if (lastIndexOf == -1) {
                        throw new DescriptorValidationException(eVar, '\"' + i3 + "\" is already defined.", aVar);
                    }
                    throw new DescriptorValidationException(eVar, '\"' + i3.substring(lastIndexOf + 1) + "\" is already defined in \"" + i3.substring(0, lastIndexOf) + "\".", aVar);
                }
                throw new DescriptorValidationException(eVar, '\"' + i3 + "\" is already defined in file \"" + put.h().getName() + "\".", aVar);
            }
        }

        e g(String str) {
            return h(str, SearchFilter.ALL_SYMBOLS);
        }

        e h(String str, SearchFilter searchFilter) {
            e eVar = this.f35359c.get(str);
            if (eVar != null && (searchFilter == SearchFilter.ALL_SYMBOLS || ((searchFilter == SearchFilter.TYPES_ONLY && k(eVar)) || (searchFilter == SearchFilter.AGGREGATES_ONLY && j(eVar))))) {
                return eVar;
            }
            Iterator<FileDescriptor> it = this.f35357a.iterator();
            while (it.hasNext()) {
                e eVar2 = it.next().D.f35359c.get(str);
                if (eVar2 != null && (searchFilter == SearchFilter.ALL_SYMBOLS || ((searchFilter == SearchFilter.TYPES_ONLY && k(eVar2)) || (searchFilter == SearchFilter.AGGREGATES_ONLY && j(eVar2))))) {
                    return eVar2;
                }
            }
            return null;
        }

        boolean j(e eVar) {
            if (!(eVar instanceof b) && !(eVar instanceof c) && !(eVar instanceof b) && !(eVar instanceof h)) {
                return false;
            }
            return true;
        }

        boolean k(e eVar) {
            if (!(eVar instanceof b) && !(eVar instanceof c)) {
                return false;
            }
            return true;
        }

        e l(String str, e eVar, SearchFilter searchFilter) throws DescriptorValidationException {
            String substring;
            e h16;
            String str2;
            if (str.startsWith(".")) {
                str2 = str.substring(1);
                h16 = h(str2, searchFilter);
            } else {
                int indexOf = str.indexOf(46);
                if (indexOf == -1) {
                    substring = str;
                } else {
                    substring = str.substring(0, indexOf);
                }
                StringBuilder sb5 = new StringBuilder(eVar.i());
                while (true) {
                    int lastIndexOf = sb5.lastIndexOf(".");
                    if (lastIndexOf == -1) {
                        h16 = h(str, searchFilter);
                        str2 = str;
                        break;
                    }
                    int i3 = lastIndexOf + 1;
                    sb5.setLength(i3);
                    sb5.append(substring);
                    e h17 = h(sb5.toString(), SearchFilter.AGGREGATES_ONLY);
                    if (h17 != null) {
                        if (indexOf != -1) {
                            sb5.setLength(i3);
                            sb5.append(str);
                            h16 = h(sb5.toString(), searchFilter);
                        } else {
                            h16 = h17;
                        }
                        str2 = sb5.toString();
                    } else {
                        sb5.setLength(lastIndexOf);
                    }
                }
            }
            if (h16 == null) {
                if (this.f35358b && searchFilter == SearchFilter.TYPES_ONLY) {
                    Descriptors.f35356a.warning("The descriptor for message type \"" + str + "\" can not be found and a placeholder is created for it");
                    b bVar = new b(str2);
                    this.f35357a.add(bVar.h());
                    return bVar;
                }
                throw new DescriptorValidationException(eVar, '\"' + str + "\" is not defined.", (a) null);
            }
            return h16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final ar proto;

        /* synthetic */ DescriptorValidationException(FileDescriptor fileDescriptor, String str, a aVar) {
            this(fileDescriptor, str);
        }

        public String getDescription() {
            return this.description;
        }

        public ar getProblemProto() {
            return this.proto;
        }

        public String getProblemSymbolName() {
            return this.name;
        }

        /* synthetic */ DescriptorValidationException(e eVar, String str, a aVar) {
            this(eVar, str);
        }

        /* synthetic */ DescriptorValidationException(e eVar, String str, Throwable th5, a aVar) {
            this(eVar, str, th5);
        }

        DescriptorValidationException(e eVar, String str) {
            super(eVar.i() + MsgSummary.STR_COLON + str);
            this.name = eVar.i();
            this.proto = eVar.j();
            this.description = str;
        }

        DescriptorValidationException(e eVar, String str, Throwable th5) {
            this(eVar, str);
            initCause(th5);
        }

        DescriptorValidationException(FileDescriptor fileDescriptor, String str) {
            super(fileDescriptor.getName() + MsgSummary.STR_COLON + str);
            this.name = fileDescriptor.getName();
            this.proto = fileDescriptor.j();
            this.description = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class FieldDescriptor extends e implements Comparable<FieldDescriptor>, z.c<FieldDescriptor> {
        private static final WireFormat.FieldType[] I = WireFormat.FieldType.values();
        private Type C;
        private b D;
        private b E;
        private g F;
        private c G;
        private Object H;

        /* renamed from: d, reason: collision with root package name */
        private final int f35367d;

        /* renamed from: e, reason: collision with root package name */
        private DescriptorProtos.FieldDescriptorProto f35368e;

        /* renamed from: f, reason: collision with root package name */
        private final String f35369f;

        /* renamed from: h, reason: collision with root package name */
        private final String f35370h;

        /* renamed from: i, reason: collision with root package name */
        private final FileDescriptor f35371i;

        /* renamed from: m, reason: collision with root package name */
        private final b f35372m;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum JavaType {
            INT(0),
            LONG(0L),
            FLOAT(Float.valueOf(0.0f)),
            DOUBLE(Double.valueOf(0.0d)),
            BOOLEAN(Boolean.FALSE),
            STRING(""),
            BYTE_STRING(ByteString.EMPTY),
            ENUM(null),
            MESSAGE(null);

            private final Object defaultDefault;

            JavaType(Object obj) {
                this.defaultDefault = obj;
            }
        }

        /* JADX WARN: Enum visitor error
        jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INT64' uses external variables
        	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
        	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
         */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class Type {
            private static final /* synthetic */ Type[] $VALUES;
            public static final Type BOOL;
            public static final Type BYTES;
            public static final Type DOUBLE;
            public static final Type ENUM;
            public static final Type FIXED32;
            public static final Type FIXED64;
            public static final Type FLOAT;

            /* renamed from: GROUP, reason: collision with root package name */
            public static final Type f35373GROUP;
            public static final Type INT32;
            public static final Type INT64;
            public static final Type MESSAGE;
            public static final Type SFIXED32;
            public static final Type SFIXED64;
            public static final Type SINT32;
            public static final Type SINT64;
            public static final Type STRING;
            public static final Type UINT32;
            public static final Type UINT64;
            private JavaType javaType;

            static {
                Type type = new Type("DOUBLE", 0, JavaType.DOUBLE);
                DOUBLE = type;
                Type type2 = new Type("FLOAT", 1, JavaType.FLOAT);
                FLOAT = type2;
                JavaType javaType = JavaType.LONG;
                Type type3 = new Type("INT64", 2, javaType);
                INT64 = type3;
                Type type4 = new Type("UINT64", 3, javaType);
                UINT64 = type4;
                JavaType javaType2 = JavaType.INT;
                Type type5 = new Type("INT32", 4, javaType2);
                INT32 = type5;
                Type type6 = new Type("FIXED64", 5, javaType);
                FIXED64 = type6;
                Type type7 = new Type("FIXED32", 6, javaType2);
                FIXED32 = type7;
                Type type8 = new Type("BOOL", 7, JavaType.BOOLEAN);
                BOOL = type8;
                Type type9 = new Type("STRING", 8, JavaType.STRING);
                STRING = type9;
                JavaType javaType3 = JavaType.MESSAGE;
                Type type10 = new Type("GROUP", 9, javaType3);
                f35373GROUP = type10;
                Type type11 = new Type("MESSAGE", 10, javaType3);
                MESSAGE = type11;
                Type type12 = new Type("BYTES", 11, JavaType.BYTE_STRING);
                BYTES = type12;
                Type type13 = new Type("UINT32", 12, javaType2);
                UINT32 = type13;
                Type type14 = new Type("ENUM", 13, JavaType.ENUM);
                ENUM = type14;
                Type type15 = new Type("SFIXED32", 14, javaType2);
                SFIXED32 = type15;
                Type type16 = new Type("SFIXED64", 15, javaType);
                SFIXED64 = type16;
                Type type17 = new Type("SINT32", 16, javaType2);
                SINT32 = type17;
                Type type18 = new Type("SINT64", 17, javaType);
                SINT64 = type18;
                $VALUES = new Type[]{type, type2, type3, type4, type5, type6, type7, type8, type9, type10, type11, type12, type13, type14, type15, type16, type17, type18};
            }

            Type(String str, int i3, JavaType javaType) {
                this.javaType = javaType;
            }

            public static Type valueOf(String str) {
                return (Type) Enum.valueOf(Type.class, str);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public JavaType getJavaType() {
                return this.javaType;
            }

            public DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return DescriptorProtos.FieldDescriptorProto.Type.forNumber(ordinal() + 1);
            }

            public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type type) {
                return values()[type.getNumber() - 1];
            }
        }

        static {
            if (Type.values().length == DescriptorProtos.FieldDescriptorProto.Type.values().length) {
            } else {
                throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
            }
        }

        /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i3, boolean z16, a aVar) throws DescriptorValidationException {
            this(fieldDescriptorProto, fileDescriptor, bVar, i3, z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto) {
            this.f35368e = fieldDescriptorProto;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:47:0x01a4. Please report as an issue. */
        public void n() throws DescriptorValidationException {
            a aVar = null;
            if (this.f35368e.hasExtendee()) {
                e l3 = this.f35371i.D.l(this.f35368e.getExtendee(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
                if (l3 instanceof b) {
                    this.D = (b) l3;
                    if (!q().w(getNumber())) {
                        throw new DescriptorValidationException(this, '\"' + q().i() + "\" does not declare " + getNumber() + " as an extension number.", aVar);
                    }
                } else {
                    throw new DescriptorValidationException(this, '\"' + this.f35368e.getExtendee() + "\" is not a message type.", aVar);
                }
            }
            if (this.f35368e.hasTypeName()) {
                e l16 = this.f35371i.D.l(this.f35368e.getTypeName(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
                if (!this.f35368e.hasType()) {
                    if (l16 instanceof b) {
                        this.C = Type.MESSAGE;
                    } else if (l16 instanceof c) {
                        this.C = Type.ENUM;
                    } else {
                        throw new DescriptorValidationException(this, '\"' + this.f35368e.getTypeName() + "\" is not a type.", aVar);
                    }
                }
                if (v() == JavaType.MESSAGE) {
                    if (l16 instanceof b) {
                        this.E = (b) l16;
                        if (this.f35368e.hasDefaultValue()) {
                            throw new DescriptorValidationException(this, "Messages can't have default values.", aVar);
                        }
                    } else {
                        throw new DescriptorValidationException(this, '\"' + this.f35368e.getTypeName() + "\" is not a message type.", aVar);
                    }
                } else if (v() == JavaType.ENUM) {
                    if (l16 instanceof c) {
                        this.G = (c) l16;
                    } else {
                        throw new DescriptorValidationException(this, '\"' + this.f35368e.getTypeName() + "\" is not an enum type.", aVar);
                    }
                } else {
                    throw new DescriptorValidationException(this, "Field with primitive type has type_name.", aVar);
                }
            } else if (v() == JavaType.MESSAGE || v() == JavaType.ENUM) {
                throw new DescriptorValidationException(this, "Field with message or enum type missing type_name.", aVar);
            }
            if (this.f35368e.getOptions().getPacked() && !C()) {
                throw new DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", aVar);
            }
            if (this.f35368e.hasDefaultValue()) {
                if (!isRepeated()) {
                    try {
                        switch (a.f35380a[y().ordinal()]) {
                            case 1:
                            case 2:
                            case 3:
                                this.H = Integer.valueOf(TextFormat.i(this.f35368e.getDefaultValue()));
                                break;
                            case 4:
                            case 5:
                                this.H = Integer.valueOf(TextFormat.l(this.f35368e.getDefaultValue()));
                                break;
                            case 6:
                            case 7:
                            case 8:
                                this.H = Long.valueOf(TextFormat.j(this.f35368e.getDefaultValue()));
                                break;
                            case 9:
                            case 10:
                                this.H = Long.valueOf(TextFormat.m(this.f35368e.getDefaultValue()));
                                break;
                            case 11:
                                if (this.f35368e.getDefaultValue().equals("inf")) {
                                    this.H = Float.valueOf(Float.POSITIVE_INFINITY);
                                    break;
                                } else if (this.f35368e.getDefaultValue().equals("-inf")) {
                                    this.H = Float.valueOf(Float.NEGATIVE_INFINITY);
                                    break;
                                } else if (this.f35368e.getDefaultValue().equals("nan")) {
                                    this.H = Float.valueOf(Float.NaN);
                                    break;
                                } else {
                                    this.H = Float.valueOf(this.f35368e.getDefaultValue());
                                    break;
                                }
                            case 12:
                                if (this.f35368e.getDefaultValue().equals("inf")) {
                                    this.H = Double.valueOf(Double.POSITIVE_INFINITY);
                                    break;
                                } else if (this.f35368e.getDefaultValue().equals("-inf")) {
                                    this.H = Double.valueOf(Double.NEGATIVE_INFINITY);
                                    break;
                                } else if (this.f35368e.getDefaultValue().equals("nan")) {
                                    this.H = Double.valueOf(Double.NaN);
                                    break;
                                } else {
                                    this.H = Double.valueOf(this.f35368e.getDefaultValue());
                                    break;
                                }
                            case 13:
                                this.H = Boolean.valueOf(this.f35368e.getDefaultValue());
                                break;
                            case 14:
                                this.H = this.f35368e.getDefaultValue();
                                break;
                            case 15:
                                try {
                                    this.H = TextFormat.o(this.f35368e.getDefaultValue());
                                    break;
                                } catch (TextFormat.InvalidEscapeSequenceException e16) {
                                    throw new DescriptorValidationException(this, "Couldn't parse default value: " + e16.getMessage(), e16, aVar);
                                }
                            case 16:
                                d l17 = this.G.l(this.f35368e.getDefaultValue());
                                this.H = l17;
                                if (l17 == null) {
                                    throw new DescriptorValidationException(this, "Unknown enum default value: \"" + this.f35368e.getDefaultValue() + '\"', aVar);
                                }
                                break;
                            case 17:
                            case 18:
                                throw new DescriptorValidationException(this, "Message type had default value.", aVar);
                        }
                    } catch (NumberFormatException e17) {
                        throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.f35368e.getDefaultValue() + '\"', e17, aVar);
                    }
                } else {
                    throw new DescriptorValidationException(this, "Repeated fields cannot have default values.", aVar);
                }
            } else if (isRepeated()) {
                this.H = Collections.emptyList();
            } else {
                int i3 = a.f35381b[v().ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        this.H = v().defaultDefault;
                    } else {
                        this.H = null;
                    }
                } else {
                    this.H = this.G.o().get(0);
                }
            }
            if (!z()) {
                this.f35371i.D.d(this);
            }
            b bVar = this.D;
            if (bVar != null && bVar.u().getMessageSetWireFormat()) {
                if (z()) {
                    if (!B() || y() != Type.MESSAGE) {
                        throw new DescriptorValidationException(this, "Extensions of MessageSets must be optional messages.", aVar);
                    }
                    return;
                }
                throw new DescriptorValidationException(this, "MessageSets cannot have fields, only extensions.", aVar);
            }
        }

        private static String o(String str) {
            int length = str.length();
            StringBuilder sb5 = new StringBuilder(length);
            boolean z16 = false;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (charAt == '_') {
                    z16 = true;
                } else if (z16) {
                    if ('a' <= charAt && charAt <= 'z') {
                        charAt = (char) ((charAt - 'a') + 65);
                    }
                    sb5.append(charAt);
                    z16 = false;
                } else {
                    sb5.append(charAt);
                }
            }
            return sb5.toString();
        }

        public boolean A() {
            if (y() == Type.MESSAGE && isRepeated() && w().u().getMapEntry()) {
                return true;
            }
            return false;
        }

        public boolean B() {
            if (this.f35368e.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL) {
                return true;
            }
            return false;
        }

        public boolean C() {
            if (isRepeated() && getLiteType().isPackable()) {
                return true;
            }
            return false;
        }

        public boolean E() {
            if (this.f35368e.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED) {
                return true;
            }
            return false;
        }

        public boolean F() {
            if (this.C != Type.STRING) {
                return false;
            }
            if (q().u().getMapEntry() || h().t() == FileDescriptor.Syntax.PROTO3) {
                return true;
            }
            return h().q().getJavaStringCheckUtf8();
        }

        @Override // com.google.protobuf.Descriptors.e
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos.FieldDescriptorProto j() {
            return this.f35368e;
        }

        @Override // com.google.protobuf.z.c
        public au.a a(au.a aVar, au auVar) {
            return ((ar.a) aVar).mergeFrom((ar) auVar);
        }

        @Override // com.google.protobuf.z.c
        public WireFormat.JavaType getLiteJavaType() {
            return getLiteType().getJavaType();
        }

        @Override // com.google.protobuf.z.c
        public WireFormat.FieldType getLiteType() {
            return I[this.C.ordinal()];
        }

        @Override // com.google.protobuf.Descriptors.e
        public String getName() {
            return this.f35368e.getName();
        }

        @Override // com.google.protobuf.z.c
        public int getNumber() {
            return this.f35368e.getNumber();
        }

        @Override // com.google.protobuf.Descriptors.e
        public FileDescriptor h() {
            return this.f35371i;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String i() {
            return this.f35369f;
        }

        @Override // com.google.protobuf.z.c
        public boolean isPacked() {
            if (!C()) {
                return false;
            }
            if (h().t() == FileDescriptor.Syntax.PROTO2) {
                return x().getPacked();
            }
            if (x().hasPacked() && !x().getPacked()) {
                return false;
            }
            return true;
        }

        @Override // com.google.protobuf.z.c
        public boolean isRepeated() {
            if (this.f35368e.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Comparable
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public int compareTo(FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.D == this.D) {
                return getNumber() - fieldDescriptor.getNumber();
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        public g p() {
            return this.F;
        }

        public b q() {
            return this.D;
        }

        public Object r() {
            if (v() != JavaType.MESSAGE) {
                return this.H;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public c s() {
            if (v() == JavaType.ENUM) {
                return this.G;
            }
            throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", this.f35369f));
        }

        public b t() {
            if (z()) {
                return this.f35372m;
            }
            throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", this.f35369f));
        }

        public String toString() {
            return i();
        }

        public int u() {
            return this.f35367d;
        }

        public JavaType v() {
            return this.C.getJavaType();
        }

        public b w() {
            if (v() == JavaType.MESSAGE) {
                return this.E;
            }
            throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", this.f35369f));
        }

        public DescriptorProtos.FieldOptions x() {
            return this.f35368e.getOptions();
        }

        public Type y() {
            return this.C;
        }

        public boolean z() {
            return this.f35368e.hasExtendee();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        FieldDescriptor(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i3, boolean z16) throws DescriptorValidationException {
            super(r0);
            a aVar = null;
            this.f35367d = i3;
            this.f35368e = fieldDescriptorProto;
            this.f35369f = Descriptors.c(fileDescriptor, bVar, fieldDescriptorProto.getName());
            this.f35371i = fileDescriptor;
            if (fieldDescriptorProto.hasJsonName()) {
                this.f35370h = fieldDescriptorProto.getJsonName();
            } else {
                this.f35370h = o(fieldDescriptorProto.getName());
            }
            if (fieldDescriptorProto.hasType()) {
                this.C = Type.valueOf(fieldDescriptorProto.getType());
            }
            if (getNumber() > 0) {
                if (z16) {
                    if (fieldDescriptorProto.hasExtendee()) {
                        this.D = null;
                        if (bVar != null) {
                            this.f35372m = bVar;
                        } else {
                            this.f35372m = null;
                        }
                        if (!fieldDescriptorProto.hasOneofIndex()) {
                            this.F = null;
                        } else {
                            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", aVar);
                        }
                    } else {
                        throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", aVar);
                    }
                } else if (!fieldDescriptorProto.hasExtendee()) {
                    this.D = bVar;
                    if (fieldDescriptorProto.hasOneofIndex()) {
                        if (fieldDescriptorProto.getOneofIndex() >= 0 && fieldDescriptorProto.getOneofIndex() < bVar.j().getOneofDeclCount()) {
                            g gVar = bVar.t().get(fieldDescriptorProto.getOneofIndex());
                            this.F = gVar;
                            g.n(gVar);
                        } else {
                            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index is out of range for type " + bVar.getName(), aVar);
                        }
                    } else {
                        this.F = null;
                    }
                    this.f35372m = null;
                } else {
                    throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", aVar);
                }
                fileDescriptor.D.f(this);
                return;
            }
            throw new DescriptorValidationException(this, "Field numbers must be positive integers.", aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35380a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f35381b;

        static {
            int[] iArr = new int[FieldDescriptor.JavaType.values().length];
            f35381b = iArr;
            try {
                iArr[FieldDescriptor.JavaType.ENUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35381b[FieldDescriptor.JavaType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[FieldDescriptor.Type.values().length];
            f35380a = iArr2;
            try {
                iArr2[FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35380a[FieldDescriptor.Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35380a[FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35380a[FieldDescriptor.Type.UINT32.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35380a[FieldDescriptor.Type.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35380a[FieldDescriptor.Type.INT64.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35380a[FieldDescriptor.Type.SINT64.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35380a[FieldDescriptor.Type.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35380a[FieldDescriptor.Type.UINT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35380a[FieldDescriptor.Type.FIXED64.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35380a[FieldDescriptor.Type.FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35380a[FieldDescriptor.Type.DOUBLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35380a[FieldDescriptor.Type.BOOL.ordinal()] = 13;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35380a[FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35380a[FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f35380a[FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f35380a[FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f35380a[FieldDescriptor.Type.f35373GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b extends e {
        private final c[] C;
        private final FieldDescriptor[] D;
        private final FieldDescriptor[] E;
        private final g[] F;

        /* renamed from: d, reason: collision with root package name */
        private final int f35382d;

        /* renamed from: e, reason: collision with root package name */
        private DescriptorProtos.DescriptorProto f35383e;

        /* renamed from: f, reason: collision with root package name */
        private final String f35384f;

        /* renamed from: h, reason: collision with root package name */
        private final FileDescriptor f35385h;

        /* renamed from: i, reason: collision with root package name */
        private final b f35386i;

        /* renamed from: m, reason: collision with root package name */
        private final b[] f35387m;

        /* synthetic */ b(DescriptorProtos.DescriptorProto descriptorProto, FileDescriptor fileDescriptor, b bVar, int i3, a aVar) throws DescriptorValidationException {
            this(descriptorProto, fileDescriptor, bVar, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m() throws DescriptorValidationException {
            for (b bVar : this.f35387m) {
                bVar.m();
            }
            for (FieldDescriptor fieldDescriptor : this.D) {
                fieldDescriptor.n();
            }
            for (FieldDescriptor fieldDescriptor2 : this.E) {
                fieldDescriptor2.n();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(DescriptorProtos.DescriptorProto descriptorProto) {
            this.f35383e = descriptorProto;
            int i3 = 0;
            int i16 = 0;
            while (true) {
                b[] bVarArr = this.f35387m;
                if (i16 >= bVarArr.length) {
                    break;
                }
                bVarArr[i16].x(descriptorProto.getNestedType(i16));
                i16++;
            }
            int i17 = 0;
            while (true) {
                g[] gVarArr = this.F;
                if (i17 >= gVarArr.length) {
                    break;
                }
                gVarArr[i17].s(descriptorProto.getOneofDecl(i17));
                i17++;
            }
            int i18 = 0;
            while (true) {
                c[] cVarArr = this.C;
                if (i18 >= cVarArr.length) {
                    break;
                }
                cVarArr[i18].p(descriptorProto.getEnumType(i18));
                i18++;
            }
            int i19 = 0;
            while (true) {
                FieldDescriptor[] fieldDescriptorArr = this.D;
                if (i19 >= fieldDescriptorArr.length) {
                    break;
                }
                fieldDescriptorArr[i19].G(descriptorProto.getField(i19));
                i19++;
            }
            while (true) {
                FieldDescriptor[] fieldDescriptorArr2 = this.E;
                if (i3 < fieldDescriptorArr2.length) {
                    fieldDescriptorArr2[i3].G(descriptorProto.getExtension(i3));
                    i3++;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.Descriptors.e
        public String getName() {
            return this.f35383e.getName();
        }

        @Override // com.google.protobuf.Descriptors.e
        public FileDescriptor h() {
            return this.f35385h;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String i() {
            return this.f35384f;
        }

        public FieldDescriptor n(String str) {
            e g16 = this.f35385h.D.g(this.f35384f + '.' + str);
            if (g16 != null && (g16 instanceof FieldDescriptor)) {
                return (FieldDescriptor) g16;
            }
            return null;
        }

        public FieldDescriptor o(int i3) {
            return (FieldDescriptor) this.f35385h.D.f35360d.get(new DescriptorPool.a(this, i3));
        }

        public List<c> p() {
            return Collections.unmodifiableList(Arrays.asList(this.C));
        }

        public List<FieldDescriptor> q() {
            return Collections.unmodifiableList(Arrays.asList(this.E));
        }

        public List<FieldDescriptor> r() {
            return Collections.unmodifiableList(Arrays.asList(this.D));
        }

        public List<b> s() {
            return Collections.unmodifiableList(Arrays.asList(this.f35387m));
        }

        public List<g> t() {
            return Collections.unmodifiableList(Arrays.asList(this.F));
        }

        public DescriptorProtos.MessageOptions u() {
            return this.f35383e.getOptions();
        }

        public boolean v() {
            if (this.f35383e.getExtensionRangeList().size() != 0) {
                return true;
            }
            return false;
        }

        public boolean w(int i3) {
            for (DescriptorProtos.DescriptorProto.ExtensionRange extensionRange : this.f35383e.getExtensionRangeList()) {
                if (extensionRange.getStart() <= i3 && i3 < extensionRange.getEnd()) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.protobuf.Descriptors.e
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos.DescriptorProto j() {
            return this.f35383e;
        }

        b(String str) throws DescriptorValidationException {
            super(null);
            String str2;
            String str3;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str3 = str.substring(lastIndexOf + 1);
                str2 = str.substring(0, lastIndexOf);
            } else {
                str2 = "";
                str3 = str;
            }
            this.f35382d = 0;
            this.f35383e = DescriptorProtos.DescriptorProto.newBuilder().T(str3).n(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().E(1).C(536870912).build()).build();
            this.f35384f = str;
            this.f35386i = null;
            this.f35387m = new b[0];
            this.C = new c[0];
            this.D = new FieldDescriptor[0];
            this.E = new FieldDescriptor[0];
            this.F = new g[0];
            this.f35385h = new FileDescriptor(str2, this);
        }

        b(DescriptorProtos.DescriptorProto descriptorProto, FileDescriptor fileDescriptor, b bVar, int i3) throws DescriptorValidationException {
            super(null);
            this.f35382d = i3;
            this.f35383e = descriptorProto;
            this.f35384f = Descriptors.c(fileDescriptor, bVar, descriptorProto.getName());
            this.f35385h = fileDescriptor;
            this.f35386i = bVar;
            this.F = new g[descriptorProto.getOneofDeclCount()];
            for (int i16 = 0; i16 < descriptorProto.getOneofDeclCount(); i16++) {
                this.F[i16] = new g(descriptorProto.getOneofDecl(i16), fileDescriptor, this, i16, null);
            }
            this.f35387m = new b[descriptorProto.getNestedTypeCount()];
            for (int i17 = 0; i17 < descriptorProto.getNestedTypeCount(); i17++) {
                this.f35387m[i17] = new b(descriptorProto.getNestedType(i17), fileDescriptor, this, i17);
            }
            this.C = new c[descriptorProto.getEnumTypeCount()];
            for (int i18 = 0; i18 < descriptorProto.getEnumTypeCount(); i18++) {
                this.C[i18] = new c(descriptorProto.getEnumType(i18), fileDescriptor, this, i18, null);
            }
            this.D = new FieldDescriptor[descriptorProto.getFieldCount()];
            for (int i19 = 0; i19 < descriptorProto.getFieldCount(); i19++) {
                this.D[i19] = new FieldDescriptor(descriptorProto.getField(i19), fileDescriptor, this, i19, false, null);
            }
            this.E = new FieldDescriptor[descriptorProto.getExtensionCount()];
            for (int i26 = 0; i26 < descriptorProto.getExtensionCount(); i26++) {
                this.E[i26] = new FieldDescriptor(descriptorProto.getExtension(i26), fileDescriptor, this, i26, true, null);
            }
            for (int i27 = 0; i27 < descriptorProto.getOneofDeclCount(); i27++) {
                g gVar = this.F[i27];
                gVar.C = new FieldDescriptor[gVar.q()];
                this.F[i27].f35410m = 0;
            }
            for (int i28 = 0; i28 < descriptorProto.getFieldCount(); i28++) {
                g p16 = this.D[i28].p();
                if (p16 != null) {
                    p16.C[g.n(p16)] = this.D[i28];
                }
            }
            fileDescriptor.D.f(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c extends e implements ad.d<d> {
        private final WeakHashMap<Integer, WeakReference<d>> C;

        /* renamed from: d, reason: collision with root package name */
        private final int f35388d;

        /* renamed from: e, reason: collision with root package name */
        private DescriptorProtos.EnumDescriptorProto f35389e;

        /* renamed from: f, reason: collision with root package name */
        private final String f35390f;

        /* renamed from: h, reason: collision with root package name */
        private final FileDescriptor f35391h;

        /* renamed from: i, reason: collision with root package name */
        private final b f35392i;

        /* renamed from: m, reason: collision with root package name */
        private d[] f35393m;

        /* synthetic */ c(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i3, a aVar) throws DescriptorValidationException {
            this(enumDescriptorProto, fileDescriptor, bVar, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(DescriptorProtos.EnumDescriptorProto enumDescriptorProto) {
            this.f35389e = enumDescriptorProto;
            int i3 = 0;
            while (true) {
                d[] dVarArr = this.f35393m;
                if (i3 < dVarArr.length) {
                    dVarArr[i3].n(enumDescriptorProto.getValue(i3));
                    i3++;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.Descriptors.e
        public String getName() {
            return this.f35389e.getName();
        }

        @Override // com.google.protobuf.Descriptors.e
        public FileDescriptor h() {
            return this.f35391h;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String i() {
            return this.f35390f;
        }

        public d l(String str) {
            e g16 = this.f35391h.D.g(this.f35390f + '.' + str);
            if (g16 != null && (g16 instanceof d)) {
                return (d) g16;
            }
            return null;
        }

        @Override // com.google.protobuf.ad.d
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public d findValueByNumber(int i3) {
            return (d) this.f35391h.D.f35361e.get(new DescriptorPool.a(this, i3));
        }

        public d n(int i3) {
            d findValueByNumber = findValueByNumber(i3);
            if (findValueByNumber != null) {
                return findValueByNumber;
            }
            synchronized (this) {
                Integer num = new Integer(i3);
                WeakReference<d> weakReference = this.C.get(num);
                if (weakReference != null) {
                    findValueByNumber = weakReference.get();
                }
                if (findValueByNumber == null) {
                    findValueByNumber = new d(this.f35391h, this, num, (a) null);
                    this.C.put(num, new WeakReference<>(findValueByNumber));
                }
            }
            return findValueByNumber;
        }

        public List<d> o() {
            return Collections.unmodifiableList(Arrays.asList(this.f35393m));
        }

        @Override // com.google.protobuf.Descriptors.e
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos.EnumDescriptorProto j() {
            return this.f35389e;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        c(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i3) throws DescriptorValidationException {
            super(r0);
            a aVar = null;
            this.C = new WeakHashMap<>();
            this.f35388d = i3;
            this.f35389e = enumDescriptorProto;
            this.f35390f = Descriptors.c(fileDescriptor, bVar, enumDescriptorProto.getName());
            this.f35391h = fileDescriptor;
            this.f35392i = bVar;
            if (enumDescriptorProto.getValueCount() != 0) {
                this.f35393m = new d[enumDescriptorProto.getValueCount()];
                for (int i16 = 0; i16 < enumDescriptorProto.getValueCount(); i16++) {
                    this.f35393m[i16] = new d(enumDescriptorProto.getValue(i16), fileDescriptor, this, i16, null);
                }
                fileDescriptor.D.f(this);
                return;
            }
            throw new DescriptorValidationException(this, "Enums must contain at least one value.", aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class d extends e implements ad.c {

        /* renamed from: d, reason: collision with root package name */
        private final int f35394d;

        /* renamed from: e, reason: collision with root package name */
        private DescriptorProtos.EnumValueDescriptorProto f35395e;

        /* renamed from: f, reason: collision with root package name */
        private final String f35396f;

        /* renamed from: h, reason: collision with root package name */
        private final FileDescriptor f35397h;

        /* renamed from: i, reason: collision with root package name */
        private final c f35398i;

        /* synthetic */ d(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, c cVar, int i3, a aVar) throws DescriptorValidationException {
            this(enumValueDescriptorProto, fileDescriptor, cVar, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto) {
            this.f35395e = enumValueDescriptorProto;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String getName() {
            return this.f35395e.getName();
        }

        @Override // com.google.protobuf.ad.c
        public int getNumber() {
            return this.f35395e.getNumber();
        }

        @Override // com.google.protobuf.Descriptors.e
        public FileDescriptor h() {
            return this.f35397h;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String i() {
            return this.f35396f;
        }

        public int l() {
            return this.f35394d;
        }

        public c m() {
            return this.f35398i;
        }

        @Override // com.google.protobuf.Descriptors.e
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos.EnumValueDescriptorProto j() {
            return this.f35395e;
        }

        public String toString() {
            return this.f35395e.getName();
        }

        /* synthetic */ d(FileDescriptor fileDescriptor, c cVar, Integer num, a aVar) {
            this(fileDescriptor, cVar, num);
        }

        d(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, c cVar, int i3) throws DescriptorValidationException {
            super(null);
            this.f35394d = i3;
            this.f35395e = enumValueDescriptorProto;
            this.f35397h = fileDescriptor;
            this.f35398i = cVar;
            this.f35396f = cVar.i() + '.' + enumValueDescriptorProto.getName();
            fileDescriptor.D.f(this);
            fileDescriptor.D.c(this);
        }

        d(FileDescriptor fileDescriptor, c cVar, Integer num) {
            super(null);
            DescriptorProtos.EnumValueDescriptorProto build = DescriptorProtos.EnumValueDescriptorProto.newBuilder().D("UNKNOWN_ENUM_VALUE_" + cVar.getName() + "_" + num).E(num.intValue()).build();
            this.f35394d = -1;
            this.f35395e = build;
            this.f35397h = fileDescriptor;
            this.f35398i = cVar;
            this.f35396f = cVar.i() + '.' + build.getName();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class e {
        /* synthetic */ e(a aVar) {
            this();
        }

        public abstract String getName();

        public abstract FileDescriptor h();

        public abstract String i();

        public abstract ar j();

        e() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class f extends e {
        private b C;

        /* renamed from: d, reason: collision with root package name */
        private final int f35399d;

        /* renamed from: e, reason: collision with root package name */
        private DescriptorProtos.MethodDescriptorProto f35400e;

        /* renamed from: f, reason: collision with root package name */
        private final String f35401f;

        /* renamed from: h, reason: collision with root package name */
        private final FileDescriptor f35402h;

        /* renamed from: i, reason: collision with root package name */
        private final h f35403i;

        /* renamed from: m, reason: collision with root package name */
        private b f35404m;

        /* synthetic */ f(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, h hVar, int i3, a aVar) throws DescriptorValidationException {
            this(methodDescriptorProto, fileDescriptor, hVar, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m() throws DescriptorValidationException {
            DescriptorPool descriptorPool = this.f35402h.D;
            String inputType = this.f35400e.getInputType();
            DescriptorPool.SearchFilter searchFilter = DescriptorPool.SearchFilter.TYPES_ONLY;
            e l3 = descriptorPool.l(inputType, this, searchFilter);
            a aVar = null;
            if (l3 instanceof b) {
                this.f35404m = (b) l3;
                e l16 = this.f35402h.D.l(this.f35400e.getOutputType(), this, searchFilter);
                if (l16 instanceof b) {
                    this.C = (b) l16;
                    return;
                }
                throw new DescriptorValidationException(this, '\"' + this.f35400e.getOutputType() + "\" is not a message type.", aVar);
            }
            throw new DescriptorValidationException(this, '\"' + this.f35400e.getInputType() + "\" is not a message type.", aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(DescriptorProtos.MethodDescriptorProto methodDescriptorProto) {
            this.f35400e = methodDescriptorProto;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String getName() {
            return this.f35400e.getName();
        }

        @Override // com.google.protobuf.Descriptors.e
        public FileDescriptor h() {
            return this.f35402h;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String i() {
            return this.f35401f;
        }

        @Override // com.google.protobuf.Descriptors.e
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos.MethodDescriptorProto j() {
            return this.f35400e;
        }

        f(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, h hVar, int i3) throws DescriptorValidationException {
            super(null);
            this.f35399d = i3;
            this.f35400e = methodDescriptorProto;
            this.f35402h = fileDescriptor;
            this.f35403i = hVar;
            this.f35401f = hVar.i() + '.' + methodDescriptorProto.getName();
            fileDescriptor.D.f(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class g extends e {
        private FieldDescriptor[] C;

        /* renamed from: d, reason: collision with root package name */
        private final int f35405d;

        /* renamed from: e, reason: collision with root package name */
        private DescriptorProtos.OneofDescriptorProto f35406e;

        /* renamed from: f, reason: collision with root package name */
        private final String f35407f;

        /* renamed from: h, reason: collision with root package name */
        private final FileDescriptor f35408h;

        /* renamed from: i, reason: collision with root package name */
        private b f35409i;

        /* renamed from: m, reason: collision with root package name */
        private int f35410m;

        /* synthetic */ g(DescriptorProtos.OneofDescriptorProto oneofDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i3, a aVar) throws DescriptorValidationException {
            this(oneofDescriptorProto, fileDescriptor, bVar, i3);
        }

        static /* synthetic */ int n(g gVar) {
            int i3 = gVar.f35410m;
            gVar.f35410m = i3 + 1;
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(DescriptorProtos.OneofDescriptorProto oneofDescriptorProto) {
            this.f35406e = oneofDescriptorProto;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String getName() {
            return this.f35406e.getName();
        }

        @Override // com.google.protobuf.Descriptors.e
        public FileDescriptor h() {
            return this.f35408h;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String i() {
            return this.f35407f;
        }

        public b p() {
            return this.f35409i;
        }

        public int q() {
            return this.f35410m;
        }

        public int r() {
            return this.f35405d;
        }

        @Override // com.google.protobuf.Descriptors.e
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos.OneofDescriptorProto j() {
            return this.f35406e;
        }

        g(DescriptorProtos.OneofDescriptorProto oneofDescriptorProto, FileDescriptor fileDescriptor, b bVar, int i3) throws DescriptorValidationException {
            super(null);
            this.f35406e = oneofDescriptorProto;
            this.f35407f = Descriptors.c(fileDescriptor, bVar, oneofDescriptorProto.getName());
            this.f35408h = fileDescriptor;
            this.f35405d = i3;
            this.f35409i = bVar;
            this.f35410m = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class h extends e {

        /* renamed from: d, reason: collision with root package name */
        private final int f35411d;

        /* renamed from: e, reason: collision with root package name */
        private DescriptorProtos.ServiceDescriptorProto f35412e;

        /* renamed from: f, reason: collision with root package name */
        private final String f35413f;

        /* renamed from: h, reason: collision with root package name */
        private final FileDescriptor f35414h;

        /* renamed from: i, reason: collision with root package name */
        private f[] f35415i;

        /* synthetic */ h(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i3, a aVar) throws DescriptorValidationException {
            this(serviceDescriptorProto, fileDescriptor, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m() throws DescriptorValidationException {
            for (f fVar : this.f35415i) {
                fVar.m();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto) {
            this.f35412e = serviceDescriptorProto;
            int i3 = 0;
            while (true) {
                f[] fVarArr = this.f35415i;
                if (i3 < fVarArr.length) {
                    fVarArr[i3].n(serviceDescriptorProto.getMethod(i3));
                    i3++;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.Descriptors.e
        public String getName() {
            return this.f35412e.getName();
        }

        @Override // com.google.protobuf.Descriptors.e
        public FileDescriptor h() {
            return this.f35414h;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String i() {
            return this.f35413f;
        }

        @Override // com.google.protobuf.Descriptors.e
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos.ServiceDescriptorProto j() {
            return this.f35412e;
        }

        h(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i3) throws DescriptorValidationException {
            super(null);
            this.f35411d = i3;
            this.f35412e = serviceDescriptorProto;
            this.f35413f = Descriptors.c(fileDescriptor, null, serviceDescriptorProto.getName());
            this.f35414h = fileDescriptor;
            this.f35415i = new f[serviceDescriptorProto.getMethodCount()];
            for (int i16 = 0; i16 < serviceDescriptorProto.getMethodCount(); i16++) {
                this.f35415i[i16] = new f(serviceDescriptorProto.getMethod(i16), fileDescriptor, this, i16, null);
            }
            fileDescriptor.D.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(FileDescriptor fileDescriptor, b bVar, String str) {
        if (bVar != null) {
            return bVar.i() + '.' + str;
        }
        String r16 = fileDescriptor.r();
        if (!r16.isEmpty()) {
            return r16 + '.' + str;
        }
        return str;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class FileDescriptor extends e {
        private final FileDescriptor[] C;
        private final DescriptorPool D;

        /* renamed from: d, reason: collision with root package name */
        private DescriptorProtos.FileDescriptorProto f35374d;

        /* renamed from: e, reason: collision with root package name */
        private final b[] f35375e;

        /* renamed from: f, reason: collision with root package name */
        private final c[] f35376f;

        /* renamed from: h, reason: collision with root package name */
        private final h[] f35377h;

        /* renamed from: i, reason: collision with root package name */
        private final FieldDescriptor[] f35378i;

        /* renamed from: m, reason: collision with root package name */
        private final FileDescriptor[] f35379m;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum Syntax {
            UNKNOWN("unknown"),
            PROTO2("proto2"),
            PROTO3("proto3");

            private final String name;

            Syntax(String str) {
                this.name = str;
            }
        }

        /* compiled from: P */
        @Deprecated
        /* loaded from: classes2.dex */
        public interface a {
            r assignDescriptors(FileDescriptor fileDescriptor);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        FileDescriptor(DescriptorProtos.FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr, DescriptorPool descriptorPool, boolean z16) throws DescriptorValidationException {
            super(r0);
            a aVar = null;
            this.D = descriptorPool;
            this.f35374d = fileDescriptorProto;
            this.f35379m = (FileDescriptor[]) fileDescriptorArr.clone();
            HashMap hashMap = new HashMap();
            for (FileDescriptor fileDescriptor : fileDescriptorArr) {
                hashMap.put(fileDescriptor.getName(), fileDescriptor);
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < fileDescriptorProto.getPublicDependencyCount(); i3++) {
                int publicDependency = fileDescriptorProto.getPublicDependency(i3);
                if (publicDependency >= 0 && publicDependency < fileDescriptorProto.getDependencyCount()) {
                    String dependency = fileDescriptorProto.getDependency(publicDependency);
                    FileDescriptor fileDescriptor2 = (FileDescriptor) hashMap.get(dependency);
                    if (fileDescriptor2 != null) {
                        arrayList.add(fileDescriptor2);
                    } else if (!z16) {
                        throw new DescriptorValidationException(this, "Invalid public dependency: " + dependency, aVar);
                    }
                } else {
                    throw new DescriptorValidationException(this, "Invalid public dependency index.", aVar);
                }
            }
            FileDescriptor[] fileDescriptorArr2 = new FileDescriptor[arrayList.size()];
            this.C = fileDescriptorArr2;
            arrayList.toArray(fileDescriptorArr2);
            descriptorPool.e(r(), this);
            this.f35375e = new b[fileDescriptorProto.getMessageTypeCount()];
            for (int i16 = 0; i16 < fileDescriptorProto.getMessageTypeCount(); i16++) {
                this.f35375e[i16] = new b(fileDescriptorProto.getMessageType(i16), this, null, i16, null);
            }
            this.f35376f = new c[fileDescriptorProto.getEnumTypeCount()];
            for (int i17 = 0; i17 < fileDescriptorProto.getEnumTypeCount(); i17++) {
                this.f35376f[i17] = new c(fileDescriptorProto.getEnumType(i17), this, null, i17, null);
            }
            this.f35377h = new h[fileDescriptorProto.getServiceCount()];
            for (int i18 = 0; i18 < fileDescriptorProto.getServiceCount(); i18++) {
                this.f35377h[i18] = new h(fileDescriptorProto.getService(i18), this, i18, aVar);
            }
            this.f35378i = new FieldDescriptor[fileDescriptorProto.getExtensionCount()];
            for (int i19 = 0; i19 < fileDescriptorProto.getExtensionCount(); i19++) {
                this.f35378i[i19] = new FieldDescriptor(fileDescriptorProto.getExtension(i19), this, null, i19, true, null);
            }
        }

        public static FileDescriptor l(DescriptorProtos.FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr, boolean z16) throws DescriptorValidationException {
            FileDescriptor fileDescriptor = new FileDescriptor(fileDescriptorProto, fileDescriptorArr, new DescriptorPool(fileDescriptorArr, z16), z16);
            fileDescriptor.m();
            return fileDescriptor;
        }

        private void m() throws DescriptorValidationException {
            for (b bVar : this.f35375e) {
                bVar.m();
            }
            for (h hVar : this.f35377h) {
                hVar.m();
            }
            for (FieldDescriptor fieldDescriptor : this.f35378i) {
                fieldDescriptor.n();
            }
        }

        public static FileDescriptor u(String[] strArr, FileDescriptor[] fileDescriptorArr) {
            try {
                DescriptorProtos.FileDescriptorProto parseFrom = DescriptorProtos.FileDescriptorProto.parseFrom(x(strArr));
                try {
                    return l(parseFrom, fileDescriptorArr, true);
                } catch (DescriptorValidationException e16) {
                    throw new IllegalArgumentException("Invalid embedded descriptor for \"" + parseFrom.getName() + "\".", e16);
                }
            } catch (InvalidProtocolBufferException e17) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e17);
            }
        }

        @Deprecated
        public static void v(String[] strArr, FileDescriptor[] fileDescriptorArr, a aVar) {
            byte[] x16 = x(strArr);
            try {
                DescriptorProtos.FileDescriptorProto parseFrom = DescriptorProtos.FileDescriptorProto.parseFrom(x16);
                try {
                    FileDescriptor l3 = l(parseFrom, fileDescriptorArr, true);
                    r assignDescriptors = aVar.assignDescriptors(l3);
                    if (assignDescriptors != null) {
                        try {
                            l3.y(DescriptorProtos.FileDescriptorProto.parseFrom(x16, assignDescriptors));
                        } catch (InvalidProtocolBufferException e16) {
                            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e16);
                        }
                    }
                } catch (DescriptorValidationException e17) {
                    throw new IllegalArgumentException("Invalid embedded descriptor for \"" + parseFrom.getName() + "\".", e17);
                }
            } catch (InvalidProtocolBufferException e18) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e18);
            }
        }

        public static void w(FileDescriptor fileDescriptor, r rVar) {
            try {
                fileDescriptor.y(DescriptorProtos.FileDescriptorProto.parseFrom(fileDescriptor.f35374d.toByteString(), rVar));
            } catch (InvalidProtocolBufferException e16) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e16);
            }
        }

        private static byte[] x(String[] strArr) {
            if (strArr.length == 1) {
                return strArr[0].getBytes(ad.f35641b);
            }
            StringBuilder sb5 = new StringBuilder();
            for (String str : strArr) {
                sb5.append(str);
            }
            return sb5.toString().getBytes(ad.f35641b);
        }

        private void y(DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
            this.f35374d = fileDescriptorProto;
            int i3 = 0;
            int i16 = 0;
            while (true) {
                b[] bVarArr = this.f35375e;
                if (i16 >= bVarArr.length) {
                    break;
                }
                bVarArr[i16].x(fileDescriptorProto.getMessageType(i16));
                i16++;
            }
            int i17 = 0;
            while (true) {
                c[] cVarArr = this.f35376f;
                if (i17 >= cVarArr.length) {
                    break;
                }
                cVarArr[i17].p(fileDescriptorProto.getEnumType(i17));
                i17++;
            }
            int i18 = 0;
            while (true) {
                h[] hVarArr = this.f35377h;
                if (i18 >= hVarArr.length) {
                    break;
                }
                hVarArr[i18].n(fileDescriptorProto.getService(i18));
                i18++;
            }
            while (true) {
                FieldDescriptor[] fieldDescriptorArr = this.f35378i;
                if (i3 < fieldDescriptorArr.length) {
                    fieldDescriptorArr[i3].G(fileDescriptorProto.getExtension(i3));
                    i3++;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.Descriptors.e
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos.FileDescriptorProto j() {
            return this.f35374d;
        }

        @Override // com.google.protobuf.Descriptors.e
        public String getName() {
            return this.f35374d.getName();
        }

        @Override // com.google.protobuf.Descriptors.e
        public String i() {
            return this.f35374d.getName();
        }

        public FieldDescriptor n(String str) {
            if (str.indexOf(46) != -1) {
                return null;
            }
            String r16 = r();
            if (!r16.isEmpty()) {
                str = r16 + '.' + str;
            }
            e g16 = this.D.g(str);
            if (g16 == null || !(g16 instanceof FieldDescriptor) || g16.h() != this) {
                return null;
            }
            return (FieldDescriptor) g16;
        }

        public List<c> o() {
            return Collections.unmodifiableList(Arrays.asList(this.f35376f));
        }

        public List<b> p() {
            return Collections.unmodifiableList(Arrays.asList(this.f35375e));
        }

        public DescriptorProtos.FileOptions q() {
            return this.f35374d.getOptions();
        }

        public String r() {
            return this.f35374d.getPackage();
        }

        public List<FileDescriptor> s() {
            return Collections.unmodifiableList(Arrays.asList(this.C));
        }

        public Syntax t() {
            Syntax syntax = Syntax.PROTO3;
            if (syntax.name.equals(this.f35374d.getSyntax())) {
                return syntax;
            }
            return Syntax.PROTO2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean z() {
            if (t() == Syntax.PROTO3) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.Descriptors.e
        public FileDescriptor h() {
            return this;
        }

        FileDescriptor(String str, b bVar) throws DescriptorValidationException {
            super(null);
            DescriptorPool descriptorPool = new DescriptorPool(new FileDescriptor[0], true);
            this.D = descriptorPool;
            this.f35374d = DescriptorProtos.FileDescriptorProto.newBuilder().S(bVar.i() + ".placeholder.proto").T(str).n(bVar.j()).build();
            this.f35379m = new FileDescriptor[0];
            this.C = new FileDescriptor[0];
            this.f35375e = new b[]{bVar};
            this.f35376f = new c[0];
            this.f35377h = new h[0];
            this.f35378i = new FieldDescriptor[0];
            descriptorPool.e(str, this);
            descriptorPool.f(bVar);
        }
    }
}
