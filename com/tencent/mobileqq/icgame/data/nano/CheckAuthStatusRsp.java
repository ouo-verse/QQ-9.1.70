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
public final class CheckAuthStatusRsp extends ExtendableMessageNano<CheckAuthStatusRsp> {
    private static volatile CheckAuthStatusRsp[] _emptyArray;
    public String phone;
    public int phoneStatus;
    public int result;

    public CheckAuthStatusRsp() {
        clear();
    }

    public static CheckAuthStatusRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CheckAuthStatusRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CheckAuthStatusRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CheckAuthStatusRsp) MessageNano.mergeFrom(new CheckAuthStatusRsp(), bArr);
    }

    public CheckAuthStatusRsp clear() {
        this.result = 0;
        this.phoneStatus = 0;
        this.phone = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.phoneStatus;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.phone.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.phone);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.phoneStatus;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.phone.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.phone);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CheckAuthStatusRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CheckAuthStatusRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CheckAuthStatusRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.phoneStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.phone = codedInputByteBufferNano.readString();
            }
        }
    }
}
