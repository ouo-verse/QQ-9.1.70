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
public final class SetDrawStatusReq extends ExtendableMessageNano<SetDrawStatusReq> {
    private static volatile SetDrawStatusReq[] _emptyArray;
    public long roomId;
    public int srcStatus;
    public String startSeq;
    public long uid;

    public SetDrawStatusReq() {
        clear();
    }

    public static SetDrawStatusReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetDrawStatusReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetDrawStatusReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetDrawStatusReq) MessageNano.mergeFrom(new SetDrawStatusReq(), bArr);
    }

    public SetDrawStatusReq clear() {
        this.uid = 0L;
        this.roomId = 0L;
        this.srcStatus = 0;
        this.startSeq = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.roomId;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        int i3 = this.srcStatus;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.startSeq.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.startSeq);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.roomId;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        int i3 = this.srcStatus;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.startSeq.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.startSeq);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetDrawStatusReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetDrawStatusReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetDrawStatusReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.srcStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.startSeq = codedInputByteBufferNano.readString();
            }
        }
    }
}
