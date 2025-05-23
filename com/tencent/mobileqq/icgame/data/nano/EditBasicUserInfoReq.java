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
public final class EditBasicUserInfoReq extends ExtendableMessageNano<EditBasicUserInfoReq> {
    private static volatile EditBasicUserInfoReq[] _emptyArray;
    public BasicUserInfo info;
    public int userLogTimeStamp;

    public EditBasicUserInfoReq() {
        clear();
    }

    public static EditBasicUserInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditBasicUserInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditBasicUserInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditBasicUserInfoReq) MessageNano.mergeFrom(new EditBasicUserInfoReq(), bArr);
    }

    public EditBasicUserInfoReq clear() {
        this.userLogTimeStamp = 0;
        this.info = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.userLogTimeStamp;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        BasicUserInfo basicUserInfo = this.info;
        if (basicUserInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, basicUserInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.userLogTimeStamp;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        BasicUserInfo basicUserInfo = this.info;
        if (basicUserInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, basicUserInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditBasicUserInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditBasicUserInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditBasicUserInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.userLogTimeStamp = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.info == null) {
                    this.info = new BasicUserInfo();
                }
                codedInputByteBufferNano.readMessage(this.info);
            }
        }
    }
}
