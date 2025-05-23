package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetDrawGuessPicReq extends ExtendableMessageNano<GetDrawGuessPicReq> {
    private static volatile GetDrawGuessPicReq[] _emptyArray;
    public int limit;
    public long roomId;
    public int start;
    public int type;

    public GetDrawGuessPicReq() {
        clear();
    }

    public static GetDrawGuessPicReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetDrawGuessPicReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetDrawGuessPicReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetDrawGuessPicReq) MessageNano.mergeFrom(new GetDrawGuessPicReq(), bArr);
    }

    public GetDrawGuessPicReq clear() {
        this.start = 0;
        this.limit = 0;
        this.type = 0;
        this.roomId = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.start;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.limit;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.type;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.start;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.limit;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.type;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetDrawGuessPicReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetDrawGuessPicReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetDrawGuessPicReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.start = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.limit = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.roomId = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
