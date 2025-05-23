package com.tencent.mobileqq.icgame.data.diff.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetMicStatusReq extends ExtendableMessageNano<SetMicStatusReq> {
    private static volatile SetMicStatusReq[] _emptyArray;
    public boolean boolStatus;
    public int roomId;
    public long uid;

    public SetMicStatusReq() {
        clear();
    }

    public static SetMicStatusReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetMicStatusReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetMicStatusReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetMicStatusReq) MessageNano.mergeFrom(new SetMicStatusReq(), bArr);
    }

    public SetMicStatusReq clear() {
        this.roomId = 0;
        this.uid = 0L;
        this.boolStatus = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.uid) + CodedOutputByteBufferNano.computeBoolSize(3, this.boolStatus);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt64(2, this.uid);
        codedOutputByteBufferNano.writeBool(3, this.boolStatus);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetMicStatusReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetMicStatusReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetMicStatusReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.boolStatus = codedInputByteBufferNano.readBool();
            }
        }
    }
}
