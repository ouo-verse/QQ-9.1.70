package com.google.protobuf.nano;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class FieldData implements Cloneable {
    private Extension<?, ?> cachedExtension;
    private List<UnknownFieldData> unknownFieldData;
    private Object value;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> FieldData(Extension<?, T> extension, T t16) {
        this.cachedExtension = extension;
        this.value = t16;
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[computeSerializedSize()];
        writeTo(CodedOutputByteBufferNano.newInstance(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addUnknownField(UnknownFieldData unknownFieldData) {
        this.unknownFieldData.add(unknownFieldData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int computeSerializedSize() {
        Object obj = this.value;
        if (obj != null) {
            return this.cachedExtension.computeSerializedSize(obj);
        }
        Iterator<UnknownFieldData> it = this.unknownFieldData.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().computeSerializedSize();
        }
        return i3;
    }

    public boolean equals(Object obj) {
        List<UnknownFieldData> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldData)) {
            return false;
        }
        FieldData fieldData = (FieldData) obj;
        if (this.value != null && fieldData.value != null) {
            Extension<?, ?> extension = this.cachedExtension;
            if (extension != fieldData.cachedExtension) {
                return false;
            }
            if (!extension.clazz.isArray()) {
                return this.value.equals(fieldData.value);
            }
            Object obj2 = this.value;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) fieldData.value);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) fieldData.value);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) fieldData.value);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) fieldData.value);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) fieldData.value);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) fieldData.value);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) fieldData.value);
        }
        List<UnknownFieldData> list2 = this.unknownFieldData;
        if (list2 != null && (list = fieldData.unknownFieldData) != null) {
            return list2.equals(list);
        }
        try {
            return Arrays.equals(toByteArray(), fieldData.toByteArray());
        } catch (IOException e16) {
            throw new IllegalStateException(e16);
        }
    }

    UnknownFieldData getUnknownField(int i3) {
        List<UnknownFieldData> list = this.unknownFieldData;
        if (list == null || i3 >= list.size()) {
            return null;
        }
        return this.unknownFieldData.get(i3);
    }

    int getUnknownFieldSize() {
        List<UnknownFieldData> list = this.unknownFieldData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getValue(Extension<?, T> extension) {
        if (this.value != null) {
            if (this.cachedExtension != extension) {
                throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
            }
        } else {
            this.cachedExtension = extension;
            this.value = extension.getValueFrom(this.unknownFieldData);
            this.unknownFieldData = null;
        }
        return (T) this.value;
    }

    public int hashCode() {
        try {
            return 527 + Arrays.hashCode(toByteArray());
        } catch (IOException e16) {
            throw new IllegalStateException(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void setValue(Extension<?, T> extension, T t16) {
        this.cachedExtension = extension;
        this.value = t16;
        this.unknownFieldData = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Object obj = this.value;
        if (obj != null) {
            this.cachedExtension.writeTo(obj, codedOutputByteBufferNano);
            return;
        }
        Iterator<UnknownFieldData> it = this.unknownFieldData.iterator();
        while (it.hasNext()) {
            it.next().writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final FieldData m68clone() {
        FieldData fieldData = new FieldData();
        try {
            fieldData.cachedExtension = this.cachedExtension;
            List<UnknownFieldData> list = this.unknownFieldData;
            if (list == null) {
                fieldData.unknownFieldData = null;
            } else {
                fieldData.unknownFieldData.addAll(list);
            }
            Object obj = this.value;
            if (obj != null) {
                if (obj instanceof MessageNano) {
                    fieldData.value = ((MessageNano) obj).mo66clone();
                } else if (obj instanceof byte[]) {
                    fieldData.value = ((byte[]) obj).clone();
                } else {
                    int i3 = 0;
                    if (obj instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) obj;
                        byte[][] bArr2 = new byte[bArr.length];
                        fieldData.value = bArr2;
                        while (i3 < bArr.length) {
                            bArr2[i3] = (byte[]) bArr[i3].clone();
                            i3++;
                        }
                    } else if (obj instanceof boolean[]) {
                        fieldData.value = ((boolean[]) obj).clone();
                    } else if (obj instanceof int[]) {
                        fieldData.value = ((int[]) obj).clone();
                    } else if (obj instanceof long[]) {
                        fieldData.value = ((long[]) obj).clone();
                    } else if (obj instanceof float[]) {
                        fieldData.value = ((float[]) obj).clone();
                    } else if (obj instanceof double[]) {
                        fieldData.value = ((double[]) obj).clone();
                    } else if (obj instanceof MessageNano[]) {
                        MessageNano[] messageNanoArr = (MessageNano[]) obj;
                        MessageNano[] messageNanoArr2 = new MessageNano[messageNanoArr.length];
                        fieldData.value = messageNanoArr2;
                        while (i3 < messageNanoArr.length) {
                            messageNanoArr2[i3] = messageNanoArr[i3].mo66clone();
                            i3++;
                        }
                    }
                }
            }
            return fieldData;
        } catch (CloneNotSupportedException e16) {
            throw new AssertionError(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldData() {
        this.unknownFieldData = new ArrayList();
    }
}
