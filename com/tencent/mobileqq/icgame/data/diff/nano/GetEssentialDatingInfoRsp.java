package com.tencent.mobileqq.icgame.data.diff.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetEssentialDatingInfoRsp extends ExtendableMessageNano<GetEssentialDatingInfoRsp> {
    private static volatile GetEssentialDatingInfoRsp[] _emptyArray;
    public EssentialDatingInfo essentialDatingInfo;

    public GetEssentialDatingInfoRsp() {
        clear();
    }

    public static GetEssentialDatingInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetEssentialDatingInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetEssentialDatingInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetEssentialDatingInfoRsp) MessageNano.mergeFrom(new GetEssentialDatingInfoRsp(), bArr);
    }

    public GetEssentialDatingInfoRsp clear() {
        this.essentialDatingInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        EssentialDatingInfo essentialDatingInfo = this.essentialDatingInfo;
        if (essentialDatingInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, essentialDatingInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        EssentialDatingInfo essentialDatingInfo = this.essentialDatingInfo;
        if (essentialDatingInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, essentialDatingInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetEssentialDatingInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetEssentialDatingInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetEssentialDatingInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.essentialDatingInfo == null) {
                    this.essentialDatingInfo = new EssentialDatingInfo();
                }
                codedInputByteBufferNano.readMessage(this.essentialDatingInfo);
            }
        }
    }
}
