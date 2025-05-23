package com.google.protobuf.nano;

import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class ExtendableMessageNano<M extends ExtendableMessageNano<M>> extends MessageNano {
    protected FieldArray unknownFieldData;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        if (this.unknownFieldData == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.unknownFieldData.size(); i16++) {
            i3 += this.unknownFieldData.dataAt(i16).computeSerializedSize();
        }
        return i3;
    }

    public final <T> T getExtension(Extension<M, T> extension) {
        FieldData fieldData;
        FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray == null || (fieldData = fieldArray.get(WireFormatNano.getTagFieldNumber(extension.tag))) == null) {
            return null;
        }
        return (T) fieldData.getValue(extension);
    }

    public final boolean hasExtension(Extension<M, ?> extension) {
        FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray == null || fieldArray.get(WireFormatNano.getTagFieldNumber(extension.tag)) == null) {
            return false;
        }
        return true;
    }

    public final <T> M setExtension(Extension<M, T> extension, T t16) {
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(extension.tag);
        FieldData fieldData = null;
        if (t16 == null) {
            FieldArray fieldArray = this.unknownFieldData;
            if (fieldArray != null) {
                fieldArray.remove(tagFieldNumber);
                if (this.unknownFieldData.isEmpty()) {
                    this.unknownFieldData = null;
                }
            }
        } else {
            FieldArray fieldArray2 = this.unknownFieldData;
            if (fieldArray2 == null) {
                this.unknownFieldData = new FieldArray();
            } else {
                fieldData = fieldArray2.get(tagFieldNumber);
            }
            if (fieldData == null) {
                this.unknownFieldData.put(tagFieldNumber, new FieldData(extension, t16));
            } else {
                fieldData.setValue(extension, t16);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean storeUnknownField(CodedInputByteBufferNano codedInputByteBufferNano, int i3) throws IOException {
        FieldData fieldData;
        int position = codedInputByteBufferNano.getPosition();
        if (!codedInputByteBufferNano.skipField(i3)) {
            return false;
        }
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(i3);
        UnknownFieldData unknownFieldData = new UnknownFieldData(i3, codedInputByteBufferNano.getData(position, codedInputByteBufferNano.getPosition() - position));
        FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray == null) {
            this.unknownFieldData = new FieldArray();
            fieldData = null;
        } else {
            fieldData = fieldArray.get(tagFieldNumber);
        }
        if (fieldData == null) {
            fieldData = new FieldData();
            this.unknownFieldData.put(tagFieldNumber, fieldData);
        }
        fieldData.addUnknownField(unknownFieldData);
        return true;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (this.unknownFieldData == null) {
            return;
        }
        for (int i3 = 0; i3 < this.unknownFieldData.size(); i3++) {
            this.unknownFieldData.dataAt(i3).writeTo(codedOutputByteBufferNano);
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: clone */
    public M mo66clone() throws CloneNotSupportedException {
        M m3 = (M) super.mo66clone();
        InternalNano.cloneUnknownFieldData(this, m3);
        return m3;
    }
}
