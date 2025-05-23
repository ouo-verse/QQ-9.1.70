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
public final class GetMeleeInfoRsp extends ExtendableMessageNano<GetMeleeInfoRsp> {
    private static volatile GetMeleeInfoRsp[] _emptyArray;
    public MeleeBasicInfo meleeBasicInfo;
    public MeleeScore meleeScore;

    public GetMeleeInfoRsp() {
        clear();
    }

    public static GetMeleeInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetMeleeInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetMeleeInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetMeleeInfoRsp) MessageNano.mergeFrom(new GetMeleeInfoRsp(), bArr);
    }

    public GetMeleeInfoRsp clear() {
        this.meleeBasicInfo = null;
        this.meleeScore = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        MeleeBasicInfo meleeBasicInfo = this.meleeBasicInfo;
        if (meleeBasicInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, meleeBasicInfo);
        }
        MeleeScore meleeScore = this.meleeScore;
        if (meleeScore != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, meleeScore);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        MeleeBasicInfo meleeBasicInfo = this.meleeBasicInfo;
        if (meleeBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, meleeBasicInfo);
        }
        MeleeScore meleeScore = this.meleeScore;
        if (meleeScore != null) {
            codedOutputByteBufferNano.writeMessage(2, meleeScore);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetMeleeInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetMeleeInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetMeleeInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.meleeBasicInfo == null) {
                    this.meleeBasicInfo = new MeleeBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.meleeBasicInfo);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.meleeScore == null) {
                    this.meleeScore = new MeleeScore();
                }
                codedInputByteBufferNano.readMessage(this.meleeScore);
            }
        }
    }
}
