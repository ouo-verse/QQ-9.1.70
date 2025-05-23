package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetLiveInfoRsp extends ExtendableMessageNano<GetLiveInfoRsp> {
    private static volatile GetLiveInfoRsp[] _emptyArray;
    public StreamInfo info;

    public GetLiveInfoRsp() {
        clear();
    }

    public static GetLiveInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetLiveInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetLiveInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetLiveInfoRsp) MessageNano.mergeFrom(new GetLiveInfoRsp(), bArr);
    }

    public GetLiveInfoRsp clear() {
        this.info = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        StreamInfo streamInfo = this.info;
        if (streamInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, streamInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        StreamInfo streamInfo = this.info;
        if (streamInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, streamInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetLiveInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetLiveInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetLiveInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.info == null) {
                    this.info = new StreamInfo();
                }
                codedInputByteBufferNano.readMessage(this.info);
            }
        }
    }
}
