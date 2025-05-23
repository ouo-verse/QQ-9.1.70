package com.tencent.mobileqq.icgame.data.shortvideo.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class TmpAuth extends ExtendableMessageNano<TmpAuth> {
    private static volatile TmpAuth[] _emptyArray;
    public long expireEndTime;
    public long expireStartTime;
    public String tmpAk;
    public String tmpSessionToken;
    public String tmpSk;

    public TmpAuth() {
        clear();
    }

    public static TmpAuth[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TmpAuth[0];
                }
            }
        }
        return _emptyArray;
    }

    public static TmpAuth parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (TmpAuth) MessageNano.mergeFrom(new TmpAuth(), bArr);
    }

    public TmpAuth clear() {
        this.tmpAk = "";
        this.tmpSk = "";
        this.tmpSessionToken = "";
        this.expireStartTime = 0L;
        this.expireEndTime = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.tmpAk.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.tmpAk);
        }
        if (!this.tmpSk.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.tmpSk);
        }
        if (!this.tmpSessionToken.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.tmpSessionToken);
        }
        long j3 = this.expireStartTime;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j3);
        }
        long j16 = this.expireEndTime;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(5, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.tmpAk.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.tmpAk);
        }
        if (!this.tmpSk.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.tmpSk);
        }
        if (!this.tmpSessionToken.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.tmpSessionToken);
        }
        long j3 = this.expireStartTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j3);
        }
        long j16 = this.expireEndTime;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static TmpAuth parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new TmpAuth().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public TmpAuth mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.tmpAk = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.tmpSk = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.tmpSessionToken = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.expireStartTime = codedInputByteBufferNano.readInt64();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.expireEndTime = codedInputByteBufferNano.readInt64();
            }
        }
    }
}
