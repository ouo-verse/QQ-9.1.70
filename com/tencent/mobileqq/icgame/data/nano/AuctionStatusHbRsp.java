package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AuctionStatusHbRsp extends ExtendableMessageNano<AuctionStatusHbRsp> {
    private static volatile AuctionStatusHbRsp[] _emptyArray;
    public int hbInterval;
    public int result;

    public AuctionStatusHbRsp() {
        clear();
    }

    public static AuctionStatusHbRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AuctionStatusHbRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AuctionStatusHbRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AuctionStatusHbRsp) MessageNano.mergeFrom(new AuctionStatusHbRsp(), bArr);
    }

    public AuctionStatusHbRsp clear() {
        this.hbInterval = 1;
        this.result = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.hbInterval;
        if (i3 != 1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.result;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.hbInterval;
        if (i3 != 1) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.result;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AuctionStatusHbRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AuctionStatusHbRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AuctionStatusHbRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.hbInterval = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.result = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
