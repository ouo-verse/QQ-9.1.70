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
public final class CommonReportRsp extends ExtendableMessageNano<CommonReportRsp> {
    private static volatile CommonReportRsp[] _emptyArray;
    public int retCode;
    public String retMsg;

    public CommonReportRsp() {
        clear();
    }

    public static CommonReportRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommonReportRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CommonReportRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommonReportRsp) MessageNano.mergeFrom(new CommonReportRsp(), bArr);
    }

    public CommonReportRsp clear() {
        this.retCode = 0;
        this.retMsg = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.retMsg.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.retMsg);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.retMsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.retMsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CommonReportRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CommonReportRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CommonReportRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retCode = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.retMsg = codedInputByteBufferNano.readString();
            }
        }
    }
}
