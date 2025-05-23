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
public final class GetActivityReq extends ExtendableMessageNano<GetActivityReq> {
    private static volatile GetActivityReq[] _emptyArray;
    public long anchorUid;
    public String channel;
    public long roomId;

    public GetActivityReq() {
        clear();
    }

    public static GetActivityReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetActivityReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetActivityReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetActivityReq) MessageNano.mergeFrom(new GetActivityReq(), bArr);
    }

    public GetActivityReq clear() {
        this.roomId = 0L;
        this.anchorUid = 0L;
        this.channel = "";
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
        long j16 = this.anchorUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.channel.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.channel);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.anchorUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.channel.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.channel);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetActivityReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetActivityReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetActivityReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.channel = codedInputByteBufferNano.readString();
            }
        }
    }
}
