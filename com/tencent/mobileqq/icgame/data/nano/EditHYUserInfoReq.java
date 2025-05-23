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
public final class EditHYUserInfoReq extends ExtendableMessageNano<EditHYUserInfoReq> {
    private static volatile EditHYUserInfoReq[] _emptyArray;
    public int idType;
    public HYUserInfo info;

    public EditHYUserInfoReq() {
        clear();
    }

    public static EditHYUserInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditHYUserInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditHYUserInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditHYUserInfoReq) MessageNano.mergeFrom(new EditHYUserInfoReq(), bArr);
    }

    public EditHYUserInfoReq clear() {
        this.idType = 1;
        this.info = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.idType);
        HYUserInfo hYUserInfo = this.info;
        if (hYUserInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, hYUserInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt32(1, this.idType);
        HYUserInfo hYUserInfo = this.info;
        if (hYUserInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, hYUserInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditHYUserInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditHYUserInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditHYUserInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 1 || readInt32 == 2) {
                    this.idType = readInt32;
                }
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.info == null) {
                    this.info = new HYUserInfo();
                }
                codedInputByteBufferNano.readMessage(this.info);
            }
        }
    }
}
