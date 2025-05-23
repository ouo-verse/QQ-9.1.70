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
public final class IdScoreItem extends ExtendableMessageNano<IdScoreItem> {
    private static volatile IdScoreItem[] _emptyArray;
    public long roomId;
    public int roomNo;
    public long score;

    public IdScoreItem() {
        clear();
    }

    public static IdScoreItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new IdScoreItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static IdScoreItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (IdScoreItem) MessageNano.mergeFrom(new IdScoreItem(), bArr);
    }

    public IdScoreItem clear() {
        this.roomId = 0L;
        this.score = 0L;
        this.roomNo = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.score);
        int i3 = this.roomNo;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.roomId);
        codedOutputByteBufferNano.writeUInt64(2, this.score);
        int i3 = this.roomNo;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static IdScoreItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new IdScoreItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public IdScoreItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.score = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.roomNo = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
