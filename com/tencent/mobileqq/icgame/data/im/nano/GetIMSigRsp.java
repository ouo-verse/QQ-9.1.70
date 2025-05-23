package com.tencent.mobileqq.icgame.data.im.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetIMSigRsp extends ExtendableMessageNano<GetIMSigRsp> {
    private static volatile GetIMSigRsp[] _emptyArray;
    public GetIMSig result;
    public int retcode;

    public GetIMSigRsp() {
        clear();
    }

    public static GetIMSigRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetIMSigRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetIMSigRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetIMSigRsp) MessageNano.mergeFrom(new GetIMSigRsp(), bArr);
    }

    public GetIMSigRsp clear() {
        this.retcode = 0;
        this.result = null;
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
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        GetIMSig getIMSig = this.result;
        if (getIMSig != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, getIMSig);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        GetIMSig getIMSig = this.result;
        if (getIMSig != null) {
            codedOutputByteBufferNano.writeMessage(2, getIMSig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetIMSigRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetIMSigRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetIMSigRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retcode = codedInputByteBufferNano.readInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.result == null) {
                    this.result = new GetIMSig();
                }
                codedInputByteBufferNano.readMessage(this.result);
            }
        }
    }
}
