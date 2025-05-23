package com.tencent.mobileqq.icgame.data.echo.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PermitRsp extends ExtendableMessageNano<PermitRsp> {
    private static volatile PermitRsp[] _emptyArray;
    public RetInfo retinfo;

    public PermitRsp() {
        clear();
    }

    public static PermitRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PermitRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PermitRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PermitRsp) MessageNano.mergeFrom(new PermitRsp(), bArr);
    }

    public PermitRsp clear() {
        this.retinfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RetInfo retInfo = this.retinfo;
        if (retInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, retInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RetInfo retInfo = this.retinfo;
        if (retInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, retInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PermitRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PermitRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PermitRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.retinfo == null) {
                    this.retinfo = new RetInfo();
                }
                codedInputByteBufferNano.readMessage(this.retinfo);
            }
        }
    }
}
