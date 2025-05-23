package com.tencent.mobileqq.icgame.data.meet.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetTabConfigReq extends ExtendableMessageNano<GetTabConfigReq> {
    private static volatile GetTabConfigReq[] _emptyArray;
    public String qmei;

    public GetTabConfigReq() {
        clear();
    }

    public static GetTabConfigReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetTabConfigReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetTabConfigReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetTabConfigReq) MessageNano.mergeFrom(new GetTabConfigReq(), bArr);
    }

    public GetTabConfigReq clear() {
        this.qmei = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.qmei.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.qmei);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.qmei.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.qmei);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetTabConfigReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetTabConfigReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetTabConfigReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.qmei = codedInputByteBufferNano.readString();
            }
        }
    }
}
