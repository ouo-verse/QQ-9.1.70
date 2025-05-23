package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.ad;
import com.google.protobuf.ar;
import com.google.protobuf.b;
import com.google.protobuf.cc;
import com.tencent.thumbplayer.api.common.TPErrorType;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class a extends com.google.protobuf.b implements ar {
    protected int memoizedSize = -1;

    /* compiled from: P */
    /* renamed from: com.google.protobuf.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0252a<BuilderType extends AbstractC0252a<BuilderType>> extends b.a implements ar.a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException newUninitializedMessageException(ar arVar) {
            return new UninitializedMessageException(MessageReflection.c(arVar));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dispose() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        public List<String> findInitializationErrors() {
            return MessageReflection.c(this);
        }

        public ar.a getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        }

        public String getInitializationErrorString() {
            return MessageReflection.a(findInitializationErrors());
        }

        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar) {
            throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        }

        public ar.a getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i3) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
        }

        public boolean hasOneof(Descriptors.g gVar) {
            throw new UnsupportedOperationException("hasOneof() is not implemented.");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void markClean() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        @Override // com.google.protobuf.b.a
        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return super.mergeDelimitedFrom(inputStream);
        }

        public String toString() {
            return TextFormat.n().j(this);
        }

        @Override // 
        public BuilderType clearOneof(Descriptors.g gVar) {
            throw new UnsupportedOperationException("clearOneof() is not implemented.");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.b.a
        public BuilderType internalMergeFrom(com.google.protobuf.b bVar) {
            return mergeFrom((ar) bVar);
        }

        @Override // com.google.protobuf.b.a
        public boolean mergeDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return super.mergeDelimitedFrom(inputStream, tVar);
        }

        @Override // 
        /* renamed from: mergeUnknownFields */
        public BuilderType mo52mergeUnknownFields(cc ccVar) {
            setUnknownFields(cc.h(getUnknownFields()).p(ccVar).build());
            return this;
        }

        @Override // 
        public BuilderType clear() {
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> it = getAllFields().entrySet().iterator();
            while (it.hasNext()) {
                clearField(it.next().getKey());
            }
            return this;
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: clone */
        public BuilderType mo50clone() {
            throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
        }

        public BuilderType mergeFrom(ar arVar) {
            return mergeFrom(arVar, arVar.getAllFields());
        }

        BuilderType mergeFrom(ar arVar, Map<Descriptors.FieldDescriptor, Object> map) {
            if (arVar.getDescriptorForType() == getDescriptorForType()) {
                for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
                    Descriptors.FieldDescriptor key = entry.getKey();
                    if (key.isRepeated()) {
                        Iterator it = ((List) entry.getValue()).iterator();
                        while (it.hasNext()) {
                            addRepeatedField(key, it.next());
                        }
                    } else if (key.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        ar arVar2 = (ar) getField(key);
                        if (arVar2 == arVar2.getDefaultInstanceForType()) {
                            setField(key, entry.getValue());
                        } else {
                            setField(key, arVar2.newBuilderForType().mergeFrom(arVar2).mergeFrom((ar) entry.getValue()).build());
                        }
                    } else {
                        setField(key, entry.getValue());
                    }
                }
                mo52mergeUnknownFields(arVar.getUnknownFields());
                return this;
            }
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(k kVar) throws IOException {
            return mergeFrom(kVar, (t) r.f());
        }

        @Override // com.google.protobuf.b.a, com.google.protobuf.au.a
        public BuilderType mergeFrom(k kVar, t tVar) throws IOException {
            int J;
            cc.b h16 = kVar.M() ? null : cc.h(getUnknownFields());
            do {
                J = kVar.J();
                if (J == 0) {
                    break;
                }
            } while (MessageReflection.g(kVar, h16, tVar, getDescriptorForType(), new MessageReflection.b(this), J));
            if (h16 != null) {
                setUnknownFields(h16.build());
            }
            return this;
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(byteString);
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(byteString, tVar);
        }

        @Override // com.google.protobuf.b.a, com.google.protobuf.au.a
        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(bArr);
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom */
        public BuilderType mo58mergeFrom(byte[] bArr, int i3, int i16) throws InvalidProtocolBufferException {
            return (BuilderType) super.mo58mergeFrom(bArr, i3, i16);
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(bArr, tVar);
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom */
        public BuilderType mo59mergeFrom(byte[] bArr, int i3, int i16, t tVar) throws InvalidProtocolBufferException {
            return (BuilderType) super.mo59mergeFrom(bArr, i3, i16, tVar);
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            return (BuilderType) super.mergeFrom(inputStream);
        }

        @Override // com.google.protobuf.b.a
        public BuilderType mergeFrom(InputStream inputStream, t tVar) throws IOException {
            return (BuilderType) super.mergeFrom(inputStream, tVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    private static boolean compareBytes(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        return toByteString(obj).equals(toByteString(obj2));
    }

    static boolean compareFields(Map<Descriptors.FieldDescriptor, Object> map, Map<Descriptors.FieldDescriptor, Object> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Descriptors.FieldDescriptor fieldDescriptor : map.keySet()) {
            if (!map2.containsKey(fieldDescriptor)) {
                return false;
            }
            Object obj = map.get(fieldDescriptor);
            Object obj2 = map2.get(fieldDescriptor);
            if (fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.BYTES) {
                if (fieldDescriptor.isRepeated()) {
                    List list = (List) obj;
                    List list2 = (List) obj2;
                    if (list.size() != list2.size()) {
                        return false;
                    }
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        if (!compareBytes(list.get(i3), list2.get(i3))) {
                            return false;
                        }
                    }
                } else if (!compareBytes(obj, obj2)) {
                    return false;
                }
            } else if (fieldDescriptor.A()) {
                if (!compareMapField(obj, obj2)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean compareMapField(Object obj, Object obj2) {
        return MapFieldLite.equals(convertMapEntryListToMap((List) obj), convertMapEntryListToMap((List) obj2));
    }

    private static Map convertMapEntryListToMap(List list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        ar arVar = (ar) it.next();
        Descriptors.b descriptorForType = arVar.getDescriptorForType();
        Descriptors.FieldDescriptor n3 = descriptorForType.n("key");
        Descriptors.FieldDescriptor n16 = descriptorForType.n("value");
        Object field = arVar.getField(n16);
        if (field instanceof Descriptors.d) {
            field = Integer.valueOf(((Descriptors.d) field).getNumber());
        }
        hashMap.put(arVar.getField(n3), field);
        while (it.hasNext()) {
            ar arVar2 = (ar) it.next();
            Object field2 = arVar2.getField(n16);
            if (field2 instanceof Descriptors.d) {
                field2 = Integer.valueOf(((Descriptors.d) field2).getNumber());
            }
            hashMap.put(arVar2.getField(n3), field2);
        }
        return hashMap;
    }

    @Deprecated
    protected static int hashBoolean(boolean z16) {
        if (z16) {
            return TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM;
        }
        return 1237;
    }

    @Deprecated
    protected static int hashEnum(ad.c cVar) {
        return cVar.getNumber();
    }

    @Deprecated
    protected static int hashEnumList(List<? extends ad.c> list) {
        Iterator<? extends ad.c> it = list.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            i3 = (i3 * 31) + hashEnum(it.next());
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int hashFields(int i3, Map<Descriptors.FieldDescriptor, Object> map) {
        int i16;
        int f16;
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            int number = (i3 * 37) + key.getNumber();
            if (key.A()) {
                i16 = number * 53;
                f16 = hashMapField(value);
            } else if (key.y() != Descriptors.FieldDescriptor.Type.ENUM) {
                i16 = number * 53;
                f16 = value.hashCode();
            } else if (key.isRepeated()) {
                i16 = number * 53;
                f16 = ad.g((List) value);
            } else {
                i16 = number * 53;
                f16 = ad.f((ad.c) value);
            }
            i3 = i16 + f16;
        }
        return i3;
    }

    @Deprecated
    protected static int hashLong(long j3) {
        return (int) (j3 ^ (j3 >>> 32));
    }

    private static int hashMapField(Object obj) {
        return MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((List) obj));
    }

    private static ByteString toByteString(Object obj) {
        if (obj instanceof byte[]) {
            return ByteString.copyFrom((byte[]) obj);
        }
        return (ByteString) obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ar)) {
            return false;
        }
        ar arVar = (ar) obj;
        if (getDescriptorForType() != arVar.getDescriptorForType()) {
            return false;
        }
        if (compareFields(getAllFields(), arVar.getAllFields()) && getUnknownFields().equals(arVar.getUnknownFields())) {
            return true;
        }
        return false;
    }

    public List<String> findInitializationErrors() {
        return MessageReflection.c(this);
    }

    public String getInitializationErrorString() {
        return MessageReflection.a(findInitializationErrors());
    }

    @Override // com.google.protobuf.b
    int getMemoizedSerializedSize() {
        return this.memoizedSize;
    }

    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    @Override // com.google.protobuf.au
    public int getSerializedSize() {
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        int e16 = MessageReflection.e(this, getAllFields());
        this.memoizedSize = e16;
        return e16;
    }

    public boolean hasOneof(Descriptors.g gVar) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    public int hashCode() {
        int i3 = this.memoizedHashCode;
        if (i3 == 0) {
            int hashFields = (hashFields(com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptorForType().hashCode(), getAllFields()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }
        return i3;
    }

    @Override // com.google.protobuf.av
    public boolean isInitialized() {
        return MessageReflection.f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ar.a newBuilderForType(b bVar) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.b
    public UninitializedMessageException newUninitializedMessageException() {
        return AbstractC0252a.newUninitializedMessageException((ar) this);
    }

    @Override // com.google.protobuf.b
    void setMemoizedSerializedSize(int i3) {
        this.memoizedSize = i3;
    }

    public final String toString() {
        return TextFormat.n().j(this);
    }

    @Override // com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MessageReflection.k(this, getAllFields(), codedOutputStream, false);
    }
}
