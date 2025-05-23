package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class RoomPreviewMiddleMsg extends ExtendableMessageNano<RoomPreviewMiddleMsg> {
    private static volatile RoomPreviewMiddleMsg[] _emptyArray;
    public long timestamp;
    public String url;

    public RoomPreviewMiddleMsg() {
        clear();
    }

    public static RoomPreviewMiddleMsg[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomPreviewMiddleMsg[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomPreviewMiddleMsg parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomPreviewMiddleMsg) MessageNano.mergeFrom(new RoomPreviewMiddleMsg(), bArr);
    }

    public RoomPreviewMiddleMsg clear() {
        this.url = "";
        this.timestamp = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.url.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.url);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.url);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomPreviewMiddleMsg parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomPreviewMiddleMsg().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomPreviewMiddleMsg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.url = codedInputByteBufferNano.readString();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
