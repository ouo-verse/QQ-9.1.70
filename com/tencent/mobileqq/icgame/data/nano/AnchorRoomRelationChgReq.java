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
public final class AnchorRoomRelationChgReq extends ExtendableMessageNano<AnchorRoomRelationChgReq> {
    private static volatile AnchorRoomRelationChgReq[] _emptyArray;
    public long anchorUid;
    public int changeType;
    public long roomId;
    public long unionUin;

    public AnchorRoomRelationChgReq() {
        clear();
    }

    public static AnchorRoomRelationChgReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnchorRoomRelationChgReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnchorRoomRelationChgReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnchorRoomRelationChgReq) MessageNano.mergeFrom(new AnchorRoomRelationChgReq(), bArr);
    }

    public AnchorRoomRelationChgReq clear() {
        this.unionUin = 0L;
        this.anchorUid = 0L;
        this.roomId = 0L;
        this.changeType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.unionUin;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.anchorUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.roomId;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        int i3 = this.changeType;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.unionUin;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.anchorUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.roomId;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        int i3 = this.changeType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AnchorRoomRelationChgReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnchorRoomRelationChgReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnchorRoomRelationChgReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.unionUin = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.changeType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
