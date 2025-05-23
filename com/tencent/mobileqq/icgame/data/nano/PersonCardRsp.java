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
public final class PersonCardRsp extends ExtendableMessageNano<PersonCardRsp> {
    private static volatile PersonCardRsp[] _emptyArray;
    public UinData[] msgUinData;

    public PersonCardRsp() {
        clear();
    }

    public static PersonCardRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PersonCardRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PersonCardRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PersonCardRsp) MessageNano.mergeFrom(new PersonCardRsp(), bArr);
    }

    public PersonCardRsp clear() {
        this.msgUinData = UinData.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UinData[] uinDataArr = this.msgUinData;
        if (uinDataArr != null && uinDataArr.length > 0) {
            int i3 = 0;
            while (true) {
                UinData[] uinDataArr2 = this.msgUinData;
                if (i3 >= uinDataArr2.length) {
                    break;
                }
                UinData uinData = uinDataArr2[i3];
                if (uinData != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, uinData);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UinData[] uinDataArr = this.msgUinData;
        if (uinDataArr != null && uinDataArr.length > 0) {
            int i3 = 0;
            while (true) {
                UinData[] uinDataArr2 = this.msgUinData;
                if (i3 >= uinDataArr2.length) {
                    break;
                }
                UinData uinData = uinDataArr2[i3];
                if (uinData != null) {
                    codedOutputByteBufferNano.writeMessage(1, uinData);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PersonCardRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PersonCardRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PersonCardRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                UinData[] uinDataArr = this.msgUinData;
                int length = uinDataArr == null ? 0 : uinDataArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UinData[] uinDataArr2 = new UinData[i3];
                if (length != 0) {
                    System.arraycopy(uinDataArr, 0, uinDataArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UinData uinData = new UinData();
                    uinDataArr2[length] = uinData;
                    codedInputByteBufferNano.readMessage(uinData);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UinData uinData2 = new UinData();
                uinDataArr2[length] = uinData2;
                codedInputByteBufferNano.readMessage(uinData2);
                this.msgUinData = uinDataArr2;
            }
        }
    }
}
