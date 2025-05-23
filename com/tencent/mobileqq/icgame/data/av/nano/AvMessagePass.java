package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes15.dex */
public final class AvMessagePass extends ExtendableMessageNano<AvMessagePass> {
    private static volatile AvMessagePass[] _emptyArray;
    public byte[] data;
    public byte[] header;
    public int msgId;

    public AvMessagePass() {
        clear();
    }

    public static AvMessagePass[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AvMessagePass[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AvMessagePass parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AvMessagePass) MessageNano.mergeFrom(new AvMessagePass(), bArr);
    }

    public AvMessagePass clear() {
        this.msgId = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.data = bArr;
        this.header = bArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.msgId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        byte[] bArr = this.data;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.data);
        }
        if (!Arrays.equals(this.header, bArr2)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(3, this.header);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.msgId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        byte[] bArr = this.data;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.data);
        }
        if (!Arrays.equals(this.header, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.header);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AvMessagePass parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AvMessagePass().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AvMessagePass mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.msgId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.data = codedInputByteBufferNano.readBytes();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.header = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
