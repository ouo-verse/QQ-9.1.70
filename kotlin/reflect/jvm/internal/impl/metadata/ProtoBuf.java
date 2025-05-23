package kotlin.reflect.jvm.internal.impl.metadata;

import com.tencent.mobileqq.data.MessageRecord;
import cooperation.qzone.util.WnsNetworkConst;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes28.dex */
public final class ProtoBuf {

    /* loaded from: classes28.dex */
    public static final class Annotation extends GeneratedMessageLite implements AnnotationOrBuilder {
        public static Parser<Annotation> PARSER = new AbstractParser<Annotation>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Annotation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Annotation(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Annotation defaultInstance;
        private List<Argument> argument_;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        /* loaded from: classes28.dex */
        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER = new AbstractParser<Argument>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.1
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Argument(codedInputStream, extensionRegistryLite);
                }
            };
            private static final Argument defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int nameId_;
            private final ByteString unknownFields;
            private Value value_;

            /* loaded from: classes28.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private int nameId_;
                private Value value_ = Value.getDefaultInstance();

                Builder() {
                    maybeForceBuilderInitialization();
                }

                static /* synthetic */ Builder access$3600() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                public Argument buildPartial() {
                    Argument argument = new Argument(this);
                    int i3 = this.bitField0_;
                    int i16 = 1;
                    if ((i3 & 1) != 1) {
                        i16 = 0;
                    }
                    argument.nameId_ = this.nameId_;
                    if ((i3 & 2) == 2) {
                        i16 |= 2;
                    }
                    argument.value_ = this.value_;
                    argument.bitField0_ = i16;
                    return argument;
                }

                public Value getValue() {
                    return this.value_;
                }

                public boolean hasNameId() {
                    if ((this.bitField0_ & 1) == 1) {
                        return true;
                    }
                    return false;
                }

                public boolean hasValue() {
                    if ((this.bitField0_ & 2) == 2) {
                        return true;
                    }
                    return false;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (!hasNameId() || !hasValue() || !getValue().isInitialized()) {
                        return false;
                    }
                    return true;
                }

                public Builder mergeValue(Value value) {
                    if ((this.bitField0_ & 2) == 2 && this.value_ != Value.getDefaultInstance()) {
                        this.value_ = Value.newBuilder(this.value_).mergeFrom(value).buildPartial();
                    } else {
                        this.value_ = value;
                    }
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder setNameId(int i3) {
                    this.bitField0_ |= 1;
                    this.nameId_ = i3;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone, reason: merged with bridge method [inline-methods] */
                public Builder mo1777clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasNameId()) {
                        setNameId(argument.getNameId());
                    }
                    if (argument.hasValue()) {
                        mergeValue(argument.getValue());
                    }
                    setUnknownFields(getUnknownFields().concat(argument.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Argument argument = null;
                    try {
                        try {
                            Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (Throwable th5) {
                            th = th5;
                            if (argument != null) {
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        Argument argument2 = (Argument) e16.getUnfinishedMessage();
                        try {
                            throw e16;
                        } catch (Throwable th6) {
                            th = th6;
                            argument = argument2;
                            if (argument != null) {
                                mergeFrom(argument);
                            }
                            throw th;
                        }
                    }
                }

                private void maybeForceBuilderInitialization() {
                }
            }

            /* loaded from: classes28.dex */
            public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
                public static Parser<Value> PARSER = new AbstractParser<Value>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.1
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                    public Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return new Value(codedInputStream, extensionRegistryLite);
                    }
                };
                private static final Value defaultInstance;
                private Annotation annotation_;
                private int arrayDimensionCount_;
                private List<Value> arrayElement_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private int stringValue_;
                private Type type_;
                private final ByteString unknownFields;

                /* loaded from: classes28.dex */
                public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
                    private int arrayDimensionCount_;
                    private int bitField0_;
                    private int classId_;
                    private double doubleValue_;
                    private int enumValueId_;
                    private int flags_;
                    private float floatValue_;
                    private long intValue_;
                    private int stringValue_;
                    private Type type_ = Type.BYTE;
                    private Annotation annotation_ = Annotation.getDefaultInstance();
                    private List<Value> arrayElement_ = Collections.emptyList();

                    Builder() {
                        maybeForceBuilderInitialization();
                    }

                    static /* synthetic */ Builder access$2100() {
                        return create();
                    }

                    private static Builder create() {
                        return new Builder();
                    }

                    private void ensureArrayElementIsMutable() {
                        if ((this.bitField0_ & 256) != 256) {
                            this.arrayElement_ = new ArrayList(this.arrayElement_);
                            this.bitField0_ |= 256;
                        }
                    }

                    public Value buildPartial() {
                        Value value = new Value(this);
                        int i3 = this.bitField0_;
                        int i16 = 1;
                        if ((i3 & 1) != 1) {
                            i16 = 0;
                        }
                        value.type_ = this.type_;
                        if ((i3 & 2) == 2) {
                            i16 |= 2;
                        }
                        value.intValue_ = this.intValue_;
                        if ((i3 & 4) == 4) {
                            i16 |= 4;
                        }
                        value.floatValue_ = this.floatValue_;
                        if ((i3 & 8) == 8) {
                            i16 |= 8;
                        }
                        value.doubleValue_ = this.doubleValue_;
                        if ((i3 & 16) == 16) {
                            i16 |= 16;
                        }
                        value.stringValue_ = this.stringValue_;
                        if ((i3 & 32) == 32) {
                            i16 |= 32;
                        }
                        value.classId_ = this.classId_;
                        if ((i3 & 64) == 64) {
                            i16 |= 64;
                        }
                        value.enumValueId_ = this.enumValueId_;
                        if ((i3 & 128) == 128) {
                            i16 |= 128;
                        }
                        value.annotation_ = this.annotation_;
                        if ((this.bitField0_ & 256) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                            this.bitField0_ &= -257;
                        }
                        value.arrayElement_ = this.arrayElement_;
                        if ((i3 & 512) == 512) {
                            i16 |= 256;
                        }
                        value.arrayDimensionCount_ = this.arrayDimensionCount_;
                        if ((i3 & 1024) == 1024) {
                            i16 |= 512;
                        }
                        value.flags_ = this.flags_;
                        value.bitField0_ = i16;
                        return value;
                    }

                    public Annotation getAnnotation() {
                        return this.annotation_;
                    }

                    public Value getArrayElement(int i3) {
                        return this.arrayElement_.get(i3);
                    }

                    public int getArrayElementCount() {
                        return this.arrayElement_.size();
                    }

                    public boolean hasAnnotation() {
                        if ((this.bitField0_ & 128) == 128) {
                            return true;
                        }
                        return false;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public final boolean isInitialized() {
                        if (hasAnnotation() && !getAnnotation().isInitialized()) {
                            return false;
                        }
                        for (int i3 = 0; i3 < getArrayElementCount(); i3++) {
                            if (!getArrayElement(i3).isInitialized()) {
                                return false;
                            }
                        }
                        return true;
                    }

                    public Builder mergeAnnotation(Annotation annotation) {
                        if ((this.bitField0_ & 128) == 128 && this.annotation_ != Annotation.getDefaultInstance()) {
                            this.annotation_ = Annotation.newBuilder(this.annotation_).mergeFrom(annotation).buildPartial();
                        } else {
                            this.annotation_ = annotation;
                        }
                        this.bitField0_ |= 128;
                        return this;
                    }

                    public Builder setArrayDimensionCount(int i3) {
                        this.bitField0_ |= 512;
                        this.arrayDimensionCount_ = i3;
                        return this;
                    }

                    public Builder setClassId(int i3) {
                        this.bitField0_ |= 32;
                        this.classId_ = i3;
                        return this;
                    }

                    public Builder setDoubleValue(double d16) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = d16;
                        return this;
                    }

                    public Builder setEnumValueId(int i3) {
                        this.bitField0_ |= 64;
                        this.enumValueId_ = i3;
                        return this;
                    }

                    public Builder setFlags(int i3) {
                        this.bitField0_ |= 1024;
                        this.flags_ = i3;
                        return this;
                    }

                    public Builder setFloatValue(float f16) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = f16;
                        return this;
                    }

                    public Builder setIntValue(long j3) {
                        this.bitField0_ |= 2;
                        this.intValue_ = j3;
                        return this;
                    }

                    public Builder setStringValue(int i3) {
                        this.bitField0_ |= 16;
                        this.stringValue_ = i3;
                        return this;
                    }

                    public Builder setType(Type type) {
                        type.getClass();
                        this.bitField0_ |= 1;
                        this.type_ = type;
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public Value build() {
                        Value buildPartial = buildPartial();
                        if (buildPartial.isInitialized()) {
                            return buildPartial;
                        }
                        throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    /* renamed from: clone */
                    public Builder mo1777clone() {
                        return create().mergeFrom(buildPartial());
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                    public Builder mergeFrom(Value value) {
                        if (value == Value.getDefaultInstance()) {
                            return this;
                        }
                        if (value.hasType()) {
                            setType(value.getType());
                        }
                        if (value.hasIntValue()) {
                            setIntValue(value.getIntValue());
                        }
                        if (value.hasFloatValue()) {
                            setFloatValue(value.getFloatValue());
                        }
                        if (value.hasDoubleValue()) {
                            setDoubleValue(value.getDoubleValue());
                        }
                        if (value.hasStringValue()) {
                            setStringValue(value.getStringValue());
                        }
                        if (value.hasClassId()) {
                            setClassId(value.getClassId());
                        }
                        if (value.hasEnumValueId()) {
                            setEnumValueId(value.getEnumValueId());
                        }
                        if (value.hasAnnotation()) {
                            mergeAnnotation(value.getAnnotation());
                        }
                        if (!value.arrayElement_.isEmpty()) {
                            if (this.arrayElement_.isEmpty()) {
                                this.arrayElement_ = value.arrayElement_;
                                this.bitField0_ &= -257;
                            } else {
                                ensureArrayElementIsMutable();
                                this.arrayElement_.addAll(value.arrayElement_);
                            }
                        }
                        if (value.hasArrayDimensionCount()) {
                            setArrayDimensionCount(value.getArrayDimensionCount());
                        }
                        if (value.hasFlags()) {
                            setFlags(value.getFlags());
                        }
                        setUnknownFields(getUnknownFields().concat(value.unknownFields));
                        return this;
                    }

                    private void maybeForceBuilderInitialization() {
                    }

                    /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        Value value = null;
                        try {
                            try {
                                Value parsePartialFrom = Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                                if (parsePartialFrom != null) {
                                    mergeFrom(parsePartialFrom);
                                }
                                return this;
                            } catch (Throwable th5) {
                                th = th5;
                                if (value != null) {
                                }
                                throw th;
                            }
                        } catch (InvalidProtocolBufferException e16) {
                            Value value2 = (Value) e16.getUnfinishedMessage();
                            try {
                                throw e16;
                            } catch (Throwable th6) {
                                th = th6;
                                value = value2;
                                if (value != null) {
                                    mergeFrom(value);
                                }
                                throw th;
                            }
                        }
                    }
                }

                /* loaded from: classes28.dex */
                public enum Type implements Internal.EnumLite {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);

                    private static Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                        public Type findValueByNumber(int i3) {
                            return Type.valueOf(i3);
                        }
                    };
                    private final int value;

                    Type(int i3, int i16) {
                        this.value = i16;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int i3) {
                        switch (i3) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }
                }

