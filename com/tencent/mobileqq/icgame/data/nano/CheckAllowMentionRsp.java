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
public final class CheckAllowMentionRsp extends ExtendableMessageNano<CheckAllowMentionRsp> {
    private static volatile CheckAllowMentionRsp[] _emptyArray;
    public boolean allow;

    public CheckAllowMentionRsp() {
        clear();
    }

    public static CheckAllowMentionRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CheckAllowMentionRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CheckAllowMentionRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CheckAllowMentionRsp) MessageNano.mergeFrom(new CheckAllowMentionRsp(), bArr);
    }

    public CheckAllowMentionRsp clear() {
        this.allow = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.allow;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.allow;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CheckAllowMentionRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CheckAllowMentionRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CheckAllowMentionRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.allow = codedInputByteBufferNano.readBool();
            }
        }
    }
}
