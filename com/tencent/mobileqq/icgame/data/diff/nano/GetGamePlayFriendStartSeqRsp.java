package com.tencent.mobileqq.icgame.data.diff.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetGamePlayFriendStartSeqRsp extends ExtendableMessageNano<GetGamePlayFriendStartSeqRsp> {
    private static volatile GetGamePlayFriendStartSeqRsp[] _emptyArray;
    public int roomId;
    public long startSeq;

    public GetGamePlayFriendStartSeqRsp() {
        clear();
    }

    public static GetGamePlayFriendStartSeqRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGamePlayFriendStartSeqRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGamePlayFriendStartSeqRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGamePlayFriendStartSeqRsp) MessageNano.mergeFrom(new GetGamePlayFriendStartSeqRsp(), bArr);
    }

    public GetGamePlayFriendStartSeqRsp clear() {
        this.roomId = 0;
        this.startSeq = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.startSeq;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.startSeq;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetGamePlayFriendStartSeqRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGamePlayFriendStartSeqRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGamePlayFriendStartSeqRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.startSeq = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
