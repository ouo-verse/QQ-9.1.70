package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class Participant extends ExtendableMessageNano<Participant> {
    private static volatile Participant[] _emptyArray;
    public Award award;
    public String desc;
    public long endTs;
    public long finishTs;
    public long progress;
    public long startTs;
    public long svrTs;
    public long target;
    public String taskConfigId;
    public int taskState;
    public int taskType;
    public long uid;

    public Participant() {
        clear();
    }

    public static Participant[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Participant[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Participant parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Participant) MessageNano.mergeFrom(new Participant(), bArr);
    }

    public Participant clear() {
        this.uid = 0L;
        this.startTs = 0L;
        this.endTs = 0L;
        this.taskType = 0;
        this.desc = "";
        this.progress = 0L;
        this.target = 0L;
        this.finishTs = 0L;
        this.taskState = 0;
        this.award = null;
        this.taskConfigId = "";
        this.svrTs = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.startTs;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        long j17 = this.endTs;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j17);
        }
        int i3 = this.taskType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        if (!this.desc.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.desc);
        }
        long j18 = this.progress;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j18);
        }
        long j19 = this.target;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j19);
        }
        long j26 = this.finishTs;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j26);
        }
        int i16 = this.taskState;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i16);
        }
        Award award = this.award;
        if (award != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, award);
        }
        if (!this.taskConfigId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.taskConfigId);
        }
        long j27 = this.svrTs;
        if (j27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(12, j27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.startTs;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        long j17 = this.endTs;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j17);
        }
        int i3 = this.taskType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        if (!this.desc.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.desc);
        }
        long j18 = this.progress;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j18);
        }
        long j19 = this.target;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j19);
        }
        long j26 = this.finishTs;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeInt64(8, j26);
        }
        int i16 = this.taskState;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i16);
        }
        Award award = this.award;
        if (award != null) {
            codedOutputByteBufferNano.writeMessage(10, award);
        }
        if (!this.taskConfigId.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.taskConfigId);
        }
        long j27 = this.svrTs;
        if (j27 != 0) {
            codedOutputByteBufferNano.writeInt64(12, j27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Participant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Participant().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Participant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.startTs = codedInputByteBufferNano.readInt64();
                    break;
                case 24:
                    this.endTs = codedInputByteBufferNano.readInt64();
                    break;
                case 32:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.taskType = readInt32;
                        break;
                    }
                case 42:
                    this.desc = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.progress = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.target = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.finishTs = codedInputByteBufferNano.readInt64();
                    break;
                case 72:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    switch (readInt322) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            this.taskState = readInt322;
                            break;
                    }
                case 82:
                    if (this.award == null) {
                        this.award = new Award();
                    }
                    codedInputByteBufferNano.readMessage(this.award);
                    break;
                case 90:
                    this.taskConfigId = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.svrTs = codedInputByteBufferNano.readInt64();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
