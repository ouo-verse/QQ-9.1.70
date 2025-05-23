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
public final class SendSmsVerifyRsp extends ExtendableMessageNano<SendSmsVerifyRsp> {
    private static volatile SendSmsVerifyRsp[] _emptyArray;
    public String phoneStr;
    public int retcode;
    public String smsToken;

    public SendSmsVerifyRsp() {
        clear();
    }

    public static SendSmsVerifyRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SendSmsVerifyRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SendSmsVerifyRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SendSmsVerifyRsp) MessageNano.mergeFrom(new SendSmsVerifyRsp(), bArr);
    }

    public SendSmsVerifyRsp clear() {
        this.retcode = 0;
        this.smsToken = "";
        this.phoneStr = "";
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
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.smsToken.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.smsToken);
        }
        if (!this.phoneStr.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.phoneStr);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.smsToken.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.smsToken);
        }
        if (!this.phoneStr.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.phoneStr);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SendSmsVerifyRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SendSmsVerifyRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SendSmsVerifyRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retcode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.smsToken = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.phoneStr = codedInputByteBufferNano.readString();
            }
        }
    }
}
