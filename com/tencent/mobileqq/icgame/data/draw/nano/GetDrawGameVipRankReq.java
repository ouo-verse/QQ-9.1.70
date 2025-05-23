package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetDrawGameVipRankReq extends ExtendableMessageNano<GetDrawGameVipRankReq> {
    private static volatile GetDrawGameVipRankReq[] _emptyArray;
    public int needContributor;
    public long roomId;
    public String startSeq;

    public GetDrawGameVipRankReq() {
        clear();
    }

    public static GetDrawGameVipRankReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetDrawGameVipRankReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetDrawGameVipRankReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetDrawGameVipRankReq) MessageNano.mergeFrom(new GetDrawGameVipRankReq(), bArr);
    }

    public GetDrawGameVipRankReq clear() {
        this.roomId = 0L;
        this.startSeq = "";
        this.needContributor = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.startSeq.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.startSeq);
        }
        int i3 = this.needContributor;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.startSeq.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.startSeq);
        }
        int i3 = this.needContributor;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetDrawGameVipRankReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetDrawGameVipRankReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetDrawGameVipRankReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.startSeq = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.needContributor = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
