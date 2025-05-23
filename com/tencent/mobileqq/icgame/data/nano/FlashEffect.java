package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class FlashEffect extends ExtendableMessageNano<FlashEffect> {
    private static volatile FlashEffect[] _emptyArray;
    public int type;
    public byte[] url;

    public FlashEffect() {
        clear();
    }

    public static FlashEffect[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FlashEffect[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FlashEffect parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FlashEffect) MessageNano.mergeFrom(new FlashEffect(), bArr);
    }

    public FlashEffect clear() {
        this.type = 0;
        this.url = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.type) + CodedOutputByteBufferNano.computeBytesSize(2, this.url);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.type);
        codedOutputByteBufferNano.writeBytes(2, this.url);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FlashEffect parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FlashEffect().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FlashEffect mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.url = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
