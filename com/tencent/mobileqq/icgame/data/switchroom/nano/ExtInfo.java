package com.tencent.mobileqq.icgame.data.switchroom.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ExtInfo extends ExtendableMessageNano<ExtInfo> {
    private static volatile ExtInfo[] _emptyArray;
    public String key;
    public byte[] value;

    public ExtInfo() {
        clear();
    }

    public static ExtInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ExtInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ExtInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ExtInfo) MessageNano.mergeFrom(new ExtInfo(), bArr);
    }

    public ExtInfo clear() {
        this.key = "";
        this.value = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.key.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.key);
        }
        if (!Arrays.equals(this.value, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(2, this.value);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.key.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.key);
        }
        if (!Arrays.equals(this.value, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.value);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ExtInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ExtInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ExtInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.key = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.value = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
