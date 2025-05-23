package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EditVipRsp extends ExtendableMessageNano<EditVipRsp> {
    private static volatile EditVipRsp[] _emptyArray;
    public FreePlayBasicInfo basicInfo;
    public WaitingInfo waitingInfo;

    public EditVipRsp() {
        clear();
    }

    public static EditVipRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditVipRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditVipRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditVipRsp) MessageNano.mergeFrom(new EditVipRsp(), bArr);
    }

    public EditVipRsp clear() {
        this.basicInfo = null;
        this.waitingInfo = null;
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
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, freePlayBasicInfo);
        }
        WaitingInfo waitingInfo = this.waitingInfo;
        if (waitingInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, waitingInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        FreePlayBasicInfo freePlayBasicInfo = this.basicInfo;
        if (freePlayBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, freePlayBasicInfo);
        }
        WaitingInfo waitingInfo = this.waitingInfo;
        if (waitingInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, waitingInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditVipRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditVipRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditVipRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.basicInfo == null) {
                    this.basicInfo = new FreePlayBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.basicInfo);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.waitingInfo == null) {
                    this.waitingInfo = new WaitingInfo();
                }
                codedInputByteBufferNano.readMessage(this.waitingInfo);
            }
        }
    }
}
