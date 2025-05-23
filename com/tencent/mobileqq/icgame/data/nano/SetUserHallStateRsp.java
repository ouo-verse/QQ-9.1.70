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
public final class SetUserHallStateRsp extends ExtendableMessageNano<SetUserHallStateRsp> {
    private static volatile SetUserHallStateRsp[] _emptyArray;
    public int recode;

    public SetUserHallStateRsp() {
        clear();
    }

    public static SetUserHallStateRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetUserHallStateRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetUserHallStateRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetUserHallStateRsp) MessageNano.mergeFrom(new SetUserHallStateRsp(), bArr);
    }

    public SetUserHallStateRsp clear() {
        this.recode = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.recode;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.recode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetUserHallStateRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetUserHallStateRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetUserHallStateRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 8) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.recode = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
