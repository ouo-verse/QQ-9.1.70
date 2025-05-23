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
public final class GetActivityInfosRsp extends ExtendableMessageNano<GetActivityInfosRsp> {
    private static volatile GetActivityInfosRsp[] _emptyArray;
    public ActivityInfos infos;

    public GetActivityInfosRsp() {
        clear();
    }

    public static GetActivityInfosRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetActivityInfosRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetActivityInfosRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetActivityInfosRsp) MessageNano.mergeFrom(new GetActivityInfosRsp(), bArr);
    }

    public GetActivityInfosRsp clear() {
        this.infos = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ActivityInfos activityInfos = this.infos;
        if (activityInfos != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, activityInfos);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ActivityInfos activityInfos = this.infos;
        if (activityInfos != null) {
            codedOutputByteBufferNano.writeMessage(1, activityInfos);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetActivityInfosRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetActivityInfosRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetActivityInfosRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.infos == null) {
                    this.infos = new ActivityInfos();
                }
                codedInputByteBufferNano.readMessage(this.infos);
            }
        }
    }
}
