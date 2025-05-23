package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PropertyList extends ExtendableMessageNano<PropertyList> {
    private static volatile PropertyList[] _emptyArray;
    public PropertyItem[] items;

    public PropertyList() {
        clear();
    }

    public static PropertyList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PropertyList[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PropertyList parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PropertyList) MessageNano.mergeFrom(new PropertyList(), bArr);
    }

    public PropertyList clear() {
        this.items = PropertyItem.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        PropertyItem[] propertyItemArr = this.items;
        if (propertyItemArr != null && propertyItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                PropertyItem[] propertyItemArr2 = this.items;
                if (i3 >= propertyItemArr2.length) {
                    break;
                }
                PropertyItem propertyItem = propertyItemArr2[i3];
                if (propertyItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, propertyItem);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        PropertyItem[] propertyItemArr = this.items;
        if (propertyItemArr != null && propertyItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                PropertyItem[] propertyItemArr2 = this.items;
                if (i3 >= propertyItemArr2.length) {
                    break;
                }
                PropertyItem propertyItem = propertyItemArr2[i3];
                if (propertyItem != null) {
                    codedOutputByteBufferNano.writeMessage(1, propertyItem);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PropertyList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PropertyList().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PropertyList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                PropertyItem[] propertyItemArr = this.items;
                int length = propertyItemArr == null ? 0 : propertyItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                PropertyItem[] propertyItemArr2 = new PropertyItem[i3];
                if (length != 0) {
                    System.arraycopy(propertyItemArr, 0, propertyItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    PropertyItem propertyItem = new PropertyItem();
                    propertyItemArr2[length] = propertyItem;
                    codedInputByteBufferNano.readMessage(propertyItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                PropertyItem propertyItem2 = new PropertyItem();
                propertyItemArr2[length] = propertyItem2;
                codedInputByteBufferNano.readMessage(propertyItem2);
                this.items = propertyItemArr2;
            }
        }
    }
}
