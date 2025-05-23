package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetLiveAddrReq extends ExtendableMessageNano<SetLiveAddrReq> {
    private static volatile SetLiveAddrReq[] _emptyArray;
    public long roomId;
    public String rtmp;

    public SetLiveAddrReq() {
        clear();
    }

    public static SetLiveAddrReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetLiveAddrReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetLiveAddrReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetLiveAddrReq) MessageNano.mergeFrom(new SetLiveAddrReq(), bArr);
    }

    public SetLiveAddrReq clear() {
        this.roomId = 0L;
        this.rtmp = "";
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
        if (!this.rtmp.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.rtmp);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.rtmp.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.rtmp);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetLiveAddrReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetLiveAddrReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetLiveAddrReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.rtmp = codedInputByteBufferNano.readString();
            }
        }
    }
}
