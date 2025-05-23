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
public final class AudienceGuessReq extends ExtendableMessageNano<AudienceGuessReq> {
    private static volatile AudienceGuessReq[] _emptyArray;
    public String answer;
    public long roomId;
    public long uid;

    public AudienceGuessReq() {
        clear();
    }

    public static AudienceGuessReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AudienceGuessReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AudienceGuessReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AudienceGuessReq) MessageNano.mergeFrom(new AudienceGuessReq(), bArr);
    }

    public AudienceGuessReq clear() {
        this.uid = 0L;
        this.answer = "";
        this.roomId = 0L;
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
        if (!this.answer.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.answer);
        }
        long j16 = this.roomId;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.answer.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.answer);
        }
        long j16 = this.roomId;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AudienceGuessReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AudienceGuessReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AudienceGuessReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.answer = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.roomId = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
