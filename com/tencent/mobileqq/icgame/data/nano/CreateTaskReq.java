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
public final class CreateTaskReq extends ExtendableMessageNano<CreateTaskReq> {
    private static volatile CreateTaskReq[] _emptyArray;
    public String actId;
    public Task task;

    public CreateTaskReq() {
        clear();
    }

    public static CreateTaskReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CreateTaskReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CreateTaskReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CreateTaskReq) MessageNano.mergeFrom(new CreateTaskReq(), bArr);
    }

    public CreateTaskReq clear() {
        this.actId = "";
        this.task = null;
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
        Task task = this.task;
        if (task != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, task);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.actId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.actId);
        }
        Task task = this.task;
        if (task != null) {
            codedOutputByteBufferNano.writeMessage(2, task);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CreateTaskReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CreateTaskReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CreateTaskReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.task == null) {
                    this.task = new Task();
                }
                codedInputByteBufferNano.readMessage(this.task);
            }
        }
    }
}
