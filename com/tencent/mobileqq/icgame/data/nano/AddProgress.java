package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AddProgress extends ExtendableMessageNano<AddProgress> {
    private static volatile AddProgress[] _emptyArray;
    public long anchorUid;
    public long fansUid;
    public long score;
    public String taskId;

    /* renamed from: ts, reason: collision with root package name */
    public long f237271ts;

    public AddProgress() {
        clear();
    }

    public static AddProgress[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AddProgress[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AddProgress parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AddProgress) MessageNano.mergeFrom(new AddProgress(), bArr);
    }

    public AddProgress clear() {
        this.taskId = "";
        this.anchorUid = 0L;
        this.fansUid = 0L;
        this.f237271ts = 0L;
        this.score = 0L;
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
        long j3 = this.anchorUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.fansUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        long j17 = this.f237271ts;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j17);
        }
        long j18 = this.score;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.taskId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.taskId);
        }
        long j3 = this.anchorUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.fansUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        long j17 = this.f237271ts;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j17);
        }
        long j18 = this.score;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AddProgress parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AddProgress().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AddProgress mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.taskId = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.fansUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.f237271ts = codedInputByteBufferNano.readInt64();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.score = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
