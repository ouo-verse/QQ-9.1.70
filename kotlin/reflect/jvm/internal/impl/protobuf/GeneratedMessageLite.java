package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i3, WireFormat.FieldType fieldType, boolean z16, boolean z17) {
            this.enumTypeMap = enumLiteMap;
            this.number = i3;
            this.type = fieldType;
            this.isRepeated = z16;
            this.isPacked = z17;
        }

        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // java.lang.Comparable
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.number - extensionDescriptor.number;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final Method enumValueOf;
        final MessageLite messageDefaultInstance;
        final Class singularType;

        GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype != null) {
                if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.containingTypeDefaultInstance = containingtype;
                this.defaultValue = type;
                this.messageDefaultInstance = messageLite;
                this.descriptor = extensionDescriptor;
                this.singularType = cls;
                if (Internal.EnumLite.class.isAssignableFrom(cls)) {
                    this.enumValueOf = GeneratedMessageLite.getMethodOrDie(cls, "valueOf", Integer.TYPE);
                    return;
                } else {
                    this.enumValueOf = null;
                    return;
                }
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        Object fromFieldSetType(Object obj) {
            if (this.descriptor.isRepeated()) {
                if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((List) obj).iterator();
                    while (it.hasNext()) {
                        arrayList.add(singularFromFieldSetType(it.next()));
                    }
                    return arrayList;
                }
                return obj;
            }
            return singularFromFieldSetType(obj);
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        Object singularFromFieldSetType(Object obj) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, (Integer) obj);
            }
            return obj;
        }

        Object singularToFieldSetType(Object obj) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return Integer.valueOf(((Internal.EnumLite) obj).getNumber());
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessageLite() {
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e16) {
            String name = cls.getName();
            String valueOf = String.valueOf(str);
            StringBuilder sb5 = new StringBuilder(name.length() + 45 + valueOf.length());
            sb5.append("Generated message class \"");
            sb5.append(name);
            sb5.append("\" missing method \"");
            sb5.append(valueOf);
            sb5.append("\".");
            throw new RuntimeException(sb5.toString(), e16);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e16) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e16);
        } catch (InvocationTargetException e17) {
            Throwable cause = e17.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i3, WireFormat.FieldType fieldType, boolean z16, Class cls) {
        return new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i3, fieldType, true, z16), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i3, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension<>(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i3, fieldType, false, false), cls);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i3) throws IOException {
        return codedInputStream.skipField(i3, codedOutputStream);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        private ByteString unknownFields = ByteString.EMPTY;

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public abstract MessageType getDefaultInstanceForType();

        public final ByteString getUnknownFields() {
            return this.unknownFields;
        }

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public final BuilderType setUnknownFields(ByteString byteString) {
            this.unknownFields = byteString;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo1777clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        private final FieldSet<ExtensionDescriptor> extensions;

        /* JADX INFO: Access modifiers changed from: protected */
        /* compiled from: P */
        /* loaded from: classes28.dex */
        public class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z16, AnonymousClass1 anonymousClass1) {
                this(z16);
            }

            public void writeUntil(int i3, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<ExtensionDescriptor, Object> entry = this.next;
                    if (entry != null && entry.getKey().getNumber() < i3) {
                        ExtensionDescriptor key = this.next.getKey();
                        if (this.messageSetWireFormat && key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated()) {
                            codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.next.getValue());
                        } else {
                            FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                        }
                        if (this.iter.hasNext()) {
                            this.next = this.iter.next();
                        } else {
                            this.next = null;
                        }
                    } else {
                        return;
                    }
                }
            }

            ExtensionWriter(boolean z16) {
                Iterator<Map.Entry<ExtensionDescriptor, Object>> it = ExtendableMessage.this.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = it.next();
                }
                this.messageSetWireFormat = z16;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType()) {
            } else {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Object field = this.extensions.getField(generatedExtension.descriptor);
            if (field == null) {
                return generatedExtension.defaultValue;
            }
            return (Type) generatedExtension.fromFieldSetType(field);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.descriptor);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i3) throws IOException {
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, codedOutputStream, extensionRegistryLite, i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            this.extensions = extendableBuilder.buildExtensions();
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i3) {
            verifyExtensionContainingType(generatedExtension);
            return (Type) generatedExtension.singularFromFieldSetType(this.extensions.getRepeatedField(generatedExtension.descriptor, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessageLite(Builder builder) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> fieldSet, MessageType messagetype, CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i3) throws IOException {
        boolean z16;
        boolean z17;
        Object build;
        MessageLite messageLite;
        int tagWireType = WireFormat.getTagWireType(i3);
        GeneratedExtension findLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(messagetype, WireFormat.getTagFieldNumber(i3));
        if (findLiteExtensionByNumber != null) {
            if (tagWireType == FieldSet.getWireFormatForFieldType(findLiteExtensionByNumber.descriptor.getLiteType(), false)) {
                z17 = false;
                z16 = false;
            } else {
                ExtensionDescriptor extensionDescriptor = findLiteExtensionByNumber.descriptor;
                if (extensionDescriptor.isRepeated && extensionDescriptor.type.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(findLiteExtensionByNumber.descriptor.getLiteType(), true)) {
                    z16 = true;
                    z17 = false;
                }
            }
            if (!z17) {
                return codedInputStream.skipField(i3, codedOutputStream);
            }
            if (z16) {
                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                if (findLiteExtensionByNumber.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
                    while (codedInputStream.getBytesUntilLimit() > 0) {
                        Object findValueByNumber = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                        if (findValueByNumber == null) {
                            return true;
                        }
                        fieldSet.addRepeatedField(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(findValueByNumber));
                    }
                } else {
                    while (codedInputStream.getBytesUntilLimit() > 0) {
                        fieldSet.addRepeatedField(findLiteExtensionByNumber.descriptor, FieldSet.readPrimitiveField(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType(), false));
                    }
                }
                codedInputStream.popLimit(pushLimit);
            } else {
                int i16 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[findLiteExtensionByNumber.descriptor.getLiteJavaType().ordinal()];
                if (i16 == 1) {
                    MessageLite.Builder builder = (findLiteExtensionByNumber.descriptor.isRepeated() || (messageLite = (MessageLite) fieldSet.getField(findLiteExtensionByNumber.descriptor)) == null) ? null : messageLite.toBuilder();
                    if (builder == null) {
                        builder = findLiteExtensionByNumber.getMessageDefaultInstance().newBuilderForType();
                    }
                    if (findLiteExtensionByNumber.descriptor.getLiteType() == WireFormat.FieldType.f412759GROUP) {
                        codedInputStream.readGroup(findLiteExtensionByNumber.getNumber(), builder, extensionRegistryLite);
                    } else {
                        codedInputStream.readMessage(builder, extensionRegistryLite);
                    }
                    build = builder.build();
                } else if (i16 != 2) {
                    build = FieldSet.readPrimitiveField(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType(), false);
                } else {
                    int readEnum = codedInputStream.readEnum();
                    Object findValueByNumber2 = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(readEnum);
                    if (findValueByNumber2 == null) {
                        codedOutputStream.writeRawVarint32(i3);
                        codedOutputStream.writeUInt32NoTag(readEnum);
                        return true;
                    }
                    build = findValueByNumber2;
                }
                if (findLiteExtensionByNumber.descriptor.isRepeated()) {
                    fieldSet.addRepeatedField(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(build));
                } else {
                    fieldSet.setField(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(build));
                }
            }
            return true;
        }
        z17 = true;
        z16 = false;
        if (!z17) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<ExtensionDescriptor> extensions = FieldSet.emptySet();
        private boolean extensionsIsMutable;

        /* JADX INFO: Access modifiers changed from: private */
        public FieldSet<ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (!this.extensionsIsMutable) {
                this.extensions = this.extensions.clone();
                this.extensionsIsMutable = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void mergeExtensionFields(MessageType messagetype) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(((ExtendableMessage) messagetype).extensions);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo1777clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void makeExtensionsImmutable() {
    }
}
