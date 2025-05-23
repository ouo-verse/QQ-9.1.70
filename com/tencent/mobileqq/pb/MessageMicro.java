package com.tencent.mobileqq.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class MessageMicro<T extends MessageMicro<T>> extends PBPrimitiveField<T> {
    private FieldMap _fields = null;
    private int cachedSize = -1;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class FieldMap {
        private Object[] defaultValues;
        private Field[] fields;
        private int[] tags;

        FieldMap(int[] iArr, String[] strArr, Object[] objArr, Class<?> cls) {
            this.tags = iArr;
            this.defaultValues = objArr;
            this.fields = new Field[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                try {
                    this.fields[i3] = cls.getField(strArr[i3]);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        void clear(MessageMicro<?> messageMicro) throws IllegalArgumentException, IllegalAccessException {
            for (int i3 = 0; i3 < this.tags.length; i3++) {
                ((PBField) this.fields[i3].get(messageMicro)).clear(this.defaultValues[i3]);
            }
        }

        <U extends MessageMicro<U>> void copyFields(U u16, U u17) throws IllegalArgumentException, IllegalAccessException {
            for (int i3 = 0; i3 < this.tags.length; i3++) {
                Field field = this.fields[i3];
                ((PBField) field.get(u16)).copyFrom((PBField) field.get(u17));
            }
        }

        Field get(int i3) {
            int binarySearch = Arrays.binarySearch(this.tags, i3);
            if (binarySearch < 0) {
                return null;
            }
            return this.fields[binarySearch];
        }

        int getSerializedSize(MessageMicro<?> messageMicro) throws IllegalArgumentException, IllegalAccessException {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                int[] iArr = this.tags;
                if (i3 >= iArr.length) {
                    return i16;
                }
                i16 += ((PBField) this.fields[i3].get(messageMicro)).computeSize(WireFormatMicro.getTagFieldNumber(iArr[i3]));
                i3++;
            }
        }

        public boolean readFieldFrom(CodedInputStreamMicro codedInputStreamMicro, int i3, MessageMicro<?> messageMicro) throws IOException, IllegalArgumentException, IllegalAccessException, InstantiationException {
            int binarySearch = Arrays.binarySearch(this.tags, i3);
            if (binarySearch < 0) {
                return false;
            }
            ((PBField) this.fields[binarySearch].get(messageMicro)).readFrom(codedInputStreamMicro);
            return true;
        }

        void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, MessageMicro<?> messageMicro) throws IllegalArgumentException, IllegalAccessException, IOException {
            int i3 = 0;
            while (true) {
                int[] iArr = this.tags;
                if (i3 >= iArr.length) {
                    return;
                }
                ((PBField) this.fields[i3].get(messageMicro)).writeTo(codedOutputStreamMicro, WireFormatMicro.getTagFieldNumber(iArr[i3]));
                i3++;
            }
        }
    }

    private final FieldMap getFieldMap() {
        if (this._fields == null) {
            try {
                Field declaredField = getClass().getDeclaredField("__fieldMap__");
                declaredField.setAccessible(true);
                this._fields = (FieldMap) declaredField.get(this);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e16) {
                e16.printStackTrace();
            }
        }
        return this._fields;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static FieldMap initFieldMap(int[] iArr, String[] strArr, Object[] objArr, Class<?> cls) {
        return new FieldMap(iArr, strArr, objArr, cls);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        try {
            getFieldMap().clear(this);
        } catch (IllegalAccessException | IllegalArgumentException e16) {
            e16.printStackTrace();
        }
        setHasFlag(false);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i3) {
        if (has()) {
            return CodedOutputStreamMicro.computeMessageSize(i3, this);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSizeDirectly(int i3, T t16) {
        return CodedOutputStreamMicro.computeMessageSize(i3, t16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void copyFrom(PBField<T> pBField) {
        try {
            getFieldMap().copyFields(this, (MessageMicro) pBField);
            setHasFlag(((MessageMicro) pBField).has());
        } catch (IllegalAccessException | IllegalArgumentException e16) {
            e16.printStackTrace();
        }
    }

    public final int getCachedSize() {
        return getSerializedSize();
    }

    public final int getSerializedSize() {
        int i3;
        try {
            i3 = getFieldMap().getSerializedSize(this);
        } catch (IllegalAccessException | IllegalArgumentException e16) {
            e16.printStackTrace();
            i3 = -1;
        }
        this.cachedSize = i3;
        return i3;
    }

    public final T mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        FieldMap fieldMap = getFieldMap();
        setHasFlag(true);
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            try {
                if (!fieldMap.readFieldFrom(codedInputStreamMicro, readTag, this) && (readTag == 0 || !parseUnknownField(codedInputStreamMicro, readTag))) {
                    return this;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException e16) {
                e16.printStackTrace();
            }
        }
    }

    protected boolean parseUnknownField(CodedInputStreamMicro codedInputStreamMicro, int i3) throws IOException {
        return codedInputStreamMicro.skipField(i3);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        codedInputStreamMicro.readMessage(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public T readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        try {
            T t16 = (T) getClass().newInstance();
            codedInputStreamMicro.readMessage(t16);
            return t16;
        } catch (IllegalAccessException | InstantiationException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void set(T t16) {
        set(t16, true);
    }

    public final void toByteArray(byte[] bArr, int i3, int i16) {
        try {
            CodedOutputStreamMicro newInstance = CodedOutputStreamMicro.newInstance(bArr, i3, i16);
            writeTo(newInstance);
            newInstance.checkNoSpaceLeft();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public final void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        try {
            getFieldMap().writeTo(codedOutputStreamMicro, this);
        } catch (IllegalAccessException | IllegalArgumentException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i3, T t16) throws IOException {
        codedOutputStreamMicro.writeMessage(i3, t16);
    }

    public static final <T extends MessageMicro<T>> T mergeFrom(T t16, byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (T) t16.mergeFrom(bArr);
    }

    public void set(T t16, boolean z16) {
        copyFrom(t16);
        setHasFlag(z16);
        this.cachedSize = -1;
    }

    public final byte[] toByteArray() {
        int serializedSize = getSerializedSize();
        byte[] bArr = new byte[serializedSize];
        toByteArray(bArr, 0, serializedSize);
        return bArr;
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i3) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeMessage(i3, this);
        }
    }

    public static final byte[] toByteArray(MessageMicro<?> messageMicro) {
        return messageMicro.toByteArray();
    }

    public final T mergeFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return mergeFrom(bArr, 0, bArr.length);
    }

    public final T mergeFrom(byte[] bArr, int i3, int i16) throws InvalidProtocolBufferMicroException {
        try {
            CodedInputStreamMicro newInstance = CodedInputStreamMicro.newInstance(bArr, i3, i16);
            mergeFrom(newInstance);
            newInstance.checkLastTagWas(0);
            return this;
        } catch (InvalidProtocolBufferMicroException e16) {
            throw e16;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public T get() {
        return this;
    }

    public static void main(String[] strArr) throws Exception {
    }
}
