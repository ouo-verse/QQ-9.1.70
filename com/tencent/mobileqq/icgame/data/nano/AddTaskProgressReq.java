package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AddTaskProgressReq extends ExtendableMessageNano<AddTaskProgressReq> {
    private static volatile AddTaskProgressReq[] _emptyArray;
    public String actId;
    public AddProgress progress;

    public AddTaskProgressReq() {
        clear();
    }

    public static AddTaskProgressReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AddTaskProgressReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AddTaskProgressReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AddTaskProgressReq) MessageNano.mergeFrom(new AddTaskProgressReq(), bArr);
    }

    public AddTaskProgressReq clear() {
        this.actId = "";
        this.progress = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.actId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.actId);
        }
        AddProgress addProgress = this.progress;
        if (addProgress != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, addProgress);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.actId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.actId);
        }
        AddProgress addProgress = this.progress;
        if (addProgress != null) {
            codedOutputByteBufferNano.writeMessage(2, addProgress);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AddTaskProgressReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AddTaskProgressReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AddTaskProgressReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.actId = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.progress == null) {
                    this.progress = new AddProgress();
                }
                codedInputByteBufferNano.readMessage(this.progress);
            }
        }
    }
}
