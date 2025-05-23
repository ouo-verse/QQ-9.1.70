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
public final class SendIMControlRsp extends ExtendableMessageNano<SendIMControlRsp> {
    private static volatile SendIMControlRsp[] _emptyArray;
    public int errCode;
    public String errMsg;
    public boolean isRemind;

    public SendIMControlRsp() {
        clear();
    }

    public static SendIMControlRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SendIMControlRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SendIMControlRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SendIMControlRsp) MessageNano.mergeFrom(new SendIMControlRsp(), bArr);
    }

    public SendIMControlRsp clear() {
        this.isRemind = false;
        this.errCode = 0;
        this.errMsg = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.isRemind;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        int i3 = this.errCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!this.errMsg.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.errMsg);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.isRemind;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        int i3 = this.errCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.errMsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SendIMControlRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SendIMControlRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SendIMControlRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 16) {
                this.isRemind = codedInputByteBufferNano.readBool();
            } else if (readTag == 24) {
                this.errCode = codedInputByteBufferNano.readInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.errMsg = codedInputByteBufferNano.readString();
            }
        }
    }
}
