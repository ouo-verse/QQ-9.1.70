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
public final class SetLoveAnchorInfoReq extends ExtendableMessageNano<SetLoveAnchorInfoReq> {
    private static volatile SetLoveAnchorInfoReq[] _emptyArray;
    public LoveAnchorInfo info;
    public long roomId;

    public SetLoveAnchorInfoReq() {
        clear();
    }

    public static SetLoveAnchorInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetLoveAnchorInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetLoveAnchorInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetLoveAnchorInfoReq) MessageNano.mergeFrom(new SetLoveAnchorInfoReq(), bArr);
    }

    public SetLoveAnchorInfoReq clear() {
        this.roomId = 0L;
        this.info = null;
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
        LoveAnchorInfo loveAnchorInfo = this.info;
        if (loveAnchorInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, loveAnchorInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        LoveAnchorInfo loveAnchorInfo = this.info;
        if (loveAnchorInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, loveAnchorInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetLoveAnchorInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetLoveAnchorInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetLoveAnchorInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.info == null) {
                    this.info = new LoveAnchorInfo();
                }
                codedInputByteBufferNano.readMessage(this.info);
            }
        }
    }
}
