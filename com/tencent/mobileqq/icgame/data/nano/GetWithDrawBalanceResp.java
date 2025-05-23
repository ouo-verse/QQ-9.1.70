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
public final class GetWithDrawBalanceResp extends ExtendableMessageNano<GetWithDrawBalanceResp> {
    private static volatile GetWithDrawBalanceResp[] _emptyArray;
    public int withdrawBalance;

    public GetWithDrawBalanceResp() {
        clear();
    }

    public static GetWithDrawBalanceResp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetWithDrawBalanceResp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetWithDrawBalanceResp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetWithDrawBalanceResp) MessageNano.mergeFrom(new GetWithDrawBalanceResp(), bArr);
    }

    public GetWithDrawBalanceResp clear() {
        this.withdrawBalance = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.withdrawBalance;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.withdrawBalance;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetWithDrawBalanceResp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetWithDrawBalanceResp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetWithDrawBalanceResp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.withdrawBalance = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
