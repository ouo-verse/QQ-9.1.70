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
public final class CheckAllowMentionReq extends ExtendableMessageNano<CheckAllowMentionReq> {
    private static volatile CheckAllowMentionReq[] _emptyArray;
    public long toUid;

    public CheckAllowMentionReq() {
        clear();
    }

    public static CheckAllowMentionReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CheckAllowMentionReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CheckAllowMentionReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CheckAllowMentionReq) MessageNano.mergeFrom(new CheckAllowMentionReq(), bArr);
    }

    public CheckAllowMentionReq clear() {
        this.toUid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.toUid;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.toUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CheckAllowMentionReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CheckAllowMentionReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CheckAllowMentionReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 8) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.toUid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
