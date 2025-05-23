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
public final class MeleeAddTimeRsp extends ExtendableMessageNano<MeleeAddTimeRsp> {
    private static volatile MeleeAddTimeRsp[] _emptyArray;
    public MeleeBasicInfo meleeBasicInfo;

    public MeleeAddTimeRsp() {
        clear();
    }

    public static MeleeAddTimeRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MeleeAddTimeRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MeleeAddTimeRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MeleeAddTimeRsp) MessageNano.mergeFrom(new MeleeAddTimeRsp(), bArr);
    }

    public MeleeAddTimeRsp clear() {
        this.meleeBasicInfo = null;
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
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, meleeBasicInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        MeleeBasicInfo meleeBasicInfo = this.meleeBasicInfo;
        if (meleeBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, meleeBasicInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MeleeAddTimeRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MeleeAddTimeRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MeleeAddTimeRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.meleeBasicInfo == null) {
                    this.meleeBasicInfo = new MeleeBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.meleeBasicInfo);
            }
        }
    }
}
