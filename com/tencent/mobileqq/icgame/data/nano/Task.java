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
public final class Task extends ExtendableMessageNano<Task> {
    private static volatile Task[] _emptyArray;
    public Participant negative;
    public Participant positive;
    public String taskId;

    public Task() {
        clear();
    }

    public static Task[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Task[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Task parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Task) MessageNano.mergeFrom(new Task(), bArr);
    }

    public Task clear() {
        this.taskId = "";
        this.positive = null;
        this.negative = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.taskId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.taskId);
        }
        Participant participant = this.positive;
        if (participant != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, participant);
        }
        Participant participant2 = this.negative;
        if (participant2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, participant2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.taskId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.taskId);
        }
        Participant participant = this.positive;
        if (participant != null) {
            codedOutputByteBufferNano.writeMessage(2, participant);
        }
        Participant participant2 = this.negative;
        if (participant2 != null) {
            codedOutputByteBufferNano.writeMessage(3, participant2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Task parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Task().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Task mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.taskId = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.positive == null) {
                    this.positive = new Participant();
                }
                codedInputByteBufferNano.readMessage(this.positive);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.negative == null) {
                    this.negative = new Participant();
                }
                codedInputByteBufferNano.readMessage(this.negative);
            }
        }
    }
}