                static {
                    Value value = new Value(true);
                    defaultInstance = value;
                    value.initFields();
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0L;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0d;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                public static Builder newBuilder() {
                    return Builder.access$2100();
                }

                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public Value getArrayElement(int i3) {
                    return this.arrayElement_.get(i3);
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public int getClassId() {
                    return this.classId_;
                }

                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                public int getFlags() {
                    return this.flags_;
                }

                public float getFloatValue() {
                    return this.floatValue_;
                }

                public long getIntValue() {
                    return this.intValue_;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Parser<Value> getParserForType() {
                    return PARSER;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public int getSerializedSize() {
                    int i3;
                    int i16 = this.memoizedSerializedSize;
                    if (i16 != -1) {
                        return i16;
                    }
                    if ((this.bitField0_ & 1) == 1) {
                        i3 = CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0;
                    } else {
                        i3 = 0;
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        i3 += CodedOutputStream.computeSInt64Size(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        i3 += CodedOutputStream.computeFloatSize(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        i3 += CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        i3 += CodedOutputStream.computeInt32Size(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        i3 += CodedOutputStream.computeInt32Size(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        i3 += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        i3 += CodedOutputStream.computeMessageSize(8, this.annotation_);
                    }
                    for (int i17 = 0; i17 < this.arrayElement_.size(); i17++) {
                        i3 += CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(i17));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        i3 += CodedOutputStream.computeInt32Size(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        i3 += CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                    }
                    int size = i3 + this.unknownFields.size();
                    this.memoizedSerializedSize = size;
                    return size;
                }

                public int getStringValue() {
                    return this.stringValue_;
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasAnnotation() {
                    if ((this.bitField0_ & 128) == 128) {
                        return true;
                    }
                    return false;
                }

                public boolean hasArrayDimensionCount() {
                    if ((this.bitField0_ & 256) == 256) {
                        return true;
                    }
                    return false;
                }

                public boolean hasClassId() {
                    if ((this.bitField0_ & 32) == 32) {
                        return true;
                    }
                    return false;
                }

                public boolean hasDoubleValue() {
                    if ((this.bitField0_ & 8) == 8) {
                        return true;
                    }
                    return false;
                }

                public boolean hasEnumValueId() {
                    if ((this.bitField0_ & 64) == 64) {
                        return true;
                    }
                    return false;
                }

                public boolean hasFlags() {
                    if ((this.bitField0_ & 512) == 512) {
                        return true;
                    }
                    return false;
                }

                public boolean hasFloatValue() {
                    if ((this.bitField0_ & 4) == 4) {
                        return true;
                    }
                    return false;
                }

                public boolean hasIntValue() {
                    if ((this.bitField0_ & 2) == 2) {
                        return true;
                    }
                    return false;
                }

                public boolean hasStringValue() {
                    if ((this.bitField0_ & 16) == 16) {
                        return true;
                    }
                    return false;
                }

                public boolean hasType() {
                    if ((this.bitField0_ & 1) == 1) {
                        return true;
                    }
                    return false;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    byte b16 = this.memoizedIsInitialized;
                    if (b16 == 1) {
                        return true;
                    }
                    if (b16 == 0) {
                        return false;
                    }
                    if (hasAnnotation() && !getAnnotation().isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                    for (int i3 = 0; i3 < getArrayElementCount(); i3++) {
                        if (!getArrayElement(i3).isInitialized()) {
                            this.memoizedIsInitialized = (byte) 0;
                            return false;
                        }
                    }
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) == 1) {
                        codedOutputStream.writeEnum(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        codedOutputStream.writeSInt64(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        codedOutputStream.writeFloat(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        codedOutputStream.writeDouble(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        codedOutputStream.writeInt32(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        codedOutputStream.writeInt32(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        codedOutputStream.writeInt32(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        codedOutputStream.writeMessage(8, this.annotation_);
                    }
                    for (int i3 = 0; i3 < this.arrayElement_.size(); i3++) {
                        codedOutputStream.writeMessage(9, this.arrayElement_.get(i3));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        codedOutputStream.writeInt32(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        codedOutputStream.writeInt32(11, this.arrayDimensionCount_);
                    }
                    codedOutputStream.writeRawBytes(this.unknownFields);
                }

                public static Builder newBuilder(Value value) {
                    return newBuilder().mergeFrom(value);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Value getDefaultInstanceForType() {
                    return defaultInstance;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Builder newBuilderForType() {
                    return newBuilder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Builder toBuilder() {
                    return newBuilder(this);
                }

                Value(GeneratedMessageLite.Builder builder) {
                    super(builder);
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = builder.getUnknownFields();
                }

                Value(boolean z16) {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = ByteString.EMPTY;
                }

                /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001e. Please report as an issue. */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r5v0 */
                /* JADX WARN: Type inference failed for: r5v1 */
                /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
                Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    initFields();
                    ByteString.Output newOutput = ByteString.newOutput();
                    CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                    boolean z16 = false;
                    int i3 = 0;
                    while (true) {
                        ?? r56 = 256;
                        if (!z16) {
                            try {
                                try {
                                    int readTag = codedInputStream.readTag();
                                    switch (readTag) {
                                        case 0:
                                            z16 = true;
                                        case 8:
                                            int readEnum = codedInputStream.readEnum();
                                            Type valueOf = Type.valueOf(readEnum);
                                            if (valueOf == null) {
                                                newInstance.writeRawVarint32(readTag);
                                                newInstance.writeRawVarint32(readEnum);
                                            } else {
                                                this.bitField0_ |= 1;
                                                this.type_ = valueOf;
                                            }
                                        case 16:
                                            this.bitField0_ |= 2;
                                            this.intValue_ = codedInputStream.readSInt64();
                                        case 29:
                                            this.bitField0_ |= 4;
                                            this.floatValue_ = codedInputStream.readFloat();
                                        case 33:
                                            this.bitField0_ |= 8;
                                            this.doubleValue_ = codedInputStream.readDouble();
                                        case 40:
                                            this.bitField0_ |= 16;
                                            this.stringValue_ = codedInputStream.readInt32();
                                        case 48:
                                            this.bitField0_ |= 32;
                                            this.classId_ = codedInputStream.readInt32();
                                        case 56:
                                            this.bitField0_ |= 64;
                                            this.enumValueId_ = codedInputStream.readInt32();
                                        case 66:
                                            Builder builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                            Annotation annotation = (Annotation) codedInputStream.readMessage(Annotation.PARSER, extensionRegistryLite);
                                            this.annotation_ = annotation;
                                            if (builder != null) {
                                                builder.mergeFrom(annotation);
                                                this.annotation_ = builder.buildPartial();
                                            }
                                            this.bitField0_ |= 128;
                                        case 74:
                                            if ((i3 & 256) != 256) {
                                                this.arrayElement_ = new ArrayList();
                                                i3 |= 256;
                                            }
                                            this.arrayElement_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                                        case 80:
                                            this.bitField0_ |= 512;
                                            this.flags_ = codedInputStream.readInt32();
                                        case 88:
                                            this.bitField0_ |= 256;
                                            this.arrayDimensionCount_ = codedInputStream.readInt32();
                                        default:
                                            r56 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                            if (r56 == 0) {
                                                z16 = true;
                                            }
                                    }
                                } catch (InvalidProtocolBufferException e16) {
                                    throw e16.setUnfinishedMessage(this);
                                } catch (IOException e17) {
                                    throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                                }
                            } catch (Throwable th5) {
                                if ((i3 & 256) == r56) {
                                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                                }
                                try {
                                    newInstance.flush();
                                } catch (IOException unused) {
                                } catch (Throwable th6) {
                                    this.unknownFields = newOutput.toByteString();
                                    throw th6;
                                }
                                this.unknownFields = newOutput.toByteString();
                                makeExtensionsImmutable();
                                throw th5;
                            }
                        } else {
                            if ((i3 & 256) == 256) {
                                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                            }
                            try {
                                newInstance.flush();
                            } catch (IOException unused2) {
                            } catch (Throwable th7) {
                                this.unknownFields = newOutput.toByteString();
                                throw th7;
                            }
                            this.unknownFields = newOutput.toByteString();
                            makeExtensionsImmutable();
                            return;
                        }
                    }
                }
            }

            /* loaded from: classes28.dex */
            public interface ValueOrBuilder extends MessageLiteOrBuilder {
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
            }

            public static Builder newBuilder() {
                return Builder.access$3600();
            }

            public int getNameId() {
                return this.nameId_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int i3 = this.memoizedSerializedSize;
                if (i3 != -1) {
                    return i3;
                }
                int i16 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i16 = 0 + CodedOutputStream.computeInt32Size(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i16 += CodedOutputStream.computeMessageSize(2, this.value_);
                }
                int size = i16 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public Value getValue() {
                return this.value_;
            }

            public boolean hasNameId() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            public boolean hasValue() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b16 = this.memoizedIsInitialized;
                if (b16 == 1) {
                    return true;
                }
                if (b16 == 0) {
                    return false;
                }
                if (!hasNameId()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                if (!hasValue()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                if (!getValue().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.value_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public static Builder newBuilder(Argument argument) {
                return newBuilder().mergeFrom(argument);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            Argument(boolean z16) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                boolean z16 = false;
                while (!z16) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.bitField0_ |= 1;
                                        this.nameId_ = codedInputStream.readInt32();
                                    } else if (readTag != 18) {
                                        if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        Value.Builder builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                        Value value = (Value) codedInputStream.readMessage(Value.PARSER, extensionRegistryLite);
                                        this.value_ = value;
                                        if (builder != null) {
                                            builder.mergeFrom(value);
                                            this.value_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 2;
                                    }
                                }
                                z16 = true;
                            } catch (InvalidProtocolBufferException e16) {
                                throw e16.setUnfinishedMessage(this);
                            }
                        } catch (IOException e17) {
                            throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th5) {
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th6) {
                            this.unknownFields = newOutput.toByteString();
                            throw th6;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th5;
                    }
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th7) {
                    this.unknownFields = newOutput.toByteString();
                    throw th7;
                }
                this.unknownFields = newOutput.toByteString();
                makeExtensionsImmutable();
            }
        }

        /* loaded from: classes28.dex */
        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
            private List<Argument> argument_ = Collections.emptyList();
            private int bitField0_;
            private int id_;

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$4200() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.argument_ = new ArrayList(this.argument_);
                    this.bitField0_ |= 2;
                }
            }

            public Annotation buildPartial() {
                Annotation annotation = new Annotation(this);
                int i3 = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i3 = 0;
                }
                annotation.id_ = this.id_;
                if ((this.bitField0_ & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= -3;
                }
                annotation.argument_ = this.argument_;
                annotation.bitField0_ = i3;
                return annotation;
            }

            public Argument getArgument(int i3) {
                return this.argument_.get(i3);
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public boolean hasId() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                for (int i3 = 0; i3 < getArgumentCount(); i3++) {
                    if (!getArgument(i3).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder setId(int i3) {
                this.bitField0_ |= 1;
                this.id_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Annotation build() {
                Annotation buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Annotation annotation) {
                if (annotation == Annotation.getDefaultInstance()) {
                    return this;
                }
                if (annotation.hasId()) {
                    setId(annotation.getId());
                }
                if (!annotation.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = annotation.argument_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureArgumentIsMutable();
                        this.argument_.addAll(annotation.argument_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(annotation.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Annotation annotation = null;
                try {
                    try {
                        Annotation parsePartialFrom = Annotation.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (annotation != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    Annotation annotation2 = (Annotation) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        annotation = annotation2;
                        if (annotation != null) {
                            mergeFrom(annotation);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        static {
            Annotation annotation = new Annotation(true);
            defaultInstance = annotation;
            annotation.initFields();
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$4200();
        }

        public Argument getArgument(int i3) {
            return this.argument_.get(i3);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getId() {
            return this.id_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Annotation> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.argument_.size(); i17++) {
                i3 += CodedOutputStream.computeMessageSize(2, this.argument_.get(i17));
            }
            int size = i3 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasId() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getArgumentCount(); i3++) {
                if (!getArgument(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.id_);
            }
            for (int i3 = 0; i3 < this.argument_.size(); i3++) {
                codedOutputStream.writeMessage(2, this.argument_.get(i3));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Annotation annotation) {
            return newBuilder().mergeFrom(annotation);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Annotation getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        Annotation(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        Annotation(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.id_ = codedInputStream.readInt32();
                            } else if (readTag != 18) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if ((i3 & 2) != 2) {
                                    this.argument_ = new ArrayList();
                                    i3 |= 2;
                                }
                                this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if ((i3 & 2) == 2) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if ((i3 & 2) == 2) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements ClassOrBuilder {
        public static Parser<Class> PARSER = new AbstractParser<Class>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Class parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Class(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Class defaultInstance;
        private int bitField0_;
        private int companionObjectName_;
        private List<Constructor> constructor_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private List<EnumEntry> enumEntry_;
        private int flags_;
        private int fqName_;
        private List<Function> function_;
        private int inlineClassUnderlyingPropertyName_;
        private int inlineClassUnderlyingTypeId_;
        private Type inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingName_;
        private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingTypeId_;
        private List<Type> multiFieldValueClassUnderlyingType_;
        private int nestedClassNameMemoizedSerializedSize;
        private List<Integer> nestedClassName_;
        private List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        private List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        private List<Integer> supertypeId_;
        private List<Type> supertype_;
        private List<TypeAlias> typeAlias_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private VersionRequirementTable versionRequirementTable_;
        private List<Integer> versionRequirement_;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Class, Builder> implements ClassOrBuilder {
            private int bitField0_;
            private int companionObjectName_;
            private int fqName_;
            private int inlineClassUnderlyingPropertyName_;
            private int inlineClassUnderlyingTypeId_;
            private int flags_ = 6;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private List<Type> supertype_ = Collections.emptyList();
            private List<Integer> supertypeId_ = Collections.emptyList();
            private List<Integer> nestedClassName_ = Collections.emptyList();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<Constructor> constructor_ = Collections.emptyList();
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private List<EnumEntry> enumEntry_ = Collections.emptyList();
            private List<Integer> sealedSubclassFqName_ = Collections.emptyList();
            private Type inlineClassUnderlyingType_ = Type.getDefaultInstance();
            private List<Integer> multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            private List<Type> multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            private List<Integer> multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$8700() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureConstructorIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.constructor_ = new ArrayList(this.constructor_);
                    this.bitField0_ |= 512;
                }
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 256;
                }
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 128;
                }
            }

            private void ensureEnumEntryIsMutable() {
                if ((this.bitField0_ & 8192) != 8192) {
                    this.enumEntry_ = new ArrayList(this.enumEntry_);
                    this.bitField0_ |= 8192;
                }
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.function_ = new ArrayList(this.function_);
                    this.bitField0_ |= 1024;
                }
            }

            private void ensureMultiFieldValueClassUnderlyingNameIsMutable() {
                if ((this.bitField0_ & 262144) != 262144) {
                    this.multiFieldValueClassUnderlyingName_ = new ArrayList(this.multiFieldValueClassUnderlyingName_);
                    this.bitField0_ |= 262144;
                }
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIdIsMutable() {
                if ((this.bitField0_ & 1048576) != 1048576) {
                    this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList(this.multiFieldValueClassUnderlyingTypeId_);
                    this.bitField0_ |= 1048576;
                }
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIsMutable() {
                if ((this.bitField0_ & 524288) != 524288) {
                    this.multiFieldValueClassUnderlyingType_ = new ArrayList(this.multiFieldValueClassUnderlyingType_);
                    this.bitField0_ |= 524288;
                }
            }

            private void ensureNestedClassNameIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                    this.bitField0_ |= 64;
                }
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2048) != 2048) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 2048;
                }
            }

            private void ensureSealedSubclassFqNameIsMutable() {
                if ((this.bitField0_ & 16384) != 16384) {
                    this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                    this.bitField0_ |= 16384;
                }
            }

            private void ensureSupertypeIdIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.supertypeId_ = new ArrayList(this.supertypeId_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureSupertypeIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.supertype_ = new ArrayList(this.supertype_);
                    this.bitField0_ |= 16;
                }
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4096) != 4096) {
                    this.typeAlias_ = new ArrayList(this.typeAlias_);
                    this.bitField0_ |= 4096;
                }
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 8;
                }
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4194304) != 4194304) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4194304;
                }
            }

            public Class buildPartial() {
                Class r06 = new Class(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) != 1) {
                    i16 = 0;
                }
                r06.flags_ = this.flags_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                r06.fqName_ = this.fqName_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                r06.companionObjectName_ = this.companionObjectName_;
                if ((this.bitField0_ & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -9;
                }
                r06.typeParameter_ = this.typeParameter_;
                if ((this.bitField0_ & 16) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    this.bitField0_ &= -17;
                }
                r06.supertype_ = this.supertype_;
                if ((this.bitField0_ & 32) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    this.bitField0_ &= -33;
                }
                r06.supertypeId_ = this.supertypeId_;
                if ((this.bitField0_ & 64) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    this.bitField0_ &= -65;
                }
                r06.nestedClassName_ = this.nestedClassName_;
                if ((this.bitField0_ & 128) == 128) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -129;
                }
                r06.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -257;
                }
                r06.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 512) == 512) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    this.bitField0_ &= -513;
                }
                r06.constructor_ = this.constructor_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= -1025;
                }
                r06.function_ = this.function_;
                if ((this.bitField0_ & 2048) == 2048) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
                }
                r06.property_ = this.property_;
                if ((this.bitField0_ & 4096) == 4096) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= -4097;
                }
                r06.typeAlias_ = this.typeAlias_;
                if ((this.bitField0_ & 8192) == 8192) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    this.bitField0_ &= -8193;
                }
                r06.enumEntry_ = this.enumEntry_;
                if ((this.bitField0_ & 16384) == 16384) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    this.bitField0_ &= -16385;
                }
                r06.sealedSubclassFqName_ = this.sealedSubclassFqName_;
                if ((i3 & 32768) == 32768) {
                    i16 |= 8;
                }
                r06.inlineClassUnderlyingPropertyName_ = this.inlineClassUnderlyingPropertyName_;
                if ((i3 & 65536) == 65536) {
                    i16 |= 16;
                }
                r06.inlineClassUnderlyingType_ = this.inlineClassUnderlyingType_;
                if ((i3 & 131072) == 131072) {
                    i16 |= 32;
                }
                r06.inlineClassUnderlyingTypeId_ = this.inlineClassUnderlyingTypeId_;
                if ((this.bitField0_ & 262144) == 262144) {
                    this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                    this.bitField0_ &= -262145;
                }
                r06.multiFieldValueClassUnderlyingName_ = this.multiFieldValueClassUnderlyingName_;
                if ((this.bitField0_ & 524288) == 524288) {
                    this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                    this.bitField0_ &= -524289;
                }
                r06.multiFieldValueClassUnderlyingType_ = this.multiFieldValueClassUnderlyingType_;
                if ((this.bitField0_ & 1048576) == 1048576) {
                    this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                    this.bitField0_ &= -1048577;
                }
                r06.multiFieldValueClassUnderlyingTypeId_ = this.multiFieldValueClassUnderlyingTypeId_;
                if ((i3 & 2097152) == 2097152) {
                    i16 |= 64;
                }
                r06.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 4194304) == 4194304) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -4194305;
                }
                r06.versionRequirement_ = this.versionRequirement_;
                if ((i3 & 8388608) == 8388608) {
                    i16 |= 128;
                }
                r06.versionRequirementTable_ = this.versionRequirementTable_;
                r06.bitField0_ = i16;
                return r06;
            }

            public Constructor getConstructor(int i3) {
                return this.constructor_.get(i3);
            }

            public int getConstructorCount() {
                return this.constructor_.size();
            }

            public Type getContextReceiverType(int i3) {
                return this.contextReceiverType_.get(i3);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public EnumEntry getEnumEntry(int i3) {
                return this.enumEntry_.get(i3);
            }

            public int getEnumEntryCount() {
                return this.enumEntry_.size();
            }

            public Function getFunction(int i3) {
                return this.function_.get(i3);
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Type getInlineClassUnderlyingType() {
                return this.inlineClassUnderlyingType_;
            }

            public Type getMultiFieldValueClassUnderlyingType(int i3) {
                return this.multiFieldValueClassUnderlyingType_.get(i3);
            }

            public int getMultiFieldValueClassUnderlyingTypeCount() {
                return this.multiFieldValueClassUnderlyingType_.size();
            }

            public Property getProperty(int i3) {
                return this.property_.get(i3);
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public Type getSupertype(int i3) {
                return this.supertype_.get(i3);
            }

            public int getSupertypeCount() {
                return this.supertype_.size();
            }

            public TypeAlias getTypeAlias(int i3) {
                return this.typeAlias_.get(i3);
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeParameter getTypeParameter(int i3) {
                return this.typeParameter_.get(i3);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public boolean hasFqName() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            public boolean hasInlineClassUnderlyingType() {
                if ((this.bitField0_ & 65536) == 65536) {
                    return true;
                }
                return false;
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 2097152) == 2097152) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasFqName()) {
                    return false;
                }
                for (int i3 = 0; i3 < getTypeParameterCount(); i3++) {
                    if (!getTypeParameter(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i16 = 0; i16 < getSupertypeCount(); i16++) {
                    if (!getSupertype(i16).isInitialized()) {
                        return false;
                    }
                }
                for (int i17 = 0; i17 < getContextReceiverTypeCount(); i17++) {
                    if (!getContextReceiverType(i17).isInitialized()) {
                        return false;
                    }
                }
                for (int i18 = 0; i18 < getConstructorCount(); i18++) {
                    if (!getConstructor(i18).isInitialized()) {
                        return false;
                    }
                }
                for (int i19 = 0; i19 < getFunctionCount(); i19++) {
                    if (!getFunction(i19).isInitialized()) {
                        return false;
                    }
                }
                for (int i26 = 0; i26 < getPropertyCount(); i26++) {
                    if (!getProperty(i26).isInitialized()) {
                        return false;
                    }
                }
                for (int i27 = 0; i27 < getTypeAliasCount(); i27++) {
                    if (!getTypeAlias(i27).isInitialized()) {
                        return false;
                    }
                }
                for (int i28 = 0; i28 < getEnumEntryCount(); i28++) {
                    if (!getEnumEntry(i28).isInitialized()) {
                        return false;
                    }
                }
                if (hasInlineClassUnderlyingType() && !getInlineClassUnderlyingType().isInitialized()) {
                    return false;
                }
                for (int i29 = 0; i29 < getMultiFieldValueClassUnderlyingTypeCount(); i29++) {
                    if (!getMultiFieldValueClassUnderlyingType(i29).isInitialized()) {
                        return false;
                    }
                }
                if ((hasTypeTable() && !getTypeTable().isInitialized()) || !extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeInlineClassUnderlyingType(Type type) {
                if ((this.bitField0_ & 65536) == 65536 && this.inlineClassUnderlyingType_ != Type.getDefaultInstance()) {
                    this.inlineClassUnderlyingType_ = Type.newBuilder(this.inlineClassUnderlyingType_).mergeFrom(type).buildPartial();
                } else {
                    this.inlineClassUnderlyingType_ = type;
                }
                this.bitField0_ |= 65536;
                return this;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 2097152) == 2097152 && this.typeTable_ != TypeTable.getDefaultInstance()) {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                } else {
                    this.typeTable_ = typeTable;
                }
                this.bitField0_ |= 2097152;
                return this;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                if ((this.bitField0_ & 8388608) == 8388608 && this.versionRequirementTable_ != VersionRequirementTable.getDefaultInstance()) {
                    this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(versionRequirementTable).buildPartial();
                } else {
                    this.versionRequirementTable_ = versionRequirementTable;
                }
                this.bitField0_ |= 8388608;
                return this;
            }

            public Builder setCompanionObjectName(int i3) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = i3;
                return this;
            }

            public Builder setFlags(int i3) {
                this.bitField0_ |= 1;
                this.flags_ = i3;
                return this;
            }

            public Builder setFqName(int i3) {
                this.bitField0_ |= 2;
                this.fqName_ = i3;
                return this;
            }

            public Builder setInlineClassUnderlyingPropertyName(int i3) {
                this.bitField0_ |= 32768;
                this.inlineClassUnderlyingPropertyName_ = i3;
                return this;
            }

            public Builder setInlineClassUnderlyingTypeId(int i3) {
                this.bitField0_ |= 131072;
                this.inlineClassUnderlyingTypeId_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Class build() {
                Class buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Class r36) {
                if (r36 == Class.getDefaultInstance()) {
                    return this;
                }
                if (r36.hasFlags()) {
                    setFlags(r36.getFlags());
                }
                if (r36.hasFqName()) {
                    setFqName(r36.getFqName());
                }
                if (r36.hasCompanionObjectName()) {
                    setCompanionObjectName(r36.getCompanionObjectName());
                }
                if (!r36.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = r36.typeParameter_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(r36.typeParameter_);
                    }
                }
                if (!r36.supertype_.isEmpty()) {
                    if (this.supertype_.isEmpty()) {
                        this.supertype_ = r36.supertype_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureSupertypeIsMutable();
                        this.supertype_.addAll(r36.supertype_);
                    }
                }
                if (!r36.supertypeId_.isEmpty()) {
                    if (this.supertypeId_.isEmpty()) {
                        this.supertypeId_ = r36.supertypeId_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureSupertypeIdIsMutable();
                        this.supertypeId_.addAll(r36.supertypeId_);
                    }
                }
                if (!r36.nestedClassName_.isEmpty()) {
                    if (this.nestedClassName_.isEmpty()) {
                        this.nestedClassName_ = r36.nestedClassName_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureNestedClassNameIsMutable();
                        this.nestedClassName_.addAll(r36.nestedClassName_);
                    }
                }
                if (!r36.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = r36.contextReceiverType_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(r36.contextReceiverType_);
                    }
                }
                if (!r36.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = r36.contextReceiverTypeId_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(r36.contextReceiverTypeId_);
                    }
                }
                if (!r36.constructor_.isEmpty()) {
                    if (this.constructor_.isEmpty()) {
                        this.constructor_ = r36.constructor_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureConstructorIsMutable();
                        this.constructor_.addAll(r36.constructor_);
                    }
                }
                if (!r36.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = r36.function_;
                        this.bitField0_ &= -1025;
                    } else {
                        ensureFunctionIsMutable();
                        this.function_.addAll(r36.function_);
                    }
                }
                if (!r36.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = r36.property_;
                        this.bitField0_ &= MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
                    } else {
                        ensurePropertyIsMutable();
                        this.property_.addAll(r36.property_);
                    }
                }
                if (!r36.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = r36.typeAlias_;
                        this.bitField0_ &= -4097;
                    } else {
                        ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(r36.typeAlias_);
                    }
                }
                if (!r36.enumEntry_.isEmpty()) {
                    if (this.enumEntry_.isEmpty()) {
                        this.enumEntry_ = r36.enumEntry_;
                        this.bitField0_ &= -8193;
                    } else {
                        ensureEnumEntryIsMutable();
                        this.enumEntry_.addAll(r36.enumEntry_);
                    }
                }
                if (!r36.sealedSubclassFqName_.isEmpty()) {
                    if (this.sealedSubclassFqName_.isEmpty()) {
                        this.sealedSubclassFqName_ = r36.sealedSubclassFqName_;
                        this.bitField0_ &= -16385;
                    } else {
                        ensureSealedSubclassFqNameIsMutable();
                        this.sealedSubclassFqName_.addAll(r36.sealedSubclassFqName_);
                    }
                }
                if (r36.hasInlineClassUnderlyingPropertyName()) {
                    setInlineClassUnderlyingPropertyName(r36.getInlineClassUnderlyingPropertyName());
                }
                if (r36.hasInlineClassUnderlyingType()) {
                    mergeInlineClassUnderlyingType(r36.getInlineClassUnderlyingType());
                }
                if (r36.hasInlineClassUnderlyingTypeId()) {
                    setInlineClassUnderlyingTypeId(r36.getInlineClassUnderlyingTypeId());
                }
                if (!r36.multiFieldValueClassUnderlyingName_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingName_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingName_ = r36.multiFieldValueClassUnderlyingName_;
                        this.bitField0_ &= -262145;
                    } else {
                        ensureMultiFieldValueClassUnderlyingNameIsMutable();
                        this.multiFieldValueClassUnderlyingName_.addAll(r36.multiFieldValueClassUnderlyingName_);
                    }
                }
                if (!r36.multiFieldValueClassUnderlyingType_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingType_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingType_ = r36.multiFieldValueClassUnderlyingType_;
                        this.bitField0_ &= -524289;
                    } else {
                        ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                        this.multiFieldValueClassUnderlyingType_.addAll(r36.multiFieldValueClassUnderlyingType_);
                    }
                }
                if (!r36.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingTypeId_ = r36.multiFieldValueClassUnderlyingTypeId_;
                        this.bitField0_ &= -1048577;
                    } else {
                        ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                        this.multiFieldValueClassUnderlyingTypeId_.addAll(r36.multiFieldValueClassUnderlyingTypeId_);
                    }
                }
                if (r36.hasTypeTable()) {
                    mergeTypeTable(r36.getTypeTable());
                }
                if (!r36.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = r36.versionRequirement_;
                        this.bitField0_ &= -4194305;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(r36.versionRequirement_);
                    }
                }
                if (r36.hasVersionRequirementTable()) {
                    mergeVersionRequirementTable(r36.getVersionRequirementTable());
                }
                mergeExtensionFields(r36);
                setUnknownFields(getUnknownFields().concat(r36.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Class r06 = null;
                try {
                    try {
                        Class parsePartialFrom = Class.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (r06 != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    Class r46 = (Class) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        r06 = r46;
                        if (r06 != null) {
                            mergeFrom(r06);
                        }
                        throw th;
                    }
                }
            }
        }

        /* loaded from: classes28.dex */
        public enum Kind implements Internal.EnumLite {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);

            private static Internal.EnumLiteMap<Kind> internalValueMap = new Internal.EnumLiteMap<Kind>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                public Kind findValueByNumber(int i3) {
                    return Kind.valueOf(i3);
                }
            };
            private final int value;

            Kind(int i3, int i16) {
                this.value = i16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int i3) {
                switch (i3) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }
        }

        static {
            Class r06 = new Class(true);
            defaultInstance = r06;
            r06.initFields();
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$8700();
        }

        public static Class parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public Constructor getConstructor(int i3) {
            return this.constructor_.get(i3);
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public Type getContextReceiverType(int i3) {
            return this.contextReceiverType_.get(i3);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public EnumEntry getEnumEntry(int i3) {
            return this.enumEntry_.get(i3);
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public Function getFunction(int i3) {
            return this.function_.get(i3);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public int getMultiFieldValueClassUnderlyingNameCount() {
            return this.multiFieldValueClassUnderlyingName_.size();
        }

        public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
            return this.multiFieldValueClassUnderlyingName_;
        }

        public Type getMultiFieldValueClassUnderlyingType(int i3) {
            return this.multiFieldValueClassUnderlyingType_.get(i3);
        }

        public int getMultiFieldValueClassUnderlyingTypeCount() {
            return this.multiFieldValueClassUnderlyingType_.size();
        }

        public int getMultiFieldValueClassUnderlyingTypeIdCount() {
            return this.multiFieldValueClassUnderlyingTypeId_.size();
        }

        public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
            return this.multiFieldValueClassUnderlyingTypeId_;
        }

        public List<Type> getMultiFieldValueClassUnderlyingTypeList() {
            return this.multiFieldValueClassUnderlyingType_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Class> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i3) {
            return this.property_.get(i3);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
            } else {
                i3 = 0;
            }
            int i17 = 0;
            for (int i18 = 0; i18 < this.supertypeId_.size(); i18++) {
                i17 += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i18).intValue());
            }
            int i19 = i3 + i17;
            if (!getSupertypeIdList().isEmpty()) {
                i19 = i19 + 1 + CodedOutputStream.computeInt32SizeNoTag(i17);
            }
            this.supertypeIdMemoizedSerializedSize = i17;
            if ((this.bitField0_ & 2) == 2) {
                i19 += CodedOutputStream.computeInt32Size(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i19 += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
            }
            for (int i26 = 0; i26 < this.typeParameter_.size(); i26++) {
                i19 += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i26));
            }
            for (int i27 = 0; i27 < this.supertype_.size(); i27++) {
                i19 += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i27));
            }
            int i28 = 0;
            for (int i29 = 0; i29 < this.nestedClassName_.size(); i29++) {
                i28 += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i29).intValue());
            }
            int i36 = i19 + i28;
            if (!getNestedClassNameList().isEmpty()) {
                i36 = i36 + 1 + CodedOutputStream.computeInt32SizeNoTag(i28);
            }
            this.nestedClassNameMemoizedSerializedSize = i28;
            for (int i37 = 0; i37 < this.constructor_.size(); i37++) {
                i36 += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i37));
            }
            for (int i38 = 0; i38 < this.function_.size(); i38++) {
                i36 += CodedOutputStream.computeMessageSize(9, this.function_.get(i38));
            }
            for (int i39 = 0; i39 < this.property_.size(); i39++) {
                i36 += CodedOutputStream.computeMessageSize(10, this.property_.get(i39));
            }
            for (int i46 = 0; i46 < this.typeAlias_.size(); i46++) {
                i36 += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i46));
            }
            for (int i47 = 0; i47 < this.enumEntry_.size(); i47++) {
                i36 += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i47));
            }
            int i48 = 0;
            for (int i49 = 0; i49 < this.sealedSubclassFqName_.size(); i49++) {
                i48 += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i49).intValue());
            }
            int i56 = i36 + i48;
            if (!getSealedSubclassFqNameList().isEmpty()) {
                i56 = i56 + 2 + CodedOutputStream.computeInt32SizeNoTag(i48);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = i48;
            if ((this.bitField0_ & 8) == 8) {
                i56 += CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i56 += CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i56 += CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
            }
            for (int i57 = 0; i57 < this.contextReceiverType_.size(); i57++) {
                i56 += CodedOutputStream.computeMessageSize(20, this.contextReceiverType_.get(i57));
            }
            int i58 = 0;
            for (int i59 = 0; i59 < this.contextReceiverTypeId_.size(); i59++) {
                i58 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i59).intValue());
            }
            int i65 = i56 + i58;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i65 = i65 + 2 + CodedOutputStream.computeInt32SizeNoTag(i58);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i58;
            int i66 = 0;
            for (int i67 = 0; i67 < this.multiFieldValueClassUnderlyingName_.size(); i67++) {
                i66 += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingName_.get(i67).intValue());
            }
            int i68 = i65 + i66;
            if (!getMultiFieldValueClassUnderlyingNameList().isEmpty()) {
                i68 = i68 + 2 + CodedOutputStream.computeInt32SizeNoTag(i66);
            }
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = i66;
            for (int i69 = 0; i69 < this.multiFieldValueClassUnderlyingType_.size(); i69++) {
                i68 += CodedOutputStream.computeMessageSize(23, this.multiFieldValueClassUnderlyingType_.get(i69));
            }
            int i75 = 0;
            for (int i76 = 0; i76 < this.multiFieldValueClassUnderlyingTypeId_.size(); i76++) {
                i75 += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i76).intValue());
            }
            int i77 = i68 + i75;
            if (!getMultiFieldValueClassUnderlyingTypeIdList().isEmpty()) {
                i77 = i77 + 2 + CodedOutputStream.computeInt32SizeNoTag(i75);
            }
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = i75;
            if ((this.bitField0_ & 64) == 64) {
                i77 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            int i78 = 0;
            for (int i79 = 0; i79 < this.versionRequirement_.size(); i79++) {
                i78 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i79).intValue());
            }
            int size = i77 + i78 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 128) == 128) {
                size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getSupertype(int i3) {
            return this.supertype_.get(i3);
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public TypeAlias getTypeAlias(int i3) {
            return this.typeAlias_.get(i3);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeParameter getTypeParameter(int i3) {
            return this.typeParameter_.get(i3);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasCompanionObjectName() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasFqName() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        public boolean hasInlineClassUnderlyingType() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 64) == 64) {
                return true;
            }
            return false;
        }

        public boolean hasVersionRequirementTable() {
            if ((this.bitField0_ & 128) == 128) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (!hasFqName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getTypeParameterCount(); i3++) {
                if (!getTypeParameter(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i16 = 0; i16 < getSupertypeCount(); i16++) {
                if (!getSupertype(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i17 = 0; i17 < getContextReceiverTypeCount(); i17++) {
                if (!getContextReceiverType(i17).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i18 = 0; i18 < getConstructorCount(); i18++) {
                if (!getConstructor(i18).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i19 = 0; i19 < getFunctionCount(); i19++) {
                if (!getFunction(i19).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i26 = 0; i26 < getPropertyCount(); i26++) {
                if (!getProperty(i26).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i27 = 0; i27 < getTypeAliasCount(); i27++) {
                if (!getTypeAlias(i27).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i28 = 0; i28 < getEnumEntryCount(); i28++) {
                if (!getEnumEntry(i28).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasInlineClassUnderlyingType() && !getInlineClassUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i29 = 0; i29 < getMultiFieldValueClassUnderlyingTypeCount(); i29++) {
                if (!getMultiFieldValueClassUnderlyingType(i29).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if (getSupertypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(18);
                codedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.supertypeId_.size(); i3++) {
                codedOutputStream.writeInt32NoTag(this.supertypeId_.get(i3).intValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(4, this.companionObjectName_);
            }
            for (int i16 = 0; i16 < this.typeParameter_.size(); i16++) {
                codedOutputStream.writeMessage(5, this.typeParameter_.get(i16));
            }
            for (int i17 = 0; i17 < this.supertype_.size(); i17++) {
                codedOutputStream.writeMessage(6, this.supertype_.get(i17));
            }
            if (getNestedClassNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(58);
                codedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
            }
            for (int i18 = 0; i18 < this.nestedClassName_.size(); i18++) {
                codedOutputStream.writeInt32NoTag(this.nestedClassName_.get(i18).intValue());
            }
            for (int i19 = 0; i19 < this.constructor_.size(); i19++) {
                codedOutputStream.writeMessage(8, this.constructor_.get(i19));
            }
            for (int i26 = 0; i26 < this.function_.size(); i26++) {
                codedOutputStream.writeMessage(9, this.function_.get(i26));
            }
            for (int i27 = 0; i27 < this.property_.size(); i27++) {
                codedOutputStream.writeMessage(10, this.property_.get(i27));
            }
            for (int i28 = 0; i28 < this.typeAlias_.size(); i28++) {
                codedOutputStream.writeMessage(11, this.typeAlias_.get(i28));
            }
            for (int i29 = 0; i29 < this.enumEntry_.size(); i29++) {
                codedOutputStream.writeMessage(13, this.enumEntry_.get(i29));
            }
            if (getSealedSubclassFqNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(130);
                codedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (int i36 = 0; i36 < this.sealedSubclassFqName_.size(); i36++) {
                codedOutputStream.writeInt32NoTag(this.sealedSubclassFqName_.get(i36).intValue());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(19, this.inlineClassUnderlyingTypeId_);
            }
            for (int i37 = 0; i37 < this.contextReceiverType_.size(); i37++) {
                codedOutputStream.writeMessage(20, this.contextReceiverType_.get(i37));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(170);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i38 = 0; i38 < this.contextReceiverTypeId_.size(); i38++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i38).intValue());
            }
            if (getMultiFieldValueClassUnderlyingNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(178);
                codedOutputStream.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
            }
            for (int i39 = 0; i39 < this.multiFieldValueClassUnderlyingName_.size(); i39++) {
                codedOutputStream.writeInt32NoTag(this.multiFieldValueClassUnderlyingName_.get(i39).intValue());
            }
            for (int i46 = 0; i46 < this.multiFieldValueClassUnderlyingType_.size(); i46++) {
                codedOutputStream.writeMessage(23, this.multiFieldValueClassUnderlyingType_.get(i46));
            }
            if (getMultiFieldValueClassUnderlyingTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(194);
                codedOutputStream.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
            }
            for (int i47 = 0; i47 < this.multiFieldValueClassUnderlyingTypeId_.size(); i47++) {
                codedOutputStream.writeInt32NoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i47).intValue());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            for (int i48 = 0; i48 < this.versionRequirement_.size(); i48++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i48).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(32, this.versionRequirementTable_);
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Class r16) {
            return newBuilder().mergeFrom(r16);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Class getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> extendableBuilder) {
            super(extendableBuilder);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        Class(boolean z16) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x003c. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r8v11 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v19 */
        /* JADX WARN: Type inference failed for: r8v21 */
        /* JADX WARN: Type inference failed for: r8v23 */
        /* JADX WARN: Type inference failed for: r8v25 */
        /* JADX WARN: Type inference failed for: r8v27 */
        /* JADX WARN: Type inference failed for: r8v29 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v31 */
        /* JADX WARN: Type inference failed for: r8v33 */
        /* JADX WARN: Type inference failed for: r8v35 */
        /* JADX WARN: Type inference failed for: r8v37 */
        /* JADX WARN: Type inference failed for: r8v39 */
        /* JADX WARN: Type inference failed for: r8v41 */
        /* JADX WARN: Type inference failed for: r8v43 */
        /* JADX WARN: Type inference failed for: r8v45 */
        /* JADX WARN: Type inference failed for: r8v47 */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v9 */
        Class(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z16;
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z17 = false;
            char c16 = 0;
            while (true) {
                ?? r56 = 4194304;
                if (!z17) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z16 = true;
                                    z17 = z16;
                                case 8:
                                    z16 = true;
                                    this.bitField0_ |= 1;
                                    this.flags_ = codedInputStream.readInt32();
                                case 16:
                                    int i3 = (c16 == true ? 1 : 0) & 32;
                                    char c17 = c16;
                                    if (i3 != 32) {
                                        this.supertypeId_ = new ArrayList();
                                        c17 = (c16 == true ? 1 : 0) | TokenParser.SP;
                                    }
                                    this.supertypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    c16 = c17;
                                    z16 = true;
                                case 18:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    int i16 = (c16 == true ? 1 : 0) & 32;
                                    char c18 = c16;
                                    if (i16 != 32) {
                                        c18 = c16;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.supertypeId_ = new ArrayList();
                                            c18 = (c16 == true ? 1 : 0) | TokenParser.SP;
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.supertypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    c16 = c18;
                                    z16 = true;
                                case 24:
                                    this.bitField0_ |= 2;
                                    this.fqName_ = codedInputStream.readInt32();
                                    c16 = c16;
                                    z16 = true;
                                case 32:
                                    this.bitField0_ |= 4;
                                    this.companionObjectName_ = codedInputStream.readInt32();
                                    c16 = c16;
                                    z16 = true;
                                case 42:
                                    int i17 = (c16 == true ? 1 : 0) & 8;
                                    char c19 = c16;
                                    if (i17 != 8) {
                                        this.typeParameter_ = new ArrayList();
                                        c19 = (c16 == true ? 1 : 0) | '\b';
                                    }
                                    this.typeParameter_.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                                    c16 = c19;
                                    z16 = true;
                                case 50:
                                    int i18 = (c16 == true ? 1 : 0) & 16;
                                    char c26 = c16;
                                    if (i18 != 16) {
                                        this.supertype_ = new ArrayList();
                                        c26 = (c16 == true ? 1 : 0) | 16;
                                    }
                                    this.supertype_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                    c16 = c26;
                                    z16 = true;
                                case 56:
                                    int i19 = (c16 == true ? 1 : 0) & 64;
                                    char c27 = c16;
                                    if (i19 != 64) {
                                        this.nestedClassName_ = new ArrayList();
                                        c27 = (c16 == true ? 1 : 0) | '@';
                                    }
                                    this.nestedClassName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    c16 = c27;
                                    z16 = true;
                                case 58:
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    int i26 = (c16 == true ? 1 : 0) & 64;
                                    char c28 = c16;
                                    if (i26 != 64) {
                                        c28 = c16;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.nestedClassName_ = new ArrayList();
                                            c28 = (c16 == true ? 1 : 0) | '@';
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.nestedClassName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit2);
                                    c16 = c28;
                                    z16 = true;
                                case 66:
                                    int i27 = (c16 == true ? 1 : 0) & 512;
                                    char c29 = c16;
                                    if (i27 != 512) {
                                        this.constructor_ = new ArrayList();
                                        c29 = (c16 == true ? 1 : 0) | '\u0200';
                                    }
                                    this.constructor_.add(codedInputStream.readMessage(Constructor.PARSER, extensionRegistryLite));
                                    c16 = c29;
                                    z16 = true;
                                case 74:
                                    int i28 = (c16 == true ? 1 : 0) & 1024;
                                    char c36 = c16;
                                    if (i28 != 1024) {
                                        this.function_ = new ArrayList();
                                        c36 = (c16 == true ? 1 : 0) | '\u0400';
                                    }
                                    this.function_.add(codedInputStream.readMessage(Function.PARSER, extensionRegistryLite));
                                    c16 = c36;
                                    z16 = true;
                                case 82:
                                    int i29 = (c16 == true ? 1 : 0) & 2048;
                                    char c37 = c16;
                                    if (i29 != 2048) {
                                        this.property_ = new ArrayList();
                                        c37 = (c16 == true ? 1 : 0) | '\u0800';
                                    }
                                    this.property_.add(codedInputStream.readMessage(Property.PARSER, extensionRegistryLite));
                                    c16 = c37;
                                    z16 = true;
                                case 90:
                                    int i36 = (c16 == true ? 1 : 0) & 4096;
                                    char c38 = c16;
                                    if (i36 != 4096) {
                                        this.typeAlias_ = new ArrayList();
                                        c38 = (c16 == true ? 1 : 0) | '\u1000';
                                    }
                                    this.typeAlias_.add(codedInputStream.readMessage(TypeAlias.PARSER, extensionRegistryLite));
                                    c16 = c38;
                                    z16 = true;
                                case 106:
                                    int i37 = (c16 == true ? 1 : 0) & 8192;
                                    char c39 = c16;
                                    if (i37 != 8192) {
                                        this.enumEntry_ = new ArrayList();
                                        c39 = (c16 == true ? 1 : 0) | '\u2000';
                                    }
                                    this.enumEntry_.add(codedInputStream.readMessage(EnumEntry.PARSER, extensionRegistryLite));
                                    c16 = c39;
                                    z16 = true;
                                case 128:
                                    int i38 = (c16 == true ? 1 : 0) & 16384;
                                    char c46 = c16;
                                    if (i38 != 16384) {
                                        this.sealedSubclassFqName_ = new ArrayList();
                                        c46 = (c16 == true ? 1 : 0) | '\u4000';
                                    }
                                    this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    c16 = c46;
                                    z16 = true;
                                case 130:
                                    int pushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    int i39 = (c16 == true ? 1 : 0) & 16384;
                                    char c47 = c16;
                                    if (i39 != 16384) {
                                        c47 = c16;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.sealedSubclassFqName_ = new ArrayList();
                                            c47 = (c16 == true ? 1 : 0) | '\u4000';
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit3);
                                    c16 = c47;
                                    z16 = true;
                                case 136:
                                    this.bitField0_ |= 8;
                                    this.inlineClassUnderlyingPropertyName_ = codedInputStream.readInt32();
                                    c16 = c16;
                                    z16 = true;
                                case 146:
                                    Type.Builder builder = (this.bitField0_ & 16) == 16 ? this.inlineClassUnderlyingType_.toBuilder() : null;
                                    Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                    this.inlineClassUnderlyingType_ = type;
                                    if (builder != null) {
                                        builder.mergeFrom(type);
                                        this.inlineClassUnderlyingType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 16;
                                    c16 = c16;
                                    z16 = true;
                                case 152:
                                    this.bitField0_ |= 32;
                                    this.inlineClassUnderlyingTypeId_ = codedInputStream.readInt32();
                                    c16 = c16;
                                    z16 = true;
                                case 162:
                                    int i46 = (c16 == true ? 1 : 0) & 128;
                                    char c48 = c16;
                                    if (i46 != 128) {
                                        this.contextReceiverType_ = new ArrayList();
                                        c48 = (c16 == true ? 1 : 0) | '\u0080';
                                    }
                                    this.contextReceiverType_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                    c16 = c48;
                                    z16 = true;
                                case 168:
                                    int i47 = (c16 == true ? 1 : 0) & 256;
                                    char c49 = c16;
                                    if (i47 != 256) {
                                        this.contextReceiverTypeId_ = new ArrayList();
                                        c49 = (c16 == true ? 1 : 0) | '\u0100';
                                    }
                                    this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    c16 = c49;
                                    z16 = true;
                                case 170:
                                    int pushLimit4 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    int i48 = (c16 == true ? 1 : 0) & 256;
                                    char c56 = c16;
                                    if (i48 != 256) {
                                        c56 = c16;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.contextReceiverTypeId_ = new ArrayList();
                                            c56 = (c16 == true ? 1 : 0) | '\u0100';
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit4);
                                    c16 = c56;
                                    z16 = true;
                                case 176:
                                    int i49 = (c16 == true ? 1 : 0) & 262144;
                                    char c57 = c16;
                                    if (i49 != 262144) {
                                        this.multiFieldValueClassUnderlyingName_ = new ArrayList();
                                        c57 = (c16 == true ? 1 : 0) | 0;
                                    }
                                    this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    c16 = c57;
                                    z16 = true;
                                case 178:
                                    int pushLimit5 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    int i56 = (c16 == true ? 1 : 0) & 262144;
                                    char c58 = c16;
                                    if (i56 != 262144) {
                                        c58 = c16;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.multiFieldValueClassUnderlyingName_ = new ArrayList();
                                            c58 = (c16 == true ? 1 : 0) | 0;
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit5);
                                    c16 = c58;
                                    z16 = true;
                                case 186:
                                    int i57 = (c16 == true ? 1 : 0) & 524288;
                                    char c59 = c16;
                                    if (i57 != 524288) {
                                        this.multiFieldValueClassUnderlyingType_ = new ArrayList();
                                        c59 = (c16 == true ? 1 : 0) | 0;
                                    }
                                    this.multiFieldValueClassUnderlyingType_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                    c16 = c59;
                                    z16 = true;
                                case 192:
                                    int i58 = (c16 == true ? 1 : 0) & 1048576;
                                    char c65 = c16;
                                    if (i58 != 1048576) {
                                        this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();
                                        c65 = (c16 == true ? 1 : 0) | 0;
                                    }
                                    this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    c16 = c65;
                                    z16 = true;
                                case 194:
                                    int pushLimit6 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    int i59 = (c16 == true ? 1 : 0) & 1048576;
                                    char c66 = c16;
                                    if (i59 != 1048576) {
                                        c66 = c16;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();
                                            c66 = (c16 == true ? 1 : 0) | 0;
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit6);
                                    c16 = c66;
                                    z16 = true;
                                case 242:
                                    TypeTable.Builder builder2 = (this.bitField0_ & 64) == 64 ? this.typeTable_.toBuilder() : null;
                                    TypeTable typeTable = (TypeTable) codedInputStream.readMessage(TypeTable.PARSER, extensionRegistryLite);
                                    this.typeTable_ = typeTable;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(typeTable);
                                        this.typeTable_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 64;
                                    c16 = c16;
                                    z16 = true;
                                case 248:
                                    int i65 = (c16 == true ? 1 : 0) & 4194304;
                                    char c67 = c16;
                                    if (i65 != 4194304) {
                                        this.versionRequirement_ = new ArrayList();
                                        c67 = (c16 == true ? 1 : 0) | 0;
                                    }
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    c16 = c67;
                                    z16 = true;
                                case 250:
                                    int pushLimit7 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    int i66 = (c16 == true ? 1 : 0) & 4194304;
                                    char c68 = c16;
                                    if (i66 != 4194304) {
                                        c68 = c16;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.versionRequirement_ = new ArrayList();
                                            c68 = (c16 == true ? 1 : 0) | 0;
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit7);
                                    c16 = c68;
                                    z16 = true;
                                case 258:
                                    VersionRequirementTable.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.versionRequirementTable_.toBuilder() : null;
                                    VersionRequirementTable versionRequirementTable = (VersionRequirementTable) codedInputStream.readMessage(VersionRequirementTable.PARSER, extensionRegistryLite);
                                    this.versionRequirementTable_ = versionRequirementTable;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(versionRequirementTable);
                                        this.versionRequirementTable_ = builder3.buildPartial();
                                    }
                                    this.bitField0_ |= 128;
                                    c16 = c16;
                                    z16 = true;
                                default:
                                    z16 = true;
                                    r56 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                    c16 = r56 != 0 ? c16 : c16;
                                    z17 = z16;
                            }
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        } catch (IOException e17) {
                            throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th5) {
                        if (((c16 == true ? 1 : 0) & 32) == 32) {
                            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                        }
                        if (((c16 == true ? 1 : 0) & 8) == 8) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if (((c16 == true ? 1 : 0) & 16) == 16) {
                            this.supertype_ = Collections.unmodifiableList(this.supertype_);
                        }
                        if (((c16 == true ? 1 : 0) & 64) == 64) {
                            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                        }
                        if (((c16 == true ? 1 : 0) & 512) == 512) {
                            this.constructor_ = Collections.unmodifiableList(this.constructor_);
                        }
                        if (((c16 == true ? 1 : 0) & 1024) == 1024) {
                            this.function_ = Collections.unmodifiableList(this.function_);
                        }
                        if (((c16 == true ? 1 : 0) & 2048) == 2048) {
                            this.property_ = Collections.unmodifiableList(this.property_);
                        }
                        if (((c16 == true ? 1 : 0) & 4096) == 4096) {
                            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                        }
                        if (((c16 == true ? 1 : 0) & 8192) == 8192) {
                            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                        }
                        if (((c16 == true ? 1 : 0) & 16384) == 16384) {
                            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                        }
                        if (((c16 == true ? 1 : 0) & 128) == 128) {
                            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                        }
                        if (((c16 == true ? 1 : 0) & 256) == 256) {
                            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                        }
                        if (((c16 == true ? 1 : 0) & 262144) == 262144) {
                            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                        }
                        if (((c16 == true ? 1 : 0) & 524288) == 524288) {
                            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                        }
                        if (((c16 == true ? 1 : 0) & 1048576) == 1048576) {
                            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                        }
                        if (((c16 == true ? 1 : 0) & r56) == r56) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                        }
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th6) {
                            this.unknownFields = newOutput.toByteString();
                            throw th6;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th5;
                    }
                } else {
                    if (((c16 == true ? 1 : 0) & 32) == 32) {
                        this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    }
                    if (((c16 == true ? 1 : 0) & 8) == 8) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (((c16 == true ? 1 : 0) & 16) == 16) {
                        this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    }
                    if (((c16 == true ? 1 : 0) & 64) == 64) {
                        this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    }
                    if (((c16 == true ? 1 : 0) & 512) == 512) {
                        this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    }
                    if (((c16 == true ? 1 : 0) & 1024) == 1024) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if (((c16 == true ? 1 : 0) & 2048) == 2048) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if (((c16 == true ? 1 : 0) & 4096) == 4096) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    }
                    if (((c16 == true ? 1 : 0) & 8192) == 8192) {
                        this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    }
                    if (((c16 == true ? 1 : 0) & 16384) == 16384) {
                        this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    }
                    if (((c16 == true ? 1 : 0) & 128) == 128) {
                        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    }
                    if (((c16 == true ? 1 : 0) & 256) == 256) {
                        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    }
                    if (((c16 == true ? 1 : 0) & 262144) == 262144) {
                        this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                    }
                    if (((c16 == true ? 1 : 0) & 524288) == 524288) {
                        this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                    }
                    if (((c16 == true ? 1 : 0) & 1048576) == 1048576) {
                        this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                    }
                    if (((c16 == true ? 1 : 0) & 4194304) == 4194304) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused2) {
                    } catch (Throwable th7) {
                        this.unknownFields = newOutput.toByteString();
                        throw th7;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    return;
                }
            }
        }
    }

    /* loaded from: classes28.dex */
    public interface ClassOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements ConstructorOrBuilder {
        public static Parser<Constructor> PARSER = new AbstractParser<Constructor>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Constructor parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Constructor(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Constructor defaultInstance;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Constructor, Builder> implements ConstructorOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$13300() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.valueParameter_ = new ArrayList(this.valueParameter_);
                    this.bitField0_ |= 2;
                }
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4;
                }
            }

            public Constructor buildPartial() {
                Constructor constructor = new Constructor(this);
                int i3 = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i3 = 0;
                }
                constructor.flags_ = this.flags_;
                if ((this.bitField0_ & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= -3;
                }
                constructor.valueParameter_ = this.valueParameter_;
                if ((this.bitField0_ & 4) == 4) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -5;
                }
                constructor.versionRequirement_ = this.versionRequirement_;
                constructor.bitField0_ = i3;
                return constructor;
            }

            public ValueParameter getValueParameter(int i3) {
                return this.valueParameter_.get(i3);
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i3 = 0; i3 < getValueParameterCount(); i3++) {
                    if (!getValueParameter(i3).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder setFlags(int i3) {
                this.bitField0_ |= 1;
                this.flags_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Constructor build() {
                Constructor buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Constructor constructor) {
                if (constructor == Constructor.getDefaultInstance()) {
                    return this;
                }
                if (constructor.hasFlags()) {
                    setFlags(constructor.getFlags());
                }
                if (!constructor.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = constructor.valueParameter_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(constructor.valueParameter_);
                    }
                }
                if (!constructor.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = constructor.versionRequirement_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(constructor.versionRequirement_);
                    }
                }
                mergeExtensionFields(constructor);
                setUnknownFields(getUnknownFields().concat(constructor.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Constructor constructor = null;
                try {
                    try {
                        Constructor parsePartialFrom = Constructor.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (constructor != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    Constructor constructor2 = (Constructor) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        constructor = constructor2;
                        if (constructor != null) {
                            mergeFrom(constructor);
                        }
                        throw th;
                    }
                }
            }
        }

        static {
            Constructor constructor = new Constructor(true);
            defaultInstance = constructor;
            constructor.initFields();
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$13300();
        }

        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Constructor> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.valueParameter_.size(); i17++) {
                i3 += CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(i17));
            }
            int i18 = 0;
            for (int i19 = 0; i19 < this.versionRequirement_.size(); i19++) {
                i18 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i19).intValue());
            }
            int size = i3 + i18 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public ValueParameter getValueParameter(int i3) {
            return this.valueParameter_.get(i3);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getValueParameterCount(); i3++) {
                if (!getValueParameter(i3).isInitialized()) {
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            for (int i3 = 0; i3 < this.valueParameter_.size(); i3++) {
                codedOutputStream.writeMessage(2, this.valueParameter_.get(i3));
            }
            for (int i16 = 0; i16 < this.versionRequirement_.size(); i16++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i16).intValue());
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Constructor constructor) {
            return newBuilder().mergeFrom(constructor);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Constructor getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        Constructor(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Constructor(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.flags_ = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    if ((i3 & 2) != 2) {
                                        this.valueParameter_ = new ArrayList();
                                        i3 |= 2;
                                    }
                                    this.valueParameter_.add(codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite));
                                } else if (readTag == 248) {
                                    if ((i3 & 4) != 4) {
                                        this.versionRequirement_ = new ArrayList();
                                        i3 |= 4;
                                    }
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                } else if (readTag != 250) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if ((i3 & 4) != 4 && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_ = new ArrayList();
                                        i3 |= 4;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                }
                            }
                            z16 = true;
                        } catch (IOException e16) {
                            throw new InvalidProtocolBufferException(e16.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e17) {
                        throw e17.setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if ((i3 & 2) == 2) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if ((i3 & 4) == 4) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if ((i3 & 2) == 2) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if ((i3 & 4) == 4) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface ConstructorOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class Contract extends GeneratedMessageLite implements ContractOrBuilder {
        public static Parser<Contract> PARSER = new AbstractParser<Contract>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Contract parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Contract(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Contract defaultInstance;
        private List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Contract, Builder> implements ContractOrBuilder {
            private int bitField0_;
            private List<Effect> effect_ = Collections.emptyList();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$23500() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureEffectIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.effect_ = new ArrayList(this.effect_);
                    this.bitField0_ |= 1;
                }
            }

            public Contract buildPartial() {
                Contract contract = new Contract(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                    this.bitField0_ &= -2;
                }
                contract.effect_ = this.effect_;
                return contract;
            }

            public Effect getEffect(int i3) {
                return this.effect_.get(i3);
            }

            public int getEffectCount() {
                return this.effect_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i3 = 0; i3 < getEffectCount(); i3++) {
                    if (!getEffect(i3).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Contract build() {
                Contract buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Contract contract) {
                if (contract == Contract.getDefaultInstance()) {
                    return this;
                }
                if (!contract.effect_.isEmpty()) {
                    if (this.effect_.isEmpty()) {
                        this.effect_ = contract.effect_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureEffectIsMutable();
                        this.effect_.addAll(contract.effect_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(contract.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Contract contract = null;
                try {
                    try {
                        Contract parsePartialFrom = Contract.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (contract != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    Contract contract2 = (Contract) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        contract = contract2;
                        if (contract != null) {
                            mergeFrom(contract);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        static {
            Contract contract = new Contract(true);
            defaultInstance = contract;
            contract.initFields();
        }

        public static Contract getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effect_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$23500();
        }

        public Effect getEffect(int i3) {
            return this.effect_.get(i3);
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Contract> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.effect_.size(); i17++) {
                i16 += CodedOutputStream.computeMessageSize(1, this.effect_.get(i17));
            }
            int size = i16 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getEffectCount(); i3++) {
                if (!getEffect(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i3 = 0; i3 < this.effect_.size(); i3++) {
                codedOutputStream.writeMessage(1, this.effect_.get(i3));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Contract contract) {
            return newBuilder().mergeFrom(contract);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Contract getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        Contract(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        Contract(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Contract(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 10) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z17 & true)) {
                                    this.effect_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.effect_.add(codedInputStream.readMessage(Effect.PARSER, extensionRegistryLite));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if (z17 & true) {
                        this.effect_ = Collections.unmodifiableList(this.effect_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if (z17 & true) {
                this.effect_ = Collections.unmodifiableList(this.effect_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface ContractOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class Effect extends GeneratedMessageLite implements EffectOrBuilder {
        public static Parser<Effect> PARSER = new AbstractParser<Effect>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Effect parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Effect(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Effect defaultInstance;
        private int bitField0_;
        private Expression conclusionOfConditionalEffect_;
        private List<Expression> effectConstructorArgument_;
        private EffectType effectType_;
        private InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Effect, Builder> implements EffectOrBuilder {
            private int bitField0_;
            private EffectType effectType_ = EffectType.RETURNS_CONSTANT;
            private List<Expression> effectConstructorArgument_ = Collections.emptyList();
            private Expression conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            private InvocationKind kind_ = InvocationKind.AT_MOST_ONCE;

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$24000() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureEffectConstructorArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                    this.bitField0_ |= 2;
                }
            }

            public Effect buildPartial() {
                Effect effect = new Effect(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) != 1) {
                    i16 = 0;
                }
                effect.effectType_ = this.effectType_;
                if ((this.bitField0_ & 2) == 2) {
                    this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    this.bitField0_ &= -3;
                }
                effect.effectConstructorArgument_ = this.effectConstructorArgument_;
                if ((i3 & 4) == 4) {
                    i16 |= 2;
                }
                effect.conclusionOfConditionalEffect_ = this.conclusionOfConditionalEffect_;
                if ((i3 & 8) == 8) {
                    i16 |= 4;
                }
                effect.kind_ = this.kind_;
                effect.bitField0_ = i16;
                return effect;
            }

            public Expression getConclusionOfConditionalEffect() {
                return this.conclusionOfConditionalEffect_;
            }

            public Expression getEffectConstructorArgument(int i3) {
                return this.effectConstructorArgument_.get(i3);
            }

            public int getEffectConstructorArgumentCount() {
                return this.effectConstructorArgument_.size();
            }

            public boolean hasConclusionOfConditionalEffect() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i3 = 0; i3 < getEffectConstructorArgumentCount(); i3++) {
                    if (!getEffectConstructorArgument(i3).isInitialized()) {
                        return false;
                    }
                }
                if (hasConclusionOfConditionalEffect() && !getConclusionOfConditionalEffect().isInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeConclusionOfConditionalEffect(Expression expression) {
                if ((this.bitField0_ & 4) == 4 && this.conclusionOfConditionalEffect_ != Expression.getDefaultInstance()) {
                    this.conclusionOfConditionalEffect_ = Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(expression).buildPartial();
                } else {
                    this.conclusionOfConditionalEffect_ = expression;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setEffectType(EffectType effectType) {
                effectType.getClass();
                this.bitField0_ |= 1;
                this.effectType_ = effectType;
                return this;
            }

            public Builder setKind(InvocationKind invocationKind) {
                invocationKind.getClass();
                this.bitField0_ |= 8;
                this.kind_ = invocationKind;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Effect build() {
                Effect buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Effect effect) {
                if (effect == Effect.getDefaultInstance()) {
                    return this;
                }
                if (effect.hasEffectType()) {
                    setEffectType(effect.getEffectType());
                }
                if (!effect.effectConstructorArgument_.isEmpty()) {
                    if (this.effectConstructorArgument_.isEmpty()) {
                        this.effectConstructorArgument_ = effect.effectConstructorArgument_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureEffectConstructorArgumentIsMutable();
                        this.effectConstructorArgument_.addAll(effect.effectConstructorArgument_);
                    }
                }
                if (effect.hasConclusionOfConditionalEffect()) {
                    mergeConclusionOfConditionalEffect(effect.getConclusionOfConditionalEffect());
                }
                if (effect.hasKind()) {
                    setKind(effect.getKind());
                }
                setUnknownFields(getUnknownFields().concat(effect.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Effect effect = null;
                try {
                    try {
                        Effect parsePartialFrom = Effect.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (effect != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    Effect effect2 = (Effect) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        effect = effect2;
                        if (effect != null) {
                            mergeFrom(effect);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        /* loaded from: classes28.dex */
        public enum EffectType implements Internal.EnumLite {
            RETURNS_CONSTANT(0, 0),
            CALLS(1, 1),
            RETURNS_NOT_NULL(2, 2);

            private static Internal.EnumLiteMap<EffectType> internalValueMap = new Internal.EnumLiteMap<EffectType>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.EffectType.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                public EffectType findValueByNumber(int i3) {
                    return EffectType.valueOf(i3);
                }
            };
            private final int value;

            EffectType(int i3, int i16) {
                this.value = i16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static EffectType valueOf(int i3) {
                if (i3 == 0) {
                    return RETURNS_CONSTANT;
                }
                if (i3 == 1) {
                    return CALLS;
                }
                if (i3 != 2) {
                    return null;
                }
                return RETURNS_NOT_NULL;
            }
        }

        /* loaded from: classes28.dex */
        public enum InvocationKind implements Internal.EnumLite {
            AT_MOST_ONCE(0, 0),
            EXACTLY_ONCE(1, 1),
            AT_LEAST_ONCE(2, 2);

            private static Internal.EnumLiteMap<InvocationKind> internalValueMap = new Internal.EnumLiteMap<InvocationKind>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.InvocationKind.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                public InvocationKind findValueByNumber(int i3) {
                    return InvocationKind.valueOf(i3);
                }
            };
            private final int value;

            InvocationKind(int i3, int i16) {
                this.value = i16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static InvocationKind valueOf(int i3) {
                if (i3 == 0) {
                    return AT_MOST_ONCE;
                }
                if (i3 == 1) {
                    return EXACTLY_ONCE;
                }
                if (i3 != 2) {
                    return null;
                }
                return AT_LEAST_ONCE;
            }
        }

        static {
            Effect effect = new Effect(true);
            defaultInstance = effect;
            effect.initFields();
        }

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        public static Builder newBuilder() {
            return Builder.access$24000();
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        public Expression getEffectConstructorArgument(int i3) {
            return this.effectConstructorArgument_.get(i3);
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public EffectType getEffectType() {
            return this.effectType_;
        }

        public InvocationKind getKind() {
            return this.kind_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Effect> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.effectConstructorArgument_.size(); i17++) {
                i3 += CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(i17));
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
            }
            int size = i3 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasConclusionOfConditionalEffect() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean hasEffectType() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasKind() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getEffectConstructorArgumentCount(); i3++) {
                if (!getEffectConstructorArgument(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasConclusionOfConditionalEffect() && !getConclusionOfConditionalEffect().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.effectType_.getNumber());
            }
            for (int i3 = 0; i3 < this.effectConstructorArgument_.size(); i3++) {
                codedOutputStream.writeMessage(2, this.effectConstructorArgument_.get(i3));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(4, this.kind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Effect effect) {
            return newBuilder().mergeFrom(effect);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Effect getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        Effect(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        Effect(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Effect(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    int readEnum = codedInputStream.readEnum();
                                    EffectType valueOf = EffectType.valueOf(readEnum);
                                    if (valueOf == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.effectType_ = valueOf;
                                    }
                                } else if (readTag == 18) {
                                    if ((i3 & 2) != 2) {
                                        this.effectConstructorArgument_ = new ArrayList();
                                        i3 |= 2;
                                    }
                                    this.effectConstructorArgument_.add(codedInputStream.readMessage(Expression.PARSER, extensionRegistryLite));
                                } else if (readTag == 26) {
                                    Expression.Builder builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                                    Expression expression = (Expression) codedInputStream.readMessage(Expression.PARSER, extensionRegistryLite);
                                    this.conclusionOfConditionalEffect_ = expression;
                                    if (builder != null) {
                                        builder.mergeFrom(expression);
                                        this.conclusionOfConditionalEffect_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (readTag != 32) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    int readEnum2 = codedInputStream.readEnum();
                                    InvocationKind valueOf2 = InvocationKind.valueOf(readEnum2);
                                    if (valueOf2 == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum2);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.kind_ = valueOf2;
                                    }
                                }
                            }
                            z16 = true;
                        } catch (IOException e16) {
                            throw new InvalidProtocolBufferException(e16.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e17) {
                        throw e17.setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if ((i3 & 2) == 2) {
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if ((i3 & 2) == 2) {
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface EffectOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements EnumEntryOrBuilder {
        public static Parser<EnumEntry> PARSER = new AbstractParser<EnumEntry>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public EnumEntry parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EnumEntry(codedInputStream, extensionRegistryLite);
            }
        };
        private static final EnumEntry defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumEntry, Builder> implements EnumEntryOrBuilder {
            private int bitField0_;
            private int name_;

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$20400() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            public EnumEntry buildPartial() {
                EnumEntry enumEntry = new EnumEntry(this);
                int i3 = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i3 = 0;
                }
                enumEntry.name_ = this.name_;
                enumEntry.bitField0_ = i3;
                return enumEntry;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder setName(int i3) {
                this.bitField0_ |= 1;
                this.name_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public EnumEntry build() {
                EnumEntry buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(EnumEntry enumEntry) {
                if (enumEntry == EnumEntry.getDefaultInstance()) {
                    return this;
                }
                if (enumEntry.hasName()) {
                    setName(enumEntry.getName());
                }
                mergeExtensionFields(enumEntry);
                setUnknownFields(getUnknownFields().concat(enumEntry.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                EnumEntry enumEntry = null;
                try {
                    try {
                        EnumEntry parsePartialFrom = EnumEntry.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (enumEntry != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    EnumEntry enumEntry2 = (EnumEntry) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        enumEntry = enumEntry2;
                        if (enumEntry != null) {
                            mergeFrom(enumEntry);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        static {
            EnumEntry enumEntry = new EnumEntry(true);
            defaultInstance = enumEntry;
            enumEntry.initFields();
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.access$20400();
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<EnumEntry> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i16 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
            }
            int extensionsSerializedSize = i16 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(EnumEntry enumEntry) {
            return newBuilder().mergeFrom(enumEntry);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public EnumEntry getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        EnumEntry(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        EnumEntry(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 8) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.name_ = codedInputStream.readInt32();
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface EnumEntryOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class Expression extends GeneratedMessageLite implements ExpressionOrBuilder {
        public static Parser<Expression> PARSER = new AbstractParser<Expression>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Expression parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Expression(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Expression defaultInstance;
        private List<Expression> andArgument_;
        private int bitField0_;
        private ConstantValue constantValue_;
        private int flags_;
        private int isInstanceTypeId_;
        private Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Expression> orArgument_;
        private final ByteString unknownFields;
        private int valueParameterReference_;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Expression, Builder> implements ExpressionOrBuilder {
            private int bitField0_;
            private int flags_;
            private int isInstanceTypeId_;
            private int valueParameterReference_;
            private ConstantValue constantValue_ = ConstantValue.TRUE;
            private Type isInstanceType_ = Type.getDefaultInstance();
            private List<Expression> andArgument_ = Collections.emptyList();
            private List<Expression> orArgument_ = Collections.emptyList();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$24900() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureAndArgumentIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.andArgument_ = new ArrayList(this.andArgument_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureOrArgumentIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.orArgument_ = new ArrayList(this.orArgument_);
                    this.bitField0_ |= 64;
                }
            }

            public Expression buildPartial() {
                Expression expression = new Expression(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) != 1) {
                    i16 = 0;
                }
                expression.flags_ = this.flags_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                expression.valueParameterReference_ = this.valueParameterReference_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                expression.constantValue_ = this.constantValue_;
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                expression.isInstanceType_ = this.isInstanceType_;
                if ((i3 & 16) == 16) {
                    i16 |= 16;
                }
                expression.isInstanceTypeId_ = this.isInstanceTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    this.bitField0_ &= -33;
                }
                expression.andArgument_ = this.andArgument_;
                if ((this.bitField0_ & 64) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                    this.bitField0_ &= -65;
                }
                expression.orArgument_ = this.orArgument_;
                expression.bitField0_ = i16;
                return expression;
            }

            public Expression getAndArgument(int i3) {
                return this.andArgument_.get(i3);
            }

            public int getAndArgumentCount() {
                return this.andArgument_.size();
            }

            public Type getIsInstanceType() {
                return this.isInstanceType_;
            }

            public Expression getOrArgument(int i3) {
                return this.orArgument_.get(i3);
            }

            public int getOrArgumentCount() {
                return this.orArgument_.size();
            }

            public boolean hasIsInstanceType() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                    return false;
                }
                for (int i3 = 0; i3 < getAndArgumentCount(); i3++) {
                    if (!getAndArgument(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i16 = 0; i16 < getOrArgumentCount(); i16++) {
                    if (!getOrArgument(i16).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeIsInstanceType(Type type) {
                if ((this.bitField0_ & 8) == 8 && this.isInstanceType_ != Type.getDefaultInstance()) {
                    this.isInstanceType_ = Type.newBuilder(this.isInstanceType_).mergeFrom(type).buildPartial();
                } else {
                    this.isInstanceType_ = type;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setConstantValue(ConstantValue constantValue) {
                constantValue.getClass();
                this.bitField0_ |= 4;
                this.constantValue_ = constantValue;
                return this;
            }

            public Builder setFlags(int i3) {
                this.bitField0_ |= 1;
                this.flags_ = i3;
                return this;
            }

            public Builder setIsInstanceTypeId(int i3) {
                this.bitField0_ |= 16;
                this.isInstanceTypeId_ = i3;
                return this;
            }

            public Builder setValueParameterReference(int i3) {
                this.bitField0_ |= 2;
                this.valueParameterReference_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Expression build() {
                Expression buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Expression expression) {
                if (expression == Expression.getDefaultInstance()) {
                    return this;
                }
                if (expression.hasFlags()) {
                    setFlags(expression.getFlags());
                }
                if (expression.hasValueParameterReference()) {
                    setValueParameterReference(expression.getValueParameterReference());
                }
                if (expression.hasConstantValue()) {
                    setConstantValue(expression.getConstantValue());
                }
                if (expression.hasIsInstanceType()) {
                    mergeIsInstanceType(expression.getIsInstanceType());
                }
                if (expression.hasIsInstanceTypeId()) {
                    setIsInstanceTypeId(expression.getIsInstanceTypeId());
                }
                if (!expression.andArgument_.isEmpty()) {
                    if (this.andArgument_.isEmpty()) {
                        this.andArgument_ = expression.andArgument_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureAndArgumentIsMutable();
                        this.andArgument_.addAll(expression.andArgument_);
                    }
                }
                if (!expression.orArgument_.isEmpty()) {
                    if (this.orArgument_.isEmpty()) {
                        this.orArgument_ = expression.orArgument_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureOrArgumentIsMutable();
                        this.orArgument_.addAll(expression.orArgument_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(expression.unknownFields));
                return this;
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Expression expression = null;
                try {
                    try {
                        Expression parsePartialFrom = Expression.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (expression != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    Expression expression2 = (Expression) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        expression = expression2;
                        if (expression != null) {
                            mergeFrom(expression);
                        }
                        throw th;
                    }
                }
            }
        }

        /* loaded from: classes28.dex */
        public enum ConstantValue implements Internal.EnumLite {
            TRUE(0, 0),
            FALSE(1, 1),
            NULL(2, 2);

            private static Internal.EnumLiteMap<ConstantValue> internalValueMap = new Internal.EnumLiteMap<ConstantValue>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.ConstantValue.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                public ConstantValue findValueByNumber(int i3) {
                    return ConstantValue.valueOf(i3);
                }
            };
            private final int value;

            ConstantValue(int i3, int i16) {
                this.value = i16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int i3) {
                if (i3 == 0) {
                    return TRUE;
                }
                if (i3 == 1) {
                    return FALSE;
                }
                if (i3 != 2) {
                    return null;
                }
                return NULL;
            }
        }

        static {
            Expression expression = new Expression(true);
            defaultInstance = expression;
            expression.initFields();
        }

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$24900();
        }

        public Expression getAndArgument(int i3) {
            return this.andArgument_.get(i3);
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        public Expression getOrArgument(int i3) {
            return this.orArgument_.get(i3);
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Expression> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
            }
            for (int i17 = 0; i17 < this.andArgument_.size(); i17++) {
                i3 += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i17));
            }
            for (int i18 = 0; i18 < this.orArgument_.size(); i18++) {
                i3 += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i18));
            }
            int size = i3 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        public boolean hasConstantValue() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasIsInstanceType() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        public boolean hasIsInstanceTypeId() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        public boolean hasValueParameterReference() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getAndArgumentCount(); i3++) {
                if (!getAndArgument(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i16 = 0; i16 < getOrArgumentCount(); i16++) {
                if (!getOrArgument(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.isInstanceTypeId_);
            }
            for (int i3 = 0; i3 < this.andArgument_.size(); i3++) {
                codedOutputStream.writeMessage(6, this.andArgument_.get(i3));
            }
            for (int i16 = 0; i16 < this.orArgument_.size(); i16++) {
                codedOutputStream.writeMessage(7, this.orArgument_.get(i16));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Expression expression) {
            return newBuilder().mergeFrom(expression);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Expression getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        Expression(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        Expression(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Expression(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.flags_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.bitField0_ |= 2;
                                this.valueParameterReference_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                int readEnum = codedInputStream.readEnum();
                                ConstantValue valueOf = ConstantValue.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.constantValue_ = valueOf;
                                }
                            } else if (readTag == 34) {
                                Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                                Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.isInstanceType_ = type;
                                if (builder != null) {
                                    builder.mergeFrom(type);
                                    this.isInstanceType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 8;
                            } else if (readTag == 40) {
                                this.bitField0_ |= 16;
                                this.isInstanceTypeId_ = codedInputStream.readInt32();
                            } else if (readTag == 50) {
                                if ((i3 & 32) != 32) {
                                    this.andArgument_ = new ArrayList();
                                    i3 |= 32;
                                }
                                this.andArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                            } else if (readTag != 58) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if ((i3 & 64) != 64) {
                                    this.orArgument_ = new ArrayList();
                                    i3 |= 64;
                                }
                                this.orArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if ((i3 & 32) == 32) {
                        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    }
                    if ((i3 & 64) == 64) {
                        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if ((i3 & 32) == 32) {
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
            }
            if ((i3 & 64) == 64) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface ExpressionOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements FunctionOrBuilder {
        public static Parser<Function> PARSER = new AbstractParser<Function>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Function parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Function(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Function defaultInstance;
        private int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private Contract contract_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Function, Builder> implements FunctionOrBuilder {
            private int bitField0_;
            private int name_;
            private int receiverTypeId_;
            private int returnTypeId_;
            private int flags_ = 6;
            private int oldFlags_ = 6;
            private Type returnType_ = Type.getDefaultInstance();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type receiverType_ = Type.getDefaultInstance();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();
            private Contract contract_ = Contract.getDefaultInstance();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$14100() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 512;
                }
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 256;
                }
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.valueParameter_ = new ArrayList(this.valueParameter_);
                    this.bitField0_ |= 1024;
                }
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4096) != 4096) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4096;
                }
            }

            public Function buildPartial() {
                Function function = new Function(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) != 1) {
                    i16 = 0;
                }
                function.flags_ = this.flags_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                function.oldFlags_ = this.oldFlags_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                function.name_ = this.name_;
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                function.returnType_ = this.returnType_;
                if ((i3 & 16) == 16) {
                    i16 |= 16;
                }
                function.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -33;
                }
                function.typeParameter_ = this.typeParameter_;
                if ((i3 & 64) == 64) {
                    i16 |= 32;
                }
                function.receiverType_ = this.receiverType_;
                if ((i3 & 128) == 128) {
                    i16 |= 64;
                }
                function.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -257;
                }
                function.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -513;
                }
                function.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= -1025;
                }
                function.valueParameter_ = this.valueParameter_;
                if ((i3 & 2048) == 2048) {
                    i16 |= 128;
                }
                function.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 4096) == 4096) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -4097;
                }
                function.versionRequirement_ = this.versionRequirement_;
                if ((i3 & 8192) == 8192) {
                    i16 |= 256;
                }
                function.contract_ = this.contract_;
                function.bitField0_ = i16;
                return function;
            }

            public Type getContextReceiverType(int i3) {
                return this.contextReceiverType_.get(i3);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Contract getContract() {
                return this.contract_;
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public TypeParameter getTypeParameter(int i3) {
                return this.typeParameter_.get(i3);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public ValueParameter getValueParameter(int i3) {
                return this.valueParameter_.get(i3);
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public boolean hasContract() {
                if ((this.bitField0_ & 8192) == 8192) {
                    return true;
                }
                return false;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            public boolean hasReceiverType() {
                if ((this.bitField0_ & 64) == 64) {
                    return true;
                }
                return false;
            }

            public boolean hasReturnType() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 2048) == 2048) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasReturnType() && !getReturnType().isInitialized()) {
                    return false;
                }
                for (int i3 = 0; i3 < getTypeParameterCount(); i3++) {
                    if (!getTypeParameter(i3).isInitialized()) {
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    return false;
                }
                for (int i16 = 0; i16 < getContextReceiverTypeCount(); i16++) {
                    if (!getContextReceiverType(i16).isInitialized()) {
                        return false;
                    }
                }
                for (int i17 = 0; i17 < getValueParameterCount(); i17++) {
                    if (!getValueParameter(i17).isInitialized()) {
                        return false;
                    }
                }
                if (hasTypeTable() && !getTypeTable().isInitialized()) {
                    return false;
                }
                if ((hasContract() && !getContract().isInitialized()) || !extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeContract(Contract contract) {
                if ((this.bitField0_ & 8192) == 8192 && this.contract_ != Contract.getDefaultInstance()) {
                    this.contract_ = Contract.newBuilder(this.contract_).mergeFrom(contract).buildPartial();
                } else {
                    this.contract_ = contract;
                }
                this.bitField0_ |= 8192;
                return this;
            }

            public Builder mergeReceiverType(Type type) {
                if ((this.bitField0_ & 64) == 64 && this.receiverType_ != Type.getDefaultInstance()) {
                    this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(type).buildPartial();
                } else {
                    this.receiverType_ = type;
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeReturnType(Type type) {
                if ((this.bitField0_ & 8) == 8 && this.returnType_ != Type.getDefaultInstance()) {
                    this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(type).buildPartial();
                } else {
                    this.returnType_ = type;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 2048) == 2048 && this.typeTable_ != TypeTable.getDefaultInstance()) {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                } else {
                    this.typeTable_ = typeTable;
                }
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder setFlags(int i3) {
                this.bitField0_ |= 1;
                this.flags_ = i3;
                return this;
            }

            public Builder setName(int i3) {
                this.bitField0_ |= 4;
                this.name_ = i3;
                return this;
            }

            public Builder setOldFlags(int i3) {
                this.bitField0_ |= 2;
                this.oldFlags_ = i3;
                return this;
            }

            public Builder setReceiverTypeId(int i3) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i3;
                return this;
            }

            public Builder setReturnTypeId(int i3) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Function build() {
                Function buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Function function) {
                if (function == Function.getDefaultInstance()) {
                    return this;
                }
                if (function.hasFlags()) {
                    setFlags(function.getFlags());
                }
                if (function.hasOldFlags()) {
                    setOldFlags(function.getOldFlags());
                }
                if (function.hasName()) {
                    setName(function.getName());
                }
                if (function.hasReturnType()) {
                    mergeReturnType(function.getReturnType());
                }
                if (function.hasReturnTypeId()) {
                    setReturnTypeId(function.getReturnTypeId());
                }
                if (!function.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = function.typeParameter_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(function.typeParameter_);
                    }
                }
                if (function.hasReceiverType()) {
                    mergeReceiverType(function.getReceiverType());
                }
                if (function.hasReceiverTypeId()) {
                    setReceiverTypeId(function.getReceiverTypeId());
                }
                if (!function.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = function.contextReceiverType_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(function.contextReceiverType_);
                    }
                }
                if (!function.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = function.contextReceiverTypeId_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(function.contextReceiverTypeId_);
                    }
                }
                if (!function.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = function.valueParameter_;
                        this.bitField0_ &= -1025;
                    } else {
                        ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(function.valueParameter_);
                    }
                }
                if (function.hasTypeTable()) {
                    mergeTypeTable(function.getTypeTable());
                }
                if (!function.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = function.versionRequirement_;
                        this.bitField0_ &= -4097;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(function.versionRequirement_);
                    }
                }
                if (function.hasContract()) {
                    mergeContract(function.getContract());
                }
                mergeExtensionFields(function);
                setUnknownFields(getUnknownFields().concat(function.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Function function = null;
                try {
                    try {
                        Function parsePartialFrom = Function.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (function != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    Function function2 = (Function) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        function = function2;
                        if (function != null) {
                            mergeFrom(function);
                        }
                        throw th;
                    }
                }
            }
        }

        static {
            Function function = new Function(true);
            defaultInstance = function;
            function.initFields();
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$14100();
        }

        public static Function parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public Type getContextReceiverType(int i3) {
            return this.contextReceiverType_.get(i3);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public Contract getContract() {
            return this.contract_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Function> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (int i17 = 0; i17 < this.typeParameter_.size(); i17++) {
                i3 += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i17));
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            for (int i18 = 0; i18 < this.valueParameter_.size(); i18++) {
                i3 += CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(i18));
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i3 += CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 += CodedOutputStream.computeInt32Size(9, this.flags_);
            }
            for (int i19 = 0; i19 < this.contextReceiverType_.size(); i19++) {
                i3 += CodedOutputStream.computeMessageSize(10, this.contextReceiverType_.get(i19));
            }
            int i26 = 0;
            for (int i27 = 0; i27 < this.contextReceiverTypeId_.size(); i27++) {
                i26 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i27).intValue());
            }
            int i28 = i3 + i26;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i28 = i28 + 1 + CodedOutputStream.computeInt32SizeNoTag(i26);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i26;
            if ((this.bitField0_ & 128) == 128) {
                i28 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            int i29 = 0;
            for (int i36 = 0; i36 < this.versionRequirement_.size(); i36++) {
                i29 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i36).intValue());
            }
            int size = i28 + i29 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 256) == 256) {
                size += CodedOutputStream.computeMessageSize(32, this.contract_);
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public TypeParameter getTypeParameter(int i3) {
            return this.typeParameter_.get(i3);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public ValueParameter getValueParameter(int i3) {
            return this.valueParameter_.get(i3);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasContract() {
            if ((this.bitField0_ & 256) == 256) {
                return true;
            }
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean hasOldFlags() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean hasReceiverType() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        public boolean hasReceiverTypeId() {
            if ((this.bitField0_ & 64) == 64) {
                return true;
            }
            return false;
        }

        public boolean hasReturnType() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        public boolean hasReturnTypeId() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 128) == 128) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getTypeParameterCount(); i3++) {
                if (!getTypeParameter(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasReceiverType() && !getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i16 = 0; i16 < getContextReceiverTypeCount(); i16++) {
                if (!getContextReceiverType(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i17 = 0; i17 < getValueParameterCount(); i17++) {
                if (!getValueParameter(i17).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasContract() && !getContract().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(3, this.returnType_);
            }
            for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
                codedOutputStream.writeMessage(4, this.typeParameter_.get(i3));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(5, this.receiverType_);
            }
            for (int i16 = 0; i16 < this.valueParameter_.size(); i16++) {
                codedOutputStream.writeMessage(6, this.valueParameter_.get(i16));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(9, this.flags_);
            }
            for (int i17 = 0; i17 < this.contextReceiverType_.size(); i17++) {
                codedOutputStream.writeMessage(10, this.contextReceiverType_.get(i17));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(90);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i18 = 0; i18 < this.contextReceiverTypeId_.size(); i18++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i18).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            for (int i19 = 0; i19 < this.versionRequirement_.size(); i19++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i19).intValue());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeMessage(32, this.contract_);
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Function function) {
            return newBuilder().mergeFrom(function);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Function getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> extendableBuilder) {
            super(extendableBuilder);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        Function(boolean z16) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0029. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        Function(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            char c16 = 0;
            while (true) {
                ?? r56 = 1024;
                if (!z16) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        z16 = true;
                                    case 8:
                                        this.bitField0_ |= 2;
                                        this.oldFlags_ = codedInputStream.readInt32();
                                    case 16:
                                        this.bitField0_ |= 4;
                                        this.name_ = codedInputStream.readInt32();
                                    case 26:
                                        Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                        Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.returnType_ = type;
                                        if (builder != null) {
                                            builder.mergeFrom(type);
                                            this.returnType_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 8;
                                    case 34:
                                        int i3 = (c16 == true ? 1 : 0) & 32;
                                        c16 = c16;
                                        if (i3 != 32) {
                                            this.typeParameter_ = new ArrayList();
                                            c16 = (c16 == true ? 1 : 0) | TokenParser.SP;
                                        }
                                        this.typeParameter_.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                                    case 42:
                                        Type.Builder builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                        Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.receiverType_ = type2;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(type2);
                                            this.receiverType_ = builder2.buildPartial();
                                        }
                                        this.bitField0_ |= 32;
                                    case 50:
                                        int i16 = (c16 == true ? 1 : 0) & 1024;
                                        c16 = c16;
                                        if (i16 != 1024) {
                                            this.valueParameter_ = new ArrayList();
                                            c16 = (c16 == true ? 1 : 0) | '\u0400';
                                        }
                                        this.valueParameter_.add(codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite));
                                    case 56:
                                        this.bitField0_ |= 16;
                                        this.returnTypeId_ = codedInputStream.readInt32();
                                    case 64:
                                        this.bitField0_ |= 64;
                                        this.receiverTypeId_ = codedInputStream.readInt32();
                                    case 72:
                                        this.bitField0_ |= 1;
                                        this.flags_ = codedInputStream.readInt32();
                                    case 82:
                                        int i17 = (c16 == true ? 1 : 0) & 256;
                                        c16 = c16;
                                        if (i17 != 256) {
                                            this.contextReceiverType_ = new ArrayList();
                                            c16 = (c16 == true ? 1 : 0) | '\u0100';
                                        }
                                        this.contextReceiverType_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                    case 88:
                                        int i18 = (c16 == true ? 1 : 0) & 512;
                                        c16 = c16;
                                        if (i18 != 512) {
                                            this.contextReceiverTypeId_ = new ArrayList();
                                            c16 = (c16 == true ? 1 : 0) | '\u0200';
                                        }
                                        this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    case 90:
                                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        int i19 = (c16 == true ? 1 : 0) & 512;
                                        c16 = c16;
                                        if (i19 != 512) {
                                            c16 = c16;
                                            if (codedInputStream.getBytesUntilLimit() > 0) {
                                                this.contextReceiverTypeId_ = new ArrayList();
                                                c16 = (c16 == true ? 1 : 0) | '\u0200';
                                            }
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                        }
                                        codedInputStream.popLimit(pushLimit);
                                    case 242:
                                        TypeTable.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : null;
                                        TypeTable typeTable = (TypeTable) codedInputStream.readMessage(TypeTable.PARSER, extensionRegistryLite);
                                        this.typeTable_ = typeTable;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(typeTable);
                                            this.typeTable_ = builder3.buildPartial();
                                        }
                                        this.bitField0_ |= 128;
                                    case 248:
                                        int i26 = (c16 == true ? 1 : 0) & 4096;
                                        c16 = c16;
                                        if (i26 != 4096) {
                                            this.versionRequirement_ = new ArrayList();
                                            c16 = (c16 == true ? 1 : 0) | '\u1000';
                                        }
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    case 250:
                                        int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        int i27 = (c16 == true ? 1 : 0) & 4096;
                                        c16 = c16;
                                        if (i27 != 4096) {
                                            c16 = c16;
                                            if (codedInputStream.getBytesUntilLimit() > 0) {
                                                this.versionRequirement_ = new ArrayList();
                                                c16 = (c16 == true ? 1 : 0) | '\u1000';
                                            }
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                        }
                                        codedInputStream.popLimit(pushLimit2);
                                    case 258:
                                        Contract.Builder builder4 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : null;
                                        Contract contract = (Contract) codedInputStream.readMessage(Contract.PARSER, extensionRegistryLite);
                                        this.contract_ = contract;
                                        if (builder4 != null) {
                                            builder4.mergeFrom(contract);
                                            this.contract_ = builder4.buildPartial();
                                        }
                                        this.bitField0_ |= 256;
                                    default:
                                        r56 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                        if (r56 == 0) {
                                            z16 = true;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e16) {
                                throw e16.setUnfinishedMessage(this);
                            }
                        } catch (IOException e17) {
                            throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th5) {
                        if (((c16 == true ? 1 : 0) & 32) == 32) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if (((c16 == true ? 1 : 0) & 1024) == r56) {
                            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                        }
                        if (((c16 == true ? 1 : 0) & 256) == 256) {
                            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                        }
                        if (((c16 == true ? 1 : 0) & 512) == 512) {
                            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                        }
                        if (((c16 == true ? 1 : 0) & 4096) == 4096) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                        }
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th6) {
                            this.unknownFields = newOutput.toByteString();
                            throw th6;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th5;
                    }
                } else {
                    if (((c16 == true ? 1 : 0) & 32) == 32) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (((c16 == true ? 1 : 0) & 1024) == 1024) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if (((c16 == true ? 1 : 0) & 256) == 256) {
                        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    }
                    if (((c16 == true ? 1 : 0) & 512) == 512) {
                        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    }
                    if (((c16 == true ? 1 : 0) & 4096) == 4096) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused2) {
                    } catch (Throwable th7) {
                        this.unknownFields = newOutput.toByteString();
                        throw th7;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    return;
                }
            }
        }
    }

    /* loaded from: classes28.dex */
    public interface FunctionOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public enum MemberKind implements Internal.EnumLite {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);

        private static Internal.EnumLiteMap<MemberKind> internalValueMap = new Internal.EnumLiteMap<MemberKind>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
            public MemberKind findValueByNumber(int i3) {
                return MemberKind.valueOf(i3);
            }
        };
        private final int value;

        MemberKind(int i3, int i16) {
            this.value = i16;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int i3) {
            if (i3 == 0) {
                return DECLARATION;
            }
            if (i3 == 1) {
                return FAKE_OVERRIDE;
            }
            if (i3 == 2) {
                return DELEGATION;
            }
            if (i3 != 3) {
                return null;
            }
            return SYNTHESIZED;
        }
    }

    /* loaded from: classes28.dex */
    public enum Modality implements Internal.EnumLite {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);

        private static Internal.EnumLiteMap<Modality> internalValueMap = new Internal.EnumLiteMap<Modality>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
            public Modality findValueByNumber(int i3) {
                return Modality.valueOf(i3);
            }
        };
        private final int value;

        Modality(int i3, int i16) {
            this.value = i16;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int i3) {
            if (i3 == 0) {
                return FINAL;
            }
            if (i3 == 1) {
                return OPEN;
            }
            if (i3 == 2) {
                return ABSTRACT;
            }
            if (i3 != 3) {
                return null;
            }
            return SEALED;
        }
    }

    /* loaded from: classes28.dex */
    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements PackageOrBuilder {
        public static Parser<Package> PARSER = new AbstractParser<Package>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Package parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Package(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Package defaultInstance;
        private int bitField0_;
        private List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private VersionRequirementTable versionRequirementTable_;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Package, Builder> implements PackageOrBuilder {
            private int bitField0_;
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$11600() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.function_ = new ArrayList(this.function_);
                    this.bitField0_ |= 1;
                }
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 2;
                }
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeAlias_ = new ArrayList(this.typeAlias_);
                    this.bitField0_ |= 4;
                }
            }

            public Package buildPartial() {
                Package r06 = new Package(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) == 1) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= -2;
                }
                r06.function_ = this.function_;
                if ((this.bitField0_ & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -3;
                }
                r06.property_ = this.property_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= -5;
                }
                r06.typeAlias_ = this.typeAlias_;
                if ((i3 & 8) != 8) {
                    i16 = 0;
                }
                r06.typeTable_ = this.typeTable_;
                if ((i3 & 16) == 16) {
                    i16 |= 2;
                }
                r06.versionRequirementTable_ = this.versionRequirementTable_;
                r06.bitField0_ = i16;
                return r06;
            }

            public Function getFunction(int i3) {
                return this.function_.get(i3);
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Property getProperty(int i3) {
                return this.property_.get(i3);
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public TypeAlias getTypeAlias(int i3) {
                return this.typeAlias_.get(i3);
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i3 = 0; i3 < getFunctionCount(); i3++) {
                    if (!getFunction(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i16 = 0; i16 < getPropertyCount(); i16++) {
                    if (!getProperty(i16).isInitialized()) {
                        return false;
                    }
                }
                for (int i17 = 0; i17 < getTypeAliasCount(); i17++) {
                    if (!getTypeAlias(i17).isInitialized()) {
                        return false;
                    }
                }
                if ((hasTypeTable() && !getTypeTable().isInitialized()) || !extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 8) == 8 && this.typeTable_ != TypeTable.getDefaultInstance()) {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                } else {
                    this.typeTable_ = typeTable;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                if ((this.bitField0_ & 16) == 16 && this.versionRequirementTable_ != VersionRequirementTable.getDefaultInstance()) {
                    this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(versionRequirementTable).buildPartial();
                } else {
                    this.versionRequirementTable_ = versionRequirementTable;
                }
                this.bitField0_ |= 16;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Package build() {
                Package buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Package r36) {
                if (r36 == Package.getDefaultInstance()) {
                    return this;
                }
                if (!r36.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = r36.function_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFunctionIsMutable();
                        this.function_.addAll(r36.function_);
                    }
                }
                if (!r36.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = r36.property_;
                        this.bitField0_ &= -3;
                    } else {
                        ensurePropertyIsMutable();
                        this.property_.addAll(r36.property_);
                    }
                }
                if (!r36.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = r36.typeAlias_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(r36.typeAlias_);
                    }
                }
                if (r36.hasTypeTable()) {
                    mergeTypeTable(r36.getTypeTable());
                }
                if (r36.hasVersionRequirementTable()) {
                    mergeVersionRequirementTable(r36.getVersionRequirementTable());
                }
                mergeExtensionFields(r36);
                setUnknownFields(getUnknownFields().concat(r36.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Package r06 = null;
                try {
                    try {
                        Package parsePartialFrom = Package.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (r06 != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    Package r46 = (Package) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        r06 = r46;
                        if (r06 != null) {
                            mergeFrom(r06);
                        }
                        throw th;
                    }
                }
            }
        }

        static {
            Package r06 = new Package(true);
            defaultInstance = r06;
            r06.initFields();
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$11600();
        }

        public static Package parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public Function getFunction(int i3) {
            return this.function_.get(i3);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Package> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i3) {
            return this.property_.get(i3);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.function_.size(); i17++) {
                i16 += CodedOutputStream.computeMessageSize(3, this.function_.get(i17));
            }
            for (int i18 = 0; i18 < this.property_.size(); i18++) {
                i16 += CodedOutputStream.computeMessageSize(4, this.property_.get(i18));
            }
            for (int i19 = 0; i19 < this.typeAlias_.size(); i19++) {
                i16 += CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(i19));
            }
            if ((this.bitField0_ & 1) == 1) {
                i16 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i16 += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = i16 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public TypeAlias getTypeAlias(int i3) {
            return this.typeAlias_.get(i3);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasVersionRequirementTable() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getFunctionCount(); i3++) {
                if (!getFunction(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i16 = 0; i16 < getPropertyCount(); i16++) {
                if (!getProperty(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i17 = 0; i17 < getTypeAliasCount(); i17++) {
                if (!getTypeAlias(i17).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            for (int i3 = 0; i3 < this.function_.size(); i3++) {
                codedOutputStream.writeMessage(3, this.function_.get(i3));
            }
            for (int i16 = 0; i16 < this.property_.size(); i16++) {
                codedOutputStream.writeMessage(4, this.property_.get(i16));
            }
            for (int i17 = 0; i17 < this.typeAlias_.size(); i17++) {
                codedOutputStream.writeMessage(5, this.typeAlias_.get(i17));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(32, this.versionRequirementTable_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Package r16) {
            return newBuilder().mergeFrom(r16);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Package getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        Package(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v8 */
        Package(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            char c16 = 0;
            while (!z16) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 26) {
                                    int i3 = (c16 == true ? 1 : 0) & 1;
                                    c16 = c16;
                                    if (i3 != 1) {
                                        this.function_ = new ArrayList();
                                        c16 = (c16 == true ? 1 : 0) | 1;
                                    }
                                    this.function_.add(codedInputStream.readMessage(Function.PARSER, extensionRegistryLite));
                                } else if (readTag == 34) {
                                    int i16 = (c16 == true ? 1 : 0) & 2;
                                    c16 = c16;
                                    if (i16 != 2) {
                                        this.property_ = new ArrayList();
                                        c16 = (c16 == true ? 1 : 0) | 2;
                                    }
                                    this.property_.add(codedInputStream.readMessage(Property.PARSER, extensionRegistryLite));
                                } else if (readTag != 42) {
                                    if (readTag == 242) {
                                        TypeTable.Builder builder = (this.bitField0_ & 1) == 1 ? this.typeTable_.toBuilder() : null;
                                        TypeTable typeTable = (TypeTable) codedInputStream.readMessage(TypeTable.PARSER, extensionRegistryLite);
                                        this.typeTable_ = typeTable;
                                        if (builder != null) {
                                            builder.mergeFrom(typeTable);
                                            this.typeTable_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 1;
                                    } else if (readTag != 258) {
                                        if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        VersionRequirementTable.Builder builder2 = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.toBuilder() : null;
                                        VersionRequirementTable versionRequirementTable = (VersionRequirementTable) codedInputStream.readMessage(VersionRequirementTable.PARSER, extensionRegistryLite);
                                        this.versionRequirementTable_ = versionRequirementTable;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(versionRequirementTable);
                                            this.versionRequirementTable_ = builder2.buildPartial();
                                        }
                                        this.bitField0_ |= 2;
                                    }
                                } else {
                                    int i17 = (c16 == true ? 1 : 0) & 4;
                                    c16 = c16;
                                    if (i17 != 4) {
                                        this.typeAlias_ = new ArrayList();
                                        c16 = (c16 == true ? 1 : 0) | 4;
                                    }
                                    this.typeAlias_.add(codedInputStream.readMessage(TypeAlias.PARSER, extensionRegistryLite));
                                }
                            }
                            z16 = true;
                        } catch (IOException e16) {
                            throw new InvalidProtocolBufferException(e16.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e17) {
                        throw e17.setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if (((c16 == true ? 1 : 0) & 1) == 1) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if (((c16 == true ? 1 : 0) & 2) == 2) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if (((c16 == true ? 1 : 0) & 4) == 4) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if (((c16 == true ? 1 : 0) & 1) == 1) {
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if (((c16 == true ? 1 : 0) & 2) == 2) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if (((c16 == true ? 1 : 0) & 4) == 4) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements PackageFragmentOrBuilder {
        public static Parser<PackageFragment> PARSER = new AbstractParser<PackageFragment>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public PackageFragment parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PackageFragment(codedInputStream, extensionRegistryLite);
            }
        };
        private static final PackageFragment defaultInstance;
        private int bitField0_;
        private List<Class> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Package package_;
        private QualifiedNameTable qualifiedNames_;
        private StringTable strings_;
        private final ByteString unknownFields;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<PackageFragment, Builder> implements PackageFragmentOrBuilder {
            private int bitField0_;
            private StringTable strings_ = StringTable.getDefaultInstance();
            private QualifiedNameTable qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            private Package package_ = Package.getDefaultInstance();
            private List<Class> class__ = Collections.emptyList();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$22600() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureClass_IsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.class__ = new ArrayList(this.class__);
                    this.bitField0_ |= 8;
                }
            }

            public PackageFragment buildPartial() {
                PackageFragment packageFragment = new PackageFragment(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) != 1) {
                    i16 = 0;
                }
                packageFragment.strings_ = this.strings_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                packageFragment.qualifiedNames_ = this.qualifiedNames_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                packageFragment.package_ = this.package_;
                if ((this.bitField0_ & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                    this.bitField0_ &= -9;
                }
                packageFragment.class__ = this.class__;
                packageFragment.bitField0_ = i16;
                return packageFragment;
            }

            public Class getClass_(int i3) {
                return this.class__.get(i3);
            }

            public int getClass_Count() {
                return this.class__.size();
            }

            public Package getPackage() {
                return this.package_;
            }

            public QualifiedNameTable getQualifiedNames() {
                return this.qualifiedNames_;
            }

            public boolean hasPackage() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            public boolean hasQualifiedNames() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                    return false;
                }
                if (hasPackage() && !getPackage().isInitialized()) {
                    return false;
                }
                for (int i3 = 0; i3 < getClass_Count(); i3++) {
                    if (!getClass_(i3).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergePackage(Package r46) {
                if ((this.bitField0_ & 4) == 4 && this.package_ != Package.getDefaultInstance()) {
                    this.package_ = Package.newBuilder(this.package_).mergeFrom(r46).buildPartial();
                } else {
                    this.package_ = r46;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeQualifiedNames(QualifiedNameTable qualifiedNameTable) {
                if ((this.bitField0_ & 2) == 2 && this.qualifiedNames_ != QualifiedNameTable.getDefaultInstance()) {
                    this.qualifiedNames_ = QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(qualifiedNameTable).buildPartial();
                } else {
                    this.qualifiedNames_ = qualifiedNameTable;
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeStrings(StringTable stringTable) {
                if ((this.bitField0_ & 1) == 1 && this.strings_ != StringTable.getDefaultInstance()) {
                    this.strings_ = StringTable.newBuilder(this.strings_).mergeFrom(stringTable).buildPartial();
                } else {
                    this.strings_ = stringTable;
                }
                this.bitField0_ |= 1;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public PackageFragment build() {
                PackageFragment buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(PackageFragment packageFragment) {
                if (packageFragment == PackageFragment.getDefaultInstance()) {
                    return this;
                }
                if (packageFragment.hasStrings()) {
                    mergeStrings(packageFragment.getStrings());
                }
                if (packageFragment.hasQualifiedNames()) {
                    mergeQualifiedNames(packageFragment.getQualifiedNames());
                }
                if (packageFragment.hasPackage()) {
                    mergePackage(packageFragment.getPackage());
                }
                if (!packageFragment.class__.isEmpty()) {
                    if (this.class__.isEmpty()) {
                        this.class__ = packageFragment.class__;
                        this.bitField0_ &= -9;
                    } else {
                        ensureClass_IsMutable();
                        this.class__.addAll(packageFragment.class__);
                    }
                }
                mergeExtensionFields(packageFragment);
                setUnknownFields(getUnknownFields().concat(packageFragment.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                PackageFragment packageFragment = null;
                try {
                    try {
                        PackageFragment parsePartialFrom = PackageFragment.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (packageFragment != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    PackageFragment packageFragment2 = (PackageFragment) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        packageFragment = packageFragment2;
                        if (packageFragment != null) {
                            mergeFrom(packageFragment);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        static {
            PackageFragment packageFragment = new PackageFragment(true);
            defaultInstance = packageFragment;
            packageFragment.initFields();
        }

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$22600();
        }

        public static PackageFragment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public Class getClass_(int i3) {
            return this.class__.get(i3);
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        public Package getPackage() {
            return this.package_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<PackageFragment> getParserForType() {
            return PARSER;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.computeMessageSize(1, this.strings_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.computeMessageSize(3, this.package_);
            }
            for (int i17 = 0; i17 < this.class__.size(); i17++) {
                i3 += CodedOutputStream.computeMessageSize(4, this.class__.get(i17));
            }
            int extensionsSerializedSize = i3 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public StringTable getStrings() {
            return this.strings_;
        }

        public boolean hasPackage() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean hasQualifiedNames() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean hasStrings() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasPackage() && !getPackage().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getClass_Count(); i3++) {
                if (!getClass_(i3).isInitialized()) {
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.package_);
            }
            for (int i3 = 0; i3 < this.class__.size(); i3++) {
                codedOutputStream.writeMessage(4, this.class__.get(i3));
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(PackageFragment packageFragment) {
            return newBuilder().mergeFrom(packageFragment);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public PackageFragment getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        PackageFragment(GeneratedMessageLite.ExtendableBuilder<PackageFragment, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        PackageFragment(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v4 */
        PackageFragment(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            char c16 = 0;
            while (!z16) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    StringTable.Builder builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : null;
                                    StringTable stringTable = (StringTable) codedInputStream.readMessage(StringTable.PARSER, extensionRegistryLite);
                                    this.strings_ = stringTable;
                                    if (builder != null) {
                                        builder.mergeFrom(stringTable);
                                        this.strings_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (readTag == 18) {
                                    QualifiedNameTable.Builder builder2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : null;
                                    QualifiedNameTable qualifiedNameTable = (QualifiedNameTable) codedInputStream.readMessage(QualifiedNameTable.PARSER, extensionRegistryLite);
                                    this.qualifiedNames_ = qualifiedNameTable;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(qualifiedNameTable);
                                        this.qualifiedNames_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (readTag == 26) {
                                    Package.Builder builder3 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : null;
                                    Package r65 = (Package) codedInputStream.readMessage(Package.PARSER, extensionRegistryLite);
                                    this.package_ = r65;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(r65);
                                        this.package_ = builder3.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (readTag != 34) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    int i3 = (c16 == true ? 1 : 0) & 8;
                                    c16 = c16;
                                    if (i3 != 8) {
                                        this.class__ = new ArrayList();
                                        c16 = (c16 == true ? 1 : 0) | '\b';
                                    }
                                    this.class__.add(codedInputStream.readMessage(Class.PARSER, extensionRegistryLite));
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        }
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if (((c16 == true ? 1 : 0) & 8) == 8) {
                        this.class__ = Collections.unmodifiableList(this.class__);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if (((c16 == true ? 1 : 0) & 8) == 8) {
                this.class__ = Collections.unmodifiableList(this.class__);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface PackageFragmentOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public interface PackageOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements PropertyOrBuilder {
        public static Parser<Property> PARSER = new AbstractParser<Property>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Property parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Property(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Property defaultInstance;
        private int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private int flags_;
        private int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private int setterFlags_;
        private ValueParameter setterValueParameter_;
        private List<TypeParameter> typeParameter_;
        private final ByteString unknownFields;
        private List<Integer> versionRequirement_;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Property, Builder> implements PropertyOrBuilder {
            private int bitField0_;
            private int getterFlags_;
            private int name_;
            private int receiverTypeId_;
            private int returnTypeId_;
            private int setterFlags_;
            private int flags_ = WnsNetworkConst.WRITE_FAIL;
            private int oldFlags_ = 2054;
            private Type returnType_ = Type.getDefaultInstance();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type receiverType_ = Type.getDefaultInstance();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private ValueParameter setterValueParameter_ = ValueParameter.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$16000() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 512;
                }
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 256;
                }
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 8192) != 8192) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 8192;
                }
            }

            public Property buildPartial() {
                Property property = new Property(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) != 1) {
                    i16 = 0;
                }
                property.flags_ = this.flags_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                property.oldFlags_ = this.oldFlags_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                property.name_ = this.name_;
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                property.returnType_ = this.returnType_;
                if ((i3 & 16) == 16) {
                    i16 |= 16;
                }
                property.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -33;
                }
                property.typeParameter_ = this.typeParameter_;
                if ((i3 & 64) == 64) {
                    i16 |= 32;
                }
                property.receiverType_ = this.receiverType_;
                if ((i3 & 128) == 128) {
                    i16 |= 64;
                }
                property.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -257;
                }
                property.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -513;
                }
                property.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((i3 & 1024) == 1024) {
                    i16 |= 128;
                }
                property.setterValueParameter_ = this.setterValueParameter_;
                if ((i3 & 2048) == 2048) {
                    i16 |= 256;
                }
                property.getterFlags_ = this.getterFlags_;
                if ((i3 & 4096) == 4096) {
                    i16 |= 512;
                }
                property.setterFlags_ = this.setterFlags_;
                if ((this.bitField0_ & 8192) == 8192) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -8193;
                }
                property.versionRequirement_ = this.versionRequirement_;
                property.bitField0_ = i16;
                return property;
            }

            public Type getContextReceiverType(int i3) {
                return this.contextReceiverType_.get(i3);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public ValueParameter getSetterValueParameter() {
                return this.setterValueParameter_;
            }

            public TypeParameter getTypeParameter(int i3) {
                return this.typeParameter_.get(i3);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public boolean hasName() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            public boolean hasReceiverType() {
                if ((this.bitField0_ & 64) == 64) {
                    return true;
                }
                return false;
            }

            public boolean hasReturnType() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            public boolean hasSetterValueParameter() {
                if ((this.bitField0_ & 1024) == 1024) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasReturnType() && !getReturnType().isInitialized()) {
                    return false;
                }
                for (int i3 = 0; i3 < getTypeParameterCount(); i3++) {
                    if (!getTypeParameter(i3).isInitialized()) {
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    return false;
                }
                for (int i16 = 0; i16 < getContextReceiverTypeCount(); i16++) {
                    if (!getContextReceiverType(i16).isInitialized()) {
                        return false;
                    }
                }
                if ((hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) || !extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeReceiverType(Type type) {
                if ((this.bitField0_ & 64) == 64 && this.receiverType_ != Type.getDefaultInstance()) {
                    this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(type).buildPartial();
                } else {
                    this.receiverType_ = type;
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeReturnType(Type type) {
                if ((this.bitField0_ & 8) == 8 && this.returnType_ != Type.getDefaultInstance()) {
                    this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(type).buildPartial();
                } else {
                    this.returnType_ = type;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeSetterValueParameter(ValueParameter valueParameter) {
                if ((this.bitField0_ & 1024) == 1024 && this.setterValueParameter_ != ValueParameter.getDefaultInstance()) {
                    this.setterValueParameter_ = ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(valueParameter).buildPartial();
                } else {
                    this.setterValueParameter_ = valueParameter;
                }
                this.bitField0_ |= 1024;
                return this;
            }

            public Builder setFlags(int i3) {
                this.bitField0_ |= 1;
                this.flags_ = i3;
                return this;
            }

            public Builder setGetterFlags(int i3) {
                this.bitField0_ |= 2048;
                this.getterFlags_ = i3;
                return this;
            }

            public Builder setName(int i3) {
                this.bitField0_ |= 4;
                this.name_ = i3;
                return this;
            }

            public Builder setOldFlags(int i3) {
                this.bitField0_ |= 2;
                this.oldFlags_ = i3;
                return this;
            }

            public Builder setReceiverTypeId(int i3) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i3;
                return this;
            }

            public Builder setReturnTypeId(int i3) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = i3;
                return this;
            }

            public Builder setSetterFlags(int i3) {
                this.bitField0_ |= 4096;
                this.setterFlags_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Property build() {
                Property buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Property property) {
                if (property == Property.getDefaultInstance()) {
                    return this;
                }
                if (property.hasFlags()) {
                    setFlags(property.getFlags());
                }
                if (property.hasOldFlags()) {
                    setOldFlags(property.getOldFlags());
                }
                if (property.hasName()) {
                    setName(property.getName());
                }
                if (property.hasReturnType()) {
                    mergeReturnType(property.getReturnType());
                }
                if (property.hasReturnTypeId()) {
                    setReturnTypeId(property.getReturnTypeId());
                }
                if (!property.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = property.typeParameter_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(property.typeParameter_);
                    }
                }
                if (property.hasReceiverType()) {
                    mergeReceiverType(property.getReceiverType());
                }
                if (property.hasReceiverTypeId()) {
                    setReceiverTypeId(property.getReceiverTypeId());
                }
                if (!property.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = property.contextReceiverType_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(property.contextReceiverType_);
                    }
                }
                if (!property.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = property.contextReceiverTypeId_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(property.contextReceiverTypeId_);
                    }
                }
                if (property.hasSetterValueParameter()) {
                    mergeSetterValueParameter(property.getSetterValueParameter());
                }
                if (property.hasGetterFlags()) {
                    setGetterFlags(property.getGetterFlags());
                }
                if (property.hasSetterFlags()) {
                    setSetterFlags(property.getSetterFlags());
                }
                if (!property.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = property.versionRequirement_;
                        this.bitField0_ &= -8193;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(property.versionRequirement_);
                    }
                }
                mergeExtensionFields(property);
                setUnknownFields(getUnknownFields().concat(property.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Property property = null;
                try {
                    try {
                        Property parsePartialFrom = Property.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (property != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    Property property2 = (Property) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        property = property2;
                        if (property != null) {
                            mergeFrom(property);
                        }
                        throw th;
                    }
                }
            }
        }

        static {
            Property property = new Property(true);
            defaultInstance = property;
            property.initFields();
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = WnsNetworkConst.WRITE_FAIL;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$16000();
        }

        public Type getContextReceiverType(int i3) {
            return this.contextReceiverType_.get(i3);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Property> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (int i17 = 0; i17 < this.typeParameter_.size(); i17++) {
                i3 += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i17));
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i3 += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i3 += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i3 += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i3 += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 += CodedOutputStream.computeInt32Size(11, this.flags_);
            }
            for (int i18 = 0; i18 < this.contextReceiverType_.size(); i18++) {
                i3 += CodedOutputStream.computeMessageSize(12, this.contextReceiverType_.get(i18));
            }
            int i19 = 0;
            for (int i26 = 0; i26 < this.contextReceiverTypeId_.size(); i26++) {
                i19 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i26).intValue());
            }
            int i27 = i3 + i19;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i27 = i27 + 1 + CodedOutputStream.computeInt32SizeNoTag(i19);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i19;
            int i28 = 0;
            for (int i29 = 0; i29 < this.versionRequirement_.size(); i29++) {
                i28 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i29).intValue());
            }
            int size = i27 + i28 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public TypeParameter getTypeParameter(int i3) {
            return this.typeParameter_.get(i3);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasGetterFlags() {
            if ((this.bitField0_ & 256) == 256) {
                return true;
            }
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean hasOldFlags() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean hasReceiverType() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        public boolean hasReceiverTypeId() {
            if ((this.bitField0_ & 64) == 64) {
                return true;
            }
            return false;
        }

        public boolean hasReturnType() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        public boolean hasReturnTypeId() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        public boolean hasSetterFlags() {
            if ((this.bitField0_ & 512) == 512) {
                return true;
            }
            return false;
        }

        public boolean hasSetterValueParameter() {
            if ((this.bitField0_ & 128) == 128) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getTypeParameterCount(); i3++) {
                if (!getTypeParameter(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasReceiverType() && !getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i16 = 0; i16 < getContextReceiverTypeCount(); i16++) {
                if (!getContextReceiverType(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(3, this.returnType_);
            }
            for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
                codedOutputStream.writeMessage(4, this.typeParameter_.get(i3));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(11, this.flags_);
            }
            for (int i16 = 0; i16 < this.contextReceiverType_.size(); i16++) {
                codedOutputStream.writeMessage(12, this.contextReceiverType_.get(i16));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(106);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i17 = 0; i17 < this.contextReceiverTypeId_.size(); i17++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i17).intValue());
            }
            for (int i18 = 0; i18 < this.versionRequirement_.size(); i18++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i18).intValue());
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Property property) {
            return newBuilder().mergeFrom(property);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> extendableBuilder) {
            super(extendableBuilder);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        Property(boolean z16) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0027. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v14 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        Property(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            char c16 = 0;
            while (true) {
                ?? r56 = 256;
                if (!z16) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        z16 = true;
                                    case 8:
                                        this.bitField0_ |= 2;
                                        this.oldFlags_ = codedInputStream.readInt32();
                                    case 16:
                                        this.bitField0_ |= 4;
                                        this.name_ = codedInputStream.readInt32();
                                    case 26:
                                        Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                        Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.returnType_ = type;
                                        if (builder != null) {
                                            builder.mergeFrom(type);
                                            this.returnType_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 8;
                                    case 34:
                                        int i3 = (c16 == true ? 1 : 0) & 32;
                                        c16 = c16;
                                        if (i3 != 32) {
                                            this.typeParameter_ = new ArrayList();
                                            c16 = (c16 == true ? 1 : 0) | TokenParser.SP;
                                        }
                                        this.typeParameter_.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                                    case 42:
                                        Type.Builder builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                        Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.receiverType_ = type2;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(type2);
                                            this.receiverType_ = builder2.buildPartial();
                                        }
                                        this.bitField0_ |= 32;
                                    case 50:
                                        ValueParameter.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                                        ValueParameter valueParameter = (ValueParameter) codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite);
                                        this.setterValueParameter_ = valueParameter;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(valueParameter);
                                            this.setterValueParameter_ = builder3.buildPartial();
                                        }
                                        this.bitField0_ |= 128;
                                    case 56:
                                        this.bitField0_ |= 256;
                                        this.getterFlags_ = codedInputStream.readInt32();
                                    case 64:
                                        this.bitField0_ |= 512;
                                        this.setterFlags_ = codedInputStream.readInt32();
                                    case 72:
                                        this.bitField0_ |= 16;
                                        this.returnTypeId_ = codedInputStream.readInt32();
                                    case 80:
                                        this.bitField0_ |= 64;
                                        this.receiverTypeId_ = codedInputStream.readInt32();
                                    case 88:
                                        this.bitField0_ |= 1;
                                        this.flags_ = codedInputStream.readInt32();
                                    case 98:
                                        int i16 = (c16 == true ? 1 : 0) & 256;
                                        c16 = c16;
                                        if (i16 != 256) {
                                            this.contextReceiverType_ = new ArrayList();
                                            c16 = (c16 == true ? 1 : 0) | '\u0100';
                                        }
                                        this.contextReceiverType_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                    case 104:
                                        int i17 = (c16 == true ? 1 : 0) & 512;
                                        c16 = c16;
                                        if (i17 != 512) {
                                            this.contextReceiverTypeId_ = new ArrayList();
                                            c16 = (c16 == true ? 1 : 0) | '\u0200';
                                        }
                                        this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    case 106:
                                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        int i18 = (c16 == true ? 1 : 0) & 512;
                                        c16 = c16;
                                        if (i18 != 512) {
                                            c16 = c16;
                                            if (codedInputStream.getBytesUntilLimit() > 0) {
                                                this.contextReceiverTypeId_ = new ArrayList();
                                                c16 = (c16 == true ? 1 : 0) | '\u0200';
                                            }
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                        }
                                        codedInputStream.popLimit(pushLimit);
                                    case 248:
                                        int i19 = (c16 == true ? 1 : 0) & 8192;
                                        c16 = c16;
                                        if (i19 != 8192) {
                                            this.versionRequirement_ = new ArrayList();
                                            c16 = (c16 == true ? 1 : 0) | '\u2000';
                                        }
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    case 250:
                                        int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        int i26 = (c16 == true ? 1 : 0) & 8192;
                                        c16 = c16;
                                        if (i26 != 8192) {
                                            c16 = c16;
                                            if (codedInputStream.getBytesUntilLimit() > 0) {
                                                this.versionRequirement_ = new ArrayList();
                                                c16 = (c16 == true ? 1 : 0) | '\u2000';
                                            }
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                        }
                                        codedInputStream.popLimit(pushLimit2);
                                    default:
                                        r56 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                        if (r56 == 0) {
                                            z16 = true;
                                        }
                                }
                            } catch (IOException e16) {
                                throw new InvalidProtocolBufferException(e16.getMessage()).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e17) {
                            throw e17.setUnfinishedMessage(this);
                        }
                    } catch (Throwable th5) {
                        if (((c16 == true ? 1 : 0) & 32) == 32) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if (((c16 == true ? 1 : 0) & 256) == r56) {
                            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                        }
                        if (((c16 == true ? 1 : 0) & 512) == 512) {
                            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                        }
                        if (((c16 == true ? 1 : 0) & 8192) == 8192) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                        }
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th6) {
                            this.unknownFields = newOutput.toByteString();
                            throw th6;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th5;
                    }
                } else {
                    if (((c16 == true ? 1 : 0) & 32) == 32) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (((c16 == true ? 1 : 0) & 256) == 256) {
                        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    }
                    if (((c16 == true ? 1 : 0) & 512) == 512) {
                        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    }
                    if (((c16 == true ? 1 : 0) & 8192) == 8192) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused2) {
                    } catch (Throwable th7) {
                        this.unknownFields = newOutput.toByteString();
                        throw th7;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    return;
                }
            }
        }
    }

    /* loaded from: classes28.dex */
    public interface PropertyOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class QualifiedNameTable extends GeneratedMessageLite implements QualifiedNameTableOrBuilder {
        public static Parser<QualifiedNameTable> PARSER = new AbstractParser<QualifiedNameTable>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public QualifiedNameTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new QualifiedNameTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final QualifiedNameTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<QualifiedName> qualifiedName_;
        private final ByteString unknownFields;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<QualifiedNameTable, Builder> implements QualifiedNameTableOrBuilder {
            private int bitField0_;
            private List<QualifiedName> qualifiedName_ = Collections.emptyList();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$1400() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureQualifiedNameIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.qualifiedName_ = new ArrayList(this.qualifiedName_);
                    this.bitField0_ |= 1;
                }
            }

            public QualifiedNameTable buildPartial() {
                QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                    this.bitField0_ &= -2;
                }
                qualifiedNameTable.qualifiedName_ = this.qualifiedName_;
                return qualifiedNameTable;
            }

            public QualifiedName getQualifiedName(int i3) {
                return this.qualifiedName_.get(i3);
            }

            public int getQualifiedNameCount() {
                return this.qualifiedName_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i3 = 0; i3 < getQualifiedNameCount(); i3++) {
                    if (!getQualifiedName(i3).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public QualifiedNameTable build() {
                QualifiedNameTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(QualifiedNameTable qualifiedNameTable) {
                if (qualifiedNameTable == QualifiedNameTable.getDefaultInstance()) {
                    return this;
                }
                if (!qualifiedNameTable.qualifiedName_.isEmpty()) {
                    if (this.qualifiedName_.isEmpty()) {
                        this.qualifiedName_ = qualifiedNameTable.qualifiedName_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureQualifiedNameIsMutable();
                        this.qualifiedName_.addAll(qualifiedNameTable.qualifiedName_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(qualifiedNameTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                QualifiedNameTable qualifiedNameTable = null;
                try {
                    try {
                        QualifiedNameTable parsePartialFrom = QualifiedNameTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (qualifiedNameTable != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    QualifiedNameTable qualifiedNameTable2 = (QualifiedNameTable) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        qualifiedNameTable = qualifiedNameTable2;
                        if (qualifiedNameTable != null) {
                            mergeFrom(qualifiedNameTable);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        /* loaded from: classes28.dex */
        public static final class QualifiedName extends GeneratedMessageLite implements QualifiedNameOrBuilder {
            public static Parser<QualifiedName> PARSER = new AbstractParser<QualifiedName>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.1
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                public QualifiedName parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new QualifiedName(codedInputStream, extensionRegistryLite);
                }
            };
            private static final QualifiedName defaultInstance;
            private int bitField0_;
            private Kind kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int parentQualifiedName_;
            private int shortName_;
            private final ByteString unknownFields;

            /* loaded from: classes28.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<QualifiedName, Builder> implements QualifiedNameOrBuilder {
                private int bitField0_;
                private int shortName_;
                private int parentQualifiedName_ = -1;
                private Kind kind_ = Kind.PACKAGE;

                Builder() {
                    maybeForceBuilderInitialization();
                }

                static /* synthetic */ Builder access$700() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                public QualifiedName buildPartial() {
                    QualifiedName qualifiedName = new QualifiedName(this);
                    int i3 = this.bitField0_;
                    int i16 = 1;
                    if ((i3 & 1) != 1) {
                        i16 = 0;
                    }
                    qualifiedName.parentQualifiedName_ = this.parentQualifiedName_;
                    if ((i3 & 2) == 2) {
                        i16 |= 2;
                    }
                    qualifiedName.shortName_ = this.shortName_;
                    if ((i3 & 4) == 4) {
                        i16 |= 4;
                    }
                    qualifiedName.kind_ = this.kind_;
                    qualifiedName.bitField0_ = i16;
                    return qualifiedName;
                }

                public boolean hasShortName() {
                    if ((this.bitField0_ & 2) == 2) {
                        return true;
                    }
                    return false;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (!hasShortName()) {
                        return false;
                    }
                    return true;
                }

                public Builder setKind(Kind kind) {
                    kind.getClass();
                    this.bitField0_ |= 4;
                    this.kind_ = kind;
                    return this;
                }

                public Builder setParentQualifiedName(int i3) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = i3;
                    return this;
                }

                public Builder setShortName(int i3) {
                    this.bitField0_ |= 2;
                    this.shortName_ = i3;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public QualifiedName build() {
                    QualifiedName buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public Builder mo1777clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(QualifiedName qualifiedName) {
                    if (qualifiedName == QualifiedName.getDefaultInstance()) {
                        return this;
                    }
                    if (qualifiedName.hasParentQualifiedName()) {
                        setParentQualifiedName(qualifiedName.getParentQualifiedName());
                    }
                    if (qualifiedName.hasShortName()) {
                        setShortName(qualifiedName.getShortName());
                    }
                    if (qualifiedName.hasKind()) {
                        setKind(qualifiedName.getKind());
                    }
                    setUnknownFields(getUnknownFields().concat(qualifiedName.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    QualifiedName qualifiedName = null;
                    try {
                        try {
                            QualifiedName parsePartialFrom = QualifiedName.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (Throwable th5) {
                            th = th5;
                            if (qualifiedName != null) {
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        QualifiedName qualifiedName2 = (QualifiedName) e16.getUnfinishedMessage();
                        try {
                            throw e16;
                        } catch (Throwable th6) {
                            th = th6;
                            qualifiedName = qualifiedName2;
                            if (qualifiedName != null) {
                                mergeFrom(qualifiedName);
                            }
                            throw th;
                        }
                    }
                }

                private void maybeForceBuilderInitialization() {
                }
            }

            /* loaded from: classes28.dex */
            public enum Kind implements Internal.EnumLite {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);

                private static Internal.EnumLiteMap<Kind> internalValueMap = new Internal.EnumLiteMap<Kind>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                    public Kind findValueByNumber(int i3) {
                        return Kind.valueOf(i3);
                    }
                };
                private final int value;

                Kind(int i3, int i16) {
                    this.value = i16;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int i3) {
                    if (i3 == 0) {
                        return CLASS;
                    }
                    if (i3 == 1) {
                        return PACKAGE;
                    }
                    if (i3 != 2) {
                        return null;
                    }
                    return LOCAL;
                }
            }

            static {
                QualifiedName qualifiedName = new QualifiedName(true);
                defaultInstance = qualifiedName;
                qualifiedName.initFields();
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            public static Builder newBuilder() {
                return Builder.access$700();
            }

            public Kind getKind() {
                return this.kind_;
            }

            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<QualifiedName> getParserForType() {
                return PARSER;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int i3 = this.memoizedSerializedSize;
                if (i3 != -1) {
                    return i3;
                }
                int i16 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i16 = 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i16 += CodedOutputStream.computeInt32Size(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i16 += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
                }
                int size = i16 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public int getShortName() {
                return this.shortName_;
            }

            public boolean hasKind() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            public boolean hasParentQualifiedName() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            public boolean hasShortName() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b16 = this.memoizedIsInitialized;
                if (b16 == 1) {
                    return true;
                }
                if (b16 == 0) {
                    return false;
                }
                if (!hasShortName()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeEnum(3, this.kind_.getNumber());
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public static Builder newBuilder(QualifiedName qualifiedName) {
                return newBuilder().mergeFrom(qualifiedName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedName getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            QualifiedName(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            QualifiedName(boolean z16) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            QualifiedName(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                boolean z16 = false;
                while (!z16) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.parentQualifiedName_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.shortName_ = codedInputStream.readInt32();
                                } else if (readTag != 24) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    int readEnum = codedInputStream.readEnum();
                                    Kind valueOf = Kind.valueOf(readEnum);
                                    if (valueOf == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.kind_ = valueOf;
                                    }
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        } catch (IOException e17) {
                            throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th5) {
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th6) {
                            this.unknownFields = newOutput.toByteString();
                            throw th6;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th5;
                    }
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th7) {
                    this.unknownFields = newOutput.toByteString();
                    throw th7;
                }
                this.unknownFields = newOutput.toByteString();
                makeExtensionsImmutable();
            }
        }

        /* loaded from: classes28.dex */
        public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(true);
            defaultInstance = qualifiedNameTable;
            qualifiedNameTable.initFields();
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.qualifiedName_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$1400();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public QualifiedName getQualifiedName(int i3) {
            return this.qualifiedName_.get(i3);
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.qualifiedName_.size(); i17++) {
                i16 += CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(i17));
            }
            int size = i16 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getQualifiedNameCount(); i3++) {
                if (!getQualifiedName(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i3 = 0; i3 < this.qualifiedName_.size(); i3++) {
                codedOutputStream.writeMessage(1, this.qualifiedName_.get(i3));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(QualifiedNameTable qualifiedNameTable) {
            return newBuilder().mergeFrom(qualifiedNameTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public QualifiedNameTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        QualifiedNameTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        QualifiedNameTable(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        QualifiedNameTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 10) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z17 & true)) {
                                    this.qualifiedName_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.qualifiedName_.add(codedInputStream.readMessage(QualifiedName.PARSER, extensionRegistryLite));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if (z17 & true) {
                        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if (z17 & true) {
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface QualifiedNameTableOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class StringTable extends GeneratedMessageLite implements StringTableOrBuilder {
        public static Parser<StringTable> PARSER = new AbstractParser<StringTable>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public StringTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final StringTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private LazyStringList string_;
        private final ByteString unknownFields;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<StringTable, Builder> implements StringTableOrBuilder {
            private int bitField0_;
            private LazyStringList string_ = LazyStringArrayList.EMPTY;

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$100() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureStringIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.string_ = new LazyStringArrayList(this.string_);
                    this.bitField0_ |= 1;
                }
            }

            public StringTable buildPartial() {
                StringTable stringTable = new StringTable(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.string_ = this.string_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                stringTable.string_ = this.string_;
                return stringTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public StringTable build() {
                StringTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(StringTable stringTable) {
                if (stringTable == StringTable.getDefaultInstance()) {
                    return this;
                }
                if (!stringTable.string_.isEmpty()) {
                    if (this.string_.isEmpty()) {
                        this.string_ = stringTable.string_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureStringIsMutable();
                        this.string_.addAll(stringTable.string_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(stringTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                StringTable stringTable = null;
                try {
                    try {
                        StringTable parsePartialFrom = StringTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (stringTable != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    StringTable stringTable2 = (StringTable) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        stringTable = stringTable2;
                        if (stringTable != null) {
                            mergeFrom(stringTable);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        static {
            StringTable stringTable = new StringTable(true);
            defaultInstance = stringTable;
            stringTable.initFields();
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.string_ = LazyStringArrayList.EMPTY;
        }

        public static Builder newBuilder() {
            return Builder.access$100();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<StringTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.string_.size(); i17++) {
                i16 += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i17));
            }
            int size = 0 + i16 + (getStringList().size() * 1) + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public String getString(int i3) {
            return this.string_.get(i3);
        }

        public ProtocolStringList getStringList() {
            return this.string_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i3 = 0; i3 < this.string_.size(); i3++) {
                codedOutputStream.writeBytes(1, this.string_.getByteString(i3));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(StringTable stringTable) {
            return newBuilder().mergeFrom(stringTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        StringTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        StringTable(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        StringTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag != 10) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    ByteString readBytes = codedInputStream.readBytes();
                                    if (!(z17 & true)) {
                                        this.string_ = new LazyStringArrayList();
                                        z17 |= true;
                                    }
                                    this.string_.add(readBytes);
                                }
                            }
                            z16 = true;
                        } catch (IOException e16) {
                            throw new InvalidProtocolBufferException(e16.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e17) {
                        throw e17.setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if (z17 & true) {
                        this.string_ = this.string_.getUnmodifiableView();
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if (z17 & true) {
                this.string_ = this.string_.getUnmodifiableView();
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface StringTableOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements TypeOrBuilder {
        public static Parser<Type> PARSER = new AbstractParser<Type>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Type parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Type(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Type defaultInstance;
        private int abbreviatedTypeId_;
        private Type abbreviatedType_;
        private List<Argument> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean nullable_;
        private int outerTypeId_;
        private Type outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private final ByteString unknownFields;

        /* loaded from: classes28.dex */
        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER = new AbstractParser<Argument>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.1
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Argument(codedInputStream, extensionRegistryLite);
                }
            };
            private static final Argument defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Projection projection_;
            private int typeId_;
            private Type type_;
            private final ByteString unknownFields;

            /* loaded from: classes28.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private int typeId_;
                private Projection projection_ = Projection.INV;
                private Type type_ = Type.getDefaultInstance();

                Builder() {
                    maybeForceBuilderInitialization();
                }

                static /* synthetic */ Builder access$5000() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                public Argument buildPartial() {
                    Argument argument = new Argument(this);
                    int i3 = this.bitField0_;
                    int i16 = 1;
                    if ((i3 & 1) != 1) {
                        i16 = 0;
                    }
                    argument.projection_ = this.projection_;
                    if ((i3 & 2) == 2) {
                        i16 |= 2;
                    }
                    argument.type_ = this.type_;
                    if ((i3 & 4) == 4) {
                        i16 |= 4;
                    }
                    argument.typeId_ = this.typeId_;
                    argument.bitField0_ = i16;
                    return argument;
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    if ((this.bitField0_ & 2) == 2) {
                        return true;
                    }
                    return false;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasType() && !getType().isInitialized()) {
                        return false;
                    }
                    return true;
                }

                public Builder mergeType(Type type) {
                    if ((this.bitField0_ & 2) == 2 && this.type_ != Type.getDefaultInstance()) {
                        this.type_ = Type.newBuilder(this.type_).mergeFrom(type).buildPartial();
                    } else {
                        this.type_ = type;
                    }
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder setProjection(Projection projection) {
                    projection.getClass();
                    this.bitField0_ |= 1;
                    this.projection_ = projection;
                    return this;
                }

                public Builder setTypeId(int i3) {
                    this.bitField0_ |= 4;
                    this.typeId_ = i3;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public Builder mo1777clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasProjection()) {
                        setProjection(argument.getProjection());
                    }
                    if (argument.hasType()) {
                        mergeType(argument.getType());
                    }
                    if (argument.hasTypeId()) {
                        setTypeId(argument.getTypeId());
                    }
                    setUnknownFields(getUnknownFields().concat(argument.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Argument argument = null;
                    try {
                        try {
                            Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (Throwable th5) {
                            th = th5;
                            if (argument != null) {
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        Argument argument2 = (Argument) e16.getUnfinishedMessage();
                        try {
                            throw e16;
                        } catch (Throwable th6) {
                            th = th6;
                            argument = argument2;
                            if (argument != null) {
                                mergeFrom(argument);
                            }
                            throw th;
                        }
                    }
                }

                private void maybeForceBuilderInitialization() {
                }
            }

            /* loaded from: classes28.dex */
            public enum Projection implements Internal.EnumLite {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);

                private static Internal.EnumLiteMap<Projection> internalValueMap = new Internal.EnumLiteMap<Projection>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                    public Projection findValueByNumber(int i3) {
                        return Projection.valueOf(i3);
                    }
                };
                private final int value;

                Projection(int i3, int i16) {
                    this.value = i16;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int i3) {
                    if (i3 == 0) {
                        return IN;
                    }
                    if (i3 == 1) {
                        return OUT;
                    }
                    if (i3 == 2) {
                        return INV;
                    }
                    if (i3 != 3) {
                        return null;
                    }
                    return STAR;
                }
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
            }

            public static Builder newBuilder() {
                return Builder.access$5000();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public Projection getProjection() {
                return this.projection_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int i3 = this.memoizedSerializedSize;
                if (i3 != -1) {
                    return i3;
                }
                int i16 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i16 = 0 + CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    i16 += CodedOutputStream.computeMessageSize(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i16 += CodedOutputStream.computeInt32Size(3, this.typeId_);
                }
                int size = i16 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public Type getType() {
                return this.type_;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            public boolean hasProjection() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            public boolean hasType() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            public boolean hasTypeId() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b16 = this.memoizedIsInitialized;
                if (b16 == 1) {
                    return true;
                }
                if (b16 == 0) {
                    return false;
                }
                if (hasType() && !getType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeInt32(3, this.typeId_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public static Builder newBuilder(Argument argument) {
                return newBuilder().mergeFrom(argument);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            Argument(boolean z16) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                boolean z16 = false;
                while (!z16) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        int readEnum = codedInputStream.readEnum();
                                        Projection valueOf = Projection.valueOf(readEnum);
                                        if (valueOf == null) {
                                            newInstance.writeRawVarint32(readTag);
                                            newInstance.writeRawVarint32(readEnum);
                                        } else {
                                            this.bitField0_ |= 1;
                                            this.projection_ = valueOf;
                                        }
                                    } else if (readTag == 18) {
                                        Builder builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                        Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.type_ = type;
                                        if (builder != null) {
                                            builder.mergeFrom(type);
                                            this.type_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 2;
                                    } else if (readTag != 24) {
                                        if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.typeId_ = codedInputStream.readInt32();
                                    }
                                }
                                z16 = true;
                            } catch (InvalidProtocolBufferException e16) {
                                throw e16.setUnfinishedMessage(this);
                            }
                        } catch (IOException e17) {
                            throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th5) {
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th6) {
                            this.unknownFields = newOutput.toByteString();
                            throw th6;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th5;
                    }
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th7) {
                    this.unknownFields = newOutput.toByteString();
                    throw th7;
                }
                this.unknownFields = newOutput.toByteString();
                makeExtensionsImmutable();
            }
        }

        /* loaded from: classes28.dex */
        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Type, Builder> implements TypeOrBuilder {
            private int abbreviatedTypeId_;
            private int bitField0_;
            private int className_;
            private int flags_;
            private int flexibleTypeCapabilitiesId_;
            private int flexibleUpperBoundId_;
            private boolean nullable_;
            private int outerTypeId_;
            private int typeAliasName_;
            private int typeParameterName_;
            private int typeParameter_;
            private List<Argument> argument_ = Collections.emptyList();
            private Type flexibleUpperBound_ = Type.getDefaultInstance();
            private Type outerType_ = Type.getDefaultInstance();
            private Type abbreviatedType_ = Type.getDefaultInstance();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$5700() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.argument_ = new ArrayList(this.argument_);
                    this.bitField0_ |= 1;
                }
            }

            public Type buildPartial() {
                Type type = new Type(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) == 1) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= -2;
                }
                type.argument_ = this.argument_;
                if ((i3 & 2) != 2) {
                    i16 = 0;
                }
                type.nullable_ = this.nullable_;
                if ((i3 & 4) == 4) {
                    i16 |= 2;
                }
                type.flexibleTypeCapabilitiesId_ = this.flexibleTypeCapabilitiesId_;
                if ((i3 & 8) == 8) {
                    i16 |= 4;
                }
                type.flexibleUpperBound_ = this.flexibleUpperBound_;
                if ((i3 & 16) == 16) {
                    i16 |= 8;
                }
                type.flexibleUpperBoundId_ = this.flexibleUpperBoundId_;
                if ((i3 & 32) == 32) {
                    i16 |= 16;
                }
                type.className_ = this.className_;
                if ((i3 & 64) == 64) {
                    i16 |= 32;
                }
                type.typeParameter_ = this.typeParameter_;
                if ((i3 & 128) == 128) {
                    i16 |= 64;
                }
                type.typeParameterName_ = this.typeParameterName_;
                if ((i3 & 256) == 256) {
                    i16 |= 128;
                }
                type.typeAliasName_ = this.typeAliasName_;
                if ((i3 & 512) == 512) {
                    i16 |= 256;
                }
                type.outerType_ = this.outerType_;
                if ((i3 & 1024) == 1024) {
                    i16 |= 512;
                }
                type.outerTypeId_ = this.outerTypeId_;
                if ((i3 & 2048) == 2048) {
                    i16 |= 1024;
                }
                type.abbreviatedType_ = this.abbreviatedType_;
                if ((i3 & 4096) == 4096) {
                    i16 |= 2048;
                }
                type.abbreviatedTypeId_ = this.abbreviatedTypeId_;
                if ((i3 & 8192) == 8192) {
                    i16 |= 4096;
                }
                type.flags_ = this.flags_;
                type.bitField0_ = i16;
                return type;
            }

            public Type getAbbreviatedType() {
                return this.abbreviatedType_;
            }

            public Argument getArgument(int i3) {
                return this.argument_.get(i3);
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public Type getFlexibleUpperBound() {
                return this.flexibleUpperBound_;
            }

            public Type getOuterType() {
                return this.outerType_;
            }

            public boolean hasAbbreviatedType() {
                if ((this.bitField0_ & 2048) == 2048) {
                    return true;
                }
                return false;
            }

            public boolean hasFlexibleUpperBound() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            public boolean hasOuterType() {
                if ((this.bitField0_ & 512) == 512) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i3 = 0; i3 < getArgumentCount(); i3++) {
                    if (!getArgument(i3).isInitialized()) {
                        return false;
                    }
                }
                if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                    return false;
                }
                if (hasOuterType() && !getOuterType().isInitialized()) {
                    return false;
                }
                if ((hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) || !extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeAbbreviatedType(Type type) {
                if ((this.bitField0_ & 2048) == 2048 && this.abbreviatedType_ != Type.getDefaultInstance()) {
                    this.abbreviatedType_ = Type.newBuilder(this.abbreviatedType_).mergeFrom(type).buildPartial();
                } else {
                    this.abbreviatedType_ = type;
                }
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder mergeFlexibleUpperBound(Type type) {
                if ((this.bitField0_ & 8) == 8 && this.flexibleUpperBound_ != Type.getDefaultInstance()) {
                    this.flexibleUpperBound_ = Type.newBuilder(this.flexibleUpperBound_).mergeFrom(type).buildPartial();
                } else {
                    this.flexibleUpperBound_ = type;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeOuterType(Type type) {
                if ((this.bitField0_ & 512) == 512 && this.outerType_ != Type.getDefaultInstance()) {
                    this.outerType_ = Type.newBuilder(this.outerType_).mergeFrom(type).buildPartial();
                } else {
                    this.outerType_ = type;
                }
                this.bitField0_ |= 512;
                return this;
            }

            public Builder setAbbreviatedTypeId(int i3) {
                this.bitField0_ |= 4096;
                this.abbreviatedTypeId_ = i3;
                return this;
            }

            public Builder setClassName(int i3) {
                this.bitField0_ |= 32;
                this.className_ = i3;
                return this;
            }

            public Builder setFlags(int i3) {
                this.bitField0_ |= 8192;
                this.flags_ = i3;
                return this;
            }

            public Builder setFlexibleTypeCapabilitiesId(int i3) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = i3;
                return this;
            }

            public Builder setFlexibleUpperBoundId(int i3) {
                this.bitField0_ |= 16;
                this.flexibleUpperBoundId_ = i3;
                return this;
            }

            public Builder setNullable(boolean z16) {
                this.bitField0_ |= 2;
                this.nullable_ = z16;
                return this;
            }

            public Builder setOuterTypeId(int i3) {
                this.bitField0_ |= 1024;
                this.outerTypeId_ = i3;
                return this;
            }

            public Builder setTypeAliasName(int i3) {
                this.bitField0_ |= 256;
                this.typeAliasName_ = i3;
                return this;
            }

            public Builder setTypeParameter(int i3) {
                this.bitField0_ |= 64;
                this.typeParameter_ = i3;
                return this;
            }

            public Builder setTypeParameterName(int i3) {
                this.bitField0_ |= 128;
                this.typeParameterName_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Type build() {
                Type buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Type type) {
                if (type == Type.getDefaultInstance()) {
                    return this;
                }
                if (!type.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = type.argument_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureArgumentIsMutable();
                        this.argument_.addAll(type.argument_);
                    }
                }
                if (type.hasNullable()) {
                    setNullable(type.getNullable());
                }
                if (type.hasFlexibleTypeCapabilitiesId()) {
                    setFlexibleTypeCapabilitiesId(type.getFlexibleTypeCapabilitiesId());
                }
                if (type.hasFlexibleUpperBound()) {
                    mergeFlexibleUpperBound(type.getFlexibleUpperBound());
                }
                if (type.hasFlexibleUpperBoundId()) {
                    setFlexibleUpperBoundId(type.getFlexibleUpperBoundId());
                }
                if (type.hasClassName()) {
                    setClassName(type.getClassName());
                }
                if (type.hasTypeParameter()) {
                    setTypeParameter(type.getTypeParameter());
                }
                if (type.hasTypeParameterName()) {
                    setTypeParameterName(type.getTypeParameterName());
                }
                if (type.hasTypeAliasName()) {
                    setTypeAliasName(type.getTypeAliasName());
                }
                if (type.hasOuterType()) {
                    mergeOuterType(type.getOuterType());
                }
                if (type.hasOuterTypeId()) {
                    setOuterTypeId(type.getOuterTypeId());
                }
                if (type.hasAbbreviatedType()) {
                    mergeAbbreviatedType(type.getAbbreviatedType());
                }
                if (type.hasAbbreviatedTypeId()) {
                    setAbbreviatedTypeId(type.getAbbreviatedTypeId());
                }
                if (type.hasFlags()) {
                    setFlags(type.getFlags());
                }
                mergeExtensionFields(type);
                setUnknownFields(getUnknownFields().concat(type.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Type type = null;
                try {
                    try {
                        Type parsePartialFrom = Type.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (type != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    Type type2 = (Type) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        type = type2;
                        if (type != null) {
                            mergeFrom(type);
                        }
                        throw th;
                    }
                }
            }
        }

        static {
            Type type = new Type(true);
            defaultInstance = type;
            type.initFields();
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.access$5700();
        }

        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public Argument getArgument(int i3) {
            return this.argument_.get(i3);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getClassName() {
            return this.className_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public Type getOuterType() {
            return this.outerType_;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Type> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 4096) == 4096) {
                i3 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.argument_.size(); i17++) {
                i3 += CodedOutputStream.computeMessageSize(2, this.argument_.get(i17));
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 += CodedOutputStream.computeBoolSize(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.computeInt32Size(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.computeInt32Size(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i3 += CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i3 += CodedOutputStream.computeMessageSize(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i3 += CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i3 += CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                i3 += CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                i3 += CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
            }
            int extensionsSerializedSize = i3 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        public int getTypeParameter() {
            return this.typeParameter_;
        }

        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        public boolean hasAbbreviatedType() {
            if ((this.bitField0_ & 1024) == 1024) {
                return true;
            }
            return false;
        }

        public boolean hasAbbreviatedTypeId() {
            if ((this.bitField0_ & 2048) == 2048) {
                return true;
            }
            return false;
        }

        public boolean hasClassName() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 4096) == 4096) {
                return true;
            }
            return false;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean hasFlexibleUpperBound() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean hasFlexibleUpperBoundId() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        public boolean hasNullable() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasOuterType() {
            if ((this.bitField0_ & 256) == 256) {
                return true;
            }
            return false;
        }

        public boolean hasOuterTypeId() {
            if ((this.bitField0_ & 512) == 512) {
                return true;
            }
            return false;
        }

        public boolean hasTypeAliasName() {
            if ((this.bitField0_ & 128) == 128) {
                return true;
            }
            return false;
        }

        public boolean hasTypeParameter() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        public boolean hasTypeParameterName() {
            if ((this.bitField0_ & 64) == 64) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getArgumentCount(); i3++) {
                if (!getArgument(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasOuterType() && !getOuterType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            for (int i3 = 0; i3 < this.argument_.size(); i3++) {
                codedOutputStream.writeMessage(2, this.argument_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeMessage(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeMessage(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeInt32(14, this.abbreviatedTypeId_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Type type) {
            return newBuilder().mergeFrom(type);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Type getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        Type(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        Type(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z16 = true;
                            case 8:
                                this.bitField0_ |= 4096;
                                this.flags_ = codedInputStream.readInt32();
                            case 18:
                                if (!(z17 & true)) {
                                    this.argument_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                            case 24:
                                this.bitField0_ |= 1;
                                this.nullable_ = codedInputStream.readBool();
                            case 32:
                                this.bitField0_ |= 2;
                                this.flexibleTypeCapabilitiesId_ = codedInputStream.readInt32();
                            case 42:
                                builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : null;
                                Type type = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                                this.flexibleUpperBound_ = type;
                                if (builder != null) {
                                    builder.mergeFrom(type);
                                    this.flexibleUpperBound_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            case 48:
                                this.bitField0_ |= 16;
                                this.className_ = codedInputStream.readInt32();
                            case 56:
                                this.bitField0_ |= 32;
                                this.typeParameter_ = codedInputStream.readInt32();
                            case 64:
                                this.bitField0_ |= 8;
                                this.flexibleUpperBoundId_ = codedInputStream.readInt32();
                            case 72:
                                this.bitField0_ |= 64;
                                this.typeParameterName_ = codedInputStream.readInt32();
                            case 82:
                                builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : null;
                                Type type2 = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                                this.outerType_ = type2;
                                if (builder != null) {
                                    builder.mergeFrom(type2);
                                    this.outerType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 256;
                            case 88:
                                this.bitField0_ |= 512;
                                this.outerTypeId_ = codedInputStream.readInt32();
                            case 96:
                                this.bitField0_ |= 128;
                                this.typeAliasName_ = codedInputStream.readInt32();
                            case 106:
                                builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : null;
                                Type type3 = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                                this.abbreviatedType_ = type3;
                                if (builder != null) {
                                    builder.mergeFrom(type3);
                                    this.abbreviatedType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1024;
                            case 112:
                                this.bitField0_ |= 2048;
                                this.abbreviatedTypeId_ = codedInputStream.readInt32();
                            default:
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    z16 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if (z17 & true) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if (z17 & true) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements TypeAliasOrBuilder {
        public static Parser<TypeAlias> PARSER = new AbstractParser<TypeAlias>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public TypeAlias parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeAlias(codedInputStream, extensionRegistryLite);
            }
        };
        private static final TypeAlias defaultInstance;
        private List<Annotation> annotation_;
        private int bitField0_;
        private int expandedTypeId_;
        private Type expandedType_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List<TypeParameter> typeParameter_;
        private int underlyingTypeId_;
        private Type underlyingType_;
        private final ByteString unknownFields;
        private List<Integer> versionRequirement_;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeAlias, Builder> implements TypeAliasOrBuilder {
            private int bitField0_;
            private int expandedTypeId_;
            private int name_;
            private int underlyingTypeId_;
            private int flags_ = 6;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type underlyingType_ = Type.getDefaultInstance();
            private Type expandedType_ = Type.getDefaultInstance();
            private List<Annotation> annotation_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$19000() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.annotation_ = new ArrayList(this.annotation_);
                    this.bitField0_ |= 128;
                }
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 4;
                }
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 256;
                }
            }

            public TypeAlias buildPartial() {
                TypeAlias typeAlias = new TypeAlias(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) != 1) {
                    i16 = 0;
                }
                typeAlias.flags_ = this.flags_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                typeAlias.name_ = this.name_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -5;
                }
                typeAlias.typeParameter_ = this.typeParameter_;
                if ((i3 & 8) == 8) {
                    i16 |= 4;
                }
                typeAlias.underlyingType_ = this.underlyingType_;
                if ((i3 & 16) == 16) {
                    i16 |= 8;
                }
                typeAlias.underlyingTypeId_ = this.underlyingTypeId_;
                if ((i3 & 32) == 32) {
                    i16 |= 16;
                }
                typeAlias.expandedType_ = this.expandedType_;
                if ((i3 & 64) == 64) {
                    i16 |= 32;
                }
                typeAlias.expandedTypeId_ = this.expandedTypeId_;
                if ((this.bitField0_ & 128) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= -129;
                }
                typeAlias.annotation_ = this.annotation_;
                if ((this.bitField0_ & 256) == 256) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -257;
                }
                typeAlias.versionRequirement_ = this.versionRequirement_;
                typeAlias.bitField0_ = i16;
                return typeAlias;
            }

            public Annotation getAnnotation(int i3) {
                return this.annotation_.get(i3);
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Type getExpandedType() {
                return this.expandedType_;
            }

            public TypeParameter getTypeParameter(int i3) {
                return this.typeParameter_.get(i3);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public Type getUnderlyingType() {
                return this.underlyingType_;
            }

            public boolean hasExpandedType() {
                if ((this.bitField0_ & 32) == 32) {
                    return true;
                }
                return false;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            public boolean hasUnderlyingType() {
                if ((this.bitField0_ & 8) == 8) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                for (int i3 = 0; i3 < getTypeParameterCount(); i3++) {
                    if (!getTypeParameter(i3).isInitialized()) {
                        return false;
                    }
                }
                if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                    return false;
                }
                if (hasExpandedType() && !getExpandedType().isInitialized()) {
                    return false;
                }
                for (int i16 = 0; i16 < getAnnotationCount(); i16++) {
                    if (!getAnnotation(i16).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeExpandedType(Type type) {
                if ((this.bitField0_ & 32) == 32 && this.expandedType_ != Type.getDefaultInstance()) {
                    this.expandedType_ = Type.newBuilder(this.expandedType_).mergeFrom(type).buildPartial();
                } else {
                    this.expandedType_ = type;
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder mergeUnderlyingType(Type type) {
                if ((this.bitField0_ & 8) == 8 && this.underlyingType_ != Type.getDefaultInstance()) {
                    this.underlyingType_ = Type.newBuilder(this.underlyingType_).mergeFrom(type).buildPartial();
                } else {
                    this.underlyingType_ = type;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setExpandedTypeId(int i3) {
                this.bitField0_ |= 64;
                this.expandedTypeId_ = i3;
                return this;
            }

            public Builder setFlags(int i3) {
                this.bitField0_ |= 1;
                this.flags_ = i3;
                return this;
            }

            public Builder setName(int i3) {
                this.bitField0_ |= 2;
                this.name_ = i3;
                return this;
            }

            public Builder setUnderlyingTypeId(int i3) {
                this.bitField0_ |= 16;
                this.underlyingTypeId_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeAlias build() {
                TypeAlias buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(TypeAlias typeAlias) {
                if (typeAlias == TypeAlias.getDefaultInstance()) {
                    return this;
                }
                if (typeAlias.hasFlags()) {
                    setFlags(typeAlias.getFlags());
                }
                if (typeAlias.hasName()) {
                    setName(typeAlias.getName());
                }
                if (!typeAlias.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = typeAlias.typeParameter_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(typeAlias.typeParameter_);
                    }
                }
                if (typeAlias.hasUnderlyingType()) {
                    mergeUnderlyingType(typeAlias.getUnderlyingType());
                }
                if (typeAlias.hasUnderlyingTypeId()) {
                    setUnderlyingTypeId(typeAlias.getUnderlyingTypeId());
                }
                if (typeAlias.hasExpandedType()) {
                    mergeExpandedType(typeAlias.getExpandedType());
                }
                if (typeAlias.hasExpandedTypeId()) {
                    setExpandedTypeId(typeAlias.getExpandedTypeId());
                }
                if (!typeAlias.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = typeAlias.annotation_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureAnnotationIsMutable();
                        this.annotation_.addAll(typeAlias.annotation_);
                    }
                }
                if (!typeAlias.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = typeAlias.versionRequirement_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(typeAlias.versionRequirement_);
                    }
                }
                mergeExtensionFields(typeAlias);
                setUnknownFields(getUnknownFields().concat(typeAlias.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeAlias typeAlias = null;
                try {
                    try {
                        TypeAlias parsePartialFrom = TypeAlias.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (typeAlias != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    TypeAlias typeAlias2 = (TypeAlias) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        typeAlias = typeAlias2;
                        if (typeAlias != null) {
                            mergeFrom(typeAlias);
                        }
                        throw th;
                    }
                }
            }
        }

        static {
            TypeAlias typeAlias = new TypeAlias(true);
            defaultInstance = typeAlias;
            typeAlias.initFields();
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$19000();
        }

        public static TypeAlias parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public Annotation getAnnotation(int i3) {
            return this.annotation_.get(i3);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public Type getExpandedType() {
            return this.expandedType_;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeAlias> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            for (int i17 = 0; i17 < this.typeParameter_.size(); i17++) {
                i3 += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i17));
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.computeMessageSize(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
            }
            for (int i18 = 0; i18 < this.annotation_.size(); i18++) {
                i3 += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i18));
            }
            int i19 = 0;
            for (int i26 = 0; i26 < this.versionRequirement_.size(); i26++) {
                i19 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i26).intValue());
            }
            int size = i3 + i19 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public TypeParameter getTypeParameter(int i3) {
            return this.typeParameter_.get(i3);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasExpandedType() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        public boolean hasExpandedTypeId() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean hasUnderlyingType() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean hasUnderlyingTypeId() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getTypeParameterCount(); i3++) {
                if (!getTypeParameter(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasExpandedType() && !getExpandedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i16 = 0; i16 < getAnnotationCount(); i16++) {
                if (!getAnnotation(i16).isInitialized()) {
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
                codedOutputStream.writeMessage(3, this.typeParameter_.get(i3));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(7, this.expandedTypeId_);
            }
            for (int i16 = 0; i16 < this.annotation_.size(); i16++) {
                codedOutputStream.writeMessage(8, this.annotation_.get(i16));
            }
            for (int i17 = 0; i17 < this.versionRequirement_.size(); i17++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i17).intValue());
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(TypeAlias typeAlias) {
            return newBuilder().mergeFrom(typeAlias);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeAlias getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        TypeAlias(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0022. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        TypeAlias(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Type.Builder builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                ?? r56 = 128;
                if (!z16) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        z16 = true;
                                    case 8:
                                        this.bitField0_ |= 1;
                                        this.flags_ = codedInputStream.readInt32();
                                    case 16:
                                        this.bitField0_ |= 2;
                                        this.name_ = codedInputStream.readInt32();
                                    case 26:
                                        if ((i3 & 4) != 4) {
                                            this.typeParameter_ = new ArrayList();
                                            i3 |= 4;
                                        }
                                        this.typeParameter_.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                                    case 34:
                                        builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                                        Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.underlyingType_ = type;
                                        if (builder != null) {
                                            builder.mergeFrom(type);
                                            this.underlyingType_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 4;
                                    case 40:
                                        this.bitField0_ |= 8;
                                        this.underlyingTypeId_ = codedInputStream.readInt32();
                                    case 50:
                                        builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                                        Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.expandedType_ = type2;
                                        if (builder != null) {
                                            builder.mergeFrom(type2);
                                            this.expandedType_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 16;
                                    case 56:
                                        this.bitField0_ |= 32;
                                        this.expandedTypeId_ = codedInputStream.readInt32();
                                    case 66:
                                        if ((i3 & 128) != 128) {
                                            this.annotation_ = new ArrayList();
                                            i3 |= 128;
                                        }
                                        this.annotation_.add(codedInputStream.readMessage(Annotation.PARSER, extensionRegistryLite));
                                    case 248:
                                        if ((i3 & 256) != 256) {
                                            this.versionRequirement_ = new ArrayList();
                                            i3 |= 256;
                                        }
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    case 250:
                                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if ((i3 & 256) != 256 && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.versionRequirement_ = new ArrayList();
                                            i3 |= 256;
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                        }
                                        codedInputStream.popLimit(pushLimit);
                                        break;
                                    default:
                                        r56 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                        if (r56 == 0) {
                                            z16 = true;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e16) {
                                throw e16.setUnfinishedMessage(this);
                            }
                        } catch (IOException e17) {
                            throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th5) {
                        if ((i3 & 4) == 4) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((i3 & 128) == r56) {
                            this.annotation_ = Collections.unmodifiableList(this.annotation_);
                        }
                        if ((i3 & 256) == 256) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                        }
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th6) {
                            this.unknownFields = newOutput.toByteString();
                            throw th6;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th5;
                    }
                } else {
                    if ((i3 & 4) == 4) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((i3 & 128) == 128) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if ((i3 & 256) == 256) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused2) {
                    } catch (Throwable th7) {
                        this.unknownFields = newOutput.toByteString();
                        throw th7;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    return;
                }
            }
        }
    }

    /* loaded from: classes28.dex */
    public interface TypeAliasOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public interface TypeOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements TypeParameterOrBuilder {
        public static Parser<TypeParameter> PARSER = new AbstractParser<TypeParameter>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public TypeParameter parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeParameter(codedInputStream, extensionRegistryLite);
            }
        };
        private static final TypeParameter defaultInstance;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private boolean reified_;
        private final ByteString unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        private List<Integer> upperBoundId_;
        private List<Type> upperBound_;
        private Variance variance_;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeParameter, Builder> implements TypeParameterOrBuilder {
            private int bitField0_;
            private int id_;
            private int name_;
            private boolean reified_;
            private Variance variance_ = Variance.INV;
            private List<Type> upperBound_ = Collections.emptyList();
            private List<Integer> upperBoundId_ = Collections.emptyList();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$7600() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureUpperBoundIdIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureUpperBoundIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.upperBound_ = new ArrayList(this.upperBound_);
                    this.bitField0_ |= 16;
                }
            }

            public TypeParameter buildPartial() {
                TypeParameter typeParameter = new TypeParameter(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) != 1) {
                    i16 = 0;
                }
                typeParameter.id_ = this.id_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                typeParameter.name_ = this.name_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                typeParameter.reified_ = this.reified_;
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                typeParameter.variance_ = this.variance_;
                if ((this.bitField0_ & 16) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    this.bitField0_ &= -17;
                }
                typeParameter.upperBound_ = this.upperBound_;
                if ((this.bitField0_ & 32) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                    this.bitField0_ &= -33;
                }
                typeParameter.upperBoundId_ = this.upperBoundId_;
                typeParameter.bitField0_ = i16;
                return typeParameter;
            }

            public Type getUpperBound(int i3) {
                return this.upperBound_.get(i3);
            }

            public int getUpperBoundCount() {
                return this.upperBound_.size();
            }

            public boolean hasId() {
                if ((this.bitField0_ & 1) == 1) {
                    return true;
                }
                return false;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasId() || !hasName()) {
                    return false;
                }
                for (int i3 = 0; i3 < getUpperBoundCount(); i3++) {
                    if (!getUpperBound(i3).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder setId(int i3) {
                this.bitField0_ |= 1;
                this.id_ = i3;
                return this;
            }

            public Builder setName(int i3) {
                this.bitField0_ |= 2;
                this.name_ = i3;
                return this;
            }

            public Builder setReified(boolean z16) {
                this.bitField0_ |= 4;
                this.reified_ = z16;
                return this;
            }

            public Builder setVariance(Variance variance) {
                variance.getClass();
                this.bitField0_ |= 8;
                this.variance_ = variance;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeParameter build() {
                TypeParameter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(TypeParameter typeParameter) {
                if (typeParameter == TypeParameter.getDefaultInstance()) {
                    return this;
                }
                if (typeParameter.hasId()) {
                    setId(typeParameter.getId());
                }
                if (typeParameter.hasName()) {
                    setName(typeParameter.getName());
                }
                if (typeParameter.hasReified()) {
                    setReified(typeParameter.getReified());
                }
                if (typeParameter.hasVariance()) {
                    setVariance(typeParameter.getVariance());
                }
                if (!typeParameter.upperBound_.isEmpty()) {
                    if (this.upperBound_.isEmpty()) {
                        this.upperBound_ = typeParameter.upperBound_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureUpperBoundIsMutable();
                        this.upperBound_.addAll(typeParameter.upperBound_);
                    }
                }
                if (!typeParameter.upperBoundId_.isEmpty()) {
                    if (this.upperBoundId_.isEmpty()) {
                        this.upperBoundId_ = typeParameter.upperBoundId_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureUpperBoundIdIsMutable();
                        this.upperBoundId_.addAll(typeParameter.upperBoundId_);
                    }
                }
                mergeExtensionFields(typeParameter);
                setUnknownFields(getUnknownFields().concat(typeParameter.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeParameter typeParameter = null;
                try {
                    try {
                        TypeParameter parsePartialFrom = TypeParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (typeParameter != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    TypeParameter typeParameter2 = (TypeParameter) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        typeParameter = typeParameter2;
                        if (typeParameter != null) {
                            mergeFrom(typeParameter);
                        }
                        throw th;
                    }
                }
            }
        }

        /* loaded from: classes28.dex */
        public enum Variance implements Internal.EnumLite {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);

            private static Internal.EnumLiteMap<Variance> internalValueMap = new Internal.EnumLiteMap<Variance>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                public Variance findValueByNumber(int i3) {
                    return Variance.valueOf(i3);
                }
            };
            private final int value;

            Variance(int i3, int i16) {
                this.value = i16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int i3) {
                if (i3 == 0) {
                    return IN;
                }
                if (i3 == 1) {
                    return OUT;
                }
                if (i3 != 2) {
                    return null;
                }
                return INV;
            }
        }

        static {
            TypeParameter typeParameter = new TypeParameter(true);
            defaultInstance = typeParameter;
            typeParameter.initFields();
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$7600();
        }

        public int getId() {
            return this.id_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeParameter> getParserForType() {
            return PARSER;
        }

        public boolean getReified() {
            return this.reified_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSerializedSize;
            if (i16 != -1) {
                return i16;
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
            } else {
                i3 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.computeBoolSize(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
            }
            for (int i17 = 0; i17 < this.upperBound_.size(); i17++) {
                i3 += CodedOutputStream.computeMessageSize(5, this.upperBound_.get(i17));
            }
            int i18 = 0;
            for (int i19 = 0; i19 < this.upperBoundId_.size(); i19++) {
                i18 += CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(i19).intValue());
            }
            int i26 = i3 + i18;
            if (!getUpperBoundIdList().isEmpty()) {
                i26 = i26 + 1 + CodedOutputStream.computeInt32SizeNoTag(i18);
            }
            this.upperBoundIdMemoizedSerializedSize = i18;
            int extensionsSerializedSize = i26 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getUpperBound(int i3) {
            return this.upperBound_.get(i3);
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public Variance getVariance() {
            return this.variance_;
        }

        public boolean hasId() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean hasReified() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean hasVariance() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getUpperBoundCount(); i3++) {
                if (!getUpperBound(i3).isInitialized()) {
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBool(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeEnum(4, this.variance_.getNumber());
            }
            for (int i3 = 0; i3 < this.upperBound_.size(); i3++) {
                codedOutputStream.writeMessage(5, this.upperBound_.get(i3));
            }
            if (getUpperBoundIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(50);
                codedOutputStream.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
            }
            for (int i16 = 0; i16 < this.upperBoundId_.size(); i16++) {
                codedOutputStream.writeInt32NoTag(this.upperBoundId_.get(i16).intValue());
            }
            newExtensionWriter.writeUntil(1000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(TypeParameter typeParameter) {
            return newBuilder().mergeFrom(typeParameter);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> extendableBuilder) {
            super(extendableBuilder);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        TypeParameter(boolean z16) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        TypeParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.id_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.name_ = codedInputStream.readInt32();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 4;
                                    this.reified_ = codedInputStream.readBool();
                                } else if (readTag == 32) {
                                    int readEnum = codedInputStream.readEnum();
                                    Variance valueOf = Variance.valueOf(readEnum);
                                    if (valueOf == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.variance_ = valueOf;
                                    }
                                } else if (readTag == 42) {
                                    if ((i3 & 16) != 16) {
                                        this.upperBound_ = new ArrayList();
                                        i3 |= 16;
                                    }
                                    this.upperBound_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                } else if (readTag == 48) {
                                    if ((i3 & 32) != 32) {
                                        this.upperBoundId_ = new ArrayList();
                                        i3 |= 32;
                                    }
                                    this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                } else if (readTag != 50) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if ((i3 & 32) != 32 && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.upperBoundId_ = new ArrayList();
                                        i3 |= 32;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        }
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if ((i3 & 16) == 16) {
                        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    }
                    if ((i3 & 32) == 32) {
                        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if ((i3 & 16) == 16) {
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
            }
            if ((i3 & 32) == 32) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface TypeParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class TypeTable extends GeneratedMessageLite implements TypeTableOrBuilder {
        public static Parser<TypeTable> PARSER = new AbstractParser<TypeTable>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public TypeTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final TypeTable defaultInstance;
        private int bitField0_;
        private int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Type> type_;
        private final ByteString unknownFields;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TypeTable, Builder> implements TypeTableOrBuilder {
            private int bitField0_;
            private List<Type> type_ = Collections.emptyList();
            private int firstNullable_ = -1;

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$12600() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureTypeIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.type_ = new ArrayList(this.type_);
                    this.bitField0_ |= 1;
                }
            }

            public TypeTable buildPartial() {
                TypeTable typeTable = new TypeTable(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) == 1) {
                    this.type_ = Collections.unmodifiableList(this.type_);
                    this.bitField0_ &= -2;
                }
                typeTable.type_ = this.type_;
                if ((i3 & 2) != 2) {
                    i16 = 0;
                }
                typeTable.firstNullable_ = this.firstNullable_;
                typeTable.bitField0_ = i16;
                return typeTable;
            }

            public Type getType(int i3) {
                return this.type_.get(i3);
            }

            public int getTypeCount() {
                return this.type_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i3 = 0; i3 < getTypeCount(); i3++) {
                    if (!getType(i3).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder setFirstNullable(int i3) {
                this.bitField0_ |= 2;
                this.firstNullable_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeTable build() {
                TypeTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(TypeTable typeTable) {
                if (typeTable == TypeTable.getDefaultInstance()) {
                    return this;
                }
                if (!typeTable.type_.isEmpty()) {
                    if (this.type_.isEmpty()) {
                        this.type_ = typeTable.type_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTypeIsMutable();
                        this.type_.addAll(typeTable.type_);
                    }
                }
                if (typeTable.hasFirstNullable()) {
                    setFirstNullable(typeTable.getFirstNullable());
                }
                setUnknownFields(getUnknownFields().concat(typeTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeTable typeTable = null;
                try {
                    try {
                        TypeTable parsePartialFrom = TypeTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (typeTable != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    TypeTable typeTable2 = (TypeTable) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        typeTable = typeTable2;
                        if (typeTable != null) {
                            mergeFrom(typeTable);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        static {
            TypeTable typeTable = new TypeTable(true);
            defaultInstance = typeTable;
            typeTable.initFields();
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
        }

        public static Builder newBuilder() {
            return Builder.access$12600();
        }

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.type_.size(); i17++) {
                i16 += CodedOutputStream.computeMessageSize(1, this.type_.get(i17));
            }
            if ((this.bitField0_ & 1) == 1) {
                i16 += CodedOutputStream.computeInt32Size(2, this.firstNullable_);
            }
            int size = i16 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public Type getType(int i3) {
            return this.type_.get(i3);
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public List<Type> getTypeList() {
            return this.type_;
        }

        public boolean hasFirstNullable() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            for (int i3 = 0; i3 < getTypeCount(); i3++) {
                if (!getType(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i3 = 0; i3 < this.type_.size(); i3++) {
                codedOutputStream.writeMessage(1, this.type_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(2, this.firstNullable_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(TypeTable typeTable) {
            return newBuilder().mergeFrom(typeTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        TypeTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        TypeTable(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        TypeTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                if (!(z17 & true)) {
                                    this.type_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.type_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                            } else if (readTag != 16) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.firstNullable_ = codedInputStream.readInt32();
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if (z17 & true) {
                        this.type_ = Collections.unmodifiableList(this.type_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if (z17 & true) {
                this.type_ = Collections.unmodifiableList(this.type_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface TypeTableOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements ValueParameterOrBuilder {
        public static Parser<ValueParameter> PARSER = new AbstractParser<ValueParameter>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public ValueParameter parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ValueParameter(codedInputStream, extensionRegistryLite);
            }
        };
        private static final ValueParameter defaultInstance;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int typeId_;
        private Type type_;
        private final ByteString unknownFields;
        private int varargElementTypeId_;
        private Type varargElementType_;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ValueParameter, Builder> implements ValueParameterOrBuilder {
            private int bitField0_;
            private int flags_;
            private int name_;
            private int typeId_;
            private int varargElementTypeId_;
            private Type type_ = Type.getDefaultInstance();
            private Type varargElementType_ = Type.getDefaultInstance();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$17900() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            public ValueParameter buildPartial() {
                ValueParameter valueParameter = new ValueParameter(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) != 1) {
                    i16 = 0;
                }
                valueParameter.flags_ = this.flags_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                valueParameter.name_ = this.name_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                valueParameter.type_ = this.type_;
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                valueParameter.typeId_ = this.typeId_;
                if ((i3 & 16) == 16) {
                    i16 |= 16;
                }
                valueParameter.varargElementType_ = this.varargElementType_;
                if ((i3 & 32) == 32) {
                    i16 |= 32;
                }
                valueParameter.varargElementTypeId_ = this.varargElementTypeId_;
                valueParameter.bitField0_ = i16;
                return valueParameter;
            }

            public Type getType() {
                return this.type_;
            }

            public Type getVarargElementType() {
                return this.varargElementType_;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) == 2) {
                    return true;
                }
                return false;
            }

            public boolean hasType() {
                if ((this.bitField0_ & 4) == 4) {
                    return true;
                }
                return false;
            }

            public boolean hasVarargElementType() {
                if ((this.bitField0_ & 16) == 16) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasType() && !getType().isInitialized()) {
                    return false;
                }
                if ((hasVarargElementType() && !getVarargElementType().isInitialized()) || !extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeType(Type type) {
                if ((this.bitField0_ & 4) == 4 && this.type_ != Type.getDefaultInstance()) {
                    this.type_ = Type.newBuilder(this.type_).mergeFrom(type).buildPartial();
                } else {
                    this.type_ = type;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeVarargElementType(Type type) {
                if ((this.bitField0_ & 16) == 16 && this.varargElementType_ != Type.getDefaultInstance()) {
                    this.varargElementType_ = Type.newBuilder(this.varargElementType_).mergeFrom(type).buildPartial();
                } else {
                    this.varargElementType_ = type;
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setFlags(int i3) {
                this.bitField0_ |= 1;
                this.flags_ = i3;
                return this;
            }

            public Builder setName(int i3) {
                this.bitField0_ |= 2;
                this.name_ = i3;
                return this;
            }

            public Builder setTypeId(int i3) {
                this.bitField0_ |= 8;
                this.typeId_ = i3;
                return this;
            }

            public Builder setVarargElementTypeId(int i3) {
                this.bitField0_ |= 32;
                this.varargElementTypeId_ = i3;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public ValueParameter build() {
                ValueParameter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(ValueParameter valueParameter) {
                if (valueParameter == ValueParameter.getDefaultInstance()) {
                    return this;
                }
                if (valueParameter.hasFlags()) {
                    setFlags(valueParameter.getFlags());
                }
                if (valueParameter.hasName()) {
                    setName(valueParameter.getName());
                }
                if (valueParameter.hasType()) {
                    mergeType(valueParameter.getType());
                }
                if (valueParameter.hasTypeId()) {
                    setTypeId(valueParameter.getTypeId());
                }
                if (valueParameter.hasVarargElementType()) {
                    mergeVarargElementType(valueParameter.getVarargElementType());
                }
                if (valueParameter.hasVarargElementTypeId()) {
                    setVarargElementTypeId(valueParameter.getVarargElementTypeId());
                }
                mergeExtensionFields(valueParameter);
                setUnknownFields(getUnknownFields().concat(valueParameter.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ValueParameter valueParameter = null;
                try {
                    try {
                        ValueParameter parsePartialFrom = ValueParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (valueParameter != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    ValueParameter valueParameter2 = (ValueParameter) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        valueParameter = valueParameter2;
                        if (valueParameter != null) {
                            mergeFrom(valueParameter);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        static {
            ValueParameter valueParameter = new ValueParameter(true);
            defaultInstance = valueParameter;
            valueParameter.initFields();
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.access$17900();
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<ValueParameter> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i16 = 0 + CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i16 += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i16 += CodedOutputStream.computeMessageSize(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i16 += CodedOutputStream.computeMessageSize(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i16 += CodedOutputStream.computeInt32Size(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i16 += CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
            }
            int extensionsSerializedSize = i16 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean hasType() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean hasTypeId() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        public boolean hasVarargElementType() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        public boolean hasVarargElementTypeId() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasType() && !getType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.varargElementTypeId_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(ValueParameter valueParameter) {
            return newBuilder().mergeFrom(valueParameter);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public ValueParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        ValueParameter(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        ValueParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Type.Builder builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.flags_ = codedInputStream.readInt32();
                                } else if (readTag != 16) {
                                    if (readTag == 26) {
                                        builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : null;
                                        Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.type_ = type;
                                        if (builder != null) {
                                            builder.mergeFrom(type);
                                            this.type_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 4;
                                    } else if (readTag == 34) {
                                        builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : null;
                                        Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.varargElementType_ = type2;
                                        if (builder != null) {
                                            builder.mergeFrom(type2);
                                            this.varargElementType_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 16;
                                    } else if (readTag == 40) {
                                        this.bitField0_ |= 8;
                                        this.typeId_ = codedInputStream.readInt32();
                                    } else if (readTag != 48) {
                                        if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 32;
                                        this.varargElementTypeId_ = codedInputStream.readInt32();
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.name_ = codedInputStream.readInt32();
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        }
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface ValueParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class VersionRequirement extends GeneratedMessageLite implements VersionRequirementOrBuilder {
        public static Parser<VersionRequirement> PARSER = new AbstractParser<VersionRequirement>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public VersionRequirement parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VersionRequirement(codedInputStream, extensionRegistryLite);
            }
        };
        private static final VersionRequirement defaultInstance;
        private int bitField0_;
        private int errorCode_;
        private Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int message_;
        private final ByteString unknownFields;
        private int versionFull_;
        private VersionKind versionKind_;
        private int version_;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirement, Builder> implements VersionRequirementOrBuilder {
            private int bitField0_;
            private int errorCode_;
            private int message_;
            private int versionFull_;
            private int version_;
            private Level level_ = Level.ERROR;
            private VersionKind versionKind_ = VersionKind.LANGUAGE_VERSION;

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$21000() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            public VersionRequirement buildPartial() {
                VersionRequirement versionRequirement = new VersionRequirement(this);
                int i3 = this.bitField0_;
                int i16 = 1;
                if ((i3 & 1) != 1) {
                    i16 = 0;
                }
                versionRequirement.version_ = this.version_;
                if ((i3 & 2) == 2) {
                    i16 |= 2;
                }
                versionRequirement.versionFull_ = this.versionFull_;
                if ((i3 & 4) == 4) {
                    i16 |= 4;
                }
                versionRequirement.level_ = this.level_;
                if ((i3 & 8) == 8) {
                    i16 |= 8;
                }
                versionRequirement.errorCode_ = this.errorCode_;
                if ((i3 & 16) == 16) {
                    i16 |= 16;
                }
                versionRequirement.message_ = this.message_;
                if ((i3 & 32) == 32) {
                    i16 |= 32;
                }
                versionRequirement.versionKind_ = this.versionKind_;
                versionRequirement.bitField0_ = i16;
                return versionRequirement;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setErrorCode(int i3) {
                this.bitField0_ |= 8;
                this.errorCode_ = i3;
                return this;
            }

            public Builder setLevel(Level level) {
                level.getClass();
                this.bitField0_ |= 4;
                this.level_ = level;
                return this;
            }

            public Builder setMessage(int i3) {
                this.bitField0_ |= 16;
                this.message_ = i3;
                return this;
            }

            public Builder setVersion(int i3) {
                this.bitField0_ |= 1;
                this.version_ = i3;
                return this;
            }

            public Builder setVersionFull(int i3) {
                this.bitField0_ |= 2;
                this.versionFull_ = i3;
                return this;
            }

            public Builder setVersionKind(VersionKind versionKind) {
                versionKind.getClass();
                this.bitField0_ |= 32;
                this.versionKind_ = versionKind;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirement build() {
                VersionRequirement buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(VersionRequirement versionRequirement) {
                if (versionRequirement == VersionRequirement.getDefaultInstance()) {
                    return this;
                }
                if (versionRequirement.hasVersion()) {
                    setVersion(versionRequirement.getVersion());
                }
                if (versionRequirement.hasVersionFull()) {
                    setVersionFull(versionRequirement.getVersionFull());
                }
                if (versionRequirement.hasLevel()) {
                    setLevel(versionRequirement.getLevel());
                }
                if (versionRequirement.hasErrorCode()) {
                    setErrorCode(versionRequirement.getErrorCode());
                }
                if (versionRequirement.hasMessage()) {
                    setMessage(versionRequirement.getMessage());
                }
                if (versionRequirement.hasVersionKind()) {
                    setVersionKind(versionRequirement.getVersionKind());
                }
                setUnknownFields(getUnknownFields().concat(versionRequirement.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                VersionRequirement versionRequirement = null;
                try {
                    try {
                        VersionRequirement parsePartialFrom = VersionRequirement.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (versionRequirement != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    VersionRequirement versionRequirement2 = (VersionRequirement) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        versionRequirement = versionRequirement2;
                        if (versionRequirement != null) {
                            mergeFrom(versionRequirement);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        /* loaded from: classes28.dex */
        public enum Level implements Internal.EnumLite {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);

            private static Internal.EnumLiteMap<Level> internalValueMap = new Internal.EnumLiteMap<Level>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                public Level findValueByNumber(int i3) {
                    return Level.valueOf(i3);
                }
            };
            private final int value;

            Level(int i3, int i16) {
                this.value = i16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int i3) {
                if (i3 == 0) {
                    return WARNING;
                }
                if (i3 == 1) {
                    return ERROR;
                }
                if (i3 != 2) {
                    return null;
                }
                return HIDDEN;
            }
        }

        /* loaded from: classes28.dex */
        public enum VersionKind implements Internal.EnumLite {
            LANGUAGE_VERSION(0, 0),
            COMPILER_VERSION(1, 1),
            API_VERSION(2, 2);

            private static Internal.EnumLiteMap<VersionKind> internalValueMap = new Internal.EnumLiteMap<VersionKind>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                public VersionKind findValueByNumber(int i3) {
                    return VersionKind.valueOf(i3);
                }
            };
            private final int value;

            VersionKind(int i3, int i16) {
                this.value = i16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int i3) {
                if (i3 == 0) {
                    return LANGUAGE_VERSION;
                }
                if (i3 == 1) {
                    return COMPILER_VERSION;
                }
                if (i3 != 2) {
                    return null;
                }
                return API_VERSION;
            }
        }

        static {
            VersionRequirement versionRequirement = new VersionRequirement(true);
            defaultInstance = versionRequirement;
            versionRequirement.initFields();
        }

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        }

        public static Builder newBuilder() {
            return Builder.access$21000();
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public Level getLevel() {
            return this.level_;
        }

        public int getMessage() {
            return this.message_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<VersionRequirement> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i16 = 0 + CodedOutputStream.computeInt32Size(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i16 += CodedOutputStream.computeInt32Size(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i16 += CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                i16 += CodedOutputStream.computeInt32Size(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i16 += CodedOutputStream.computeInt32Size(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i16 += CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
            }
            int size = i16 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getVersion() {
            return this.version_;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        public boolean hasErrorCode() {
            if ((this.bitField0_ & 8) == 8) {
                return true;
            }
            return false;
        }

        public boolean hasLevel() {
            if ((this.bitField0_ & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean hasMessage() {
            if ((this.bitField0_ & 16) == 16) {
                return true;
            }
            return false;
        }

        public boolean hasVersion() {
            if ((this.bitField0_ & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean hasVersionFull() {
            if ((this.bitField0_ & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean hasVersionKind() {
            if ((this.bitField0_ & 32) == 32) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeEnum(6, this.versionKind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(VersionRequirement versionRequirement) {
            return newBuilder().mergeFrom(versionRequirement);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirement getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        VersionRequirement(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        VersionRequirement(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        VersionRequirement(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.version_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.bitField0_ |= 2;
                                this.versionFull_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                int readEnum = codedInputStream.readEnum();
                                Level valueOf = Level.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.level_ = valueOf;
                                }
                            } else if (readTag == 32) {
                                this.bitField0_ |= 8;
                                this.errorCode_ = codedInputStream.readInt32();
                            } else if (readTag == 40) {
                                this.bitField0_ |= 16;
                                this.message_ = codedInputStream.readInt32();
                            } else if (readTag != 48) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                int readEnum2 = codedInputStream.readEnum();
                                VersionKind valueOf2 = VersionKind.valueOf(readEnum2);
                                if (valueOf2 == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum2);
                                } else {
                                    this.bitField0_ |= 32;
                                    this.versionKind_ = valueOf2;
                                }
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface VersionRequirementOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes28.dex */
    public static final class VersionRequirementTable extends GeneratedMessageLite implements VersionRequirementTableOrBuilder {
        public static Parser<VersionRequirementTable> PARSER = new AbstractParser<VersionRequirementTable>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public VersionRequirementTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VersionRequirementTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final VersionRequirementTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<VersionRequirement> requirement_;
        private final ByteString unknownFields;

        /* loaded from: classes28.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirementTable, Builder> implements VersionRequirementTableOrBuilder {
            private int bitField0_;
            private List<VersionRequirement> requirement_ = Collections.emptyList();

            Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$22100() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureRequirementIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.requirement_ = new ArrayList(this.requirement_);
                    this.bitField0_ |= 1;
                }
            }

            public VersionRequirementTable buildPartial() {
                VersionRequirementTable versionRequirementTable = new VersionRequirementTable(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
                    this.bitField0_ &= -2;
                }
                versionRequirementTable.requirement_ = this.requirement_;
                return versionRequirementTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirementTable build() {
                VersionRequirementTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1777clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(VersionRequirementTable versionRequirementTable) {
                if (versionRequirementTable == VersionRequirementTable.getDefaultInstance()) {
                    return this;
                }
                if (!versionRequirementTable.requirement_.isEmpty()) {
                    if (this.requirement_.isEmpty()) {
                        this.requirement_ = versionRequirementTable.requirement_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRequirementIsMutable();
                        this.requirement_.addAll(versionRequirementTable.requirement_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(versionRequirementTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                VersionRequirementTable versionRequirementTable = null;
                try {
                    try {
                        VersionRequirementTable parsePartialFrom = VersionRequirementTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th5) {
                        th = th5;
                        if (versionRequirementTable != null) {
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    VersionRequirementTable versionRequirementTable2 = (VersionRequirementTable) e16.getUnfinishedMessage();
                    try {
                        throw e16;
                    } catch (Throwable th6) {
                        th = th6;
                        versionRequirementTable = versionRequirementTable2;
                        if (versionRequirementTable != null) {
                            mergeFrom(versionRequirementTable);
                        }
                        throw th;
                    }
                }
            }

            private void maybeForceBuilderInitialization() {
            }
        }

        static {
            VersionRequirementTable versionRequirementTable = new VersionRequirementTable(true);
            defaultInstance = versionRequirementTable;
            versionRequirementTable.initFields();
        }

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.requirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$22100();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i3 = this.memoizedSerializedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.requirement_.size(); i17++) {
                i16 += CodedOutputStream.computeMessageSize(1, this.requirement_.get(i17));
            }
            int size = i16 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i3 = 0; i3 < this.requirement_.size(); i3++) {
                codedOutputStream.writeMessage(1, this.requirement_.get(i3));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(VersionRequirementTable versionRequirementTable) {
            return newBuilder().mergeFrom(versionRequirementTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirementTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        VersionRequirementTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        VersionRequirementTable(boolean z16) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        VersionRequirementTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 10) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z17 & true)) {
                                    this.requirement_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.requirement_.add(codedInputStream.readMessage(VersionRequirement.PARSER, extensionRegistryLite));
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th5) {
                    if (z17 & true) {
                        this.requirement_ = Collections.unmodifiableList(this.requirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th6) {
                        this.unknownFields = newOutput.toByteString();
                        throw th6;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th5;
                }
            }
            if (z17 & true) {
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th7) {
                this.unknownFields = newOutput.toByteString();
                throw th7;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes28.dex */
    public interface VersionRequirementTableOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes28.dex */
    public enum Visibility implements Internal.EnumLite {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);

        private static Internal.EnumLiteMap<Visibility> internalValueMap = new Internal.EnumLiteMap<Visibility>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
            public Visibility findValueByNumber(int i3) {
                return Visibility.valueOf(i3);
            }
        };
        private final int value;

        Visibility(int i3, int i16) {
            this.value = i16;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int i3) {
            if (i3 == 0) {
                return INTERNAL;
            }
            if (i3 == 1) {
                return PRIVATE;
            }
            if (i3 == 2) {
                return PROTECTED;
            }
            if (i3 == 3) {
                return PUBLIC;
            }
            if (i3 == 4) {
                return PRIVATE_TO_THIS;
            }
            if (i3 != 5) {
                return null;
            }
            return LOCAL;
        }
    }
}
