package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PayGiftStrategyRsp extends ExtendableMessageNano<PayGiftStrategyRsp> {
    private static volatile PayGiftStrategyRsp[] _emptyArray;
    public int retcode;

    public PayGiftStrategyRsp() {
        clear();
    }

    public static PayGiftStrategyRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PayGiftStrategyRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PayGiftStrategyRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PayGiftStrategyRsp) MessageNano.mergeFrom(new PayGiftStrategyRsp(), bArr);
    }

    public PayGiftStrategyRsp clear() {
        this.retcode = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retcode;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PayGiftStrategyRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PayGiftStrategyRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PayGiftStrategyRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.retcode = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
