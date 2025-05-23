package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AddTaskProgressRsp extends ExtendableMessageNano<AddTaskProgressRsp> {
    private static volatile AddTaskProgressRsp[] _emptyArray;
    public AddProgressResult result;
    public Task task;

    public AddTaskProgressRsp() {
        clear();
    }

    public static AddTaskProgressRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AddTaskProgressRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AddTaskProgressRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AddTaskProgressRsp) MessageNano.mergeFrom(new AddTaskProgressRsp(), bArr);
    }

    public AddTaskProgressRsp clear() {
        this.task = null;
        this.result = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Task task = this.task;
        if (task != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, task);
        }
        AddProgressResult addProgressResult = this.result;
        if (addProgressResult != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, addProgressResult);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Task task = this.task;
        if (task != null) {
            codedOutputByteBufferNano.writeMessage(1, task);
        }
        AddProgressResult addProgressResult = this.result;
        if (addProgressResult != null) {
            codedOutputByteBufferNano.writeMessage(2, addProgressResult);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AddTaskProgressRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AddTaskProgressRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AddTaskProgressRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.task == null) {
                    this.task = new Task();
                }
                codedInputByteBufferNano.readMessage(this.task);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.result == null) {
                    this.result = new AddProgressResult();
                }
                codedInputByteBufferNano.readMessage(this.result);
            }
        }
    }
}
