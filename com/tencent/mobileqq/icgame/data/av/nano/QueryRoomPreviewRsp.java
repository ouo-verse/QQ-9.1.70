package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class QueryRoomPreviewRsp extends ExtendableMessageNano<QueryRoomPreviewRsp> {
    private static volatile QueryRoomPreviewRsp[] _emptyArray;
    public int result;
    public long timestamp;
    public String url;

    public QueryRoomPreviewRsp() {
        clear();
    }

    public static QueryRoomPreviewRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QueryRoomPreviewRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QueryRoomPreviewRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QueryRoomPreviewRsp) MessageNano.mergeFrom(new QueryRoomPreviewRsp(), bArr);
    }

    public QueryRoomPreviewRsp clear() {
        this.result = 0;
        this.url = "";
        this.timestamp = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.result);
        if (!this.url.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.url);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt32(1, this.result);
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.url);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QueryRoomPreviewRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QueryRoomPreviewRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QueryRoomPreviewRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.url = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
