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
public final class GetMeleeInfoReq extends ExtendableMessageNano<GetMeleeInfoReq> {
    private static volatile GetMeleeInfoReq[] _emptyArray;
    public int meleeBasicinfoReq;
    public int meleeScoreReq;
    public int roomId;

    public GetMeleeInfoReq() {
        clear();
    }

    public static GetMeleeInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetMeleeInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetMeleeInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetMeleeInfoReq) MessageNano.mergeFrom(new GetMeleeInfoReq(), bArr);
    }

    public GetMeleeInfoReq clear() {
        this.roomId = 0;
        this.meleeBasicinfoReq = 0;
        this.meleeScoreReq = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        int i3 = this.meleeBasicinfoReq;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.meleeScoreReq;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        int i3 = this.meleeBasicinfoReq;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.meleeScoreReq;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetMeleeInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetMeleeInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetMeleeInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.meleeBasicinfoReq = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.meleeScoreReq = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
