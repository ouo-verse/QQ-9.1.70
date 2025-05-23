package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class FreePlayAddTimeRsp extends ExtendableMessageNano<FreePlayAddTimeRsp> {
    private static volatile FreePlayAddTimeRsp[] _emptyArray;
    public FreePlayBasicInfo basicInfo;

    public FreePlayAddTimeRsp() {
        clear();
    }

    public static FreePlayAddTimeRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FreePlayAddTimeRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FreePlayAddTimeRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FreePlayAddTimeRsp) MessageNano.mergeFrom(new FreePlayAddTimeRsp(), bArr);
    }

    public FreePlayAddTimeRsp clear() {
        this.basicInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        FreePlayBasicInfo freePlayBasicInfo = this.basicInfo;
        if (freePlayBasicInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, freePlayBasicInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        FreePlayBasicInfo freePlayBasicInfo = this.basicInfo;
        if (freePlayBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, freePlayBasicInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FreePlayAddTimeRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FreePlayAddTimeRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FreePlayAddTimeRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.basicInfo == null) {
                    this.basicInfo = new FreePlayBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.basicInfo);
            }
        }
    }
}
