package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PhoneAuthInfo extends ExtendableMessageNano<PhoneAuthInfo> {
    private static volatile PhoneAuthInfo[] _emptyArray;
    public String phone;
    public int phoneStatus;

    public PhoneAuthInfo() {
        clear();
    }

    public static PhoneAuthInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PhoneAuthInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PhoneAuthInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PhoneAuthInfo) MessageNano.mergeFrom(new PhoneAuthInfo(), bArr);
    }

    public PhoneAuthInfo clear() {
        this.phone = "";
        this.phoneStatus = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.phone.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.phone);
        }
        int i3 = this.phoneStatus;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.phone.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.phone);
        }
        int i3 = this.phoneStatus;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PhoneAuthInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PhoneAuthInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PhoneAuthInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.phone = codedInputByteBufferNano.readString();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.phoneStatus = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
