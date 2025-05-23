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
public final class LiveState extends ExtendableMessageNano<LiveState> {
    private static volatile LiveState[] _emptyArray;
    public int liveType;
    public long roomId;
    public int state;

    public LiveState() {
        clear();
    }

    public static LiveState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveState[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LiveState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LiveState) MessageNano.mergeFrom(new LiveState(), bArr);
    }

    public LiveState clear() {
        this.state = 0;
        this.liveType = 0;
        this.roomId = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.state) + CodedOutputByteBufferNano.computeUInt32Size(2, this.liveType) + CodedOutputByteBufferNano.computeUInt64Size(3, this.roomId);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.state);
        codedOutputByteBufferNano.writeUInt32(2, this.liveType);
        codedOutputByteBufferNano.writeUInt64(3, this.roomId);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LiveState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LiveState().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LiveState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.state = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.liveType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.roomId = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
